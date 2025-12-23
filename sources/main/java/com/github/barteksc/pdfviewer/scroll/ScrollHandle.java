package com.github.barteksc.pdfviewer.scroll;

import com.github.barteksc.pdfviewer.PDFView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface ScrollHandle {
    void destroyLayout();

    void hide();

    void hideDelayed();

    void setPageNum(int i6);

    void setScroll(float f6);

    void setupLayout(PDFView pDFView);

    void show();

    boolean shown();
}
