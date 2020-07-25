package cl.random.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import cl.random.test.models.Country
import cl.random.test.services.CountryBuilder
import cl.random.test.services.CountryService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = CountryBuilder.buildService(CountryService::class.java)
        val call = request.getCountryList()

        call.enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                Log.d("response", response.body()!!.first().name);
                if (response.isSuccessful){
                    Log.d("response", response.body()!!.first().name);

                }
            }
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.d("failure", t.toString());
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}