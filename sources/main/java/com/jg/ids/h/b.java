package com.jg.ids.h;

/* loaded from: D:\Downloads\app\classes10.dex */
final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f35532a;

    /* renamed from: b, reason: collision with root package name */
    private /* synthetic */ a f35533b;

    b(a aVar, String str) {
        this.f35533b = aVar;
        this.f35532a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f35533b.c(this.f35532a);
    }
}
