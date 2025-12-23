package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.TaskBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static String f13676a = "AppLinkRunnable";

    /* renamed from: b, reason: collision with root package name */
    private TaskBean.BackTaskArrayBean f13677b;

    /* renamed from: c, reason: collision with root package name */
    private Context f13678c;

    private void a() {
        int i6;
        try {
            ArrayList arrayList = new ArrayList();
            List<TaskBean.BackTaskArrayBean.AppLinkBean> apps = this.f13677b.getApps();
            if (apps == null || apps.size() <= 0) {
                return;
            }
            Iterator<TaskBean.BackTaskArrayBean.AppLinkBean> it = apps.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TaskBean.BackTaskArrayBean.AppLinkBean next = it.next();
                String valueOf = ap.a(this.f13678c, next.getTestLink()) ? String.valueOf(1) : String.valueOf(0);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appLinkId", next.getAppLinkId());
                jSONObject.put("isLink", valueOf);
                arrayList.add(jSONObject.toString());
            }
            List<String> report = this.f13677b.getReport();
            if (report == null || report.size() <= 0) {
                return;
            }
            for (i6 = 0; i6 < report.size(); i6++) {
                if (!TextUtils.isEmpty(report.get(i6))) {
                    EventCar.getInstance(this.f13678c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "590.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "", arrayList.toString(), report.get(i6), false));
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13677b != null) {
            try {
                if (System.currentTimeMillis() - ap.o(this.f13678c).longValue() < 86400000) {
                    return;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            for (int i6 = 0; i6 < this.f13677b.getRepeatCount(); i6++) {
                if (this.f13677b.getMethod().equalsIgnoreCase("GET")) {
                    try {
                        a();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        EventCar.getInstance(this.f13678c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "510.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                }
            }
            EventCar.getInstance(this.f13678c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.f13294b, "", "510.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }

    public c(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this.f13678c = context;
        this.f13677b = backTaskArrayBean;
    }
}
