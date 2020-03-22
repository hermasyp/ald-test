package com.catnip.avengersapp.feature.main.herolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.catnip.avengersapp.R
import com.catnip.avengersapp.utils.result.ResultState
import kotlinx.android.synthetic.main.fragment_hero_list.*

class HeroListFragment : Fragment() {

    private lateinit var heroListViewModel: HeroListViewModel
    private lateinit var adapterList: HeroesAdapterList

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        heroListViewModel =
                ViewModelProviders.of(this).get(HeroListViewModel::class.java)
        return inflater.inflate(R.layout.fragment_hero_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObserver()
    }

    private fun setupObserver() {
        heroListViewModel.fetchHeroesData()
        heroListViewModel.heroesResult.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultState.Progress -> {
                    pb_hero_list.visibility = View.VISIBLE
                }
                is ResultState.Success -> {
                    pb_hero_list.visibility = View.GONE
                    adapterList.heroes = it.data.heroes.toMutableList()
                }
                is ResultState.Error -> {
                    Toast.makeText(context,getString(R.string.txt_error_get_data), Toast.LENGTH_SHORT).show()
                    pb_hero_list.visibility = View.GONE
                }
            }
        })
    }

    private fun setupViews(){
        adapterList = HeroesAdapterList {
            Toast.makeText(context,it.name, Toast.LENGTH_SHORT).show()

        }
        rv_hero?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(false)
            adapter = adapterList
        }
    }
}
