package com.jg.ids;

/* loaded from: D:\Downloads\app\classes10.dex */
final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f35513a;

    /* renamed from: b, reason: collision with root package name */
    private /* synthetic */ a f35514b;

    c(a aVar, String str) {
        this.f35514b = aVar;
        this.f35513a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f35514b.c(this.f35513a);
    }
}
