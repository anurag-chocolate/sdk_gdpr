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

import com.vdopia.ads.lw.Chocolate;
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
    //private LVDOInterstitialAd mInterstitialAd;
    private static final String TAG = "RewardedActivity";
    Button CLICK;
    Button Load;
    TextView STRING;

     public int flag=0;
     public int completedflag=0;
      String locale;

    LVDOAdRequest adRequestRewarded = new LVDOAdRequest(this);

   // LVDOAdRequest adRequestInt = new LVDOAdRequest(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CLICK=(Button) findViewById(R.id.button);
        Load=(Button) findViewById(R.id.button2);

        STRING=(TextView) findViewById(R.id.textView4);
        CLICK.setVisibility(View.VISIBLE);
        STRING.setVisibility(View.INVISIBLE);

        Load.setVisibility(View.INVISIBLE);
        loadRewarded();
        //prefetchInterstitial();

       /* if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            locale = getResources().getConfiguration().getLocales().get(0).getCountry();
        } else {
            locale = getResources().getConfiguration().locale.getCountry();
        }

        Log.d(TAG, "country::-"+locale);

        Chocolate.getGDPRConsentString(this);
        Chocolate.isSubjectToGDPR(this);
        Chocolate.setGDPR(this,true,"BOEFEAyOEFEAyAHBDENAIB9vABAAJA");*/
        Chocolate.setGDPR(this,false,"BOEFEAyOEFEAyAHBDENAIB9vABAAJA");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void prefetchRewarded(){


        LVDORewardedAd.prefetch(this, "0DqXTL", adRequestRewarded);

    }

   /* private void prefetchInterstitial(){

        LVDOInterstitialAd.prefetch(this,"0DqXTL", adRequestInt);


    }*/

public void loadAd(View v){
        loadRewarded();

        /*if(completedflag==2)
        {

            loadRewarded();

        }
        else if (completedflag==3){

            loadRewarded();

        }*/


}


    public void click(View v){

        Toast.makeText(getBaseContext(), "To mainactivity2", Toast.LENGTH_SHORT).show();

        showRewarded();
           /* if (flag==1)
            {

                showRewarded();

            }
            else if (flag!=1 && flag==2){


                showInterstitial();

            }*/

    }
    @Override
    public void onPermissionsGranted(int requestCode) {

    }

    private void loadRewarded() {
        //mRewardedAd = LVDORewardedAd.getInstance();
        mRewardedAd = new LVDORewardedAd(this, "0DqXTL", this);



        adRequestRewarded.setDmaCode("807");
        adRequestRewarded.setEthnicity("Asian");
        adRequestRewarded.setPostalCode("110096");
        adRequestRewarded.setCurrPostal("201301");
        adRequestRewarded.setDmaCode("807");
        adRequestRewarded.setAge("27");

        adRequestRewarded.setGender(LVDOAdRequest.LVDOGender.MALE);


        adRequestRewarded.setRequester("Vdopia");

        adRequestRewarded.setAppDomain("vdopia.com");

        adRequestRewarded.setAppStoreUrl("play.google.com");
        adRequestRewarded.setCategory("Education");
        adRequestRewarded.setPublisherDomain("vdopia.com");
        mRewardedAd.loadAd(adRequestRewarded);
        Toast.makeText(getBaseContext(), "LOAD AD event called", Toast.LENGTH_SHORT).show();

    }



    /*private void loadInterstitial() {

        //mInterstitialAd = new LVDOInterstitialAd(this, "8WeCrB", this);
        mInterstitialAd = new LVDOInterstitialAd(this, "0DqXTL", this);

        Log.d(TAG, "Method loadcalled");

        adRequestInt.setDmaCode("807");
        adRequestInt.setEthnicity("Asian");
        adRequestInt.setPostalCode("110096");
        adRequestInt.setCurrPostal("201301");
        adRequestInt.setDmaCode("807");
        adRequestInt.setAge("27");

        adRequestInt.setGender(LVDOAdRequest.LVDOGender.MALE);


        adRequestInt.setRequester("Vdopia");
        //adRequest.setAppBundle("chocolateApp");
        adRequestInt.setAppDomain("vdopia.com");
        //adRequest.setAppName("VdopiaSampleApp");
        adRequestInt.setAppStoreUrl("play.google.com");
        adRequestInt.setCategory("Education");
        adRequestInt.setPublisherDomain("vdopia.com");

        mInterstitialAd.loadAd(adRequestInt);
    }

    private  void showInterstitial() {

        try {
            mInterstitialAd.show();
        } catch(com.vdopia.ads.lw.ChocolateAdException e){
            Log.e("", "show failed ",e);
        }
    }*/
    private  void showRewarded() {
        try {
            mRewardedAd.showRewardAd("JK69GBeXDtYOldrZ", "Chocolate1", "indiancoin_"+mRewardedAd.getWinningPartnerName(), "22");
        } catch(com.vdopia.ads.lw.ChocolateAdException e){
            Log.e("SouravTest", "show failed ",e);
        }

    }


    @Override
    public void onRewardedVideoLoaded(LVDORewardedAd rewardedAd){

        Log.d(TAG, "onRewardedVideoLoaded");

flag=1;

    }


    @Override
    public void onRewardedVideoFailed(LVDORewardedAd rewardedAd, LVDOConstants.LVDOErrorCode errorCode){

        Log.d(TAG, "onRewardedVideoFailed");
        //loadInterstitial();
    }
    @Override
    public void onRewardedVideoShown(LVDORewardedAd rewardedAd){

            flag=0;
            prefetchRewarded();
        Load.setVisibility(View.INVISIBLE);
        Log.d(TAG, "Method onRewardedVideoShown");

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
        completedflag=2;
        Load.setVisibility(View.VISIBLE);
    }

    // The rewarded video ad is being dismissed. Resume / load state accordingly.
    @Override
    public void onRewardedVideoCompleted(LVDORewardedAd rewardedAd){

        Log.d(TAG, "onRewardedVideoCompleted");


    }

  /*  @Override
    public void onInterstitialLoaded(LVDOInterstitialAd interstitialAd) {

        flag=2;
        Log.d(TAG, "Method onInterstitialLoaded");

    }

    @Override
    public void onInterstitialFailed(LVDOInterstitialAd interstitialAd, LVDOConstants.LVDOErrorCode errorCode) {

        Log.d(TAG, "Method onInterstitialFailed");
    }

    @Override
    public void onInterstitialShown(LVDOInterstitialAd interstitialAd) {
        Load.setVisibility(View.INVISIBLE);
        //prefetchInterstitial();
        prefetchRewarded();

        Log.d(TAG, "Method onInterstitialShown");

    }

    @Override
    public void onInterstitialClicked(LVDOInterstitialAd interstitialAd) {


        Log.d(TAG, "Method onInterstitialClicked");
    }

    @Override
    public void onInterstitialDismissed(LVDOInterstitialAd interstitialAdl) {
        completedflag=3;
        Load.setVisibility(View.VISIBLE);

        Log.d(TAG, "Method onInterstitialDismissed");

    }
*/




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
