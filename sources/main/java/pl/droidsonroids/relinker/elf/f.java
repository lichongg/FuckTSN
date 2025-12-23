package pl.droidsonroids.relinker.elf;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.j1;
import okhttp3.internal.ws.WebSocketProtocol;
import pl.droidsonroids.relinker.elf.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f implements Closeable, c {

    /* renamed from: a, reason: collision with root package name */
    private final int f51912a = 1179403647;

    /* renamed from: b, reason: collision with root package name */
    private final FileChannel f51913b;

    protected void d(ByteBuffer byteBuffer, long j6, int i6) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i6);
        long j7 = 0;
        while (j7 < i6) {
            int read = this.f51913b.read(byteBuffer, j6 + j7);
            if (read == -1) {
                throw new EOFException();
            }
            j7 += read;
        }
        byteBuffer.position(0);
    }

    protected short e(ByteBuffer byteBuffer, long j6) throws IOException {
        d(byteBuffer, j6, 1);
        return (short) (byteBuffer.get() & 255);
    }

    protected int f(ByteBuffer byteBuffer, long j6) throws IOException {
        d(byteBuffer, j6, 2);
        return byteBuffer.getShort() & j1.f43986d;
    }

    protected long i(ByteBuffer byteBuffer, long j6) throws IOException {
        d(byteBuffer, j6, 4);
        return byteBuffer.getInt() & 4294967295L;
    }

    private long a(c.b bVar, long j6, long j7) throws IOException {
        for (long j8 = 0; j8 < j6; j8++) {
            c.AbstractC1002c b6 = bVar.b(j8);
            if (b6.f51905a == 1) {
                long j9 = b6.f51907c;
                if (j9 <= j7 && j7 <= b6.f51908d + j9) {
                    return (j7 - j9) + b6.f51906b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public c.b b() throws IOException {
        this.f51913b.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (i(allocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short e6 = e(allocate, 4L);
        boolean z5 = e(allocate, 5L) == 2;
        if (e6 == 1) {
            return new d(z5, this);
        }
        if (e6 == 2) {
            return new e(z5, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public List<String> c() throws IOException {
        long j6;
        long j7;
        this.f51913b.position(0L);
        ArrayList arrayList = new ArrayList();
        c.b b6 = b();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(b6.f51894a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j8 = b6.f51899f;
        int i6 = 0;
        if (j8 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j8 = b6.c(0).f51909a;
        }
        long j9 = 0;
        while (true) {
            j6 = 1;
            if (j9 >= j8) {
                j7 = 0;
                break;
            }
            c.AbstractC1002c b7 = b6.b(j9);
            if (b7.f51905a == 2) {
                j7 = b7.f51906b;
                break;
            }
            j9++;
        }
        if (j7 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j10 = 0;
        while (true) {
            c.a a6 = b6.a(j7, i6);
            long j11 = j6;
            long j12 = a6.f51889a;
            if (j12 == j11) {
                arrayList2.add(Long.valueOf(a6.f51890b));
            } else if (j12 == 5) {
                j10 = a6.f51890b;
            }
            i6++;
            if (a6.f51889a == 0) {
                break;
            }
            j6 = j11;
            j8 = j8;
        }
        if (j10 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long a7 = a(b6, j8, j10);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(h(allocate, ((Long) it.next()).longValue() + a7));
        }
        return arrayList;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f51913b.close();
    }

    protected long g(ByteBuffer byteBuffer, long j6) throws IOException {
        d(byteBuffer, j6, 8);
        return byteBuffer.getLong();
    }

    protected String h(ByteBuffer byteBuffer, long j6) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j7 = 1 + j6;
            short e6 = e(byteBuffer, j6);
            if (e6 == 0) {
                return sb.toString();
            }
            sb.append((char) e6);
            j6 = j7;
        }
    }

    public f(File file) throws FileNotFoundException {
        if (file != null && file.exists()) {
            this.f51913b = new FileInputStream(file).getChannel();
            return;
        }
        throw new IllegalArgumentException("File is null or does not exist");
    }
}
