package com.bytedance.sdk.openadsdk.m.xt;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.ch.jy;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.m.cw.ae;
import com.bytedance.sdk.openadsdk.m.cw.av;
import com.bytedance.sdk.openadsdk.m.cw.az;
import com.bytedance.sdk.openadsdk.m.cw.i;
import com.bytedance.sdk.openadsdk.m.cw.m;
import com.bytedance.sdk.openadsdk.m.cw.oq;
import com.bytedance.sdk.openadsdk.m.cw.qv;
import com.bytedance.sdk.openadsdk.m.cw.tl;
import com.bytedance.sdk.openadsdk.m.cw.up;
import com.bytedance.sdk.openadsdk.m.cw.ws;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static final Map<com.bykv.vk.openvk.component.video.api.xt.j, i> f31611j = Collections.synchronizedMap(new WeakHashMap());

    public static void cw(com.bytedance.sdk.openadsdk.m.cw.xt<qv> xtVar) {
        xt(xtVar, "load_video_error");
    }

    public static void r(com.bytedance.sdk.openadsdk.m.cw.xt<oq> xtVar) {
        xt(xtVar, "load_video_cancel");
    }

    public static void up(final com.bykv.vk.openvk.component.video.api.xt.j jVar, final i.j jVar2) {
        cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.11
            @Override // java.lang.Runnable
            public void run() {
                i.j jVar3;
                if (com.bykv.vk.openvk.component.video.api.xt.j.this == null || (jVar3 = jVar2) == null) {
                    return;
                }
                if (jVar3.vl() <= 0) {
                    vl.j("VideoEventManager", "Cancel log report when buffer count is 0");
                    return;
                }
                i iVar = (i) r.f31611j.get(com.bykv.vk.openvk.component.video.api.xt.j.this);
                if (iVar == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.cw.r r5 = iVar.r();
                n up = iVar.up();
                if (r5 == null || up == null) {
                    return;
                }
                long r6 = jVar2.r();
                if (r6 <= 0) {
                    return;
                }
                ws wsVar = new ws();
                wsVar.j(jVar2.cw());
                wsVar.xt(r6);
                wsVar.j(jVar2.vl());
                JSONObject j6 = r.j(r5, iVar.xt(), iVar.cw(), r5.w(), up, SystemClock.elapsedRealtime() - iVar.j());
                r.j(j6, r5.up("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.m.cw.xt xtVar = new com.bytedance.sdk.openadsdk.m.cw.xt(up, uf.xt(up), j6, wsVar);
                xtVar.j(jVar2.jy());
                r.xt(xtVar, "play_buffer");
            }
        });
    }

    public static void cw(final com.bykv.vk.openvk.component.video.api.xt.j jVar, final i.j jVar2) {
        cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.8
            @Override // java.lang.Runnable
            public void run() {
                i iVar;
                if (com.bykv.vk.openvk.component.video.api.xt.j.this == null || jVar2 == null || (iVar = (i) r.f31611j.get(com.bykv.vk.openvk.component.video.api.xt.j.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.cw.r r5 = iVar.r();
                n up = iVar.up();
                if (r5 == null || up == null) {
                    return;
                }
                long xt = jVar2.xt();
                long r6 = jVar2.r();
                com.bytedance.sdk.openadsdk.m.cw.cw cwVar = new com.bytedance.sdk.openadsdk.m.cw.cw();
                cwVar.cw(jVar2.cw());
                cwVar.r(r6);
                cwVar.xt(jVar2.ae());
                cwVar.cw(jVar2.tl());
                cwVar.xt(g.j(up.ly()).xt(r5));
                cwVar.j(xt);
                cwVar.j(jVar2.g());
                JSONObject j6 = r.j(r5, iVar.xt(), iVar.cw(), r5.w(), up, SystemClock.elapsedRealtime() - iVar.j());
                r.j(j6, r5.up("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.m.cw.xt xtVar = new com.bytedance.sdk.openadsdk.m.cw.xt(up, uf.xt(up), j6, cwVar);
                xtVar.j(jVar2.jy());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", xt);
                    jSONObject.put("percent", jVar2.g());
                    r.xt(xtVar, "endcard_skip", jSONObject);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        r.f31611j.remove(com.bykv.vk.openvk.component.video.api.xt.j.this);
                    }
                }, 1000L);
            }
        });
    }

    public static void r(final com.bykv.vk.openvk.component.video.api.xt.j jVar, final i.j jVar2) {
        cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.10
            @Override // java.lang.Runnable
            public void run() {
                i.j jVar3;
                com.bykv.vk.openvk.component.video.api.xt.j jVar4 = com.bykv.vk.openvk.component.video.api.xt.j.this;
                if (jVar4 == null || (jVar3 = jVar2) == null) {
                    return;
                }
                r.up(jVar4, jVar3);
                i iVar = (i) r.f31611j.get(com.bykv.vk.openvk.component.video.api.xt.j.this);
                if (iVar == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.cw.r r5 = iVar.r();
                n up = iVar.up();
                if (r5 == null || up == null) {
                    return;
                }
                long xt = jVar2.xt();
                long r6 = jVar2.r();
                if (r6 <= 0) {
                    return;
                }
                ae aeVar = new ae();
                aeVar.xt(jVar2.cw());
                aeVar.j(r6);
                aeVar.j(jVar2.qv());
                JSONObject j6 = r.j(r5, iVar.xt(), iVar.cw(), r5.w(), up, SystemClock.elapsedRealtime() - iVar.j());
                r.j(j6, r5.up("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.m.cw.xt xtVar = new com.bytedance.sdk.openadsdk.m.cw.xt(up, uf.xt(up), j6, aeVar);
                xtVar.j(jVar2.jy());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", xt);
                    jSONObject.put("percent", jVar2.g());
                    jy.j(xt, up, r5);
                    r.xt(xtVar, r.xt(up, "feed_over"), jSONObject);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                r.f31611j.remove(com.bykv.vk.openvk.component.video.api.xt.j.this);
            }
        });
    }

    private static boolean up(com.bytedance.sdk.openadsdk.m.cw.xt xtVar) {
        n j6;
        com.bytedance.sdk.openadsdk.i.cw.cw.xt rr;
        if (xtVar == null || !xtVar.up() || (j6 = xtVar.j()) == null || (rr = j6.rr()) == null) {
            return false;
        }
        String f6 = rr.f();
        if (TextUtils.isEmpty(f6)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(f6);
            int length = jSONArray.length();
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            for (int i6 = 0; i6 < length; i6++) {
                String optString = jSONArray.getJSONObject(i6).optString(CommonNetImpl.NAME);
                if ("content_did".equalsIgnoreCase(optString)) {
                    z5 = true;
                } else if ("content_utmsource".equalsIgnoreCase(optString)) {
                    z6 = true;
                } else if ("content_sdk_version".equalsIgnoreCase(optString)) {
                    z7 = true;
                }
            }
            return z5 && z6 && z7;
        } catch (JSONException e6) {
            e6.getMessage();
            return false;
        }
    }

    public static void xt(com.bytedance.sdk.openadsdk.m.cw.xt<com.bytedance.sdk.openadsdk.m.cw.jy> xtVar) {
        xt(xtVar, "load_video_success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long cw(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        if (rVar == null) {
            return 0L;
        }
        com.bykv.vk.openvk.component.video.api.cw.cw x5 = rVar.ws() ? rVar.x() : rVar.v();
        if (x5 != null) {
            return Double.valueOf(x5.m() * 1000.0d).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String r(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        return new File(rVar.up(), rVar.i()).getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String xt(n nVar, String str) {
        if (nVar == null || !uf.m(nVar) || !uf.ae(nVar)) {
            return str;
        }
        str.getClass();
        switch (str) {
        }
        return str;
    }

    public static JSONObject j(com.bykv.vk.openvk.component.video.api.cw.r rVar, String str, int i6, int i7, n nVar, long j6) {
        com.bykv.vk.openvk.component.video.api.cw.cw v5;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i6 > 0) {
                jSONObject.put("play_type", String.valueOf(i6));
            }
            if (com.bytedance.sdk.openadsdk.l.oq.j(nVar)) {
                jSONObject.put("is_audio", 1);
            }
            if (rVar != null) {
                if (rVar.ws()) {
                    v5 = rVar.x();
                    jSONObject.put("codec", "h265");
                } else {
                    v5 = rVar.v();
                }
                if (v5 != null) {
                    jSONObject.put("video_resolution", v5.g());
                    jSONObject.put("video_size", Long.valueOf(v5.up()));
                    String vl = v5.vl();
                    jSONObject.put("video_url", vl);
                    jSONObject.put("is_expired", uf.vl(vl));
                    jSONObject.put("send_duration", Math.floor(System.currentTimeMillis() - (uf.vl(nVar) * 1000.0d)));
                    jSONObject.put("start_duration", j6);
                    jSONObject.put("player_type", i7);
                    jSONObject.put("play_speed_ratio", v5.tl());
                    if (v5.ae() > 0.0d) {
                        jSONObject.put("start", v5.ae());
                    }
                }
            }
            if (nVar != null) {
                jSONObject.put("dynamic_join_type", nVar.to());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void xt(final com.bykv.vk.openvk.component.video.api.xt.j jVar, final i.j jVar2) {
        cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.6
            @Override // java.lang.Runnable
            public void run() {
                i iVar;
                if (com.bykv.vk.openvk.component.video.api.xt.j.this == null || jVar2 == null || (iVar = (i) r.f31611j.get(com.bykv.vk.openvk.component.video.api.xt.j.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.cw.r r5 = iVar.r();
                n up = iVar.up();
                if (r5 == null || up == null) {
                    return;
                }
                long xt = jVar2.xt();
                long r6 = jVar2.r();
                if (r6 <= 0 || xt <= 0) {
                    return;
                }
                m mVar = new m();
                mVar.j(jVar2.cw());
                mVar.xt(r6);
                JSONObject j6 = r.j(r5, iVar.xt(), iVar.cw(), r5.w(), up, SystemClock.elapsedRealtime() - iVar.j());
                r.j(j6, r5.up("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.m.cw.xt xtVar = new com.bytedance.sdk.openadsdk.m.cw.xt(up, uf.xt(up), j6, mVar);
                xtVar.j(jVar2.jy());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", xt);
                    jSONObject.put("percent", jVar2.g());
                    r.xt(xtVar, "feed_continue", jSONObject);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(com.bytedance.sdk.openadsdk.m.cw.xt xtVar, String str) {
        xt(xtVar, str, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(final com.bytedance.sdk.openadsdk.m.cw.xt xtVar, String str, JSONObject jSONObject) {
        if (xtVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (xtVar.up() && !TextUtils.isEmpty(xtVar.xt()) && !up(xtVar)) {
            String xt = xtVar.xt();
            xt.getClass();
            switch (xt) {
                case "stream":
                case "embeded_ad":
                case "draw_ad":
                    str = "customer_".concat(String.valueOf(str));
                    break;
            }
        }
        xt.j(str, xtVar.j());
        com.bytedance.sdk.openadsdk.core.jy.cw.j(xtVar.j(), xtVar.xt(), str, jSONObject, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.2
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                JSONObject cw = com.bytedance.sdk.openadsdk.m.cw.xt.this.cw();
                if (com.bytedance.sdk.openadsdk.m.cw.xt.this.r() != null) {
                    com.bytedance.sdk.openadsdk.m.cw.xt.this.r().a_(cw);
                }
                jSONObject2.put("ad_extra_data", cw.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(final n nVar, final com.bykv.vk.openvk.component.video.api.cw.r rVar, final i.j jVar) {
        com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.3
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", r.cw(com.bykv.vk.openvk.component.video.api.cw.r.this));
                jSONObject.put("player_duration", jVar.r());
                jSONObject.put("cache_path_type", g.r());
                jSONObject.put("url", com.bykv.vk.openvk.component.video.api.cw.r.this.av());
                jSONObject.put("path", r.r(com.bykv.vk.openvk.component.video.api.cw.r.this));
                jSONObject.put("player_type", com.bykv.vk.openvk.component.video.api.cw.r.this.w());
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("pangle_video_play_state").j(uf.tl(nVar)).xt(jSONObject.toString());
            }
        }, "pangle_video_play_state");
    }

    public static synchronized com.bykv.vk.openvk.component.video.api.cw.r xt(com.bykv.vk.openvk.component.video.api.xt.j jVar) {
        synchronized (r.class) {
            if (jVar == null) {
                return null;
            }
            i iVar = f31611j.get(jVar);
            if (iVar == null) {
                return null;
            }
            return iVar.r();
        }
    }

    public static void j(com.bytedance.sdk.openadsdk.m.cw.xt<com.bytedance.sdk.openadsdk.m.cw.vl> xtVar) {
        xt(xtVar, "load_video_start");
    }

    public static boolean j(n nVar, com.bykv.vk.openvk.component.video.api.xt.j jVar, com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        int ly = nVar.ly();
        com.bykv.vk.openvk.component.video.api.j.xt j6 = g.j(ly);
        if (ly != 0) {
            if (ly == 1) {
                return j6.j(rVar);
            }
            return false;
        }
        long xt = j6.xt(rVar);
        boolean jy = rVar.jy();
        int m6 = rVar.m();
        if (jy) {
            m6 = (int) rVar.vl();
        }
        int xt2 = rVar.xt();
        if (xt2 > 0) {
            m6 = xt2;
        }
        return xt >= ((long) m6);
    }

    public static void j(final n nVar, final com.bykv.vk.openvk.component.video.api.xt.j jVar, final com.bykv.vk.openvk.component.video.api.cw.r rVar, final boolean z5) {
        cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.1
            @Override // java.lang.Runnable
            public void run() {
                if (n.this == null || jVar == null || rVar == null) {
                    return;
                }
                String uuid = UUID.randomUUID().toString();
                com.bykv.vk.openvk.component.video.api.j.xt j6 = g.j(n.this.ly());
                int i6 = r.j(n.this, jVar, rVar) ? 1 : 2;
                r.f31611j.put(jVar, new i(SystemClock.elapsedRealtime(), uuid, i6, rVar, n.this));
                long xt = j6.xt(rVar);
                av avVar = new av();
                if (xt > 0) {
                    avVar.j(xt);
                }
                avVar.j(z5);
                jy.j(i6, xt, n.this, rVar);
                com.bykv.vk.openvk.component.video.api.cw.r rVar2 = rVar;
                JSONObject j7 = r.j(rVar2, uuid, i6, rVar2.w(), n.this, 0L);
                r.j(j7, rVar.up("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.m.cw.xt xtVar = new com.bytedance.sdk.openadsdk.m.cw.xt(n.this, uf.xt(n.this), j7, avVar);
                xtVar.j(rVar.w() == -1);
                r.xt(xtVar, "play_start");
            }
        });
    }

    public static void j(final com.bykv.vk.openvk.component.video.api.xt.j jVar, final i.j jVar2) {
        cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.4
            @Override // java.lang.Runnable
            public void run() {
                i iVar;
                if (com.bykv.vk.openvk.component.video.api.xt.j.this == null || jVar2 == null || (iVar = (i) r.f31611j.get(com.bykv.vk.openvk.component.video.api.xt.j.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.cw.r r5 = iVar.r();
                n up = iVar.up();
                if (r5 == null || up == null) {
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.l.oq.j(up) || kt.xt(up)) {
                    if (!jVar2.jy()) {
                        r.xt(up, r5, jVar2);
                    }
                    com.bytedance.sdk.openadsdk.m.cw.g gVar = new com.bytedance.sdk.openadsdk.m.cw.g();
                    gVar.xt(jVar2.ws() ? 1 : 0);
                    gVar.j(jVar2.az() ? 1 : 0);
                    gVar.xt(g.j(up.ly()).xt(r5));
                    long elapsedRealtime = SystemClock.elapsedRealtime() - iVar.j();
                    gVar.j(elapsedRealtime);
                    JSONObject j6 = r.j(r5, iVar.xt(), iVar.cw(), r5.w(), up, elapsedRealtime);
                    r.j(j6, r5.up("EXTRA_PLAY_START"));
                    com.bytedance.sdk.openadsdk.m.cw.xt xtVar = new com.bytedance.sdk.openadsdk.m.cw.xt(up, uf.xt(up), j6, gVar);
                    xtVar.j(jVar2.jy());
                    r.xt(xtVar, r.xt(up, "feed_play"));
                }
            }
        });
    }

    public static String j(com.bykv.vk.openvk.component.video.api.xt.j jVar) {
        i iVar;
        if (jVar != null && (iVar = f31611j.get(jVar)) != null) {
            String xt = iVar.xt();
            if (!TextUtils.isEmpty(xt)) {
                return xt;
            }
        }
        return "empty";
    }

    public static void j(final com.bykv.vk.openvk.component.video.api.xt.j jVar, final i.j jVar2, final int i6) {
        cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.5
            @Override // java.lang.Runnable
            public void run() {
                i iVar;
                if (com.bykv.vk.openvk.component.video.api.xt.j.this == null || jVar2 == null || (iVar = (i) r.f31611j.get(com.bykv.vk.openvk.component.video.api.xt.j.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.cw.r r5 = iVar.r();
                n up = iVar.up();
                if (r5 == null || up == null) {
                    return;
                }
                long xt = jVar2.xt();
                long r6 = jVar2.r();
                if (r6 <= 0 || xt <= 0) {
                    return;
                }
                tl tlVar = new tl();
                tlVar.j(jVar2.cw());
                tlVar.xt(r6);
                tlVar.j(i6);
                tlVar.j(jVar2.av());
                JSONObject j6 = r.j(r5, iVar.xt(), iVar.cw(), r5.w(), up, SystemClock.elapsedRealtime() - iVar.j());
                r.j(j6, r5.up("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.m.cw.xt xtVar = new com.bytedance.sdk.openadsdk.m.cw.xt(up, uf.xt(up), j6, tlVar);
                xtVar.j(jVar2.jy());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", xt);
                    jSONObject.put("percent", jVar2.g());
                    r.xt(xtVar, "feed_pause", jSONObject);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        });
    }

    public static void j(final com.bykv.vk.openvk.component.video.api.xt.j jVar, final i.j jVar2, final String str, final int i6, final boolean z5) {
        cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.7
            @Override // java.lang.Runnable
            public void run() {
                i iVar;
                if (com.bykv.vk.openvk.component.video.api.xt.j.this == null || jVar2 == null || (iVar = (i) r.f31611j.get(com.bykv.vk.openvk.component.video.api.xt.j.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.cw.r r5 = iVar.r();
                n up = iVar.up();
                if (r5 == null || up == null) {
                    return;
                }
                long xt = jVar2.xt();
                long r6 = jVar2.r();
                if (r6 < 0) {
                    return;
                }
                az azVar = new az();
                azVar.cw(jVar2.cw());
                azVar.r(r6);
                azVar.cw(jVar2.up());
                azVar.r(jVar2.m());
                azVar.xt(i6);
                azVar.xt(g.j(up.ly()).xt(r5));
                azVar.j(str);
                JSONArray j6 = jVar2.j();
                if (j6 != null) {
                    azVar.j(j6);
                }
                azVar.j(xt);
                azVar.j(jVar2.g());
                azVar.j(z5);
                JSONObject j7 = r.j(r5, iVar.xt(), iVar.cw(), r5.w(), up, SystemClock.elapsedRealtime() - iVar.j());
                r.j(j7, r5.up("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.m.cw.xt xtVar = new com.bytedance.sdk.openadsdk.m.cw.xt(up, uf.xt(up), j7, azVar);
                xtVar.j(jVar2.jy());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", xt);
                    jSONObject.put("percent", jVar2.g());
                    r.xt(xtVar, "play_error", jSONObject);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        r.f31611j.remove(com.bykv.vk.openvk.component.video.api.xt.j.this);
                    }
                }, 1000L);
            }
        });
    }

    public static void j(final com.bykv.vk.openvk.component.video.api.xt.j jVar, final i.j jVar2, final Map<String, Object> map, final int i6) {
        cw.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.xt.r.9
            @Override // java.lang.Runnable
            public void run() {
                i iVar;
                if (com.bykv.vk.openvk.component.video.api.xt.j.this == null || jVar2 == null || (iVar = (i) r.f31611j.get(com.bykv.vk.openvk.component.video.api.xt.j.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.cw.r r5 = iVar.r();
                n up = iVar.up();
                if (r5 == null || up == null) {
                    return;
                }
                long xt = jVar2.xt();
                long r6 = jVar2.r();
                if (r6 <= 0) {
                    return;
                }
                up upVar = new up();
                upVar.xt(jVar2.cw());
                upVar.j(r6);
                upVar.xt(jVar2.oq());
                upVar.cw(jVar2.qv());
                upVar.j(i6);
                JSONObject j6 = r.j(r5, iVar.xt(), iVar.cw(), r5.w(), up, SystemClock.elapsedRealtime() - iVar.j());
                r.j(j6, map);
                com.bytedance.sdk.openadsdk.m.cw.xt xtVar = new com.bytedance.sdk.openadsdk.m.cw.xt(up, uf.xt(up), j6, upVar);
                xtVar.j(jVar2.jy());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", xt);
                    jSONObject.put("percent", jVar2.g());
                    jy.j(xt, up, r5);
                    r.xt(xtVar, r.xt(up, "feed_break"), jSONObject);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                r.f31611j.remove(com.bykv.vk.openvk.component.video.api.xt.j.this);
            }
        });
    }

    public static void j(JSONObject jSONObject, Object obj) {
        if (jSONObject == null) {
            return;
        }
        Map map = null;
        try {
            if (obj instanceof Map) {
                map = (Map) obj;
            }
        } catch (Exception unused) {
        }
        if (map != null) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
    }
}
