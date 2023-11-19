package com.rpl.viper.main.entity;


import android.content.Context;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpl.viper.R;
import com.rpl.viper.main.MainContract;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UniversityRepository implements MainContract.Repo {
    private Context context;
    public UniversityRepository(Context context) {
        this.context = context;
    };

    public List<University> fetchUniversity() {
        try {
            String raw = inputStreamToString(context.getResources().openRawResource(R.raw.university_list));
            ObjectMapper om = new ObjectMapper();
            UniversityList list = om.readValue(raw, UniversityList.class);
            return new ArrayList<>(list.list);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    };

    public String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            String json = new String(bytes);
            return json;
        } catch (IOException e) {
            return null;
        }
    }
}
