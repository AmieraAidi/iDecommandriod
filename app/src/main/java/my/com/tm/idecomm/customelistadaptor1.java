package my.com.tm.idecomm;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe on 1/25/2016.
 */
public class customelistadaptor1 extends ArrayAdapter implements Filterable {

    private List<listmodel> ttmodellist;
    private List<listmodel> orig;
    private int resource;
    private LayoutInflater inflator;

    public customelistadaptor1(Context context, int resource, List<listmodel> objects) {
        super(context, resource, objects);

        ttmodellist = objects;
        this.resource = resource;
        inflator = (LayoutInflater)getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }



    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<listmodel> results = new ArrayList<listmodel>();
                if (orig == null)
                    orig = ttmodellist;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final listmodel g : orig) {
                            if (g.getCABINET().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                            else if (g.getSTATE().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                            else if(g.getSTATUS().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);

                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          Filter.FilterResults results) {
                ttmodellist = (ArrayList<listmodel>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return ttmodellist.size();
    }

    @Override
    public Object getItem(int position) {
        return ttmodellist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            convertView = inflator.inflate(resource,null);
        }


        TextView STATE;
        TextView CABINET;
        TextView STATUS;

        STATE = (TextView) convertView.findViewById(R.id.satu);
        CABINET = (TextView) convertView.findViewById(R.id.dua);
        STATUS = (TextView) convertView.findViewById(R.id.tiga);

        STATE.setText(ttmodellist.get(position).getSTATE());
        CABINET.setText(ttmodellist.get(position).getCABINET());
        STATUS.setText(ttmodellist.get(position).getSTATUS());

//        ttmodellist.get(position).getSTATE()
//        if(ttmodellist.get(position).getAgingint()>24){
//
//            convertView.setBackgroundColor(Color.RED);
//        }else{
//
//            convertView.setBackgroundColor(Color.DKGRAY);
//        }

        return convertView;
    }
}