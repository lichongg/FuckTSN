package com.bxkj.student.home.teaching.rollcall;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.provider.Settings;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.WaveView;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.rollcall.BlueToothSignActivity;
import com.orhanobut.logger.j;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class BlueToothSignActivity extends BaseActivity {
    private WaveView W;
    private final int X = 2561;
    private BluetoothLeScanner Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f18962a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f18963b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f18964c0;

    /* renamed from: k0, reason: collision with root package name */
    private ScanCallback f18965k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f18966p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements b.a {
        a() {
        }

        @Override // t.b.a
        public void a() {
            BlueToothSignActivity.this.C0();
            BlueToothSignActivity.this.B0();
        }

        @Override // t.b.a
        public void b(String... permission) {
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).T).setMessage("您拒绝了定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
        }

        @Override // t.b.a
        public void c(String... permission) {
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).T).setMessage("您拒绝了定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            BlueToothSignActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BlueToothSignActivity.this.Z = JsonParse.getString(data, "Identify");
            BlueToothSignActivity.this.f18962a0 = JsonParse.getString(data, "teachingClockingin");
            BlueToothSignActivity.this.f18963b0 = JsonParse.getString(data, "stuTeacherCurriculum");
            BlueToothSignActivity.this.f18964c0 = JsonParse.getString(data, "weekNum");
            BlueToothSignActivity.this.E0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).T).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BlueToothSignActivity.b.this.b(view);
                }
            }).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends ScanCallback {
        c() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> results) {
            j.c("results=" + results);
            super.onBatchScanResults(results);
            j.c("results=" + results);
        }

        @Override // android.bluetooth.le.ScanCallback
        @RequiresApi(api = 21)
        public void onScanResult(int callbackType, ScanResult re) {
            j.c("callbackType=" + callbackType + "\nre=" + re.toString());
            super.onScanResult(callbackType, re);
            try {
                BlueToothSignActivity.this.Y.stopScan(this);
                j.c("callbackType=" + callbackType + "\nre=" + re.toString());
                List<ParcelUuid> serviceUuids = re.getScanRecord().getServiceUuids();
                if (re.getScanRecord() == null || serviceUuids == null) {
                    return;
                }
                Iterator<ParcelUuid> it = serviceUuids.iterator();
                while (it.hasNext()) {
                    if (it.next().toString().equalsIgnoreCase(BlueToothSignActivity.this.Z)) {
                        BlueToothSignActivity.this.F0();
                        return;
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
            j.c("errorCode=" + errorCode);
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).T).setMessage("签到失败,请重新再试").show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                BlueToothSignActivity.this.finish();
            }
        }

        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            try {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).T).setMessage("签到失败，请重新再试").show();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).T).setMessage("签到成功").setButtonOnClickListener(new a()).show();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            try {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).T).setMessage("签到失败，请重新再试").show();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 18)
    public void B0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).S0(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 18)
    public void E0() {
        BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        if (adapter == null || !adapter.isEnabled()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2561);
        } else {
            G0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 21)
    public void F0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).D1(this.f18962a0, this.f18963b0, this.f18964c0, this.f18966p0, LoginUser.getLoginUser().getSchoolId())).setDataListener(new d());
    }

    private void G0() {
        BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        this.f18966p0 = A0(this.T);
        j.c("bluetoothAddress=" + this.f18966p0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(this.Z)).build());
        ScanSettings build = new ScanSettings.Builder().setScanMode(2).build();
        this.f18965k0 = new c();
        BluetoothLeScanner bluetoothLeScanner = adapter.getBluetoothLeScanner();
        this.Y = bluetoothLeScanner;
        bluetoothLeScanner.startScan(arrayList, build, this.f18965k0);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    @RequiresApi(api = 18)
    public void S() {
        new t.b(this.U).c(com.kuaishou.weapon.p0.g.f36048h, com.kuaishou.weapon.p0.g.f36047g).d(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("上课签到");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @RequiresApi(api = 21)
    protected void onDestroy() {
        WaveView waveView = this.W;
        if (waveView != null) {
            waveView.l();
        }
        BluetoothLeScanner bluetoothLeScanner = this.Y;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.stopScan(this.f18965k0);
        }
        super.onDestroy();
    }

    public static String A0(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        WaveView waveView = (WaveView) findViewById(R.id.waveView);
        this.W = waveView;
        waveView.setStyle(Paint.Style.FILL);
        this.W.setColor(ContextCompat.getColor(this.T, 2131099714));
        this.W.k();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_sign;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2561) {
            if (resultCode == -1) {
                j.c("打开蓝牙成功！");
                G0();
                return;
            } else {
                new iOSOneButtonDialog(this.T).setMessage("打开蓝牙失败,将无法签到").show();
                return;
            }
        }
        j.c("打开蓝牙异常！");
    }

    public String z0() {
        Method method;
        Object invoke;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            Field declaredField = BluetoothAdapter.class.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(defaultAdapter);
            if (obj != null && (method = obj.getClass().getMethod("getAddress", null)) != null && (invoke = method.invoke(obj, null)) != null) {
                return invoke.toString();
            }
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        } catch (NoSuchFieldException e7) {
            e7.printStackTrace();
        } catch (NoSuchMethodException e8) {
            e8.printStackTrace();
        } catch (InvocationTargetException e9) {
            e9.printStackTrace();
        }
        return null;
    }

    @RequiresApi(api = 18)
    public void D0(String number) {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
