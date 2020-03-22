package com.catnip.avengersapp.feature.main.herolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.catnip.avengersapp.R

class HeroListFragment : Fragment() {

    private lateinit var heroListViewModel: HeroListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        heroListViewModel =
                ViewModelProviders.of(this).get(HeroListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_hero_list, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        heroListViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
