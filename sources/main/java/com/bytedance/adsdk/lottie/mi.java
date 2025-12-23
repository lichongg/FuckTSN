package com.bytedance.adsdk.lottie;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum mi {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* renamed from: com.bytedance.adsdk.lottie.mi$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23352j;

        static {
            int[] iArr = new int[mi.values().length];
            f23352j = iArr;
            try {
                iArr[mi.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23352j[mi.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23352j[mi.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean j(int i6, boolean z5, int i7) {
        int i8 = AnonymousClass1.f23352j[ordinal()];
        if (i8 == 1) {
            return false;
        }
        if (i8 != 2) {
            return (z5 && i6 < 28) || i7 > 4 || i6 <= 25;
        }
        return true;
    }
}
