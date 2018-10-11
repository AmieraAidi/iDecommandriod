package my.com.tm.idecomm;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.content.ContentValues.TAG;

public class Ipmsansite extends Fragment implements View.OnClickListener  {

    private ListView listView;
    EditText editext;
    Button btnsearch;
    Button test;
    Button back;

    View myView;
    private String JSON_STRING;

    private  String total;
    private String totalBlock;
    RequestQueue rq;
    Button totalcabinet;
    Button totalBlockNis;



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.ipmsan);
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            myView = inflater.inflate(R.layout.ipmsan, container, false);
        // setTheme(Constant.theme);



//        back = (Button) findViewById(R.id.back);
//        back.setOnClickListener(this);

//        Toolbar mActionBar = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            mActionBar = (Toolbar) findViewById(R.id.toolbar);
//        }
//
//        mActionBar.setBackgroundColor(Color.parseColor("#80000000"));
         ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.maroon_colorPrimary)));


        totalcabinet =(Button) myView.findViewById(R.id.totalcabinetbtn);
//        completeDecomm =(Button) findViewById(R.id.completeDecommbtn);
        totalBlockNis =(Button) myView.findViewById(R.id.inprogress);
//        totalApproved =(Button) findViewById(R.id.totalApprovedbtn);
//        totalCabApproved =(Button) findViewById(R.id.totalCabApprovedbtn);
//        totalPlinthRecovered =(Button) findViewById(R.id.totalPlinthRecoveredbtn);
//
//

        totalBlockNis.setOnClickListener(this);
        totalcabinet.setOnClickListener(this);

        rq = Volley.newRequestQueue(getActivity());
        sendrequest1();

        return myView;

    }


    public void sendrequest1(){
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest
                (Request.Method.GET,Config.URL_IPMSAN , null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            total = response.getString("totalcab");
//                            completed = response.getString(" ");
                            totalBlock = response.getString("totalcab_block");
//                            approve = response.getString("totalApproved");
//                            dismantle = response.getString("totalCabApproved");
//                            plinth = response.getString("totalPlinthReco
//
//                            completeDecomm.setText(completed);
                            totalcabinet.setText(total);
                            totalBlockNis.setText(totalBlock);
//                            totalApproved.setText(inprogress);
//                            totalCabApproved.setText(remain);
//                            totalPlinthRecovered.setText(moneys);


//                    int x=Integer.parseInt(totalpstn.getText().toString());
//                    int y=Integer.parseInt(complete.getText().toString());
//                    int z=x-y;
//                    String zstr = String.valueOf(z);
//                    remaining.setText(zstr);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        rq.add(jsonObjectRequest);
    }



    @Override
    public void onClick(View view) {

        Fragment fragment = null;
        if(view == back) {

            startActivity(new Intent(getActivity(), MainActivity.class));


        }

        if(view == totalBlockNis) {
            //finish();
//            startActivity(new Intent(getActivity(), cablistblock.class));
            fragment = new cablistblock();
        }

        if(fragment != null){
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

    }
}
