package com.beizi.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import androidx.annotation.RequiresPermission;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.lance.a.p;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class BannerAdView extends e {

    /* renamed from: b, reason: collision with root package name */
    private int f11246b;

    /* renamed from: c, reason: collision with root package name */
    private int f11247c;

    /* renamed from: d, reason: collision with root package name */
    private String f11248d;

    /* renamed from: e, reason: collision with root package name */
    private int f11249e;

    /* renamed from: f, reason: collision with root package name */
    private String f11250f;

    /* renamed from: g, reason: collision with root package name */
    private List<Pair<String, Integer>> f11251g;

    /* renamed from: h, reason: collision with root package name */
    private View f11252h;

    public BannerAdView(Context context) {
        super(context, com.beizi.ad.internal.k.BANNER);
    }

    public BannerAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.beizi.ad.internal.k.BANNER);
    }

    public int getAdOptimizePercent() {
        return this.f11246b;
    }

    public int getAdOptimizeSize() {
        return this.f11247c;
    }

    public String getDirection() {
        return this.f11250f;
    }

    public List<Pair<String, Integer>> getOrderOptimizeList() {
        return this.f11251g;
    }

    public String getScrollDistance() {
        return this.f11248d;
    }

    public int getScrollDistancePercent() {
        return this.f11249e;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getValidOptimizePercent() {
        /*
            r6 = this;
            com.beizi.ad.internal.view.BannerAdViewImpl r0 = r6.f11420a
            r1 = -1
            if (r0 == 0) goto L39
            java.lang.String r0 = r0.getLandingPageUrl()
            if (r0 == 0) goto L39
            com.beizi.ad.internal.view.BannerAdViewImpl r0 = r6.f11420a
            java.lang.String r0 = r0.getLandingPageUrl()
            java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>> r2 = r6.f11251g
            if (r2 == 0) goto L39
            java.util.Iterator r2 = r2.iterator()
            r3 = -1
        L1a:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r2.next()
            android.util.Pair r4 = (android.util.Pair) r4
            java.lang.Object r5 = r4.first
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = r0.contains(r5)
            if (r5 == 0) goto L1a
            java.lang.Object r3 = r4.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L1a
        L39:
            r3 = -1
        L3a:
            if (r3 != r1) goto L3f
            int r0 = r6.f11246b
            return r0
        L3f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.BannerAdView.getValidOptimizePercent():int");
    }

    public void setAdOptimizePercent(int i6) {
        this.f11246b = i6;
    }

    public void setAdOptimizeSize(int i6) {
        this.f11247c = i6;
    }

    public void setDirection(String str) {
        this.f11250f = str;
    }

    public void setOrderOptimizeList(List<Pair<String, Integer>> list) {
        this.f11251g = list;
    }

    public void setScrollDistance(String str) {
        this.f11248d = str;
    }

    public void setScrollDistancePercent(int i6) {
        this.f11249e = i6;
    }

    public void setTouchAreaNormal() {
        View view = this.f11252h;
        if (view != null) {
            u.a(view);
        }
    }

    public BannerAdView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6, com.beizi.ad.internal.k.BANNER);
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ a getAdListener() {
        return super.getAdListener();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ c getAdSize() {
        return super.getAdSize();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ String getPrice() {
        return super.getPrice();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ boolean getResizeAdToFitContainer() {
        return super.getResizeAdToFitContainer();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void isAutoRefresh() {
        super.isAutoRefresh();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ boolean isDownloadApp() {
        return super.isDownloadApp();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ boolean isLoading() {
        return super.isLoading();
    }

    @Override // com.beizi.ad.e
    @RequiresPermission(com.kuaishou.weapon.p0.g.f36041a)
    public /* bridge */ /* synthetic */ void loadAd(b bVar) {
        super.loadAd(bVar);
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void onCreateLifeCycle() {
        super.onCreateLifeCycle();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void onDestoryLifeCycle() {
        super.onDestoryLifeCycle();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void onPauseLifeCycle() {
        super.onPauseLifeCycle();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void onRestartLifeCycle() {
        super.onRestartLifeCycle();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void onResumeLifeCycle() {
        super.onResumeLifeCycle();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void onStartLifeCycle() {
        super.onStartLifeCycle();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void onStopLifeCycle() {
        super.onStopLifeCycle();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void openAdInNativeBrowser(boolean z5) {
        super.openAdInNativeBrowser(z5);
    }

    public void optimizeClickArea(int i6, View view, View view2, String str) {
        int validOptimizePercent = getValidOptimizePercent();
        boolean a6 = p.a(validOptimizePercent);
        com.beizi.ad.lance.a.m.c("BeiZisAd", "percent = " + validOptimizePercent + ",isPass = " + a6);
        if (a6) {
            this.f11252h = com.beizi.ad.lance.a.g.a(i6, view, view2, str);
        }
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void setAdListener(a aVar) {
        super.setAdListener(aVar);
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        super.setAdUnitId(str);
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void setAutoRefresh(boolean z5) {
        super.setAutoRefresh(z5);
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void setCloseMarketDialog(boolean z5) {
        super.setCloseMarketDialog(z5);
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void setResizeAdToFitContainer(boolean z5) {
        super.setResizeAdToFitContainer(z5);
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void setTransitionDerection(com.beizi.ad.internal.animation.g gVar) {
        super.setTransitionDerection(gVar);
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void setTransitionDuration(int i6) {
        super.setTransitionDuration(i6);
    }

    @Override // com.beizi.ad.e
    public /* bridge */ /* synthetic */ void setTransitionType(com.beizi.ad.internal.animation.h hVar) {
        super.setTransitionType(hVar);
    }
}
