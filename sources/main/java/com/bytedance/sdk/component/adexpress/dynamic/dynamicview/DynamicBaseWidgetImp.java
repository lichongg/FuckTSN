package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.ae;
import com.bytedance.sdk.component.adexpress.dynamic.cw.oq;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.adexpress.dynamic.r.g;
import com.bytedance.sdk.component.adexpress.r.m;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.m.tl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    private static String kt = "";

    /* renamed from: f, reason: collision with root package name */
    private ImageView f25664f;

    /* renamed from: j, reason: collision with root package name */
    private Runnable f25665j;
    protected InteractViewContainer mi;
    private volatile boolean tj;
    private Runnable xt;

    private static class cw implements tl {

        /* renamed from: j, reason: collision with root package name */
        private final WeakReference<Context> f25673j;
        private final int xt;

        @Override // com.bytedance.sdk.component.m.tl
        @ATSMethod(1)
        public Bitmap j(Bitmap bitmap) {
            Context context = this.f25673j.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.r.xt.j(context, bitmap, this.xt);
            }
            return null;
        }

        public cw(Context context, int i6) {
            this.f25673j = new WeakReference<>(context);
            this.xt = i6;
        }
    }

    private static class j implements av<Bitmap> {
        private final com.bytedance.sdk.component.adexpress.dynamic.cw.tl cw;

        /* renamed from: j, reason: collision with root package name */
        private final WeakReference<View> f25674j;
        private final WeakReference<DynamicRootView> xt;

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(2)
        public void j(int i6, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(1)
        public void j(qv<Bitmap> qvVar) {
            View view = this.f25674j.get();
            if (!com.bytedance.sdk.component.adexpress.r.j()) {
                DynamicRootView dynamicRootView = this.xt.get();
                if (dynamicRootView == null) {
                    return;
                }
                if ("open_ad".equals(dynamicRootView.getRenderRequest().m()) || "splash_ad".equals(dynamicRootView.getRenderRequest().m())) {
                    view.setBackground(new BitmapDrawable(qvVar.cw()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(qvVar.cw()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(qvVar.cw()));
            com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar = this.cw;
            if (tlVar == null || tlVar.oq() == null || 6 != this.cw.oq().j() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }

        public j(View view, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
            this.f25674j = new WeakReference<>(view);
            this.xt = new WeakReference<>(dynamicRootView);
            this.cw = tlVar;
        }
    }

    private static class xt implements av<Bitmap> {

        /* renamed from: j, reason: collision with root package name */
        private final WeakReference<View> f25675j;
        private final WeakReference<DynamicBaseWidget> xt;

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(2)
        public void j(int i6, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(1)
        public void j(qv<Bitmap> qvVar) {
            Bitmap cw;
            DynamicBaseWidget dynamicBaseWidget;
            View view = this.f25675j.get();
            if (view == null || (cw = qvVar.cw()) == null || qvVar.r() == null || (dynamicBaseWidget = this.xt.get()) == null) {
                return;
            }
            view.setBackground(dynamicBaseWidget.j(cw));
        }

        public xt(View view, DynamicBaseWidget dynamicBaseWidget) {
            this.f25675j = new WeakReference<>(view);
            this.xt = new WeakReference<>(dynamicBaseWidget);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable xt(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                if (jSONArray.getString(i6).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i6));
                } else if (jSONArray.getString(i6).endsWith("deg")) {
                    str2 = jSONArray.getString(i6);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                iArr[i7] = ae.j(((String) arrayList.get(i7)).substring(0, 7));
            }
            GradientDrawable j6 = j(j(str2), iArr);
            j6.setShape(0);
            j6.setCornerRadius(com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.az()));
            return j6;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void g() {
        if (this.tj) {
            int hl = this.vl.hl();
            int b6 = this.vl.b();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.6
                @Override // java.lang.Runnable
                public void run() {
                    DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.ws;
                    if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.mi = new InteractViewContainer(dynamicBaseWidgetImp2.qv, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.vl);
                    } else {
                        jy renderRequest = DynamicBaseWidgetImp.this.ws.getRenderRequest();
                        oq oqVar = new oq();
                        oqVar.j(renderRequest.w());
                        oqVar.xt(renderRequest.mi());
                        oqVar.cw(renderRequest.kt());
                        oqVar.j(renderRequest.tj());
                        oqVar.xt(renderRequest.f());
                        oqVar.cw(renderRequest.v());
                        oqVar.r(renderRequest.x());
                        oqVar.up(renderRequest.ch());
                        DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp3.mi = new InteractViewContainer(dynamicBaseWidgetImp4.qv, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.vl, oqVar, renderRequest);
                    }
                    DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp5.xt(dynamicBaseWidgetImp5.mi);
                    if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                    }
                    DynamicBaseWidgetImp.this.setClipChildren(false);
                    DynamicBaseWidgetImp.this.mi.setTag(2);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp6.j((ViewGroup) dynamicBaseWidgetImp6);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp7 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp7.addView(dynamicBaseWidgetImp7.mi, new FrameLayout.LayoutParams(-1, -1));
                    DynamicBaseWidgetImp.this.mi.cw();
                }
            };
            this.f25665j = runnable;
            postDelayed(runnable, hl * 1000);
            if (this.vl.e() || b6 >= Integer.MAX_VALUE || hl >= b6) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.7
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                    if (dynamicBaseWidgetImp.mi != null) {
                        dynamicBaseWidgetImp.tj = false;
                        DynamicBaseWidgetImp.this.mi.r();
                        DynamicBaseWidgetImp.this.mi.setVisibility(4);
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp2.removeView(dynamicBaseWidgetImp2.mi);
                    }
                }
            };
            this.xt = runnable2;
            postDelayed(runnable2, b6 * 1000);
        }
    }

    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.ae, this.tl);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View view = this.az;
        if (view == null) {
            view = this;
        }
        double kt2 = this.jy.oq().up().kt();
        if (kt2 < 90.0d && kt2 > 0.0d) {
            com.bytedance.sdk.component.utils.tl.xt().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (kt2 * 1000.0d));
        }
        j(this.jy.oq().up().mi(), view);
        if (!TextUtils.isEmpty(this.vl.nd())) {
            g();
        }
        super.onAttachedToWindow();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        Drawable backgroundDrawable;
        DynamicRootView dynamicRootView;
        JSONObject optJSONObject;
        final View view = this.az;
        if (view == null) {
            view = this;
        }
        setContentDescription(this.jy.j(this.vl.a()));
        String im = this.vl.im();
        String str = null;
        String j6 = (TextUtils.isEmpty(im) || (dynamicRootView = this.ws) == null || dynamicRootView.getRenderRequest() == null || this.ws.getRenderRequest().up() == null || (optJSONObject = this.ws.getRenderRequest().up().optJSONObject("creative")) == null) ? null : j(optJSONObject.opt(im));
        if (TextUtils.isEmpty(j6)) {
            j6 = this.vl.tj();
        }
        if (this.vl.kt()) {
            com.bytedance.sdk.component.adexpress.j.j.j.j().up().j(this.vl.xt).cw(2).j(new cw(this.qv, this.vl.mi())).j(new xt(view, this));
        } else if (!TextUtils.isEmpty(j6)) {
            if (!j6.startsWith("http:") && !j6.startsWith("https:")) {
                DynamicRootView dynamicRootView2 = this.ws;
                if (dynamicRootView2 != null && dynamicRootView2.getRenderRequest() != null) {
                    str = this.ws.getRenderRequest().a();
                }
                j6 = g.xt(j6, str);
            }
            com.bytedance.sdk.component.m.oq cw2 = com.bytedance.sdk.component.adexpress.j.j.j.j().up().j(j6).cw(2);
            j(cw2);
            if (com.bytedance.sdk.component.adexpress.r.j()) {
                cw2.j(new j(view, this.ws, this.jy));
            } else if ((view instanceof FrameLayout) && TextUtils.equals(this.jy.oq().getType(), "vessel")) {
                if (com.bytedance.sdk.component.adexpress.r.oq.xt(j6)) {
                    this.f25664f = new GifView(this.qv);
                } else {
                    this.f25664f = new ImageView(this.qv);
                }
                ((FrameLayout) view).addView(this.f25664f, new FrameLayout.LayoutParams(-1, -1));
                cw2.cw(3).j(new av() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.1
                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(2)
                    public void j(int i6, String str2, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(1)
                    public void j(qv qvVar) {
                        Object cw3 = qvVar.cw();
                        if (cw3 instanceof byte[]) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            m.xt(DynamicBaseWidgetImp.this.f25664f, (byte[]) cw3, dynamicBaseWidgetImp.ae, dynamicBaseWidgetImp.tl);
                        }
                    }
                }, 4);
            } else {
                j(cw2, view);
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.vl.p() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.vl.wq() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable xt2 = dynamicBaseWidgetImp.xt(dynamicBaseWidgetImp.ws.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.vl.wq())));
                            if (xt2 == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                xt2 = dynamicBaseWidgetImp2.j(true, dynamicBaseWidgetImp2.ws.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.vl.wq())));
                            }
                            if (xt2 != null) {
                                view.setBackground(xt2);
                                return;
                            }
                            View view2 = view;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view2.setBackground(dynamicBaseWidgetImp3.j(true, dynamicBaseWidgetImp3.ws.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.vl.p() * 1000.0d));
        }
        View view2 = this.az;
        if (view2 != null) {
            view2.setPadding((int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.cw()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.xt()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.r()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.j()));
        }
        if (this.av || this.vl.ws() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        super(context, dynamicRootView, tlVar);
        this.tj = true;
        setTag(Integer.valueOf(getClickArea()));
        String type = tlVar.oq().getType();
        if ("logo-union".equals(type)) {
            dynamicRootView.setLogoUnionHeight(this.tl - ((int) com.bytedance.sdk.component.adexpress.r.tl.j(context, this.vl.xt() + this.vl.j())));
        } else if ("scoreCountWithIcon".equals(type)) {
            dynamicRootView.setScoreCountWithIcon(this.tl - ((int) com.bytedance.sdk.component.adexpress.r.tl.j(context, this.vl.xt() + this.vl.j())));
        }
    }

    private static String getBuildModel() {
        try {
            kt = x.j();
        } catch (Throwable unused) {
            kt = Build.MODEL;
        }
        if (TextUtils.isEmpty(kt)) {
            kt = Build.MODEL;
        }
        return kt;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.f25665j);
            removeCallbacks(this.xt);
        } catch (Exception unused) {
        }
    }

    private String j(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return j(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return j((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void j(com.bytedance.sdk.component.m.oq oqVar, final View view) {
        oqVar.j(new av<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.3
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i6, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv<Bitmap> qvVar) {
                DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.ws;
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().m()) && !"splash_ad".equals(DynamicBaseWidgetImp.this.ws.getRenderRequest().m())) {
                    view.setBackground(new BitmapDrawable(qvVar.cw()));
                } else {
                    if (!com.bytedance.sdk.component.adexpress.r.j()) {
                        view.setBackground(new BitmapDrawable(qvVar.cw()));
                        return;
                    }
                    view.setBackground(new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.j(qvVar.cw(), ((DynamicRoot) DynamicBaseWidgetImp.this.ws.getChildAt(0)).f25688j));
                }
            }
        });
    }

    private static void j(com.bytedance.sdk.component.m.oq oqVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            oqVar.j(Bitmap.Config.ARGB_8888);
        }
    }

    private void j(double d6, final View view) {
        if (d6 > 0.0d) {
            com.bytedance.sdk.component.utils.tl.xt().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.jy.oq().up().qe() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    DynamicBaseWidgetImp.this.setVisibility(0);
                }
            }, (long) (d6 * 1000.0d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            if (viewGroup.getChildAt(i6) instanceof InteractViewContainer) {
                viewGroup.removeViewAt(i6);
            }
        }
    }
}
