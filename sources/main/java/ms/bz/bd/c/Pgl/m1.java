package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.stub.StubApp;
import io.netty.handler.codec.http.HttpConstants;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class m1 implements SensorEventListener {

    /* renamed from: f, reason: collision with root package name */
    private static volatile m1 f50303f;

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f50304a;

    /* renamed from: b, reason: collision with root package name */
    private int f50305b;

    /* renamed from: c, reason: collision with root package name */
    private int f50306c = 0;

    /* renamed from: d, reason: collision with root package name */
    private float[] f50307d = new float[3];

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f50308e = new ArrayList();

    private synchronized void d() {
        try {
            SensorManager sensorManager = this.f50304a;
            if (sensorManager != null) {
                if (this.f50305b == 0) {
                    if (!this.f50304a.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f50305b++;
            }
        } catch (Exception unused) {
        }
    }

    private synchronized void e() {
        try {
            SensorManager sensorManager = this.f50304a;
            if (sensorManager != null) {
                int i6 = this.f50305b - 1;
                this.f50305b = i6;
                if (i6 == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2ba200", new byte[]{48, 115, 17, 121, 26});
        }
    }

    public final synchronized String a() {
        StringBuilder sb = new StringBuilder();
        int size = this.f50308e.size();
        if (size <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = this.f50308e;
            int i6 = size - 50;
            if (i6 <= 0) {
                i6 = 0;
            }
            List<JSONArray> subList = arrayList.subList(i6, size);
            if (subList.size() > 0) {
                for (JSONArray jSONArray : subList) {
                    if (jSONArray != null) {
                        sb.append(jSONArray.get(0).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28f2c7", new byte[]{111}));
                        sb.append(jSONArray.get(1).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f414bd", new byte[]{HttpConstants.SEMICOLON}));
                        sb.append(jSONArray.get(2).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "98efac", new byte[]{52}));
                    }
                }
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public final synchronized void f() {
        JSONArray c6 = c();
        if (c6 == null) {
            return;
        }
        this.f50308e.add(c6);
        try {
            int size = this.f50308e.size();
            if (size > 100) {
                ArrayList arrayList = new ArrayList(this.f50308e.subList(size - 50, size));
                this.f50308e.clear();
                this.f50308e = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    static {
        new DecimalFormat((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28ecfe", new byte[]{115, 116, 70}));
        f50303f = null;
    }

    public static m1 b(Context context) {
        if (f50303f == null) {
            synchronized (m1.class) {
                try {
                    if (f50303f == null) {
                        f50303f = new m1(context);
                    }
                } finally {
                }
            }
        }
        return f50303f;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.f50307d = sensorEvent.values;
        this.f50306c = 1;
    }

    private m1(Context context) {
        this.f50304a = null;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext != null) {
            this.f50304a = (SensorManager) origApplicationContext.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "79826e", new byte[]{53, 62, 69, 85, 6, 96}));
        }
    }

    public final JSONArray c() {
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        try {
            if (pble.b() != null) {
                d();
                try {
                    try {
                        synchronized (this) {
                            int i6 = 0;
                            while (this.f50306c == 0 && i6 < 10) {
                                try {
                                    i6++;
                                    wait(1000L);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        jSONArray = new JSONArray();
                        jSONArray.put(new BigDecimal(this.f50307d[0]).setScale(2, 4));
                        jSONArray.put(new BigDecimal(this.f50307d[1]).setScale(2, 4));
                        bigDecimal = new BigDecimal(this.f50307d[2]);
                    } catch (Exception unused) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d1d471", new byte[]{102, 32, 20, Byte.MAX_VALUE, 15});
                        jSONArray = new JSONArray();
                        jSONArray.put(new BigDecimal(this.f50307d[0]).setScale(2, 4));
                        jSONArray.put(new BigDecimal(this.f50307d[1]).setScale(2, 4));
                        bigDecimal = new BigDecimal(this.f50307d[2]);
                    }
                    jSONArray.put(bigDecimal.setScale(2, 4));
                    e();
                    this.f50306c = 0;
                    return jSONArray;
                } catch (Throwable th2) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(new BigDecimal(this.f50307d[0]).setScale(2, 4));
                    jSONArray2.put(new BigDecimal(this.f50307d[1]).setScale(2, 4));
                    jSONArray2.put(new BigDecimal(this.f50307d[2]).setScale(2, 4));
                    e();
                    this.f50306c = 0;
                    throw th2;
                }
            }
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i6) {
    }
}
