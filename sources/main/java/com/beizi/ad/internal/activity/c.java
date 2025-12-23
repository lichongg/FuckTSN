package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.webkit.WebView;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.view.AdViewImpl;
import com.beizi.ad.internal.view.AdWebView;
import com.beizi.ad.internal.view.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c implements AdActivity.a {

    /* renamed from: a, reason: collision with root package name */
    private Activity f11638a;

    /* renamed from: b, reason: collision with root package name */
    private AdWebView f11639b;

    /* renamed from: c, reason: collision with root package name */
    private f f11640c = null;

    @Override // com.beizi.ad.AdActivity.a
    public void b() {
        f fVar = this.f11640c;
        if (fVar != null) {
            fVar.a((Activity) null);
            this.f11640c.a();
        }
        this.f11640c = null;
    }

    @Override // com.beizi.ad.AdActivity.a
    public WebView f() {
        return this.f11639b;
    }

    public c(Activity activity) {
        this.f11638a = activity;
    }

    @Override // com.beizi.ad.AdActivity.a
    public void a() {
        if (AdViewImpl.getMRAIDFullscreenContainer() != null && AdViewImpl.getMRAIDFullscreenImplementation() != null) {
            u.a(AdViewImpl.getMRAIDFullscreenContainer());
            this.f11638a.setContentView(AdViewImpl.getMRAIDFullscreenContainer());
            if (AdViewImpl.getMRAIDFullscreenContainer().getChildAt(0) instanceof AdWebView) {
                this.f11639b = (AdWebView) AdViewImpl.getMRAIDFullscreenContainer().getChildAt(0);
            }
            if (this.f11639b.getContext() instanceof MutableContextWrapper) {
                ((MutableContextWrapper) this.f11639b.getContext()).setBaseContext(this.f11638a);
            }
            f mRAIDFullscreenImplementation = AdViewImpl.getMRAIDFullscreenImplementation();
            this.f11640c = mRAIDFullscreenImplementation;
            mRAIDFullscreenImplementation.a(this.f11638a);
            if (AdViewImpl.getMRAIDFullscreenListener() != null) {
                AdViewImpl.getMRAIDFullscreenListener().a();
                return;
            }
            return;
        }
        this.f11638a.finish();
    }

    @Override // com.beizi.ad.AdActivity.a
    public void c() {
    }

    @Override // com.beizi.ad.AdActivity.a
    public void d() {
    }

    @Override // com.beizi.ad.AdActivity.a
    public void e() {
    }
}
