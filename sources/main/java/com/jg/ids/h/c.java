package com.jg.ids.h;

/* loaded from: D:\Downloads\app\classes10.dex */
final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f35534a;

    /* renamed from: b, reason: collision with root package name */
    private /* synthetic */ a f35535b;

    c(a aVar, String str) {
        this.f35535b = aVar;
        this.f35534a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f35535b.b(this.f35534a);
    }
}
