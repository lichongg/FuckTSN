package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.embedapplog.oq;
import com.bytedance.embedapplog.tk;

/* loaded from: D:\Downloads\app\classes3.dex */
abstract class uq<SERVICE> implements tk {

    /* renamed from: j, reason: collision with root package name */
    private final String f24073j;
    private wf<Boolean> xt = new wf<Boolean>() { // from class: com.bytedance.embedapplog.uq.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.wf
        /* renamed from: cw, reason: merged with bridge method [inline-methods] */
        public Boolean j(Object... objArr) {
            return Boolean.valueOf(qo.j((Context) objArr[0], uq.this.f24073j));
        }
    };

    protected abstract Intent cw(Context context);

    protected abstract oq.xt<SERVICE, String> j();

    @Override // com.bytedance.embedapplog.tk
    public boolean j(Context context) {
        if (context == null) {
            return false;
        }
        return this.xt.xt(context).booleanValue();
    }

    uq(String str) {
        this.f24073j = str;
    }

    private tk.j j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        tk.j jVar = new tk.j();
        jVar.xt = str;
        return jVar;
    }

    @Override // com.bytedance.embedapplog.tk
    public tk.j xt(Context context) {
        return j((String) new oq(context, cw(context), j()).j());
    }
}
