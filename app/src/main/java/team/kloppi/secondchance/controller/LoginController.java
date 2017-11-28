package team.kloppi.secondchance.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;

import team.kloppi.secondchance.model.BaseActivity;
import team.kloppi.secondchance.model.User;

/**
 * Created by Bonziller on 27.11.2017.
 */

public class LoginController extends BaseActivity {

    private String email;
    private String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //new AsyncLogin().execute(email,password); (Beispiel für den Aufruf des Asynchronen Logins)
    }

    private static void login(User user){
        // Weiterleiten zur nächsten Seite
    }

    private static class AsyncLogin extends AsyncTask<String,Void,User> {

        /**
         * Alles in dieser Methode wird Asynchron ausgeführt.
         * @param params Die übergebenen String werte (kann alles sein)
         * @return Gibt einen User zurück, wenn der Login Erfolgreich war.
         */
        @Override
        protected User doInBackground(String... params) {
            // Suche Benutzer nach email + passwort und gib ihr zurück (statt return null)
            return null;
        }

        /**
         * Wird erst ausgeführt, wenn die Methode "doInBackground" ausgeführt wurde.
         * @param user Der User, der von der Methode "doInBackground" zurückgegeben wird.
         */
        @Override
        protected void onPostExecute(User user) {
            if(user != null){
                login(user);
            }else{
                // Login fehlgeschlagen, benutze NotificationHandler.
            }
        }
    }

}
