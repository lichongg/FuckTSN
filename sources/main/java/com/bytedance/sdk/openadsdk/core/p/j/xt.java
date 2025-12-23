package com.bytedance.sdk.openadsdk.core.p.j;

import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private boolean j(long j6, long j7) {
        long currentTimeMillis = System.currentTimeMillis();
        return j7 == 0 ? !uf.j(j6, currentTimeMillis) : currentTimeMillis - j6 >= j7;
    }

    private void xt(JSONObject jSONObject, String str) {
        FileOutputStream fileOutputStream;
        byte[] r5 = r(jSONObject.toString());
        if (r5 == null || r5.length <= 0) {
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(new File(com.bytedance.sdk.openadsdk.api.plugin.xt.j(v.getContext()), new File(str).getName()));
        } catch (Throwable unused) {
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(r5);
            com.bytedance.sdk.component.m.cw.cw.xt.j(fileOutputStream);
        } catch (Throwable unused2) {
            com.bytedance.sdk.component.m.cw.cw.xt.j(fileOutputStream);
        }
    }

    private JSONObject cw(String str) {
        byte[] r5 = m.r(new File(com.bytedance.sdk.openadsdk.api.plugin.xt.j(v.getContext()), new File(str).getName()));
        if (r5 == null) {
            return null;
        }
        try {
            String j6 = j(r5);
            if (j6 != null) {
                return new JSONObject(j6);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        return null;
    }

    private boolean up(String str) {
        File[] listFiles;
        long lastModified;
        File file = new File(str);
        boolean z5 = true;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (name.startsWith("._tt_")) {
                    try {
                        lastModified = Long.parseLong(name.substring(5));
                    } catch (Throwable unused) {
                        lastModified = file2.lastModified();
                    }
                    if (uf.j(lastModified, System.currentTimeMillis())) {
                        z5 = false;
                    } else {
                        file2.delete();
                    }
                }
            }
        }
        if (z5) {
            new File(file, "._tt_" + System.currentTimeMillis()).mkdirs();
        }
        return z5;
    }

    private byte[] r(String str) {
        byte[] bytes = com.bytedance.sdk.component.utils.j.xt(str).getBytes(StandardCharsets.UTF_8);
        if (bytes != null && bytes.length > 0) {
            ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 1);
            allocate.put((byte) 3);
            allocate.put(bytes);
            return allocate.array();
        }
        return null;
    }

    public void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject j6;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("id_conf")) == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.r.j.xt j7 = com.bytedance.sdk.openadsdk.core.xt.j();
            long j8 = j7.getLong("last_gather_id_time", 0L);
            long optLong = optJSONObject.optLong("delt", 0L);
            if (j8 <= 0 || j(j8, optLong)) {
                String optString = optJSONObject.optString("store");
                int optInt = optJSONObject.optInt("state", 0);
                if (optInt != 1) {
                    if (optInt != 2) {
                        if (optInt != 4) {
                            return;
                        }
                        File file = new File(optString);
                        File file2 = new File(com.bytedance.sdk.openadsdk.api.plugin.xt.j(v.getContext()), file.getName());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        j(file);
                    }
                    j6 = null;
                } else {
                    j6 = j(optString);
                }
                int optInt2 = optJSONObject.optInt("upload", 0);
                if (optInt2 != 1 && optInt2 != 2) {
                    return;
                }
                j7.j("last_gather_id_time", System.currentTimeMillis());
                File file3 = new File(optString);
                j6.put("c_r", file3.canRead());
                j6.put("c_w", file3.canWrite());
                j6.put("d", optString);
                j(optString, j6, optInt2 == 1);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @DungeonFlag
    private JSONObject xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        JSONObject cw = cw(str);
        if (file.exists() && file.isDirectory() && file.canRead()) {
            HashMap hashMap = new HashMap();
            j(file, str, hashMap);
            if (hashMap.size() != 0) {
                if (cw == null) {
                    cw = new JSONObject();
                }
                JSONObject optJSONObject = cw.optJSONObject(CommonNetImpl.AID);
                try {
                    if (optJSONObject == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            cw.put(CommonNetImpl.AID, jSONObject);
                        } catch (JSONException unused) {
                        }
                        optJSONObject = jSONObject;
                    } else {
                        for (Map.Entry<String, Set<String>> entry : hashMap.entrySet()) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray(entry.getKey());
                            if (optJSONArray != null) {
                                Set<String> value = entry.getValue();
                                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                                    String optString = optJSONArray.optString(i6);
                                    if (!TextUtils.isEmpty(optString)) {
                                        value.add(optString);
                                    }
                                }
                            }
                        }
                    }
                } catch (JSONException unused2) {
                }
                for (Map.Entry<String, Set<String>> entry2 : hashMap.entrySet()) {
                    String key = entry2.getKey();
                    Set<String> value2 = entry2.getValue();
                    if (!TextUtils.isEmpty(key) && value2 != null && value2.size() != 0) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            Iterator<String> it = value2.iterator();
                            while (it.hasNext()) {
                                jSONArray.put(it.next());
                            }
                            optJSONObject.put(key, jSONArray);
                        } catch (JSONException e6) {
                            vl.j(e6);
                        }
                    }
                }
            }
        }
        return cw;
    }

    private void j(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        j(file2);
                    }
                }
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject j(String str) throws JSONException {
        String m6 = kt.m();
        if (TextUtils.isEmpty(m6)) {
            return null;
        }
        String str2 = (!kt.up() ? 1 : 0) + m6;
        JSONObject xt = xt(str);
        if (xt == null) {
            xt = new JSONObject();
        }
        JSONObject optJSONObject = xt.optJSONObject(CommonNetImpl.AID);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            xt.putOpt(CommonNetImpl.AID, optJSONObject);
        }
        String packageName = v.getContext().getPackageName();
        if (packageName == null) {
            packageName = oq.i().f();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(packageName);
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
            optJSONObject.put(packageName, optJSONArray);
        }
        int i6 = 0;
        while (true) {
            if (i6 >= optJSONArray.length()) {
                i6 = -1;
                break;
            }
            if (TextUtils.equals(optJSONArray.optString(i6), str2)) {
                break;
            }
            i6++;
        }
        if (i6 == -1) {
            optJSONArray.put(str2);
        }
        xt(xt, str);
        j(optJSONObject, str);
        return xt;
    }

    @DungeonFlag
    private void j(JSONObject jSONObject, String str) {
        File file = new File(str);
        if (file.exists()) {
            if (!file.canWrite()) {
                return;
            }
        } else if (!file.mkdirs()) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray optJSONArray = jSONObject.optJSONArray(next);
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    String optString = optJSONArray.optString(i6);
                    if (!TextUtils.isEmpty(optString)) {
                        byte[] r5 = r(next + "/" + optString);
                        if (r5 != null) {
                            File file2 = new File(str, j.j(r5, 20));
                            if (file2.isFile()) {
                                file2.delete();
                            }
                            file2.mkdirs();
                            file2.getAbsolutePath();
                        }
                    }
                }
            }
        }
    }

    private void j(File file, String str, Map<String, Set<String>> map) {
        if (file == null || !file.exists() || !file.canRead() || file.getName().startsWith("._tt_")) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (!file2.getName().startsWith("._tt_") && file2.isDirectory()) {
                        j(file2, str, map);
                        file2.delete();
                    }
                }
                return;
            }
            file.delete();
            String absolutePath = file.getAbsolutePath();
            if (absolutePath.length() <= str.length()) {
                return;
            }
            try {
                String j6 = j(j.j(absolutePath.substring(str.length() + 1)));
                if (j6 == null) {
                    return;
                }
                String[] split = j6.split("/");
                if (split.length != 2) {
                    return;
                }
                String str2 = split[0];
                String str3 = split[1];
                Set<String> set = map.get(str2);
                if (set == null) {
                    set = new HashSet<>();
                    map.put(str2, set);
                }
                set.add(str3);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        file.delete();
    }

    private String j(byte[] bArr) throws JSONException {
        byte b6 = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        if (b6 == 3) {
            return com.bytedance.sdk.component.utils.j.cw(new String(bArr2));
        }
        return null;
    }

    private void j(String str, JSONObject jSONObject, boolean z5) {
        if (z5 || up(str)) {
            j(str, jSONObject);
        }
    }

    private void j(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            jSONObject = xt(str);
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(CommonNetImpl.AID);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            HashSet hashSet = new HashSet();
            int i6 = 0;
            while (keys.hasNext()) {
                i6++;
                JSONArray optJSONArray = optJSONObject.optJSONArray(keys.next());
                if (optJSONArray != null) {
                    for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                        String optString = optJSONArray.optString(i7);
                        if (!TextUtils.isEmpty(optString)) {
                            hashSet.add(optString);
                        }
                    }
                }
            }
            try {
                jSONObject.put("size", i6);
                if (!hashSet.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put("all", jSONArray);
                }
            } catch (JSONException unused) {
            }
        }
        ws.j().j("s_d_i_c", jSONObject);
    }
}
