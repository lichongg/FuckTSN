package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.TaskBean;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class aq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static String f13673a = "TaskRunnable";

    /* renamed from: b, reason: collision with root package name */
    private TaskBean.BackTaskArrayBean f13674b;

    /* renamed from: c, reason: collision with root package name */
    private Context f13675c;

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13674b != null) {
            for (int i6 = 0; i6 < this.f13674b.getRepeatCount(); i6++) {
                if (this.f13674b.getMethod().equals("GET") && !TextUtils.isEmpty(this.f13674b.getContentUrl())) {
                    try {
                        v.a(ao.a(this.f13675c, this.f13674b.getContentUrl(), null), this.f13674b.getUserAgent());
                        Thread.sleep(this.f13674b.getSleepTime());
                        List<String> report = this.f13674b.getReport();
                        if (report != null && report.size() > 0) {
                            for (int i7 = 0; i7 < report.size(); i7++) {
                                if (!TextUtils.isEmpty(report.get(i7))) {
                                    if (v.a(ao.a(this.f13675c, report.get(i7), null), this.f13674b.getUserAgent()) != null) {
                                        EventCar.getInstance(this.f13675c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "520.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                    } else {
                                        EventCar.getInstance(this.f13675c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "520.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                    }
                                    Thread.sleep(this.f13674b.getSleepTime());
                                }
                            }
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        EventCar.getInstance(this.f13675c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "510.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                }
            }
            EventCar.getInstance(this.f13675c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "510.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }

    public aq(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this.f13675c = context;
        this.f13674b = backTaskArrayBean;
    }
}
