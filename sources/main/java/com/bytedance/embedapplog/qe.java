package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.oq;
import com.bytedance.embedapplog.t;
import com.bytedance.embedapplog.tk;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qe extends uq<t> {

    /* renamed from: j, reason: collision with root package name */
    final oy f24036j;
    final yl xt;

    @Override // com.bytedance.embedapplog.uq, com.bytedance.embedapplog.tk
    public /* bridge */ /* synthetic */ boolean j(Context context) {
        return super.j(context);
    }

    qe() {
        super("com.hihonor.id");
        this.f24036j = new oy();
        this.xt = new yl();
    }

    @Override // com.bytedance.embedapplog.uq
    protected Intent cw(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.bytedance.embedapplog.uq
    protected oq.xt<t, String> j() {
        return new oq.xt<t, String>() { // from class: com.bytedance.embedapplog.qe.1
            @Override // com.bytedance.embedapplog.oq.xt
            public String j(t tVar) {
                if (tVar == null) {
                    com.bytedance.sdk.component.utils.vl.r("honor# ", "service is null");
                    return null;
                }
                tVar.j(qe.this.f24036j);
                tVar.xt(qe.this.xt);
                return "";
            }

            @Override // com.bytedance.embedapplog.oq.xt
            /* renamed from: xt, reason: merged with bridge method [inline-methods] */
            public t j(IBinder iBinder) {
                return t.j.j(iBinder);
            }
        };
    }

    @Override // com.bytedance.embedapplog.uq, com.bytedance.embedapplog.tk
    public tk.j xt(Context context) {
        new oq(context, cw(context), j()).j();
        tk.j jVar = new tk.j();
        jVar.xt = this.f24036j.xt();
        jVar.cw = this.xt.xt();
        return jVar;
    }
}
