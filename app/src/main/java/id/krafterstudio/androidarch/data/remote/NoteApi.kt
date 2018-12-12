package id.krafterstudio.androidarch.data.remote

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import io.reactivex.Completable
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
interface NoteApi {
    @GET("notes")
    fun getNotes(): Flowable<MutableList<NoteRemote>>

    @POST("notes")
    fun addNote(note: NoteRemote): Completable

    companion object {
        private const val URL = "https://expressnote.herokuapp.com/"

        private val gson = GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .setLenient()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        private val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        private val client = OkHttpClient.Builder().addInterceptor(logging).build()

        private val builder = Retrofit.Builder()
            .baseUrl(URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        private val retrofit = builder.build()

        val INSTANCE: NoteApi by lazy {
            retrofit.create(NoteApi::class.java)
        }
    }
}