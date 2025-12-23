package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class q extends s {
    @Override // pl.droidsonroids.gif.s
    public void a() {
        e eVar = this.f51861a;
        long B = eVar.f51809g.B(eVar.f51808f);
        if (B >= 0) {
            this.f51861a.f51805c = SystemClock.uptimeMillis() + B;
            if (this.f51861a.isVisible() && this.f51861a.f51804b) {
                e eVar2 = this.f51861a;
                if (!eVar2.f51814l) {
                    eVar2.f51803a.remove(this);
                    e eVar3 = this.f51861a;
                    eVar3.f51818p = eVar3.f51803a.schedule(this, B, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f51861a.f51810h.isEmpty() && this.f51861a.h() == this.f51861a.f51809g.n() - 1) {
                e eVar4 = this.f51861a;
                eVar4.f51815m.sendEmptyMessageAtTime(eVar4.i(), this.f51861a.f51805c);
            }
        } else {
            e eVar5 = this.f51861a;
            eVar5.f51805c = Long.MIN_VALUE;
            eVar5.f51804b = false;
        }
        if (!this.f51861a.isVisible() || this.f51861a.f51815m.hasMessages(-1)) {
            return;
        }
        this.f51861a.f51815m.sendEmptyMessageAtTime(-1, 0L);
    }

    q(e eVar) {
        super(eVar);
    }
}
