package cl.random.test.ui.holders

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.random.test.R
import cl.random.test.models.Country
import cl.random.test.presenter.MainPresenter
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountryViewHolder(inflater: LayoutInflater, parent: ViewGroup, val presenter: MainPresenter) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.country_item, parent, false)) {
    val name: TextView = itemView.findViewById(R.id.country_name)
    val capital: TextView = itemView.findViewById(R.id.country_capital)
    val flag: ImageView = itemView.findViewById(R.id.country_flag)
    lateinit var country: Country

    init {
        itemView.setOnClickListener { presenter.goToCountry(country) }
    }

    fun bind(country: Country, context: Context) {
        this.country = country
        name.text = country.name
        capital.text = "Capital: ${country.capital}"
        GlideToVectorYou.init().with(context).load(Uri.parse(country.flag), flag)

    }

}

