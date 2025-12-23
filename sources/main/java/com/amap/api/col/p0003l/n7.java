package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class n7 extends q7 {

    /* renamed from: c, reason: collision with root package name */
    private StringBuilder f6807c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6808d;

    public n7() {
        this.f6807c = new StringBuilder();
        this.f6808d = true;
    }

    @Override // com.amap.api.col.p0003l.q7
    protected final byte[] b(byte[] bArr) {
        byte[] o5 = q4.o(this.f6807c.toString());
        this.f6987b = o5;
        this.f6808d = true;
        StringBuilder sb = this.f6807c;
        sb.delete(0, sb.length());
        return o5;
    }

    @Override // com.amap.api.col.p0003l.q7
    public final void c(byte[] bArr) {
        String g6 = q4.g(bArr);
        if (this.f6808d) {
            this.f6808d = false;
        } else {
            this.f6807c.append(",");
        }
        StringBuilder sb = this.f6807c;
        sb.append("{\"log\":\"");
        sb.append(g6);
        sb.append("\"}");
    }

    public n7(q7 q7Var) {
        super(q7Var);
        this.f6807c = new StringBuilder();
        this.f6808d = true;
    }
}
