package com.example.iskander2.clicker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClickerActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mSettings";
    public static final String APP_PREFERENCES_CLICKS = "Clicks";
    int clicks =0;
    SharedPreferences mClicks;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicks = Integer.parseInt(textView.getText().toString());
                textView.setText(Integer.toString(++clicks));
                mClicks = getSharedPreferences(APP_PREFERENCES, getApplicationContext().MODE_PRIVATE);
            }
        }
        );
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mClicks.edit();
        editor.putInt(APP_PREFERENCES_CLICKS,clicks);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mClicks.contains(APP_PREFERENCES_CLICKS)) {
            textView.setText(Integer.toString(mClicks.getInt(APP_PREFERENCES_CLICKS, 0)));
            clicks = mClicks.getInt(APP_PREFERENCES_CLICKS, 0);
        }
    }
}
