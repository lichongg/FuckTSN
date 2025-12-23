package javax.mail.util;

import com.kuaishou.weapon.p0.t;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import javax.mail.internet.SharedInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class SharedFileInputStream extends BufferedInputStream implements SharedInputStream {
    private static int defaultBufferSize = 2048;
    protected long bufpos;
    protected int bufsize;
    protected long datalen;
    protected RandomAccessFile in;

    /* renamed from: master, reason: collision with root package name */
    private boolean f43459master;
    private SharedFile sf;
    protected long start;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SharedFile {
        private int cnt;
        private RandomAccessFile in;

        SharedFile(String str) throws IOException {
            this.in = new RandomAccessFile(str, t.f36150k);
        }

        public synchronized void close() throws IOException {
            int i6 = this.cnt;
            if (i6 > 0) {
                int i7 = i6 - 1;
                this.cnt = i7;
                if (i7 <= 0) {
                    this.in.close();
                }
            }
        }

        public synchronized void forceClose() throws IOException {
            if (this.cnt > 0) {
                this.cnt = 0;
                this.in.close();
            } else {
                try {
                    this.in.close();
                } catch (IOException unused) {
                }
            }
        }

        public RandomAccessFile open() {
            this.cnt++;
            return this.in;
        }

        SharedFile(File file) throws IOException {
            this.in = new RandomAccessFile(file, t.f36150k);
        }

        protected void finalize() throws Throwable {
            super.finalize();
            this.in.close();
        }
    }

    public SharedFileInputStream(File file) throws IOException {
        this(file, defaultBufferSize);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        ensureOpen();
        return (((BufferedInputStream) this).count - ((BufferedInputStream) this).pos) + in_available();
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i6) {
        ((BufferedInputStream) this).marklimit = i6;
        ((BufferedInputStream) this).markpos = ((BufferedInputStream) this).pos;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        ensureOpen();
        if (((BufferedInputStream) this).pos >= ((BufferedInputStream) this).count) {
            fill();
            if (((BufferedInputStream) this).pos >= ((BufferedInputStream) this).count) {
                return -1;
            }
        }
        byte[] bArr = ((BufferedInputStream) this).buf;
        int i6 = ((BufferedInputStream) this).pos;
        ((BufferedInputStream) this).pos = i6 + 1;
        return bArr[i6] & 255;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        ensureOpen();
        int i6 = ((BufferedInputStream) this).markpos;
        if (i6 < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        ((BufferedInputStream) this).pos = i6;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j6) throws IOException {
        ensureOpen();
        if (j6 <= 0) {
            return 0L;
        }
        long j7 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
        if (j7 <= 0) {
            fill();
            j7 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
            if (j7 <= 0) {
                return 0L;
            }
        }
        if (j7 < j6) {
            j6 = j7;
        }
        ((BufferedInputStream) this).pos = (int) (((BufferedInputStream) this).pos + j6);
        return j6;
    }

    public SharedFileInputStream(String str) throws IOException {
        this(str, defaultBufferSize);
    }

    private void ensureOpen() throws IOException {
        if (this.in == null) {
            throw new IOException("Stream closed");
        }
    }

    private void fill() throws IOException {
        if (((BufferedInputStream) this).markpos < 0) {
            ((BufferedInputStream) this).pos = 0;
            this.bufpos += ((BufferedInputStream) this).count;
        } else if (((BufferedInputStream) this).pos >= ((BufferedInputStream) this).buf.length) {
            int i6 = ((BufferedInputStream) this).markpos;
            if (i6 > 0) {
                int i7 = ((BufferedInputStream) this).pos - i6;
                System.arraycopy(((BufferedInputStream) this).buf, ((BufferedInputStream) this).markpos, ((BufferedInputStream) this).buf, 0, i7);
                ((BufferedInputStream) this).pos = i7;
                this.bufpos += ((BufferedInputStream) this).markpos;
                ((BufferedInputStream) this).markpos = 0;
            } else {
                int length = ((BufferedInputStream) this).buf.length;
                int i8 = ((BufferedInputStream) this).marklimit;
                if (length >= i8) {
                    ((BufferedInputStream) this).markpos = -1;
                    ((BufferedInputStream) this).pos = 0;
                    this.bufpos += ((BufferedInputStream) this).count;
                } else {
                    int i9 = ((BufferedInputStream) this).pos * 2;
                    if (i9 <= i8) {
                        i8 = i9;
                    }
                    byte[] bArr = new byte[i8];
                    System.arraycopy(((BufferedInputStream) this).buf, 0, bArr, 0, ((BufferedInputStream) this).pos);
                    ((BufferedInputStream) this).buf = bArr;
                }
            }
        }
        int i10 = ((BufferedInputStream) this).pos;
        ((BufferedInputStream) this).count = i10;
        this.in.seek(this.bufpos + i10);
        int length2 = ((BufferedInputStream) this).buf.length;
        int i11 = ((BufferedInputStream) this).pos;
        int i12 = length2 - i11;
        long j6 = this.bufpos;
        long j7 = this.start;
        long j8 = (j6 - j7) + i11 + i12;
        long j9 = this.datalen;
        if (j8 > j9) {
            i12 = (int) (j9 - ((j6 - j7) + i11));
        }
        int read = this.in.read(((BufferedInputStream) this).buf, ((BufferedInputStream) this).pos, i12);
        if (read > 0) {
            ((BufferedInputStream) this).count = read + ((BufferedInputStream) this).pos;
        }
    }

    private int in_available() throws IOException {
        return (int) ((this.start + this.datalen) - (this.bufpos + ((BufferedInputStream) this).count));
    }

    private void init(SharedFile sharedFile, int i6) throws IOException {
        this.sf = sharedFile;
        RandomAccessFile open = sharedFile.open();
        this.in = open;
        this.start = 0L;
        this.datalen = open.length();
        this.bufsize = i6;
        ((BufferedInputStream) this).buf = new byte[i6];
    }

    private int read1(byte[] bArr, int i6, int i7) throws IOException {
        int i8 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
        if (i8 <= 0) {
            fill();
            i8 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
            if (i8 <= 0) {
                return -1;
            }
        }
        if (i8 < i7) {
            i7 = i8;
        }
        System.arraycopy(((BufferedInputStream) this).buf, ((BufferedInputStream) this).pos, bArr, i6, i7);
        ((BufferedInputStream) this).pos += i7;
        return i7;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.in == null) {
            return;
        }
        try {
            if (this.f43459master) {
                this.sf.forceClose();
            } else {
                this.sf.close();
            }
            this.sf = null;
            this.in = null;
            ((BufferedInputStream) this).buf = null;
        } catch (Throwable th) {
            this.sf = null;
            this.in = null;
            ((BufferedInputStream) this).buf = null;
            throw th;
        }
    }

    @Override // javax.mail.internet.SharedInputStream
    public long getPosition() {
        if (this.in != null) {
            return (this.bufpos + ((BufferedInputStream) this).pos) - this.start;
        }
        throw new RuntimeException("Stream closed");
    }

    @Override // javax.mail.internet.SharedInputStream
    public InputStream newStream(long j6, long j7) {
        if (this.in == null) {
            throw new RuntimeException("Stream closed");
        }
        if (j6 < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (j7 == -1) {
            j7 = this.datalen;
        }
        return new SharedFileInputStream(this.sf, this.start + ((int) j6), (int) (j7 - j6), this.bufsize);
    }

    public SharedFileInputStream(File file, int i6) throws IOException {
        super(null);
        this.start = 0L;
        this.f43459master = true;
        if (i6 > 0) {
            init(new SharedFile(file), i6);
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i6, int i7) throws IOException {
        ensureOpen();
        int i8 = i6 + i7;
        if ((i6 | i7 | i8 | (bArr.length - i8)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i7 == 0) {
            return 0;
        }
        int read1 = read1(bArr, i6, i7);
        if (read1 <= 0) {
            return read1;
        }
        while (read1 < i7) {
            int read12 = read1(bArr, i6 + read1, i7 - read1);
            if (read12 <= 0) {
                break;
            }
            read1 += read12;
        }
        return read1;
    }

    public SharedFileInputStream(String str, int i6) throws IOException {
        super(null);
        this.start = 0L;
        this.f43459master = true;
        if (i6 > 0) {
            init(new SharedFile(str), i6);
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    private SharedFileInputStream(SharedFile sharedFile, long j6, long j7, int i6) {
        super(null);
        this.start = 0L;
        this.f43459master = false;
        this.sf = sharedFile;
        this.in = sharedFile.open();
        this.start = j6;
        this.bufpos = j6;
        this.datalen = j7;
        this.bufsize = i6;
        ((BufferedInputStream) this).buf = new byte[i6];
    }
}
