package com.bytedance.sdk.component.tl.xt.cw;

import com.bytedance.sdk.component.tl.j.r;
import com.bytedance.sdk.component.tl.j.up;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static void j(AtomicLong atomicLong, int i6, up upVar) {
        r r5 = upVar.r();
        if (r5 != null && r5.cw() && atomicLong != null) {
            atomicLong.getAndAdd(i6);
        }
    }
}
