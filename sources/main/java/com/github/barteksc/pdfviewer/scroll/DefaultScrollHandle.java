package com.github.barteksc.pdfviewer.scroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.R;
import com.github.barteksc.pdfviewer.util.Util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class DefaultScrollHandle extends RelativeLayout implements ScrollHandle {
    private static final int DEFAULT_TEXT_SIZE = 16;
    private static final int HANDLE_LONG = 65;
    private static final int HANDLE_SHORT = 40;
    protected Context context;
    private float currentPos;
    private Handler handler;
    private Runnable hidePageScrollerRunnable;
    private boolean inverted;
    private PDFView pdfView;
    private float relativeHandlerMiddle;
    protected TextView textView;

    public DefaultScrollHandle(Context context) {
        this(context, false);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void hide() {
        setVisibility(4);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void show() {
        setVisibility(0);
    }

    public DefaultScrollHandle(Context context, boolean z5) {
        super(context);
        this.relativeHandlerMiddle = 0.0f;
        this.handler = new Handler();
        this.hidePageScrollerRunnable = new Runnable() { // from class: com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultScrollHandle.this.hide();
            }
        };
        this.context = context;
        this.inverted = z5;
        this.textView = new TextView(context);
        setVisibility(4);
        setTextColor(ViewCompat.MEASURED_STATE_MASK);
        setTextSize(16);
    }

    private void calculateMiddle() {
        float x5;
        float width;
        int width2;
        if (this.pdfView.isSwipeVertical()) {
            x5 = getY();
            width = getHeight();
            width2 = this.pdfView.getHeight();
        } else {
            x5 = getX();
            width = getWidth();
            width2 = this.pdfView.getWidth();
        }
        this.relativeHandlerMiddle = ((x5 + this.relativeHandlerMiddle) / width2) * width;
    }

    private boolean isPDFViewReady() {
        PDFView pDFView = this.pdfView;
        return (pDFView == null || pDFView.getPageCount() <= 0 || this.pdfView.documentFitsView()) ? false : true;
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void destroyLayout() {
        this.pdfView.removeView(this);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void hideDelayed() {
        this.handler.postDelayed(this.hidePageScrollerRunnable, 1000L);
    }

    public void setTextColor(int i6) {
        this.textView.setTextColor(i6);
    }

    public void setTextSize(int i6) {
        this.textView.setTextSize(1, i6);
    }

    private void setPosition(float f6) {
        int width;
        if (!Float.isInfinite(f6) && !Float.isNaN(f6)) {
            if (this.pdfView.isSwipeVertical()) {
                width = this.pdfView.getHeight();
            } else {
                width = this.pdfView.getWidth();
            }
            float f7 = width;
            float f8 = f6 - this.relativeHandlerMiddle;
            if (f8 < 0.0f) {
                f8 = 0.0f;
            } else if (f8 > f7 - Util.getDP(this.context, 40)) {
                f8 = f7 - Util.getDP(this.context, 40);
            }
            if (this.pdfView.isSwipeVertical()) {
                setY(f8);
            } else {
                setX(f8);
            }
            calculateMiddle();
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.isPDFViewReady()
            if (r0 != 0) goto Lb
            boolean r5 = super.onTouchEvent(r5)
            return r5
        Lb:
            int r0 = r5.getAction()
            r1 = 1
            if (r0 == 0) goto L2e
            if (r0 == r1) goto L25
            r2 = 2
            if (r0 == r2) goto L59
            r2 = 3
            if (r0 == r2) goto L25
            r2 = 5
            if (r0 == r2) goto L2e
            r2 = 6
            if (r0 == r2) goto L25
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L25:
            r4.hideDelayed()
            com.github.barteksc.pdfviewer.PDFView r5 = r4.pdfView
            r5.performPageSnap()
            return r1
        L2e:
            com.github.barteksc.pdfviewer.PDFView r0 = r4.pdfView
            r0.stopFling()
            android.os.Handler r0 = r4.handler
            java.lang.Runnable r2 = r4.hidePageScrollerRunnable
            r0.removeCallbacks(r2)
            com.github.barteksc.pdfviewer.PDFView r0 = r4.pdfView
            boolean r0 = r0.isSwipeVertical()
            if (r0 == 0) goto L4e
            float r0 = r5.getRawY()
            float r2 = r4.getY()
            float r0 = r0 - r2
            r4.currentPos = r0
            goto L59
        L4e:
            float r0 = r5.getRawX()
            float r2 = r4.getX()
            float r0 = r0 - r2
            r4.currentPos = r0
        L59:
            com.github.barteksc.pdfviewer.PDFView r0 = r4.pdfView
            boolean r0 = r0.isSwipeVertical()
            r2 = 0
            if (r0 == 0) goto L7d
            float r5 = r5.getRawY()
            float r0 = r4.currentPos
            float r5 = r5 - r0
            float r0 = r4.relativeHandlerMiddle
            float r5 = r5 + r0
            r4.setPosition(r5)
            com.github.barteksc.pdfviewer.PDFView r5 = r4.pdfView
            float r0 = r4.relativeHandlerMiddle
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            r5.setPositionOffset(r0, r2)
            goto L97
        L7d:
            float r5 = r5.getRawX()
            float r0 = r4.currentPos
            float r5 = r5 - r0
            float r0 = r4.relativeHandlerMiddle
            float r5 = r5 + r0
            r4.setPosition(r5)
            com.github.barteksc.pdfviewer.PDFView r5 = r4.pdfView
            float r0 = r4.relativeHandlerMiddle
            int r3 = r4.getWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            r5.setPositionOffset(r0, r2)
        L97:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setPageNum(int i6) {
        String valueOf = String.valueOf(i6);
        if (!this.textView.getText().equals(valueOf)) {
            this.textView.setText(valueOf);
        }
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setScroll(float f6) {
        int width;
        if (!shown()) {
            show();
        } else {
            this.handler.removeCallbacks(this.hidePageScrollerRunnable);
        }
        PDFView pDFView = this.pdfView;
        if (pDFView != null) {
            if (pDFView.isSwipeVertical()) {
                width = this.pdfView.getHeight();
            } else {
                width = this.pdfView.getWidth();
            }
            setPosition(width * f6);
        }
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setupLayout(PDFView pDFView) {
        Drawable drawable;
        int i6;
        int i7 = 40;
        int i8 = 65;
        if (pDFView.isSwipeVertical()) {
            if (this.inverted) {
                drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_left);
                i6 = 9;
            } else {
                drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_right);
                i6 = 11;
            }
            i7 = 65;
            i8 = 40;
        } else if (this.inverted) {
            drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_top);
            i6 = 10;
        } else {
            drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_bottom);
            i6 = 12;
        }
        setBackground(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.getDP(this.context, i7), Util.getDP(this.context, i8));
        layoutParams.setMargins(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        addView(this.textView, layoutParams2);
        layoutParams.addRule(i6);
        pDFView.addView(this, layoutParams);
        this.pdfView = pDFView;
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public boolean shown() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
