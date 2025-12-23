package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.TaskBean;
import com.stub.StubApp;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    private static k f13718b;

    /* renamed from: a, reason: collision with root package name */
    private String f13719a = "ClipUtil";

    /* renamed from: c, reason: collision with root package name */
    private Context f13720c;

    public static k a(Context context) {
        if (f13718b == null) {
            synchronized (k.class) {
                try {
                    if (f13718b == null) {
                        f13718b = new k(context);
                    }
                } finally {
                }
            }
        }
        return f13718b;
    }

    private k(Context context) {
        this.f13720c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public void a(final TaskBean.BackTaskArrayBean backTaskArrayBean) {
        if (backTaskArrayBean != null && !TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            EventCar.getInstance(this.f13720c).goRoad(new EventBean(com.beizi.fusion.c.b.f13294b, "", "510.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            final List<String> report = backTaskArrayBean.getReport();
            if (report == null || report.size() <= 0) {
                return;
            }
            e.b().e().execute(new Runnable() { // from class: com.beizi.fusion.tool.k.1
                @Override // java.lang.Runnable
                public void run() {
                    for (int i6 = 0; i6 < report.size(); i6++) {
                        if (!TextUtils.isEmpty((CharSequence) report.get(i6))) {
                            if (v.a(ao.a(k.this.f13720c, (String) report.get(i6), null), backTaskArrayBean.getUserAgent()) != null) {
                                EventCar.getInstance(k.this.f13720c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "520.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                            } else {
                                EventCar.getInstance(k.this.f13720c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "520.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                            }
                            try {
                                Thread.sleep(backTaskArrayBean.getSleepTime());
                            } catch (InterruptedException e6) {
                                e6.printStackTrace();
                            }
                        }
                    }
                }
            });
            return;
        }
        EventCar.getInstance(this.f13720c).goRoad(new EventBean(com.beizi.fusion.c.b.f13294b, "", "510.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }
}
