package io.github.salild1011.mvvmdemo.repositories;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import io.github.salild1011.mvvmdemo.models.Place;

public class PlaceRepository {

    private static PlaceRepository instance;
    private ArrayList<Place> dataSet = new ArrayList<>();

    public static PlaceRepository getInstance() {
        if (instance == null) {
            instance = new PlaceRepository();
        }

        return instance;
    }

    // Pretend you are populating data from a webservice or a database
    public MutableLiveData<List<Place>> getPlaces() {
        setPlaces();

        MutableLiveData<List<Place>> liveData = new MutableLiveData<>();
        liveData.setValue(dataSet);
        return liveData;
    }

    private void setPlaces() {
        dataSet.add(
                new Place("Havasu Falls",
                        "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg")
        );
        dataSet.add(
                new Place("Trondheim",
                        "https://i.redd.it/tpsnoz5bzo501.jpg")
        );
        dataSet.add(
                new Place("Portugal",
                        "https://i.redd.it/qn7f9oqu7o501.jpg")
        );
        dataSet.add(
                new Place("Rocky Mountain National Park",
                        "https://i.redd.it/j6myfqglup501.jpg")
        );
        dataSet.add(
                new Place("Havasu Falls",
                        "https://i.redd.it/0h2gm1ix6p501.jpg")
        );
        dataSet.add(
                new Place("Mahahual",
                        "https://i.redd.it/k98uzl68eh501.jpg")
        );
        dataSet.add(
                new Place("Frozen Lake",
                        "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg")
        );
        dataSet.add(
                new Place("Austrailia",
                        "https://i.redd.it/obx4zydshg601.jpg")
        );
    }
}
