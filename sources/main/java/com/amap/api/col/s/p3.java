package com.amap.api.col.s;

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
public abstract class p3 {

    /* renamed from: a, reason: collision with root package name */
    p3 f8326a;

    /* renamed from: b, reason: collision with root package name */
    byte[] f8327b = null;

    p3() {
    }

    protected abstract byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] b6 = b(this.f8327b);
        p3 p3Var = this.f8326a;
        if (p3Var == null) {
            return b6;
        }
        p3Var.f8327b = b6;
        return p3Var.a();
    }

    p3(p3 p3Var) {
        this.f8326a = p3Var;
    }

    public void c(byte[] bArr) {
    }
}
