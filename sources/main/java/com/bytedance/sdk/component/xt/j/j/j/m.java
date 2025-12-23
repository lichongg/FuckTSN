package com.bytedance.sdk.component.xt.j.j.j;

import android.text.TextUtils;
import com.bytedance.sdk.component.cw.xt.a;
import com.bytedance.sdk.component.cw.xt.f;
import com.bytedance.sdk.component.cw.xt.r;
import com.bytedance.sdk.component.cw.xt.s;
import com.bytedance.sdk.component.cw.xt.tj;
import com.bytedance.sdk.component.cw.xt.v;
import com.bytedance.sdk.component.xt.j.az;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends vl {
    v jy;
    com.bytedance.sdk.component.xt.j.r ws;

    private boolean cw(az azVar) {
        return (azVar == null || azVar.f27267m != az.j.STRING_TYPE || TextUtils.isEmpty(azVar.f27268r)) ? false : true;
    }

    private boolean xt(az azVar) {
        byte[] bArr;
        return azVar != null && azVar.f27267m == az.j.BYTE_ARRAY_TYPE && (bArr = azVar.up) != null && bArr.length > 0;
    }

    @Override // com.bytedance.sdk.component.xt.j.vl
    public com.bytedance.sdk.component.xt.j.r j() {
        return this.ws;
    }

    @Override // com.bytedance.sdk.component.xt.j.vl
    public com.bytedance.sdk.component.xt.j.xt j(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        s.j jVar = new s.j();
        jVar.j(wsVar.j());
        if (wsVar.xt() != null) {
            jVar.j(wsVar.xt().j());
        }
        if (wsVar.m() != null) {
            if (cw(wsVar.m())) {
                jVar.j(wsVar.cw(), a.j(tj.j(wsVar.m().cw.toString()), wsVar.m().f27268r));
            } else if (j(wsVar.m())) {
                jVar.j(wsVar.cw(), new f.j().j(f.up).j(wsVar.m().xt(), wsVar.m().j(), a.j(tj.j("multipart/form-data"), wsVar.m().up)).j());
            } else if (xt(wsVar.m())) {
                jVar.j(wsVar.cw(), a.j(tj.j(wsVar.m().cw.toString()), wsVar.m().up));
            }
        }
        if (wsVar.up() != null && wsVar.up().f27271j) {
            jVar.j(new r.j().j().cw());
        }
        if (wsVar.r() != null && wsVar.r().size() > 0) {
            for (Map.Entry<String, List<String>> entry : wsVar.r().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    jVar.j(entry.getKey(), it.next());
                }
            }
        }
        return new r(this.jy.j(jVar.j()));
    }

    public m(v.j jVar) {
        super(jVar);
        v j6 = jVar.j();
        this.jy = j6;
        this.ws = new ae(j6);
    }

    private boolean j(az azVar) {
        byte[] bArr;
        return azVar != null && azVar.f27267m == az.j.FILE_TYPE && (bArr = azVar.up) != null && bArr.length > 0;
    }
}
