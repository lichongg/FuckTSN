package com.clj.fastble.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.exception.ConnectException;
import com.clj.fastble.exception.OtherException;
import com.clj.fastble.exception.TimeoutException;
import e1.f;
import e1.g;
import e1.k;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private e1.b f32025a;

    /* renamed from: b, reason: collision with root package name */
    private g f32026b;

    /* renamed from: c, reason: collision with root package name */
    private e1.d f32027c;

    /* renamed from: h, reason: collision with root package name */
    private EnumC0511b f32032h;

    /* renamed from: j, reason: collision with root package name */
    private BleDevice f32034j;

    /* renamed from: k, reason: collision with root package name */
    private BluetoothGatt f32035k;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, e1.e> f32028d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, e1.c> f32029e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, k> f32030f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, f> f32031g = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private boolean f32033i = false;

    /* renamed from: l, reason: collision with root package name */
    private c f32036l = new c(Looper.getMainLooper());

    /* renamed from: m, reason: collision with root package name */
    private int f32037m = 0;

    /* renamed from: n, reason: collision with root package name */
    private BluetoothGattCallback f32038n = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends BluetoothGattCallback {
        a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            Handler a6;
            Handler a7;
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            Iterator it = b.this.f32028d.entrySet().iterator();
            while (it.hasNext()) {
                Object value = ((Map.Entry) it.next()).getValue();
                if (value instanceof e1.e) {
                    e1.e eVar = (e1.e) value;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(eVar.b()) && (a7 = eVar.a()) != null) {
                        Message obtainMessage = a7.obtainMessage();
                        obtainMessage.what = 19;
                        obtainMessage.obj = eVar;
                        Bundle bundle = new Bundle();
                        bundle.putByteArray(com.clj.fastble.data.b.f32089m, bluetoothGattCharacteristic.getValue());
                        obtainMessage.setData(bundle);
                        a7.sendMessage(obtainMessage);
                    }
                }
            }
            Iterator it2 = b.this.f32029e.entrySet().iterator();
            while (it2.hasNext()) {
                Object value2 = ((Map.Entry) it2.next()).getValue();
                if (value2 instanceof e1.c) {
                    e1.c cVar = (e1.c) value2;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(cVar.b()) && (a6 = cVar.a()) != null) {
                        Message obtainMessage2 = a6.obtainMessage();
                        obtainMessage2.what = 35;
                        obtainMessage2.obj = cVar;
                        Bundle bundle2 = new Bundle();
                        bundle2.putByteArray(com.clj.fastble.data.b.f32094r, bluetoothGattCharacteristic.getValue());
                        obtainMessage2.setData(bundle2);
                        a6.sendMessage(obtainMessage2);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i6) {
            Handler a6;
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i6);
            Iterator it = b.this.f32031g.entrySet().iterator();
            while (it.hasNext()) {
                Object value = ((Map.Entry) it.next()).getValue();
                if (value instanceof f) {
                    f fVar = (f) value;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(fVar.b()) && (a6 = fVar.a()) != null) {
                        Message obtainMessage = a6.obtainMessage();
                        obtainMessage.what = 66;
                        obtainMessage.obj = fVar;
                        Bundle bundle = new Bundle();
                        bundle.putInt(com.clj.fastble.data.b.f32102z, i6);
                        bundle.putByteArray(com.clj.fastble.data.b.A, bluetoothGattCharacteristic.getValue());
                        obtainMessage.setData(bundle);
                        a6.sendMessage(obtainMessage);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i6) {
            Handler a6;
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i6);
            Iterator it = b.this.f32030f.entrySet().iterator();
            while (it.hasNext()) {
                Object value = ((Map.Entry) it.next()).getValue();
                if (value instanceof k) {
                    k kVar = (k) value;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(kVar.b()) && (a6 = kVar.a()) != null) {
                        Message obtainMessage = a6.obtainMessage();
                        obtainMessage.what = 50;
                        obtainMessage.obj = kVar;
                        Bundle bundle = new Bundle();
                        bundle.putInt(com.clj.fastble.data.b.f32098v, i6);
                        bundle.putByteArray(com.clj.fastble.data.b.f32099w, bluetoothGattCharacteristic.getValue());
                        obtainMessage.setData(bundle);
                        a6.sendMessage(obtainMessage);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i6, int i7) {
            super.onConnectionStateChange(bluetoothGatt, i6, i7);
            com.clj.fastble.utils.a.c("BluetoothGattCallback：onConnectionStateChange \nstatus: " + i6 + "\nnewState: " + i7 + "\ncurrentThread: " + Thread.currentThread().getId());
            b.this.f32035k = bluetoothGatt;
            b.this.f32036l.removeMessages(7);
            if (i7 == 2) {
                Message obtainMessage = b.this.f32036l.obtainMessage();
                obtainMessage.what = 4;
                b.this.f32036l.sendMessageDelayed(obtainMessage, 500L);
                return;
            }
            if (i7 == 0) {
                if (b.this.f32032h == EnumC0511b.CONNECT_CONNECTING) {
                    Message obtainMessage2 = b.this.f32036l.obtainMessage();
                    obtainMessage2.what = 1;
                    obtainMessage2.obj = new com.clj.fastble.data.a(i6);
                    b.this.f32036l.sendMessage(obtainMessage2);
                    return;
                }
                if (b.this.f32032h == EnumC0511b.CONNECT_CONNECTED) {
                    Message obtainMessage3 = b.this.f32036l.obtainMessage();
                    obtainMessage3.what = 2;
                    com.clj.fastble.data.a aVar = new com.clj.fastble.data.a(i6);
                    aVar.c(b.this.f32033i);
                    obtainMessage3.obj = aVar;
                    b.this.f32036l.sendMessage(obtainMessage3);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i6) {
            Handler a6;
            Handler a7;
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i6);
            Iterator it = b.this.f32028d.entrySet().iterator();
            while (it.hasNext()) {
                Object value = ((Map.Entry) it.next()).getValue();
                if (value instanceof e1.e) {
                    e1.e eVar = (e1.e) value;
                    if (bluetoothGattDescriptor.getCharacteristic().getUuid().toString().equalsIgnoreCase(eVar.b()) && (a7 = eVar.a()) != null) {
                        Message obtainMessage = a7.obtainMessage();
                        obtainMessage.what = 18;
                        obtainMessage.obj = eVar;
                        Bundle bundle = new Bundle();
                        bundle.putInt(com.clj.fastble.data.b.f32088l, i6);
                        obtainMessage.setData(bundle);
                        a7.sendMessage(obtainMessage);
                    }
                }
            }
            Iterator it2 = b.this.f32029e.entrySet().iterator();
            while (it2.hasNext()) {
                Object value2 = ((Map.Entry) it2.next()).getValue();
                if (value2 instanceof e1.c) {
                    e1.c cVar = (e1.c) value2;
                    if (bluetoothGattDescriptor.getCharacteristic().getUuid().toString().equalsIgnoreCase(cVar.b()) && (a6 = cVar.a()) != null) {
                        Message obtainMessage2 = a6.obtainMessage();
                        obtainMessage2.what = 34;
                        obtainMessage2.obj = cVar;
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt(com.clj.fastble.data.b.f32093q, i6);
                        obtainMessage2.setData(bundle2);
                        a6.sendMessage(obtainMessage2);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i6, int i7) {
            Handler a6;
            super.onMtuChanged(bluetoothGatt, i6, i7);
            if (b.this.f32027c != null && (a6 = b.this.f32027c.a()) != null) {
                Message obtainMessage = a6.obtainMessage();
                obtainMessage.what = 98;
                obtainMessage.obj = b.this.f32027c;
                Bundle bundle = new Bundle();
                bundle.putInt(com.clj.fastble.data.b.H, i7);
                bundle.putInt(com.clj.fastble.data.b.I, i6);
                obtainMessage.setData(bundle);
                a6.sendMessage(obtainMessage);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i6, int i7) {
            Handler a6;
            super.onReadRemoteRssi(bluetoothGatt, i6, i7);
            if (b.this.f32026b != null && (a6 = b.this.f32026b.a()) != null) {
                Message obtainMessage = a6.obtainMessage();
                obtainMessage.what = 82;
                obtainMessage.obj = b.this.f32026b;
                Bundle bundle = new Bundle();
                bundle.putInt(com.clj.fastble.data.b.D, i7);
                bundle.putInt(com.clj.fastble.data.b.E, i6);
                obtainMessage.setData(bundle);
                a6.sendMessage(obtainMessage);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i6) {
            super.onServicesDiscovered(bluetoothGatt, i6);
            com.clj.fastble.utils.a.c("BluetoothGattCallback：onServicesDiscovered \nstatus: " + i6 + "\ncurrentThread: " + Thread.currentThread().getId());
            b.this.f32035k = bluetoothGatt;
            if (i6 == 0) {
                Message obtainMessage = b.this.f32036l.obtainMessage();
                obtainMessage.what = 6;
                obtainMessage.obj = new com.clj.fastble.data.a(i6);
                b.this.f32036l.sendMessage(obtainMessage);
                return;
            }
            Message obtainMessage2 = b.this.f32036l.obtainMessage();
            obtainMessage2.what = 5;
            b.this.f32036l.sendMessage(obtainMessage2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.clj.fastble.bluetooth.b$b, reason: collision with other inner class name */
    enum EnumC0511b {
        CONNECT_IDLE,
        CONNECT_CONNECTING,
        CONNECT_CONNECTED,
        CONNECT_FAILURE,
        CONNECT_DISCONNECT
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.H();
                    b.this.M();
                    b.this.C();
                    if (b.this.f32037m >= com.clj.fastble.a.v().z()) {
                        b.this.f32032h = EnumC0511b.CONNECT_FAILURE;
                        com.clj.fastble.a.v().x().m(b.this);
                        int a6 = ((com.clj.fastble.data.a) message.obj).a();
                        if (b.this.f32025a != null) {
                            b.this.f32025a.c(b.this.f32034j, new ConnectException(b.this.f32035k, a6));
                            break;
                        }
                    } else {
                        com.clj.fastble.utils.a.b("Connect fail, try reconnect " + com.clj.fastble.a.v().A() + " millisecond later");
                        b.k(b.this);
                        Message obtainMessage = b.this.f32036l.obtainMessage();
                        obtainMessage.what = 3;
                        b.this.f32036l.sendMessageDelayed(obtainMessage, com.clj.fastble.a.v().A());
                        break;
                    }
                    break;
                case 2:
                    b.this.f32032h = EnumC0511b.CONNECT_DISCONNECT;
                    com.clj.fastble.a.v().x().l(b.this);
                    b.this.G();
                    b.this.M();
                    b.this.C();
                    b.this.S();
                    b.this.P();
                    b.this.B();
                    b.this.f32036l.removeCallbacksAndMessages(null);
                    com.clj.fastble.data.a aVar = (com.clj.fastble.data.a) message.obj;
                    boolean b6 = aVar.b();
                    int a7 = aVar.a();
                    if (b.this.f32025a != null) {
                        b.this.f32025a.e(b6, b.this.f32034j, b.this.f32035k, a7);
                        break;
                    }
                    break;
                case 3:
                    b bVar = b.this;
                    bVar.E(bVar.f32034j, false, b.this.f32025a, b.this.f32037m);
                    break;
                case 4:
                    if (b.this.f32035k == null) {
                        Message obtainMessage2 = b.this.f32036l.obtainMessage();
                        obtainMessage2.what = 5;
                        b.this.f32036l.sendMessage(obtainMessage2);
                        break;
                    } else if (!b.this.f32035k.discoverServices()) {
                        Message obtainMessage3 = b.this.f32036l.obtainMessage();
                        obtainMessage3.what = 5;
                        b.this.f32036l.sendMessage(obtainMessage3);
                        break;
                    }
                    break;
                case 5:
                    b.this.H();
                    b.this.M();
                    b.this.C();
                    b.this.f32032h = EnumC0511b.CONNECT_FAILURE;
                    com.clj.fastble.a.v().x().m(b.this);
                    if (b.this.f32025a != null) {
                        b.this.f32025a.c(b.this.f32034j, new OtherException("GATT discover services exception occurred!"));
                        break;
                    }
                    break;
                case 6:
                    b.this.f32032h = EnumC0511b.CONNECT_CONNECTED;
                    b.this.f32033i = false;
                    com.clj.fastble.a.v().x().m(b.this);
                    com.clj.fastble.a.v().x().a(b.this);
                    int a8 = ((com.clj.fastble.data.a) message.obj).a();
                    if (b.this.f32025a != null) {
                        b.this.f32025a.d(b.this.f32034j, b.this.f32035k, a8);
                        break;
                    }
                    break;
                case 7:
                    b.this.H();
                    b.this.M();
                    b.this.C();
                    b.this.f32032h = EnumC0511b.CONNECT_FAILURE;
                    com.clj.fastble.a.v().x().m(b.this);
                    if (b.this.f32025a != null) {
                        b.this.f32025a.c(b.this.f32034j, new TimeoutException());
                        break;
                    }
                    break;
                default:
                    super.handleMessage(message);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void C() {
        BluetoothGatt bluetoothGatt = this.f32035k;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void H() {
        BluetoothGatt bluetoothGatt = this.f32035k;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void M() {
        BluetoothGatt bluetoothGatt;
        try {
            Method method = BluetoothGatt.class.getMethod("refresh", null);
            if (method != null && (bluetoothGatt = this.f32035k) != null) {
                com.clj.fastble.utils.a.c("refreshDeviceCache, is success:  " + ((Boolean) method.invoke(bluetoothGatt, null)).booleanValue());
            }
        } catch (Exception e6) {
            com.clj.fastble.utils.a.c("exception occur while refreshing device: " + e6.getMessage());
            e6.printStackTrace();
        }
    }

    public synchronized void A(String str, k kVar) {
        this.f32030f.put(str, kVar);
    }

    public synchronized void B() {
        try {
            HashMap<String, e1.e> hashMap = this.f32028d;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<String, e1.c> hashMap2 = this.f32029e;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            HashMap<String, k> hashMap3 = this.f32030f;
            if (hashMap3 != null) {
                hashMap3.clear();
            }
            HashMap<String, f> hashMap4 = this.f32031g;
            if (hashMap4 != null) {
                hashMap4.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized BluetoothGatt D(BleDevice bleDevice, boolean z5, e1.b bVar) {
        return E(bleDevice, z5, bVar, 0);
    }

    public synchronized BluetoothGatt E(BleDevice bleDevice, boolean z5, e1.b bVar, int i6) {
        BluetoothGatt connectGatt;
        try {
            com.clj.fastble.utils.a.c("connect device: " + bleDevice.d() + "\nmac: " + bleDevice.c() + "\nautoConnect: " + z5 + "\ncurrentThread: " + Thread.currentThread().getId() + "\nconnectCount:" + (i6 + 1));
            if (i6 == 0) {
                this.f32037m = 0;
            }
            u(bVar);
            this.f32032h = EnumC0511b.CONNECT_CONNECTING;
            if (Build.VERSION.SDK_INT >= 23) {
                connectGatt = bleDevice.a().connectGatt(com.clj.fastble.a.v().getContext(), z5, this.f32038n, 2);
                this.f32035k = connectGatt;
            } else {
                this.f32035k = bleDevice.a().connectGatt(com.clj.fastble.a.v().getContext(), z5, this.f32038n);
            }
            if (this.f32035k != null) {
                e1.b bVar2 = this.f32025a;
                if (bVar2 != null) {
                    bVar2.f();
                }
                Message obtainMessage = this.f32036l.obtainMessage();
                obtainMessage.what = 7;
                this.f32036l.sendMessageDelayed(obtainMessage, com.clj.fastble.a.v().t());
            } else {
                H();
                M();
                C();
                this.f32032h = EnumC0511b.CONNECT_FAILURE;
                com.clj.fastble.a.v().x().m(this);
                e1.b bVar3 = this.f32025a;
                if (bVar3 != null) {
                    bVar3.c(bleDevice, new OtherException("GATT connect exception occurred!"));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f32035k;
    }

    public synchronized void F() {
        this.f32032h = EnumC0511b.CONNECT_IDLE;
        H();
        M();
        C();
        N();
        S();
        P();
        B();
        this.f32036l.removeCallbacksAndMessages(null);
    }

    public synchronized void G() {
        this.f32033i = true;
        H();
    }

    public synchronized void N() {
        this.f32025a = null;
    }

    public synchronized void O(String str) {
        if (this.f32029e.containsKey(str)) {
            this.f32029e.remove(str);
        }
    }

    public synchronized void P() {
        this.f32027c = null;
    }

    public synchronized void Q(String str) {
        if (this.f32028d.containsKey(str)) {
            this.f32028d.remove(str);
        }
    }

    public synchronized void R(String str) {
        if (this.f32031g.containsKey(str)) {
            this.f32031g.remove(str);
        }
    }

    public synchronized void S() {
        this.f32026b = null;
    }

    public synchronized void T(String str) {
        if (this.f32030f.containsKey(str)) {
            this.f32030f.remove(str);
        }
    }

    public synchronized void u(e1.b bVar) {
        this.f32025a = bVar;
    }

    public synchronized void v(String str, e1.c cVar) {
        this.f32029e.put(str, cVar);
    }

    public synchronized void w(e1.d dVar) {
        this.f32027c = dVar;
    }

    public synchronized void x(String str, e1.e eVar) {
        this.f32028d.put(str, eVar);
    }

    public synchronized void y(String str, f fVar) {
        this.f32031g.put(str, fVar);
    }

    public synchronized void z(g gVar) {
        this.f32026b = gVar;
    }

    static /* synthetic */ int k(b bVar) {
        int i6 = bVar.f32037m + 1;
        bVar.f32037m = i6;
        return i6;
    }

    public BluetoothGatt I() {
        return this.f32035k;
    }

    public BleDevice J() {
        return this.f32034j;
    }

    public String K() {
        return this.f32034j.b();
    }

    public com.clj.fastble.bluetooth.c L() {
        return new com.clj.fastble.bluetooth.c(this);
    }

    public b(BleDevice bleDevice) {
        this.f32034j = bleDevice;
    }
}
