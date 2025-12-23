package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.util.IllegalReferenceCountException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class MqttPublishMessage extends MqttMessage implements ByteBufHolder {
    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return content().release();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MqttPublishMessage copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MqttPublishMessage duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public ByteBuf payload() {
        return content();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return content().release(i6);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MqttPublishMessage replace(ByteBuf byteBuf) {
        return new MqttPublishMessage(fixedHeader(), variableHeader(), byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MqttPublishMessage retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttPublishVariableHeader variableHeader() {
        return (MqttPublishVariableHeader) super.variableHeader();
    }

    public MqttPublishMessage(MqttFixedHeader mqttFixedHeader, MqttPublishVariableHeader mqttPublishVariableHeader, ByteBuf byteBuf) {
        super(mqttFixedHeader, mqttPublishVariableHeader, byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        ByteBuf byteBuf = (ByteBuf) super.payload();
        if (byteBuf.refCnt() > 0) {
            return byteBuf;
        }
        throw new IllegalReferenceCountException(byteBuf.refCnt());
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return content().refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public MqttPublishMessage retain() {
        content().retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public MqttPublishMessage touch() {
        content().touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public MqttPublishMessage retain(int i6) {
        content().retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public MqttPublishMessage touch(Object obj) {
        content().touch(obj);
        return this;
    }
}
