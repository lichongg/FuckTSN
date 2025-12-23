package com.beizi.fusion.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ap;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ScrollClickView extends LinearLayout {
    public static final String DIR_DOWN = "down";
    public static final String DIR_LEFT = "left";
    public static final String DIR_RIGHT = "right";
    public static final String DIR_UP = "up";

    /* renamed from: a, reason: collision with root package name */
    ImageView f13910a;

    /* renamed from: b, reason: collision with root package name */
    ImageView f13911b;

    /* renamed from: c, reason: collision with root package name */
    TextView f13912c;

    /* renamed from: d, reason: collision with root package name */
    TextView f13913d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f13914e;

    /* renamed from: f, reason: collision with root package name */
    private String f13915f;

    /* renamed from: g, reason: collision with root package name */
    private String f13916g;

    /* renamed from: h, reason: collision with root package name */
    private int f13917h;

    /* renamed from: i, reason: collision with root package name */
    private int f13918i;

    /* renamed from: j, reason: collision with root package name */
    private String f13919j;

    /* renamed from: k, reason: collision with root package name */
    private int f13920k;

    /* renamed from: l, reason: collision with root package name */
    private int f13921l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f13922m;

    /* renamed from: n, reason: collision with root package name */
    private Context f13923n;

    /* renamed from: o, reason: collision with root package name */
    private FrameLayout f13924o;

    /* renamed from: p, reason: collision with root package name */
    private FrameLayout f13925p;

    /* renamed from: q, reason: collision with root package name */
    private LinearLayout f13926q;

    public ScrollClickView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13914e = false;
        this.f13919j = "up";
        this.f13920k = 45;
        this.f13921l = 180;
        this.f13926q = null;
        init(context);
    }

    private void b() {
        try {
            this.f13910a.post(new Runnable() { // from class: com.beizi.fusion.widget.ScrollClickView.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ScrollClickView.this.f13924o != null && ScrollClickView.this.f13925p != null) {
                            if (ScrollClickView.this.f13910a.getLayoutParams() == null) {
                                return;
                            }
                            final int i6 = ScrollClickView.this.f13910a.getLayoutParams().height;
                            ScrollClickView scrollClickView = ScrollClickView.this;
                            scrollClickView.f13922m = ValueAnimator.ofInt(i6, scrollClickView.f13921l);
                            ViewGroup.LayoutParams layoutParams = ScrollClickView.this.f13911b.getLayoutParams();
                            aa.b("ScrollClickUtil", "handHeight = " + i6);
                            if (layoutParams != null) {
                                layoutParams.height = ScrollClickView.this.f13921l;
                            }
                            ScrollClickView.this.f13922m.setDuration(1000L);
                            ScrollClickView.this.f13922m.setRepeatCount(-1);
                            ScrollClickView.this.f13922m.setRepeatMode(1);
                            ScrollClickView.this.f13922m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.ScrollClickView.2.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    try {
                                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                        ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.f13924o.getLayoutParams();
                                        if (layoutParams2 != null) {
                                            layoutParams2.height = intValue;
                                        }
                                        ViewGroup.LayoutParams layoutParams3 = ScrollClickView.this.f13925p.getLayoutParams();
                                        if (layoutParams3 != null) {
                                            layoutParams3.height = intValue - (i6 / 3);
                                        }
                                        ScrollClickView.this.f13924o.requestLayout();
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            });
                            return;
                        }
                        aa.b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0043 -> B:6:0x007c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0062 -> B:6:0x007c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0064 -> B:6:0x007c). Please report as a decompilation issue!!! */
    public void buildRealView() {
        try {
            if ("up".equalsIgnoreCase(this.f13919j)) {
                this.f13926q = (LinearLayout) LayoutInflater.from(this.f13923n).inflate(R.layout.layout_scrollview_up, this);
            } else if (DIR_DOWN.equalsIgnoreCase(this.f13919j)) {
                this.f13926q = (LinearLayout) LayoutInflater.from(this.f13923n).inflate(R.layout.layout_scrollview_down, this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if ("up".equalsIgnoreCase(this.f13919j)) {
                this.f13926q = (LinearLayout) LayoutInflater.from(StubApp.getOrigApplicationContext(this.f13923n.getApplicationContext())).inflate(R.layout.layout_scrollview_up, this);
            } else if (DIR_DOWN.equalsIgnoreCase(this.f13919j)) {
                this.f13926q = (LinearLayout) LayoutInflater.from(StubApp.getOrigApplicationContext(this.f13923n.getApplicationContext())).inflate(R.layout.layout_scrollview_down, this);
            }
        }
        try {
            LinearLayout linearLayout = this.f13926q;
            if (linearLayout == null) {
                return;
            }
            this.f13910a = (ImageView) linearLayout.findViewById(R.id.hand);
            this.f13911b = (ImageView) this.f13926q.findViewById(R.id.scrollbar);
            this.f13912c = (TextView) this.f13926q.findViewById(R.id.title);
            this.f13913d = (TextView) this.f13926q.findViewById(R.id.details);
            this.f13924o = (FrameLayout) this.f13926q.findViewById(R.id.scroll_container);
            this.f13925p = (FrameLayout) this.f13926q.findViewById(R.id.scrollbar_container);
            this.f13920k = ap.a(this.f13923n, this.f13920k);
            this.f13921l = ap.a(this.f13923n, this.f13921l) + this.f13920k;
            TextView textView = this.f13912c;
            if (textView != null) {
                textView.setText(this.f13915f);
                this.f13912c.setTextSize(2, this.f13917h);
            }
            TextView textView2 = this.f13913d;
            if (textView2 != null) {
                textView2.setText(this.f13916g);
                this.f13913d.setTextSize(2, this.f13918i);
            }
            ImageView imageView = this.f13910a;
            if (imageView == null || this.f13911b == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.f13911b.getLayoutParams();
            if (layoutParams != null) {
                int i6 = this.f13920k;
                layoutParams.width = i6;
                layoutParams.height = i6;
                if (layoutParams2 != null) {
                    layoutParams2.height = this.f13921l;
                    layoutParams2.width = (int) (i6 * 0.55f);
                }
            }
            if (DIR_DOWN.equalsIgnoreCase(this.f13919j)) {
                b();
            } else if ("up".equalsIgnoreCase(this.f13919j)) {
                a();
            } else {
                if (DIR_LEFT.equalsIgnoreCase(this.f13919j)) {
                    return;
                }
                "right".equalsIgnoreCase(this.f13919j);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void init(Context context) {
        if (this.f13914e) {
            return;
        }
        this.f13923n = context;
        this.f13914e = true;
    }

    public void setDetailText(String str) {
        this.f13916g = str;
    }

    public void setDetailsFont(int i6) {
        this.f13918i = i6;
    }

    public void setHandWidth(int i6) {
        this.f13920k = i6;
    }

    public void setScrollDirection(String str) {
        this.f13919j = str;
    }

    public void setScrollbarHeight(int i6) {
        this.f13921l = i6;
    }

    public void setTitleFont(int i6) {
        this.f13917h = i6;
    }

    public void setTitleText(String str) {
        this.f13915f = str;
    }

    public void startAnim() {
        StringBuilder sb = new StringBuilder();
        sb.append("startAnim animator != null ? ");
        sb.append(this.f13922m != null);
        aa.b("ScrollClickUtil", sb.toString());
        try {
            ValueAnimator valueAnimator = this.f13922m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void stopAnim() {
        try {
            ValueAnimator valueAnimator = this.f13922m;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f13922m.cancel();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a() {
        try {
            this.f13910a.post(new Runnable() { // from class: com.beizi.fusion.widget.ScrollClickView.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ScrollClickView.this.f13924o != null && ScrollClickView.this.f13925p != null) {
                            if (ScrollClickView.this.f13910a.getLayoutParams() == null) {
                                return;
                            }
                            final int i6 = ScrollClickView.this.f13910a.getLayoutParams().height;
                            ScrollClickView scrollClickView = ScrollClickView.this;
                            scrollClickView.f13922m = ValueAnimator.ofInt(i6, scrollClickView.f13921l);
                            aa.b("ScrollClickUtil", "handHeight = " + i6 + ",scrollbarHeight = " + ScrollClickView.this.f13921l);
                            ViewGroup.LayoutParams layoutParams = ScrollClickView.this.f13911b.getLayoutParams();
                            StringBuilder sb = new StringBuilder();
                            sb.append("handHeight = ");
                            sb.append(i6);
                            aa.b("ScrollClickUtil", sb.toString());
                            if (layoutParams != null) {
                                layoutParams.height = ScrollClickView.this.f13921l;
                            }
                            ScrollClickView.this.f13922m.setDuration(1000L);
                            ScrollClickView.this.f13922m.setRepeatCount(-1);
                            ScrollClickView.this.f13922m.setRepeatMode(1);
                            ScrollClickView.this.f13922m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.ScrollClickView.1.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    try {
                                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                        ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.f13910a.getLayoutParams();
                                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                                            ((FrameLayout.LayoutParams) layoutParams2).topMargin = ScrollClickView.this.f13921l - intValue;
                                        }
                                        ViewGroup.LayoutParams layoutParams3 = ScrollClickView.this.f13925p.getLayoutParams();
                                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                                            layoutParams3.height = intValue - (i6 / 3);
                                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                                            layoutParams4.topMargin = ScrollClickView.this.f13921l - layoutParams4.height;
                                        }
                                        ScrollClickView.this.f13924o.requestLayout();
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            });
                            return;
                        }
                        aa.b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public ScrollClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13914e = false;
        this.f13919j = "up";
        this.f13920k = 45;
        this.f13921l = 180;
        this.f13926q = null;
        init(context);
    }

    public ScrollClickView(Context context) {
        super(context);
        this.f13914e = false;
        this.f13919j = "up";
        this.f13920k = 45;
        this.f13921l = 180;
        this.f13926q = null;
        init(context);
    }
}
