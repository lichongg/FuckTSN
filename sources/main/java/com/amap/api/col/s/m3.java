package com.amap.api.col.s;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class m3 extends p3 {

    /* renamed from: c, reason: collision with root package name */
    private StringBuilder f8252c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8253d;

    public m3() {
        this.f8252c = new StringBuilder();
        this.f8253d = true;
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) {
        byte[] o5 = j1.o(this.f8252c.toString());
        this.f8327b = o5;
        this.f8253d = true;
        StringBuilder sb = this.f8252c;
        sb.delete(0, sb.length());
        return o5;
    }

    @Override // com.amap.api.col.s.p3
    public final void c(byte[] bArr) {
        String g6 = j1.g(bArr);
        if (this.f8253d) {
            this.f8253d = false;
        } else {
            this.f8252c.append(",");
        }
        StringBuilder sb = this.f8252c;
        sb.append("{\"log\":\"");
        sb.append(g6);
        sb.append("\"}");
    }

    public m3(p3 p3Var) {
        super(p3Var);
        this.f8252c = new StringBuilder();
        this.f8253d = true;
    }
}
