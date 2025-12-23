package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.w3;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class r6 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile r6 f34757a;

    public static r6 a() {
        if (f34757a == null) {
            synchronized (r6.class) {
                try {
                    if (f34757a == null) {
                        f34757a = new r6();
                    }
                } finally {
                }
            }
        }
        return f34757a;
    }

    public HmsScan[] b(Bitmap bitmap, int i6, boolean z5, w3 w3Var) {
        w3.c cVar;
        if (w3Var != null) {
            w3Var.a("single");
            cVar = w3Var.a(z5, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                cVar.a(-1005);
            }
        } else {
            cVar = null;
        }
        s6[] b6 = m1.b(bitmap, new x6(i6, z5));
        o4.d("Scankit", "start totalParseResult");
        HmsScan[] a6 = y6.a(b6);
        if (w3Var != null) {
            w3Var.a(a6, cVar);
        }
        return a6;
    }

    public static s6 c() {
        return new s6("", null, new u6[]{new u6(-2.0f, -2.0f), new u6(-2.0f, -2.0f), new u6(-2.0f, -2.0f), new u6(-2.0f, -2.0f)}, BarcodeFormat.NONE);
    }

    public HmsScanResult a(byte[] bArr, int i6, int i7, int i8, boolean z5, boolean z6, w3 w3Var) {
        w3.c cVar;
        if (w3Var != null) {
            w3Var.a("single");
            cVar = w3Var.a(z5, i7 * i6);
            if (i7 < 30 || i6 < 30) {
                cVar.a(-1005);
            }
        } else {
            cVar = null;
        }
        w3.c cVar2 = cVar;
        o4.d("Scankit", "start decodeSingleCode");
        s6[] c6 = m1.c(bArr, new x6(i6, i7, i8, true, z5));
        o4.d("Scankit", "start totalParseResult");
        HmsScan[] a6 = y6.a(c6);
        o4.d("Scankit", "end totalParseResult");
        if (w3Var != null) {
            w3Var.a(a6, cVar2);
        }
        if (!z6) {
            o4.d("Scankit", "start hmsResultTrans");
            a6 = w7.a(a6);
            o4.d("Scankit", "end hmsResultTrans");
        }
        int i9 = i8 == 0 ? HmsScanBase.ALL_SCAN_TYPE : i8;
        if (r3.f34733d) {
            return new HmsScanResult(4099, a6);
        }
        if (r3.f34734e) {
            return new HmsScanResult(4100, a6);
        }
        if (r3.f34737h && a6.length == 0) {
            int i10 = HmsScanBase.QRCODE_SCAN_TYPE;
            if ((i9 & i10) == i10) {
                return new HmsScanResult(4097, a6);
            }
        }
        if (a6.length == 0) {
            return new HmsScanResult(4096, a6);
        }
        if (a6.length > 0 && !TextUtils.isEmpty(a6[0].getOriginalValue())) {
            return new HmsScanResult(0, a6);
        }
        if (a6.length > 0 && a6[0].getZoomValue() > 1.0d) {
            return new HmsScanResult(4098, a6);
        }
        return new HmsScanResult(4096, new HmsScan[0]);
    }

    public static HmsScan b() {
        return new HmsScan("", HmsScanBase.FORMAT_UNKNOWN, "", HmsScan.PURE_TEXT_FORM, null, new Point[]{new Point(-2, -2), new Point(-2, -2), new Point(-2, -2), new Point(-2, -2)}, null, null).setZoomValue(1.0d);
    }

    public HmsScan[] a(Bitmap bitmap, int i6, boolean z5, w3 w3Var) {
        w3.c cVar;
        o4.d("Scankit", "start decodeWithBitmapWorkMulti");
        if (w3Var != null) {
            w3Var.a("multi");
            cVar = w3Var.a(z5, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                cVar.a(-1005);
            }
        } else {
            cVar = null;
        }
        o4.d("Scankit", "end decodeWithBitmapWorkMulti");
        s6[] a6 = m1.a(bitmap, new x6(i6, z5));
        o4.d("Scankit", "start totalParseResult");
        HmsScan[] a7 = y6.a(a6);
        o4.d("Scankit", "end totalParseResult");
        if (w3Var != null) {
            w3Var.a(a7, cVar);
        }
        return a7;
    }

    public HmsScan[] a(ByteBuffer byteBuffer, int i6, int i7, int i8, boolean z5, w3 w3Var) {
        w3.c cVar;
        if (w3Var != null) {
            w3Var.a("multi");
            int i9 = i7 * i6;
            cVar = w3Var.a(z5, i9);
            if (i6 >= 30 && i7 >= 30) {
                if (byteBuffer.array().length < i9) {
                    cVar.a(-1008);
                }
            } else {
                cVar.a(IMediaPlayer.MEDIA_ERROR_MALFORMED);
            }
        } else {
            cVar = null;
        }
        HmsScan[] a6 = y6.a(m1.a(byteBuffer, new x6(i6, i7, i8, true, z5)));
        if (w3Var != null) {
            w3Var.a(a6, cVar);
        }
        return a6;
    }
}
