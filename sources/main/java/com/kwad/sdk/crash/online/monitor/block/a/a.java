package com.kwad.sdk.crash.online.monitor.block.a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends c {
    private static String aHP = "CREATE TABLE IF NOT EXISTS ksad_block_actions (actionId varchar(60) primary key, aLog TEXT)";

    public a(@Nullable Context context, int i6) {
        super(context, "ksadBlock.db", i6, aHP);
    }
}
