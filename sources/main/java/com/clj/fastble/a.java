package com.clj.fastble;

import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Looper;
import com.clj.fastble.bluetooth.d;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.exception.OtherException;
import com.stub.StubApp;
import e1.c;
import e1.e;
import e1.f;
import e1.g;
import e1.h;
import e1.i;
import e1.k;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes4.dex */
public class a {

    /* renamed from: l, reason: collision with root package name */
    public static final int f31998l = 10000;

    /* renamed from: m, reason: collision with root package name */
    private static final int f31999m = 7;

    /* renamed from: n, reason: collision with root package name */
    private static final int f32000n = 5000;

    /* renamed from: o, reason: collision with root package name */
    private static final int f32001o = 0;

    /* renamed from: p, reason: collision with root package name */
    private static final int f32002p = 5000;

    /* renamed from: q, reason: collision with root package name */
    private static final int f32003q = 23;

    /* renamed from: r, reason: collision with root package name */
    private static final int f32004r = 512;

    /* renamed from: s, reason: collision with root package name */
    private static final int f32005s = 20;

    /* renamed from: t, reason: collision with root package name */
    private static final int f32006t = 10000;

    /* renamed from: a, reason: collision with root package name */
    private Application f32007a;

    /* renamed from: b, reason: collision with root package name */
    private com.clj.fastble.scan.b f32008b;

    /* renamed from: c, reason: collision with root package name */
    private BluetoothAdapter f32009c;

    /* renamed from: d, reason: collision with root package name */
    private d f32010d;

    /* renamed from: e, reason: collision with root package name */
    private BluetoothManager f32011e;

    /* renamed from: f, reason: collision with root package name */
    private int f32012f = 7;

    /* renamed from: g, reason: collision with root package name */
    private int f32013g = 5000;

    /* renamed from: h, reason: collision with root package name */
    private int f32014h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f32015i = 5000;

    /* renamed from: j, reason: collision with root package name */
    private int f32016j = 20;

    /* renamed from: k, reason: collision with root package name */
    private long f32017k = 10000;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.clj.fastble.a$a, reason: collision with other inner class name */
    private static class C0510a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f32018a = new a();

        private C0510a() {
        }
    }

    public void E(BleDevice bleDevice, String str, String str2, c cVar) {
        F(bleDevice, str, str2, false, cVar);
    }

    public void M(BleDevice bleDevice, String str, String str2, e eVar) {
        N(bleDevice, str, str2, false, eVar);
    }

    public a b0(int i6) {
        if (i6 > 7) {
            i6 = 7;
        }
        this.f32012f = i6;
        return this;
    }

    public boolean h0(BleDevice bleDevice, String str, String str2) {
        return i0(bleDevice, str, str2, false);
    }

    public boolean j0(BleDevice bleDevice, String str, String str2) {
        return k0(bleDevice, str, str2, false);
    }

    public void l0(BleDevice bleDevice, String str, String str2, byte[] bArr, k kVar) {
        m0(bleDevice, str, str2, bArr, true, kVar);
    }

    public void m0(BleDevice bleDevice, String str, String str2, byte[] bArr, boolean z5, k kVar) {
        n0(bleDevice, str, str2, bArr, z5, true, 0L, kVar);
    }

    public long A() {
        return this.f32015i;
    }

    public com.clj.fastble.scan.b B() {
        return this.f32008b;
    }

    public int D() {
        return this.f32016j;
    }

    public void F(BleDevice bleDevice, String str, String str2, boolean z5, c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("BleIndicateCallback can not be Null!");
        }
        com.clj.fastble.bluetooth.b f6 = this.f32010d.f(bleDevice);
        if (f6 == null) {
            cVar.f(new OtherException("This device not connect!"));
        } else {
            f6.L().x(str, str2).c(cVar, str2, z5);
        }
    }

    public void G(Application application) {
        if (this.f32007a != null || application == null) {
            return;
        }
        this.f32007a = application;
        if (L()) {
            this.f32011e = (BluetoothManager) this.f32007a.getSystemService("bluetooth");
        }
        this.f32009c = BluetoothAdapter.getDefaultAdapter();
        this.f32010d = new d();
        this.f32008b = new com.clj.fastble.scan.b();
    }

    public void H(com.clj.fastble.scan.b bVar) {
        this.f32008b = bVar;
    }

    public boolean I() {
        BluetoothAdapter bluetoothAdapter = this.f32009c;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public boolean L() {
        return StubApp.getOrigApplicationContext(this.f32007a.getApplicationContext()).getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public void N(BleDevice bleDevice, String str, String str2, boolean z5, e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("BleNotifyCallback can not be Null!");
        }
        com.clj.fastble.bluetooth.b f6 = this.f32010d.f(bleDevice);
        if (f6 == null) {
            eVar.f(new OtherException("This device not connect!"));
        } else {
            f6.L().x(str, str2).d(eVar, str2, z5);
        }
    }

    public void O(BleDevice bleDevice, String str, String str2, f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("BleReadCallback can not be Null!");
        }
        com.clj.fastble.bluetooth.b f6 = this.f32010d.f(bleDevice);
        if (f6 == null) {
            fVar.e(new OtherException("This device is not connected!"));
        } else {
            f6.L().x(str, str2).o(fVar, str2);
        }
    }

    public void P(BleDevice bleDevice, g gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("BleRssiCallback can not be Null!");
        }
        com.clj.fastble.bluetooth.b f6 = this.f32010d.f(bleDevice);
        if (f6 == null) {
            gVar.e(new OtherException("This device is not connected!"));
        } else {
            f6.L().q(gVar);
        }
    }

    public boolean X(BleDevice bleDevice, int i6) {
        com.clj.fastble.bluetooth.b f6 = this.f32010d.f(bleDevice);
        if (f6 == null) {
            return false;
        }
        return f6.L().r(i6);
    }

    public void Y(i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("BleScanCallback can not be Null!");
        }
        if (!I()) {
            com.clj.fastble.utils.a.b("Bluetooth not enable!");
            iVar.a(false);
            return;
        }
        com.clj.fastble.scan.c.b().d(this.f32008b.j(), this.f32008b.h(), this.f32008b.g(), this.f32008b.l(), this.f32008b.i(), iVar);
    }

    public void Z(h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("BleScanAndConnectCallback can not be Null!");
        }
        if (!I()) {
            com.clj.fastble.utils.a.b("Bluetooth not enable!");
            hVar.a(false);
            return;
        }
        com.clj.fastble.scan.c.b().e(this.f32008b.j(), this.f32008b.h(), this.f32008b.g(), this.f32008b.l(), this.f32008b.i(), hVar);
    }

    public a a0(long j6) {
        if (j6 <= 0) {
            j6 = 100;
        }
        this.f32017k = j6;
        return this;
    }

    public BluetoothGatt c(BleDevice bleDevice, e1.b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("BleGattCallback can not be Null!");
        }
        if (!I()) {
            com.clj.fastble.utils.a.b("Bluetooth not enable!");
            bVar.c(bleDevice, new OtherException("Bluetooth not enable!"));
            return null;
        }
        if (Looper.myLooper() == null || Looper.myLooper() != Looper.getMainLooper()) {
            com.clj.fastble.utils.a.d("Be careful: currentThread is not MainThread!");
        }
        if (bleDevice != null && bleDevice.a() != null) {
            return this.f32010d.b(bleDevice).D(bleDevice, this.f32008b.k(), bVar);
        }
        bVar.c(bleDevice, new OtherException("Not Found Device Exception Occurred!"));
        return null;
    }

    public void c0(BleDevice bleDevice, int i6, e1.d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("BleMtuChangedCallback can not be Null!");
        }
        if (i6 > 512) {
            com.clj.fastble.utils.a.b("requiredMtu should lower than 512 !");
            dVar.f(new OtherException("requiredMtu should lower than 512 !"));
        } else {
            if (i6 < 23) {
                com.clj.fastble.utils.a.b("requiredMtu should higher than 23 !");
                dVar.f(new OtherException("requiredMtu should higher than 23 !"));
                return;
            }
            com.clj.fastble.bluetooth.b f6 = this.f32010d.f(bleDevice);
            if (f6 == null) {
                dVar.f(new OtherException("This device is not connected!"));
            } else {
                f6.L().v(i6, dVar);
            }
        }
    }

    public a d0(int i6) {
        this.f32013g = i6;
        return this;
    }

    public BleDevice e(BluetoothDevice bluetoothDevice) {
        return new BleDevice(bluetoothDevice);
    }

    public a e0(int i6) {
        return f0(i6, 5000L);
    }

    @TargetApi(21)
    public BleDevice f(ScanResult scanResult) {
        if (scanResult == null) {
            throw new IllegalArgumentException("scanResult can not be Null!");
        }
        BluetoothDevice device = scanResult.getDevice();
        int rssi = scanResult.getRssi();
        ScanRecord scanRecord = scanResult.getScanRecord();
        return new BleDevice(device, rssi, scanRecord != null ? scanRecord.getBytes() : null, scanResult.getTimestampNanos());
    }

    public a f0(int i6, long j6) {
        if (i6 > 10) {
            i6 = 10;
        }
        if (j6 < 0) {
            j6 = 0;
        }
        this.f32014h = i6;
        this.f32015i = j6;
        return this;
    }

    public void g() {
        d dVar = this.f32010d;
        if (dVar != null) {
            dVar.c();
        }
    }

    public a g0(int i6) {
        if (i6 > 0) {
            this.f32016j = i6;
        }
        return this;
    }

    public Context getContext() {
        return this.f32007a;
    }

    public void h() {
        BluetoothAdapter bluetoothAdapter = this.f32009c;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            return;
        }
        this.f32009c.disable();
    }

    public void i(BleDevice bleDevice) {
        d dVar = this.f32010d;
        if (dVar != null) {
            dVar.d(bleDevice);
        }
    }

    public boolean i0(BleDevice bleDevice, String str, String str2, boolean z5) {
        com.clj.fastble.bluetooth.b f6 = this.f32010d.f(bleDevice);
        if (f6 == null) {
            return false;
        }
        boolean a6 = f6.L().x(str, str2).a(z5);
        if (a6) {
            f6.O(str2);
        }
        return a6;
    }

    public void j() {
        d dVar = this.f32010d;
        if (dVar != null) {
            dVar.e();
        }
    }

    public void k() {
        BluetoothAdapter bluetoothAdapter = this.f32009c;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.enable();
        }
    }

    public boolean k0(BleDevice bleDevice, String str, String str2, boolean z5) {
        com.clj.fastble.bluetooth.b f6 = this.f32010d.f(bleDevice);
        if (f6 == null) {
            return false;
        }
        boolean b6 = f6.L().x(str, str2).b(z5);
        if (b6) {
            f6.Q(str2);
        }
        return b6;
    }

    public a l(boolean z5) {
        com.clj.fastble.utils.a.f32144a = z5;
        return this;
    }

    public List<BleDevice> m() {
        d dVar = this.f32010d;
        if (dVar == null) {
            return null;
        }
        return dVar.h();
    }

    public com.clj.fastble.bluetooth.b n(BleDevice bleDevice) {
        d dVar = this.f32010d;
        if (dVar != null) {
            return dVar.f(bleDevice);
        }
        return null;
    }

    public void n0(BleDevice bleDevice, String str, String str2, byte[] bArr, boolean z5, boolean z6, long j6, k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("BleWriteCallback can not be Null!");
        }
        if (bArr == null) {
            com.clj.fastble.utils.a.b("data is Null!");
            kVar.e(new OtherException("data is Null!"));
            return;
        }
        if (bArr.length > 20 && !z5) {
            com.clj.fastble.utils.a.d("Be careful: data's length beyond 20! Ensure MTU higher than 23, or use spilt write!");
        }
        com.clj.fastble.bluetooth.b f6 = this.f32010d.f(bleDevice);
        if (f6 == null) {
            kVar.e(new OtherException("This device not connect!"));
        } else if (!z5 || bArr.length <= D()) {
            f6.L().x(str, str2).y(bArr, kVar, str2);
        } else {
            new com.clj.fastble.bluetooth.e().k(f6, str, str2, bArr, z6, j6, kVar);
        }
    }

    public BluetoothAdapter o() {
        return this.f32009c;
    }

    public BluetoothManager s() {
        return this.f32011e;
    }

    public long t() {
        return this.f32017k;
    }

    public int u(BleDevice bleDevice) {
        if (bleDevice != null) {
            return this.f32011e.getConnectionState(bleDevice.a(), 7);
        }
        return 0;
    }

    public int w() {
        return this.f32012f;
    }

    public d x() {
        return this.f32010d;
    }

    public int y() {
        return this.f32013g;
    }

    public int z() {
        return this.f32014h;
    }

    public static a v() {
        return C0510a.f32018a;
    }

    public BleScanState C() {
        return com.clj.fastble.scan.c.b().c();
    }

    public boolean J(BleDevice bleDevice) {
        if (u(bleDevice) == 2) {
            return true;
        }
        return false;
    }

    public boolean K(String str) {
        for (BleDevice bleDevice : m()) {
            if (bleDevice != null && bleDevice.c().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void Q(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.b n6 = n(bleDevice);
        if (n6 != null) {
            n6.N();
        }
    }

    public void R(BleDevice bleDevice, String str) {
        com.clj.fastble.bluetooth.b n6 = n(bleDevice);
        if (n6 != null) {
            n6.O(str);
        }
    }

    public void S(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.b n6 = n(bleDevice);
        if (n6 != null) {
            n6.P();
        }
    }

    public void T(BleDevice bleDevice, String str) {
        com.clj.fastble.bluetooth.b n6 = n(bleDevice);
        if (n6 != null) {
            n6.Q(str);
        }
    }

    public void U(BleDevice bleDevice, String str) {
        com.clj.fastble.bluetooth.b n6 = n(bleDevice);
        if (n6 != null) {
            n6.R(str);
        }
    }

    public void V(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.b n6 = n(bleDevice);
        if (n6 != null) {
            n6.S();
        }
    }

    public void W(BleDevice bleDevice, String str) {
        com.clj.fastble.bluetooth.b n6 = n(bleDevice);
        if (n6 != null) {
            n6.T(str);
        }
    }

    public void a() {
        com.clj.fastble.scan.c.b().g();
    }

    public void b(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.b n6 = n(bleDevice);
        if (n6 != null) {
            n6.B();
        }
    }

    public BluetoothGatt d(String str, e1.b bVar) {
        return c(new BleDevice(o().getRemoteDevice(str), 0, null, 0L), bVar);
    }

    public BluetoothGatt p(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.b n6 = n(bleDevice);
        if (n6 != null) {
            return n6.I();
        }
        return null;
    }

    public List<BluetoothGattCharacteristic> q(BluetoothGattService bluetoothGattService) {
        return bluetoothGattService.getCharacteristics();
    }

    public List<BluetoothGattService> r(BleDevice bleDevice) {
        BluetoothGatt p5 = p(bleDevice);
        if (p5 != null) {
            return p5.getServices();
        }
        return null;
    }
}
