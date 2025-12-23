package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class PLSharedPreferences {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33334b = "PLSharedPreferences";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33335c = "grs_move2DE_records";

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f33336a;

    public String getString(String str) {
        return getString(str, "");
    }

    private SharedPreferences a(Context context, String str) {
        Context createDeviceProtectedStorageContext;
        boolean moveSharedPreferencesFrom;
        if (context == null) {
            Logger.e(f33334b, "context is null, must call init method to set context");
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences(f33335c, 0);
            if (!sharedPreferences.getBoolean(str, false)) {
                moveSharedPreferencesFrom = createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str);
                if (moveSharedPreferencesFrom) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean(str, true);
                    edit.apply();
                }
            }
            context = createDeviceProtectedStorageContext;
        }
        return context.getSharedPreferences(str, 0);
    }

    public void clear() {
        SharedPreferences sharedPreferences = this.f33336a;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().clear().apply();
    }

    public SharedPreferences.Editor edit() {
        SharedPreferences sharedPreferences = this.f33336a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.edit();
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.f33336a;
        if (sharedPreferences == null) {
            return null;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        StringBuilder sb = new StringBuilder();
        sb.append("sp size ");
        sb.append(all == null ? 0 : all.size());
        Logger.i(f33334b, sb.toString());
        return all;
    }

    public Map<String, String> getHashMap(String str) {
        HashMap hashMap = new HashMap();
        SharedPreferences sharedPreferences = this.f33336a;
        if (sharedPreferences != null) {
            try {
                JSONArray jSONArray = new JSONArray(sharedPreferences.getString(str, ""));
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i6);
                    JSONArray names = jSONObject.names();
                    if (names != null) {
                        for (int i7 = 0; i7 < names.length(); i7++) {
                            String string = names.getString(i7);
                            hashMap.put(string, jSONObject.getString(string));
                        }
                    }
                }
            } catch (JSONException e6) {
                Logger.w(f33334b, "getHashMap parse Json to map error: %s", StringUtils.anonymizeMessage(e6.getMessage()));
                return hashMap;
            }
        }
        return hashMap;
    }

    public long getLong(String str, long j6) {
        SharedPreferences sharedPreferences = this.f33336a;
        return sharedPreferences == null ? j6 : sharedPreferences.getLong(str, j6);
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f33336a;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    public void putHashMap(String str, Map<String, String> map) {
        if (this.f33336a == null || map == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e6) {
                Logger.w(f33334b, "putHashMap one object error: %s", StringUtils.anonymizeMessage(e6.getMessage()));
            }
        }
        jSONArray.put(jSONObject);
        this.f33336a.edit().putString(str, jSONArray.toString()).apply();
    }

    public void putLong(String str, long j6) {
        SharedPreferences sharedPreferences = this.f33336a;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(str, j6).apply();
    }

    public void putString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f33336a;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences = this.f33336a;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public void removeKeyValue(String str) {
        SharedPreferences sharedPreferences = this.f33336a;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public PLSharedPreferences(Context context, String str) {
        this.f33336a = a(context, str);
    }
}
