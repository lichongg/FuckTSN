package io.netty.channel.rxtx;

import io.netty.channel.ChannelOption;
import io.netty.channel.rxtx.RxtxChannelConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class RxtxChannelOption<T> extends ChannelOption<T> {
    public static final ChannelOption<Integer> BAUD_RATE = ChannelOption.valueOf(RxtxChannelOption.class, "BAUD_RATE");
    public static final ChannelOption<Boolean> DTR = ChannelOption.valueOf(RxtxChannelOption.class, "DTR");
    public static final ChannelOption<Boolean> RTS = ChannelOption.valueOf(RxtxChannelOption.class, "RTS");
    public static final ChannelOption<RxtxChannelConfig.Stopbits> STOP_BITS = ChannelOption.valueOf(RxtxChannelOption.class, "STOP_BITS");
    public static final ChannelOption<RxtxChannelConfig.Databits> DATA_BITS = ChannelOption.valueOf(RxtxChannelOption.class, "DATA_BITS");
    public static final ChannelOption<RxtxChannelConfig.Paritybit> PARITY_BIT = ChannelOption.valueOf(RxtxChannelOption.class, "PARITY_BIT");
    public static final ChannelOption<Integer> WAIT_TIME = ChannelOption.valueOf(RxtxChannelOption.class, "WAIT_TIME");
    public static final ChannelOption<Integer> READ_TIMEOUT = ChannelOption.valueOf(RxtxChannelOption.class, "READ_TIMEOUT");

    private RxtxChannelOption() {
        super(null);
    }
}
