package org.junit.rules;

import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class k extends m {

    /* renamed from: a, reason: collision with root package name */
    private String f51474a;

    public String r() {
        return this.f51474a;
    }

    @Override // org.junit.rules.m
    protected void n(Description description) {
        this.f51474a = description.getMethodName();
    }
}
