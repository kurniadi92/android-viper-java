package com.rpl.viper.main.router;

import android.content.Intent;
import com.rpl.viper.detail.DetailActivity;
import com.rpl.viper.main.MainContract;
import com.rpl.viper.main.view.MainActivity;

public class MainRouter implements MainContract.Router {

    private MainActivity activity;
    public MainRouter(MainActivity activity) {
        this.activity = activity;
    }
    @Override
    public void openUniversity(String name) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra("university_name", name);

        activity.startActivity(intent);
    }
}