package com.bytedance.sdk.openadsdk.az;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: r, reason: collision with root package name */
    private int f27745r;
    private tl xt;

    /* renamed from: j, reason: collision with root package name */
    private ScheduledExecutorService f27744j = null;
    private long cw = 0;

    public void j(long j6) {
        this.cw = j6;
    }

    public boolean xt() {
        ScheduledExecutorService scheduledExecutorService = this.f27744j;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }

    public xt(tl tlVar, int i6) {
        this.xt = tlVar;
        this.f27745r = i6;
    }

    public void j(int i6) {
        ScheduledExecutorService j6 = com.bytedance.sdk.component.oq.cw.j(1, new com.bytedance.sdk.component.oq.oq("/CrashMonitor"));
        this.f27744j = j6;
        j6.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.az.xt.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (System.currentTimeMillis() - xt.this.cw > xt.this.f27745r) {
                    xt.this.f27744j.shutdown();
                    if (xt.this.xt != null) {
                        xt.this.xt.xt(0, "自动检测卡死");
                    }
                }
            }
        }, 0L, i6, TimeUnit.MILLISECONDS);
    }

    public void j() {
        ScheduledExecutorService scheduledExecutorService = this.f27744j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }
}
