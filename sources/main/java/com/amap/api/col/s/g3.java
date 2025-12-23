package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g3 {

    /* renamed from: a, reason: collision with root package name */
    private Context f8096a;

    /* renamed from: b, reason: collision with root package name */
    private String f8097b;

    /* renamed from: c, reason: collision with root package name */
    private String f8098c;

    /* renamed from: d, reason: collision with root package name */
    private String f8099d;

    /* renamed from: e, reason: collision with root package name */
    private String f8100e;

    public final byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream;
        int i6 = 0;
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            j1.k(byteArrayOutputStream, this.f8098c);
            j1.k(byteArrayOutputStream, this.f8099d);
            j1.k(byteArrayOutputStream, this.f8097b);
            j1.k(byteArrayOutputStream, String.valueOf(c1.D(this.f8096a)));
            try {
                i6 = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
            }
            byteArrayOutputStream.write(c(i6));
            byteArrayOutputStream.write(d(this.f8100e));
            byteArrayOutputStream.write(j1.o(this.f8100e));
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                g2.o(th, "se", "tds");
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                return bArr;
            } catch (Throwable th4) {
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th4;
            }
        }
        return bArr;
    }

    private static byte[] c(int i6) {
        return new byte[]{(byte) ((i6 >> 24) & 255), (byte) ((i6 >> 16) & 255), (byte) ((i6 >> 8) & 255), (byte) (i6 & 255)};
    }

    public g3(Context context, String str, String str2, String str3) throws bv {
        if (!TextUtils.isEmpty(str3) && str3.length() <= 256) {
            this.f8096a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8098c = str;
            this.f8099d = str2;
            this.f8097b = str3;
            return;
        }
        throw new bv("无效的参数 - IllegalArgumentException");
    }

    private byte[] d(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{0, 0};
        }
        byte[] o5 = j1.o(this.f8100e);
        if (o5 == null) {
            return new byte[]{0, 0};
        }
        return j1.n(o5.length);
    }

    public final void a(String str) throws bv {
        if (!TextUtils.isEmpty(str) && str.length() <= 65536) {
            this.f8100e = str;
            return;
        }
        throw new bv("无效的参数 - IllegalArgumentException");
    }
}
