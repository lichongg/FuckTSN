package com.ss.android.downloadlib.addownload;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.a;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37730a = "f";

    static /* synthetic */ class a {
    }

    private class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.ss.android.xt.j.xt.b f37731a;

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.f37731a.f0(true);
                    f.this.e(this.f37731a);
                } catch (Exception e6) {
                    vl.j(e6);
                }
            } finally {
                this.f37731a.f0(false);
            }
        }

        b(com.ss.android.xt.j.xt.b bVar) {
            this.f37731a = bVar;
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static f f37733a = new f(null);
    }

    /* synthetic */ f(a aVar) {
        this();
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.ss.android.xt.j.xt.b bVar) {
        JSONObject jSONObject = new JSONObject();
        int j6 = a.n.j(bVar);
        int v5 = a.n.v(bVar);
        if (a.n.u(bVar) && a.n.r(bVar)) {
            a.o.a().b(f37730a, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            d(bVar, j6, v5, jSONObject);
        } else {
            a.o.a().b(f37730a, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            f(bVar, 15, 20000, jSONObject);
        }
    }

    public static f a() {
        return c.f37733a;
    }

    private void d(com.ss.android.xt.j.xt.b bVar, int i6, int i7, JSONObject jSONObject) {
        int n6;
        if (bVar.l() == 4) {
            n6 = m.f().optInt("market_install_finish_check_time", 600);
        } else {
            n6 = a.n.n(bVar);
        }
        int i8 = ((n6 * 1000) / 20000) + 1;
        a.o a6 = a.o.a();
        String str = f37730a;
        a6.b(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:".concat(String.valueOf(i8)));
        if (!f(bVar, i8, 20000, jSONObject)) {
            if (n6 * 1000 < a.n.a(bVar)) {
                a.o.a().b(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
                if (!f(bVar, i6, i7, jSONObject)) {
                    a.o.a().b(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
                    return;
                }
                return;
            }
            a.o.a().b(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
        }
    }

    private boolean f(com.ss.android.xt.j.xt.b bVar, int i6, int i7, JSONObject jSONObject) {
        a.o.a().b(f37730a, "realListenInstallFinishEvent", "开始轮询检测,轮询时间间隔为" + i7 + ",轮询次数为" + i6);
        long j6 = (long) i7;
        SystemClock.sleep(j6);
        while (i6 > 0) {
            if (a.h.M(bVar)) {
                com.ss.android.downloadlib.d.d().p(bVar.up());
                a.o.a().b(f37730a, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为".concat(String.valueOf(i6)));
                return true;
            }
            i6--;
            if (i6 != 0) {
                SystemClock.sleep(j6);
            } else {
                return false;
            }
        }
        return false;
    }

    public void c(com.ss.android.xt.j.xt.b bVar) {
        a.o.a().b(f37730a, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.ss.android.downloadlib.e.c().b(new b(bVar));
    }
}
