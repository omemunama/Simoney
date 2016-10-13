package nursulaeman.simoney.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nursulaeman.simoney.R;

/**
 * Created by nur on 13/10/16.
 */
public class ExpensesFragment extends Fragment {

    public static ExpensesFragment newInstance() {
        return new ExpensesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_expenses, container, false);

        return rootView;
    }

}
