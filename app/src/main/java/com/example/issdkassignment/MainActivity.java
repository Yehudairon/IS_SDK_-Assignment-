package com.example.issdkassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialListener;

public class MainActivity extends AppCompatActivity implements InterstitialListener {

    private Button mInterstitialLoadButton;
    private Button mInterstitialShowButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntegrationHelper.validateIntegration(this);
        mInterstitialLoadButton = (Button) findViewById(R.id.btnLoad);
        mInterstitialLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IronSource.loadInterstitial();
            }
        });
        mInterstitialShowButton = (Button) findViewById(R.id.btnShow);
        mInterstitialShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IronSource.isInterstitialReady()) {
                    //show the interstitial
                    IronSource.showInterstitial();
                }
            }
        });
        mInterstitialShowButton.setEnabled(false);
        IronSource.setInterstitialListener(this);
        IronSource.init(this, "85460dcd");

    }
    protected void onResume() {
        super.onResume();
        IronSource.onResume(this);
    }
    protected void onPause() {
        super.onPause();
        IronSource.onPause(this);
    }

    @Override
    public void onInterstitialAdReady() {
        mInterstitialShowButton.setEnabled(true);

    }

    @Override
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {

    }

    @Override
    public void onInterstitialAdOpened() {

    }

    @Override
    public void onInterstitialAdClosed() {

    }

    @Override
    public void onInterstitialAdShowSucceeded() {

    }

    @Override
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {

    }

    @Override
    public void onInterstitialAdClicked() {

    }
}