package mduashisharchit.org.mdu;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends ActionBarActivity {
    WebView mWebView;
    String regNo = "12mrcef0421", js;
    String rNo = "6456274";
    int flag = 0;


    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

/*
        Intent intent = getIntent();
        regNo = intent.getStringExtra("regNo");
        regNo = intent.getStringExtra("rNo");
*/

        progress = new ProgressDialog(this);
        progress.setMessage("Downloading Your Result");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setCancelable(false);
        // progress.setProgress(0);
        progress.show();
        String uu = "http://result.mdurtk.in/postexam/result.aspx";
        executeResult(uu);
        Log.d("TAG: ", "Called uu");
       // executeResult(js);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("Result");


        /////////////////////////////////////CHEDA CHHADI NI IDHR AB UPR KRO SAB////////////////////////////////////////////////
        js = "javascript:" + "\n" +
                "firstStep();\n" +
                "\n" +
                "function firstStep(){\n" +
                "\tif(!(document.getElementById('cmdbtnProceed'))){\n" +
                "\tsetTimeout(function(){\n" +
                "\t\tfirstStep();\n" +
                "\t\t}, 2500);\n" +
                "\t}\n" +
                "\telse{\n" +
                "\t\tdocument.getElementById('txtRegistrationNo').value = '" + regNo + "';\n" +
                "\t\tdocument.getElementById('txtRollNo').value = '" + rNo + "';\n" +
                "\t\tdocument.getElementById('cmdbtnProceed').click();\n" +
                "\t\tsecondStep();\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "function secondStep(){\n" +
                "\tif(!(document.getElementById('imgComfirm'))){\n" +
                "\tsetTimeout(function(){\n" +
                "\t\tsecondStep();\n" +
                "\t\t}, 2500);\n" +
                "\t}\n" +
                "\telse{\n" +
                "\t\tdocument.getElementById('imgComfirm').click();\n" +
                "\t\tthirdStep();\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "function thirdStep(){\n" +
                "\tif(!(document.getElementById('rptMain_ctl01_lnkView'))){\n" +
                "\tsetTimeout(function(){\n" +
                "\t\tthirdStep();\n" +
                "\t\t}, 2500);\n" +
                "\t}\n" +
                "\telse{\n" +
                "\t\tdocument.getElementById('rptMain_ctl01_lnkView').click();\n" +
                "\t\tfourthStep();\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "function fourthStep(){\n" +
                "\tif(!(document.getElementById('btnPrint'))){\n" +
                "\tsetTimeout(function(){\n" +
                "\t\tfourthStep();\n" +
                "\t\t}, 2500);\n" +
                "\t}\n" +
                "\telse\n" +
                "\t{\n" +
                "\t\tvar s = document.getElementsByTagName('table')[2];\n" +
                "\t\tvar pleft = document.getElementById('divResultNoticeBoard');\n" +
                "\t\twhile(pleft.firstChild){\n" +
                "\t\tpleft.removeChild(pleft.firstChild);\n" +
                "\t\t}\n" +
                "\t\tvar pnlMain = document.getElementById('pnlMain');\n" +
                "\t\twhile(pnlMain.firstChild){\n" +
                "\t\tpnlMain.removeChild(pnlMain.firstChild);\n" +
                "\t\t}\n" +
                "\t\tpnlMain.appendChild(s);\n" +
                "\t\tAndroid.showView();\n" +
                "\tvoid(0)" +
                "\t}\n" +
                "}\n";
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }


    public void executeResult(String uu) {


        mWebView = (WebView) findViewById(R.id.webView3);
        //mWebView.setWebChromeClient(new MyWebViewClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        mWebView.setVisibility(View.INVISIBLE);

        try {
            mWebView.loadUrl(uu);
            mWebView.setWebChromeClient(new WebChromeClient()
            {
                @Override
                public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                    progress.hide();
                    return super.onJsAlert(view, url, message, result);
                }
            });
            mWebView.setWebViewClient(new WebViewClient() {


                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    Log.d("TAG: ", "onpage start, url=" + url);
                }


                @Override
                public void onPageFinished(WebView view, String url) {

                    Log.d("TAG: ", "onpage finsihed, url=" + url);
                    if(flag == 0) {
                        flag++;
                        Log.d("TAG: ", "Before Calling js");
                        executeResult(js);
                        //mWebView.setVisibility(View.VISIBLE);
                        Log.d("TAG: ", "Called js");
                        //progress.hide();
                        Log.d("TAG: ", "Hide progress");
                    }
                    super.onPageFinished(mWebView, url);
                }
            });
        }
         catch (Exception e) {
            Log.e("RESULT: ", "exception");
        }
        Log.d("TAG: ", "above return 1");

    }

    public class WebAppInterface {
        Context mContext;

        /**
         * Instantiate the interface and set the context
         */

        WebAppInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void showView() {
            Log.d("TAG:", "showview");
            //Toast.makeText(mContext, "toast", Toast.LENGTH_SHORT).show();
            Main2Activity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mWebView.setVisibility(View.VISIBLE);
                    progress.hide();
                }
            });

            Log.d("TAG:", "showview2");
        }
    }
}