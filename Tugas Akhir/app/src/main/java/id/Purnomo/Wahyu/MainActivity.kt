package id.Purnomo.Wahyu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.miso.covidlog.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadCountries()
    }


    private fun loadCountries() {
        //inisiasi pada penyedia layanan
        val destinationService = LayananClient.buildService(DataNegara::class.java)
        //inisiasi permintaan sambungan ke penyedia layanan
        val requestCall = destinationService.getAffectedCountryList()
        //sinkronisasi data
        requestCall.enqueue(object : Callback<List<Negara>>{
            override fun onResponse(call: Call<List<Negara>>, response: Response<List<Negara>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val countryList = response.body()!!
                    Log.d("Response", "countrylist size : ${countryList.size}")
                    country_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity,2)
                        adapter = CountriesAdapter(response.body()!!)
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Kesalahan Jaringan ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<Negara>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Kesalahan Jaringan $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
}