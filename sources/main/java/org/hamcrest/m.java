package org.hamcrest;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class m extends a {

    /* renamed from: b, reason: collision with root package name */
    private final Appendable f51313b;

    public m() {
        this(new StringBuilder());
    }

    public m(Appendable appendable) {
        this.f51313b = appendable;
    }

    public static String o(l lVar) {
        return new m().f(lVar).toString();
    }

    @Override // org.hamcrest.a
    protected void g(char c6) {
        try {
            this.f51313b.append(c6);
        } catch (IOException e6) {
            throw new RuntimeException("Could not write description", e6);
        }
    }

    @Override // org.hamcrest.a
    protected void h(String str) {
        try {
            this.f51313b.append(str);
        } catch (IOException e6) {
            throw new RuntimeException("Could not write description", e6);
        }
    }

    public String toString() {
        return this.f51313b.toString();
    }

    public static String n(l lVar) {
        return o(lVar);
    }
}
