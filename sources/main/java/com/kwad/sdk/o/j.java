package com.kwad.sdk.o;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j {
    private static final String CLAZZ_NAME = "com.kwad.sdk.o.j";
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static final Map<Context, Context> sResContextCache = new WeakHashMap();
    private static final AtomicBoolean beb = new AtomicBoolean(false);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private WeakReference<Context> aqb;
        private int aqc;
        private StackTraceElement[] aqd;
        private int aqe;
        private long aqf;

        private a() {
            this.aqb = new WeakReference<>(null);
            this.aqc = 0;
            this.aqd = null;
            this.aqe = 0;
        }

        static /* synthetic */ int c(a aVar) {
            int i6 = aVar.aqc;
            aVar.aqc = i6 + 1;
            return i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.aqb = new WeakReference<>(null);
            this.aqc = 0;
            this.aqd = null;
            this.aqe = 0;
            this.aqf = 0L;
        }

        static /* synthetic */ int g(a aVar) {
            int i6 = aVar.aqe;
            aVar.aqe = i6 + 1;
            return i6;
        }

        /* synthetic */ a(byte b6) {
            this();
        }
    }

    private static void a(final Context context, Context context2) {
        sResContextCache.put(context, context2);
        if (context instanceof Activity) {
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.o.j.1
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityDestroyed */
                public final void b(@NonNull Activity activity) {
                    if (activity == context) {
                        com.kwad.sdk.core.c.b.Ho();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        j.onDestroy(context);
                    }
                }
            });
        }
    }

    public static boolean SX() {
        return beb.get();
    }

    public static void ct(boolean z5) {
        beb.set(z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v3 */
    static Context eg(Context context) {
        boolean z5 = context instanceof b;
        Context context2 = context;
        if (z5) {
            context2 = ((b) context).getDelegatedContext();
        }
        if (m.eo(context2)) {
            return context2;
        }
        RuntimeException runtimeException = null;
        int i6 = 0;
        Context context3 = context2;
        while (i6 < 10) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context3.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            boolean aN = k.aN(context3);
            ?? r5 = context3;
            if (aN) {
                r5 = k.aM(context3);
            }
            boolean z6 = r5 instanceof b;
            Context context4 = r5;
            if (z6) {
                context4 = ((b) r5).getDelegatedContext();
            }
            if (m.eo(context4)) {
                return context4;
            }
            i6++;
            context3 = context4;
        }
        return context3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7 */
    static Context eh(Context context) {
        if (context instanceof Application) {
            return context;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(eg(context).getApplicationContext());
        if (origApplicationContext instanceof Application) {
            return origApplicationContext;
        }
        int i6 = 0;
        Context context2 = origApplicationContext;
        while (i6 < 10) {
            Context origApplicationContext2 = StubApp.getOrigApplicationContext(context2.getApplicationContext());
            if (origApplicationContext2 instanceof Application) {
                return origApplicationContext2;
            }
            if (origApplicationContext2 instanceof b) {
                origApplicationContext2 = ((b) origApplicationContext2).getDelegatedContext();
            }
            i6++;
            context2 = origApplicationContext2;
        }
        return context2;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static void onDestroy(Context context) {
        sResContextCache.remove(context);
    }

    private static boolean returnUnWrappedContext(Context context) {
        ThreadLocal<a> threadLocal = sAutoUnWrapModelTL;
        a aVar = threadLocal.get();
        byte b6 = 0;
        if (aVar == null) {
            threadLocal.set(new a(b6));
        } else if (aVar.aqb.get() != context || Math.abs(System.currentTimeMillis() - aVar.aqf) >= 150) {
            aVar.clear();
            aVar.aqb = new WeakReference(context);
            aVar.aqf = System.currentTimeMillis();
        } else {
            a.c(aVar);
            if (aVar.aqc >= (context instanceof Application ? 15 : 5) && a(context, aVar)) {
                aVar.clear();
                return true;
            }
        }
        return false;
    }

    static Context wrapContextIfNeed(Context context) {
        Context context2;
        if (context == null) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper wrapContextIfNeed context is null"));
            return null;
        }
        com.kwad.sdk.core.d.c.w("Wrapper", "wrapContextIfNeed run context is: " + context);
        if (!m.Td() || (context instanceof b)) {
            return context;
        }
        if (k.aN(context)) {
            context = k.unwrapContextIfNeed(context);
            if (k.aN(context)) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper unwrapContextIfNeed fail"));
                return context;
            }
        }
        Context context3 = sResContextCache.get(context);
        if (context3 instanceof b) {
            return context3;
        }
        if (l.ei(context)) {
            return context;
        }
        if (returnUnWrappedContext(context)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper returnUnWrappedContext context: " + context.getClass().getName()));
            return context;
        }
        if (context instanceof Application) {
            try {
                g gVar = new g((Application) context, new h(context, f.SS()));
                m.a(gVar);
                context2 = gVar;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.w("Wrapper", "wrapContextIfNeed Application error: " + th.getMessage());
                th.printStackTrace();
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("wrapper Application fail --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn()));
                return context;
            }
        } else {
            context2 = context instanceof ContextThemeWrapper ? new c((ContextThemeWrapper) context) : context instanceof androidx.appcompat.view.ContextThemeWrapper ? new d((androidx.appcompat.view.ContextThemeWrapper) context) : context instanceof ContextWrapper ? new e(context) : new e(context);
        }
        a(context, context2);
        return context2;
    }

    static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader classLoader2 = f.SS().getClassLoader();
        if (classLoader2 != null) {
            return classLoader2;
        }
        return classLoader;
    }

    static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i6) {
        Resources resources = f.SS().getResources();
        if (resources != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = resources.newTheme();
                newTheme.applyStyle(i6, true);
                return newTheme;
            }
            return theme2;
        }
        return theme;
    }

    private static boolean a(Context context, a aVar) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, aVar.aqd)) {
            if (aVar.aqd != null) {
                aVar.clear();
                return false;
            }
            aVar.aqd = stackTrace;
            int i6 = 0;
            int i7 = 0;
            while (i6 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i6];
                String className = stackTraceElement.getClassName();
                for (String str : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str) && className.contains(str)) {
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i6++;
                if (i6 < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i6];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i7 = i7 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
        a.g(aVar);
        aVar.aqd = stackTrace;
        return aVar.aqe >= 5;
    }
}
