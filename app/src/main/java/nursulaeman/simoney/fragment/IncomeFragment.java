package nursulaeman.simoney.fragment;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Date;
import java.util.Locale;

import nursulaeman.simoney.R;
import nursulaeman.simoney.validation.DatepickIncome;

/**
 * Created by nur on 13/10/16.
 */
public class IncomeFragment extends Fragment {

    public static IncomeFragment newInstance() {
        return new IncomeFragment();
    }

    private EditText et_description, et_amount, et_date;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_income, container, false);

        et_description = (EditText) rootView.findViewById(R.id.et_des_income);
        et_amount = (EditText) rootView.findViewById(R.id.et_amo_income);
        et_date = (EditText) rootView.findViewById(R.id.et_date_income);
        et_date.setText(getDateTime());

        et_date.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment picker = new DatepickIncome();
                picker.setCancelable(false);
                picker.show(getActivity().getSupportFragmentManager(), "DatePicker");
            }
        });

        return rootView;
    }

    public String getDateTime() {
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
                "dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

}
