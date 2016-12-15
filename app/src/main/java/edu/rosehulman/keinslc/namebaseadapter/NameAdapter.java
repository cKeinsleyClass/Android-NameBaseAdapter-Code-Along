package edu.rosehulman.keinslc.namebaseadapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by keinslc on 12/12/2016.
 */

public class NameAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mNames;
    private Random mRandom;

    public NameAdapter(Context context) {
        mContext = context;
        mNames = new ArrayList<>();
        mRandom = new Random();
        // Starting with 5 names
        for (int i = 0; i < 5; i++) {
            mNames.add(getRandomName());
        }
    }

    private String getRandomName() {
        String[] names = new String[]{
                "Hannah", "Emily", "Sarah", "Madison", "Brianna",
                "Kaylee", "Kaitlyn", "Hailey", "Alexis", "Elizabeth",
                "Michael", "Jacob", "Matthew", "Nicholas", "Christopher",
                "Joseph", "Zachary", "Joshua", "Andrew", "William"
        };
        return names[mRandom.nextInt(names.length)];
    }


    @Override
    // Number of items in the list, called automatically
    public int getCount() {
        return mNames.size();
    }

    // Not called unless you do it
    @Override
    public Object getItem(int i) {
        return null;
    }

    // Not called unless you do it
    @Override
    public long getItemId(int i) {
        return 0;
    }

    // Called automatically when inflated
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = null;
        if (convertView == null) {
            // We have to make it
            view = LayoutInflater.from(mContext).inflate(R.layout.row_view, viewGroup, false);
        } else {
            // Reuse it
            view = convertView;
        }
        // Customize the view
        TextView nameView = (TextView) view.findViewById(R.id.name_view);
        nameView.setText(mNames.get(position));
        TextView positionView = (TextView) view.findViewById(R.id.position_view);
        positionView.setText("I'm #" + position);

        return view;
    }

    public void addName() {
        mNames.add(getRandomName());
        notifyDataSetChanged();
    }

    public void removeName(int position){
        mNames.remove(position);
        notifyDataSetChanged();
    }
}
