package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.ba.c;
import cn.jiguang.ba.i;
import cn.jiguang.bb.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class ActionManager {
    private static final String SDK_TYPE = "sdk_type";
    private static final String SDK_VERSION = "version";
    private static final String TAG = "ActionManager";
    private static HashMap<String, JDispatchAction> actionMap = new HashMap<>();
    private static HashMap<String, String> actionStringMap = new HashMap<>();

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ActionManager f3039a = new ActionManager();
    }

    public static boolean wrapSdkTypeVersionInfo(JSONObject jSONObject) {
        boolean z5 = false;
        if (jSONObject == null) {
            f.i(TAG, "wrapSdkTypeVersionInfo failed ,container is null");
            return false;
        }
        try {
            if (i.a(i.b())) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("version", cn.jiguang.a.a.f1444b);
                jSONObject2.put("sdk_type", i.b());
                try {
                    jSONObject.put("core_sdk_ver", jSONObject2);
                    z5 = true;
                } catch (JSONException unused) {
                    return true;
                }
            }
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (i.a(value.getSdkType())) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", value.getSdkVersion(entry.getKey()));
                    jSONObject3.put("sdk_type", value.getSdkType());
                    jSONObject.put(value.getReportVersionKey(entry.getKey()), jSONObject3);
                    z5 = true;
                }
            }
            return z5;
        } catch (JSONException unused2) {
            return z5;
        }
    }

    public static HashMap<String, String> getActionMap() {
        return actionStringMap;
    }

    public static HashMap<String, JDispatchAction> getDispatchActionMap() {
        return actionMap;
    }

    public static JDispatchAction getJDispatchAction(String str) {
        return actionMap.get(str);
    }

    public void handleMessage(Context context, String str, Object obj) {
        f.a(TAG, "onSended type:" + str + ",actionMap size:" + actionMap.size());
        if (TextUtils.isEmpty(str)) {
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                entry.getValue().handleMessage(context, entry.getKey(), obj);
            }
            return;
        }
        JDispatchAction jDispatchAction = actionMap.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.handleMessage(context, str, obj);
        }
    }

    public Map<Integer, Bundle> loadPInfo() {
        int i6;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
            Bundle pInfo = entry.getValue().getPInfo(entry.getKey());
            if (pInfo != null && (i6 = pInfo.getInt("pid", 0)) > 0) {
                hashMap.put(Integer.valueOf(i6), pInfo);
            }
        }
        return hashMap;
    }

    public boolean wrapSdkVersionInfo(JSONObject jSONObject) {
        Object dataByCmd;
        if (jSONObject == null) {
            f.i(TAG, "wrapSdkVersionInfo failed ,container is null");
            return false;
        }
        try {
            jSONObject.put("core_sdk_ver", cn.jiguang.a.a.f1444b);
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                jSONObject.put(value.getReportVersionKey(entry.getKey()), value.getSdkVersion(entry.getKey()));
                Object dataByCmd2 = value.getDataByCmd(null, 30001);
                if (dataByCmd2 != null && (dataByCmd2 instanceof String) && (dataByCmd = value.getDataByCmd(null, 30002)) != null && (dataByCmd instanceof String)) {
                    jSONObject.put((String) dataByCmd2, (String) dataByCmd);
                }
            }
            return true;
        } catch (JSONException unused) {
            return true;
        }
    }

    public ActionManager() {
        c.a();
    }

    public static void addAction(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (!actionMap.containsKey(str)) {
                try {
                    Object newInstance = Class.forName(str2).newInstance();
                    if (newInstance instanceof JDispatchAction) {
                        actionStringMap.put(str, str2);
                        actionMap.put(str, (JDispatchAction) newInstance);
                        return;
                    } else {
                        f.i(TAG, "this action is not a JDispatchAction,please check and extends JDispatchAction");
                        return;
                    }
                } catch (Throwable th) {
                    f.j(TAG, "#unexcepted - instance " + str2 + " class failed:" + th);
                    return;
                }
            }
            f.c(TAG, "has same type action");
        }
    }

    public static ActionManager getInstance() {
        return a.f3039a;
    }
}
