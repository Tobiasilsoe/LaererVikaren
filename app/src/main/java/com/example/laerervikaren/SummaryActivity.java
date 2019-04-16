package com.example.laerervikaren;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity  extends BaseActivity {

    TextView tvName;
    TextView tvDescription;
    TextView tvTitle;
    TextView tvUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvName = findViewById(R.id.tvName);
        tvDescription = findViewById(R.id.tvDescription);
        tvTitle = findViewById(R.id.tvTitle);
        tvUrl = findViewById(R.id.tvUrl);

        Intent intent = getIntent();

        tvName.setText(intent.getStringExtra(Constants.NAME_KEY));
        tvDescription.setText(intent.getStringExtra(Constants.DESCRIPTION_KEY));
        tvTitle.setText(intent.getStringExtra(Constants.TITLE_KEY));
        tvUrl.setText(intent.getStringExtra(Constants.URL_KEY));

        Log.i(Constants.TAG, "SummaryActivity onCreate");

        ((Button) findViewById(R.id.btnBack)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Constants.TAG, "SummaryActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Constants.TAG, "SummaryActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Constants.TAG, "SummaryActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Constants.TAG, "SummaryActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Constants.TAG, "SummaryActivity onDestroy");
    }


    private void finishActivity() {
        finish();
    }
}