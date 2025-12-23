package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzec implements zzeb {
    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzeb
    public final StackTraceElement[] zzb(Class cls, int i6, int i7) {
        boolean z5 = true;
        if (i6 != -1 && i6 <= 0) {
            z5 = false;
        }
        zzdy.zzc(z5, "maxDepth must be > 0 or -1");
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int zzc = zzc(stackTrace, cls, 3);
        if (zzc == -1) {
            return new StackTraceElement[0];
        }
        int length = stackTrace.length - zzc;
        if (i6 <= 0 || i6 >= length) {
            i6 = length;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i6];
        System.arraycopy(stackTrace, zzc, stackTraceElementArr, 0, i6);
        return stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzeb
    public final StackTraceElement zza(Class cls, int i6) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int zzc = zzc(stackTrace, cls, 3);
        if (zzc != -1) {
            return stackTrace[zzc];
        }
        return null;
    }

    zzec() {
    }

    private static final int zzc(StackTraceElement[] stackTraceElementArr, Class cls, int i6) {
        String name = cls.getName();
        boolean z5 = false;
        for (int i7 = 3; i7 < stackTraceElementArr.length; i7++) {
            if (stackTraceElementArr[i7].getClassName().equals(name)) {
                z5 = true;
            } else if (z5) {
                return i7;
            }
        }
        return -1;
    }
}
