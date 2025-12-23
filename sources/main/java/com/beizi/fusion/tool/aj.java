package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollClickView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class aj {

    /* renamed from: j, reason: collision with root package name */
    private static AdSpacesBean.BuyerBean.ScrollClickBean f13625j;

    /* renamed from: a, reason: collision with root package name */
    ScrollClickView f13626a;

    /* renamed from: b, reason: collision with root package name */
    int f13627b;

    /* renamed from: c, reason: collision with root package name */
    int f13628c;

    /* renamed from: d, reason: collision with root package name */
    private Context f13629d;

    /* renamed from: e, reason: collision with root package name */
    private int f13630e;

    /* renamed from: f, reason: collision with root package name */
    private int f13631f;

    /* renamed from: g, reason: collision with root package name */
    private a f13632g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13633h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f13634i = 200;

    /* renamed from: k, reason: collision with root package name */
    private Boolean f13635k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a_();

        void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    private void c() {
        if (((Boolean) c(this.f13631f).second).booleanValue()) {
            u.a(new Runnable() { // from class: com.beizi.fusion.tool.aj.1
                @Override // java.lang.Runnable
                public void run() {
                    aj.this.a();
                }
            }, this.f13630e + (((Integer) r0.first).intValue() * 10));
        }
    }

    public void b(int i6) {
        this.f13631f = i6;
        c();
    }

    public void a(AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean) {
        if (scrollClickBean == null) {
            return;
        }
        f13625j = scrollClickBean;
        a(scrollClickBean.getRandomClickTime());
        b(scrollClickBean.getRandomClickNum());
    }

    public aj(Context context) {
        this.f13629d = context;
    }

    public void b() {
        this.f13633h = false;
        ScrollClickView scrollClickView = this.f13626a;
        if (scrollClickView != null) {
            scrollClickView.stopAnim();
        }
        this.f13632g = null;
        this.f13629d = null;
        this.f13626a = null;
        this.f13634i = 200;
    }

    public void a(int i6) {
        this.f13630e = i6;
    }

    public static Pair<Integer, Boolean> c(int i6) {
        int random = (int) ((Math.random() * 100.0d) + 1.0d);
        if (random <= i6) {
            return new Pair<>(Integer.valueOf(random), Boolean.TRUE);
        }
        return new Pair<>(Integer.valueOf(random), Boolean.FALSE);
    }

    public void a(a aVar) {
        this.f13632g = aVar;
    }

    protected void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.f13632g != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.f13633h);
        aa.a("ScrollClickUtil", sb.toString());
        if (this.f13632g == null || this.f13633h) {
            return;
        }
        aa.a("ScrollClickUtil", "callback onShakeHappened()");
        this.f13632g.b("100", "200", "105", "206", "100", "200", "105", "206");
        this.f13633h = true;
        ScrollClickView scrollClickView = this.f13626a;
        if (scrollClickView != null) {
            scrollClickView.stopAnim();
        }
    }

    public View a(final int i6, final int i7, AdSpacesBean.BuyerBean.ScrollClickPositionBean scrollClickPositionBean) {
        String downloadDetails;
        int parseInt;
        int parseInt2;
        aa.a("ScrollClickUtil", "enter getScrollClick");
        if (this.f13629d == null || scrollClickPositionBean == null) {
            return null;
        }
        ScrollClickView scrollClickView = new ScrollClickView(this.f13629d);
        this.f13626a = scrollClickView;
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = f13625j;
            if (scrollClickBean != null) {
                scrollClickView.setScrollDirection(scrollClickBean.getScrollDirection());
                this.f13626a.setTitleText(f13625j.getTitle());
                this.f13626a.setTitleFont(f13625j.getTitleFont());
                if (!this.f13635k.booleanValue()) {
                    downloadDetails = f13625j.getDetails();
                } else {
                    downloadDetails = f13625j.getDownloadDetails();
                    if (TextUtils.isEmpty(downloadDetails)) {
                        downloadDetails = "下载应用";
                    }
                }
                this.f13626a.setDetailText(downloadDetails);
                this.f13626a.setDetailsFont(f13625j.getDetailsFont());
                AdSpacesBean.BuyerBean.ScrollClickPositionBean position = f13625j.getPosition();
                String width = position.getWidth();
                String height = position.getHeight();
                if (width.endsWith("%")) {
                    parseInt = (Integer.parseInt(width.substring(0, width.indexOf("%"))) * i6) / 100;
                } else {
                    parseInt = Integer.parseInt(width);
                }
                if (height.endsWith("%")) {
                    parseInt2 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * parseInt) / 100;
                } else {
                    parseInt2 = Integer.parseInt(height);
                }
                this.f13626a.setHandWidth(parseInt);
                this.f13626a.setScrollbarHeight(parseInt2);
                this.f13626a.buildRealView();
            }
            String top2 = scrollClickPositionBean.getTop();
            String centerX = scrollClickPositionBean.getCenterX();
            if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                centerX = "50%";
            }
            if (TextUtils.isEmpty(top2) || "0".equals(top2)) {
                top2 = "50%";
            }
            ap.i(this.f13629d);
            if (centerX.endsWith("%")) {
                this.f13627b = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i6) / 100;
            } else {
                this.f13627b = Integer.parseInt(centerX);
            }
            if (top2.endsWith("%")) {
                this.f13628c = (Integer.parseInt(top2.substring(0, top2.indexOf("%"))) * i7) / 100;
            } else {
                this.f13628c = Integer.parseInt(top2);
            }
            this.f13627b = ap.a(this.f13629d, this.f13627b);
            this.f13628c = ap.a(this.f13629d, this.f13628c);
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            aa.a("ScrollClickUtil", "topInt = " + this.f13628c + ",centerXInt = " + this.f13627b + ",adWidthDp = " + i6 + ",adHeightDp = " + i7);
            this.f13626a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.tool.aj.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ScrollClickView scrollClickView2 = aj.this.f13626a;
                    if (scrollClickView2 == null) {
                        return;
                    }
                    scrollClickView2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredWidth = aj.this.f13626a.getMeasuredWidth();
                    aj ajVar = aj.this;
                    if (ajVar.f13628c == 0) {
                        ajVar.f13628c = ap.a(ajVar.f13629d, i7) / 2;
                    }
                    aj ajVar2 = aj.this;
                    if (ajVar2.f13627b == 0) {
                        ajVar2.f13627b = ap.a(ajVar2.f13629d, i6) / 2;
                    }
                    FrameLayout.LayoutParams layoutParams2 = layoutParams;
                    aj ajVar3 = aj.this;
                    layoutParams2.topMargin = ajVar3.f13628c;
                    layoutParams2.leftMargin = ajVar3.f13627b - (measuredWidth / 2);
                    ajVar3.f13626a.setLayoutParams(layoutParams2);
                    aa.a("ScrollClickUtil", "topMargin = " + layoutParams.topMargin + ",leftMargin = " + layoutParams.leftMargin + ",scrollViewWidthInt = " + measuredWidth);
                }
            });
            this.f13626a.setLayoutParams(layoutParams);
            this.f13626a.postDelayed(new Runnable() { // from class: com.beizi.fusion.tool.aj.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ScrollClickView scrollClickView2 = aj.this.f13626a;
                        if (scrollClickView2 != null) {
                            scrollClickView2.startAnim();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }, 10L);
        } catch (NumberFormatException e6) {
            e6.printStackTrace();
        }
        return this.f13626a;
    }

    public void a(Boolean bool) {
        this.f13635k = bool;
    }
}
