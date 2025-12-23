package com.bytedance.sdk.openadsdk.core.rn;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Application.ActivityLifecycleCallbacks {
    public static long cw;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f30082j;
    public static long xt;
    private volatile WeakReference<Activity> az;
    private volatile WeakReference<Activity> jy;

    /* renamed from: m, reason: collision with root package name */
    private volatile xt f30084m;

    /* renamed from: r, reason: collision with root package name */
    private volatile InterfaceC0472j f30085r;
    private volatile Application.ActivityLifecycleCallbacks up;
    private Handler ws;
    private final AtomicBoolean ae = new AtomicBoolean(false);
    private final HashSet<Integer> tl = new HashSet<>();

    /* renamed from: g, reason: collision with root package name */
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.j>> f30083g = new CopyOnWriteArrayList<>();
    private volatile CopyOnWriteArrayList<xt> oq = new CopyOnWriteArrayList<>();
    private final ArrayList<String> qv = new ArrayList<>();
    private SparseArray<Set<Runnable>> vl = new SparseArray<>();

    /* renamed from: com.bytedance.sdk.openadsdk.core.rn.j$j, reason: collision with other inner class name */
    public interface InterfaceC0472j {
        void j();
    }

    public interface xt {
        void j();

        void xt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@ForbidWrapParam Activity activity) {
        if (activity != null) {
            this.tl.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.up != null) {
            this.up.onActivityDestroyed(activity);
        }
        if (this.f30083g != null && this.f30083g.size() > 0) {
            Iterator<WeakReference<com.bytedance.sdk.component.adexpress.j>> it = this.f30083g.iterator();
            while (it.hasNext()) {
                WeakReference<com.bytedance.sdk.component.adexpress.j> next = it.next();
                if (next != null && next.get() != null) {
                    try {
                        next.get().j(activity);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.vl.j(th);
                    }
                }
            }
        }
        if (this.jy != null && this.jy.get() == activity) {
            this.jy = null;
        }
        if (activity != null) {
            int hashCode = activity.hashCode();
            synchronized (this.vl) {
                try {
                    Set<Runnable> set = this.vl.get(hashCode);
                    if (set != null) {
                        for (Runnable runnable : set) {
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                        this.vl.remove(hashCode);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(@ForbidWrapParam Activity activity) {
        if (activity != null) {
            this.tl.add(Integer.valueOf(activity.hashCode()));
        }
        if (this.f30085r != null) {
            this.f30085r.j();
        }
        if (this.up != null) {
            this.up.onActivityResumed(activity);
        }
        com.bytedance.sdk.component.g.cw.j.j(com.bytedance.sdk.openadsdk.core.v.getContext(), Integer.parseInt("1371"));
        if (!f30082j) {
            xt = System.currentTimeMillis();
            f30082j = true;
        }
        com.bytedance.sdk.openadsdk.core.p.j();
        this.jy = new WeakReference<>(activity);
        if (com.bytedance.sdk.openadsdk.core.oq.i().la()) {
            return;
        }
        if (activity != null && activity.getComponentName() != null) {
            com.bytedance.sdk.openadsdk.core.rn.xt.j().j(activity.getComponentName().getClassName());
        }
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        ws.j().j(activity.getIntent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(@ForbidWrapParam Activity activity) {
        if (this.up != null) {
            this.up.onActivityPaused(activity);
        }
        if (com.bytedance.sdk.openadsdk.core.oq.i().la() || activity == null || activity.getComponentName() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.xt.j().cw(activity.getComponentName().getClassName());
    }

    private Handler up() {
        if (this.ws == null) {
            if (com.bytedance.sdk.openadsdk.core.v.xt().ot()) {
                this.ws = com.bytedance.sdk.component.utils.tl.cw();
            } else {
                this.ws = com.bytedance.sdk.component.utils.tl.xt();
            }
        }
        return this.ws;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(@ForbidWrapParam Activity activity) {
        if (this.ae.get()) {
            xt(true);
        }
        if (!this.qv.contains(activity.toString())) {
            this.qv.add(activity.toString());
            this.ae.set(false);
            com.bytedance.sdk.openadsdk.j.xt.xt.up();
        }
        if (this.az != null && this.az.get() != null && this.az.get() == activity) {
            tl();
        }
        if (this.up != null) {
            this.up.onActivityStarted(activity);
        }
        ed.up(activity);
    }

    public WeakReference<Activity> j() {
        return this.jy;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
        if (this.up != null) {
            this.up.onActivityCreated(activity, bundle);
        }
    }

    private void ae() {
        if (!com.bytedance.sdk.openadsdk.core.oq.i().la() && xt()) {
            com.bytedance.sdk.component.oq.ae.cw(new com.bytedance.sdk.component.oq.g("reportSdkUseTime") { // from class: com.bytedance.sdk.openadsdk.core.rn.j.6
                @Override // java.lang.Runnable
                public void run() {
                    j.f30082j = false;
                    j.cw = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.kt.ws.j().j(j.xt / 1000, j.cw / 1000, !com.bytedance.sdk.openadsdk.core.tj.xt.get() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.tj.xt.set(false);
                }
            });
        }
    }

    private void tl() {
        if (com.bytedance.sdk.openadsdk.core.oq.i().la()) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.ae.xt(new com.bytedance.sdk.component.oq.g("upload_dpl") { // from class: com.bytedance.sdk.openadsdk.core.rn.j.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
                long xt2 = j6.xt("save_jump_success_time", 0L);
                if (xt2 > 0) {
                    long currentTimeMillis = System.currentTimeMillis() - xt2;
                    if (currentTimeMillis < 86400000 && currentTimeMillis > 0) {
                        String xt3 = j6.xt("save_jump_success_ad_tag", "");
                        String xt4 = j6.xt("save_dpl_success_materialmeta", "");
                        if (!TextUtils.isEmpty(xt3) && !TextUtils.isEmpty(xt4)) {
                            j6.j("save_dpl_success_materialmeta");
                            com.bytedance.sdk.openadsdk.core.jy.cw.j(currentTimeMillis, xt3, xt4);
                        }
                    }
                }
            }
        });
    }

    public boolean j(boolean z5) {
        Activity activity;
        Window window;
        WeakReference<Activity> weakReference = this.jy;
        return (weakReference == null || (activity = weakReference.get()) == null || (window = activity.getWindow()) == null) ? z5 : window.getDecorView().hasWindowFocus();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@ForbidWrapParam final Activity activity) {
        up().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.j.5
            @Override // java.lang.Runnable
            public void run() {
                j.this.m(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@ForbidWrapParam final Activity activity) {
        up().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.j.3
            @Override // java.lang.Runnable
            public void run() {
                j.this.r(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@ForbidWrapParam final Activity activity) {
        up().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.cw(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@ForbidWrapParam final Activity activity) {
        up().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.xt(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@ForbidWrapParam final Activity activity) {
        up().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.j.4
            @Override // java.lang.Runnable
            public void run() {
                j.this.up(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up(@ForbidWrapParam Activity activity) {
        if (this.qv.contains(activity.toString())) {
            this.qv.remove(activity.toString());
            if (this.qv.size() == 0) {
                this.ae.set(true);
                com.bytedance.sdk.openadsdk.j.xt.xt.r();
                xt(false);
            }
        }
        this.az = new WeakReference<>(activity);
        if (this.up != null) {
            this.up.onActivityStopped(activity);
        }
        ae();
        ((com.bytedance.sdk.component.r.r) AutoService.j(com.bytedance.sdk.component.r.r.class)).j();
    }

    public boolean j(@ForbidWrapParam Activity activity) {
        return activity != null && this.tl.contains(Integer.valueOf(activity.hashCode()));
    }

    public void r() {
        com.bytedance.sdk.openadsdk.core.rn.xt.j().xt();
    }

    public void j(InterfaceC0472j interfaceC0472j) {
        this.f30085r = interfaceC0472j;
    }

    public void j(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.up = activityLifecycleCallbacks;
    }

    public void j(com.bytedance.sdk.component.adexpress.j jVar) {
        this.f30083g.add(new WeakReference<>(jVar));
    }

    public void j(xt xtVar) {
        if (this.oq.contains(xtVar)) {
            return;
        }
        this.oq.add(xtVar);
    }

    private void xt(boolean z5) {
        try {
            if (z5) {
                if (this.f30084m != null) {
                    this.f30084m.j();
                }
                Iterator<xt> it = this.oq.iterator();
                while (it.hasNext()) {
                    xt next = it.next();
                    if (next != null) {
                        next.j();
                    }
                }
                return;
            }
            if (this.f30084m != null) {
                this.f30084m.xt();
            }
            Iterator<xt> it2 = this.oq.iterator();
            while (it2.hasNext()) {
                xt next2 = it2.next();
                if (next2 != null) {
                    next2.xt();
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean j(Activity activity, Runnable runnable) {
        boolean add;
        if (activity == null) {
            return false;
        }
        int hashCode = activity.hashCode();
        synchronized (this.vl) {
            try {
                Set<Runnable> set = this.vl.get(hashCode);
                if (set == null) {
                    set = new HashSet<>();
                    this.vl.put(hashCode, set);
                }
                add = set.add(runnable);
            } catch (Throwable th) {
                throw th;
            }
        }
        return add;
    }

    private boolean m() {
        Object apply;
        Function<SparseArray<Object>, Object> qb = com.bytedance.sdk.openadsdk.core.oq.i().qb();
        if (qb != null) {
            try {
                apply = qb.apply(com.bytedance.sdk.openadsdk.i.r.j().j(2).j(Boolean.class).xt());
                if (apply != null) {
                    return ((Boolean) apply).booleanValue();
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return this.ae.get();
    }

    public void cw() {
        if (this.f30085r != null) {
            this.f30085r = null;
        }
    }

    public boolean xt() {
        return m();
    }

    public boolean xt(com.bytedance.sdk.component.adexpress.j jVar) {
        return this.f30083g.remove(new WeakReference(jVar));
    }

    public void xt(xt xtVar) {
        this.f30084m = xtVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
    }
}
