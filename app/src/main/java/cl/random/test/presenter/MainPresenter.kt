package cl.random.test.presenter

import android.util.Log
import cl.random.test.callbacks.OnCountriesFetched
import cl.random.test.interactors.MainInteractor
import cl.random.test.models.Country
import cl.random.test.views.MainView

class MainPresenter(var mainView: MainView, val interactor: MainInteractor) :
OnCountriesFetched {

    fun fetch()
    {
        mainView.showLoading();
        interactor.fetchCountries(this)
    }

    override fun onSuccess(countries: List<Country>) {
        mainView.hideLoading()
        mainView.updateCountries(countries)
    }

    override fun onFailure(t: Throwable) {
        TODO("Not yet implemented")
        mainView.hideLoading()
        Log.d("TAG", "error" + t.toString());
    }
}

