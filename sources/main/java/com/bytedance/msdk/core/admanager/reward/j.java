package com.bytedance.msdk.core.admanager.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.rn;
import com.bytedance.msdk.tl.ws;
import com.bytedance.msdk.tl.x;
import com.bytedance.msdk.xt.cw;
import com.bytedance.sdk.component.g.xt.r;
import com.bytedance.sdk.component.g.xt.up;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.umeng.socialize.common.SocializeConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.model.android.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private com.bytedance.msdk.api.cw.j ae;
    private String av;
    private long az;
    private int cw;

    /* renamed from: i, reason: collision with root package name */
    private xt f24415i;
    private com.bytedance.msdk.api.j.xt jy;
    private cw ws;
    private int xt;

    /* renamed from: r, reason: collision with root package name */
    private boolean f24418r = false;
    private boolean up = false;

    /* renamed from: m, reason: collision with root package name */
    private long f24417m = -1;
    private boolean tl = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f24414g = false;
    private boolean oq = true;
    private int qv = -1;
    private String vl = "";

    /* renamed from: j, reason: collision with root package name */
    AtomicInteger f24416j = new AtomicInteger(1);

    /* renamed from: com.bytedance.msdk.core.admanager.reward.j$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f24418r) {
                com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经destroy, 直接return");
                return;
            }
            j.this.tl = true;
            if (j.this.ae != null) {
                if (j.this.f24415i == null || j.this.f24414g) {
                    return;
                }
                com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经有结果，直接给开发者回调");
                j.this.f24414g = true;
                j.this.f24415i.j(j.this.ae);
                return;
            }
            if (j.this.f24417m == -1) {
                com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，先进来发起请求");
                j.this.f24417m = SystemClock.elapsedRealtime();
                if (j.this.oq) {
                    j.this.ae();
                } else {
                    com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                }
            } else if (SystemClock.elapsedRealtime() - j.this.f24417m > 2000) {
                com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，后进来但大于2s，发起请求");
                if (j.this.oq) {
                    j.this.ae();
                } else {
                    com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                }
            }
            m.j(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.j.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f24418r) {
                        com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，已经destroy了, 直接return");
                        return;
                    }
                    if (j.this.f24415i == null || j.this.f24414g) {
                        return;
                    }
                    com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，给开发者verify回调");
                    j.this.f24414g = true;
                    com.bytedance.msdk.api.cw.j jVar = new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.core.admanager.reward.j.3.1.1
                        @Override // com.bytedance.msdk.api.cw.j
                        public boolean j() {
                            return false;
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        public String cw() {
                            return j.this.jy != null ? j.this.jy.p() : "";
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        @DungeonFlag
                        public Map<String, Object> r() {
                            HashMap hashMap = new HashMap();
                            hashMap.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
                            hashMap.put("transId", j.this.av);
                            hashMap.put(MediationConstant.KEY_REASON, 0);
                            hashMap.put("gromoreExtra", (j.this.jy == null || j.this.jy.c() == null) ? "" : j.this.jy.c().get("gromoreExtra"));
                            hashMap.put("errorCode", Integer.valueOf(j.this.qv));
                            hashMap.put(MediationConstant.KEY_ERROR_MSG, j.this.vl);
                            com.bytedance.msdk.api.cw j6 = ws.j(j.this.jy, j.this.ws, true);
                            hashMap.put(MediationConstant.KEY_ADN_NAME, j6 != null ? j6.vl() : "");
                            hashMap.put("ecpm", j6 != null ? j6.jy() : "");
                            return hashMap;
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        public float xt() {
                            if (j.this.jy != null) {
                                return j.this.jy.h();
                            }
                            return 0.0f;
                        }
                    };
                    xt xtVar = j.this.f24415i;
                    if (j.this.ae != null) {
                        jVar = j.this.ae;
                    }
                    xtVar.j(jVar);
                }
            }, 3000L);
        }
    }

    /* renamed from: com.bytedance.msdk.core.admanager.reward.j$j, reason: collision with other inner class name */
    private class RunnableC0351j implements Runnable {
        private final int xt;

        RunnableC0351j(int i6) {
            this.xt = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.ae != null || j.this.f24414g || !j.this.oq || j.this.f24418r || j.this.up) {
                return;
            }
            com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide reward verify 进行第" + this.xt + "次重试请求");
            j.this.ae();
        }
    }

    public interface xt {
        void j(com.bytedance.msdk.api.cw.j jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void ae() {
        up xt2 = com.bytedance.msdk.r.xt.j().xt().xt();
        xt2.j(com.bytedance.msdk.core.cw.r());
        final long currentTimeMillis = System.currentTimeMillis();
        String tl = com.bytedance.msdk.core.j.qv().tl();
        if (!TextUtils.isEmpty(tl)) {
            xt2.xt("X-Tt-Env", tl);
            xt2.xt("x-use-ppe", "1");
        }
        xt2.xt("User-Agent", com.bytedance.msdk.xt.xt.f25363j);
        boolean cw = com.bytedance.msdk.core.xt.xt().cw();
        final boolean z5 = !cw;
        if (cw) {
            xt2.cw(j(false));
        } else {
            xt2.xt("x-pglcypher", "4");
            xt2.j("application/octet-stream", rn.xt(j(true)));
        }
        xt2.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.msdk.core.admanager.reward.j.7
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(r rVar, final com.bytedance.sdk.component.g.xt xtVar) {
                m.j(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.j.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        j.this.j(xtVar, z5, currentTimeMillis);
                    }
                });
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(r rVar, final IOException iOException) {
                m.j(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.j.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify http error: " + iOException.toString());
                        j.this.j(-2, "request error" + iOException.getMessage(), z5);
                    }
                });
            }
        });
    }

    private void m() {
        com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- showListen回调进来，开始计时");
        m.j(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.j.6
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f24417m != -1 || j.this.f24418r || j.this.up) {
                    com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，已经destroy，或者skip，或者比complete/verify回调还晚，直接return");
                    return;
                }
                com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，发起请求");
                j.this.ae();
                m.j(j.this.new RunnableC0351j(1), 3000L);
                m.j(j.this.new RunnableC0351j(2), 6000L);
                m.j(j.this.new RunnableC0351j(3), d.f50004s);
            }
        }, this.xt);
    }

    public void up() {
        m.j(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.j.4
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f24418r) {
                    com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，已经destroy, 直接return");
                    return;
                }
                if (j.this.ae != null || j.this.f24414g) {
                    StringBuilder sb = new StringBuilder("--==-- complete回调进来，已经有响应(");
                    sb.append(j.this.ae != null);
                    sb.append(")或已经给出开发者回调(");
                    sb.append(j.this.f24414g);
                    sb.append("), 直接return");
                    com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", sb.toString());
                    return;
                }
                if (j.this.f24417m == -1) {
                    com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，先进来发起请求");
                    j.this.f24417m = SystemClock.elapsedRealtime();
                    if (j.this.oq) {
                        j.this.ae();
                        return;
                    } else {
                        com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                        return;
                    }
                }
                if (SystemClock.elapsedRealtime() - j.this.f24417m > 2000) {
                    com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，后进来但大于2s，发起请求");
                    if (j.this.oq) {
                        j.this.ae();
                    } else {
                        com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                    }
                }
            }
        });
    }

    public j(String str) {
        com.bytedance.msdk.core.oq.xt j6;
        com.bytedance.msdk.core.ws.cw xt2 = com.bytedance.msdk.core.xt.xt();
        if (xt2 != null && (j6 = xt2.j(str, 7, 101)) != null) {
            this.xt = j6.n();
            this.cw = j6.nd();
        }
        if (this.xt < 0) {
            this.xt = 15000;
        }
    }

    public void cw() {
        m.j(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.f24418r = true;
            }
        });
    }

    public void r() {
        m.j(new AnonymousClass3());
    }

    public void xt() {
        m.j(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.up = true;
            }
        });
    }

    public boolean j() {
        boolean z5 = this.cw == 1;
        com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- 判断是否开启了M服务端激励验证： ".concat(String.valueOf(z5)));
        return z5;
    }

    public void j(com.bytedance.msdk.api.j.xt xtVar, cw cwVar) {
        this.az = System.currentTimeMillis();
        this.jy = xtVar;
        this.ws = cwVar;
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void j(com.bytedance.sdk.component.g.xt xtVar, boolean z5, long j6) {
        if (this.f24418r) {
            return;
        }
        if (xtVar == null) {
            com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify netResponse is null");
            j(-1, "response is null", z5);
            return;
        }
        int j7 = xtVar.j();
        if (rn.j(xtVar)) {
            String j8 = rn.j(xtVar.oq());
            if (TextUtils.isEmpty(j8)) {
                com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data v4 is null");
                j(j7, "data is empty", z5);
                return;
            }
            try {
                this.qv = 20000;
                j(new JSONObject(j8), z5, j6);
                return;
            } catch (Throwable th) {
                vl.j(th);
                this.qv = 1;
                j(-1, th.getMessage(), z5);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(xtVar.r());
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
            this.qv = jSONObject.optInt("code");
            this.vl = jSONObject.optString("desc");
            int i6 = this.qv;
            if (i6 == 50001) {
                this.oq = true;
                com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: 50001，请求媒体服务端失败，需要重试");
                j(this.qv, this.vl, z5);
                return;
            }
            if (i6 != 0 && i6 != 20000) {
                this.oq = false;
                com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: " + this.qv + ", msg: " + this.vl + "，不能再重试");
                j(this.qv, this.vl, z5);
                return;
            }
            if (optInt < 0 || TextUtils.isEmpty(optString)) {
                com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify cypher error or message is null");
                j(j7, "message is null", z5);
                return;
            }
            JSONObject jSONObject2 = null;
            if (optInt == 2) {
                String j9 = rn.j(optString);
                if (!TextUtils.isEmpty(j9)) {
                    jSONObject2 = new JSONObject(j9);
                }
            } else if (optInt == 1) {
                String xt2 = com.bytedance.msdk.tl.j.xt(optString, com.bytedance.msdk.tl.xt.j());
                if (!TextUtils.isEmpty(xt2)) {
                    jSONObject2 = new JSONObject(xt2);
                }
            } else if (optInt == 0) {
                jSONObject2 = new JSONObject(optString);
            }
            j(jSONObject2, z5, j6);
        } catch (Throwable th2) {
            j(-1, th2.getMessage(), z5);
        }
    }

    @DungeonFlag
    private void j(JSONObject jSONObject, boolean z5, long j6) {
        long currentTimeMillis = System.currentTimeMillis() - j6;
        if (jSONObject == null) {
            com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data is null");
            j(-1, "data is null", z5);
            return;
        }
        com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- data: " + jSONObject.toString());
        final boolean optBoolean = jSONObject.optBoolean("is_verify");
        final int optInt = jSONObject.optInt(MediationConstant.KEY_REASON);
        final String optString = jSONObject.optString(MediationConstant.REWARD_NAME);
        final int optInt2 = jSONObject.optInt(MediationConstant.REWARD_AMOUNT);
        this.ae = new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.core.admanager.reward.j.5
            @Override // com.bytedance.msdk.api.cw.j
            public String cw() {
                return optString;
            }

            @Override // com.bytedance.msdk.api.cw.j
            public boolean j() {
                return optBoolean;
            }

            @Override // com.bytedance.msdk.api.cw.j
            @DungeonFlag
            public Map<String, Object> r() {
                HashMap hashMap = new HashMap();
                hashMap.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
                hashMap.put("transId", j.this.av);
                hashMap.put(MediationConstant.KEY_REASON, Integer.valueOf(optInt));
                hashMap.put("gromoreExtra", (j.this.jy == null || j.this.jy.c() == null) ? "" : j.this.jy.c().get("gromoreExtra"));
                hashMap.put("errorCode", Integer.valueOf(j.this.qv));
                hashMap.put(MediationConstant.KEY_ERROR_MSG, j.this.vl);
                com.bytedance.msdk.api.cw j7 = ws.j(j.this.jy, j.this.ws, true);
                hashMap.put(MediationConstant.KEY_ADN_NAME, j7 != null ? j7.vl() : "");
                hashMap.put("ecpm", j7 != null ? j7.jy() : "");
                return hashMap;
            }

            @Override // com.bytedance.msdk.api.cw.j
            public float xt() {
                return optInt2;
            }
        };
        if (this.tl && this.f24415i != null && !this.f24414g) {
            com.bytedance.msdk.j.up.cw.j("GROMORE_SS_REWARD_VERIFY", "--==-- verify接口请求回来，给开发者verify回调");
            this.f24414g = true;
            this.f24415i.j(this.ae);
        }
        j(z5, currentTimeMillis);
    }

    private void j(boolean z5, long j6) {
        l.j(z5 ? "v4Enc_reward" : "v2Enc_reward", true, j6, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, String str, boolean z5) {
        l.j(z5 ? "v4Enc_reward" : "v2Enc_reward", false, 0L, "code = " + i6 + "，msg = " + str);
    }

    @DungeonFlag
    private String j(boolean z5) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", com.bytedance.msdk.xt.xt.xt());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.xt.xt.r());
            jSONObject.put("user_agent", com.bytedance.msdk.xt.xt.f25363j);
            jSONObject.put("try_value", this.f24416j.getAndIncrement());
            jSONObject.put("network", x.up());
            jSONObject.put("play_start_ts", this.az);
            jSONObject.put("play_end_ts", System.currentTimeMillis());
            com.bytedance.msdk.api.j.xt xtVar = this.jy;
            jSONObject.put(SocializeConstants.TENCENT_UID, xtVar != null ? xtVar.gq() : "");
            if (TextUtils.isEmpty(this.av)) {
                str = UUID.randomUUID().toString();
                this.av = str;
            } else {
                str = this.av;
            }
            jSONObject.put("trans_id", str);
            com.bytedance.msdk.api.j.xt xtVar2 = this.jy;
            jSONObject.put("link_id", xtVar2 != null ? xtVar2.j() : "");
            com.bytedance.msdk.api.j.xt xtVar3 = this.jy;
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, xtVar3 != null ? xtVar3.v() : "");
            cw cwVar = this.ws;
            jSONObject.put("adn_rit", cwVar != null ? cwVar.qa() : "");
            com.bytedance.msdk.api.j.xt xtVar4 = this.jy;
            jSONObject.put(MediationConstant.REWARD_NAME, xtVar4 != null ? xtVar4.p() : "");
            com.bytedance.msdk.api.j.xt xtVar5 = this.jy;
            jSONObject.put(MediationConstant.REWARD_AMOUNT, xtVar5 != null ? xtVar5.h() : 0);
            com.bytedance.msdk.api.j.xt xtVar6 = this.jy;
            jSONObject.put("media_extra", (xtVar6 == null || xtVar6.c() == null) ? "" : this.jy.c().get("gromoreExtra"));
            com.bytedance.msdk.api.j.xt xtVar7 = this.jy;
            if (xtVar7 != null && xtVar7.x() != null) {
                jSONObject.put("scenario_id", this.jy.x());
            }
            com.bytedance.msdk.api.cw j6 = ws.j(this.jy, this.ws, true);
            jSONObject.put(MediationConstant.EXTRA_ADN_NAME, j6 != null ? j6.vl() : "");
            jSONObject.put("ecpm", j6 != null ? j6.jy() : "");
        } catch (JSONException e6) {
            vl.j(e6);
        }
        if (z5) {
            return jSONObject.toString();
        }
        return rn.j(jSONObject).toString();
    }

    public void j(xt xtVar) {
        this.f24415i = xtVar;
    }
}
