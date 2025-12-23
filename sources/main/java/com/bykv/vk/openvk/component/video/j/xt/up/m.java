package com.bykv.vk.openvk.component.video.j.xt.up;

import com.bykv.vk.openvk.component.video.j.xt.g;
import com.bytedance.sdk.component.xt.j.av;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends j {
    private av cw;

    @Override // com.bykv.vk.openvk.component.video.j.xt.up.j
    public int j() {
        return this.cw.cw();
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.up.j
    public List<g.xt> cw() {
        return this.f23107j;
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.up.j
    public String j(String str, String str2) {
        return j(str) != null ? j(str).xt : str2;
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.up.j
    public String m() {
        return j(this.cw.cw());
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.up.j
    public InputStream r() {
        return this.cw.m().cw();
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.up.j
    public String up() {
        av avVar = this.cw;
        return (avVar == null || avVar.tl() == null) ? ApplicationProtocolNames.HTTP_1_1 : this.cw.tl().toString();
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.up.j
    public boolean xt() {
        return this.cw.cw() >= 200 && this.cw.cw() < 300;
    }

    public m(av avVar, up upVar) {
        com.bytedance.sdk.component.xt.j.m ae;
        this.cw = avVar;
        this.f23107j = new ArrayList();
        if (avVar != null && (ae = avVar.ae()) != null) {
            for (int i6 = 0; i6 < ae.j(); i6++) {
                this.f23107j.add(new g.xt(ae.j(i6), ae.xt(i6)));
            }
        }
        this.xt = upVar;
    }
}
