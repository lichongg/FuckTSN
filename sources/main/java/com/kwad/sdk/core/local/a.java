package com.kwad.sdk.core.local;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private static volatile a aDZ;
    public static ThreadLocal<SimpleDateFormat> aEa = new ThreadLocal<SimpleDateFormat>() { // from class: com.kwad.sdk.core.local.a.1
        @Nullable
        private static SimpleDateFormat Hv() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override // java.lang.ThreadLocal
        @Nullable
        protected final /* synthetic */ SimpleDateFormat initialValue() {
            return Hv();
        }
    };

    public static a Hq() {
        if (aDZ == null) {
            synchronized (a.class) {
                try {
                    if (aDZ == null) {
                        aDZ = new a();
                    }
                } finally {
                }
            }
        }
        return aDZ;
    }

    public static boolean Hr() {
        List<f> dw = dw(15);
        if (dw.size() == 0) {
            return true;
        }
        long j6 = -1;
        int i6 = 0;
        for (f fVar : dw) {
            i6 += fVar.count;
            long j7 = fVar.aIK;
            if (j7 > j6) {
                j6 = j7;
            }
        }
        c.d("AdCounter", "onBind localCountCheck: allCount: " + i6 + ", lastShowTime: " + j6);
        if (i6 > Ht()) {
            return false;
        }
        return j6 + (Hu() * 1000) <= System.currentTimeMillis();
    }

    public static List<f> Hs() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    private static int Ht() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long Hu() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }

    private static void Q(String str, String str2) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    private static boolean a(@NonNull f fVar) {
        long j6 = fVar.aIK;
        if (j6 <= 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = aEa.get();
        return simpleDateFormat.format(new Date(j6)).equals(simpleDateFormat.format(new Date()));
    }

    public static void ch(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            c.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            ci(adTemplate);
        }
    }

    @NonNull
    private static List<f> dw(int i6) {
        ArrayList arrayList = new ArrayList();
        List<f> Hs = Hs();
        if (Hs != null && Hs.size() != 0) {
            for (f fVar : Hs) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void e(int i6, long j6) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i6).putLong("reward_aggregation_min_interval", j6).apply();
    }

    private static String getString(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
        } catch (Throwable th) {
            c.printStackTrace(th);
            return null;
        }
    }

    private static void ci(AdTemplate adTemplate) {
        int et = e.et(adTemplate);
        int ef = e.ef(adTemplate);
        List Hs = Hs();
        if (Hs != null && Hs.size() != 0) {
            Iterator it = Hs.iterator();
            while (true) {
                if (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar.adStyle == ef && fVar.taskType == et) {
                        fVar.count++;
                        if (!a(fVar)) {
                            fVar.count = 1;
                            fVar.aG(System.currentTimeMillis());
                        }
                    }
                } else {
                    Hs.add(new f(ef, et, 1, System.currentTimeMillis()));
                    break;
                }
            }
        } else {
            Hs = new ArrayList();
            Hs.add(new f(ef, et, 1, System.currentTimeMillis()));
        }
        Q("ksadsdk_local_ad_task_info_adstyle_data", aa.S(Hs).toString());
        adTemplate.watched = true;
    }
}
