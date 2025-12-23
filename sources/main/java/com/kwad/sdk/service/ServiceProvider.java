package com.kwad.sdk.service;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ServiceProvider {
    private static List<Throwable> Oe;

    @SuppressLint({"StaticFieldLeak"})
    private static Context aYl;

    @SuppressLint({"StaticFieldLeak"})
    private static Context aYm;
    private static boolean aYn;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t5) {
            this.mProviders.put(cls, t5);
        }

        ServiceProviderDelegate() {
        }
    }

    public static void Po() {
        aYn = true;
    }

    @NonNull
    @Deprecated
    public static Context Pp() {
        return mContext;
    }

    private static void b(Throwable th) {
        if (Oe == null) {
            Oe = new CopyOnWriteArrayList();
        }
        Oe.add(th);
    }

    public static void co(Context context) {
        aYl = context;
        mContext = m.ep(context);
    }

    public static void f(com.kwad.sdk.g.a<Throwable> aVar) {
        List<Throwable> list = Oe;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
        Oe.clear();
        Oe = null;
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    @NonNull
    public static Context getContext() {
        if (aYn) {
            return Pp();
        }
        if (aYm == null) {
            aYm = m.wrapContextIfNeed(mContext);
        }
        return aYm;
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static <T> void put(Class<T> cls, T t5) {
        ServiceProviderDelegate.INSTANCE.put(cls, t5);
    }

    public static void reportSdkCaughtException(Throwable th) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        } else {
            b(th);
        }
    }

    public static String getAppId() {
        return b.getAppId();
    }

    public static String getAppName() {
        return b.getAppName();
    }

    @NonNull
    public static SdkConfig getSDKConfig() {
        return b.getSDKConfig();
    }
}
