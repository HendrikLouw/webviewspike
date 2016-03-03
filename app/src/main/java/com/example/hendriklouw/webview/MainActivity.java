package com.example.hendriklouw.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// http://developer.android.com/reference/android/webkit/WebView.html
// http://stackoverflow.com/questions/21378169/best-approach-to-pass-data-from-web-view-to-native-app-windows-ios-android
// http://stackoverflow.com/questions/11752052/passing-data-from-java-class-to-web-view-html
// http://developer.android.com/reference/android/webkit/WebView.html
// http://developer.android.com/reference/android/webkit/WebViewClient.html#onPageStarted

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final WebView browser = new WebView(this);
        browser.loadUrl("http://slashdot.org/");
        browser.getSettings().setJavaScriptEnabled(true);

        browser.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d("Mainactivity", url);
            }
        });
        setContentView(browser);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
