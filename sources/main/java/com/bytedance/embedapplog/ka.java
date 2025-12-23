package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.i;
import com.bytedance.embedapplog.oq;
import com.bytedance.embedapplog.tk;

/* loaded from: D:\Downloads\app\classes3.dex */
final class ka extends uq<i> {
    @Override // com.bytedance.embedapplog.uq
    protected oq.xt<i, String> j() {
        return new oq.xt<i, String>() { // from class: com.bytedance.embedapplog.ka.1
            @Override // com.bytedance.embedapplog.oq.xt
            public String j(i iVar) {
                if (iVar == null) {
                    return null;
                }
                return iVar.j();
            }

            @Override // com.bytedance.embedapplog.oq.xt
            /* renamed from: xt, reason: merged with bridge method [inline-methods] */
            public i j(IBinder iBinder) {
                return i.j.j(iBinder);
            }
        };
    }

    ka() {
        super("com.mdid.msa");
    }

    private void j(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e6) {
            uc.j(e6);
        }
    }

    @Override // com.bytedance.embedapplog.uq
    protected Intent cw(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    @Override // com.bytedance.embedapplog.uq, com.bytedance.embedapplog.tk
    public tk.j xt(Context context) {
        j(context, context.getPackageName());
        return super.xt(context);
    }
}
