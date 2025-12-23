package com.bigkoo.pickerview.lib;

import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class e extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    int f14425a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    int f14426b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f14427c;

    /* renamed from: d, reason: collision with root package name */
    final WheelView f14428d;

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f14425a == Integer.MAX_VALUE) {
            this.f14425a = this.f14427c;
        }
        int i6 = this.f14425a;
        int i7 = (int) (i6 * 0.1f);
        this.f14426b = i7;
        if (i7 == 0) {
            if (i6 < 0) {
                this.f14426b = -1;
            } else {
                this.f14426b = 1;
            }
        }
        if (Math.abs(i6) <= 1) {
            this.f14428d.a();
            this.f14428d.f14392c.sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f14428d;
        wheelView.A += this.f14426b;
        if (!wheelView.f14412w) {
            float f6 = wheelView.f14406q;
            float f7 = (-wheelView.B) * f6;
            int itemsCount = wheelView.getItemsCount() - 1;
            WheelView wheelView2 = this.f14428d;
            float f8 = (itemsCount - wheelView2.B) * f6;
            int i8 = wheelView2.A;
            if (i8 <= f7 || i8 >= f8) {
                wheelView2.A = i8 - this.f14426b;
                wheelView2.a();
                this.f14428d.f14392c.sendEmptyMessage(3000);
                return;
            }
        }
        this.f14428d.f14392c.sendEmptyMessage(1000);
        this.f14425a -= this.f14426b;
    }

    e(WheelView wheelView, int i6) {
        this.f14428d = wheelView;
        this.f14427c = i6;
    }
}
