package com.rpl.viper.main;

import com.rpl.viper.main.entity.University;

import java.util.List;

public interface MainContract {
    public interface View {
        public void publishData(List<University> data);
        public void showMessage(String msg);
    }

    public interface Presenter {
        public void onViewCreated();
        public void onTap(Integer index);
        public void onLongTap(Integer index);
    }

    public interface Interactor {
        public List<University> getUniversities();
    }

    public interface Router {
        public void openUniversity(String name);
    }

    public interface Repo {
        public List<University> fetchUniversity();
    }
}