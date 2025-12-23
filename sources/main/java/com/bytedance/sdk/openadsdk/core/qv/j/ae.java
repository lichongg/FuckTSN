package com.bytedance.sdk.openadsdk.core.qv.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {
    private static void callback(com.bytedance.sdk.component.g.xt xtVar, ITTHttpCallback iTTHttpCallback) {
        if (xtVar != null && xtVar.tl()) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onResponse(xtVar.r());
            }
        } else {
            boolean isEmpty = TextUtils.isEmpty((xtVar == null || xtVar.xt() == null) ? null : xtVar.xt());
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onError(new Exception(!isEmpty ? xtVar.xt() : xtVar != null ? String.valueOf(xtVar.j()) : ""));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.sdk.component.g.xt.cw] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.g.xt.r] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.sdk.component.g.xt.up] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static void execute(int i6, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        ?? cw;
        if (i6 == 0) {
            cw = com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    cw.j(entry.getKey(), entry.getValue().toString());
                }
            }
        } else if (i6 != 1) {
            cw = 0;
        } else {
            cw = com.bytedance.sdk.openadsdk.core.v.up.j().xt().xt();
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue().toString());
            }
            cw.j(hashMap);
        }
        if (cw != 0) {
            cw.j(str);
            callback(cw.j(), iTTHttpCallback);
        }
    }

    public static void postBody(String str, byte[] bArr, String str2, int i6, ITTHttpCallback iTTHttpCallback) {
        if (bArr == null) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onError(new Exception("request data is null"));
            }
        } else {
            com.bytedance.sdk.component.g.xt.up xt = com.bytedance.sdk.openadsdk.core.v.up.j().xt().xt();
            xt.j(str);
            xt.j(str2, bArr);
            callback(xt.j(), iTTHttpCallback);
        }
    }
}
