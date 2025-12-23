package com.bytedance.sdk.component.m.j;

import com.bytedance.sdk.component.oq.r.r;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static final TimeUnit f26595j = TimeUnit.SECONDS;

    public static ExecutorService j() {
        r rVar = new r(1, 2, 30L, f26595j, new LinkedBlockingQueue(), new j("default"));
        rVar.allowCoreThreadTimeOut(true);
        return rVar;
    }
}
