package com.example.mostofa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class HpiWebsiteActivity extends AppCompatActivity {
public WebView mywebView;
    ProgressBar pbar;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hpi_website);
        mywebView = (WebView)findViewById(R.id.webView1);
        pbar = (ProgressBar)findViewById(R.id.progressBar1);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView.loadUrl("http://hpi.gov.bd/");
        mywebView.setWebViewClient(new  HpiWebsiteActivity .WebViewClient());
    }

    public class WebViewClient extends android.webkit.WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            pbar.setVisibility(View.VISIBLE);

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {

            // TODO Auto-generated method stub

            super.onPageFinished(view, url);
            pbar.setVisibility(View.GONE);

        }

    }


}