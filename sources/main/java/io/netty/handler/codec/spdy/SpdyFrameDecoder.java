package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SpdyFrameDecoder {
    private final SpdyFrameDecoderDelegate delegate;
    private byte flags;
    private int length;
    private final int maxChunkSize;
    private int numSettings;
    private final int spdyVersion;
    private State state;
    private int streamId;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum State {
        READ_COMMON_HEADER,
        READ_DATA_FRAME,
        READ_SYN_STREAM_FRAME,
        READ_SYN_REPLY_FRAME,
        READ_RST_STREAM_FRAME,
        READ_SETTINGS_FRAME,
        READ_SETTING,
        READ_PING_FRAME,
        READ_GOAWAY_FRAME,
        READ_HEADERS_FRAME,
        READ_WINDOW_UPDATE_FRAME,
        READ_HEADER_BLOCK,
        DISCARD_FRAME,
        FRAME_ERROR
    }

    public SpdyFrameDecoder(SpdyVersion spdyVersion, SpdyFrameDecoderDelegate spdyFrameDecoderDelegate) {
        this(spdyVersion, spdyFrameDecoderDelegate, 8192);
    }

    private static boolean hasFlag(byte b6, byte b7) {
        return (b6 & b7) != 0;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.spdy.SpdyFrameDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State = iArr;
            try {
                iArr[State.READ_COMMON_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_DATA_FRAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SYN_STREAM_FRAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SYN_REPLY_FRAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_RST_STREAM_FRAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SETTINGS_FRAME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SETTING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_PING_FRAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_GOAWAY_FRAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_HEADERS_FRAME.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_WINDOW_UPDATE_FRAME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_HEADER_BLOCK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.DISCARD_FRAME.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.FRAME_ERROR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public SpdyFrameDecoder(SpdyVersion spdyVersion, SpdyFrameDecoderDelegate spdyFrameDecoderDelegate, int i6) {
        if (spdyVersion == null) {
            throw new NullPointerException("spdyVersion");
        }
        if (spdyFrameDecoderDelegate == null) {
            throw new NullPointerException("delegate");
        }
        ObjectUtil.checkPositive(i6, "maxChunkSize");
        this.spdyVersion = spdyVersion.getVersion();
        this.delegate = spdyFrameDecoderDelegate;
        this.maxChunkSize = i6;
        this.state = State.READ_COMMON_HEADER;
    }

    private static boolean isValidFrameHeader(int i6, int i7, byte b6, int i8) {
        switch (i7) {
            case 0:
                if (i6 != 0) {
                }
                break;
            case 1:
                if (i8 >= 10) {
                }
                break;
            case 2:
                if (i8 >= 4) {
                }
                break;
            case 3:
                if (b6 != 0 || i8 != 8) {
                }
                break;
            case 4:
                if (i8 >= 4) {
                }
                break;
            case 6:
                if (i8 == 4) {
                }
                break;
            case 7:
                if (i8 == 8) {
                }
                break;
            case 8:
                if (i8 >= 4) {
                }
                break;
            case 9:
                if (i8 == 8) {
                }
                break;
        }
        return true;
    }

    public void decode(ByteBuf byteBuf) {
        int i6;
        while (true) {
            int i7 = 0;
            r2 = false;
            boolean z5 = false;
            switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[this.state.ordinal()]) {
                case 1:
                    if (byteBuf.readableBytes() >= 8) {
                        int readerIndex = byteBuf.readerIndex();
                        int i8 = readerIndex + 4;
                        int i9 = readerIndex + 5;
                        byteBuf.skipBytes(8);
                        if ((byteBuf.getByte(readerIndex) & 128) != 0) {
                            i6 = SpdyCodecUtil.getUnsignedShort(byteBuf, readerIndex) & 32767;
                            int unsignedShort = SpdyCodecUtil.getUnsignedShort(byteBuf, readerIndex + 2);
                            this.streamId = 0;
                            i7 = unsignedShort;
                        } else {
                            i6 = this.spdyVersion;
                            this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, readerIndex);
                        }
                        this.flags = byteBuf.getByte(i8);
                        int unsignedMedium = SpdyCodecUtil.getUnsignedMedium(byteBuf, i9);
                        this.length = unsignedMedium;
                        if (i6 == this.spdyVersion) {
                            if (!isValidFrameHeader(this.streamId, i7, this.flags, unsignedMedium)) {
                                this.state = State.FRAME_ERROR;
                                this.delegate.readFrameError("Invalid Frame Error");
                                break;
                            } else {
                                this.state = getNextState(i7, this.length);
                                break;
                            }
                        } else {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid SPDY Version");
                            break;
                        }
                    } else {
                        return;
                    }
                case 2:
                    int i10 = this.length;
                    if (i10 != 0) {
                        int min = Math.min(this.maxChunkSize, i10);
                        if (byteBuf.readableBytes() >= min) {
                            ByteBuf buffer = byteBuf.alloc().buffer(min);
                            buffer.writeBytes(byteBuf, min);
                            int i11 = this.length - min;
                            this.length = i11;
                            if (i11 == 0) {
                                this.state = State.READ_COMMON_HEADER;
                            }
                            if (i11 == 0 && hasFlag(this.flags, (byte) 1)) {
                                z5 = true;
                            }
                            this.delegate.readDataFrame(this.streamId, z5, buffer);
                            break;
                        } else {
                            return;
                        }
                    } else {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readDataFrame(this.streamId, hasFlag(this.flags, (byte) 1), Unpooled.buffer(0));
                        break;
                    }
                case 3:
                    if (byteBuf.readableBytes() >= 10) {
                        int readerIndex2 = byteBuf.readerIndex();
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, readerIndex2);
                        int unsignedInt = SpdyCodecUtil.getUnsignedInt(byteBuf, readerIndex2 + 4);
                        byte b6 = (byte) ((byteBuf.getByte(readerIndex2 + 8) >> 5) & 7);
                        boolean hasFlag = hasFlag(this.flags, (byte) 1);
                        boolean hasFlag2 = hasFlag(this.flags, (byte) 2);
                        byteBuf.skipBytes(10);
                        this.length -= 10;
                        int i12 = this.streamId;
                        if (i12 != 0) {
                            this.state = State.READ_HEADER_BLOCK;
                            this.delegate.readSynStreamFrame(i12, unsignedInt, b6, hasFlag, hasFlag2);
                            break;
                        } else {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid SYN_STREAM Frame");
                            break;
                        }
                    } else {
                        return;
                    }
                case 4:
                    if (byteBuf.readableBytes() >= 4) {
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        boolean hasFlag3 = hasFlag(this.flags, (byte) 1);
                        byteBuf.skipBytes(4);
                        this.length -= 4;
                        int i13 = this.streamId;
                        if (i13 != 0) {
                            this.state = State.READ_HEADER_BLOCK;
                            this.delegate.readSynReplyFrame(i13, hasFlag3);
                            break;
                        } else {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid SYN_REPLY Frame");
                            break;
                        }
                    } else {
                        return;
                    }
                case 5:
                    if (byteBuf.readableBytes() >= 8) {
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        int signedInt = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                        byteBuf.skipBytes(8);
                        int i14 = this.streamId;
                        if (i14 != 0 && signedInt != 0) {
                            this.state = State.READ_COMMON_HEADER;
                            this.delegate.readRstStreamFrame(i14, signedInt);
                            break;
                        } else {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid RST_STREAM Frame");
                            break;
                        }
                    } else {
                        return;
                    }
                case 6:
                    if (byteBuf.readableBytes() >= 4) {
                        boolean hasFlag4 = hasFlag(this.flags, (byte) 1);
                        this.numSettings = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        byteBuf.skipBytes(4);
                        int i15 = this.length - 4;
                        this.length = i15;
                        if ((i15 & 7) != 0 || (i15 >> 3) != this.numSettings) {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid SETTINGS Frame");
                            break;
                        } else {
                            this.state = State.READ_SETTING;
                            this.delegate.readSettingsFrame(hasFlag4);
                            break;
                        }
                    } else {
                        return;
                    }
                case 7:
                    if (this.numSettings != 0) {
                        if (byteBuf.readableBytes() >= 8) {
                            byte b7 = byteBuf.getByte(byteBuf.readerIndex());
                            int unsignedMedium2 = SpdyCodecUtil.getUnsignedMedium(byteBuf, byteBuf.readerIndex() + 1);
                            int signedInt2 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                            boolean hasFlag5 = hasFlag(b7, (byte) 1);
                            boolean hasFlag6 = hasFlag(b7, (byte) 2);
                            byteBuf.skipBytes(8);
                            this.numSettings--;
                            this.delegate.readSetting(unsignedMedium2, signedInt2, hasFlag5, hasFlag6);
                            break;
                        } else {
                            return;
                        }
                    } else {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readSettingsEnd();
                        break;
                    }
                case 8:
                    if (byteBuf.readableBytes() >= 4) {
                        int signedInt3 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex());
                        byteBuf.skipBytes(4);
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readPingFrame(signedInt3);
                        break;
                    } else {
                        return;
                    }
                case 9:
                    if (byteBuf.readableBytes() >= 8) {
                        int unsignedInt2 = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        int signedInt4 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                        byteBuf.skipBytes(8);
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readGoAwayFrame(unsignedInt2, signedInt4);
                        break;
                    } else {
                        return;
                    }
                case 10:
                    if (byteBuf.readableBytes() >= 4) {
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        boolean hasFlag7 = hasFlag(this.flags, (byte) 1);
                        byteBuf.skipBytes(4);
                        this.length -= 4;
                        int i16 = this.streamId;
                        if (i16 != 0) {
                            this.state = State.READ_HEADER_BLOCK;
                            this.delegate.readHeadersFrame(i16, hasFlag7);
                            break;
                        } else {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid HEADERS Frame");
                            break;
                        }
                    } else {
                        return;
                    }
                case 11:
                    if (byteBuf.readableBytes() >= 8) {
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        int unsignedInt3 = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex() + 4);
                        byteBuf.skipBytes(8);
                        if (unsignedInt3 != 0) {
                            this.state = State.READ_COMMON_HEADER;
                            this.delegate.readWindowUpdateFrame(this.streamId, unsignedInt3);
                            break;
                        } else {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid WINDOW_UPDATE Frame");
                            break;
                        }
                    } else {
                        return;
                    }
                case 12:
                    if (this.length != 0) {
                        if (byteBuf.isReadable()) {
                            int min2 = Math.min(byteBuf.readableBytes(), this.length);
                            ByteBuf buffer2 = byteBuf.alloc().buffer(min2);
                            buffer2.writeBytes(byteBuf, min2);
                            this.length -= min2;
                            this.delegate.readHeaderBlock(buffer2);
                            break;
                        } else {
                            return;
                        }
                    } else {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readHeaderBlockEnd();
                        break;
                    }
                case 13:
                    int min3 = Math.min(byteBuf.readableBytes(), this.length);
                    byteBuf.skipBytes(min3);
                    int i17 = this.length - min3;
                    this.length = i17;
                    if (i17 == 0) {
                        this.state = State.READ_COMMON_HEADER;
                        break;
                    } else {
                        return;
                    }
                case 14:
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        }
    }

    private static State getNextState(int i6, int i7) {
        switch (i6) {
            case 0:
                return State.READ_DATA_FRAME;
            case 1:
                return State.READ_SYN_STREAM_FRAME;
            case 2:
                return State.READ_SYN_REPLY_FRAME;
            case 3:
                return State.READ_RST_STREAM_FRAME;
            case 4:
                return State.READ_SETTINGS_FRAME;
            case 5:
            default:
                if (i7 != 0) {
                    return State.DISCARD_FRAME;
                }
                return State.READ_COMMON_HEADER;
            case 6:
                return State.READ_PING_FRAME;
            case 7:
                return State.READ_GOAWAY_FRAME;
            case 8:
                return State.READ_HEADERS_FRAME;
            case 9:
                return State.READ_WINDOW_UPDATE_FRAME;
        }
    }
}
