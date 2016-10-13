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
public class IncomeFragment extends Fragment {

    public static IncomeFragment newInstance() {
        return new IncomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_income, container, false);

        return rootView;
    }

}
