package com.example.vplectures.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vplectures.R;
import com.example.vplectures.adapters.CustomAdapter;
import com.example.vplectures.models.ListModel;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {
    ListView list;
    CustomAdapter adapter;
    public CustomListViewActivity CustomListView = null;
    public ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        CustomListView = this;

        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setListData();

        Resources res = getResources();
        list = (ListView) findViewById(R.id.list);  // List defined in XML ( See Below )

        /**************** Create Custom Adapter *********/
        adapter = new CustomAdapter(CustomListView, CustomListViewValuesArr, res);
        list.setAdapter(adapter);
    }

    /****** Function to set data in ArrayList *************/
    public void setListData() {
        for (int i = 0; i < 21; i++) {
            final ListModel sched = new ListModel();

            /******* Firstly take data in model object ******/
            sched.setCompanyName("Company " + i);
            sched.setImage("image" + i);
            sched.setUrl("http:\\www." + i + ".com");

            /******** Take Model Object in ArrayList **********/
            CustomListViewValuesArr.add(sched);
        }
    }

    /*****************  This function used by adapter ****************/
    public void onItemClick(int mPosition) {
        ListModel tempValues = (ListModel) CustomListViewValuesArr.get(mPosition);

        // SHOW ALERT
        Toast.makeText(CustomListView, "" + tempValues.getCompanyName() + "Image:" + tempValues.getImage() + " Url:" + tempValues.getUrl(), Toast.LENGTH_LONG).show();
    }
}