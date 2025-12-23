package com.bytedance.sdk.component.g.cw;

import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.g;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements g {

    /* renamed from: j, reason: collision with root package name */
    private int f26430j;

    public void j(int i6) {
        this.f26430j = i6;
    }

    @Override // com.bytedance.sdk.component.xt.j.g
    public av j(g.j jVar) throws IOException {
        IOException iOException;
        ws j6 = jVar.j();
        if (ae.j().j(this.f26430j).xt() != null) {
            ae.j().j(this.f26430j).xt().up();
        }
        String aeVar = j6.xt().toString();
        String j7 = ae.j().j(this.f26430j).j(aeVar);
        if (!aeVar.equals(j7)) {
            j6 = j6.ae().j(j7).xt();
        }
        av avVar = null;
        try {
            iOException = null;
            avVar = jVar.j(j6);
        } catch (Exception e6) {
            iOException = new IOException(e6.getMessage());
            ae.j().j(this.f26430j).j(j6, e6);
        }
        ae.j().j(this.f26430j).j(j6, avVar);
        if (iOException == null) {
            return avVar == null ? jVar.j(j6) : avVar;
        }
        throw iOException;
    }
}
