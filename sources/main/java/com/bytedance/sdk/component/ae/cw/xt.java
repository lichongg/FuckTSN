package com.bytedance.sdk.component.ae.cw;

import android.util.Pair;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bytedance.sdk.component.ae.j, com.bytedance.sdk.component.ae.xt {
    private final boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.component.r.j.j f26076j;
    private final com.bytedance.sdk.component.r.j.j xt;

    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto Lb
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> Lb
            goto Lc
        Lb:
            r2 = 0
        Lc:
            if (r2 != 0) goto L12
            r2 = 0
            r1.f26076j = r2
            return
        L12:
            com.bytedance.sdk.component.r.j.j r0 = r1.f26076j
            if (r0 == 0) goto L1c
            int r0 = r0.j()
            if (r0 == r2) goto L2e
        L1c:
            java.lang.Class<com.bytedance.sdk.component.r.r> r0 = com.bytedance.sdk.component.r.r.class
            java.lang.Object r0 = com.bytedance.sdk.openadsdk.ats.AutoService.j(r0)
            com.bytedance.sdk.component.r.r r0 = (com.bytedance.sdk.component.r.r) r0
            if (r0 == 0) goto L2e
            com.bytedance.sdk.component.r.j.j r2 = r0.j(r2)
            if (r2 == 0) goto L2e
            r1.f26076j = r2
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ae.cw.xt.j(java.lang.String):void");
    }

    private Pair<String, String> getType(String str) {
        if (str.contains(".")) {
            String[] split = str.split("\\.");
            if (split.length >= 2) {
                return new Pair<>(split[0], split[1]);
            }
        }
        return new Pair<>("s", str);
    }

    public xt(com.bytedance.sdk.component.r.j.j jVar, boolean z5) {
        this.f26076j = jVar;
        this.xt = jVar;
        this.cw = z5;
    }

    @Override // com.bytedance.sdk.component.ae.j
    public Map<String, Object> j(File file) {
        FileReader fileReader;
        if (file == null || !file.exists()) {
            return null;
        }
        if (!file.canRead()) {
            vl.xt("PropReaderWriter", "can't read file ".concat(String.valueOf(file)));
            return null;
        }
        Properties properties = new Properties();
        try {
            fileReader = new FileReader(file);
            try {
                properties.load(fileReader);
                Object obj = properties.get(".i.tt_ect");
                if (obj != null) {
                    j(String.valueOf(obj));
                }
                Enumeration<?> propertyNames = properties.propertyNames();
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(properties.size());
                while (propertyNames.hasMoreElements()) {
                    String str = (String) propertyNames.nextElement();
                    String property = properties.getProperty(str);
                    if (str != null && !str.startsWith(".i.tt_ect")) {
                        if (this.cw) {
                            str = (String) this.f26076j.xt(str);
                        }
                        com.bytedance.sdk.component.r.j.j jVar = this.f26076j;
                        if (jVar != null) {
                            property = (String) jVar.xt(property);
                        }
                        Pair<String, String> type = getType(str);
                        String str2 = (String) type.second;
                        String str3 = (String) type.first;
                        int hashCode = str3.hashCode();
                        if (hashCode != 98) {
                            if (hashCode != 102) {
                                if (hashCode != 105) {
                                    if (hashCode != 108) {
                                        if (hashCode == 115) {
                                            str3.equals("s");
                                        } else if (hashCode == 3680 && str3.equals("ss")) {
                                            JSONArray jSONArray = new JSONArray(property);
                                            HashSet hashSet = new HashSet((int) (jSONArray.length() / 0.75d));
                                            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                                                hashSet.add(jSONArray.optString(i6));
                                            }
                                            concurrentHashMap.put(str2, hashSet);
                                        }
                                        concurrentHashMap.put(str2, property);
                                    } else if (str3.equals(t.f36143d)) {
                                        concurrentHashMap.put(str2, Long.valueOf(Long.parseLong(property)));
                                    } else {
                                        concurrentHashMap.put(str2, property);
                                    }
                                } else if (str3.equals("i")) {
                                    concurrentHashMap.put(str2, Integer.valueOf(Integer.parseInt(property)));
                                } else {
                                    concurrentHashMap.put(str2, property);
                                }
                            } else if (str3.equals("f")) {
                                concurrentHashMap.put(str2, Float.valueOf(Float.parseFloat(property)));
                            } else {
                                concurrentHashMap.put(str2, property);
                            }
                        } else if (str3.equals("b")) {
                            concurrentHashMap.put(str2, Boolean.valueOf(Boolean.parseBoolean(property)));
                        } else {
                            concurrentHashMap.put(str2, property);
                        }
                    }
                }
                try {
                    fileReader.close();
                } catch (Throwable unused) {
                }
                return concurrentHashMap;
            } catch (Throwable th) {
                th = th;
                try {
                    boolean delete = file.delete();
                    com.bytedance.sdk.component.r.cw cwVar = (com.bytedance.sdk.component.r.cw) AutoService.j(com.bytedance.sdk.component.r.cw.class);
                    if (cwVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(b.f50156c, file.getAbsolutePath());
                            jSONObject.put("delete", delete);
                            jSONObject.put("msg", "read failed");
                            jSONObject.put("class", "PropReaderWriter");
                        } catch (JSONException unused2) {
                        }
                        cwVar.j("kv", jSONObject, th);
                    }
                    vl.xt("PropReader", "read failed， try delete = " + delete + "," + file.getAbsolutePath(), th);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
        }
    }

    @Override // com.bytedance.sdk.component.ae.xt
    public void j(Map<String, Object> map, File file) throws IOException {
        FileWriter fileWriter;
        Throwable th;
        String str;
        String concat;
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Properties properties = new Properties();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    concat = "ss.".concat(key);
                    value = jSONArray.toString();
                } else if (entry.getValue() instanceof Boolean) {
                    concat = "b.".concat(key);
                } else if (entry.getValue() instanceof Integer) {
                    concat = "i.".concat(key);
                } else if (entry.getValue() instanceof Long) {
                    concat = "l.".concat(key);
                } else if (entry.getValue() instanceof Float) {
                    concat = "f.".concat(key);
                } else if (entry.getValue() instanceof Double) {
                    concat = "f.".concat(key);
                } else {
                    concat = "s.".concat(key);
                }
                String valueOf = String.valueOf(value);
                if (this.cw) {
                    concat = this.xt.j(concat);
                }
                com.bytedance.sdk.component.r.j.j jVar = this.xt;
                if (jVar != null) {
                    valueOf = jVar.j(valueOf);
                }
                properties.put(concat, valueOf);
            }
        }
        try {
            fileWriter = new FileWriter(file);
        } catch (Throwable th2) {
            fileWriter = null;
            th = th2;
        }
        try {
            com.bytedance.sdk.component.r.j.j jVar2 = this.xt;
            if (jVar2 != null) {
                str = String.valueOf(jVar2.j());
            } else {
                str = "0";
            }
            properties.put(".i.tt_ect", str);
            properties.store(fileWriter, (String) null);
            fileWriter.flush();
            try {
                fileWriter.close();
            } catch (Exception unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                    throw th;
                } catch (Exception unused3) {
                    throw th;
                }
            }
            throw th;
        }
    }
}
