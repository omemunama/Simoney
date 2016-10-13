package nursulaeman.simoney.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nursulaeman.simoney.R;
import nursulaeman.simoney.adapter.FragmentPagerAdapterSimoney;

/**
 * Created by nur on 13/10/16.
 */

public class TransactionFragment extends Fragment {

    public static TransactionFragment newInstance() {
        return new TransactionFragment();
    }

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transaction, container, false);

        initializeViews(rootView);

        if (viewPager != null) {
            setUpViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);
        }

        return rootView;
    }

    private void initializeViews(View rootView) {
        viewPager = (ViewPager) rootView.findViewById(R.id.pager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
    }

    private void setUpViewPager(ViewPager viewPager) {
        FragmentPagerAdapterSimoney mPagerAdapter = new FragmentPagerAdapterSimoney(getChildFragmentManager());
        mPagerAdapter.addFragment(IncomeFragment.newInstance(), getResources().getString(R.string.tab_income));
        mPagerAdapter.addFragment(ExpensesFragment.newInstance(), getResources().getString(R.string.tab_expenses));
        viewPager.setAdapter(mPagerAdapter);
    }

}

