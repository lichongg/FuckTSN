package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16308a = 16384;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReference<byte[]> f16309b = new AtomicReference<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.util.a$a, reason: collision with other inner class name */
    private static class C0176a extends InputStream {

        /* renamed from: c, reason: collision with root package name */
        private static final int f16310c = -1;

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final ByteBuffer f16311a;

        /* renamed from: b, reason: collision with root package name */
        private int f16312b = -1;

        @Override // java.io.InputStream
        public synchronized void mark(int i6) {
            this.f16312b = this.f16311a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f16311a.hasRemaining()) {
                return this.f16311a.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i6 = this.f16312b;
            if (i6 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f16311a.position(i6);
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f16311a.remaining();
        }

        @Override // java.io.InputStream
        public long skip(long j6) throws IOException {
            if (!this.f16311a.hasRemaining()) {
                return -1L;
            }
            long min = Math.min(j6, available());
            this.f16311a.position((int) (r0.position() + min));
            return min;
        }

        C0176a(@NonNull ByteBuffer byteBuffer) {
            this.f16311a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i6, int i7) throws IOException {
            if (!this.f16311a.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i7, available());
            this.f16311a.get(bArr, i6, min);
            return min;
        }
    }

    @NonNull
    public static ByteBuffer a(@NonNull File file) throws IOException {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, t.f36150k);
            try {
                channel = randomAccessFile.getChannel();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return load;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = channel;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    public static void e(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            fileChannel = randomAccessFile.getChannel();
            fileChannel.write(byteBuffer);
            fileChannel.force(false);
            fileChannel.close();
            randomAccessFile.close();
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile == null) {
                throw th;
            }
            try {
                randomAccessFile.close();
                throw th;
            } catch (IOException unused4) {
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f16313a;

        /* renamed from: b, reason: collision with root package name */
        final int f16314b;

        /* renamed from: c, reason: collision with root package name */
        final byte[] f16315c;

        b(@NonNull byte[] bArr, int i6, int i7) {
            this.f16315c = bArr;
            this.f16313a = i6;
            this.f16314b = i7;
        }
    }

    @NonNull
    public static ByteBuffer b(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f16309b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read < 0) {
                f16309b.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
            byteArrayOutputStream.write(andSet, 0, read);
        }
    }

    @NonNull
    public static InputStream f(@NonNull ByteBuffer byteBuffer) {
        return new C0176a(byteBuffer);
    }

    private a() {
    }

    @Nullable
    private static b c(@NonNull ByteBuffer byteBuffer) {
        if (!byteBuffer.isReadOnly() && byteBuffer.hasArray()) {
            return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        }
        return null;
    }

    @NonNull
    public static byte[] d(@NonNull ByteBuffer byteBuffer) {
        b c6 = c(byteBuffer);
        if (c6 != null && c6.f16313a == 0 && c6.f16314b == c6.f16315c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void g(@NonNull ByteBuffer byteBuffer, @NonNull OutputStream outputStream) throws IOException {
        b c6 = c(byteBuffer);
        if (c6 != null) {
            byte[] bArr = c6.f16315c;
            int i6 = c6.f16313a;
            outputStream.write(bArr, i6, c6.f16314b + i6);
            return;
        }
        byte[] andSet = f16309b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int min = Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, min);
            outputStream.write(andSet, 0, min);
        }
        f16309b.set(andSet);
    }
}
