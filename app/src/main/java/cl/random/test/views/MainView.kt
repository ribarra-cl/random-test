package cl.random.test.views

import cl.random.test.models.Country

interface MainView {

    // progress
    fun showLoading()
    fun hideLoading()

    // failure
    fun onFailure()

    // update
    fun updateCountries(countries: List<Country>)

    // navigation
    fun goToCountry(country: Country)
}