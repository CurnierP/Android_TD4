package com.pierrecurnier.android_td4_curnier;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

/**
 * Created by rr612094 on 26/09/2016.
 */
public class NumberPickerFragment extends Fragment implements NumberPicker.OnValueChangeListener {


    String d;
    OnActionListener MyListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_number_picker, null);
        NumberPicker picker = (NumberPicker) v.findViewById(R.id.numberPicker);

        picker.setMinValue(1);
        picker.setMaxValue(9);
        picker.setOnValueChangedListener(this);

        return v;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            MyListener = (OnActionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnActionListener");
        }
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        MyListener.onAction(Integer.toString(picker.getValue()));
    }

    // Container Activity must implement this kind of interface
    public interface OnActionListener {
       void onAction(String d);
    }

}
