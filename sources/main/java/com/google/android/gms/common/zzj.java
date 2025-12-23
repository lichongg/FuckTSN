package com.google.android.gms.common;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.commons.net.ftp.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzj extends com.google.android.gms.common.internal.zzz {
    private final int zza;

    public final boolean equals(@Nullable Object obj) {
        IObjectWrapper zzd;
        if (obj != null && (obj instanceof com.google.android.gms.common.internal.zzaa)) {
            try {
                com.google.android.gms.common.internal.zzaa zzaaVar = (com.google.android.gms.common.internal.zzaa) obj;
                if (zzaaVar.zzc() == this.zza && (zzd = zzaaVar.zzd()) != null) {
                    return Arrays.equals(zzf(), (byte[]) ObjectWrapper.unwrap(zzd));
                }
                return false;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    abstract byte[] zzf();

    protected static byte[] zze(String str) {
        try {
            return str.getBytes(b.T);
        } catch (UnsupportedEncodingException e6) {
            throw new AssertionError(e6);
        }
    }

    public final int hashCode() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        return this.zza;
    }

    protected zzj(byte[] bArr) {
        boolean z5;
        if (bArr.length == 25) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        this.zza = Arrays.hashCode(bArr);
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(zzf());
    }
}
