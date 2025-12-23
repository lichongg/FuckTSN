package cn.jiguang.bk;

import cn.jiguang.api.JCoreManager;
import cn.jiguang.bb.f;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f2317a;

    /* renamed from: b, reason: collision with root package name */
    public int f2318b;

    /* renamed from: c, reason: collision with root package name */
    public int f2319c;

    /* renamed from: d, reason: collision with root package name */
    public int f2320d;

    /* renamed from: e, reason: collision with root package name */
    private final c f2321e;

    /* renamed from: f, reason: collision with root package name */
    private ByteBuffer f2322f;

    /* renamed from: g, reason: collision with root package name */
    private int f2323g;

    /* renamed from: h, reason: collision with root package name */
    private String f2324h;

    /* renamed from: i, reason: collision with root package name */
    private String f2325i;

    private void a() {
        try {
            this.f2317a = this.f2322f.getShort();
        } catch (Throwable unused) {
            this.f2317a = 10000;
        }
        if (this.f2317a > 0) {
            f.l("LoginResponse", "Response error - code:" + this.f2317a);
        }
        ByteBuffer byteBuffer = this.f2322f;
        this.f2320d = -1;
        int i6 = this.f2317a;
        if (i6 != 0) {
            if (i6 == 1012) {
                try {
                    this.f2325i = b.a(byteBuffer);
                } catch (Throwable unused2) {
                    this.f2317a = 10000;
                }
                cn.jiguang.bf.a.a(JCoreManager.getAppContext(null), this.f2325i);
                return;
            }
            return;
        }
        try {
            this.f2318b = byteBuffer.getInt();
            this.f2323g = byteBuffer.getShort();
            this.f2324h = b.a(byteBuffer);
            this.f2319c = byteBuffer.getInt();
        } catch (Throwable unused3) {
            this.f2317a = 10000;
        }
        try {
            this.f2320d = byteBuffer.get();
            f.c("LoginResponse", "idc parse success, value:" + this.f2320d);
        } catch (Throwable th) {
            f.i("LoginResponse", "parse idc failed, error:" + th);
        }
    }

    public String toString() {
        return "[LoginResponse] - code:" + this.f2317a + ",sid:" + this.f2318b + ", serverVersion:" + this.f2323g + ", sessionKey:" + this.f2324h + ", serverTime:" + this.f2319c + ", idc:" + this.f2320d + ", connectInfo:" + this.f2325i;
    }

    public d(c cVar, ByteBuffer byteBuffer) {
        this.f2321e = cVar;
        if (byteBuffer != null) {
            this.f2322f = byteBuffer;
            a();
        } else {
            f.i("LoginResponse", "No body to parse.");
        }
    }
}
