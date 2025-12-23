package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class aa {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void a(JSONObject jSONObject, String str, com.kwad.sdk.core.b bVar) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put(str, bVar.toJson());
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, str2);
    }

    public static <T> JSONArray S(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (T t5 : list) {
                        if (t5 != null) {
                            if (t5 instanceof JSONObject) {
                                jSONArray.put(t5);
                            } else if (t5 instanceof com.kwad.sdk.core.b) {
                                jSONArray.put(((com.kwad.sdk.core.b) t5).toJson());
                            } else {
                                if (!(t5 instanceof String)) {
                                    throw new IllegalArgumentException("<T> now suppprt type: " + t5.getClass().getName());
                                }
                                jSONArray.put(t5);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return jSONArray;
    }

    public static JSONArray a(JSONArray jSONArray, JSONObject jSONObject) {
        try {
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return jSONArray;
        }
    }

    public static void putValue(JSONObject jSONObject, String str, double d6) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, d6);
    }

    @NonNull
    public static <T extends com.kwad.sdk.core.b> T b(@Nullable String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        T Ef = cVar.Ef();
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Ef.parseJson(new JSONObject(str));
                    return Ef;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return Ef;
    }

    public static <T> List<T> gV(String str) {
        return ab.gV(str);
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        return ab.h(jSONArray);
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        return ab.parseJSON2MapString(str);
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        return ab.parseMap2JSON(map);
    }

    public static void putValue(JSONObject jSONObject, String str, int i6) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, i6);
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        return ab.toJsonArray(list);
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2, boolean z5) {
        try {
            ab.a(jSONObject, jSONObject2, z5);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f6) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, f6);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b6) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, b6);
    }

    public static <T extends com.kwad.sdk.core.b> List<T> a(String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i6);
                    T Ef = cVar.Ef();
                    Ef.parseJson(jSONObject);
                    arrayList.add(Ef);
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return arrayList;
            }
        }
        return arrayList;
    }

    public static void putValue(JSONObject jSONObject, String str, long j6) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, j6);
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z5) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, z5);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, jSONObject2);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, jSONArray);
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            boolean z5 = false;
            for (Object obj : list) {
                if (obj instanceof com.kwad.sdk.core.b) {
                    a(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof JSONObject) && !(obj instanceof JSONArray) && !(obj instanceof Double) && !(obj instanceof Boolean)) {
                        if (!(obj instanceof Float)) {
                            break;
                        } else {
                            try {
                                jSONArray.put(((Float) obj).floatValue());
                            } catch (JSONException unused) {
                            }
                        }
                    }
                    jSONArray.put(obj);
                }
                z5 = true;
            }
            if (z5) {
                putValue(jSONObject, str, jSONArray);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
