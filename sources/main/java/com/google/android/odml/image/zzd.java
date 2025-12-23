package com.google.android.odml.image;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final /* synthetic */ class zzd {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[Bitmap.Config.values().length];
        zza = iArr;
        try {
            iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[Bitmap.Config.ARGB_8888.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
