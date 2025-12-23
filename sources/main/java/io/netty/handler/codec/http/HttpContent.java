package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface HttpContent extends HttpObject, ByteBufHolder {
    HttpContent copy();

    HttpContent duplicate();

    HttpContent replace(ByteBuf byteBuf);

    HttpContent retain();

    HttpContent retain(int i6);

    HttpContent retainedDuplicate();

    HttpContent touch();

    HttpContent touch(Object obj);
}
