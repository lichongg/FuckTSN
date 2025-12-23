package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.EmptyArrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttEncoder extends MessageToMessageEncoder<MqttMessage> {
    public static final MqttEncoder INSTANCE = new MqttEncoder();

    private static ByteBuf encodeConnAckMessage(ByteBufAllocator byteBufAllocator, MqttConnAckMessage mqttConnAckMessage) {
        ByteBuf buffer = byteBufAllocator.buffer(4);
        buffer.writeByte(getFixedHeaderByte1(mqttConnAckMessage.fixedHeader()));
        buffer.writeByte(2);
        buffer.writeByte(mqttConnAckMessage.variableHeader().isSessionPresent() ? 1 : 0);
        buffer.writeByte(mqttConnAckMessage.variableHeader().connectReturnCode().byteValue());
        return buffer;
    }

    private static int getVariableLengthInt(int i6) {
        int i7 = 0;
        do {
            i6 /= 128;
            i7++;
        } while (i6 > 0);
        return i7;
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, MqttMessage mqttMessage, List list) throws Exception {
        encode2(channelHandlerContext, mqttMessage, (List<Object>) list);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.mqtt.MqttEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType;

        static {
            int[] iArr = new int[MqttMessageType.values().length];
            $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType = iArr;
            try {
                iArr[MqttMessageType.CONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.CONNACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBLISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBSCRIBE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBSCRIBE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBACK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBACK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBREC.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBREL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBCOMP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PINGREQ.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PINGRESP.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.DISCONNECT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    static ByteBuf doEncode(ByteBufAllocator byteBufAllocator, MqttMessage mqttMessage) {
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttMessage.fixedHeader().messageType().ordinal()]) {
            case 1:
                return encodeConnectMessage(byteBufAllocator, (MqttConnectMessage) mqttMessage);
            case 2:
                return encodeConnAckMessage(byteBufAllocator, (MqttConnAckMessage) mqttMessage);
            case 3:
                return encodePublishMessage(byteBufAllocator, (MqttPublishMessage) mqttMessage);
            case 4:
                return encodeSubscribeMessage(byteBufAllocator, (MqttSubscribeMessage) mqttMessage);
            case 5:
                return encodeUnsubscribeMessage(byteBufAllocator, (MqttUnsubscribeMessage) mqttMessage);
            case 6:
                return encodeSubAckMessage(byteBufAllocator, (MqttSubAckMessage) mqttMessage);
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return encodeMessageWithOnlySingleByteFixedHeaderAndMessageId(byteBufAllocator, mqttMessage);
            case 12:
            case 13:
            case 14:
                return encodeMessageWithOnlySingleByteFixedHeader(byteBufAllocator, mqttMessage);
            default:
                throw new IllegalArgumentException("Unknown message type: " + mqttMessage.fixedHeader().messageType().value());
        }
    }

    private static byte[] encodeStringUtf8(String str) {
        return str.getBytes(CharsetUtil.UTF_8);
    }

    private static void writeVariableLengthInt(ByteBuf byteBuf, int i6) {
        do {
            int i7 = i6 % 128;
            i6 /= 128;
            if (i6 > 0) {
                i7 |= 128;
            }
            byteBuf.writeByte(i7);
        } while (i6 > 0);
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, MqttMessage mqttMessage, List<Object> list) throws Exception {
        list.add(doEncode(channelHandlerContext.alloc(), mqttMessage));
    }

    private MqttEncoder() {
    }

    private static ByteBuf encodeConnectMessage(ByteBufAllocator byteBufAllocator, MqttConnectMessage mqttConnectMessage) {
        byte[] bArr;
        byte[] bArr2;
        MqttFixedHeader fixedHeader = mqttConnectMessage.fixedHeader();
        MqttConnectVariableHeader variableHeader = mqttConnectMessage.variableHeader();
        MqttConnectPayload payload = mqttConnectMessage.payload();
        MqttVersion fromProtocolNameAndLevel = MqttVersion.fromProtocolNameAndLevel(variableHeader.name(), (byte) variableHeader.version());
        if (!variableHeader.hasUserName() && variableHeader.hasPassword()) {
            throw new DecoderException("Without a username, the password MUST be not set");
        }
        String clientIdentifier = payload.clientIdentifier();
        if (MqttCodecUtil.isValidClientId(fromProtocolNameAndLevel, clientIdentifier)) {
            byte[] encodeStringUtf8 = encodeStringUtf8(clientIdentifier);
            int length = encodeStringUtf8.length + 2;
            String willTopic = payload.willTopic();
            if (willTopic != null) {
                bArr = encodeStringUtf8(willTopic);
            } else {
                bArr = EmptyArrays.EMPTY_BYTES;
            }
            byte[] willMessageInBytes = payload.willMessageInBytes();
            if (willMessageInBytes == null) {
                willMessageInBytes = EmptyArrays.EMPTY_BYTES;
            }
            if (variableHeader.isWillFlag()) {
                length = length + bArr.length + 2 + willMessageInBytes.length + 2;
            }
            String userName = payload.userName();
            if (userName != null) {
                bArr2 = encodeStringUtf8(userName);
            } else {
                bArr2 = EmptyArrays.EMPTY_BYTES;
            }
            if (variableHeader.hasUserName()) {
                length += bArr2.length + 2;
            }
            byte[] passwordInBytes = payload.passwordInBytes();
            if (passwordInBytes == null) {
                passwordInBytes = EmptyArrays.EMPTY_BYTES;
            }
            if (variableHeader.hasPassword()) {
                length += passwordInBytes.length + 2;
            }
            byte[] protocolNameBytes = fromProtocolNameAndLevel.protocolNameBytes();
            int length2 = protocolNameBytes.length + 6 + length;
            ByteBuf buffer = byteBufAllocator.buffer(getVariableLengthInt(length2) + 1 + length2);
            buffer.writeByte(getFixedHeaderByte1(fixedHeader));
            writeVariableLengthInt(buffer, length2);
            buffer.writeShort(protocolNameBytes.length);
            buffer.writeBytes(protocolNameBytes);
            buffer.writeByte(variableHeader.version());
            buffer.writeByte(getConnVariableHeaderFlag(variableHeader));
            buffer.writeShort(variableHeader.keepAliveTimeSeconds());
            buffer.writeShort(encodeStringUtf8.length);
            buffer.writeBytes(encodeStringUtf8, 0, encodeStringUtf8.length);
            if (variableHeader.isWillFlag()) {
                buffer.writeShort(bArr.length);
                buffer.writeBytes(bArr, 0, bArr.length);
                buffer.writeShort(willMessageInBytes.length);
                buffer.writeBytes(willMessageInBytes, 0, willMessageInBytes.length);
            }
            if (variableHeader.hasUserName()) {
                buffer.writeShort(bArr2.length);
                buffer.writeBytes(bArr2, 0, bArr2.length);
            }
            if (variableHeader.hasPassword()) {
                buffer.writeShort(passwordInBytes.length);
                buffer.writeBytes(passwordInBytes, 0, passwordInBytes.length);
            }
            return buffer;
        }
        throw new MqttIdentifierRejectedException("invalid clientIdentifier: " + clientIdentifier);
    }

    private static ByteBuf encodeMessageWithOnlySingleByteFixedHeader(ByteBufAllocator byteBufAllocator, MqttMessage mqttMessage) {
        MqttFixedHeader fixedHeader = mqttMessage.fixedHeader();
        ByteBuf buffer = byteBufAllocator.buffer(2);
        buffer.writeByte(getFixedHeaderByte1(fixedHeader));
        buffer.writeByte(0);
        return buffer;
    }

    private static ByteBuf encodeMessageWithOnlySingleByteFixedHeaderAndMessageId(ByteBufAllocator byteBufAllocator, MqttMessage mqttMessage) {
        MqttFixedHeader fixedHeader = mqttMessage.fixedHeader();
        int messageId = ((MqttMessageIdVariableHeader) mqttMessage.variableHeader()).messageId();
        ByteBuf buffer = byteBufAllocator.buffer(getVariableLengthInt(2) + 3);
        buffer.writeByte(getFixedHeaderByte1(fixedHeader));
        writeVariableLengthInt(buffer, 2);
        buffer.writeShort(messageId);
        return buffer;
    }

    private static ByteBuf encodePublishMessage(ByteBufAllocator byteBufAllocator, MqttPublishMessage mqttPublishMessage) {
        MqttFixedHeader fixedHeader = mqttPublishMessage.fixedHeader();
        MqttPublishVariableHeader variableHeader = mqttPublishMessage.variableHeader();
        ByteBuf duplicate = mqttPublishMessage.payload().duplicate();
        byte[] encodeStringUtf8 = encodeStringUtf8(variableHeader.topicName());
        int i6 = 2;
        int length = encodeStringUtf8.length + 2;
        if (fixedHeader.qosLevel().value() <= 0) {
            i6 = 0;
        }
        int readableBytes = length + i6 + duplicate.readableBytes();
        ByteBuf buffer = byteBufAllocator.buffer(getVariableLengthInt(readableBytes) + 1 + readableBytes);
        buffer.writeByte(getFixedHeaderByte1(fixedHeader));
        writeVariableLengthInt(buffer, readableBytes);
        buffer.writeShort(encodeStringUtf8.length);
        buffer.writeBytes(encodeStringUtf8);
        if (fixedHeader.qosLevel().value() > 0) {
            buffer.writeShort(variableHeader.messageId());
        }
        buffer.writeBytes(duplicate);
        return buffer;
    }

    private static ByteBuf encodeSubAckMessage(ByteBufAllocator byteBufAllocator, MqttSubAckMessage mqttSubAckMessage) {
        int size = mqttSubAckMessage.payload().grantedQoSLevels().size() + 2;
        ByteBuf buffer = byteBufAllocator.buffer(getVariableLengthInt(size) + 1 + size);
        buffer.writeByte(getFixedHeaderByte1(mqttSubAckMessage.fixedHeader()));
        writeVariableLengthInt(buffer, size);
        buffer.writeShort(mqttSubAckMessage.variableHeader().messageId());
        Iterator<Integer> it = mqttSubAckMessage.payload().grantedQoSLevels().iterator();
        while (it.hasNext()) {
            buffer.writeByte(it.next().intValue());
        }
        return buffer;
    }

    private static ByteBuf encodeSubscribeMessage(ByteBufAllocator byteBufAllocator, MqttSubscribeMessage mqttSubscribeMessage) {
        MqttFixedHeader fixedHeader = mqttSubscribeMessage.fixedHeader();
        MqttMessageIdVariableHeader variableHeader = mqttSubscribeMessage.variableHeader();
        MqttSubscribePayload payload = mqttSubscribeMessage.payload();
        Iterator<MqttTopicSubscription> it = payload.topicSubscriptions().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 = i6 + encodeStringUtf8(it.next().topicName()).length + 2 + 1;
        }
        int i7 = 2 + i6;
        ByteBuf buffer = byteBufAllocator.buffer(getVariableLengthInt(i7) + 1 + i7);
        buffer.writeByte(getFixedHeaderByte1(fixedHeader));
        writeVariableLengthInt(buffer, i7);
        buffer.writeShort(variableHeader.messageId());
        for (MqttTopicSubscription mqttTopicSubscription : payload.topicSubscriptions()) {
            byte[] encodeStringUtf8 = encodeStringUtf8(mqttTopicSubscription.topicName());
            buffer.writeShort(encodeStringUtf8.length);
            buffer.writeBytes(encodeStringUtf8, 0, encodeStringUtf8.length);
            buffer.writeByte(mqttTopicSubscription.qualityOfService().value());
        }
        return buffer;
    }

    private static ByteBuf encodeUnsubscribeMessage(ByteBufAllocator byteBufAllocator, MqttUnsubscribeMessage mqttUnsubscribeMessage) {
        MqttFixedHeader fixedHeader = mqttUnsubscribeMessage.fixedHeader();
        MqttMessageIdVariableHeader variableHeader = mqttUnsubscribeMessage.variableHeader();
        MqttUnsubscribePayload payload = mqttUnsubscribeMessage.payload();
        Iterator<String> it = payload.topics().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += encodeStringUtf8(it.next()).length + 2;
        }
        int i7 = 2 + i6;
        ByteBuf buffer = byteBufAllocator.buffer(getVariableLengthInt(i7) + 1 + i7);
        buffer.writeByte(getFixedHeaderByte1(fixedHeader));
        writeVariableLengthInt(buffer, i7);
        buffer.writeShort(variableHeader.messageId());
        Iterator<String> it2 = payload.topics().iterator();
        while (it2.hasNext()) {
            byte[] encodeStringUtf8 = encodeStringUtf8(it2.next());
            buffer.writeShort(encodeStringUtf8.length);
            buffer.writeBytes(encodeStringUtf8, 0, encodeStringUtf8.length);
        }
        return buffer;
    }

    private static int getConnVariableHeaderFlag(MqttConnectVariableHeader mqttConnectVariableHeader) {
        int i6;
        if (mqttConnectVariableHeader.hasUserName()) {
            i6 = 128;
        } else {
            i6 = 0;
        }
        if (mqttConnectVariableHeader.hasPassword()) {
            i6 |= 64;
        }
        if (mqttConnectVariableHeader.isWillRetain()) {
            i6 |= 32;
        }
        int willQos = i6 | ((mqttConnectVariableHeader.willQos() & 3) << 3);
        if (mqttConnectVariableHeader.isWillFlag()) {
            willQos |= 4;
        }
        if (mqttConnectVariableHeader.isCleanSession()) {
            return willQos | 2;
        }
        return willQos;
    }

    private static int getFixedHeaderByte1(MqttFixedHeader mqttFixedHeader) {
        int value = mqttFixedHeader.messageType().value() << 4;
        if (mqttFixedHeader.isDup()) {
            value |= 8;
        }
        int value2 = value | (mqttFixedHeader.qosLevel().value() << 1);
        if (mqttFixedHeader.isRetain()) {
            return value2 | 1;
        }
        return value2;
    }
}
