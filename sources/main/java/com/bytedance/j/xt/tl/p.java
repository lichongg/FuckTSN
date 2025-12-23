package com.bytedance.j.xt.tl;

import android.annotation.TargetApi;
import android.os.Debug;

/* loaded from: D:\Downloads\app\classes3.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    static final b f24242a = new c(null);

    static /* synthetic */ class a {
    }

    private static class b {
        private b() {
        }

        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    @TargetApi(19)
    private static class c extends b {
        private c() {
            super(null);
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.bytedance.j.xt.tl.p.b
        public int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }

        @Override // com.bytedance.j.xt.tl.p.b
        public int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.bytedance.j.xt.tl.p.b
        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return f24242a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return f24242a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return f24242a.c(memoryInfo);
    }
}
