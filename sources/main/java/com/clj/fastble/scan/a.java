package com.clj.fastble.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.clj.fastble.data.BleDevice;
import e1.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class a implements BluetoothAdapter.LeScanCallback {

    /* renamed from: a, reason: collision with root package name */
    private String[] f32104a;

    /* renamed from: b, reason: collision with root package name */
    private String f32105b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f32106c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32107d;

    /* renamed from: e, reason: collision with root package name */
    private long f32108e;

    /* renamed from: f, reason: collision with root package name */
    private j f32109f;

    /* renamed from: g, reason: collision with root package name */
    private List<BleDevice> f32110g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private Handler f32111h = new Handler(Looper.getMainLooper());

    /* renamed from: i, reason: collision with root package name */
    private HandlerThread f32112i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f32113j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f32114k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.clj.fastble.scan.a$a, reason: collision with other inner class name */
    class RunnableC0512a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BleDevice f32115a;

        RunnableC0512a(BleDevice bleDevice) {
            this.f32115a = bleDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.j(this.f32115a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.clj.fastble.scan.c.b().g();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BleDevice f32118a;

        c(BleDevice bleDevice) {
            this.f32118a = bleDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.m(this.f32118a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.clj.fastble.scan.c.b().g();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f32121a;

        e(boolean z5) {
            this.f32121a = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.l(this.f32121a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.k(aVar.f32110g);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f32124a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BleDevice bleDevice;
            a aVar = this.f32124a.get();
            if (aVar == null || message.what != 0 || (bleDevice = (BleDevice) message.obj) == null) {
                return;
            }
            aVar.f(bleDevice);
        }

        g(Looper looper, a aVar) {
            super(looper);
            this.f32124a = new WeakReference<>(aVar);
        }
    }

    public final void i() {
        this.f32114k = false;
        this.f32112i.quit();
        o();
        this.f32111h.post(new f());
    }

    public abstract void j(BleDevice bleDevice);

    public abstract void k(List<BleDevice> list);

    public abstract void l(boolean z5);

    public abstract void m(BleDevice bleDevice);

    private void c(BleDevice bleDevice) {
        int i6;
        String[] strArr;
        if (TextUtils.isEmpty(this.f32105b) && ((strArr = this.f32104a) == null || strArr.length < 1)) {
            d(bleDevice);
            return;
        }
        if (TextUtils.isEmpty(this.f32105b) || this.f32105b.equalsIgnoreCase(bleDevice.c())) {
            String[] strArr2 = this.f32104a;
            if (strArr2 != null && strArr2.length > 0) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                String[] strArr3 = this.f32104a;
                int length = strArr3.length;
                while (i6 < length) {
                    String str = strArr3[i6];
                    String d6 = bleDevice.d();
                    if (d6 == null) {
                        d6 = "";
                    }
                    if (this.f32106c) {
                        i6 = d6.contains(str) ? 0 : i6 + 1;
                        atomicBoolean.set(true);
                    } else {
                        if (!d6.equals(str)) {
                        }
                        atomicBoolean.set(true);
                    }
                }
                if (!atomicBoolean.get()) {
                    return;
                }
            }
            d(bleDevice);
        }
    }

    private void d(BleDevice bleDevice) {
        if (this.f32107d) {
            com.clj.fastble.utils.a.c("devices detected  ------  name:" + bleDevice.d() + "  mac:" + bleDevice.c() + "  Rssi:" + bleDevice.e() + "  scanRecord:" + com.clj.fastble.utils.b.j(bleDevice.f()));
            this.f32110g.add(bleDevice);
            this.f32111h.post(new b());
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Iterator<BleDevice> it = this.f32110g.iterator();
        while (it.hasNext()) {
            if (it.next().a().equals(bleDevice.a())) {
                atomicBoolean.set(true);
            }
        }
        if (atomicBoolean.get()) {
            return;
        }
        com.clj.fastble.utils.a.c("device detected  ------  name: " + bleDevice.d() + "  mac: " + bleDevice.c() + "  Rssi: " + bleDevice.e() + "  scanRecord: " + com.clj.fastble.utils.b.k(bleDevice.f(), true));
        this.f32110g.add(bleDevice);
        this.f32111h.post(new c(bleDevice));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(BleDevice bleDevice) {
        this.f32111h.post(new RunnableC0512a(bleDevice));
        c(bleDevice);
    }

    public j e() {
        return this.f32109f;
    }

    public boolean g() {
        return this.f32107d;
    }

    public final void h(boolean z5) {
        this.f32110g.clear();
        o();
        if (z5 && this.f32108e > 0) {
            this.f32111h.postDelayed(new d(), this.f32108e);
        }
        this.f32111h.post(new e(z5));
    }

    public void n(String[] strArr, String str, boolean z5, boolean z6, long j6, j jVar) {
        this.f32104a = strArr;
        this.f32105b = str;
        this.f32106c = z5;
        this.f32107d = z6;
        this.f32108e = j6;
        this.f32109f = jVar;
        HandlerThread handlerThread = new HandlerThread(a.class.getSimpleName());
        this.f32112i = handlerThread;
        handlerThread.start();
        this.f32113j = new g(this.f32112i.getLooper(), this);
        this.f32114k = true;
    }

    public final void o() {
        this.f32111h.removeCallbacksAndMessages(null);
        this.f32113j.removeCallbacksAndMessages(null);
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(BluetoothDevice bluetoothDevice, int i6, byte[] bArr) {
        if (bluetoothDevice != null && this.f32114k) {
            Message obtainMessage = this.f32113j.obtainMessage();
            obtainMessage.what = 0;
            obtainMessage.obj = new BleDevice(bluetoothDevice, i6, bArr, System.currentTimeMillis());
            this.f32113j.sendMessage(obtainMessage);
        }
    }
}
