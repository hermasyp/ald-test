package com.catnip.avengersapp.feature.main.herolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catnip.avengersapp.data.model.Heroes
import com.catnip.avengersapp.data.network.RetrofitApi
import com.catnip.avengersapp.utils.result.ResultState
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HeroListViewModel : ViewModel() {

    private val api = RetrofitApi()
    private val compositeDisposable = CompositeDisposable()

    var heroesResult = MutableLiveData<ResultState<Heroes>>()

    public fun fetchHeroesData() {
        heroesResult.value = ResultState.loading(true)
        compositeDisposable.add(
            api.getHeroes().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.success) {
                        heroesResult.value = ResultState.success(it)
                    } else {
                        heroesResult.value = ResultState.failure("Error while fetching data")
                    }
                }, {
                    heroesResult.value = ResultState.error(it)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}