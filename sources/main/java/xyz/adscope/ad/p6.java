package xyz.adscope.ad;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import xyz.adscope.ad.n3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class p6 extends g1 {

    /* renamed from: i, reason: collision with root package name */
    protected SensorManager f55801i;

    /* renamed from: j, reason: collision with root package name */
    private final b f55802j;

    /* renamed from: k, reason: collision with root package name */
    private final e4 f55803k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements SensorEventListener {

        /* renamed from: a, reason: collision with root package name */
        private long f55804a;

        /* renamed from: b, reason: collision with root package name */
        private c f55805b;

        private b() {
            this.f55804a = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f55805b = p6.this.g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f55805b = null;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr;
            if (this.f55805b == null || (fArr = sensorEvent.values) == null || fArr.length <= 2) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f55804a > 200) {
                this.f55804a = currentTimeMillis;
                this.f55805b.a(sensorEvent);
            }
        }

        /* synthetic */ b(p6 p6Var, a aVar) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a(SensorEvent sensorEvent);
    }

    protected abstract n3.a e();

    protected abstract Sensor f();

    protected abstract c g();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.ad.g1, xyz.adscope.ad.i3
    public void a(View view, xyz.adscope.ad.c cVar) {
        super.a(view, cVar);
        Context context = view.getContext();
        if (context != null) {
            this.f55801i = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(bi.ac);
        }
    }

    public void i() {
        if (this.f55801i == null || f() == null || !this.f55166f) {
            return;
        }
        this.f55802j.a();
        this.f55801i.registerListener(this.f55802j, f(), 2);
    }

    public void j() {
        if (this.f55801i != null) {
            this.f55802j.b();
            this.f55801i.unregisterListener(this.f55802j);
        }
    }

    public p6(Context context, String str) {
        super(context, str);
        this.f55802j = new b(this, null);
        this.f55803k = null;
    }

    @Override // xyz.adscope.ad.g1, xyz.adscope.ad.i3
    public void b() {
        super.b();
        j();
    }

    protected void h() {
        a(e());
    }

    @Override // xyz.adscope.ad.g1, xyz.adscope.ad.i3
    public void a() {
        super.a();
        i();
    }
}
