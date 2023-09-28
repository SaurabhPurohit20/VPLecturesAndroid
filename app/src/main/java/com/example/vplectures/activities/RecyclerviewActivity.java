package com.example.vplectures.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vplectures.R;
import com.example.vplectures.adapters.MyRecyclerViewAdapter;
import com.example.vplectures.models.Student;

import java.util.ArrayList;

public class RecyclerviewActivity extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;
    ArrayList<Student> names = new ArrayList<>();

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        rv = findViewById(R.id.rv);

//        for (int i = 0; i < 25; i++) {
//            names.add(new Student((i + 1) + "", "Android " + i));
//        }

        names.add(new Student(1 + "", "BASE", "2008-09-23"));
        names.add(new Student(2 + "", "BASE_1_1", "2009-02-09"));//
        names.add(new Student(14 + "", "Upside Down Cake", "06-09.2023"));

//        1.5 3 CUPCAKE 2009-04-27
//        1.6 4 DONUT 2009-09-15
//        2.0 5 ECLAIR 2009-10-26
//        2.0.1 6 ECLAIR_0_1 2009-12-03
//        2.1.x 7 ECLAIR_MR1 2010-01-12
//        2.2.x 8 FROYO 2010-05-20
//        2.3 9 GINGERBREAD 2010-12-06
//        2.3.3 10 GINGERBREAD_MR1 2011-02-09
//        3.0.x 11 HONEYCOMB 2011-02-22
//        3.1.x 12 HONEYCOMB_MR1 2011-05-10        3.2.x 13 HONEYCOMB_MR2 2011-07-15
//        4.0 14 ICE_CREAM_SANDWICH 2011-10-18
//        4.0.3 15 ICE_CREAM_SANDWICH_MR1 2011-12-16
//        4.1 16 JELLY_BEAN 2012-07-09
//        4.2 17 JELLY_BEAN_MR1 2012-11-13
//        4.3 18 JELLY_BEAN_MR2 2013-07-24
//        4.4 19 KITKAT 2013-10-31
//        4.4W 20 KITKAT_WATCH 2014-06-25
//        5.0 21 LOLLIPOP 2014-11-12
//        5.1 22 LOLLIPOP_MR1 2015-03-09
//        6.0 23 M (Marshmallow) 2015-10-05
//        7.0 24 N (Nougat) 2016-08-22
//        7.1 25 N_MR1 (Nougat MR1) 2016-10-04
//        8.0 26 O (Developer Preview 4) 2017-07-24

        adapter = new MyRecyclerViewAdapter(this, names);
//        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }
}