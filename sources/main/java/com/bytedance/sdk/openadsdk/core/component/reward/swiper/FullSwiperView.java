package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.tj.l;
import com.bytedance.sdk.openadsdk.core.tj.la;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ws.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class FullSwiperView extends FrameLayout {
    private boolean ae;
    private AtomicBoolean az;
    private TTBaseVideoActivity cw;

    /* renamed from: g, reason: collision with root package name */
    private List<Integer> f28399g;

    /* renamed from: j, reason: collision with root package name */
    private BaseSwiper<ViewGroup> f28400j;
    private boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private String f28401m;
    private List<Long> oq;
    private List<FullSwiperItemView> qv;

    /* renamed from: r, reason: collision with root package name */
    private float f28402r;
    private List<Integer> tl;
    private float up;
    private int vl;
    private boolean ws;
    private List<j> xt;

    public void ae() {
        BaseSwiper<ViewGroup> baseSwiper = this.f28400j;
        if (baseSwiper != null) {
            baseSwiper.oq(this.vl + 1);
        }
    }

    public int getCurrentPosition() {
        return this.vl;
    }

    public void m() {
        BaseSwiper<ViewGroup> baseSwiper = this.f28400j;
        if (baseSwiper != null) {
            baseSwiper.m();
        }
    }

    public void r() {
        m();
    }

    public void up() {
        for (FullSwiperItemView fullSwiperItemView : this.qv) {
            if (fullSwiperItemView != null) {
                fullSwiperItemView.mi();
            }
        }
    }

    public FullSwiperView(TTBaseVideoActivity tTBaseVideoActivity) {
        super(tTBaseVideoActivity);
        this.ae = false;
        this.jy = true;
        this.ws = true;
        this.az = new AtomicBoolean(false);
        this.cw = tTBaseVideoActivity;
        this.tl = new ArrayList();
        this.f28399g = new ArrayList();
        this.oq = new ArrayList();
        this.f28400j = new SwiperView(tTBaseVideoActivity);
        this.qv = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f28400j, layoutParams);
    }

    public void cw() {
        FullSwiperItemView cw = cw(this.vl);
        if (cw != null) {
            cw.i();
        }
        if (this.vl == this.qv.size() - 1) {
            return;
        }
        this.f28400j.oq(this.vl);
        List<Integer> list = this.f28399g;
        if (list == null || this.vl >= list.size()) {
            return;
        }
        if (!this.jy && !this.az.get()) {
            j(this.f28399g.get(this.vl).intValue());
        }
        this.jy = false;
    }

    public FullSwiperView j(List<j> list) {
        this.xt = list;
        return this;
    }

    public FullSwiperView xt(float f6) {
        this.up = f6;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i6) {
        FullSwiperItemView cw = cw(i6);
        if (cw != null) {
            cw.ws();
        }
    }

    public FullSwiperView j(float f6) {
        this.f28402r = f6;
        return this;
    }

    public FullSwiperView j(String str) {
        this.f28401m = str;
        return this;
    }

    public void j() {
        l ng;
        List<j> list = this.xt;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f28400j.j(false).j("dot").r(false).cw(false).xt(false);
        this.f28400j.setOnPageChangeListener(new com.bytedance.adsdk.ugeno.swiper.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.1
            @Override // com.bytedance.adsdk.ugeno.swiper.j
            public void j(boolean z5, int i6, int i7, boolean z6, boolean z7) {
                if (FullSwiperView.this.ws && i6 == 1) {
                    return;
                }
                FullSwiperView.this.ws = false;
                FullSwiperView.this.vl = i6;
                FullSwiperItemView cw = FullSwiperView.this.cw(i6);
                if (cw != null && FullSwiperView.this.vl != 0) {
                    cw.xt(false);
                }
                FullSwiperItemView cw2 = FullSwiperView.this.cw(i6 - 1);
                if (cw2 != null) {
                    cw2.av();
                    cw2.w();
                }
                FullSwiperView.this.xt(i6 + 1);
                if (!FullSwiperView.this.ae && i6 > 0) {
                    FullSwiperView.this.ae = true;
                    r.xt(FullSwiperView.this.f28401m);
                }
                int intValue = ((Integer) FullSwiperView.this.tl.get(i6)).intValue();
                if (intValue > 0 && i6 != FullSwiperView.this.qv.size() - 1) {
                    FullSwiperView.this.oq.add(i6, Long.valueOf(System.currentTimeMillis()));
                    int i8 = intValue / 1000;
                    int min = Math.min(la.xt(false), i8);
                    int max = Math.max(i8 - la.xt(false), 0);
                    if (min > 0) {
                        FullSwiperView.this.az.set(false);
                        FullSwiperView.this.cw.j(-1, min, max);
                    } else {
                        if (FullSwiperView.this.az.get()) {
                            return;
                        }
                        FullSwiperView.this.j(intValue);
                    }
                }
            }
        });
        for (j jVar : this.xt) {
            n j6 = jVar.j();
            if (j6 != null && (ng = j6.ng()) != null) {
                this.tl.add(Integer.valueOf((int) ng.xt()));
                this.f28399g.add(0);
                this.oq.add(Long.valueOf(System.currentTimeMillis()));
                FullSwiperItemView fullSwiperItemView = new FullSwiperItemView(this.cw, jVar, this.f28402r, this.up);
                fullSwiperItemView.setOnSwiperItemInteractListener(new FullSwiperItemView.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.2
                    @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.j
                    public void j() {
                        FullSwiperView.this.m();
                        FullSwiperView.this.az.set(true);
                        FullSwiperView.this.cw.ff();
                    }
                });
                this.f28400j.j((BaseSwiper<ViewGroup>) fullSwiperItemView);
                this.qv.add(fullSwiperItemView);
            }
        }
        final FullSwiperItemView fullSwiperItemView2 = this.qv.get(0);
        fullSwiperItemView2.setOnSwiperItemRenderResultListener(new FullSwiperItemView.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.xt
            public void j(View view, float f6, float f7) {
                int intValue = ((Integer) FullSwiperView.this.tl.get(0)).intValue();
                if (intValue <= 0) {
                    FullSwiperView.this.f28400j.up();
                } else {
                    FullSwiperView.this.oq.add(0, Long.valueOf(System.currentTimeMillis()));
                    FullSwiperView.this.f28400j.up();
                    if (FullSwiperView.this.qv.size() > 1) {
                        int i6 = intValue / 1000;
                        int min = Math.min(la.xt(false), i6);
                        int max = Math.max(i6 - la.xt(false), 0);
                        if (min > 0) {
                            FullSwiperView.this.cw.j(-1, min, max);
                        } else {
                            FullSwiperView.this.j(intValue);
                        }
                    }
                }
                fullSwiperItemView2.xt(true);
                FullSwiperView.this.xt(1);
            }
        });
        fullSwiperItemView2.ws();
    }

    public void xt() {
        FullSwiperItemView cw = cw(this.vl);
        if (cw != null) {
            cw.av();
        }
        List<Long> list = this.oq;
        if (list != null && this.vl < list.size()) {
            this.f28399g.add(this.vl, Integer.valueOf(this.tl.get(this.vl).intValue() - ((int) (System.currentTimeMillis() - this.oq.get(this.vl).longValue()))));
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullSwiperItemView cw(int i6) {
        List<FullSwiperItemView> list = this.qv;
        if (list == null || i6 < 0 || i6 >= list.size()) {
            return null;
        }
        return this.qv.get(i6);
    }

    public void j(int i6) {
        BaseSwiper<ViewGroup> baseSwiper;
        if (Math.min(la.xt(false), i6 / 1000) <= 0 && (baseSwiper = this.f28400j) != null) {
            baseSwiper.qv(i6);
        }
    }
}
