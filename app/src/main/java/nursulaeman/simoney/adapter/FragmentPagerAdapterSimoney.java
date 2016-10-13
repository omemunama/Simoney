package nursulaeman.simoney.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nur on 13/10/16.
 */
public class FragmentPagerAdapterSimoney extends FragmentPagerAdapter {

    private List<Fragment> mfragments = new ArrayList<>();
    private List<String> mfragmentsTitles = new ArrayList<>();

    public FragmentPagerAdapterSimoney (FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mfragmentsTitles.get(position);
    }


    public void addFragment(Fragment fragment, String title) {
        mfragments.add(fragment);
        mfragmentsTitles.add(title);
    }

}
