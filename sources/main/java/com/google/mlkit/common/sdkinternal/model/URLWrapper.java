package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class URLWrapper {
    private final URL zza;

    @NonNull
    @KeepForSdk
    public URLConnection openConnection() throws IOException {
        return this.zza.openConnection();
    }

    @KeepForSdk
    public URLWrapper(@NonNull String str) throws MalformedURLException {
        this.zza = new URL(str);
    }
}
