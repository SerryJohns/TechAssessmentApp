package com.serionz.communityhealthproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.serionz.communityhealthproject.R;
import com.serionz.communityhealthproject.adapters.ChildListAdapter;
import com.serionz.communityhealthproject.model.Child;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.serionz.communityhealthproject.Constants.KEY_AGE;
import static com.serionz.communityhealthproject.Constants.KEY_FIRST_NAME;
import static com.serionz.communityhealthproject.Constants.KEY_LAST_NAME;
import static com.serionz.communityhealthproject.Constants.KEY_WEIGHT;

public class ChildListActivity extends AppCompatActivity {

    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.child_list_recycler_view)
    RecyclerView mRecyclerView;

    private List<Child> mChildList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_list);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initUI();
        initListeners();
    }

    private void initUI() {
        mChildList = new ArrayList<Child>() {{
            add(new Child("John", "Paul", 12, 45));
            add(new Child("Martin", "Morty", 16, 75));
            add(new Child("Walker", "Jones", 11, 25));
            add(new Child("Peter", "Paul", 8, 15));
            add(new Child("Bruce", "Lee", 11, 35));
            add(new Child("Michael", "Jordan", 7, 65));
        }};

        ChildListAdapter mChildListAdapter = new ChildListAdapter(mChildList, new ChildListAdapter.OnItemClickListener() {
            @Override
            public void onChildClicked(Child child) {
                onChildClick(child);
            }
        });

        mRecyclerView.setAdapter(mChildListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void onChildClick(Child child) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_FIRST_NAME, child.getFirstName());
        bundle.putString(KEY_LAST_NAME, child.getLastName());
        bundle.putInt(KEY_AGE, child.getAge());
        bundle.putInt(KEY_WEIGHT, child.getWeight());

        Intent childDetailsIntent = new Intent(getApplicationContext(), ChildDetailsActivity.class);
        childDetailsIntent.putExtras(bundle);
        startActivity(childDetailsIntent);
    }


    private void initListeners() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChildDetailsActivity.class));
            }
        });
    }

}
