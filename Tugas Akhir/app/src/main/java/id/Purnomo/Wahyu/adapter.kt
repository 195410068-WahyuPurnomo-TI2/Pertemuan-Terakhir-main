package id.Purnomo.Wahyu

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miso.covidlog.R
import com.squareup.picasso.Picasso
//mendefinisikan seluruh varibel dan method pada object tertentu
// (berisi atribut atau type data dan method untuk menjalankan suatu program)
class CountriesAdapter(private val countriesList: List<Negara>) :RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //layout tambahasn (extend) pada main activity
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.country_item,parent,false)
        return ViewHolder(view)
    }

        //override penulisan ulang pada sumber awal
    override fun getItemCount(): Int {
        //method return (non-void)
        //mengembalikan nilai yang tersimapan dalam variabel
        return countriesList.size
    }

        //fungsi ini untuk menyetel materi item pada posisi yang telah ditentukan dalam recycler view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //log d berfungsi sebagi debug ini sangat penting  karena dapat mencatat
            // algortima yang telah dihasilkan program ini
            // (log.d singkatnya untuk menyimpan log variabel)
        Log.d("Response", "List Count :${countriesList.size} ")

        //membuat  binding data dari model item ke layout item
        return holder.bind(countriesList[position])
    }
    //Menampilkan daftar data (view group) secara dinamis
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        //menampilkan data gambar negara
        var imageView = itemView.findViewById<ImageView>(R.id.ivFlag)
        //menampilkan nama senuah negara
        var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        //menampilkan jumlah kasus pada neagra tersebut
        var tvCases = itemView.findViewById<TextView>(R.id.tvCases)
        fun bind(country: Negara) {
        //untuk mendeklarasikan variable yang sudah ada agar bisa ditampilkan pada tampilan awal view holder
            val name ="Cases :${country.cases.toString()}"
            //deklarasi untuk negara
            tvTitle.text = country.country
            //deklarasi untuk nama negara
            tvCases.text = name
            //deklarasi untuk setiap lambang negara (imgae view)
            Picasso.get().load(country.countryInfo.flag).into(imageView);
        }

    }
}