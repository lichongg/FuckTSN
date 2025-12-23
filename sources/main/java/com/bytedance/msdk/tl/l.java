package com.bytedance.msdk.tl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.d;
import com.bytedance.sdk.component.ae.r;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.feature.dynamic.b;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class l {

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, l> f25220j = new HashMap();
    private com.bytedance.sdk.component.r.j.xt xt;

    public static l j(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_mediation_sdk_sp";
        }
        Map<String, l> map = f25220j;
        l lVar = map.get(str);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(str, context);
        map.put(str, lVar2);
        return lVar2;
    }

    public int cw(@NonNull String str) {
        return xt(str, -1);
    }

    public long r(@NonNull String str) {
        return xt(str, -1L);
    }

    public boolean up(@NonNull String str) {
        return xt(str, false);
    }

    public String xt(@NonNull String str) {
        try {
            return xt(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject ae(String str) {
        try {
            String xt = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt(str);
            if (TextUtils.isEmpty(xt)) {
                return null;
            }
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).m(str);
            return new JSONObject(xt);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray r() {
        try {
            String xt = j("gm_v3_temp", com.bytedance.msdk.core.xt.getContext()).xt("gm_key_v3_bug");
            if (TextUtils.isEmpty(xt)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(xt);
            j("gm_v3_temp", com.bytedance.msdk.core.xt.getContext()).m("gm_key_v3_bug");
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject up() {
        try {
            String xt = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt(d.f10985a);
            if (TextUtils.isEmpty(xt)) {
                return null;
            }
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).m(d.f10985a);
            return new JSONObject(xt);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void cw() {
        try {
            this.xt.j();
        } catch (Throwable unused) {
        }
    }

    public void m(@NonNull String str) {
        try {
            this.xt.j(str);
        } catch (Throwable unused) {
        }
    }

    public String xt(@NonNull String str, @NonNull String str2) {
        try {
            return this.xt.xt(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private l(String str, Context context) {
        context = context == null ? com.bytedance.msdk.core.xt.getContext() : context;
        if (context != null) {
            this.xt = new r.j().j(str).j(context).j(1).j(com.bytedance.msdk.core.j.qv().jy()).j();
        }
    }

    public static void cw(String str, long j6) {
        JSONObject jSONObject;
        try {
            String xt = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt(d.f10985a);
            if (TextUtils.isEmpty(xt)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(xt);
            }
            jSONObject.put(str, j6);
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).j(d.f10985a, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public int xt(@NonNull String str, int i6) {
        try {
            return this.xt.xt(str, i6);
        } catch (Throwable unused) {
            return i6;
        }
    }

    public long xt(@NonNull String str, long j6) {
        try {
            return this.xt.xt(str, j6);
        } catch (Throwable unused) {
            return j6;
        }
    }

    public void j(String str) {
        j("any_door_id", str);
    }

    public float xt(@NonNull String str, float f6) {
        try {
            return this.xt.xt(str, f6);
        } catch (Throwable unused) {
            return f6;
        }
    }

    public String j() {
        return xt("any_door_id", "");
    }

    public boolean xt(@NonNull String str, boolean z5) {
        try {
            return this.xt.xt(str, z5);
        } catch (Throwable unused) {
            return z5;
        }
    }

    public void j(@NonNull String str, @NonNull String str2) {
        try {
            this.xt.j(str, str2);
        } catch (Throwable unused) {
        }
    }

    public Map<String, ?> xt() {
        try {
            return this.xt.getAll();
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    public void j(@NonNull String str, int i6) {
        try {
            this.xt.j(str, i6);
        } catch (Throwable unused) {
        }
    }

    public static void xt(Map<String, Object> map) {
        try {
            Context context = com.bytedance.msdk.core.xt.getContext();
            SharedPreferences xt = com.bytedance.sdk.openadsdk.api.plugin.xt.xt((Context) com.bytedance.msdk.j.up.j.j(context), "cb_test", 0);
            String string = xt.getString(MediationConstant.ADN_KS, "");
            String string2 = xt.getString(MediationConstant.ADN_GDT, "");
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                xt = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context, "cb_test", 0);
                string = xt.getString(MediationConstant.ADN_KS, "");
                string2 = xt.getString(MediationConstant.ADN_GDT, "");
            }
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put(MediationConstant.ADN_KS, string);
            }
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put(MediationConstant.ADN_GDT, string2);
            }
            map.put("cb_stacktrace", jSONObject);
            xt.edit().clear().apply();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void j(@NonNull String str, long j6) {
        try {
            this.xt.j(str, j6);
        } catch (Throwable unused) {
        }
    }

    public void j(@NonNull String str, float f6) {
        try {
            this.xt.j(str, f6);
        } catch (Throwable unused) {
        }
    }

    public void j(@NonNull String str, boolean z5) {
        try {
            this.xt.j(str, z5);
        } catch (Throwable unused) {
        }
    }

    public static void j(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            String xt = j("gm_v3_temp", com.bytedance.msdk.core.xt.getContext()).xt("gm_key_v3_bug");
            if (!TextUtils.isEmpty(xt)) {
                jSONArray = new JSONArray(xt);
            } else {
                jSONArray = new JSONArray();
            }
            if (jSONArray.length() >= 100) {
                jSONArray.put(99, jSONObject);
            } else {
                jSONArray.put(jSONObject);
            }
            j("gm_v3_temp", com.bytedance.msdk.core.xt.getContext()).j("gm_key_v3_bug", jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public static void j(boolean z5, int i6, String str, long j6, String str2) {
        JSONObject jSONObject;
        try {
            String xt = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt(b.f33222u);
            if (TextUtils.isEmpty(xt)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(xt);
            }
            int i7 = 1;
            if (z5) {
                JSONObject optJSONObject = jSONObject.optJSONObject("success");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    jSONObject.put("success", optJSONObject);
                }
                int optInt = optJSONObject.optInt("times", -1);
                int i8 = optInt == -1 ? 1 : optInt + 1;
                optJSONObject.put("times", i8);
                int optInt2 = optJSONObject.optInt("upload_size", -1);
                if (optInt2 != -1) {
                    i6 += optInt2;
                }
                optJSONObject.put("upload_size", i6);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(MediationConstant.KEY_REASON);
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                    optJSONObject.put(MediationConstant.KEY_REASON, optJSONObject2);
                }
                int optInt3 = optJSONObject2.optInt(str, -1);
                if (optInt3 != -1) {
                    i7 = 1 + optInt3;
                }
                optJSONObject2.put(str, i7);
                if (j6 <= 10000) {
                    long optInt4 = optJSONObject.optInt("avg_req_duration", -1);
                    optJSONObject.put("avg_req_duration", optInt4 == -1 ? j6 : ((optInt4 * (i8 - 1)) + j6) / i8);
                }
            } else {
                JSONObject optJSONObject3 = jSONObject.optJSONObject(CommonNetImpl.FAIL);
                if (optJSONObject3 == null) {
                    optJSONObject3 = new JSONObject();
                    jSONObject.put(CommonNetImpl.FAIL, optJSONObject3);
                }
                int optInt5 = optJSONObject3.optInt("times", -1);
                optJSONObject3.put("times", optInt5 == -1 ? 1 : optInt5 + 1);
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("error_code");
                if (optJSONObject4 == null) {
                    optJSONObject4 = new JSONObject();
                    optJSONObject3.put("error_code", optJSONObject4);
                }
                int optInt6 = optJSONObject4.optInt(str2, -1);
                if (optInt6 != -1) {
                    i7 = 1 + optInt6;
                }
                optJSONObject4.put(str2, i7);
            }
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).j(b.f33222u, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static void j(String str, boolean z5, long j6, String str2) {
        JSONObject jSONObject;
        try {
            String xt = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt(str);
            if (TextUtils.isEmpty(xt)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(xt);
            }
            int i6 = 1;
            if (z5) {
                JSONObject optJSONObject = jSONObject.optJSONObject("success");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    jSONObject.put("success", optJSONObject);
                }
                int optInt = optJSONObject.optInt("times", -1);
                if (optInt != -1) {
                    i6 = 1 + optInt;
                }
                optJSONObject.put("times", i6);
                if (j6 <= 10000) {
                    long optInt2 = optJSONObject.optInt("avg_req_duration", -1);
                    if (optInt2 != -1) {
                        j6 = ((optInt2 * (i6 - 1)) + j6) / i6;
                    }
                    optJSONObject.put("avg_req_duration", j6);
                }
            } else {
                JSONObject optJSONObject2 = jSONObject.optJSONObject(CommonNetImpl.FAIL);
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                    jSONObject.put(CommonNetImpl.FAIL, optJSONObject2);
                }
                int optInt3 = optJSONObject2.optInt("times", -1);
                optJSONObject2.put("times", optInt3 == -1 ? 1 : optInt3 + 1);
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("error_code");
                if (optJSONObject3 == null) {
                    optJSONObject3 = new JSONObject();
                    optJSONObject2.put("error_code", optJSONObject3);
                }
                int optInt4 = optJSONObject3.optInt(str2, -1);
                if (optInt4 != -1) {
                    i6 = 1 + optInt4;
                }
                optJSONObject3.put(str2, i6);
            }
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).j(str, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static void j(int i6, int i7) {
        try {
            int xt = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt("low_m_cnt", 0);
            int xt2 = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt("clean_invalid_cnt", 0) + i6;
            int xt3 = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt("force_clean_cnt", 0) + i7;
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).j("low_m_cnt", xt + 1);
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).j("clean_invalid_cnt", xt2);
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).j("force_clean_cnt", xt3);
        } catch (Throwable unused) {
        }
    }

    public static void j(Map<String, Object> map) {
        try {
            int xt = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt("low_m_cnt", 0);
            int xt2 = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt("clean_invalid_cnt", 0);
            int xt3 = j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).xt("force_clean_cnt", 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("low_m_cnt", xt);
            jSONObject.put("invalid_cnt", xt2);
            jSONObject.put("force_cnt", xt3);
            map.put("low_m_clean", jSONObject);
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).j("low_m_cnt", 0);
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).j("clean_invalid_cnt", 0);
            j("evt_upload_info", com.bytedance.msdk.core.xt.getContext()).j("force_clean_cnt", 0);
        } catch (Throwable unused) {
        }
    }
}
