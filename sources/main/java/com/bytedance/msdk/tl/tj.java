package com.bytedance.msdk.tl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tj extends HashMap<String, Object> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @Nullable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        if (MediationConstant.KEY_GM_USB.equals(str)) {
            return !com.bytedance.msdk.core.xt.xt().uf() ? super.put(str, "接口获取无权限，请联系商务开通") : super.put(str, obj);
        }
        if (MediationConstant.KEY_USE_POLICY.equals(str) && com.bytedance.msdk.core.xt.xt().ed() && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (com.bytedance.msdk.core.j.qv().r().containsKey(next)) {
                    Object opt = jSONObject.opt(next);
                    if (opt != null && !j(String.valueOf(opt))) {
                        com.bytedance.sdk.component.utils.vl.r(MediationConstant.TAG, "adLoad参数中key为 " + next + " 字段的值，" + opt + " 存在不合法输入");
                    }
                } else {
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "KEY_USE_POLICY的adLoad参数中存在不合法key：" + next + "，该key将被移除，如需要自定义key 请通过 KEY_USE_POLICY 中的 KEY_USE_POLICY_OBJ_CUSTOM 实现");
                }
            }
        }
        return super.put(str, obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @Nullable
    public Object get(@Nullable Object obj) {
        if (MediationConstant.KEY_GM_USB.equals(obj)) {
            com.bytedance.msdk.core.j.qv().j(true);
            if (!com.bytedance.msdk.core.xt.xt().uf()) {
                return "接口获取无权限，请联系商务开通";
            }
        } else if (MediationConstant.KEY_GM_POLICY.equals(obj)) {
            if (!com.bytedance.msdk.core.xt.xt().ed()) {
                return "接口获取无权限，请联系商务开通";
            }
            Object obj2 = get(MediationConstant.KEY_GM_PRIME_RIT);
            if (obj2 instanceof String) {
                String str = (String) obj2;
                com.bytedance.msdk.core.xt.xt gx = com.bytedance.msdk.core.xt.xt().gx();
                if (gx != null) {
                    return gx.j(str, this);
                }
            }
        }
        return super.get(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(@NonNull Map<? extends String, ?> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.HashMap, java.util.Map
    @Nullable
    public Object getOrDefault(@Nullable Object obj, @Nullable Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }
}
