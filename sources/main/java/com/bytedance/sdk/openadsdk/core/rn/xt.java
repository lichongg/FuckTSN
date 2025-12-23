package com.bytedance.sdk.openadsdk.core.rn;

import android.os.SystemClock;
import android.text.TextUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.v2.persistent.db.IBaseDBOperator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f30175j;
    private com.bytedance.sdk.component.r.j.xt ae;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.component.r.j.xt f30176g;
    private com.bytedance.sdk.component.r.j.xt oq;
    private com.bytedance.sdk.component.r.j.xt tl;
    private volatile int qv = 0;
    private int vl = 0;
    private int jy = 0;
    private final Map<String, Integer> xt = new HashMap();
    private final ConcurrentHashMap<String, Integer> cw = new ConcurrentHashMap<>();

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, Long> f30178r = new HashMap();
    private final ConcurrentHashMap<String, Long> up = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private final long f30177m = SystemClock.elapsedRealtime();

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.r.j.xt ae() {
        if (this.oq == null) {
            this.oq = h.j("activity_recorder");
        }
        return this.oq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.r.j.xt m() {
        if (this.f30176g == null) {
            this.f30176g = h.j("activity_foreground_time");
        }
        return this.f30176g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.r.j.xt up() {
        if (this.tl == null) {
            this.tl = h.j("activity_adshow_count");
        }
        return this.tl;
    }

    public void cw(String str) {
        Long remove;
        if (TextUtils.isEmpty(str) || (remove = this.up.remove(str)) == null) {
            return;
        }
        long elapsedRealtime = (SystemClock.elapsedRealtime() - remove.longValue()) / 1000;
        if (elapsedRealtime >= 0) {
            Long l6 = this.f30178r.get(str);
            if (l6 == null || l6.longValue() < 0) {
                l6 = 0L;
            }
            this.f30178r.put(str, Long.valueOf(l6.longValue() + elapsedRealtime));
            j(str, elapsedRealtime);
        }
    }

    public void r(final String str) {
        com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.xt.3
            @Override // java.lang.Runnable
            public void run() {
                xt.this.up().j(str, xt.this.up().xt(str, 0) + 1);
            }
        });
    }

    public void xt(final String str) {
        com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.xt.1
            @Override // java.lang.Runnable
            public void run() {
                xt.this.r().j(str, xt.this.r().xt(str, 0) + 1);
                if (xt.this.qv == 0) {
                    xt xtVar = xt.this;
                    xtVar.qv = xtVar.ae().xt("histRunningCount", 0) + 1;
                    xt.this.ae().j("histRunningCount", xt.this.qv);
                }
            }
        });
    }

    private xt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.r.j.xt r() {
        if (this.ae == null) {
            this.ae = h.j("activity_resume_count");
        }
        return this.ae;
    }

    public void xt() {
        if (this.up.size() == 1) {
            for (String str : this.up.keySet()) {
                Integer num = this.cw.get(str);
                this.cw.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                r(str);
            }
        }
    }

    public static xt j() {
        if (f30175j == null) {
            synchronized (xt.class) {
                try {
                    if (f30175j == null) {
                        f30175j = new xt();
                    }
                } finally {
                }
            }
        }
        return f30175j;
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.xt.get(str);
        this.xt.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.up.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        if (this.up.size() > 1) {
            this.vl++;
        }
        xt(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        try {
            Map<String, ?> all = r().getAll();
            if (all == null) {
                return;
            }
            Iterator<?> it = all.values().iterator();
            int i6 = 0;
            while (it.hasNext()) {
                i6 += ((Integer) it.next()).intValue();
            }
            if (i6 != 0 && i6 % 75 == 0) {
                final JSONArray jSONArray = new JSONArray();
                for (String str : this.xt.keySet()) {
                    Integer num = this.xt.get(str);
                    Long l6 = this.f30178r.get(str);
                    Integer num2 = this.cw.get(str);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(CommonNetImpl.NAME, str);
                        jSONObject.put("rc", num != null ? num.intValue() : 0);
                        jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_FRIST_TIME, l6 != null ? l6.longValue() : 0L);
                        jSONObject.put(IBaseDBOperator.ORDER_BY_ASC, num2 != null ? num2.intValue() : 0);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                    }
                }
                final JSONArray jSONArray2 = new JSONArray();
                Map<String, ?> all2 = m().getAll();
                Map<String, ?> all3 = up().getAll();
                if (all2 != null && all3 != null) {
                    for (String str2 : all.keySet()) {
                        Integer num3 = (Integer) all.get(str2);
                        Long l7 = (Long) all2.get(str2);
                        Integer num4 = (Integer) all3.get(str2);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CommonNetImpl.NAME, str2);
                            jSONObject2.put("rc", num3 != null ? num3.intValue() : 0);
                            jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_FRIST_TIME, l7 != null ? l7.longValue() : 0L);
                            jSONObject2.put(IBaseDBOperator.ORDER_BY_ASC, num4 != null ? num4.intValue() : 0);
                            jSONArray2.put(jSONObject2);
                        } catch (JSONException e7) {
                            com.bytedance.sdk.component.utils.vl.j(e7);
                        }
                    }
                }
                final long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f30177m) / 1000;
                com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.xt.4
                    @Override // com.bytedance.sdk.openadsdk.vl.j.j
                    public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("ara", jSONArray);
                        jSONObject3.put("hara", jSONArray2);
                        jSONObject3.put("rt", elapsedRealtime);
                        jSONObject3.put("hrc", xt.this.qv);
                        jSONObject3.put("drc", xt.this.vl);
                        return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("ad_activity_record").xt(jSONObject3.toString());
                    }
                }, "ad_activity_record");
            }
        } catch (Throwable unused) {
        }
    }

    public void j(final String str, final long j6) {
        com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.xt.2
            @Override // java.lang.Runnable
            public void run() {
                long xt = xt.this.m().xt(str, 0L);
                xt.this.m().j(str, (xt >= 0 ? xt : 0L) + j6);
                xt.this.cw();
                xt.this.j(j6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j6) {
        int i6 = this.jy;
        if (i6 == 0) {
            try {
                Map<String, ?> all = m().getAll();
                if (all != null) {
                    Iterator<?> it = all.values().iterator();
                    while (it.hasNext()) {
                        this.jy = (int) (this.jy + ((Long) it.next()).longValue());
                    }
                }
            } catch (Throwable unused) {
                this.jy = -1;
            }
        } else {
            this.jy = (int) (i6 + j6);
        }
        v.j(this.jy, this.qv);
    }
}
