package com.bytedance.j.xt.up;

import androidx.camera.view.p;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\Downloads\app\classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference<Long> f24251a = new AtomicReference<>(0L);

    public static void a(long j6) {
        int i6 = 0;
        while (true) {
            int i7 = i6 + 1;
            if (i6 >= 5) {
                return;
            }
            AtomicReference<Long> atomicReference = f24251a;
            Long l6 = atomicReference.get();
            if (p.a(atomicReference, l6, Long.valueOf(l6.longValue() | j6))) {
                return;
            } else {
                i6 = i7;
            }
        }
    }
}
