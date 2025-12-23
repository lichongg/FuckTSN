package org.junit.internal;

import org.hamcrest.j;
import org.hamcrest.l;
import org.hamcrest.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AssumptionViolatedException extends RuntimeException implements l {
    private static final long serialVersionUID = 2;
    private final String fAssumption;
    private final j<?> fMatcher;
    private final Object fValue;
    private final boolean fValueMatcher;

    @Deprecated
    public AssumptionViolatedException(String str, boolean z5, Object obj, j<?> jVar) {
        this.fAssumption = str;
        this.fValue = obj;
        this.fMatcher = jVar;
        this.fValueMatcher = z5;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        String str = this.fAssumption;
        if (str != null) {
            gVar.b(str);
        }
        if (this.fValueMatcher) {
            if (this.fAssumption != null) {
                gVar.b(": ");
            }
            gVar.b("got: ");
            gVar.c(this.fValue);
            if (this.fMatcher != null) {
                gVar.b(", expected: ");
                gVar.f(this.fMatcher);
            }
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return m.n(this);
    }

    @Deprecated
    public AssumptionViolatedException(Object obj, j<?> jVar) {
        this(null, true, obj, jVar);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Object obj, j<?> jVar) {
        this(str, true, obj, jVar);
    }

    @Deprecated
    public AssumptionViolatedException(String str) {
        this(str, false, null, null);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Throwable th) {
        this(str, false, null, null);
        initCause(th);
    }
}
