package com.github.barteksc.pdfviewer;

import android.os.AsyncTask;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class DecodingAsyncTask extends AsyncTask<Void, Void, Throwable> {
    private boolean cancelled = false;
    private DocumentSource docSource;
    private String password;
    private PdfFile pdfFile;
    private WeakReference<PDFView> pdfViewReference;
    private PdfiumCore pdfiumCore;
    private int[] userPages;

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.cancelled = true;
    }

    private Size getViewSize(PDFView pDFView) {
        return new Size(pDFView.getWidth(), pDFView.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Throwable doInBackground(Void... voidArr) {
        try {
            PDFView pDFView = this.pdfViewReference.get();
            if (pDFView == null) {
                return new NullPointerException("pdfView == null");
            }
            this.pdfFile = new PdfFile(this.pdfiumCore, this.docSource.createDocument(pDFView.getContext(), this.pdfiumCore, this.password), pDFView.getPageFitPolicy(), getViewSize(pDFView), this.userPages, pDFView.isSwipeVertical(), pDFView.getSpacingPx(), pDFView.isAutoSpacingEnabled(), pDFView.isFitEachPage());
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Throwable th) {
        PDFView pDFView = this.pdfViewReference.get();
        if (pDFView != null) {
            if (th != null) {
                pDFView.loadError(th);
            } else {
                if (this.cancelled) {
                    return;
                }
                pDFView.loadComplete(this.pdfFile);
            }
        }
    }

    DecodingAsyncTask(DocumentSource documentSource, String str, int[] iArr, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.docSource = documentSource;
        this.userPages = iArr;
        this.pdfViewReference = new WeakReference<>(pDFView);
        this.password = str;
        this.pdfiumCore = pdfiumCore;
    }
}
