package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseBooleanArray;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.PageSizeCalculator;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class PdfFile {
    private static final Object lock = new Object();
    private boolean autoSpacing;
    private final boolean fitEachPage;
    private boolean isVertical;
    private int[] originalUserPages;
    private final FitPolicy pageFitPolicy;
    private PdfDocument pdfDocument;
    private PdfiumCore pdfiumCore;
    private int spacingPx;
    private int pagesCount = 0;
    private List<Size> originalPageSizes = new ArrayList();
    private List<SizeF> pageSizes = new ArrayList();
    private SparseBooleanArray openedPages = new SparseBooleanArray();
    private Size originalMaxWidthPageSize = new Size(0, 0);
    private Size originalMaxHeightPageSize = new Size(0, 0);
    private SizeF maxHeightPageSize = new SizeF(0.0f, 0.0f);
    private SizeF maxWidthPageSize = new SizeF(0.0f, 0.0f);
    private List<Float> pageOffsets = new ArrayList();
    private List<Float> pageSpacing = new ArrayList();
    private float documentLength = 0.0f;

    private void prepareDocLen() {
        float f6;
        float f7 = 0.0f;
        for (int i6 = 0; i6 < getPagesCount(); i6++) {
            SizeF sizeF = this.pageSizes.get(i6);
            f7 += this.isVertical ? sizeF.a() : sizeF.b();
            if (this.autoSpacing) {
                f6 = this.pageSpacing.get(i6).floatValue();
            } else if (i6 < getPagesCount() - 1) {
                f6 = this.spacingPx;
            }
            f7 += f6;
        }
        this.documentLength = f7;
    }

    public int getPageAtOffset(float f6, float f7) {
        int i6 = 0;
        for (int i7 = 0; i7 < getPagesCount() && (this.pageOffsets.get(i7).floatValue() * f7) - (getPageSpacing(i7, f7) / 2.0f) < f6; i7++) {
            i6++;
        }
        int i8 = i6 - 1;
        if (i8 >= 0) {
            return i8;
        }
        return 0;
    }

    private void prepareAutoSpacing(Size size) {
        float b6;
        float b7;
        this.pageSpacing.clear();
        for (int i6 = 0; i6 < getPagesCount(); i6++) {
            SizeF sizeF = this.pageSizes.get(i6);
            if (this.isVertical) {
                b6 = size.a();
                b7 = sizeF.a();
            } else {
                b6 = size.b();
                b7 = sizeF.b();
            }
            float max = Math.max(0.0f, b6 - b7);
            if (i6 < getPagesCount() - 1) {
                max += this.spacingPx;
            }
            this.pageSpacing.add(Float.valueOf(max));
        }
    }

    private void preparePagesOffset() {
        float f6;
        this.pageOffsets.clear();
        float f7 = 0.0f;
        for (int i6 = 0; i6 < getPagesCount(); i6++) {
            SizeF sizeF = this.pageSizes.get(i6);
            float a6 = this.isVertical ? sizeF.a() : sizeF.b();
            if (this.autoSpacing) {
                f7 += this.pageSpacing.get(i6).floatValue() / 2.0f;
                if (i6 == 0) {
                    f7 -= this.spacingPx / 2.0f;
                } else if (i6 == getPagesCount() - 1) {
                    f7 += this.spacingPx / 2.0f;
                }
                this.pageOffsets.add(Float.valueOf(f7));
                f6 = this.pageSpacing.get(i6).floatValue() / 2.0f;
            } else {
                this.pageOffsets.add(Float.valueOf(f7));
                f6 = this.spacingPx;
            }
            f7 += a6 + f6;
        }
    }

    private void setup(Size size) {
        int[] iArr = this.originalUserPages;
        if (iArr != null) {
            this.pagesCount = iArr.length;
        } else {
            this.pagesCount = this.pdfiumCore.d(this.pdfDocument);
        }
        for (int i6 = 0; i6 < this.pagesCount; i6++) {
            Size h6 = this.pdfiumCore.h(this.pdfDocument, documentPage(i6));
            if (h6.b() > this.originalMaxWidthPageSize.b()) {
                this.originalMaxWidthPageSize = h6;
            }
            if (h6.a() > this.originalMaxHeightPageSize.a()) {
                this.originalMaxHeightPageSize = h6;
            }
            this.originalPageSizes.add(h6);
        }
        recalculatePageSizes(size);
    }

    public int determineValidPageNumberFrom(int i6) {
        int pagesCount;
        if (i6 <= 0) {
            return 0;
        }
        int[] iArr = this.originalUserPages;
        if (iArr != null) {
            if (i6 >= iArr.length) {
                pagesCount = iArr.length;
                return pagesCount - 1;
            }
            return i6;
        }
        if (i6 >= getPagesCount()) {
            pagesCount = getPagesCount();
            return pagesCount - 1;
        }
        return i6;
    }

    public void dispose() {
        PdfDocument pdfDocument;
        PdfiumCore pdfiumCore = this.pdfiumCore;
        if (pdfiumCore != null && (pdfDocument = this.pdfDocument) != null) {
            pdfiumCore.a(pdfDocument);
        }
        this.pdfDocument = null;
        this.originalUserPages = null;
    }

    public int documentPage(int i6) {
        int i7;
        int[] iArr = this.originalUserPages;
        if (iArr == null) {
            i7 = i6;
        } else {
            if (i6 < 0 || i6 >= iArr.length) {
                return -1;
            }
            i7 = iArr[i6];
        }
        if (i7 < 0 || i6 >= getPagesCount()) {
            return -1;
        }
        return i7;
    }

    public List<PdfDocument.Bookmark> getBookmarks() {
        PdfDocument pdfDocument = this.pdfDocument;
        return pdfDocument == null ? new ArrayList() : this.pdfiumCore.k(pdfDocument);
    }

    public float getDocLen(float f6) {
        return this.documentLength * f6;
    }

    public SizeF getMaxPageSize() {
        return this.isVertical ? this.maxWidthPageSize : this.maxHeightPageSize;
    }

    public PdfDocument.Meta getMetaData() {
        PdfDocument pdfDocument = this.pdfDocument;
        if (pdfDocument == null) {
            return null;
        }
        return this.pdfiumCore.b(pdfDocument);
    }

    public float getPageSpacing(int i6, float f6) {
        return (this.autoSpacing ? this.pageSpacing.get(i6).floatValue() : this.spacingPx) * f6;
    }

    public int getPagesCount() {
        return this.pagesCount;
    }

    public void recalculatePageSizes(Size size) {
        this.pageSizes.clear();
        PageSizeCalculator pageSizeCalculator = new PageSizeCalculator(this.pageFitPolicy, this.originalMaxWidthPageSize, this.originalMaxHeightPageSize, size, this.fitEachPage);
        this.maxWidthPageSize = pageSizeCalculator.getOptimalMaxWidthPageSize();
        this.maxHeightPageSize = pageSizeCalculator.getOptimalMaxHeightPageSize();
        Iterator<Size> it = this.originalPageSizes.iterator();
        while (it.hasNext()) {
            this.pageSizes.add(pageSizeCalculator.calculate(it.next()));
        }
        if (this.autoSpacing) {
            prepareAutoSpacing(size);
        }
        prepareDocLen();
        preparePagesOffset();
    }

    PdfFile(PdfiumCore pdfiumCore, PdfDocument pdfDocument, FitPolicy fitPolicy, Size size, int[] iArr, boolean z5, int i6, boolean z6, boolean z7) {
        this.pdfiumCore = pdfiumCore;
        this.pdfDocument = pdfDocument;
        this.pageFitPolicy = fitPolicy;
        this.originalUserPages = iArr;
        this.isVertical = z5;
        this.spacingPx = i6;
        this.autoSpacing = z6;
        this.fitEachPage = z7;
        setup(size);
    }

    public float getMaxPageHeight() {
        return getMaxPageSize().a();
    }

    public float getMaxPageWidth() {
        return getMaxPageSize().b();
    }

    public float getPageLength(int i6, float f6) {
        float b6;
        SizeF pageSize = getPageSize(i6);
        if (this.isVertical) {
            b6 = pageSize.a();
        } else {
            b6 = pageSize.b();
        }
        return b6 * f6;
    }

    public List<PdfDocument.Link> getPageLinks(int i6) {
        return this.pdfiumCore.g(this.pdfDocument, documentPage(i6));
    }

    public float getPageOffset(int i6, float f6) {
        if (documentPage(i6) < 0) {
            return 0.0f;
        }
        return this.pageOffsets.get(i6).floatValue() * f6;
    }

    public SizeF getPageSize(int i6) {
        if (documentPage(i6) < 0) {
            return new SizeF(0.0f, 0.0f);
        }
        return this.pageSizes.get(i6);
    }

    public SizeF getScaledPageSize(int i6, float f6) {
        SizeF pageSize = getPageSize(i6);
        return new SizeF(pageSize.b() * f6, pageSize.a() * f6);
    }

    public float getSecondaryPageOffset(int i6, float f6) {
        float maxPageHeight;
        float a6;
        SizeF pageSize = getPageSize(i6);
        if (this.isVertical) {
            maxPageHeight = getMaxPageWidth();
            a6 = pageSize.b();
        } else {
            maxPageHeight = getMaxPageHeight();
            a6 = pageSize.a();
        }
        return (f6 * (maxPageHeight - a6)) / 2.0f;
    }

    public RectF mapRectToDevice(int i6, int i7, int i8, int i9, int i10, RectF rectF) {
        return this.pdfiumCore.m(this.pdfDocument, documentPage(i6), i7, i8, i9, i10, 0, rectF);
    }

    public boolean openPage(int i6) throws PageRenderingException {
        int documentPage = documentPage(i6);
        if (documentPage < 0) {
            return false;
        }
        synchronized (lock) {
            try {
                if (this.openedPages.indexOfKey(documentPage) >= 0) {
                    return false;
                }
                try {
                    this.pdfiumCore.r(this.pdfDocument, documentPage);
                    this.openedPages.put(documentPage, true);
                    return true;
                } catch (Exception e6) {
                    this.openedPages.put(documentPage, false);
                    throw new PageRenderingException(i6, e6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean pageHasError(int i6) {
        return !this.openedPages.get(documentPage(i6), false);
    }

    public void renderPageBitmap(Bitmap bitmap, int i6, Rect rect, boolean z5) {
        this.pdfiumCore.x(this.pdfDocument, bitmap, documentPage(i6), rect.left, rect.top, rect.width(), rect.height(), z5);
    }
}
