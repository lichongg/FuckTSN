package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.ft;
import com.amap.api.maps.MapsInitializer;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class g2 extends Cif {
    protected boolean isPostFlag = true;

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getParams() {
        return null;
    }

    protected z6 makeHttpRequestNeedHeader() throws fk {
        if (d.f5883f != null && ft.a(d.f5883f, b3.s()).f6803a != ft.c.SuccessCode) {
            return null;
        }
        setHttpProtocol(MapsInitializer.getProtocol() == 1 ? Cif.c.HTTP : Cif.c.HTTPS);
        y6.p();
        return this.isPostFlag ? r6.d(this) : y6.r(this);
    }

    public byte[] makeHttpRequestWithInterrupted() throws fk {
        setDegradeAbility(Cif.a.INTERRUPT_IO);
        return makeHttpRequest();
    }

    protected byte[] makeHttpRequest() throws fk {
        z6 makeHttpRequestNeedHeader = makeHttpRequestNeedHeader();
        if (makeHttpRequestNeedHeader != null) {
            return makeHttpRequestNeedHeader.f7800a;
        }
        return null;
    }
}
