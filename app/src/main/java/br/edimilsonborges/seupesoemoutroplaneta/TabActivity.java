package br.edimilsonborges.seupesoemoutroplaneta;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.edimilsonborges.seupesoemoutroplaneta.planetas.CalistoActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.CeresActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.DioneActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.EnceladoActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.ErisActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.EuropaActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.FobosActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.GanimedesActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.IoActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.JapetoActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.JupiterActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.LuaActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.MarteActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.MercurioActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.NetunoActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.PlutaoActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.QuaoarActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.ReiaActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.SaturnoActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.SolActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.TerraActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.TetisActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.TitaActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.UranoActivity;
import br.edimilsonborges.seupesoemoutroplaneta.planetas.VenusActivity;

public class TabActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    Calculo calculo = new Calculo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        //MessageAtualizar messageAtualizar = new MessageAtualizar(this);
        //AsynDataClass jsonAsync = new AsynDataClass();
        //jsonAsync.execute("");

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);

        //this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // this.getSupportActionBar().setHomeButtonEnabled(true);

        // Criando o AdView.


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Criar o adaptador que retornará um fragmento para cada um dos três
        // secções primárias da actividade.

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Configurar o ViewPager com o adaptador de seçõe.
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        // Configura o TabLayout com o ViewPager

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setHorizontalFadingEdgeEnabled(true);
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static class PlaceholderFragment extends Fragment {
        /**
         * O argumento de fragmento representando o número da seção para este
         * Fragmento.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Retorna uma nova instância desse fragmento para a seção fornecida
         * número.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_terra, container, false);


            // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            return rootView;
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new MercurioActivity();
                case 1:
                    return new VenusActivity();
                case 2:
                    return new MarteActivity();
                case 3:
                    return new TerraActivity();
                case 4:
                    return new JupiterActivity();
                case 5:
                    return new SaturnoActivity();
                case 6:
                    return new NetunoActivity();
                case 7:
                    return new UranoActivity();
                case 8:
                    return new SolActivity();
                case 9:
                    return new LuaActivity();
                case 10:
                    return new PlutaoActivity();
                case 11:
                    return new ErisActivity();
                case 12:
                    return new CeresActivity();
                case 13:
                    return new QuaoarActivity();
                case 14:
                    return new FobosActivity();
                case 15:
                    return new EuropaActivity();
                case 16:
                    return new GanimedesActivity();
                case 17:
                    return new IoActivity();
                case 18:
                    return new CalistoActivity();
                case 19:
                    return new TitaActivity();
                case 20:
                    return new TetisActivity();
                case 21:
                    return new ReiaActivity();
                case 22:
                    return new JapetoActivity();
                case 23:
                    return new DioneActivity();
                case 24:
                    return new EnceladoActivity();
            }
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 25 total pages.
            return 25;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.mercurio);
                case 1:
                    return getString(R.string.venus);
                case 2:
                    return getString(R.string.marte);
                case 3:
                    return getString(R.string.terra_planeta);
                case 4:
                    return getString(R.string.jupiter);
                case 5:
                    return getString(R.string.saturno);
                case 6:
                    return getString(R.string.netuno);
                case 7:
                    return getString(R.string.urano);
                case 8:
                    return getString(R.string.sol);
                case 9:
                    return getString(R.string.lua);
                case 10:
                    return getString(R.string.plutao);
                case 11:
                    return getString(R.string.ris_planeta_an_o);
                case 12:
                    return getString(R.string.ceres_planeta_an_o);
                case 13:
                    return getString(R.string.quaoar_planeta_an_o);
                case 14:
                    return getString(R.string.fobos_sat_lite_de_marte);
                case 15:
                    return getString(R.string.europa_sat_lite_de_j_piter);
                case 16:
                    return getString(R.string.gan_medes_sat_lite_de_j_piter);
                case 17:
                    return getString(R.string.io_sat_lite_de_j_piter);
                case 18:
                    return getString(R.string.calisto_sat_lite_de_j_piter);
                case 19:
                    return getString(R.string.tit_sat_lite_de_saturno);
                case 20:
                    return getString(R.string.t_tis_sat_lite_de_saturno);
                case 21:
                    return getString(R.string.reia_sat_lite_de_saturno);
                case 22:
                    return getString(R.string.j_peto_sat_lite_de_saturno);
                case 23:
                    return getString(R.string.dione_sat_lite_de_saturno);
                case 24:
                    return getString(R.string.enc_lado_sat_lite_de_saturno);
            }
            return null;
        }
    }

}
