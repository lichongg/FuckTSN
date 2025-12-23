package com.ss.android.downloadlib;

import androidx.work.WorkRequest;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;

/* loaded from: D:\Downloads\app\classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38072a = "f";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f38073b;

    class a implements x2.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f38074a;

        a(com.ss.android.xt.j.xt.b bVar) {
            this.f38074a = bVar;
        }

        @Override // x2.b
        public void j() {
            a.o.a().b(f.f38072a, "checkMarketInstallFinishEvent", "注册广播监听成功,注册耗时" + (System.currentTimeMillis() - this.f38074a.v0()));
            this.f38074a.f0(true);
            o.f.c().l(this.f38074a);
        }

        @Override // x2.b
        public void xt() {
            a.o.a().b(f.f38072a, "checkMarketInstallFinishEvent", "广播监听时间结束,主动解除了广播监听");
            if (!a.h.M(this.f38074a)) {
                a.o.a().b(f.f38072a, "checkMarketInstallFinishEvent", "监听结束依然没有完成安装");
            }
            this.f38074a.f0(false);
            o.f.c().l(this.f38074a);
        }
    }

    class b implements x2.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f38076a;

        b(com.ss.android.xt.j.xt.b bVar) {
            this.f38076a = bVar;
        }

        @Override // x2.b
        public void j() {
            a.o.a().b(f.f38072a, "checkMarketInstallFinishEventForReboot", "进程被杀,重新注册广播监听成功,正式执行冷启兜底逻辑");
            this.f38076a.P.compareAndSet(false, true);
            o.d.c().d(this.f38076a);
        }

        @Override // x2.b
        public void xt() {
            a.o.a().b(f.f38072a, "checkMarketInstallFinishEventForReboot", "兜底监听执行完毕,解除广播监听");
            if (!a.h.M(this.f38076a)) {
                a.o.a().b(f.f38072a, "checkMarketInstallFinishEventForReboot", "监听结束依然没有完成安装");
            }
            this.f38076a.P.compareAndSet(true, false);
            this.f38076a.f0(false);
            o.d.c().d(this.f38076a);
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static f f38078a = new f(null);
    }

    /* synthetic */ f(a aVar) {
        this();
    }

    private f() {
    }

    public static f a() {
        return c.f38078a;
    }

    public void b(int i6, x2.b bVar) {
        a.o.a().b(f38072a, "registerMarketInstallFinishBroadcast", "动态广播监听的持续时间为:".concat(String.valueOf(i6)));
        if (!f38073b) {
            com.ss.android.socialbase.appdownloader.f.L().B(bVar);
            f38073b = true;
        }
        com.ss.android.socialbase.appdownloader.f.L().q(i6);
    }

    public void c(o.i iVar, com.ss.android.xt.j.xt.b bVar) {
        if (!a.n.g(bVar)) {
            a.o.a().b(f38072a, "checkMarketInstallFinishEvent", "开关未开启, 不使用动态广播监听能力");
            return;
        }
        if (bVar == null) {
            a.o.a().c(f38072a, "checkMarketInstallFinishEvent", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (bVar.y0()) {
            a.o.a().c(f38072a, "checkMarketInstallFinishEvent", "正在监听中,不重复监听");
            return;
        }
        try {
            a.o a6 = a.o.a();
            String str = f38072a;
            a6.b(str, "checkMarketInstallFinishEvent", "针对商店直投广告,开始检测安装完成事件");
            if (a.n.r(bVar)) {
                a.o.a().b(str, "checkMarketInstallFinishEvent", "开始进行动态广播监听");
                int optInt = m.f().optInt("market_install_finish_check_time", 600);
                if (bVar.v0() != 0 && System.currentTimeMillis() - bVar.v0() <= optInt * 1000) {
                    a.o.a().b(str, "checkMarketInstallFinishEvent", "目前仍在广播监听的生效期内,不进行重复注册");
                }
                bVar.d0(System.currentTimeMillis());
                b(optInt, new a(bVar));
            }
            if (a.n.u(bVar)) {
                a.o.a().b(str, "checkMarketInstallFinishEvent", "开启轮询线程能力,作为容灾手段");
                com.ss.android.downloadlib.addownload.f.a().c(bVar);
            }
            o.d.c().d(bVar);
        } catch (Exception unused) {
            com.ss.android.downloadlib.up.a.a().d(false, "监听商店场景安装完成事件发生异常");
        }
    }

    public void d(com.ss.android.xt.j.xt.b bVar) {
        if (!a.n.g(bVar)) {
            a.o.a().b(f38072a, "checkMarketInstallFinishEventForReboot", "线程轮询总开关未开启,因此不执行兜底逻辑");
            return;
        }
        if (bVar == null) {
            a.o.a().c(f38072a, "checkMarketInstallFinishEventForReboot", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (bVar.P.get() && System.currentTimeMillis() - bVar.v0() > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            a.o.a().b(f38072a, "checkMarketInstallFinishEventForReboot", "兜底过一次了,不进行重复兜底");
            return;
        }
        if (a.n.r(bVar)) {
            long optInt = m.f().optInt("market_install_finish_check_time", 600) * 1000;
            if (System.currentTimeMillis() - bVar.v0() >= optInt) {
                a.o.a().b(f38072a, "checkMarketInstallFinishEventForReboot", "当前时间距离首次检测时间超出了广播生效期,不再执行兜底策略");
            } else {
                b((int) (((bVar.v0() + optInt) - System.currentTimeMillis()) / 1000), new b(bVar));
            }
        }
    }
}
