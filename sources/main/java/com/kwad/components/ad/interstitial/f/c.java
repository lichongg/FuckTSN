package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.sdk.mvp.a {

    @NonNull
    public KsAdVideoPlayConfig bU;
    public com.kwad.sdk.core.video.videoview.a cq;

    @NonNull
    public KSFrameLayout fV;
    public com.kwad.components.ad.interstitial.g.b kO;
    public KsInterstitialAd.AdInteractionListener kQ;
    public com.kwad.components.ad.interstitial.d kW;
    public AdResultData mAdResultData;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public com.kwad.components.ad.interstitial.h.d mk;
    public boolean ml;
    public boolean mm;
    public boolean mn;
    public a mo;
    public com.kwad.components.core.webview.tachikoma.f.g mq;
    public e mr;
    public boolean mv;
    public boolean mw;
    public List<b> mp = new CopyOnWriteArrayList();
    private Handler iK = new Handler(Looper.getMainLooper());
    public volatile boolean mu = false;
    public int mx = -1;
    public List<a.c> mt = new CopyOnWriteArrayList();

    /* renamed from: ms, reason: collision with root package name */
    public List<d> f36337ms = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.interstitial.f.c$3, reason: invalid class name */
    final class AnonymousClass3 implements ImageLoadingListener {
        final /* synthetic */ Context dq;
        final /* synthetic */ View eu;

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        AnonymousClass3(Context context, View view) {
            this.dq = context;
            this.eu = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            h.execute(new bg() { // from class: com.kwad.components.ad.interstitial.f.c.3.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass3.this.dq.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    final RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(AnonymousClass3.this.dq.getResources(), stackBlur);
                    create.setCornerRadius(dimension);
                    AnonymousClass3.this.eu.post(new bg() { // from class: com.kwad.components.ad.interstitial.f.c.3.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            AnonymousClass3.this.eu.setBackground(create);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(long j6, long j7, boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void c(long j6, long j7);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.interstitial.f.c$c, reason: collision with other inner class name */
    public static class C0567c {
        private final Context context;
        private int mG;
        private boolean mH;
        private int mI;
        private boolean mJ;
        private aj.a mK;
        public double mL;
        public boolean mM;

        public final C0567c m(boolean z5) {
            this.mJ = true;
            return this;
        }

        public final C0567c n(boolean z5) {
            this.mM = true;
            return this;
        }

        public final C0567c L(int i6) {
            this.mG = i6;
            return this;
        }

        public final C0567c M(int i6) {
            this.mI = i6;
            return this;
        }

        public final C0567c a(aj.a aVar) {
            this.mK = aVar;
            return this;
        }

        public final C0567c c(double d6) {
            this.mL = d6;
            return this;
        }

        public final int dW() {
            return this.mG;
        }

        public final boolean dX() {
            return this.mH;
        }

        public final boolean dY() {
            return this.mJ;
        }

        public final int dZ() {
            return this.mI;
        }

        public final double ea() {
            return this.mL;
        }

        public final Context getContext() {
            return this.context;
        }

        public final aj.a getTouchCoords() {
            return this.mK;
        }

        public final C0567c l(boolean z5) {
            this.mH = z5;
            return this;
        }

        public C0567c(Context context) {
            this.context = context;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void eb();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        void ec();
    }

    public final void b(a.c cVar) {
        this.mt.remove(cVar);
    }

    public final boolean M(Context context) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null && context != null) {
            return com.kwad.sdk.core.response.b.a.bK(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.core.d.c.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
        return false;
    }

    public final void Y() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kQ;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    public final void b(C0567c c0567c) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.f(c0567c.getTouchCoords());
        if (!c0567c.dX() && !c0567c.mJ) {
            c0567c.M(153);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().dd(c0567c.dZ()).f(c0567c.getTouchCoords()).dr(aq.QW() ? 2 : 1).l(c0567c.ea()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar != null) {
            long a6 = a(aVar);
            int b6 = b(this.cq);
            bVar.aw(a6);
            bVar.dl(b6);
        }
        this.ml = true;
        c(1L, c0567c.mI);
    }

    public final void c(long j6, long j7) {
        Iterator<b> it = this.mp.iterator();
        while (it.hasNext()) {
            it.next().c(j6, j7);
        }
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kQ;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        a aVar = this.mo;
        if (aVar != null) {
            aVar.a(j6, j7, true);
        }
    }

    public final void dT() {
        e eVar = this.mr;
        if (eVar != null) {
            eVar.ec();
        }
    }

    public final void dU() {
        Iterator<d> it = this.f36337ms.iterator();
        while (it.hasNext()) {
            it.next().eb();
        }
    }

    public final boolean dV() {
        com.kwad.components.ad.interstitial.h.d dVar = this.mk;
        boolean z5 = dVar == null || dVar.getParent() == null;
        com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "isH5Interstitial :" + z5);
        return z5;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.iK.removeCallbacksAndMessages(null);
        this.mt.clear();
        this.f36337ms.clear();
        com.kwad.components.ad.interstitial.g.b bVar = this.kO;
        if (bVar != null) {
            bVar.wj();
        }
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void a(a.c cVar) {
        if (this.mt.contains(cVar)) {
            return;
        }
        this.mt.add(cVar);
    }

    public final boolean a(final C0567c c0567c) {
        com.kwad.components.ad.interstitial.report.a.eO().a(this.mAdTemplate, 1L, c0567c.mI);
        boolean z5 = c0567c.dW() == 1;
        boolean z6 = com.kwad.components.ad.interstitial.b.b.dK() || z5 || c0567c.dY() || c0567c.mM;
        if (z6) {
            com.kwad.components.core.e.d.a.a(new a.C0616a(c0567c.getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(z5).az(1).aA(c0567c.mI).A(this.cq.getCurrentPosition()).aB(c0567c.dW()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.f.c.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.b(c0567c);
                    c cVar = c.this;
                    if (cVar.kW == null || !com.kwad.components.ad.interstitial.d.b.t(cVar.mAdTemplate)) {
                        return;
                    }
                    c cVar2 = c.this;
                    cVar2.a(false, -1, cVar2.cq);
                    c.this.iK.postDelayed(new bg() { // from class: com.kwad.components.ad.interstitial.f.c.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            c.this.kW.dismiss();
                            c.this.Y();
                        }
                    }, 500L);
                }
            }));
        }
        return z6;
    }

    public final void c(Context context, AdTemplate adTemplate) {
        if (this.mu) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.mu = true;
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.mp.remove(bVar);
    }

    private static int b(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            return Math.round((currentPosition / duration) * 100.0f);
        }
        return -1;
    }

    public final void a(final Context context, final int i6, int i7, int i8) {
        com.kwad.components.ad.interstitial.report.a.eO().a(this.mAdTemplate, 6L, i6);
        final int i9 = 9;
        com.kwad.components.core.e.d.a.a(new a.C0616a(context).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aB(2).az(6).aA(i6).a(new a.b() { // from class: com.kwad.components.ad.interstitial.f.c.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c cVar = c.this;
                int i10 = i9;
                int i11 = i6;
                cVar.a(i10, i11, context, 6L, i11);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, int i7, Context context, long j6, long j7) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().dk(i6).dd(i7).dr(aq.QW() ? 2 : 1).EM(), (JSONObject) null);
        this.ml = true;
        c(j6, j7);
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.mp.add(bVar);
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.aW(adInfo) && !aq.QW();
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.bu(adInfo).getUrl();
        if (bp.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass3(context, view));
    }

    public final void a(boolean z5, int i6, @Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        long j6;
        int a6;
        com.kwad.components.ad.interstitial.report.a.eO().a(this.mAdTemplate, bz.k(this.fV, true));
        if (aVar != null) {
            j6 = a(aVar);
            a6 = b(aVar);
        } else {
            j6 = i6;
            a6 = a(j6, this.mAdTemplate);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, z5 ? 14 : 1, j6, a6, this.kW.getTimerHelper().getTime(), null);
    }

    private static long a(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    private static int a(long j6, @NonNull AdTemplate adTemplate) {
        if (j6 == -1) {
            return -1;
        }
        float M = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.el(adTemplate)) / 1000.0f;
        if (M != 0.0f) {
            return Math.round((j6 / M) * 100.0f);
        }
        return -1;
    }
}
