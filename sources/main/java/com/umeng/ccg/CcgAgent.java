package com.umeng.ccg;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CcgAgent {
    private static Map<String, ArrayList<String>> forbidSdkTable;
    private static Object lock = new Object();
    private static ArrayList<ConfigListener> callbacks = new ArrayList<>();
    private static Object actionInfoLock = new Object();
    private static Map<String, ActionInfo> actionInfoTable = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        forbidSdkTable = hashMap;
        hashMap.put(a.f41529e, new ArrayList());
        forbidSdkTable.put(a.f41528d, new ArrayList<>());
        forbidSdkTable.put(a.f41526b, new ArrayList<>());
        forbidSdkTable.put(a.f41527c, new ArrayList<>());
    }

    public static String[] getCollectItemList() {
        return new String[]{a.f41529e, a.f41528d, a.f41526b, a.f41527c};
    }

    public static ArrayList<String> getForbidSdkArray(String str) {
        if (forbidSdkTable.containsKey(str)) {
            return forbidSdkTable.get(str);
        }
        return null;
    }

    public static ArrayList<String> getRegistedModuleList() {
        ArrayList<String> arrayList;
        synchronized (actionInfoLock) {
            arrayList = new ArrayList<>(actionInfoTable.keySet());
        }
        return arrayList;
    }

    public static boolean hasRegistedActionInfo() {
        boolean z5;
        synchronized (actionInfoLock) {
            z5 = actionInfoTable.size() > 0;
        }
        return z5;
    }

    public static void notifyConfigReady(JSONObject jSONObject) {
        synchronized (lock) {
            try {
                int size = callbacks.size();
                if (size > 0) {
                    for (int i6 = 0; i6 < size; i6++) {
                        callbacks.get(i6).onConfigReady(jSONObject);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void registerConfigListener(ConfigListener configListener) {
        if (configListener != null) {
            synchronized (lock) {
                callbacks.add(configListener);
            }
        }
    }

    public static ActionInfo getActionInfo(String str) {
        ActionInfo actionInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (actionInfoLock) {
            try {
                if (actionInfoTable.containsKey(str)) {
                    actionInfo = actionInfoTable.get(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return actionInfo;
    }

    public static void init(Context context) {
        d.a().a(context);
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        Context appContext = UMGlobalContext.getAppContext();
        if (actionInfo != null) {
            synchronized (actionInfoLock) {
                try {
                    String module = actionInfo.getModule(UMGlobalContext.getAppContext());
                    if (!TextUtils.isEmpty(module) && !actionInfoTable.containsKey(module)) {
                        String[] supportAction = actionInfo.getSupportAction(appContext);
                        if (supportAction != null) {
                            for (String str : supportAction) {
                                boolean switchState = actionInfo.getSwitchState(appContext, str);
                                if (forbidSdkTable.containsKey(str)) {
                                    ArrayList<String> arrayList = forbidSdkTable.get(str);
                                    if (!switchState) {
                                        arrayList.add(module);
                                    }
                                }
                            }
                        }
                        actionInfoTable.put(module, actionInfo);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
