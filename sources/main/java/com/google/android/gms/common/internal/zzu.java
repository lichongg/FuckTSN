package com.google.android.gms.common.internal;

import android.net.Uri;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzu {
    private static final Uri zza;
    private static final Uri zzb;

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        zza = parse;
        zzb = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
