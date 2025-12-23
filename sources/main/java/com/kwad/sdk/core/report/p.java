package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p extends c {
    public static int Nv = 1;
    private static String aHP = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public p(@Nullable Context context, int i6) {
        super(context, "ksadrep.db", i6, aHP);
    }
}
