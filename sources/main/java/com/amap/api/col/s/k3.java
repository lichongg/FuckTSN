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
public final class k3 extends p3 {

    /* renamed from: c, reason: collision with root package name */
    private n2 f8213c;

    public k3() {
        this.f8213c = new p2();
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f8213c.b(bArr);
    }

    public k3(p3 p3Var) {
        super(p3Var);
        this.f8213c = new p2();
    }
}
