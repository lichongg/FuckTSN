package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.scankit.util.OpencvJNI;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h4 extends IRemoteFrameDecoderDelegate.Stub {

    /* renamed from: d, reason: collision with root package name */
    private static volatile h4 f34340d = new h4();

    /* renamed from: a, reason: collision with root package name */
    Point f34341a;

    /* renamed from: b, reason: collision with root package name */
    int f34342b = 0;

    /* renamed from: c, reason: collision with root package name */
    Rect f34343c;

    public static h4 a() {
        return f34340d;
    }

    public synchronized Rect b(int i6, int i7) {
        try {
            Rect rect = new Rect(a(i6, i7));
            Point point = new Point(i6, i7);
            Point point2 = this.f34341a;
            if (point2 == null) {
                return null;
            }
            int i8 = point2.x;
            int i9 = point2.y;
            if (i8 < i9) {
                int i10 = rect.left;
                int i11 = point.y;
                rect.left = (i10 * i11) / i8;
                rect.right = (rect.right * i11) / i8;
                int i12 = rect.top;
                int i13 = point.x;
                rect.top = (i12 * i13) / i9;
                rect.bottom = (rect.bottom * i13) / i9;
            } else {
                int i14 = rect.top;
                int i15 = point.y;
                rect.top = (i14 * i15) / i9;
                rect.bottom = (rect.bottom * i15) / i9;
                int i16 = rect.left;
                int i17 = point.x;
                rect.left = (i16 * i17) / i8;
                rect.right = (rect.right * i17) / i8;
            }
            return rect;
        } catch (Throwable th) {
            throw th;
        }
    }

    private e6 a(byte[] bArr, int i6, int i7, int i8) {
        if (i8 == 0) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i9 = 0; i9 < i7; i9++) {
                for (int i10 = 0; i10 < i6; i10++) {
                    bArr2[(((i10 * i7) + i7) - i9) - 1] = bArr[(i9 * i6) + i10];
                }
            }
            return a(bArr2, i7, i6);
        }
        if (i8 == 2) {
            byte[] bArr3 = new byte[bArr.length];
            for (int i11 = 0; i11 < i7; i11++) {
                for (int i12 = 0; i12 < i6; i12++) {
                    bArr3[(((i6 - 1) - i12) * i7) + i11] = bArr[(i11 * i6) + i12];
                }
            }
            return a(bArr3, i7, i6);
        }
        if (i8 != 3) {
            return a(bArr, i6, i7);
        }
        byte[] bArr4 = new byte[bArr.length];
        for (int i13 = 0; i13 < i7; i13++) {
            for (int i14 = 0; i14 < i6; i14++) {
                bArr4[(((((i7 - 1) - i13) * i6) + i6) - 1) - i14] = bArr[(i13 * i6) + i14];
            }
        }
        return a(bArr4, i6, i7);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate
    public s6[] decode(byte[] bArr, int i6, int i7, int i8, int i9, IObjectWrapper iObjectWrapper) throws RemoteException {
        boolean z5;
        boolean z6;
        boolean z7;
        if (!r3.A) {
            OpencvJNI.init();
        }
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            z5 = true;
            z6 = false;
            z7 = false;
        } else {
            Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
            this.f34341a = (Point) bundle.getParcelable("Screen");
            this.f34343c = (Rect) bundle.getParcelable("Rect");
            z6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.USE_APK, false);
            z7 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.SUPPORT_ROLLBACK, false);
            z5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.PARSE_RESULT, true);
        }
        r3.f34735f = z5;
        if (z7 && !r3.f34730a && z6) {
            return new s6[]{r6.c()};
        }
        if (this.f34343c == null) {
            this.f34343c = new Rect(-1, -1, -1, -1);
        }
        if (this.f34341a == null) {
            this.f34341a = new Point(PredefinedCaptureConfigurations.f35652s, PredefinedCaptureConfigurations.f35653t);
        }
        e6 a6 = a(bArr, i6, i7, i8);
        byte[] b6 = a6.b();
        x6 x6Var = new x6(a6.c(), a6.a(), i9);
        int i10 = this.f34342b;
        this.f34342b = i10 + 1;
        return m1.c(b6, x6Var.a(i10));
    }

    private h4() {
    }

    public synchronized Rect a(int i6, int i7) {
        int min;
        int i8;
        int i9;
        min = Math.min(i6, i7);
        i8 = (i6 - min) / 2;
        i9 = (i7 - min) / 2;
        return new Rect(i8, i9, i8 + min, min + i9);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.e6 a(byte[] r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.h4.a(byte[], int, int):com.huawei.hms.scankit.p.e6");
    }
}
