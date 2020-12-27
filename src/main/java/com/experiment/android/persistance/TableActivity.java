package com.experiment.android.persistance;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class TableActivity extends AppCompatActivity {

    EditText base,rangeLo,rangeHi;
    Button displayTables;
    String baseInteger,loInteger,hiInteger;
    int baseNumber,lo,hi,length;

    String[] titles = {"BASE","X","RANGE","=","PRODUCT"};
    String[][] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        displayTables = (Button) findViewById(R.id.buttonInitiate);

        base = (EditText) findViewById(R.id.baseInput);
        rangeLo = (EditText) findViewById(R.id.rangeLowInput);
        rangeHi = (EditText) findViewById(R.id.rangeHighInput);

        final TableView<String[]> tableView = (TableView<String[]>) findViewById(R.id.tableView);

        //Set Prop
        tableView.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
        tableView.setColumnWeight(0,2);
        tableView.setColumnWeight(1,1);
        tableView.setColumnWeight(2,2);
        tableView.setColumnWeight(3,1);
        tableView.setColumnWeight(4,2);
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,titles));
        tableView.setColumnCount(5);

        fillTable();
        tableView.setDataAdapter(new SimpleTableDataAdapter(TableActivity.this,values));

        displayTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillTable();
                tableView.setDataAdapter(new SimpleTableDataAdapter(TableActivity.this,values));
            }
        });
    }

    public void fillTable(){
        baseInteger = base.getText().toString();
        loInteger = rangeLo.getText().toString();
        hiInteger = rangeHi.getText().toString();

        if(baseInteger.equals("")){
            baseInteger = "2";
        }
        if(loInteger.equals("")){
            loInteger = "0";
        }
        if(hiInteger.equals("")){
            hiInteger = "12";
        }
        baseNumber = Integer.parseInt(baseInteger);
        lo = Integer.parseInt(loInteger);
        hi = Integer.parseInt(hiInteger);

        length = hi - lo + 1;
        values = new String[length][5];

        for (int i=0;i<length;i++){
            values[i][0]= baseInteger;
            values[i][1]= "X";
            values[i][2]= String.valueOf(lo+i);
            values[i][3]= "=";
            values[i][4]= String.valueOf(baseNumber*(lo+i));
        }
    }

    //this stuff was for the listview attempts
    /*int baseNumber,lo,hi,length;
    String[] sbase,srange,sproduct;
    ArrayList<String> baseArray = new ArrayList<String>();

        if(baseInteger.equals("")){
        baseInteger = "2";
    }
        if(rangeLo.equals("")){
        loInteger = "0";
    }
        if(rangeHi.equals("")){
        hiInteger = "12";
    }

    baseNumber = Integer.parseInt(baseInteger);
    lo = Integer.parseInt(loInteger);
    hi = Integer.parseInt(hiInteger);

    length = hi - lo + 1;
    sbase = new String[length];
    srange = new String[length];
    sproduct = new String[length];

        for (int i=0;i<length;i++){
        sbase[i] = String.valueOf(baseNumber);
        srange[i] = String.valueOf(lo+i);
        sproduct[i] = String.valueOf(baseNumber*(lo+i));
    }

    myListView = (ListView) findViewById(R.id.listViewTable);

    TableAdapter tableAdapter = new TableAdapter(this, sbase,srange,sproduct);
        myListView.setAdapter(tableAdapter); */
}