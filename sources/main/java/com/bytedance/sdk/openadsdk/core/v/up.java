package com.bytedance.sdk.openadsdk.core.v;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.component.g.j;
import com.bytedance.sdk.openadsdk.core.tj.gq;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.v.j;
import com.stub.StubApp;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile up f30957j;
    private com.bytedance.sdk.openadsdk.ws.j.j cw;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.sdk.component.g.j f30958r;
    private Context xt;

    public static up j() {
        if (f30957j == null) {
            synchronized (up.class) {
                try {
                    if (f30957j == null) {
                        com.bytedance.sdk.component.xt.j.j.j.j().j(com.bytedance.sdk.openadsdk.core.cw.cw.j().m() != 2);
                        f30957j = new up(v.getContext());
                    }
                } finally {
                }
            }
        }
        return f30957j;
    }

    private void r() {
        if (this.cw == null) {
            this.cw = new com.bytedance.sdk.openadsdk.ws.j.j();
        }
    }

    public com.bytedance.sdk.component.g.j xt() {
        return this.f30958r;
    }

    private up(Context context) {
        Context origApplicationContext;
        if (context == null) {
            origApplicationContext = v.getContext();
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.xt = origApplicationContext;
        j.C0409j c0409j = new j.C0409j();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        com.bytedance.sdk.component.g.j j6 = c0409j.j(10000L, timeUnit).xt(10000L, timeUnit).cw(10000L, timeUnit).j(new j.C0488j()).j(gq.j()).j(gq.xt()).j(true).j();
        this.f30958r = j6;
        com.bytedance.sdk.component.xt.j.r j7 = j6.m().j();
        if (j7 != null) {
            j7.j(32);
            j7.xt(com.bytedance.sdk.openadsdk.core.cw.cw.j().up());
        }
    }

    public com.bytedance.sdk.openadsdk.ws.j.j cw() {
        r();
        return this.cw;
    }
}
