package io.netty.channel.rxtx;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public interface RxtxChannelConfig extends ChannelConfig {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Databits {
        DATABITS_5(5),
        DATABITS_6(6),
        DATABITS_7(7),
        DATABITS_8(8);

        private final int value;

        public static Databits valueOf(int i6) {
            for (Databits databits : values()) {
                if (databits.value == i6) {
                    return databits;
                }
            }
            throw new IllegalArgumentException("unknown " + Databits.class.getSimpleName() + " value: " + i6);
        }

        public int value() {
            return this.value;
        }

        Databits(int i6) {
            this.value = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Paritybit {
        NONE(0),
        ODD(1),
        EVEN(2),
        MARK(3),
        SPACE(4);

        private final int value;

        public static Paritybit valueOf(int i6) {
            for (Paritybit paritybit : values()) {
                if (paritybit.value == i6) {
                    return paritybit;
                }
            }
            throw new IllegalArgumentException("unknown " + Paritybit.class.getSimpleName() + " value: " + i6);
        }

        public int value() {
            return this.value;
        }

        Paritybit(int i6) {
            this.value = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Stopbits {
        STOPBITS_1(1),
        STOPBITS_2(2),
        STOPBITS_1_5(3);

        private final int value;

        public static Stopbits valueOf(int i6) {
            for (Stopbits stopbits : values()) {
                if (stopbits.value == i6) {
                    return stopbits;
                }
            }
            throw new IllegalArgumentException("unknown " + Stopbits.class.getSimpleName() + " value: " + i6);
        }

        public int value() {
            return this.value;
        }

        Stopbits(int i6) {
            this.value = i6;
        }
    }

    int getBaudrate();

    Databits getDatabits();

    Paritybit getParitybit();

    int getReadTimeout();

    Stopbits getStopbits();

    int getWaitTimeMillis();

    boolean isDtr();

    boolean isRts();

    @Override // io.netty.channel.ChannelConfig
    RxtxChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    RxtxChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    RxtxChannelConfig setAutoRead(boolean z5);

    RxtxChannelConfig setBaudrate(int i6);

    @Override // io.netty.channel.ChannelConfig
    RxtxChannelConfig setConnectTimeoutMillis(int i6);

    RxtxChannelConfig setDatabits(Databits databits);

    RxtxChannelConfig setDtr(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    RxtxChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.ChannelConfig
    RxtxChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    RxtxChannelConfig setParitybit(Paritybit paritybit);

    RxtxChannelConfig setReadTimeout(int i6);

    @Override // io.netty.channel.ChannelConfig
    RxtxChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    RxtxChannelConfig setRts(boolean z5);

    RxtxChannelConfig setStopbits(Stopbits stopbits);

    RxtxChannelConfig setWaitTimeMillis(int i6);

    @Override // io.netty.channel.ChannelConfig
    RxtxChannelConfig setWriteBufferHighWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    RxtxChannelConfig setWriteBufferLowWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    RxtxChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    RxtxChannelConfig setWriteSpinCount(int i6);
}
