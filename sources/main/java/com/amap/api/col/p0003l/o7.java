package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class o7 extends q7 {

    /* renamed from: d, reason: collision with root package name */
    public static int f6877d = 13;

    /* renamed from: e, reason: collision with root package name */
    public static int f6878e = 6;

    /* renamed from: c, reason: collision with root package name */
    private Context f6879c;

    private static byte[] d(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            q4.k(byteArrayOutputStream, "1.2." + f6877d + "." + f6878e);
            q4.k(byteArrayOutputStream, "Android");
            q4.k(byteArrayOutputStream, i4.P());
            q4.k(byteArrayOutputStream, i4.I());
            q4.k(byteArrayOutputStream, i4.F(context));
            q4.k(byteArrayOutputStream, Build.MANUFACTURER);
            q4.k(byteArrayOutputStream, Build.MODEL);
            q4.k(byteArrayOutputStream, Build.DEVICE);
            q4.k(byteArrayOutputStream, i4.U());
            q4.k(byteArrayOutputStream, f4.g(context));
            q4.k(byteArrayOutputStream, f4.h(context));
            q4.k(byteArrayOutputStream, f4.j(context));
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

    @Override // com.amap.api.col.p0003l.q7
    protected final byte[] b(byte[] bArr) {
        byte[] d6 = d(this.f6879c);
        byte[] bArr2 = new byte[d6.length + bArr.length];
        System.arraycopy(d6, 0, bArr2, 0, d6.length);
        System.arraycopy(bArr, 0, bArr2, d6.length, bArr.length);
        return bArr2;
    }

    public o7(Context context, q7 q7Var) {
        super(q7Var);
        this.f6879c = context;
    }
}
