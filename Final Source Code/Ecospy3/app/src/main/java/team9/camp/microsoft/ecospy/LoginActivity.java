package team9.camp.microsoft.ecospy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo", "12345"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        ImageView logo = (ImageView) findViewById(R.id.imageView);
        mPasswordView = (EditText) findViewById(R.id.password);
        /*mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });*/

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click","Clicking");
                myLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);


        PictureUploader.context=this;
        FileIO.context=this;


    }
    private ProgressDialog pd2;
    Handler myHandler2 = new Handler() {
        public void handleMessage(Message msg) {

            pd2.dismiss();
            UserPO.userID=userID;
            UserPO.itembag=UserPO.getItemList(returnStr);
            Log.d("Click","Json:"+UserPO.getJson());
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);

        }
    };

    private ProgressDialog pd;
    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            if(returnStr.contains("userID")){
                userID=returnStr.substring(returnStr.indexOf("ID")+5,returnStr.indexOf("ID")+11);
                Log.d("Click","UserID:"+userID);

                pd.dismiss();

                pd2=ProgressDialog.show(LoginActivity.this, "Success", "Loading...");
                new Thread(){
                    public void run(){
                        Log.d("Click","ResponceWait2:"+userID);
                        returnStr=PictureUploader.load(UserPO.server,userID);
                        Log.d("Click","Responce:"+returnStr);
                        myHandler2.sendEmptyMessage(0);
                    }
                }.start();

            }else{
                pd.dismiss();
                Toast.makeText(LoginActivity.this,"Password is Incorrect",Toast.LENGTH_SHORT).show();
            }



        }
    };
    private static String returnStr="";
    private static String userID="";
    private void myLogin(){
        pd=ProgressDialog.show(LoginActivity.this,"Load","Checking...");
        new Thread(){
            public void run(){
                Log.d("Click","ResponceWait:"+mEmailView.getText().toString()+" "+mPasswordView.getText().toString());
                returnStr=PictureUploader.login(UserPO.server,mEmailView.getText().toString(),mPasswordView.getText().toString());
               Log.d("Click","Responce:"+returnStr);
                myHandler.sendEmptyMessage(0);
            }
        }.start();
//        String email = mEmailView.getText().toString();
//        String password = mPasswordView.getText().toString();
//        Log.d("Click","I is "+email+" "+password);

      //  String i=PictureUploader.login("http://192.168.155.2:5678/Ecospy/servlet/main",email,password);

    }
    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {




        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            Log.d("","Hello1");
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return true;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */


    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            Log.d("","Hello2");
            String res="";
            try {
                // Simulate network access.
              res= PictureUploader.login("http://192.168.155.2:5678/Ecospy/servlet/main",mEmail,mPassword);
                Log.d("","Responce is "+res);

            } catch (Exception e) {
                return false;
            }


            if(res.contains("user_ID")){
                String userID=res.substring(res.indexOf("ID:")+3,res.lastIndexOf("}"));
                Log.d("String","Login:"+userID);
                return true;
            }else{
                return false;
            }


            // TODO: register the new account here.

        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;

            if (success) {
                finish();
            } else {
                Log.d("","ErrorPass");
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
    }
}

