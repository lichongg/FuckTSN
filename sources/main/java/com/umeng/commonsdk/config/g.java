package com.umeng.commonsdk.config;

import com.umeng.commonsdk.debug.UMRTLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class g implements e {
    @Override // com.umeng.commonsdk.config.e
    public void a(String str, Object obj, String[] strArr) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong == -1) {
                UMRTLog.e("Config", "--->>> SensitiveFieldHandler: handleConfigItem: invalid config value.");
                return;
            }
            UMRTLog.i("Config", "--->>> CollectFieldJudgment: handleConfigItem: item : " + str);
            if (obj == null || !(obj instanceof b)) {
                return;
            }
            for (int i6 = 0; i6 < strArr.length; i6++) {
                try {
                    String str2 = strArr[i6];
                    if (d.a(str2)) {
                        ((b) obj).a(str2, Boolean.valueOf(a.a(parseLong, i6)));
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
        } catch (Throwable unused2) {
            UMRTLog.e("Config", "--->>> SensitiveFieldHandler: handleConfigItem: parseLong exception.");
        }
    }
}
