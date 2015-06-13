package com.s626.archery;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Vector;

public class CustomAdapter extends ArrayAdapter<ListRow6> {
    Context context;
    int layoutResourceId;

    ListRow6 currentItem;
    Vector<ListRow6> data;

    static class StringReaderHolder {
        TextView textView1, textView2, textView3, textView4, textView5,
                textView6, textView_total1, textView_total2;
    }

    public CustomAdapter(Context context, int layoutResourceId, Vector<ListRow6> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        StringReaderHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new StringReaderHolder();

            holder.textView1 = (TextView) row.findViewById(R.id.textView1);
            holder.textView2 = (TextView) row.findViewById(R.id.textView2);
            holder.textView3 = (TextView) row.findViewById(R.id.textView3);
            holder.textView4 = (TextView) row.findViewById(R.id.textView4);
            holder.textView5 = (TextView) row.findViewById(R.id.textView5);
            holder.textView6 = (TextView) row.findViewById(R.id.textView6);
            holder.textView_total1 = (TextView) row.findViewById(R.id.textView_total1);
            holder.textView_total2 = (TextView) row.findViewById(R.id.textView_total2);

            row.setTag(holder);
        } else {
            holder = (StringReaderHolder) row.getTag();
        }

        ListRow6 tmp = data.elementAt(position);
        holder.textView1.setText(tmp.firstArrow);
        holder.textView2.setText(tmp.secondArrow);
        holder.textView3.setText(tmp.thirdArrow);
        holder.textView4.setText(tmp.fourthArrow);
        holder.textView5.setText(tmp.fifthArrow);
        holder.textView6.setText(tmp.sixthArrow);
        holder.textView_total1.setText(tmp.rowTotal);
        holder.textView_total2.setText(tmp.allTotal);

        return row;
    }
}
