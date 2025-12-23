package com.bytedance.sdk.component.xt.j.j;

import com.bytedance.sdk.component.cw.xt.v;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.xt.j.j.j.m;
import com.bytedance.sdk.component.xt.j.j.xt.cw;
import com.bytedance.sdk.component.xt.j.vl;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f27273j;
    private static AtomicBoolean xt = new AtomicBoolean(true);

    public static j j() {
        if (f27273j == null) {
            synchronized (j.class) {
                try {
                    if (f27273j == null) {
                        f27273j = new j();
                    }
                } finally {
                }
            }
        }
        return f27273j;
    }

    public boolean xt() {
        AtomicBoolean atomicBoolean = xt;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    private j() {
    }

    public void j(boolean z5) {
        vl.j("NetClientAdapter", "set useOkHttp:".concat(String.valueOf(z5)));
        xt.set(z5);
    }

    public static com.bytedance.sdk.component.xt.j.vl j(vl.j jVar) {
        return new cw(jVar);
    }

    public static com.bytedance.sdk.component.xt.j.vl j(v.j jVar) {
        return new m(jVar);
    }
}
