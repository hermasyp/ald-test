package com.catnip.avengersapp.feature.main.herolist;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale
import com.catnip.avengersapp.R
import com.catnip.avengersapp.data.model.Hero
import kotlinx.android.synthetic.main.item_hero.view.*

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class HeroesAdapterList(private val itemClick: (Hero) -> Unit) :
    RecyclerView.Adapter<HeroesAdapterList.HeroViewHolder>() {

    var heroes: MutableList<Hero> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bindView(heroes[position])
    }

    override fun getItemCount(): Int = heroes.size

    class HeroViewHolder(private val view: View, val itemClick: (Hero) -> Unit) :
        RecyclerView.ViewHolder(view) {

        fun bindView(item: Hero) {
            with(item) {
                itemView.iv_preview_hero
                    .load(this.images[0]) {
                        crossfade(true)
                        scale(Scale.FIT)
                        placeholder(R.drawable.ic_placeholder)
                        error(R.drawable.ic_placeholder)
                    }
                itemView.tv_hero_name.text = name
                itemView.tv_hero_desc.text = description
                itemView.setOnClickListener { itemClick(this) }
            }

        }
    }

}