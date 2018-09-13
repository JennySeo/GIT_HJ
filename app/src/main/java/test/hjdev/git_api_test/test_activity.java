package test.hjdev.git_api_test;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class test_activity extends Activity{

    TextView mTitleText;
    TextView mDesText;
    TextView mCntText;
    ImageView mAvatarImg;
    ToastMessageHandler mHandler;

    protected void onCreate(Bundle savedInstanceState) {
        setContentView( R.layout.recycle_list_item );
        super.onCreate( savedInstanceState );
        drawItem();
        mHandler = new ToastMessageHandler();
    }
    void drawItem(){
        mTitleText = (TextView) findViewById( R.id.twTitle );
        mDesText = (TextView) findViewById( R.id.twDetail );
        mCntText = (TextView) findViewById( R.id.twCount);
        mAvatarImg = (ImageView) findViewById( R.id.ivAvartar );


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/users/jakewharton/repos")
                .build();
      // Response response = client.newCall(request).execute();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // ... check for failure using `isSuccessful` before proceeding

                // Read data on the worker thread
                final String responseData = response.body().string();

                // Run view-related code back on the main thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //TextView myTextView = (TextView) findViewById(R.id.myTextView);
                        mTitleText.setText(responseData);
                    }
                });
            }
        });
    }
    private class AppTask extends AsyncTask<String, Void, Void> {


        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }
    }
    class ToastMessageHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    break;
            }
        }
    }

}
