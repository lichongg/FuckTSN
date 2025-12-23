package com.bytedance.msdk.core.g;

import android.text.TextUtils;
import com.bytedance.j.xt.a;
import com.bytedance.msdk.tl.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j {

    /* renamed from: j, reason: collision with root package name */
    protected final Map<String, String> f24464j = new HashMap();
    protected final l xt;

    private void cw(int i6, String str, double d6) {
        if (TextUtils.isEmpty(str) || i6 != 3) {
            return;
        }
        this.xt.j(str, d6 + "_" + System.currentTimeMillis());
        j(str);
    }

    protected abstract Map<String, String> j();

    protected abstract JSONObject j(com.bytedance.msdk.core.oq.cw cwVar);

    protected void j(int i6, String str, int i7, double d6) {
        if (i7 == 1) {
            j(i6, str, d6);
        } else if (i7 == 3) {
            xt(i6, str, d6);
        } else if (i7 == 2) {
            cw(i6, str, d6);
        }
    }

    protected abstract void j(String str, int i6, String str2);

    protected abstract void j(String str, String str2);

    protected void xt() {
        Map<String, ?> xt = this.xt.xt();
        if (xt != null) {
            for (Map.Entry<String, ?> entry : xt.entrySet()) {
                if (entry != null) {
                    j(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
            }
        }
    }

    protected abstract boolean xt(String str, JSONObject jSONObject, Map<String, Object> map);

    public j(String str) {
        this.xt = l.j(str, com.bytedance.msdk.core.xt.getContext());
        cw();
    }

    protected double j(int i6, String str, int i7) {
        if (i7 == 1) {
            return BigDecimal.valueOf(Double.parseDouble(j(i6, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i7 == 3) {
            return BigDecimal.valueOf(Double.parseDouble(xt(i6, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i7 == 2) {
            return BigDecimal.valueOf(Double.parseDouble(cw(i6, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return 0.0d;
    }

    private String cw(int i6, String str) {
        if (!TextUtils.isEmpty(str) && i6 == 3) {
            String xt = this.xt.xt(str);
            if (!TextUtils.isEmpty(xt) && !"0".equals(xt)) {
                String[] split = xt.split("_");
                String str2 = split[0];
                String str3 = split[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (str3.matches("[0-9]+")) {
                        try {
                            if (com.bytedance.msdk.core.xt.xt().j(System.currentTimeMillis() - Long.parseLong(str3))) {
                                return str2;
                            }
                            this.xt.m(str);
                        } catch (NumberFormatException unused) {
                            this.xt.m(str);
                            a.f("自定义上报 saveTime format exception valueTimestamp " + xt);
                        }
                    } else {
                        this.xt.m(str);
                        a.f("自定义上报 saveTime is not number valueTimestamp " + xt);
                    }
                }
            }
        }
        return "0";
    }

    private void xt(int i6, String str, double d6) {
        if (TextUtils.isEmpty(str) || i6 != 3) {
            return;
        }
        this.xt.j(str, d6 + "_" + System.currentTimeMillis());
        j(str);
    }

    public void j(double d6, double d7, String str, String str2) {
        if (this.xt == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        j(str, "_last_post_cpm_", str2, d6);
        j(str, "_last_bidding_cpm_", str2, d7);
    }

    private String xt(int i6, String str) {
        if (!TextUtils.isEmpty(str) && i6 == 3) {
            String xt = this.xt.xt(str);
            if (!TextUtils.isEmpty(xt) && !"0".equals(xt)) {
                String[] split = xt.split("_");
                String str2 = split[0];
                String str3 = split[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (com.bytedance.msdk.core.xt.xt().j(System.currentTimeMillis() - Long.parseLong(str3))) {
                        return str2;
                    }
                    this.xt.m(str);
                }
            }
        }
        return "0";
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0141 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0146 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double[] j(int r19, double r20, double r22, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.g.j.j(int, double, double, java.lang.String, java.lang.String):double[]");
    }

    protected String xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c6 : charArray) {
            sb.append(this.f24464j.get(String.valueOf(c6)));
        }
        return sb.toString();
    }

    protected void cw() {
        this.f24464j.put("0", "a");
        this.f24464j.put("1", "b");
        this.f24464j.put("2", "c");
        this.f24464j.put("3", "d");
        this.f24464j.put("4", "e");
        this.f24464j.put("5", "f");
        this.f24464j.put("6", "g");
        this.f24464j.put("7", "h");
        this.f24464j.put("8", "i");
        this.f24464j.put("9", "j");
        this.f24464j.put(".", "k");
    }

    protected void j(String str, String str2, String str3, double d6) {
        String str4 = str + str2;
        this.xt.j(str4, str3 + "_" + d6);
    }

    private synchronized void j(int i6, String str, double d6) {
        String str2 = "label_size_" + str;
        int xt = this.xt.xt(str2, 0) + 1;
        String j6 = j(str, xt);
        String j7 = j(str, d6);
        j(j6, i6, j7);
        this.xt.j(j6, j7);
        this.xt.j(str2, xt);
    }

    private String j(int i6, String str) {
        if (!TextUtils.isEmpty(str) && i6 == 3) {
            double[] dArr = new double[2];
            Iterator<Map.Entry<String, String>> it = j().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if (next != null) {
                    String value = next.getValue();
                    if (!TextUtils.isEmpty(value) && value.contains(str)) {
                        String[] split = value.split("_");
                        String str2 = split[0];
                        String str3 = split[1];
                        String str4 = split[2];
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                            if (com.bytedance.msdk.core.xt.xt().j(System.currentTimeMillis() - Long.parseLong(str4))) {
                                dArr[0] = dArr[0] + 1.0d;
                                dArr[1] = dArr[1] + Double.parseDouble(str3);
                            } else {
                                it.remove();
                                this.xt.m(next.getKey());
                                String str5 = "label_size_" + str;
                                l lVar = this.xt;
                                lVar.j(str5, lVar.cw(str5) - 1);
                            }
                        }
                    }
                }
            }
            return j(dArr);
        }
        return "0";
    }

    public void j(String str) {
        for (int cw = this.xt.cw("label_size_" + str); cw > 0; cw--) {
            try {
                String j6 = j(str, cw);
                this.xt.m(j6);
                j().remove(j6);
            } catch (Throwable th) {
                com.bytedance.msdk.j.up.cw.r("CalculateLabelValueImpl", "clearFromSpByRit,ignore:" + th.toString());
            }
        }
    }

    private String j(String str, int i6) {
        return "cpm_key_" + str + "_" + i6;
    }

    private String j(String str, double d6) {
        return str + "_" + d6 + "_" + System.currentTimeMillis();
    }

    public String j(double[] dArr) {
        double d6 = dArr[0];
        if (d6 != 0.0d) {
            return new BigDecimal(dArr[1] / d6).setScale(2, RoundingMode.HALF_UP).toString();
        }
        return "-1.0";
    }

    public static String j(int i6) {
        switch (i6) {
            case 1:
                return "banner";
            case 2:
                return MediationConstant.RIT_TYPE_INTERSTITIAL;
            case 3:
            case 4:
                return "splash";
            case 5:
                return AMPSConstants.AdType.AD_TYPE_NATIVE;
            case 6:
            default:
                return null;
            case 7:
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
            case 8:
                return "fullscreenVideo";
            case 9:
                return MediationConstant.RIT_TYPE_DRAW;
            case 10:
                return MediationConstant.RIT_TYPE_INTERSTITIAL_FULL;
        }
    }

    protected void j(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.bytedance.msdk.core.xt.xt().hl() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (xt(str, jSONObject2, map == null ? new HashMap<>() : map)) {
            try {
                jSONObject.putOpt("label", jSONObject2);
                if (map == null || map.get("cost_time") == null) {
                    return;
                }
                jSONObject.put("uvalueExcTime", map.get("cost_time"));
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
    }
}
