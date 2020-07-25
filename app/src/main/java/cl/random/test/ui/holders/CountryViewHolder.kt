package cl.random.test.ui.holders

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.random.test.R
import cl.random.test.models.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountryViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.country_item, parent, false)) {
    val name: TextView
    val capital: TextView
    val flag: ImageView

    init {
        flag = itemView.findViewById(R.id.country_flag)
        name = itemView.findViewById(R.id.country_name)
        capital = itemView.findViewById(R.id.country_capital)
    }

    fun bind(country: Country, context: Context) {
        Log.d("TAG", "bind " + country.name + "- " + country.flag)
        name.text = country.name
        capital.text = country.capital
        GlideToVectorYou.init().with(context).load(Uri.parse(country.flag), flag)
    }

}