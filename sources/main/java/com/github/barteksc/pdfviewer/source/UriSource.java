package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import android.net.Uri;
import com.kuaishou.weapon.p0.t;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class UriSource implements DocumentSource {
    private Uri uri;

    public UriSource(Uri uri) {
        this.uri = uri;
    }

    @Override // com.github.barteksc.pdfviewer.source.DocumentSource
    public PdfDocument createDocument(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.o(context.getContentResolver().openFileDescriptor(this.uri, t.f36150k), str);
    }
}
