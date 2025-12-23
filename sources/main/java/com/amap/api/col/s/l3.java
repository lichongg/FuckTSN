package com.amap.api.col.s;

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
public final class l3 extends p3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f8229c;

    /* renamed from: d, reason: collision with root package name */
    private String f8230d;

    /* renamed from: e, reason: collision with root package name */
    private n2 f8231e;

    /* renamed from: f, reason: collision with root package name */
    private Object[] f8232f;

    private String d() {
        try {
            return String.format(j1.t(this.f8230d), this.f8232f);
        } catch (Throwable th) {
            th.printStackTrace();
            g2.o(th, "ofm", "gpj");
            return "";
        }
    }

    public l3(Context context, p3 p3Var, n2 n2Var, String str, Object... objArr) {
        super(p3Var);
        this.f8229c = context;
        this.f8230d = str;
        this.f8231e = n2Var;
        this.f8232f = objArr;
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String g6 = j1.g(bArr);
        if (TextUtils.isEmpty(g6)) {
            return null;
        }
        return j1.o("{\"pinfo\":\"" + j1.g(this.f8231e.b(j1.o(d()))) + "\",\"els\":[" + g6 + "]}");
    }
}
