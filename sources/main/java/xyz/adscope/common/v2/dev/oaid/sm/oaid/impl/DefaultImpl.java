package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class DefaultImpl implements IOAID {
    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public boolean supported() {
        return false;
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (iGetter == null) {
            return;
        }
        iGetter.onOAIDGetError(new OAIDException(RtspHeaders.Names.UNSUPPORTED));
    }

    DefaultImpl() {
    }
}
