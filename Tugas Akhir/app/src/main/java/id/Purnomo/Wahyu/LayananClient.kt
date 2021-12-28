package id.Purnomo.Wahyu

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LayananClient {
    private const val URL ="https://disease.sh/v2/"
    //HTTP CLIENT
    private val okHttp = OkHttpClient.Builder()

    //pengambil data retorfit berdasar pada data client URL yang digunakan
    private val builder =Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //membuat instansi data retrofit
    private val retrofit = builder.build()

    //menggunakan kelas ini untuk membuat fungsi kelas untuk
    //mengimplementasikan Antarmuka layanan Negara

    fun <T> buildService (serviceType :Class<T>):T{
        return retrofit.create(serviceType)
    }

}