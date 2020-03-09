package io.github.salild1011.mvvmdemo.viewmodels;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.github.salild1011.mvvmdemo.models.Place;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Place>> places;

    public LiveData<List<Place>> getPlaces() {
        return places;
    }
}
