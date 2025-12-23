package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class DislikeAnalyzer {
    private DislikeAnalyzer() {
        throw new UnsupportedOperationException();
    }

    public static Hct fixIfDisliked(Hct hct) {
        if (isDisliked(hct)) {
            return Hct.from(hct.getHue(), hct.getChroma(), 70.0d);
        }
        return hct;
    }

    public static boolean isDisliked(Hct hct) {
        boolean z5;
        boolean z6;
        boolean z7;
        if (Math.round(hct.getHue()) >= 90.0d && Math.round(hct.getHue()) <= 111.0d) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (Math.round(hct.getChroma()) > 16.0d) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (Math.round(hct.getTone()) < 65.0d) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z5 || !z6 || !z7) {
            return false;
        }
        return true;
    }
}
