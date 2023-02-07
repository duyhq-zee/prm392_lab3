package com.duyhq.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter  extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Fruit> fruitList;

    public FruitAdapter(Context context, int layout, List<Fruit> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(layout, null);

        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView nameTextView = convertView.findViewById(R.id.name_tv);
        TextView descriptionTextView = convertView.findViewById(R.id.description_tv);

        Fruit f = fruitList.get(position);

        imageView.setImageResource(f.getImage());
        nameTextView.setText(f.getName());
        descriptionTextView.setText(f.getDescription());

        return convertView;
    }
}
