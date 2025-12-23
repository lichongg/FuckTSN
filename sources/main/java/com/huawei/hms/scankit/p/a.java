package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class a extends Exception {

    /* renamed from: a, reason: collision with root package name */
    protected static final boolean f33958a;

    /* renamed from: b, reason: collision with root package name */
    protected static final StackTraceElement[] f33959b;

    /* renamed from: c, reason: collision with root package name */
    private static final a f33960c;

    private a() {
    }

    public static a a() {
        return f33958a ? new a() : f33960c;
    }

    static {
        f33958a = System.getProperty("surefire.test.class.path") != null;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        f33959b = stackTraceElementArr;
        a aVar = new a();
        f33960c = aVar;
        aVar.setStackTrace(stackTraceElementArr);
    }

    private a(String str) {
        super(str);
    }

    public static a a(String str) {
        return new a(str);
    }
}
