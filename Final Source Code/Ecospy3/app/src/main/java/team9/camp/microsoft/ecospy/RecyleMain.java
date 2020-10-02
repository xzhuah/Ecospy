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
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyleMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageButton btn1,btn2,btn3,btn4,btn5;
    private GridLayout mitemlist;
    private ImageView[] allImage=new ImageView[100];
    private TextView[] allName=new TextView[100];
    //private TextView[] allMat;
    private View.OnClickListener navBar=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn1_1:
                case R.id.btn2_1:
                case R.id.btn3_1:
                case R.id.btn4_1:
                case R.id.btn5_1:
                   startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                    break;
                case R.id.btn1_2:
                case R.id.btn2_2:
                case R.id.btn3_2:
                case R.id.btn4_2:
                case R.id.btn5_2:
                    startActivity(new Intent(getApplicationContext(), GameMain.class));
                    finish();
                    break;
                case R.id.btn1_3:
                case R.id.btn2_3:
                case R.id.btn3_3:
                case R.id.btn4_3:
                case R.id.btn5_3:
                    startActivity(new Intent(getApplicationContext(), ShareMain.class));
                    finish();
                    break;
                case R.id.btn1_4:
                case R.id.btn2_4:
                case R.id.btn3_4:
                case R.id.btn4_4:
                case R.id.btn5_4:
                  // startActivity(new Intent(getApplicationContext(),RecyleMain.class));
                    break;
                case R.id.btn1_5:
                case R.id.btn2_5:
                case R.id.btn3_5:
                case R.id.btn4_5:
                case R.id.btn5_5:
                   startActivity(new Intent(getApplicationContext(), QuitMain.class));
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
        setContentView(R.layout.activity_recyle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_recyle);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_recyle);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_recyle);
        navigationView.setNavigationItemSelectedListener(this);

        btn1=findViewById(R.id.btn4_1);
        btn2=findViewById(R.id.btn4_2);
        btn3=findViewById(R.id.btn4_3);
        btn4=findViewById(R.id.btn4_4);
        btn5=findViewById(R.id.btn4_5);
        btn1.setOnClickListener(navBar);
        btn2.setOnClickListener(navBar);
        btn3.setOnClickListener(navBar);
        btn4.setOnClickListener(navBar);
        btn5.setOnClickListener(navBar);

        allImage[0]=(ImageView)findViewById(R.id.bag_image0);
        allName[0]=(TextView)findViewById(R.id.bag_name0);
        allImage[1]=(ImageView)findViewById(R.id.bag_image1);
        allName[1]=(TextView)findViewById(R.id.bag_name1);
        allImage[2]=(ImageView)findViewById(R.id.bag_image2);
        allName[2]=(TextView)findViewById(R.id.bag_name2);
        allImage[3]=(ImageView)findViewById(R.id.bag_image3);
        allName[3]=(TextView)findViewById(R.id.bag_name3);
        allImage[4]=(ImageView)findViewById(R.id.bag_image4);
        allName[4]=(TextView)findViewById(R.id.bag_name4);
        allImage[5]=(ImageView)findViewById(R.id.bag_image5);
        allName[5]=(TextView)findViewById(R.id.bag_name5);
        allImage[6]=(ImageView)findViewById(R.id.bag_image6);
        allName[6]=(TextView)findViewById(R.id.bag_name6);
        allImage[7]=(ImageView)findViewById(R.id.bag_image7);
        allName[7]=(TextView)findViewById(R.id.bag_name7);
        allImage[8]=(ImageView)findViewById(R.id.bag_image8);
        allName[8]=(TextView)findViewById(R.id.bag_name8);
        allImage[9]=(ImageView)findViewById(R.id.bag_image9);
        allName[9]=(TextView)findViewById(R.id.bag_name9);
        allImage[10]=(ImageView)findViewById(R.id.bag_image10);
        allName[10]=(TextView)findViewById(R.id.bag_name10);
        allImage[11]=(ImageView)findViewById(R.id.bag_image11);
        allName[11]=(TextView)findViewById(R.id.bag_name11);
        allImage[12]=(ImageView)findViewById(R.id.bag_image12);
        allName[12]=(TextView)findViewById(R.id.bag_name12);
        allImage[13]=(ImageView)findViewById(R.id.bag_image13);
        allName[13]=(TextView)findViewById(R.id.bag_name13);
        allImage[14]=(ImageView)findViewById(R.id.bag_image14);
        allName[14]=(TextView)findViewById(R.id.bag_name14);
        allImage[15]=(ImageView)findViewById(R.id.bag_image15);
        allName[15]=(TextView)findViewById(R.id.bag_name15);
        allImage[16]=(ImageView)findViewById(R.id.bag_image16);
        allName[16]=(TextView)findViewById(R.id.bag_name16);
        allImage[17]=(ImageView)findViewById(R.id.bag_image17);
        allName[17]=(TextView)findViewById(R.id.bag_name17);
        allImage[18]=(ImageView)findViewById(R.id.bag_image18);
        allName[18]=(TextView)findViewById(R.id.bag_name18);
        allImage[19]=(ImageView)findViewById(R.id.bag_image19);
        allName[19]=(TextView)findViewById(R.id.bag_name19);
        allImage[20]=(ImageView)findViewById(R.id.bag_image20);
        allName[20]=(TextView)findViewById(R.id.bag_name20);
        allImage[21]=(ImageView)findViewById(R.id.bag_image21);
        allName[21]=(TextView)findViewById(R.id.bag_name21);
        allImage[22]=(ImageView)findViewById(R.id.bag_image22);
        allName[22]=(TextView)findViewById(R.id.bag_name22);
        allImage[23]=(ImageView)findViewById(R.id.bag_image23);
        allName[23]=(TextView)findViewById(R.id.bag_name23);
        allImage[24]=(ImageView)findViewById(R.id.bag_image24);
        allName[24]=(TextView)findViewById(R.id.bag_name24);
        allImage[25]=(ImageView)findViewById(R.id.bag_image25);
        allName[25]=(TextView)findViewById(R.id.bag_name25);
        allImage[26]=(ImageView)findViewById(R.id.bag_image26);
        allName[26]=(TextView)findViewById(R.id.bag_name26);
        allImage[27]=(ImageView)findViewById(R.id.bag_image27);
        allName[27]=(TextView)findViewById(R.id.bag_name27);
        allImage[28]=(ImageView)findViewById(R.id.bag_image28);
        allName[28]=(TextView)findViewById(R.id.bag_name28);
        allImage[29]=(ImageView)findViewById(R.id.bag_image29);
        allName[29]=(TextView)findViewById(R.id.bag_name29);
        allImage[30]=(ImageView)findViewById(R.id.bag_image30);
        allName[30]=(TextView)findViewById(R.id.bag_name30);
        allImage[31]=(ImageView)findViewById(R.id.bag_image31);
        allName[31]=(TextView)findViewById(R.id.bag_name31);
        allImage[32]=(ImageView)findViewById(R.id.bag_image32);
        allName[32]=(TextView)findViewById(R.id.bag_name32);
        allImage[33]=(ImageView)findViewById(R.id.bag_image33);
        allName[33]=(TextView)findViewById(R.id.bag_name33);
        allImage[34]=(ImageView)findViewById(R.id.bag_image34);
        allName[34]=(TextView)findViewById(R.id.bag_name34);
        allImage[35]=(ImageView)findViewById(R.id.bag_image35);
        allName[35]=(TextView)findViewById(R.id.bag_name35);
        allImage[36]=(ImageView)findViewById(R.id.bag_image36);
        allName[36]=(TextView)findViewById(R.id.bag_name36);
        allImage[37]=(ImageView)findViewById(R.id.bag_image37);
        allName[37]=(TextView)findViewById(R.id.bag_name37);
        allImage[38]=(ImageView)findViewById(R.id.bag_image38);
        allName[38]=(TextView)findViewById(R.id.bag_name38);
        allImage[39]=(ImageView)findViewById(R.id.bag_image39);
        allName[39]=(TextView)findViewById(R.id.bag_name39);
        allImage[40]=(ImageView)findViewById(R.id.bag_image40);
        allName[40]=(TextView)findViewById(R.id.bag_name40);
        allImage[41]=(ImageView)findViewById(R.id.bag_image41);
        allName[41]=(TextView)findViewById(R.id.bag_name41);
        allImage[42]=(ImageView)findViewById(R.id.bag_image42);
        allName[42]=(TextView)findViewById(R.id.bag_name42);
        allImage[43]=(ImageView)findViewById(R.id.bag_image43);
        allName[43]=(TextView)findViewById(R.id.bag_name43);
        allImage[44]=(ImageView)findViewById(R.id.bag_image44);
        allName[44]=(TextView)findViewById(R.id.bag_name44);
        allImage[45]=(ImageView)findViewById(R.id.bag_image45);
        allName[45]=(TextView)findViewById(R.id.bag_name45);
        allImage[46]=(ImageView)findViewById(R.id.bag_image46);
        allName[46]=(TextView)findViewById(R.id.bag_name46);
        allImage[47]=(ImageView)findViewById(R.id.bag_image47);
        allName[47]=(TextView)findViewById(R.id.bag_name47);
        allImage[48]=(ImageView)findViewById(R.id.bag_image48);
        allName[48]=(TextView)findViewById(R.id.bag_name48);
        allImage[49]=(ImageView)findViewById(R.id.bag_image49);
        allName[49]=(TextView)findViewById(R.id.bag_name49);
        allImage[50]=(ImageView)findViewById(R.id.bag_image50);
        allName[50]=(TextView)findViewById(R.id.bag_name50);
        allImage[51]=(ImageView)findViewById(R.id.bag_image51);
        allName[51]=(TextView)findViewById(R.id.bag_name51);
        allImage[52]=(ImageView)findViewById(R.id.bag_image52);
        allName[52]=(TextView)findViewById(R.id.bag_name52);
        allImage[53]=(ImageView)findViewById(R.id.bag_image53);
        allName[53]=(TextView)findViewById(R.id.bag_name53);
        allImage[54]=(ImageView)findViewById(R.id.bag_image54);
        allName[54]=(TextView)findViewById(R.id.bag_name54);
        allImage[55]=(ImageView)findViewById(R.id.bag_image55);
        allName[55]=(TextView)findViewById(R.id.bag_name55);
        allImage[56]=(ImageView)findViewById(R.id.bag_image56);
        allName[56]=(TextView)findViewById(R.id.bag_name56);
        allImage[57]=(ImageView)findViewById(R.id.bag_image57);
        allName[57]=(TextView)findViewById(R.id.bag_name57);
        allImage[58]=(ImageView)findViewById(R.id.bag_image58);
        allName[58]=(TextView)findViewById(R.id.bag_name58);
        allImage[59]=(ImageView)findViewById(R.id.bag_image59);
        allName[59]=(TextView)findViewById(R.id.bag_name59);
        allImage[60]=(ImageView)findViewById(R.id.bag_image60);
        allName[60]=(TextView)findViewById(R.id.bag_name60);
        allImage[61]=(ImageView)findViewById(R.id.bag_image61);
        allName[61]=(TextView)findViewById(R.id.bag_name61);
        allImage[62]=(ImageView)findViewById(R.id.bag_image62);
        allName[62]=(TextView)findViewById(R.id.bag_name62);
        allImage[63]=(ImageView)findViewById(R.id.bag_image63);
        allName[63]=(TextView)findViewById(R.id.bag_name63);
        allImage[64]=(ImageView)findViewById(R.id.bag_image64);
        allName[64]=(TextView)findViewById(R.id.bag_name64);
        allImage[65]=(ImageView)findViewById(R.id.bag_image65);
        allName[65]=(TextView)findViewById(R.id.bag_name65);
        allImage[66]=(ImageView)findViewById(R.id.bag_image66);
        allName[66]=(TextView)findViewById(R.id.bag_name66);
        allImage[67]=(ImageView)findViewById(R.id.bag_image67);
        allName[67]=(TextView)findViewById(R.id.bag_name67);
        allImage[68]=(ImageView)findViewById(R.id.bag_image68);
        allName[68]=(TextView)findViewById(R.id.bag_name68);
        allImage[69]=(ImageView)findViewById(R.id.bag_image69);
        allName[69]=(TextView)findViewById(R.id.bag_name69);
        allImage[70]=(ImageView)findViewById(R.id.bag_image70);
        allName[70]=(TextView)findViewById(R.id.bag_name70);
        allImage[71]=(ImageView)findViewById(R.id.bag_image71);
        allName[71]=(TextView)findViewById(R.id.bag_name71);
        allImage[72]=(ImageView)findViewById(R.id.bag_image72);
        allName[72]=(TextView)findViewById(R.id.bag_name72);
        allImage[73]=(ImageView)findViewById(R.id.bag_image73);
        allName[73]=(TextView)findViewById(R.id.bag_name73);
        allImage[74]=(ImageView)findViewById(R.id.bag_image74);
        allName[74]=(TextView)findViewById(R.id.bag_name74);
        allImage[75]=(ImageView)findViewById(R.id.bag_image75);
        allName[75]=(TextView)findViewById(R.id.bag_name75);
        allImage[76]=(ImageView)findViewById(R.id.bag_image76);
        allName[76]=(TextView)findViewById(R.id.bag_name76);
        allImage[77]=(ImageView)findViewById(R.id.bag_image77);
        allName[77]=(TextView)findViewById(R.id.bag_name77);
        allImage[78]=(ImageView)findViewById(R.id.bag_image78);
        allName[78]=(TextView)findViewById(R.id.bag_name78);
        allImage[79]=(ImageView)findViewById(R.id.bag_image79);
        allName[79]=(TextView)findViewById(R.id.bag_name79);
        allImage[80]=(ImageView)findViewById(R.id.bag_image80);
        allName[80]=(TextView)findViewById(R.id.bag_name80);
        allImage[81]=(ImageView)findViewById(R.id.bag_image81);
        allName[81]=(TextView)findViewById(R.id.bag_name81);
        allImage[82]=(ImageView)findViewById(R.id.bag_image82);
        allName[82]=(TextView)findViewById(R.id.bag_name82);
        allImage[83]=(ImageView)findViewById(R.id.bag_image83);
        allName[83]=(TextView)findViewById(R.id.bag_name83);
        allImage[84]=(ImageView)findViewById(R.id.bag_image84);
        allName[84]=(TextView)findViewById(R.id.bag_name84);
        allImage[85]=(ImageView)findViewById(R.id.bag_image85);
        allName[85]=(TextView)findViewById(R.id.bag_name85);
        allImage[86]=(ImageView)findViewById(R.id.bag_image86);
        allName[86]=(TextView)findViewById(R.id.bag_name86);
        allImage[87]=(ImageView)findViewById(R.id.bag_image87);
        allName[87]=(TextView)findViewById(R.id.bag_name87);
        allImage[88]=(ImageView)findViewById(R.id.bag_image88);
        allName[88]=(TextView)findViewById(R.id.bag_name88);
        allImage[89]=(ImageView)findViewById(R.id.bag_image89);
        allName[89]=(TextView)findViewById(R.id.bag_name89);
        allImage[90]=(ImageView)findViewById(R.id.bag_image90);
        allName[90]=(TextView)findViewById(R.id.bag_name90);
        allImage[91]=(ImageView)findViewById(R.id.bag_image91);
        allName[91]=(TextView)findViewById(R.id.bag_name91);
        allImage[92]=(ImageView)findViewById(R.id.bag_image92);
        allName[92]=(TextView)findViewById(R.id.bag_name92);
        allImage[93]=(ImageView)findViewById(R.id.bag_image93);
        allName[93]=(TextView)findViewById(R.id.bag_name93);
        allImage[94]=(ImageView)findViewById(R.id.bag_image94);
        allName[94]=(TextView)findViewById(R.id.bag_name94);
        allImage[95]=(ImageView)findViewById(R.id.bag_image95);
        allName[95]=(TextView)findViewById(R.id.bag_name95);
        allImage[96]=(ImageView)findViewById(R.id.bag_image96);
        allName[96]=(TextView)findViewById(R.id.bag_name96);
        allImage[97]=(ImageView)findViewById(R.id.bag_image97);
        allName[97]=(TextView)findViewById(R.id.bag_name97);
        allImage[98]=(ImageView)findViewById(R.id.bag_image98);
        allName[98]=(TextView)findViewById(R.id.bag_name98);
        allImage[99]=(ImageView)findViewById(R.id.bag_image99);
        allName[99]=(TextView)findViewById(R.id.bag_name99);


        int[] ownedID=UserPO.getOwnedId();
        for(int i=0;i<ownedID.length;i++){
           allImage[ownedID[i]].setBackgroundResource(ItemMap.Id2RID.get(ownedID[i]));
            allName[ownedID[i]].setText(ItemMap.Id2Name.get(ownedID[i])+"("+UserPO.itembag.get(ownedID[i])+")");
        }












    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_recyle);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_recyle);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
