package team9.camp.microsoft.ecospy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class GameMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageButton btn1,btn2,btn3,btn4,btn5;
    private View.OnClickListener navBar=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn1_1:
                case R.id.btn2_1:
                case R.id.btn3_1:
                case R.id.btn4_1:
                case R.id.btn5_1:
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                    break;
                case R.id.btn1_2:
                case R.id.btn2_2:
                case R.id.btn3_2:
                case R.id.btn4_2:
                case R.id.btn5_2:
                    //startActivity(new Intent(getApplicationContext(),GameMain.class));
                   // finish();
                    break;
                case R.id.btn1_3:
                case R.id.btn2_3:
                case R.id.btn3_3:
                case R.id.btn4_3:
                case R.id.btn5_3:
                    startActivity(new Intent(getApplicationContext(),ShareMain.class));
                    finish();
                    break;
                case R.id.btn1_4:
                case R.id.btn2_4:
                case R.id.btn3_4:
                case R.id.btn4_4:
                case R.id.btn5_4:
                    startActivity(new Intent(getApplicationContext(),RecyleMain.class));
                    finish();
                    break;
                case R.id.btn1_5:
                case R.id.btn2_5:
                case R.id.btn3_5:
                case R.id.btn4_5:
                case R.id.btn5_5:
                    startActivity(new Intent(getApplicationContext(),QuitMain.class));
                    finish();
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_game);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                /*Intent intent = new Intent(MainActivity.this, CameraMain.class);
//                startActivity(intent);*/
//                ImageView menuImage=new ImageView(MainActivity.this);
//                menuImage.setImageResource(R.drawable.ui_buttons);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_game);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_game);
        navigationView.setNavigationItemSelectedListener(this);

        btn1=(ImageButton)findViewById(R.id.btn2_1);
        btn2=(ImageButton)findViewById(R.id.btn2_2);
        btn3=(ImageButton)findViewById(R.id.btn2_3);
        btn4=(ImageButton)findViewById(R.id.btn2_4);
        btn5=(ImageButton)findViewById(R.id.btn2_5);
        btn1.setOnClickListener(navBar);
        btn2.setOnClickListener(navBar);
        btn3.setOnClickListener(navBar);
        btn4.setOnClickListener(navBar);
        btn5.setOnClickListener(navBar);
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_game);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action

            Intent intent = new Intent(this, CameraMain.class);
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_game);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
