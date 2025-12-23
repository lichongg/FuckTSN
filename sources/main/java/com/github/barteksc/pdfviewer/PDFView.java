package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.link.DefaultLinkHandler;
import com.github.barteksc.pdfviewer.link.LinkHandler;
import com.github.barteksc.pdfviewer.listener.Callbacks;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnLongPressListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.github.barteksc.pdfviewer.model.PagePart;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import com.github.barteksc.pdfviewer.source.AssetSource;
import com.github.barteksc.pdfviewer.source.ByteArraySource;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.github.barteksc.pdfviewer.source.FileSource;
import com.github.barteksc.pdfviewer.source.InputStreamSource;
import com.github.barteksc.pdfviewer.source.UriSource;
import com.github.barteksc.pdfviewer.util.Constants;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.MathUtils;
import com.github.barteksc.pdfviewer.util.SnapEdge;
import com.github.barteksc.pdfviewer.util.Util;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class PDFView extends RelativeLayout {
    public static final float DEFAULT_MAX_SCALE = 3.0f;
    public static final float DEFAULT_MID_SCALE = 1.75f;
    public static final float DEFAULT_MIN_SCALE = 1.0f;
    private static final String TAG = "PDFView";
    private AnimationManager animationManager;
    private boolean annotationRendering;
    private PaintFlagsDrawFilter antialiasFilter;
    private boolean autoSpacing;
    private boolean bestQuality;
    CacheManager cacheManager;
    Callbacks callbacks;
    private int currentPage;
    private float currentXOffset;
    private float currentYOffset;
    private Paint debugPaint;
    private DecodingAsyncTask decodingAsyncTask;
    private int defaultPage;
    private boolean doubletapEnabled;
    private DragPinchManager dragPinchManager;
    private boolean enableAntialiasing;
    private boolean enableSwipe;
    private boolean fitEachPage;
    private boolean hasSize;
    private boolean isScrollHandleInit;
    private float maxZoom;
    private float midZoom;
    private float minZoom;
    private boolean nightMode;
    private List<Integer> onDrawPagesNums;
    private FitPolicy pageFitPolicy;
    private boolean pageFling;
    private boolean pageSnap;
    private PagesLoader pagesLoader;
    private Paint paint;
    PdfFile pdfFile;
    private PdfiumCore pdfiumCore;
    private boolean recycled;
    private boolean renderDuringScale;
    RenderingHandler renderingHandler;
    private HandlerThread renderingHandlerThread;
    private ScrollDir scrollDir;
    private ScrollHandle scrollHandle;
    private int spacingPx;
    private State state;
    private boolean swipeVertical;
    private Configurator waitingDocumentConfigurator;
    private float zoom;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.github.barteksc.pdfviewer.PDFView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class Configurator {
        private boolean annotationRendering;
        private boolean antialiasing;
        private boolean autoSpacing;
        private int defaultPage;
        private final DocumentSource documentSource;
        private boolean enableDoubletap;
        private boolean enableSwipe;
        private boolean fitEachPage;
        private LinkHandler linkHandler;
        private boolean nightMode;
        private OnDrawListener onDrawAllListener;
        private OnDrawListener onDrawListener;
        private OnErrorListener onErrorListener;
        private OnLoadCompleteListener onLoadCompleteListener;
        private OnLongPressListener onLongPressListener;
        private OnPageChangeListener onPageChangeListener;
        private OnPageErrorListener onPageErrorListener;
        private OnPageScrollListener onPageScrollListener;
        private OnRenderListener onRenderListener;
        private OnTapListener onTapListener;
        private FitPolicy pageFitPolicy;
        private boolean pageFling;
        private int[] pageNumbers;
        private boolean pageSnap;
        private String password;
        private ScrollHandle scrollHandle;
        private int spacing;
        private boolean swipeHorizontal;

        /* synthetic */ Configurator(PDFView pDFView, DocumentSource documentSource, AnonymousClass1 anonymousClass1) {
            this(documentSource);
        }

        private Configurator(DocumentSource documentSource) {
            this.pageNumbers = null;
            this.enableSwipe = true;
            this.enableDoubletap = true;
            this.linkHandler = new DefaultLinkHandler(PDFView.this);
            this.defaultPage = 0;
            this.swipeHorizontal = false;
            this.annotationRendering = false;
            this.password = null;
            this.scrollHandle = null;
            this.antialiasing = true;
            this.spacing = 0;
            this.autoSpacing = false;
            this.pageFitPolicy = FitPolicy.WIDTH;
            this.fitEachPage = false;
            this.pageFling = false;
            this.pageSnap = false;
            this.nightMode = false;
            this.documentSource = documentSource;
        }

        public Configurator autoSpacing(boolean z5) {
            this.autoSpacing = z5;
            return this;
        }

        public Configurator defaultPage(int i6) {
            this.defaultPage = i6;
            return this;
        }

        public Configurator disableLongpress() {
            PDFView.this.dragPinchManager.disableLongpress();
            return this;
        }

        public Configurator enableAnnotationRendering(boolean z5) {
            this.annotationRendering = z5;
            return this;
        }

        public Configurator enableAntialiasing(boolean z5) {
            this.antialiasing = z5;
            return this;
        }

        public Configurator enableDoubletap(boolean z5) {
            this.enableDoubletap = z5;
            return this;
        }

        public Configurator enableSwipe(boolean z5) {
            this.enableSwipe = z5;
            return this;
        }

        public Configurator fitEachPage(boolean z5) {
            this.fitEachPage = z5;
            return this;
        }

        public Configurator linkHandler(LinkHandler linkHandler) {
            this.linkHandler = linkHandler;
            return this;
        }

        public void load() {
            if (!PDFView.this.hasSize) {
                PDFView.this.waitingDocumentConfigurator = this;
                return;
            }
            PDFView.this.recycle();
            PDFView.this.callbacks.setOnLoadComplete(this.onLoadCompleteListener);
            PDFView.this.callbacks.setOnError(this.onErrorListener);
            PDFView.this.callbacks.setOnDraw(this.onDrawListener);
            PDFView.this.callbacks.setOnDrawAll(this.onDrawAllListener);
            PDFView.this.callbacks.setOnPageChange(this.onPageChangeListener);
            PDFView.this.callbacks.setOnPageScroll(this.onPageScrollListener);
            PDFView.this.callbacks.setOnRender(this.onRenderListener);
            PDFView.this.callbacks.setOnTap(this.onTapListener);
            PDFView.this.callbacks.setOnLongPress(this.onLongPressListener);
            PDFView.this.callbacks.setOnPageError(this.onPageErrorListener);
            PDFView.this.callbacks.setLinkHandler(this.linkHandler);
            PDFView.this.setSwipeEnabled(this.enableSwipe);
            PDFView.this.setNightMode(this.nightMode);
            PDFView.this.enableDoubletap(this.enableDoubletap);
            PDFView.this.setDefaultPage(this.defaultPage);
            PDFView.this.setSwipeVertical(!this.swipeHorizontal);
            PDFView.this.enableAnnotationRendering(this.annotationRendering);
            PDFView.this.setScrollHandle(this.scrollHandle);
            PDFView.this.enableAntialiasing(this.antialiasing);
            PDFView.this.setSpacing(this.spacing);
            PDFView.this.setAutoSpacing(this.autoSpacing);
            PDFView.this.setPageFitPolicy(this.pageFitPolicy);
            PDFView.this.setFitEachPage(this.fitEachPage);
            PDFView.this.setPageSnap(this.pageSnap);
            PDFView.this.setPageFling(this.pageFling);
            int[] iArr = this.pageNumbers;
            if (iArr != null) {
                PDFView.this.load(this.documentSource, this.password, iArr);
            } else {
                PDFView.this.load(this.documentSource, this.password);
            }
        }

        public Configurator nightMode(boolean z5) {
            this.nightMode = z5;
            return this;
        }

        public Configurator onDraw(OnDrawListener onDrawListener) {
            this.onDrawListener = onDrawListener;
            return this;
        }

        public Configurator onDrawAll(OnDrawListener onDrawListener) {
            this.onDrawAllListener = onDrawListener;
            return this;
        }

        public Configurator onError(OnErrorListener onErrorListener) {
            this.onErrorListener = onErrorListener;
            return this;
        }

        public Configurator onLoad(OnLoadCompleteListener onLoadCompleteListener) {
            this.onLoadCompleteListener = onLoadCompleteListener;
            return this;
        }

        public Configurator onLongPress(OnLongPressListener onLongPressListener) {
            this.onLongPressListener = onLongPressListener;
            return this;
        }

        public Configurator onPageChange(OnPageChangeListener onPageChangeListener) {
            this.onPageChangeListener = onPageChangeListener;
            return this;
        }

        public Configurator onPageError(OnPageErrorListener onPageErrorListener) {
            this.onPageErrorListener = onPageErrorListener;
            return this;
        }

        public Configurator onPageScroll(OnPageScrollListener onPageScrollListener) {
            this.onPageScrollListener = onPageScrollListener;
            return this;
        }

        public Configurator onRender(OnRenderListener onRenderListener) {
            this.onRenderListener = onRenderListener;
            return this;
        }

        public Configurator onTap(OnTapListener onTapListener) {
            this.onTapListener = onTapListener;
            return this;
        }

        public Configurator pageFitPolicy(FitPolicy fitPolicy) {
            this.pageFitPolicy = fitPolicy;
            return this;
        }

        public Configurator pageFling(boolean z5) {
            this.pageFling = z5;
            return this;
        }

        public Configurator pageSnap(boolean z5) {
            this.pageSnap = z5;
            return this;
        }

        public Configurator pages(int... iArr) {
            this.pageNumbers = iArr;
            return this;
        }

        public Configurator password(String str) {
            this.password = str;
            return this;
        }

        public Configurator scrollHandle(ScrollHandle scrollHandle) {
            this.scrollHandle = scrollHandle;
            return this;
        }

        public Configurator spacing(int i6) {
            this.spacing = i6;
            return this;
        }

        public Configurator swipeHorizontal(boolean z5) {
            this.swipeHorizontal = z5;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum ScrollDir {
        NONE,
        START,
        END
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum State {
        DEFAULT,
        LOADED,
        SHOWN,
        ERROR
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(DocumentSource documentSource, String str) {
        load(documentSource, str, null);
    }

    public void jumpTo(int i6, boolean z5) {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return;
        }
        int determineValidPageNumberFrom = pdfFile.determineValidPageNumberFrom(i6);
        float f6 = determineValidPageNumberFrom == 0 ? 0.0f : -this.pdfFile.getPageOffset(determineValidPageNumberFrom, this.zoom);
        if (this.swipeVertical) {
            if (z5) {
                this.animationManager.startYAnimation(this.currentYOffset, f6);
            } else {
                moveTo(this.currentXOffset, f6);
            }
        } else if (z5) {
            this.animationManager.startXAnimation(this.currentXOffset, f6);
        } else {
            moveTo(f6, this.currentYOffset);
        }
        showPage(determineValidPageNumberFrom);
    }

    public void moveTo(float f6, float f7) {
        moveTo(f6, f7, true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        float docLen;
        float maxPageHeight;
        this.hasSize = true;
        Configurator configurator = this.waitingDocumentConfigurator;
        if (configurator != null) {
            configurator.load();
        }
        if (isInEditMode() || this.state != State.SHOWN) {
            return;
        }
        float f6 = (-this.currentXOffset) + (i8 * 0.5f);
        float f7 = (-this.currentYOffset) + (i9 * 0.5f);
        if (this.swipeVertical) {
            docLen = f6 / this.pdfFile.getMaxPageWidth();
            maxPageHeight = this.pdfFile.getDocLen(this.zoom);
        } else {
            docLen = f6 / this.pdfFile.getDocLen(this.zoom);
            maxPageHeight = this.pdfFile.getMaxPageHeight();
        }
        float f8 = f7 / maxPageHeight;
        this.animationManager.stopAll();
        this.pdfFile.recalculatePageSizes(new Size(i6, i7));
        if (this.swipeVertical) {
            this.currentXOffset = ((-docLen) * this.pdfFile.getMaxPageWidth()) + (i6 * 0.5f);
            this.currentYOffset = ((-f8) * this.pdfFile.getDocLen(this.zoom)) + (i7 * 0.5f);
        } else {
            this.currentXOffset = ((-docLen) * this.pdfFile.getDocLen(this.zoom)) + (i6 * 0.5f);
            this.currentYOffset = ((-f8) * this.pdfFile.getMaxPageHeight()) + (i7 * 0.5f);
        }
        moveTo(this.currentXOffset, this.currentYOffset);
        loadPageByOffset();
    }

    public void recycle() {
        this.waitingDocumentConfigurator = null;
        this.animationManager.stopAll();
        this.dragPinchManager.disable();
        RenderingHandler renderingHandler = this.renderingHandler;
        if (renderingHandler != null) {
            renderingHandler.stop();
            this.renderingHandler.removeMessages(1);
        }
        DecodingAsyncTask decodingAsyncTask = this.decodingAsyncTask;
        if (decodingAsyncTask != null) {
            decodingAsyncTask.cancel(true);
        }
        this.cacheManager.recycle();
        ScrollHandle scrollHandle = this.scrollHandle;
        if (scrollHandle != null && this.isScrollHandleInit) {
            scrollHandle.destroyLayout();
        }
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile != null) {
            pdfFile.dispose();
            this.pdfFile = null;
        }
        this.renderingHandler = null;
        this.scrollHandle = null;
        this.isScrollHandleInit = false;
        this.currentYOffset = 0.0f;
        this.currentXOffset = 0.0f;
        this.zoom = 1.0f;
        this.recycled = true;
        this.callbacks = new Callbacks();
        this.state = State.DEFAULT;
    }

    public void setPositionOffset(float f6, boolean z5) {
        if (this.swipeVertical) {
            moveTo(this.currentXOffset, ((-this.pdfFile.getDocLen(this.zoom)) + getHeight()) * f6, z5);
        } else {
            moveTo(((-this.pdfFile.getDocLen(this.zoom)) + getWidth()) * f6, this.currentYOffset, z5);
        }
        loadPageByOffset();
    }

    public void zoomWithAnimation(float f6, float f7, float f8) {
        this.animationManager.startZoomAnimation(f6, f7, this.zoom, f8);
    }

    private void drawWithListener(Canvas canvas, int i6, OnDrawListener onDrawListener) {
        float f6;
        if (onDrawListener != null) {
            float f7 = 0.0f;
            if (this.swipeVertical) {
                f6 = this.pdfFile.getPageOffset(i6, this.zoom);
            } else {
                f7 = this.pdfFile.getPageOffset(i6, this.zoom);
                f6 = 0.0f;
            }
            canvas.translate(f7, f6);
            SizeF pageSize = this.pdfFile.getPageSize(i6);
            onDrawListener.onLayerDrawn(canvas, toCurrentScale(pageSize.b()), toCurrentScale(pageSize.a()), i6);
            canvas.translate(-f7, -f6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(DocumentSource documentSource, String str, int[] iArr) {
        if (!this.recycled) {
            throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
        }
        this.recycled = false;
        DecodingAsyncTask decodingAsyncTask = new DecodingAsyncTask(documentSource, str, iArr, this, this.pdfiumCore);
        this.decodingAsyncTask = decodingAsyncTask;
        decodingAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoSpacing(boolean z5) {
        this.autoSpacing = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultPage(int i6) {
        this.defaultPage = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFitEachPage(boolean z5) {
        this.fitEachPage = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageFitPolicy(FitPolicy fitPolicy) {
        this.pageFitPolicy = fitPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollHandle(ScrollHandle scrollHandle) {
        this.scrollHandle = scrollHandle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwipeVertical(boolean z5) {
        this.swipeVertical = z5;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i6) {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return true;
        }
        if (this.swipeVertical) {
            if (i6 >= 0 || this.currentXOffset >= 0.0f) {
                return i6 > 0 && this.currentXOffset + toCurrentScale(pdfFile.getMaxPageWidth()) > ((float) getWidth());
            }
            return true;
        }
        if (i6 >= 0 || this.currentXOffset >= 0.0f) {
            return i6 > 0 && this.currentXOffset + pdfFile.getDocLen(this.zoom) > ((float) getWidth());
        }
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i6) {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return true;
        }
        if (this.swipeVertical) {
            if (i6 >= 0 || this.currentYOffset >= 0.0f) {
                return i6 > 0 && this.currentYOffset + pdfFile.getDocLen(this.zoom) > ((float) getHeight());
            }
            return true;
        }
        if (i6 >= 0 || this.currentYOffset >= 0.0f) {
            return i6 > 0 && this.currentYOffset + toCurrentScale(pdfFile.getMaxPageHeight()) > ((float) getHeight());
        }
        return true;
    }

    public boolean doRenderDuringScale() {
        return this.renderDuringScale;
    }

    public boolean documentFitsView() {
        float docLen = this.pdfFile.getDocLen(1.0f);
        return this.swipeVertical ? docLen < ((float) getHeight()) : docLen < ((float) getWidth());
    }

    public void enableAnnotationRendering(boolean z5) {
        this.annotationRendering = z5;
    }

    public void enableAntialiasing(boolean z5) {
        this.enableAntialiasing = z5;
    }

    void enableDoubletap(boolean z5) {
        this.doubletapEnabled = z5;
    }

    public void enableRenderDuringScale(boolean z5) {
        this.renderDuringScale = z5;
    }

    int findFocusPage(float f6, float f7) {
        boolean z5 = this.swipeVertical;
        if (z5) {
            f6 = f7;
        }
        float height = z5 ? getHeight() : getWidth();
        if (f6 > -1.0f) {
            return 0;
        }
        if (f6 < (-this.pdfFile.getDocLen(this.zoom)) + height + 1.0f) {
            return this.pdfFile.getPagesCount() - 1;
        }
        return this.pdfFile.getPageAtOffset(-(f6 - (height / 2.0f)), this.zoom);
    }

    SnapEdge findSnapEdge(int i6) {
        if (!this.pageSnap || i6 < 0) {
            return SnapEdge.NONE;
        }
        float f6 = this.swipeVertical ? this.currentYOffset : this.currentXOffset;
        float f7 = -this.pdfFile.getPageOffset(i6, this.zoom);
        int height = this.swipeVertical ? getHeight() : getWidth();
        float pageLength = this.pdfFile.getPageLength(i6, this.zoom);
        float f8 = height;
        return f8 >= pageLength ? SnapEdge.CENTER : f6 >= f7 ? SnapEdge.START : f7 - pageLength > f6 - f8 ? SnapEdge.END : SnapEdge.NONE;
    }

    public void fitToWidth(int i6) {
        if (this.state != State.SHOWN) {
            return;
        }
        zoomTo(getWidth() / this.pdfFile.getPageSize(i6).b());
        jumpTo(i6);
    }

    public Configurator fromAsset(String str) {
        return new Configurator(this, new AssetSource(str), null);
    }

    public Configurator fromBytes(byte[] bArr) {
        return new Configurator(this, new ByteArraySource(bArr), null);
    }

    public Configurator fromFile(File file) {
        return new Configurator(this, new FileSource(file), null);
    }

    public Configurator fromSource(DocumentSource documentSource) {
        return new Configurator(this, documentSource, null);
    }

    public Configurator fromStream(InputStream inputStream) {
        return new Configurator(this, new InputStreamSource(inputStream), null);
    }

    public Configurator fromUri(Uri uri) {
        return new Configurator(this, new UriSource(uri), null);
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public float getCurrentXOffset() {
        return this.currentXOffset;
    }

    public float getCurrentYOffset() {
        return this.currentYOffset;
    }

    public PdfDocument.Meta getDocumentMeta() {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return null;
        }
        return pdfFile.getMetaData();
    }

    public List<PdfDocument.Link> getLinks(int i6) {
        PdfFile pdfFile = this.pdfFile;
        return pdfFile == null ? Collections.EMPTY_LIST : pdfFile.getPageLinks(i6);
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMidZoom() {
        return this.midZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public int getPageAtPositionOffset(float f6) {
        PdfFile pdfFile = this.pdfFile;
        return pdfFile.getPageAtOffset(pdfFile.getDocLen(this.zoom) * f6, this.zoom);
    }

    public int getPageCount() {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return 0;
        }
        return pdfFile.getPagesCount();
    }

    public FitPolicy getPageFitPolicy() {
        return this.pageFitPolicy;
    }

    public SizeF getPageSize(int i6) {
        PdfFile pdfFile = this.pdfFile;
        return pdfFile == null ? new SizeF(0.0f, 0.0f) : pdfFile.getPageSize(i6);
    }

    public float getPositionOffset() {
        float f6;
        float docLen;
        int width;
        if (this.swipeVertical) {
            f6 = -this.currentYOffset;
            docLen = this.pdfFile.getDocLen(this.zoom);
            width = getHeight();
        } else {
            f6 = -this.currentXOffset;
            docLen = this.pdfFile.getDocLen(this.zoom);
            width = getWidth();
        }
        return MathUtils.limit(f6 / (docLen - width), 0.0f, 1.0f);
    }

    ScrollHandle getScrollHandle() {
        return this.scrollHandle;
    }

    public int getSpacingPx() {
        return this.spacingPx;
    }

    public List<PdfDocument.Bookmark> getTableOfContents() {
        PdfFile pdfFile = this.pdfFile;
        return pdfFile == null ? Collections.EMPTY_LIST : pdfFile.getBookmarks();
    }

    public float getZoom() {
        return this.zoom;
    }

    public boolean isAnnotationRendering() {
        return this.annotationRendering;
    }

    public boolean isAntialiasing() {
        return this.enableAntialiasing;
    }

    public boolean isAutoSpacingEnabled() {
        return this.autoSpacing;
    }

    public boolean isBestQuality() {
        return this.bestQuality;
    }

    boolean isDoubletapEnabled() {
        return this.doubletapEnabled;
    }

    public boolean isFitEachPage() {
        return this.fitEachPage;
    }

    public boolean isPageFlingEnabled() {
        return this.pageFling;
    }

    public boolean isPageSnap() {
        return this.pageSnap;
    }

    public boolean isRecycled() {
        return this.recycled;
    }

    public boolean isSwipeEnabled() {
        return this.enableSwipe;
    }

    public boolean isSwipeVertical() {
        return this.swipeVertical;
    }

    public boolean isZooming() {
        return this.zoom != this.minZoom;
    }

    void loadComplete(PdfFile pdfFile) {
        this.state = State.LOADED;
        this.pdfFile = pdfFile;
        if (!this.renderingHandlerThread.isAlive()) {
            this.renderingHandlerThread.start();
        }
        RenderingHandler renderingHandler = new RenderingHandler(this.renderingHandlerThread.getLooper(), this);
        this.renderingHandler = renderingHandler;
        renderingHandler.start();
        ScrollHandle scrollHandle = this.scrollHandle;
        if (scrollHandle != null) {
            scrollHandle.setupLayout(this);
            this.isScrollHandleInit = true;
        }
        this.dragPinchManager.enable();
        this.callbacks.callOnLoadComplete(pdfFile.getPagesCount());
        jumpTo(this.defaultPage, false);
    }

    void loadError(Throwable th) {
        this.state = State.ERROR;
        OnErrorListener onError = this.callbacks.getOnError();
        recycle();
        invalidate();
        if (onError != null) {
            onError.onError(th);
        }
    }

    void loadPageByOffset() {
        float f6;
        int width;
        if (this.pdfFile.getPagesCount() == 0) {
            return;
        }
        if (this.swipeVertical) {
            f6 = this.currentYOffset;
            width = getHeight();
        } else {
            f6 = this.currentXOffset;
            width = getWidth();
        }
        int pageAtOffset = this.pdfFile.getPageAtOffset(-(f6 - (width / 2.0f)), this.zoom);
        if (pageAtOffset < 0 || pageAtOffset > this.pdfFile.getPagesCount() - 1 || pageAtOffset == getCurrentPage()) {
            loadPages();
        } else {
            showPage(pageAtOffset);
        }
    }

    public void loadPages() {
        RenderingHandler renderingHandler;
        if (this.pdfFile == null || (renderingHandler = this.renderingHandler) == null) {
            return;
        }
        renderingHandler.removeMessages(1);
        this.cacheManager.makeANewSet();
        this.pagesLoader.loadPages();
        redraw();
    }

    public void moveRelativeTo(float f6, float f7) {
        moveTo(this.currentXOffset + f6, this.currentYOffset + f7);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void moveTo(float r6, float r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.moveTo(float, float, boolean):void");
    }

    public void onBitmapRendered(PagePart pagePart) {
        if (this.state == State.LOADED) {
            this.state = State.SHOWN;
            this.callbacks.callOnRender(this.pdfFile.getPagesCount());
        }
        if (pagePart.isThumbnail()) {
            this.cacheManager.cacheThumbnail(pagePart);
        } else {
            this.cacheManager.cachePart(pagePart);
        }
        redraw();
    }

    void onPageError(PageRenderingException pageRenderingException) {
        if (this.callbacks.callOnPageError(pageRenderingException.getPage(), pageRenderingException.getCause())) {
            return;
        }
        pageRenderingException.getPage();
        pageRenderingException.getCause();
    }

    public boolean pageFillsScreen() {
        float f6 = -this.pdfFile.getPageOffset(this.currentPage, this.zoom);
        float pageLength = f6 - this.pdfFile.getPageLength(this.currentPage, this.zoom);
        if (isSwipeVertical()) {
            float f7 = this.currentYOffset;
            return f6 > f7 && pageLength < f7 - ((float) getHeight());
        }
        float f8 = this.currentXOffset;
        return f6 > f8 && pageLength < f8 - ((float) getWidth());
    }

    public void performPageSnap() {
        PdfFile pdfFile;
        int findFocusPage;
        SnapEdge findSnapEdge;
        if (!this.pageSnap || (pdfFile = this.pdfFile) == null || pdfFile.getPagesCount() == 0 || (findSnapEdge = findSnapEdge((findFocusPage = findFocusPage(this.currentXOffset, this.currentYOffset)))) == SnapEdge.NONE) {
            return;
        }
        float snapOffsetForPage = snapOffsetForPage(findFocusPage, findSnapEdge);
        if (this.swipeVertical) {
            this.animationManager.startYAnimation(this.currentYOffset, -snapOffsetForPage);
        } else {
            this.animationManager.startXAnimation(this.currentXOffset, -snapOffsetForPage);
        }
    }

    public void resetZoom() {
        zoomTo(this.minZoom);
    }

    public void resetZoomWithAnimation() {
        zoomWithAnimation(this.minZoom);
    }

    public void setMaxZoom(float f6) {
        this.maxZoom = f6;
    }

    public void setMidZoom(float f6) {
        this.midZoom = f6;
    }

    public void setMinZoom(float f6) {
        this.minZoom = f6;
    }

    public void setNightMode(boolean z5) {
        this.nightMode = z5;
        if (!z5) {
            this.paint.setColorFilter(null);
        } else {
            this.paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
        }
    }

    public void setPageFling(boolean z5) {
        this.pageFling = z5;
    }

    public void setPageSnap(boolean z5) {
        this.pageSnap = z5;
    }

    public void setSwipeEnabled(boolean z5) {
        this.enableSwipe = z5;
    }

    void showPage(int i6) {
        if (this.recycled) {
            return;
        }
        this.currentPage = this.pdfFile.determineValidPageNumberFrom(i6);
        loadPages();
        if (this.scrollHandle != null && !documentFitsView()) {
            this.scrollHandle.setPageNum(this.currentPage + 1);
        }
        this.callbacks.callOnPageChange(this.currentPage, this.pdfFile.getPagesCount());
    }

    float snapOffsetForPage(int i6, SnapEdge snapEdge) {
        float f6;
        float pageOffset = this.pdfFile.getPageOffset(i6, this.zoom);
        float height = this.swipeVertical ? getHeight() : getWidth();
        float pageLength = this.pdfFile.getPageLength(i6, this.zoom);
        if (snapEdge == SnapEdge.CENTER) {
            f6 = pageOffset - (height / 2.0f);
            pageLength /= 2.0f;
        } else {
            if (snapEdge != SnapEdge.END) {
                return pageOffset;
            }
            f6 = pageOffset - height;
        }
        return f6 + pageLength;
    }

    public void stopFling() {
        this.animationManager.stopFling();
    }

    public float toCurrentScale(float f6) {
        return f6 * this.zoom;
    }

    public float toRealScale(float f6) {
        return f6 / this.zoom;
    }

    public void useBestQuality(boolean z5) {
        this.bestQuality = z5;
    }

    public void zoomCenteredRelativeTo(float f6, PointF pointF) {
        zoomCenteredTo(this.zoom * f6, pointF);
    }

    public void zoomCenteredTo(float f6, PointF pointF) {
        float f7 = f6 / this.zoom;
        zoomTo(f6);
        float f8 = this.currentXOffset * f7;
        float f9 = this.currentYOffset * f7;
        float f10 = pointF.x;
        float f11 = pointF.y;
        moveTo(f8 + (f10 - (f10 * f7)), f9 + (f11 - (f7 * f11)));
    }

    public void zoomTo(float f6) {
        this.zoom = f6;
    }

    public void zoomWithAnimation(float f6) {
        this.animationManager.startZoomAnimation(getWidth() / 2, getHeight() / 2, this.zoom, f6);
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.minZoom = 1.0f;
        this.midZoom = 1.75f;
        this.maxZoom = 3.0f;
        this.scrollDir = ScrollDir.NONE;
        this.currentXOffset = 0.0f;
        this.currentYOffset = 0.0f;
        this.zoom = 1.0f;
        this.recycled = true;
        this.state = State.DEFAULT;
        this.callbacks = new Callbacks();
        this.pageFitPolicy = FitPolicy.WIDTH;
        this.fitEachPage = false;
        this.defaultPage = 0;
        this.swipeVertical = true;
        this.enableSwipe = true;
        this.doubletapEnabled = true;
        this.nightMode = false;
        this.pageSnap = true;
        this.isScrollHandleInit = false;
        this.bestQuality = false;
        this.annotationRendering = false;
        this.renderDuringScale = false;
        this.enableAntialiasing = true;
        this.antialiasFilter = new PaintFlagsDrawFilter(0, 3);
        this.spacingPx = 0;
        this.autoSpacing = false;
        this.pageFling = true;
        this.onDrawPagesNums = new ArrayList(10);
        this.hasSize = false;
        this.renderingHandlerThread = new HandlerThread("PDF renderer");
        if (isInEditMode()) {
            return;
        }
        this.cacheManager = new CacheManager();
        AnimationManager animationManager = new AnimationManager(this);
        this.animationManager = animationManager;
        this.dragPinchManager = new DragPinchManager(this, animationManager);
        this.pagesLoader = new PagesLoader(this);
        this.paint = new Paint();
        Paint paint = new Paint();
        this.debugPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.pdfiumCore = new PdfiumCore(context);
        setWillNotDraw(false);
    }

    private void drawPart(Canvas canvas, PagePart pagePart) {
        float pageOffset;
        float currentScale;
        int i6;
        RectF pageRelativeBounds = pagePart.getPageRelativeBounds();
        Bitmap renderedBitmap = pagePart.getRenderedBitmap();
        if (renderedBitmap.isRecycled()) {
            return;
        }
        SizeF pageSize = this.pdfFile.getPageSize(pagePart.getPage());
        if (this.swipeVertical) {
            currentScale = this.pdfFile.getPageOffset(pagePart.getPage(), this.zoom);
            pageOffset = toCurrentScale(this.pdfFile.getMaxPageWidth() - pageSize.b()) / 2.0f;
        } else {
            pageOffset = this.pdfFile.getPageOffset(pagePart.getPage(), this.zoom);
            currentScale = toCurrentScale(this.pdfFile.getMaxPageHeight() - pageSize.a()) / 2.0f;
        }
        canvas.translate(pageOffset, currentScale);
        Rect rect = new Rect(0, 0, renderedBitmap.getWidth(), renderedBitmap.getHeight());
        float currentScale2 = toCurrentScale(pageRelativeBounds.left * pageSize.b());
        float currentScale3 = toCurrentScale(pageRelativeBounds.top * pageSize.a());
        RectF rectF = new RectF((int) currentScale2, (int) currentScale3, (int) (currentScale2 + toCurrentScale(pageRelativeBounds.width() * pageSize.b())), (int) (currentScale3 + toCurrentScale(pageRelativeBounds.height() * pageSize.a())));
        float f6 = this.currentXOffset + pageOffset;
        float f7 = this.currentYOffset + currentScale;
        if (rectF.left + f6 < getWidth() && f6 + rectF.right > 0.0f && rectF.top + f7 < getHeight() && f7 + rectF.bottom > 0.0f) {
            canvas.drawBitmap(renderedBitmap, rect, rectF, this.paint);
            if (Constants.DEBUG_MODE) {
                Paint paint = this.debugPaint;
                if (pagePart.getPage() % 2 == 0) {
                    i6 = SupportMenu.CATEGORY_MASK;
                } else {
                    i6 = -16776961;
                }
                paint.setColor(i6);
                canvas.drawRect(rectF, this.debugPaint);
            }
            canvas.translate(-pageOffset, -currentScale);
            return;
        }
        canvas.translate(-pageOffset, -currentScale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpacing(int i6) {
        this.spacingPx = Util.getDP(getContext(), i6);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (isInEditMode()) {
            return;
        }
        this.animationManager.computeFling();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        recycle();
        HandlerThread handlerThread = this.renderingHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.renderingHandlerThread = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i6;
        if (!isInEditMode()) {
            if (this.enableAntialiasing) {
                canvas.setDrawFilter(this.antialiasFilter);
            }
            Drawable background = getBackground();
            if (background == null) {
                if (this.nightMode) {
                    i6 = ViewCompat.MEASURED_STATE_MASK;
                } else {
                    i6 = -1;
                }
                canvas.drawColor(i6);
            } else {
                background.draw(canvas);
            }
            if (this.recycled || this.state != State.SHOWN) {
                return;
            }
            float f6 = this.currentXOffset;
            float f7 = this.currentYOffset;
            canvas.translate(f6, f7);
            Iterator<PagePart> it = this.cacheManager.getThumbnails().iterator();
            while (it.hasNext()) {
                drawPart(canvas, it.next());
            }
            for (PagePart pagePart : this.cacheManager.getPageParts()) {
                drawPart(canvas, pagePart);
                if (this.callbacks.getOnDrawAll() != null && !this.onDrawPagesNums.contains(Integer.valueOf(pagePart.getPage()))) {
                    this.onDrawPagesNums.add(Integer.valueOf(pagePart.getPage()));
                }
            }
            Iterator<Integer> it2 = this.onDrawPagesNums.iterator();
            while (it2.hasNext()) {
                drawWithListener(canvas, it2.next().intValue(), this.callbacks.getOnDrawAll());
            }
            this.onDrawPagesNums.clear();
            drawWithListener(canvas, this.currentPage, this.callbacks.getOnDraw());
            canvas.translate(-f6, -f7);
        }
    }

    void redraw() {
        invalidate();
    }

    public void setPositionOffset(float f6) {
        setPositionOffset(f6, true);
    }

    public void jumpTo(int i6) {
        jumpTo(i6, false);
    }
}
