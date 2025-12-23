package com.github.barteksc.pdfviewer.model;

import android.graphics.RectF;
import com.shockwave.pdfium.PdfDocument;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class LinkTapEvent {
    private float documentX;
    private float documentY;
    private PdfDocument.Link link;
    private RectF mappedLinkRect;
    private float originalX;
    private float originalY;

    public float getDocumentX() {
        return this.documentX;
    }

    public float getDocumentY() {
        return this.documentY;
    }

    public PdfDocument.Link getLink() {
        return this.link;
    }

    public RectF getMappedLinkRect() {
        return this.mappedLinkRect;
    }

    public float getOriginalX() {
        return this.originalX;
    }

    public float getOriginalY() {
        return this.originalY;
    }

    public LinkTapEvent(float f6, float f7, float f8, float f9, RectF rectF, PdfDocument.Link link) {
        this.originalX = f6;
        this.originalY = f7;
        this.documentX = f8;
        this.documentY = f9;
        this.mappedLinkRect = rectF;
        this.link = link;
    }
}
