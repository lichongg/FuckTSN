package com.bytedance.sdk.openadsdk.core.component.reward.view.ugen;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.adsdk.ugeno.xt.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.ae.up;
import com.bytedance.sdk.openadsdk.core.ugeno.m.j;
import com.bytedance.sdk.openadsdk.core.xt.xt;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class UgenBanner extends FrameLayout {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private az f28478j;

    /* renamed from: m, reason: collision with root package name */
    private int f28479m;

    /* renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f28480r;
    private WeakReference<ObjectAnimator> up;
    private View xt;

    public void setTopMargin(int i6) {
        this.f28479m = i6;
    }

    public void xt() {
        View view = this.xt;
        if (view == null || this.cw) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        layoutParams.topMargin = this.f28479m;
        addView(this.xt, layoutParams);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xt, "translationY", -400.0f, 0.0f);
        ofFloat.setDuration(600L);
        ofFloat.start();
        this.up = new WeakReference<>(ofFloat);
    }

    public UgenBanner(Context context) {
        super(context);
        this.f28480r = new AtomicBoolean(false);
    }

    public void j(n nVar, xt xtVar) {
        if (nVar.by() == null || TextUtils.isEmpty(nVar.by().cw())) {
            return;
        }
        j(kt.vl(nVar), nVar, xtVar, nVar.by().cw(), nVar.hw(), TextUtils.isEmpty(nVar.sf()) ? "立即下载" : nVar.sf(), false);
    }

    public void j(j jVar, final n nVar, final xt xtVar, final String str, final String str2, final String str3, final boolean z5) {
        if (jVar == null || this.f28480r.getAndSet(true) || nVar.ig() == null || TextUtils.isEmpty(nVar.ig().j())) {
            return;
        }
        up.j(jVar, new up.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.up.j
            public void j(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("icon", nVar.ig().j());
                    jSONObject2.put("app_name", str);
                    jSONObject2.put("title", str2);
                    jSONObject2.put("button_text", str3);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                UgenBanner ugenBanner = UgenBanner.this;
                ugenBanner.xt = ugenBanner.j(jSONObject, jSONObject2, new w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1.1
                    @Override // com.bytedance.adsdk.ugeno.cw.w
                    public void j(cw cwVar, String str4, m.j jVar2) {
                    }

                    @Override // com.bytedance.adsdk.ugeno.cw.w
                    public void j(av avVar, w.xt xtVar2, w.j jVar2) {
                        if (avVar.cw() != null && "banner_click".equals(avVar.cw().optString("type"))) {
                            UgenBanner.this.xt.setTag(2114387600, Boolean.TRUE);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            xtVar.j(UgenBanner.this.xt, null);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            if (z5) {
                                UgenBanner.this.j();
                            }
                        }
                    }
                });
            }
        });
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.2
            @Override // java.lang.Runnable
            public void run() {
                UgenBanner.this.xt();
            }
        }, 3000L);
    }

    public void j() {
        ObjectAnimator objectAnimator;
        this.cw = true;
        View view = this.xt;
        if (view != null) {
            view.setVisibility(8);
        }
        WeakReference<ObjectAnimator> weakReference = this.up;
        if (weakReference == null || (objectAnimator = weakReference.get()) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View j(JSONObject jSONObject, JSONObject jSONObject2, w wVar) {
        az azVar = new az(getContext());
        this.f28478j = azVar;
        cw<View> j6 = azVar.j(jSONObject);
        this.f28478j.j(wVar);
        this.f28478j.xt(jSONObject2);
        if (j6 == null) {
            return null;
        }
        View g6 = j6.g();
        if (g6 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(j6.rn(), j6.wq());
            layoutParams.leftMargin = ed.cw(getContext(), 16.0f);
            layoutParams.rightMargin = ed.cw(getContext(), 16.0f);
            g6.setLayoutParams(layoutParams);
        }
        return g6;
    }
}
