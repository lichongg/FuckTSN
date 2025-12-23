package com.umeng.commonsdk.statistics;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TagHelper {
    private static Object lock = new Object();
    private static Map<String, String> moduleTags = new HashMap();

    public static void deleteModuleTag(String str) {
        synchronized (lock) {
            try {
                if (moduleTags.containsKey(str)) {
                    moduleTags.remove(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, String> getModuleTags() {
        HashMap hashMap = new HashMap();
        synchronized (lock) {
            try {
                if (moduleTags.size() > 0) {
                    for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                        hashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static void setModuleTag(String str, String str2) {
        synchronized (lock) {
            if (moduleTags.size() >= 30) {
                return;
            }
            if (!moduleTags.containsKey(str)) {
                moduleTags.put(str, str2);
            }
        }
    }
}
