package com.google.android.gms.internal.mlkit_vision_mediapipe;

import android.os.Build;
import dalvik.system.VMStack;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzcn extends zzch {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zzcg zzc;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class zza {
        zza() {
        }

        static boolean zza() {
            return zzcn.zzt();
        }
    }

    static boolean zzt() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", null);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzch
    protected zzcg zzh() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzch
    protected String zzm() {
        return "platform: Android";
    }

    static {
        String str = Build.FINGERPRINT;
        boolean z5 = true;
        if (str != null && !"robolectric".equals(str)) {
            z5 = false;
        }
        zzb = z5;
        zzc = new zzcg() { // from class: com.google.android.gms.internal.mlkit_vision_mediapipe.zzcn.1
            @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzcg
            public zzz zza(Class<?> cls, int i6) {
                return zzz.zza;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzcg
            public String zzb(Class<? extends zzd<?>> cls) {
                StackTraceElement zza2;
                if (zzcn.zza) {
                    try {
                        if (cls.equals(zzcn.zzp())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (zzcn.zzb && (zza2 = zzdx.zza(cls, 1)) != null) {
                    return zza2.getClassName();
                }
                return null;
            }
        };
    }

    static Class<?> zzp() {
        return VMStack.getStackClass2();
    }

    static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzch
    protected zzbd zze(String str) {
        return zzcs.zze(str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzch
    protected zzcz zzj() {
        return zzct.zzb();
    }
}
