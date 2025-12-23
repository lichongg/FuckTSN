package com.bytedance.sdk.openadsdk.core.kt;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.tl.j.j;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.rn.f;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private static final Set<String> up;

    /* renamed from: j, reason: collision with root package name */
    public static final String f29419j = UUID.randomUUID().toString();
    public static AtomicInteger xt = new AtomicInteger(0);

    /* renamed from: r, reason: collision with root package name */
    private static String f29420r = "_create";
    public static final AtomicBoolean cw = new AtomicBoolean(false);

    public static void j(Context context, boolean z5) {
        if (cw.compareAndSet(false, true) || com.bytedance.sdk.component.tl.xt.j.j("csj")) {
            xt(context, z5);
            com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kt.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.tl.xt.j.r("csj");
                }
            }, com.bytedance.sdk.openadsdk.core.oq.i().ae() ? 20000L : WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        }
    }

    private static void xt(Context context, boolean z5) {
        if (context == null) {
            return;
        }
        int wq = v.xt().wq();
        if (wq <= 0 || wq == Integer.MAX_VALUE) {
            wq = 100;
        }
        int s5 = v.xt().s();
        if (s5 > wq) {
            s5 = 5;
            wq = 10;
        }
        com.bytedance.sdk.component.tl.xt.j.j(new j.C0417j().cw(com.bytedance.sdk.component.tl.xt.r.xt.j.j(s5, wq)).j(com.bytedance.sdk.component.tl.xt.r.xt.j.j(1, wq)).xt(com.bytedance.sdk.component.tl.xt.r.xt.j.j(1, wq)).xt(z5).j("csj").j(context).j(new g()).j(tl.f29349j).j(v.xt().p()).j());
    }

    public static com.bytedance.sdk.openadsdk.core.kt.cw.j cw() {
        return jy.f29343j;
    }

    public static void r() {
        try {
            com.bytedance.sdk.component.tl.xt.j.xt("csj");
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r(f29420r, e6.getMessage());
        }
    }

    static {
        HashSet hashSet = new HashSet();
        up = hashSet;
        hashSet.add("click_start");
        hashSet.add("download_start");
        hashSet.add("download_finish");
        hashSet.add("install_finish");
        hashSet.add(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK);
        hashSet.add(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW);
    }

    public static void j() {
        com.bytedance.sdk.component.tl.xt.j.j(false, "csj");
    }

    public static void j(com.bytedance.sdk.component.tl.xt.r.j.j jVar, String str, int i6) {
        if (com.bytedance.sdk.component.tl.xt.j.j("csj")) {
            j(v.getContext(), com.bytedance.sdk.openadsdk.core.multipro.xt.cw());
        }
        if (v.xt().oy()) {
            return;
        }
        com.bytedance.sdk.component.tl.xt.j.j(jVar, "csj");
    }

    private static void j(String str, com.bytedance.sdk.component.tl.xt.r.j.j jVar) {
        if (v.xt().tj()) {
            try {
                jVar.cw(com.bytedance.sdk.component.tl.xt.cw.j.xt(str));
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.cw(e6.getMessage());
            }
        }
    }

    public static void j(com.bytedance.sdk.openadsdk.core.jy.j jVar, String str) {
        if (!v.xt().oy() || up.contains(str)) {
            com.bytedance.sdk.component.tl.xt.r.j.j jVar2 = new com.bytedance.sdk.component.tl.xt.r.j.j(jVar.r(), jVar);
            jVar2.xt(jVar.m() ? (byte) 1 : (byte) 2);
            jVar2.j((byte) 0);
            j(jVar.cw(), jVar2);
            if (com.bytedance.sdk.component.tl.xt.j.j("csj")) {
                j(v.getContext(), com.bytedance.sdk.openadsdk.core.multipro.xt.cw());
            }
            com.bytedance.sdk.component.tl.xt.j.j(jVar2, "csj");
            com.bytedance.sdk.openadsdk.core.ch.cw cwVar = (com.bytedance.sdk.openadsdk.core.ch.cw) AutoService.j(com.bytedance.sdk.openadsdk.core.ch.cw.class);
            if (cwVar != null) {
                cwVar.j(str, jVar2);
            }
        }
    }

    public static void xt() {
        com.bytedance.sdk.component.tl.xt.j.j(tl.f29349j, "csj");
    }

    public static void j(String str, List<String> list, boolean z5, Map<String, String> map, JSONObject jSONObject) {
        if (list == null || list.size() == 0) {
            return;
        }
        list.size();
        if (com.bytedance.sdk.component.tl.xt.j.j("csj")) {
            j(v.getContext(), com.bytedance.sdk.openadsdk.core.multipro.xt.cw());
        }
        com.bytedance.sdk.component.tl.xt.j.j("csj", str, j(list, f.j(false)), z5, map, jSONObject);
    }

    public static List<String> j(List<String> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList(list);
            list = new ArrayList<>();
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                String str2 = (String) arrayList.get(i6);
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.contains("{OAID}") || str2.contains("__OAID__")) {
                        str2 = str2.replace("{OAID}", str).replace("__OAID__", str);
                    }
                    list.add(str2);
                }
            }
        }
        return list;
    }

    public static void j(String str) {
        if (com.bytedance.sdk.component.tl.xt.j.j("csj")) {
            j(v.getContext(), com.bytedance.sdk.openadsdk.core.multipro.xt.cw());
        }
        com.bytedance.sdk.component.tl.xt.j.j("csj", str);
    }
}
