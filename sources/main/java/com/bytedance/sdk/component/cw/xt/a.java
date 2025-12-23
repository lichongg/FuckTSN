package com.bytedance.sdk.component.cw.xt;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class a {
    public static a j(tj tjVar, String str) {
        Charset charset = com.bytedance.sdk.component.cw.xt.j.cw.up;
        if (tjVar != null) {
            Charset cw = tjVar.cw();
            if (cw == null) {
                tjVar = tj.j(tjVar + "; charset=utf-8");
            } else {
                charset = cw;
            }
        }
        return j(tjVar, str.getBytes(charset));
    }

    public abstract tj j();

    public abstract void j(com.bytedance.sdk.component.cw.j.r rVar) throws IOException;

    public long xt() throws IOException {
        return -1L;
    }

    public static a j(tj tjVar, byte[] bArr) {
        return j(tjVar, bArr, 0, bArr.length);
    }

    public static a j(final tj tjVar, final byte[] bArr, final int i6, final int i7) {
        if (bArr != null) {
            com.bytedance.sdk.component.cw.xt.j.cw.j(bArr.length, i6, i7);
            return new a() { // from class: com.bytedance.sdk.component.cw.xt.a.1
                @Override // com.bytedance.sdk.component.cw.xt.a
                public tj j() {
                    return tj.this;
                }

                @Override // com.bytedance.sdk.component.cw.xt.a
                public void j(com.bytedance.sdk.component.cw.j.r rVar) throws IOException {
                    rVar.cw(bArr, i6, i7);
                }

                @Override // com.bytedance.sdk.component.cw.xt.a
                public long xt() {
                    return i7;
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
