package cl.random.test

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.random.test.interactors.MainInteractor
import cl.random.test.presenter.MainPresenter
import cl.random.test.views.MainView

class MainActivity : AppCompatActivity(), MainView {

    lateinit var progressBar: ProgressBar
    lateinit var textView: TextView

    private val presenter = MainPresenter(this, MainInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById<ProgressBar>(R.id.progress)
        textView =  findViewById<TextView>(R.id.country)

        presenter.fetch()
    }

    override fun onReady()
    {

    }

    override fun showLoading()
    {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading()
    {
        progressBar.visibility = View.GONE
    }

    override fun showCountries(total: Int)
    {
        textView.setText("found " + total + "countries")
    }
}