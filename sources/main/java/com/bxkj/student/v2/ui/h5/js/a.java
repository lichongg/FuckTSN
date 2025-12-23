package com.bxkj.student.v2.ui.h5.js;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Intent;
import android.os.ParcelUuid;
import android.provider.Settings;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.work.WorkRequest;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.student.v2.ui.h5.js.a;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.scan.b;
import java.util.List;
import java.util.UUID;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t.b;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a extends com.bxkj.base.v2.h5.l {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private FragmentActivity f21420c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private WebView f21421d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private BluetoothGattServer f21422e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private BluetoothLeAdvertiser f21423f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private AdvertiseCallback f21424g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.v2.ui.h5.js.a$a, reason: collision with other inner class name */
    public static final class C0291a implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21426b;

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            if (i6 == -1) {
                a.this.k(this.f21426b);
            }
        }

        C0291a(String str) {
            this.f21426b = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.BlueToothJS$openBluetooth$1", f = "BlueToothJS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21427a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21429c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.v2.ui.h5.js.a$b$a, reason: collision with other inner class name */
        public static final class C0292a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f21430a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f21431b;

            @Override // u.b.a
            public void a(int i6, Intent intent) {
                if (i6 != -1) {
                    this.f21430a.openBluetooth(this.f21431b);
                } else {
                    this.f21430a.l(this.f21431b);
                }
            }

            C0292a(a aVar, String str) {
                this.f21430a = aVar;
                this.f21431b = str;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
            this.f21429c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return a.this.new b(this.f21429c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21427a == 0) {
                g0.n(obj);
                Object systemService = a.this.a().getSystemService("bluetooth");
                kotlin.jvm.internal.g0.n(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
                BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
                if (adapter != null && adapter.isEnabled()) {
                    a.this.l(this.f21429c);
                } else {
                    new u.b(a.this.a()).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE")).c(new C0292a(a.this, this.f21429c));
                }
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends e1.i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21433b;

        @Override // e1.j
        public void a(boolean z5) {
            com.orhanobut.logger.j.d("onScanStarted", new Object[0]);
        }

        c(String str) {
            this.f21433b = str;
        }

        @Override // e1.j
        public void b(BleDevice bleDevice) {
            kotlin.jvm.internal.g0.p(bleDevice, "bleDevice");
            com.orhanobut.logger.j.d("onScanning:" + bleDevice.d() + "-" + bleDevice.c(), new Object[0]);
            com.clj.fastble.a.v().a();
            String i6 = a.this.i();
            a.this.b().loadUrl("javascript:stuSignStatus('" + this.f21433b + "','" + i6 + "')");
        }

        @Override // e1.i
        public void c(BleDevice bleDevice) {
            kotlin.jvm.internal.g0.p(bleDevice, "bleDevice");
            com.orhanobut.logger.j.d("onLeScan:" + bleDevice.d() + "-" + bleDevice.c(), new Object[0]);
        }

        @Override // e1.i
        public void d(List<? extends BleDevice> scanResultList) {
            kotlin.jvm.internal.g0.p(scanResultList, "scanResultList");
            com.orhanobut.logger.j.d("onScanFinished:" + scanResultList, new Object[0]);
            if (scanResultList.isEmpty()) {
                iOSTwoButtonDialog leftButtonOnClickListener = new iOSTwoButtonDialog(a.this.a()).setMessage("未搜索到蓝牙信息，签到失败，是否重试？").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.v2.ui.h5.js.b
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                    public final void buttonLeftOnClick() {
                        a.c.g();
                    }
                });
                final a aVar = a.this;
                final String str = this.f21433b;
                leftButtonOnClickListener.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.v2.ui.h5.js.c
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        a.c.h(a.this, str);
                    }
                }).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(a aVar, String str) {
            aVar.k(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends BluetoothGattServerCallback {
        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onConnectionStateChange(BluetoothDevice device, int i6, int i7) {
            kotlin.jvm.internal.g0.p(device, "device");
            super.onConnectionStateChange(device, i6, i7);
        }

        d() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class e extends AdvertiseCallback {
        e() {
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartSuccess(AdvertiseSettings settingsInEffect) {
            kotlin.jvm.internal.g0.p(settingsInEffect, "settingsInEffect");
            super.onStartSuccess(settingsInEffect);
            com.orhanobut.logger.j.g("服务发布成功", new Object[0]);
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartFailure(int i6) {
            super.onStartFailure(i6);
            new iOSOneButtonDialog(a.this.a()).setMessage("开启蓝牙广播服务失败,错误码：" + i6 + ",请重新再试").show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.BlueToothJS$stuOpenBluetooth$1", f = "BlueToothJS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21435a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21437c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.v2.ui.h5.js.a$f$a, reason: collision with other inner class name */
        public static final class C0293a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f21438a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f21439b;

            C0293a(a aVar, String str) {
                this.f21438a = aVar;
                this.f21439b = str;
            }

            @Override // t.b.a
            public void b(String[] permission) {
                kotlin.jvm.internal.g0.p(permission, "permission");
                new iOSOneButtonDialog(this.f21438a.a()).setMessage("您拒绝了蓝牙定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
            }

            @Override // t.b.a
            public void c(String[] permission) {
                kotlin.jvm.internal.g0.p(permission, "permission");
                new iOSOneButtonDialog(this.f21438a.a()).setMessage("您拒绝了蓝牙和定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
            }

            @Override // t.b.a
            public void a() {
                com.clj.fastble.a.v().G(this.f21438a.a().getApplication());
                com.clj.fastble.a.v().l(true).f0(1, 5000L).d0(5000);
                this.f21438a.j(this.f21439b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, kotlin.coroutines.e<? super f> eVar) {
            super(2, eVar);
            this.f21437c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return a.this.new f(this.f21437c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((f) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21435a == 0) {
                g0.n(obj);
                new t.b(a.this.a()).c("android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", com.kuaishou.weapon.p0.g.f36048h, com.kuaishou.weapon.p0.g.f36047g).d(new C0293a(a.this, this.f21437c));
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @JavascriptInterface
    @RequiresApi(21)
    public final void closeBluetooth() {
        com.clj.fastble.a v5;
        com.orhanobut.logger.j.d("关闭蓝牙点名", new Object[0]);
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f21423f;
        if (bluetoothLeAdvertiser != null) {
            bluetoothLeAdvertiser.stopAdvertising(this.f21424g);
        }
        BluetoothGattServer bluetoothGattServer = this.f21422e;
        if (bluetoothGattServer != null) {
            bluetoothGattServer.clearServices();
        }
        BluetoothGattServer bluetoothGattServer2 = this.f21422e;
        if (bluetoothGattServer2 != null) {
            bluetoothGattServer2.close();
        }
        if (com.clj.fastble.a.v().C() != BleScanState.STATE_SCANNING || (v5 = com.clj.fastble.a.v()) == null) {
            return;
        }
        v5.a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        super(mActivity, mWebView);
        kotlin.jvm.internal.g0.p(mActivity, "mActivity");
        kotlin.jvm.internal.g0.p(mWebView, "mWebView");
        this.f21420c = mActivity;
        this.f21421d = mWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String str) {
        com.clj.fastble.a.v().H(new b.a().g(new UUID[]{UUID.fromString(str)}).f(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).b());
        com.clj.fastble.a.v().Y(new c(str));
    }

    @Override // com.bxkj.base.v2.h5.l
    @NotNull
    public FragmentActivity a() {
        return this.f21420c;
    }

    @Override // com.bxkj.base.v2.h5.l
    @NotNull
    public WebView b() {
        return this.f21421d;
    }

    @Override // com.bxkj.base.v2.h5.l
    public void c(@NotNull FragmentActivity fragmentActivity) {
        kotlin.jvm.internal.g0.p(fragmentActivity, "<set-?>");
        this.f21420c = fragmentActivity;
    }

    @Override // com.bxkj.base.v2.h5.l
    public void d(@NotNull WebView webView) {
        kotlin.jvm.internal.g0.p(webView, "<set-?>");
        this.f21421d = webView;
    }

    @JavascriptInterface
    public final void openBluetooth(@Nullable String str) {
        com.orhanobut.logger.j.d("开始蓝牙点名uuid=" + str, new Object[0]);
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(a()), g1.e(), null, new b(str, null), 2, null);
    }

    @JavascriptInterface
    public final void stuOpenBluetooth(@NotNull String identify) {
        kotlin.jvm.internal.g0.p(identify, "identify");
        com.orhanobut.logger.j.d("js->stuOpenBluetooth identify=" + identify, new Object[0]);
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(a()), g1.e(), null, new f(identify, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i() {
        return Settings.Secure.getString(a().getContentResolver(), "bluetooth_address");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String str) {
        if (com.clj.fastble.a.v().L()) {
            new u.b(a()).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE")).c(new C0291a(str));
        } else {
            new iOSOneButtonDialog(a()).setMessage("您的手机不支持蓝牙签到,请联系老师手动签到").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    public final void l(String str) {
        Object systemService = a().getSystemService("bluetooth");
        kotlin.jvm.internal.g0.n(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothManager bluetoothManager = (BluetoothManager) systemService;
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UUID.fromString(str), 16, 1);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(UUID.fromString(str), 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        this.f21422e = bluetoothManager.openGattServer(a(), new d());
        this.f21423f = adapter.getBluetoothLeAdvertiser();
        BluetoothGattServer bluetoothGattServer = this.f21422e;
        if (bluetoothGattServer != null) {
            bluetoothGattServer.addService(bluetoothGattService);
        }
        AdvertiseData build = new AdvertiseData.Builder().addServiceUuid(ParcelUuid.fromString(str)).build();
        AdvertiseSettings build2 = new AdvertiseSettings.Builder().setConnectable(true).build();
        e eVar = new e();
        this.f21424g = eVar;
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f21423f;
        if (bluetoothLeAdvertiser != null) {
            bluetoothLeAdvertiser.startAdvertising(build2, build, eVar);
        }
    }
}
