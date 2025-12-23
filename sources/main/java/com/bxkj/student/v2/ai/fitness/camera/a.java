package com.bxkj.student.v2.ai.fitness.camera;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageProxy;
import androidx.exifinterface.media.ExifInterface;
import com.bxkj.student.v2.ai.fitness.camera.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f20511a = "BitmapUtils";

    private static boolean a(Image.Plane[] planes, int width, int height) {
        int i6 = width * height;
        ByteBuffer buffer = planes[1].getBuffer();
        ByteBuffer buffer2 = planes[2].getBuffer();
        int position = buffer2.position();
        int limit = buffer.limit();
        buffer2.position(position + 1);
        buffer.limit(limit - 1);
        boolean z5 = buffer2.remaining() == ((i6 * 2) / 4) - 2 && buffer2.compareTo(buffer) == 0;
        buffer2.position(position);
        buffer.limit(limit);
        return z5;
    }

    @Nullable
    @ExperimentalGetImage
    @RequiresApi(21)
    public static Bitmap b(ImageProxy image) {
        return c(h(image.getImage().getPlanes(), image.getWidth(), image.getHeight()), new f.a().d(image.getWidth()).b(image.getHeight()).c(image.getImageInfo().getRotationDegrees()).a());
    }

    private static int e(ContentResolver resolver, Uri imageUri) {
        if (!"content".equals(imageUri.getScheme()) && !master.flame.danmaku.danmaku.parser.b.f50156c.equals(imageUri.getScheme())) {
            return 0;
        }
        try {
            InputStream openInputStream = resolver.openInputStream(imageUri);
            if (openInputStream == null) {
                if (openInputStream != null) {
                    openInputStream.close();
                }
                return 0;
            }
            try {
                ExifInterface exifInterface = new ExifInterface(openInputStream);
                openInputStream.close();
                return exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            } finally {
            }
        } catch (IOException unused) {
            imageUri.toString();
            return 0;
        }
    }

    private static Bitmap f(Bitmap bitmap, int rotationDegrees, boolean flipX, boolean flipY) {
        Matrix matrix = new Matrix();
        matrix.postRotate(rotationDegrees);
        matrix.postScale(flipX ? -1.0f : 1.0f, flipY ? -1.0f : 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    private static ByteBuffer h(Image.Plane[] yuv420888planes, int width, int height) {
        int i6 = width * height;
        byte[] bArr = new byte[((i6 / 4) * 2) + i6];
        if (a(yuv420888planes, width, height)) {
            yuv420888planes[0].getBuffer().get(bArr, 0, i6);
            ByteBuffer buffer = yuv420888planes[1].getBuffer();
            yuv420888planes[2].getBuffer().get(bArr, i6, 1);
            buffer.get(bArr, i6 + 1, ((i6 * 2) / 4) - 1);
        } else {
            g(yuv420888planes[0], width, height, bArr, 0, 1);
            g(yuv420888planes[1], width, height, bArr, i6 + 1, 2);
            g(yuv420888planes[2], width, height, bArr, i6, 2);
        }
        return ByteBuffer.wrap(bArr);
    }

    @Nullable
    public static Bitmap c(ByteBuffer data, f metadata) {
        data.rewind();
        int limit = data.limit();
        byte[] bArr = new byte[limit];
        data.get(bArr, 0, limit);
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, metadata.c(), metadata.a(), null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, metadata.c(), metadata.a()), 80, byteArrayOutputStream);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            byteArrayOutputStream.close();
            return f(decodeByteArray, metadata.b(), false, false);
        } catch (Exception e6) {
            e6.getMessage();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public static Bitmap d(ContentResolver contentResolver, Uri imageUri) throws IOException {
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri);
        if (bitmap == null) {
            return null;
        }
        int e6 = e(contentResolver, imageUri);
        int i6 = 90;
        boolean z5 = false;
        boolean z6 = true;
        switch (e6) {
            case 2:
                i6 = 0;
                z5 = true;
                z6 = false;
                break;
            case 3:
                i6 = 180;
                z6 = false;
                break;
            case 4:
                i6 = 0;
                break;
            case 5:
                z5 = true;
                z6 = false;
                break;
            case 6:
                z6 = false;
                break;
            case 7:
                i6 = -90;
                z5 = true;
                z6 = false;
                break;
            case 8:
                i6 = -90;
                z6 = false;
                break;
            default:
                i6 = 0;
                z6 = false;
                break;
        }
        return f(bitmap, i6, z5, z6);
    }

    private static void g(Image.Plane plane, int width, int height, byte[] out, int offset, int pixelStride) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int limit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (limit != 0) {
            int i6 = width / (height / limit);
            int i7 = 0;
            for (int i8 = 0; i8 < limit; i8++) {
                int i9 = i7;
                for (int i10 = 0; i10 < i6; i10++) {
                    out[offset] = buffer.get(i9);
                    offset += pixelStride;
                    i9 += plane.getPixelStride();
                }
                i7 += plane.getRowStride();
            }
        }
    }
}
