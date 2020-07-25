package cl.random.test.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.random.test.models.Country
import cl.random.test.ui.holders.CountryViewHolder

class CountriesAdapter : RecyclerView.Adapter<CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CountryViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        Log.d("TAG", "ol bind")
        holder.bind(Country("Hola" + position))
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}