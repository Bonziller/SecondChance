package team.kloppi.secondchance.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Bonziller on 04.12.2017.
 */

public class BaseDBService {

    /**
     * Erzeugt eine Instanz von FirebaseAuth, um die Authentifizierung über Firebase zu ermöglichen.
     * Also: Login, Logout, Erstellen neuer Benutzer, Senden von "Passwort vergessen" Links...
     */
    protected FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public BaseDBService(){

    }

    /**
     * Schaut nach, ob der Handy Benutzer eingeloggt ist, oder nicht und gibt einen Benutzer zurück.
     * @return FireBaseUser, wenn man eingeloggt ist. Null, wenn man nicht eingeloggt ist.
     */
    protected FirebaseUser getCurrentUser(){
        return mAuth.getCurrentUser();
    }

}
