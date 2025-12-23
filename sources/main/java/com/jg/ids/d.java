package com.jg.ids;

/* loaded from: D:\Downloads\app\classes10.dex */
final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f35516a;

    /* renamed from: b, reason: collision with root package name */
    private /* synthetic */ a f35517b;

    d(a aVar, String str) {
        this.f35517b = aVar;
        this.f35516a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f35517b.b(this.f35516a);
    }
}
