package team.kloppi.secondchance.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Bonziller on 04.12.2017.
 */

public class BaseDBService {

    protected FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public BaseDBService(){

    }

    protected FirebaseUser getCurrentUser(){
        return mAuth.getCurrentUser();
    }

}
