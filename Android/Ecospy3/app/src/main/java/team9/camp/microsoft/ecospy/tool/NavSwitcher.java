package team9.camp.microsoft.ecospy.tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import team9.camp.microsoft.ecospy.main.MainActivity;
import team9.camp.microsoft.ecospy.QuitMain;
import team9.camp.microsoft.ecospy.R;
import team9.camp.microsoft.ecospy.RecyleMain;
import team9.camp.microsoft.ecospy.ShareMain;
import team9.camp.microsoft.ecospy.game.GameMain;

/**
 * Created by Xinyu on 8/23/2016.
 */
public class NavSwitcher implements View.OnClickListener {
    Context context;

    int currentCls;
    public NavSwitcher(Context context,int currentCls){
        this.context=context;

        this.currentCls=currentCls;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1_1:
            case R.id.btn2_1:
            case R.id.btn3_1:
            case R.id.btn4_1:
            case R.id.btn5_1:

                if(currentCls!=1){
                    context.startActivity(new Intent(context, MainActivity.class));
                    ((Activity)context).finish();
                }

                break;
            case R.id.btn1_2:
            case R.id.btn2_2:
            case R.id.btn3_2:
            case R.id.btn4_2:
            case R.id.btn5_2:

                if(currentCls!=2){
                    context.startActivity(new Intent(context, GameMain.class));
                    ((Activity)context).finish();
                }

                break;
            case R.id.btn1_3:
            case R.id.btn2_3:
            case R.id.btn3_3:
            case R.id.btn4_3:
            case R.id.btn5_3:

                if(currentCls!=3){
                    context.startActivity(new Intent(context, ShareMain.class));
                    ((Activity)context).finish();
                }

                break;
            case R.id.btn1_4:
            case R.id.btn2_4:
            case R.id.btn3_4:
            case R.id.btn4_4:
            case R.id.btn5_4:

                if(currentCls!=4){
                    context.startActivity(new Intent(context, RecyleMain.class));
                    ((Activity)context).finish();
                }

                break;

            case R.id.btn1_5:
            case R.id.btn2_5:
            case R.id.btn3_5:
            case R.id.btn4_5:
            case R.id.btn5_5:

                if(currentCls!=5){
                    context.startActivity(new Intent(context, QuitMain.class));
                    ((Activity)context).finish();
                }

                break;

            default:
                break;
        }
    }
}
