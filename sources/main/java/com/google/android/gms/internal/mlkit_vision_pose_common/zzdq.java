package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdq {
    public static zzcv zza(zzdu zzduVar) throws zzcz {
        boolean z5;
        try {
            try {
                zzduVar.zzn();
                z5 = false;
                try {
                    return (zzcv) zzds.zza.zza(zzduVar);
                } catch (EOFException e6) {
                    e = e6;
                    if (z5) {
                        return zzcx.zza;
                    }
                    throw new zzdc(e);
                }
            } catch (zzdx e7) {
                throw new zzdc(e7);
            } catch (IOException e8) {
                throw new zzcw(e8);
            } catch (NumberFormatException e9) {
                throw new zzdc(e9);
            }
        } catch (EOFException e10) {
            e = e10;
            z5 = true;
        }
    }
}
