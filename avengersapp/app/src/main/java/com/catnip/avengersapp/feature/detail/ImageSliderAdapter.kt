package com.catnip.avengersapp.feature.detail;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import coil.size.Scale
import com.catnip.avengersapp.R
import com.catnip.avengersapp.data.model.Hero
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.item_image_slider.view.*

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class ImageSliderAdapter() :
    SliderViewAdapter<ImageSliderAdapter.ImageSliderViewHolder>() {

    var heroesImage: MutableList<String> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onBindViewHolder(holder: ImageSliderViewHolder, position: Int) {
        holder.bindView(heroesImage[position])
    }

    class ImageSliderViewHolder(private val view: View) :
        SliderViewAdapter.ViewHolder(view) {

        fun bindView(item: String) {
            itemView.iv_auto_image_slider
                .load(item) {
                    crossfade(true)
                    placeholder(R.drawable.ic_placeholder)
                    error(R.drawable.ic_placeholder)
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ImageSliderViewHolder {
        val view =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_image_slider, parent, false)
        return ImageSliderViewHolder(view)
    }

    override fun getCount(): Int = heroesImage.size

}