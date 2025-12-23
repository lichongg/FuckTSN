package com.bytedance.adsdk.j.j.xt;

import java.nio.ByteOrder;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends r {
    public void j(int i6) {
        j((byte) (i6 & 255));
        j((byte) ((i6 >> 8) & 255));
        j((byte) ((i6 >> 16) & 255));
        j((byte) ((i6 >> 24) & 255));
    }

    public void xt(int i6) {
        j((byte) ((i6 >> 24) & 255));
        j((byte) ((i6 >> 16) & 255));
        j((byte) ((i6 >> 8) & 255));
        j((byte) (i6 & 255));
    }

    @Override // com.bytedance.adsdk.j.j.xt.r
    public void cw(int i6) {
        super.cw(i6);
        this.f23170j.order(ByteOrder.BIG_ENDIAN);
    }
}
