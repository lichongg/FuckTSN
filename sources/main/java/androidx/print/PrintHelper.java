package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PrintHelper {

    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;

    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    final Context mContext;
    BitmapFactory.Options mDecodeOptions = null;
    final Object mLock = new Object();
    int mScaleMode = 2;
    int mColorMode = 2;
    int mOrientation = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(19)
    private class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;

        PrintBitmapAdapter(String str, int i6, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            this.mJobName = str;
            this.mFittingMode = i6;
            this.mBitmap = bitmap;
            this.mCallback = onPrintFinishCallback;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.mAttributes = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(19)
    private class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap = null;
        final OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(final PrintAttributes printAttributes, final PrintAttributes printAttributes2, final CancellationSignal cancellationSignal, final PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                try {
                    this.mAttributes = printAttributes2;
                } catch (Throwable th) {
                    th = th;
                    while (true) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.mBitmap != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                this.mLoadBitmap = new AsyncTask<Uri, Boolean, Bitmap>() { // from class: androidx.print.PrintHelper.PrintUriAdapter.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public Bitmap doInBackground(Uri... uriArr) {
                        try {
                            PrintUriAdapter printUriAdapter = PrintUriAdapter.this;
                            return PrintHelper.this.loadConstrainedBitmap(printUriAdapter.mImageFile);
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public void onCancelled(Bitmap bitmap) {
                        layoutResultCallback.onLayoutCancelled();
                        PrintUriAdapter.this.mLoadBitmap = null;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
                    @Override // android.os.AsyncTask
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onPostExecute(android.graphics.Bitmap r10) {
                        /*
                            r9 = this;
                            super.onPostExecute(r10)
                            if (r10 == 0) goto L12
                            boolean r0 = androidx.print.PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION
                            if (r0 == 0) goto L14
                            androidx.print.PrintHelper$PrintUriAdapter r0 = androidx.print.PrintHelper.PrintUriAdapter.this
                            androidx.print.PrintHelper r0 = androidx.print.PrintHelper.this
                            int r0 = r0.mOrientation
                            if (r0 != 0) goto L12
                            goto L14
                        L12:
                            r2 = r10
                            goto L49
                        L14:
                            monitor-enter(r9)
                            androidx.print.PrintHelper$PrintUriAdapter r0 = androidx.print.PrintHelper.PrintUriAdapter.this     // Catch: java.lang.Throwable -> L45
                            android.print.PrintAttributes r0 = r0.mAttributes     // Catch: java.lang.Throwable -> L45
                            android.print.PrintAttributes$MediaSize r0 = r0.getMediaSize()     // Catch: java.lang.Throwable -> L45
                            monitor-exit(r9)     // Catch: java.lang.Throwable -> L45
                            if (r0 == 0) goto L12
                            boolean r0 = r0.isPortrait()
                            boolean r1 = androidx.print.PrintHelper.isPortrait(r10)
                            if (r0 == r1) goto L12
                            android.graphics.Matrix r7 = new android.graphics.Matrix
                            r7.<init>()
                            r0 = 1119092736(0x42b40000, float:90.0)
                            r7.postRotate(r0)
                            int r5 = r10.getWidth()
                            int r6 = r10.getHeight()
                            r8 = 1
                            r3 = 0
                            r4 = 0
                            r2 = r10
                            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)
                            goto L4a
                        L45:
                            r0 = move-exception
                            r10 = r0
                            monitor-exit(r9)     // Catch: java.lang.Throwable -> L45
                            throw r10
                        L49:
                            r10 = r2
                        L4a:
                            androidx.print.PrintHelper$PrintUriAdapter r0 = androidx.print.PrintHelper.PrintUriAdapter.this
                            r0.mBitmap = r10
                            r0 = 0
                            if (r10 == 0) goto L76
                            android.print.PrintDocumentInfo$Builder r10 = new android.print.PrintDocumentInfo$Builder
                            androidx.print.PrintHelper$PrintUriAdapter r1 = androidx.print.PrintHelper.PrintUriAdapter.this
                            java.lang.String r1 = r1.mJobName
                            r10.<init>(r1)
                            r1 = 1
                            android.print.PrintDocumentInfo$Builder r10 = r10.setContentType(r1)
                            android.print.PrintDocumentInfo$Builder r10 = r10.setPageCount(r1)
                            android.print.PrintDocumentInfo r10 = r10.build()
                            android.print.PrintAttributes r2 = r3
                            android.print.PrintAttributes r3 = r4
                            boolean r2 = r2.equals(r3)
                            r1 = r1 ^ r2
                            android.print.PrintDocumentAdapter$LayoutResultCallback r2 = r5
                            r2.onLayoutFinished(r10, r1)
                            goto L7b
                        L76:
                            android.print.PrintDocumentAdapter$LayoutResultCallback r10 = r5
                            r10.onLayoutFailed(r0)
                        L7b:
                            androidx.print.PrintHelper$PrintUriAdapter r10 = androidx.print.PrintHelper.PrintUriAdapter.this
                            r10.mLoadBitmap = r0
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.PrintUriAdapter.AnonymousClass1.onPostExecute(android.graphics.Bitmap):void");
                    }

                    @Override // android.os.AsyncTask
                    protected void onPreExecute() {
                        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.print.PrintHelper.PrintUriAdapter.1.1
                            @Override // android.os.CancellationSignal.OnCancelListener
                            public void onCancel() {
                                PrintUriAdapter.this.cancelLoad();
                                cancel(false);
                            }
                        });
                    }
                }.execute(new Uri[0]);
            }
        }

        PrintUriAdapter(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i6) {
            this.mJobName = str;
            this.mImageFile = uri;
            this.mCallback = onPrintFinishCallback;
            this.mFittingMode = i6;
        }

        void cancelLoad() {
            synchronized (PrintHelper.this.mLock) {
                try {
                    BitmapFactory.Options options = PrintHelper.this.mDecodeOptions;
                    if (options != null) {
                        if (Build.VERSION.SDK_INT < 24) {
                            options.requestCancelDecode();
                        }
                        PrintHelper.this.mDecodeOptions = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            cancelLoad();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.mLoadBitmap;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mBitmap = null;
            }
        }
    }

    static Bitmap convertBitmapForColorMode(Bitmap bitmap, int i6) {
        if (i6 != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static boolean systemSupportsPrint() {
        return true;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap) {
        printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = i6 > 23;
        IS_MIN_MARGINS_HANDLING_CORRECT = i6 != 23;
    }

    @RequiresApi(19)
    private static PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        int duplexMode;
        int duplexMode2;
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            duplexMode = printAttributes.getDuplexMode();
            if (duplexMode != 0) {
                duplexMode2 = printAttributes.getDuplexMode();
                minMargins.setDuplexMode(duplexMode2);
            }
        }
        return minMargins;
    }

    static Matrix getMatrix(int i6, int i7, RectF rectF, int i8) {
        Matrix matrix = new Matrix();
        float f6 = i6;
        float width = rectF.width() / f6;
        float max = i8 == 2 ? Math.max(width, rectF.height() / i7) : Math.min(width, rectF.height() / i7);
        matrix.postScale(max, max);
        matrix.postTranslate((rectF.width() - (f6 * max)) / 2.0f, (rectF.height() - (i7 * max)) / 2.0f);
        return matrix;
    }

    private Bitmap loadBitmap(Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
        Context context;
        InputStream openInputStream;
        if (uri == null || (context = this.mContext) == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        InputStream inputStream = null;
        try {
            openInputStream = context.getContentResolver().openInputStream(uri);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return decodeStream;
        } catch (Throwable th2) {
            th = th2;
            inputStream = openInputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public int getOrientation() {
        int i6 = this.mOrientation;
        if (i6 == 0) {
            return 1;
        }
        return i6;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    Bitmap loadConstrainedBitmap(Uri uri) throws FileNotFoundException {
        BitmapFactory.Options options;
        if (uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        loadBitmap(uri, options2);
        int i6 = options2.outWidth;
        int i7 = options2.outHeight;
        if (i6 > 0 && i7 > 0) {
            int max = Math.max(i6, i7);
            int i8 = 1;
            while (max > MAX_PRINT_SIZE) {
                max >>>= 1;
                i8 <<= 1;
            }
            if (i8 > 0 && Math.min(i6, i7) / i8 > 0) {
                synchronized (this.mLock) {
                    options = new BitmapFactory.Options();
                    this.mDecodeOptions = options;
                    options.inMutable = true;
                    options.inSampleSize = i8;
                }
                try {
                    Bitmap loadBitmap = loadBitmap(uri, options);
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                    }
                    return loadBitmap;
                } catch (Throwable th) {
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap, @Nullable OnPrintFinishCallback onPrintFinishCallback) {
        if (bitmap == null) {
            return;
        }
        ((PrintManager) this.mContext.getSystemService("print")).print(str, new PrintBitmapAdapter(str, this.mScaleMode, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(isPortrait(bitmap) ? PrintAttributes.MediaSize.UNKNOWN_PORTRAIT : PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE).setColorMode(this.mColorMode).build());
    }

    public void setColorMode(int i6) {
        this.mColorMode = i6;
    }

    public void setOrientation(int i6) {
        this.mOrientation = i6;
    }

    public void setScaleMode(int i6) {
        this.mScaleMode = i6;
    }

    @RequiresApi(19)
    void writeBitmap(final PrintAttributes printAttributes, final int i6, final Bitmap bitmap, final ParcelFileDescriptor parcelFileDescriptor, final CancellationSignal cancellationSignal, final PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        final PrintAttributes build = IS_MIN_MARGINS_HANDLING_CORRECT ? printAttributes : copyAttributes(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        new AsyncTask<Void, Void, Throwable>() { // from class: androidx.print.PrintHelper.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Throwable doInBackground(Void... voidArr) {
                RectF rectF;
                try {
                    if (cancellationSignal.isCanceled()) {
                        return null;
                    }
                    PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelper.this.mContext, build);
                    Bitmap convertBitmapForColorMode = PrintHelper.convertBitmapForColorMode(bitmap, build.getColorMode());
                    if (cancellationSignal.isCanceled()) {
                        return null;
                    }
                    try {
                        PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                        boolean z5 = PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT;
                        if (z5) {
                            rectF = new RectF(startPage.getInfo().getContentRect());
                        } else {
                            PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(PrintHelper.this.mContext, printAttributes);
                            PdfDocument.Page startPage2 = printedPdfDocument2.startPage(1);
                            RectF rectF2 = new RectF(startPage2.getInfo().getContentRect());
                            printedPdfDocument2.finishPage(startPage2);
                            printedPdfDocument2.close();
                            rectF = rectF2;
                        }
                        Matrix matrix = PrintHelper.getMatrix(convertBitmapForColorMode.getWidth(), convertBitmapForColorMode.getHeight(), rectF, i6);
                        if (!z5) {
                            matrix.postTranslate(rectF.left, rectF.top);
                            startPage.getCanvas().clipRect(rectF);
                        }
                        startPage.getCanvas().drawBitmap(convertBitmapForColorMode, matrix, null);
                        printedPdfDocument.finishPage(startPage);
                        if (cancellationSignal.isCanceled()) {
                            printedPdfDocument.close();
                            ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
                            if (parcelFileDescriptor2 != null) {
                                try {
                                    parcelFileDescriptor2.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (convertBitmapForColorMode != bitmap) {
                                convertBitmapForColorMode.recycle();
                            }
                            return null;
                        }
                        printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                        printedPdfDocument.close();
                        ParcelFileDescriptor parcelFileDescriptor3 = parcelFileDescriptor;
                        if (parcelFileDescriptor3 != null) {
                            try {
                                parcelFileDescriptor3.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (convertBitmapForColorMode != bitmap) {
                            convertBitmapForColorMode.recycle();
                        }
                        return null;
                    } finally {
                    }
                } catch (Throwable th) {
                    return th;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Throwable th) {
                if (cancellationSignal.isCanceled()) {
                    writeResultCallback.onWriteCancelled();
                } else if (th == null) {
                    writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } else {
                    writeResultCallback.onWriteFailed(null);
                }
            }
        }.execute(new Void[0]);
    }

    public PrintHelper(@NonNull Context context) {
        this.mContext = context;
    }

    static boolean isPortrait(Bitmap bitmap) {
        if (bitmap.getWidth() <= bitmap.getHeight()) {
            return true;
        }
        return false;
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri) throws FileNotFoundException {
        printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri, @Nullable OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        PrintUriAdapter printUriAdapter = new PrintUriAdapter(str, uri, onPrintFinishCallback, this.mScaleMode);
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.mColorMode);
        int i6 = this.mOrientation;
        if (i6 == 1 || i6 == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i6 == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, printUriAdapter, builder.build());
    }
}
