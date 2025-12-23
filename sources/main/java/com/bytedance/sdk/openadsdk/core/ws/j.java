package com.bytedance.sdk.openadsdk.core.ws;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f31298j;

    @Override // com.bytedance.sdk.openadsdk.core.ws.xt
    protected synchronized long cw() {
        return com.bytedance.sdk.openadsdk.core.cw.up.j().xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ws.xt
    protected synchronized int xt() {
        int cw = com.bytedance.sdk.openadsdk.core.cw.up.j().cw();
        if (com.bytedance.sdk.openadsdk.core.cw.up.j().r() <= 0.0f) {
            return cw;
        }
        return (int) Math.ceil(r1 * cw);
    }

    public static xt j() {
        if (f31298j == null) {
            synchronized (xt.class) {
                try {
                    if (f31298j == null) {
                        f31298j = new j();
                    }
                } finally {
                }
            }
        }
        return f31298j;
    }

    private j() {
    }
}
