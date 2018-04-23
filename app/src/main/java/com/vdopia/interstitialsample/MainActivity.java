package com.vdopia.interstitialsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.vdopia.ads.lw.LVDOAdRequest;
import com.vdopia.ads.lw.LVDOConstants;
import com.vdopia.ads.lw.LVDOInterstitialAd;
import com.vdopia.ads.lw.LVDOInterstitialListener;
import com.vdopia.ads.lw.LVDORewardedAd;
import com.vdopia.ads.lw.LVDOAdRequest;
import com.vdopia.ads.lw.LVDOConstants;
import com.vdopia.ads.lw.RewardedAdListener;
import com.vdopia.ads.lw.LVDORewardedAd;

import org.w3c.dom.Text;

public class MainActivity extends RequestPermissionActivity implements RewardedAdListener {
    private LVDORewardedAd mRewardedAd;
    private static final String TAG = "RewardedActivity";
    Button CLICK;
    Button Load;
    TextView STRING;

    LVDOAdRequest adRequest = new LVDOAdRequest(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        CLICK=(Button) findViewById(R.id.button);
        Load=(Button) findViewById(R.id.button2);
        //CLICK=(Button) findViewById();
        STRING=(TextView) findViewById(R.id.textView4);
        CLICK.setVisibility(View.INVISIBLE);
        STRING.setVisibility(View.INVISIBLE);
        prefetch();
        Load.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void prefetch(){


        LVDORewardedAd.prefetch(this, "0DqXTL", adRequest);

    }

    public  void loadAd(View v){
        loadRewarded();

    }
    public void click(View v){

        Toast.makeText(getBaseContext(), "To mainactivity2", Toast.LENGTH_SHORT).show();

        try {
            mRewardedAd.showRewardAd("JK69GBeXDtYOldrZ", "Chocolate1", "indiancoin_"+mRewardedAd.getWinningPartnerName(), "22");
        } catch(com.vdopia.ads.lw.ChocolateAdException e){
            Log.e("SouravTest", "show failed ",e);
        }


    }
    @Override
    public void onPermissionsGranted(int requestCode) {

    }

    private void loadRewarded() {
        //mRewardedAd = LVDORewardedAd.getInstance();
        mRewardedAd = new LVDORewardedAd(this, "0DqXTL", this);



        adRequest.setDmaCode("807");
        adRequest.setEthnicity("Asian");
        adRequest.setPostalCode("110096");
        adRequest.setCurrPostal("201301");
        adRequest.setDmaCode("807");
        adRequest.setAge("27");

        adRequest.setGender(LVDOAdRequest.LVDOGender.MALE);


        adRequest.setRequester("Vdopia");

        adRequest.setAppDomain("vdopia.com");

        adRequest.setAppStoreUrl("play.google.com");
        adRequest.setCategory("Education");
        adRequest.setPublisherDomain("vdopia.com");
        mRewardedAd.loadAd(adRequest);
        Toast.makeText(getBaseContext(), "LOAD AD event called", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onRewardedVideoLoaded(LVDORewardedAd rewardedAd){

        Log.d(TAG, "onRewardedVideoLoaded");
        CLICK.setVisibility(View.VISIBLE);
        Load.setVisibility(View.INVISIBLE);


    }


    @Override
    public void onRewardedVideoFailed(LVDORewardedAd rewardedAd, LVDOConstants.LVDOErrorCode errorCode){

        Log.d(TAG, "onRewardedVideoFailed");
    }
    @Override
    public void onRewardedVideoShown(LVDORewardedAd rewardedAd){
        Log.d(TAG, "onRewardedVideoShown");
        prefetch();

    }

    // The rewarded video ad has failed to load. Inspect errorCode for additional information.
    @Override
    public void onRewardedVideoShownError(LVDORewardedAd rewardedAd, LVDOConstants.LVDOErrorCode errorCode){

        Log.d(TAG, "onRewardedVideoShownError");
    }

    // The rewarded video ad has been clicked. Take actions accordingly.
    @Override
    public void onRewardedVideoDismissed(LVDORewardedAd rewardedAd){
        Log.d(TAG, "onRewardedVideoDismissed");
    }

    // The rewarded video ad is being dismissed. Resume / load state accordingly.
    @Override
    public void onRewardedVideoCompleted(LVDORewardedAd rewardedAd){

        Log.d(TAG, "onRewardedVideoCompleted");
        CLICK.setVisibility(View.VISIBLE);
        Load.setVisibility(View.INVISIBLE);
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
    @Override
    protected void onDestroy() {
        if (mRewardedAd != null) {
            mRewardedAd.destroyView();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        if (mRewardedAd != null) {
            mRewardedAd.pause();
        }
        super.onPause();
    }
}
