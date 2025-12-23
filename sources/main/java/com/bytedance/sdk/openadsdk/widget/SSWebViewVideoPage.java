package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.bytedance.sdk.component.widget.SSWebView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SSWebViewVideoPage extends SSWebView {
    private boolean ae;

    /* renamed from: m, reason: collision with root package name */
    private float f31966m;
    private ViewParent tl;
    private boolean up;

    public void ae() {
        if (this.ae) {
            return;
        }
        this.tl.requestDisallowInterceptTouchEvent(false);
        this.ae = true;
    }

    public void j(boolean z5) {
        if (((ScrollView) this.tl).getScrollY() == 0) {
            if (z5) {
                m();
                return;
            } else {
                ae();
                return;
            }
        }
        if (!this.up) {
            m();
        } else if (z5) {
            ae();
        } else {
            m();
        }
    }

    public void m() {
        if (this.ae) {
            return;
        }
        this.tl.requestDisallowInterceptTouchEvent(true);
        this.ae = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.tl == null) {
            this.tl = j((View) this);
        }
        if (motionEvent.getAction() == 0) {
            this.f31966m = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y5 = motionEvent.getY() - this.f31966m;
            if (y5 > 0.0f) {
                j(true);
            } else if (y5 != 0.0f && y5 < 0.0f) {
                j(false);
            }
            this.f31966m = motionEvent.getY();
        } else if (motionEvent.getAction() == 1) {
            m();
            this.ae = false;
        } else if (motionEvent.getAction() == 3) {
            m();
            this.ae = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.up = true;
        this.f31966m = -1.0f;
        this.ae = false;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i6, int i7, boolean z5, boolean z6) {
        super.onOverScrolled(i6, i7, z5, z6);
        if (i7 == 0 && z6) {
            this.up = true;
        } else {
            this.up = false;
        }
    }
}
