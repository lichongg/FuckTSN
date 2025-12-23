package com.bytedance.adsdk.lottie.r;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class az implements nd<com.bytedance.adsdk.lottie.model.xt.r> {

    /* renamed from: j, reason: collision with root package name */
    private int f23502j;

    @Override // com.bytedance.adsdk.lottie.r.nd
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.xt.r xt(JsonReader jsonReader, float f6) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z5 = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z5) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (arrayList.size() == 4 && arrayList.get(0).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add(arrayList.get(1));
            arrayList.add(arrayList.get(2));
            arrayList.add(arrayList.get(3));
            this.f23502j = 2;
        }
        if (z5) {
            jsonReader.endArray();
        }
        if (this.f23502j == -1) {
            this.f23502j = arrayList.size() / 4;
        }
        int i6 = this.f23502j;
        float[] fArr = new float[i6];
        int[] iArr = new int[i6];
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < this.f23502j * 4; i9++) {
            int i10 = i9 / 4;
            double floatValue = arrayList.get(i9).floatValue();
            int i11 = i9 % 4;
            if (i11 == 0) {
                if (i10 > 0) {
                    float f7 = (float) floatValue;
                    if (fArr[i10 - 1] >= f7) {
                        fArr[i10] = f7 + 0.01f;
                    }
                }
                fArr[i10] = (float) floatValue;
            } else if (i11 == 1) {
                i7 = (int) (floatValue * 255.0d);
            } else if (i11 == 2) {
                i8 = (int) (floatValue * 255.0d);
            } else if (i11 == 3) {
                iArr[i10] = Color.argb(255, i7, i8, (int) (floatValue * 255.0d));
            }
        }
        return j(new com.bytedance.adsdk.lottie.model.xt.r(fArr, iArr), arrayList);
    }

    public az(int i6) {
        this.f23502j = i6;
    }

    private com.bytedance.adsdk.lottie.model.xt.r j(com.bytedance.adsdk.lottie.model.xt.r rVar, List<Float> list) {
        int i6 = this.f23502j * 4;
        if (list.size() <= i6) {
            return rVar;
        }
        float[] j6 = rVar.j();
        int[] xt = rVar.xt();
        int size = (list.size() - i6) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i7 = 0;
        while (i6 < list.size()) {
            if (i6 % 2 == 0) {
                fArr[i7] = list.get(i6).floatValue();
            } else {
                fArr2[i7] = list.get(i6).floatValue();
                i7++;
            }
            i6++;
        }
        float[] j7 = j(rVar.j(), fArr);
        int length = j7.length;
        int[] iArr = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            float f6 = j7[i8];
            int binarySearch = Arrays.binarySearch(j6, f6);
            int binarySearch2 = Arrays.binarySearch(fArr, f6);
            if (binarySearch >= 0 && binarySearch2 <= 0) {
                iArr[i8] = j(f6, xt[binarySearch], fArr, fArr2);
            } else {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                iArr[i8] = j(f6, fArr2[binarySearch2], j6, xt);
            }
        }
        return new com.bytedance.adsdk.lottie.model.xt.r(j7, iArr);
    }

    int j(float f6, float f7, float[] fArr, int[] iArr) {
        if (iArr.length >= 2 && f6 != fArr[0]) {
            for (int i6 = 1; i6 < fArr.length; i6++) {
                float f8 = fArr[i6];
                if (f8 >= f6 || i6 == fArr.length - 1) {
                    int i7 = i6 - 1;
                    float f9 = fArr[i7];
                    float f10 = (f6 - f9) / (f8 - f9);
                    int i8 = iArr[i6];
                    int i9 = iArr[i7];
                    return Color.argb((int) (f7 * 255.0f), com.bytedance.adsdk.lottie.up.cw.j(f10, Color.red(i9), Color.red(i8)), com.bytedance.adsdk.lottie.up.cw.j(f10, Color.green(i9), Color.green(i8)), com.bytedance.adsdk.lottie.up.cw.j(f10, Color.blue(i9), Color.blue(i8)));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return iArr[0];
    }

    private int j(float f6, int i6, float[] fArr, float[] fArr2) {
        float j6;
        if (fArr2.length >= 2 && f6 > fArr[0]) {
            for (int i7 = 1; i7 < fArr.length; i7++) {
                float f7 = fArr[i7];
                if (f7 >= f6 || i7 == fArr.length - 1) {
                    if (f7 <= f6) {
                        j6 = fArr2[i7];
                    } else {
                        int i8 = i7 - 1;
                        float f8 = fArr[i8];
                        j6 = com.bytedance.adsdk.lottie.up.tl.j(fArr2[i8], fArr2[i7], (f6 - f8) / (f7 - f8));
                    }
                    return Color.argb((int) (j6 * 255.0f), Color.red(i6), Color.green(i6), Color.blue(i6));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i6), Color.green(i6), Color.blue(i6));
    }

    protected static float[] j(float[] fArr, float[] fArr2) {
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            float f6 = i7 < fArr.length ? fArr[i7] : Float.NaN;
            float f7 = i8 < fArr2.length ? fArr2[i8] : Float.NaN;
            if (!Float.isNaN(f7) && f6 >= f7) {
                if (!Float.isNaN(f6) && f7 >= f6) {
                    fArr3[i9] = f6;
                    i7++;
                    i8++;
                    i6++;
                } else {
                    fArr3[i9] = f7;
                    i8++;
                }
            } else {
                fArr3[i9] = f6;
                i7++;
            }
        }
        return i6 == 0 ? fArr3 : Arrays.copyOf(fArr3, length - i6);
    }
}
