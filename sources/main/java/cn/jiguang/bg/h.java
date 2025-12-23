package cn.jiguang.bg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.bg.c;
import cn.jiguang.bz.y;
import com.amap.api.services.core.AMapException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h extends cn.jiguang.by.b {

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f2084f = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f2085a;

    /* renamed from: b, reason: collision with root package name */
    private Context f2086b;

    /* renamed from: c, reason: collision with root package name */
    private cn.jiguang.bl.a f2087c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2088d = false;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f2089e = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private final int f2090g = f2084f.incrementAndGet();

    @Override // cn.jiguang.by.b
    public void a() {
        boolean a6;
        cn.jiguang.bb.f.g("NetworkingClient", "Begin to run in ConnectingThread - id:" + Thread.currentThread().getId());
        try {
            a6 = a(this.f2086b);
            this.f2089e.set(false);
        } finally {
            try {
            } finally {
            }
        }
        if (!a6) {
            cn.jiguang.bb.f.d("NetworkingClient", "prepare Push Channel failed , returned");
            return;
        }
        while (!this.f2085a) {
            cn.jiguang.bb.f.e("NetworkingClient", "Network listening...");
            try {
                ByteBuffer a7 = this.f2087c.a();
                a(this.f2087c, a7);
                cn.jiguang.bb.f.d("NetworkingClient", "Received bytes - len:" + a7.array().length + ", pkg:" + cn.jiguang.bz.p.a(this.f2086b));
            } catch (cn.jiguang.bi.e e6) {
                cn.jiguang.bb.f.k("NetworkingClient", " recv failed with error:" + e6 + " ,No Break!!");
                c.a.a(this.f2086b, AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS, " recv failed with error:" + e6 + " ,No Break!!");
            }
        }
        if (this.f2085a) {
            cn.jiguang.bb.f.d("NetworkingClient", "Break receiving by wantStop");
        }
        a(1);
    }

    public synchronized void b() {
        try {
            this.f2089e.set(true);
            cn.jiguang.by.d.a("TCP_CONN_TASK", this);
        } finally {
        }
    }

    public synchronized void c() {
        cn.jiguang.bb.f.d("NetworkingClient", "Action - stop");
        this.f2085a = true;
        this.f2089e.set(false);
        y.a(this.f2087c);
        cn.jiguang.by.d.a("TCP_CONN_TASK");
    }

    private boolean b(int i6) {
        int i7;
        if (this.f2085a) {
            return false;
        }
        if (i6 <= 0) {
            cn.jiguang.bb.f.d("NetworkingClient", "login error,retry login too many times");
            h();
            i7 = 4;
        } else {
            cn.jiguang.bb.f.c("NetworkingClient", "loginTimes:" + i6);
            if (!g()) {
                return false;
            }
            cn.jiguang.bq.c a6 = cn.jiguang.bq.c.a();
            cn.jiguang.bl.a aVar = this.f2087c;
            String c6 = a6.c(aVar.f2343h, aVar.f2344i, aVar.f2342g);
            int a7 = c.a(this.f2086b, this.f2087c);
            cn.jiguang.bq.c.a().f(c6, a7);
            if (a7 >= 0) {
                if (a7 <= 0) {
                    cn.jiguang.bi.g.a().a(this.f2086b, "tcp_a10", null);
                    return true;
                }
                h();
                if (a7 == 108) {
                    cn.jiguang.be.b.a(this.f2086b);
                    return b(i6 - 1);
                }
                c(a7);
                return false;
            }
            i7 = 2;
        }
        a(i7);
        return false;
    }

    private void c(int i6) {
        cn.jiguang.bb.f.a("NetworkingClient", "Action - onLoginFailed - respCode:" + i6);
        Bundle bundle = new Bundle();
        bundle.putInt("resCode", i6);
        cn.jiguang.bi.g.a().a(this.f2086b, "tcp_a12", bundle);
    }

    private boolean g() {
        cn.jiguang.ba.k.c(this.f2086b);
        if (cn.jiguang.d.b.a(this.f2086b) && !TextUtils.isEmpty(cn.jiguang.d.a.j(this.f2086b))) {
            return true;
        }
        cn.jiguang.bq.c a6 = cn.jiguang.bq.c.a();
        cn.jiguang.bl.a aVar = this.f2087c;
        String b6 = a6.b(aVar.f2343h, aVar.f2344i, aVar.f2342g);
        int b7 = c.b(this.f2086b, this.f2087c);
        cn.jiguang.bq.c.a().e(b6, b7);
        if (b7 == 0) {
            cn.jiguang.ba.k.b(this.f2086b);
            cn.jiguang.bi.g.a().a(this.f2086b, "tcp_a11", null);
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("resCode", b7);
        cn.jiguang.bi.g.a().a(this.f2086b, "tcp_a13", bundle);
        h();
        a(3);
        return false;
    }

    private void h() {
        c.b(this.f2086b);
    }

    public void a(int i6) {
        cn.jiguang.bb.f.d("NetworkingClient", "Action - closeConnection");
        y.a(this.f2087c);
        Bundle bundle = new Bundle();
        bundle.putBoolean("connect_state", this.f2088d);
        bundle.putInt("connect_instance_id", this.f2090g);
        cn.jiguang.bi.g.a().a(this.f2086b, "tcp_a19", bundle);
        cn.jiguang.bq.c a6 = cn.jiguang.bq.c.a();
        cn.jiguang.bl.a aVar = this.f2087c;
        a6.a(aVar.f2343h, aVar.f2344i, aVar.f2342g, i6);
    }

    public boolean d() {
        return this.f2089e.get();
    }

    public cn.jiguang.bl.a e() {
        return this.f2087c;
    }

    public int f() {
        return this.f2090g;
    }

    public h(Context context) {
        cn.jiguang.bl.a cVar;
        this.f2086b = context;
        if (c.d(context)) {
            cVar = new cn.jiguang.bl.b(8128, 20);
        } else {
            cVar = new cn.jiguang.bl.c(8128, 20);
        }
        this.f2087c = cVar;
        this.f2653h = "NetworkingClient";
    }

    private void a(cn.jiguang.bl.a aVar, ByteBuffer byteBuffer) {
        cn.jiguang.be.b.c(new q(aVar, this.f2086b, byteBuffer.array()));
    }

    private boolean a(Context context) {
        String str;
        cn.jiguang.bb.f.c("NetworkingClient", "google:false");
        cn.jiguang.bn.a.a(context);
        try {
            this.f2087c = new j(new k(context)).a(this);
        } catch (Exception e6) {
            if (e6 instanceof cn.jiguang.bi.e) {
                String str2 = "connect failed, errCode: " + ((cn.jiguang.bi.e) e6).a();
                cn.jiguang.bb.f.j("NetworkingClient", str2);
                c.a.a(this.f2086b, 1400, "内部异常：" + str2);
            } else {
                c.a.a(this.f2086b, 1401, "未知异常：" + e6);
            }
            this.f2088d = true;
            a(1);
            str = "sis and connect failed:" + e6;
        }
        if (b(2)) {
            return true;
        }
        str = "login failed";
        cn.jiguang.bb.f.i("NetworkingClient", str);
        return false;
    }
}
