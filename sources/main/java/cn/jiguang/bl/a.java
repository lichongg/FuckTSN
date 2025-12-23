package cn.jiguang.bl;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.q0;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class a implements Closeable {

    /* renamed from: j, reason: collision with root package name */
    private static AtomicInteger f2335j = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    protected SocketChannel f2337b;

    /* renamed from: c, reason: collision with root package name */
    protected int f2338c;

    /* renamed from: d, reason: collision with root package name */
    protected Selector f2339d;

    /* renamed from: g, reason: collision with root package name */
    public int f2342g;

    /* renamed from: h, reason: collision with root package name */
    public String f2343h;

    /* renamed from: i, reason: collision with root package name */
    public int f2344i;

    /* renamed from: f, reason: collision with root package name */
    protected int f2341f = 20;

    /* renamed from: a, reason: collision with root package name */
    protected ByteBuffer f2336a = ByteBuffer.allocate(49152);

    /* renamed from: e, reason: collision with root package name */
    protected volatile boolean f2340e = false;

    public int a(String str, int i6) {
        if (this.f2336a == null) {
            this.f2336a = ByteBuffer.allocate(49152);
        }
        this.f2336a.clear();
        this.f2338c = 0;
        this.f2340e = true;
        this.f2343h = str;
        this.f2344i = i6;
        return 0;
    }

    public abstract int a(byte[] bArr);

    public abstract ByteBuffer a(int i6);

    protected ByteBuffer b(int i6) {
        int i7 = this.f2338c;
        if (i7 < i6) {
            return null;
        }
        this.f2338c = i7 - i6;
        byte[] bArr = new byte[i6];
        this.f2336a.flip();
        this.f2336a.get(bArr, 0, i6);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f2336a.compact();
        return wrap;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2340e = false;
        ByteBuffer byteBuffer = this.f2336a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f2338c = 0;
    }

    public ByteBuffer a() {
        return a(0);
    }

    public boolean b() {
        SocketChannel socketChannel;
        return this.f2340e && (socketChannel = this.f2337b) != null && socketChannel.isConnected();
    }

    protected int c() {
        if (this.f2338c < this.f2341f) {
            return 0;
        }
        int position = this.f2336a.position();
        this.f2336a.position(0);
        int i6 = this.f2336a.getShort() & q0.f44053c;
        this.f2336a.position(position);
        return i6;
    }

    public a() {
        this.f2342g = 0;
        this.f2342g = f2335j.incrementAndGet();
    }
}
