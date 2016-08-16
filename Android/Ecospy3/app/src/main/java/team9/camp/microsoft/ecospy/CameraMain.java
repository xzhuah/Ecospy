package team9.camp.microsoft.ecospy;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/*这个Activity 主要实现图像读取，以及两种浮窗的信息交互功能*/
/*两种浮窗的接口函数为public 函数，其他private函数可忽略 */
/*样式设置不在这里进行*/
public class CameraMain extends AppCompatActivity {
    private Camera mCamera;
    private CameraPreview mPreview;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    public static byte data[];
    public static String result;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_main);
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
                        mCamera.autoFocus(null);
                        mCamera.takePicture(null, null, mPicture);


                        //showAMessage(200,200,"<h2>Ecospy</h2><br><p>Click <a href=\"http://www.google.com\">here</a></p>");

                    }
                }
        );


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * Check if this device has a camera
     */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /**
     * A safe way to get an instance of the Camera object.
     */
    private static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        } catch (Exception e) {
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
    private ProgressDialog pd;
    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            pd.dismiss();
            verifyDialog("", result.substring(9,result.length()-3).replace("\",\"description\":\"","<br><br>"));

        }
    };
    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {
        //Sent data to online server here

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            CameraMain.data=data;

            /*File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
            if (pictureFile == null){
                Log.d("TAG", "Error creating media file, check storage permissions: ");
                return;
            }*/


            //FileOutputStream fos = new FileOutputStream(pictureFile);
            pd=ProgressDialog.show(CameraMain.this,"Load","Loading");
            new Thread(){
                public void run(){
                    CameraMain.result = PictureUploader.formUpload("http://192.168.43.82:5678/Ecospy/servlet/main", CameraMain.data);
                    myHandler.sendEmptyMessage(0);
                }
            }.start();




            /*
            if (mCamera != null) {
                mCamera.setPreviewCallback(null);
                mCamera.stopPreview();
                mCamera.release();
                mCamera = null;
            }
            mCamera = getCameraInstance();

            // Create our Preview view and set it as the content of our activity.
            mPreview = new CameraPreview(CameraMain.this, mCamera);
            FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
            preview.addView(mPreview);
            preview.refreshDrawableState();*/
            /*fos.write(data);
            fos.close();*/

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        releaseCamera();              // release the camera immediately on pause event
    }

    @Override
    protected void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CameraMain Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://team9.camp.microsoft.ecospy/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        releaseCamera();              // release the camera immediately on pause event
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseCamera();              // release the camera immediately on pause event
    }


    private void releaseCamera() {
        if (mCamera != null) {
            mCamera.release();        // release the camera for other applications
            mCamera = null;
        }
    }


    private static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /**
     * Create a File for saving an image or video
     */
    private static File getOutputMediaFile(int type) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + timeStamp + ".jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }

    /**
     * @param x    信息窗口x 坐标
     * @param y    信息窗口y 坐标
     * @param text 信息窗口内容（简单html格式）
     */
    public void showAMessage(int x, int y, String text) {
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

    /**
     * @param htmlContent html 格式内容
     * @param titleText   html 格式标题
     */
    private void verifyDialog(String htmlContent, String titleText) {


        final Dialog dialog = new Dialog(CameraMain.this, R.style.popupDialog);
        dialog.setContentView(R.layout.verify_dialog);

        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);


        TextView message = (TextView) dialog.getWindow().findViewById(R.id.messageTxt);
        TextView title = (TextView) dialog.getWindow().findViewById(R.id.messageTitle);
        title.setText(Html.fromHtml(titleText));
        //htmlContent="Recyclable<br>Recyclable at rate 59%<br>Globle production 180 million/year<br>";
        message.setText(Html.fromHtml(htmlContent));

        Button okBtn = (Button) dialog.getWindow().findViewById(R.id.dismissBtn);
        Button recycle = (Button) dialog.getWindow().findViewById(R.id.recycleBtn);
        recycle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                    CameraMain.this.finish();

                }
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                    Intent intent = new Intent(CameraMain.this, CameraMain.class);
                    startActivity(intent);
                    CameraMain.this.finish();

                }
            }
        });
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CameraMain Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://team9.camp.microsoft.ecospy/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }
}
