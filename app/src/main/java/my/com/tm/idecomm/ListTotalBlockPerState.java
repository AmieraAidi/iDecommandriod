package my.com.tm.idecomm;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListTotalBlockPerState extends AppCompatActivity  {

    private ProgressDialog loading;

    private ListView listView;
    EditText editext;
    Button btnsearch,home,back;
    String sitestr;
    SearchView sv;

    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_total_blocked_state);

        Intent i = getIntent();
        listView = (ListView) findViewById(R.id.list);
        sitestr = i.getStringExtra("STATE");

        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), Ipmsansite.class);
                view.getContext().startActivity(Intent);}
        });

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        getJSON();
    }


    private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList  <HashMap<String, String>>();
        ArrayList<listmodel> listmodelarray = new ArrayList();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray("cablistperstate");

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String a = jo.getString("STATE");
                String b = jo.getString("CABINET");
                String c = jo.getString("CAB STATUS");
//                String d = jo.getString(Config.TAG_JEXTYPE);
//                String e = jo.getString(Config.TAG_JBUILDING);


                listmodel objectlist = new listmodel();

                objectlist.setCABINET(b);
                objectlist.setSTATE(a);
                objectlist.setSTATUS(c);

                HashMap<String,String> employees = new HashMap<>();
                employees.put("STATE",a);
                employees.put("CABINET",b);
                employees.put("CAB STATUS",c);
//                employees.put(Config.TAG_JEXTYPE,d);
//                employees.put(Config.TAG_JBUILDING,e);



                list.add(employees);
                listmodelarray.add(objectlist);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                getApplicationContext(), list, R.layout.activity_total_state,
                new String[]{"STATE","CABINET","CAB STATUS"},

                new int[]{R.id.satu, R.id.dua,R.id.tiga});

        final customelistadaptor1 adaptercustom = new customelistadaptor1(getApplicationContext(),R.layout.activity_total_state,listmodelarray);

        listView.setAdapter(adaptercustom);


        sv = (SearchView) findViewById(R.id.searchstate);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adaptercustom.getFilter().filter(newText);
                return false;
            }
        });

    }


    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
//                loading = ProgressDialog.show(getApplicationContext(),"Loading Data","Wait...",false,false);
                // loading.setIndeterminateDrawable(getResources().getDrawable(R.drawable.dashb));
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //   loading.dismiss();
                //   loading.setIndeterminateDrawable(getResources().getDrawable(R.drawable.dashb));
                JSON_STRING = s;
                //  showData();
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler3 rh = new RequestHandler3();
                String s = rh.sendGetRequest(Config.URL_IPMSANBlocklist_perstate+"?STATE="+sitestr);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }




}
