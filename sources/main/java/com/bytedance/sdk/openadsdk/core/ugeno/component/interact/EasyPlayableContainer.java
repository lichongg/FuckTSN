package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.av;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class EasyPlayableContainer extends FrameLayout {
    private final n cw;

    /* renamed from: j, reason: collision with root package name */
    private final ae f30577j;
    private final av xt;

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.xt == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        float r5 = ed.r(getContext(), motionEvent.getX());
        float r6 = ed.r(getContext(), motionEvent.getY());
        if (this.xt.j(r5, r6)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            com.bytedance.sdk.openadsdk.core.f.xt.j(this.cw, r5, r6, 1);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.xt == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.xt.j(ed.r(getContext(), motionEvent.getX()), ed.r(getContext(), motionEvent.getY()))) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public EasyPlayableContainer(@NonNull Context context, ae aeVar, av avVar, n nVar) {
        super(context);
        this.f30577j = aeVar;
        this.xt = avVar;
        this.cw = nVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ae aeVar = this.f30577j;
        if (aeVar != null) {
            aeVar.xt();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ae aeVar = this.f30577j;
        if (aeVar != null) {
            aeVar.cw();
        }
    }
}
