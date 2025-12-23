package cn.jiguang.bk;

import cn.jiguang.api.JCoreManager;
import cn.jiguang.bb.f;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f2326a;

    /* renamed from: b, reason: collision with root package name */
    public long f2327b;

    /* renamed from: c, reason: collision with root package name */
    public String f2328c;

    /* renamed from: d, reason: collision with root package name */
    public String f2329d;

    /* renamed from: e, reason: collision with root package name */
    public String f2330e;

    /* renamed from: f, reason: collision with root package name */
    private final c f2331f;

    /* renamed from: g, reason: collision with root package name */
    private ByteBuffer f2332g;

    /* renamed from: h, reason: collision with root package name */
    private String f2333h;

    /* renamed from: i, reason: collision with root package name */
    private String f2334i;

    private void a() {
        try {
            this.f2326a = this.f2332g.getShort();
        } catch (Throwable unused) {
            this.f2326a = 10000;
        }
        if (this.f2326a > 0) {
            f.l("RegisterResponse", "Response error - code:" + this.f2326a);
        }
        ByteBuffer byteBuffer = this.f2332g;
        int i6 = this.f2326a;
        try {
            if (i6 == 0) {
                this.f2327b = byteBuffer.getLong();
                this.f2328c = b.a(byteBuffer);
                this.f2329d = b.a(byteBuffer);
            } else {
                if (i6 != 1007) {
                    if (i6 == 1012) {
                        try {
                            this.f2334i = b.a(byteBuffer);
                        } catch (Throwable unused2) {
                            this.f2326a = 10000;
                        }
                        cn.jiguang.bf.a.a(JCoreManager.getAppContext(null), this.f2334i);
                        return;
                    }
                    return;
                }
                this.f2333h = b.a(byteBuffer);
            }
        } catch (Throwable unused3) {
            this.f2326a = 10000;
        }
    }

    public String toString() {
        return "[RegisterResponse] - code:" + this.f2326a + ", juid:" + this.f2327b + ", password:" + this.f2328c + ", regId:" + this.f2329d + ", deviceId:" + this.f2330e + ", connectInfo:" + this.f2334i;
    }

    public e(c cVar, ByteBuffer byteBuffer) {
        this.f2331f = cVar;
        if (byteBuffer != null) {
            this.f2332g = byteBuffer;
            a();
        } else {
            f.i("RegisterResponse", "No body to parse.");
        }
    }
}
