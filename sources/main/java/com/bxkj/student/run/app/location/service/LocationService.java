package com.bxkj.student.run.app.location.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import cn.jiguang.bz.c0;
import com.alibaba.fastjson.JSON;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bxkj.student.R;
import com.bxkj.student.run.app.RunBroadcastActionType;
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.lockscreen.LockScreenActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.run.app.utils.p;
import com.bxkj.student.run.app.utils.y;
import com.bxkj.student.run.app.utils.z;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.orhanobut.logger.j;
import com.snail.antifake.deviceid.e;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LocationService extends Service {
    private NotificationManager A;
    private NotificationCompat.Builder B;
    private Timer E;

    /* renamed from: e, reason: collision with root package name */
    private float f19849e;

    /* renamed from: f, reason: collision with root package name */
    private long f19850f;

    /* renamed from: h, reason: collision with root package name */
    private long f19852h;

    /* renamed from: l, reason: collision with root package name */
    private Notification f19856l;

    /* renamed from: n, reason: collision with root package name */
    private p f19858n;

    /* renamed from: o, reason: collision with root package name */
    private long f19859o;

    /* renamed from: p, reason: collision with root package name */
    private z f19860p;

    /* renamed from: q, reason: collision with root package name */
    private BroadcastReceiver f19861q;

    /* renamed from: r, reason: collision with root package name */
    private MediaPlayer f19862r;

    /* renamed from: u, reason: collision with root package name */
    private LatLng f19865u;

    /* renamed from: v, reason: collision with root package name */
    private LatLng f19866v;

    /* renamed from: w, reason: collision with root package name */
    private LatLngTimeSpeed f19867w;

    /* renamed from: a, reason: collision with root package name */
    private String f19845a = "LocationService";

    /* renamed from: b, reason: collision with root package name */
    private boolean f19846b = false;

    /* renamed from: c, reason: collision with root package name */
    private AMapLocationClient f19847c = null;

    /* renamed from: d, reason: collision with root package name */
    private AMapLocationClientOption f19848d = null;

    /* renamed from: g, reason: collision with root package name */
    private long f19851g = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f19853i = false;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<LatLngTimeSpeed> f19854j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private List<LatLng> f19855k = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private int f19857m = 3;

    /* renamed from: s, reason: collision with root package name */
    private BroadcastReceiver f19863s = new b();

    /* renamed from: t, reason: collision with root package name */
    private boolean f19864t = false;

    /* renamed from: x, reason: collision with root package name */
    private long f19868x = 0;

    /* renamed from: y, reason: collision with root package name */
    private AMapLocationListener f19869y = new AMapLocationListener() { // from class: com.bxkj.student.run.app.location.service.a
        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            LocationService.this.z(aMapLocation);
        }
    };

    /* renamed from: z, reason: collision with root package name */
    private boolean f19870z = false;
    private int C = 100;
    private String D = "";
    private final int F = 170;
    private long G = 0;
    private Handler H = new d();
    private int I = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RunBroadcastActionType.UPDATE_STEP)) {
                if (intent.hasExtra("stepCount")) {
                    LocationService.this.I = intent.getIntExtra("stepCount", 0);
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.SET_RUNNING_PAUSE)) {
                if (intent.hasExtra("isPause")) {
                    LocationService locationService = LocationService.this;
                    locationService.f19846b = intent.getBooleanExtra("isPause", locationService.f19846b);
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.STOP_LOCATION)) {
                LocationService.this.H();
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION)) {
                if (intent.hasExtra(CrashHianalyticsData.MESSAGE)) {
                    LocationService.this.E(intent.getStringExtra(CrashHianalyticsData.MESSAGE));
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION)) {
                LocationService.this.K();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Intent intent2 = new Intent(context, (Class<?>) LockScreenActivity.class);
                intent2.putExtra("distance", i.d(LocationService.this.f19849e));
                intent2.putExtra("speed", i.a(LocationService.this.f19849e, LocationService.this.f19851g));
                intent2.putExtra("peisu", i.b(LocationService.this.f19849e, LocationService.this.f19851g));
                intent2.putExtra("time", i.g(LocationService.this.f19851g));
                intent2.putExtra("lastPauseMessage", LocationService.this.D);
                intent2.putExtra("stepCount", LocationService.this.I);
                intent2.addFlags(276824064);
                LocationService.this.startActivity(intent2);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LocationService.this.H.sendEmptyMessage(170);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 170 && !LocationService.this.f19846b) {
                LocationService.this.f19851g++;
                LocationService.this.G = System.currentTimeMillis();
                LocationService locationService = LocationService.this;
                locationService.L(locationService.f19851g);
                LocationService.this.K();
                LocationService.this.J();
                LocationService locationService2 = LocationService.this;
                y.g(locationService2, locationService2.f19851g, LocationService.this.f19849e, LocationService.this.I);
                LocationService.this.C();
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void A() {
        this.f19861q = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RunBroadcastActionType.UPDATE_DISTANCE);
        intentFilter.addAction(RunBroadcastActionType.UPDATE_STEP);
        intentFilter.addAction(RunBroadcastActionType.SET_RUNNING_PAUSE);
        intentFilter.addAction(RunBroadcastActionType.STOP_LOCATION);
        intentFilter.addAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
        intentFilter.addAction(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION);
        registerReceiver(this.f19861q, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    private void B() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.f19863s, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.SAVE_LOCAL_DB);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void D(LatLng latLng) {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.CURRENT_LATLNG);
        intent.putExtra("latLng", latLng);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String message) {
        this.D = message;
        this.f19859o = System.currentTimeMillis();
        Notification build = this.B.setContentText(message).setWhen(this.f19859o).build();
        this.f19856l = build;
        this.A.notify(this.C, build);
    }

    private void F() {
        this.f19847c.stopLocation();
        this.f19847c.startLocation();
        this.f19870z = true;
    }

    private void G() {
        if (this.f19850f == 0) {
            this.f19850f = System.currentTimeMillis();
        }
        this.G = System.currentTimeMillis();
        c cVar = new c();
        Timer timer = new Timer();
        this.E = timer;
        timer.schedule(cVar, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        try {
            try {
                Handler handler = this.H;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                Timer timer = this.E;
                if (timer != null) {
                    timer.cancel();
                }
                this.f19852h = System.currentTimeMillis();
                stopForeground(true);
                this.f19847c.disableBackgroundLocation(true);
                if (this.f19870z) {
                    this.f19847c.stopLocation();
                    this.f19870z = false;
                }
                stopSelf();
            } catch (Exception e6) {
                e6.printStackTrace();
                stopSelf();
            }
        } catch (Throwable th) {
            stopSelf();
            throw th;
        }
    }

    private void I(String gpsStatus, int gpsStatusImage) {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.UPDATE_GPS_STATUS);
        intent.putExtra("gpsStatus", gpsStatus);
        intent.putExtra("gpsStatusImage", gpsStatusImage);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.NOTIFY_RUN_DATA);
        intent.putExtra("distance", i.d(this.f19849e));
        intent.putExtra("speed", i.a(this.f19849e, this.f19851g));
        intent.putExtra("peisu", i.b(this.f19849e, this.f19851g));
        intent.putExtra("time", i.g(this.f19851g));
        intent.putExtra("countTime", this.f19851g);
        intent.putExtra("stepCount", this.I);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.D = "";
        this.f19859o = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("你已经运动");
        sb.append(i.d(this.f19849e));
        sb.append(" KM,");
        sb.append(this.I);
        sb.append("步,用时");
        sb.append(i.g(this.f19851g));
        Notification build = this.B.setContentText(sb).setWhen(this.f19859o).build();
        this.f19856l = build;
        this.A.notify(this.C, build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(long countTime) {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.TIME_CHANGE);
        intent.putExtra("countTime", countTime);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void r(LatLng latLng) {
        j.c("第一个定位点获取成功");
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.GET_FIRST_LOCATION_SUCCESS);
        intent.putExtra("latLng", latLng);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
        this.f19864t = true;
    }

    private void s(LatLng pathSmoothCurrentLatLng, LatLng pathSmoothLastLatLng, float speed, float distance, String avgSpeed, String pace, boolean isPause, LatLngTimeSpeed latLngTimeSpeed) {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.ADD_LINE);
        intent.putExtra("lastLatLng", pathSmoothLastLatLng);
        intent.putExtra("currentLatLng", pathSmoothCurrentLatLng);
        intent.putExtra("speed", speed);
        intent.putExtra("distance", distance);
        intent.putExtra("avgSpeed", avgSpeed);
        intent.putExtra("pace", pace);
        intent.putExtra("isPause", isPause);
        intent.putExtra("latLngTimeSpeed", latLngTimeSpeed);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void t(String avgSpeed, String pace, long countTime, float distance, long startTime, ArrayList<LatLngTimeSpeed> latLngTimeSpeedList) {
        j.c("发送广播addOldLine");
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.ADD_OLD_LINE);
        intent.putExtra("avgSpeed", avgSpeed);
        intent.putExtra("pace", pace);
        intent.putExtra("countTime", countTime);
        intent.putExtra("distance", distance);
        intent.putExtra(AnalyticsConfig.RTD_START_TIME, startTime);
        intent.putParcelableArrayListExtra("latLngTimeSpeedList", latLngTimeSpeedList);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void u(LatLng latLng, long startTime, LatLngTimeSpeed latLngTimeSpeed) {
        j.c("起始点定位成功");
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.ADD_START_POINT);
        intent.putExtra("latLng", latLng);
        intent.putExtra(AnalyticsConfig.RTD_START_TIME, startTime);
        intent.putExtra("latLngTimeSpeed", latLngTimeSpeed);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void v() {
        try {
            AMapLocationClient aMapLocationClient = this.f19847c;
            if (aMapLocationClient != null) {
                aMapLocationClient.onDestroy();
                this.f19847c = null;
                this.f19848d = null;
            }
            Handler handler = this.H;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Timer timer = this.E;
            if (timer != null) {
                timer.cancel();
            }
            BroadcastReceiver broadcastReceiver = this.f19861q;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
            }
            BroadcastReceiver broadcastReceiver2 = this.f19863s;
            if (broadcastReceiver2 != null) {
                unregisterReceiver(broadcastReceiver2);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.f19870z = false;
        this.f19853i = false;
    }

    private AMapLocationClientOption w() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport);
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setGpsFirst(true);
        aMapLocationClientOption.setHttpTimeOut(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        aMapLocationClientOption.setInterval(1000L);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setOnceLocation(false);
        aMapLocationClientOption.setOnceLocationLatest(false);
        aMapLocationClientOption.setSensorEnable(true);
        aMapLocationClientOption.setWifiScan(true);
        aMapLocationClientOption.setLocationCacheEnable(true);
        aMapLocationClientOption.setMockEnable(false);
        return aMapLocationClientOption;
    }

    private void x() {
        p pVar = new p();
        this.f19858n = pVar;
        pVar.p(3);
        try {
            this.f19847c = new AMapLocationClient(StubApp.getOrigApplicationContext(getApplicationContext()));
            AMapLocationClientOption w5 = w();
            this.f19848d = w5;
            this.f19847c.setLocationOption(w5);
            this.f19847c.setLocationListener(this.f19869y);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        y();
    }

    private void y() {
        this.B = new NotificationCompat.Builder(this, "default");
        PendingIntent activity = PendingIntent.getActivity(this, 1, new Intent(this, (Class<?>) RunningActivity.class), AMapEngineUtils.HALF_MAX_P20_WIDTH);
        this.f19859o = System.currentTimeMillis();
        this.B.setContentTitle(getResources().getString(2131951695)).setContentText("正在记录本次跑步").setContentIntent(activity).setWhen(this.f19859o).setPriority(1).setAutoCancel(false).setOngoing(true).setOnlyAlertOnce(true).setSmallIcon(2131689689).setDefaults(64);
        this.f19856l = this.B.build();
        this.A = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.A.createNotificationChannel(c0.a("default", "体适能", 2));
        }
        try {
            startForeground(this.C, this.f19856l);
            this.f19847c.enableBackgroundLocation(this.C, this.f19856l);
            j.c("initNotification()");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(AMapLocation aMapLocation) {
        BigDecimal multiply;
        if (aMapLocation == null) {
            j.c("定位失败，loc is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        this.f19868x = System.currentTimeMillis();
        sb.append("回调时间: " + i.h(this.f19868x, "yyyy-MM-dd HH:mm:ss") + e.f37542d);
        if (aMapLocation.getErrorCode() == 0) {
            sb.append("定位成功\n");
            sb.append("定位类型: " + aMapLocation.getLocationType() + e.f37542d);
            sb.append("经    度    : " + aMapLocation.getLongitude() + e.f37542d);
            sb.append("纬    度    : " + aMapLocation.getLatitude() + e.f37542d);
            sb.append("精    度    : " + aMapLocation.getAccuracy() + "米\n");
            sb.append("提供者    : " + aMapLocation.getProvider() + e.f37542d);
            sb.append("速    度    : " + aMapLocation.getSpeed() + "米/秒\n");
            sb.append("角    度    : " + aMapLocation.getBearing() + e.f37542d);
            sb.append("星    数    : " + aMapLocation.getSatellites() + e.f37542d);
            sb.append("国    家    : " + aMapLocation.getCountry() + e.f37542d);
            sb.append("省            : " + aMapLocation.getProvince() + e.f37542d);
            sb.append("市            : " + aMapLocation.getCity() + e.f37542d);
            sb.append("城市编码 : " + aMapLocation.getCityCode() + e.f37542d);
            sb.append("区            : " + aMapLocation.getDistrict() + e.f37542d);
            sb.append("区域 码   : " + aMapLocation.getAdCode() + e.f37542d);
            sb.append("地    址    : " + aMapLocation.getAddress() + e.f37542d);
            sb.append("兴趣点    : " + aMapLocation.getPoiName() + e.f37542d);
            sb.append("定位时间: " + i.h(aMapLocation.getTime(), "yyyy-MM-dd HH:mm:ss") + e.f37542d);
            LatLng latLng = new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            this.f19865u = latLng;
            D(latLng);
            if (!this.f19864t) {
                r(this.f19865u);
            }
            if (aMapLocation.getLocationType() != 6 && aMapLocation.getAccuracy() <= 100) {
                float speed = aMapLocation.getSpeed();
                if (this.f19853i) {
                    LatLng latLng2 = this.f19865u;
                    LatLngTimeSpeed latLngTimeSpeed = new LatLngTimeSpeed(latLng2.latitude, latLng2.longitude, System.currentTimeMillis(), speed, this.f19846b, aMapLocation.getLocationType());
                    if (aMapLocation.getTrustedLevel() == 1 || aMapLocation.getTrustedLevel() == 2) {
                        if (!this.f19846b) {
                            new BigDecimal(0.0d);
                            if (com.bxkj.student.run.app.drift.a.f19783a.c(this.f19867w, latLngTimeSpeed)) {
                                multiply = BigDecimal.valueOf(AMapUtils.calculateLineDistance(this.f19866v, this.f19865u));
                            } else {
                                multiply = new BigDecimal(this.f19849e).divide(new BigDecimal(this.f19851g), 10, 4).multiply(new BigDecimal(this.f19867w.getTime() - latLngTimeSpeed.getTime()).abs().divide(new BigDecimal(1000), 10, 4));
                                j.c("漂移点avg=${avg}appendDistance=${appendDistance}");
                            }
                            this.f19849e = new BigDecimal(this.f19849e).add(multiply).floatValue();
                        }
                        String a6 = i.a(this.f19849e, this.f19851g);
                        String b6 = i.b(this.f19849e, this.f19851g);
                        this.f19865u.toString();
                        this.f19866v.toString();
                        s(this.f19865u, this.f19866v, speed, this.f19849e, a6, b6, this.f19846b, latLngTimeSpeed);
                        this.f19855k.add(this.f19865u);
                    }
                    this.f19867w = latLngTimeSpeed;
                    this.f19866v = this.f19865u;
                } else if (i.p(aMapLocation) != null) {
                    this.f19853i = true;
                    G();
                    y.f(this, R.raw.run_start);
                    j.c("起始点定位成功");
                    ArrayList<LatLngTimeSpeed> arrayList = this.f19854j;
                    if (arrayList == null || arrayList.size() <= 0) {
                        LatLng latLng3 = this.f19865u;
                        LatLngTimeSpeed latLngTimeSpeed2 = new LatLngTimeSpeed(latLng3.latitude, latLng3.longitude, System.currentTimeMillis(), speed, this.f19846b, aMapLocation.getLocationType());
                        u(this.f19865u, this.f19850f, latLngTimeSpeed2);
                        this.f19855k.add(this.f19865u);
                        this.f19867w = latLngTimeSpeed2;
                        this.f19866v = this.f19865u;
                    } else {
                        try {
                            j.c("oldLatLngTimeSpeedList" + this.f19854j.toString());
                            ArrayList<LatLngTimeSpeed> arrayList2 = this.f19854j;
                            LatLngTimeSpeed latLngTimeSpeed3 = arrayList2.get(arrayList2.size() - 1);
                            j.c("latLngTimeSpeed1" + latLngTimeSpeed3.toString());
                            latLngTimeSpeed3.setPuase(true);
                            LatLng latLng4 = this.f19865u;
                            LatLngTimeSpeed latLngTimeSpeed4 = new LatLngTimeSpeed(latLng4.latitude, latLng4.longitude, System.currentTimeMillis(), speed, true, aMapLocation.getLocationType());
                            this.f19854j.add(latLngTimeSpeed4);
                            t(i.a(this.f19849e, this.f19851g), i.b(this.f19849e, this.f19851g), this.f19851g, this.f19849e, this.f19850f, this.f19854j);
                            this.f19855k.add(this.f19865u);
                            this.f19867w = latLngTimeSpeed4;
                            this.f19866v = this.f19865u;
                            this.f19854j.get(0).toString();
                            this.f19866v.toString();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                }
            }
        } else {
            sb.append("定位失败\n");
            sb.append("错误码:" + aMapLocation.getErrorCode() + e.f37542d);
            sb.append("错误信息:" + aMapLocation.getErrorInfo() + e.f37542d);
            sb.append("错误描述:" + aMapLocation.getLocationDetail() + e.f37542d);
        }
        sb.append("***定位质量报告***");
        sb.append(e.f37542d);
        sb.append("* WIFI开关：");
        sb.append(aMapLocation.getLocationQualityReport().isWifiAble() ? "开启" : "关闭");
        sb.append(e.f37542d);
        I(i.j(aMapLocation.getLocationQualityReport().getGPSStatus(), aMapLocation.getGpsAccuracyStatus()), i.k(aMapLocation.getGpsAccuracyStatus()));
        sb.append("* GPS状态：");
        sb.append(i.m(aMapLocation.getLocationQualityReport().getGPSStatus()));
        sb.append(e.f37542d);
        sb.append("* GPS星数：");
        sb.append(aMapLocation.getLocationQualityReport().getGPSSatellites());
        sb.append(e.f37542d);
        sb.append("****************");
        sb.append(e.f37542d);
        j.c(sb.toString());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        RunDb runDb;
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        this.A = notificationManager;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        if (intent == null || !intent.hasExtra("runType")) {
            stopSelf();
        } else {
            this.f19857m = intent.getIntExtra("runType", 3);
            if (intent.hasExtra("runExceptionDataDB") && (runDb = (RunDb) intent.getParcelableExtra("runExceptionDataDB")) != null && Long.parseLong(runDb.getCountTime()) != 0) {
                this.f19851g = Long.parseLong(runDb.getCountTime());
                this.f19849e = Float.parseFloat(runDb.getDistance());
                this.f19850f = Long.parseLong(runDb.getStartTime());
                for (LatLngTimeSpeed latLngTimeSpeed : JSON.parseArray(runDb.getLatLngList(), LatLngTimeSpeed.class)) {
                    if (latLngTimeSpeed != null) {
                        this.f19854j.add(latLngTimeSpeed);
                    }
                }
            }
            F();
            this.f19860p = new z();
        }
        MediaPlayer mediaPlayer = this.f19862r;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        NotificationManager notificationManager = this.A;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        super.onTaskRemoved(rootIntent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        this.A = notificationManager;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        x();
        B();
        A();
        MediaPlayer create = MediaPlayer.create(this, R.raw.slient);
        this.f19862r = create;
        create.setWakeMode(this, 1);
        this.f19862r.setLooping(true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        v();
        MediaPlayer mediaPlayer = this.f19862r;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f19862r.release();
            this.f19862r = null;
        }
        super.onDestroy();
    }
}
