package com.duyhq.lab3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class BasicListView extends AppCompatActivity {

    ListView basicLV;
    ListView indexLV;
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> indexList = new ArrayList<>();

    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list_view);

        basicLV = findViewById(R.id.basic_lv);
        indexLV = findViewById(R.id.index_lv);

        list.add("Android");
        list.add("PHP");
        list.add("iOS");
        list.add("Unity");
        list.add("ASP.NET");

        indexList.add("1.");
        indexList.add("2.");
        indexList.add("3.");
        indexList.add("4.");
        indexList.add("5.");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                list);

        ArrayAdapter indexAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                indexList);

        basicLV.setAdapter(adapter);
        indexLV.setAdapter(indexAdapter);
    }

    public void onAddButtonClicked(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        final View addPopupView =
                getLayoutInflater().inflate(R.layout.add_popup, null);

        EditText input = addPopupView.findViewById(R.id.input);
        Button addButton = addPopupView.findViewById(R.id.add_button);

        dialogBuilder.setView(addPopupView);
        dialog = dialogBuilder.create();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(0, input.getText().toString());
                indexList.add(list.size() + ".");
                input.setText("");
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void onUpdateButtonClicked(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        final View updatePopupView =
                getLayoutInflater().inflate(R.layout.update_popup, null);

        EditText input1 = updatePopupView.findViewById(R.id.input1);
        EditText input2 = updatePopupView.findViewById(R.id.input2);
        Button updateButton = updatePopupView.findViewById(R.id.update_button);

        dialogBuilder.setView(updatePopupView);
        dialog = dialogBuilder.create();

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.set(Integer.parseInt(input1.getText().toString()) - 1,
                        input2.getText().toString());

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void onDeleteButtonClicked(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        final View deletePopupView =
                getLayoutInflater().inflate(R.layout.delete_popup, null);

        EditText input = deletePopupView.findViewById(R.id.input);
        Button deleteButton = deletePopupView.findViewById(R.id.delete_button);

        dialogBuilder.setView(deletePopupView);
        dialog = dialogBuilder.create();

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(Integer.parseInt(input.getText().toString()) - 1);
                indexList.remove(indexList.size() - 1);
                input.setText("");
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}