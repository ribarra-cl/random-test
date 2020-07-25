package cl.random.test.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.random.test.models.Country
import cl.random.test.ui.holders.CountryViewHolder

class CountriesAdapter : RecyclerView.Adapter<CountryViewHolder>() {

    var countries: ArrayList<Country> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CountryViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        var country = countries[position]
        Log.d("TAG", "binding" + country.name)
        holder.bind(country)

    }

    override fun getItemCount(): Int {
        return countries.size
    }

    fun updateCountries(countries: List<Country>)
    {
        this.countries.clear()
        this.countries.addAll(countries)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}