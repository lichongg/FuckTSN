package com.kwad.components.ad.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.c;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.feed.e$2, reason: invalid class name */
    final class AnonymousClass2 extends com.kwad.components.core.request.d {
        final /* synthetic */ SceneImpl bX;
        final /* synthetic */ KsLoadManager.FeedAdListener hh;
        final /* synthetic */ boolean hi;
        final /* synthetic */ long hj;

        AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z5, long j6) {
            this.hh = feedAdListener;
            this.bX = sceneImpl;
            this.hi = z5;
            this.hj = j6;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
        public final void b(@NonNull AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adTemplateList.size());
            if (adTemplateList.isEmpty()) {
                com.kwad.components.ad.feed.monitor.b.ch();
            }
            String str = null;
            for (AdTemplate adTemplate : adTemplateList) {
                if (adTemplate != null) {
                    AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
                    if (FeedType.checkTypeValid(adTemplate)) {
                        adTemplate.mAdScene = this.bX;
                        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(el))) {
                            Pair<Integer, String> m6 = com.kwad.components.ad.feed.monitor.a.m(adTemplate);
                            com.kwad.components.ad.feed.monitor.b.f(((Integer) m6.first).intValue(), (String) m6.second);
                        }
                        arrayList.add(new c(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate), this.hi));
                    } else {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.be(el)), FeedType.fromInt(adTemplate.type, adTemplate.defaultType));
                        com.kwad.components.ad.feed.monitor.b.b(com.kwad.sdk.core.response.b.a.be(el), adTemplate.type, adTemplate);
                    }
                }
            }
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            com.kwad.components.ad.feed.monitor.b.C(arrayList.size());
            if (!arrayList.isEmpty()) {
                com.kwad.sdk.commercial.d.d.a(this.bX, arrayList.size());
                if (!com.kwad.sdk.core.config.e.ES() || (l.Cf().Bk() && !(l.Cf().Bk() && com.kwad.sdk.core.config.e.ET() == 1))) {
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.e.2.3
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            final int size = arrayList.size();
                            final int[] iArr = {0};
                            for (final KsFeedAd ksFeedAd : arrayList) {
                                final c cVar = (c) ksFeedAd;
                                com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                                final int i6 = com.kwad.sdk.core.response.b.b.dd(cVar.getAdTemplate()) ? 3 : 2;
                                final long elapsedRealtime = SystemClock.elapsedRealtime();
                                cVar.a(new c.a() { // from class: com.kwad.components.ad.feed.e.2.3.1
                                    @Override // com.kwad.components.ad.feed.c.a
                                    public final void d(int i7, String str2) {
                                        com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar);
                                        com.kwad.components.ad.feed.monitor.b.a(((c) ksFeedAd).getAdTemplate(), i7, i6, SystemClock.elapsedRealtime() - elapsedRealtime, str2);
                                        int[] iArr2 = iArr;
                                        int i8 = iArr2[0] + 1;
                                        iArr2[0] = i8;
                                        int i9 = size;
                                        if (i8 == i9) {
                                            com.kwad.components.ad.feed.monitor.b.a(i9, SystemClock.elapsedRealtime() - AnonymousClass2.this.hj);
                                            KsAdLoadManager.M().b(arrayList);
                                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                            AnonymousClass2.this.hh.onFeedAdLoad(arrayList);
                                            com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.bX.getPosId(), (List<KsFeedAd>) arrayList);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    return;
                } else {
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.e.2.2
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.components.ad.feed.monitor.b.a(arrayList.size(), SystemClock.elapsedRealtime() - AnonymousClass2.this.hj);
                            KsAdLoadManager.M().b(arrayList);
                            AnonymousClass2.this.hh.onFeedAdLoad(arrayList);
                            com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.bX.getPosId(), (List<KsFeedAd>) arrayList);
                        }
                    });
                    return;
                }
            }
            com.kwad.components.ad.feed.monitor.b.e(com.kwad.sdk.core.network.e.aEq.errorCode, com.kwad.sdk.core.network.e.aEq.msg + str);
            onError(com.kwad.sdk.core.network.e.aEq.errorCode, com.kwad.sdk.core.network.e.aEq.msg + str);
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onError");
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
        public final void onError(final int i6, final String str) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.e.2.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    AnonymousClass2.this.hh.onError(i6, str);
                }
            });
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i6), str));
            com.kwad.components.ad.feed.monitor.b.e(i6, str);
            if (i6 == com.kwad.sdk.core.network.e.aEl.errorCode || i6 == com.kwad.sdk.core.network.e.aEq.errorCode) {
                return;
            }
            com.kwad.components.ad.feed.monitor.b.g(i6, str);
        }
    }

    public static void a(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener, boolean z5) {
        if (!l.Cf().Bn()) {
            com.kwad.sdk.core.d.c.e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.e.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    KsLoadManager.FeedAdListener.this.onError(com.kwad.sdk.core.network.e.aEq.errorCode, com.kwad.sdk.core.network.e.aEq.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(covert);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.b.B(covert.getAdNum());
        boolean b6 = n.tn().b(covert, "loadConfigFeedAd");
        covert.setAdStyle(1);
        KsAdLoadManager.M().a(new a.C0634a().e(new ImpInfo(covert)).aM(b6).a(new AnonymousClass2(feedAdListener, covert, z5, elapsedRealtime)).sw());
    }
}
