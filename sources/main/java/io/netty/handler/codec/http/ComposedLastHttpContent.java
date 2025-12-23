package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class ComposedLastHttpContent implements LastHttpContent {
    private DecoderResult result;
    private final HttpHeaders trailingHeaders;

    ComposedLastHttpContent(HttpHeaders httpHeaders) {
        this.trailingHeaders = httpHeaders;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return 1;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return false;
    }

    @Override // io.netty.util.ReferenceCounted
    public LastHttpContent retain() {
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public LastHttpContent touch() {
        return this;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return Unpooled.EMPTY_BUFFER;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.result;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return false;
    }

    @Override // io.netty.util.ReferenceCounted
    public LastHttpContent retain(int i6) {
        return this;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        this.result = decoderResult;
    }

    @Override // io.netty.util.ReferenceCounted
    public LastHttpContent touch(Object obj) {
        return this;
    }

    @Override // io.netty.handler.codec.http.LastHttpContent
    public HttpHeaders trailingHeaders() {
        return this.trailingHeaders;
    }

    ComposedLastHttpContent(HttpHeaders httpHeaders, DecoderResult decoderResult) {
        this(httpHeaders);
        this.result = decoderResult;
    }

    @Override // io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public LastHttpContent copy() {
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.trailingHeaders().set(trailingHeaders());
        return defaultLastHttpContent;
    }

    @Override // io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public LastHttpContent duplicate() {
        return copy();
    }

    @Override // io.netty.handler.codec.http.HttpObject
    public DecoderResult getDecoderResult() {
        return decoderResult();
    }

    @Override // io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public LastHttpContent replace(ByteBuf byteBuf) {
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(byteBuf);
        defaultLastHttpContent.trailingHeaders().setAll(trailingHeaders());
        return defaultLastHttpContent;
    }

    @Override // io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public LastHttpContent retainedDuplicate() {
        return copy();
    }
}
