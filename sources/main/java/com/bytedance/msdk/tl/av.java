package com.bytedance.msdk.tl;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class av {
    private static final Map<Integer, Map<String, List<List<String>>>> ae = new HashMap();
    private static boolean cw = true;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f25204j = true;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f25205m = false;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f25206r = true;
    private static boolean up = true;
    private static boolean xt = true;

    public static boolean j() {
        return f25205m;
    }

    public static boolean ae() {
        if (!f25206r) {
            return false;
        }
        f25206r = false;
        return true;
    }

    public static void j(boolean z5) {
        f25205m = z5;
    }

    public static boolean m() {
        if (!cw) {
            return false;
        }
        cw = false;
        return true;
    }

    public static boolean r() {
        if (!f25204j) {
            return false;
        }
        f25204j = false;
        return true;
    }

    public static boolean tl() {
        if (!up) {
            return false;
        }
        up = false;
        return true;
    }

    public static boolean up() {
        if (!xt) {
            return false;
        }
        xt = false;
        return true;
    }

    public static boolean cw() {
        StackTraceElement[] stackTraceElementArr;
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        try {
            stackTraceElementArr = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0 || (map = ae.get(8)) == null || (list = map.get(MediationConstant.ADN_PANGLE)) == null || list.size() <= 1) {
            return true;
        }
        return j(stackTraceElementArr, list);
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                                Integer valueOf = Integer.valueOf(jSONObject2.optInt("rit_type"));
                                JSONArray optJSONArray2 = jSONObject2.optJSONArray("adn_features");
                                if (optJSONArray2 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                                        JSONArray jSONArray = optJSONArray2.getJSONArray(i7);
                                        if (jSONArray != null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                                                String string = jSONArray.getString(i8);
                                                if (!TextUtils.isEmpty(string)) {
                                                    arrayList2.add(string);
                                                }
                                            }
                                            arrayList.add(arrayList2);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(next, arrayList);
                                        ae.put(valueOf, hashMap);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e6) {
                com.bytedance.msdk.j.up.cw.j("TMe", "supervisorFeature error: " + e6.toString());
                com.bytedance.sdk.component.utils.vl.j(e6);
                return;
            }
        }
        com.bytedance.msdk.j.up.cw.j("TMe", "--==-- adn features:" + ae);
    }

    public static boolean xt() {
        StackTraceElement[] stackTraceElementArr;
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        try {
            stackTraceElementArr = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0 || (map = ae.get(7)) == null || (list = map.get(MediationConstant.ADN_PANGLE)) == null || list.size() <= 1) {
            return true;
        }
        return j(stackTraceElementArr, list);
    }

    private static boolean j(Object obj, List<List<String>> list) {
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        for (List<String> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                for (int i6 = 0; i6 < stackTraceElementArr.length; i6++) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i6];
                    if (stackTraceElement != null) {
                        String stackTraceElement2 = stackTraceElement.toString();
                        if (!TextUtils.isEmpty(stackTraceElement2) && stackTraceElement2.contains(list2.get(0)) && (list2.size() == 1 || j(stackTraceElementArr, i6, list2))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean j(Object obj, int i6, List<String> list) {
        int i7;
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        for (int i8 = 0; i8 < list.size(); i8++) {
            String str = list.get(i8);
            if (TextUtils.isEmpty(str) || (i7 = i6 + i8) >= stackTraceElementArr.length) {
                return false;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i7];
            if (stackTraceElement != null) {
                String stackTraceElement2 = stackTraceElement.toString();
                if (TextUtils.isEmpty(stackTraceElement2) || !stackTraceElement2.contains(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
