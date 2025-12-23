package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.model.layer.a;
import com.bytedance.adsdk.lottie.model.layer.b;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationImageView;
import com.bytedance.sdk.component.adexpress.dynamic.r.g;
import com.bytedance.sdk.component.adexpress.r.m;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.adexpress.widget.TTRoundRectImageView;
import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.az;
import com.bytedance.sdk.component.m.oq;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.m.tl;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.umeng.analytics.pro.au;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicImageView extends DynamicBaseWidgetImp {

    /* renamed from: j, reason: collision with root package name */
    private String f25680j;

    private static class j implements tl {

        /* renamed from: j, reason: collision with root package name */
        private final WeakReference<Context> f25682j;

        @Override // com.bytedance.sdk.component.m.tl
        @ATSMethod(1)
        public Bitmap j(Bitmap bitmap) {
            Context context = this.f25682j.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.r.xt.j(context, bitmap, 25);
            }
            return null;
        }

        public j(Context context) {
            this.f25682j = new WeakReference<>(context);
        }
    }

    private static class xt implements av<Bitmap> {

        /* renamed from: j, reason: collision with root package name */
        private WeakReference<View> f25683j;
        private Resources xt;

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(2)
        public void j(int i6, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(1)
        public void j(qv<Bitmap> qvVar) {
            Bitmap cw;
            View view = this.f25683j.get();
            if (view == null || (cw = qvVar.cw()) == null || qvVar.r() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.xt, cw));
        }

        public xt(View view, Resources resources) {
            this.f25683j = new WeakReference<>(view);
            this.xt = resources;
        }
    }

    private void j(oq oqVar) {
        oqVar.cw(3).j(new av() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView.1
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i6, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv qvVar) {
                Object cw = qvVar.cw();
                if (cw instanceof byte[]) {
                    DynamicImageView dynamicImageView = DynamicImageView.this;
                    View view = dynamicImageView.az;
                    if (view instanceof ImageView) {
                        m.xt((ImageView) view, (byte[]) cw, dynamicImageView.ae, dynamicImageView.tl);
                    }
                }
            }
        }, 4);
    }

    private boolean g() {
        String vl = this.vl.vl();
        if (this.vl.kt()) {
            return true;
        }
        if (TextUtils.isEmpty(vl)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(vl);
            return Math.abs((((float) this.ae) / (((float) this.tl) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException e6) {
            vl.j(e6);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        try {
            View view = this.az;
            if (view instanceof UpieImageView) {
                view.setBackgroundColor(this.vl.l());
                if (g()) {
                    ((UpieImageView) this.az).setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    ((UpieImageView) this.az).setScaleType(ImageView.ScaleType.FIT_XY);
                }
                if ("cover".equals(getImageObjectFit())) {
                    ((UpieImageView) this.az).setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                return true;
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        if (!TextUtils.isEmpty(this.vl.st())) {
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        if ("arrowButton".equals(this.jy.oq().getType())) {
            ((ImageView) this.az).setImageResource(kt.up(this.qv, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.az).getDrawable() != null) {
                ((ImageView) this.az).getDrawable().setAutoMirrored(true);
            }
            this.az.setPadding(0, 0, 0, 0);
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.az.setBackgroundColor(this.vl.l());
        String xt2 = this.jy.oq().xt();
        if (au.f40908m.equals(xt2)) {
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.az).setColorFilter(this.vl.ae());
            kt.j(getContext(), "tt_user", (ImageView) this.az);
            ImageView imageView = (ImageView) this.az;
            int i6 = this.ae;
            imageView.setPadding(i6 / 10, this.tl / 5, i6 / 10, 0);
        } else if (xt2 != null && xt2.startsWith("@")) {
            try {
                ((ImageView) this.az).setImageResource(Integer.parseInt(xt2.substring(1)));
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        az up = com.bytedance.sdk.component.adexpress.j.j.j.j().up();
        String qv = this.vl.qv();
        if (!TextUtils.isEmpty(qv) && !qv.startsWith("http:") && !qv.startsWith("https:")) {
            DynamicRootView dynamicRootView = this.ws;
            qv = g.xt(qv, (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) ? null : this.ws.getRenderRequest().a());
        }
        oq xt3 = up.j(qv).xt(this.f25680j);
        String i7 = this.ws.getRenderRequest().i();
        if (!TextUtils.isEmpty(i7)) {
            xt3.cw(i7);
        }
        if (g()) {
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.FIT_CENTER);
            xt3.j(Bitmap.Config.ARGB_4444).cw(2).j(new j(this.qv)).j(new xt(this.az, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.r.j()) {
                xt3.j((ImageView) this.az);
            }
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.az instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.bytedance.sdk.component.adexpress.r.j()) {
            j(xt3);
        }
        return true;
    }

    protected String xt(String str) {
        Map<String, String> ws = this.ws.getRenderRequest().ws();
        if (ws == null || ws.size() <= 0) {
            return null;
        }
        return ws.get(str);
    }

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        super(context, dynamicRootView, tlVar);
        if (!TextUtils.isEmpty(this.vl.st()) && tlVar.mi()) {
            DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
            dynamicLottieView.setAnimationsLoop(this.vl.pz());
            dynamicLottieView.setImageLottieTosPath(this.vl.st());
            dynamicLottieView.setLottieAppNameMaxLength(this.vl.ln());
            dynamicLottieView.setLottieAdTitleMaxLength(this.vl.wf());
            dynamicLottieView.setLottieAdDescMaxLength(this.vl.qa());
            dynamicLottieView.setData(tlVar.kt());
            this.az = dynamicLottieView;
        } else if (this.vl.az() > 0.0f) {
            TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
            this.az = tTRoundRectImageView;
            tTRoundRectImageView.setXRound((int) com.bytedance.sdk.component.adexpress.r.tl.j(context, this.vl.az()));
            ((TTRoundRectImageView) this.az).setYRound((int) com.bytedance.sdk.component.adexpress.r.tl.j(context, this.vl.az()));
        } else if (!ae() && "arrowButton".equals(tlVar.oq().getType())) {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.vl);
            this.az = animationImageView;
        } else if (com.bytedance.sdk.component.adexpress.r.oq.xt(this.vl.qv())) {
            this.az = new GifView(context);
        } else {
            String qv = this.vl.qv();
            jy renderRequest = dynamicRootView.getRenderRequest();
            if (renderRequest != null && renderRequest.xt() != null && TextUtils.equals(qv, renderRequest.j())) {
                this.az = renderRequest.xt();
            } else {
                this.az = new ImageView(context);
            }
        }
        this.f25680j = xt(this.vl.qv());
        this.az.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(tlVar.oq().getType())) {
            if (this.vl.xt() <= 0 && this.vl.j() <= 0) {
                int max = Math.max(this.ae, this.tl);
                this.ae = max;
                this.tl = Math.max(max, this.tl);
            } else {
                int min = Math.min(this.ae, this.tl);
                this.ae = min;
                this.tl = Math.min(min, this.tl);
                this.f25656g = (int) (this.f25656g + com.bytedance.sdk.component.adexpress.r.tl.j(context, this.vl.xt() + (this.vl.j() / 2) + 0.5f));
            }
            this.vl.j(this.ae / 2);
        }
        addView(this.az, new FrameLayout.LayoutParams(this.ae, this.tl));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this.az;
        if (view instanceof ImageView) {
            Drawable drawable = ((ImageView) view).getDrawable();
            if (Build.VERSION.SDK_INT >= 28 && a.a(drawable)) {
                b.a(drawable).start();
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View view = this.az;
        if (view instanceof ImageView) {
            Drawable drawable = ((ImageView) view).getDrawable();
            if (Build.VERSION.SDK_INT >= 28 && a.a(drawable)) {
                b.a(drawable).stop();
            }
        }
    }
}
