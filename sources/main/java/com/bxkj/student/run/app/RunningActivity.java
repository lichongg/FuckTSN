package com.bxkj.student.run.app;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.WorkRequest;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.http.dialog.DialogOnKeyListener;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceClient;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.R;
import com.bxkj.student.common.view.LongPressToFinishButton;
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.location.service.LocationService;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.ready.RunRoleSetBean;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.set.RunSettingActivity;
import com.bxkj.student.run.app.step.service.StepService;
import com.bxkj.student.run.app.vm.RunVM;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunningActivity extends BaseActivity {

    /* renamed from: y1, reason: collision with root package name */
    public static final String f19689y1 = "com.location.apis.geofencedemo.broadcast";

    /* renamed from: z1, reason: collision with root package name */
    public static final String f19690z1 = "com.location.apis.geofenceBounds.broadcast";
    private TextView F0;
    private LinearLayout G0;
    private LongPressToFinishButton H0;
    private Button I0;
    private LatLngBounds.Builder J0;
    private Intent M0;
    private RunRoleSetBean.DataBean O0;
    private List<Double> P0;
    private LatLng R0;
    private iOSOneButtonDialog U0;
    private RunDb V0;
    private MapView W;
    private com.bxkj.student.run.app.utils.g W0;
    private AMap X;
    private e X0;
    private ImageView Y;
    private LatLngBounds.Builder Y0;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private MarqueeTextView f19691a0;

    /* renamed from: a1, reason: collision with root package name */
    private GeoFenceClient f19692a1;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f19693b0;

    /* renamed from: b1, reason: collision with root package name */
    private GeoFenceClient f19694b1;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f19695c0;

    /* renamed from: c1, reason: collision with root package name */
    private Intent f19696c1;

    /* renamed from: d1, reason: collision with root package name */
    private RunVM f19697d1;

    /* renamed from: e1, reason: collision with root package name */
    private iOSOneButtonDialog f19698e1;

    /* renamed from: h1, reason: collision with root package name */
    private long f19701h1;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f19704k0;

    /* renamed from: m1, reason: collision with root package name */
    private LatLng f19707m1;

    /* renamed from: n1, reason: collision with root package name */
    private int f19708n1;

    /* renamed from: o1, reason: collision with root package name */
    private int f19709o1;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f19710p0;

    /* renamed from: u1, reason: collision with root package name */
    private ProgressDialog f19716u1;
    private List<Map<String, Object>> K0 = new ArrayList();
    private List<Map<String, Object>> L0 = new ArrayList();
    private int N0 = 0;
    private int Q0 = 0;
    private boolean S0 = true;
    private boolean T0 = false;
    private List<Marker> Z0 = new ArrayList();

    /* renamed from: f1, reason: collision with root package name */
    private long f19699f1 = 0;

    /* renamed from: g1, reason: collision with root package name */
    private long f19700g1 = System.currentTimeMillis();

    /* renamed from: i1, reason: collision with root package name */
    private long f19702i1 = 0;

    /* renamed from: j1, reason: collision with root package name */
    private float f19703j1 = 0.0f;

    /* renamed from: k1, reason: collision with root package name */
    private List<LatLngTimeSpeed> f19705k1 = new ArrayList();

    /* renamed from: l1, reason: collision with root package name */
    private boolean f19706l1 = false;

    /* renamed from: p1, reason: collision with root package name */
    private List<Integer> f19711p1 = new ArrayList();

    /* renamed from: q1, reason: collision with root package name */
    private BroadcastReceiver f19712q1 = new b();

    /* renamed from: r1, reason: collision with root package name */
    private Map<String, Boolean> f19713r1 = new ArrayMap();

    /* renamed from: s1, reason: collision with root package name */
    private BroadcastReceiver f19714s1 = new c();

    /* renamed from: t1, reason: collision with root package name */
    private Boolean f19715t1 = Boolean.FALSE;

    /* renamed from: v1, reason: collision with root package name */
    private boolean f19717v1 = false;

    /* renamed from: w1, reason: collision with root package name */
    private boolean f19718w1 = false;

    /* renamed from: x1, reason: collision with root package name */
    private boolean f19719x1 = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends TypeReference<ArrayMap<String, Object>> {
        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RunningActivity.f19689y1)) {
                com.orhanobut.logger.j.c("进入电子围栏");
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    extras.getInt("event");
                    String string = extras.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                    extras.getString(GeoFence.BUNDLE_KEY_FENCEID);
                    GeoFence geoFence = (GeoFence) extras.getParcelable(GeoFence.BUNDLE_KEY_FENCE);
                    if (geoFence != null) {
                        com.bxkj.student.run.app.utils.y.f(((BaseActivity) RunningActivity.this).T, R.raw.pass_asses);
                        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(R.mipmap.img_point_must_pass);
                        double latitude = geoFence.getCenter().getLatitude();
                        double longitude = geoFence.getCenter().getLongitude();
                        String str = string.split(",")[0];
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        HashMap hashMap = new HashMap();
                        hashMap.put("id", str);
                        hashMap.put("time", simpleDateFormat.format(new Date()));
                        hashMap.put("latitude", Double.valueOf(latitude));
                        hashMap.put("longitude", Double.valueOf(longitude));
                        if (!RunningActivity.this.n2(hashMap)) {
                            RunningActivity.this.L0.add(hashMap);
                        }
                        MarkerOptions draggable = new MarkerOptions().position(new LatLng(latitude, longitude)).icon(fromResource).zIndex(9.0f).title("你已经通过必经点").draggable(false);
                        for (Marker marker : RunningActivity.this.Z0) {
                            if (marker.getObject().toString().equals(string) && !marker.isRemoved()) {
                                draggable.title(draggable.getTitle() + marker.getTitle().substring(marker.getTitle().indexOf("：")));
                                marker.remove();
                            }
                        }
                        RunningActivity.this.X.addMarker(draggable);
                        RunningActivity.this.f19692a1.removeGeoFence(geoFence);
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            boolean z5;
            if (intent.getAction().equals(RunningActivity.f19690z1) && (extras = intent.getExtras()) != null) {
                int i6 = extras.getInt("event");
                String string = extras.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                Map map = RunningActivity.this.f19713r1;
                boolean z6 = false;
                if (i6 == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                map.put(string, Boolean.valueOf(z5));
                com.orhanobut.logger.j.c("ActionStatus=" + i6);
                Iterator it = RunningActivity.this.f19713r1.keySet().iterator();
                while (it.hasNext()) {
                    if (((Boolean) RunningActivity.this.f19713r1.get((String) it.next())).booleanValue()) {
                        z6 = true;
                    }
                }
                RunningActivity.this.Y2(z6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoadingDialog f19723a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f19724b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19725c;

        d(final LoadingDialog val$loadingDialog, final int val$uploadType, final String val$stepNumbers) {
            this.f19723a = val$loadingDialog;
            this.f19724b = val$uploadType;
            this.f19725c = val$stepNumbers;
        }

        private void a() {
            RunningActivity.this.q2();
            RunningActivity.this.f19697d1.v(RunningActivity.this.V0.getIdentify());
            Toast toast = new Toast(((BaseActivity) RunningActivity.this).T);
            toast.setView(View.inflate(((BaseActivity) RunningActivity.this).T, R.layout.toast_upload, null));
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.show();
            RunningActivity.this.a3(this.f19725c);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            RunningActivity.this.O2(this.f19724b, this.f19725c);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            LoadingDialog loadingDialog = this.f19723a;
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 202) {
                a();
            } else {
                new iOSOneButtonDialog(((BaseActivity) RunningActivity.this).T).setMessage(msg).show();
                RunningActivity.this.U2(false);
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnStart() {
            super.netOnStart();
            this.f19723a.showDefaultStyle("正在上传跑步数据，1分钟内如果上传不成功，会在本地保存数据，请选择其他时间段，选择本地记录进行上传。上传数据这1分钟内，请不要退出或卸载APP，否则数据将丢失。");
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            a();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccessServerError(int code, String errorMessage) {
            super.netOnSuccessServerError(code, errorMessage);
            RunningActivity.this.O2(this.f19724b, this.f19725c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private PolylineOptions f19727a;

        /* renamed from: b, reason: collision with root package name */
        private Polyline f19728b;

        /* renamed from: c, reason: collision with root package name */
        private List<Integer> f19729c;

        /* renamed from: d, reason: collision with root package name */
        private PolylineOptions f19730d;

        /* renamed from: e, reason: collision with root package name */
        private Polyline f19731e;

        /* renamed from: f, reason: collision with root package name */
        List<Polyline> f19732f;

        /* synthetic */ e(RunningActivity runningActivity, y yVar) {
            this();
        }

        private void f(LatLng newLatLng, LatLng lastLatLng, float speed, boolean isPause) {
            if (isPause) {
                Polyline polyline = this.f19731e;
                if (polyline != null) {
                    polyline.setOptions(this.f19730d.add(newLatLng).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)).setDottedLine(true).color(ContextCompat.getColor(((BaseActivity) RunningActivity.this).T, 2131099715)).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)));
                    return;
                }
                this.f19727a = null;
                this.f19728b = null;
                this.f19729c = new ArrayList();
                this.f19730d = new PolylineOptions();
                this.f19731e = RunningActivity.this.X.addPolyline(this.f19730d.add(lastLatLng, newLatLng).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)).setDottedLine(true).color(ContextCompat.getColor(((BaseActivity) RunningActivity.this).T, 2131099715)).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)));
                return;
            }
            this.f19729c.add(Integer.valueOf(com.bxkj.student.run.app.utils.i.r(((BaseActivity) RunningActivity.this).T, speed)));
            Polyline polyline2 = this.f19728b;
            if (polyline2 != null) {
                polyline2.setOptions(this.f19727a.add(newLatLng).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)).colorValues(this.f19729c).useGradient(true).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)).color(com.bxkj.student.run.app.utils.i.r(((BaseActivity) RunningActivity.this).T, speed)));
                return;
            }
            this.f19730d = null;
            this.f19731e = null;
            this.f19727a = new PolylineOptions();
            this.f19728b = RunningActivity.this.X.addPolyline(this.f19727a.add(lastLatLng, newLatLng).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)).colorValues(this.f19729c).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(int i6, Intent intent) {
            if (i6 != -1) {
                if (i6 == 170) {
                    n();
                    return;
                } else {
                    RunningActivity.this.S2();
                    return;
                }
            }
            if (RunningActivity.this.U0 != null && RunningActivity.this.U0.isShowing()) {
                RunningActivity.this.U0.dismiss();
            }
            RunningActivity.this.Q0++;
            com.bxkj.student.run.app.utils.y.f(((BaseActivity) RunningActivity.this).T, R.raw.face_live_success_run_continue);
            new iOSOneButtonDialog(((BaseActivity) RunningActivity.this).T).setMessage("人脸识别成功，请继续跑步").show();
            if (RunningActivity.this.f19718w1) {
                RunningActivity.this.f19698e1.setMessage("您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！").show();
                Intent intent2 = new Intent();
                intent2.setAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
                intent2.putExtra(CrashHianalyticsData.MESSAGE, "您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！");
                RunningActivity.this.sendBroadcast(intent2, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            } else {
                Intent intent3 = new Intent();
                intent3.setAction(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION);
                RunningActivity.this.sendBroadcast(intent3, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            }
            RunningActivity.this.Q2(false);
            if (RunningActivity.this.O0.getFaceDistanceOut() != 0.0d && AMapUtils.calculateLineDistance(RunningActivity.this.f19707m1, RunningActivity.this.R0) > RunningActivity.this.O0.getFaceDistanceOut() * 1000.0d) {
                RunningActivity.this.S0 = false;
            }
        }

        private e() {
            this.f19727a = new PolylineOptions();
            this.f19729c = new ArrayList();
            this.f19730d = new PolylineOptions();
            this.f19732f = new ArrayList();
        }

        private void d(double distance, LatLng latLng) {
            if (RunningActivity.this.P0 != null && RunningActivity.this.Q0 < RunningActivity.this.P0.size() && !RunningActivity.this.f19717v1 && distance >= ((Double) RunningActivity.this.P0.get(RunningActivity.this.Q0)).doubleValue()) {
                RunningActivity.this.R0 = latLng;
                ((Vibrator) RunningActivity.this.getSystemService("vibrator")).vibrate(2000L);
                RunningActivity.this.Q2(true);
                com.bxkj.student.run.app.utils.y.f(((BaseActivity) RunningActivity.this).T, R.raw.run_pause_face_live);
                if (RunningActivity.this.U0 == null) {
                    RunningActivity.this.U0 = new iOSOneButtonDialog(((BaseActivity) RunningActivity.this).T);
                } else {
                    RunningActivity.this.U0.dismiss();
                }
                RunningActivity.this.U0.setClickAutoCancel(false);
                RunningActivity.this.U0.setCancelable(false);
                RunningActivity.this.U0.setCanceledOnTouchOutside(false);
                String str = "跑步已暂停，请在" + Double.valueOf(RunningActivity.this.O0.getFaceDistanceOut() * 1000.0d).intValue() + "米范围内进行人脸识别！";
                Intent intent = new Intent();
                intent.setAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
                intent.putExtra(CrashHianalyticsData.MESSAGE, str);
                RunningActivity.this.sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
                RunningActivity.this.U0.setMessage(str).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RunningActivity.e.this.j(view);
                    }
                });
                RunningActivity.this.U0.show();
            }
        }

        private void e(List<LatLng> latLngs) {
            this.f19732f.add(RunningActivity.this.X.addPolyline(new PolylineOptions().addAll(latLngs).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)).setDottedLine(true).color(ContextCompat.getColor(((BaseActivity) RunningActivity.this).T, 2131099715)).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T))));
        }

        private void g(List<LatLng> latLngs, boolean isPause, List<Integer> colorValues) {
            com.orhanobut.logger.j.c("画线");
            if (isPause) {
                e(latLngs);
            } else {
                h(latLngs, colorValues);
            }
        }

        private void h(List<LatLng> latLngs, List<Integer> colorValues) {
            this.f19732f.add(RunningActivity.this.X.addPolyline(new PolylineOptions().addAll(latLngs).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)).colorValues(colorValues).useGradient(true).zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T))));
        }

        private void i(LatLng startLatLng) {
            if (RunningActivity.this.isFinishing() || RunningActivity.this.isDestroyed()) {
                return;
            }
            if (RunningActivity.this.f19716u1 != null && RunningActivity.this.f19716u1.isShowing()) {
                RunningActivity.this.f19716u1.dismiss();
            }
            if (RunningActivity.this.G0.getVisibility() != 0) {
                RunningActivity.this.G0.setVisibility(0);
            }
            RunningActivity.this.W2();
            RunningActivity.this.m2(startLatLng);
            RunningActivity.this.k2();
            this.f19729c.add(Integer.valueOf(ContextCompat.getColor(((BaseActivity) RunningActivity.this).T, R.color.speed1)));
            try {
                if (this.f19727a == null) {
                    this.f19727a = new PolylineOptions();
                }
                this.f19728b = RunningActivity.this.X.addPolyline(this.f19727a.add(startLatLng).width(cn.bluemobi.dylan.base.utils.u.a(5.0f, ((BaseActivity) RunningActivity.this).T)).colorValues(this.f19729c).useGradient(false).zIndex(10.0f));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            RunningActivity.this.J0.include(startLatLng).build();
            RunningActivity.this.X.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(startLatLng, 18.0f)), 1000L, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ n1 l() {
            Intent intent = RunningActivity.this.getIntent().setClass(((BaseActivity) RunningActivity.this).T, FaceDetectExpActivity.class);
            intent.putExtra("identify", RunningActivity.this.O0.getIdentify());
            new u.b(((BaseActivity) RunningActivity.this).U).startActivityForResult(intent).c(new b.a() { // from class: com.bxkj.student.run.app.w
                @Override // u.b.a
                public final void a(int i6, Intent intent2) {
                    RunningActivity.e.this.k(i6, intent2);
                }
            });
            RunningActivity.this.overridePendingTransition(2130771987, 2130771986);
            return null;
        }

        private void m(long countTime) {
            if (countTime % 60 == 0) {
                long j6 = countTime / 60;
                int i6 = RunningActivity.this.f19708n1 - RunningActivity.this.f19709o1;
                if (i6 < 0) {
                    i6 = 0;
                }
                if (RunningActivity.this.f19711p1.size() < j6) {
                    RunningActivity.this.f19711p1.add(Integer.valueOf(i6));
                } else {
                    RunningActivity.this.f19711p1.set(RunningActivity.this.f19711p1.size() - 1, Integer.valueOf(((Integer) RunningActivity.this.f19711p1.get(RunningActivity.this.f19711p1.size() - 1)).intValue() + i6));
                }
                RunningActivity runningActivity = RunningActivity.this;
                runningActivity.f19709o1 = runningActivity.f19708n1;
            }
        }

        private void n() {
            com.bxkj.base.v2.common.ext.b0.x(((BaseActivity) RunningActivity.this).U, "人脸识别", new Function0() { // from class: com.bxkj.student.run.app.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 l6;
                    l6 = RunningActivity.e.this.l();
                    return l6;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(View view) {
            n();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RunBroadcastActionType.GET_FIRST_LOCATION_SUCCESS)) {
                if (intent.hasExtra("latLng")) {
                    LatLng latLng = (LatLng) intent.getParcelableExtra("latLng");
                    if (RunningActivity.this.Y0 != null) {
                        RunningActivity.this.Y0.include(latLng);
                    }
                    RunningActivity.this.X.animateCamera(CameraUpdateFactory.newLatLngBounds(RunningActivity.this.Y0.build(), cn.bluemobi.dylan.base.utils.u.a(50.0f, ((BaseActivity) RunningActivity.this).T)), 1000L, null);
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.ADD_START_POINT)) {
                com.orhanobut.logger.j.c("起始点定位成功");
                if (intent.hasExtra(AnalyticsConfig.RTD_START_TIME)) {
                    RunningActivity.this.f19700g1 = intent.getLongExtra(AnalyticsConfig.RTD_START_TIME, System.currentTimeMillis());
                }
                if (intent.hasExtra("latLngTimeSpeed")) {
                    RunningActivity.this.f19705k1.add((LatLngTimeSpeed) intent.getParcelableExtra("latLngTimeSpeed"));
                }
                if (intent.hasExtra("latLng")) {
                    i((LatLng) intent.getParcelableExtra("latLng"));
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.ADD_OLD_LINE)) {
                if (intent.hasExtra("countTime")) {
                    RunningActivity.this.f19702i1 = intent.getLongExtra("countTime", 0L);
                    RunningActivity.this.f19693b0.setText(com.bxkj.student.run.app.utils.i.g(RunningActivity.this.f19702i1));
                }
                if (intent.hasExtra("distance")) {
                    RunningActivity.this.f19703j1 = intent.getFloatExtra("distance", 0.0f);
                    RunningActivity.this.f19695c0.setText(com.bxkj.student.run.app.utils.i.d(RunningActivity.this.f19703j1));
                }
                if (intent.hasExtra("avgSpeed")) {
                    RunningActivity.this.f19704k0.setText(intent.getStringExtra("avgSpeed"));
                }
                if (intent.hasExtra("pace")) {
                    RunningActivity.this.f19710p0.setText(intent.getStringExtra("pace"));
                }
                if (intent.hasExtra("latLngTimeSpeedList")) {
                    RunningActivity.this.f19705k1 = intent.getParcelableArrayListExtra("latLngTimeSpeedList");
                    for (int i6 = 1; i6 < RunningActivity.this.f19705k1.size(); i6++) {
                        LatLngTimeSpeed latLngTimeSpeed = (LatLngTimeSpeed) RunningActivity.this.f19705k1.get(i6 - 1);
                        LatLngTimeSpeed latLngTimeSpeed2 = (LatLngTimeSpeed) RunningActivity.this.f19705k1.get(i6);
                        f(new LatLng(latLngTimeSpeed2.getLatitude(), latLngTimeSpeed2.getLongitude()), new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude()), latLngTimeSpeed2.getSpeed(), latLngTimeSpeed2.isPuase());
                    }
                    i(new LatLng(((LatLngTimeSpeed) RunningActivity.this.f19705k1.get(0)).getLatitude(), ((LatLngTimeSpeed) RunningActivity.this.f19705k1.get(0)).getLongitude()));
                    this.f19728b = null;
                    this.f19731e = null;
                }
                if (intent.hasExtra(AnalyticsConfig.RTD_START_TIME)) {
                    RunningActivity.this.f19700g1 = intent.getLongExtra(AnalyticsConfig.RTD_START_TIME, System.currentTimeMillis());
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.ADD_LINE)) {
                RunningActivity.this.N2();
                if (intent.hasExtra("latLngTimeSpeed")) {
                    RunningActivity.this.f19705k1.add((LatLngTimeSpeed) intent.getParcelableExtra("latLngTimeSpeed"));
                }
                if (intent.hasExtra("distance")) {
                    RunningActivity.this.f19703j1 = intent.getFloatExtra("distance", 0.0f);
                }
                String d6 = com.bxkj.student.run.app.utils.i.d(RunningActivity.this.f19703j1);
                RunningActivity.this.f19695c0.setText(d6);
                if (intent.hasExtra("currentLatLng")) {
                    d(Double.parseDouble(d6), (LatLng) intent.getParcelableExtra("currentLatLng"));
                }
                if (intent.hasExtra("avgSpeed")) {
                    RunningActivity.this.f19704k0.setText(intent.getStringExtra("avgSpeed"));
                }
                if (intent.hasExtra("pace")) {
                    RunningActivity.this.f19710p0.setText(intent.getStringExtra("pace"));
                }
                if (intent.hasExtra("currentLatLng") && intent.hasExtra("lastLatLng") && intent.hasExtra("speed") && intent.hasExtra("isPause")) {
                    LatLng latLng2 = (LatLng) intent.getParcelableExtra("currentLatLng");
                    f(latLng2, (LatLng) intent.getParcelableExtra("lastLatLng"), intent.getFloatExtra("speed", 0.0f), intent.getBooleanExtra("isPause", false));
                    RunningActivity.this.J0.include(latLng2).build();
                    if (System.currentTimeMillis() - RunningActivity.this.f19699f1 > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                        RunningActivity.this.X.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng2, 18.0f)), 500L, null);
                        return;
                    }
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.SAVE_LOCAL_DB)) {
                RunningActivity.this.N2();
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.TIME_CHANGE)) {
                if (intent.hasExtra("countTime")) {
                    RunningActivity.this.f19702i1 = intent.getLongExtra("countTime", 0L);
                    RunningActivity.this.f19693b0.setText(com.bxkj.student.run.app.utils.i.g(RunningActivity.this.f19702i1));
                    m(RunningActivity.this.f19702i1);
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.UPDATE_GPS_STATUS)) {
                if (intent.hasExtra("gpsStatus") && intent.hasExtra("gpsStatusImage")) {
                    String stringExtra = intent.getStringExtra("gpsStatus");
                    RunningActivity.this.Y.setImageResource(intent.getIntExtra("gpsStatusImage", 0));
                    RunningActivity.this.Z.setText(stringExtra);
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.UPDATE_STEP)) {
                if (intent.hasExtra("stepCount")) {
                    RunningActivity.this.f19708n1 = intent.getIntExtra("stepCount", 0);
                    RunningActivity.this.F0.setText(String.valueOf(RunningActivity.this.f19708n1));
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.CURRENT_LATLNG)) {
                Bundle extras = intent.getExtras();
                if (extras.containsKey("latLng")) {
                    try {
                        RunningActivity.this.f19707m1 = (LatLng) extras.get("latLng");
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D2() {
        U2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E2() {
        r2(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2() {
        U2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G2() {
        r2(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean J2(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
        if (i6 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        s0();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(int i6, int i7, Intent intent) {
        if (i7 == -1) {
            this.T0 = true;
            r2(i6);
        } else if (i7 == 170) {
            Z2(i6);
        } else {
            U2(false);
        }
    }

    public static /* synthetic */ n1 t0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2() {
        U2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2() {
        r2(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y2() {
        U2(true);
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.T);
        iostwobuttondialog.setTitle("提示").setMessage("确定要结束跑步吗？").setLeftButtonText("继续").setRightButtonText("结束").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.k
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                RunningActivity.this.w2();
            }
        }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.l
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                RunningActivity.this.x2();
            }
        }).show();
        iostwobuttondialog.setCancelable(false);
    }

    public String o2(long size) {
        if (size >= IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return String.format("%.1f GB", Float.valueOf(size / IjkMediaMeta.AV_CH_STEREO_RIGHT));
        }
        if (size >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            float f6 = size / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            return String.format(f6 > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f6));
        }
        if (size < 1024) {
            return String.format("%d B", Long.valueOf(size));
        }
        float f7 = size / 1024;
        return String.format(f7 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f7));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed, reason: merged with bridge method [inline-methods] */
    public void z2() {
        try {
            U2(true);
            iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.T);
            iostwobuttondialog.setCancelable(false);
            if (this.O0.getRunType() == 3) {
                iostwobuttondialog.setTitle("提示").setMessage("确定要取消本次跑步吗？").setLeftButtonText("继续跑步").setRightButtonText("确定取消").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.q
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                    public final void buttonLeftOnClick() {
                        RunningActivity.this.D2();
                    }
                }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.r
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        RunningActivity.this.E2();
                    }
                }).show();
                return;
            }
            iostwobuttondialog.setTitle("确定要取消本次跑步吗？").setMessage("今天剩余可跑步次数" + this.N0 + "次").setLeftButtonText("继续跑步").setRightButtonText("确定取消").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.s
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                public final void buttonLeftOnClick() {
                    RunningActivity.this.F2();
                }
            }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.t
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    RunningActivity.this.G2();
                }
            }).show();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2(View view) {
        iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.T);
        iosonebuttondialog.setTitle("请刷码");
        iosonebuttondialog.setCenterCustomView(R.layout.dialog_qr_code);
        iosonebuttondialog.setOneButtonText("关闭");
        iosonebuttondialog.setMessageGrivity(17);
        ((ImageView) iosonebuttondialog.findViewById(R.id.iv_qr)).setImageBitmap(new com.bxkj.base.v2.common.qrcode.b(this.U).f(LoginUser.getLoginUser().getAccount(), 2131689689));
        iosonebuttondialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 B2(List list) {
        if (list == null || list.size() <= 0) {
            u2();
            return null;
        }
        int i6 = 0;
        RunDb runDb = (RunDb) list.get(0);
        this.V0 = runDb;
        this.O0 = (RunRoleSetBean.DataBean) JSON.parseObject(runDb.getSportsSet(), RunRoleSetBean.DataBean.class);
        if (Long.parseLong(this.V0.getCountTime()) != 0) {
            try {
                this.f19711p1 = JSON.parseArray(this.V0.getStepList(), Integer.class);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        if (this.f19711p1 == null) {
            this.f19711p1 = new ArrayList();
        }
        Iterator<Integer> it = this.f19711p1.iterator();
        while (it.hasNext()) {
            i6 += it.next().intValue();
        }
        this.L0 = JsonParse.jsonToListMap(this.V0.getUserPassPointList());
        this.F0.setText(String.valueOf(i6));
        this.f19708n1 = i6;
        this.f19709o1 = i6;
        if (!TextUtils.isEmpty(this.V0.getFaceDetectCount())) {
            this.Q0 = Integer.parseInt(this.V0.getFaceDetectCount());
        }
        t2();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C2() {
        startActivity(new Intent(this.T, (Class<?>) RunSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 L2(final int i6) {
        new u.b(this.U).startActivityForResult(new Intent(this.T, (Class<?>) FaceDetectExpActivity.class).putExtra("identify", this.O0.getIdentify())).c(new b.a() { // from class: com.bxkj.student.run.app.f
            @Override // u.b.a
            public final void a(int i7, Intent intent) {
                RunningActivity.this.K2(i6, i7, intent);
            }
        });
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    private void M2() {
        this.X0 = new e(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RunBroadcastActionType.GET_FIRST_LOCATION_SUCCESS);
        intentFilter.addAction(RunBroadcastActionType.ADD_START_POINT);
        intentFilter.addAction(RunBroadcastActionType.ADD_OLD_LINE);
        intentFilter.addAction(RunBroadcastActionType.ADD_LINE);
        intentFilter.addAction(RunBroadcastActionType.SAVE_LOCAL_DB);
        intentFilter.addAction(RunBroadcastActionType.TIME_CHANGE);
        intentFilter.addAction(RunBroadcastActionType.UPDATE_GPS_STATUS);
        intentFilter.addAction(RunBroadcastActionType.UPDATE_STEP);
        intentFilter.addAction(RunBroadcastActionType.CURRENT_LATLNG);
        registerReceiver(this.X0, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        this.V0.setDistance(String.valueOf(this.f19703j1));
        this.V0.setCountTime(String.valueOf(this.f19702i1));
        this.V0.setStartTime(String.valueOf(this.f19700g1));
        this.V0.setLatLngList(JSON.toJSONString(this.f19705k1));
        this.V0.setPassLatLngList(JSON.toJSONString(this.K0));
        this.V0.setUserPassPointList(JSON.toJSONString(this.L0));
        this.V0.setStepList(JSON.toJSONString(s2()));
        this.V0.setFaceOut(this.S0 ? "0" : "1");
        this.V0.setFaceDetectCount(String.valueOf(this.Q0));
        this.f19697d1.z(this.V0);
    }

    private void P2(boolean isPause) {
        this.f19718w1 = isPause;
        S2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2(boolean isPause) {
        this.f19717v1 = isPause;
        S2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2() {
        boolean z5 = this.f19717v1 || this.f19718w1 || this.f19719x1;
        this.f19706l1 = z5;
        R2(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2(boolean isPause) {
        this.f19719x1 = isPause;
        S2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2() {
        if (com.bxkj.base.util.a0.a(this.T, StepService.class.getName())) {
            com.orhanobut.logger.j.c("LocationService---isRunning");
            stopService(new Intent(this.T, (Class<?>) StepService.class));
        }
        Intent intent = new Intent(this, (Class<?>) StepService.class);
        intent.putExtra("runType", this.O0.getRunType());
        intent.putExtra("isPause", this.f19706l1);
        intent.putExtra("runExceptionDataDB", this.V0);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2(boolean isIn) {
        if (this.f19698e1 == null) {
            this.f19698e1 = new iOSOneButtonDialog(this.T);
        }
        if (isIn && this.f19715t1.booleanValue()) {
            if (this.f19717v1) {
                String str = "跑步已暂停，请在" + Double.valueOf(this.O0.getFaceDistanceOut() * 1000.0d).intValue() + "米范围内进行人脸识别！";
                this.f19698e1.setMessage(str).show();
                Intent intent = new Intent();
                intent.setAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
                intent.putExtra(CrashHianalyticsData.MESSAGE, str);
                sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            } else {
                Intent intent2 = new Intent();
                intent2.setAction(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION);
                sendBroadcast(intent2, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            }
            P2(false);
            com.bxkj.student.run.app.utils.y.f(this.T, R.raw.geofence_in);
            com.orhanobut.logger.j.c("ActionStatus=在地理围栏里面");
            if (this.f19698e1.isShowing()) {
                this.f19698e1.dismiss();
            } else {
                this.f19698e1.setMessage("您已进入跑步规定区域，跑步已恢复，请继续进行跑步！").show();
            }
        } else if (!isIn) {
            if (this.f19698e1.isShowing()) {
                this.f19698e1.dismiss();
            }
            com.orhanobut.logger.j.c("ActionStatus=在地理围栏外面");
            P2(true);
            com.bxkj.student.run.app.utils.y.f(this.T, R.raw.geofence_out);
            ((Vibrator) getSystemService("vibrator")).vibrate(2000L);
            String str2 = "您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！";
            if (this.f19717v1) {
                str2 = "跑步已暂停，请在" + Double.valueOf(this.O0.getFaceDistanceOut() * 1000.0d).intValue() + "米范围内进行人脸识别！\n您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！";
            }
            this.f19698e1.setMessage(str2).show();
            Intent intent3 = new Intent();
            intent3.setAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
            intent3.putExtra(CrashHianalyticsData.MESSAGE, str2);
            sendBroadcast(intent3, "com.bxkj.student.sports.permissions.MY_BROADCAST");
        }
        this.f19715t1 = Boolean.valueOf(!isIn);
    }

    private void Z2(final int uploadType) {
        com.bxkj.base.v2.common.ext.b0.x(this.U, "人脸识别", new Function0() { // from class: com.bxkj.student.run.app.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 L2;
                L2 = RunningActivity.this.L2(uploadType);
                return L2;
            }
        });
    }

    private void b3() {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.STOP_LOCATION);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void c3(int uploadType) {
        U2(true);
        N2();
        this.f19701h1 = System.currentTimeMillis();
        String jSONString = JSON.toJSONString(s2());
        LoadingDialog loadingDialog = new LoadingDialog(this.T);
        loadingDialog.setOnKeyListener(new DialogOnKeyListener(loadingDialog, false));
        String charSequence = this.f19693b0.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = com.bxkj.student.run.app.utils.i.g(this.f19702i1);
        }
        String str = charSequence;
        String charSequence2 = this.f19695c0.getText().toString();
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = com.bxkj.student.run.app.utils.i.d(this.f19703j1);
        }
        String str2 = charSequence2;
        String charSequence3 = this.f19704k0.getText().toString();
        if (TextUtils.isEmpty(charSequence3)) {
            charSequence3 = com.bxkj.student.run.app.utils.i.a(this.f19703j1, this.f19702i1);
        }
        String str3 = charSequence3;
        String charSequence4 = this.f19710p0.getText().toString();
        if (TextUtils.isEmpty(charSequence4)) {
            charSequence4 = com.bxkj.student.run.app.utils.i.b(this.f19703j1, this.f19702i1);
        }
        String str4 = charSequence4;
        try {
            List<LatLngTimeSpeed> list = this.f19705k1;
            if (list != null && list.size() > 2) {
                this.f19705k1 = new com.bxkj.student.run.app.utils.o().k(this.f19705k1);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        Http.with(this.T).hideLoadingDialog().setCanCancel(false).hideFailMessage().hideOtherStatusMessage().hideSuccessMessage().setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).l(LoginUser.getLoginUser().getUserId(), this.O0.getRunType(), this.f19700g1, this.f19701h1, JSON.toJSONString(this.f19705k1), this.O0.getIdentify(), str, str2, str3, str4, JSON.toJSONString(this.K0), com.bxkj.base.util.b0.d(), com.bxkj.base.util.b0.e(), com.bxkj.base.util.b0.f(), com.bxkj.base.util.b0.c(), com.bxkj.base.util.b0.h(this.T), jSONString, this.S0 ? "0" : "1", JSON.toJSONString(this.L0), Integer.valueOf(uploadType), null)).setDataListener(new d(loadingDialog, uploadType, jSONString));
    }

    public static /* synthetic */ void j0(List list, int i6, String str) {
        if (i6 == 0) {
            com.orhanobut.logger.j.c("添加围栏成功!!");
        } else {
            com.orhanobut.logger.j.c("添加围栏失败!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2() {
        List<RunRoleSetBean.DataBean.GeofenceBean> list;
        if (this.O0.getGeofence() == null || this.O0.getGeofence().isEmpty()) {
            return;
        }
        GeoFenceClient geoFenceClient = new GeoFenceClient(StubApp.getOrigApplicationContext(getApplicationContext()));
        this.f19694b1 = geoFenceClient;
        geoFenceClient.setActivateAction(3);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.O0.getGeofence().size() && (list = this.O0.getGeofence().get(i6)) != null; i6++) {
            ArrayList arrayList2 = new ArrayList();
            for (RunRoleSetBean.DataBean.GeofenceBean geofenceBean : list) {
                arrayList2.add(new DPoint(Double.parseDouble(geofenceBean.getLat()), Double.parseDouble(geofenceBean.getLng())));
            }
            arrayList.add(arrayList2);
            String str = "runGeoFenceId" + i6;
            this.f19713r1.put(str, Boolean.TRUE);
            this.f19694b1.addGeoFence(arrayList2, str);
        }
        p2(arrayList);
        this.f19694b1.setGeoFenceListener(new GeoFenceListener() { // from class: com.bxkj.student.run.app.o
            @Override // com.amap.api.fence.GeoFenceListener
            public final void onGeoFenceCreateFinished(List list2, int i7, String str2) {
                RunningActivity.u0(list2, i7, str2);
            }
        });
        this.f19694b1.createPendingIntent(f19690z1);
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(f19690z1);
        this.f19696c1 = registerReceiver(this.f19714s1, intentFilter);
    }

    private void l2() {
        BitmapDescriptor fromResource;
        String str;
        List<Map<String, Object>> list = this.K0;
        if (list == null || list.size() == 0) {
            return;
        }
        GeoFenceClient geoFenceClient = new GeoFenceClient(StubApp.getOrigApplicationContext(getApplicationContext()));
        this.f19692a1 = geoFenceClient;
        geoFenceClient.setActivateAction(1);
        for (Map<String, ? extends Object> map : this.K0) {
            double d6 = JsonParse.getDouble(map, "latitude");
            double d7 = JsonParse.getDouble(map, "longitude");
            int i6 = JsonParse.getInt(map, "isMustPoint");
            LatLng latLng = new LatLng(d6, d7);
            if (n2(map)) {
                this.X.addMarker(new MarkerOptions().position(new LatLng(d6, d7)).icon(BitmapDescriptorFactory.fromResource(R.mipmap.img_point_must_pass)).zIndex(9.0f).title("你已经通过必经点:" + com.bxkj.base.v2.common.utils.c0.f16887a.t(map, "content")).draggable(false));
            } else {
                if (i6 == 1) {
                    fromResource = BitmapDescriptorFactory.fromResource(R.mipmap.img_point_must_normal);
                    str = "必经点：";
                } else {
                    fromResource = BitmapDescriptorFactory.fromResource(R.mipmap.xjd_location);
                    str = "选经点：";
                }
                String string = JsonParse.getString(map, "content");
                Marker addMarker = this.X.addMarker(new MarkerOptions().position(latLng).icon(fromResource).zIndex(9.0f).title(str + string).draggable(false));
                String str2 = JsonParse.getString(map, "id") + "," + i6;
                addMarker.setObject(str2);
                this.Z0.add(addMarker);
                this.f19692a1.addGeoFence(new DPoint(d6, d7), JsonParse.getInt(map, "okRadius"), str2);
                this.Y0.include(latLng);
            }
        }
        this.X.animateCamera(CameraUpdateFactory.newLatLngBounds(this.Y0.build(), cn.bluemobi.dylan.base.utils.u.a(10.0f, this.T)), 2000L, null);
        this.f19692a1.setGeoFenceListener(new GeoFenceListener() { // from class: com.bxkj.student.run.app.p
            @Override // com.amap.api.fence.GeoFenceListener
            public final void onGeoFenceCreateFinished(List list2, int i7, String str3) {
                RunningActivity.j0(list2, i7, str3);
            }
        });
        this.f19692a1.createPendingIntent(f19689y1);
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(f19689y1);
        this.M0 = registerReceiver(this.f19712q1, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n2(Map<String, Object> stringObjectMap) {
        double d6 = JsonParse.getDouble(stringObjectMap, "latitude");
        double d7 = JsonParse.getDouble(stringObjectMap, "longitude");
        boolean z5 = false;
        for (Map<String, Object> map : this.L0) {
            double d8 = JsonParse.getDouble(map, "latitude");
            double d9 = JsonParse.getDouble(map, "longitude");
            if (d8 == d6 && d9 == d7) {
                z5 = true;
            }
        }
        return z5;
    }

    private void p2(List<List<DPoint>> pointList) {
        if (pointList == null || pointList.isEmpty()) {
            return;
        }
        for (List<DPoint> list : pointList) {
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                PolygonOptions polygonOptions = new PolygonOptions();
                for (DPoint dPoint : list) {
                    arrayList.add(new LatLng(dPoint.getLatitude(), dPoint.getLongitude()));
                }
                polygonOptions.addAll(arrayList);
                polygonOptions.fillColor(this.T.getResources().getColor(R.color.fill));
                polygonOptions.strokeColor(this.T.getResources().getColor(R.color.stroke));
                polygonOptions.strokeWidth(4.0f);
                this.X.addPolygon(polygonOptions);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2() {
        this.X.getMyLocationStyle().myLocationType(7);
        b3();
        this.f19701h1 = System.currentTimeMillis();
        List<LatLngTimeSpeed> list = this.f19705k1;
        if (list != null && list.size() > 0) {
            BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_end);
            com.orhanobut.logger.j.c("latLngList=" + this.f19705k1.size());
            List<LatLngTimeSpeed> list2 = this.f19705k1;
            LatLngTimeSpeed latLngTimeSpeed = list2.get(list2.size() - 1);
            this.X.addMarker(new MarkerOptions().position(new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude())).icon(fromResource).zIndex(9.0f).draggable(true));
        }
        this.X.animateCamera(CameraUpdateFactory.newLatLngBounds(this.J0.build(), cn.bluemobi.dylan.base.utils.u.a(50.0f, this.T)), 2000L, null);
    }

    private void r2(int uploadType) {
        if (this.O0.getRunType() == 4) {
            c3(uploadType);
            return;
        }
        if (this.L0.size() >= this.K0.size()) {
            if (this.O0.getIsEndFace() <= 0 || this.T0) {
                c3(uploadType);
                return;
            } else {
                Z2(uploadType);
                return;
            }
        }
        U2(false);
        new iOSOneButtonDialog(this.T).setMessage("必须经过" + this.K0.size() + "个必经点").show();
    }

    private void t2() {
        try {
            if (com.bxkj.base.util.a0.a(this.T, LocationService.class.getName())) {
                com.orhanobut.logger.j.c("LocationService----------isServiceRunning");
                stopService(new Intent(this.T, (Class<?>) LocationService.class));
            }
            if (com.bxkj.base.util.a0.a(this.T, StepService.class.getName())) {
                com.orhanobut.logger.j.c("StepService----------isServiceRunning");
                stopService(new Intent(this.T, (Class<?>) StepService.class));
            }
            T2();
            v2();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static /* synthetic */ void u0(List list, int i6, String str) {
        if (i6 == 0) {
            com.orhanobut.logger.j.c("添加跑步范围围栏成功!!");
        } else {
            com.orhanobut.logger.j.c("添加跑步范围围栏失败!!");
        }
    }

    private void u2() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        if (com.bxkj.base.util.a0.a(this.T, LocationService.class.getName())) {
            com.orhanobut.logger.j.c("LocationService----------isServiceRunning");
            stopService(new Intent(this.T, (Class<?>) LocationService.class));
        }
        if (com.bxkj.base.util.a0.a(this.T, StepService.class.getName())) {
            com.orhanobut.logger.j.c("LocationService----------isServiceRunning");
            stopService(new Intent(this.T, (Class<?>) StepService.class));
        }
        finish();
    }

    private void v2() {
        if (this.O0 == null) {
            u2();
        }
        for (Map<String, Object> map : JsonParse.getList((ArrayMap) JSON.parseObject(JSON.toJSONString(this.O0), new a().getType(), new Feature[0]), "list")) {
            if (JsonParse.getInt(map, "isMustPoint") == 1) {
                this.K0.add(map);
            }
        }
        this.N0 = this.O0.getSurplusNum();
        if (this.O0.getIsClock() > 0) {
            this.I0.setVisibility(0);
        }
        this.P0 = this.O0.getMiddleFaces();
        if (!this.O0.getContext().isEmpty()) {
            this.f19691a0.setVisibility(0);
            this.f19691a0.setText(this.O0.getContext());
        }
        this.Y0 = LatLngBounds.builder();
        V2();
        l2();
        X2("GPS信号弱或位置精确度较低,请在室外空旷的地方进行跑步,否则将可能影响您的跑步轨迹记录不准确。如果长时间不能定位，请重启手机后重试！");
        if (TextUtils.isEmpty(this.O0.getContext())) {
            return;
        }
        new iOSOneButtonDialog(this.T).setMessageGrivity(3).setMessage(this.O0.getContext()).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.H0.setOnFinishListener(new LongPressToFinishButton.OnFinishListener() { // from class: com.bxkj.student.run.app.g
            @Override // com.bxkj.student.common.view.LongPressToFinishButton.OnFinishListener
            public final void onFinish() {
                RunningActivity.this.y2();
            }
        });
        Y(new BaseActivity.c() { // from class: com.bxkj.student.run.app.h
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                RunningActivity.this.z2();
            }
        });
        this.I0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunningActivity.this.A2(view);
            }
        });
    }

    public void R2(boolean isPause) {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.SET_RUNNING_PAUSE);
        intent.putExtra("isPause", isPause);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W0 = new com.bxkj.student.run.app.utils.g();
        if (getIntent().hasExtra("runExceptionDataDBId")) {
            String stringExtra = getIntent().getStringExtra("runExceptionDataDBId");
            if (TextUtils.isEmpty(stringExtra)) {
                u2();
                return;
            } else {
                this.f19697d1.w(stringExtra, new Function1() { // from class: com.bxkj.student.run.app.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 B2;
                        B2 = RunningActivity.this.B2((List) obj);
                        return B2;
                    }
                });
                return;
            }
        }
        if (!getIntent().hasExtra("dataBean")) {
            u2();
            return;
        }
        RunRoleSetBean.DataBean dataBean = (RunRoleSetBean.DataBean) getIntent().getParcelableExtra("dataBean");
        this.O0 = dataBean;
        if (dataBean == null || TextUtils.isEmpty(dataBean.getIdentify())) {
            u2();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (getIntent().hasExtra(AnalyticsConfig.RTD_START_TIME)) {
            currentTimeMillis = getIntent().getLongExtra(AnalyticsConfig.RTD_START_TIME, System.currentTimeMillis());
            com.orhanobut.logger.j.c("跑步开始时间=" + com.bxkj.student.run.app.utils.i.h(currentTimeMillis, null));
        }
        RunDb runDb = new RunDb(this.O0.getIdentify(), LoginUser.getLoginUser().getAccount(), String.valueOf(this.O0.getRunType()), JSON.toJSONString(this.O0), String.valueOf(currentTimeMillis), "", "0", "0", "", "", "", "", "0", "0", "-1");
        this.V0 = runDb;
        this.f19697d1.z(runDb);
        t2();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("跑步中");
        a0(2131690065, new BaseActivity.c() { // from class: com.bxkj.student.run.app.d
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                RunningActivity.this.C2();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        try {
            this.T = this;
            MapView mapView = (MapView) findViewById(R.id.map);
            this.W = mapView;
            mapView.onCreate(savedInstanceState);
            this.X = this.W.getMap();
            this.Y = (ImageView) findViewById(R.id.iv_gps_state);
            this.Z = (TextView) findViewById(R.id.tv_gps_tips);
            this.f19693b0 = (TextView) findViewById(2131299158);
            this.f19695c0 = (TextView) findViewById(2131298881);
            this.f19704k0 = (TextView) findViewById(R.id.tv_speed);
            this.f19710p0 = (TextView) findViewById(R.id.tv_peisu);
            LinearLayout linearLayout = (LinearLayout) findViewById(2131298015);
            this.G0 = linearLayout;
            linearLayout.setVisibility(4);
            this.H0 = (LongPressToFinishButton) findViewById(R.id.bt_stop);
            this.I0 = (Button) findViewById(R.id.bt_card);
            this.f19691a0 = (MarqueeTextView) findViewById(2131298879);
            this.F0 = (TextView) findViewById(2131299117);
            if (savedInstanceState != null && savedInstanceState.containsKey("runExceptionDataDBId")) {
                getIntent().putExtra("runExceptionDataDBId", savedInstanceState.getString("runExceptionDataDBId"));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.f19697d1 = (RunVM) new ViewModelProvider(this).get(RunVM.class);
    }

    public void X2(String str) {
        if (this.f19716u1 == null) {
            this.f19716u1 = new ProgressDialog(this);
        }
        this.f19716u1.setMessage(str);
        this.f19716u1.setCanceledOnTouchOutside(false);
        this.f19716u1.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.run.app.c
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                boolean J2;
                J2 = RunningActivity.this.J2(dialogInterface, i6, keyEvent);
                return J2;
            }
        });
        this.f19716u1.show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            ProgressDialog progressDialog = this.f19716u1;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f19716u1.dismiss();
            }
            this.W.onDestroy();
            GeoFenceClient geoFenceClient = this.f19692a1;
            if (geoFenceClient != null) {
                geoFenceClient.removeGeoFence();
            }
            if (this.M0 != null) {
                unregisterReceiver(this.f19712q1);
            }
            GeoFenceClient geoFenceClient2 = this.f19694b1;
            if (geoFenceClient2 != null) {
                geoFenceClient2.removeGeoFence();
            }
            if (this.f19696c1 != null) {
                unregisterReceiver(this.f19714s1);
            }
            e eVar = this.X0;
            if (eVar != null) {
                unregisterReceiver(eVar);
            }
            if (com.bxkj.base.util.a0.a(this.T, LocationService.class.getName())) {
                com.orhanobut.logger.j.c("stopService(new Intent(mContext, LocationService.class))");
                stopService(new Intent(this.T, (Class<?>) LocationService.class));
            }
            if (com.bxkj.base.util.a0.a(this.T, StepService.class.getName())) {
                com.orhanobut.logger.j.c("stopService(new Intent(mContext, StepService.class))");
                stopService(new Intent(this.T, (Class<?>) StepService.class));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.W0.c();
        super.onPause();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        this.W.onSaveInstanceState(outState);
        RunDb runDb = this.V0;
        if (runDb != null) {
            outState.putString("runExceptionDataDBId", runDb.getIdentify());
        }
        super.onSaveInstanceState(outState);
    }

    public List<Integer> s2() {
        long j6 = this.f19702i1;
        long j7 = (j6 / 60) + (j6 % 60 == 0 ? 0 : 1);
        ArrayList arrayList = new ArrayList(this.f19711p1);
        int i6 = this.f19708n1;
        int i7 = i6 - this.f19709o1;
        if (i6 < 0) {
            this.f19708n1 = 0;
        }
        if (arrayList.size() < j7) {
            arrayList.add(Integer.valueOf(i7));
            return arrayList;
        }
        if (arrayList.size() == 0) {
            arrayList.add(Integer.valueOf(i7));
            return arrayList;
        }
        arrayList.set(arrayList.size() - 1, Integer.valueOf(((Integer) arrayList.get(arrayList.size() - 1)).intValue() + i7));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H2(String str, View view) {
        a3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I2(MotionEvent motionEvent) {
        this.f19699f1 = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O2(int uploadType, final String stepNumbers) {
        q2();
        this.V0.setUploadType(String.valueOf(uploadType));
        this.f19697d1.D(this.V0, new Function0() { // from class: com.bxkj.student.run.app.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RunningActivity.t0();
            }
        });
        iOSOneButtonDialog message = new iOSOneButtonDialog(this.T).setMessage("提交异常，已为您暂存本地，请稍后在本地跑步记录中重新上传！");
        message.setCancelable(false);
        message.setCanceledOnTouchOutside(false);
        message.show();
        message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunningActivity.this.H2(stepNumbers, view);
            }
        });
    }

    private void T2() {
        this.J0 = LatLngBounds.builder();
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.mipmap.location_marker));
        myLocationStyle.strokeColor(ViewCompat.MEASURED_STATE_MASK);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        myLocationStyle.strokeWidth(1.0f);
        myLocationStyle.myLocationType(6);
        this.X.setMyLocationStyle(myLocationStyle);
        this.X.getUiSettings().setMyLocationButtonEnabled(true);
        this.X.setMyLocationEnabled(true);
        this.X.moveCamera(CameraUpdateFactory.zoomTo(18.0f));
        this.X.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
        this.X.setOnMapTouchListener(new AMap.OnMapTouchListener() { // from class: com.bxkj.student.run.app.e
            @Override // com.amap.api.maps.AMap.OnMapTouchListener
            public final void onTouch(MotionEvent motionEvent) {
                RunningActivity.this.I2(motionEvent);
            }
        });
    }

    private void V2() {
        M2();
        if (com.bxkj.base.util.a0.a(this.T, LocationService.class.getName())) {
            com.orhanobut.logger.j.c("LocationService---isRunning");
            stopService(new Intent(this.T, (Class<?>) LocationService.class));
        }
        Intent intent = new Intent(this, (Class<?>) LocationService.class);
        intent.putExtra("runType", this.O0.getRunType());
        intent.putExtra("runExceptionDataDB", this.V0);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a3(String stepNumbers) {
        StartRunActivity startRunActivity = (StartRunActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(StartRunActivity.class);
        if (startRunActivity != null) {
            startRunActivity.n1();
        }
        RunRecorderListActivity runRecorderListActivity = (RunRecorderListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(RunRecorderListActivity.class);
        if (runRecorderListActivity != null) {
            runRecorderListActivity.J0();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(LatLng startLatLng) {
        this.X.addMarker(new MarkerOptions().position(startLatLng).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_start)).zIndex(9.0f).draggable(true));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_run;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            this.W0.b(this);
            LatLng latLng = this.f19707m1;
            if (latLng != null) {
                this.X.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng, 18.0f)), 1000L, null);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
