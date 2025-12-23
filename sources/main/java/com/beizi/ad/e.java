package com.beizi.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RequiresPermission;
import com.beizi.ad.internal.view.BannerAdViewImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class e extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    protected final BannerAdViewImpl f11420a;

    public e(Context context, com.beizi.ad.internal.k kVar) {
        super(context);
        this.f11420a = new BannerAdViewImpl(context);
        a();
    }

    private void a() {
        setBackgroundColor(0);
        setPadding(0, 0, 0, 0);
        addView(this.f11420a);
    }

    public void cancel() {
        BannerAdViewImpl bannerAdViewImpl = this.f11420a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.cancel();
        }
    }

    public a getAdListener() {
        return this.f11420a.getAdListener();
    }

    public c getAdSize() {
        return this.f11420a.getAdSize();
    }

    public String getAdUnitId() {
        return this.f11420a.getAdUnitId();
    }

    public String getPrice() {
        return this.f11420a.getPrice();
    }

    public boolean getResizeAdToFitContainer() {
        return this.f11420a.getResizeAdToFitContainer();
    }

    public void isAutoRefresh() {
        this.f11420a.isAutoRefresh();
    }

    public boolean isDownloadApp() {
        BannerAdViewImpl bannerAdViewImpl = this.f11420a;
        if (bannerAdViewImpl == null) {
            return false;
        }
        return bannerAdViewImpl.isDownloadApp();
    }

    public boolean isLoading() {
        return this.f11420a.isLoading();
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f36041a)
    public void loadAd(b bVar) {
        this.f11420a.loadAd(bVar.a());
    }

    public void onDestoryLifeCycle() {
        BannerAdViewImpl bannerAdViewImpl = this.f11420a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.onDestoryLifeCycle();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        if (i6 == 8) {
            this.f11420a.activityOnPause();
        } else {
            this.f11420a.activityOnResume();
        }
    }

    public void openAdInNativeBrowser(boolean z5) {
        this.f11420a.openAdInNativeBrowser(z5);
    }

    public void resume() {
        this.f11420a.activityOnResume();
    }

    public void setAdListener(a aVar) {
        this.f11420a.setAdListener(aVar);
    }

    void setAdSize(c cVar) {
        this.f11420a.setAdSize(cVar.b(), cVar.a());
    }

    public void setAdUnitId(String str) {
        this.f11420a.setAdUnitId(str);
    }

    public void setAutoRefresh(boolean z5) {
        this.f11420a.setAutoRefresh(z5);
    }

    public void setCloseMarketDialog(boolean z5) {
        BannerAdViewImpl bannerAdViewImpl = this.f11420a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.setCloseMarketDialog(z5);
        }
    }

    public void setResizeAdToFitContainer(boolean z5) {
        this.f11420a.setResizeAdToFitContainer(z5);
        if (getResizeAdToFitContainer()) {
            this.f11420a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void setTransitionDerection(com.beizi.ad.internal.animation.g gVar) {
        this.f11420a.setTransitionDirection(gVar);
    }

    public void setTransitionDuration(int i6) {
        this.f11420a.setTransitionDuration(i6);
    }

    public void setTransitionType(com.beizi.ad.internal.animation.h hVar) {
        this.f11420a.setTransitionType(hVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BannerAdViewImpl bannerAdViewImpl = this.f11420a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.activityOnDestroy();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        c cVar;
        int i8;
        if (getResizeAdToFitContainer()) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6), 1073741824);
            super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(makeMeasureSpec) / 6, 1073741824));
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        View.MeasureSpec.getSize(i7);
        int i9 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i6, i7);
            i9 = childAt.getMeasuredWidth();
            i8 = childAt.getMeasuredHeight();
        } else {
            try {
                cVar = getAdSize();
            } catch (NullPointerException unused) {
                cVar = null;
            }
            if (cVar != null) {
                Context context = getContext();
                int b6 = cVar.b(context);
                i8 = cVar.a(context);
                i9 = b6;
            } else {
                i8 = 0;
            }
        }
        int max = Math.max(i9, getSuggestedMinimumWidth());
        int max2 = Math.max(i8, getSuggestedMinimumHeight());
        if (mode == 1073741824) {
            max = View.MeasureSpec.getSize(i6);
        }
        if (mode2 == 1073741824) {
            max2 = View.MeasureSpec.getSize(i7);
        }
        setMeasuredDimension(View.resolveSize(max, i6), View.resolveSize(max2, i7));
    }

    public e(Context context, AttributeSet attributeSet, com.beizi.ad.internal.k kVar) {
        super(context, attributeSet);
        this.f11420a = new BannerAdViewImpl(context, attributeSet);
        a();
    }

    public e(Context context, AttributeSet attributeSet, int i6, com.beizi.ad.internal.k kVar) {
        super(context, attributeSet, i6);
        this.f11420a = new BannerAdViewImpl(context, attributeSet, i6);
        a();
    }

    public void onCreateLifeCycle() {
    }

    public void onPauseLifeCycle() {
    }

    public void onRestartLifeCycle() {
    }

    public void onResumeLifeCycle() {
    }

    public void onStartLifeCycle() {
    }

    public void onStopLifeCycle() {
    }
}
