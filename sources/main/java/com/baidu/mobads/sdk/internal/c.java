package com.baidu.mobads.sdk.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f10832a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f10833a = "remote_adserv";

        /* renamed from: b, reason: collision with root package name */
        public static final String f10834b = "remote_novel";
    }

    public static c a() {
        if (f10832a == null) {
            synchronized (c.class) {
                try {
                    if (f10832a == null) {
                        f10832a = new c();
                    }
                } finally {
                }
            }
        }
        return f10832a;
    }

    private c() {
    }

    public as a(String str) {
        return new as(str);
    }
}
