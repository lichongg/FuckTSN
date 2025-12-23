package com.kwad.library.solder.lib;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.ext.c;
import com.kwad.sdk.utils.bw;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i {
    private static volatile i aqD;
    private static Map<String, Integer> aqF = new ConcurrentHashMap(8);

    @Nullable
    private static a aqG;
    private e aqE;
    private volatile boolean mHasInit = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void b(String str, File file);

        void f(String str, Throwable th);

        int getCorePoolSize();

        int getMaxRetryCount();

        boolean zV();
    }

    private synchronized void init(Context context) {
        try {
            if (this.mHasInit) {
                return;
            }
            c.a bZ = new c.a().bZ("sodler");
            a aVar = aqG;
            c.a bk = bZ.cj(aVar != null ? aVar.getMaxRetryCount() : 1).bk(false);
            a aVar2 = aqG;
            c.a bl = bk.bl(aVar2 != null && aVar2.zV());
            a aVar3 = aqG;
            c.a a6 = bl.a(cg(aVar3 != null ? aVar3.getCorePoolSize() : 0));
            a aVar4 = aqG;
            com.kwad.library.solder.lib.ext.c Ay = a6.ck(aVar4 != null ? aVar4.getCorePoolSize() : 0).Ay();
            d dVar = new d(context);
            c cVar = new c(context, Ay);
            f fVar = new f(context);
            fVar.a(new f.a() { // from class: com.kwad.library.solder.lib.i.2
                @Override // com.kwad.library.solder.lib.a.f.a
                public final void a(com.kwad.library.solder.lib.a.e eVar, File file) {
                    if (i.aqG != null) {
                        try {
                            i.aqG.b(eVar.getDownloadUrl(), file);
                        } catch (Throwable th) {
                            i.aqG.f(eVar.getDownloadUrl(), th);
                            throw new PluginError.UpdateError(th.getMessage(), 2010);
                        }
                    }
                }
            });
            this.aqE = new e(dVar, fVar, cVar, Ay, new com.kwad.library.solder.lib.ext.a());
            this.mHasInit = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void a(a aVar) {
        aqG = aVar;
    }

    public static boolean bR(String str) {
        try {
            Map<String, Integer> map = aqF;
            if (map != null) {
                return map.containsKey(str);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static ExecutorService cg(int i6) {
        return new ThreadPoolExecutor(i6, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.library.solder.lib.i.1
            private final AtomicInteger poolNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                try {
                    String name = thread.getName();
                    thread.setName(name + "-");
                    i.aqF.put(name, 1);
                    return thread;
                } catch (Throwable th) {
                    com.kwad.library.solder.lib.a.e("Sodler", Log.getStackTraceString(th));
                    return thread;
                }
            }
        });
    }

    public static i zS() {
        if (aqD == null) {
            synchronized (i.class) {
                try {
                    if (aqD == null) {
                        aqD = new i();
                    }
                } finally {
                }
            }
        }
        return aqD;
    }

    public final void l(Context context, final String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        if (zM() == null || zM().Aw() == null) {
            return;
        }
        zM().Aw().execute(new Runnable() { // from class: com.kwad.library.solder.lib.i.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    i.this.aqE.zP().bN(str);
                } catch (Throwable th) {
                    Log.getStackTraceString(th);
                }
            }
        });
    }

    @Nullable
    public final com.kwad.library.solder.lib.a.a m(Context context, String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        e eVar = this.aqE;
        if (eVar != null) {
            return eVar.zN().bP(str);
        }
        return null;
    }

    public final com.kwad.library.solder.lib.ext.c zM() {
        if (this.mHasInit) {
            return this.aqE.zM();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    private i() {
    }

    public final <P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> void a(Context context, @NonNull R r5, com.kwad.library.solder.lib.ext.b<P, R> bVar) {
        init(context);
        r5.ci(this.aqE.zM().getRetryCount());
        r5.a(new b<P, R>(bVar, new b.C0666b()) { // from class: com.kwad.library.solder.lib.i.3
            /* JADX WARN: Incorrect types in method signature: (TR;Lcom/kwad/library/solder/lib/ext/PluginError;)V */
            @Override // com.kwad.library.solder.lib.b, com.kwad.library.solder.lib.ext.b
            public final void a(final com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                long j6;
                super.a((AnonymousClass3<P, R>) eVar, pluginError);
                com.kwad.library.solder.lib.a.e("Sodler", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
                i.this.aqE.i(eVar);
                boolean z5 = eVar.Ab() instanceof PluginError.UpdateError;
                Runnable runnable = new Runnable() { // from class: com.kwad.library.solder.lib.i.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (eVar.Ac()) {
                            i.this.aqE.a(eVar, 16);
                        }
                    }
                };
                if (z5) {
                    j6 = 1000;
                } else {
                    j6 = 0;
                }
                bw.runOnUiThreadDelay(runnable, j6);
            }
        });
        this.aqE.a(r5, 16);
    }
}
