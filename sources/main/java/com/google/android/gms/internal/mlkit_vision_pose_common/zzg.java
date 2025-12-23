package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.regex.Pattern;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzg {
    private static final Pattern zza = Pattern.compile("^OpenGL ES(-C[ML])? (\\d)\\.(\\d).*$");

    /* JADX WARN: Removed duplicated region for block: B:67:0x00e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.google.android.gms.internal.mlkit_vision_pose_common.zzf zza() throws com.google.android.gms.internal.mlkit_vision_pose_common.zzd {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_pose_common.zzg.zza():com.google.android.gms.internal.mlkit_vision_pose_common.zzf");
    }

    private static void zzb(EGL10 egl10, String str) throws zzd {
        int eglGetError = egl10.eglGetError();
        if (eglGetError == 12288) {
        } else {
            throw zzd.zzc(eglGetError, str);
        }
    }

    private static void zzc(EGL10 egl10, EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i6, int[] iArr2) throws zzd {
        try {
            egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i6, iArr2);
            zzb(egl10, "egl.eglChooseConfig");
        } catch (RuntimeException e6) {
            throw zzd.zzd("egl.eglChooseConfig failed with ".concat(e6.toString()), e6);
        }
    }
}
