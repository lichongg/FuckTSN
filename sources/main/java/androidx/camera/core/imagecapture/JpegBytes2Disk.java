package androidx.camera.core.imagecapture;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.InvalidJpegDataParser;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import com.google.auto.value.AutoValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
class JpegBytes2Disk implements Operation<In, ImageCapture.OutputFileResults> {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class In {
        @NonNull
        abstract ImageCapture.OutputFileOptions getOutputFileOptions();

        @NonNull
        abstract Packet<byte[]> getPacket();

        @NonNull
        static In of(@NonNull Packet<byte[]> packet, @NonNull ImageCapture.OutputFileOptions outputFileOptions) {
            return new AutoValue_JpegBytes2Disk_In(packet, outputFileOptions);
        }

        In() {
        }
    }

    @Nullable
    static Uri moveFileToTarget(@NonNull File file, @NonNull ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        Uri uri = null;
        try {
            try {
                if (isSaveToMediaStore(outputFileOptions)) {
                    uri = copyFileToMediaStore(file, outputFileOptions);
                } else if (isSaveToOutputStream(outputFileOptions)) {
                    OutputStream outputStream = outputFileOptions.getOutputStream();
                    Objects.requireNonNull(outputStream);
                    copyFileToOutputStream(file, outputStream);
                } else if (isSaveToFile(outputFileOptions)) {
                    File file2 = outputFileOptions.getFile();
                    Objects.requireNonNull(file2);
                    uri = copyFileToFile(file, file2);
                }
                file.delete();
                return uri;
            } catch (IOException unused) {
                throw new ImageCaptureException(1, "Failed to write to OutputStream.", null);
            }
        } catch (Throwable th) {
            file.delete();
            throw th;
        }
    }

    private static void copyFileToOutputStream(@NonNull File file, @NonNull OutputStream outputStream) throws IOException {
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

    private static void setContentValuePendingFlag(@NonNull ContentValues contentValues, int i6) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i6));
        }
    }

    private static void updateUriPendingStatus(@NonNull Uri uri, @NonNull ContentResolver contentResolver, int i6) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            setContentValuePendingFlag(contentValues, i6);
            contentResolver.update(uri, contentValues, null, null);
        }
    }

    private static void writeBytesToFile(@NonNull File file, @NonNull byte[] bArr) throws ImageCaptureException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr, 0, new InvalidJpegDataParser().getValidDataLength(bArr));
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e6) {
            throw new ImageCaptureException(1, "Failed to write to temp file", e6);
        }
    }

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    public ImageCapture.OutputFileResults apply(@NonNull In in) throws ImageCaptureException {
        Packet<byte[]> packet = in.getPacket();
        ImageCapture.OutputFileOptions outputFileOptions = in.getOutputFileOptions();
        File createTempFile = createTempFile(outputFileOptions);
        writeBytesToFile(createTempFile, packet.getData());
        Exif exif = packet.getExif();
        Objects.requireNonNull(exif);
        updateFileExif(createTempFile, exif, outputFileOptions, packet.getRotationDegrees());
        return new ImageCapture.OutputFileResults(moveFileToTarget(createTempFile, outputFileOptions));
    }

    JpegBytes2Disk() {
    }

    private static Uri copyFileToFile(@NonNull File file, @NonNull File file2) throws ImageCaptureException {
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            return Uri.fromFile(file2);
        }
        throw new ImageCaptureException(1, "Failed to overwrite the file: " + file2.getAbsolutePath(), null);
    }

    private static Uri copyFileToMediaStore(@NonNull File file, @NonNull ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        ContentValues contentValues;
        ContentResolver contentResolver = outputFileOptions.getContentResolver();
        Objects.requireNonNull(contentResolver);
        if (outputFileOptions.getContentValues() != null) {
            contentValues = new ContentValues(outputFileOptions.getContentValues());
        } else {
            contentValues = new ContentValues();
        }
        setContentValuePendingFlag(contentValues, 1);
        Uri uri = null;
        try {
            try {
                Uri insert = contentResolver.insert(outputFileOptions.getSaveCollection(), contentValues);
                try {
                    if (insert != null) {
                        copyTempFileToUri(file, insert, contentResolver);
                        updateUriPendingStatus(insert, contentResolver, 0);
                        return insert;
                    }
                    throw new ImageCaptureException(1, "Failed to insert a MediaStore URI.", null);
                } catch (IOException e6) {
                    e = e6;
                    uri = insert;
                    throw new ImageCaptureException(1, "Failed to write to MediaStore URI: " + uri, e);
                } catch (SecurityException e7) {
                    e = e7;
                    uri = insert;
                    throw new ImageCaptureException(1, "Failed to write to MediaStore URI: " + uri, e);
                } catch (Throwable th) {
                    th = th;
                    uri = insert;
                    if (uri != null) {
                        updateUriPendingStatus(uri, contentResolver, 0);
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
            } catch (SecurityException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void copyTempFileToUri(@NonNull File file, @NonNull Uri uri, @NonNull ContentResolver contentResolver) throws IOException {
        OutputStream openOutputStream = contentResolver.openOutputStream(uri);
        try {
            if (openOutputStream != null) {
                copyFileToOutputStream(file, openOutputStream);
                openOutputStream.close();
            } else {
                throw new FileNotFoundException(uri + " cannot be resolved.");
            }
        } catch (Throwable th) {
            if (openOutputStream != null) {
                try {
                    openOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @NonNull
    private static File createTempFile(@NonNull ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        try {
            File file = outputFileOptions.getFile();
            if (file != null) {
                return new File(file.getParent(), TEMP_FILE_PREFIX + UUID.randomUUID().toString() + getFileExtensionWithDot(file));
            }
            return File.createTempFile(TEMP_FILE_PREFIX, ".tmp");
        } catch (IOException e6) {
            throw new ImageCaptureException(1, "Failed to create temp file.", e6);
        }
    }

    private static String getFileExtensionWithDot(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            return name.substring(lastIndexOf);
        }
        return "";
    }

    private static boolean isSaveToFile(ImageCapture.OutputFileOptions outputFileOptions) {
        if (outputFileOptions.getFile() != null) {
            return true;
        }
        return false;
    }

    private static boolean isSaveToMediaStore(ImageCapture.OutputFileOptions outputFileOptions) {
        if (outputFileOptions.getSaveCollection() != null && outputFileOptions.getContentResolver() != null && outputFileOptions.getContentValues() != null) {
            return true;
        }
        return false;
    }

    private static boolean isSaveToOutputStream(ImageCapture.OutputFileOptions outputFileOptions) {
        if (outputFileOptions.getOutputStream() != null) {
            return true;
        }
        return false;
    }

    private static void updateFileExif(@NonNull File file, @NonNull Exif exif, @NonNull ImageCapture.OutputFileOptions outputFileOptions, int i6) throws ImageCaptureException {
        try {
            Exif createFromFile = Exif.createFromFile(file);
            exif.copyToCroppedImage(createFromFile);
            if (createFromFile.getRotation() == 0 && i6 != 0) {
                createFromFile.rotate(i6);
            }
            ImageCapture.Metadata metadata = outputFileOptions.getMetadata();
            if (metadata.isReversedHorizontal()) {
                createFromFile.flipHorizontally();
            }
            if (metadata.isReversedVertical()) {
                createFromFile.flipVertically();
            }
            if (metadata.getLocation() != null) {
                createFromFile.attachLocation(metadata.getLocation());
            }
            createFromFile.save();
        } catch (IOException e6) {
            throw new ImageCaptureException(1, "Failed to update Exif data", e6);
        }
    }
}
