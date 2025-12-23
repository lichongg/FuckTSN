package com.bykv.vk.openvk.component.video.j.xt.up;

import android.text.TextUtils;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements xt {

    /* renamed from: j, reason: collision with root package name */
    private vl f23108j;

    @Override // com.bykv.vk.openvk.component.video.j.xt.up.xt
    public j j(up upVar) throws IOException {
        ws.j jVar = new ws.j();
        try {
            Map<String, String> map = upVar.up;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        jVar.xt(key, value);
                    }
                }
            }
            av j6 = this.f23108j.j(jVar.j(upVar.xt).j().xt()).j();
            com.bykv.vk.openvk.component.video.api.m.cw.j("NetworkSoureVolleyImpl", "response code = ", Integer.valueOf(j6.cw()));
            return new m(j6, upVar);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return null;
        }
    }

    public r() {
        this.f23108j = null;
        this.f23108j = com.bykv.vk.openvk.component.video.api.cw.cw();
    }
}
