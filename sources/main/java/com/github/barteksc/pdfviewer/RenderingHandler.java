package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.model.PagePart;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class RenderingHandler extends Handler {
    static final int MSG_RENDER_TASK = 1;
    private static final String TAG = "com.github.barteksc.pdfviewer.RenderingHandler";
    private PDFView pdfView;
    private RectF renderBounds;
    private Matrix renderMatrix;
    private Rect roundedRenderBounds;
    private boolean running;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class RenderingTask {
        boolean annotationRendering;
        boolean bestQuality;
        RectF bounds;
        int cacheOrder;
        float height;
        int page;
        boolean thumbnail;
        float width;

        RenderingTask(float f6, float f7, RectF rectF, int i6, boolean z5, int i7, boolean z6, boolean z7) {
            this.page = i6;
            this.width = f6;
            this.height = f7;
            this.bounds = rectF;
            this.thumbnail = z5;
            this.cacheOrder = i7;
            this.bestQuality = z6;
            this.annotationRendering = z7;
        }
    }

    void start() {
        this.running = true;
    }

    void stop() {
        this.running = false;
    }

    private void calculateBounds(int i6, int i7, RectF rectF) {
        this.renderMatrix.reset();
        float f6 = i6;
        float f7 = i7;
        this.renderMatrix.postTranslate((-rectF.left) * f6, (-rectF.top) * f7);
        this.renderMatrix.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
        this.renderBounds.set(0.0f, 0.0f, f6, f7);
        this.renderMatrix.mapRect(this.renderBounds);
        this.renderBounds.round(this.roundedRenderBounds);
    }

    private PagePart proceed(RenderingTask renderingTask) throws PageRenderingException {
        PdfFile pdfFile = this.pdfView.pdfFile;
        pdfFile.openPage(renderingTask.page);
        int round = Math.round(renderingTask.width);
        int round2 = Math.round(renderingTask.height);
        if (round != 0 && round2 != 0 && !pdfFile.pageHasError(renderingTask.page)) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(round, round2, renderingTask.bestQuality ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                calculateBounds(round, round2, renderingTask.bounds);
                pdfFile.renderPageBitmap(createBitmap, renderingTask.page, this.roundedRenderBounds, renderingTask.annotationRendering);
                return new PagePart(renderingTask.page, createBitmap, renderingTask.bounds, renderingTask.thumbnail, renderingTask.cacheOrder);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    void addRenderingTask(int i6, float f6, float f7, RectF rectF, boolean z5, int i7, boolean z6, boolean z7) {
        sendMessage(obtainMessage(1, new RenderingTask(f6, f7, rectF, i6, z5, i7, z6, z7)));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            final PagePart proceed = proceed((RenderingTask) message.obj);
            if (proceed != null) {
                if (this.running) {
                    this.pdfView.post(new Runnable() { // from class: com.github.barteksc.pdfviewer.RenderingHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RenderingHandler.this.pdfView.onBitmapRendered(proceed);
                        }
                    });
                } else {
                    proceed.getRenderedBitmap().recycle();
                }
            }
        } catch (PageRenderingException e6) {
            this.pdfView.post(new Runnable() { // from class: com.github.barteksc.pdfviewer.RenderingHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    RenderingHandler.this.pdfView.onPageError(e6);
                }
            });
        }
    }

    RenderingHandler(Looper looper, PDFView pDFView) {
        super(looper);
        this.renderBounds = new RectF();
        this.roundedRenderBounds = new Rect();
        this.renderMatrix = new Matrix();
        this.running = false;
        this.pdfView = pDFView;
    }
}
