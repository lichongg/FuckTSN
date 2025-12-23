package com.amap.api.col.p0003l;

import android.content.Context;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class s6 extends l4 {

    /* renamed from: a, reason: collision with root package name */
    protected Context f7245a;

    /* renamed from: b, reason: collision with root package name */
    protected p4 f7246b;

    /* renamed from: c, reason: collision with root package name */
    protected byte[] f7247c;

    protected static byte[] a(byte[] bArr) {
        return q4.n(bArr.length);
    }

    public abstract byte[] c();

    public abstract byte[] d();

    public boolean f() {
        return true;
    }

    protected boolean h() {
        return false;
    }

    private static byte[] i() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(q4.o("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                r5.e(th2, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th3) {
                    r5.e(th3, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    r5.e(th4, "bre", "gbh");
                }
            }
        }
    }

    private byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (f()) {
                Context context = this.f7245a;
                boolean h6 = h();
                p4 p4Var = this.f7246b;
                byte[] f6 = h4.f(context, h6, p4Var != null && "navi".equals(p4Var.a()));
                byteArrayOutputStream.write(a(f6));
                byteArrayOutputStream.write(f6);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] o5 = q4.o(e());
            if (o5 == null || o5.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(o5));
                byteArrayOutputStream.write(o5);
            }
            byte[] o6 = q4.o(g());
            if (o6 == null || o6.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(o6));
                byteArrayOutputStream.write(o6);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                r5.e(th2, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    r5.e(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    r5.e(th4, "bre", "gred");
                }
            }
        }
    }

    private byte[] k() {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c6 = c();
            try {
                if (c6 != null && c6.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(a(c6));
                    byteArrayOutputStream.write(c6);
                    byteArray = byteArrayOutputStream.toByteArray();
                    return byteArray;
                }
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
            byteArrayOutputStream.write(new byte[]{0});
            byteArray = byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            try {
                r5.e(th2, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    r5.e(th3, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    r5.e(th4, "bre", "grrd");
                }
            }
        }
    }

    private byte[] l() {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] d6 = d();
            try {
                if (d6 != null && d6.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] g6 = h4.g(d6);
                    byteArrayOutputStream.write(a(g6));
                    byteArrayOutputStream.write(g6);
                    byteArray = byteArrayOutputStream.toByteArray();
                    return byteArray;
                }
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
            byteArrayOutputStream.write(new byte[]{0});
            byteArray = byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            try {
                r5.e(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    r5.e(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    r5.e(th4, "bre", "gred");
                }
            }
        }
    }

    protected String e() {
        return "2.1";
    }

    public String g() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.f7246b.f(), this.f7246b.a());
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        byte[] bArr = this.f7247c;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(i());
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(k());
            byteArrayOutputStream.write(l());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f7247c = byteArray;
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                r5.e(th2, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th3) {
                    r5.e(th3, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    r5.e(th4, "bre", "geb");
                }
            }
        }
    }

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getParams() {
        String j6 = f4.j(this.f7245a);
        String a6 = h4.a();
        String c6 = h4.c(this.f7245a, a6, "key=".concat(String.valueOf(j6)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a6);
        hashMap.put("key", j6);
        hashMap.put("scode", c6);
        return hashMap;
    }

    public s6(Context context, p4 p4Var) {
        if (context != null) {
            this.f7245a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f7246b = p4Var;
        setBinary(true);
    }
}
