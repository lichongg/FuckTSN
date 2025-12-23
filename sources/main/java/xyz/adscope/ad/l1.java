package xyz.adscope.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.a2;
import xyz.adscope.ad.publish.ad.IAdListener;
import xyz.adscope.ad.publish.ad.nativead.INativeAdItem;
import xyz.adscope.ad.publish.ad.nativead.INativeExpressListener;
import xyz.adscope.ad.publish.ad.nativead.INativeRenderListener;
import xyz.adscope.ad.publish.ad.nativead.INativeRewardListener;
import xyz.adscope.ad.publish.ad.nativead.INativeVideoPlayListener;
import xyz.adscope.ad.publish.ad.video.IRewardVideoListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class l1<C extends a2, L extends IAdListener> extends b2<C, L> {

    /* renamed from: n, reason: collision with root package name */
    protected String f55347n;

    /* renamed from: o, reason: collision with root package name */
    private final l1<C, L>.b f55348o;

    /* renamed from: p, reason: collision with root package name */
    private View f55349p;

    /* renamed from: q, reason: collision with root package name */
    private INativeAdItem f55350q;

    /* renamed from: r, reason: collision with root package name */
    private final c f55351r;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements INativeExpressListener, INativeRewardListener, INativeRenderListener, INativeVideoPlayListener {
        private b() {
        }

        /* synthetic */ b(l1 l1Var, a aVar) {
            this();
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeInteractiveListener
        public void onAdClicked() {
            IAdListener iAdListener = (IAdListener) l1.this.c();
            l1 l1Var = l1.this;
            if (l1Var.f54864a == xyz.adscope.ad.c.SPLASH) {
                l1Var.a(System.currentTimeMillis());
            }
            if (iAdListener != null) {
                iAdListener.onAdClicked();
            }
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeExpressListener
        public void onAdClosed() {
            IAdListener iAdListener = (IAdListener) l1.this.c();
            if (iAdListener != null) {
                iAdListener.onAdClosed();
            }
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeExpressListener
        public void onAdExposure() {
            IAdListener iAdListener = (IAdListener) l1.this.c();
            if (iAdListener != null) {
                iAdListener.onAdExposure();
            }
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeExpressListener
        public void onAdShown() {
            IAdListener iAdListener = (IAdListener) l1.this.c();
            if (iAdListener != null) {
                iAdListener.onAdShown();
            }
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeRewardListener
        public void onReward() {
            L c6 = l1.this.c();
            if (c6 instanceof IRewardVideoListener) {
                ((IRewardVideoListener) c6).onReward();
            }
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeRenderListener
        public void renderFailed() {
            l1.this.b(y0.ERROR_RENDER_FAILED);
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeRenderListener
        public void renderSuccess(View view) {
            l1.this.n();
            l1.this.f55349p = view;
            IAdListener iAdListener = (IAdListener) l1.this.c();
            if (iAdListener != null) {
                iAdListener.onRenderSuccess();
            }
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeVideoPlayListener
        public void onVideoPlayCompleted() {
            onReward();
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeVideoPlayListener
        public void onVideoPlay() {
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeVideoPlayListener
        public void onVideoPlayFailed() {
        }

        @Override // xyz.adscope.ad.publish.ad.nativead.INativeVideoPlayListener
        public void onVideoPrepared() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final l1<?, ?> f55353a;

        /* synthetic */ c(l1 l1Var, a aVar) {
            this(l1Var);
        }

        private c(l1<?, ?> l1Var) {
            this.f55353a = l1Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StubApp.getOrigApplicationContext(context.getApplicationContext()).unregisterReceiver(this);
            l1<?, ?> l1Var = this.f55353a;
            if (l1Var != null) {
                l1Var.b(y0.ERROR_ACTIVITY_ISSUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f54867d = true;
    }

    public void b(Map<String, String> map) {
        INativeAdItem iNativeAdItem = this.f55350q;
        if (iNativeAdItem == null || iNativeAdItem.getBidding() == null) {
            return;
        }
        this.f55350q.getBidding().notifyBidWin(map);
    }

    public void j() {
        INativeAdItem iNativeAdItem = this.f55350q;
        if (iNativeAdItem != null) {
            iNativeAdItem.destroyAd();
        }
        View view = this.f55349p;
        if (view == null || !(view instanceof xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a)) {
            return;
        }
        ((xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) view).onViewDestroy();
    }

    public int k() {
        INativeAdItem iNativeAdItem = this.f55350q;
        if (iNativeAdItem == null || iNativeAdItem.getBidding() == null) {
            return 0;
        }
        return this.f55350q.getBidding().getECPM();
    }

    public void l() {
        View view = this.f55349p;
        if (view == null || !(view instanceof xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a)) {
            return;
        }
        ((xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) view).onActivityPause();
    }

    public void m() {
        View view = this.f55349p;
        if (view == null || !(view instanceof xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a)) {
            return;
        }
        ((xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) view).onActivityResume();
    }

    l1(Context context, C c6, xyz.adscope.ad.c cVar) {
        super(context, c6, cVar);
        a aVar = null;
        this.f55348o = new b(this, aVar);
        this.f55351r = new c(this, aVar);
    }

    private void c(Context context) {
        StubApp.getOrigApplicationContext(context.getApplicationContext()).unregisterReceiver(this.f55351r);
    }

    private void i() {
        IAdListener iAdListener = (IAdListener) c();
        if (iAdListener != null) {
            iAdListener.onAdLoaded();
        }
    }

    @Override // xyz.adscope.ad.b2
    protected void a(List<s3> list) {
        i();
        s3 s3Var = list.get(0);
        if (s3Var != null) {
            a(new y6(s3Var));
        }
    }

    public void b(y0 y0Var) {
        IAdListener iAdListener = (IAdListener) c();
        if (iAdListener != null) {
            iAdListener.onAdLoadFailed(y0Var.b(), y0Var.c());
        }
    }

    public void b(Context context) {
        if (!b()) {
            a(context);
            if (n4.a(context, this.f54866c.getSpaceID(), this.f54864a, this.f55347n, this.f54866c.getApiKey())) {
                return;
            }
            c(context);
            return;
        }
        b(y0.ERROR_UNITE_CONTROL);
    }

    private void a(INativeAdItem iNativeAdItem) {
        this.f55350q = iNativeAdItem;
        if (iNativeAdItem != null) {
            iNativeAdItem.setInteractiveListener(this.f55348o);
            iNativeAdItem.setExpressListener(this.f55348o);
            iNativeAdItem.setVideoPlayListener(this.f55348o);
            iNativeAdItem.renderAdView(this.f55348o);
        }
    }

    public void a(Map<String, String> map) {
        INativeAdItem iNativeAdItem = this.f55350q;
        if (iNativeAdItem == null || iNativeAdItem.getBidding() == null) {
            return;
        }
        this.f55350q.getBidding().notifyBidLose(map);
    }

    public View a(boolean z5) {
        if (z5) {
            a(this.f55349p);
            return null;
        }
        return this.f55349p;
    }

    private void a(View view) {
        xyz.adscope.ad.a aVar = this.f54868e;
        if (aVar != null) {
            this.f55347n = aVar.a(this.f54866c, view);
        }
    }

    private void a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.asnp.ad.ACTION_ACTIVITY_RESULT");
        LocalBroadcastManager.getInstance(StubApp.getOrigApplicationContext(context.getApplicationContext())).registerReceiver(this.f55351r, intentFilter);
    }
}
