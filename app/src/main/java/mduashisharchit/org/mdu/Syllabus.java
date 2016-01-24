package mduashisharchit.org.mdu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Syllabus extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalfile);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_finalfile, menu);
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
            String devPage = "devPage";
            Intent intent = new Intent(this , Syllabus.class).putExtra(Intent.EXTRA_TEXT, devPage );
            startActivity(intent);
            return true;
        }
        if(id == R.id.action_share){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Take a look at \"MDU\" - https://play.google.com/store/apps/details?id=mduashisharchit.org.mdu");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment() {
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            Intent intent = getActivity().getIntent();
            View rootView = inflater.inflate(R.layout.fragment_finalfile, container, false);
            AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

            WebView webView = (WebView) rootView.findViewById(R.id.webView);
            webView.getSettings().setJavaScriptEnabled(true);
            if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
                String finalStr = intent.getStringExtra(Intent.EXTRA_TEXT);
                switch (finalStr) {

                    case "B.techIT7TH SEMESTERDATA WAREHOUSE AND DATA MINING":
                    {
                        webView.loadUrl("file:///android_asset/DWM.html");
                    }
                    break;
                    case "B.techIT7TH SEMESTERSOFTWARE PROJECT MANAGEMENT":
                    {
                        webView.loadUrl("file:///android_asset/SPM.html");
                    }
                    break;
                    case "B.techIT7TH SEMESTERWEB ENGINEERING":
                    {
                        webView.loadUrl("file:///android_asset/WE.html");
                    }
                    break;
                    case "B.techIT7TH SEMESTERSYSTEM AND NETWORK  ADMINISTRATION":
                    {
                        webView.loadUrl("file:///android_asset/SANA.html");
                    }
                    break;
                    case "B.techIT7TH SEMESTERADVANCED JAVA":
                    {
                        webView.loadUrl("file:///android_asset/AJAVA.html");
                    }
                    break;
                    case "B.techIT7TH SEMESTERREAL TIME SYSTEM":
                    {
                        webView.loadUrl("file:///android_asset/RTS.html");
                    }
                    break;
                    case "B.techIT7TH SEMESTERDISTRIBUTED OPERATING SYSTEM":
                    {
                        webView.loadUrl("file:///android_asset/DOS.html");
                    }
                    break;
                    case "B.techIT7TH SEMESTERNETWORK SECURITY":
                    {
                        webView.loadUrl("file:///android_asset/NSM.html");
                    }
                    break;
                    case "B.techIT7TH SEMESTERHIGH SPEED NETWORKS":
                    {
                        webView.loadUrl("file:///android_asset/HSN.html");
                    }
                    break;
                    case "B.techIT7TH SEMESTERCOMPUTER SOFTWARE TESTING":
                    {
                        webView.loadUrl("file:///android_asset/CST.html");
                    }
                    break;
                    case "B.techIT7TH SEMESTERADVANCED DBMS":
                    {
                        webView.loadUrl("file:///android_asset/ADBMS.html");
                    }
                    break;



                    case "B.techIT6TH SEMESTERINTELLIGENT SYSTEMS": {
                        webView.loadUrl("file:///android_asset/IS.html");
                    }
                    break;
                    case "B.techIT6TH SEMESTEROPERATIONS RESEARCH": {
                        webView.loadUrl("file:///android_asset/OR.html");
                    }
                    break;
                    case "B.techIT6TH SEMESTERNETWORK PROGRAMMING": {
                        webView.loadUrl("file:///android_asset/NP.html");
                    }
                    break;
                    case "B.techIT6TH SEMESTERPRINCIPLE OF SOFTWARE ENGINEERING": {
                        webView.loadUrl("file:///android_asset/POSE.html");
                    }
                    break;
                    case "B.techIT6TH SEMESTERWIRELESS COMMUNICATION": {
                        webView.loadUrl("file:///android_asset/WCOM.html");
                    }

                    break;
                    case "B.techIT6TH SEMESTERWEB DEVELOPMENT": {
                        webView.loadUrl("file:///android_asset/WD.html");
                    }
                    break;




                    case "B.techIT5TH SEMESTERRAPID APPLICATION DEVELOPMENT":
                        webView.loadUrl("file:///android_asset/RAD.html");
                        break;
                    case "B.techIT5TH SEMESTERSPSA":
                        webView.loadUrl("file:///android_asset/SPSA.html");
                        break;
                    case "B.techIT5TH SEMESTERCOMPUTER NETWORKS":
                        webView.loadUrl("file:///android_asset/CN.html");
                        break;
                    case "B.techIT5TH SEMESTERMICPROCESSOR AND INTERFACING":
                        webView.loadUrl("file:///android_asset/MPI.html");
                        break;
                    case "B.techIT5TH SEMESTERCOMPUTER GRAPHICS":
                        webView.loadUrl("file:///android_asset/CG.html");
                        break;
                    case "B.techIT5TH SEMESTERPRINCIPLES OF OPERATING SYSTEM":
                        webView.loadUrl("file:///android_asset/POS.html");
                        break;


                    case "B.techIT4TH SEMESTERMULTIMEDIA TECHNOLOGIES":
                        webView.loadUrl("file:///android_asset/MMT.html");
                        break;
                    case "B.techIT4TH SEMESTERINTERNET FUNDAMENTALS":
                        webView.loadUrl("file:///android_asset/IF.html");
                        break;
                    case "B.techIT4TH SEMESTERDATABASE MANAGEMENT SYSTEM":
                        webView.loadUrl("file:///android_asset/DBMS.html");
                        break;
                    case "B.techIT4TH SEMESTERCOMPUTER ARCHITECTURE AND ORGANISATION":
                        webView.loadUrl("file:///android_asset/CAO.html");
                        break;
                    case "B.techIT4TH SEMESTEROBJECT ORIENTED PROGRAMMING":
                        webView.loadUrl("file:///android_asset/OOPS.html");
                        break;
                    case "B.techIT4TH SEMESTERMATHS3":
                        webView.loadUrl("file:///android_asset/M3.html");
                        break;



                    case "B.techIT3RD SEMESTERDIGITAL ELECTRONICS":
                        webView.loadUrl("file:///android_asset/DE.html");
                        break;
                    case "B.techIT3RD SEMESTERFUNDAMENTALS OF MANAGEMENT":
                        webView.loadUrl("file:///android_asset/FOM.html");
                        break;
                    case "B.techIT3RD SEMESTERDISCRETE STRUCTURES":
                        webView.loadUrl("file:///android_asset/DISCRETE.html");
                        break;
                    case "B.techIT3RD SEMESTERDATA STRUCTURES":
                        webView.loadUrl("file:///android_asset/DS.html");
                        break;
                    case "B.techIT3RD SEMESTERDIGITAL AND ANALOG COMMUNICATION":
                        webView.loadUrl("file:///android_asset/DAC.html");
                        break;
                    case "B.techIT3RD SEMESTERENGINEERING ECONOMICS":
                        webView.loadUrl("file:///android_asset/ECO.html");
                        break;


                    case "B.techIT2ND SEMESTERBASICS OF ELECTRONICS":
                        webView.loadUrl("file:///android_asset/BE.html");
                        break;
                    case "B.techIT2ND SEMESTERFUNDAMENTAL OF COMPUTER PROGRAMMING":
                        webView.loadUrl("file:///android_asset/FCPC.html");
                        break;
                    case "B.techIT2ND SEMESTERBASICS OF MECHANICAL ENGINEERING":
                        webView.loadUrl("file:///android_asset/BME.html");
                        break;
                    case "B.techIT2ND SEMESTERCOMMUNICATION SKILLS":
                        webView.loadUrl("file:///android_asset/COMM.html");
                        break;
                    case "B.techIT2ND SEMESTERMATHEMATICS2":
                        webView.loadUrl("file:///android_asset/M2.html");
                        break;
                    case "B.techIT2ND SEMESTERPHYSICS2":
                        webView.loadUrl("file:///android_asset/P2.html");
                        break;


                    case "B.techIT1ST SEMESTERESSENTIAL OF COMMUNICATION":
                        webView.loadUrl("file:///android_asset/EOC.html");
                        break;
                    case "B.techIT1ST SEMESTERMATHEMATICS1":
                        webView.loadUrl("file:///android_asset/M1.html");
                        break;

                    case "B.techIT1ST SEMESTERPHYSICS1":
                        webView.loadUrl("file:///android_asset/P1.html");
                        break;
                    case "B.techIT1ST SEMESTERENGINEERING CHEMISTRY":
                        webView.loadUrl("file:///android_asset/CHEM.html");
                        break;

                    case "B.techIT1ST SEMESTERELECTRICAL TECHNOLOGY":
                        webView.loadUrl("file:///android_asset/ET.html");
                        break;
                    case "B.techIT1ST SEMESTERENGINEERING DRAWING":
                        webView.loadUrl("file:///android_asset/ED.html");
                        break;
                    case "B.techIT1ST SEMESTERWORKSHOP TECHNOLOGY":
                        webView.loadUrl("file:///android_asset/WT.html");
                        break;




                    //7th sem cse
                    case "B.techCSE7TH SEMESTERADVANCED COMPUTER ARCHITECTURE":
                    {
                        webView.loadUrl("file:///android_asset/ACA.html");
                    }
                    break;
                    case "B.techCSE7TH SEMESTERSOFTWARE PROJECT MANAGEMENT":
                    {
                        webView.loadUrl("file:///android_asset/SPM.html");
                    }
                    break;
                    case "B.techCSE7TH SEMESTERCOMPILER DESIGN":
                    {
                        webView.loadUrl("file:///android_asset/CD.html");
                    }
                    break;
                    case "B.techCSE7TH SEMESTERNEURAL NETWORKS":
                    {
                        webView.loadUrl("file:///android_asset/NN.html");
                    }
                    break;
                    case "B.techCSE7TH SEMESTERADVANCED JAVA":
                    {
                        webView.loadUrl("file:///android_asset/AJAVA.html");
                    }
                    break;
                    case "B.techCSE7TH SEMESTERREAL TIME SYSTEM":
                    {
                        webView.loadUrl("file:///android_asset/RTS.html");
                    }
                    break;
                    case "B.techCSE7TH SEMESTERDISTRIBUTED OPERATING SYSTEM":
                    {
                        webView.loadUrl("file:///android_asset/DOS.html");
                    }
                    break;
                    case "B.techCSE7TH SEMESTERNETWORK SECURITY":
                    {
                        webView.loadUrl("file:///android_asset/NSM.html");
                    }
                    break;
                    case "B.techCSE7TH SEMESTERHIGH SPEED NETWORKS":
                    {
                        webView.loadUrl("file:///android_asset/HSN.html");
                    }
                    break;
                    case "B.techCSE7TH SEMESTERCOMPUTER SOFTWARE TESTING":
                    {
                        webView.loadUrl("file:///android_asset/CST.html");
                    }
                    break;
                    case "B.techCSE7TH SEMESTERADVANCED DBMS":
                    {
                        webView.loadUrl("file:///android_asset/ADBMS.html");
                    }
                    break;



                    //6th sem cse
                    case "B.techCSE6TH SEMESTERPRINCIPLE OF SOFTWARE ENGINEERING":
                    {
                        webView.loadUrl("file:///android_asset/POSE.html");
                    }
                    break;
                    case "B.techCSE6TH SEMESTERINTELLIGENT SYSTEMS":
                    {
                        webView.loadUrl("file:///android_asset/IS.html");
                    }break;

                    case "B.techCSE6TH SEMESTERADA":
                    {webView.loadUrl("file:///android_asset/ADA.html");}

                        break;
                    case "B.techCSE6TH SEMESTERCOMPUTER NETWORKS":
                    {   webView.loadUrl("file:///android_asset/CN.html");}

                        break;
                    case "B.techCSE6TH SEMESTERDIGITAL SYSTEM":

                    {webView.loadUrl("file:///android_asset/DSD.html");}

                        break;
                    case "B.techCSE6TH SEMESTERSPSA":

                    {   webView.loadUrl("file:///android_asset/SPSA.html");}

                        break;


                    //5th sem cse
                    case "B.techCSE5TH SEMESTERCOMPUTER GRAPHICS":
                        webView.loadUrl("file:///android_asset/CG.html");
                        break;
                    case "B.techCSE5TH SEMESTERTHEORY OF AUTOMATA COMPUTATION":
                        webView.loadUrl("file:///android_asset/TAC.html");
                        break;
                    case "B.techCSE5TH SEMESTERMICPROCESSOR AND INTERFACING":
                        webView.loadUrl("file:///android_asset/MPI.html");
                        break;
                    case "B.techCSE5TH SEMESTERMULTIMEDIA TECHNOLOGIES":
                        webView.loadUrl("file:///android_asset/MMT.html");
                        break;
                    case "B.techCSE5TH SEMESTERWEB DEVELOPMENT":
                        webView.loadUrl("file:///android_asset/WD.html");
                        break;
                    case "B.techCSE5TH SEMESTERPRINCIPLES OF OPERATING SYSTEM":
                        webView.loadUrl("file:///android_asset/POS.html");
                        break;





                    //4th sem cse
                    case "B.techCSE4TH SEMESTEROBJECT ORIENTED PROGRAMMING":
                        webView.loadUrl("file:///android_asset/OOPS.html");
                        break;
                    case "B.techCSE4TH SEMESTERDATABASE MANAGEMENT SYSTEM":
                        webView.loadUrl("file:///android_asset/DBMS.html");
                        break;
                    case "B.techCSE4TH SEMESTERINTERNET FUNDAMENTALS":
                        webView.loadUrl("file:///android_asset/IF.html");
                        break;
                    case "B.techCSE4TH SEMESTERCOMPUTER ARCHITECTURE AND ORGANISATION":
                        webView.loadUrl("file:///android_asset/CAO.html");
                        break;
                    case "B.techCSE4TH SEMESTERPROGRAMMING LANGUAGES":
                        webView.loadUrl("file:///android_asset/PL.html");
                        break;
                    case "B.techCSE4TH SEMESTERFUNDAMENTALS OF MANAGEMENT":
                        webView.loadUrl("file:///android_asset/FOM.html");
                        break;


                    //3rd sem cse
                    case "B.techCSE3RD SEMESTERDIGITAL ELECTRONICS":
                        webView.loadUrl("file:///android_asset/DE.html");
                        break;
                    case "B.techCSE3RD SEMESTERFUNDAMENTALS OF MANAGEMENT":
                        webView.loadUrl("file:///android_asset/FOM.html");
                        break;
                    case "B.techCSE3RD SEMESTERDISCRETE STRUCTURES":
                        webView.loadUrl("file:///android_asset/DISCRETE.html");
                        break;
                    case "B.techCSE3RD SEMESTERDATA STRUCTURES":
                        webView.loadUrl("file:///android_asset/DS.html");
                        break;
                    case "B.techCSE3RD SEMESTERDIGITAL AND ANALOG COMMUNICATION":
                        webView.loadUrl("file:///android_asset/DAC.html");
                        break;
                    case "B.techCSE3RD SEMESTERENGINEERING ECONOMICS":
                        webView.loadUrl("file:///android_asset/ECO.html");
                        break;

                    //2nd sem cse
                    case "B.techCSE2ND SEMESTERCOMMUNICATION SKILLS":
                        webView.loadUrl("file:///android_asset/COMM.html");
                        break;
                    case "B.techCSE2ND SEMESTERMATHEMATICS2":
                        webView.loadUrl("file:///android_asset/M2.html");
                        break;

                    case "B.techCSE2ND SEMESTERPHYSICS2":
                        webView.loadUrl("file:///android_asset/P2.html");
                        break;

                    case "B.techCSE2ND SEMESTERBASICS OF ELECTRONICS":
                        webView.loadUrl("file:///android_asset/BE.html");
                        break;

                    case "B.techCSE2ND SEMESTERBASICS OF MECHANICAL ENGINEERING":
                        webView.loadUrl("file:///android_asset/BME.html");
                        break;

                    case "B.techCSE2ND SEMESTERFUNDAMENTAL OF COMPUTER PROGRAMMING":
                        webView.loadUrl("file:///android_asset/FCPC.html");
                        break;




                    //1st sem cse
                    case "B.techCSE1ST SEMESTERESSENTIAL OF COMMUNICATION":
                        webView.loadUrl("file:///android_asset/EOC.html");
                        break;
                    case "B.techCSE1ST SEMESTERENGINEERING CHEMISTRY":
                        webView.loadUrl("file:///android_asset/CHEM.html");
                        break;

                    case "B.techCSE1ST SEMESTERMATHEMATICS1":
                        webView.loadUrl("file:///android_asset/M1.html");
                        break;

                    case "B.techCSE1ST SEMESTERPHYSICS1":
                        webView.loadUrl("file:///android_asset/P1.html");
                        break;

                    case "B.techCSE1ST SEMESTERELECTRICAL TECHNOLOGY":
                        webView.loadUrl("file:///android_asset/ET.html");
                        break;
                    case "B.techCSE1ST SEMESTERENGINEERING DRAWING":
                        webView.loadUrl("file:///android_asset/ED.html");
                        break;
                    case "B.techCSE1ST SEMESTERWORKSHOP TECHNOLOGY":
                        webView.loadUrl("file:///android_asset/WT.html");
                        break;

                    case "devPage":
                        //String pdfLink = "https://www.cca.edu/sites/default/files/pdf/08/word-to-pdf.pdf";
                        //webView.loadUrl("http://docs.google.com/gview?embedded=true&url=" + pdfLink);
                        webView.loadUrl("file:///android_asset/dev.html");
                        break;




                }}
            return rootView;
        }

    }
}


