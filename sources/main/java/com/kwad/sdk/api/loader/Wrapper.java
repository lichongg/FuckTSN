package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class Wrapper {
    private static final String CLAZZ_NAME = "com.kwad.sdk.api.loader.Wrapper";
    private static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    private static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    private static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    private static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    private static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    private static final String TAG = "Wrapper";
    private static final int TIMELINE_MINIWRAP = 150;
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static Map<Context, Context> sResContextCache = new WeakHashMap();

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

    public static boolean containsAllElements(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        if (stackTraceElementArr == null || stackTraceElementArr2 == null) {
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(stackTraceElementArr));
        for (StackTraceElement stackTraceElement : stackTraceElementArr2) {
            if (!hashSet.contains(stackTraceElement)) {
                return false;
            }
        }
        return true;
    }

    @Keep
    @Deprecated
    public static Context unwrapContextIfNeed(Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.g("URC", context);
        if (context2 != null) {
            return context2;
        }
        ResContext resContext = context instanceof ResContext ? (ResContext) context : null;
        Context context3 = context;
        while (context3 instanceof ContextWrapper) {
            if (context3 instanceof Activity) {
                return context3;
            }
            if (context3 instanceof ResContext) {
                resContext = context3;
                context3 = resContext.getDelegatedContext();
            } else {
                context3 = ((ContextWrapper) context3).getBaseContext();
            }
        }
        return resContext != null ? resContext.getDelegatedContext() : context;
    }

    @NonNull
    @Keep
    public static Context wrapContextIfNeed(@Nullable Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.g("WRC", context);
        if (context2 != null) {
            return context2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return context;
        }
        if (context == null) {
            return null;
        }
        if ((context instanceof ResContext) || returnUnWrappedContext(context)) {
            return context;
        }
        if (context instanceof ContextThemeWrapper) {
            Context context3 = sResContextCache.get(context);
            if (context3 != null) {
                return context3;
            }
            t tVar = new t((ContextThemeWrapper) context);
            sResContextCache.put(context, tVar);
            return tVar;
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            Context context4 = sResContextCache.get(context);
            if (context4 != null) {
                return context4;
            }
            u uVar = new u((androidx.appcompat.view.ContextThemeWrapper) context);
            sResContextCache.put(context, uVar);
            return uVar;
        }
        if (context instanceof ContextWrapper) {
            Context context5 = sResContextCache.get(context);
            if (context5 != null) {
                return context5;
            }
            v vVar = new v(context);
            sResContextCache.put(context, vVar);
            return vVar;
        }
        Context context6 = sResContextCache.get(context);
        if (context6 != null) {
            return context6;
        }
        v vVar2 = new v(context);
        sResContextCache.put(context, vVar2);
        return vVar2;
    }

    @Keep
    @Deprecated
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        LayoutInflater layoutInflater2 = (LayoutInflater) com.kwad.sdk.api.c.g("WRI", layoutInflater);
        if (layoutInflater2 != null) {
            return layoutInflater2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof ResContext) {
            return layoutInflater;
        }
        Context wrapContextIfNeed = wrapContextIfNeed(context);
        return wrapContextIfNeed instanceof ResContext ? layoutInflater.cloneInContext(wrapContextIfNeed) : layoutInflater;
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
        Object obj = ApiReflect.h(context).cq("getThemeResId").get();
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    private static boolean needAutoUnWrap(Context context, a aVar) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (containsAllElements(stackTrace, aVar.aqd)) {
            a.g(aVar);
            aVar.aqd = stackTrace;
            return aVar.aqe >= 5;
        }
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
            if (i6 < stackTrace.length && CLAZZ_NAME.equals(className) && METHOD_WRAP_CONTEXT.equals(methodName)) {
                StackTraceElement stackTraceElement2 = stackTrace[i6];
                if (TextUtils.equals(name, stackTraceElement2.getClassName()) && METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i7 = i7 + 1) >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void onDestroy(Context context) {
        if (context == null) {
            return;
        }
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
            if (aVar.aqc >= (context instanceof Application ? 15 : 5) && needAutoUnWrap(context, aVar)) {
                aVar.clear();
                return true;
            }
        }
        return false;
    }

    static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof ResContext ? layoutInflater : layoutInflater.cloneInContext(context);
    }

    static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            return externalClassLoader;
        }
        return classLoader;
    }

    static Resources replaceExternalResources(Resources resources) {
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            return externalResource;
        }
        return resources;
    }

    static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i6) {
        Resources.Theme theme3 = (Resources.Theme) com.kwad.sdk.api.c.g("WRT", theme, theme2, Integer.valueOf(i6));
        if (theme3 != null) {
            return theme3;
        }
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = externalResource.newTheme();
                newTheme.applyStyle(i6, true);
                return newTheme;
            }
            return theme2;
        }
        return theme;
    }
}
