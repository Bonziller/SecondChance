package team.kloppi.secondchance;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Bonziller on 27.11.2017.
 */

public class ProgressDialogHolder {

    /**
     * Gibt ein Loading Screen zurück. Um diesen anzeigen zu lassen, muss die Methode "show()" ausgeführt werden.
     *
     * @param context Den Activity Context, in dem man sich momentan befindet
     * @param titel Der Titel, der dem User angezeigt wird (Überschrift)
     * @param message Die Nachricht, die dem User angezeigt wird, während es lädt.
     * @return Gibt ProgressDialog zurück, den man sich an der beliebigen Stelle mit "show()" anzeigen lassen könnte.
     */
    public static ProgressDialog createAndGetProgressDialog(Context context, @NonNull String titel, String message){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(titel);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
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
    public static ProgressDialog createAndGetProgressDialog(Context context, @NonNull String titel, String message,boolean cancelable){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(titel);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(cancelable);
        return progressDialog;
    }

}
