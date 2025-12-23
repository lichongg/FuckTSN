package com.kwad.library.b.c;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private static final String CLAZZ_NAME = "com.kwad.library.b.c.a";
    private static final ThreadLocal<C0664a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.library.b.c.a$a, reason: collision with other inner class name */
    static class C0664a {
        private WeakReference<Context> aqb;
        private int aqc;
        private StackTraceElement[] aqd;
        private int aqe;
        private long aqf;

        private C0664a() {
            this.aqb = new WeakReference<>(null);
            this.aqc = 0;
            this.aqd = null;
            this.aqe = 0;
        }

        static /* synthetic */ int c(C0664a c0664a) {
            int i6 = c0664a.aqc;
            c0664a.aqc = i6 + 1;
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

        static /* synthetic */ int g(C0664a c0664a) {
            int i6 = c0664a.aqe;
            c0664a.aqe = i6 + 1;
            return i6;
        }

        /* synthetic */ C0664a(byte b6) {
            this();
        }
    }

    @Nullable
    private static Context a(String str, Context context) {
        WeakReference<Context> weakReference = sResContextCache.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static com.kwad.library.b.a bM(String str) {
        return com.kwad.library.solder.a.a.k(null, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context aM(Context context) {
        return ((b) context).getDelegatedContext();
    }

    private static boolean aN(Context context) {
        return context instanceof b;
    }

    private static boolean b(String str, Context context) {
        ThreadLocal<C0664a> threadLocal = sAutoUnWrapModelTL;
        C0664a c0664a = threadLocal.get();
        byte b6 = 0;
        if (c0664a == null) {
            threadLocal.set(new C0664a(b6));
        } else if (c0664a.aqb.get() != context || Math.abs(System.currentTimeMillis() - c0664a.aqf) >= 150) {
            c0664a.clear();
            c0664a.aqb = new WeakReference(context);
            c0664a.aqf = System.currentTimeMillis();
        } else {
            C0664a.c(c0664a);
            if (c0664a.aqc >= (context instanceof Application ? 15 : 5) && a(str, context, c0664a)) {
                c0664a.clear();
                return true;
            }
        }
        return false;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    static int getThemeResId(Context context) {
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

    @NonNull
    public static Context j(Context context, String str) {
        if (context == null) {
            return null;
        }
        com.kwad.library.b.a bM = bM(str);
        if (bM == null || !bM.isLoaded() || (context instanceof b) || b(str, context)) {
            return context;
        }
        Context a6 = a(str, context);
        if (a6 != null) {
            return a6;
        }
        Context cVar = context instanceof ContextThemeWrapper ? new c((ContextThemeWrapper) context, str) : context instanceof androidx.appcompat.view.ContextThemeWrapper ? new d((androidx.appcompat.view.ContextThemeWrapper) context, str) : context instanceof ContextWrapper ? new e(context, str) : new e(context, str);
        a(str, context, cVar);
        return cVar;
    }

    static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof b ? layoutInflater : layoutInflater.cloneInContext(context);
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (aN(context)) {
            context = aM(context);
        }
        if (!aN(context)) {
            return context;
        }
        for (int i6 = 0; i6 < 10; i6++) {
            context = aM(context);
            if (!aN(context)) {
                return context;
            }
        }
        return context;
    }

    private static void a(String str, Context context, Context context2) {
        sResContextCache.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean a(String str, Context context, C0664a c0664a) {
        Context a6 = a(str, context);
        String name = a6 != null ? a6.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, c0664a.aqd)) {
            if (c0664a.aqd != null) {
                c0664a.clear();
                return false;
            }
            c0664a.aqd = stackTrace;
            int i6 = 0;
            int i7 = 0;
            while (i6 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i6];
                String className = stackTraceElement.getClassName();
                Iterator<String> it = getAutoUnWrapStackList().iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
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
        C0664a.g(c0664a);
        c0664a.aqd = stackTrace;
        return c0664a.aqe >= 5;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwad.library.b.a bM = bM(str);
        if (bM == null || !bM.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof b) {
            return layoutInflater;
        }
        Context j6 = j(context, str);
        return j6 instanceof b ? layoutInflater.cloneInContext(j6) : layoutInflater;
    }

    static Resources a(Resources resources, String str) {
        com.kwad.library.b.a bM = bM(str);
        if (bM != null && bM.isLoaded()) {
            Resources resources2 = bM.getResources();
            Objects.toString(resources2);
            return resources2 != null ? resources2 : resources;
        }
        Objects.toString(bM);
        return resources;
    }

    static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i6, String str) {
        Resources resources;
        com.kwad.library.b.a bM = bM(str);
        if (bM == null || !bM.isLoaded() || (resources = bM.getResources()) == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme newTheme = resources.newTheme();
        newTheme.applyStyle(i6, true);
        return newTheme;
    }

    static ClassLoader a(ClassLoader classLoader, String str) {
        com.kwad.library.b.a.b zI;
        com.kwad.library.b.a bM = bM(str);
        return (bM == null || !bM.isLoaded() || (zI = bM.zI()) == null) ? classLoader : zI;
    }
}
