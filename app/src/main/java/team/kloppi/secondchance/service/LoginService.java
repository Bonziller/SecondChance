package team.kloppi.secondchance.service;

import android.content.Context;
import android.content.SharedPreferences;

import team.kloppi.secondchance.constants.Constants;

/**
 * Created by Bonziller on 27.11.2017.
 */

public class LoginService {

    private SharedPreferences speicher;

    /**
     * Überprüft, ob das Handy bereits gespeicherte Nutzerdaten enthält.
     * @param context Context der momentan aktiven Activity (Wahrscheinlich LoginController)
     * @return true, wenn email und password im Handy hinterlegt sind. false, wenn nichts hinterlegt ist.
     */
    public boolean isUserLoggedIn(Context context){
        speicher = context.getSharedPreferences("userdata",0);
        if(speicher != null && speicher.getString(Constants.EMAIL,null) != null
                && speicher.getString(Constants.PASSWORD,null) != null){
            return true;
        }
        return false;
    }

    /**
     * Hier werden die Benutzerdaten, mit den die Person sich Erfolgreich angemeldet hat, auf dessen Handy gespeichert,
     * damit man später nicht mehr nach Email und Password fragen muss, sondern die gespeicherten Werte nimmt und Sie lediglich
     * in der Datenbank überprüft (sind diese gültig?)
     * @param context Context der momentan aktiven Activity (Wahrscheinlich LoginController)
     * @param email Die Email, vom User.
     * @param password Das Password, vom User.
     */
    public void rememberUserData(Context context,String email, String password){
            speicher = context.getSharedPreferences("userdata",0);
            SharedPreferences.Editor editor;
            editor = speicher.edit();
            editor.putString(Constants.EMAIL,email);
            editor.putString(Constants.PASSWORD,password);
            editor.apply();
    }

    /**
     * Gibt die im Handy gespeicherte Email Adresse aus, falls vorhanden.
     * @param context Context der momentan aktiven Activity (Wahrscheinlich LoginController)
     * @return String, wenn eine Email auf dem Handy hinterlegt wurde. Null, wenn nichts hinterlegt wurde.
     */
    public String getStoredEmail(Context context){
        speicher = context.getSharedPreferences("userdata",0);
        if(speicher != null){
            return speicher.getString(Constants.EMAIL,null);
        }
        return null;
    }

    /**
     * Gibt das im Handy gespeicherte Passwort aus, falls vorhanden.
     * @param context Context der momentan aktiven Activity (Wahrscheinlich LoginController)
     * @return String, wenn ein Passwort auf dem Handy hinterlegt wurde. Null, wenn nichts hinterlegt wurde.
     */
    public String getStoredPassword(Context context){
        speicher = context.getSharedPreferences("userdata",0);
        if(speicher != null){
            return speicher.getString(Constants.PASSWORD,null);
        }
        return null;
    }

}
