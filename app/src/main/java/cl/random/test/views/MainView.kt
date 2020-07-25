package cl.random.test.views

import cl.random.test.models.Country

interface MainView {

    // on create
    fun onReady()

    // progress
    fun showLoading()
    fun hideLoading()

    // update
    fun updateCountries(countries: List<Country>)
}