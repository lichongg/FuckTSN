package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ck;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ca {

    /* renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f41072a;

    /* renamed from: b, reason: collision with root package name */
    private final dc f41073b;

    /* renamed from: c, reason: collision with root package name */
    private cq f41074c;

    public ca() {
        this(new ck.a());
    }

    public byte[] a(br brVar) throws bx {
        this.f41072a.reset();
        brVar.write(this.f41074c);
        return this.f41072a.toByteArray();
    }

    public ca(cs csVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f41072a = byteArrayOutputStream;
        dc dcVar = new dc(byteArrayOutputStream);
        this.f41073b = dcVar;
        this.f41074c = csVar.a(dcVar);
    }

    public String b(br brVar) throws bx {
        return new String(a(brVar));
    }

    public String a(br brVar, String str) throws bx {
        try {
            return new String(a(brVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bx("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
