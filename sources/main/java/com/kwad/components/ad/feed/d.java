package com.kwad.components.ad.feed;

import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    private static com.kwad.sdk.core.g.d gX;
    private static com.kwad.sdk.core.g.c gY;
    private static Vibrator gZ;
    private static List<c> ha = new CopyOnWriteArrayList();
    private static List<a> hb = new CopyOnWriteArrayList();
    private static long hc;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private b hf;
        private Context mContext;

        public a(b bVar, Context context) {
            this.hf = bVar;
            this.mContext = context;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        boolean s(String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {
        private InterfaceC0556d hg;
        private Context mContext;

        public c(InterfaceC0556d interfaceC0556d, Context context) {
            this.hg = interfaceC0556d;
            this.mContext = context;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.feed.d$d, reason: collision with other inner class name */
    public interface InterfaceC0556d {
        boolean b(double d6);
    }

    public static void a(float f6, Context context, InterfaceC0556d interfaceC0556d) {
        if (gX == null) {
            a(f6, context);
        }
        ha.add(new c(interfaceC0556d, context));
    }

    public static void D(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = gY;
            if (cVar != null) {
                cVar.bH(context);
                gY = null;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void E(Context context) {
        try {
            com.kwad.sdk.core.g.d dVar = gX;
            if (dVar != null) {
                dVar.bH(context);
                gX = null;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Vibrator F(Context context) {
        if (gZ == null) {
            gZ = (Vibrator) context.getSystemService("vibrator");
        }
        return gZ;
    }

    public static synchronized boolean bY() {
        synchronized (d.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - hc <= 500) {
                return false;
            }
            hc = elapsedRealtime;
            return true;
        }
    }

    public static void a(InterfaceC0556d interfaceC0556d) {
        for (c cVar : ha) {
            if (cVar != null && cVar.hg == interfaceC0556d) {
                ha.remove(cVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "sShakeItems size " + ha.size());
    }

    private static void a(float f6, Context context) {
        gX = new com.kwad.sdk.core.g.d(f6);
        ha = new CopyOnWriteArrayList();
        gX.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.feed.d.1
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d6) {
                if (d.ha != null) {
                    Iterator it = d.ha.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c cVar = (c) it.next();
                        if (cVar != null && cVar.hg != null && cVar.hg.b(d6)) {
                            bw.a(cVar.mContext, d.F(cVar.mContext));
                            break;
                        }
                    }
                    bw.a(new bg() { // from class: com.kwad.components.ad.feed.d.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onShakeEvent openGate2");
                            if (d.gX != null) {
                                d.gX.Jb();
                            }
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void cd() {
            }
        });
        gX.g(f6);
        gX.bG(context);
    }

    public static void a(AdMatrixInfo.RotateInfo rotateInfo, Context context, b bVar) {
        com.kwad.sdk.core.g.c cVar = gY;
        if (cVar == null) {
            a(rotateInfo, context);
        } else {
            cVar.a(rotateInfo);
        }
        hb.add(new a(bVar, context));
    }

    public static void a(b bVar) {
        for (a aVar : hb) {
            if (aVar != null && aVar.hf == bVar) {
                hb.remove(aVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "sRotateItems size " + hb.size());
    }

    private static void a(AdMatrixInfo.RotateInfo rotateInfo, Context context) {
        com.kwad.sdk.core.g.c cVar = new com.kwad.sdk.core.g.c(rotateInfo);
        gY = cVar;
        cVar.a(new com.kwad.sdk.core.g.a() { // from class: com.kwad.components.ad.feed.d.2
            @Override // com.kwad.sdk.core.g.a
            public final void r(String str) {
                a aVar;
                if (d.hb != null) {
                    Iterator it = d.hb.iterator();
                    while (it.hasNext() && ((aVar = (a) it.next()) == null || aVar.hf == null || !aVar.hf.s(str))) {
                    }
                    bw.a(new bg() { // from class: com.kwad.components.ad.feed.d.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onRotateEvent openGate2");
                            if (d.gY != null) {
                                d.gY.Jb();
                            }
                        }
                    }, null, 1000L);
                }
            }

            @Override // com.kwad.sdk.core.g.a
            public final void ce() {
            }
        });
        gY.bG(context);
    }
}
