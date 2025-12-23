package com.bytedance.sdk.component.widget.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static volatile j xt;

    /* renamed from: j, reason: collision with root package name */
    private volatile xt f26972j;

    public static j j() {
        if (xt == null) {
            synchronized (j.class) {
                try {
                    if (xt == null) {
                        xt = new j();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    public xt xt() {
        return this.f26972j;
    }

    private j() {
    }
}
