package com.oplus.omes.stdsco.log;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class StdScoLog {

    /* renamed from: a, reason: collision with root package name */
    public static final int f36392a = 2;

    /* renamed from: b, reason: collision with root package name */
    public static final int f36393b = 3;

    /* renamed from: c, reason: collision with root package name */
    public static final int f36394c = 4;

    /* renamed from: d, reason: collision with root package name */
    public static final int f36395d = 5;

    /* renamed from: e, reason: collision with root package name */
    public static final int f36396e = 6;

    /* renamed from: f, reason: collision with root package name */
    public static final int f36397f = 7;

    /* renamed from: g, reason: collision with root package name */
    public static final int f36398g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public static final int f36399h = Integer.MIN_VALUE;

    private static native void nativeLogInit(int level, String tag);

    public static synchronized void a(int level, String tag) {
        synchronized (StdScoLog.class) {
            if (tag != null) {
                try {
                    if (tag.equals("")) {
                    }
                    nativeLogInit(level, tag);
                } catch (Throwable th) {
                    throw th;
                }
            }
            tag = "[\\s\\S]*";
            nativeLogInit(level, tag);
        }
    }
}
