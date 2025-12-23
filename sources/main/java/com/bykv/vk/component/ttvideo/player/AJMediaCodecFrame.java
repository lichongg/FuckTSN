package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import com.bytedance.sdk.component.utils.vl;
import java.nio.ByteBuffer;

@Keep
@TargetApi(16)
/* loaded from: D:\Downloads\app\classes3.dex */
public class AJMediaCodecFrame implements Cloneable {

    @Keep
    public ByteBuffer data;

    @Keep
    public int flags;

    @Keep
    public int index;

    @Keep
    public long pts = -269488145;

    @Keep
    public int size;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJMediaCodecFrame m89clone() {
        try {
            return (AJMediaCodecFrame) super.clone();
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    @Keep
    public AJMediaCodecFrame() {
    }
}
