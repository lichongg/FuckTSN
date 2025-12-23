package com.bykv.vk.component.ttvideo.utils;

import com.bytedance.sdk.component.oq.oq;
import com.bytedance.sdk.component.oq.r.r;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class EngineThreadPool {

    /* renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f22933a;

    public static ExecutorService a() {
        if (f22933a == null) {
            synchronized (EngineThreadPool.class) {
                try {
                    if (f22933a == null) {
                        r rVar = new r(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new oq("EngineThreadPool"));
                        f22933a = rVar;
                        rVar.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f22933a;
    }

    public static void setExcutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            f22933a = threadPoolExecutor;
        }
    }
}
