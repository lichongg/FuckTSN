package com.bytedance.adsdk.j.j.cw;

import com.bytedance.adsdk.j.j.xt.cw;
import com.bytedance.adsdk.j.j.xt.m;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j implements xt {
    public abstract ByteBuffer j();

    @Override // com.bytedance.adsdk.j.j.cw.xt
    public m xt() throws IOException {
        return new cw(j());
    }
}
