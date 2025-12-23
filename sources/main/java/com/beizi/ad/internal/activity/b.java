package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.video.AdVideoView;
import com.beizi.ad.internal.view.AdWebView;
import com.beizi.ad.internal.view.InterstitialAdViewImpl;
import com.beizi.ad.internal.view.e;
import com.beizi.fusion.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements AdActivity.a {

    /* renamed from: a, reason: collision with root package name */
    private Activity f11632a;

    /* renamed from: b, reason: collision with root package name */
    private AdWebView f11633b;

    /* renamed from: c, reason: collision with root package name */
    private com.beizi.ad.internal.view.c f11634c;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f11635d;

    /* renamed from: e, reason: collision with root package name */
    private long f11636e;

    /* renamed from: f, reason: collision with root package name */
    private InterstitialAdViewImpl f11637f;

    @Override // com.beizi.ad.AdActivity.a
    public void a() {
        InterstitialAdViewImpl interstitialAdViewImpl = InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE;
        if (interstitialAdViewImpl == null || interstitialAdViewImpl.getAdQueue().peek() == null || !(InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getAdQueue().peek().d() instanceof AdWebView)) {
            return;
        }
        this.f11632a.setTheme(R.style.BeiZiDialogStyle);
        AdWebView adWebView = (AdWebView) InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getAdQueue().peek().d();
        adWebView.getSettings().setLoadsImagesAutomatically(true);
        if (adWebView.isVideoFullScreen()) {
            this.f11632a.setTheme(R.style.BeiZiTheme_Transparent);
            this.f11632a.requestWindowFeature(1);
            this.f11632a.getWindow().setFlags(1024, 1024);
        }
        this.f11635d = new FrameLayout(this.f11632a);
        this.f11635d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.f11632a.setContentView(this.f11635d);
        try {
            this.f11636e = this.f11632a.getIntent().getLongExtra("TIME", System.currentTimeMillis());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        a(InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE);
    }

    private void h() {
        if (this.f11632a != null) {
            InterstitialAdViewImpl interstitialAdViewImpl = this.f11637f;
            if (interstitialAdViewImpl != null && interstitialAdViewImpl.getAdDispatcher() != null) {
                this.f11637f.getAdDispatcher().b();
            }
            this.f11632a.finish();
        }
    }

    @Override // com.beizi.ad.AdActivity.a
    public void b() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f11637f;
        if (interstitialAdViewImpl == null || interstitialAdViewImpl.getAdDispatcher() == null || this.f11637f.isRewardedVideo() || this.f11632a == null) {
            return;
        }
        this.f11637f.getAdDispatcher().b();
        this.f11632a.finish();
    }

    @Override // com.beizi.ad.AdActivity.a
    public void c() {
        AdWebView adWebView = this.f11633b;
        if (adWebView != null) {
            u.a(adWebView);
            this.f11633b.destroy();
            AdVideoView adVideoView = this.f11633b.mAdVideoView;
            if (adVideoView != null) {
                adVideoView.destroy();
            }
        }
        InterstitialAdViewImpl interstitialAdViewImpl = this.f11637f;
        if (interstitialAdViewImpl != null) {
            interstitialAdViewImpl.setAdImplementation(null);
        }
        this.f11632a.finish();
    }

    @Override // com.beizi.ad.AdActivity.a
    public void e() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f11637f;
        if (interstitialAdViewImpl == null || !interstitialAdViewImpl.shouldDismissOnClick()) {
            return;
        }
        h();
    }

    @Override // com.beizi.ad.AdActivity.a
    public WebView f() {
        return this.f11633b;
    }

    public void g() {
        com.beizi.ad.internal.view.c realDisplayable;
        com.beizi.ad.internal.view.c cVar;
        AdWebView adWebView = this.f11633b;
        if (adWebView == null || (realDisplayable = adWebView.getRealDisplayable()) == (cVar = this.f11634c)) {
            return;
        }
        this.f11635d.removeView(cVar.getView());
        if (realDisplayable instanceof AdVideoView) {
            this.f11635d.addView(realDisplayable.getView(), new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.f11635d.addView(realDisplayable.getView(), new ViewGroup.LayoutParams(-1, -1));
        }
        this.f11634c = realDisplayable;
        realDisplayable.visible();
    }

    public b(Activity activity) {
        this.f11632a = activity;
    }

    private void a(InterstitialAdViewImpl interstitialAdViewImpl) {
        int i6;
        this.f11637f = interstitialAdViewImpl;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.setAdImplementation(this);
        this.f11635d.setBackgroundColor(this.f11637f.getBackgroundColor());
        this.f11635d.removeAllViews();
        if (this.f11637f.getParent() != null) {
            ((ViewGroup) this.f11637f.getParent()).removeAllViews();
        }
        e poll = this.f11637f.getAdQueue().poll();
        while (poll != null && (this.f11636e - poll.a() > InterstitialAdViewImpl.MAX_AGE || this.f11636e - poll.a() < 0)) {
            poll = this.f11637f.getAdQueue().poll();
        }
        if (poll == null || !(poll.d() instanceof AdWebView)) {
            return;
        }
        AdWebView adWebView = (AdWebView) poll.d();
        this.f11633b = adWebView;
        if (adWebView.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.f11633b.getContext()).setBaseContext(this.f11632a);
            AdVideoView adVideoView = this.f11633b.mAdVideoView;
            if (adVideoView != null) {
                ((MutableContextWrapper) adVideoView.getContext()).setBaseContext(this.f11632a);
            }
        }
        if ((this.f11633b.getCreativeWidth() != 1 || this.f11633b.getCreativeHeight() != 1) && this.f11632a.getResources().getConfiguration().orientation != 2) {
            try {
                i6 = this.f11637f.getAdParameters().b().getApplicationInfo().targetSdkVersion;
            } catch (Exception e6) {
                e6.printStackTrace();
                i6 = 0;
            }
            if (i6 <= 26 || Build.VERSION.SDK_INT != 26) {
                AdActivity.a(this.f11632a, this.f11633b.getOrientation());
            }
        }
        this.f11634c = this.f11633b.getRealDisplayable();
        AdWebView adWebView2 = this.f11633b;
        if (adWebView2.mAdVideoView != null) {
            this.f11635d.addView(adWebView2.getRealDisplayable().getView(), new FrameLayout.LayoutParams(-2, -2, 17));
        } else if (this.f11632a.getRequestedOrientation() == 0) {
            this.f11635d.addView(this.f11633b.getRealDisplayable().getView(), new FrameLayout.LayoutParams((int) (this.f11633b.getCreativeHeight() * h.a().f12003k), (int) (this.f11633b.getCreativeWidth() * h.a().f12004l), 17));
        } else if (this.f11632a.getRequestedOrientation() == 1) {
            this.f11635d.addView(this.f11633b.getRealDisplayable().getView(), new FrameLayout.LayoutParams((int) (this.f11633b.getCreativeWidth() * h.a().f12003k), (int) (this.f11633b.getCreativeHeight() * h.a().f12004l), 17));
        } else {
            this.f11635d.addView(this.f11633b.getRealDisplayable().getView(), new FrameLayout.LayoutParams((int) (this.f11633b.getCreativeWidth() * h.a().f12003k), (int) (this.f11633b.getCreativeHeight() * h.a().f12004l), 17));
        }
        this.f11634c.visible();
    }

    @Override // com.beizi.ad.AdActivity.a
    public void d() {
    }
}
