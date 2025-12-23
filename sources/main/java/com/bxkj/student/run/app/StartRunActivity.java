package com.bxkj.student.run.app;

import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.alibaba.fastjson.JSON;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.ViewSwitcher;
import com.bxkj.student.R;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.location.service.LocationService;
import com.bxkj.student.run.app.my.MyRunActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.ready.RunDescriptionActivity;
import com.bxkj.student.run.app.ready.RunRoleSetBean;
import com.bxkj.student.run.app.ready.RunType;
import com.bxkj.student.run.app.ready.RunTypeDialog;
import com.bxkj.student.run.app.record.Card;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.step.service.StepService;
import com.bxkj.student.run.app.vm.RunVM;
import com.snail.antifake.jni.EmulatorDetectUtil;
import com.umeng.socialize.common.SocializeConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import t.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class StartRunActivity extends BaseActivity {
    private iOSTwoButtonDialog F0;
    private RunVM G0 = null;
    private MapView W;
    private AMap X;
    private Button Y;
    private RunTypeDialog Z;

    /* renamed from: a0, reason: collision with root package name */
    private ViewSwitcher f19734a0;

    /* renamed from: b0, reason: collision with root package name */
    private Card f19735b0;

    /* renamed from: c0, reason: collision with root package name */
    private Card f19736c0;

    /* renamed from: k0, reason: collision with root package name */
    private Card f19737k0;

    /* renamed from: p0, reason: collision with root package name */
    private iOSTwoButtonDialog f19738p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RunDb f19739a;

        a(final RunDb val$runDb) {
            this.f19739a = val$runDb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(RunDb runDb, View view) {
            StartRunActivity startRunActivity = StartRunActivity.this;
            startRunActivity.v1(runDb, startRunActivity.f19738p0, 3);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            StartRunActivity.this.f19738p0.dismiss();
            if (status != 201) {
                new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).T).setMessage(msg).show();
                return;
            }
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).T);
            iosonebuttondialog.setCanceledOnTouchOutside(false);
            iosonebuttondialog.setCancelable(false);
            final RunDb runDb = this.f19739a;
            iosonebuttondialog.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StartRunActivity.a.this.b(runDb, view);
                }
            });
            iosonebuttondialog.setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StartRunActivity.this.f19738p0.dismiss();
            Intent intent = new Intent();
            intent.putExtra("runExceptionDataDBId", this.f19739a.getIdentify());
            intent.setClass(((BaseActivity) StartRunActivity.this).T, RunningActivity.class);
            StartRunActivity.this.startActivity(intent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Function0<n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f19741a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f19742b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RunDb f19743c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f19744d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f19745e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
            }

            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void d(View view) {
                StartRunActivity.this.Z0();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e(View view) {
                StartRunActivity.this.Z0();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(View view) {
                StartRunActivity.this.Z0();
            }

            private void g(String msg) {
                iOSTwoButtonDialog iostwobuttondialog = b.this.f19745e;
                if (iostwobuttondialog != null) {
                    iostwobuttondialog.dismiss();
                }
                StartRunActivity.this.n1();
                StartRunActivity.this.G0.v(b.this.f19743c.getIdentify());
                new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).T).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.l0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.b.a.this.f(view);
                    }
                }).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnFailure(Throwable e6) {
                iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).T).setMessage("提交异常，已为您暂存本地，请稍后在本地跑步记录中重新上传！");
                message.setCanceledOnTouchOutside(false);
                message.setCancelable(false);
                message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.k0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.b.a.this.d(view);
                    }
                });
                message.show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data, String msg) {
                super.netOnSuccess(data, msg);
                g(msg);
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                if (status == 202) {
                    g(msg);
                } else {
                    netOnFailure(new Exception("上传失败"));
                }
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccessServerError(int code, String errorMessage) {
                super.netOnSuccessServerError(code, errorMessage);
                iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).T).setMessage("提交异常，已为您暂存本地，请稍后在本地跑步记录中重新上传！");
                message.setCanceledOnTouchOutside(false);
                message.setCancelable(false);
                message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.j0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.b.a.this.e(view);
                    }
                });
                message.show();
            }
        }

        b(final float val$distance, final long val$countTime, final RunDb val$runDb, final int val$uploadType, final iOSTwoButtonDialog val$exceptionDialog) {
            this.f19741a = val$distance;
            this.f19742b = val$countTime;
            this.f19743c = val$runDb;
            this.f19744d = val$uploadType;
            this.f19745e = val$exceptionDialog;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n1 invoke() {
            Http.with(((BaseActivity) StartRunActivity.this).T).setLoadingMessage("正在上传...").hideLoadingDialog().setCanCancel(false).hideSuccessMessage().hideFailMessage().setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).l(LoginUser.getLoginUser().getUserId(), Integer.parseInt(this.f19743c.getSportsType()), Long.parseLong(this.f19743c.getStartTime()), Long.parseLong(this.f19743c.getEndTime()), TextUtils.isEmpty(this.f19743c.getLatLngList()) ? null : this.f19743c.getLatLngList(), this.f19743c.getIdentify(), com.bxkj.student.run.app.utils.i.g(this.f19742b), com.bxkj.student.run.app.utils.i.d(this.f19741a), com.bxkj.student.run.app.utils.i.a(this.f19741a, this.f19742b), com.bxkj.student.run.app.utils.i.b(this.f19741a, this.f19742b), TextUtils.isEmpty(this.f19743c.getPassLatLngList()) ? null : this.f19743c.getPassLatLngList(), com.bxkj.base.util.b0.d(), com.bxkj.base.util.b0.e(), "Android", com.bxkj.base.util.b0.c(), com.bxkj.base.util.b0.h(((BaseActivity) StartRunActivity.this).T), this.f19743c.getStepList(), this.f19743c.isFaceOut(), TextUtils.isEmpty(this.f19743c.getPassLatLngList()) ? null : this.f19743c.getPassLatLngList(), Integer.valueOf(this.f19744d), null)).setDataListener(new a());
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements b.a {
        c() {
        }

        @Override // t.b.a
        public void b(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).T).setMessage(StartRunActivity.this.getString(R.string.run_permission_hint)).show();
        }

        @Override // t.b.a
        public void c(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).T).setMessage(StartRunActivity.this.getString(R.string.run_permission_hint)).show();
        }

        @Override // t.b.a
        public void a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements iOSTwoButtonDialog.RightButtonOnClick {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            com.bxkj.base.util.u.b(((BaseActivity) StartRunActivity.this).U);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements b.a {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            Intent intent = new Intent();
            intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            StartRunActivity.this.startActivity(intent);
        }

        @Override // t.b.a
        public void a() {
            if (((LocationManager) StartRunActivity.this.getSystemService(SocializeConstants.KEY_LOCATION)).isProviderEnabled(GeocodeSearch.GPS)) {
                StartRunActivity.this.a1();
            } else {
                new iOSTwoButtonDialog(((BaseActivity) StartRunActivity.this).T).setTitle("GPS未开启").setMessage(StartRunActivity.this.getString(R.string.run_request_location)).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.m0
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        StartRunActivity.e.this.e();
                    }
                }).show();
            }
        }

        @Override // t.b.a
        public void b(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).T).setMessage(StartRunActivity.this.getString(R.string.run_permission_hint)).show();
        }

        @Override // t.b.a
        public void c(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).T).setMessage(StartRunActivity.this.getString(R.string.run_permission_hint)).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StartRunActivity.this.t1(data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements RunTypeDialog.a {
        g() {
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.a
        public void a() {
            StartRunActivity.this.u1(4);
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.a
        public void b() {
            StartRunActivity.this.u1(3);
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.a
        public void c() {
            StartRunActivity.this.u1(1);
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.a
        public void d() {
            StartRunActivity.this.u1(2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19753a;

        h(final int val$runType) {
            this.f19753a = val$runType;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                RunRoleSetBean.DataBean dataBean = (RunRoleSetBean.DataBean) JSON.parseObject(JSON.toJSONString(data), RunRoleSetBean.DataBean.class);
                dataBean.setRunType(this.f19753a);
                Intent intent = new Intent(((BaseActivity) StartRunActivity.this).T, (Class<?>) RunDescriptionActivity.class);
                intent.putExtra("dataBean", dataBean);
                StartRunActivity.this.startActivity(intent);
                StartRunActivity.this.overridePendingTransition(2130771987, 2130771986);
            } catch (Exception e6) {
                e6.printStackTrace();
                new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).T).setMessage("跑步设置异常,请联系管理员").show();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i extends HttpCallBack {
        i() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Map<String, Object> map = JsonParse.getMap(data, "morningRun");
            if (map != null && !map.isEmpty()) {
                int i6 = JsonParse.getInt(map, "succeed");
                double d6 = JsonParse.getDouble(map, "runSportRange");
                int i7 = JsonParse.getInt(map, "isShow");
                if (StartRunActivity.this.f19735b0 == null && i7 == 1) {
                    StartRunActivity.this.f19735b0 = new Card(((BaseActivity) StartRunActivity.this).T).f(1).e(ContextCompat.getColor(((BaseActivity) StartRunActivity.this).T, R.color.card1));
                    StartRunActivity.this.f19734a0.addView(StartRunActivity.this.f19735b0);
                }
                if (StartRunActivity.this.f19735b0 != null) {
                    StartRunActivity.this.f19735b0.setCount(i6);
                    StartRunActivity.this.f19735b0.setDistance(d6);
                }
            }
            Map<String, Object> map2 = JsonParse.getMap(data, "sunRun");
            if (map2 != null && !map2.isEmpty()) {
                int i8 = JsonParse.getInt(map2, "succeed");
                double d7 = JsonParse.getDouble(map2, "runSportRange");
                int i9 = JsonParse.getInt(map2, "isShow");
                if (StartRunActivity.this.f19736c0 == null && i9 == 1) {
                    StartRunActivity.this.f19736c0 = new Card(((BaseActivity) StartRunActivity.this).T).f(2).e(ContextCompat.getColor(((BaseActivity) StartRunActivity.this).T, R.color.card2));
                    StartRunActivity.this.f19734a0.addView(StartRunActivity.this.f19736c0);
                }
                if (StartRunActivity.this.f19736c0 != null) {
                    StartRunActivity.this.f19736c0.setCount(i8);
                    StartRunActivity.this.f19736c0.setDistance(d7);
                }
            }
            Map<String, Object> map3 = JsonParse.getMap(data, "freedom");
            if (map3 == null || map3.isEmpty()) {
                return;
            }
            int i10 = JsonParse.getInt(map3, "succeed");
            double d8 = JsonParse.getDouble(map3, "runSportRange");
            int i11 = JsonParse.getInt(map3, "isShow");
            if (StartRunActivity.this.f19737k0 == null && i11 == 1) {
                StartRunActivity.this.f19737k0 = new Card(((BaseActivity) StartRunActivity.this).T).f(3).e(ContextCompat.getColor(((BaseActivity) StartRunActivity.this).T, R.color.card3));
                StartRunActivity.this.f19734a0.addView(StartRunActivity.this.f19737k0);
            }
            if (StartRunActivity.this.f19737k0 != null) {
                StartRunActivity.this.f19737k0.setCount(i10);
                StartRunActivity.this.f19737k0.setDistance(d8);
            }
        }
    }

    public static boolean c1(String source, String dest) {
        try {
            File file = new File(source);
            File file2 = new File(dest);
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (FileNotFoundException | IOException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        iOSTwoButtonDialog iostwobuttondialog = this.f19738p0;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f19738p0.dismiss();
        }
        iOSTwoButtonDialog iostwobuttondialog2 = this.F0;
        if (iostwobuttondialog2 != null && iostwobuttondialog2.isShowing()) {
            this.F0.dismiss();
        }
        if (this.G0 == null) {
            return;
        }
        final LoadingDialog loadingDialog = new LoadingDialog(this.T);
        loadingDialog.show();
        this.G0.A(new Function1() { // from class: com.bxkj.student.run.app.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 g12;
                g12 = StartRunActivity.this.g1(loadingDialog, (List) obj);
                return g12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        final LoadingDialog loadingDialog = new LoadingDialog(this.U);
        loadingDialog.show();
        com.bxkj.student.v2.common.utils.q.f20918a.c(this.U, new Function0() { // from class: com.bxkj.student.run.app.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 h12;
                h12 = StartRunActivity.this.h1(loadingDialog);
                return h12;
            }
        }, new Function0() { // from class: com.bxkj.student.run.app.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StartRunActivity.j0(LoadingDialog.this);
            }
        });
    }

    private void b1() {
        if (!((PowerManager) getSystemService("power")).isPowerSaveMode() || isFinishing()) {
            return;
        }
        new iOSOneButtonDialog(this.T).setMessage("开始跑步前请关闭省电模式，否则轨迹记录可能不准确！").show();
    }

    private void e1() {
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).a(LoginUser.getLoginUser().getUserId())).setDataListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1(View view) {
        startActivity(new Intent(this.T, (Class<?>) RunRecorderListActivity.class).putExtra("runType", ((Card) view).getRunType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1() {
        startActivity(new Intent(this.T, (Class<?>) MyRunActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1(RunDb runDb) {
        v1(runDb, this.f19738p0, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1(RunDb runDb) {
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).d(runDb.getIdentify())).setDataListener(new a(runDb));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1() {
        startActivity(new Intent(this.T, (Class<?>) RunRecorderListActivity.class));
    }

    private void o1() {
        new t.b(this).c(com.kuaishou.weapon.p0.g.f36048h, com.kuaishou.weapon.p0.g.f36047g).d(new c());
        if (com.bxkj.base.util.u.a(this.T)) {
            return;
        }
        new iOSTwoButtonDialog(this.T).setMessage("为了能够让你在跑步过程中不错过重要的通知消息,强烈建议你开始允许推送通知功能").setRightButtonOnClickListener(new d()).setLeftButtonText("不了").setRightButtonText("去开启").show();
    }

    private void p1() {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.mipmap.location_marker));
        myLocationStyle.strokeColor(ViewCompat.MEASURED_STATE_MASK);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        myLocationStyle.strokeWidth(1.0f);
        this.X.setMyLocationStyle(myLocationStyle);
        this.X.getUiSettings().setMyLocationButtonEnabled(true);
        this.X.setMyLocationEnabled(true);
        this.X.moveCamera(CameraUpdateFactory.zoomTo(19.0f));
    }

    private void q1(final RunDb runDb) {
        com.orhanobut.logger.j.c("runExceptionDataDB=" + runDb.toString());
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(Long.parseLong(runDb.getStartTime())));
        String g6 = com.bxkj.student.run.app.utils.i.g(Long.parseLong(runDb.getCountTime()));
        String d6 = com.bxkj.student.run.app.utils.i.d((double) Float.parseFloat(runDb.getDistance()));
        String q5 = com.bxkj.student.run.app.utils.i.q(Integer.parseInt(runDb.getSportsType()));
        StringBuilder sb = new StringBuilder();
        sb.append("系统检测到您有1条在");
        sb.append(format);
        sb.append("开始的的已运动");
        sb.append(d6);
        sb.append("KM");
        sb.append(",用时");
        sb.append(g6);
        sb.append("的");
        sb.append(q5);
        sb.append("记录异常结束,强烈建议您检查运动权限设置是否正确后尽快恢复继续跑步");
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.T);
        this.f19738p0 = iostwobuttondialog;
        iostwobuttondialog.setClickAutoCancel(false);
        this.f19738p0.setCancelable(false);
        this.f19738p0.setCanceledOnTouchOutside(false);
        this.f19738p0.setMessage(sb).setLeftButtonText("结束并上传").setRightButtonText("恢复继续跑步").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.e0
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                StartRunActivity.this.k1(runDb);
            }
        }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.f0
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                StartRunActivity.this.l1(runDb);
            }
        }).show();
    }

    private void r1(List<RunDb> runDbs1) {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.T);
        this.F0 = iostwobuttondialog;
        iostwobuttondialog.setMessage("系统检测到您还有" + runDbs1.size() + "条跑步记录在本地暂存,是否上传？").setLeftButtonText("暂存本地").setRightButtonText("现在上传").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.h0
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                StartRunActivity.this.m1();
            }
        }).show();
    }

    private void s1() {
        new t.b(this).c(com.kuaishou.weapon.p0.g.f36048h, com.kuaishou.weapon.p0.g.f36047g).d(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(@RunType int runType) {
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).k(runType, LoginUser.getLoginUser().getUserId())).setDataListener(new h(runType));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (com.bxkj.base.util.a0.a(this.T, LocationService.class.getName())) {
            com.orhanobut.logger.j.c("LocationService----------isServiceRunning");
            stopService(new Intent(this.T, (Class<?>) LocationService.class));
        }
        if (com.bxkj.base.util.a0.a(this.T, StepService.class.getName())) {
            com.orhanobut.logger.j.c("StepService----------isServiceRunning");
            stopService(new Intent(this.T, (Class<?>) StepService.class));
        }
        this.Y.setOnClickListener(this);
        d1();
        o1();
        p1();
        this.f19734a0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StartRunActivity.this.i1(view);
            }
        });
        b1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("App跑步");
        e0(ContextCompat.getColor(this, 2131099737));
        a0(2131689955, new BaseActivity.c() { // from class: com.bxkj.student.run.app.g0
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                StartRunActivity.this.j1();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.T = this;
        this.Y = (Button) findViewById(R.id.bt_start);
        MapView mapView = (MapView) findViewById(R.id.map);
        this.W = mapView;
        mapView.onCreate(savedInstanceState);
        this.X = this.W.getMap();
        this.f19734a0 = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        this.G0 = (RunVM) new ViewModelProvider(this).get(RunVM.class);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void r1() {
        RunTypeDialog runTypeDialog = this.Z;
        if (runTypeDialog == null || !runTypeDialog.isShowing()) {
            super.r1();
        } else {
            com.bxkj.student.run.app.utils.j.d(this);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.W.onDestroy();
        super.onDestroy();
    }

    public void t1(Map<String, Object> data) {
        RunTypeDialog r5 = new RunTypeDialog(this).u(JsonParse.getInt(data, "morningRun", 1) == 0).v(JsonParse.getInt(data, "sunRun", 1) == 0).s(JsonParse.getInt(data, "freedom", 1) == 0).t(JsonParse.getInt(data, "marathonRun", 1) == 0, JsonParse.getString(data, "marathonRunName")).r(new g());
        this.Z = r5;
        r5.show();
    }

    private void d1() {
        if (!LoginUser.getLoginUser().isLogin()) {
            return;
        }
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).p(LoginUser.getLoginUser().getUserId())).setDataListener(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 f1(LoadingDialog loadingDialog, List list) {
        loadingDialog.dismiss();
        if (list != null && list.size() > 0) {
            r1(list);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 g1(final LoadingDialog loadingDialog, List list) {
        loadingDialog.dismiss();
        if (list != null && list.size() > 0) {
            q1((RunDb) list.get(0));
            return null;
        }
        loadingDialog.show();
        this.G0.B(new Function1() { // from class: com.bxkj.student.run.app.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 f12;
                f12 = StartRunActivity.this.f1(loadingDialog, (List) obj);
                return f12;
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 h1(LoadingDialog loadingDialog) {
        loadingDialog.dismiss();
        e1();
        return null;
    }

    public static /* synthetic */ n1 j0(LoadingDialog loadingDialog) {
        loadingDialog.dismiss();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(RunDb runDb, iOSTwoButtonDialog exceptionDialog, int uploadType) {
        long parseLong = Long.parseLong(runDb.getCountTime());
        this.G0.E(runDb, new b(Float.parseFloat(runDb.getDistance()), parseLong, runDb, uploadType, exceptionDialog));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.fm_run;
    }

    public void n1() {
        d1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (!LoginUser.getLoginUser().isLogin()) {
            this.T.startActivity(new Intent(this.T, (Class<?>) LoginActivity.class));
        } else {
            if (v5.getId() != 2131296646) {
                return;
            }
            if (EmulatorDetectUtil.b(this.T)) {
                new iOSOneButtonDialog(this.T).setMessage("系统检查到当前运行环境为模拟器，请使用真机进行跑步").show();
            } else {
                s1();
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.W.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.W.onResume();
        Z0();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.W.onSaveInstanceState(outState);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }
}
