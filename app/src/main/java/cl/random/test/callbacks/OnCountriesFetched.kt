package cl.random.test.callbacks

import cl.random.test.models.Country

interface OnCountriesFetched
{

    fun onSuccess(countries: List<Country>)
    fun onFailure(t: Throwable)

}