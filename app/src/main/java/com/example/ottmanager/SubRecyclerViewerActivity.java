package com.example.ottmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class SubRecyclerViewerActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private CardRecyclerViewAdapter cardRecyclerViewAdapter;
    private ArrayList<Subscription> subscriptionArrayList;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_recycler_viewer);

        subscriptionArrayList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(this);

        Subscription s1 = new Subscription("hee",100,20, "hello");
        Subscription s2 = new Subscription("wwwhello", 41,24,"www");

        Subscription s3 = new Subscription("1234o", 234,2444,"www");
        Subscription s4 = new Subscription("5678ello", 34,22324,"www");

        subscriptionArrayList.add(s1);
        subscriptionArrayList.add(s2);
        subscriptionArrayList.add(s3);
        subscriptionArrayList.add(s4);


        recyclerView = findViewById(R.id.recView);
        cardRecyclerViewAdapter = new CardRecyclerViewAdapter(subscriptionArrayList);
        recyclerView.setAdapter(cardRecyclerViewAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
//                Toast.makeText(getBaseContext(), "on Move", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                Toast.makeText(getBaseContext(), "on Swiped ", Toast.LENGTH_SHORT).show();
                //Remove swiped item from list and notify the RecyclerView
                // TODO Implement Delete
//                int position = viewHolder.getAdapterPosition();
//                arrayList.remove(position);
//                adapter.notifyDataSetChanged();

            }
        };
    }
}