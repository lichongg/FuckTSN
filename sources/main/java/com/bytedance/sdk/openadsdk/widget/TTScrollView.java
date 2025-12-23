package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTScrollView extends ScrollView {
    private j cw;

    /* renamed from: j, reason: collision with root package name */
    private int f31982j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f31983r;
    private boolean xt;

    public interface j {
        void j(boolean z5);
    }

    public boolean j() {
        return this.f31983r;
    }

    public void setListener(j jVar) {
        this.cw = jVar;
    }

    public TTScrollView(Context context) {
        super(context);
        this.xt = false;
        this.f31983r = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (!this.xt) {
            try {
                this.xt = true;
                View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.height = getHeight();
                childAt.setLayoutParams(layoutParams);
            } catch (Throwable th) {
                vl.r("TTScrollView", "onLayout error" + th.toString());
            }
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i6, int i7, boolean z5, boolean z6) {
        super.onOverScrolled(i6, i7, z5, z6);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f31982j = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.f31982j);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (getScrollY() == 0) goto L15;
     */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 1
            if (r0 != r1) goto L46
            int r0 = r4.getScrollY()
            int r2 = r4.f31982j
            if (r0 >= r2) goto L46
            int r0 = r4.getScrollY()
            int r2 = r4.f31982j
            int r2 = r2 / 2
            r3 = 0
            if (r0 <= r2) goto L24
            com.bytedance.sdk.openadsdk.widget.TTScrollView$1 r0 = new com.bytedance.sdk.openadsdk.widget.TTScrollView$1
            r0.<init>()
            r4.post(r0)
        L22:
            r1 = 0
            goto L39
        L24:
            int r0 = r4.getScrollY()
            if (r0 <= 0) goto L33
            com.bytedance.sdk.openadsdk.widget.TTScrollView$2 r0 = new com.bytedance.sdk.openadsdk.widget.TTScrollView$2
            r0.<init>()
            r4.post(r0)
            goto L39
        L33:
            int r0 = r4.getScrollY()
            if (r0 != 0) goto L22
        L39:
            com.bytedance.sdk.openadsdk.widget.TTScrollView$j r0 = r4.cw
            if (r0 == 0) goto L44
            boolean r2 = r4.f31983r
            if (r1 == r2) goto L44
            r0.j(r1)
        L44:
            r4.f31983r = r1
        L46:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.widget.TTScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
