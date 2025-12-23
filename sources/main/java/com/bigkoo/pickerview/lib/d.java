package com.bigkoo.pickerview.lib;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final WheelView f14424a;

    @Override // java.lang.Runnable
    public final void run() {
        WheelView wheelView = this.f14424a;
        wheelView.f14394e.a(wheelView.getCurrentItem());
    }

    d(WheelView wheelView) {
        this.f14424a = wheelView;
    }
}
