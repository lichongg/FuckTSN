package com.kwad.sdk.core.config.item;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends b<Integer> {
    public c() {
        super("batchReportCacheType", 2);
    }

    public static int bt(@Nullable Context context) {
        SharedPreferences sharedPreferences;
        try {
            com.kwad.sdk.core.d.c.d("batchReportCacheType", "loadBatchReportCacheType");
            if (context != null && (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) != null) {
                return sharedPreferences.getInt("batchReportCacheType", 2);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        return 2;
    }

    private static void i(@Nullable Context context, int i6) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.d.c.d("batchReportCacheType", "saveBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("batchReportCacheType", i6);
        edit.apply();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Integer.valueOf(jSONObject.optInt(getKey(), Gu().intValue())));
        } else {
            setValue(Gu());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Integer.valueOf(bt(ServiceProvider.Pp())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        i(ServiceProvider.Pp(), getValue().intValue());
    }
}
