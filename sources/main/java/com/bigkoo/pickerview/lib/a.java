package com.bigkoo.pickerview.lib;

import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class a extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    float f14416a = 2.1474836E9f;

    /* renamed from: b, reason: collision with root package name */
    final float f14417b;

    /* renamed from: c, reason: collision with root package name */
    final WheelView f14418c;

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f14416a == 2.1474836E9f) {
            if (Math.abs(this.f14417b) <= 2000.0f) {
                this.f14416a = this.f14417b;
            } else if (this.f14417b > 0.0f) {
                this.f14416a = 2000.0f;
            } else {
                this.f14416a = -2000.0f;
            }
        }
        if (Math.abs(this.f14416a) >= 0.0f && Math.abs(this.f14416a) <= 20.0f) {
            this.f14418c.a();
            this.f14418c.f14392c.sendEmptyMessage(2000);
            return;
        }
        int i6 = (int) ((this.f14416a * 10.0f) / 1000.0f);
        WheelView wheelView = this.f14418c;
        wheelView.A -= i6;
        if (!wheelView.f14412w) {
            float f6 = wheelView.f14406q;
            float f7 = (-wheelView.B) * f6;
            int itemsCount = wheelView.getItemsCount() - 1;
            WheelView wheelView2 = this.f14418c;
            float f8 = (itemsCount - wheelView2.B) * f6;
            int i7 = wheelView2.A;
            double d6 = f6 * 0.3d;
            if (i7 - d6 < f7) {
                f7 = i6 + i7;
            } else if (i7 + d6 > f8) {
                f8 = i6 + i7;
            }
            if (i7 <= f7) {
                this.f14416a = 40.0f;
                wheelView2.A = (int) f7;
            } else if (i7 >= f8) {
                wheelView2.A = (int) f8;
                this.f14416a = -40.0f;
            }
        }
        float f9 = this.f14416a;
        if (f9 < 0.0f) {
            this.f14416a = f9 + 20.0f;
        } else {
            this.f14416a = f9 - 20.0f;
        }
        this.f14418c.f14392c.sendEmptyMessage(1000);
    }

    a(WheelView wheelView, float f6) {
        this.f14418c = wheelView;
        this.f14417b = f6;
    }
}
