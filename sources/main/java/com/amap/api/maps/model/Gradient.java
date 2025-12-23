package com.amap.api.maps.model;

import android.graphics.Color;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f8967a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8968b;

        /* renamed from: c, reason: collision with root package name */
        private final float f8969c;

        /* synthetic */ a(int i6, int i7, float f6, byte b6) {
            this(i6, i7, f6);
        }

        private a(int i6, int i7, float f6) {
            this.f8967a = i6;
            this.f8968b = i7;
            this.f8969c = f6;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, (byte) 0);
    }

    private HashMap<Integer, a> a() {
        HashMap<Integer, a> hashMap = new HashMap<>(32);
        byte b6 = 0;
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0], b6));
        }
        for (int i6 = 1; i6 < this.mColors.length; i6++) {
            int i7 = i6 - 1;
            Integer valueOf = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[i7]));
            int[] iArr = this.mColors;
            int i8 = iArr[i7];
            int i9 = iArr[i6];
            float f6 = this.mColorMapSize;
            float[] fArr = this.mStartPoints;
            hashMap.put(valueOf, new a(i8, i9, f6 * (fArr[i6] - fArr[i7]), b6));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.mColorMapSize * fArr2[length]));
            int i10 = this.mColors[length];
            hashMap.put(valueOf2, new a(i10, i10, this.mColorMapSize * (1.0f - this.mStartPoints[length]), b6));
        }
        return hashMap;
    }

    private Gradient(int[] iArr, float[] fArr, byte b6) {
        this.isAvailable = true;
        try {
            if (iArr == null || fArr == null) {
                throw new AMapException("colors and startPoints should not be null");
            }
            if (iArr.length != fArr.length) {
                throw new AMapException("colors and startPoints should be same length");
            }
            if (iArr.length == 0) {
                throw new AMapException("No colors have been defined");
            }
            for (int i6 = 1; i6 < fArr.length; i6++) {
                if (fArr[i6] < fArr[i6 - 1]) {
                    throw new AMapException("startPoints should be in increasing order");
                }
            }
            this.mColorMapSize = 1000;
            int[] iArr2 = new int[iArr.length];
            this.mColors = iArr2;
            this.mStartPoints = new float[fArr.length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
            this.isAvailable = true;
        } catch (AMapException e6) {
            this.isAvailable = false;
            e6.getErrorMessage();
            e6.printStackTrace();
        }
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float[] getStartPoints() {
        return this.mStartPoints;
    }

    protected boolean isAvailable() {
        return this.isAvailable;
    }

    protected int[] generateColorMap(double d6) {
        HashMap<Integer, a> a6 = a();
        int[] iArr = new int[this.mColorMapSize];
        a aVar = a6.get(0);
        int i6 = 0;
        for (int i7 = 0; i7 < this.mColorMapSize; i7++) {
            if (a6.containsKey(Integer.valueOf(i7))) {
                aVar = a6.get(Integer.valueOf(i7));
                i6 = i7;
            }
            iArr[i7] = a(aVar.f8967a, aVar.f8968b, (i7 - i6) / aVar.f8969c);
        }
        if (d6 != 1.0d) {
            for (int i8 = 0; i8 < this.mColorMapSize; i8++) {
                int i9 = iArr[i8];
                iArr[i8] = Color.argb((int) (Color.alpha(i9) * d6), Color.red(i9), Color.green(i9), Color.blue(i9));
            }
        }
        return iArr;
    }

    private static int a(int i6, int i7, float f6) {
        int alpha = (int) (((Color.alpha(i7) - Color.alpha(i6)) * f6) + Color.alpha(i6));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i6), Color.green(i6), Color.blue(i6), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i7), Color.green(i7), Color.blue(i7), fArr2);
        float f7 = fArr[0];
        float f8 = fArr2[0];
        if (f7 - f8 > 180.0f) {
            fArr2[0] = f8 + 360.0f;
        } else if (f8 - f7 > 180.0f) {
            fArr[0] = f7 + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i8 = 0; i8 < 3; i8++) {
            float f9 = fArr2[i8];
            float f10 = fArr[i8];
            fArr3[i8] = ((f9 - f10) * f6) + f10;
        }
        return Color.HSVToColor(alpha, fArr3);
    }
}
