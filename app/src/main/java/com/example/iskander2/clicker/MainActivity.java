package com.example.iskander2.clicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
ImageButton button1;
    Animation lefttoright;
    LinearLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startNewActivity();
        l1 = (LinearLayout) findViewById(R.id.layout1);
        l1.setAnimation(lefttoright);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
    }

 /*   @Override
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
    }*/
    public void startNewActivity() {
        button1 = (ImageButton) findViewById(R.id.button_start);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(MainActivity.this, ClickerActivity.class);
                startActivity(start);
            }
        });
    }
 /*  public void OnClick(View view){
        int clicks = Integer.parseInt(textView.getText().toString());
        textView.setText(Integer.toString(++clicks))
    } */
}
