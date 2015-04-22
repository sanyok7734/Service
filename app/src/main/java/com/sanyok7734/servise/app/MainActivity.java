package com.sanyok7734.servise.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    TextView textView, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume() {
        stopService(new Intent(this, MyService.class));
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("SANO", "onPause");
        startService(new Intent(this, MyService.class));
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
