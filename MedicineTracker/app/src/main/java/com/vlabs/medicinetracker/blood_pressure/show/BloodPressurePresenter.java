package com.vlabs.medicinetracker.blood_pressure.show;

import android.os.Bundle;

import com.vlabs.medicinetracker.db.BloodPressureMeasurement;
import com.vlabs.medicinetracker.db.BloodPressureMeasurementModel;
import com.vlabs.medicinetracker.units.domain.BloodPressure;
import com.vlabs.medicinetracker.units.domain.MeasurementItem;

/**
 * Created by vlad on 3/28/16.
 */
public class BloodPressurePresenter {

    private final BloodPressureView mView;

    private final BloodPressureMeasurementModel mModel;

    private BloodPressureAdapter mAdapter;

    public BloodPressurePresenter(BloodPressureView view) {
        mView = view;
        mModel = new BloodPressureMeasurementModel(); // TODO: inject dependency
        mAdapter = new BloodPressureAdapter(mModel, mModel.loadAll(),mView);
    }

    public void onCreate(final Bundle savedInstanceState) {
        mView.loadMeasurements(mAdapter);
    }

    public void handleOnAddClicked() {
        mView.showAddItemDialog();
    }

    public void onAddItem(final MeasurementItem<BloodPressure> measurementItem) {
        mAdapter.addItem(mModel.save(measurementItem));
    }

    public boolean onLongClick(final int position) {
        return false;
    }

    public void onClick(final int position) {
        final BloodPressureMeasurement item = mAdapter.getItemByPosition(position);
        mView.showEditDialogForItem(item);
    }

    public void onUpdateItem(final BloodPressureMeasurement originalItem, final MeasurementItem<BloodPressure> updates) {
        mAdapter.update(originalItem, updates);
    }
}
