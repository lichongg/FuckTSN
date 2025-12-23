package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class bi {
    private static volatile bi bas;
    private final Map<String, a> bat = new ConcurrentHashMap();
    private final Map<String, CopyOnWriteArraySet<SensorEventListener>> bau = new ConcurrentHashMap();
    private boolean bav = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements SensorEventListener {
        private final WeakReference<bi> aek;
        private final String key;

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            bi biVar = this.aek.get();
            if (biVar != null) {
                biVar.a(this.key, sensorEvent);
            }
        }

        public a(String str, bi biVar) {
            this.key = str;
            this.aek = new WeakReference<>(biVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void onFailed();
    }

    static /* synthetic */ Sensor a(bi biVar, int i6) {
        return eV(i6);
    }

    private static int eW(int i6) {
        if (i6 == -3) {
            return 2;
        }
        if (i6 != -2) {
            return i6 != -1 ? 3 : 0;
        }
        return 1;
    }

    private static String C(int i6, int i7) {
        return i6 + "_" + i7;
    }

    @NonNull
    public static bi Rx() {
        if (bas == null) {
            synchronized (bi.class) {
                try {
                    if (bas == null) {
                        bas = new bi();
                    }
                } finally {
                }
            }
        }
        return bas;
    }

    private void hm(String str) {
        a aVar = this.bat.get(str);
        if (aVar != null) {
            this.bat.remove(str);
            try {
                bk.RC().unregisterListener(aVar);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    private a hn(String str) {
        a aVar = this.bat.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, this);
        this.bat.put(str, aVar2);
        return aVar2;
    }

    private bi() {
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bi.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToBackground");
                SensorManager checkAndObtainSensorManager = bk.RC().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bi.this.bat.keySet()) {
                    try {
                        checkAndObtainSensorManager.unregisterListener((a) bi.this.bat.get(str));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "unregister successfully: " + str);
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToForeground ");
                SensorManager checkAndObtainSensorManager = bk.RC().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bi.this.bat.keySet()) {
                    a aVar = (a) bi.this.bat.get(str);
                    if (aVar != null) {
                        checkAndObtainSensorManager.registerListener(aVar, bi.a(bi.this, Integer.parseInt(str.split("_")[0])), bi.b(bi.this, Integer.parseInt(str.split("_")[1])));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "register successfully: " + str);
                    }
                }
            }
        });
    }

    static /* synthetic */ int b(bi biVar, int i6) {
        return eW(i6);
    }

    @Nullable
    private static Sensor eV(int i6) {
        bk RC = bk.RC();
        Context context = ServiceProvider.getContext();
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        return null;
                    }
                    return RC.getDefaultSensor(context, 9);
                }
                return RC.getDefaultSensor(context, 1);
            }
            return RC.getDefaultSensor(context, 4);
        }
        return RC.getDefaultSensor(context, 10);
    }

    public final synchronized void a(int i6, int i7, SensorEventListener sensorEventListener, b bVar) {
        Sensor eV = eV(i6);
        if (eV == null) {
            if (bVar != null) {
                bVar.onFailed();
            }
            return;
        }
        String C = C(i6, i7);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.bau.get(C);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.bau.put(C, copyOnWriteArraySet);
            a(C, i7, eV);
        }
    }

    public final synchronized void a(SensorEventListener sensorEventListener) {
        try {
            for (Map.Entry<String, CopyOnWriteArraySet<SensorEventListener>> entry : this.bau.entrySet()) {
                CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
                Iterator<SensorEventListener> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SensorEventListener next = it.next();
                    if (next.equals(sensorEventListener)) {
                        value.remove(next);
                        break;
                    }
                }
                if (value.size() == 0) {
                    hm(entry.getKey());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(String str, int i6, Sensor sensor) {
        boolean useSensorManagerDisable = bc.useSensorManagerDisable();
        this.bav = useSensorManagerDisable;
        if (useSensorManagerDisable) {
            return;
        }
        bk.RC().registerListener(ServiceProvider.getContext(), hn(str), sensor, eW(i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.bau.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }
}
