package cl.random.test.presenter

import android.util.Log
import cl.random.test.callbacks.OnCountriesFetched
import cl.random.test.interactors.CountryInteractor
import cl.random.test.interactors.MainInteractor
import cl.random.test.models.Country
import cl.random.test.views.CountryView
import cl.random.test.views.MainView

class CountryPresenter(var view: CountryView, val interactor: CountryInteractor) {

fun setup()
{
    view.setup()
}
}

