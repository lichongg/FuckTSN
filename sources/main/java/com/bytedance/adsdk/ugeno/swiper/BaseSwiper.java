package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.swiper.indicator.BaseIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.DotIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.RectangleIndicator;
import com.bytedance.adsdk.ugeno.swiper.j.cw;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;
import com.bytedance.sdk.component.utils.vl;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class BaseSwiper<T> extends FrameLayout implements ViewPager.r {

    /* renamed from: s, reason: collision with root package name */
    private static final Interpolator f23716s = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (f7 * f7 * f7 * f7 * f7) + 1.0f;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f23717a;
    private int ae;
    private boolean av;
    private boolean az;
    private com.bytedance.adsdk.ugeno.swiper.j ch;
    protected Context cw;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f23718f;

    /* renamed from: g, reason: collision with root package name */
    private int f23719g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f23720i;

    /* renamed from: j, reason: collision with root package name */
    protected List<T> f23721j;
    private boolean jy;
    private int kt;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f23722l;

    /* renamed from: m, reason: collision with root package name */
    private int f23723m;
    private int mi;
    private String oq;
    private float qv;

    /* renamed from: r, reason: collision with root package name */
    private int f23724r;
    private int tj;
    private int tl;
    private int up;

    /* renamed from: v, reason: collision with root package name */
    private BaseIndicator f23725v;
    private boolean vl;

    /* renamed from: w, reason: collision with root package name */
    private int f23726w;
    private boolean ws;

    /* renamed from: x, reason: collision with root package name */
    private j f23727x;
    protected ViewPager xt;

    public class SwiperViewPager extends ViewPager {
        public SwiperViewPager(Context context) {
            super(context);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.az) {
                return false;
            }
            try {
                if (BaseSwiper.this.tj != 1) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
                boolean onInterceptTouchEvent = super.onInterceptTouchEvent(j(motionEvent));
                j(motionEvent);
                return onInterceptTouchEvent;
            } catch (IllegalArgumentException e6) {
                vl.j(e6);
                return false;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.az) {
                return false;
            }
            try {
                return BaseSwiper.this.tj == 1 ? super.onTouchEvent(j(motionEvent)) : super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException e6) {
                vl.j(e6);
                return false;
            }
        }

        private MotionEvent j(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }
    }

    class j extends com.bytedance.adsdk.ugeno.viewpager.xt {
        @Override // com.bytedance.adsdk.ugeno.viewpager.xt
        public int j(Object obj) {
            return -2;
        }

        j() {
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xt
        public boolean j(View view, Object obj) {
            return view == obj;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xt
        public int j() {
            if (BaseSwiper.this.ws) {
                return 1024;
            }
            return BaseSwiper.this.f23721j.size();
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xt
        public Object j(ViewGroup viewGroup, int i6) {
            View j6 = BaseSwiper.this.j(i6, xt.j(BaseSwiper.this.ws, i6, BaseSwiper.this.f23721j.size()));
            viewGroup.addView(j6);
            return j6;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xt
        public void j(ViewGroup viewGroup, int i6, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xt
        public float j(int i6) {
            if (BaseSwiper.this.qv <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / BaseSwiper.this.qv;
        }
    }

    public abstract View ae(int i6);

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.r
    public void g(int i6) {
        if (i6 == 1 && this.av) {
            r();
        }
    }

    private boolean ae() {
        return this.f23721j.size() <= 2 && this.ws;
    }

    public BaseSwiper cw(boolean z5) {
        this.vl = z5;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.jy) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.av) {
                    cw();
                }
            } else if (action == 0) {
                r();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.bytedance.adsdk.ugeno.viewpager.xt getAdapter() {
        return this.xt.getAdapter();
    }

    public int getCurrentItem() {
        return this.xt.getCurrentItem();
    }

    public ViewPager getViewPager() {
        return this.xt;
    }

    public ViewPager j() {
        return new SwiperViewPager(getContext());
    }

    public BaseSwiper m(int i6) {
        this.f23719g = i6;
        j(this.oq, this.ae, this.tl, i6, true);
        return this;
    }

    public void oq(int i6) {
        j(this.oq, this.ae, this.tl, this.f23719g, true);
        if (this.f23727x == null) {
            this.f23727x = new j();
            this.xt.j((ViewPager.r) this);
            this.xt.setAdapter(this.f23727x);
        }
        if (this.ws) {
            if (i6 >= 1024) {
                this.xt.j(512, false);
                return;
            } else {
                this.xt.j(i6, true);
                return;
            }
        }
        if (i6 < 0 || i6 >= this.f23721j.size()) {
            return;
        }
        this.xt.j(i6, true);
    }

    public void qv(int i6) {
        removeCallbacks(this.f23717a);
        postDelayed(this.f23717a, i6);
    }

    public BaseSwiper r(boolean z5) {
        this.f23725v.setLoop(z5);
        if (this.ws != z5) {
            int j6 = xt.j(z5, this.xt.getCurrentItem(), this.f23721j.size());
            this.ws = z5;
            j jVar = this.f23727x;
            if (jVar != null) {
                jVar.cw();
                this.xt.setCurrentItem(j6);
            }
        }
        return this;
    }

    public void setOnPageChangeListener(com.bytedance.adsdk.ugeno.swiper.j jVar) {
        this.ch = jVar;
    }

    public void setTwoItems(boolean z5) {
        this.f23720i = z5;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.r
    public void tl(int i6) {
        int i7;
        if (this.ch != null) {
            int j6 = xt.j(this.ws, i6, this.f23721j.size());
            i7 = i6;
            this.ch.j(this.ws, j6, i7, j6 == 0, j6 == this.f23721j.size() - 1);
        } else {
            i7 = i6;
        }
        if (this.vl) {
            this.f23725v.j(i7);
        }
    }

    public BaseSwiper<T> up(int i6) {
        this.tl = i6;
        j(this.oq, this.ae, i6, this.f23719g, true);
        return this;
    }

    public BaseSwiper xt(boolean z5) {
        this.az = z5;
        return this;
    }

    public BaseSwiper(Context context) {
        super(context);
        this.f23721j = new CopyOnWriteArrayList();
        this.f23724r = 2000;
        this.up = 500;
        this.f23723m = 500;
        this.ae = 0;
        this.tl = -1;
        this.f23719g = -1;
        this.oq = PrerollVideoResponse.NORMAL;
        this.qv = 1.0f;
        this.vl = true;
        this.jy = true;
        this.ws = true;
        this.az = true;
        this.f23726w = 0;
        this.mi = 0;
        this.kt = 0;
        this.tj = 0;
        this.f23717a = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.2
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = BaseSwiper.this.xt.getCurrentItem() + 1;
                if (BaseSwiper.this.ws) {
                    if (currentItem >= 1024) {
                        BaseSwiper.this.xt.j(512, false);
                        return;
                    } else {
                        BaseSwiper.this.xt.j(currentItem, true);
                        return;
                    }
                }
                com.bytedance.adsdk.ugeno.viewpager.xt adapter = BaseSwiper.this.xt.getAdapter();
                if (adapter != null) {
                    if (currentItem >= adapter.j()) {
                        BaseSwiper.this.xt.j(0, false);
                    } else {
                        BaseSwiper.this.xt.j(currentItem, true);
                    }
                }
            }
        };
        this.f23722l = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaseSwiper.this.jy) {
                    int currentItem = BaseSwiper.this.xt.getCurrentItem() + 1;
                    if (BaseSwiper.this.ws) {
                        if (currentItem >= 1024) {
                            BaseSwiper.this.xt.j(512, false);
                        } else {
                            BaseSwiper.this.xt.j(currentItem, true);
                        }
                        BaseSwiper baseSwiper = BaseSwiper.this;
                        baseSwiper.postDelayed(baseSwiper.f23722l, BaseSwiper.this.f23724r);
                        return;
                    }
                    com.bytedance.adsdk.ugeno.viewpager.xt adapter = BaseSwiper.this.xt.getAdapter();
                    if (adapter != null) {
                        if (currentItem >= adapter.j()) {
                            BaseSwiper.this.xt.j(0, false);
                            BaseSwiper baseSwiper2 = BaseSwiper.this;
                            baseSwiper2.postDelayed(baseSwiper2.f23722l, BaseSwiper.this.f23724r);
                        } else {
                            BaseSwiper.this.xt.j(currentItem, true);
                            BaseSwiper baseSwiper3 = BaseSwiper.this;
                            baseSwiper3.postDelayed(baseSwiper3.f23722l, BaseSwiper.this.f23724r);
                        }
                    }
                }
            }
        };
        this.cw = context;
        this.f23718f = new FrameLayout(context);
        this.xt = j();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f23718f.addView(this.xt, layoutParams);
        addView(this.f23718f);
    }

    public BaseSwiper cw(int i6) {
        this.f23725v.setUnSelectedColor(i6);
        return this;
    }

    public BaseSwiper j(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.f23725v = new RectangleIndicator(this.cw);
        } else {
            this.f23725v = new DotIndicator(this.cw);
        }
        addView(this.f23725v, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public BaseSwiper xt(int i6) {
        this.f23725v.setSelectedColor(i6);
        return this;
    }

    public void cw() {
        removeCallbacks(this.f23722l);
        postDelayed(this.f23722l, this.f23724r);
    }

    public void m() {
        removeCallbacks(this.f23717a);
    }

    public void up() {
        int i6;
        j(this.oq, this.ae, this.tl, this.f23719g, true);
        if (this.f23727x == null) {
            this.f23727x = new j();
            this.xt.j((ViewPager.r) this);
            this.xt.setAdapter(this.f23727x);
        }
        int i7 = this.f23726w;
        if (i7 < 0 || i7 >= this.f23721j.size()) {
            this.f23726w = 0;
        }
        if (this.ws) {
            i6 = this.f23726w + 512;
        } else {
            i6 = this.f23726w;
        }
        this.xt.j(i6, true);
    }

    public BaseSwiper xt(String str) {
        this.oq = str;
        j(str, this.ae, this.tl, this.f23719g, true);
        return this;
    }

    public void xt() {
        int i6;
        j(this.oq, this.ae, this.tl, this.f23719g, true);
        if (this.f23727x == null) {
            this.f23727x = new j();
            this.xt.j((ViewPager.r) this);
            this.xt.setAdapter(this.f23727x);
        }
        int i7 = this.f23726w;
        if (i7 < 0 || i7 >= this.f23721j.size()) {
            this.f23726w = 0;
        }
        if (this.ws) {
            i6 = this.f23726w + 512;
        } else {
            i6 = this.f23726w;
        }
        this.xt.j(i6, true);
        if (!this.ws) {
            tl(i6);
        }
        if (this.jy) {
            cw();
        }
    }

    public BaseSwiper j(boolean z5) {
        this.jy = z5;
        cw();
        return this;
    }

    public BaseSwiper j(int i6) {
        this.f23724r = i6;
        cw();
        return this;
    }

    public BaseSwiper r(int i6) {
        this.ae = i6;
        j(this.oq, i6, this.tl, this.f23719g, true);
        return this;
    }

    public BaseSwiper j(float f6) {
        this.qv = f6;
        return this;
    }

    public void r() {
        removeCallbacks(this.f23722l);
    }

    public void j(String str, int i6, int i7, int i8, boolean z5) {
        j jVar = this.f23727x;
        if (jVar != null) {
            jVar.cw();
        }
        this.xt.setPageMargin(i6);
        if (i7 > 0 || i8 > 0) {
            if (this.tj == 1) {
                this.xt.setPadding(0, i7 + i6, 0, i8 + i6);
            } else {
                this.xt.setPadding(i7 + i6, 0, i8 + i6, 0);
            }
            this.f23718f.setClipChildren(false);
            this.xt.setClipChildren(false);
            this.xt.setClipToPadding(false);
        }
        if (this.tj == 1) {
            cw cwVar = new cw();
            cwVar.j(str);
            this.xt.j(true, (ViewPager.up) cwVar);
            this.xt.setOverScrollMode(2);
        } else if (TextUtils.equals(str, "linear")) {
            this.xt.j(false, (ViewPager.up) new com.bytedance.adsdk.ugeno.swiper.j.xt());
        } else if (TextUtils.equals(str, "cube")) {
            this.xt.j(false, (ViewPager.up) new com.bytedance.adsdk.ugeno.swiper.j.j());
        } else {
            this.xt.j(false, (ViewPager.up) null);
        }
        this.xt.setOffscreenPageLimit((int) this.qv);
    }

    public View j(int i6, int i7) {
        if (this.f23721j.size() == 0) {
            return new View(getContext());
        }
        View ae = ae(i7);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (ae instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (ae()) {
            ae.setTag("two_items_tag");
        }
        if (ae.getParent() instanceof ViewGroup) {
            ((ViewGroup) ae.getParent()).removeView(ae);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(ae, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (ae()) {
            frameLayout.setTag(Integer.valueOf(i6));
        }
        return frameLayout;
    }

    public BaseSwiper<T> j(T t5) {
        if (t5 != null) {
            this.f23721j.add(t5);
            if (this.vl) {
                this.f23725v.j();
            }
        }
        j jVar = this.f23727x;
        if (jVar != null) {
            jVar.cw();
            this.f23725v.j(this.f23726w, this.xt.getCurrentItem());
        }
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.r
    public void j(int i6, float f6, int i7) {
        if (this.ch != null) {
            xt.j(this.ws, i6, this.f23721j.size());
        }
        if (ae()) {
            j(i6, findViewWithTag(Integer.valueOf(i6)));
            if (f6 > 0.0f) {
                int i8 = i6 + 1;
                j(i8, findViewWithTag(Integer.valueOf(i8)));
            }
        }
    }

    private void j(int i6, View view) {
        View findViewWithTag;
        if ((view instanceof ViewGroup) && (findViewWithTag = view.findViewWithTag("two_items_tag")) == null) {
            T t5 = this.f23721j.get(xt.j(true, i6, this.f23721j.size()));
            if (t5 == null) {
                return;
            }
            if (t5 instanceof com.bytedance.adsdk.ugeno.xt.cw) {
                findViewWithTag = ((com.bytedance.adsdk.ugeno.xt.cw) t5).g();
            } else if (t5 instanceof View) {
                findViewWithTag = (View) t5;
            }
            if (findViewWithTag == null) {
                return;
            }
            if (findViewWithTag.getParent() instanceof ViewGroup) {
                ((ViewGroup) findViewWithTag.getParent()).removeView(findViewWithTag);
            }
            ((ViewGroup) view).addView(findViewWithTag);
        }
    }
}
