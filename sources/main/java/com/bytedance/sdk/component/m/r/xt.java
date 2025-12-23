package com.bytedance.sdk.component.m.r;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements g {

    /* renamed from: j, reason: collision with root package name */
    private byte[] f26605j;
    private com.bytedance.sdk.component.m.m xt;

    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        g upVar;
        int jy = cwVar.jy();
        cwVar.j(this.f26605j.length);
        if (jy == 2) {
            upVar = com.bytedance.sdk.component.m.cw.cw.j.j(this.f26605j) ? new up(this.f26605j, this.xt) : this.xt == null ? new qv() : new tl(1001, "not image format", null);
        } else if (jy != 3) {
            boolean xt = com.bytedance.sdk.component.m.cw.cw.j.xt(this.f26605j);
            if (xt) {
                byte[] bArr = this.f26605j;
                upVar = new jy(bArr, bArr, this.xt, xt);
            } else if (com.bytedance.sdk.component.m.cw.cw.j.j(this.f26605j)) {
                upVar = new up(this.f26605j, this.xt);
            } else {
                byte[] bArr2 = this.f26605j;
                upVar = new jy(bArr2, bArr2, this.xt, xt);
            }
        } else {
            byte[] bArr3 = this.f26605j;
            upVar = new jy(bArr3, bArr3, this.xt, com.bytedance.sdk.component.m.cw.cw.j.xt(bArr3));
        }
        cwVar.j(upVar);
    }

    public xt(byte[] bArr, com.bytedance.sdk.component.m.m mVar) {
        this.f26605j = bArr;
        this.xt = mVar;
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "image_type";
    }
}
