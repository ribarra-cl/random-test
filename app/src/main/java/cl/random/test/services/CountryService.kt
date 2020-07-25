package cl.random.test.services

import cl.random.test.models.Country
import retrofit2.Call
import retrofit2.http.GET


interface CountryService
{
    @GET("all")
    fun getCountryList() : Call<List<Country>>
}