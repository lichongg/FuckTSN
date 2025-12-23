package cn.jiguang.o;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import cn.jiguang.p.b;
import java.util.Arrays;

@TargetApi(18)
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f3151a;

    /* renamed from: b, reason: collision with root package name */
    private int f3152b;

    /* renamed from: c, reason: collision with root package name */
    private String f3153c;

    /* renamed from: d, reason: collision with root package name */
    private String f3154d;

    /* renamed from: e, reason: collision with root package name */
    private int f3155e;

    /* renamed from: f, reason: collision with root package name */
    private int f3156f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f3157g;

    /* renamed from: h, reason: collision with root package name */
    private int f3158h;

    /* renamed from: i, reason: collision with root package name */
    private int f3159i;

    /* renamed from: m, reason: collision with root package name */
    private String[] f3163m;

    /* renamed from: j, reason: collision with root package name */
    private String f3160j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f3161k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f3162l = "";

    /* renamed from: n, reason: collision with root package name */
    private int f3164n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f3165o = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f3166p = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f3167q = 0;

    public a() {
    }

    public a(BluetoothDevice bluetoothDevice, int i6) {
        if (bluetoothDevice != null) {
            this.f3151a = bluetoothDevice.getType();
            this.f3153c = bluetoothDevice.getAddress();
            this.f3154d = TextUtils.isEmpty(bluetoothDevice.getName()) ? "" : bluetoothDevice.getName();
            this.f3155e = bluetoothDevice.getBondState();
            this.f3152b = cn.jiguang.p.a.a(bluetoothDevice);
            this.f3157g = b.a(bluetoothDevice.getUuids());
        }
        this.f3156f = i6;
    }

    public int a() {
        return this.f3151a;
    }

    public int b() {
        return this.f3152b;
    }

    public String c() {
        return this.f3153c;
    }

    public String d() {
        return this.f3154d;
    }

    public int e() {
        return this.f3155e;
    }

    public int f() {
        return this.f3156f;
    }

    public String[] g() {
        return this.f3157g;
    }

    public int h() {
        return this.f3158h;
    }

    public int i() {
        return this.f3159i;
    }

    public String j() {
        return this.f3160j;
    }

    public String k() {
        return this.f3161k;
    }

    public String l() {
        return this.f3162l;
    }

    public String[] m() {
        return this.f3163m;
    }

    public int n() {
        return this.f3164n;
    }

    public int o() {
        return this.f3165o;
    }

    public int p() {
        return this.f3166p;
    }

    public int q() {
        return this.f3167q;
    }

    public String toString() {
        return "JBluetoothInfo{type=" + this.f3151a + ", bluetoothClass=" + this.f3152b + ", address='" + this.f3153c + "', name='" + this.f3154d + "', state=" + this.f3155e + ", rssi=" + this.f3156f + ", uuids=" + Arrays.toString(this.f3157g) + ", advertiseFlag=" + this.f3158h + ", advertisingSid=" + this.f3159i + ", deviceName='" + this.f3160j + "', manufacturer_ids=" + this.f3161k + ", serviceData='" + this.f3162l + "', serviceUuids=" + Arrays.toString(this.f3163m) + ", txPower=" + this.f3164n + ", txPowerLevel=" + this.f3165o + ", primaryPhy=" + this.f3166p + ", secondaryPhy=" + this.f3167q + '}';
    }
}
