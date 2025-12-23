package com.bytedance.j.xt.tl;

import android.annotation.TargetApi;
import android.app.ActivityManager;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final b f24228a = new c(null);

    /* renamed from: com.bytedance.j.xt.tl.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0346a {
    }

    private static class b {
        private b() {
        }

        /* synthetic */ b(C0346a c0346a) {
            this();
        }

        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }
    }

    @TargetApi(16)
    private static class c extends b {
        private c() {
            super(null);
        }

        /* synthetic */ c(C0346a c0346a) {
            this();
        }

        @Override // com.bytedance.j.xt.tl.a.b
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return f24228a.a(memoryInfo);
    }
}
