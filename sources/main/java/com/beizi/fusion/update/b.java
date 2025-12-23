package com.beizi.fusion.update;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.model.TaskConfig;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.aq;
import com.beizi.fusion.tool.as;
import com.beizi.fusion.tool.e;
import com.beizi.fusion.tool.k;
import com.beizi.fusion.tool.v;
import com.beizi.fusion.tool.y;
import com.beizi.fusion.tool.z;
import com.beizi.fusion.widget.JSView;
import com.beizi.fusion.widget.LandingView;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    private static Context f13807f;

    /* renamed from: g, reason: collision with root package name */
    private static ResponseInfo f13808g;

    /* renamed from: i, reason: collision with root package name */
    private static TaskBean f13809i;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f13810k;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f13811l;

    /* renamed from: m, reason: collision with root package name */
    private static b f13812m;

    /* renamed from: a, reason: collision with root package name */
    private ScheduledExecutorService f13813a;

    /* renamed from: b, reason: collision with root package name */
    private long f13814b;

    /* renamed from: c, reason: collision with root package name */
    private long f13815c;

    /* renamed from: d, reason: collision with root package name */
    private long f13816d;

    /* renamed from: e, reason: collision with root package name */
    private final HandlerC0137b f13817e;

    /* renamed from: h, reason: collision with root package name */
    private ScheduledExecutorService f13818h;

    /* renamed from: j, reason: collision with root package name */
    private ScheduledExecutorService f13819j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private int f13821b;

        a(int i6) {
            this.f13821b = i6;
        }

        private void a() {
            if (b.f13809i != null) {
                long expired = b.f13809i.getExpired();
                long currentTimeMillis = System.currentTimeMillis();
                List<TaskBean.BackTaskArrayBean> backTaskArray = b.f13809i.getBackTaskArray();
                if (backTaskArray == null || backTaskArray.size() <= 0) {
                    return;
                }
                EventCar.getInstance(b.f13807f).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "500.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "", String.valueOf(backTaskArray.size())));
                for (int i6 = 0; i6 < backTaskArray.size(); i6++) {
                    if (System.currentTimeMillis() - currentTimeMillis > expired) {
                        EventCar.getInstance(b.f13807f).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "530.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "", String.valueOf(backTaskArray.size() - i6)));
                    } else {
                        final TaskBean.BackTaskArrayBean backTaskArrayBean = backTaskArray.get(i6);
                        final int type = backTaskArrayBean.getType();
                        b.this.f13817e.post(new Runnable() { // from class: com.beizi.fusion.update.b.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                int i7 = type;
                                if (i7 == 1) {
                                    e.b().e().execute(new aq(b.f13807f, backTaskArrayBean));
                                    return;
                                }
                                if (i7 == 2) {
                                    k.a(b.f13807f).a(backTaskArrayBean);
                                    return;
                                }
                                if (i7 == 3) {
                                    as.a(b.f13807f);
                                    new LandingView(b.f13807f, backTaskArrayBean).load();
                                } else if (i7 == 4) {
                                    as.a(b.f13807f);
                                    new JSView(b.f13807f, backTaskArrayBean).load();
                                } else {
                                    if (i7 != 8) {
                                        return;
                                    }
                                    e.b().f().execute(new com.beizi.fusion.tool.c(b.f13807f, backTaskArrayBean));
                                }
                            }
                        });
                        try {
                            Thread.sleep(backTaskArrayBean.getSleepTime());
                        } catch (InterruptedException e6) {
                            e6.printStackTrace();
                        }
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            TaskConfig taskConfig;
            int i6 = this.f13821b;
            if (i6 == 2) {
                if (!b.this.e().booleanValue()) {
                    EventCar.getInstance(b.f13807f).goRoad(new EventBean(com.beizi.fusion.c.b.f13294b, "", "310.210", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    return;
                }
                Thread.currentThread().getName();
                Message message = new Message();
                message.what = 1;
                message.arg1 = 1;
                b.this.f13817e.sendMessage(message);
                EventCar.getInstance(b.f13807f).goRoad(new EventBean(com.beizi.fusion.c.b.f13294b, "", "310.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                return;
            }
            if (i6 == 3) {
                EventCar.getInstance(b.f13807f).doUpLoadLogs();
                return;
            }
            if (i6 != 4) {
                if (i6 != 5) {
                    return;
                }
                Thread.currentThread().getName();
                Message message2 = new Message();
                message2.what = 1;
                message2.arg1 = 5;
                b.this.f13817e.sendMessage(message2);
                EventCar.getInstance(b.f13807f).goRoad(new EventBean(com.beizi.fusion.c.b.f13294b, "", "310.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                return;
            }
            Thread.currentThread().getName();
            if (b.f13808g.getTaskConfig() == null || (taskConfig = b.f13808g.getTaskConfig()) == null || taskConfig.getUrl() == null) {
                return;
            }
            String a6 = v.a(b.f13807f, taskConfig.getUrl(), com.beizi.fusion.c.b.a().b(), Boolean.TRUE);
            if (TextUtils.isEmpty(a6) || a6.length() <= 0) {
                return;
            }
            try {
                String optString = new JSONObject(a6).optString("data");
                if (TextUtils.isEmpty(optString) || optString.equals("null")) {
                    return;
                }
                String b6 = com.beizi.fusion.tool.b.b(y.a(), optString);
                if (TextUtils.isEmpty(b6)) {
                    return;
                }
                TaskBean unused = b.f13809i = TaskBean.objectFromData(b6);
                if (b.f13809i != null) {
                    a();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.fusion.update.b$b, reason: collision with other inner class name */
    private static class HandlerC0137b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<b> f13825a;

        HandlerC0137b(b bVar) {
            super(Looper.getMainLooper());
            this.f13825a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        @SuppressLint({"NewApi"})
        public void handleMessage(Message message) {
            if (!b.f13811l) {
                boolean unused = b.f13811l = true;
                try {
                    b bVar = this.f13825a.get();
                    if (bVar == null) {
                        boolean unused2 = b.f13811l = false;
                        return;
                    }
                    c cVar = new c(b.f13807f, bVar);
                    if (b.f13808g.getConfigurator() != null) {
                        cVar.executeOnExecutor(e.b().d(), b.f13808g.getConfigurator().getConfigUrl());
                    } else {
                        cVar.executeOnExecutor(e.b().d(), new String[0]);
                    }
                } catch (RejectedExecutionException e6) {
                    e6.printStackTrace();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        }
    }

    private void c(int i6) {
        z a6 = z.a(f13807f);
        Intent intent = new Intent("com.ad.action.UPDATE_CONFIG_SUCCESS");
        intent.putExtra("updateResult", i6);
        a6.a(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean e() {
        Manager manager = f13808g.getManager();
        if (manager == null) {
            return Boolean.TRUE;
        }
        List<AdSpacesBean> adSpaces = manager.getAdSpaces();
        if (adSpaces == null) {
            return Boolean.TRUE;
        }
        if (adSpaces.size() == 0) {
            return Boolean.TRUE;
        }
        String b6 = com.beizi.fusion.c.b.a().b();
        AdSpacesBean adSpacesBean = adSpaces.get(0);
        if (!b6.equals(adSpacesBean.getAppId())) {
            return Boolean.TRUE;
        }
        if (adSpacesBean.getComponent() == null) {
            return Boolean.TRUE;
        }
        if (f13808g.getConfigurator() == null) {
            return Boolean.TRUE;
        }
        long longValue = ((Long) an.b(f13807f, "lastUpdateTime", Long.valueOf(new Date(0L).getTime()))).longValue();
        long expireTime = f13808g.getExpireTime();
        long maxValidTime = f13808g.getMaxValidTime();
        if (maxValidTime == 0) {
            maxValidTime = 2592000000L;
        }
        long currentTimeMillis = System.currentTimeMillis() - longValue;
        return Boolean.valueOf(currentTimeMillis > expireTime || currentTimeMillis > maxValidTime);
    }

    private void f() {
        if (this.f13813a == null) {
            this.f13813a = Executors.newScheduledThreadPool(2);
        }
        if (this.f13818h == null) {
            this.f13818h = Executors.newScheduledThreadPool(2);
        }
        if (this.f13819j != null || this.f13816d == 0) {
            return;
        }
        this.f13819j = Executors.newScheduledThreadPool(2);
    }

    private b(Context context) {
        this.f13814b = 60000L;
        this.f13815c = 60000L;
        this.f13816d = 0L;
        f13807f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f13817e = new HandlerC0137b(this);
        if (f13808g == null) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(f13807f);
            f13808g = responseInfo;
            if (!responseInfo.isInit()) {
                f13808g.init();
            }
            if (f13808g.getConfigurator() != null) {
                long checkInterval = f13808g.getConfigurator().getCheckInterval();
                if (checkInterval != 0) {
                    this.f13814b = checkInterval;
                }
            }
            if (f13808g.getMessenger() != null) {
                long checkInterval2 = f13808g.getMessenger().getCheckInterval();
                if (checkInterval2 != 0) {
                    this.f13815c = checkInterval2;
                }
            }
            if (f13808g.getTaskConfig() != null) {
                long checkInterval3 = f13808g.getTaskConfig().getCheckInterval();
                if (checkInterval3 != 0) {
                    this.f13816d = checkInterval3;
                }
            }
        }
    }

    public void b(int i6) {
        f();
        if (i6 != 0) {
            if (i6 != 5) {
                return;
            }
            f13810k = true;
            if (!f13811l) {
                Message message = new Message();
                message.what = 1;
                message.arg1 = 5;
                this.f13817e.sendMessage(message);
            }
            EventCar.getInstance(f13807f).goRoad(new EventBean(com.beizi.fusion.c.b.f13294b, "", "310.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            return;
        }
        ScheduledExecutorService scheduledExecutorService = this.f13813a;
        a aVar = new a(2);
        long j6 = this.f13814b;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        scheduledExecutorService.scheduleWithFixedDelay(aVar, 0L, j6, timeUnit);
        this.f13818h.scheduleWithFixedDelay(new a(3), 0L, this.f13815c, timeUnit);
        ScheduledExecutorService scheduledExecutorService2 = this.f13819j;
        if (scheduledExecutorService2 != null && this.f13816d != 0) {
            scheduledExecutorService2.scheduleWithFixedDelay(new a(4), 0L, this.f13816d, timeUnit);
            EventCar.getInstance(f13807f).goRoad(new EventBean(com.beizi.fusion.c.b.f13294b, "", "500.000", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
        EventCar.getInstance(f13807f).goRoad(new EventBean(com.beizi.fusion.c.b.f13294b, "", "300.000", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    public void a(Object obj) {
        if (((com.beizi.fusion.update.a) obj) != null) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(f13807f);
            f13808g = responseInfo;
            responseInfo.init();
            if (f13810k) {
                c(1);
                f13810k = false;
            }
            EventCar.getInstance(f13807f).goRoad(new EventBean(com.beizi.fusion.c.b.f13294b, "", "320.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
        f13811l = false;
    }

    public void a(int i6) {
        if (f13810k) {
            c(0);
            f13810k = false;
        }
        EventCar.getInstance(f13807f).goRoad(new EventBean(com.beizi.fusion.c.b.f13294b, "", "320.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        f13811l = false;
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (f13812m == null) {
                    f13812m = new b(context);
                }
                bVar = f13812m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }
}
