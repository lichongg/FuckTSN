package com.github.barteksc.pdfviewer.link;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.model.LinkTapEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class DefaultLinkHandler implements LinkHandler {
    private static final String TAG = "DefaultLinkHandler";
    private PDFView pdfView;

    private void handlePage(int i6) {
        this.pdfView.jumpTo(i6);
    }

    public DefaultLinkHandler(PDFView pDFView) {
        this.pdfView = pDFView;
    }

    private void handleUri(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        Context context = this.pdfView.getContext();
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    @Override // com.github.barteksc.pdfviewer.link.LinkHandler
    public void handleLinkEvent(LinkTapEvent linkTapEvent) {
        String c6 = linkTapEvent.getLink().c();
        Integer b6 = linkTapEvent.getLink().b();
        if (c6 != null && !c6.isEmpty()) {
            handleUri(c6);
        } else if (b6 != null) {
            handlePage(b6.intValue());
        }
    }
}
