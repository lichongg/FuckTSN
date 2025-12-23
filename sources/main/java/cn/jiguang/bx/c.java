package cn.jiguang.bx;

import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.q0;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    int f2640a;

    /* renamed from: b, reason: collision with root package name */
    int f2641b;

    /* renamed from: c, reason: collision with root package name */
    int f2642c;

    /* renamed from: d, reason: collision with root package name */
    Long f2643d;

    /* renamed from: e, reason: collision with root package name */
    int f2644e;

    /* renamed from: f, reason: collision with root package name */
    long f2645f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2646g;

    public c(boolean z5, int i6, int i7, int i8, long j6, int i9, long j7) {
        this.f2646g = z5;
        this.f2640a = i6;
        this.f2641b = i7;
        this.f2642c = i8;
        this.f2643d = Long.valueOf(j6);
        this.f2644e = i9;
        this.f2645f = j7;
    }

    public int a() {
        return this.f2642c;
    }

    public Long b() {
        return this.f2643d;
    }

    public c(boolean z5, int i6, int i7, long j6) {
        this(z5, 0, i6, i7, j6, 0, 0L);
    }

    public void a(int i6) {
        this.f2640a = i6;
    }

    public void b(int i6) {
        this.f2644e = i6;
    }

    public long c() {
        return this.f2645f;
    }

    public int d() {
        return this.f2644e;
    }

    public int e() {
        return this.f2641b;
    }

    public byte[] f() {
        if (this.f2640a == 0) {
            throw new IllegalStateException("The head is not initialized yet.");
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        allocate.putShort((short) this.f2640a);
        allocate.put((byte) this.f2641b);
        allocate.put((byte) this.f2642c);
        allocate.putLong(this.f2643d.longValue());
        if (this.f2646g) {
            allocate.putInt(this.f2644e);
        }
        allocate.putLong(this.f2645f);
        allocate.flip();
        return ProtocolUtil.getBytesConsumed(allocate);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[JHead] - len:");
        sb.append(this.f2640a);
        sb.append(", version:");
        sb.append(this.f2641b);
        sb.append(", command:");
        sb.append(this.f2642c);
        sb.append(", rid:");
        sb.append(this.f2643d);
        if (this.f2646g) {
            str = ", sid:" + this.f2644e;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f2645f);
        return sb.toString();
    }

    public c(boolean z5, byte[] bArr) {
        this.f2646g = z5;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f2640a = wrap.getShort() & q0.f44053c;
        this.f2641b = wrap.get();
        this.f2642c = wrap.get();
        Long valueOf = Long.valueOf(wrap.getLong());
        this.f2643d = valueOf;
        this.f2643d = Long.valueOf(valueOf.longValue() & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        if (z5) {
            this.f2644e = wrap.getInt();
        }
        this.f2645f = wrap.getLong();
    }

    public void a(long j6) {
        this.f2645f = j6;
    }
}
