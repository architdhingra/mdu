package mduashisharchit.org.mdu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }


        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        /*MenuItem item = menu.findItem(R.id.action_search);
        SearchView sv = new SearchView((getSupportActionBar().getThemedContext()));
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, sv);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
               // Log.v("CONSOLE1: ", query);
                Intent intent = new Intent(getApplicationContext(), Subject.class).putExtra(Intent.EXTRA_TEXT,query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Log.v("CONSOLE2: ", newText);
                return false;
            }
        });*/
        return super.onCreateOptionsMenu(menu);
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
       // if(id == R.id.action_search){
            //String srch = "srch";

            //Intent intent = new Intent(this, Subject.class).putExtra(Intent.EXTRA_TEXT, srch);
            //startActivity(intent);
       // }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private ArrayAdapter<String> sylAdapter;
        int i;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);


            final String[] Syllabus = {
                    "B.tech","M.tech"
            };
            List<String> listsyllabus =new ArrayList<String>(Arrays.asList(Syllabus));

            sylAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    R.layout.list_course,
                    R.id.list_course1,
                    listsyllabus
            );



            ListView listView = (ListView) rootView.findViewById(R.id.listView);
            listView.setAdapter(sylAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override

                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                        String forecast = sylAdapter.getItem(position);
                        if(forecast.equals("B.tech")) {


                            Intent intent = new Intent(getActivity(), Stream.class)
                                    .putExtra(Intent.EXTRA_TEXT, forecast);

                            startActivity(intent);
                        }
                        else {
                            //Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), Main2Activity.class);
                            startActivity(intent);
                        }
                    }
                });

            return rootView;
        }
    }
}
