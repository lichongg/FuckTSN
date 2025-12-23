package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tj {

    /* renamed from: j, reason: collision with root package name */
    private Map<String, j> f29715j;

    static class j {

        /* renamed from: j, reason: collision with root package name */
        private int f29716j;
        private int xt;

        public j(int i6, int i7) {
            this.f29716j = i6;
            this.xt = i7;
        }

        public int j() {
            return this.f29716j;
        }

        public int xt() {
            return this.xt;
        }

        public j() {
        }
    }

    public void j(Map<String, j> map) {
        this.f29715j = map;
    }

    public int xt(String str) {
        int j6 = j(false);
        Map<String, j> map = this.f29715j;
        if (map != null && map.containsKey(str)) {
            j jVar = this.f29715j.get(str);
            j6 = jVar != null ? j6 + jVar.xt() : j6 + 5000;
        }
        return j6 + 5000;
    }

    public int j(String str) {
        int j6 = j(true);
        Map<String, j> map = this.f29715j;
        if (map != null && map.containsKey(str)) {
            j jVar = this.f29715j.get(str);
            j6 = jVar != null ? j6 + jVar.j() : j6 + 5000;
        }
        return j6 + 5000;
    }

    @NonNull
    public String toString() {
        if (this.f29715j == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, j> entry : this.f29715j.entrySet()) {
            j value = entry.getValue();
            JSONArray jSONArray = new JSONArray();
            if (value != null) {
                jSONArray.put(value.j());
                jSONArray.put(value.xt());
                try {
                    jSONObject.put(entry.getKey(), jSONArray);
                } catch (JSONException e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
        }
        return jSONObject.toString();
    }

    public static tj cw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        tj tjVar = new tj();
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null && optJSONArray.length() == 2) {
                    hashMap.put(next, new j(optJSONArray.optInt(0), optJSONArray.optInt(1)));
                }
            }
            tjVar.j(hashMap);
            return tjVar;
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return tjVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078 A[Catch: JSONException -> 0x0051, NumberFormatException -> 0x0054, TryCatch #4 {NumberFormatException -> 0x0054, JSONException -> 0x0051, blocks: (B:23:0x0048, B:26:0x0059, B:29:0x006c, B:31:0x0078, B:32:0x0081, B:34:0x00a6, B:37:0x00bb, B:38:0x00c4, B:41:0x00af), top: B:22:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6 A[Catch: JSONException -> 0x0051, NumberFormatException -> 0x0054, TryCatch #4 {NumberFormatException -> 0x0054, JSONException -> 0x0051, blocks: (B:23:0x0048, B:26:0x0059, B:29:0x006c, B:31:0x0078, B:32:0x0081, B:34:0x00a6, B:37:0x00bb, B:38:0x00c4, B:41:0x00af), top: B:22:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb A[Catch: JSONException -> 0x0051, NumberFormatException -> 0x0054, TryCatch #4 {NumberFormatException -> 0x0054, JSONException -> 0x0051, blocks: (B:23:0x0048, B:26:0x0059, B:29:0x006c, B:31:0x0078, B:32:0x0081, B:34:0x00a6, B:37:0x00bb, B:38:0x00c4, B:41:0x00af), top: B:22:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af A[Catch: JSONException -> 0x0051, NumberFormatException -> 0x0054, TryCatch #4 {NumberFormatException -> 0x0054, JSONException -> 0x0051, blocks: (B:23:0x0048, B:26:0x0059, B:29:0x006c, B:31:0x0078, B:32:0x0081, B:34:0x00a6, B:37:0x00bb, B:38:0x00c4, B:41:0x00af), top: B:22:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int j(boolean r10) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.tj.j(boolean):int");
    }
}
