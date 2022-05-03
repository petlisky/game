package com.petlisky.game;

import android.app.Activity;
import android.os.Bundle;

import com.petlisky.game.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // orientation landscape
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); // fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE); // to title bar

        setContentView(R.layout.activity_main);

    }

}
