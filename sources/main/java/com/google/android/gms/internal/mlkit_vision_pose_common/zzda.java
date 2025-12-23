package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.io.IOException;
import java.io.StringReader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzda {
    public static zzcv zza(zzdu zzduVar) throws zzcw, zzdc {
        zzdd zzb = zzduVar.zzb();
        if (zzb == zzdd.LEGACY_STRICT) {
            zzduVar.zzk(zzdd.LENIENT);
        }
        try {
            try {
                return zzdq.zza(zzduVar);
            } catch (OutOfMemoryError e6) {
                throw new zzcz("Failed parsing JSON source: " + zzduVar.toString() + " to Json", e6);
            } catch (StackOverflowError e7) {
                throw new zzcz("Failed parsing JSON source: " + zzduVar.toString() + " to Json", e7);
            }
        } finally {
            zzduVar.zzk(zzb);
        }
    }

    public static zzcv zzb(String str) throws zzdc {
        try {
            zzdu zzduVar = new zzdu(new StringReader(str));
            zzcv zza = zza(zzduVar);
            if (!(zza instanceof zzcx) && zzduVar.zzn() != 10) {
                throw new zzdc("Did not consume the entire document.");
            }
            return zza;
        } catch (zzdx e6) {
            throw new zzdc(e6);
        } catch (IOException e7) {
            throw new zzcw(e7);
        } catch (NumberFormatException e8) {
            throw new zzdc(e8);
        }
    }
}
