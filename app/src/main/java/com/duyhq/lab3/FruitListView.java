package com.duyhq.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FruitListView extends AppCompatActivity {
    ListView fruitListView;
    ArrayList<Fruit> fruitList = new ArrayList<>();

    FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list_view);

        fruitListView = findViewById(R.id.fruit_list_view);
        fruitList.add(new Fruit("Gomu Gomu no mi", "Một trái ác quỷ tối " +
                "thượng thuộc hệ zoan thần thoại, mang đến cho cơ thể của " +
                "người sử dụng có khả năng và đặc tính hoạt động của cao su, " +
                "khiến người dùng trở thành một thần nika",
                R.drawable.gomu_gomu_no_mi));

        fruitList.add(new Fruit("Bara Bra no mi", "Bara Bara no Mi thuộc hệ Paramecia cho phép người sử dụng miễn nhiễm với các đòn tấn công chém và có thể phân tách cơ thể ra làm nhiều khúc, và điều khiến từng khúc cơ thể đó tùy ý.",
                R.drawable.bara_bara_no_mi));

        fruitAdapter = new FruitAdapter(this, R.layout.fruit_item, fruitList);

        fruitListView.setAdapter(fruitAdapter);
    }
}