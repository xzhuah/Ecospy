package team9.camp.microsoft.ecospy.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import team9.camp.microsoft.ecospy.R;

public class Splash extends AppCompatActivity
{
    private static final int LOAD_DISPLAY_TIME = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
                /* Create an Intent that will start the Main WordPress Activity. */
                Intent mainIntent = new Intent(Splash.this, LoginActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, LOAD_DISPLAY_TIME); //1500 for release
    }
}
