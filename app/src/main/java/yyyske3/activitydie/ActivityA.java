package yyyske3.activitydie;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityA extends AppCompatActivity {

    private static final String TAG = ActivityA.class.getSimpleName();

    private LinearLayout mRootLayout;
    private TextView mTextTitle;
    private EditText mEtTest;
    private Button mBtnTest;
    private Button mBtnShow;

    private int mTapCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Log.d(TAG, "onCreate - saveInstance" + (savedInstanceState != null ? "あり" : "なし"));
//        Log.d(TAG, (savedInstanceState != null ? savedInstanceState.toString() : ""));

        setContentView(R.layout.activity_a);

        mRootLayout = (LinearLayout) findViewById(R.id.activity_a);
        mTextTitle = (TextView) findViewById(R.id.tv_title);

        mEtTest = (EditText) findViewById(R.id.et_test);
        mBtnTest = (Button) findViewById(R.id.btn_count_up);
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTapCount++;
            }
        });
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityA.this, String.valueOf(mTapCount), Toast.LENGTH_SHORT).show();
            }
        });

        if (savedInstanceState != null) {
            int tapCount = savedInstanceState.getInt("tap_count");
            mTapCount = tapCount;
        }

        if (savedInstanceState != null) {
            mTextTitle.setText("Activityは一度死にました・・");
            mRootLayout.setBackgroundColor(Color.parseColor("#770000"));
        } else {
            mTextTitle.setText("Activityは死んでません");
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("tap_count", mTapCount);
//        Log.d(TAG, "onSaveInstanceState");
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Log.d(TAG, "onRestoreInstanceState");
//    }

}
