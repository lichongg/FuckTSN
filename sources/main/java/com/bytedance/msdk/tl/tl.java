package com.bytedance.msdk.tl;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl {
    private static volatile tl cw;

    /* renamed from: j, reason: collision with root package name */
    private volatile String f25236j = "";
    private volatile ExecutorService xt = com.bytedance.msdk.j.up.m.j("gaid", 2, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.tl.tl.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });

    private class j implements Callable<String> {
        private j() {
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.msdk.core.xt.getContext());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    com.bytedance.msdk.j.up.cw.j("gaid-", "getAdvertisingId: ".concat(String.valueOf(id)));
                    tl.xt(id);
                }
            } catch (Throwable unused) {
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.msdk.core.xt.getContext());
                if (advertisingIdInfo2 != null) {
                    tl.this.f25236j = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable unused2) {
            }
            com.bytedance.msdk.j.up.cw.j("AdvertisingIdHelper", "mGAId:" + tl.this.f25236j + " , get gaid consume time :" + (System.currentTimeMillis() - currentTimeMillis));
            return tl.this.f25236j;
        }
    }

    public synchronized void cw() {
        try {
            this.f25236j = l.j("tt_device_info", com.bytedance.msdk.core.xt.getContext()).xt("gaid", "");
            com.bytedance.msdk.j.up.cw.j("gaid", "--==-- initGAIdByAsyc-mGAId = " + this.f25236j);
            if (TextUtils.isEmpty(this.f25236j) && this.xt != null) {
                this.xt.execute(new FutureTask(new j()));
            }
        } catch (Throwable unused) {
        }
    }

    public String xt() {
        try {
            this.f25236j = l.j("tt_device_info", com.bytedance.msdk.core.xt.getContext()).xt("gaid", "");
            com.bytedance.msdk.j.up.cw.j("gaid", "--==-- getGAIdTimeOut-mGAId = " + this.f25236j);
            if (TextUtils.isEmpty(this.f25236j)) {
                synchronized (this) {
                    try {
                        if (this.xt != null) {
                            FutureTask futureTask = new FutureTask(new j());
                            this.xt.execute(futureTask);
                            this.f25236j = (String) futureTask.get(1L, TimeUnit.MICROSECONDS);
                            if (!TextUtils.isEmpty(this.f25236j)) {
                                this.xt.shutdown();
                                this.xt = null;
                            }
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return this.f25236j;
    }

    private tl() {
    }

    public static tl j() {
        if (cw == null) {
            synchronized (tl.class) {
                try {
                    if (cw == null) {
                        cw = new tl();
                    }
                } finally {
                }
            }
        }
        return cw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        l.j("tt_device_info", com.bytedance.msdk.core.xt.getContext()).j("gaid", str);
    }
}
