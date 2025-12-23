package com.bytedance.sdk.openadsdk.core.live.xt;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.jy.j;
import com.bytedance.sdk.openadsdk.core.live.j.ae;
import com.bytedance.sdk.openadsdk.core.rn.a;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    final ae f29498j;

    private void ae(PluginValueSet pluginValueSet) {
        try {
            Map map = (Map) pluginValueSet.objectValue(1, Map.class);
            this.f29498j.j(Integer.valueOf((String) map.get("is_auth")).intValue() != 0, (String) map.get("open_uid"));
        } catch (Exception e6) {
            vl.xt("LiveServiceBridge", e6);
        }
    }

    private void cw(PluginValueSet pluginValueSet) {
        try {
            this.f29498j.cw((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception e6) {
            vl.xt("LiveServiceBridge", e6);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0062, code lost:
    
        if (r1.equals("sendGoldExchangeCoupon") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object j(com.bykv.vk.openvk.api.proto.PluginValueSet r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r6.stringValue(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            if (r2 == 0) goto Ld
            return r3
        Ld:
            r1.getClass()
            int r2 = r1.hashCode()
            r4 = -1
            switch(r2) {
                case -1828730287: goto L5c;
                case -955478604: goto L51;
                case -366799433: goto L46;
                case 862273347: goto L3b;
                case 1186389324: goto L30;
                case 1388496268: goto L25;
                case 1979487267: goto L1a;
                default: goto L18;
            }
        L18:
            r0 = -1
            goto L65
        L1a:
            java.lang.String r0 = "reportPangleEvent"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L23
            goto L18
        L23:
            r0 = 6
            goto L65
        L25:
            java.lang.String r0 = "onAuthCallback"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2e
            goto L18
        L2e:
            r0 = 5
            goto L65
        L30:
            java.lang.String r0 = "getPanglePluginVersion"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L39
            goto L18
        L39:
            r0 = 4
            goto L65
        L3b:
            java.lang.String r0 = "onLiveFakeInitFinish"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L44
            goto L18
        L44:
            r0 = 3
            goto L65
        L46:
            java.lang.String r0 = "onTaskFinish"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L4f
            goto L18
        L4f:
            r0 = 2
            goto L65
        L51:
            java.lang.String r0 = "getBiddingToken"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L5a
            goto L18
        L5a:
            r0 = 1
            goto L65
        L5c:
            java.lang.String r2 = "sendGoldExchangeCoupon"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L65
            goto L18
        L65:
            switch(r0) {
                case 0: goto L85;
                case 1: goto L80;
                case 2: goto L7c;
                case 3: goto L78;
                case 4: goto L71;
                case 5: goto L6d;
                case 6: goto L69;
                default: goto L68;
            }
        L68:
            goto L88
        L69:
            r5.m(r6)
            goto L88
        L6d:
            r5.ae(r6)
            goto L88
        L71:
            r6 = 7012(0x1b64, float:9.826E-42)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            return r6
        L78:
            r5.xt(r6)
            goto L88
        L7c:
            r5.r(r6)
            goto L88
        L80:
            java.lang.Object r6 = r5.up(r6)
            return r6
        L85:
            r5.cw(r6)
        L88:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.xt.j.j(com.bykv.vk.openvk.api.proto.PluginValueSet):java.lang.Object");
    }

    private void m(PluginValueSet pluginValueSet) {
        Map<String, String> map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null) {
            return;
        }
        this.f29498j.j(map);
    }

    private void r(PluginValueSet pluginValueSet) {
        try {
            this.f29498j.xt((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception e6) {
            vl.xt("LiveServiceBridge", e6);
        }
    }

    private Object up(PluginValueSet pluginValueSet) {
        try {
            Integer tl = tl(pluginValueSet);
            if (tl == null) {
                return null;
            }
            return v.j().j(a.j(tl.intValue()));
        } catch (Throwable th) {
            vl.xt("TTLiveSDkBridge", "invokeGetBiddingToken failed:" + th.getMessage());
            return null;
        }
    }

    private void xt(PluginValueSet pluginValueSet) {
        String message;
        int i6 = -3;
        try {
            String str = (String) ((Map) pluginValueSet.objectValue(1, Map.class)).get("success");
            message = null;
            if (str != null) {
                if (Boolean.parseBoolean(str)) {
                    i6 = 2;
                } else {
                    message = "fake init failed";
                }
            }
        } catch (Exception e6) {
            vl.xt("LiveServiceBridge", e6);
            message = e6.getMessage();
        }
        this.f29498j.j(i6, message, true);
    }

    public j(ae aeVar) {
        this.f29498j = aeVar;
    }

    private Integer tl(PluginValueSet pluginValueSet) {
        String ae = com.bytedance.sdk.openadsdk.core.live.xt.j().ae();
        if (ae == null) {
            return null;
        }
        if (ae.replaceAll(".", "").startsWith("2112")) {
            Object[] arrayValue = pluginValueSet.arrayValue(1, Object[].class);
            if (arrayValue == null || arrayValue.length == 0) {
                return null;
            }
            return (Integer) arrayValue[0];
        }
        Map map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null || map.size() == 0) {
            return null;
        }
        return Integer.valueOf((String) map.get("adType"));
    }

    public void j(boolean z5, String str, String str2, Map<String, String> map) {
        final JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!jSONObject.has(entry.getKey())) {
                            jSONObject.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (Exception e6) {
                vl.j(e6);
                return;
            }
        }
        new j.C0460j().j(str).xt(str2).cw("umeng").up(jSONObject.optString("value")).r(jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA)).j(new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.live.xt.j.1
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject2) throws JSONException {
                if (!TextUtils.isEmpty(jSONObject.optString("ad_extra_data"))) {
                    jSONObject2.put("ad_extra_data", jSONObject.optString("ad_extra_data"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("is_other_channel"))) {
                    jSONObject2.put("is_other_channel", jSONObject.optString("is_other_channel"));
                }
                if (jSONObject2.has("is_ad_event")) {
                    return;
                }
                jSONObject2.putOpt("is_ad_event", "1");
            }
        });
    }

    private boolean j(PluginValueSet pluginValueSet, int i6) {
        try {
            Map map = (Map) pluginValueSet.objectValue(i6, Map.class);
            if (map != null && map.containsKey("onlyUpdateState")) {
                if (Boolean.parseBoolean(String.valueOf(map.get("onlyUpdateState")))) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        if (intValue == 0) {
            return j(k6);
        }
        if (intValue == 1) {
            j(k6.booleanValue(0), k6.stringValue(1), k6.stringValue(2), (Map) k6.objectValue(3, Map.class));
        } else if (intValue == 2) {
            this.f29498j.j(k6.intValue(0), k6.stringValue(1), j(k6, 2));
        } else if (intValue == 3) {
            int intValue2 = k6.intValue(0);
            boolean j6 = j(k6, 4);
            if (1000 == intValue2) {
                this.f29498j.j(5, (String) null, j6);
                if (!j6) {
                    this.f29498j.j();
                }
            } else if (1001 == intValue2) {
                this.f29498j.j(-2, k6.stringValue(1), j6);
            }
        }
        return null;
    }
}
