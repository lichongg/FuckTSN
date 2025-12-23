package cn.jiguang.bg;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes2.dex */
class q extends cn.jiguang.by.b {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f2152a;

    /* renamed from: b, reason: collision with root package name */
    private cn.jiguang.bl.a f2153b;

    /* renamed from: c, reason: collision with root package name */
    private Context f2154c;

    q(cn.jiguang.bl.a aVar, Context context, byte[] bArr) {
        this.f2154c = cn.jiguang.bz.d.a(context);
        this.f2152a = bArr;
        this.f2653h = "TcpRecvAction";
        this.f2153b = aVar;
    }

    @Override // cn.jiguang.by.b
    public void a() {
        try {
            cn.jiguang.bi.g.a().a(this.f2154c, "tcp_a22", null);
            cn.jiguang.bk.a.a(this.f2153b, this.f2154c, this.f2152a);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("TcpRecvAction", "TcpRecvAction failed:" + th.getMessage());
        }
    }
}
