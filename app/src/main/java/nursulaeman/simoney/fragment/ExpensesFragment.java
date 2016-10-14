package nursulaeman.simoney.fragment;

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
import nursulaeman.simoney.validation.DatepickExpenses;

/**
 * Created by nur on 13/10/16.
 */
public class ExpensesFragment extends Fragment {

    public static ExpensesFragment newInstance() {
        return new ExpensesFragment();
    }

    private EditText et_description, et_amount, et_date;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_expenses, container, false);

        et_description = (EditText) rootView.findViewById(R.id.et_des_expenses);
        et_amount = (EditText) rootView.findViewById(R.id.et_amo_expenses);
        et_date = (EditText) rootView.findViewById(R.id.et_date_expenses);
        et_date.setText(getDateTime());

        et_date.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment picker = new DatepickExpenses();
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
