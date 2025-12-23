package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.s6;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class d extends s6 {

    /* renamed from: d, reason: collision with root package name */
    Map<String, String> f10169d;

    /* renamed from: e, reason: collision with root package name */
    String f10170e;

    /* renamed from: f, reason: collision with root package name */
    String f10171f;

    /* renamed from: g, reason: collision with root package name */
    byte[] f10172g;

    /* renamed from: h, reason: collision with root package name */
    byte[] f10173h;

    /* renamed from: i, reason: collision with root package name */
    boolean f10174i;

    /* renamed from: j, reason: collision with root package name */
    String f10175j;

    /* renamed from: k, reason: collision with root package name */
    Map<String, String> f10176k;

    /* renamed from: p, reason: collision with root package name */
    boolean f10177p;

    /* renamed from: q, reason: collision with root package name */
    private String f10178q;

    public final void a(Map<String, String> map) {
        this.f10176k = map;
    }

    public final void b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                if (bArr != null) {
                    try {
                        byteArrayOutputStream2.write(s6.a(bArr));
                        byteArrayOutputStream2.write(bArr);
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        try {
                            th.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                }
                this.f10173h = byteArrayOutputStream2.toByteArray();
                byteArrayOutputStream2.close();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        }
    }

    public final void c(byte[] bArr) {
        this.f10172g = bArr;
    }

    @Override // com.amap.api.col.p0003l.s6
    public final byte[] d() {
        return this.f10173h;
    }

    public final void a(String str) {
        this.f10175j = str;
    }

    public final void c(String str) {
        this.f10171f = str;
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f10178q = "";
        } else {
            this.f10178q = str;
        }
    }

    @Override // com.amap.api.col.p0003l.s6
    public final boolean f() {
        return this.f10174i;
    }

    @Override // com.amap.api.col.p0003l.s6
    public final String g() {
        return this.f10175j;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPDNSName() {
        return this.f10178q;
    }

    @Override // com.amap.api.col.p0003l.l4, com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return this.f10171f;
    }

    @Override // com.amap.api.col.p0003l.s6, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return this.f10176k;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        return this.f10169d;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getSDKName() {
        return "loc";
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return this.f10170e;
    }

    @Override // com.amap.api.col.p0003l.s6
    protected final boolean h() {
        return this.f10177p;
    }

    public d(Context context, p4 p4Var) {
        super(context, p4Var);
        this.f10169d = null;
        this.f10178q = "";
        this.f10170e = "";
        this.f10171f = "";
        this.f10172g = null;
        this.f10173h = null;
        this.f10174i = false;
        this.f10175j = null;
        this.f10176k = null;
        this.f10177p = false;
    }

    public final void a(boolean z5) {
        this.f10174i = z5;
    }

    @Override // com.amap.api.col.p0003l.s6
    public final byte[] c() {
        return this.f10172g;
    }

    public final void b(String str) {
        this.f10170e = str;
    }

    public final void b(Map<String, String> map) {
        this.f10169d = map;
    }

    public final void b(boolean z5) {
        this.f10177p = z5;
    }
}
