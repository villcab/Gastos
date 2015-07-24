package com.villcab.gastos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.villcab.gastos.activitys.CategoriaActivity;
import com.villcab.gastos.activitys.ConceptoActivity;
import com.villcab.gastos.data.DConcepto;
import com.villcab.gastos.entitys.Concepto;
import com.villcab.gastos.fragment.CategoriaFragment;
import com.villcab.gastos.fragment.ConceptoFragment;
import com.villcab.gastos.utils.App;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private String drawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        drawerTitle = getResources().getString(R.string.home_item);
        if (savedInstanceState == null) {
            //selectItem(R.menu.nav_menu);
        }

        try {
            DConcepto data = new DConcepto(this, Concepto.class);
        } catch (Exception e) {
            Log.e(App.TAG, "Error al crear", e);
        }

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.primaryColorDark));
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_1);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        selectItem(menuItem);
                        return true;
                    }
                }
        );
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void selectItem(MenuItem menuItem) {
        String title = menuItem.getTitle().toString();
        Bundle args = new Bundle();
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.nav_productos:
                args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);
                fragment = ConceptoFragment.newInstance(title);
                fragment.setArguments(args);
                break;

            case R.id.nav_categorias:
                args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);
                fragment = CategoriaFragment.newInstance(title);
                fragment.setArguments(args);
                break;

            default:
                args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);
                fragment = PlaceholderFragment.newInstance(title);
                fragment.setArguments(args);
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();

        drawerLayout.closeDrawers(); // Cerrar drawer

        setTitle(title); // Setear título actual

    }

    public void onclickAddConcepto(View view) {
        Intent intent = new Intent(this, ConceptoActivity.class);
        startActivity(intent);
    }

    public void onclickAddCategoria(View view) {
        Intent intent = new Intent(this, CategoriaActivity.class);
        startActivity(intent);
    }
}
