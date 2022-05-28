package br.edimilsonborges.seupesoemoutroplaneta;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText editTextPesoAtual;
    String peso;
    Calculo calculo = new Calculo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar_Principal = (Toolbar) findViewById(R.id.toolbar_Principal);
        setSupportActionBar(toolbar_Principal);

        editTextPesoAtual = (EditText) findViewById(R.id.editTextPesoAtual);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_principal);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar_Principal, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_principal);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public void calcular(View view){
        try{
            //if(editTextPesoAtual.getText().toString().isEmpty()){}
            if (editTextPesoAtual.getText().toString().length() <=0) {
                editTextPesoAtual.setError(getBaseContext().getString(R.string.setError));
                editTextPesoAtual.requestFocus();
            }else {
                peso = editTextPesoAtual.getText().toString();
                calculo.setPeso(Double.parseDouble(peso),9.780);

                Intent it = new Intent();
                it.setClass(PrincipalActivity.this, TabActivity.class);
                startActivity(it);
            }
        }catch (Exception ignored){
        }
    }
    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_principal);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage(R.string.alertsair);
            alert.setPositiveButton(R.string.alertbutsim, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.setNeutralButton(R.string.alertbutnao, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alert.create();
            alert.show();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_sobre) {
            AlertDialog.Builder sobre = new AlertDialog.Builder(this);
            sobre.setTitle(R.string.sobre);
            sobre.setMessage(R.string.mensag_sobre);
            sobre.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            sobre.create();
            sobre.show();
        } else if (id == R.id.nav_ajuda) {
            AlertDialog.Builder sobre = new AlertDialog.Builder(this);
            sobre.setTitle(R.string.como_calculamos);
            sobre.setMessage(R.string.como_se_calcula);
            sobre.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            sobre.create();
            sobre.show();
        } else if (id == R.id.nav_compartilhar) {

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=br.edimilsonborges.seupesoemoutroplaneta");
            startActivity(Intent.createChooser(share, getString(R.string.compartilhar)));

        } else if (id == R.id.nav_qualificar) {

            String urlString = "https://play.google.com/store/apps/details?id=br.edimilsonborges.seupesoemoutroplaneta";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.android.vending");
            try {
                this.startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                // Chrome browser presumably not installed so allow user to choose instead
                intent.setPackage(null);
                this.startActivity(intent);
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_principal);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
