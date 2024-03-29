package com.codeslayers.hack.travelcheap;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by mukulsoftwap on 10/2/2016.
 */

public class FareListActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView_Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farelist);
        Bundle extras = getIntent().getExtras();
        Route fareData= (Route) extras.getSerializable("key");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecyclerView_Adapter adapter = new RecyclerView_Adapter(this, fareData.getSteps());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
