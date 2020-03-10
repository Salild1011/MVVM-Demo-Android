package io.github.salild1011.mvvmdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.salild1011.mvvmdemo.adapters.RecyclerAdapter;
import io.github.salild1011.mvvmdemo.models.Place;
import io.github.salild1011.mvvmdemo.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.progress_circular) ProgressBar progressBar;
    @BindView(R.id.floating_action_button) FloatingActionButton floatingActionButton;

    private RecyclerAdapter recyclerAdapter;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.init();
        viewModel.getPlaces().observe(this, places -> recyclerAdapter.notifyDataSetChanged());

        viewModel.getIsUpdating().observe(this, isUpdating -> {
            if (isUpdating) {
                showProgressBar();
            } else {
                hideProgressBar();
                recyclerView.smoothScrollToPosition(viewModel.getPlaces().getValue().size() - 1);
            }
        });

        floatingActionButton.setOnClickListener(view -> {
                viewModel.addNewValue(new Place(
                        "Washington",
                        "https://i.redd.it/k98uzl68eh501.jpg"
                ));
        });

        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerAdapter = new RecyclerAdapter(this, viewModel.getPlaces().getValue());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }
}
