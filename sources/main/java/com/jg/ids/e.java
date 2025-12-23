package com.jg.ids;

/* loaded from: D:\Downloads\app\classes10.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f35519a;

    /* renamed from: b, reason: collision with root package name */
    private /* synthetic */ a f35520b;

    e(a aVar, String str) {
        this.f35520b = aVar;
        this.f35519a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f35520b.a(this.f35519a);
    }
}
