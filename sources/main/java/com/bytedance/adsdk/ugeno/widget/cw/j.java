package com.bytedance.adsdk.ugeno.widget.cw;

import android.content.Context;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j extends com.bytedance.adsdk.ugeno.xt.j<UGFrameLayout> {
    public j(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "onVideoProgress":
            case "onVideoFinish":
            case "onVideoPlay":
            case "onVideoResume":
            case "onVideoPause":
                xt(str, str2);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
    }
}
