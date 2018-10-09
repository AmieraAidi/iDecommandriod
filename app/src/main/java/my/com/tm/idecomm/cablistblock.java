package my.com.tm.idecomm;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class cablistblock extends AppCompatActivity  implements ListView.OnItemClickListener{


    private ProgressDialog loading;

    private ListView listView;
    EditText editext;
    Button btnsearch,back;

    ;
    private String JSON_STRING;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_total_sites);
        listView = (ListView) findViewById(R.id.list);

        listView.setOnItemClickListener(this);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(),Ipmsansite.class));
                finish();
            }
        });

        getJSON();

    }

    private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList  <HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray("cablist");

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String a = jo.getString("STATE");
                String b = jo.getString("total");


                HashMap<String,String> employees = new HashMap<>();
                employees.put("STATE",a);
                employees.put("total",b);


                list.add(employees);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                getApplicationContext(), list, R.layout.totalpstnsite,
                new String[]{"STATE","total"},

                new int[]{R.id.satu, R.id.dua});

        listView.setAdapter(adapter);

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
                String s = rh.sendGetRequest(Config.URL_IPMSANBlocklist);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Intent intent = new Intent(getApplicationContext(), ListTotalBlockPerState.class);
        HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
        String empId = map.get("STATE").toString();
        intent.putExtra("STATE", empId);

        Context context = getApplicationContext();
        CharSequence text = empId;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        startActivity(intent);
    }


}
