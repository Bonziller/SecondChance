package team.kloppi.secondchance.service;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

import team.kloppi.secondchance.model.BaseActivity;

/**
 * Created by Bonziller on 04.12.2017.
 */

public class UserService extends BaseDBService {

    public void createUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email.trim(),password.trim());
    }

    public void createUserWithListener(BaseActivity activity, String email, String password,OnCompleteListener<AuthResult> onCompleteListener){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, onCompleteListener);
    }

}
