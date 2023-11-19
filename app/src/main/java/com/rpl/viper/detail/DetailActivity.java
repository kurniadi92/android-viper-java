package com.rpl.viper.detail;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import com.rpl.viper.R;

public class DetailActivity extends AppCompatActivity implements Toolbar.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String text = getIntent().getStringExtra("university_name");
        TextView textView = findViewById(R.id.nameTextView);
        textView.setText(text);
        initView();
    }

    void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Detail University");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.finish();
    }
}