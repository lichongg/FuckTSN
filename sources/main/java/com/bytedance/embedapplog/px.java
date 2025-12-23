package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.oq;
import com.bytedance.embedapplog.ws;

/* loaded from: D:\Downloads\app\classes3.dex */
final class px extends uq<ws> {
    px() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.uq
    protected Intent cw(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    @Override // com.bytedance.embedapplog.uq
    protected oq.xt<ws, String> j() {
        return new oq.xt<ws, String>() { // from class: com.bytedance.embedapplog.px.1
            @Override // com.bytedance.embedapplog.oq.xt
            public String j(ws wsVar) {
                if (wsVar == null) {
                    return null;
                }
                return wsVar.j();
            }

            @Override // com.bytedance.embedapplog.oq.xt
            /* renamed from: xt, reason: merged with bridge method [inline-methods] */
            public ws j(IBinder iBinder) {
                return ws.j.j(iBinder);
            }
        };
    }
}
