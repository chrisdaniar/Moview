package id.sch.smktelkom_mlg.privateassignment.xirpl229.moview;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.adapter.NowAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.adapter.PopularAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.adapter.SoonAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.fragment.NowFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.fragment.PopularFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.fragment.SoonFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SoonAdapter.ISoonAdapter, NowAdapter.ISourceAdapter, PopularAdapter.IPopularAdapter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        changePage(R.id.nav_camera);
        navigationView.setCheckedItem(R.id.nav_camera);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        changePage(id);
        return true;
    }

    private void changePage(int id) {
        Fragment fragment = null;

        if (id == R.id.nav_camera) {
            fragment = new SoonFragment();
            setTitle("Coming Soon");
        } else if (id == R.id.nav_gallery) {
            fragment = new NowFragment();
            setTitle("Now Playing");
        } else if (id == R.id.nav_slideshow) {
            fragment = new PopularFragment();
            setTitle("Popular!");
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).commitNow();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @Override
    public void showArticles(String title, String overview, String poster_path) {

    }
}
