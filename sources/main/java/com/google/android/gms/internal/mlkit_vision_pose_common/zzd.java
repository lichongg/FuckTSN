package com.google.android.gms.internal.mlkit_vision_pose_common;

import javax.microedition.khronos.egl.EGL10;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzd extends Exception {
    private final int zza;

    private zzd(int i6, String str) {
        super(str);
        this.zza = i6;
    }

    private zzd(String str, Throwable th) {
        super(str, th);
        this.zza = 0;
    }

    public static zzd zzb(String str) {
        return new zzd(0, str);
    }

    public static zzd zzc(int i6, String str) {
        return new zzd(i6, "EGL error " + i6 + " during " + str);
    }

    public static zzd zzd(String str, Throwable th) {
        return new zzd(str, th);
    }

    public final int zza() {
        return this.zza;
    }

    public static zzd zze(EGL10 egl10, String str) {
        int eglGetError = egl10.eglGetError();
        if (eglGetError != 12288) {
            return new zzd(eglGetError, "EGL error " + eglGetError + " during " + str);
        }
        return new zzd(0, "EGL context not available during ".concat(str));
    }
}
