package com.shockwave.pdfium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.Size;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class PdfiumCore {

    /* renamed from: b, reason: collision with root package name */
    private static final String f37505b = "com.shockwave.pdfium.PdfiumCore";

    /* renamed from: c, reason: collision with root package name */
    private static final Class f37506c = FileDescriptor.class;

    /* renamed from: d, reason: collision with root package name */
    private static final String f37507d = "descriptor";

    /* renamed from: e, reason: collision with root package name */
    private static final Object f37508e;

    /* renamed from: f, reason: collision with root package name */
    private static Field f37509f;

    /* renamed from: a, reason: collision with root package name */
    private int f37510a;

    public static int c(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            if (f37509f == null) {
                Field declaredField = f37506c.getDeclaredField(f37507d);
                f37509f = declaredField;
                declaredField.setAccessible(true);
            }
            return f37509f.getInt(parcelFileDescriptor.getFileDescriptor());
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return -1;
        } catch (NoSuchFieldException e7) {
            e7.printStackTrace();
            return -1;
        }
    }

    private native void nativeCloseDocument(long j6);

    private native void nativeClosePage(long j6);

    private native void nativeClosePages(long[] jArr);

    private native long nativeGetBookmarkDestIndex(long j6, long j7);

    private native String nativeGetBookmarkTitle(long j6);

    private native Integer nativeGetDestPageIndex(long j6, long j7);

    private native String nativeGetDocumentMetaText(long j6, String str);

    private native Long nativeGetFirstChildBookmark(long j6, Long l6);

    private native RectF nativeGetLinkRect(long j6);

    private native String nativeGetLinkURI(long j6, long j7);

    private native int nativeGetPageCount(long j6);

    private native int nativeGetPageHeightPixel(long j6, int i6);

    private native int nativeGetPageHeightPoint(long j6);

    private native long[] nativeGetPageLinks(long j6);

    private native Size nativeGetPageSizeByIndex(long j6, int i6, int i7);

    private native int nativeGetPageWidthPixel(long j6, int i6);

    private native int nativeGetPageWidthPoint(long j6);

    private native Long nativeGetSiblingBookmark(long j6, long j7);

    private native long nativeLoadPage(long j6, int i6);

    private native long[] nativeLoadPages(long j6, int i6, int i7);

    private native long nativeOpenDocument(int i6, String str);

    private native long nativeOpenMemDocument(byte[] bArr, String str);

    private native Point nativePageCoordsToDevice(long j6, int i6, int i7, int i8, int i9, int i10, double d6, double d7);

    private native void nativeRenderPage(long j6, Surface surface, int i6, int i7, int i8, int i9, int i10, boolean z5);

    private native void nativeRenderPageBitmap(long j6, Bitmap bitmap, int i6, int i7, int i8, int i9, int i10, boolean z5);

    public PdfDocument n(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        return o(parcelFileDescriptor, null);
    }

    public PdfDocument p(byte[] bArr) throws IOException {
        return q(bArr, null);
    }

    public void u(PdfDocument pdfDocument, Surface surface, int i6, int i7, int i8, int i9, int i10) {
        v(pdfDocument, surface, i6, i7, i8, i9, i10, false);
    }

    public void w(PdfDocument pdfDocument, Bitmap bitmap, int i6, int i7, int i8, int i9, int i10) {
        x(pdfDocument, bitmap, i6, i7, i8, i9, i10, false);
    }

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("modpng");
            System.loadLibrary("modft2");
            System.loadLibrary("modpdfium");
            System.loadLibrary("jniPdfium");
        } catch (UnsatisfiedLinkError e6) {
            e6.toString();
        }
        f37508e = new Object();
        f37509f = null;
    }

    private void t(List<PdfDocument.Bookmark> list, PdfDocument pdfDocument, long j6) {
        PdfDocument.Bookmark bookmark = new PdfDocument.Bookmark();
        bookmark.f37493d = j6;
        bookmark.f37491b = nativeGetBookmarkTitle(j6);
        bookmark.f37492c = nativeGetBookmarkDestIndex(pdfDocument.f37487a, j6);
        list.add(bookmark);
        Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.f37487a, Long.valueOf(j6));
        if (nativeGetFirstChildBookmark != null) {
            t(bookmark.a(), pdfDocument, nativeGetFirstChildBookmark.longValue());
        }
        Long nativeGetSiblingBookmark = nativeGetSiblingBookmark(pdfDocument.f37487a, j6);
        if (nativeGetSiblingBookmark != null) {
            t(list, pdfDocument, nativeGetSiblingBookmark.longValue());
        }
    }

    public void a(PdfDocument pdfDocument) {
        synchronized (f37508e) {
            try {
                Iterator<Integer> it = pdfDocument.f37489c.keySet().iterator();
                while (it.hasNext()) {
                    nativeClosePage(pdfDocument.f37489c.get(it.next()).longValue());
                }
                pdfDocument.f37489c.clear();
                nativeCloseDocument(pdfDocument.f37487a);
                ParcelFileDescriptor parcelFileDescriptor = pdfDocument.f37488b;
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException unused) {
                    }
                    pdfDocument.f37488b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PdfDocument.Meta b(PdfDocument pdfDocument) {
        PdfDocument.Meta meta;
        synchronized (f37508e) {
            meta = new PdfDocument.Meta();
            meta.f37497a = nativeGetDocumentMetaText(pdfDocument.f37487a, "Title");
            meta.f37498b = nativeGetDocumentMetaText(pdfDocument.f37487a, "Author");
            meta.f37499c = nativeGetDocumentMetaText(pdfDocument.f37487a, "Subject");
            meta.f37500d = nativeGetDocumentMetaText(pdfDocument.f37487a, "Keywords");
            meta.f37501e = nativeGetDocumentMetaText(pdfDocument.f37487a, "Creator");
            meta.f37502f = nativeGetDocumentMetaText(pdfDocument.f37487a, "Producer");
            meta.f37503g = nativeGetDocumentMetaText(pdfDocument.f37487a, "CreationDate");
            meta.f37504h = nativeGetDocumentMetaText(pdfDocument.f37487a, "ModDate");
        }
        return meta;
    }

    public int d(PdfDocument pdfDocument) {
        int nativeGetPageCount;
        synchronized (f37508e) {
            nativeGetPageCount = nativeGetPageCount(pdfDocument.f37487a);
        }
        return nativeGetPageCount;
    }

    public int e(PdfDocument pdfDocument, int i6) {
        synchronized (f37508e) {
            try {
                Long l6 = pdfDocument.f37489c.get(Integer.valueOf(i6));
                if (l6 == null) {
                    return 0;
                }
                return nativeGetPageHeightPixel(l6.longValue(), this.f37510a);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int f(PdfDocument pdfDocument, int i6) {
        synchronized (f37508e) {
            try {
                Long l6 = pdfDocument.f37489c.get(Integer.valueOf(i6));
                if (l6 == null) {
                    return 0;
                }
                return nativeGetPageHeightPoint(l6.longValue());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public List<PdfDocument.Link> g(PdfDocument pdfDocument, int i6) {
        synchronized (f37508e) {
            try {
                ArrayList arrayList = new ArrayList();
                Long l6 = pdfDocument.f37489c.get(Integer.valueOf(i6));
                if (l6 == null) {
                    return arrayList;
                }
                for (long j6 : nativeGetPageLinks(l6.longValue())) {
                    Integer nativeGetDestPageIndex = nativeGetDestPageIndex(pdfDocument.f37487a, j6);
                    String nativeGetLinkURI = nativeGetLinkURI(pdfDocument.f37487a, j6);
                    RectF nativeGetLinkRect = nativeGetLinkRect(j6);
                    if (nativeGetLinkRect != null && (nativeGetDestPageIndex != null || nativeGetLinkURI != null)) {
                        arrayList.add(new PdfDocument.Link(nativeGetLinkRect, nativeGetDestPageIndex, nativeGetLinkURI));
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Size h(PdfDocument pdfDocument, int i6) {
        Size nativeGetPageSizeByIndex;
        synchronized (f37508e) {
            nativeGetPageSizeByIndex = nativeGetPageSizeByIndex(pdfDocument.f37487a, i6, this.f37510a);
        }
        return nativeGetPageSizeByIndex;
    }

    public int i(PdfDocument pdfDocument, int i6) {
        synchronized (f37508e) {
            try {
                Long l6 = pdfDocument.f37489c.get(Integer.valueOf(i6));
                if (l6 == null) {
                    return 0;
                }
                return nativeGetPageWidthPixel(l6.longValue(), this.f37510a);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int j(PdfDocument pdfDocument, int i6) {
        synchronized (f37508e) {
            try {
                Long l6 = pdfDocument.f37489c.get(Integer.valueOf(i6));
                if (l6 == null) {
                    return 0;
                }
                return nativeGetPageWidthPoint(l6.longValue());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public List<PdfDocument.Bookmark> k(PdfDocument pdfDocument) {
        ArrayList arrayList;
        synchronized (f37508e) {
            try {
                arrayList = new ArrayList();
                Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.f37487a, null);
                if (nativeGetFirstChildBookmark != null) {
                    t(arrayList, pdfDocument, nativeGetFirstChildBookmark.longValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public Point l(PdfDocument pdfDocument, int i6, int i7, int i8, int i9, int i10, int i11, double d6, double d7) {
        return nativePageCoordsToDevice(pdfDocument.f37489c.get(Integer.valueOf(i6)).longValue(), i7, i8, i9, i10, i11, d6, d7);
    }

    public RectF m(PdfDocument pdfDocument, int i6, int i7, int i8, int i9, int i10, int i11, RectF rectF) {
        Point l6 = l(pdfDocument, i6, i7, i8, i9, i10, i11, rectF.left, rectF.top);
        Point l7 = l(pdfDocument, i6, i7, i8, i9, i10, i11, rectF.right, rectF.bottom);
        return new RectF(l6.x, l6.y, l7.x, l7.y);
    }

    public PdfDocument o(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.f37488b = parcelFileDescriptor;
        synchronized (f37508e) {
            pdfDocument.f37487a = nativeOpenDocument(c(parcelFileDescriptor), str);
        }
        return pdfDocument;
    }

    public PdfDocument q(byte[] bArr, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        synchronized (f37508e) {
            pdfDocument.f37487a = nativeOpenMemDocument(bArr, str);
        }
        return pdfDocument;
    }

    public long r(PdfDocument pdfDocument, int i6) {
        long nativeLoadPage;
        synchronized (f37508e) {
            nativeLoadPage = nativeLoadPage(pdfDocument.f37487a, i6);
            pdfDocument.f37489c.put(Integer.valueOf(i6), Long.valueOf(nativeLoadPage));
        }
        return nativeLoadPage;
    }

    public long[] s(PdfDocument pdfDocument, int i6, int i7) {
        long[] nativeLoadPages;
        synchronized (f37508e) {
            try {
                nativeLoadPages = nativeLoadPages(pdfDocument.f37487a, i6, i7);
                for (long j6 : nativeLoadPages) {
                    if (i6 <= i7) {
                        pdfDocument.f37489c.put(Integer.valueOf(i6), Long.valueOf(j6));
                        i6++;
                    }
                }
            } finally {
            }
        }
        return nativeLoadPages;
    }

    public void v(PdfDocument pdfDocument, Surface surface, int i6, int i7, int i8, int i9, int i10, boolean z5) {
        synchronized (f37508e) {
            try {
                nativeRenderPage(pdfDocument.f37489c.get(Integer.valueOf(i6)).longValue(), surface, this.f37510a, i7, i8, i9, i10, z5);
            } catch (NullPointerException e6) {
                e6.printStackTrace();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    public void x(PdfDocument pdfDocument, Bitmap bitmap, int i6, int i7, int i8, int i9, int i10, boolean z5) {
        synchronized (f37508e) {
            try {
                nativeRenderPageBitmap(pdfDocument.f37489c.get(Integer.valueOf(i6)).longValue(), bitmap, this.f37510a, i7, i8, i9, i10, z5);
            } catch (NullPointerException e6) {
                e6.printStackTrace();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    public PdfiumCore(Context context) {
        this.f37510a = context.getResources().getDisplayMetrics().densityDpi;
    }
}
