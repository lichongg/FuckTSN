package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.components.core.t.d;
import com.kwad.sdk.core.webview.KsAdWebView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SplitScrollWebView extends KsAdWebView {
    private int UZ;
    private boolean VA;
    private boolean Vx;
    private a Vy;
    private float Vz;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void f(float f6);

        boolean rL();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Vx = false;
        rF();
    }

    private void rF() {
        this.UZ = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        if (this.UZ != 0) {
            i7 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.c.a.a.g((Activity) getContext()) : com.kwad.sdk.c.a.a.getScreenHeight(getContext())) - (d.tc() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0)) - this.UZ, 1073741824);
        }
        super.onMeasure(i6, i7);
    }

    public void setDisableAnimation(boolean z5) {
        this.Vx = z5;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.Vy = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if (r1 != 3) goto L31;
     */
    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r6)
            boolean r1 = r5.Vx
            if (r1 == 0) goto Ld
            boolean r6 = super.onTouchEvent(r0)
            return r6
        Ld:
            int r1 = androidx.core.view.MotionEventCompat.getActionMasked(r6)
            float r2 = r6.getY()
            r3 = 0
            if (r1 == 0) goto L51
            r6 = 1
            if (r1 == r6) goto L38
            r4 = 2
            if (r1 == r4) goto L22
            r0 = 3
            if (r1 == r0) goto L38
            goto L50
        L22:
            float r1 = r5.Vz
            float r3 = r1 - r2
            com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView$a r4 = r5.Vy
            if (r4 == 0) goto L33
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 > 0) goto L33
            r5.VA = r6
            r4.f(r3)
        L33:
            boolean r6 = super.onTouchEvent(r0)
            return r6
        L38:
            com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView$a r0 = r5.Vy
            if (r0 == 0) goto L50
            float r1 = r5.Vz
            float r1 = r1 - r2
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L48
            boolean r1 = r5.VA
            if (r1 == 0) goto L50
        L48:
            boolean r0 = r0.rL()
            if (r0 == 0) goto L50
            r5.Vx = r6
        L50:
            return r3
        L51:
            r5.Vz = r2
            r5.VA = r3
            boolean r6 = super.onTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Vx = false;
        rF();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.Vx = false;
        rF();
    }
}
