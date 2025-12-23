package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35741a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f35742b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f35743c;

    public String a(String str) {
        JSONObject jSONObject = this.f35741a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f35741a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                hashSet.add(jSONArray.getString(i6));
            }
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                jSONArray2.put(it.next());
            }
            return jSONArray2;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set c(String str) {
        JSONObject jSONObject = this.f35741a;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        Integer valueOf = Integer.valueOf((String) jSONArray.get(i6), 16);
                        valueOf.intValue();
                        hashSet.add(valueOf);
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONArray d(String str) {
        JSONObject jSONObject = this.f35741a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            int i6 = 0;
            if (TextUtils.equals(str, "46")) {
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                JSONArray jSONArray2 = new JSONArray();
                while (i6 < jSONArray.length()) {
                    jSONArray2.put(jSONArray.getString(i6).replaceAll(" ", "").replace(com.snail.antifake.deviceid.e.f37542d, "").replace(">", ""));
                    i6++;
                }
                return jSONArray2;
            }
            if (!TextUtils.equals(str, "45")) {
                return null;
            }
            String a6 = i.a("aae31bed33c490b6613a", "0701");
            String a7 = i.a("99e111e83fc4d0a7662b", "0701");
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray3 = new JSONArray(string);
            HashSet hashSet = new HashSet();
            while (i6 < jSONArray3.length()) {
                hashSet.add(jSONArray3.getString(i6).replaceAll(" ", "").replace(com.snail.antifake.deviceid.e.f37542d, ""));
                i6++;
            }
            JSONArray jSONArray4 = new JSONArray();
            for (Object obj : hashSet) {
                jSONArray4.put(obj);
                String str2 = (String) obj;
                if (str2.contains(a6)) {
                    this.f35742b = true;
                }
                if (str2.contains(a7)) {
                    this.f35743c = true;
                }
            }
            return jSONArray4;
        } catch (Exception unused) {
            return null;
        }
    }

    public at(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35874g).intValue(), 0, 100, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f35741a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public Set a(int i6) {
        HashSet hashSet = new HashSet();
        if (i6 == 0) {
            hashSet.add("/preas/chi");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i6) {
        JSONObject jSONObject = this.f35741a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            Set a6 = a(i6);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                String replace = jSONArray.getString(i7).replaceAll(" ", "").replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\t", "").replace("\u200b", "");
                boolean startsWith = replace.startsWith(":");
                String str2 = replace;
                if (startsWith) {
                    str2 = replace.substring(1);
                }
                String substring = str2.length() > 10 ? str2.substring(0, 10) : str2;
                String packageName = context.getPackageName();
                if (!str2.contains(packageName) && !packageName.contains(str2) && !a6.contains(substring)) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b() {
        return this.f35743c;
    }

    public boolean a() {
        return this.f35742b;
    }
}
