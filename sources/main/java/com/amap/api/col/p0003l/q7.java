package com.amap.api.col.p0003l;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class q7 {

    /* renamed from: a, reason: collision with root package name */
    q7 f6986a;

    /* renamed from: b, reason: collision with root package name */
    byte[] f6987b = null;

    q7() {
    }

    protected abstract byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] b6 = b(this.f6987b);
        q7 q7Var = this.f6986a;
        if (q7Var == null) {
            return b6;
        }
        q7Var.f6987b = b6;
        return q7Var.a();
    }

    q7(q7 q7Var) {
        this.f6986a = q7Var;
    }

    public void c(byte[] bArr) {
    }
}
