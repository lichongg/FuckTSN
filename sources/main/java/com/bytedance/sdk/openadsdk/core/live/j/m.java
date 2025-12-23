package com.bytedance.sdk.openadsdk.core.live.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.jy.ae;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.tj.hl;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qb;
import com.bytedance.sdk.openadsdk.core.x;
import com.umeng.analytics.pro.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class m extends com.bytedance.sdk.openadsdk.core.live.j.j {

    /* renamed from: m, reason: collision with root package name */
    protected volatile SoftReference<n> f29473m;

    /* renamed from: r, reason: collision with root package name */
    protected String f29474r;
    protected String up;

    protected interface j {
        void j(boolean z5);
    }

    public static String xt(int i6) {
        switch (i6) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                return EnterMethod.LIVE_CELL.lowerName();
            case 5:
                return EnterMethod.LIVE_CARD.lowerName();
            default:
                return EnterMethod.NO_VALUE.lowerName();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    @Deprecated
    public int b_(n nVar) {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int j(n nVar, cw cwVar, String str) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.j
    protected boolean x_() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011d A[Catch: Exception -> 0x0103, TryCatch #11 {Exception -> 0x0103, blocks: (B:51:0x00f9, B:53:0x011d, B:55:0x0127), top: B:50:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0208 A[Catch: Exception -> 0x025c, TryCatch #4 {Exception -> 0x025c, blocks: (B:70:0x01e1, B:72:0x0208, B:73:0x025e, B:75:0x028d, B:76:0x0290, B:78:0x029c, B:79:0x02a2), top: B:69:0x01e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x028d A[Catch: Exception -> 0x025c, TryCatch #4 {Exception -> 0x025c, blocks: (B:70:0x01e1, B:72:0x0208, B:73:0x025e, B:75:0x028d, B:76:0x0290, B:78:0x029c, B:79:0x02a2), top: B:69:0x01e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x029c A[Catch: Exception -> 0x025c, TryCatch #4 {Exception -> 0x025c, blocks: (B:70:0x01e1, B:72:0x0208, B:73:0x025e, B:75:0x028d, B:76:0x0290, B:78:0x029c, B:79:0x02a2), top: B:69:0x01e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.os.Bundle cw(android.content.Context r25, com.bytedance.sdk.openadsdk.core.tj.n r26, java.util.Map<java.lang.String, java.lang.Object> r27) {
        /*
            Method dump skipped, instructions count: 877
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.j.m.cw(android.content.Context, com.bytedance.sdk.openadsdk.core.tj.n, java.util.Map):android.os.Bundle");
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.j
    public void a_(String str) {
        this.up = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public String ae() {
        return this.up;
    }

    private int up(n nVar) {
        String sz = nVar.sz();
        Integer num = (Integer) x.j(nVar.uv(), Integer.class);
        if ((num != null && num.intValue() > 0) || TextUtils.isEmpty(sz)) {
            return 0;
        }
        try {
            return new JSONObject(sz).optInt("auth_reward_gold");
        } catch (Throwable th) {
            vl.cw("TTLiveSDkBridge", th);
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.j, com.bytedance.sdk.openadsdk.core.live.j.r
    public void j(Function<SparseArray<Object>, Object> function) {
        super.j(function);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int j(final Context context, final n nVar, final Map<String, Object> map) {
        String str;
        final String str2;
        r(nVar);
        if (!a_(nVar)) {
            return 6;
        }
        vl.j("TTLiveSDkBridge", "openLive key:" + nVar.uv());
        if (map != null) {
            str = (String) map.get("event_tag");
        } else {
            str = "";
        }
        String str3 = str;
        final int ww = nVar.ww();
        if (!m()) {
            j(nVar, str3, ww, 1, ww == 7 ? 1 : 2);
            return 1;
        }
        nVar.hm();
        if (this.f29472j == null) {
            return 4;
        }
        this.xt = str3;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long currentTimeMillis = System.currentTimeMillis();
        if (up() != 2 ? j(nVar, new j() { // from class: com.bytedance.sdk.openadsdk.core.live.j.m.1
            @Override // com.bytedance.sdk.openadsdk.core.live.j.m.j
            public void j(boolean z5) {
                boolean z6;
                if (atomicBoolean.compareAndSet(false, true)) {
                    m mVar = m.this;
                    mVar.j(context, nVar, ww, mVar.xt, (Map<String, Object>) map);
                    z6 = false;
                } else {
                    z6 = true;
                }
                ws.j().j(nVar, System.currentTimeMillis() - currentTimeMillis, z5, z6);
            }
        }, true) : false) {
            qb uw = nVar.uw();
            if (uw != null) {
                long up = uw.up();
                if (up > 0) {
                    str2 = str3;
                    tl.cw().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.j.m.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                m.this.j(context, nVar, ww, str2, (Map<String, Object>) map);
                            }
                        }
                    }, up);
                } else {
                    str2 = str3;
                }
                if (uw.m() == 1 && oq.i().r() != null) {
                    new com.bytedance.sdk.openadsdk.core.jy.ae().j(new ae.j() { // from class: com.bytedance.sdk.openadsdk.core.live.j.m.3
                        @Override // com.bytedance.sdk.openadsdk.core.jy.ae.j
                        public void j(boolean z5) {
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.jy.ae.j
                        public void j() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                m.this.j(context, nVar, ww, str2, (Map<String, Object>) map);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.jy.ae.j
                        public void j(String str4) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                m.this.j(context, nVar, ww, str2, (Map<String, Object>) map);
                            }
                        }
                    });
                }
            }
            return 0;
        }
        return j(context, nVar, ww, str3, map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int xt(Context context, n nVar, Map<String, Object> map) {
        Object obj;
        long longValue;
        if (map != null) {
            try {
                obj = map.get("reward_countdown");
            } catch (Exception e6) {
                vl.xt("TTLiveSDkBridge", e6.toString());
            }
            if (obj instanceof Long) {
                longValue = ((Long) obj).longValue();
                if (context != null || nVar == null) {
                    return 5;
                }
                if (!(context instanceof Activity)) {
                    return 7;
                }
                if (!hl.j(nVar)) {
                    return 5;
                }
                if (longValue < 0) {
                    return 8;
                }
                if (hl.xt(nVar) == 1) {
                    return 9;
                }
                return j(context, nVar, map);
            }
        }
        longValue = 0;
        if (context != null) {
        }
        return 5;
    }

    protected boolean j(n nVar, final j jVar, boolean z5) {
        qb uw;
        if (this.up == null || (uw = nVar.uw()) == null || uw.cw() == 0) {
            return false;
        }
        try {
            if (Integer.parseInt(this.up.replaceAll("\\.", "")) < 211413) {
                return false;
            }
        } catch (Exception unused) {
        }
        int xt = uw.xt();
        boolean z6 = xt > 0;
        if (z5) {
            z6 = xt == 3;
        }
        if (z6) {
            this.f29473m = new SoftReference<>(nVar);
            if (j(new com.bytedance.sdk.openadsdk.core.live.xt.xt() { // from class: com.bytedance.sdk.openadsdk.core.live.j.m.4
                @Override // com.bytedance.sdk.openadsdk.core.live.xt.xt
                protected void j(Object obj) {
                    if (obj instanceof Map) {
                        Map map = (Map) obj;
                        if (map.containsKey("code")) {
                            Object obj2 = map.get("code");
                            if (obj2 instanceof String) {
                                try {
                                    int parseInt = Integer.parseInt((String) obj2);
                                    r1 = parseInt == 1;
                                    vl.j("TTLiveSDkBridge", "requestDyAuth result:".concat(String.valueOf(parseInt)));
                                } catch (NumberFormatException unused2) {
                                }
                            }
                        }
                    }
                    jVar.j(r1);
                }
            }, xt == 3) == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j(Context context, n nVar, int i6, String str, Map<String, Object> map) {
        int i7;
        int i8;
        int i9;
        int i10;
        Object apply;
        int i11;
        vl.j("TTLiveSDkBridge", "openLive key:" + nVar.hm());
        if (this.f29472j != null) {
            int i12 = 0;
            apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(0).j(Integer.class).j(0, new la().j(d.X, context).j("bundle", cw(context, nVar, map))).xt());
            i7 = apply != null ? ((Integer) apply).intValue() : 0;
            this.xt = str;
            this.f29474r = nVar.uv();
            if (i7 == 0) {
                this.f29473m = new SoftReference<>(nVar);
                int j6 = com.bytedance.sdk.openadsdk.core.live.up.cw.j(map);
                if (j6 == 101 || j6 == 102) {
                    i7 |= j6 << 8;
                } else if (j(nVar, j6)) {
                    i12 = cw(nVar);
                    i6 = 7;
                    if (i12 == 0) {
                        try {
                            new com.bytedance.sdk.openadsdk.core.live.cw.j().j(str).j(context, nVar);
                            i7 |= j6 << 8;
                        } catch (Exception e6) {
                            vl.j(e6);
                        }
                        i11 = 7;
                    } else {
                        i11 = 2;
                    }
                    i9 = i11;
                    i8 = i6;
                    i10 = i12;
                }
            } else {
                i12 = 3;
            }
            i11 = i6;
            i9 = i11;
            i8 = i6;
            i10 = i12;
        } else {
            i7 = 4;
            i8 = i6;
            i9 = i8;
            i10 = 1;
        }
        j(nVar, str, i8, i9, i10);
        return i7;
    }

    private void j(JSONArray jSONArray, n nVar) {
        com.bytedance.sdk.openadsdk.core.live.r.j jVar;
        if (nVar == null || jSONArray == null || (jVar = (com.bytedance.sdk.openadsdk.core.live.r.j) x.j(nVar.uv(), com.bytedance.sdk.openadsdk.core.live.r.j.class)) == null || jVar.xt.isEmpty()) {
            return;
        }
        String fs = nVar.fs();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                String optString = jSONObject.optString("type");
                if (jVar.xt.contains(fs + "_" + optString)) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static String j(int i6) {
        if (i6 == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION.lowerName();
        }
        if (i6 == 8) {
            return EnterFromMerge.AD_UNION_INSERT.lowerName();
        }
        if (i6 == 5) {
            return EnterFromMerge.AD_UNION_FEED.lowerName();
        }
        if (i6 == 9) {
            return EnterFromMerge.AD_UNION_DRAW.lowerName();
        }
        if (i6 == 1) {
            return "ad_union_banner";
        }
        if (i6 == 3 || i6 == 4) {
            return "ad_union_topview";
        }
        if (i6 == 2) {
            return "ad_union_former_insert";
        }
        if (i6 == 6) {
            return "ad_union_patch";
        }
        return EnterFromMerge.NO_VALUE.lowerName();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public boolean j(n nVar) {
        return a_(nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int j(String str) {
        Object apply;
        if (TextUtils.isEmpty(str)) {
            return 10;
        }
        if (this.f29472j == null) {
            return 12;
        }
        if (!m()) {
            return 11;
        }
        Object ry = oq.i().ry();
        if (ry == null) {
            return 13;
        }
        try {
            apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8).j(Boolean.class).j(0, new la().j(d.X, ry).j("scheme_uri", str)).xt());
            return apply != null ? ((Boolean) apply).booleanValue() : false ? 1 : 10;
        } catch (Exception unused) {
            return 14;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int j(com.bytedance.sdk.openadsdk.core.live.xt.xt xtVar, boolean z5) {
        Object apply;
        if (this.f29472j == null) {
            return 12;
        }
        if (!m()) {
            return 11;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("expand_method_name", "requestDyAuth");
        hashMap.put("expand_method_param", new Object[]{oq.i().ry(), xtVar, Boolean.valueOf(z5)});
        apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(7).j(Void.class).j(0, hashMap).xt());
        vl.j("TTLiveSDkBridge", "requestDyAuth:" + apply + ", syncAuth = " + z5);
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.j, com.bytedance.sdk.openadsdk.core.live.j.r
    public void j(String str, n nVar, long j6) {
        com.bytedance.sdk.openadsdk.core.video.cw.j.j(str, nVar, j6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public void j(String str, boolean z5) {
        if (this.f29472j != null && m()) {
            HashMap hashMap = new HashMap();
            hashMap.put("expand_method_name", str);
            hashMap.put("expand_method_param", new Object[]{Boolean.valueOf(z5)});
            this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(7).j(Void.class).j(0, hashMap).xt());
        }
    }
}
