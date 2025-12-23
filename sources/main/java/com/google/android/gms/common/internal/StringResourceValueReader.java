package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bjtsn.pose_detection.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class StringResourceValueReader {
    private final Resources zza;
    private final String zzb;

    @Nullable
    @KeepForSdk
    public String getString(@NonNull String str) {
        int identifier = this.zza.getIdentifier(str, ResIdentify.RES_TYPE_STRING, this.zzb);
        if (identifier == 0) {
            return null;
        }
        return this.zza.getString(identifier);
    }

    public StringResourceValueReader(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.zza = resources;
        this.zzb = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }
}
