package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* loaded from: D:\Downloads\app\classes6.dex */
public class da {

    /* renamed from: b, reason: collision with root package name */
    private static volatile da f35962b;

    /* renamed from: a, reason: collision with root package name */
    private Context f35963a;

    /* renamed from: c, reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f35964c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f35965d;

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            Context context = this.f35963a;
            if (context == null) {
                return;
            }
            h a6 = h.a(context, "re_po_rt");
            if (a6.b(df.f36010w, 0) == 0) {
                return;
            }
            final int[] iArr = {0};
            final int[] iArr2 = {a6.b(df.f35998k, 1)};
            if (this.f35963a instanceof Application) {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.kuaishou.weapon.p0.da.2
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        try {
                            int[] iArr3 = iArr;
                            iArr3[0] = iArr3[0] + 1;
                            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (iArr[0] < 20 && iArr2[0] <= 0) {
                                        ((Application) da.this.f35963a).unregisterActivityLifecycleCallbacks(da.this.f35964c);
                                        return;
                                    }
                                    iArr2[0] = r1[0] - 1;
                                    cx.a(da.this.f35963a).a(106);
                                    dd.a(da.this.f35963a).a(106);
                                    db.a(da.this.f35963a).a(106, 0);
                                    cy.a(da.this.f35963a).a(106);
                                    cz.a(da.this.f35963a).a(106);
                                    de.a(da.this.f35963a).a(106);
                                }
                            });
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }
                };
                this.f35964c = activityLifecycleCallbacks;
                ((Application) this.f35963a).registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        } catch (Throwable unused) {
        }
    }

    private da(Context context) {
        this.f35963a = context;
    }

    public static da a(Context context) {
        if (f35962b == null) {
            synchronized (da.class) {
                try {
                    if (f35962b == null) {
                        f35962b = new da(context);
                    }
                } finally {
                }
            }
        }
        return f35962b;
    }

    public void a() {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        h a6 = h.a(da.this.f35963a, "re_po_rt");
                        boolean e6 = a6.e("a1_p_s_p_s");
                        boolean e7 = a6.e("a1_p_s_p_s_c_b");
                        if ((e6 || e7) && !da.this.f35965d) {
                            da.this.f35965d = true;
                            da.this.b();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
