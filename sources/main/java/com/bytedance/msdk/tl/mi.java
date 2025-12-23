package com.bytedance.msdk.tl;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes3.dex */
public class mi {

    /* renamed from: j, reason: collision with root package name */
    private static final HashSet f25226j = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace"));

    public static String j() {
        StackTraceElement[] stackTraceElementArr;
        try {
            stackTraceElementArr = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (stackTraceElement != null) {
                    if (!f25226j.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                        String className = stackTraceElement.getClassName();
                        if (className != null && className.startsWith("android.app")) {
                            break;
                        }
                        jSONArray.put(stackTraceElement.toString());
                    } else {
                        continue;
                    }
                }
            }
            return jSONArray.toString();
        } catch (OutOfMemoryError e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return "";
        }
    }

    public static String xt() {
        StackTraceElement[] stackTraceElementArr;
        Map<String, List<String>> rn;
        try {
            stackTraceElementArr = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr != null && stackTraceElementArr.length != 0 && (rn = com.bytedance.msdk.core.xt.xt().rn()) != null && !rn.isEmpty()) {
            for (String str : rn.keySet()) {
                if (j(rn.get(str), stackTraceElementArr)) {
                    return str;
                }
            }
        }
        return null;
    }

    public static double cw() {
        return com.bytedance.msdk.core.xt.xt().wq();
    }

    private static boolean r() {
        Map<String, List<String>> rn = com.bytedance.msdk.core.xt.xt().rn();
        if (rn != null && rn.size() != 0) {
            return j(com.bytedance.msdk.core.xt.xt().wq());
        }
        return false;
    }

    public static String j(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            if (j(map.get(str))) {
                jSONArray.put(str);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        try {
            return jSONArray.toString();
        } catch (OutOfMemoryError e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return "";
        }
    }

    private static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean j(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null) {
            for (int i6 = 0; i6 < list.size(); i6++) {
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (list.get(i6) != null) {
                        try {
                            if (stackTraceElement.toString().contains(list.get(i6))) {
                                return true;
                            }
                        } catch (OutOfMemoryError e6) {
                            com.bytedance.sdk.component.utils.vl.j(e6);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean j(com.bytedance.msdk.xt.cw cwVar) {
        if (cwVar == null || !cwVar.dj()) {
            return false;
        }
        return r();
    }

    public static boolean j(com.bytedance.msdk.core.oq.oq oqVar) {
        if (oqVar == null || !oqVar.c()) {
            return false;
        }
        return r();
    }

    public static boolean j(double d6) {
        return d6 > 0.0d && Math.random() <= d6;
    }
}
