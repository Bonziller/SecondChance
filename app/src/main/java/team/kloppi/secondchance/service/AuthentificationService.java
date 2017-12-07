package team.kloppi.secondchance.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import team.kloppi.secondchance.constants.Constants;
import team.kloppi.secondchance.model.BaseActivity;

/**
 * Created by Bonziller on 27.11.2017.
 */

public class AuthentificationService extends BaseDBService{

    private SharedPreferences storage;

    /**
     * Überprüft, ob das Handy bereits gespeicherte Nutzerdaten enthält.
     * @param context Context der momentan aktiven Activity (Wahrscheinlich LoginController)
     * @return true, wenn email und password im Handy hinterlegt sind. false, wenn nichts hinterlegt ist.
     */
    public boolean isUserKnown(Context context){
        storage = context.getSharedPreferences(Constants.USERDATA,0);
        if(storage != null && storage.getString(Constants.EMAIL,null) != null
                && storage.getString(Constants.PASSWORD,null) != null){
            return true;
        }
        return false;
    }

    /**
     * Überprüft, ob der User bereits eingeloggt ist
     * @return True, wenn der User eingeloggt ist. False, wenn nicht.
     */
    public boolean isUserAlreadyLoggedIn(){
        return getCurrentUser() != null;
    }

    /**
     * Dies ist die "Normale" Authentifizierung (Nur mit Email und Passwort) und hat rein gar nichts mit dem "Google, Facebook, Twitter..." Login Verfahren zu tun.
     * Loggt den User ein, sollten die Daten (email und password) mit der Datenbank übereinstimmen
     * @param activity Die Activity, von wo aus der Login-Prozess gestartet wurrde
     * @param email Die Email, mit dem sich der User anmelden möchte
     * @param password Das Password, mit dem sich der User anmelden möchte
     */
    public void signIn(BaseActivity activity, String email, String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    // Anmeldung erfolgreich, was nun? (Activity wechseln...)
                }else{
                    // Anmeldung fehlgeschlagen, was nun? (Anzeigen, dass es nicht geklappt hat...)
                }
            }
        });
    }

    /**
     * Dies ist die "Normale" Authentifizierung (Nur mit Email und Passwort) und hat rein gar nichts mit dem "Google, Facebook, Twitter..." Login Verfahren zu tun.
     * Loggt den User ein, sollten die Daten (email und password) mit der Datenbank übereinstimmen
     * @param activity Die Activity, von wo aus der Login-Prozess gestartet wurrde
     * @param email Die Email, mit dem sich der User anmelden möchte
     * @param password Das Password, mit dem sich der User anmelden möchte
     * @param onCompleteListener Der Listener, welcher eine Antwort bezüglich des Log-In's zurückgibt. (task.isSuccessful == Eingeloggt)
     */
    public void signInWithListener(BaseActivity activity, String email, String password, OnCompleteListener onCompleteListener){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity, onCompleteListener);
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
            storage = context.getSharedPreferences(Constants.USERDATA,0);
            SharedPreferences.Editor editor;
            editor = storage.edit();
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
        storage = context.getSharedPreferences(Constants.USERDATA,0);
        if(storage != null){
            return storage.getString(Constants.EMAIL,null);
        }
        return null;
    }

    /**
     * Gibt das im Handy gespeicherte Passwort aus, falls vorhanden.
     * @param context Context der momentan aktiven Activity (Wahrscheinlich LoginController)
     * @return String, wenn ein Passwort auf dem Handy hinterlegt wurde. Null, wenn nichts hinterlegt wurde.
     */
    public String getStoredPassword(Context context){
        storage = context.getSharedPreferences(Constants.USERDATA,0);
        if(storage != null){
            return storage.getString(Constants.PASSWORD,null);
        }
        return null;
    }

}
