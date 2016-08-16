package team9.camp.microsoft.ecospy;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

    private ImageButton btn11,btn12,btn13,btn21,btn22,btn23,btn31,btn32,btn33,rst1,rst2;
    private TextView num1,num2;
    private View.OnClickListener itemList=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            int item=-1;
            switch (v.getId()){
                case R.id.btn1_1:
                    item=0;
                    break;
                case R.id.btn1_2:
                    item=1;
                    break;
                case R.id.btn1_3:
                    item=2;
                    break;
                case R.id.btn2_1:
                    item=3;
                    break;
                case R.id.btn2_2:
                    item=4;
                    break;
                case R.id.btn2_3:
                    item=5;
                    break;
                case R.id.btn3_1:
                    item=6;
                    break;
                case R.id.btn3_2:
                    item=7;
                    break;
                case R.id.btn3_3:
                    item=8;
                    break;
                case R.id.result1:
                    break;
                case R.id.result2:
                    break;

            }
            showList(item);
        }
    };
    private void showList(int item){
        int a[]={1,2,3};
        verifyDialog(item,a);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_game);
        setSupportActionBar(toolbar);



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

        btn11=(ImageButton)findViewById(R.id.gamebtn_11); btn12=(ImageButton)findViewById(R.id.gamebtn_12); btn13=(ImageButton)findViewById(R.id.gamebtn_13);
        btn21=(ImageButton)findViewById(R.id.gamebtn_21); btn22=(ImageButton)findViewById(R.id.gamebtn_22); btn23=(ImageButton)findViewById(R.id.gamebtn_23);
        btn31=(ImageButton)findViewById(R.id.gamebtn_31); btn32=(ImageButton)findViewById(R.id.gamebtn_32); btn33=(ImageButton)findViewById(R.id.gamebtn_33);

        rst1=(ImageButton)findViewById(R.id.result1); rst2=(ImageButton)findViewById(R.id.result2);
        num1=(TextView)findViewById(R.id.number1); num2=(TextView)findViewById(R.id.number2);

        btn11.setOnClickListener(itemList);
        btn12.setOnClickListener(itemList);
        btn13.setOnClickListener(itemList);
        btn21.setOnClickListener(itemList);
        btn22.setOnClickListener(itemList);
        btn23.setOnClickListener(itemList);
        btn31.setOnClickListener(itemList);
        btn32.setOnClickListener(itemList);
        btn33.setOnClickListener(itemList);


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
    /**
     *
     * @param x 信息窗口x 坐标
     * @param y 信息窗口y 坐标
     * @param text 信息窗口内容（简单html格式）
     */
    public void showAMessage(int x,int y,String text){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom,
                (ViewGroup) findViewById(R.id.llToast));
//        ImageView image = (ImageView) layout
//                .findViewById(R.id.tvImageToast);

//        TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
//        title.setText("Attention");
        TextView text1 = (TextView) layout.findViewById(R.id.tvTextToast);
        text1.setText(Html.fromHtml(text));
        text1.setMovementMethod(LinkMovementMethod.getInstance());
        //  text1.setText("完全自定义Toast");


        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.LEFT | Gravity.TOP, x, y);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

       /*toast = Toast.makeText(getApplicationContext(),
                text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.LEFT | Gravity.TOP, x, y);
        toast.show();*/

    }

    private static int tempID;
    private void verifyDialog(int item,int[] buttonlist)
    {


        final Dialog dialog = new Dialog(GameMain.this, R.style.popupDialog);
        dialog.setContentView(R.layout.itemlist);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        //ImageButton btn1_1=(ImageButton)
        ImageButton[][] buttons=new ImageButton[12][7];

        buttons[0][0]=(ImageButton)findViewById(R.id.item_11);
        buttons[0][1]=(ImageButton)findViewById(R.id.item_12);
        buttons[0][2]=(ImageButton)findViewById(R.id.item_13);
        buttons[0][3]=(ImageButton)findViewById(R.id.item_14);
        buttons[0][4]=(ImageButton)findViewById(R.id.item_15);
        buttons[0][5]=(ImageButton)findViewById(R.id.item_16);
        buttons[0][6]=(ImageButton)findViewById(R.id.item_17);
        buttons[1][0]=(ImageButton)findViewById(R.id.item_21);
        buttons[1][1]=(ImageButton)findViewById(R.id.item_22);
        buttons[1][2]=(ImageButton)findViewById(R.id.item_23);
        buttons[1][3]=(ImageButton)findViewById(R.id.item_24);
        buttons[1][4]=(ImageButton)findViewById(R.id.item_25);
        buttons[1][5]=(ImageButton)findViewById(R.id.item_26);
        buttons[1][6]=(ImageButton)findViewById(R.id.item_27);
        buttons[2][0]=(ImageButton)findViewById(R.id.item_31);
        buttons[2][1]=(ImageButton)findViewById(R.id.item_32);
        buttons[2][2]=(ImageButton)findViewById(R.id.item_33);
        buttons[2][3]=(ImageButton)findViewById(R.id.item_34);
        buttons[2][4]=(ImageButton)findViewById(R.id.item_35);
        buttons[2][5]=(ImageButton)findViewById(R.id.item_36);
        buttons[2][6]=(ImageButton)findViewById(R.id.item_37);
        buttons[3][0]=(ImageButton)findViewById(R.id.item_41);
        buttons[3][1]=(ImageButton)findViewById(R.id.item_42);
        buttons[3][2]=(ImageButton)findViewById(R.id.item_43);
        buttons[3][3]=(ImageButton)findViewById(R.id.item_44);
        buttons[3][4]=(ImageButton)findViewById(R.id.item_45);
        buttons[3][5]=(ImageButton)findViewById(R.id.item_46);
        buttons[3][6]=(ImageButton)findViewById(R.id.item_47);
        buttons[4][0]=(ImageButton)findViewById(R.id.item_51);
        buttons[4][1]=(ImageButton)findViewById(R.id.item_52);
        buttons[4][2]=(ImageButton)findViewById(R.id.item_53);
        buttons[4][3]=(ImageButton)findViewById(R.id.item_54);
        buttons[4][4]=(ImageButton)findViewById(R.id.item_55);
        buttons[4][5]=(ImageButton)findViewById(R.id.item_56);
        buttons[4][6]=(ImageButton)findViewById(R.id.item_57);
        buttons[5][0]=(ImageButton)findViewById(R.id.item_61);
        buttons[5][1]=(ImageButton)findViewById(R.id.item_62);
        buttons[5][2]=(ImageButton)findViewById(R.id.item_63);
        buttons[5][3]=(ImageButton)findViewById(R.id.item_64);
        buttons[5][4]=(ImageButton)findViewById(R.id.item_65);
        buttons[5][5]=(ImageButton)findViewById(R.id.item_66);
        buttons[5][6]=(ImageButton)findViewById(R.id.item_67);
        buttons[6][0]=(ImageButton)findViewById(R.id.item_71);
        buttons[6][1]=(ImageButton)findViewById(R.id.item_72);
        buttons[6][2]=(ImageButton)findViewById(R.id.item_73);
        buttons[6][3]=(ImageButton)findViewById(R.id.item_74);
        buttons[6][4]=(ImageButton)findViewById(R.id.item_75);
        buttons[6][5]=(ImageButton)findViewById(R.id.item_76);
        buttons[6][6]=(ImageButton)findViewById(R.id.item_77);
        buttons[7][0]=(ImageButton)findViewById(R.id.item_81);
        buttons[7][1]=(ImageButton)findViewById(R.id.item_82);
        buttons[7][2]=(ImageButton)findViewById(R.id.item_83);
        buttons[7][3]=(ImageButton)findViewById(R.id.item_84);
        buttons[7][4]=(ImageButton)findViewById(R.id.item_85);
        buttons[7][5]=(ImageButton)findViewById(R.id.item_86);
        buttons[7][6]=(ImageButton)findViewById(R.id.item_87);
        buttons[8][0]=(ImageButton)findViewById(R.id.item_91);
        buttons[8][1]=(ImageButton)findViewById(R.id.item_92);
        buttons[8][2]=(ImageButton)findViewById(R.id.item_93);
        buttons[8][3]=(ImageButton)findViewById(R.id.item_94);
        buttons[8][4]=(ImageButton)findViewById(R.id.item_95);
        buttons[8][5]=(ImageButton)findViewById(R.id.item_96);
        buttons[8][6]=(ImageButton)findViewById(R.id.item_97);
        buttons[9][0]=(ImageButton)findViewById(R.id.item_101);
        buttons[9][1]=(ImageButton)findViewById(R.id.item_102);
        buttons[9][2]=(ImageButton)findViewById(R.id.item_103);
        buttons[9][3]=(ImageButton)findViewById(R.id.item_104);
        buttons[9][4]=(ImageButton)findViewById(R.id.item_105);
        buttons[9][5]=(ImageButton)findViewById(R.id.item_106);
        buttons[9][6]=(ImageButton)findViewById(R.id.item_107);
        buttons[10][0]=(ImageButton)findViewById(R.id.item_111);
        buttons[10][1]=(ImageButton)findViewById(R.id.item_112);
        buttons[10][2]=(ImageButton)findViewById(R.id.item_113);
        buttons[10][3]=(ImageButton)findViewById(R.id.item_114);
        buttons[10][4]=(ImageButton)findViewById(R.id.item_115);
        buttons[10][5]=(ImageButton)findViewById(R.id.item_116);
        buttons[10][6]=(ImageButton)findViewById(R.id.item_117);
        buttons[11][0]=(ImageButton)findViewById(R.id.item_121);
        buttons[11][1]=(ImageButton)findViewById(R.id.item_122);
        buttons[11][2]=(ImageButton)findViewById(R.id.item_123);
        buttons[11][3]=(ImageButton)findViewById(R.id.item_124);
        buttons[11][4]=(ImageButton)findViewById(R.id.item_125);
        buttons[11][5]=(ImageButton)findViewById(R.id.item_126);
        buttons[11][6]=(ImageButton)findViewById(R.id.item_127);



        for(int i=0;i<buttonlist.length;i++){
            tempID=buttonlist[i];
            int row=tempID/7;
            int col=tempID%7+1;
            buttons[row][col].setImageResource(ItemMap.Id2RID.get(tempID));
            buttons[row][col].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((ImageButton)v).setImageResource(ItemMap.Id2RID.get(tempID));
                }
            });
        }
        if(dialog!=null && !dialog.isShowing())
        {
            dialog.show();
        }
    }
}
