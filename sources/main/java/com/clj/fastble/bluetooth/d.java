package com.clj.fastble.bluetooth;

import android.bluetooth.BluetoothDevice;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.utils.BleLruHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final BleLruHashMap<String, b> f32054a = new BleLruHashMap<>(com.clj.fastble.a.v().w());

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, b> f32055b = new HashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Comparator<b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.K().compareToIgnoreCase(bVar2.K());
        }
    }

    public synchronized void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (!this.f32054a.containsKey(bVar.K())) {
            this.f32054a.put(bVar.K(), bVar);
        }
    }

    public synchronized b b(BleDevice bleDevice) {
        b bVar;
        bVar = new b(bleDevice);
        if (!this.f32055b.containsKey(bVar.K())) {
            this.f32055b.put(bVar.K(), bVar);
        }
        return bVar;
    }

    public synchronized void c() {
        try {
            Iterator<Map.Entry<String, b>> it = this.f32054a.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().F();
            }
            this.f32054a.clear();
            Iterator<Map.Entry<String, b>> it2 = this.f32055b.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().F();
            }
            this.f32055b.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void d(BleDevice bleDevice) {
        if (j(bleDevice)) {
            f(bleDevice).G();
        }
    }

    public synchronized void e() {
        try {
            Iterator<Map.Entry<String, b>> it = this.f32054a.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().G();
            }
            this.f32054a.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized b f(BleDevice bleDevice) {
        if (bleDevice != null) {
            if (this.f32054a.containsKey(bleDevice.b())) {
                return this.f32054a.get(bleDevice.b());
            }
        }
        return null;
    }

    public synchronized List<b> g() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f32054a.values());
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    public synchronized List<BleDevice> h() {
        ArrayList arrayList;
        k();
        arrayList = new ArrayList();
        for (b bVar : g()) {
            if (bVar != null) {
                arrayList.add(bVar.J());
            }
        }
        return arrayList;
    }

    public synchronized boolean i(BluetoothDevice bluetoothDevice) {
        boolean z5;
        if (bluetoothDevice != null) {
            BleLruHashMap<String, b> bleLruHashMap = this.f32054a;
            StringBuilder sb = new StringBuilder();
            sb.append(bluetoothDevice.getName());
            sb.append(bluetoothDevice.getAddress());
            z5 = bleLruHashMap.containsKey(sb.toString());
        }
        return z5;
    }

    public synchronized boolean j(BleDevice bleDevice) {
        boolean z5;
        if (bleDevice != null) {
            z5 = this.f32054a.containsKey(bleDevice.b());
        }
        return z5;
    }

    public synchronized void l(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.f32054a.containsKey(bVar.K())) {
            this.f32054a.remove(bVar.K());
        }
    }

    public synchronized void m(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.f32055b.containsKey(bVar.K())) {
            this.f32055b.remove(bVar.K());
        }
    }

    public void k() {
        List<b> g6 = g();
        for (int i6 = 0; g6 != null && i6 < g6.size(); i6++) {
            b bVar = g6.get(i6);
            if (!com.clj.fastble.a.v().J(bVar.J())) {
                l(bVar);
            }
        }
    }
}
