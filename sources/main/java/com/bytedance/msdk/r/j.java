package com.bytedance.msdk.r;

import android.content.Context;
import android.location.Address;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.x;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements com.bytedance.sdk.component.g.cw.xt {
    private Context xt;

    /* renamed from: j, reason: collision with root package name */
    String f25198j = "sp_multi_ttmadnet_config";
    private final l cw = l.j("sp_multi_ttmadnet_config", getContext());

    @Override // com.bytedance.sdk.component.g.cw.xt
    public int j() {
        return 4741;
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public String cw() {
        return FaceEnvironment.OS;
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public Context getContext() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public Address j(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public String[] m() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public String xt() {
        return "msdk";
    }

    public j(Context context) {
        this.xt = context;
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public String j(Context context, String str, String str2) {
        return this.cw.xt(str, str2);
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public int r() {
        return com.bytedance.msdk.xt.xt.j();
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public String up() {
        return x.j();
    }

    @Override // com.bytedance.sdk.component.g.cw.xt
    public void j(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.cw.j(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.cw.j(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.cw.j(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.cw.j(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.cw.j(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
