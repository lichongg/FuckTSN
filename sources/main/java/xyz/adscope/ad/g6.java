package xyz.adscope.ad;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.c5;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.par.StatusParamModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.status.StatusTitleModel;
import xyz.adscope.amps.R;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class g6 extends a6 implements c4 {

    /* renamed from: f, reason: collision with root package name */
    private ImageView f55172f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f55173g;

    /* renamed from: h, reason: collision with root package name */
    private k6 f55174h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f55175i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f55176j;

    /* renamed from: k, reason: collision with root package name */
    private String f55177k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f55178l;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f55179m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g6.this.a(g6.this.getLayoutParams());
            g6.this.f();
            g6.this.j();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b extends k6 {

        /* renamed from: b, reason: collision with root package name */
        private final String f55181b;

        public b(int i6, int i7, String str) {
            super(i6, i7, 1000L);
            this.f55181b = str;
            a(-1, 1);
        }

        @Override // xyz.adscope.ad.k6
        protected void a(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (g6.this.f55173g != null && g6.this.f55172f != null) {
                g6.this.f55173g.layout(intValue, g6.this.f55173g.getTop(), g6.this.f55173g.getWidth() + intValue, g6.this.f55173g.getBottom());
                if ("slideleft".equalsIgnoreCase(this.f55181b)) {
                    g6.this.f55172f.layout(intValue, g6.this.f55172f.getTop(), g6.this.f55172f.getRight(), g6.this.f55172f.getBottom());
                } else {
                    g6.this.f55172f.layout(g6.this.f55172f.getLeft(), g6.this.f55172f.getTop(), intValue, g6.this.f55172f.getBottom());
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends k6 {

        /* renamed from: b, reason: collision with root package name */
        private final String f55183b;

        /* synthetic */ c(g6 g6Var, int i6, int i7, String str, a aVar) {
            this(i6, i7, str);
        }

        private c(int i6, int i7, String str) {
            super(i6, i7, 1000L);
            this.f55183b = str;
            a(-1, 1);
        }

        @Override // xyz.adscope.ad.k6
        protected void a(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (g6.this.f55173g != null && g6.this.f55172f != null) {
                g6.this.f55173g.layout(g6.this.f55173g.getLeft(), intValue, g6.this.f55173g.getRight(), g6.this.f55173g.getHeight() + intValue);
                if ("slideup".equalsIgnoreCase(this.f55183b)) {
                    g6.this.f55172f.layout(g6.this.f55172f.getLeft(), intValue, g6.this.f55172f.getRight(), g6.this.f55172f.getBottom());
                } else {
                    g6.this.f55172f.layout(g6.this.f55172f.getLeft(), g6.this.f55172f.getTop(), g6.this.f55172f.getRight(), intValue);
                }
            }
        }
    }

    private boolean b(String str) {
        return "slideleft".equalsIgnoreCase(str) || "slideright".equalsIgnoreCase(str);
    }

    private boolean c(String str) {
        return "slidedown".equalsIgnoreCase(str) || "slideup".equalsIgnoreCase(str);
    }

    private String d(String str) {
        RenderModel renderModel = this.f55727b;
        return (renderModel == null || renderModel.f() == null) ? "" : a(a(this.f55727b.f().l()), str);
    }

    private String e(String str) {
        RenderModel renderModel = this.f55727b;
        return (renderModel == null || renderModel.f() == null) ? "" : a(a(this.f55727b.f().k()), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        char c6;
        int right;
        int left;
        int right2;
        int width;
        String str = this.f55177k;
        int hashCode = str.hashCode();
        if (hashCode == -2119261172) {
            if (str.equals("slideup")) {
                c6 = 2;
            }
            c6 = 65535;
        } else if (hashCode == -795991597) {
            if (str.equals("slidedown")) {
                c6 = 3;
            }
            c6 = 65535;
        } else if (hashCode != -795763400) {
            if (hashCode == 1106799371 && str.equals("slideright")) {
                c6 = 1;
            }
            c6 = 65535;
        } else {
            if (str.equals("slideleft")) {
                c6 = 0;
            }
            c6 = 65535;
        }
        if (c6 != 0) {
            if (c6 == 1) {
                right = this.f55172f.getLeft();
                right2 = this.f55172f.getRight();
                width = this.f55173g.getWidth();
            } else if (c6 != 2) {
                right = this.f55172f.getTop();
                right2 = this.f55172f.getBottom();
                width = this.f55173g.getHeight();
            } else {
                right = this.f55172f.getBottom() - this.f55173g.getHeight();
                left = this.f55172f.getTop();
            }
            left = right2 - width;
        } else {
            right = this.f55172f.getRight() - this.f55173g.getWidth();
            left = this.f55172f.getLeft();
        }
        int i6 = right;
        int i7 = left;
        if ("slideleft".equalsIgnoreCase(this.f55177k) || "slideright".equalsIgnoreCase(this.f55177k)) {
            this.f55174h = new b(i6, i7, this.f55177k);
        }
        if ("slideup".equalsIgnoreCase(this.f55177k) || "slidedown".equalsIgnoreCase(this.f55177k)) {
            this.f55174h = new c(this, i6, i7, this.f55177k, null);
        }
    }

    private void h() {
        k6 k6Var = this.f55174h;
        if (k6Var != null) {
            k6Var.b();
        }
    }

    private void i() {
        if (this.f55727b.f() != null) {
            String o5 = this.f55727b.f().o();
            if (!StringUtil.isValidColor(o5)) {
                o5 = "#FFFFFFFF";
            }
            int i6 = this.f55727b.f().i();
            if (i6 == 0) {
                i6 = 20;
            }
            TextView textView = this.f55175i;
            if (textView != null) {
                textView.setTextColor(Color.parseColor(o5));
                this.f55175i.setTextSize(2, i6);
                this.f55175i.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            TextView textView2 = this.f55176j;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(o5));
                this.f55176j.setTextSize(2, i6 - 4);
                this.f55176j.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        k6 k6Var = this.f55174h;
        if (k6Var != null) {
            k6Var.c();
        }
    }

    private void k() {
        String d6 = d("Normal");
        if (this.f55175i != null) {
            if (TextUtils.isEmpty(d6)) {
                this.f55175i.setVisibility(8);
            } else {
                this.f55175i.setText(d6);
            }
        }
        String e6 = e("Normal");
        if (this.f55176j != null) {
            if (TextUtils.isEmpty(e6)) {
                this.f55176j.setVisibility(8);
            } else {
                this.f55176j.setText(e6);
            }
        }
    }

    @Override // xyz.adscope.ad.c4
    public void setRenderWithDownload(boolean z5) {
        this.f55178l = z5;
    }

    public g6(Context context) {
        super(context);
    }

    private int a(TextView textView) {
        if (textView == null || textView.getVisibility() == 8) {
            return 0;
        }
        return c5.a.a(getContext(), textView);
    }

    private void g() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.asnp_interaction_slide_view, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        addView(inflate, layoutParams);
        this.f55179m = (RelativeLayout) inflate.findViewById(R.id.guild_layout);
        this.f55172f = (ImageView) inflate.findViewById(R.id.slide_basic_line);
        this.f55173g = (ImageView) inflate.findViewById(R.id.slide_guide_icon);
        this.f55175i = (TextView) inflate.findViewById(R.id.main_title);
        this.f55176j = (TextView) inflate.findViewById(R.id.sub_title);
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void b() {
        super.b();
        h();
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void c() {
        super.c();
        j();
    }

    @Override // xyz.adscope.ad.a6, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        i();
        k();
        post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup.LayoutParams layoutParams) {
        RenderModel renderModel;
        if (layoutParams == null || (renderModel = this.f55727b) == null || renderModel.b() == null) {
            return;
        }
        int a6 = (layoutParams.height - a(this.f55175i)) - a(this.f55176j);
        String a7 = this.f55727b.f().a();
        this.f55177k = a7;
        if (TextUtils.isEmpty(a7)) {
            this.f55177k = "slideup";
        }
        ViewGroup.LayoutParams layoutParams2 = this.f55179m.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = a6;
        if (!TextUtils.isEmpty(this.f55177k)) {
            if (c(this.f55177k) && "slidedown".equalsIgnoreCase(this.f55177k)) {
                this.f55172f.setRotation(180.0f);
            }
            if (b(this.f55177k)) {
                if ("slideright".equalsIgnoreCase(this.f55177k)) {
                    this.f55172f.setRotation(90.0f);
                }
                if ("slideleft".equalsIgnoreCase(this.f55177k)) {
                    this.f55172f.setRotation(270.0f);
                }
            }
        }
        this.f55179m.setLayoutParams(layoutParams2);
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void a(b4.a aVar) {
        super.a(aVar);
    }

    @Override // xyz.adscope.ad.c4
    public void a(String str) {
        k();
    }

    private String a(StatusParamModel statusParamModel, String str) {
        if (statusParamModel != null) {
            if ("Normal".equals(str)) {
                return statusParamModel.b();
            }
            if ("Passive".equals(str)) {
                return statusParamModel.c();
            }
            if ("Cooling".equals(str)) {
                return statusParamModel.a();
            }
            return "";
        }
        return "";
    }

    private StatusParamModel a(StatusTitleModel statusTitleModel) {
        if (statusTitleModel == null) {
            return null;
        }
        if (this.f55178l) {
            return statusTitleModel.a();
        }
        return statusTitleModel.b();
    }
}
