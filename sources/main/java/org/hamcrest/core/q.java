package org.hamcrest.core;

import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class q extends r {
    @Factory
    public static org.hamcrest.j<String> j(String str) {
        return new q(str);
    }

    @Override // org.hamcrest.core.r
    protected boolean g(String str) {
        return str.startsWith(this.f51298c);
    }

    @Override // org.hamcrest.core.r
    protected String i() {
        return "starting with";
    }

    public q(String str) {
        super(str);
    }
}
