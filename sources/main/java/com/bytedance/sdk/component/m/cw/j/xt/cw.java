package com.bytedance.sdk.component.m.cw.j.xt;

import com.bytedance.sdk.component.m.mi;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements mi {
    private com.bytedance.sdk.component.m.cw.j.cw<String, byte[]> cw;

    /* renamed from: j, reason: collision with root package name */
    private int f26569j;
    private int xt;

    @Override // com.bytedance.sdk.component.m.j
    public boolean xt(String str) {
        return this.cw.j((com.bytedance.sdk.component.m.cw.j.cw<String, byte[]>) str) != null;
    }

    public cw(int i6, int i7) {
        this.xt = i6;
        this.f26569j = i7;
        this.cw = new com.bytedance.sdk.component.m.cw.j.cw<String, byte[]>(i6) { // from class: com.bytedance.sdk.component.m.cw.j.xt.cw.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.m.cw.j.cw
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public int xt(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.m.j
    public boolean j(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.cw.j(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.m.j
    public byte[] j(String str) {
        return this.cw.j((com.bytedance.sdk.component.m.cw.j.cw<String, byte[]>) str);
    }

    @Override // com.bytedance.sdk.component.m.j
    public void j(double d6) {
        this.cw.j((int) (this.xt * d6));
    }
}
