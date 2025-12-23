package com.ss.android.downloadlib.addownload.j;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.cw;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
class e {
    @NonNull
    CopyOnWriteArrayList<o.e> a(String str, String str2) {
        CopyOnWriteArrayList<o.e> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = cw.j(m.getContext(), str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    o.e a6 = o.e.a(jSONObject.optJSONObject(keys.next()));
                    if (a6 != null) {
                        copyOnWriteArrayList.add(a6);
                    }
                }
            }
            return copyOnWriteArrayList;
        } catch (Exception e6) {
            vl.j(e6);
            return copyOnWriteArrayList;
        }
    }

    void b(String str, String str2, CopyOnWriteArrayList<o.e> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<o.e> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                o.e next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.f37936b), next.b());
                }
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
        cw.j(m.getContext(), str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    e() {
    }

    void c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            cw.j(m.getContext(), str, 0).edit().putString(str2, "").apply();
        }
    }
}
