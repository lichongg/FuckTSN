package com.bytedance.embedapplog;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

/* loaded from: D:\Downloads\app\classes3.dex */
public class w implements Application.ActivityLifecycleCallbacks {
    private static int ae = -1;
    private static long cw;

    /* renamed from: g, reason: collision with root package name */
    private static final HashSet<Integer> f24084g = new HashSet<>(8);

    /* renamed from: j, reason: collision with root package name */
    private static int f24085j;

    /* renamed from: m, reason: collision with root package name */
    private static String f24086m;

    /* renamed from: r, reason: collision with root package name */
    private static String f24087r;
    private static long up;
    private static kc xt;
    private final m tl;

    public static kc j(String str, String str2, long j6, String str3) {
        kc kcVar = new kc();
        if (TextUtils.isEmpty(str2)) {
            kcVar.ws = str;
        } else {
            kcVar.ws = str + ":" + str2;
        }
        kcVar.xt = j6;
        kcVar.vl = -1L;
        if (str3 == null) {
            str3 = "";
        }
        kcVar.jy = str3;
        f.j(kcVar);
        return kcVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        f24084g.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        f24084g.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kc kcVar = xt;
        if (kcVar != null) {
            f24087r = kcVar.ws;
            long currentTimeMillis = System.currentTimeMillis();
            cw = currentTimeMillis;
            j(xt, currentTimeMillis);
            xt = null;
            if (activity.isChild()) {
                return;
            }
            ae = -1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        f24085j++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (f24087r != null) {
            int i6 = f24085j - 1;
            f24085j = i6;
            if (i6 <= 0) {
                f24087r = null;
                f24086m = null;
                up = 0L;
                cw = 0L;
            }
        }
    }

    public w(m mVar) {
        this.tl = mVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        kc j6 = j(activity.getClass().getName(), "", System.currentTimeMillis(), f24087r);
        xt = j6;
        j6.mi = !f24084g.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (!activity.isChild()) {
            try {
                ae = activity.getWindow().getDecorView().hashCode();
            } catch (Exception e6) {
                uc.xt(e6);
            }
        }
    }

    public static kc j(kc kcVar, long j6) {
        kc kcVar2 = (kc) kcVar.clone();
        kcVar2.xt = j6;
        long j7 = j6 - kcVar.xt;
        if (j7 >= 0) {
            kcVar2.vl = j7;
        } else {
            uc.xt((Throwable) null);
        }
        f.j(kcVar2);
        return kcVar2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
