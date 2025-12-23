package xyz.adscope.common;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.common.analyse2.base.model.AnalyseBasicReceiveLog;
import xyz.adscope.common.analyse2.base.model.biz.AnalyseAdCommon;
import xyz.adscope.common.analyse2.base.model.biz.AnalyseAdEventLog;
import xyz.adscope.common.analyse2.base.model.biz.AnalyseSimpleLog;
import xyz.adscope.common.analyse2.db.AnalyseEventDBModel;
import xyz.adscope.common.v2.crash.ScopeCrashLog;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;
import xyz.adscope.common.v2.tool.json.JsonUtil;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class c {
    public static AnalyseEventDBModel a(Context context, String str, String str2, JSONObject jSONObject, List<ScopeCrashLog> list) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return null;
        }
        return a(context, str, str2, a(jSONObject, list));
    }

    public static AnalyseEventDBModel b(Context context, String str, String str2, JSONObject jSONObject, List<AnalyseSimpleLog> list) {
        if (list.isEmpty()) {
            return null;
        }
        return a(context, str, str2, b(jSONObject, list));
    }

    private static AnalyseEventDBModel a(Context context, String str, String str2, JSONObject jSONObject) {
        AnalyseEventDBModel analyseEventDBModel = new AnalyseEventDBModel();
        analyseEventDBModel.setUrl(str);
        analyseEventDBModel.setEncrypt(str2);
        analyseEventDBModel.b(System.currentTimeMillis() + "");
        byte[] encrypt = LinkedEncryptManager.getInstance().getOrCreateImplement(context).encrypt(jSONObject.toString().getBytes(), str2, ILinkedEncrypt.B64Model.NOT_APPEND, false);
        if (encrypt == null) {
            return null;
        }
        analyseEventDBModel.a(StringUtil.bytesToHexString(encrypt));
        return analyseEventDBModel;
    }

    private static JSONObject b(JSONObject jSONObject, List<AnalyseSimpleLog> list) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (AnalyseSimpleLog analyseSimpleLog : list) {
            if (analyseSimpleLog instanceof AnalyseAdEventLog) {
                AnalyseAdEventLog analyseAdEventLog = (AnalyseAdEventLog) analyseSimpleLog;
                AnalyseAdCommon c6 = analyseAdEventLog.c();
                if (c6 != null) {
                    String b6 = c6.b();
                    List list2 = (List) hashMap.get(b6);
                    if (list2 != null) {
                        list2.add(analyseAdEventLog);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(analyseAdEventLog);
                        hashMap.put(b6, arrayList2);
                    }
                }
            } else {
                arrayList.add(analyseSimpleLog);
            }
        }
        if (!arrayList.isEmpty()) {
            JSONArray emptyJSONArray = JsonUtil.emptyJSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                emptyJSONArray.put(((AnalyseBasicReceiveLog) it.next()).a());
            }
            JsonUtil.putObject(jSONObject, "event_list", emptyJSONArray);
        }
        if (!hashMap.isEmpty()) {
            JSONArray emptyJSONArray2 = JsonUtil.emptyJSONArray();
            Iterator it2 = hashMap.values().iterator();
            while (it2.hasNext()) {
                emptyJSONArray2.put(a((List) it2.next()));
            }
            JsonUtil.putObject(jSONObject, "session_list", emptyJSONArray2);
        }
        return jSONObject;
    }

    private static JSONObject a(JSONObject jSONObject, List<ScopeCrashLog> list) {
        if (!list.isEmpty()) {
            JSONArray emptyJSONArray = JsonUtil.emptyJSONArray();
            Iterator<ScopeCrashLog> it = list.iterator();
            while (it.hasNext()) {
                emptyJSONArray.put(it.next().getAnalyseJsonObject());
            }
            JsonUtil.putObject(jSONObject, "crash", emptyJSONArray);
        }
        return jSONObject;
    }

    private static JSONObject a(List<AnalyseAdEventLog> list) {
        if (!list.isEmpty()) {
            JSONArray emptyJSONArray = JsonUtil.emptyJSONArray();
            JSONObject jSONObject = null;
            for (AnalyseAdEventLog analyseAdEventLog : list) {
                if (analyseAdEventLog != null) {
                    AnalyseAdCommon c6 = analyseAdEventLog.c();
                    if (c6 != null) {
                        jSONObject = c6.a();
                    }
                    emptyJSONArray.put(analyseAdEventLog.a());
                }
            }
            if (jSONObject != null) {
                JsonUtil.putObject(jSONObject, "event_list", emptyJSONArray);
                return jSONObject;
            }
        }
        return null;
    }
}
