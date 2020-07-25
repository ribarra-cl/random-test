package cl.random.test.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cl.random.test.R
import cl.random.test.interactors.MainInteractor
import cl.random.test.models.Country
import cl.random.test.presenter.MainPresenter
import cl.random.test.ui.adapters.CountriesAdapter
import cl.random.test.views.MainView

class MainActivity : AppCompatActivity(), MainView {

    lateinit var progressBar: ProgressBar
    lateinit var recyclerView: RecyclerView

    private val presenter = MainPresenter(this, MainInteractor())
    private val adapter = CountriesAdapter(this, presenter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progress)
        recyclerView = findViewById(R.id.main_recycler_view)

        recyclerView.adapter = adapter

        presenter.fetch()
    }

    override fun onReady() {

    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun updateCountries(countries: List<Country>) {
        adapter.updateCountries(countries)
        adapter.notifyDataSetChanged()

    }

    override fun goToCountry(country: Country) {
        val intent = Intent(this, CountryActivity::class.java).apply{
            putExtra("country", country)
        }
        startActivity(intent)
    }
}