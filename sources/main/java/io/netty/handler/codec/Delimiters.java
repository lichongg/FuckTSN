package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Delimiters {
    public static ByteBuf[] lineDelimiter() {
        return new ByteBuf[]{Unpooled.wrappedBuffer(new byte[]{13, 10}), Unpooled.wrappedBuffer(new byte[]{10})};
    }

    public static ByteBuf[] nulDelimiter() {
        return new ByteBuf[]{Unpooled.wrappedBuffer(new byte[]{0})};
    }

    private Delimiters() {
    }
}
