package com.github.barteksc.pdfviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class AnimationManager {
    private ValueAnimator animation;
    private boolean flinging = false;
    private boolean pageFlinging = false;
    private PDFView pdfView;
    private OverScroller scroller;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class XAnimation extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        XAnimation() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.pageFlinging = false;
            AnimationManager.this.hideHandle();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.pageFlinging = false;
            AnimationManager.this.hideHandle();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.pdfView.moveTo(((Float) valueAnimator.getAnimatedValue()).floatValue(), AnimationManager.this.pdfView.getCurrentYOffset());
            AnimationManager.this.pdfView.loadPageByOffset();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class YAnimation extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        YAnimation() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.pageFlinging = false;
            AnimationManager.this.hideHandle();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.pageFlinging = false;
            AnimationManager.this.hideHandle();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.pdfView.moveTo(AnimationManager.this.pdfView.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
            AnimationManager.this.pdfView.loadPageByOffset();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class ZoomAnimation implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
        private final float centerX;
        private final float centerY;

        public ZoomAnimation(float f6, float f7) {
            this.centerX = f6;
            this.centerY = f7;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.hideHandle();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.pdfView.performPageSnap();
            AnimationManager.this.hideHandle();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.pdfView.zoomCenteredTo(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF(this.centerX, this.centerY));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public void stopFling() {
        this.flinging = false;
        this.scroller.forceFinished(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideHandle() {
        if (this.pdfView.getScrollHandle() != null) {
            this.pdfView.getScrollHandle().hideDelayed();
        }
    }

    void computeFling() {
        if (this.scroller.computeScrollOffset()) {
            this.pdfView.moveTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            this.pdfView.loadPageByOffset();
        } else if (this.flinging) {
            this.flinging = false;
            this.pdfView.loadPages();
            hideHandle();
            this.pdfView.performPageSnap();
        }
    }

    public boolean isFlinging() {
        return this.flinging || this.pageFlinging;
    }

    public void startPageFlingAnimation(float f6) {
        if (this.pdfView.isSwipeVertical()) {
            startYAnimation(this.pdfView.getCurrentYOffset(), f6);
        } else {
            startXAnimation(this.pdfView.getCurrentXOffset(), f6);
        }
        this.pageFlinging = true;
    }

    public void stopAll() {
        ValueAnimator valueAnimator = this.animation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.animation = null;
        }
        stopFling();
    }

    public AnimationManager(PDFView pDFView) {
        this.pdfView = pDFView;
        this.scroller = new OverScroller(pDFView.getContext());
    }

    public void startFlingAnimation(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        stopAll();
        this.flinging = true;
        this.scroller.fling(i6, i7, i8, i9, i10, i11, i12, i13);
    }

    public void startXAnimation(float f6, float f7) {
        stopAll();
        this.animation = ValueAnimator.ofFloat(f6, f7);
        XAnimation xAnimation = new XAnimation();
        this.animation.setInterpolator(new DecelerateInterpolator());
        this.animation.addUpdateListener(xAnimation);
        this.animation.addListener(xAnimation);
        this.animation.setDuration(400L);
        this.animation.start();
    }

    public void startYAnimation(float f6, float f7) {
        stopAll();
        this.animation = ValueAnimator.ofFloat(f6, f7);
        YAnimation yAnimation = new YAnimation();
        this.animation.setInterpolator(new DecelerateInterpolator());
        this.animation.addUpdateListener(yAnimation);
        this.animation.addListener(yAnimation);
        this.animation.setDuration(400L);
        this.animation.start();
    }

    public void startZoomAnimation(float f6, float f7, float f8, float f9) {
        stopAll();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f8, f9);
        this.animation = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ZoomAnimation zoomAnimation = new ZoomAnimation(f6, f7);
        this.animation.addUpdateListener(zoomAnimation);
        this.animation.addListener(zoomAnimation);
        this.animation.setDuration(400L);
        this.animation.start();
    }
}
