package cl.random.test.activities

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.random.test.R
import cl.random.test.interactors.CountryInteractor
import cl.random.test.models.Country
import cl.random.test.presenter.CountryPresenter
import cl.random.test.views.CountryView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountryActivity : AppCompatActivity(), CountryView {

    lateinit var flag: ImageView
    lateinit var name: TextView
    lateinit var capital: TextView
    lateinit var region: TextView
    lateinit var population: TextView

    private val presenter = CountryPresenter(this, CountryInteractor())
    lateinit var country: Country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        flag = findViewById(R.id.country_flag)
        name = findViewById(R.id.country_name)
        capital = findViewById(R.id.country_capital)
        region = findViewById(R.id.country_region)
        population = findViewById(R.id.country_population)

        country = intent.getSerializableExtra("country") as Country
        Log.d("TAG", "countr" + country.name)

        presenter.setup()
    }

    override fun setup()
    {
        name.text = country.name
        capital.text = "Capital: ${country.capital}"
        region.text = "Región: ${country.area}"
        population.text = "Población: ${country.population}"
        GlideToVectorYou.init().with(this).load(Uri.parse(country.flag), flag)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}