package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttDecoder extends ReplayingDecoder<DecoderState> {
    private static final int DEFAULT_MAX_BYTES_IN_MESSAGE = 8092;
    private int bytesRemainingInVariablePart;
    private final int maxBytesInMessage;
    private MqttFixedHeader mqttFixedHeader;
    private Object variableHeader;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum DecoderState {
        READ_FIXED_HEADER,
        READ_VARIABLE_HEADER,
        READ_PAYLOAD,
        BAD_MESSAGE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Result<T> {
        private final int numberOfBytesConsumed;
        private final T value;

        Result(T t5, int i6) {
            this.value = t5;
            this.numberOfBytesConsumed = i6;
        }
    }

    public MqttDecoder() {
        this(DEFAULT_MAX_BYTES_IN_MESSAGE);
    }

    private static Result<Integer> decodeMsbLsb(ByteBuf byteBuf) {
        return decodeMsbLsb(byteBuf, 0, 65535);
    }

    private static Result<String> decodeString(ByteBuf byteBuf) {
        return decodeString(byteBuf, 0, Integer.MAX_VALUE);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.mqtt.MqttDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState;
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
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBSCRIBE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBSCRIBE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBACK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBREC.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBCOMP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBREL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBLISH.ordinal()] = 11;
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
            int[] iArr2 = new int[DecoderState.values().length];
            $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState = iArr2;
            try {
                iArr2[DecoderState.READ_FIXED_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState[DecoderState.READ_VARIABLE_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState[DecoderState.READ_PAYLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState[DecoderState.BAD_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public MqttDecoder(int i6) {
        super(DecoderState.READ_FIXED_HEADER);
        this.maxBytesInMessage = i6;
    }

    private static Result<Integer> decodeMsbLsb(ByteBuf byteBuf, int i6, int i7) {
        int readUnsignedByte = byteBuf.readUnsignedByte() | (byteBuf.readUnsignedByte() << 8);
        if (readUnsignedByte < i6 || readUnsignedByte > i7) {
            readUnsignedByte = -1;
        }
        return new Result<>(Integer.valueOf(readUnsignedByte), 2);
    }

    private static Result<?> decodePayload(ByteBuf byteBuf, MqttMessageType mqttMessageType, int i6, Object obj) {
        int i7 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttMessageType.ordinal()];
        return i7 != 1 ? i7 != 11 ? i7 != 3 ? i7 != 4 ? i7 != 5 ? new Result<>(null, 0) : decodeSubackPayload(byteBuf, i6) : decodeUnsubscribePayload(byteBuf, i6) : decodeSubscribePayload(byteBuf, i6) : decodePublishPayload(byteBuf, i6) : decodeConnectionPayload(byteBuf, (MqttConnectVariableHeader) obj);
    }

    private static Result<String> decodeString(ByteBuf byteBuf, int i6, int i7) {
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        int intValue = ((Integer) ((Result) decodeMsbLsb).value).intValue();
        int i8 = ((Result) decodeMsbLsb).numberOfBytesConsumed;
        if (intValue < i6 || intValue > i7) {
            byteBuf.skipBytes(intValue);
            return new Result<>(null, i8 + intValue);
        }
        String byteBuf2 = byteBuf.toString(byteBuf.readerIndex(), intValue, CharsetUtil.UTF_8);
        byteBuf.skipBytes(intValue);
        return new Result<>(byteBuf2, i8 + intValue);
    }

    private static Result<MqttSubAckPayload> decodeSubackPayload(ByteBuf byteBuf, int i6) {
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 < i6) {
            int readUnsignedByte = byteBuf.readUnsignedByte();
            if (readUnsignedByte != MqttQoS.FAILURE.value()) {
                readUnsignedByte &= 3;
            }
            i7++;
            arrayList.add(Integer.valueOf(readUnsignedByte));
        }
        return new Result<>(new MqttSubAckPayload(arrayList), i7);
    }

    private static Result<MqttSubscribePayload> decodeSubscribePayload(ByteBuf byteBuf, int i6) {
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 < i6) {
            Result<String> decodeString = decodeString(byteBuf);
            int i8 = i7 + ((Result) decodeString).numberOfBytesConsumed;
            i7 = i8 + 1;
            arrayList.add(new MqttTopicSubscription((String) ((Result) decodeString).value, MqttQoS.valueOf(byteBuf.readUnsignedByte() & 3)));
        }
        return new Result<>(new MqttSubscribePayload(arrayList), i7);
    }

    private static Result<MqttUnsubscribePayload> decodeUnsubscribePayload(ByteBuf byteBuf, int i6) {
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 < i6) {
            Result<String> decodeString = decodeString(byteBuf);
            i7 += ((Result) decodeString).numberOfBytesConsumed;
            arrayList.add(((Result) decodeString).value);
        }
        return new Result<>(new MqttUnsubscribePayload(arrayList), i7);
    }

    private static Result<?> decodeVariableHeader(ByteBuf byteBuf, MqttFixedHeader mqttFixedHeader) {
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttFixedHeader.messageType().ordinal()]) {
        }
        return new Result<>(null, 0);
    }

    private MqttMessage invalidMessage(Throwable th) {
        checkpoint(DecoderState.BAD_MESSAGE);
        return MqttMessageFactory.newInvalidMessage(this.mqttFixedHeader, this.variableHeader, th);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0070 A[Catch: Exception -> 0x008a, TryCatch #1 {Exception -> 0x008a, blocks: (B:15:0x0057, B:17:0x0070, B:19:0x008c, B:20:0x00b7), top: B:14:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c A[Catch: Exception -> 0x008a, TryCatch #1 {Exception -> 0x008a, blocks: (B:15:0x0057, B:17:0x0070, B:19:0x008c, B:20:0x00b7), top: B:14:0x0057 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, java.util.List<java.lang.Object> r5) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.mqtt.MqttDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    private static Result<byte[]> decodeByteArray(ByteBuf byteBuf) {
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        int intValue = ((Integer) ((Result) decodeMsbLsb).value).intValue();
        byte[] bArr = new byte[intValue];
        byteBuf.readBytes(bArr);
        return new Result<>(bArr, ((Result) decodeMsbLsb).numberOfBytesConsumed + intValue);
    }

    private static Result<MqttConnAckVariableHeader> decodeConnAckVariableHeader(ByteBuf byteBuf) {
        boolean z5 = true;
        if ((byteBuf.readUnsignedByte() & 1) != 1) {
            z5 = false;
        }
        return new Result<>(new MqttConnAckVariableHeader(MqttConnectReturnCode.valueOf(byteBuf.readByte()), z5), 2);
    }

    private static Result<MqttConnectPayload> decodeConnectionPayload(ByteBuf byteBuf, MqttConnectVariableHeader mqttConnectVariableHeader) {
        Result<String> result;
        Result<byte[]> result2;
        Result<String> result3;
        Result<byte[]> result4;
        String str;
        byte[] bArr;
        String str2;
        Result<String> decodeString = decodeString(byteBuf);
        String str3 = (String) ((Result) decodeString).value;
        if (MqttCodecUtil.isValidClientId(MqttVersion.fromProtocolNameAndLevel(mqttConnectVariableHeader.name(), (byte) mqttConnectVariableHeader.version()), str3)) {
            int i6 = ((Result) decodeString).numberOfBytesConsumed;
            byte[] bArr2 = null;
            if (mqttConnectVariableHeader.isWillFlag()) {
                result = decodeString(byteBuf, 0, 32767);
                int i7 = i6 + ((Result) result).numberOfBytesConsumed;
                result2 = decodeByteArray(byteBuf);
                i6 = i7 + ((Result) result2).numberOfBytesConsumed;
            } else {
                result = null;
                result2 = null;
            }
            if (mqttConnectVariableHeader.hasUserName()) {
                result3 = decodeString(byteBuf);
                i6 += ((Result) result3).numberOfBytesConsumed;
            } else {
                result3 = null;
            }
            if (mqttConnectVariableHeader.hasPassword()) {
                result4 = decodeByteArray(byteBuf);
                i6 += ((Result) result4).numberOfBytesConsumed;
            } else {
                result4 = null;
            }
            String str4 = (String) ((Result) decodeString).value;
            if (result != null) {
                str = (String) ((Result) result).value;
            } else {
                str = null;
            }
            if (result2 != null) {
                bArr = (byte[]) ((Result) result2).value;
            } else {
                bArr = null;
            }
            if (result3 != null) {
                str2 = (String) ((Result) result3).value;
            } else {
                str2 = null;
            }
            if (result4 != null) {
                bArr2 = (byte[]) ((Result) result4).value;
            }
            return new Result<>(new MqttConnectPayload(str4, str, bArr, str2, bArr2), i6);
        }
        throw new MqttIdentifierRejectedException("invalid clientIdentifier: " + str3);
    }

    private static Result<MqttConnectVariableHeader> decodeConnectionVariableHeader(ByteBuf byteBuf) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        Result<String> decodeString = decodeString(byteBuf);
        int i6 = ((Result) decodeString).numberOfBytesConsumed;
        MqttVersion fromProtocolNameAndLevel = MqttVersion.fromProtocolNameAndLevel((String) ((Result) decodeString).value, byteBuf.readByte());
        short readUnsignedByte = byteBuf.readUnsignedByte();
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        int i7 = i6 + 2 + ((Result) decodeMsbLsb).numberOfBytesConsumed;
        if ((readUnsignedByte & 128) == 128) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((readUnsignedByte & 64) == 64) {
            z6 = true;
        } else {
            z6 = false;
        }
        if ((readUnsignedByte & 32) == 32) {
            z7 = true;
        } else {
            z7 = false;
        }
        int i8 = (readUnsignedByte & 24) >> 3;
        if ((readUnsignedByte & 4) == 4) {
            z8 = true;
        } else {
            z8 = false;
        }
        if ((readUnsignedByte & 2) == 2) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (fromProtocolNameAndLevel == MqttVersion.MQTT_3_1_1 && (readUnsignedByte & 1) != 0) {
            throw new DecoderException("non-zero reserved flag");
        }
        return new Result<>(new MqttConnectVariableHeader(fromProtocolNameAndLevel.protocolName(), fromProtocolNameAndLevel.protocolLevel(), z5, z6, z7, i8, z8, z9, ((Integer) ((Result) decodeMsbLsb).value).intValue()), i7);
    }

    private static MqttFixedHeader decodeFixedHeader(ByteBuf byteBuf) {
        boolean z5;
        int i6;
        short readUnsignedByte = byteBuf.readUnsignedByte();
        MqttMessageType valueOf = MqttMessageType.valueOf(readUnsignedByte >> 4);
        int i7 = 0;
        boolean z6 = true;
        if ((readUnsignedByte & 8) != 8) {
            z6 = false;
        }
        int i8 = (readUnsignedByte & 6) >> 1;
        if ((readUnsignedByte & 1) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        int i9 = 0;
        int i10 = 1;
        do {
            short readUnsignedByte2 = byteBuf.readUnsignedByte();
            i7 += (readUnsignedByte2 & 127) * i10;
            i10 *= 128;
            i9++;
            i6 = readUnsignedByte2 & 128;
            if (i6 == 0) {
                break;
            }
        } while (i9 < 4);
        if (i9 == 4 && i6 != 0) {
            throw new DecoderException("remaining length exceeds 4 digits (" + valueOf + ')');
        }
        return MqttCodecUtil.validateFixedHeader(MqttCodecUtil.resetUnusedFields(new MqttFixedHeader(valueOf, z6, MqttQoS.valueOf(i8), z5, i7)));
    }

    private static Result<Integer> decodeMessageId(ByteBuf byteBuf) {
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        if (MqttCodecUtil.isValidMessageId(((Integer) ((Result) decodeMsbLsb).value).intValue())) {
            return decodeMsbLsb;
        }
        throw new DecoderException("invalid messageId: " + ((Result) decodeMsbLsb).value);
    }

    private static Result<MqttMessageIdVariableHeader> decodeMessageIdVariableHeader(ByteBuf byteBuf) {
        Result<Integer> decodeMessageId = decodeMessageId(byteBuf);
        return new Result<>(MqttMessageIdVariableHeader.from(((Integer) ((Result) decodeMessageId).value).intValue()), ((Result) decodeMessageId).numberOfBytesConsumed);
    }

    private static Result<ByteBuf> decodePublishPayload(ByteBuf byteBuf, int i6) {
        return new Result<>(byteBuf.readRetainedSlice(i6), i6);
    }

    private static Result<MqttPublishVariableHeader> decodePublishVariableHeader(ByteBuf byteBuf, MqttFixedHeader mqttFixedHeader) {
        int i6;
        Result<String> decodeString = decodeString(byteBuf);
        if (MqttCodecUtil.isValidPublishTopicName((String) ((Result) decodeString).value)) {
            int i7 = ((Result) decodeString).numberOfBytesConsumed;
            if (mqttFixedHeader.qosLevel().value() > 0) {
                Result<Integer> decodeMessageId = decodeMessageId(byteBuf);
                i6 = ((Integer) ((Result) decodeMessageId).value).intValue();
                i7 += ((Result) decodeMessageId).numberOfBytesConsumed;
            } else {
                i6 = -1;
            }
            return new Result<>(new MqttPublishVariableHeader((String) ((Result) decodeString).value, i6), i7);
        }
        throw new DecoderException("invalid publish topic name: " + ((String) ((Result) decodeString).value) + " (contains wildcards)");
    }
}
