package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bj implements SensorEventListener {
    private boolean baA;
    private boolean baB;
    private final bi.b baC;
    private final b bax;
    private final b bay;
    private final b baz;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final bj baE = new bj(0);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b {
        private SensorEvent baF;
        private long timestamp;

        private b() {
        }

        /* synthetic */ b(byte b6) {
            this();
        }

        public final void U(List<com.kwad.sdk.l.a.e> list) {
            if (this.baF == null) {
                return;
            }
            com.kwad.sdk.l.a.e eVar = new com.kwad.sdk.l.a.e();
            eVar.sensorType = this.baF.sensor.getType();
            eVar.timestamp = this.timestamp / 1000;
            for (float f6 : this.baF.values) {
                eVar.aWP.add(Float.valueOf(f6));
            }
            list.add(eVar);
        }

        public final void b(SensorEvent sensorEvent) {
            this.baF = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }
    }

    /* synthetic */ bj(byte b6) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void RA() {
        if (this.baB) {
            bi.Rx().a(this);
            this.baB = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void register() {
        if (!this.baA && !this.baB) {
            this.baB = true;
            try {
                bi.Rx().a(3, 3, this, this.baC);
                bi.Rx().a(2, 3, this, this.baC);
                bi.Rx().a(4, 3, this, this.baC);
            } catch (Throwable unused) {
                this.baA = true;
            }
        }
    }

    public final synchronized List<com.kwad.sdk.l.a.e> Rz() {
        try {
            if (!s.PV()) {
                return null;
            }
            com.kwad.sdk.core.c.b.Ho();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                register();
            }
            ArrayList arrayList = new ArrayList();
            this.bax.U(arrayList);
            this.bay.U(arrayList);
            this.baz.U(arrayList);
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
    }

    private bj() {
        byte b6 = 0;
        this.bax = new b(b6);
        this.bay = new b(b6);
        this.baz = new b(b6);
        this.baA = false;
        this.baC = new bi.b() { // from class: com.kwad.sdk.utils.bj.2
            @Override // com.kwad.sdk.utils.bi.b
            public final void onFailed() {
                bj.a(bj.this, true);
            }
        };
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bj.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                bj.this.RA();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                if (s.PV()) {
                    bj.this.register();
                }
            }
        });
    }

    static /* synthetic */ boolean a(bj bjVar, boolean z5) {
        bjVar.baA = true;
        return true;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.bax.b(sensorEvent);
        } else if (type == 4) {
            this.bay.b(sensorEvent);
        } else {
            if (type != 9) {
                return;
            }
            this.baz.b(sensorEvent);
        }
    }

    public static bj Ry() {
        return a.baE;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i6) {
    }
}
