package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.adexpress.dynamic.interact.az;
import com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup;
import com.bytedance.sdk.component.adexpress.xt.qv;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicImageFlipSlide extends DynamicImageView {

    /* renamed from: j, reason: collision with root package name */
    private final ImageFlipSlideGroup f25676j;
    private final xt xt;

    private static class cw implements View.OnClickListener, View.OnTouchListener, com.bytedance.sdk.component.adexpress.dynamic.up.j {

        /* renamed from: j, reason: collision with root package name */
        com.bytedance.sdk.component.adexpress.dynamic.up.j f25678j;
        xt xt;

        @Override // com.bytedance.sdk.component.adexpress.dynamic.up.j
        public void j(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.up.j jVar = this.f25678j;
            if (jVar != null) {
                jVar.j(view);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            xt xtVar = this.xt;
            if (xtVar != null) {
                xtVar.j(new j() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.cw.1
                    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.j
                    public void j() {
                        com.bytedance.sdk.component.adexpress.dynamic.up.j jVar = cw.this.f25678j;
                        if (jVar instanceof View.OnClickListener) {
                            ((View.OnClickListener) jVar).onClick(view);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.component.adexpress.dynamic.up.j jVar = this.f25678j;
            if (jVar instanceof View.OnClickListener) {
                ((View.OnClickListener) jVar).onClick(view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.bytedance.sdk.component.adexpress.dynamic.up.j jVar = this.f25678j;
            if (jVar instanceof View.OnTouchListener) {
                return ((View.OnTouchListener) jVar).onTouch(view, motionEvent);
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.up.j
        public void xt(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.up.j jVar = this.f25678j;
            if (jVar != null) {
                jVar.xt(view);
            }
        }

        public cw(com.bytedance.sdk.component.adexpress.dynamic.up.j jVar, xt xtVar) {
            this.f25678j = jVar;
            this.xt = xtVar;
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.up.j
        public void j(qv qvVar) {
            com.bytedance.sdk.component.adexpress.dynamic.up.j jVar = this.f25678j;
            if (jVar != null) {
                jVar.j(qvVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.up.j
        public void j(boolean z5, az azVar) {
            com.bytedance.sdk.component.adexpress.dynamic.up.j jVar = this.f25678j;
            if (jVar != null) {
                jVar.j(z5, azVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.up.j
        public void j(JSONObject jSONObject) {
            com.bytedance.sdk.component.adexpress.dynamic.up.j jVar = this.f25678j;
            if (jVar != null) {
                jVar.j(jSONObject);
            }
        }
    }

    public interface j {
        void j();
    }

    private interface xt {
        void j(j jVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public com.bytedance.sdk.component.adexpress.dynamic.up.j getDynamicClickListener() {
        com.bytedance.sdk.component.adexpress.dynamic.up.j dynamicClickListener = this.ws.getDynamicClickListener();
        return this.vl.uc() ? new cw(dynamicClickListener, this.xt) : dynamicClickListener;
    }

    public DynamicImageFlipSlide(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        this.xt = new xt() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.1
            @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.xt
            public void j(j jVar) {
                if (DynamicImageFlipSlide.this.f25676j != null) {
                    DynamicImageFlipSlide.this.f25676j.j(jVar);
                }
            }
        };
        ImageFlipSlideGroup imageFlipSlideGroup = new ImageFlipSlideGroup(getContext(), TextUtils.equals(getDynamicLayoutBrickValue().yb(), "slide"));
        this.f25676j = imageFlipSlideGroup;
        addView(imageFlipSlideGroup, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f25676j.j();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f25676j.xt();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        this.f25676j.j(this.vl.qv(), xt(this.vl.qv()));
        this.f25676j.xt(this.vl.y(), xt(this.vl.y()));
        this.f25676j.setFilterColors(this.vl.nt());
        this.f25676j.cw();
        return true;
    }
}
