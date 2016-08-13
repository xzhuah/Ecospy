package com.hkust.xinyu.cameraonback;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*这个Activity 主要实现图像读取，以及两种浮窗的信息交互功能*/
/*两种浮窗的接口函数为public 函数，其他private函数可忽略 */
/*样式设置不在这里进行*/
public class MainActivity extends AppCompatActivity {
    private Camera mCamera;
    private CameraPreview mPreview;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create an instance of Camera
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);


        Button captureButton = (Button) findViewById(R.id.button_capture);
        captureButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // get an image from the camera
                        //mCamera.takePicture(null, null, mPicture);


                       //showAMessage(200,200,"<h2>Ecospy</h2><br><p>Click <a href=\"http://www.google.com\">here</a></p>");
                        verifyDialog("\"Recyclable<br>Recyclable at rate 59%<br>Globle production 180 million/year<br>\"","Item Name");
                    }
                }
        );



    }

    /** Check if this device has a camera */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /** A safe way to get an instance of the Camera object. */
    private static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {
        //Sent data to online server here

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

            File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
            if (pictureFile == null){
                Log.d("TAG", "Error creating media file, check storage permissions: ");
                return;
            }

            try {
                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
                Log.d("TAG", "File not found: " + e.getMessage());
            } catch (IOException e) {
                Log.d("TAG", "Error accessing file: " + e.getMessage());
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
      //  releaseCamera();              // release the camera immediately on pause event
    }



    private void releaseCamera(){
        if (mCamera != null){
            mCamera.release();        // release the camera for other applications
            mCamera = null;
        }
    }


    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
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


        Toast  toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.LEFT | Gravity.TOP, x, y);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

       /*toast = Toast.makeText(getApplicationContext(),
                text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.LEFT | Gravity.TOP, x, y);
        toast.show();*/

    }

    /**
     *
     * @param htmlContent html 格式内容
     * @param titleText html 格式标题
     */
    private void verifyDialog(String htmlContent,String titleText)
    {


        final Dialog dialog = new Dialog(MainActivity.this, R.style.popupDialog);
        dialog.setContentView(R.layout.verify_dialog);

        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);


        TextView message = (TextView)dialog.getWindow().findViewById(R.id.messageTxt);
        TextView title=(TextView)dialog.getWindow().findViewById(R.id.messageTitle);
        title.setText(Html.fromHtml(titleText));
        //htmlContent="Recyclable<br>Recyclable at rate 59%<br>Globle production 180 million/year<br>";
        message.setText(Html.fromHtml(htmlContent));

        Button okBtn = (Button)dialog.getWindow().findViewById(R.id.dismissBtn);


        okBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        if(dialog!=null && !dialog.isShowing())
        {
            dialog.show();
        }
    }

}
