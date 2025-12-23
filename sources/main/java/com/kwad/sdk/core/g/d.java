package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.bi;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    private static float aJi = 9.81f;
    private static double aJj = 0.01d;
    private volatile boolean aIY = true;
    private final bi.b aJf = new bi.b() { // from class: com.kwad.sdk.core.g.d.1
        @Override // com.kwad.sdk.utils.bi.b
        public final void onFailed() {
            if (d.this.aJk != null) {
                d.this.aJk.cd();
            }
        }
    };
    private float aJh;

    @Nullable
    private b aJk;

    @Nullable
    private a aJl;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements SensorEventListener {
        private Random aFu;
        private boolean aJo;
        private final float[] aJn = {0.0f, 0.0f, 9.8f};
        private final float[] aJp = {0.0f, 0.0f, 0.0f};

        private static boolean b(float[] fArr) {
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[2];
            return Math.abs(Math.abs(Math.sqrt((double) (((f6 * f6) + (f7 * f7)) + (f8 * f8)))) - ((double) d.aJi)) <= d.aJj;
        }

        public a() {
            this.aJo = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)) != null) {
                this.aJo = false;
            }
        }

        private void Jh() {
            if (this.aFu == null) {
                this.aFu = new Random();
            }
            if (this.aFu.nextInt(100) == 1) {
                a(this.aJn);
            }
        }

        private void c(float[] fArr) {
            float[] fArr2 = this.aJp;
            float f6 = fArr2[0];
            float f7 = (f6 == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) ? 1.0f : 0.6f;
            float f8 = 1.0f - f7;
            fArr[0] = (fArr[0] * f7) + (f6 * f8);
            fArr[1] = (fArr[1] * f7) + (fArr2[1] * f8);
            fArr[2] = (f7 * fArr[2]) + (f8 * fArr2[2]);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.aJo) {
                Jh();
            }
        }

        private void a(float[] fArr) {
            c(fArr);
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[2];
            double abs = Math.abs(Math.sqrt((f6 * f6) + (f7 * f7) + (f8 * f8)));
            if (b(fArr)) {
                abs = Math.abs(abs - d.aJi);
            }
            if (d.this.aIY && abs >= d.this.aJh && d.this.aJk != null) {
                d.a(d.this, false);
                d.this.aJk.a(abs);
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i6) {
        }
    }

    public final synchronized void Jb() {
        this.aIY = true;
    }

    public final synchronized void bH(Context context) {
        if (context != null) {
            if (this.aJl != null) {
                bi.Rx().a(this.aJl);
                this.aJl = null;
            }
        }
    }

    static /* synthetic */ boolean a(d dVar, boolean z5) {
        dVar.aIY = false;
        return false;
    }

    public final void bG(Context context) {
        if (context == null) {
            com.kwad.sdk.core.d.c.d("ShakeDetector", "startDetect context is null");
            return;
        }
        this.aIY = true;
        if (this.aJl == null) {
            this.aJl = new a();
        }
        bi.Rx().a(1, 2, this.aJl, this.aJf);
    }

    public final void g(float f6) {
        this.aJh = f6;
    }

    public d(float f6) {
        if (f6 <= 0.0f) {
            this.aJh = 5.0f;
        } else {
            this.aJh = f6;
        }
    }

    public final void a(@Nullable b bVar) {
        this.aJk = bVar;
    }
}
