package com.vlabs.medicinetracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vlabs.medicinetracker.sections.SectionItem;
import com.vlabs.medicinetracker.sections.SectionsAdapter;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SectionsAdapter.SectionItemClickListener {

    @Bind(R.id.sections)
    RecyclerView mSections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final GridLayoutManager lm = new GridLayoutManager(this, getResources().getInteger(R.integer.sections_rows_count));
        mSections.setLayoutManager(lm);
        mSections.setHasFixedSize(true);
        mSections.setAdapter(new SectionsAdapter(Arrays.asList(SectionItem.values()), this));
    }

    @Override
    public void onSectionItemClicked(final SectionItem item) {
        startActivity(item.getIntentFactory().createIntent(this));
    }
}
