package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
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
public final class m7 extends q7 {

    /* renamed from: c, reason: collision with root package name */
    private Context f6761c;

    /* renamed from: d, reason: collision with root package name */
    private String f6762d;

    /* renamed from: e, reason: collision with root package name */
    private k6 f6763e;

    /* renamed from: f, reason: collision with root package name */
    private Object[] f6764f;

    private String d() {
        try {
            return String.format(q4.u(this.f6762d), this.f6764f);
        } catch (Throwable th) {
            th.printStackTrace();
            v5.p(th, "ofm", "gpj");
            return "";
        }
    }

    public m7(Context context, q7 q7Var, k6 k6Var, String str, Object... objArr) {
        super(q7Var);
        this.f6761c = context;
        this.f6762d = str;
        this.f6763e = k6Var;
        this.f6764f = objArr;
    }

    @Override // com.amap.api.col.p0003l.q7
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String g6 = q4.g(bArr);
        if (TextUtils.isEmpty(g6)) {
            return null;
        }
        return q4.o("{\"pinfo\":\"" + q4.g(this.f6763e.b(q4.o(d()))) + "\",\"els\":[" + g6 + "]}");
    }
}
