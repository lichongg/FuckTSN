package com.bytedance.sdk.openadsdk.core.ugeno.component.j;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.adsdk.ugeno.widget.xt.j {
    public j(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.xt.j
    public String qv(String str) {
        str.getClass();
        switch (str) {
            case "unmuted":
                return "tt_ugen_unmuted";
            case "back":
                return "tt_ugen_back";
            case "logo":
                return "tt_ugen_logo";
            case "close":
                return "tt_ugen_close";
            case "muted":
                return "tt_ugen_muted";
            default:
                return "";
        }
    }
}
