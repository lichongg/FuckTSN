package com.bytedance.sdk.component.adexpress.r;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    public static void j(com.bytedance.sdk.component.oq.g gVar, int i6) {
        if (gVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.j.j.cw cw = com.bytedance.sdk.component.adexpress.j.j.j.j().cw();
        ExecutorService ws = cw != null ? cw.ws() : null;
        if (ws == null) {
            com.bytedance.sdk.component.oq.ae.j(gVar, i6);
        } else {
            gVar.setPriority(i6);
            ws.execute(gVar);
        }
    }

    public static void xt(com.bytedance.sdk.component.oq.g gVar, int i6) {
        if (gVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.j.j.cw cw = com.bytedance.sdk.component.adexpress.j.j.j.j().cw();
        ExecutorService jy = cw != null ? cw.jy() : null;
        if (jy == null) {
            com.bytedance.sdk.component.oq.ae.j(gVar);
        } else {
            gVar.setPriority(i6);
            jy.execute(gVar);
        }
    }

    public static ScheduledFuture j(Runnable runnable, long j6, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.oq.ae.r().schedule(runnable, j6, timeUnit);
    }
}
