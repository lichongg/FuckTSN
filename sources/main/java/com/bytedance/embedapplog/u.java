package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.embedapplog.oq;
import com.bytedance.embedapplog.tk;
import com.bytedance.embedapplog.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class u extends uq<vl> {

    /* renamed from: j, reason: collision with root package name */
    private final Context f24069j;

    u(Context context) {
        super("com.coolpad.deviceidsupport");
        this.f24069j = context;
    }

    @Override // com.bytedance.embedapplog.uq
    protected Intent cw(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.bytedance.embedapplog.uq, com.bytedance.embedapplog.tk
    public /* bridge */ /* synthetic */ boolean j(Context context) {
        return super.j(context);
    }

    @Override // com.bytedance.embedapplog.uq
    protected oq.xt<vl, String> j() {
        return new oq.xt<vl, String>() { // from class: com.bytedance.embedapplog.u.1
            @Override // com.bytedance.embedapplog.oq.xt
            public String j(vl vlVar) {
                if (vlVar == null) {
                    return null;
                }
                return vlVar.xt(u.this.f24069j.getPackageName());
            }

            @Override // com.bytedance.embedapplog.oq.xt
            /* renamed from: xt, reason: merged with bridge method [inline-methods] */
            public vl j(IBinder iBinder) {
                return vl.j.j(iBinder);
            }
        };
    }

    @Override // com.bytedance.embedapplog.uq, com.bytedance.embedapplog.tk
    public tk.j xt(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                tk.j jVar = new tk.j();
                jVar.xt = string;
                return jVar;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
        return super.xt(context);
    }
}
