package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class UserRecoverableException extends Exception {
    private final Intent zza;

    @NonNull
    public Intent getIntent() {
        return new Intent(this.zza);
    }

    public UserRecoverableException(@NonNull String str, @NonNull Intent intent) {
        super(str);
        this.zza = intent;
    }
}
