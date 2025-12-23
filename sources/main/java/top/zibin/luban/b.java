package top.zibin.luban;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private ExifInterface f54624a;

    /* renamed from: b, reason: collision with root package name */
    private File f54625b;

    /* renamed from: c, reason: collision with root package name */
    private File f54626c;

    /* renamed from: d, reason: collision with root package name */
    private int f54627d;

    /* renamed from: e, reason: collision with root package name */
    private int f54628e;

    private int b() {
        int i6 = this.f54627d;
        if (i6 % 2 == 1) {
            i6++;
        }
        this.f54627d = i6;
        int i7 = this.f54628e;
        if (i7 % 2 == 1) {
            i7++;
        }
        this.f54628e = i7;
        if (i6 > i7) {
            i6 = i7;
        }
        this.f54627d = i6;
        if (i6 > i7) {
            i7 = i6;
        }
        this.f54628e = i7;
        double d6 = i6 / i7;
        if (d6 > 1.0d || d6 <= 0.5625d) {
            if (d6 > 0.5625d || d6 <= 0.5d) {
                return (int) Math.ceil(i7 / (1280.0d / d6));
            }
            if (i7 / PredefinedCaptureConfigurations.f35648o == 0) {
                return 1;
            }
            return i7 / PredefinedCaptureConfigurations.f35648o;
        }
        if (i7 < 1664) {
            return 1;
        }
        if (i7 >= 1664 && i7 < 4990) {
            return 2;
        }
        if (i7 >= 4990 && i7 < 10240) {
            return 4;
        }
        if (i7 / PredefinedCaptureConfigurations.f35648o == 0) {
            return 1;
        }
        return i7 / PredefinedCaptureConfigurations.f35648o;
    }

    private Bitmap d(Bitmap bitmap) {
        if (this.f54624a == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int attributeInt = this.f54624a.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        matrix.postRotate(attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    File a() throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = b();
        Bitmap decodeFile = BitmapFactory.decodeFile(this.f54625b.getAbsolutePath(), options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap d6 = d(decodeFile);
        d6.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        d6.recycle();
        FileOutputStream fileOutputStream = new FileOutputStream(this.f54626c);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.f54626c;
    }

    b(File file, File file2) throws IOException {
        if (c(file)) {
            this.f54624a = new ExifInterface(file.getAbsolutePath());
        }
        this.f54626c = file2;
        this.f54625b = file;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        this.f54627d = options.outWidth;
        this.f54628e = options.outHeight;
    }

    private boolean c(File file) {
        if (!file.getAbsolutePath().contains("jpeg") && !file.getAbsolutePath().contains("jpg")) {
            return false;
        }
        return true;
    }
}
