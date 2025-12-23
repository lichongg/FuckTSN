package com.clj.fastble.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.clj.fastble.exception.GattException;
import com.clj.fastble.exception.OtherException;
import com.clj.fastble.exception.TimeoutException;
import e1.f;
import e1.g;
import e1.k;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes4.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    private static final String f32047f = "00002902-0000-1000-8000-00805f9b34fb";

    /* renamed from: a, reason: collision with root package name */
    private BluetoothGatt f32048a;

    /* renamed from: b, reason: collision with root package name */
    private BluetoothGattService f32049b;

    /* renamed from: c, reason: collision with root package name */
    private BluetoothGattCharacteristic f32050c;

    /* renamed from: d, reason: collision with root package name */
    private b f32051d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f32052e = new a(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i6 = message.what;
            if (i6 != 49) {
                if (i6 != 50) {
                    if (i6 != 65) {
                        if (i6 != 66) {
                            if (i6 != 81) {
                                if (i6 != 82) {
                                    if (i6 != 97) {
                                        if (i6 != 98) {
                                            switch (i6) {
                                                case 17:
                                                    e1.e eVar = (e1.e) message.obj;
                                                    if (eVar != null) {
                                                        eVar.f(new TimeoutException());
                                                        break;
                                                    }
                                                    break;
                                                case 18:
                                                    c.this.n();
                                                    e1.e eVar2 = (e1.e) message.obj;
                                                    int i7 = message.getData().getInt(com.clj.fastble.data.b.f32088l);
                                                    if (eVar2 != null) {
                                                        if (i7 == 0) {
                                                            eVar2.g();
                                                            break;
                                                        } else {
                                                            eVar2.f(new GattException(i7));
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case 19:
                                                    e1.e eVar3 = (e1.e) message.obj;
                                                    byte[] byteArray = message.getData().getByteArray(com.clj.fastble.data.b.f32089m);
                                                    if (eVar3 != null) {
                                                        eVar3.e(byteArray);
                                                        break;
                                                    }
                                                    break;
                                                default:
                                                    switch (i6) {
                                                        case 33:
                                                            e1.c cVar = (e1.c) message.obj;
                                                            if (cVar != null) {
                                                                cVar.f(new TimeoutException());
                                                                break;
                                                            }
                                                            break;
                                                        case 34:
                                                            c.this.l();
                                                            e1.c cVar2 = (e1.c) message.obj;
                                                            int i8 = message.getData().getInt(com.clj.fastble.data.b.f32093q);
                                                            if (cVar2 != null) {
                                                                if (i8 == 0) {
                                                                    cVar2.g();
                                                                    break;
                                                                } else {
                                                                    cVar2.f(new GattException(i8));
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        case 35:
                                                            e1.c cVar3 = (e1.c) message.obj;
                                                            byte[] byteArray2 = message.getData().getByteArray(com.clj.fastble.data.b.f32094r);
                                                            if (cVar3 != null) {
                                                                cVar3.e(byteArray2);
                                                                break;
                                                            }
                                                            break;
                                                    }
                                            }
                                            return;
                                        }
                                        c.this.m();
                                        e1.d dVar = (e1.d) message.obj;
                                        Bundle data = message.getData();
                                        int i9 = data.getInt(com.clj.fastble.data.b.H);
                                        int i10 = data.getInt(com.clj.fastble.data.b.I);
                                        if (dVar != null) {
                                            if (i9 == 0) {
                                                dVar.e(i10);
                                                return;
                                            } else {
                                                dVar.f(new GattException(i9));
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    e1.d dVar2 = (e1.d) message.obj;
                                    if (dVar2 != null) {
                                        dVar2.f(new TimeoutException());
                                        return;
                                    }
                                    return;
                                }
                                c.this.s();
                                g gVar = (g) message.obj;
                                Bundle data2 = message.getData();
                                int i11 = data2.getInt(com.clj.fastble.data.b.D);
                                int i12 = data2.getInt(com.clj.fastble.data.b.E);
                                if (gVar != null) {
                                    if (i11 == 0) {
                                        gVar.f(i12);
                                        return;
                                    } else {
                                        gVar.e(new GattException(i11));
                                        return;
                                    }
                                }
                                return;
                            }
                            g gVar2 = (g) message.obj;
                            if (gVar2 != null) {
                                gVar2.e(new TimeoutException());
                                return;
                            }
                            return;
                        }
                        c.this.p();
                        f fVar = (f) message.obj;
                        Bundle data3 = message.getData();
                        int i13 = data3.getInt(com.clj.fastble.data.b.f32102z);
                        byte[] byteArray3 = data3.getByteArray(com.clj.fastble.data.b.A);
                        if (fVar != null) {
                            if (i13 == 0) {
                                fVar.f(byteArray3);
                                return;
                            } else {
                                fVar.e(new GattException(i13));
                                return;
                            }
                        }
                        return;
                    }
                    f fVar2 = (f) message.obj;
                    if (fVar2 != null) {
                        fVar2.e(new TimeoutException());
                        return;
                    }
                    return;
                }
                c.this.z();
                k kVar = (k) message.obj;
                Bundle data4 = message.getData();
                int i14 = data4.getInt(com.clj.fastble.data.b.f32098v);
                byte[] byteArray4 = data4.getByteArray(com.clj.fastble.data.b.f32099w);
                if (kVar != null) {
                    if (i14 == 0) {
                        kVar.f(1, 1, byteArray4);
                        return;
                    } else {
                        kVar.e(new GattException(i14));
                        return;
                    }
                }
                return;
            }
            k kVar2 = (k) message.obj;
            if (kVar2 != null) {
                kVar2.e(new TimeoutException());
            }
        }
    }

    private boolean t(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z5, boolean z6, e1.c cVar) {
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null) {
            l();
            if (cVar != null) {
                cVar.f(new OtherException("gatt or characteristic equal null"));
            }
            return false;
        }
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z6)) {
            l();
            if (cVar != null) {
                cVar.f(new OtherException("gatt setCharacteristicNotification fail"));
            }
            return false;
        }
        BluetoothGattDescriptor descriptor = z5 ? bluetoothGattCharacteristic.getDescriptor(bluetoothGattCharacteristic.getUuid()) : bluetoothGattCharacteristic.getDescriptor(e(f32047f));
        if (descriptor == null) {
            l();
            if (cVar != null) {
                cVar.f(new OtherException("descriptor equals null"));
            }
            return false;
        }
        descriptor.setValue(z6 ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        boolean writeDescriptor = bluetoothGatt.writeDescriptor(descriptor);
        if (!writeDescriptor) {
            l();
            if (cVar != null) {
                cVar.f(new OtherException("gatt writeDescriptor fail"));
            }
        }
        return writeDescriptor;
    }

    private boolean u(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z5, boolean z6, e1.e eVar) {
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null) {
            n();
            if (eVar != null) {
                eVar.f(new OtherException("gatt or characteristic equal null"));
            }
            return false;
        }
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z6)) {
            n();
            if (eVar != null) {
                eVar.f(new OtherException("gatt setCharacteristicNotification fail"));
            }
            return false;
        }
        BluetoothGattDescriptor descriptor = z5 ? bluetoothGattCharacteristic.getDescriptor(bluetoothGattCharacteristic.getUuid()) : bluetoothGattCharacteristic.getDescriptor(e(f32047f));
        if (descriptor == null) {
            n();
            if (eVar != null) {
                eVar.f(new OtherException("descriptor equals null"));
            }
            return false;
        }
        descriptor.setValue(z6 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        boolean writeDescriptor = bluetoothGatt.writeDescriptor(descriptor);
        if (!writeDescriptor) {
            n();
            if (eVar != null) {
                eVar.f(new OtherException("gatt writeDescriptor fail"));
            }
        }
        return writeDescriptor;
    }

    private UUID e(String str) {
        if (str == null) {
            return null;
        }
        return UUID.fromString(str);
    }

    private void f(e1.c cVar, String str) {
        if (cVar != null) {
            l();
            cVar.d(str);
            cVar.c(this.f32052e);
            this.f32051d.v(str, cVar);
            Handler handler = this.f32052e;
            handler.sendMessageDelayed(handler.obtainMessage(33, cVar), com.clj.fastble.a.v().y());
        }
    }

    private void g(e1.e eVar, String str) {
        if (eVar != null) {
            n();
            eVar.d(str);
            eVar.c(this.f32052e);
            this.f32051d.x(str, eVar);
            Handler handler = this.f32052e;
            handler.sendMessageDelayed(handler.obtainMessage(17, eVar), com.clj.fastble.a.v().y());
        }
    }

    private void h(f fVar, String str) {
        if (fVar != null) {
            p();
            fVar.d(str);
            fVar.c(this.f32052e);
            this.f32051d.y(str, fVar);
            Handler handler = this.f32052e;
            handler.sendMessageDelayed(handler.obtainMessage(65, fVar), com.clj.fastble.a.v().y());
        }
    }

    private void i(k kVar, String str) {
        if (kVar != null) {
            z();
            kVar.d(str);
            kVar.c(this.f32052e);
            this.f32051d.A(str, kVar);
            Handler handler = this.f32052e;
            handler.sendMessageDelayed(handler.obtainMessage(49, kVar), com.clj.fastble.a.v().y());
        }
    }

    private void j(g gVar) {
        if (gVar != null) {
            s();
            gVar.c(this.f32052e);
            this.f32051d.z(gVar);
            Handler handler = this.f32052e;
            handler.sendMessageDelayed(handler.obtainMessage(81, gVar), com.clj.fastble.a.v().y());
        }
    }

    private void k(e1.d dVar) {
        if (dVar != null) {
            m();
            dVar.c(this.f32052e);
            this.f32051d.w(dVar);
            Handler handler = this.f32052e;
            handler.sendMessageDelayed(handler.obtainMessage(97, dVar), com.clj.fastble.a.v().y());
        }
    }

    private c w(UUID uuid, UUID uuid2) {
        BluetoothGatt bluetoothGatt;
        if (uuid != null && (bluetoothGatt = this.f32048a) != null) {
            this.f32049b = bluetoothGatt.getService(uuid);
        }
        BluetoothGattService bluetoothGattService = this.f32049b;
        if (bluetoothGattService != null && uuid2 != null) {
            this.f32050c = bluetoothGattService.getCharacteristic(uuid2);
        }
        return this;
    }

    public boolean a(boolean z5) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f32050c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() | 16) <= 0) {
            return false;
        }
        return t(this.f32048a, this.f32050c, z5, false, null);
    }

    public boolean b(boolean z5) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f32050c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() | 16) <= 0) {
            return false;
        }
        return u(this.f32048a, this.f32050c, z5, false, null);
    }

    public void c(e1.c cVar, String str, boolean z5) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f32050c;
        if (bluetoothGattCharacteristic != null && (bluetoothGattCharacteristic.getProperties() | 16) > 0) {
            f(cVar, str);
            t(this.f32048a, this.f32050c, z5, true, cVar);
        } else if (cVar != null) {
            cVar.f(new OtherException("this characteristic not support indicate!"));
        }
    }

    public void d(e1.e eVar, String str, boolean z5) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f32050c;
        if (bluetoothGattCharacteristic != null && (bluetoothGattCharacteristic.getProperties() | 16) > 0) {
            g(eVar, str);
            u(this.f32048a, this.f32050c, z5, true, eVar);
        } else if (eVar != null) {
            eVar.f(new OtherException("this characteristic not support notify!"));
        }
    }

    public void l() {
        this.f32052e.removeMessages(33);
    }

    public void m() {
        this.f32052e.removeMessages(97);
    }

    public void n() {
        this.f32052e.removeMessages(17);
    }

    public void o(f fVar, String str) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f32050c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 2) <= 0) {
            if (fVar != null) {
                fVar.e(new OtherException("this characteristic not support read!"));
                return;
            }
            return;
        }
        h(fVar, str);
        if (this.f32048a.readCharacteristic(this.f32050c)) {
            return;
        }
        p();
        if (fVar != null) {
            fVar.e(new OtherException("gatt readCharacteristic fail"));
        }
    }

    public void p() {
        this.f32052e.removeMessages(65);
    }

    public boolean r(int i6) {
        return this.f32048a.requestConnectionPriority(i6);
    }

    public void s() {
        this.f32052e.removeMessages(81);
    }

    public void y(byte[] bArr, k kVar, String str) {
        if (bArr == null || bArr.length <= 0) {
            if (kVar != null) {
                kVar.e(new OtherException("the data to be written is empty"));
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f32050c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 12) == 0) {
            if (kVar != null) {
                kVar.e(new OtherException("this characteristic not support write!"));
            }
        } else {
            if (!this.f32050c.setValue(bArr)) {
                if (kVar != null) {
                    kVar.e(new OtherException("Updates the locally stored value of this characteristic fail"));
                    return;
                }
                return;
            }
            i(kVar, str);
            if (this.f32048a.writeCharacteristic(this.f32050c)) {
                return;
            }
            z();
            if (kVar != null) {
                kVar.e(new OtherException("gatt writeCharacteristic fail"));
            }
        }
    }

    public void z() {
        this.f32052e.removeMessages(49);
    }

    c(b bVar) {
        this.f32051d = bVar;
        this.f32048a = bVar.I();
    }

    public void q(g gVar) {
        j(gVar);
        if (!this.f32048a.readRemoteRssi()) {
            s();
            if (gVar != null) {
                gVar.e(new OtherException("gatt readRemoteRssi fail"));
            }
        }
    }

    public void v(int i6, e1.d dVar) {
        k(dVar);
        if (!this.f32048a.requestMtu(i6)) {
            m();
            if (dVar != null) {
                dVar.f(new OtherException("gatt requestMtu fail"));
            }
        }
    }

    public c x(String str, String str2) {
        return w(e(str), e(str2));
    }
}
