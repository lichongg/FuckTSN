package cn.jiguang.bh;

import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.j1;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f2159a;

    /* renamed from: b, reason: collision with root package name */
    private int f2160b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f2161c = -1;

    public int a() {
        return this.f2159a.position();
    }

    public int b() {
        return this.f2159a.remaining();
    }

    public void c() {
        ByteBuffer byteBuffer = this.f2159a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public int f() {
        c(1);
        return this.f2159a.get() & 255;
    }

    public int g() {
        c(2);
        return this.f2159a.getShort() & j1.f43986d;
    }

    public long h() {
        c(4);
        return this.f2159a.getInt() & 4294967295L;
    }

    private void c(int i6) {
        if (i6 > b()) {
            throw new IOException("end of input");
        }
    }

    public void a(int i6) {
        if (i6 > this.f2159a.capacity() - this.f2159a.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        ByteBuffer byteBuffer = this.f2159a;
        byteBuffer.limit(byteBuffer.position() + i6);
    }

    public void b(int i6) {
        if (i6 >= this.f2159a.capacity()) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.f2159a.position(i6);
        ByteBuffer byteBuffer = this.f2159a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void d() {
        this.f2160b = this.f2159a.position();
        this.f2161c = this.f2159a.limit();
    }

    public void e() {
        int i6 = this.f2160b;
        if (i6 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.f2159a.position(i6);
        this.f2159a.limit(this.f2161c);
        this.f2160b = -1;
        this.f2161c = -1;
    }

    public b(byte[] bArr) {
        this.f2159a = ByteBuffer.wrap(bArr);
    }

    public void a(byte[] bArr, int i6, int i7) {
        c(i7);
        this.f2159a.get(bArr, i6, i7);
    }
}
