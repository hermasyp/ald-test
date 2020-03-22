package com.catnip.avengersapp.feature.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.catnip.avengersapp.R
import com.catnip.avengersapp.data.model.Hero
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_detail_hero_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class DetailHeroDialogFragment : DialogFragment() {

    private lateinit var adapter: ImageSliderAdapter
    private  var hero: Hero? = null

    companion object {
        const val ARG_HERO = "HERO"

        fun newInstance(hero: Hero): DetailHeroDialogFragment {
            val args = Bundle()
            args.putParcelable(ARG_HERO, hero)
            val fragment = DetailHeroDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setStyle(STYLE_NO_TITLE, R.style.AppTheme_DialogThemeTransparent)
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_hero_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hero =  this.arguments?.getParcelable(ARG_HERO)
        adapter = ImageSliderAdapter()
        imageSlider.setSliderAdapter(adapter)
        imageSlider.setIndicatorAnimation(IndicatorAnimations.THIN_WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT;
        imageSlider.indicatorSelectedColor = Color.WHITE;
        imageSlider.indicatorUnselectedColor = Color.GRAY;
        imageSlider.scrollTimeInSec = 3;
        imageSlider.isAutoCycle = false;
        hero?.let {
            imageSlider.startAutoCycle()
            tv_hero_name?.text = it.name
            tv_hero_desc?.text = it.description
            adapter.heroesImage = it.images.toMutableList()
        }
    }

}
