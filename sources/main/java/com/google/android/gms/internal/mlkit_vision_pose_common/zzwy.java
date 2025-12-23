package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.annotation.VisibleForTesting;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzwy {
    private static final Date zza = new Date(0);
    private final JSONObject zzb;
    private final JSONObject zzc;
    private final Date zzd;

    public final String toString() {
        return this.zzb.toString();
    }

    public final Date zzb() {
        return this.zzd;
    }

    public final JSONObject zzc() {
        return this.zzc;
    }

    @VisibleForTesting
    zzwy(JSONObject jSONObject, Date date, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("configs_key", jSONObject);
        jSONObject2.put("fetch_time_key", date.getTime());
        jSONObject2.put("abt_experiments_key", jSONArray);
        this.zzc = jSONObject;
        this.zzd = date;
        this.zzb = jSONObject2;
    }
}
