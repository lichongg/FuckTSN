package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> ayA = new ConcurrentHashMap();
    private static SharedPreferences ayB = null;

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> dy = dy(key);
        if (dy == null) {
            dy = new CopyOnWriteArraySet<>();
            ayA.put(key, dy);
        }
        dy.add(bVar);
    }

    private static SharedPreferences EN() {
        if (ayB == null) {
            ayB = bo.ho("ksadsdk_config");
        }
        return ayB;
    }

    @WorkerThread
    public static synchronized void bq(Context context) {
        synchronized (b.class) {
            try {
                SharedPreferences EN = EN();
                if (EN != null) {
                    SharedPreferences.Editor edit = EN.edit();
                    a(edit);
                    edit.commit();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    @WorkerThread
    public static synchronized void br(Context context) {
        synchronized (b.class) {
            SharedPreferences EN = EN();
            if (EN != null) {
                a(EN);
            }
        }
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : ayA.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = ayA.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.k(jSONObject);
                    }
                }
            }
        }
    }

    @Nullable
    private static Set<com.kwad.sdk.core.config.item.b> dy(String str) {
        if (!TextUtils.isEmpty(str)) {
            return ayA.get(str);
        }
        return null;
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            Iterator<String> it = ayA.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = ayA.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            Iterator<String> it = ayA.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = ayA.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e6) {
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                            }
                        }
                    }
                }
            }
        }
    }

    static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences EN;
        if (bVar == null || (EN = EN()) == null) {
            return;
        }
        try {
            bVar.a(EN);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }
}
