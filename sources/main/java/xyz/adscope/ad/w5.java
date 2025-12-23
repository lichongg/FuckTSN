package xyz.adscope.ad;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.ScopeIndicateArrowView;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.InteractionModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.par.StatusParamModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.status.StatusTitleModel;
import xyz.adscope.amps.R;
import xyz.adscope.common.v2.image.loader.ImageLoader;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class w5 extends a6 implements c4 {

    /* renamed from: f, reason: collision with root package name */
    private final String f56049f;

    /* renamed from: g, reason: collision with root package name */
    private final String f56050g;

    /* renamed from: h, reason: collision with root package name */
    private final String f56051h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f56052i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f56053j;

    /* renamed from: k, reason: collision with root package name */
    private ScopeIndicateArrowView f56054k;

    /* renamed from: l, reason: collision with root package name */
    private LinearLayout f56055l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f56056m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f56057n;

    /* renamed from: o, reason: collision with root package name */
    private AnimatorSet f56058o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f56059p;

    /* renamed from: q, reason: collision with root package name */
    private Object f56060q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModel f56061a;

        a(ViewModel viewModel) {
            this.f56061a = viewModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            int min = Math.min(w5.this.f56052i.getMeasuredHeight(), w5.this.f56052i.getMeasuredWidth());
            q6.a(w5.this.getContext(), w5.this.f56052i, this.f56061a.c(), StringUtil.parseInt(this.f56061a.f()), this.f56061a.d(), q6.a(this.f56061a.e(), min));
            w5.this.c(min);
            w5.this.a(min);
            w5.this.b(min);
        }
    }

    private void f() {
        ViewModel f6;
        RenderModel renderModel = this.f55727b;
        if (renderModel == null || (f6 = renderModel.f()) == null) {
            return;
        }
        this.f56052i.post(new a(f6));
    }

    private void h() {
        if (this.f55727b.f() != null) {
            String o5 = this.f55727b.f().o();
            if (!StringUtil.isValidColor(o5)) {
                o5 = "#FFFFFFFF";
            }
            int i6 = this.f55727b.f().i();
            if (i6 == 0) {
                i6 = 20;
            }
            TextView textView = this.f56056m;
            if (textView != null) {
                textView.setTextColor(Color.parseColor(o5));
                this.f56056m.setTextSize(2, i6);
                this.f56056m.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            TextView textView2 = this.f56057n;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(o5));
                this.f56057n.setTextSize(2, i6 - 4);
                this.f56057n.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
        }
    }

    private void i() {
        AnimatorSet animatorSet = this.f56058o;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f56058o = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f56058o = animatorSet2;
        animatorSet2.addListener(new r4(animatorSet2));
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void b() {
        super.b();
        i3 i3Var = this.f54799e;
        if (i3Var != null && (i3Var instanceof p6)) {
            ((p6) i3Var).j();
        }
        i();
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void c() {
        super.c();
        i3 i3Var = this.f54799e;
        if (i3Var == null || !(i3Var instanceof p6)) {
            return;
        }
        ((p6) i3Var).i();
    }

    public void setCurrentProgress(double d6) {
        try {
            ScopeIndicateArrowView scopeIndicateArrowView = this.f56054k;
            if (scopeIndicateArrowView != null) {
                scopeIndicateArrowView.setCurrentProgress(d6);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.ad.c4
    public void setRenderWithDownload(boolean z5) {
        this.f56059p = z5;
    }

    public w5(Context context) {
        super(context);
        this.f56049f = "rotationX";
        this.f56050g = "rotationY";
        this.f56051h = "rotation";
        this.f56060q = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[Catch: Exception -> 0x0011, TryCatch #0 {Exception -> 0x0011, blocks: (B:3:0x0008, B:5:0x000d, B:6:0x0013, B:8:0x001a, B:10:0x0020, B:12:0x0026, B:13:0x0031, B:14:0x0039, B:16:0x003d, B:18:0x0043, B:19:0x004e, B:21:0x0057), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0057 A[Catch: Exception -> 0x0011, TRY_LEAVE, TryCatch #0 {Exception -> 0x0011, blocks: (B:3:0x0008, B:5:0x000d, B:6:0x0013, B:8:0x001a, B:10:0x0020, B:12:0x0026, B:13:0x0031, B:14:0x0039, B:16:0x003d, B:18:0x0043, B:19:0x004e, B:21:0x0057), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = r5.b(r6)
            java.lang.String r6 = r5.c(r6)
            android.widget.LinearLayout r1 = r5.f56055l     // Catch: java.lang.Exception -> L11
            r2 = 0
            if (r1 == 0) goto L13
            r1.setVisibility(r2)     // Catch: java.lang.Exception -> L11
            goto L13
        L11:
            r6 = move-exception
            goto L5b
        L13:
            android.widget.TextView r1 = r5.f56056m     // Catch: java.lang.Exception -> L11
            r3 = 1
            r4 = 8
            if (r1 == 0) goto L38
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L11
            if (r1 != 0) goto L38
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L11
            if (r1 != 0) goto L31
            android.widget.TextView r1 = r5.f56056m     // Catch: java.lang.Exception -> L11
            r1.setVisibility(r2)     // Catch: java.lang.Exception -> L11
            android.widget.TextView r1 = r5.f56056m     // Catch: java.lang.Exception -> L11
            r1.setText(r0)     // Catch: java.lang.Exception -> L11
            goto L38
        L31:
            android.widget.TextView r0 = r5.f56056m     // Catch: java.lang.Exception -> L11
            r0.setVisibility(r4)     // Catch: java.lang.Exception -> L11
            r0 = 1
            goto L39
        L38:
            r0 = 0
        L39:
            android.widget.TextView r1 = r5.f56057n     // Catch: java.lang.Exception -> L11
            if (r1 == 0) goto L54
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> L11
            if (r1 != 0) goto L4e
            android.widget.TextView r1 = r5.f56057n     // Catch: java.lang.Exception -> L11
            r1.setVisibility(r2)     // Catch: java.lang.Exception -> L11
            android.widget.TextView r1 = r5.f56057n     // Catch: java.lang.Exception -> L11
            r1.setText(r6)     // Catch: java.lang.Exception -> L11
            goto L54
        L4e:
            android.widget.TextView r6 = r5.f56057n     // Catch: java.lang.Exception -> L11
            r6.setVisibility(r4)     // Catch: java.lang.Exception -> L11
            goto L55
        L54:
            r3 = r0
        L55:
            if (r3 == 0) goto L5a
            r5.f()     // Catch: java.lang.Exception -> L11
        L5a:
            return
        L5b:
            r6.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.w5.d(java.lang.String):void");
    }

    private void g() {
        View inflate = View.inflate(getContext(), R.layout.asnp_interaction_euler_angle_view, null);
        this.f56052i = (RelativeLayout) inflate.findViewById(R.id.adscope_ieav_container_rl);
        this.f56053j = (ImageView) inflate.findViewById(R.id.adscope_ieav_img_iv);
        ScopeIndicateArrowView scopeIndicateArrowView = (ScopeIndicateArrowView) inflate.findViewById(R.id.adscope_ieav_indicate_arrow_view);
        this.f56054k = scopeIndicateArrowView;
        scopeIndicateArrowView.setMaxProgress(100.0d);
        this.f56055l = (LinearLayout) inflate.findViewById(R.id.adscope_ieav_title_container_ll);
        this.f56056m = (TextView) inflate.findViewById(R.id.adscope_ieav_title_tv);
        this.f56057n = (TextView) inflate.findViewById(R.id.adscope_ieav_subtitle_tv);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(inflate, layoutParams);
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void a() {
        AnimatorSet animatorSet = this.f56058o;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f56058o.removeAllListeners();
        }
        this.f56058o = null;
        super.a();
    }

    @Override // xyz.adscope.ad.a6, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h();
        f();
    }

    @Override // xyz.adscope.ad.a6, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.f56058o;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f56058o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i6) {
        RelativeLayout relativeLayout = this.f56052i;
        if (relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.width = i6;
            layoutParams.height = i6;
            this.f56052i.setLayoutParams(layoutParams);
            String c6 = this.f55727b.f().c();
            int i7 = i6 / 2;
            if (StringUtil.isValidColor(c6)) {
                q6.a(getContext(), this.f56052i, c6, 0, null, i7);
            } else {
                q6.a(getContext(), this.f56052i, "#66333333", 0, null, i7);
            }
        }
    }

    public void b(String str, String str2, String str3) {
        try {
            AnimatorSet animatorSet = this.f56058o;
            if (animatorSet == null || !animatorSet.isRunning()) {
                a(str, str2, str3);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a(str, "rotationX"));
                arrayList.addAll(a(str2, "rotationY"));
                arrayList.addAll(a(str3, "rotation"));
                if (arrayList.isEmpty()) {
                    return;
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.f56058o = animatorSet2;
                animatorSet2.addListener(new r4(animatorSet2));
                this.f56058o.playSequentially(arrayList);
                this.f56058o.start();
            }
        } catch (Exception e6) {
            SDKLog.stack(e6);
        }
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void a(b4.a aVar) {
        if (this.f55727b != null) {
            setBackgroundColor(0);
            aVar.b(this.f55727b.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6) {
        ImageView imageView = this.f56053j;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            double d6 = i6;
            layoutParams.width = (int) (0.35d * d6);
            layoutParams.height = (int) (d6 * 0.5d);
            this.f56053j.setLayoutParams(layoutParams);
        }
        String j6 = this.f55727b.f().j();
        if (TextUtils.isEmpty(j6)) {
            return;
        }
        ImageLoader.getInstance().loadPermanentImage(this.f56053j, j6, false);
    }

    private String c(String str) {
        RenderModel renderModel = this.f55727b;
        if (renderModel != null && renderModel.f() != null) {
            return a(a(this.f55727b.f().k()), str);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i6) {
        try {
            if (this.f56054k == null) {
                return;
            }
            InteractionModel b6 = this.f55727b.b();
            if ((b6 != null ? b6.f() : 0) == 0) {
                this.f56054k.setVisibility(8);
                return;
            }
            this.f56054k.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f56054k.getLayoutParams();
            int i7 = (int) (i6 * 0.7d);
            layoutParams.width = i7;
            layoutParams.height = i7;
            this.f56054k.setLayoutParams(layoutParams);
            this.f56054k.setLineWidth(i6 / 30);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private List<Animator> a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            float f6 = ("rotationX".equalsIgnoreCase(str2) || "rotationY".equalsIgnoreCase(str2)) ? 60.0f : 30.0f;
            ArrayList arrayList = new ArrayList();
            if ("2".equalsIgnoreCase(str)) {
                float f7 = -f6;
                a(arrayList, str2, 0.0f, f7);
                a(arrayList, str2, f7, 0.0f);
                return arrayList;
            }
            if ("1".equalsIgnoreCase(str)) {
                a(arrayList, str2, 0.0f, f6);
                a(arrayList, str2, f6, 0.0f);
                return arrayList;
            }
            a(arrayList, str2, 0.0f, f6);
            a(arrayList, str2, f6, 0.0f);
            float f8 = -f6;
            a(arrayList, str2, 0.0f, f8);
            a(arrayList, str2, f8, 0.0f);
            return arrayList;
        }
        return new ArrayList();
    }

    private String b(String str) {
        RenderModel renderModel = this.f55727b;
        if (renderModel != null && renderModel.f() != null) {
            return a(a(this.f55727b.f().l()), str);
        }
        return "";
    }

    private void a(List<Animator> list, String str, float f6, float f7) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f56053j, str, f6, f7);
            ofFloat.setDuration(org.apache.commons.net.ftp.l.f50696w);
            list.add(ofFloat);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(String str, String str2, String str3) {
        try {
            if (this.f56054k == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f56054k.setArrowDirection(0);
                return;
            }
            if (("1".equals(str2) && "1".equals(str3)) || ((TextUtils.isEmpty(str2) && "1".equals(str3)) || (TextUtils.isEmpty(str3) && "1".equals(str2)))) {
                this.f56054k.setArrowDirection(1);
                return;
            }
            if (("2".equals(str2) && "2".equals(str3)) || ((TextUtils.isEmpty(str2) && "2".equals(str3)) || (TextUtils.isEmpty(str3) && "2".equals(str2)))) {
                this.f56054k.setArrowDirection(2);
            } else {
                this.f56054k.setArrowDirection(0);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private StatusParamModel a(StatusTitleModel statusTitleModel) {
        if (statusTitleModel == null) {
            return null;
        }
        if (this.f56059p) {
            return statusTitleModel.a();
        }
        return statusTitleModel.b();
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

    @Override // xyz.adscope.ad.c4
    public void a(String str) {
        if (this.f56060q.equals(str)) {
            return;
        }
        this.f56060q = str;
        d(str);
    }
}
