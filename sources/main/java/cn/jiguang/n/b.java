package cn.jiguang.n;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.ArrayMap;
import cn.jiguang.bb.f;
import cn.jiguang.bz.s;
import java.util.concurrent.Callable;

@TargetApi(21)
/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements Callable<ArrayMap<String, cn.jiguang.o.a>> {

    /* renamed from: a, reason: collision with root package name */
    private Context f3113a;

    /* renamed from: b, reason: collision with root package name */
    private BluetoothAdapter f3114b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayMap<String, cn.jiguang.o.a> f3115c = new ArrayMap<>();

    /* renamed from: d, reason: collision with root package name */
    private boolean f3116d = false;

    /* renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f3117e = new BroadcastReceiver() { // from class: cn.jiguang.n.b.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(action)) {
                b.this.a(new cn.jiguang.o.a((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0)));
            } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                f.c("JBtCallable", "scan bt finish");
                b.this.f3116d = true;
            } else if ("android.bluetooth.adapter.action.DISCOVERY_STARTED".equals(action)) {
                f.c("JBtCallable", "scan bt start");
            }
        }
    };

    private void b() {
        f.c("JBtCallable", "doDiscovery() and state is " + this.f3114b.getState());
        BluetoothAdapter bluetoothAdapter = this.f3114b;
        if (bluetoothAdapter == null || bluetoothAdapter.getState() != 12) {
            return;
        }
        if (this.f3114b.isDiscovering()) {
            this.f3114b.cancelDiscovery();
        }
        this.f3114b.startDiscovery();
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ArrayMap<String, cn.jiguang.o.a> call() {
        b();
        while (!this.f3116d) {
            try {
                Thread.sleep(1000L);
            } catch (Throwable unused) {
            }
        }
        BluetoothAdapter bluetoothAdapter = this.f3114b;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
        }
        this.f3113a.unregisterReceiver(this.f3117e);
        this.f3114b = null;
        f.c("JBtCallable", "devices size is " + this.f3115c.size());
        return this.f3115c;
    }

    private boolean b(cn.jiguang.o.a aVar) {
        if (aVar.m() == null || aVar.m().length <= 0 || !(this.f3115c.get(aVar.c()).m() == null || this.f3115c.get(aVar.c()).m().length == 0)) {
            return !TextUtils.isEmpty(aVar.d()) && TextUtils.isEmpty(this.f3115c.get(aVar.c()).d());
        }
        return true;
    }

    public b(Context context) {
        this.f3113a = context;
        try {
            this.f3114b = BluetoothAdapter.getDefaultAdapter();
        } catch (Throwable unused) {
        }
        s.a(context, this.f3117e, new IntentFilter("android.bluetooth.device.action.FOUND"), "android.permission.BLUETOOTH", null, false);
        s.a(context, this.f3117e, new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_STARTED"), "android.permission.BLUETOOTH", null, false);
        s.a(context, this.f3117e, new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED"), "android.permission.BLUETOOTH", null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cn.jiguang.o.a aVar) {
        if (aVar != null) {
            if (!this.f3115c.containsKey(aVar.c()) || b(aVar)) {
                this.f3115c.put(aVar.c(), aVar);
            }
        }
    }
}
