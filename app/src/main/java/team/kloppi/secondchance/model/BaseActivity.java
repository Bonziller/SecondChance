package team.kloppi.secondchance.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import team.kloppi.secondchance.R;

/**
 * Created by Bonziller on 27.11.2017.
 */

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ProgressDialog progressDialog;

    /**
     *  Immer, wenn die Activity aufgerufen wird, wird diese Methode zuerst ausgeführt.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Das Verhalten, wenn man auf die "Zurück" Taste vom Handy drückt.
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * "R.menu." beinhaltet das Menü, welches angezeigt werden soll, wenn oben rechts auf die 3 Punkte geklickt wird.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Hier kann die Logik, hinter den einzelnen Menu-Items stehen. (Wenn Eintellungen geklickt wurd, dann....)
     * @param item Das Menu-Item, welches angeklickt wurde
     * @return
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Hier kann die Logik, hinter den einzelnen Menu-Items stehen. (Wenn Eintellungen geklickt wurd, dann....)
     * @param item MenuItem, welche sich im linken Menu befindet.
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(this,R.string.sidemenu_import,Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this,R.string.sidemenu_gallery,Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this,R.string.sidemenu_slideshow,Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(this,R.string.sidemenu_tools,Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(this,R.string.sidemenu_share,Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(this,R.string.sidemenu_send,Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Gibt ein Loading Screen zurück. Um diesen anzeigen zu lassen, muss die Methode "show()" ausgeführt werden.
     *
     * @param context Den Activity Context, in dem man sich momentan befindet
     * @param titel Der Titel, der dem User angezeigt wird (Überschrift)
     * @param message Die Nachricht, die dem User angezeigt wird, während es lädt.
     * @return Gibt ProgressDialog zurück, den man sich an der beliebigen Stelle mit "show()" anzeigen lassen könnte.
     */
    public ProgressDialog createAndGetProgressDialog(Context context, @NonNull String titel, String message){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(titel);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        this.progressDialog = progressDialog;
        return progressDialog;
    }

    /**
     * Gibt ein Loading Screen zurück. Um diesen anzeigen zu lassen, muss die Methode "show()" ausgeführt werden.
     *
     * @param context Den Activity Context, in dem man sich momentan befindet
     * @param titel Der Titel, der dem User angezeigt wird (Überschrift)
     * @param message Die Nachricht, die dem User angezeigt wird, während es lädt.
     * @param cancelable Gibt an, ob der Benutzer den Loadingscreen selbständig verschwinden lassen kann (true = JA, false = Nein)
     * @return Gibt ProgressDialog zurück, den man sich an der beliebigen Stelle mit "show()" anzeigen lassen könnte.
     */
    public ProgressDialog createAndGetProgressDialog(Context context, @NonNull String titel, String message,boolean cancelable){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(titel);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(cancelable);
        this.progressDialog = progressDialog;
        return progressDialog;
    }

    /**
     * Es wird ein ProgressDialog erstellt und sofort angezeigt.
     *
     * @param context Den Activity Context, in dem man sich momentan befindet
     * @param titel Der Titel, der dem User angezeigt wird (Überschrift)
     * @param message Die Nachricht, die dem User angezeigt wird, während es lädt.
     * @return Gibt ProgressDialog zurück, den man sich an der beliebigen Stelle mit "show()" anzeigen lassen könnte.
     */
    public void createAndShowProgressDialog(Context context, @NonNull String titel, String message){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(titel);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        this.progressDialog = progressDialog;
        this.progressDialog.show();
    }

    /**
     * Es wird ein ProgressDialog erstellt und sofort angezeigt.
     *
     * @param context Den Activity Context, in dem man sich momentan befindet
     * @param titel Der Titel, der dem User angezeigt wird (Überschrift)
     * @param message Die Nachricht, die dem User angezeigt wird, während es lädt.
     * @param cancelable Gibt an, ob der Benutzer den Loadingscreen selbständig verschwinden lassen kann (true = JA, false = Nein)
     * @return Gibt ProgressDialog zurück, den man sich an der beliebigen Stelle mit "show()" anzeigen lassen könnte.
     */
    public void createAndShowProgressDialog(Context context, @NonNull String titel, String message,boolean cancelable){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(titel);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(cancelable);
        this.progressDialog = progressDialog;
        this.progressDialog.show();
    }

    /**
     * Lässt den Loadingscreen verschwinden, wenn einer da sein sollte.
     */
    public void dismissProgressDialog(){
        if(this.progressDialog != null && this.progressDialog.isShowing()){
            this.progressDialog.dismiss();
        }
    }

}
