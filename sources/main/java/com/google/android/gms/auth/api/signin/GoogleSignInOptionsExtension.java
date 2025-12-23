package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes4.dex */
public interface GoogleSignInOptionsExtension {

    @KeepForSdk
    public static final int FITNESS = 3;

    @KeepForSdk
    public static final int GAMES = 1;

    @KeepForSdk
    int getExtensionType();

    @Nullable
    @KeepForSdk
    List<Scope> getImpliedScopes();

    @NonNull
    @KeepForSdk
    Bundle toBundle();
}
