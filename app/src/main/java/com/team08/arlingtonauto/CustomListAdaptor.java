package com.team08.arlingtonauto;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class CustomListAdaptor extends ArrayAdapter<SearchCarDbModel> {
    private List<SearchCarDbModel> l = new ArrayList<SearchCarDbModel>();
    private Context mContext;


    public CustomListAdaptor(@NonNull Context context, int resource, @SuppressLint("SupportAnnotationUsage") @LayoutRes List<SearchCarDbModel> list) {
        super(context, 0, list);
        mContext = context;
        l = list;
    }

    //@androidx.annotation.NonNull
    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView,  @NonNull ViewGroup parent) {

            View listviewRow = convertView;
            if (listviewRow == null)
                listviewRow = LayoutInflater.from(mContext).inflate(R.layout.listview_row, parent, false);
            SearchCarDbModel searchCarDbModel = l.get(position);
            ImageView imageView = (ImageView) listviewRow.findViewById(R.id.imageView);
            imageView.setImageResource(searchCarDbModel.getCarImage());
            TextView carName = (TextView) listviewRow.findViewById(R.id.textView_carName);

            carName.setText(searchCarDbModel.getCarName());
            TextView capacity = (TextView) listviewRow.findViewById(R.id.textView_capacity);
            try {
                capacity.setText(Integer.toString(searchCarDbModel.getCapacity()));
            }
            catch (Exception e){
                e.printStackTrace();
            }
            TextView carBasePrice = (TextView) listviewRow.findViewById(R.id.textView_carBasePrice);
            carBasePrice.setText(searchCarDbModel.getCarBasePrice());
            return listviewRow;

    }

}
