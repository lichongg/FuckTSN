package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class Wrappers {
    private static final Wrappers zza = new Wrappers();

    @Nullable
    private PackageManagerWrapper zzb = null;

    @NonNull
    @VisibleForTesting
    public final synchronized PackageManagerWrapper zza(@NonNull Context context) {
        try {
            if (this.zzb == null) {
                if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                    context = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                this.zzb = new PackageManagerWrapper(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzb;
    }

    @NonNull
    @KeepForSdk
    public static PackageManagerWrapper packageManager(@NonNull Context context) {
        return zza.zza(context);
    }
}
