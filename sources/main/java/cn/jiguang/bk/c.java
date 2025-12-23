package cn.jiguang.bk;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.q0;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f2309a;

    /* renamed from: b, reason: collision with root package name */
    public int f2310b;

    /* renamed from: c, reason: collision with root package name */
    public int f2311c;

    /* renamed from: d, reason: collision with root package name */
    public byte f2312d;

    /* renamed from: e, reason: collision with root package name */
    public long f2313e;

    /* renamed from: f, reason: collision with root package name */
    public int f2314f;

    /* renamed from: g, reason: collision with root package name */
    public long f2315g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2316h;

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[JHead] - len:");
        sb.append(this.f2309a);
        sb.append(", version:");
        sb.append(this.f2310b);
        sb.append(", command:");
        sb.append(this.f2311c);
        sb.append(", rid:");
        sb.append(this.f2313e);
        if (this.f2316h) {
            str = ", sid:" + this.f2314f;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f2315g);
        return sb.toString();
    }

    public c(boolean z5, byte[] bArr) {
        try {
            this.f2316h = z5;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f2309a = wrap.getShort() & q0.f44053c;
            this.f2310b = wrap.get();
            this.f2311c = wrap.get();
            this.f2312d = wrap.get();
            wrap.get();
            wrap.getInt();
            this.f2313e = wrap.getShort();
            if (z5) {
                this.f2314f = wrap.getInt();
            }
            this.f2315g = wrap.getLong();
        } catch (Throwable unused) {
        }
    }
}
