package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import com.github.barteksc.pdfviewer.util.Constants;
import com.github.barteksc.pdfviewer.util.MathUtils;
import com.github.barteksc.pdfviewer.util.Util;
import com.shockwave.pdfium.util.SizeF;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class PagesLoader {
    private int cacheOrder;
    private float pageRelativePartHeight;
    private float pageRelativePartWidth;
    private float partRenderHeight;
    private float partRenderWidth;
    private PDFView pdfView;
    private final int preloadOffset;
    private final RectF thumbnailRect = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private float xOffset;
    private float yOffset;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.github.barteksc.pdfviewer.PagesLoader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class GridSize {
        int cols;
        int rows;

        private GridSize() {
        }

        /* synthetic */ GridSize(PagesLoader pagesLoader, AnonymousClass1 anonymousClass1) {
            this();
        }

        public String toString() {
            return "GridSize{rows=" + this.rows + ", cols=" + this.cols + '}';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class Holder {
        int col;
        int row;

        private Holder() {
        }

        /* synthetic */ Holder(PagesLoader pagesLoader, AnonymousClass1 anonymousClass1) {
            this();
        }

        public String toString() {
            return "Holder{row=" + this.row + ", col=" + this.col + '}';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class RenderRange {
        GridSize gridSize;
        Holder leftTop;
        int page = 0;
        Holder rightBottom;

        RenderRange() {
            AnonymousClass1 anonymousClass1 = null;
            this.gridSize = new GridSize(PagesLoader.this, anonymousClass1);
            this.leftTop = new Holder(PagesLoader.this, anonymousClass1);
            this.rightBottom = new Holder(PagesLoader.this, anonymousClass1);
        }

        public String toString() {
            return "RenderRange{page=" + this.page + ", gridSize=" + this.gridSize + ", leftTop=" + this.leftTop + ", rightBottom=" + this.rightBottom + '}';
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.github.barteksc.pdfviewer.PagesLoader.RenderRange> getRenderRangeList(float r21, float r22, float r23, float r24) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PagesLoader.getRenderRangeList(float, float, float, float):java.util.List");
    }

    private int loadPage(int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i7; i13 <= i8; i13++) {
            int i14 = i9;
            while (i14 <= i10) {
                int i15 = i6;
                if (loadCell(i15, i13, i14, this.pageRelativePartWidth, this.pageRelativePartHeight)) {
                    i12++;
                }
                if (i12 >= i11) {
                    return i12;
                }
                i14++;
                i6 = i15;
            }
        }
        return i12;
    }

    void loadPages() {
        this.cacheOrder = 1;
        this.xOffset = -MathUtils.max(this.pdfView.getCurrentXOffset(), 0.0f);
        this.yOffset = -MathUtils.max(this.pdfView.getCurrentYOffset(), 0.0f);
        loadVisible();
    }

    private void calculatePartSize(GridSize gridSize) {
        float f6 = 1.0f / gridSize.cols;
        this.pageRelativePartWidth = f6;
        float f7 = 1.0f / gridSize.rows;
        this.pageRelativePartHeight = f7;
        float f8 = Constants.PART_SIZE;
        this.partRenderWidth = f8 / f6;
        this.partRenderHeight = f8 / f7;
    }

    private void getPageColsRows(GridSize gridSize, int i6) {
        SizeF pageSize = this.pdfView.pdfFile.getPageSize(i6);
        float b6 = 1.0f / pageSize.b();
        float a6 = (Constants.PART_SIZE * (1.0f / pageSize.a())) / this.pdfView.getZoom();
        float zoom = (Constants.PART_SIZE * b6) / this.pdfView.getZoom();
        gridSize.rows = MathUtils.ceil(1.0f / a6);
        gridSize.cols = MathUtils.ceil(1.0f / zoom);
    }

    private boolean loadCell(int i6, int i7, int i8, float f6, float f7) {
        float f8 = i8 * f6;
        float f9 = i7 * f7;
        float f10 = this.partRenderWidth;
        float f11 = this.partRenderHeight;
        float f12 = f8 + f6 > 1.0f ? 1.0f - f8 : f6;
        float f13 = f9 + f7 > 1.0f ? 1.0f - f9 : f7;
        float f14 = f10 * f12;
        float f15 = f11 * f13;
        RectF rectF = new RectF(f8, f9, f12 + f8, f13 + f9);
        if (f14 <= 0.0f || f15 <= 0.0f) {
            return false;
        }
        if (!this.pdfView.cacheManager.upPartIfContained(i6, rectF, this.cacheOrder)) {
            PDFView pDFView = this.pdfView;
            pDFView.renderingHandler.addRenderingTask(i6, f14, f15, rectF, false, this.cacheOrder, pDFView.isBestQuality(), this.pdfView.isAnnotationRendering());
        }
        this.cacheOrder++;
        return true;
    }

    private void loadThumbnail(int i6) {
        SizeF pageSize = this.pdfView.pdfFile.getPageSize(i6);
        float b6 = pageSize.b() * Constants.THUMBNAIL_RATIO;
        float a6 = pageSize.a() * Constants.THUMBNAIL_RATIO;
        if (this.pdfView.cacheManager.containsThumbnail(i6, this.thumbnailRect)) {
            return;
        }
        PDFView pDFView = this.pdfView;
        pDFView.renderingHandler.addRenderingTask(i6, b6, a6, this.thumbnailRect, true, 0, pDFView.isBestQuality(), this.pdfView.isAnnotationRendering());
    }

    private void loadVisible() {
        float f6 = this.preloadOffset;
        float f7 = this.xOffset;
        float f8 = this.yOffset;
        List<RenderRange> renderRangeList = getRenderRangeList((-f7) + f6, (-f8) + f6, ((-f7) - this.pdfView.getWidth()) - f6, ((-f8) - this.pdfView.getHeight()) - f6);
        Iterator<RenderRange> it = renderRangeList.iterator();
        while (it.hasNext()) {
            loadThumbnail(it.next().page);
        }
        int i6 = 0;
        for (RenderRange renderRange : renderRangeList) {
            calculatePartSize(renderRange.gridSize);
            int i7 = renderRange.page;
            Holder holder = renderRange.leftTop;
            int i8 = holder.row;
            Holder holder2 = renderRange.rightBottom;
            i6 += loadPage(i7, i8, holder2.row, holder.col, holder2.col, Constants.Cache.CACHE_SIZE - i6);
            if (i6 >= Constants.Cache.CACHE_SIZE) {
                return;
            }
        }
    }

    PagesLoader(PDFView pDFView) {
        this.pdfView = pDFView;
        this.preloadOffset = Util.getDP(pDFView.getContext(), Constants.PRELOAD_OFFSET);
    }
}
