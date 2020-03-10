package io.github.salild1011.mvvmdemo.viewmodels;

import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.github.salild1011.mvvmdemo.models.Place;
import io.github.salild1011.mvvmdemo.repositories.PlaceRepository;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Place>> places;
    private PlaceRepository placeRepo;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public void init() {
        if (places != null) {
            return;
        }

        placeRepo = PlaceRepository.getInstance();
        places = placeRepo.getPlaces();
    }

    public void addNewValue(final Place place) {
        isUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                List<Place> currentPlaces = places.getValue();
                currentPlaces.add(place);

                places.postValue(currentPlaces);
                isUpdating.setValue(false);
            }
        }.execute();
    }

    public LiveData<List<Place>> getPlaces() {
        return places;
    }

    public LiveData<Boolean> getIsUpdating() { return isUpdating; }
}
