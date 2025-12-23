package com.kwad.components.ad.reward.presenter.b;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.video.m;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private IAdLiveEndRequest iS;
    private long jY;

    @Nullable
    private p se;

    @Nullable
    private View xj;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.1
        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @NonNull
        private static AdLiveEndResultData W(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: cM, reason: merged with bridge method [inline-methods] */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.iS);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ AdLiveEndResultData parseData(String str) {
            return W(str);
        }
    };
    private final m vR = new m() { // from class: com.kwad.components.ad.reward.presenter.b.b.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.iZ();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.ja();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            super.onMediaPlayProgress(j6, j7);
            b.this.jY = j7;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.ja();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iI() {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0675a c0675a = new a.C0675a();
        bVar.dm(24);
        bVar.b(c0675a);
        com.kwad.components.ad.reward.j.b.a(true, this.tm.mAdTemplate, null, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ() {
        if (this.iS == null) {
            return;
        }
        this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull final AdLiveEndResultData adLiveEndResultData) {
                super.onSuccess(aVar, adLiveEndResultData);
                if (adLiveEndResultData.mQLivePushEndInfo == null) {
                    return;
                }
                b.this.tm.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.reward.presenter.b.b.3.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (b.this.se == null) {
                            b bVar = b.this;
                            bVar.se = new p(bVar.tm);
                        }
                        b.this.se.h(b.this.tm.mRootContainer);
                        b.this.se.b(r.aa(b.this.tm.mAdTemplate));
                        b.this.se.a(b.this.tm, adLiveEndResultData.mQLivePushEndInfo, b.this.jY);
                        b.this.tm.se = b.this.se;
                        if (b.this.tm.mContext.getResources().getConfiguration().orientation == 2) {
                            b bVar2 = b.this;
                            bVar2.xj = bVar2.findViewById(R.id.ksad_live_end_page_layout_root_landscape);
                        } else {
                            b bVar3 = b.this;
                            bVar3.xj = bVar3.findViewById(R.id.ksad_live_end_page_layout_root);
                        }
                        b.this.xj.setVisibility(0);
                        b.this.iI();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i6, String str) {
                super.onError(aVar, i6, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        View view = this.xj;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        com.kwad.components.core.o.a.b.a aVar;
        super.at();
        if (this.tm.rE.kW()) {
            this.tm.rE.a(this.vR);
            String bh = com.kwad.sdk.core.response.b.a.bh(e.el(this.tm.mAdTemplate));
            if (!TextUtils.isEmpty(bh) && (aVar = (com.kwad.components.core.o.a.b.a) d.f(com.kwad.components.core.o.a.b.a.class)) != null) {
                this.iS = aVar.getAdLiveEndRequest(bh);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.tm.rE.kW()) {
            this.tm.rE.b(this.vR);
        }
    }
}
