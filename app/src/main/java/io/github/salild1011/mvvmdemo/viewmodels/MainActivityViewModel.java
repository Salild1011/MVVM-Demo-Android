package io.github.salild1011.mvvmdemo.viewmodels;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.github.salild1011.mvvmdemo.models.Place;
import io.github.salild1011.mvvmdemo.repositories.PlaceRepository;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Place>> places;
    private PlaceRepository placeRepo;

    public void init() {
        if (places != null) {
            return;
        }

        placeRepo = PlaceRepository.getInstance();
        places = placeRepo.getPlaces();
    }

    public LiveData<List<Place>> getPlaces() {
        return places;
    }
}
