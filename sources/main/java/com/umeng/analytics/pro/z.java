package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class z implements ag {

    /* renamed from: a, reason: collision with root package name */
    private String f41474a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<aa> f41475b;

    /* renamed from: c, reason: collision with root package name */
    private String f41476c;

    /* renamed from: d, reason: collision with root package name */
    private String f41477d;

    /* renamed from: e, reason: collision with root package name */
    private String f41478e;

    /* renamed from: f, reason: collision with root package name */
    private String f41479f;

    public String a() {
        return this.f41474a;
    }

    public String b() {
        return this.f41476c;
    }

    public String c() {
        return this.f41477d;
    }

    private String c(String str) {
        String[] split = str.split(",");
        String str2 = "";
        if (split.length > 0) {
            ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.f41474a);
            if (forbidSdkArray == null || forbidSdkArray.size() <= 0) {
                for (String str3 : split) {
                    ActionInfo actionInfo = CcgAgent.getActionInfo(str3);
                    if (actionInfo != null) {
                        String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                        if (supportAction.length > 0) {
                            int i6 = 0;
                            while (true) {
                                if (i6 >= supportAction.length) {
                                    break;
                                }
                                if (this.f41474a.equals(supportAction[i6])) {
                                    str2 = str3;
                                    break;
                                }
                                i6++;
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                return str2;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } else {
                this.f41479f = forbidSdkArray.toString();
                for (String str4 : split) {
                    if (CcgAgent.getActionInfo(str4) != null && !forbidSdkArray.contains(str4)) {
                        return str4;
                    }
                }
            }
        }
        return str2;
    }

    public void a(String str) {
        this.f41476c = str;
    }

    public void b(String str) {
        this.f41477d = str;
    }

    public z(String str, ArrayList<aa> arrayList) {
        this.f41474a = null;
        new ArrayList();
        this.f41476c = "";
        this.f41477d = "";
        this.f41478e = "";
        this.f41479f = "";
        this.f41474a = str;
        this.f41475b = arrayList;
    }

    @Override // com.umeng.analytics.pro.ag
    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            int size = this.f41475b.size();
            if (size == 0) {
                return null;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (this.f41475b.get(i6).b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.f41477d)) {
                String c6 = c(this.f41477d);
                this.f41478e = c6;
                if (TextUtils.isEmpty(c6)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f41474a + "; 未选中可用Module ; sdk: " + this.f41477d);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f41474a + "; 选中Module: " + this.f41478e + "; sdk: " + this.f41477d);
                }
            }
            aa aaVar = this.f41475b.get(size - 1);
            if (aaVar == null || !(aaVar instanceof ac)) {
                return null;
            }
            long c7 = aaVar.c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.f41474a);
                jSONObject2.put("sdk", this.f41477d);
                jSONObject2.put(com.umeng.ccg.a.f41539o, this.f41476c);
                jSONObject2.put("delay", c7);
                jSONObject2.put(com.umeng.ccg.a.f41540p, this.f41478e);
                jSONObject2.put(com.umeng.ccg.a.f41541q, this.f41479f);
                return jSONObject2;
            } catch (Throwable unused) {
                return jSONObject2;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
