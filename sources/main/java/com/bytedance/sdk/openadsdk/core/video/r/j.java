package com.bytedance.sdk.openadsdk.core.video.r;

import com.bytedance.sdk.openadsdk.i.cw.xt.ws;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    static final Map<Integer, WeakReference<ws>> f31117j = new HashMap();

    public static void j(Integer num, ws wsVar) {
        f31117j.put(num, new WeakReference<>(wsVar));
    }

    public static ws j(Integer num) {
        WeakReference<ws> weakReference = f31117j.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
