package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.az;
import com.bytedance.embedapplog.oq;

/* loaded from: D:\Downloads\app\classes3.dex */
final class ed extends uq<az> {
    ed() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.embedapplog.uq
    protected Intent cw(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }

    @Override // com.bytedance.embedapplog.uq
    protected oq.xt<az, String> j() {
        return new oq.xt<az, String>() { // from class: com.bytedance.embedapplog.ed.1
            @Override // com.bytedance.embedapplog.oq.xt
            public String j(az azVar) {
                if (azVar == null) {
                    return null;
                }
                return azVar.cw();
            }

            @Override // com.bytedance.embedapplog.oq.xt
            /* renamed from: xt, reason: merged with bridge method [inline-methods] */
            public az j(IBinder iBinder) {
                return az.j.j(iBinder);
            }
        };
    }
}
