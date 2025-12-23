package com.amap.api.col.s;

import android.content.Context;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class v2 extends f1 {

    /* renamed from: m, reason: collision with root package name */
    protected Context f8575m;

    /* renamed from: n, reason: collision with root package name */
    protected i1 f8576n;

    /* renamed from: o, reason: collision with root package name */
    protected byte[] f8577o;

    private static byte[] K(byte[] bArr) {
        return j1.n(bArr.length);
    }

    public abstract byte[] L();

    private byte[] H() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            Context context = this.f8575m;
            i1 i1Var = this.f8576n;
            byte[] f6 = a1.f(context, i1Var != null && "navi".equals(i1Var.d()));
            byteArrayOutputStream.write(K(f6));
            byteArrayOutputStream.write(f6);
            byte[] o5 = j1.o(M());
            if (o5 == null || o5.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(K(o5));
                byteArrayOutputStream.write(o5);
            }
            byte[] o6 = j1.o(N());
            if (o6 == null || o6.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(K(o6));
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
                d2.e(th2, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    d2.e(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    d2.e(th4, "bre", "gred");
                }
            }
        }
    }

    private static byte[] I() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                d2.e(th2, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    d2.e(th3, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    d2.e(th4, "bre", "grrd");
                }
            }
        }
    }

    private byte[] J() {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] L = L();
            try {
                if (L != null && L.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] g6 = a1.g(L);
                    byteArrayOutputStream.write(K(g6));
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
                d2.e(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    d2.e(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    d2.e(th4, "bre", "gred");
                }
            }
        }
    }

    private static byte[] O() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(j1.o("PANDORA$"));
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
                d2.e(th2, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th3) {
                    d2.e(th3, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    d2.e(th4, "bre", "gbh");
                }
            }
        }
    }

    protected String M() {
        return "2.1";
    }

    public final String N() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.f8576n.f(), this.f8576n.d());
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> o() {
        String i6 = x0.i(this.f8575m);
        String a6 = a1.a();
        String c6 = a1.c(this.f8575m, a6, "key=".concat(String.valueOf(i6)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a6);
        hashMap.put("key", i6);
        hashMap.put("scode", c6);
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        byte[] bArr = this.f8577o;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(O());
            byteArrayOutputStream.write(H());
            byteArrayOutputStream.write(I());
            byteArrayOutputStream.write(J());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f8577o = byteArray;
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                d2.e(th2, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th3) {
                    d2.e(th3, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    d2.e(th4, "bre", "geb");
                }
            }
        }
    }

    public v2(Context context, i1 i1Var) {
        if (context != null) {
            this.f8575m = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f8576n = i1Var;
        y();
    }
}
