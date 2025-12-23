package com.kwad.sdk.o;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.z;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m {
    private static Application bei;

    private static Application Tc() {
        Application application = (Application) z.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        return application != null ? application : (Application) z.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static View a(Context context, @LayoutRes int i6, @Nullable ViewGroup viewGroup, boolean z5) {
        return eq(context).inflate(i6, viewGroup, z5);
    }

    private static Application Tb() {
        Application application = bei;
        if (application != null) {
            return application;
        }
        Context Pp = ServiceProvider.Pp();
        if (Pp instanceof Application) {
            Application application2 = (Application) Pp;
            bei = application2;
            return application2;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(Pp.getApplicationContext());
        if (origApplicationContext instanceof Application) {
            Application application3 = (Application) origApplicationContext;
            bei = application3;
            return application3;
        }
        Context eh = aN(origApplicationContext) ? j.eh(origApplicationContext) : k.aN(origApplicationContext) ? k.eh(origApplicationContext) : StubApp.getOrigApplicationContext(Pp.getApplicationContext());
        if (eh instanceof Application) {
            bei = (Application) eh;
        } else {
            Application application4 = com.kwad.sdk.core.c.b.Ho().getApplication();
            if (application4 != null) {
                bei = application4;
            } else if (eh instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) eh).getBaseContext();
                if (baseContext != null) {
                    baseContext = StubApp.getOrigApplicationContext(baseContext.getApplicationContext());
                }
                if (baseContext instanceof Application) {
                    bei = (Application) baseContext;
                }
            }
        }
        if (bei == null) {
            bei = Tc();
        }
        Application en = en(bei);
        bei = en;
        return en;
    }

    public static boolean Td() {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk() || f.SS().ST();
    }

    public static void a(Application application) {
        if (bei == null) {
            bei = application;
        }
    }

    private static boolean aN(Context context) {
        return context instanceof b;
    }

    @Nullable
    public static Activity ej(@Nullable Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context el = el(context);
        if (el instanceof Activity) {
            return (Activity) el;
        }
        com.kwad.sdk.core.c.b.Ho();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    private static Application en(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn() + "--isExternal:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk() + "--isInnerDex:" + f.SS().ST()));
        return null;
    }

    private static Context er(Context context) {
        return context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : context;
    }

    public static int getThemeResId(Context context) {
        if (!(context instanceof ContextThemeWrapper)) {
            if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
            }
            return 0;
        }
        Object a6 = z.a((Object) context, "android.view.ContextThemeWrapper", "getThemeResId");
        if (a6 != null) {
            return ((Integer) a6).intValue();
        }
        return 0;
    }

    public static void z(Context context, boolean z5) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z5).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private static boolean SZ() {
        if (!f.SS().Rw()) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("please init KSPlugin"));
            return false;
        }
        return true;
    }

    public static Application Ta() {
        SZ();
        Application Tb = Tb();
        if (j.SX()) {
            bei = (Application) j.wrapContextIfNeed(Tb);
        }
        return bei;
    }

    public static LayoutInflater b(Context context, Context context2) {
        LayoutInflater cloneInContext = LayoutInflater.from(er(context)).cloneInContext(context2);
        a(cloneInContext);
        return cloneInContext;
    }

    @NonNull
    private static Context ek(Context context) {
        if (j.SX() && !aN(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn()));
            return context;
        }
        if (!j.SX() && !k.aN(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn()));
        }
        return context;
    }

    @NonNull
    public static Context el(Context context) {
        Context unwrapContextIfNeed;
        if (!SZ() || !Td() || eo(context)) {
            return context;
        }
        if (aN(context)) {
            unwrapContextIfNeed = j.eg(context);
        } else {
            unwrapContextIfNeed = k.unwrapContextIfNeed(context);
        }
        return em(unwrapContextIfNeed);
    }

    private static Context em(Context context) {
        if (!k.aN(context) && !(context instanceof b)) {
            return context;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn()));
        return context;
    }

    public static boolean eo(Context context) {
        if (!aN(context) && !k.aN(context)) {
            return true;
        }
        return false;
    }

    public static Context ep(Context context) {
        try {
            if (k.aN(context)) {
                context = k.aM(context);
            }
            if (context instanceof b) {
                context = ((b) context).getDelegatedContext();
            }
            if (eo(context)) {
                return context;
            }
            for (int i6 = 0; i6 < 5; i6++) {
                if (k.aN(context)) {
                    context = k.aM(context);
                }
                if (context instanceof b) {
                    context = ((b) context).getDelegatedContext();
                }
                if (eo(context)) {
                    return context;
                }
            }
            return context;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return context;
        }
    }

    public static LayoutInflater eq(Context context) {
        Context wrapContextIfNeed = wrapContextIfNeed(context);
        if (k.aN(wrapContextIfNeed)) {
            LayoutInflater from = LayoutInflater.from(wrapContextIfNeed);
            a(from);
            return from;
        }
        return LayoutInflater.from(wrapContextIfNeed);
    }

    public static View inflate(Context context, @LayoutRes int i6, @Nullable ViewGroup viewGroup) {
        return eq(context).inflate(i6, viewGroup);
    }

    public static void n(Activity activity) {
        k.onDestroy(activity);
    }

    @NonNull
    public static Context wrapContextIfNeed(Context context) {
        Context wrapContextIfNeed;
        if (!SZ() || !Td()) {
            return context;
        }
        if (j.SX()) {
            wrapContextIfNeed = j.wrapContextIfNeed(context);
        } else {
            wrapContextIfNeed = k.wrapContextIfNeed(context);
        }
        return ek(wrapContextIfNeed);
    }

    private static void a(LayoutInflater layoutInflater) {
        z.a(layoutInflater, "mFactory", (Object) null);
        z.a(layoutInflater, "mFactory2", (Object) null);
    }
}
