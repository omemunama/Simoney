package nursulaeman.simoney;

import android.content.pm.ActivityInfo;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.Date;
import java.util.Locale;

import nursulaeman.simoney.fragment.DashboardFragment;
import nursulaeman.simoney.fragment.TransactionFragment;

public class    MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupViews();
        setUpDrawerToogle();

    }

    private void initializeViews() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }

    private void setupViews() {

        if (toolbar != null)
            setSupportActionBar(toolbar);

        if (navigationView != null) {
            setUpDrawerContent(navigationView);
            navigationView.getMenu().performIdentifierAction(R.id.nav_section_one, 0);
        }

    }

    private void setUpDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                CharSequence s = menuItem.getTitle();
                onSectionAttached(s);
                switch (menuItem.getItemId()) {
                    case R.id.nav_section_one:
                        fragmentTransactionReplace(DashboardFragment.newInstance());
                        break;
                    case R.id.nav_section_two:
                        fragmentTransactionReplace(TransactionFragment.newInstance());
                        break;
                }

                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    public void onSectionAttached(CharSequence mTitle) {
        if (toolbar != null) {
            toolbar.setTitle(mTitle);

        }
    }

    private void fragmentTransactionReplace(Fragment fragmentInstance) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragmentInstance)
                .commit();
    }

    private void setUpDrawerToogle() {
        final ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                actionBarDrawerToggle.syncState();
            }
        });
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
