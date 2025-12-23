package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class d5 {

    /* renamed from: a, reason: collision with root package name */
    public List<i2> f34124a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f34125b = 0;

    public void a(boolean z5, byte[] bArr, int i6, int i7, int i8, boolean z6) {
        float[] multiBarcodeDetect = LoadOpencvJNIUtil.multiBarcodeDetect(bArr, i6, i7, i8, z6);
        if (multiBarcodeDetect != null) {
            this.f34125b = multiBarcodeDetect.length / 10;
        } else {
            this.f34125b = 0;
        }
        for (int i9 = 0; i9 < this.f34125b; i9++) {
            int i10 = i9 * 10;
            if (w7.a(multiBarcodeDetect, i10)) {
                int i11 = i10 + 1;
                if (w7.a(multiBarcodeDetect, i11)) {
                    int i12 = i10 + 2;
                    if (w7.a(multiBarcodeDetect, i12)) {
                        int i13 = i10 + 3;
                        if (w7.a(multiBarcodeDetect, i13)) {
                            int i14 = i10 + 4;
                            if (w7.a(multiBarcodeDetect, i14)) {
                                int i15 = i10 + 5;
                                if (w7.a(multiBarcodeDetect, i15)) {
                                    int i16 = i10 + 6;
                                    if (w7.a(multiBarcodeDetect, i16)) {
                                        int i17 = i10 + 7;
                                        if (w7.a(multiBarcodeDetect, i17)) {
                                            int i18 = i10 + 8;
                                            if (w7.a(multiBarcodeDetect, i18)) {
                                                int i19 = i10 + 9;
                                                if (w7.a(multiBarcodeDetect, i19)) {
                                                    this.f34124a.add(new i2(z5, multiBarcodeDetect[i10], multiBarcodeDetect[i11], multiBarcodeDetect[i12], multiBarcodeDetect[i13], multiBarcodeDetect[i14], multiBarcodeDetect[i15], multiBarcodeDetect[i16], multiBarcodeDetect[i17], multiBarcodeDetect[i18], multiBarcodeDetect[i19]));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
