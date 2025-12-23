package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static Map<String, WeakReference<C0690a>> aJq = new ConcurrentHashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.threads.a$a, reason: collision with other inner class name */
    public static class C0690a {
        private HandlerThread aJr;
        private Handler iK;

        public final Handler getHandler() {
            return this.iK;
        }

        public C0690a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.aJr = handlerThread;
            handlerThread.start();
            this.iK = new Handler(this.aJr.getLooper());
        }
    }

    public static synchronized Handler Ji() {
        Handler handler;
        synchronized (a.class) {
            handler = eB("reportHT").getHandler();
        }
        return handler;
    }

    @NonNull
    private static C0690a eB(String str) {
        WeakReference<C0690a> weakReference = aJq.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C0690a c0690a = new C0690a(str);
        aJq.put(str, new WeakReference<>(c0690a));
        return c0690a;
    }
}
