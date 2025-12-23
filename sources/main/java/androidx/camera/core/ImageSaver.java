package androidx.camera.core;

import android.content.ContentValues;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class ImageSaver implements Runnable {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TAG = "ImageSaver";
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";

    @NonNull
    private final OnImageSavedCallback mCallback;
    private final ImageProxy mImage;
    private final int mJpegQuality;
    private final int mOrientation;

    @NonNull
    private final ImageCapture.OutputFileOptions mOutputFileOptions;

    @NonNull
    private final Executor mSequentialIoExecutor;

    @NonNull
    private final Executor mUserCallbackExecutor;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnImageSavedCallback {
        void onError(@NonNull SaveError saveError, @NonNull String str, @Nullable Throwable th);

        void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum SaveError {
        FILE_IO_FAILED,
        ENCODE_FAILED,
        CROP_FAILED,
        UNKNOWN
    }

    @Nullable
    private File saveImageToTempFile() {
        File createTempFile;
        SaveError saveError;
        String str;
        Throwable th;
        ImageProxy imageProxy;
        try {
            if (isSaveToFile()) {
                createTempFile = new File(this.mOutputFileOptions.getFile().getParent(), TEMP_FILE_PREFIX + UUID.randomUUID().toString() + getFileExtensionWithDot(this.mOutputFileOptions.getFile()));
            } else {
                createTempFile = File.createTempFile(TEMP_FILE_PREFIX, ".tmp");
            }
            try {
                imageProxy = this.mImage;
            } catch (ImageUtil.CodecFailedException e6) {
                int i6 = AnonymousClass1.$SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType[e6.getFailureType().ordinal()];
                if (i6 == 1) {
                    saveError = SaveError.ENCODE_FAILED;
                    str = "Failed to encode mImage";
                    th = e6;
                } else if (i6 != 2) {
                    saveError = SaveError.UNKNOWN;
                    str = "Failed to transcode mImage";
                    th = e6;
                } else {
                    saveError = SaveError.CROP_FAILED;
                    str = "Failed to crop mImage";
                    th = e6;
                }
            } catch (IOException e7) {
                e = e7;
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                th = e;
            } catch (IllegalArgumentException e8) {
                e = e8;
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                th = e;
            } catch (OutOfMemoryError e9) {
                saveError = SaveError.UNKNOWN;
                str = "Processing failed due to low memory.";
                th = e9;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                try {
                    fileOutputStream.write(imageToJpegByteArray(this.mImage, this.mJpegQuality));
                    Exif createFromFile = Exif.createFromFile(createTempFile);
                    Exif.createFromImageProxy(this.mImage).copyToCroppedImage(createFromFile);
                    if (!new ExifRotationAvailability().shouldUseExifOrientation(this.mImage)) {
                        createFromFile.rotate(this.mOrientation);
                    }
                    ImageCapture.Metadata metadata = this.mOutputFileOptions.getMetadata();
                    if (metadata.isReversedHorizontal()) {
                        createFromFile.flipHorizontally();
                    }
                    if (metadata.isReversedVertical()) {
                        createFromFile.flipVertically();
                    }
                    if (metadata.getLocation() != null) {
                        createFromFile.attachLocation(this.mOutputFileOptions.getMetadata().getLocation());
                    }
                    createFromFile.save();
                    fileOutputStream.close();
                    if (imageProxy != null) {
                        imageProxy.close();
                    }
                    th = null;
                    saveError = null;
                    str = null;
                    if (saveError == null) {
                        return createTempFile;
                    }
                    postError(saveError, str, th);
                    createTempFile.delete();
                    return null;
                } finally {
                }
            } catch (Throwable th2) {
                if (imageProxy != null) {
                    try {
                        imageProxy.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (IOException e10) {
            postError(SaveError.FILE_IO_FAILED, "Failed to create temp file", e10);
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.core.ImageSaver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType;

        static {
            int[] iArr = new int[ImageUtil.CodecFailedException.FailureType.values().length];
            $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType = iArr;
            try {
                iArr[ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.DECODE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void copyTempFileToOutputStream(@NonNull File file, @NonNull OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private boolean copyTempFileToUri(@NonNull File file, @NonNull Uri uri) throws IOException {
        OutputStream openOutputStream = this.mOutputFileOptions.getContentResolver().openOutputStream(uri);
        if (openOutputStream == null) {
            if (openOutputStream != null) {
                openOutputStream.close();
            }
            return false;
        }
        try {
            copyTempFileToOutputStream(file, openOutputStream);
            openOutputStream.close();
            return true;
        } catch (Throwable th) {
            try {
                openOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private boolean isSaveToFile() {
        return this.mOutputFileOptions.getFile() != null;
    }

    private boolean isSaveToMediaStore() {
        return (this.mOutputFileOptions.getSaveCollection() == null || this.mOutputFileOptions.getContentResolver() == null || this.mOutputFileOptions.getContentValues() == null) ? false : true;
    }

    private boolean isSaveToOutputStream() {
        return this.mOutputFileOptions.getOutputStream() != null;
    }

    private void postError(final SaveError saveError, final String str, @Nullable final Throwable th) {
        try {
            this.mUserCallbackExecutor.execute(new Runnable() { // from class: androidx.camera.core.g0
                @Override // java.lang.Runnable
                public final void run() {
                    ImageSaver.this.mCallback.onError(saveError, str, th);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "Application executor rejected executing OnImageSavedCallback.onError callback. Skipping.");
        }
    }

    private void postSuccess(@Nullable final Uri uri) {
        try {
            this.mUserCallbackExecutor.execute(new Runnable() { // from class: androidx.camera.core.i0
                @Override // java.lang.Runnable
                public final void run() {
                    ImageSaver.this.mCallback.onImageSaved(new ImageCapture.OutputFileResults(uri));
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "Application executor rejected executing OnImageSavedCallback.onImageSaved callback. Skipping.");
        }
    }

    private void setContentValuePending(@NonNull ContentValues contentValues, int i6) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i6));
        }
    }

    private void setUriNotPending(@NonNull Uri uri) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            setContentValuePending(contentValues, 0);
            this.mOutputFileOptions.getContentResolver().update(uri, contentValues, null, null);
        }
    }

    ImageSaver(@NonNull ImageProxy imageProxy, @NonNull ImageCapture.OutputFileOptions outputFileOptions, int i6, @IntRange(from = 1, to = 100) int i7, @NonNull Executor executor, @NonNull Executor executor2, @NonNull OnImageSavedCallback onImageSavedCallback) {
        this.mImage = imageProxy;
        this.mOutputFileOptions = outputFileOptions;
        this.mOrientation = i6;
        this.mJpegQuality = i7;
        this.mCallback = onImageSavedCallback;
        this.mUserCallbackExecutor = executor;
        this.mSequentialIoExecutor = executor2;
    }

    private static String getFileExtensionWithDot(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            return name.substring(lastIndexOf);
        }
        return "";
    }

    @NonNull
    private byte[] imageToJpegByteArray(@NonNull ImageProxy imageProxy, @IntRange(from = 1, to = 100) int i6) throws ImageUtil.CodecFailedException {
        boolean shouldCropImage = ImageUtil.shouldCropImage(imageProxy);
        int format = imageProxy.getFormat();
        if (format == 256) {
            if (!shouldCropImage) {
                return ImageUtil.jpegImageToJpegByteArray(imageProxy);
            }
            return ImageUtil.jpegImageToJpegByteArray(imageProxy, imageProxy.getCropRect(), i6);
        }
        Rect rect = null;
        if (format == 35) {
            if (shouldCropImage) {
                rect = imageProxy.getCropRect();
            }
            return ImageUtil.yuvImageToJpegByteArray(imageProxy, rect, i6, 0);
        }
        Logger.w(TAG, "Unrecognized image format: " + format);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void copyTempFileToDestination(@androidx.annotation.NonNull java.io.File r6) {
        /*
            r5 = this;
            androidx.core.util.Preconditions.checkNotNull(r6)
            r0 = 0
            boolean r1 = r5.isSaveToMediaStore()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            if (r1 == 0) goto L62
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.mOutputFileOptions     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            android.content.ContentValues r1 = r1.getContentValues()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            if (r1 == 0) goto L2b
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            androidx.camera.core.ImageCapture$OutputFileOptions r2 = r5.mOutputFileOptions     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            android.content.ContentValues r2 = r2.getContentValues()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            goto L30
        L1e:
            r0 = move-exception
            goto Laf
        L21:
            r1 = move-exception
        L22:
            r4 = r1
            r1 = r0
            r0 = r4
            goto La0
        L27:
            r1 = move-exception
            goto L22
        L29:
            r1 = move-exception
            goto L22
        L2b:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            r1.<init>()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
        L30:
            r2 = 1
            r5.setContentValuePending(r1, r2)     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            androidx.camera.core.ImageCapture$OutputFileOptions r2 = r5.mOutputFileOptions     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            androidx.camera.core.ImageCapture$OutputFileOptions r3 = r5.mOutputFileOptions     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            android.net.Uri r3 = r3.getSaveCollection()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            android.net.Uri r1 = r2.insert(r3, r1)     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            if (r1 != 0) goto L51
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L4b java.lang.IllegalArgumentException -> L4d java.io.IOException -> L4f
            java.lang.String r3 = "Failed to insert URI."
            goto L9c
        L4b:
            r0 = move-exception
            goto La0
        L4d:
            r0 = move-exception
            goto La0
        L4f:
            r0 = move-exception
            goto La0
        L51:
            boolean r2 = r5.copyTempFileToUri(r6, r1)     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L4b java.lang.IllegalArgumentException -> L4d java.io.IOException -> L4f
            if (r2 != 0) goto L5c
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L4b java.lang.IllegalArgumentException -> L4d java.io.IOException -> L4f
            java.lang.String r3 = "Failed to save to URI."
            goto L5e
        L5c:
            r2 = r0
            r3 = r2
        L5e:
            r5.setUriNotPending(r1)     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L4b java.lang.IllegalArgumentException -> L4d java.io.IOException -> L4f
            goto L9c
        L62:
            boolean r1 = r5.isSaveToOutputStream()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            if (r1 == 0) goto L72
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.mOutputFileOptions     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            java.io.OutputStream r1 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            r5.copyTempFileToOutputStream(r6, r1)     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            goto L99
        L72:
            boolean r1 = r5.isSaveToFile()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            if (r1 == 0) goto L99
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.mOutputFileOptions     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            java.io.File r1 = r1.getFile()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            if (r2 == 0) goto L87
            r1.delete()     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
        L87:
            boolean r2 = r6.renameTo(r1)     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            if (r2 != 0) goto L92
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            java.lang.String r3 = "Failed to rename file."
            goto L94
        L92:
            r2 = r0
            r3 = r2
        L94:
            android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L21 java.lang.IllegalArgumentException -> L27 java.io.IOException -> L29
            goto L9c
        L99:
            r1 = r0
            r2 = r1
            r3 = r2
        L9c:
            r6.delete()
            goto La5
        La0:
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch: java.lang.Throwable -> L1e
            java.lang.String r3 = "Failed to write destination file."
            goto L9c
        La5:
            if (r2 == 0) goto Lab
            r5.postError(r2, r3, r0)
            goto Lae
        Lab:
            r5.postSuccess(r1)
        Lae:
            return
        Laf:
            r6.delete()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.copyTempFileToDestination(java.io.File):void");
    }

    @Override // java.lang.Runnable
    public void run() {
        final File saveImageToTempFile = saveImageToTempFile();
        if (saveImageToTempFile != null) {
            this.mSequentialIoExecutor.execute(new Runnable() { // from class: androidx.camera.core.h0
                @Override // java.lang.Runnable
                public final void run() {
                    ImageSaver.this.copyTempFileToDestination(saveImageToTempFile);
                }
            });
        }
    }
}
