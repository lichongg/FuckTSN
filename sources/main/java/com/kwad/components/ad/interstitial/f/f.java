package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends b implements com.kwad.sdk.widget.d {

    @NonNull
    private KsAdVideoPlayConfig bU;
    private List<Integer> ck;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0692a cz;
    private KSFrameLayout fC;
    private ImageView hM;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @NonNull
    protected Context mContext;
    private c mj;
    private KSFrameLayout ni;
    private com.kwad.components.core.video.f nj;

    @Nullable
    private boolean mIsAudioEnable = false;
    private final a.InterfaceC0635a hQ = new a.InterfaceC0635a() { // from class: com.kwad.components.ad.interstitial.f.f.4
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        @Override // com.kwad.components.core.video.a.InterfaceC0635a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(int r11, com.kwad.sdk.utils.aj.a r12) {
            /*
                r10 = this;
                r0 = 2
                r1 = 0
                r2 = 1
                if (r11 == r2) goto L16
                if (r11 == r0) goto L13
                r3 = 3
                if (r11 == r3) goto Le
                r11 = 108(0x6c, float:1.51E-43)
            Lc:
                r3 = 2
                goto L19
            Le:
                r11 = 83
                r1 = 1
                r3 = 1
                goto L19
            L13:
                r11 = 82
                goto Lc
            L16:
                r11 = 13
                goto Lc
            L19:
                com.kwad.components.ad.interstitial.f.f r4 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.ad.interstitial.f.f.d(r4)
                boolean r4 = com.kwad.sdk.utils.aq.QW()
                if (r4 == 0) goto L25
                goto L26
            L25:
                r0 = 1
            L26:
                com.kwad.components.ad.interstitial.report.a r4 = com.kwad.components.ad.interstitial.report.a.eO()
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.a(r5)
                r6 = 1
                long r8 = (long) r11
                r4.a(r5, r6, r8)
                com.kwad.components.core.e.d.a$a r4 = new com.kwad.components.core.e.d.a$a
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                android.content.Context r5 = com.kwad.components.ad.interstitial.f.f.f(r5)
                r4.<init>(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.a(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.aB(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.core.e.d.c r5 = com.kwad.components.ad.interstitial.f.f.e(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.b(r5)
                com.kwad.components.core.e.d.a$a r3 = r4.aB(r3)
                com.kwad.components.core.e.d.a$a r1 = r3.aq(r1)
                com.kwad.components.core.e.d.a$a r1 = r1.as(r2)
                com.kwad.components.core.e.d.a$a r1 = r1.aA(r11)
                com.kwad.components.core.e.d.a$a r12 = r1.d(r12)
                com.kwad.components.core.e.d.a$a r12 = r12.aC(r0)
                com.kwad.components.ad.interstitial.f.f$4$1 r0 = new com.kwad.components.ad.interstitial.f.f$4$1
                r0.<init>()
                com.kwad.components.core.e.d.a$a r11 = r12.a(r0)
                com.kwad.components.core.e.d.a.a(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.f.f.AnonymousClass4.a(int, com.kwad.sdk.utils.aj$a):void");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j6) {
        int ceil = (int) Math.ceil(j6 / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.ck.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void ex() {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.f.f.ex():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j6) {
        c cVar = this.mj;
        cVar.ml = true;
        cVar.c(1L, j6);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.mj.a(c(view, true));
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        c cVar = (c) NN();
        this.mj = cVar;
        this.bU = cVar.bU;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.mAdInfo = el;
        List<Integer> bp = com.kwad.sdk.core.response.b.a.bp(el);
        this.ck = bp;
        com.kwad.sdk.core.video.videoview.a aVar = this.mj.cq;
        this.cq = aVar;
        aVar.setTag(bp);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.cq);
        this.nj = fVar;
        fVar.setDataFlowAutoStart(this.bU.isDataFlowAutoStart());
        this.nj.setAdClickListener(this.hQ);
        this.nj.ty();
        this.mApkDownloadHelper = this.mj.mApkDownloadHelper;
        ex();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.fC.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        this.mj.a(c(view, false));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ni = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.fC = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.hM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.fC.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mj.mr = null;
    }

    private c.C0567c c(View view, boolean z5) {
        return new c.C0567c(view.getContext()).l(z5).a(this.ni.getTouchCoords()).L(3).M(85);
    }
}
