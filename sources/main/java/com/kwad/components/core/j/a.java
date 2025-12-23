package com.kwad.components.core.j;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.k;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static int QU = 12;
    private static int QV = 4;
    private static int QW = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.j.a$a, reason: collision with other inner class name */
    public interface InterfaceC0621a {
        void e(@Nullable List<c> list);

        void onError(int i6, String str);

        void onRequestResult(int i6);
    }

    public static void a(@NonNull SceneImpl sceneImpl, InterfaceC0621a interfaceC0621a) {
        a(15, QV, sceneImpl, e.AGGREGATION, interfaceC0621a);
    }

    private static void a(int i6, int i7, @NonNull SceneImpl sceneImpl, final int i8, final InterfaceC0621a interfaceC0621a) {
        SceneImpl m124clone = sceneImpl.m124clone();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        m124clone.setAdStyle(i6);
        m124clone.setAdNum(i7);
        a(new ImpInfo(m124clone), null, false, true, new k() { // from class: com.kwad.components.core.j.a.1
            @Override // com.kwad.components.core.request.l
            public final void b(@NonNull final AdResultData adResultData) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.j.a.1.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            InterfaceC0621a.this.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.j.a.1.3
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        InterfaceC0621a.this.e(a.b(adResultData.getAdTemplateList(), i8));
                        a.a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.request.l
            public final void onError(final int i9, final String str) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.j.a.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i9), str));
                        InterfaceC0621a.this.onError(i9, str);
                    }
                });
            }
        }, false);
    }

    public static void b(@NonNull SceneImpl sceneImpl, InterfaceC0621a interfaceC0621a) {
        a(17, QW, sceneImpl, e.Rh, interfaceC0621a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> b(List<AdTemplate> list, int i6) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new c(it.next(), i6));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdResultData adResultData, long j6) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.p.a.se().h(adTemplate, elapsedRealtime - j6);
    }

    private static void a(final ImpInfo impInfo, List<String> list, boolean z5, boolean z6, @NonNull final k kVar, boolean z7) {
        final boolean z8 = false;
        final boolean z9 = true;
        final List list2 = null;
        final boolean z10 = false;
        new com.kwad.components.core.n.a(impInfo) { // from class: com.kwad.components.core.j.a.2
            @Override // com.kwad.components.core.n.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: ou, reason: merged with bridge method [inline-methods] */
            public final com.kwad.components.core.request.a createRequest() {
                com.kwad.components.core.request.a aVar = new com.kwad.components.core.request.a(impInfo, list2, z8, null);
                aVar.aU(z9 ? 1 : 0);
                return aVar;
            }
        }.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.j.a.3
            private void k(int i6, String str) {
                kVar.onError(i6, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                n((AdResultData) baseResultData);
            }

            private void n(@NonNull AdResultData adResultData) {
                String str;
                if (adResultData.isAdResultDataEmpty() && !z10) {
                    k kVar2 = kVar;
                    int i6 = com.kwad.sdk.core.network.e.aEq.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.aEq.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    kVar2.onError(i6, str);
                    return;
                }
                kVar.b(adResultData);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i6, String str) {
                k(i6, str);
            }
        });
    }
}
