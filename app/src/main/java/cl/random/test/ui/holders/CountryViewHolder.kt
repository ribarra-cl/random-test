package cl.random.test.ui.holders

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.random.test.R
import cl.random.test.models.Country

class CountryViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.country_item, parent, false)) {
    private var textView: TextView? = null


    init {
        textView = itemView.findViewById(R.id.country_name)
    }

    fun bind(country: Country) {
        Log.d("TAG", "bind " + country.name)
        textView?.text = country.name
    }

}