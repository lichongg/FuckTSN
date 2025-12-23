package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zza = new Object();
    private boolean zzb = false;

    @KeepForSdk
    protected abstract boolean prepareForClientVersion(int i6);

    @KeepForSdk
    protected static boolean canUnparcelSafely(@NonNull String str) {
        synchronized (zza) {
        }
        return true;
    }

    @Nullable
    @KeepForSdk
    protected static Integer getUnparcelClientVersion() {
        synchronized (zza) {
        }
        return null;
    }

    @KeepForSdk
    public void setShouldDowngrade(boolean z5) {
        this.zzb = z5;
    }

    @KeepForSdk
    protected boolean shouldDowngrade() {
        return this.zzb;
    }
}
