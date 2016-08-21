package team9.camp.microsoft.ecospy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageButton btn1,btn2,btn3,btn4,btn5;
    private Button refresh;
    private EditText ip;

    private View.OnClickListener navBar=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn1_1:
                case R.id.btn2_1:
                case R.id.btn3_1:
                case R.id.btn4_1:
                case R.id.btn5_1:

                   // startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    break;
                case R.id.btn1_2:
                case R.id.btn2_2:
                case R.id.btn3_2:
                case R.id.btn4_2:
                case R.id.btn5_2:

                    startActivity(new Intent(MainActivity.this, GameMain.class));
                    finish();
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
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        UserPO.context=this;


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btn1=(ImageButton)findViewById(R.id.btn1_1);
        btn2=(ImageButton)findViewById(R.id.btn1_2);
        btn3=(ImageButton)findViewById(R.id.btn1_3);
        btn4=(ImageButton)findViewById(R.id.btn1_4);
        btn5=(ImageButton)findViewById(R.id.btn1_5);
        btn1.setOnClickListener(navBar);
        btn2.setOnClickListener(navBar);
        btn3.setOnClickListener(navBar);
        btn4.setOnClickListener(navBar);
        btn5.setOnClickListener(navBar);

        refresh=(Button)findViewById(R.id.refreshIP);

        ip=(EditText)findViewById(R.id.serverAdd);
        ip.setText(UserPO.server);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserPO.server = ip.getText().toString();
            }
        });








    }
    private void writeToFile(File fout, String data) {
        FileOutputStream osw = null;
        try {
            osw = new FileOutputStream(fout);
            osw.write(data.getBytes());
            osw.flush();
        } catch (Exception e) {
            ;
        } finally {
            try {
                osw.close();
            } catch (Exception e) {
                ;
            }
        }
    }
    public boolean isExtStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    public boolean isExtStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
    private String readFromFile(File fin) {
        StringBuilder data = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fin), "utf-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
        } catch (Exception e) {
            ;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                ;
            }
        }
        return data.toString();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
