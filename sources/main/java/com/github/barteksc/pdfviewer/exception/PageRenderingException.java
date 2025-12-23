package com.github.barteksc.pdfviewer.exception;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class PageRenderingException extends Exception {
    private final int page;

    public int getPage() {
        return this.page;
    }

    public PageRenderingException(int i6, Throwable th) {
        super(th);
        this.page = i6;
    }
}
