package com.serionz.communityhealthproject.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.serionz.communityhealthproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.serionz.communityhealthproject.Constants.KEY_AGE;
import static com.serionz.communityhealthproject.Constants.KEY_FIRST_NAME;
import static com.serionz.communityhealthproject.Constants.KEY_LAST_NAME;
import static com.serionz.communityhealthproject.Constants.KEY_WEIGHT;

public class ChildDetailsActivity extends AppCompatActivity {

    @BindView(R.id.txt_first_name)
    TextInputEditText mFirstname;
    @BindView(R.id.txt_last_name)
    TextInputEditText mLastname;
    @BindView(R.id.txt_age)
    TextInputEditText mAge;
    @BindView(R.id.txt_weight)
    TextInputEditText mWeight;
    @BindView(R.id.save_btn)
    Button mSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_details);
        ButterKnife.bind(this);
        unitUI();
        initSaveBtn();
    }

    private void unitUI() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String firstname = bundle.getString(KEY_FIRST_NAME);
            String lastname = bundle.getString(KEY_LAST_NAME);
            Integer weight = bundle.getInt(KEY_WEIGHT);
            Integer age = bundle.getInt(KEY_AGE);

            mFirstname.setText(firstname);
            mLastname.setText(lastname);
            mWeight.setText(Integer.toString(weight));
            mAge.setText(Integer.toString(age));
        } else {
            mFirstname.setEnabled(true);
            mLastname.setEnabled(true);
            mWeight.setEnabled(true);
            mAge.setEnabled(true);
            mSaveBtn.setVisibility(View.VISIBLE);
        }
    }

    private void initSaveBtn() {
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Child Created", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
