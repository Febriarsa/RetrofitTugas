package com.example.authorslist

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.authorslist.databinding.ActivityMainBinding
import com.example.authorslist.model.Authors
import com.example.authorslist.model.Provinsi
import com.example.authorslist.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()

//        val responseAuthors = client.getAllAuthors()
//        val authorList = ArrayList<String>()

        val responseProvinsi = client.getAllProvinsi()
        val provinsiList = ArrayList<String>()


        responseProvinsi.enqueue(object : Callback<List<Provinsi>> {
            override fun onFailure(p0: Call<List<Provinsi>>, p1: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi Error",
                    Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(p0: Call<List<Provinsi>>, p1: Response<List<Provinsi>>) {
                for(i in p1.body()!!){
                    provinsiList.add(i.nama)
                }
                val listAdapter = ArrayAdapter(this@MainActivity,
                    R.layout.simple_list_item_1,
                    provinsiList
                )
                binding.lvNama.adapter = listAdapter
            }
        })



    }
}