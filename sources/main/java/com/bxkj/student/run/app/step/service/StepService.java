package com.bxkj.student.run.app.step.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import cn.jiguang.bz.c0;
import com.alibaba.fastjson.JSON;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bxkj.student.R;
import com.bxkj.student.run.app.RunBroadcastActionType;
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.lockscreen.LockScreenActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.run.app.utils.y;
import com.orhanobut.logger.j;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class StepService extends Service implements SensorEventListener {

    /* renamed from: c, reason: collision with root package name */
    private SensorManager f20094c;

    /* renamed from: e, reason: collision with root package name */
    private Integer f20096e;

    /* renamed from: f, reason: collision with root package name */
    private com.bxkj.student.run.app.step.accelerometer.a f20097f;

    /* renamed from: i, reason: collision with root package name */
    private com.bxkj.student.run.app.step.a f20100i;

    /* renamed from: j, reason: collision with root package name */
    private RunDb f20101j;

    /* renamed from: k, reason: collision with root package name */
    private String f20102k;

    /* renamed from: l, reason: collision with root package name */
    private BroadcastReceiver f20103l;

    /* renamed from: n, reason: collision with root package name */
    private com.bxkj.student.run.app.step.d f20105n;

    /* renamed from: o, reason: collision with root package name */
    private long f20106o;

    /* renamed from: p, reason: collision with root package name */
    private long f20107p;

    /* renamed from: s, reason: collision with root package name */
    private Timer f20110s;

    /* renamed from: u, reason: collision with root package name */
    private NotificationManager f20112u;

    /* renamed from: v, reason: collision with root package name */
    private NotificationCompat.Builder f20113v;

    /* renamed from: x, reason: collision with root package name */
    private long f20115x;

    /* renamed from: y, reason: collision with root package name */
    private Notification f20116y;

    /* renamed from: a, reason: collision with root package name */
    private final String f20092a = "StepService";

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f20093b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private int f20095d = 0;

    /* renamed from: g, reason: collision with root package name */
    private e f20098g = new e();

    /* renamed from: h, reason: collision with root package name */
    private boolean f20099h = false;

    /* renamed from: m, reason: collision with root package name */
    private long f20104m = 0;

    /* renamed from: q, reason: collision with root package name */
    private final int f20108q = 170;

    /* renamed from: r, reason: collision with root package name */
    private long f20109r = 0;

    /* renamed from: t, reason: collision with root package name */
    private Handler f20111t = new c();

    /* renamed from: w, reason: collision with root package name */
    private int f20114w = 100;

    /* renamed from: z, reason: collision with root package name */
    private boolean f20117z = false;
    private BroadcastReceiver A = new d();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RunBroadcastActionType.SET_RUNNING_PAUSE)) {
                if (intent.hasExtra("isPause")) {
                    StepService stepService = StepService.this;
                    stepService.f20099h = intent.getBooleanExtra("isPause", stepService.f20099h);
                    boolean unused = StepService.this.f20099h;
                    if (StepService.this.f20097f != null) {
                        StepService.this.f20097f.e(StepService.this.f20099h);
                        return;
                    }
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.STOP_LOCATION)) {
                StepService.this.l();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            StepService.this.f20111t.sendEmptyMessage(170);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 170 && !StepService.this.f20099h) {
                StepService.this.f20104m++;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Intent intent2 = new Intent(context, (Class<?>) LockScreenActivity.class);
                intent2.putExtra("time", StepService.this.f20102k);
                intent2.putExtra("stepCount", StepService.this.o());
                intent2.addFlags(276824064);
                StepService.this.startActivity(intent2);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e extends Binder {
        public e() {
        }

        public StepService a() {
            return StepService.this;
        }
    }

    private void j() {
        com.bxkj.student.run.app.step.accelerometer.a aVar = new com.bxkj.student.run.app.step.accelerometer.a();
        this.f20097f = aVar;
        aVar.e(this.f20099h);
        this.f20097f.f(this.f20095d);
        this.f20094c.registerListener(this.f20097f.b(), this.f20094c.getDefaultSensor(1), 2);
        this.f20097f.c(new com.bxkj.student.run.app.step.accelerometer.d() { // from class: com.bxkj.student.run.app.step.service.d
            @Override // com.bxkj.student.run.app.step.accelerometer.d
            public final void a(int i6) {
                StepService.this.q(i6);
            }
        });
    }

    private void k() {
        Sensor defaultSensor = this.f20094c.getDefaultSensor(19);
        Sensor defaultSensor2 = this.f20094c.getDefaultSensor(18);
        if (defaultSensor != null) {
            this.f20094c.registerListener(this, defaultSensor, 0);
        } else if (defaultSensor2 != null) {
            this.f20094c.registerListener(this, defaultSensor2, 0);
        } else {
            j();
        }
    }

    private void p() {
        this.f20113v = new NotificationCompat.Builder(this, "default");
        PendingIntent activity = PendingIntent.getActivity(this, 1, new Intent(this, (Class<?>) RunningActivity.class), AMapEngineUtils.HALF_MAX_P20_WIDTH);
        this.f20115x = System.currentTimeMillis();
        this.f20113v.setContentTitle(getResources().getString(2131951695)).setContentText("正在记录本次跑步").setContentIntent(activity).setWhen(this.f20115x).setPriority(1).setAutoCancel(false).setOngoing(true).setOnlyAlertOnce(true).setSmallIcon(2131689689);
        this.f20116y = this.f20113v.build();
        this.f20112u = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f20112u.createNotificationChannel(c0.a("default", "体适能", 2));
        }
        startForeground(this.f20114w, this.f20116y);
        j.c("initNotification()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(int i6) {
        this.f20095d = i6;
        com.bxkj.student.run.app.step.a aVar = this.f20100i;
        if (aVar != null) {
            aVar.a(o());
        }
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.UPDATE_STEP);
        intent.putExtra("stepCount", o());
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void s() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RunBroadcastActionType.NOTIFY_RUN_DATA);
        intentFilter.addAction(RunBroadcastActionType.SET_RUNNING_PAUSE);
        intentFilter.addAction(RunBroadcastActionType.STOP_LOCATION);
        a aVar = new a();
        this.f20103l = aVar;
        registerReceiver(aVar, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    private void t() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.A, intentFilter);
        this.f20117z = true;
    }

    private void w() {
        String id;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel a6 = c0.a("default", "default", 4);
            a6.setGroup("default");
            a6.setLockscreenVisibility(2);
            a6.setDescription("");
            a6.setLightColor(-16711936);
            a6.setName("");
            a6.setSound(null, null);
            a6.enableVibration(false);
            id = a6.getId();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id);
            builder.setContentTitle(getString(2131951695));
            builder.setContentText("");
            builder.setDefaults(-1);
            builder.setAutoCancel(true);
            builder.setShowWhen(true);
            builder.setSmallIcon(2131689689);
            NotificationManagerCompat.from(this).notify(100, builder.build());
            try {
                startForeground(100, builder.build());
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void r() {
        if (this.f20094c != null) {
            this.f20094c = null;
        }
        this.f20094c = (SensorManager) getSystemService(bi.ac);
        k();
    }

    public long m() {
        return this.f20107p;
    }

    public long n() {
        return this.f20106o;
    }

    public int o() {
        return this.f20095d;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f20098g;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        int i6 = 0;
        if (event.sensor.getType() != 19) {
            if (event.sensor.getType() == 18) {
                if (event.values[0] == 1.0d && !this.f20099h) {
                    this.f20095d++;
                }
                com.bxkj.student.run.app.step.a aVar = this.f20100i;
                if (aVar != null) {
                    aVar.a(o());
                }
                Intent intent = new Intent();
                intent.setAction(RunBroadcastActionType.UPDATE_STEP);
                intent.putExtra("stepCount", o());
                sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
                return;
            }
            return;
        }
        int i7 = (int) event.values[0];
        Integer num = this.f20096e;
        if (num != null) {
            int intValue = i7 - num.intValue();
            if (intValue < 0) {
                this.f20096e = Integer.valueOf(i7);
            } else {
                i6 = intValue;
            }
            if (!this.f20099h) {
                this.f20095d += i6;
            }
        }
        this.f20096e = Integer.valueOf(i7);
        com.bxkj.student.run.app.step.a aVar2 = this.f20100i;
        if (aVar2 != null) {
            aVar2.a(o());
        }
        Intent intent2 = new Intent();
        intent2.setAction(RunBroadcastActionType.UPDATE_STEP);
        intent2.putExtra("stepCount", o());
        sendBroadcast(intent2, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        j.c("onStartCommand");
        if (intent == null || !intent.hasExtra("runType")) {
            stopSelf();
        } else {
            if (intent.hasExtra("isPause")) {
                this.f20099h = intent.getBooleanExtra("isPause", this.f20099h);
                com.bxkj.student.run.app.step.accelerometer.a aVar = this.f20097f;
                if (aVar != null) {
                    aVar.e(this.f20099h);
                }
            }
            if (intent.hasExtra("runExceptionDataDB")) {
                RunDb runDb = (RunDb) intent.getParcelableExtra("runExceptionDataDB");
                this.f20101j = runDb;
                if (runDb != null) {
                    this.f20104m = Long.parseLong(runDb.getCountTime());
                    this.f20106o = Long.parseLong(this.f20101j.getStartTime());
                    if (this.f20104m != 0) {
                        this.f20093b = JSON.parseArray(this.f20101j.getStepList(), Integer.class);
                    }
                    Iterator<Integer> it = this.f20093b.iterator();
                    int i6 = 0;
                    while (it.hasNext()) {
                        i6 += it.next().intValue();
                    }
                    this.f20095d = i6;
                }
            }
            new Thread(new Runnable() { // from class: com.bxkj.student.run.app.step.service.e
                @Override // java.lang.Runnable
                public final void run() {
                    StepService.this.r();
                }
            }).start();
            w();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void u(com.bxkj.student.run.app.step.a stepChangeListener) {
        this.f20100i = stepChangeListener;
    }

    public void v(com.bxkj.student.run.app.step.d stepServiceCallBack) {
        this.f20105n = stepServiceCallBack;
    }

    public void l() {
        try {
            try {
                this.f20107p = System.currentTimeMillis();
                Handler handler = this.f20111t;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                Timer timer = this.f20110s;
                if (timer != null) {
                    timer.cancel();
                }
                stopForeground(true);
                y.f(this, R.raw.stop_run);
                BroadcastReceiver broadcastReceiver = this.f20103l;
                if (broadcastReceiver != null) {
                    unregisterReceiver(broadcastReceiver);
                    this.f20103l = null;
                }
                BroadcastReceiver broadcastReceiver2 = this.A;
                if (broadcastReceiver2 != null && this.f20117z) {
                    unregisterReceiver(broadcastReceiver2);
                    this.A = null;
                }
                this.f20094c.unregisterListener(this);
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

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        s();
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.bxkj.student.run.app.step.accelerometer.a aVar;
        super.onDestroy();
        Handler handler = this.f20111t;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Timer timer = this.f20110s;
        if (timer != null) {
            timer.cancel();
        }
        SensorManager sensorManager = this.f20094c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        SensorManager sensorManager2 = this.f20094c;
        if (sensorManager2 != null && (aVar = this.f20097f) != null) {
            sensorManager2.unregisterListener(aVar.b());
        }
        stopForeground(true);
        BroadcastReceiver broadcastReceiver = this.f20103l;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f20103l = null;
        }
        BroadcastReceiver broadcastReceiver2 = this.A;
        if (broadcastReceiver2 != null && this.f20117z) {
            unregisterReceiver(broadcastReceiver2);
            this.A = null;
        }
        j.c("stepService关闭");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void y(long startTime) {
        y.f(this, R.raw.run_start);
        t();
        p();
        if (this.f20106o == 0) {
            this.f20106o = startTime;
            j.c("跑步开始时间=" + i.h(startTime, null));
        }
        this.f20109r = System.currentTimeMillis();
        b bVar = new b();
        Timer timer = new Timer();
        this.f20110s = timer;
        timer.schedule(bVar, 0L, 1000L);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
