package org.junit;

import org.hamcrest.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AssumptionViolatedException extends org.junit.internal.AssumptionViolatedException {
    private static final long serialVersionUID = 1;

    public <T> AssumptionViolatedException(T t5, j<T> jVar) {
        super((Object) t5, (j<?>) jVar);
    }

    public <T> AssumptionViolatedException(String str, T t5, j<T> jVar) {
        super(str, t5, jVar);
    }

    public AssumptionViolatedException(String str) {
        super(str);
    }

    public AssumptionViolatedException(String str, Throwable th) {
        super(str, th);
    }
}
