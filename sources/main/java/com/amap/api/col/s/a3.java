package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.dz;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class a3<T, V> extends f1 {

    /* renamed from: n, reason: collision with root package name */
    protected T f7863n;

    /* renamed from: q, reason: collision with root package name */
    protected Context f7866q;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f7862m = true;

    /* renamed from: o, reason: collision with root package name */
    protected int f7864o = 1;

    /* renamed from: p, reason: collision with root package name */
    protected String f7865p = "";

    /* renamed from: r, reason: collision with root package name */
    private int f7867r = 1;

    /* renamed from: s, reason: collision with root package name */
    protected String f7868s = "";

    private byte[] L(int i6, z2 z2Var, f1 f1Var) throws bv {
        g(i6 == 1 ? dz.c.HTTP : dz.c.HTTPS);
        b3 d6 = this.f7862m ? u2.d(f1Var) : z2.n(f1Var);
        if (d6 == null) {
            return null;
        }
        byte[] bArr = d6.f7876a;
        this.f7868s = d6.f7879d;
        return bArr;
    }

    protected abstract V I(String str) throws AMapException;

    protected V J(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e6) {
            j4.i(e6, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        j4.l(str);
        return I(str);
    }

    protected abstract String M();

    protected n.b P() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public Map<String, String> o() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public Map<String, String> p() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V H() throws AMapException {
        V v5;
        n.c a6;
        Object obj;
        try {
            n.b P = P();
            boolean h6 = n.b().h(P);
            boolean z5 = false;
            int i6 = 0;
            V v6 = null;
            boolean z6 = false;
            while (i6 < this.f7864o) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    try {
                        try {
                            int protocol = ServiceSettings.getInstance().getProtocol();
                            e1.a().c(this.f7866q);
                            z2 l6 = z2.l();
                            if (h6 && (a6 = n.b().a(P)) != null && (obj = a6.f8262a) != 0) {
                                try {
                                    x.e(this.f7866q, P.f8260a, a6.f8263b);
                                    v6 = obj;
                                    z6 = true;
                                } catch (bv e6) {
                                    e = e6;
                                    v6 = obj;
                                    z6 = true;
                                    x.d(this.f7866q, R(), System.currentTimeMillis() - currentTimeMillis, z5);
                                    i6++;
                                    if (i6 >= this.f7864o) {
                                        if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(e.a()) && !com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                            throw new AMapException(e.a(), 1, e.c());
                                        }
                                        throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                    }
                                    try {
                                        Thread.sleep(this.f7867r * 1000);
                                        if (h6 && !z6) {
                                            n.b().e(P, v6);
                                        }
                                        z5 = false;
                                    } catch (InterruptedException unused) {
                                        if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                            throw new AMapException(e.a(), 1, e.c());
                                        }
                                        throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                    }
                                } catch (AMapException e7) {
                                    e = e7;
                                    v6 = obj;
                                    z6 = true;
                                    x.d(this.f7866q, R(), System.currentTimeMillis() - currentTimeMillis, z5);
                                    i6++;
                                    if (i6 >= this.f7864o) {
                                        throw e;
                                    }
                                    if (h6 && !z6) {
                                        n.b().e(P, v6);
                                    }
                                    z5 = false;
                                } catch (Throwable th) {
                                    th = th;
                                    v5 = obj;
                                    z6 = true;
                                    if (h6) {
                                        n.b().e(P, v5);
                                    }
                                    throw th;
                                }
                            }
                            if (v6 == null) {
                                byte[] L = L(protocol, l6, this);
                                long currentTimeMillis2 = System.currentTimeMillis();
                                v6 = N(L);
                                x.d(this.f7866q, R(), currentTimeMillis2 - currentTimeMillis, true);
                            }
                            i6 = this.f7864o;
                        } catch (bv e8) {
                            e = e8;
                        } catch (AMapException e9) {
                            e = e9;
                        }
                        if (h6 && !z6) {
                            n.b().e(P, v6);
                        }
                        z5 = false;
                    } catch (Throwable th2) {
                        th = th2;
                        v5 = v6;
                        if (h6 && !z6) {
                            n.b().e(P, v5);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    v5 = null;
                }
            }
            return v6;
        } catch (AMapException e10) {
            throw e10;
        } catch (Throwable th4) {
            th4.printStackTrace();
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    private void K(Context context, T t5) {
        this.f7866q = context;
        this.f7863n = t5;
        this.f7864o = 1;
        j(ServiceSettings.getInstance().getSoTimeOut());
        d(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    private String Q() {
        return this.f7868s;
    }

    public final V O() throws AMapException {
        if (this.f7863n == null) {
            return null;
        }
        try {
            return H();
        } catch (AMapException e6) {
            x.f(R(), Q(), e6);
            throw e6;
        }
    }

    @Override // com.amap.api.col.s.dz
    public final String m() {
        return "sea";
    }

    public a3(Context context, T t5) {
        K(context, t5);
    }

    private V N(byte[] bArr) throws AMapException {
        return J(bArr);
    }

    private String R() {
        String a6 = a();
        if (a6 != null) {
            try {
                int indexOf = a6.indexOf(".com/");
                int indexOf2 = a6.indexOf("?");
                if (indexOf2 == -1) {
                    return a6.substring(indexOf + 5);
                }
                return a6.substring(indexOf + 5, indexOf2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
