package id.Purnomo.Wahyu
//sebagai pengubung client library api rest
import retrofit2.Call
//untuk mengambil (get) data dari server client,berformat dalam bentuk query string
//yang dikirm melalui  url dan tanda key=value akan dipisahkan dengan tanda "&"
import retrofit2.http.GET
//Query memiliki kemampuan untuk mengatur data mana yang perlu ditampilkan

//inisiasi pada penyedia layanan
interface DataNegara {
//mengambil query yang sesuai dengan countries
    @GET("countries")
//memanggil dan mengambil query mycountry
    fun getAffectedCountryList () : Call<List<Negara>>
}