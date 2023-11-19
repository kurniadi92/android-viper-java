package com.rpl.viper.main.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rpl.viper.R;
import com.rpl.viper.main.MainContract;
import com.rpl.viper.main.entity.University;
import com.rpl.viper.main.entity.UniversityRepository;
import com.rpl.viper.main.interactor.MainInteractor;
import com.rpl.viper.main.presenter.MainPresenter;
import com.rpl.viper.main.router.MainRouter;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MainAdapter.UniversityListener, MainContract.View {
    MainAdapter adapter;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MainAdapter(this);

        UniversityRepository repository = new UniversityRepository(this);
        presenter = new MainPresenter(
                new MainInteractor(repository),
                new MainRouter(this),
                this
        );
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter.onViewCreated();
    }

    @Override
    public void onUniversityClicked(Integer position) {
        presenter.onTap(position);
    }

    @Override
    public void onUniversityLongTap(Integer position) {
        presenter.onLongTap(position);
    }

    @Override
    public void publishData(List<University> data) {
        adapter.setList(data);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
