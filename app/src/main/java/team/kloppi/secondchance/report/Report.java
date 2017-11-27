package team.kloppi.secondchance.report;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Bonziller on 27.11.2017.
 */

public class Report {

    /**
     * Eine Nachricht erscheint beiläufig von unten, ohne den Benutzer zu nötigen diese wegklicken zu müssen.
     * Die Nachricht verschwindet nach ca. 3 Sekunden.
     * @param view View angeben (findViewById(R.id.???))
     * @param message Nachricht, an den Benutzer
     */
    public static void report(View view, String message){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    /**
     * Eine Nachricht erscheint beiläufig von unten, ohne den Benutzer zu nötigen diese wegklicken zu müssen.
     * Die Nachricht verschwindet nach ca. 3 Sekunden.
     * Die Nachricht wird mit einem zusätzlichen Button angezeigt, der innerhalb der 3 Sekunden angeklickt werden könnte.
     * @param view View angeben (findViewById(R.id.???))
     * @param message Nachricht, an den Benutzer
     * @param buttonText Text des Buttons
     * @param listener OnClickListener, welcher ausgeführt wird, wenn auf den Button geklickt wird.
     */
    public static void report(View view, String message, String buttonText, View.OnClickListener listener){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction(buttonText,listener).show();
    }

    /**
     * Eine Nachricht erscheint beiläufig von unten, ohne den Benutzer zu nötigen diese wegklicken zu müssen.
     * Die Nachricht verschwindet nach ca. 3 Sekunden.
     * Die Nachricht wird mit einem zusätzlichen Button angezeigt, der innerhalb der 3 Sekunden angeklickt werden könnte.
     * Die Button-Farbe kann hier zusätzlich verändert werden.
     * @param view View angeben (findViewById(R.id.???))
     * @param message Nachricht, an den Benutzer
     * @param buttonText Text des Buttons
     * @param listener OnClickListener, welcher ausgeführt wird, wenn auf den Button geklickt wird.
     * @param rColor R.color.??? wird benötigt, damit die Farbe erkannt wird. (Befindet sich im Ordner app > res > values > colors.xml)
     */
    public static void report(View view, String message, String buttonText, View.OnClickListener listener, int rColor){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction(buttonText,listener).setActionTextColor(rColor).show();
    }

}
