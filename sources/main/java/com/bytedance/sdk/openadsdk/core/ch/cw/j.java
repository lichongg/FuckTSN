package com.bytedance.sdk.openadsdk.core.ch.cw;

import android.content.Context;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.ats.cw;
import com.bytedance.sdk.openadsdk.core.ch.g;
import com.bytedance.sdk.openadsdk.core.ch.tl;
import com.bytedance.sdk.openadsdk.core.ch.xt;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends g implements xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f28008j;
    private AtomicBoolean xt = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.ch.g
    public void j(int i6, tl tlVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.g
    public JSONObject xt(Context context) {
        return null;
    }

    public static j cw() {
        if (f28008j == null) {
            synchronized (j.class) {
                try {
                    if (f28008j == null) {
                        f28008j = new j();
                    }
                } finally {
                }
            }
        }
        return f28008j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public String j() {
        return "network";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.g
    public boolean xt() {
        return true;
    }

    private j() {
    }

    public static String r() {
        String str;
        int i6 = Calendar.getInstance().get(11);
        if (ws.r(v.getContext())) {
            str = IAdInterListener.AdReqParam.WIDTH;
        } else {
            str = "c";
        }
        return "q_" + i6 + str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public String j(String str) {
        return cw.xt(j()).xt(r(), "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public void j(String str, String str2) {
        cw.xt(j()).j(str, str2);
    }
}
