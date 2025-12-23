package com.acse.ottn.io.reactivex.schedulers;

import java.util.concurrent.Executor;
import rx.h;
import rx.schedulers.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Schedulers {
    public static h computation() {
        return c.a();
    }

    public static h from(Executor executor) {
        return c.b(executor);
    }

    public static h immediate() {
        return c.d();
    }

    public static h io() {
        return c.e();
    }

    public static h newThread() {
        return c.f();
    }

    public static h trampoline() {
        return c.m();
    }
}
