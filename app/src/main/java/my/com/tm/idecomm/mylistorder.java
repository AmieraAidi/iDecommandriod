package my.com.tm.idecomm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class mylistorder extends Fragment implements View.OnClickListener  {

    private ListView listView;
    EditText editext;
    Button back;


    View myView;
    private String JSON_STRING;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.undermaintenance, container, false);

        back = (Button) myView.findViewById(R.id.back);
        back.setOnClickListener(this);


        return myView;
    }


    @Override
    public void onClick(View view) {

        if(view == back) {
            getActivity().finish();
            //startActivity(new Intent(getApplication(), MainActivity.class));
        }

    }
}
