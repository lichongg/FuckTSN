package com.bytedance.sdk.component.g.r;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private j f26444j;
    private xt xt;

    /* renamed from: com.bytedance.sdk.component.g.r.cw$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: com.bytedance.sdk.component.g.r.cw$cw, reason: collision with other inner class name */
    private static class C0410cw {

        /* renamed from: j, reason: collision with root package name */
        private static final cw f26445j = new cw(null);
    }

    public enum j {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    public interface xt {
        void j(String str, String str2);
    }

    /* synthetic */ cw(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static void j(j jVar) {
        synchronized (cw.class) {
            C0410cw.f26445j.f26444j = jVar;
        }
    }

    private cw() {
        this.f26444j = j.OFF;
        this.xt = new com.bytedance.sdk.component.g.r.xt();
    }

    public static void xt(String str, String str2) {
        if (C0410cw.f26445j.f26444j.compareTo(j.DEBUG) <= 0) {
            cw unused = C0410cw.f26445j;
        }
    }

    public static void j(String str, String str2) {
        if (C0410cw.f26445j.f26444j.compareTo(j.ERROR) <= 0) {
            C0410cw.f26445j.xt.j(str, str2);
        }
    }
}
