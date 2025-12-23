package com.bytedance.sdk.openadsdk.core.v;

import android.content.Context;
import android.location.Address;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.rn.h;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements com.bytedance.sdk.component.g.cw.xt {
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    String f30956j = "sp_multi_ttadnet_config";
    com.bytedance.sdk.component.r.j.xt xt = h.j("sp_multi_ttadnet_config");

    @Override // com.bytedance.sdk.component.g.cw.xt
    public Address j(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public String cw() {
        return FaceEnvironment.OS;
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public Context getContext() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public int j() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public String[] m() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public int r() {
        return com.bytedance.sdk.openadsdk.core.h.xt;
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public String xt() {
        return "openadsdk";
    }

    public r(Context context) {
        this.cw = context;
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public String j(Context context, String str, String str2) {
        return this.xt.xt(str, str2);
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public String up() {
        return kt.cw();
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public void j(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.xt.j(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.xt.j(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.xt.j(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.xt.j(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.xt.j(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
