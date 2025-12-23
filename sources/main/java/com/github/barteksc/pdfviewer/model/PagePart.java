package com.github.barteksc.pdfviewer.model;

import android.graphics.Bitmap;
import android.graphics.RectF;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class PagePart {
    private int cacheOrder;
    private int page;
    private RectF pageRelativeBounds;
    private Bitmap renderedBitmap;
    private boolean thumbnail;

    public boolean equals(Object obj) {
        if (!(obj instanceof PagePart)) {
            return false;
        }
        PagePart pagePart = (PagePart) obj;
        return pagePart.getPage() == this.page && pagePart.getPageRelativeBounds().left == this.pageRelativeBounds.left && pagePart.getPageRelativeBounds().right == this.pageRelativeBounds.right && pagePart.getPageRelativeBounds().top == this.pageRelativeBounds.top && pagePart.getPageRelativeBounds().bottom == this.pageRelativeBounds.bottom;
    }

    public int getCacheOrder() {
        return this.cacheOrder;
    }

    public int getPage() {
        return this.page;
    }

    public RectF getPageRelativeBounds() {
        return this.pageRelativeBounds;
    }

    public Bitmap getRenderedBitmap() {
        return this.renderedBitmap;
    }

    public boolean isThumbnail() {
        return this.thumbnail;
    }

    public void setCacheOrder(int i6) {
        this.cacheOrder = i6;
    }

    public PagePart(int i6, Bitmap bitmap, RectF rectF, boolean z5, int i7) {
        this.page = i6;
        this.renderedBitmap = bitmap;
        this.pageRelativeBounds = rectF;
        this.thumbnail = z5;
        this.cacheOrder = i7;
    }
}
