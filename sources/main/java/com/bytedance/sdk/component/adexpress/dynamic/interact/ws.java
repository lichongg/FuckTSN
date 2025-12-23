package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws implements ae<ShakeAnimationView>, az {
    private com.bytedance.sdk.component.adexpress.dynamic.cw.oq ae;
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    public int f25765j;

    /* renamed from: m, reason: collision with root package name */
    private String f25766m;

    /* renamed from: r, reason: collision with root package name */
    private DynamicBaseWidget f25767r;
    private boolean tl;
    private com.bytedance.sdk.component.adexpress.dynamic.cw.ae up;
    private ShakeAnimationView xt;

    private void m() {
        final com.bytedance.sdk.component.adexpress.dynamic.up.j dynamicClickListener = this.f25767r.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 1);
            dynamicClickListener.j(jSONObject);
        } catch (Throwable unused) {
        }
        if (Constants.VIA_REPORT_TYPE_START_WAP.equals(this.f25766m)) {
            Context context = this.cw;
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(context, com.bytedance.sdk.component.adexpress.cw.j.tl(context), this.ae, this.tl, this.f25765j);
            this.xt = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.xt.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.cw;
            this.xt = new ShakeAnimationView(context2, com.bytedance.sdk.component.adexpress.cw.j.ae(context2), this.ae, this.tl, this.f25765j);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.xt.setGravity(17);
        layoutParams.gravity = 17;
        this.xt.setLayoutParams(layoutParams);
        this.xt.setTranslationY(com.bytedance.sdk.component.adexpress.r.tl.j(this.cw, this.up.aq()));
        this.xt.setShakeText(this.up.q());
        this.xt.setClipChildren(false);
        this.xt.setOnShakeViewListener(new ShakeAnimationView.j() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.ws.1
            @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.j
            public void j(boolean z5) {
                com.bytedance.sdk.component.adexpress.dynamic.up.j jVar = dynamicClickListener;
                if (jVar != null) {
                    jVar.j(z5, ws.this);
                }
                ws.this.xt.setOnClickListener((View.OnClickListener) dynamicClickListener);
                ws.this.xt.performClick();
                if (ws.this.up == null || !ws.this.up.sm()) {
                    return;
                }
                ws.this.xt.setOnClickListener(null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        this.xt.j();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public ShakeAnimationView cw() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.az
    public void up() {
        if (this.xt.getParent() != null) {
            ((ViewGroup) this.xt.getParent()).setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        this.xt.clearAnimation();
    }

    public ws(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar, String str, com.bytedance.sdk.component.adexpress.dynamic.cw.oq oqVar, boolean z5, int i6) {
        this.cw = context;
        this.f25767r = dynamicBaseWidget;
        this.up = aeVar;
        this.f25766m = str;
        this.ae = oqVar;
        this.tl = z5;
        this.f25765j = i6;
        m();
    }
}
