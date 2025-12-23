package com.kwad.components.core.proxy.launchdialog;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private static e WB = new e();
    private List<b> WC = new CopyOnWriteArrayList();
    private a WD;
    private com.kwad.components.core.proxy.b WE;

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(230).dm(25));
        long ev = com.kwad.sdk.core.response.b.e.ev(adTemplate);
        Iterator<b> it = this.WC.iterator();
        while (it.hasNext()) {
            it.next().b(ev, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(231).dm(25));
        long ev = com.kwad.sdk.core.response.b.e.ev(adTemplate);
        Iterator<b> it = this.WC.iterator();
        while (it.hasNext()) {
            it.next().b(ev, 3);
        }
    }

    public static e sc() {
        return WB;
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.WC.add(bVar);
        }
    }

    public final void aF(final AdTemplate adTemplate) {
        n(this.WD.rW());
        sc().a(DetectEventType.USER_CANCEL, new f() { // from class: com.kwad.components.core.proxy.launchdialog.e.1
            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void j(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onContinue");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void k(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onComplete");
                e.this.aH(adTemplate);
                e.this.n(aVar);
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void l(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onTimeout");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void m(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onNotMatch");
            }
        });
        sc().a(DetectEventType.USER_CONFIRM, new f() { // from class: com.kwad.components.core.proxy.launchdialog.e.2
            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void j(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onContinue");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void k(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onComplete");
                e.this.aG(adTemplate);
                e.this.n(aVar);
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void l(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onTimeout");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void m(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onNotMatch");
            }
        });
        long ev = com.kwad.sdk.core.response.b.e.ev(adTemplate);
        Iterator<b> it = this.WC.iterator();
        while (it.hasNext()) {
            it.next().b(ev, 1);
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.WC.remove(bVar);
        }
    }

    public final void n(com.kwad.components.core.proxy.a aVar) {
        this.WD.i(aVar);
        this.WD.h(aVar);
    }

    public e() {
        a aVar = new a();
        this.WD = aVar;
        this.WE = new com.kwad.components.core.proxy.b(aVar);
    }

    private void a(DetectEventType detectEventType, f fVar) {
        c a6 = this.WD.a(detectEventType);
        if (a6 != null) {
            a6.a(fVar);
            a6.start();
        }
    }

    public final void init(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext instanceof Application) {
            ((Application) origApplicationContext).registerActivityLifecycleCallbacks(this.WE);
        }
    }
}
