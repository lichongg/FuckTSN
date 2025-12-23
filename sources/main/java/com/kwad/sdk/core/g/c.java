package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bi;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {

    @Nullable
    private com.kwad.sdk.core.g.a aJd;

    @Nullable
    private a aJe;
    private AdMatrixInfo.RotateInfo rotateInfo;
    private volatile boolean aIY = true;
    private long aIZ = 0;
    private double aJa = 9.999999717180685E-10d;
    private double[] aJb = {0.0d, 0.0d, 0.0d};
    private double[] aJc = {0.0d, 0.0d, 0.0d};
    private final bi.b aJf = new bi.b() { // from class: com.kwad.sdk.core.g.c.1
        @Override // com.kwad.sdk.utils.bi.b
        public final void onFailed() {
            if (c.this.aJd != null) {
                c.this.aJd.ce();
            }
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements SensorEventListener {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b6) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[2];
            if (c.this.aIZ != 0) {
                double d6 = (sensorEvent.timestamp - c.this.aIZ) * c.this.aJa;
                double[] dArr = c.this.aJc;
                dArr[0] = dArr[0] + Math.toDegrees(f6 * d6);
                double[] dArr2 = c.this.aJc;
                dArr2[1] = dArr2[1] + Math.toDegrees(f7 * d6);
                double[] dArr3 = c.this.aJc;
                dArr3[2] = dArr3[2] + Math.toDegrees(f8 * d6);
                c.this.Jc();
                c.this.Jd();
            }
            c.this.aIZ = sensorEvent.timestamp;
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i6) {
        }
    }

    public final synchronized void Jb() {
        Ja();
        this.aIY = true;
    }

    public final synchronized void bH(Context context) {
        if (context != null) {
            if (this.aJe != null) {
                bi.Rx().a(this.aJe);
                this.aJe = null;
            }
        }
    }

    private void Ja() {
        Arrays.fill(this.aJb, 0.0d);
        Arrays.fill(this.aJc, 0.0d);
        this.aIZ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jc() {
        if (this.aIY) {
            if (Math.abs(this.aJc[0]) > Math.abs(this.aJb[0])) {
                this.aJb[0] = this.aJc[0];
            }
            if (Math.abs(this.aJc[1]) > Math.abs(this.aJb[1])) {
                this.aJb[1] = this.aJc[1];
            }
            if (Math.abs(this.aJc[2]) > Math.abs(this.aJb[2])) {
                this.aJb[2] = this.aJc[2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jd() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.aIY || (rotateInfo = this.rotateInfo) == null || this.aJd == null) {
            return;
        }
        if (!a(0, r0.rotateDegree, rotateInfo.f36347x.direction)) {
            if (!a(1, r0.rotateDegree, this.rotateInfo.f36348y.direction)) {
                if (!a(2, r0.rotateDegree, this.rotateInfo.f36349z.direction)) {
                    return;
                }
            }
        }
        this.aIY = false;
        this.aJd.r(Je());
    }

    private String Je() {
        return "{\"x\": " + this.aJb[0] + ",\"y\":" + this.aJb[1] + ",\"z\":" + this.aJb[2] + "}";
    }

    public final void b(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void bG(Context context) {
        if (context == null) {
            return;
        }
        Ja();
        this.aIY = true;
        if (this.aJe == null) {
            this.aJe = new a(this, (byte) 0);
        }
        bi.Rx().a(2, 2, this.aJe, this.aJf);
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(@Nullable com.kwad.sdk.core.g.a aVar) {
        this.aJd = aVar;
    }

    private boolean a(int i6, double d6, int i7) {
        if (d6 <= 0.0d || Math.abs(this.aJc[i6]) < d6) {
            return false;
        }
        double d7 = this.aJc[i6];
        return (d7 <= 0.0d || i7 != 1) && (d7 >= 0.0d || i7 != 2);
    }
}
