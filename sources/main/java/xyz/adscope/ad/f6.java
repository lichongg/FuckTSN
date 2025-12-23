package xyz.adscope.ad;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.ScopeIndicateArrowView;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.par.StatusParamModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.status.StatusTitleModel;
import xyz.adscope.amps.R;
import xyz.adscope.common.v2.image.loader.ImageLoader;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class f6 extends a6 implements c4 {

    /* renamed from: f, reason: collision with root package name */
    private ImageView f55139f;

    /* renamed from: g, reason: collision with root package name */
    private ScopeIndicateArrowView f55140g;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f55141h;

    /* renamed from: i, reason: collision with root package name */
    private AnimatorSet f55142i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f55143j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f55144k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f55145l;

    /* renamed from: m, reason: collision with root package name */
    private String f55146m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModel f55147a;

        a(ViewModel viewModel) {
            this.f55147a = viewModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            int min = Math.min(f6.this.f55141h.getMeasuredHeight(), f6.this.f55141h.getMeasuredWidth());
            q6.a(f6.this.getContext(), f6.this.f55141h, this.f55147a.c(), StringUtil.parseInt(this.f55147a.f()), this.f55147a.d(), q6.a(this.f55147a.e(), min));
            f6.this.b(min, this.f55147a);
            f6.this.a(min, this.f55147a);
            f6.this.a(min);
        }
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void c() {
        super.c();
        f();
        i3 i3Var = this.f54799e;
        if (i3Var == null || !(i3Var instanceof p6)) {
            return;
        }
        ((p6) i3Var).i();
    }

    private void f() {
        try {
            AnimatorSet animatorSet = this.f55142i;
            if (animatorSet == null || !animatorSet.isRunning()) {
                ArrayList arrayList = new ArrayList();
                a(arrayList, 0.0f, 30.0f);
                a(arrayList, 30.0f, 0.0f);
                a(arrayList, 0.0f, -30.0f);
                a(arrayList, -30.0f, 0.0f);
                if (arrayList.isEmpty()) {
                    return;
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.f55142i = animatorSet2;
                animatorSet2.addListener(new r4(animatorSet2));
                this.f55142i.playSequentially(arrayList);
                this.f55142i.start();
            }
        } catch (Exception e6) {
            SDKLog.stack(e6);
        }
    }

    private void g() {
        ViewModel f6;
        RenderModel renderModel = this.f55727b;
        if (renderModel == null || (f6 = renderModel.f()) == null) {
            return;
        }
        this.f55141h.post(new a(f6));
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
            TextView textView = this.f55144k;
            if (textView != null) {
                textView.setTextColor(Color.parseColor(o5));
                this.f55144k.setTextSize(2, i6);
                this.f55144k.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            TextView textView2 = this.f55145l;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(o5));
                this.f55145l.setTextSize(2, i6 - 4);
                this.f55145l.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
        }
    }

    private void j() {
        AnimatorSet animatorSet = this.f55142i;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f55142i = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f55142i = animatorSet2;
        animatorSet2.addListener(new r4(animatorSet2));
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void b() {
        super.b();
        j();
        i3 i3Var = this.f54799e;
        if (i3Var == null || !(i3Var instanceof p6)) {
            return;
        }
        ((p6) i3Var).j();
    }

    public void setMaxProgress(int i6) {
        ScopeIndicateArrowView scopeIndicateArrowView = this.f55140g;
        if (scopeIndicateArrowView != null) {
            scopeIndicateArrowView.setMaxProgress(i6);
        }
    }

    public void setProgress(int i6) {
        ScopeIndicateArrowView scopeIndicateArrowView = this.f55140g;
        if (scopeIndicateArrowView != null) {
            scopeIndicateArrowView.setCurrentProgress(i6);
        }
    }

    @Override // xyz.adscope.ad.c4
    public void setRenderWithDownload(boolean z5) {
        this.f55143j = z5;
    }

    public f6(Context context) {
        super(context);
        this.f55143j = false;
        this.f55146m = "";
    }

    private void d(String str) {
        String b6 = b(str);
        String c6 = c(str);
        a(this.f55144k, b6);
        a(this.f55145l, c6);
    }

    private void h() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.asnp_interaction_shake_view, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(inflate, layoutParams);
        this.f55141h = (RelativeLayout) inflate.findViewById(R.id.adscope_isv_container_rl);
        this.f55139f = (ImageView) inflate.findViewById(R.id.adscope_isv_img_iv);
        this.f55140g = (ScopeIndicateArrowView) inflate.findViewById(R.id.adscope_isv_indicate_arrow_view);
        this.f55144k = (TextView) inflate.findViewById(R.id.adscope_isv_title);
        this.f55145l = (TextView) inflate.findViewById(R.id.adscope_isv_sub_title);
    }

    @Override // xyz.adscope.ad.a6, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        g();
        i();
        f();
    }

    @Override // xyz.adscope.ad.a6, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.f55142i;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f55142i = null;
        }
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void a(b4.a aVar) {
        setBackgroundColor(0);
        RenderModel renderModel = this.f55727b;
        if (renderModel != null) {
            aVar.b(renderModel.a());
        }
    }

    private String c(String str) {
        RenderModel renderModel = this.f55727b;
        if (renderModel != null && renderModel.f() != null) {
            return a(a(this.f55727b.f().k()), str);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i6, ViewModel viewModel) {
        RelativeLayout relativeLayout = this.f55141h;
        if (relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.width = i6;
            layoutParams.height = i6;
            this.f55141h.setLayoutParams(layoutParams);
            if (StringUtil.isValidColor(viewModel.c())) {
                q6.a(getContext(), this.f55141h, viewModel.c(), 0, null, i6 / 2);
            } else {
                q6.a(getContext(), this.f55141h, "#66333333", 0, null, i6 / 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6) {
        if (this.f55140g == null || this.f55727b.b() == null) {
            return;
        }
        if (this.f55727b.b().f() != 0) {
            this.f55140g.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f55140g.getLayoutParams();
            int i7 = (int) (i6 * 0.7d);
            layoutParams.width = i7;
            layoutParams.height = i7;
            this.f55140g.setLayoutParams(layoutParams);
            this.f55140g.setLineWidth(i6 / 30);
            return;
        }
        this.f55140g.setVisibility(8);
    }

    private String b(String str) {
        RenderModel renderModel = this.f55727b;
        if (renderModel != null && renderModel.f() != null) {
            return a(a(this.f55727b.f().l()), str);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, ViewModel viewModel) {
        ImageView imageView = this.f55139f;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            int i7 = (int) (i6 * 0.5d);
            layoutParams.width = i7;
            layoutParams.height = i7;
            this.f55139f.setLayoutParams(layoutParams);
            if (TextUtils.isEmpty(viewModel.j())) {
                return;
            }
            ImageLoader.getInstance().loadPermanentImage(this.f55139f, viewModel.j(), false);
        }
    }

    private void a(List<Animator> list, float f6, float f7) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f55139f, "rotation", f6, f7);
            ofFloat.setDuration(100);
            list.add(ofFloat);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
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
        if (this.f55143j) {
            return statusTitleModel.a();
        }
        return statusTitleModel.b();
    }

    @Override // xyz.adscope.ad.c4
    public void a(String str) {
        if (this.f55146m.equals(str)) {
            return;
        }
        this.f55146m = str;
        d(str);
    }
}
