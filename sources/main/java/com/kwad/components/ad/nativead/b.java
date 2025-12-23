package com.kwad.components.ad.nativead;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bz;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static long hc;
    private com.kwad.sdk.core.g.d gX;
    private com.kwad.sdk.core.g.c gY;
    private CopyOnWriteArrayList<d> oA = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<C0575b> oB = new CopyOnWriteArrayList<>();
    private int oC;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final b oF = new b();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.nativead.b$b, reason: collision with other inner class name */
    public static class C0575b {
        private Context mContext;
        private c oG;

        public C0575b(c cVar, Context context) {
            this.oG = cVar;
            this.mContext = context;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void B(String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d {
        private final e oH;
        private final WeakReference<View> oI;

        public d(e eVar, View view) {
            this.oI = new WeakReference<>(view);
            this.oH = eVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        void f(double d6);
    }

    public static synchronized boolean bY() {
        synchronized (b.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - hc <= 500) {
                return false;
            }
            hc = elapsedRealtime;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(double d6) {
        CopyOnWriteArrayList<d> copyOnWriteArrayList = this.oA;
        int FH = (int) (com.kwad.sdk.core.config.e.FH() * 100.0f);
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<d> it = copyOnWriteArrayList.iterator();
        d dVar = null;
        d dVar2 = null;
        int i6 = Integer.MAX_VALUE;
        while (it.hasNext()) {
            d next = it.next();
            WeakReference weakReference = next.oI;
            if (weakReference != null) {
                Rect rect = new Rect();
                if (((View) weakReference.get()).getGlobalVisibleRect(rect) && bz.o((View) weakReference.get(), FH)) {
                    int i7 = this.oC / 2;
                    int min = Math.min(Math.abs(rect.top - i7), Math.abs(rect.bottom - i7));
                    if (min < i6) {
                        dVar = next;
                        i6 = min;
                    } else if (min == i6) {
                        dVar2 = next;
                    }
                }
            }
        }
        if (dVar != null) {
            if (dVar2 != null) {
                Rect rect2 = new Rect();
                ((View) dVar.oI.get()).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                ((View) dVar2.oI.get()).getGlobalVisibleRect(rect2);
                if (rect2.top < rect3.top) {
                    dVar = dVar2;
                }
            }
            dVar.oH.f(d6);
        }
    }

    public final void D(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = this.gY;
            if (cVar != null) {
                cVar.bH(context);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void N(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = this.gY;
            if (cVar != null) {
                cVar.bG(context);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static b fm() {
        return a.oF;
    }

    public final void a(float f6, View view, e eVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.gX == null) {
            this.oC = com.kwad.sdk.c.a.a.bi(view.getContext());
            a(f6, view.getContext());
        }
        this.oA.add(new d(eVar, view));
    }

    public final void a(e eVar) {
        Iterator<d> it = this.oA.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.oH == eVar) {
                this.oA.remove(next);
            }
        }
        com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "sShakeItems size " + this.oA.size());
    }

    private void a(float f6, Context context) {
        this.gX = new com.kwad.sdk.core.g.d(f6);
        this.oA = new CopyOnWriteArrayList<>();
        this.gX.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.nativead.b.1
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d6) {
                if (b.this.oA != null) {
                    b.this.e(d6);
                    bw.a(new bg() { // from class: com.kwad.components.ad.nativead.b.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "onShakeEvent openGate2");
                            b.this.gX.Jb();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void cd() {
            }
        });
        this.gX.g(f6);
        this.gX.bG(context);
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo, Context context, c cVar) {
        com.kwad.sdk.core.g.c cVar2 = this.gY;
        if (cVar2 == null) {
            a(rotateInfo, context);
        } else {
            cVar2.a(rotateInfo);
        }
        this.oB.add(new C0575b(cVar, context));
    }

    public final void a(c cVar) {
        Iterator<C0575b> it = this.oB.iterator();
        while (it.hasNext()) {
            C0575b next = it.next();
            if (next != null && next.oG == cVar) {
                this.oB.remove(next);
            }
        }
        com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "sRotateItems size " + this.oB.size());
    }

    private void a(AdMatrixInfo.RotateInfo rotateInfo, Context context) {
        com.kwad.sdk.core.g.c cVar = new com.kwad.sdk.core.g.c(rotateInfo);
        this.gY = cVar;
        cVar.a(new com.kwad.sdk.core.g.a() { // from class: com.kwad.components.ad.nativead.b.2
            @Override // com.kwad.sdk.core.g.a
            public final void r(String str) {
                if (b.this.oB != null) {
                    Iterator it = b.this.oB.iterator();
                    while (it.hasNext()) {
                        C0575b c0575b = (C0575b) it.next();
                        if (c0575b != null && c0575b.oG != null) {
                            c0575b.oG.B(str);
                            return;
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.core.g.a
            public final void ce() {
            }
        });
        this.gY.bG(context);
    }
}
