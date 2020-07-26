package cl.random.test.presenter

import android.util.Log
import cl.random.test.callbacks.OnCountriesFetched
import cl.random.test.interactors.MainInteractor
import cl.random.test.models.Country
import cl.random.test.views.MainView

class MainPresenter(var view: MainView, val interactor: MainInteractor) :
    OnCountriesFetched {

    fun fetch() {
        view.showLoading();
        interactor.fetchCountries(this)
    }

    override fun onSuccess(countries: List<Country>) {
        view.hideLoading()
        view.updateCountries(countries)
    }

    override fun onFailure(t: Throwable) {
        view.hideLoading()
        view.onFailure()
    }

    fun goToCountry(country: Country) {
        view.goToCountry(country)
    }
}

