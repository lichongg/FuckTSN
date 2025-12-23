package org.junit.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class i {
    private i() {
    }

    public static Exception b(Throwable th) throws Exception {
        a(th);
        return null;
    }

    private static <T extends Throwable> void a(Throwable th) throws Throwable {
        throw th;
    }
}
