package com.bytedance.msdk.api.r.j.xt.j;

import android.view.View;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j extends com.bytedance.msdk.api.r.j.xt.xt.j {
    @Nullable
    public abstract View xt();

    public final View j() {
        try {
            return xt();
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }
}
