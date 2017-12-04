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

public class LoginService extends BaseDBService{

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

    public boolean isUserInDatabase(){
        return getCurrentUser() != null;
    }

    public void signIn(BaseActivity activity, String email, String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    // Anmeldung erfolgreich
                }else{
                    // Anmeldung fehlgeschlagen
                }
            }
        });
    }

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
