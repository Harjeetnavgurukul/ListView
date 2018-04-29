package com.example.groceryapp.listview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;
import static android.os.Build.VERSION_CODES.O;


public class MainActivity extends AppCompatActivity {
    ListView lv;
    Button dialog_ListView;


    private int PaintFlag;


    private void showAlertDialog() {
        ListView listView = new ListView(this);
    }

    String[] grocery_list = {"Rice", "Dal", "Vegetables", "Spices"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaintFlag = 0;

        lv = (ListView) findViewById(R.id.ListView);
        dialog_ListView = (Button) findViewById(R.id.button);


        final ArrayAdapter<String> grocery = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grocery_list);
        lv.setAdapter(grocery);


        //Setting onClickListener on ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                TextView item = (TextView) view;
                if (PaintFlag == 0) {
                    item.setPaintFlags(item.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    PaintFlag = 1;

                } else {
                    item.setPaintFlags(item.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    PaintFlag = 0;

                }
                //set onclickListener on dialog box
                dialog_ListView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder AlertButton=new AlertDialog.Builder(MainActivity.this);
                        AlertButton.setTitle("Grocery List");
                        AlertButton.setMessage("Make Your Grocery List");

                        final EditText input = new EditText(MainActivity.this);
                        AlertButton.setView(input);
                        AlertButton.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String value = input.getText().toString();

                            }
                        });

                        AlertButton.setCancelable(false);
                        AlertButton.show();
                    }


                       });

                    }
                });
            }

    }
