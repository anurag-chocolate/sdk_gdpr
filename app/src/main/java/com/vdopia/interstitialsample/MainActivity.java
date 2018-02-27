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
    TextView STRING;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        CLICK=(Button) findViewById(R.id.button);
        //CLICK=(Button) findViewById();
        STRING=(TextView) findViewById(R.id.textView4);
        CLICK.setVisibility(View.VISIBLE);
        STRING.setVisibility(View.INVISIBLE);
        prefetch();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void prefetch(){
        LVDOAdRequest adRequest = new LVDOAdRequest(this);
        LVDORewardedAd.prefetch(this, "EnP5f4", adRequest);

    }
    public void click(View v){

        Toast.makeText(getBaseContext(), "To mainactivity2", Toast.LENGTH_SHORT).show();
        Intent toy=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(toy);
        //calling show ad method
        //mInterstitialAd.show();
       // mRewardedAd.setRewardAdListener(this);
       //mRewardedAd.showRewardAd("JK69GBeXDtYOldrZ", "Chocolate1", "coin", "30");
        //mRewardedAd.showRewardAd("JK69GBeXDtYOldrZ", "Chocolate1", "coin", "30");
        loadRewarded();
        /*try {
            mRewardedAd.showRewardAd("JK69GBeXDtYOldrZ", "Chocolate1", "coin", "30");
        } catch(com.vdopia.ads.lw.ChocolateAdException e){
            Log.e("SouravTest", "show failed ",e);
        }*/


    }
    @Override
    public void onPermissionsGranted(int requestCode) {

    }

    private void loadRewarded() {
        //mRewardedAd = LVDORewardedAd.getInstance();
        mRewardedAd = new LVDORewardedAd(this, "EnP5f4", this);
        LVDOAdRequest adRequest = new LVDOAdRequest(this);

        //ArrayList<LVDOConstants.PARTNERS> mPartnerNames = new ArrayList<>();
        //LVDOConstants.PARTNERS partner = (LVDOConstants.PARTNERS) this.getIntent().getSerializableExtra(LVDOConstants.PARTNERS.ALL.toString());
        //LVDOConstants.PARTNERS partner= LVDOConstants.PARTNERS.ALL;
        //mPartnerNames.add(partner);
        //adRequest.setPartnerNames(mPartnerNames);
        adRequest.setDmaCode("807");
        adRequest.setEthnicity("Asian");
        adRequest.setPostalCode("110096");
        adRequest.setCurrPostal("201301");
        adRequest.setDmaCode("807");
        adRequest.setAge("27");
        //adRequest.setMaritalStatus("single");
        adRequest.setGender(LVDOAdRequest.LVDOGender.MALE);
        //adRequest.setBirthday(Utils.getDate());

        adRequest.setRequester("Vdopia");
        //adRequest.setAppBundle("chocolateApp");
        adRequest.setAppDomain("vdopia.com");
        //adRequest.setAppName("VdopiaSampleApp");
        adRequest.setAppStoreUrl("play.google.com");
        adRequest.setCategory("Education");
        adRequest.setPublisherDomain("vdopia.com");
        //mRewardedAd.fetchRewardAd(this,"qZPI8O", adRequest,this);
        //mRewardedAd.fetchRewardAd(this,"4vwFOd", adRequest,this);
        mRewardedAd.loadAd(adRequest);
        Toast.makeText(getBaseContext(), "LOAD AD event called", Toast.LENGTH_SHORT).show();

    }

    /*@Override
    public void onInterstitialLoaded(LVDOInterstitialAd interstitialAd) {
        Log.d(TAG, "Interstitial Loaded");
        //mInterstitialAd.show();
        CLICK.setVisibility(View.VISIBLE);
        STRING.setVisibility(View.INVISIBLE);
       // mInterstitialAd.show();
        mRewardedAd.setRewardAdListener(this);
        mRewardedAd.showRewardAd("jq4glYbZqSRYB0Oz", "Chocolate1", "coin", "30");
    }
*/
    @Override
    public void onRewardedVideoLoaded(LVDORewardedAd rewardedAd){
        //\\mRewardedAd.setAdRequest(adRequest);
        Log.d(TAG, "onRewardedVideoLoaded");
        //CLICK.setVisibility(View.VISIBLE);
        //STRING.setVisibility(View.INVISIBLE);
        try {
            mRewardedAd.showRewardAd("JK69GBeXDtYOldrZ", "Chocolate1", "coin", "30");
        } catch(com.vdopia.ads.lw.ChocolateAdException e){
            Log.e("SouravTest", "show failed ",e);
        }


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
