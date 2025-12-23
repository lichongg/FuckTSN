package com.beizi.fusion.sm.b.a;

import io.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class d implements com.beizi.fusion.sm.b.c {
    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        return false;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.a(new com.beizi.fusion.sm.b.d(RtspHeaders.Names.UNSUPPORTED));
    }

    d() {
    }
}
