package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.jy;
import com.bytedance.embedapplog.oq;

/* loaded from: D:\Downloads\app\classes3.dex */
final class om extends uq<jy> {
    om() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.uq
    protected Intent cw(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }

    @Override // com.bytedance.embedapplog.uq
    protected oq.xt<jy, String> j() {
        return new oq.xt<jy, String>() { // from class: com.bytedance.embedapplog.om.1
            @Override // com.bytedance.embedapplog.oq.xt
            public String j(jy jyVar) {
                return jyVar.j();
            }

            @Override // com.bytedance.embedapplog.oq.xt
            /* renamed from: xt, reason: merged with bridge method [inline-methods] */
            public jy j(IBinder iBinder) {
                return jy.j.j(iBinder);
            }
        };
    }
}
