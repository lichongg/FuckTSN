package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class PointProviderLab implements PointProvider {
    @Override // com.google.android.material.color.utilities.PointProvider
    public double distance(double[] dArr, double[] dArr2) {
        double d6 = dArr[0] - dArr2[0];
        double d7 = dArr[1] - dArr2[1];
        double d8 = dArr[2] - dArr2[2];
        return (d6 * d6) + (d7 * d7) + (d8 * d8);
    }

    @Override // com.google.android.material.color.utilities.PointProvider
    public int toInt(double[] dArr) {
        return ColorUtils.argbFromLab(dArr[0], dArr[1], dArr[2]);
    }

    @Override // com.google.android.material.color.utilities.PointProvider
    public double[] fromInt(int i6) {
        double[] labFromArgb = ColorUtils.labFromArgb(i6);
        return new double[]{labFromArgb[0], labFromArgb[1], labFromArgb[2]};
    }
}
