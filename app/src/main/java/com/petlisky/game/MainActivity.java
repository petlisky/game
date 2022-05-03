package com.petlisky.game;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // orientation landscape
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); // fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE); // to title bar

        setContentView(new GameScene(this));

    }
    
    @Override
    public void onBackPressed() {

        if (back_pressed + 2000 > System.currentTimeMillis()) {

            super.onBackPressed();

        } else {

            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();

        }

        back_pressed = System.currentTimeMillis();
        
    }

}
