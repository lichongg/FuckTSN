package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class g extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<g>> f33055b = new WeakHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final List<WeakReference<com.huawei.hmf.tasks.e<?>>> f33056a = new ArrayList();

    private static g b(FragmentManager fragmentManager) {
        g gVar = null;
        try {
            g gVar2 = new g();
            try {
                fragmentManager.beginTransaction().add(gVar2, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
                return gVar2;
            } catch (Exception e6) {
                e = e6;
                gVar = gVar2;
                e.getMessage();
                return gVar;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    private static g a(Activity activity) {
        WeakHashMap<Activity, WeakReference<g>> weakHashMap = f33055b;
        WeakReference<g> weakReference = weakHashMap.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        g gVar = null;
        try {
            g gVar2 = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
            if (gVar2 == null) {
                try {
                    gVar = b(fragmentManager);
                } catch (ClassCastException e6) {
                    e = e6;
                    gVar = gVar2;
                    e.getMessage();
                    return gVar;
                }
            } else {
                gVar = gVar2;
            }
            weakHashMap.put(activity, new WeakReference<>(gVar));
            return gVar;
        } catch (ClassCastException e7) {
            e = e7;
        }
    }

    public static void c(Activity activity, com.huawei.hmf.tasks.e eVar) {
        g a6 = a(activity);
        if (a6 != null) {
            synchronized (a6.f33056a) {
                a6.f33056a.add(new WeakReference<>(eVar));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.f33056a) {
            try {
                Iterator<WeakReference<com.huawei.hmf.tasks.e<?>>> it = this.f33056a.iterator();
                while (it.hasNext()) {
                    com.huawei.hmf.tasks.e<?> eVar = it.next().get();
                    if (eVar != null) {
                        eVar.cancel();
                    }
                }
                this.f33056a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
