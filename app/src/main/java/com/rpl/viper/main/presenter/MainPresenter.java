package com.rpl.viper.main.presenter;

import com.rpl.viper.main.MainContract;
import com.rpl.viper.main.entity.University;
import com.rpl.viper.main.interactor.MainInteractor;
import com.rpl.viper.main.router.MainRouter;
import com.rpl.viper.main.view.MainActivity;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.Interactor interactor;
    private MainContract.Router router;
    private MainContract.View view;
    private List<University> items;


    public MainPresenter(MainContract.Interactor mainInteractor, MainContract.Router mainRouter, MainContract.View mainActivity) {
        this.interactor = mainInteractor;
        this.router = mainRouter;
        this.view = mainActivity;
    }

    @Override
    public void onViewCreated() {
        items = interactor.getUniversities();
        view.publishData(items);
    }

    @Override
    public void onTap(Integer index) {
        router.openUniversity(items.get(index).name);
    }

    @Override
    public void onLongTap(Integer index) {
        view.showMessage(items.get(index).name);
        items.remove(index);
        view.publishData(items);
    }
}