package com.yalantis.ucrop.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.MotionEventCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final String f42791b = "ImageHeaderParser";

    /* renamed from: c, reason: collision with root package name */
    public static final int f42792c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f42793d = 65496;

    /* renamed from: e, reason: collision with root package name */
    private static final int f42794e = 19789;

    /* renamed from: f, reason: collision with root package name */
    private static final int f42795f = 18761;

    /* renamed from: i, reason: collision with root package name */
    private static final int f42798i = 218;

    /* renamed from: j, reason: collision with root package name */
    private static final int f42799j = 217;

    /* renamed from: k, reason: collision with root package name */
    private static final int f42800k = 255;

    /* renamed from: l, reason: collision with root package name */
    private static final int f42801l = 225;

    /* renamed from: m, reason: collision with root package name */
    private static final int f42802m = 274;

    /* renamed from: a, reason: collision with root package name */
    private final b f42804a;

    /* renamed from: g, reason: collision with root package name */
    private static final String f42796g = "Exif\u0000\u0000";

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f42797h = f42796g.getBytes(Charset.forName("UTF-8"));

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f42803n = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f42805a;

        public short a(int i6) {
            return this.f42805a.getShort(i6);
        }

        public int b(int i6) {
            return this.f42805a.getInt(i6);
        }

        public int c() {
            return this.f42805a.remaining();
        }

        public void d(ByteOrder byteOrder) {
            this.f42805a.order(byteOrder);
        }

        public a(byte[] bArr, int i6) {
            this.f42805a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface b {
        int a() throws IOException;

        short b() throws IOException;

        int read(byte[] bArr, int i6) throws IOException;

        long skip(long j6) throws IOException;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f42806a;

        @Override // com.yalantis.ucrop.util.f.b
        public int read(byte[] bArr, int i6) throws IOException {
            int i7 = i6;
            while (i7 > 0) {
                int read = this.f42806a.read(bArr, i6 - i7, i7);
                if (read == -1) {
                    break;
                }
                i7 -= read;
            }
            return i6 - i7;
        }

        @Override // com.yalantis.ucrop.util.f.b
        public int a() throws IOException {
            return ((this.f42806a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f42806a.read() & 255);
        }

        @Override // com.yalantis.ucrop.util.f.b
        public short b() throws IOException {
            return (short) (this.f42806a.read() & 255);
        }

        @Override // com.yalantis.ucrop.util.f.b
        public long skip(long j6) throws IOException {
            if (j6 < 0) {
                return 0L;
            }
            long j7 = j6;
            while (j7 > 0) {
                long skip = this.f42806a.skip(j7);
                if (skip <= 0) {
                    if (this.f42806a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j7 -= skip;
            }
            return j6 - j7;
        }

        public c(InputStream inputStream) {
            this.f42806a = inputStream;
        }
    }

    private boolean e(byte[] bArr, int i6) {
        boolean z5 = bArr != null && i6 > f42797h.length;
        if (z5) {
            int i7 = 0;
            while (true) {
                byte[] bArr2 = f42797h;
                if (i7 >= bArr2.length) {
                    break;
                }
                if (bArr[i7] != bArr2[i7]) {
                    return false;
                }
                i7++;
            }
        }
        return z5;
    }

    private static int g(a aVar) {
        ByteOrder byteOrder;
        short a6 = aVar.a(6);
        if (a6 == f42794e) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (a6 == f42795f) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            Log.isLoggable(f42791b, 3);
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.d(byteOrder);
        int b6 = aVar.b(10) + 6;
        short a7 = aVar.a(b6);
        for (int i6 = 0; i6 < a7; i6++) {
            int a8 = a(b6, i6);
            if (aVar.a(a8) == 274) {
                short a9 = aVar.a(a8 + 2);
                if (a9 < 1 || a9 > 12) {
                    Log.isLoggable(f42791b, 3);
                } else {
                    int b7 = aVar.b(a8 + 4);
                    if (b7 < 0) {
                        Log.isLoggable(f42791b, 3);
                    } else {
                        Log.isLoggable(f42791b, 3);
                        int i7 = b7 + f42803n[a9];
                        if (i7 > 4) {
                            Log.isLoggable(f42791b, 3);
                        } else {
                            int i8 = a8 + 8;
                            if (i8 < 0 || i8 > aVar.c()) {
                                Log.isLoggable(f42791b, 3);
                            } else {
                                if (i7 >= 0 && i7 + i8 <= aVar.c()) {
                                    return aVar.a(i8);
                                }
                                Log.isLoggable(f42791b, 3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static int a(int i6, int i7) {
        return i6 + 2 + (i7 * 12);
    }

    public static void b(ExifInterface exifInterface, int i6, int i7, String str) {
        String[] strArr = {ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE};
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            for (int i8 = 0; i8 < 22; i8++) {
                String str2 = strArr[i8];
                String attribute = exifInterface.getAttribute(str2);
                if (!TextUtils.isEmpty(attribute)) {
                    exifInterface2.setAttribute(str2, attribute);
                }
            }
            exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i6));
            exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i7));
            exifInterface2.setAttribute(ExifInterface.TAG_ORIENTATION, "0");
            exifInterface2.saveAttributes();
        } catch (IOException e6) {
            e6.getMessage();
        }
    }

    private int f() throws IOException {
        while (this.f42804a.b() == 255) {
            short b6 = this.f42804a.b();
            if (b6 == f42798i) {
                return -1;
            }
            if (b6 == f42799j) {
                Log.isLoggable(f42791b, 3);
                return -1;
            }
            int a6 = this.f42804a.a() - 2;
            if (b6 == 225) {
                return a6;
            }
            long j6 = a6;
            if (this.f42804a.skip(j6) != j6) {
                Log.isLoggable(f42791b, 3);
                return -1;
            }
        }
        Log.isLoggable(f42791b, 3);
        return -1;
    }

    private int h(byte[] bArr, int i6) throws IOException {
        if (this.f42804a.read(bArr, i6) != i6) {
            Log.isLoggable(f42791b, 3);
            return -1;
        }
        if (e(bArr, i6)) {
            return g(new a(bArr, i6));
        }
        Log.isLoggable(f42791b, 3);
        return -1;
    }

    public int c() throws IOException {
        if (!d(this.f42804a.a())) {
            Log.isLoggable(f42791b, 3);
            return -1;
        }
        int f6 = f();
        if (f6 != -1) {
            return h(new byte[f6], f6);
        }
        Log.isLoggable(f42791b, 3);
        return -1;
    }

    public f(InputStream inputStream) {
        this.f42804a = new c(inputStream);
    }

    private static boolean d(int i6) {
        if ((i6 & f42793d) != f42793d && i6 != f42794e && i6 != f42795f) {
            return false;
        }
        return true;
    }
}
