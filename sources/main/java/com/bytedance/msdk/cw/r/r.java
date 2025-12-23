package com.bytedance.msdk.cw.r;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.activity.TTTransparentActivity;
import com.bytedance.msdk.core.xt;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class r extends oq {

    /* renamed from: a, reason: collision with root package name */
    private com.bytedance.msdk.xt.cw f25083a;
    protected boolean av;
    private int ch;

    /* renamed from: f, reason: collision with root package name */
    private Handler f25084f;

    /* renamed from: h, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f25085h;

    /* renamed from: j, reason: collision with root package name */
    private boolean f25086j;
    private SoftReference<Activity> kt;

    /* renamed from: l, reason: collision with root package name */
    private Object f25087l;

    /* renamed from: p, reason: collision with root package name */
    private String f25088p;

    /* renamed from: s, reason: collision with root package name */
    private int f25089s;
    private SoftReference<Activity> tj;

    /* renamed from: v, reason: collision with root package name */
    private int f25090v;

    /* renamed from: x, reason: collision with root package name */
    private int f25091x;
    private volatile boolean xt;

    private static class j implements Runnable {
        private final Handler cw;

        /* renamed from: j, reason: collision with root package name */
        private Toast f25096j;
        private final int xt;

        private j(Toast toast, int i6, Handler handler) {
            this.f25096j = toast;
            this.xt = i6;
            this.cw = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.xt <= 0) {
                this.f25096j.cancel();
                return;
            }
            this.f25096j.cancel();
            Toast makeText = Toast.makeText(com.bytedance.msdk.core.xt.getContext(), this.xt + "秒后播放下一个广告", 0);
            this.f25096j = makeText;
            makeText.show();
            Handler handler = this.cw;
            handler.postDelayed(new j(this.f25096j, this.xt - 1, handler), 1000L);
        }
    }

    protected void j(Activity activity, Object obj, String str) {
    }

    private boolean cw() {
        return this.ch != 0;
    }

    private int m() {
        CopyOnWriteArrayList<com.bytedance.msdk.xt.cw> copyOnWriteArrayList;
        CopyOnWriteArrayList<com.bytedance.msdk.xt.cw> copyOnWriteArrayList2;
        CopyOnWriteArrayList<com.bytedance.msdk.xt.cw> copyOnWriteArrayList3;
        boolean z5;
        com.bytedance.msdk.cw.m.j.xt xtVar = this.cw;
        List<com.bytedance.msdk.core.oq.oq> list = null;
        if (xtVar != null) {
            copyOnWriteArrayList = xtVar.ae();
            copyOnWriteArrayList2 = this.cw.oq();
            copyOnWriteArrayList3 = this.cw.tl();
        } else {
            copyOnWriteArrayList = null;
            copyOnWriteArrayList2 = null;
            copyOnWriteArrayList3 = null;
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            z5 = false;
        } else {
            z5 = false;
            for (com.bytedance.msdk.xt.cw cwVar : copyOnWriteArrayList) {
                if (cwVar != null && cwVar.wq(this.up) && !cwVar.qb()) {
                    if (!r(cwVar) && !com.bytedance.msdk.core.admanager.j.j(cwVar.ff(), cwVar.om(), cwVar.rh())) {
                        return 0;
                    }
                    z5 = true;
                }
            }
        }
        if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
            for (com.bytedance.msdk.xt.cw cwVar2 : copyOnWriteArrayList3) {
                if (cwVar2 != null && cwVar2.wq(this.up) && !cwVar2.qb()) {
                    if (!r(cwVar2) && !com.bytedance.msdk.core.admanager.j.j(cwVar2.ff(), cwVar2.om(), cwVar2.rh())) {
                        return 0;
                    }
                    z5 = true;
                }
            }
        }
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
            for (com.bytedance.msdk.xt.cw cwVar3 : copyOnWriteArrayList2) {
                if (cwVar3 != null && cwVar3.wq(this.up) && !cwVar3.qb()) {
                    if (!r(cwVar3) && !com.bytedance.msdk.core.admanager.j.j(cwVar3.ff(), cwVar3.om(), cwVar3.rh())) {
                        return 0;
                    }
                    z5 = true;
                }
            }
        }
        try {
            list = xt();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
        if (list != null && list.size() > 0) {
            for (com.bytedance.msdk.core.oq.oq oqVar : list) {
                String w5 = oqVar.w();
                if (oqVar.kt() && com.bytedance.msdk.core.up.j.j.j().r(this.up, w5, mi()) && com.bytedance.msdk.core.up.j.j.j().j(w5, this.f25122m, false) == 3) {
                    if (!j(oqVar) && !com.bytedance.msdk.core.admanager.j.j(oqVar.az(), oqVar.jy(), oqVar.m())) {
                        return 0;
                    }
                    z5 = true;
                }
            }
        }
        return z5 ? 1 : 2;
    }

    private void r() {
        if (this.xt) {
            return;
        }
        Application j6 = xt.j.j();
        if (j6 == null) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- app is null, 插全屏轮播直接return");
            return;
        }
        j6.unregisterActivityLifecycleCallbacks(this.f25085h);
        j6.registerActivityLifecycleCallbacks(this.f25085h);
        this.xt = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        Handler handler = this.f25084f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Application j6 = xt.j.j();
        if (j6 != null) {
            j6.unregisterActivityLifecycleCallbacks(this.f25085h);
        }
    }

    @Override // com.bytedance.msdk.cw.r.oq
    protected boolean tj() {
        return this.f25086j;
    }

    public void xt(com.bytedance.msdk.api.j.xt xtVar) {
        j(xtVar);
        com.bytedance.msdk.core.oq.xt xtVar2 = this.ae;
        if (xtVar2 != null) {
            this.ch = xtVar2.jy();
            if (!cw()) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- inter full refresh is not enabled");
                return;
            }
            this.f25091x = this.ae.ws();
            com.bytedance.msdk.core.oq.xt xtVar3 = this.ae;
            int g6 = xtVar3.g(xtVar3.wq());
            this.f25089s = g6;
            if (g6 <= 0) {
                this.f25089s = 15000;
            }
            this.f25084f = new Handler(Looper.getMainLooper());
        }
    }

    public r(Context context) {
        super(context);
        this.f25086j = false;
        this.av = true;
        this.xt = false;
        this.kt = new SoftReference<>(null);
        this.tj = new SoftReference<>(null);
        this.f25090v = 0;
        this.f25091x = 2;
        this.ch = 0;
        this.f25089s = 15000;
        this.f25085h = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.cw.r.r.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull @ForbidWrapParam Activity activity, @Nullable Bundle bundle) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- onActivityCreated: activity: ".concat(String.valueOf(activity)));
                Activity activity2 = (Activity) r.this.tj.get();
                if (activity2 == null) {
                    com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- onActivityCreated: start transparent activity");
                    if (activity instanceof TTTransparentActivity) {
                        r.this.tj = new SoftReference(activity);
                        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- onActivityCreated: start transparent activity, callSuperShowAd");
                        r rVar = r.this;
                        rVar.xt(rVar.f25083a, activity, r.this.f25087l, r.this.f25088p);
                        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- onActivityCreated: end");
                        return;
                    }
                    return;
                }
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- onActivityCreated again, showingActivity: ".concat(String.valueOf(activity2)));
                String name = activity.getClass().getName();
                if ((activity2 instanceof TTTransparentActivity) && com.bytedance.msdk.core.admanager.j.xt(name)) {
                    com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- onActivityCreated again, is adn ad activity: ".concat(String.valueOf(activity)));
                    activity2.finish();
                    r.this.tj = new SoftReference(activity);
                } else {
                    com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- onActivityCreated again, is not adn ad activity");
                }
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- onActivityCreated: end 2");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull @ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NonNull @ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NonNull @ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NonNull @ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull @ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NonNull @ForbidWrapParam Activity activity, @NonNull Bundle bundle) {
            }
        };
    }

    protected final void f() {
        if (cw()) {
            this.av = true;
            this.f25090v++;
            final Activity activity = this.kt.get();
            final Activity activity2 = this.tj.get();
            final com.bytedance.msdk.xt.cw cwVar = this.f25083a;
            if (!j(activity2, activity, cwVar)) {
                up();
                return;
            }
            Handler handler = this.f25084f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                j(this.f25084f, activity2);
                this.f25084f.postDelayed(new Runnable() { // from class: com.bytedance.msdk.cw.r.r.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!r.this.j(activity2)) {
                            r.this.up();
                            return;
                        }
                        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播 开始，先showingActivity finish");
                        r.this.av = false;
                        activity2.finish();
                        cwVar.w();
                        r.this.tj = new SoftReference(null);
                        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播开始 showingActivity finish end");
                        r.this.f25086j = true;
                        r rVar = r.this;
                        rVar.j(activity, rVar.f25087l, r.this.f25088p);
                    }
                }, this.f25089s);
            }
        }
    }

    protected final void v() {
        if (!cw()) {
            return;
        }
        if (this.av) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 用户关闭了广告，停止轮播");
            Activity activity = this.tj.get();
            if (activity instanceof TTTransparentActivity) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 用户关闭了广告，finish showingActivity");
                activity.finish();
                this.tj = new SoftReference<>(null);
            }
            up();
            return;
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 调用finish触发了close回调");
    }

    protected final void x() {
        if (!cw()) {
            return;
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 用户点击了广告，停止轮播");
        up();
    }

    @Override // com.bytedance.msdk.cw.r.oq
    public void j(com.bytedance.msdk.xt.cw cwVar, Activity activity, Object obj, String str) {
        if (cw()) {
            r();
            this.kt = new SoftReference<>(activity);
            this.f25083a = cwVar;
            this.f25123r = cwVar;
            this.f25087l = obj;
            this.f25088p = str;
            Intent intent = new Intent(com.bytedance.msdk.core.xt.getContext(), (Class<?>) TTTransparentActivity.class);
            intent.addFlags(268435456);
            com.bytedance.msdk.core.xt.getContext().startActivity(intent);
            return;
        }
        super.j(cwVar, activity, obj, str);
    }

    private boolean r(com.bytedance.msdk.xt.cw cwVar) {
        return cwVar.dj() && cwVar.x() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(com.bytedance.msdk.xt.cw cwVar, Activity activity, Object obj, String str) {
        super.j(cwVar, activity, obj, str);
    }

    private void j(final Handler handler, final Activity activity) {
        int i6 = this.f25089s - 2000;
        if (i6 <= 0) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.bytedance.msdk.cw.r.r.2
            @Override // java.lang.Runnable
            public void run() {
                if (!r.this.j(activity)) {
                    r.this.up();
                    return;
                }
                Toast makeText = Toast.makeText(com.bytedance.msdk.core.xt.getContext(), "2秒后播放下一个广告", 0);
                makeText.show();
                Handler handler2 = handler;
                handler2.postDelayed(new j(makeText, 1, handler2), 1000L);
            }
        }, i6);
    }

    private boolean j(com.bytedance.msdk.core.oq.oq oqVar) {
        return oqVar.c() && oqVar.j() != 1;
    }

    private boolean j(Activity activity, Activity activity2, com.bytedance.msdk.xt.cw cwVar) {
        if (this.f25090v >= this.f25091x) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播，轮播次数已达上限: " + this.f25091x);
            return false;
        }
        if (activity2 == null) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播 停止轮播 developerActivity为null");
            return false;
        }
        if (cwVar == null) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播，ttBaseAd为null，不轮播");
            return false;
        }
        if (r(cwVar)) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播，展示的是自定义adn，则不轮播");
            return false;
        }
        if (!com.bytedance.msdk.core.admanager.j.j(cwVar.ff(), cwVar.om(), cwVar.rh())) {
            if (activity != null) {
                return true;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播，showingActivity是null，停止轮播");
            com.bytedance.msdk.up.m.j(this.f25122m, 81010);
            return false;
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播，当前展示的广告不支持轮播: " + cwVar.ff() + ", adtype: " + cwVar.om() + ", subType: " + cwVar.rh());
        com.bytedance.msdk.up.m.j(this.f25122m, 81011);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播，showingActivity正在finish或已经destroy，停止轮播");
            return false;
        }
        int m6 = m();
        if (m6 == 2) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播，无任何广告可用，停止轮播");
            com.bytedance.msdk.up.m.j(this.f25122m, 81008);
            return false;
        }
        if (m6 == 1) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播，仅有自定义adn广告可用，停止轮播");
            com.bytedance.msdk.up.m.j(this.f25122m, 81009);
            return false;
        }
        int xt = xt.xt(this.up);
        if (xt == 0) {
            return true;
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==--- 插全屏轮播，命中了展示频控，停止轮播");
        com.bytedance.msdk.up.m.j(this.f25122m, xt);
        return false;
    }
}
