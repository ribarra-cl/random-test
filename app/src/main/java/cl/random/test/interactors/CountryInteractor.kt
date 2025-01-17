package cl.random.test.interactors

import android.util.Log
import cl.random.test.callbacks.OnCountriesFetched
import cl.random.test.models.Country
import cl.random.test.services.CountryBuilder
import cl.random.test.services.CountryService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryInteractor
{

    fun fetchCountries(callback: OnCountriesFetched)
    {
        val request = CountryBuilder.buildService(CountryService::class.java)
        val call = request.getCountryList()

        call.enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                Log.d("response", response.body()!!.first().name);
                if (response.isSuccessful){
                    val countries = response.body()!!
                    Log.d("TAG", "Got" + countries.size + "countries")
                    callback.onSuccess(response.body()!!)

                }
            }
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.d("failure", t.toString())
                //Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        //call.enqueue(callback);
    }
}