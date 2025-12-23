package com.jg.ids.h;

/* loaded from: D:\Downloads\app\classes10.dex */
final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f35536a;

    /* renamed from: b, reason: collision with root package name */
    private /* synthetic */ a f35537b;

    d(a aVar, String str) {
        this.f35537b = aVar;
        this.f35536a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f35537b.a(this.f35536a);
    }
}
