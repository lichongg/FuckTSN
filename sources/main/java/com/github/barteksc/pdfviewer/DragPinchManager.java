package com.github.barteksc.pdfviewer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.github.barteksc.pdfviewer.model.LinkTapEvent;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import com.github.barteksc.pdfviewer.util.Constants;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.SizeF;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class DragPinchManager implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {
    private AnimationManager animationManager;
    private GestureDetector gestureDetector;
    private PDFView pdfView;
    private ScaleGestureDetector scaleGestureDetector;
    private boolean scrolling = false;
    private boolean scaling = false;
    private boolean enabled = false;

    void disable() {
        this.enabled = false;
    }

    void enable() {
        this.enabled = true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.scaling = true;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        this.scrolling = true;
        if (this.pdfView.isZooming() || this.pdfView.isSwipeEnabled()) {
            this.pdfView.moveRelativeTo(-f6, -f7);
        }
        if (!this.scaling || this.pdfView.doRenderDuringScale()) {
            this.pdfView.loadPageByOffset();
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    private boolean checkLinkTapped(float f6, float f7) {
        int secondaryPageOffset;
        int pageOffset;
        PDFView pDFView = this.pdfView;
        PdfFile pdfFile = pDFView.pdfFile;
        if (pdfFile == null) {
            return false;
        }
        float f8 = (-pDFView.getCurrentXOffset()) + f6;
        float f9 = (-this.pdfView.getCurrentYOffset()) + f7;
        int pageAtOffset = pdfFile.getPageAtOffset(this.pdfView.isSwipeVertical() ? f9 : f8, this.pdfView.getZoom());
        SizeF scaledPageSize = pdfFile.getScaledPageSize(pageAtOffset, this.pdfView.getZoom());
        if (this.pdfView.isSwipeVertical()) {
            pageOffset = (int) pdfFile.getSecondaryPageOffset(pageAtOffset, this.pdfView.getZoom());
            secondaryPageOffset = (int) pdfFile.getPageOffset(pageAtOffset, this.pdfView.getZoom());
        } else {
            secondaryPageOffset = (int) pdfFile.getSecondaryPageOffset(pageAtOffset, this.pdfView.getZoom());
            pageOffset = (int) pdfFile.getPageOffset(pageAtOffset, this.pdfView.getZoom());
        }
        for (PdfDocument.Link link : pdfFile.getPageLinks(pageAtOffset)) {
            RectF mapRectToDevice = pdfFile.mapRectToDevice(pageAtOffset, pageOffset, secondaryPageOffset, (int) scaledPageSize.b(), (int) scaledPageSize.a(), link.a());
            mapRectToDevice.sort();
            if (mapRectToDevice.contains(f8, f9)) {
                this.pdfView.callbacks.callLinkHandler(new LinkTapEvent(f6, f7, f8, f9, mapRectToDevice, link));
                return true;
            }
        }
        return false;
    }

    private void hideHandle() {
        ScrollHandle scrollHandle = this.pdfView.getScrollHandle();
        if (scrollHandle == null || !scrollHandle.shown()) {
            return;
        }
        scrollHandle.hideDelayed();
    }

    private void onBoundedFling(float f6, float f7) {
        float f8;
        float f9;
        int currentXOffset = (int) this.pdfView.getCurrentXOffset();
        int currentYOffset = (int) this.pdfView.getCurrentYOffset();
        PDFView pDFView = this.pdfView;
        PdfFile pdfFile = pDFView.pdfFile;
        float f10 = -pdfFile.getPageOffset(pDFView.getCurrentPage(), this.pdfView.getZoom());
        float pageLength = f10 - pdfFile.getPageLength(this.pdfView.getCurrentPage(), this.pdfView.getZoom());
        float f11 = 0.0f;
        if (this.pdfView.isSwipeVertical()) {
            f9 = -(this.pdfView.toCurrentScale(pdfFile.getMaxPageWidth()) - this.pdfView.getWidth());
            f8 = pageLength + this.pdfView.getHeight();
            f11 = f10;
            f10 = 0.0f;
        } else {
            float width = pageLength + this.pdfView.getWidth();
            f8 = -(this.pdfView.toCurrentScale(pdfFile.getMaxPageHeight()) - this.pdfView.getHeight());
            f9 = width;
        }
        this.animationManager.startFlingAnimation(currentXOffset, currentYOffset, (int) f6, (int) f7, (int) f9, (int) f10, (int) f8, (int) f11);
    }

    private void onScrollEnd(MotionEvent motionEvent) {
        this.pdfView.loadPages();
        hideHandle();
        if (this.animationManager.isFlinging()) {
            return;
        }
        this.pdfView.performPageSnap();
    }

    void disableLongpress() {
        this.gestureDetector.setIsLongpressEnabled(false);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.pdfView.isDoubletapEnabled()) {
            return false;
        }
        if (this.pdfView.getZoom() < this.pdfView.getMidZoom()) {
            this.pdfView.zoomWithAnimation(motionEvent.getX(), motionEvent.getY(), this.pdfView.getMidZoom());
            return true;
        }
        if (this.pdfView.getZoom() < this.pdfView.getMaxZoom()) {
            this.pdfView.zoomWithAnimation(motionEvent.getX(), motionEvent.getY(), this.pdfView.getMaxZoom());
            return true;
        }
        this.pdfView.resetZoomWithAnimation();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.animationManager.stopFling();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        float f8;
        float currentScale;
        int height;
        if (!this.pdfView.isSwipeEnabled()) {
            return false;
        }
        if (this.pdfView.isPageFlingEnabled()) {
            if (this.pdfView.pageFillsScreen()) {
                onBoundedFling(f6, f7);
            } else {
                startPageFling(motionEvent, motionEvent2, f6, f7);
            }
            return true;
        }
        int currentXOffset = (int) this.pdfView.getCurrentXOffset();
        int currentYOffset = (int) this.pdfView.getCurrentYOffset();
        PDFView pDFView = this.pdfView;
        PdfFile pdfFile = pDFView.pdfFile;
        if (pDFView.isSwipeVertical()) {
            f8 = -(this.pdfView.toCurrentScale(pdfFile.getMaxPageWidth()) - this.pdfView.getWidth());
            currentScale = pdfFile.getDocLen(this.pdfView.getZoom());
            height = this.pdfView.getHeight();
        } else {
            f8 = -(pdfFile.getDocLen(this.pdfView.getZoom()) - this.pdfView.getWidth());
            currentScale = this.pdfView.toCurrentScale(pdfFile.getMaxPageHeight());
            height = this.pdfView.getHeight();
        }
        this.animationManager.startFlingAnimation(currentXOffset, currentYOffset, (int) f6, (int) f7, (int) f8, 0, (int) (-(currentScale - height)), 0);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.pdfView.callbacks.callOnLongPress(motionEvent);
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.pdfView.loadPages();
        hideHandle();
        this.scaling = false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        ScrollHandle scrollHandle;
        boolean callOnTap = this.pdfView.callbacks.callOnTap(motionEvent);
        boolean checkLinkTapped = checkLinkTapped(motionEvent.getX(), motionEvent.getY());
        if (!callOnTap && !checkLinkTapped && (scrollHandle = this.pdfView.getScrollHandle()) != null && !this.pdfView.documentFitsView()) {
            if (scrollHandle.shown()) {
                scrollHandle.hide();
            } else {
                scrollHandle.show();
            }
        }
        this.pdfView.performClick();
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.enabled) {
            return false;
        }
        boolean z5 = this.gestureDetector.onTouchEvent(motionEvent) || this.scaleGestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.scrolling) {
            this.scrolling = false;
            onScrollEnd(motionEvent);
        }
        return z5;
    }

    DragPinchManager(PDFView pDFView, AnimationManager animationManager) {
        this.pdfView = pDFView;
        this.animationManager = animationManager;
        this.gestureDetector = new GestureDetector(pDFView.getContext(), this);
        this.scaleGestureDetector = new ScaleGestureDetector(pDFView.getContext(), this);
        pDFView.setOnTouchListener(this);
    }

    private boolean checkDoPageFling(float f6, float f7) {
        float abs = Math.abs(f6);
        float abs2 = Math.abs(f7);
        if (this.pdfView.isSwipeVertical()) {
            if (abs2 <= abs) {
                return false;
            }
            return true;
        }
        if (abs <= abs2) {
            return false;
        }
        return true;
    }

    private void startPageFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        float x5;
        float x6;
        if (!checkDoPageFling(f6, f7)) {
            return;
        }
        int i6 = -1;
        if (!this.pdfView.isSwipeVertical() ? f6 <= 0.0f : f7 <= 0.0f) {
            i6 = 1;
        }
        if (this.pdfView.isSwipeVertical()) {
            x5 = motionEvent2.getY();
            x6 = motionEvent.getY();
        } else {
            x5 = motionEvent2.getX();
            x6 = motionEvent.getX();
        }
        float f8 = x5 - x6;
        int max = Math.max(0, Math.min(this.pdfView.getPageCount() - 1, this.pdfView.findFocusPage(this.pdfView.getCurrentXOffset() - (this.pdfView.getZoom() * f8), this.pdfView.getCurrentYOffset() - (f8 * this.pdfView.getZoom())) + i6));
        this.animationManager.startPageFlingAnimation(-this.pdfView.snapOffsetForPage(max, this.pdfView.findSnapEdge(max)));
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float zoom = this.pdfView.getZoom() * scaleFactor;
        float min = Math.min(Constants.Pinch.MINIMUM_ZOOM, this.pdfView.getMinZoom());
        float min2 = Math.min(Constants.Pinch.MAXIMUM_ZOOM, this.pdfView.getMaxZoom());
        if (zoom < min) {
            scaleFactor = min / this.pdfView.getZoom();
        } else if (zoom > min2) {
            scaleFactor = min2 / this.pdfView.getZoom();
        }
        this.pdfView.zoomCenteredRelativeTo(scaleFactor, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
