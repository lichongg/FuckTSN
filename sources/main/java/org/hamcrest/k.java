package org.hamcrest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class k {
    public static <T> void a(T t5, j<? super T> jVar) {
        b("", t5, jVar);
    }

    public static void c(String str, boolean z5) {
        if (!z5) {
            throw new AssertionError(str);
        }
    }

    public static <T> void b(String str, T t5, j<? super T> jVar) {
        if (jVar.c(t5)) {
            return;
        }
        m mVar = new m();
        mVar.b(str).b("\nExpected: ").f(jVar).b("\n     but: ");
        jVar.b(t5, mVar);
        throw new AssertionError(mVar.toString());
    }
}
