package cn.jiguang.bz;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import cn.jiguang.bz.m;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

/* loaded from: D:\Downloads\app\classes2.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    private static volatile Handler f2767b;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f2766a = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f2768c = new ConcurrentHashMap<>(32);

    /* renamed from: cn.jiguang.bz.m$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final m f2769a = new m(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f2770a;

        /* renamed from: b, reason: collision with root package name */
        private final String f2771b;

        /* renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f2772c = new AtomicBoolean(false);

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.f2772c.get()) {
                    this.f2770a.run();
                }
            } finally {
                m.f2768c.remove(this.f2771b, this);
            }
        }

        b(Runnable runnable, String str) {
            this.f2770a = runnable;
            this.f2771b = str;
        }
    }

    private m() {
        f2767b = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b a(Runnable runnable, String str, String str2, b bVar) {
        if (bVar != null) {
            f2767b.removeCallbacks(bVar);
        }
        return new b(runnable, str);
    }

    /* synthetic */ m(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static m a() {
        return a.f2769a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            String str = "immediate_" + f2766a.getAndIncrement();
            b bVar = new b(runnable, str);
            f2768c.put(str, bVar);
            f2767b.post(bVar);
        }
    }

    public void a(final String str, final Runnable runnable, long j6) {
        b bVar;
        Object compute;
        if (runnable == null || str == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            compute = f2768c.compute(str, new BiFunction() { // from class: cn.jiguang.bz.j1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    m.b a6;
                    a6 = m.a(runnable, str, (String) obj, (m.b) obj2);
                    return a6;
                }
            });
            bVar = (b) compute;
        } else {
            ConcurrentHashMap<String, b> concurrentHashMap = f2768c;
            b bVar2 = concurrentHashMap.get(str);
            if (bVar2 != null) {
                f2767b.removeCallbacks(bVar2);
            }
            b bVar3 = new b(runnable, str);
            concurrentHashMap.put(str, bVar3);
            bVar = bVar3;
        }
        f2767b.postDelayed(bVar, j6);
    }
}
