package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: b, reason: collision with root package name */
    private static final String f15528b = "DfltImageHeaderParser";

    /* renamed from: c, reason: collision with root package name */
    private static final int f15529c = 4671814;

    /* renamed from: d, reason: collision with root package name */
    private static final int f15530d = -1991225785;

    /* renamed from: e, reason: collision with root package name */
    static final int f15531e = 65496;

    /* renamed from: f, reason: collision with root package name */
    private static final int f15532f = 19789;

    /* renamed from: g, reason: collision with root package name */
    private static final int f15533g = 18761;

    /* renamed from: j, reason: collision with root package name */
    private static final int f15536j = 218;

    /* renamed from: k, reason: collision with root package name */
    private static final int f15537k = 217;

    /* renamed from: l, reason: collision with root package name */
    static final int f15538l = 255;

    /* renamed from: m, reason: collision with root package name */
    static final int f15539m = 225;

    /* renamed from: n, reason: collision with root package name */
    private static final int f15540n = 274;

    /* renamed from: p, reason: collision with root package name */
    private static final int f15542p = 1380533830;

    /* renamed from: q, reason: collision with root package name */
    private static final int f15543q = 1464156752;

    /* renamed from: r, reason: collision with root package name */
    private static final int f15544r = 1448097792;

    /* renamed from: s, reason: collision with root package name */
    private static final int f15545s = -256;

    /* renamed from: t, reason: collision with root package name */
    private static final int f15546t = 255;

    /* renamed from: u, reason: collision with root package name */
    private static final int f15547u = 88;

    /* renamed from: v, reason: collision with root package name */
    private static final int f15548v = 76;

    /* renamed from: w, reason: collision with root package name */
    private static final int f15549w = 16;

    /* renamed from: x, reason: collision with root package name */
    private static final int f15550x = 8;

    /* renamed from: h, reason: collision with root package name */
    private static final String f15534h = "Exif\u0000\u0000";

    /* renamed from: i, reason: collision with root package name */
    static final byte[] f15535i = f15534h.getBytes(Charset.forName("UTF-8"));

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f15541o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface Reader {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a() throws IOException;

        short b() throws IOException;

        int read(byte[] bArr, int i6) throws IOException;

        long skip(long j6) throws IOException;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements Reader {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f15551a;

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short b() throws Reader.EndOfFileException {
            if (this.f15551a.remaining() >= 1) {
                return (short) (this.f15551a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i6) {
            int min = Math.min(i6, this.f15551a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f15551a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j6) {
            int min = (int) Math.min(this.f15551a.remaining(), j6);
            ByteBuffer byteBuffer = this.f15551a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        a(ByteBuffer byteBuffer) {
            this.f15551a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a() throws Reader.EndOfFileException {
            return (b() << 8) | b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f15552a;

        short a(int i6) {
            if (c(i6, 2)) {
                return this.f15552a.getShort(i6);
            }
            return (short) -1;
        }

        int b(int i6) {
            if (c(i6, 4)) {
                return this.f15552a.getInt(i6);
            }
            return -1;
        }

        private boolean c(int i6, int i7) {
            return this.f15552a.remaining() - i6 >= i7;
        }

        int d() {
            return this.f15552a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.f15552a.order(byteOrder);
        }

        b(byte[] bArr, int i6) {
            this.f15552a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements Reader {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f15553a;

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i6) throws IOException {
            int i7 = 0;
            int i8 = 0;
            while (i7 < i6 && (i8 = this.f15553a.read(bArr, i7, i6 - i7)) != -1) {
                i7 += i8;
            }
            if (i7 == 0 && i8 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i7;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short b() throws IOException {
            int read = this.f15553a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j6) throws IOException {
            if (j6 < 0) {
                return 0L;
            }
            long j7 = j6;
            while (j7 > 0) {
                long skip = this.f15553a.skip(j7);
                if (skip <= 0) {
                    if (this.f15553a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j7 -= skip;
            }
            return j6 - j7;
        }

        c(InputStream inputStream) {
            this.f15553a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a() throws IOException {
            return (b() << 8) | b();
        }
    }

    private int d(Reader reader, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        try {
            if (!e(reader.a())) {
                Log.isLoggable(f15528b, 3);
                return -1;
            }
            int g6 = g(reader);
            if (g6 == -1) {
                Log.isLoggable(f15528b, 3);
                return -1;
            }
            byte[] bArr = (byte[]) bVar.c(g6, byte[].class);
            try {
                return i(reader, bArr, g6);
            } finally {
                bVar.put(bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    private boolean f(byte[] bArr, int i6) {
        boolean z5 = bArr != null && i6 > f15535i.length;
        if (z5) {
            int i7 = 0;
            while (true) {
                byte[] bArr2 = f15535i;
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

    private static int h(b bVar) {
        ByteOrder byteOrder;
        short a6 = bVar.a(6);
        if (a6 == f15533g) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a6 != f15532f) {
            Log.isLoggable(f15528b, 3);
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.e(byteOrder);
        int b6 = bVar.b(10) + 6;
        short a7 = bVar.a(b6);
        for (int i6 = 0; i6 < a7; i6++) {
            int c6 = c(b6, i6);
            if (bVar.a(c6) == 274) {
                short a8 = bVar.a(c6 + 2);
                if (a8 < 1 || a8 > 12) {
                    Log.isLoggable(f15528b, 3);
                } else {
                    int b7 = bVar.b(c6 + 4);
                    if (b7 < 0) {
                        Log.isLoggable(f15528b, 3);
                    } else {
                        Log.isLoggable(f15528b, 3);
                        int i7 = b7 + f15541o[a8];
                        if (i7 > 4) {
                            Log.isLoggable(f15528b, 3);
                        } else {
                            int i8 = c6 + 8;
                            if (i8 < 0 || i8 > bVar.d()) {
                                Log.isLoggable(f15528b, 3);
                            } else {
                                if (i7 >= 0 && i7 + i8 <= bVar.d()) {
                                    return bVar.a(i8);
                                }
                                Log.isLoggable(f15528b, 3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        return getType(new c((InputStream) com.bumptech.glide.util.k.d(inputStream)));
    }

    private static int c(int i6, int i7) {
        return i6 + 2 + (i7 * 12);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return d(new a((ByteBuffer) com.bumptech.glide.util.k.d(byteBuffer)), (com.bumptech.glide.load.engine.bitmap_recycle.b) com.bumptech.glide.util.k.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return d(new c((InputStream) com.bumptech.glide.util.k.d(inputStream)), (com.bumptech.glide.load.engine.bitmap_recycle.b) com.bumptech.glide.util.k.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        return getType(new a((ByteBuffer) com.bumptech.glide.util.k.d(byteBuffer)));
    }

    private static boolean e(int i6) {
        if ((i6 & f15531e) != f15531e && i6 != f15532f && i6 != f15533g) {
            return false;
        }
        return true;
    }

    private int g(Reader reader) throws IOException {
        while (reader.b() == 255) {
            short b6 = reader.b();
            if (b6 == f15536j) {
                return -1;
            }
            if (b6 == f15537k) {
                Log.isLoggable(f15528b, 3);
                return -1;
            }
            int a6 = reader.a() - 2;
            if (b6 != 225) {
                long j6 = a6;
                if (reader.skip(j6) != j6) {
                    Log.isLoggable(f15528b, 3);
                    return -1;
                }
            } else {
                return a6;
            }
        }
        Log.isLoggable(f15528b, 3);
        return -1;
    }

    @NonNull
    private ImageHeaderParser.ImageType getType(Reader reader) throws IOException {
        try {
            int a6 = reader.a();
            if (a6 == f15531e) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int b6 = (a6 << 8) | reader.b();
            if (b6 == f15529c) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int b7 = (b6 << 8) | reader.b();
            if (b7 == f15530d) {
                reader.skip(21L);
                try {
                    return reader.b() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (b7 != f15542p) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            reader.skip(4L);
            if (((reader.a() << 16) | reader.a()) != f15543q) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int a7 = (reader.a() << 16) | reader.a();
            if ((a7 & (-256)) != f15544r) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i6 = a7 & 255;
            if (i6 == 88) {
                reader.skip(4L);
                return (reader.b() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i6 == 76) {
                reader.skip(4L);
                return (reader.b() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private int i(Reader reader, byte[] bArr, int i6) throws IOException {
        if (reader.read(bArr, i6) != i6) {
            Log.isLoggable(f15528b, 3);
            return -1;
        }
        if (f(bArr, i6)) {
            return h(new b(bArr, i6));
        }
        Log.isLoggable(f15528b, 3);
        return -1;
    }
}
