package com.beizi.ad.internal.view;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.activity.BeiZiInterstitialActivity;
import com.beizi.ad.internal.f.a;
import com.beizi.ad.internal.k;
import com.beizi.ad.lance.a.m;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class InterstitialAdViewImpl extends AdViewImpl {
    public static final String INTENT_KEY_CLOSE_BUTTON_DELAY = "CLOSE_BUTTON_DELAY";
    public static final String INTENT_KEY_TIME = "TIME";
    public static InterstitialAdViewImpl INTERSTITIALADVIEW_TO_USE = null;
    public static final long MAX_AGE = 270000;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f12616m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f12617n;

    /* renamed from: o, reason: collision with root package name */
    private int f12618o;

    /* renamed from: p, reason: collision with root package name */
    private int f12619p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f12620q;

    /* renamed from: r, reason: collision with root package name */
    private Queue<e> f12621r;

    /* renamed from: s, reason: collision with root package name */
    private AdActivity.a f12622s;

    /* renamed from: t, reason: collision with root package name */
    private AdSpacesBean.BuyerBean f12623t;

    public InterstitialAdViewImpl(Context context, boolean z5, boolean z6) {
        super(context);
        this.f12618o = 0;
        this.f12619p = 10000;
        this.f12621r = new LinkedList();
        this.f12622s = null;
        this.f12616m = false;
        this.f12617n = false;
        this.f12439j = z5;
        this.f12440k = z6;
        if (z5) {
            this.f12618o = ViewCompat.MEASURED_STATE_MASK;
        } else if (z6) {
            this.f12618o = 0;
        } else {
            this.f12618o = Color.argb(51, 0, 0, 0);
        }
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    protected void a(Context context, AttributeSet attributeSet) {
        super.a(context, attributeSet);
        this.mAdFetcher.a(-1);
        this.f12437h.a(k.INTERSTITIAL);
        try {
            View view = (View) getParent();
            if (view != null) {
                int measuredHeight = view.getMeasuredHeight();
                int measuredHeight2 = view.getMeasuredHeight();
                com.beizi.ad.internal.h a6 = com.beizi.ad.internal.h.a();
                int h6 = (int) ((measuredHeight / a6.h()) + 0.5f);
                this.f12437h.c((int) ((measuredHeight2 / a6.g()) + 0.5f));
                this.f12437h.d(h6);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void activityOnDestroy() {
        this.f12616m = true;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void activityOnPause() {
        this.f12617n = true;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void activityOnResume() {
        this.f12617n = false;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    protected void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = obtainStyledAttributes.getIndex(i6);
            if (index == R.styleable.AdView_beizi_adUnitId) {
                setAdUnitId(obtainStyledAttributes.getString(index));
            } else if (index == R.styleable.AdView_test) {
                com.beizi.ad.internal.h.a().f11999d = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.AdView_opens_native_browser) {
                setOpensNativeBrowser(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == R.styleable.AdView_show_loading_indicator) {
                setShowLoadingIndicator(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == R.styleable.AdView_load_landing_page_in_background) {
                setLoadsInBackground(obtainStyledAttributes.getBoolean(index, true));
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    boolean d() {
        return false;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    boolean e() {
        return true;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public int getCreativeHeight() {
        return -1;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public int getCreativeWidth() {
        return -1;
    }

    public void cancel() {
        com.beizi.ad.internal.d dVar = this.mAdFetcher;
        if (dVar != null) {
            dVar.a();
        }
        INTERSTITIALADVIEW_TO_USE = null;
        this.f12621r.clear();
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    void f() {
        AdActivity.a aVar = this.f12622s;
        if (aVar != null) {
            aVar.d();
        }
    }

    void g() {
        AdActivity.a aVar = this.f12622s;
        if (aVar != null) {
            aVar.e();
        }
    }

    public AdSpacesBean.BuyerBean getAdBuyerBean() {
        return this.f12623t;
    }

    public AdActivity.a getAdImplementation() {
        return this.f12622s;
    }

    public Queue<e> getAdQueue() {
        return this.f12621r;
    }

    public int getBackgroundColor() {
        return this.f12618o;
    }

    public int getCloseButtonDelay() {
        return this.f12619p;
    }

    @Override // com.beizi.ad.internal.a
    public k getMediaType() {
        return k.INTERSTITIAL;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void onDestoryLifeCycle() {
        com.beizi.ad.internal.d dVar = this.mAdFetcher;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setAdBuyerBean(AdSpacesBean.BuyerBean buyerBean) {
        this.f12623t = buyerBean;
    }

    public void setAdImplementation(AdActivity.a aVar) {
        this.f12622s = aVar;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        this.f12618o = i6;
    }

    public void setCloseButtonDelay(int i6) {
        this.f12619p = Math.min(i6, 10000);
    }

    public void setDismissOnClick(boolean z5) {
        this.f12620q = z5;
    }

    public boolean shouldDismissOnClick() {
        return this.f12620q;
    }

    public void showInterstitial(Context context) {
        m.c("BeiZisAd", "showInterstitial");
        INTERSTITIALADVIEW_TO_USE = this;
        context.startActivity(new Intent(context, (Class<?>) BeiZiInterstitialActivity.class));
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void destroy() {
        super.destroy();
        com.beizi.ad.internal.d dVar = this.mAdFetcher;
        if (dVar != null) {
            dVar.a();
        }
        this.f12621r.clear();
        INTERSTITIALADVIEW_TO_USE = null;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public boolean loadAd(a.C0107a c0107a) {
        com.beizi.ad.internal.d dVar;
        getAdParameters().a(false);
        this.f12438i = c0107a;
        if (!isReadyToStart() || (dVar = this.mAdFetcher) == null) {
            return false;
        }
        dVar.a();
        this.mAdFetcher.b();
        this.loadCount = 1;
        this.clickCount = 0;
        return true;
    }

    public int show() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean a6 = a(currentTimeMillis);
        e peek = this.f12621r.peek();
        if (peek != null && peek.b() && peek.c() != null) {
            peek.c().c();
            this.f12621r.poll();
            return this.f12621r.size();
        }
        if (a6 && !this.f12616m) {
            Intent intent = new Intent(getContext(), (Class<?>) AdActivity.a());
            intent.putExtra("ACTIVITY_TYPE", "INTERSTITIAL");
            intent.putExtra("TIME", currentTimeMillis);
            intent.putExtra(INTENT_KEY_CLOSE_BUTTON_DELAY, this.f12619p);
            INTERSTITIALADVIEW_TO_USE = this;
            try {
                intent.setFlags(268435456);
                getContext().startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                INTERSTITIALADVIEW_TO_USE = null;
            }
            return this.f12621r.size() - 1;
        }
        return this.f12621r.size();
    }

    public InterstitialAdViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12618o = 0;
        this.f12619p = 10000;
        this.f12621r = new LinkedList();
        this.f12622s = null;
        this.f12616m = false;
        this.f12617n = false;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    protected void a(c cVar) {
        if (b(cVar)) {
            c cVar2 = this.f12432c;
            if (cVar2 != null) {
                cVar2.destroy();
            }
            if (!this.f12616m && !this.f12617n) {
                this.f12432c = cVar;
                this.f12621r.add(new d(cVar, Long.valueOf(System.currentTimeMillis()), false, null));
            } else if (cVar != null) {
                cVar.destroy();
            }
        }
    }

    private boolean b(c cVar) {
        return (cVar == null || cVar.failed()) ? false : true;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void onCreateLifeCycle() {
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void onPauseLifeCycle() {
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void onRestartLifeCycle() {
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void onResumeLifeCycle() {
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void onStartLifeCycle() {
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void onStopLifeCycle() {
    }

    public InterstitialAdViewImpl(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f12618o = 0;
        this.f12619p = 10000;
        this.f12621r = new LinkedList();
        this.f12622s = null;
        this.f12616m = false;
        this.f12617n = false;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    protected void a(com.beizi.ad.internal.d.e eVar) {
        if (b(eVar)) {
            c cVar = this.f12432c;
            if (cVar != null) {
                cVar.destroy();
            }
            if (!this.f12616m && !this.f12617n) {
                this.f12432c = eVar;
                this.f12621r.add(new d(eVar, Long.valueOf(System.currentTimeMillis()), true, eVar.a()));
            } else if (eVar != null) {
                eVar.destroy();
            }
        }
    }

    private boolean a(long j6) {
        boolean z5;
        ArrayList arrayList = new ArrayList();
        for (e eVar : this.f12621r) {
            if (eVar != null && j6 - eVar.a() <= MAX_AGE && j6 - eVar.a() >= 0 && (!eVar.b() || !eVar.c().d())) {
                z5 = true;
                break;
            }
            arrayList.add(eVar);
        }
        z5 = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f12621r.remove((e) it.next());
        }
        return z5;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
    }
}
