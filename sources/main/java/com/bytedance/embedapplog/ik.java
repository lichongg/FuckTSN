package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* loaded from: D:\Downloads\app\classes3.dex */
final class ik {

    /* renamed from: j, reason: collision with root package name */
    private static wf<String> f23997j = new wf<String>() { // from class: com.bytedance.embedapplog.ik.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.wf
        /* renamed from: cw, reason: merged with bridge method [inline-methods] */
        public String j(Object... objArr) {
            SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
            String string = sharedPreferences.getString("cdid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String uuid = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("cdid", uuid).apply();
            return uuid;
        }
    };

    static String j(SharedPreferences sharedPreferences) {
        return f23997j.xt(sharedPreferences);
    }
}
