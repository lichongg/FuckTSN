package com.google.android.gms.common.internal.service;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Common {

    @NonNull
    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> API;

    @NonNull
    @KeepForSdk
    public static final Api.ClientKey<zah> CLIENT_KEY;
    public static final zae zaa;
    private static final Api.AbstractClientBuilder zab;

    static {
        Api.ClientKey<zah> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zab zabVar = new zab();
        zab = zabVar;
        API = new Api<>("Common.API", zabVar, clientKey);
        zaa = new zae();
    }
}
