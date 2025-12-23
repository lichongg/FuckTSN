package com.kwad.components.core.e.a;

import android.app.Activity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private final List<b> Om;
    private final Stack<AdTemplate> On;
    private final AtomicBoolean Oo;
    private final Set<String> Op;
    private final String TAG;
    private final AtomicBoolean qY;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final e Ot = new e(0);
    }

    /* synthetic */ e(byte b6) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void oL() {
        if (this.On.isEmpty()) {
            return;
        }
        ay(this.On.pop());
    }

    public final synchronized void ax(AdTemplate adTemplate) {
        String ay = com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.el(adTemplate));
        if (com.kwad.sdk.core.response.b.b.dC(adTemplate) && !this.Op.contains(ay)) {
            this.Op.add(ay);
            ay(adTemplate);
        }
    }

    private e() {
        this.TAG = "InstalledActivateManager";
        this.Om = new CopyOnWriteArrayList();
        this.On = new Stack<>();
        this.qY = new AtomicBoolean();
        this.Oo = new AtomicBoolean();
        this.Op = new HashSet();
    }

    private void ay(final AdTemplate adTemplate) {
        if (!this.Oo.get() && !this.qY.get()) {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "showInstalledActivate");
            this.Oo.set(true);
            bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.core.e.a.e.1
                /* JADX INFO: Access modifiers changed from: private */
                public void oN() {
                    com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow");
                    e.this.az(adTemplate);
                    e.this.Oo.set(false);
                    e.this.Op.remove(com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.el(adTemplate)));
                }

                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    final com.kwad.components.ad.b.a.a aVar = (com.kwad.components.ad.b.a.a) com.kwad.sdk.components.d.f(com.kwad.components.ad.b.a.a.class);
                    if (aVar == null || !aVar.T()) {
                        oM();
                    } else {
                        aVar.a(new com.kwad.components.ad.b.a.c() { // from class: com.kwad.components.core.e.a.e.1.1
                            @Override // com.kwad.components.ad.b.a.c, com.kwad.components.ad.b.a.b
                            public final void V() {
                                aVar.b(this);
                                oM();
                                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onPushAdClose");
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void oM() {
                    com.kwad.sdk.core.c.b.Ho();
                    if (!com.kwad.sdk.core.c.b.isEnable()) {
                        e.this.Oo.set(false);
                        return;
                    }
                    com.kwad.sdk.core.c.b.Ho();
                    if (com.kwad.sdk.core.c.b.getCurrentActivity() != null) {
                        com.kwad.sdk.core.c.b.Ho();
                        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                            oN();
                            return;
                        }
                    }
                    com.kwad.sdk.core.c.b.Ho();
                    com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.e.1.2
                        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                        /* renamed from: onActivityResumed */
                        public final void d(Activity activity) {
                            super.d(activity);
                            com.kwad.sdk.core.c.b.Ho();
                            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onBackToForeground");
                            oN();
                        }
                    });
                }
            }, com.kwad.sdk.core.response.b.b.dD(adTemplate));
        } else {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "mLoadDisable: " + this.qY.get() + ", mLoadDisable: " + this.Oo.get());
            this.On.add(adTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(AdTemplate adTemplate) {
        if (a(adTemplate, new b() { // from class: com.kwad.components.core.e.a.e.2
            @Override // com.kwad.components.core.e.a.b
            public final void fY() {
                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "onViewClose");
                e.this.eL();
                e.this.oL();
            }

            @Override // com.kwad.components.core.e.a.b
            public final void oI() {
                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "onViewShow");
                e.this.fa();
            }
        })) {
            return;
        }
        oL();
    }

    public final void b(b bVar) {
        this.Om.remove(bVar);
    }

    public final void eL() {
        this.qY.set(false);
        Iterator<b> it = this.Om.iterator();
        while (it.hasNext()) {
            it.next().fY();
        }
    }

    public final void fa() {
        this.qY.set(true);
        Iterator<b> it = this.Om.iterator();
        while (it.hasNext()) {
            it.next().oI();
        }
    }

    public final boolean isShowing() {
        return this.qY.get();
    }

    public static e oK() {
        return a.Ot;
    }

    public final void a(b bVar) {
        this.Om.add(bVar);
    }

    private static boolean a(AdTemplate adTemplate, b bVar) {
        com.kwad.sdk.core.d.c.d("InstalledActivateManager", "showToActivityWindow");
        return new h().b(adTemplate, bVar);
    }
}
