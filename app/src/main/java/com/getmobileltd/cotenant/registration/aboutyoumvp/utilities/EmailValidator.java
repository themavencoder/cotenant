package com.getmobileltd.cotenant.registration.aboutyoumvp.utilities;

import android.text.TextUtils;

public abstract class EmailValidator {

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
