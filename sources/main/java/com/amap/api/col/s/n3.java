package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class n3 extends p3 {

    /* renamed from: d, reason: collision with root package name */
    public static int f8272d = 13;

    /* renamed from: e, reason: collision with root package name */
    public static int f8273e = 6;

    /* renamed from: c, reason: collision with root package name */
    private Context f8274c;

    private static byte[] d(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            j1.k(byteArrayOutputStream, "1.2." + f8272d + "." + f8273e);
            j1.k(byteArrayOutputStream, "Android");
            j1.k(byteArrayOutputStream, c1.H());
            j1.k(byteArrayOutputStream, c1.C());
            j1.k(byteArrayOutputStream, c1.y(context));
            j1.k(byteArrayOutputStream, Build.MANUFACTURER);
            j1.k(byteArrayOutputStream, Build.MODEL);
            j1.k(byteArrayOutputStream, Build.DEVICE);
            j1.k(byteArrayOutputStream, c1.M());
            j1.k(byteArrayOutputStream, x0.f(context));
            j1.k(byteArrayOutputStream, x0.g(context));
            j1.k(byteArrayOutputStream, x0.i(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
        } finally {
            try {
                return bArr;
            } finally {
            }
        }
        return bArr;
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) {
        byte[] d6 = d(this.f8274c);
        byte[] bArr2 = new byte[d6.length + bArr.length];
        System.arraycopy(d6, 0, bArr2, 0, d6.length);
        System.arraycopy(bArr, 0, bArr2, d6.length, bArr.length);
        return bArr2;
    }

    public n3(Context context, p3 p3Var) {
        super(p3Var);
        this.f8274c = context;
    }
}
