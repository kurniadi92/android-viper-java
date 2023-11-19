package com.rpl.viper.main.interactor;

import com.rpl.viper.main.MainContract;
import com.rpl.viper.main.entity.University;
import com.rpl.viper.main.entity.UniversityRepository;

import java.util.List;

public class MainInteractor implements MainContract.Interactor {
    private UniversityRepository repo;
    public MainInteractor(UniversityRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<University> getUniversities() {
        return repo.fetchUniversity();
    }
}