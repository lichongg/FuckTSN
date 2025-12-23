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
public final class l7 extends q7 {

    /* renamed from: c, reason: collision with root package name */
    private k6 f6742c;

    public l7() {
        this.f6742c = new m6();
    }

    @Override // com.amap.api.col.p0003l.q7
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f6742c.b(bArr);
    }

    public l7(q7 q7Var) {
        super(q7Var);
        this.f6742c = new m6();
    }
}
