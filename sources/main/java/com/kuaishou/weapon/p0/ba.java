package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ba {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35757a;

    public String a(String str) {
        JSONObject jSONObject = this.f35757a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b(String str) {
        if (this.f35757a == null) {
            return null;
        }
        try {
            String a6 = a(str);
            if (TextUtils.isEmpty(a6) || a6.length() <= 3) {
                return null;
            }
            return new JSONObject(a6);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f35757a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 2) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                hashSet.add((String) jSONArray.get(i6));
            }
            Set a6 = a(hashSet);
            if (a6 == null || a6.size() <= 0) {
                return null;
            }
            return new JSONArray((Collection) a6);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(String str) {
        if (this.f35757a == null) {
            return null;
        }
        try {
            String a6 = a(str);
            if (TextUtils.isEmpty(a6) || a6.length() <= 3) {
                return null;
            }
            return a(new JSONObject(a6));
        } catch (Exception unused) {
            return null;
        }
    }

    public ba(Context context, int i6) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35870c).intValue(), 2, i6 < 10 ? 10 : i6, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f35757a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a(String str, boolean z5) {
        if (this.f35757a != null) {
            try {
                String a6 = a(str);
                if (!TextUtils.isEmpty(a6) && a6.length() > 3) {
                    JSONObject jSONObject = new JSONObject(a6);
                    if (z5) {
                        Iterator<String> keys = jSONObject.keys();
                        boolean z6 = false;
                        while (keys.hasNext()) {
                            if (jSONObject.getInt(keys.next()) == 1) {
                                z6 = true;
                            }
                        }
                        if (!z6) {
                            return null;
                        }
                    }
                    return jSONObject;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean a(Set set, String str) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!str2.equals(str) && str2.contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public Set a(Set set) {
        if (set != null) {
            try {
                if (set.size() > 0) {
                    HashSet hashSet = new HashSet();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!a(set, str)) {
                            hashSet.add(str);
                        }
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONObject a(JSONObject jSONObject) {
        try {
            String a6 = i.a("da4c6c97b9", "0702");
            String a7 = i.a("da4c709eb15f", "0702");
            JSONArray optJSONArray = jSONObject.optJSONArray(a6);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(a7);
            JSONObject jSONObject2 = new JSONObject();
            if (optJSONArray != null && optJSONArray.length() == 3) {
                jSONObject2.put("0", optJSONArray.get(2));
            }
            if (optJSONArray2 != null && optJSONArray2.length() == 3) {
                jSONObject2.put("1", optJSONArray2.get(2));
            }
            if (jSONObject2.length() > 0) {
                return jSONObject2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
