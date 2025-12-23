package com.bytedance.adsdk.j.j;

import com.bytedance.adsdk.j.j.j.g;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends cw<com.bytedance.adsdk.j.j.j.xt> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.j.j.cw
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.j.j.j.xt xt(com.bytedance.adsdk.j.j.cw.xt xtVar, g.j jVar) {
        return new com.bytedance.adsdk.j.j.j.xt(xtVar, jVar);
    }

    public static j j(final ByteBuffer byteBuffer) {
        return new j(new com.bytedance.adsdk.j.j.cw.j() { // from class: com.bytedance.adsdk.j.j.j.1
            @Override // com.bytedance.adsdk.j.j.cw.j
            public ByteBuffer j() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        });
    }

    public j(com.bytedance.adsdk.j.j.cw.xt xtVar) {
        super(xtVar);
    }
}
