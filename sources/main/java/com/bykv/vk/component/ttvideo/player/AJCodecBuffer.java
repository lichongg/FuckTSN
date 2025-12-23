package com.bykv.vk.component.ttvideo.player;

import com.bytedance.sdk.component.utils.vl;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AJCodecBuffer implements Cloneable {
    public ByteBuffer data;
    public int index;
    public long pts;
    public int size;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJCodecBuffer m88clone() {
        AJCodecBuffer aJCodecBuffer;
        try {
            aJCodecBuffer = (AJCodecBuffer) super.clone();
        } catch (Throwable th) {
            vl.j(th);
            aJCodecBuffer = null;
        }
        aJCodecBuffer.size = this.size;
        aJCodecBuffer.pts = this.pts;
        aJCodecBuffer.index = this.index;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.size);
        allocateDirect.put(this.data);
        aJCodecBuffer.data = allocateDirect;
        return aJCodecBuffer;
    }
}
