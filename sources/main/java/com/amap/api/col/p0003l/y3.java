package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.AMapException;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class y3<T, V> extends g2 {

    /* renamed from: r, reason: collision with root package name */
    protected T f7754r;

    /* renamed from: t, reason: collision with root package name */
    protected Context f7756t;

    /* renamed from: u, reason: collision with root package name */
    protected String f7757u;

    /* renamed from: s, reason: collision with root package name */
    protected int f7755s = 1;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f7758v = false;

    private V n() throws fc {
        V v5 = null;
        int i6 = 0;
        while (i6 < this.f7755s) {
            try {
                setProxy(o4.c(this.f7756t));
                v5 = this.f7758v ? j(makeHttpRequestNeedHeader()) : k(makeHttpRequest());
                i6 = this.f7755s;
            } catch (fc e6) {
                i6++;
                if (i6 >= this.f7755s) {
                    throw new fc(e6.a());
                }
            } catch (fk e7) {
                i6++;
                if (i6 >= this.f7755s) {
                    if (AMapException.ERROR_CONNECTION.equals(e7.getMessage()) || AMapException.ERROR_SOCKET.equals(e7.getMessage()) || AMapException.ERROR_UNKNOWN.equals(e7.a()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e7.getMessage())) {
                        throw new fc(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                    throw new fc(e7.a());
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    if (AMapException.ERROR_CONNECTION.equals(e7.getMessage()) || AMapException.ERROR_SOCKET.equals(e7.getMessage()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e7.getMessage())) {
                        throw new fc(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                    throw new fc(e7.a());
                }
            }
        }
        return v5;
    }

    protected V f(z6 z6Var) throws fc {
        return null;
    }

    protected abstract V g(String str) throws fc;

    protected V h(byte[] bArr) throws fc {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e6) {
            e6.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        a4.c(str);
        return g(str);
    }

    protected abstract String l();

    private void i(Context context, T t5) {
        this.f7756t = context;
        this.f7754r = t5;
        this.f7755s = 1;
        setSoTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        setConnectionTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
    }

    public final V m() throws fc {
        if (this.f7754r == null) {
            return null;
        }
        try {
            return n();
        } catch (fc e6) {
            b3.D(e6);
            throw e6;
        }
    }

    public y3(Context context, T t5) {
        i(context, t5);
    }

    private V j(z6 z6Var) throws fc {
        return f(z6Var);
    }

    private V k(byte[] bArr) throws fc {
        return h(bArr);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getRequestHead() {
        String str;
        p4 s5 = b3.s();
        if (s5 != null) {
            str = s5.e();
        } else {
            str = null;
        }
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", ga.f6366c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", str, "3dmap"));
        hashtable.put("X-INFO", h4.i(this.f7756t));
        hashtable.put("key", f4.j(this.f7756t));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }
}
