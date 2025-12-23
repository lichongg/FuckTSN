package com.bytedance.sdk.openadsdk.core.ws;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile up f31300j;

    public static xt j() {
        if (f31300j == null) {
            synchronized (xt.class) {
                try {
                    if (f31300j == null) {
                        f31300j = new up();
                    }
                } finally {
                }
            }
        }
        return f31300j;
    }

    private up() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ws.xt
    protected long cw() {
        return com.bytedance.sdk.openadsdk.core.cw.up.j().xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ws.xt
    protected int xt() {
        return com.bytedance.sdk.openadsdk.core.cw.up.j().cw();
    }
}
