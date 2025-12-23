package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m implements c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.c.m$1, reason: invalid class name */
    final class AnonymousClass1 extends j {
        final /* synthetic */ com.kwad.components.core.request.model.a bD;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(com.kwad.components.core.request.model.a aVar, com.kwad.components.core.request.model.a aVar2) {
            super(aVar);
            this.bD = aVar2;
        }

        @Override // com.kwad.components.core.c.j
        protected final boolean a(final com.kwad.components.core.request.model.a aVar, final AdResultData adResultData) {
            AdResultData e6;
            final SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
            final int adNum = adScene.getAdNum();
            if (adResultData.isAdResultDataEmpty()) {
                GlobalThreadPools.Jt().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.a(adScene, adResultData, adNum, new k() { // from class: com.kwad.components.core.c.m.1.1.1
                            @Override // com.kwad.components.core.c.k
                            public final void ot() {
                                RunnableC06081 runnableC06081 = RunnableC06081.this;
                                com.kwad.components.core.request.model.a.a(aVar, adResultData, false);
                            }
                        });
                    }
                });
                return true;
            }
            if (adResultData.isBidding() && (e6 = l.e(aVar)) != null && !e6.isAdResultDataEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(e6.getProceedTemplateList());
                arrayList.addAll(adResultData.getProceedTemplateList());
                List<AdTemplate> m6 = m.m(arrayList);
                List<AdTemplate> subList = m6.subList(0, Math.min(adNum, m6.size()));
                if (subList != null && subList.size() > 0) {
                    com.kwad.components.core.request.model.a.a(aVar, new AdResultData(adResultData, adScene, subList), true);
                    return true;
                }
            }
            return false;
        }

        @Override // com.kwad.components.core.c.j, com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public final void onError(@NonNull final com.kwad.components.core.request.a aVar, final int i6, final String str) {
            GlobalThreadPools.Jt().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new k() { // from class: com.kwad.components.core.c.m.1.2.1
                        @Override // com.kwad.components.core.c.k
                        public final void ot() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.kwad.components.core.request.model.a.a(AnonymousClass1.this.bD, i6, str, false);
                        }
                    });
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i6, k kVar) {
            AdResultData e6 = l.e(this.bD);
            if (e6 == null || e6.isAdResultDataEmpty()) {
                if (kVar != null) {
                    kVar.ot();
                    return;
                }
                return;
            }
            List<AdTemplate> m6 = m.m(e6.getProceedTemplateList());
            List<AdTemplate> subList = m6.subList(0, Math.min(i6, m6.size()));
            if (subList.size() > 0) {
                if (adResultData == null) {
                    adResultData = new AdResultData(sceneImpl);
                }
                com.kwad.components.core.request.model.a.a(this.bD, new AdResultData(adResultData, sceneImpl, subList), false);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Comparator<AdTemplate> {
        private a() {
        }

        /* synthetic */ a(byte b6) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }

        private static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int ez = com.kwad.sdk.core.response.b.e.ez(adTemplate2) - com.kwad.sdk.core.response.b.e.ez(adTemplate);
            if (ez != 0) {
                return ez;
            }
            boolean z5 = adTemplate.fromCache;
            if (z5 && adTemplate2.fromCache) {
                return 0;
            }
            if (z5) {
                return 1;
            }
            return -1;
        }
    }

    public static List<AdTemplate> m(List<AdTemplate> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new a((byte) 0));
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : list) {
            long ev = com.kwad.sdk.core.response.b.e.ev(adTemplate);
            if (!hashSet.contains(Long.valueOf(ev))) {
                hashSet.add(Long.valueOf(ev));
                arrayList.add(adTemplate);
            }
        }
        return arrayList;
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        n.a(aVar, new AnonymousClass1(aVar, aVar));
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkFirst";
    }
}
