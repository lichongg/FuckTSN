package cn.jpush.android.helper;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {
    public static void a(Context context, String str, byte b6, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "", b6, 1000L, context, str2, null);
            return;
        }
        Logger.ee("JPushReportHelper", "The msgId is not valid - " + str);
    }

    public static void a(Context context, String str, long j6, int i6) {
        a(str, e.a(i6, j6), (String) null, context);
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        Logger.d("JPushReportHelper", "action:reportOperation - content:" + jSONObject.toString());
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 14, null, null, jSONObject);
    }

    public static void a(String str, long j6, Context context) {
        a(str, j6, (String) null, context);
    }

    public static void a(String str, long j6, String str2, Context context) {
        if (context == null) {
            Logger.d("JPushReportHelper", "context did not init, return");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:reportActionResult - messageId: " + str + ", code: " + j6 + "-" + e.a(j6));
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("， report content: " + str2);
        }
        String c6 = cn.jpush.android.d.d.c(str);
        if (!TextUtils.isEmpty(c6)) {
            stringBuffer.append("， report jData:" + c6);
        }
        Logger.d("JPushReportHelper", stringBuffer.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, str);
            jSONObject.put("result", j6);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("data", str2);
            }
            if (!TextUtils.isEmpty(c6)) {
                jSONObject.put("_j_data_", c6);
            }
            JSONObject fillBase = JCoreHelper.fillBase(context, jSONObject, "msg_status");
            if (fillBase != null) {
                fillBase.put("type", "msg_status");
                a(context, fillBase);
            } else {
                Logger.ww("JPushReportHelper", "report msg json is null, code: " + j6);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, byte b6, long j6, Context context) {
        a(str, str2, b6, j6, context, null, null);
    }

    public static void a(String str, String str2, byte b6, long j6, Context context, String str3, String str4) {
        if (context == null) {
            Logger.d("JPushReportHelper", "context did not init, return");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:reportThirdSDKMsgActionResult - messageId: " + str + ", code: " + j6);
        if (!TextUtils.isEmpty(str4)) {
            stringBuffer.append("， report content: " + str4);
        }
        String c6 = cn.jpush.android.d.d.c(str);
        if (TextUtils.isEmpty(c6) && !TextUtils.isEmpty(str3)) {
            try {
                c6 = new JSONObject(str3).optString("_j_data_", "");
                Logger.d("JPushReportHelper", "get jdata from third push msg:" + c6);
            } catch (Throwable th) {
                Logger.d("JPushReportHelper", "get jdata from third push msg error:" + th.getMessage());
            }
        }
        if (!TextUtils.isEmpty(c6)) {
            stringBuffer.append("， report jData:" + c6);
        }
        Logger.d("JPushReportHelper", stringBuffer.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, str);
            jSONObject.put("tmsg_id", str2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("data", str4);
            }
            jSONObject.put("result", j6);
            jSONObject.put("sdk_type", (int) b6);
            if (!TextUtils.isEmpty(c6)) {
                jSONObject.put("_j_data_", c6);
            }
            JSONObject fillBase = JCoreHelper.fillBase(context, jSONObject, "third_msg_status");
            if (fillBase != null) {
                fillBase.put("type", "third_msg_status");
                a(context, fillBase);
            } else {
                Logger.ww("JPushReportHelper", "report third sdk msg json is null, code: " + j6);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, Map<String, Integer> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            JCoreHelper.fillBase(context, jSONObject, "api_record");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if ((value instanceof Integer) && value.intValue() != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("method", entry.getKey());
                    jSONObject2.put("count", value);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("record_list", jSONArray);
            a(context, jSONObject);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
