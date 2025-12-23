package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzwx {
    private JSONObject zza = new JSONObject();
    private Date zzb;
    private JSONArray zzc;

    private zzwx() {
        Date date;
        date = zzwy.zza;
        this.zzb = date;
        this.zzc = new JSONArray();
    }

    public final zzwx zza(JSONObject jSONObject) {
        try {
            this.zza = new JSONObject(jSONObject.toString());
        } catch (JSONException unused) {
        }
        return this;
    }

    public final zzwx zzb(JSONArray jSONArray) {
        try {
            this.zzc = new JSONArray(jSONArray.toString());
        } catch (JSONException unused) {
        }
        return this;
    }

    public final zzwx zzc(Date date) {
        this.zzb = date;
        return this;
    }

    public final zzwy zzd() throws JSONException {
        return new zzwy(this.zza, this.zzb, this.zzc);
    }

    /* synthetic */ zzwx(zzww zzwwVar) {
        Date date;
        date = zzwy.zza;
        this.zzb = date;
        this.zzc = new JSONArray();
    }
}
