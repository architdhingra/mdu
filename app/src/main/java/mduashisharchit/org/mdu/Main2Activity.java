package mduashisharchit.org.mdu;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Main2Activity extends ActionBarActivity {
    WebView mWebView;
    String regNo = "12mrcef0421";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mWebView = (WebView) findViewById(R.id.webView3);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        try {
            mWebView.loadUrl("http://result.mdurtk.in/postexam/result.aspx");
            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(mWebView, url);

                    //Toast.makeText(getApplicationContext(), "yoo!", Toast.LENGTH_SHORT).show();
                    //mWebView.loadUrl("javascript:" + "document.getElementById('txtRegistrationNo').value = '12mrcef0421';document.getElementById('txtRollNo').value = '6456274';document.getElementById('cmdbtnProceed').click(); if()document.getElementById('imgComfirm').click();setTimeout(function(){document.getElementById('rptMain_ctl01_lnkView').click(); }, 10000);setTimeout(function(){var s = document.getElementsByTagName('table')[2];var myNode = document.getElementById(\"form1\");while (myNode.firstChild) { myNode.removeChild(myNode.firstChild);}document.getElementById(\"form1\").appendChild(s);},15000);void(0);");
                    mWebView.loadUrl("javascript:" + "\n" +
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
                            "\t\tdocument.getElementById('txtRollNo').value = '6456274';\n" +
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
                            "\t\tvoid(0);\n" +
                            "\t}\n" +
                            "}\n");
                    //mWebView.loadUrl("javascript:window.HTMLOUT.processHTML('<body>'+document.getElementsByTagName('table')[0].innerHTML+'</body>');");
                }
            });
        }
        catch (Exception e){
            Log.e("RESULT: ", "exception");
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
