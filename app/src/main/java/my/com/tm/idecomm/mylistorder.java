package my.com.tm.idecomm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class mylistorder extends AppCompatActivity implements View.OnClickListener  {

    private ListView listView;
    EditText editext;
    Button back;


    View myView;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.undermaintenance);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        if(view == back) {
            finish();
            //startActivity(new Intent(getApplication(), MainActivity.class));
        }

    }
}
