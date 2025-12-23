package io.netty.channel;

import androidx.concurrent.futures.a;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultChannelConfig implements ChannelConfig {
    private static final int DEFAULT_CONNECT_TIMEOUT = 30000;
    private volatile ByteBufAllocator allocator;
    private volatile boolean autoClose;
    private volatile int autoRead;
    protected final Channel channel;
    private volatile int connectTimeoutMillis;
    private volatile MessageSizeEstimator msgSizeEstimator;
    private volatile boolean pinEventExecutor;
    private volatile RecvByteBufAllocator rcvBufAllocator;
    private volatile WriteBufferWaterMark writeBufferWaterMark;
    private volatile int writeSpinCount;
    private static final MessageSizeEstimator DEFAULT_MSG_SIZE_ESTIMATOR = DefaultMessageSizeEstimator.DEFAULT;
    private static final AtomicIntegerFieldUpdater<DefaultChannelConfig> AUTOREAD_UPDATER = AtomicIntegerFieldUpdater.newUpdater(DefaultChannelConfig.class, "autoRead");
    private static final AtomicReferenceFieldUpdater<DefaultChannelConfig, WriteBufferWaterMark> WATERMARK_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultChannelConfig.class, WriteBufferWaterMark.class, "writeBufferWaterMark");

    public DefaultChannelConfig(Channel channel) {
        this(channel, new AdaptiveRecvByteBufAllocator());
    }

    @Override // io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(null, ChannelOption.CONNECT_TIMEOUT_MILLIS, ChannelOption.MAX_MESSAGES_PER_READ, ChannelOption.WRITE_SPIN_COUNT, ChannelOption.ALLOCATOR, ChannelOption.AUTO_READ, ChannelOption.AUTO_CLOSE, ChannelOption.RCVBUF_ALLOCATOR, ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK, ChannelOption.WRITE_BUFFER_LOW_WATER_MARK, ChannelOption.WRITE_BUFFER_WATER_MARK, ChannelOption.MESSAGE_SIZE_ESTIMATOR, ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP);
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        this.rcvBufAllocator = (RecvByteBufAllocator) ObjectUtil.checkNotNull(recvByteBufAllocator, "allocator");
        return this;
    }

    protected DefaultChannelConfig(Channel channel, RecvByteBufAllocator recvByteBufAllocator) {
        this.allocator = ByteBufAllocator.DEFAULT;
        this.msgSizeEstimator = DEFAULT_MSG_SIZE_ESTIMATOR;
        this.connectTimeoutMillis = 30000;
        this.writeSpinCount = 16;
        this.autoRead = 1;
        this.autoClose = true;
        this.writeBufferWaterMark = WriteBufferWaterMark.DEFAULT;
        this.pinEventExecutor = true;
        setRecvByteBufAllocator(recvByteBufAllocator, channel.metadata());
        this.channel = channel;
    }

    private boolean getPinEventExecutorPerGroup() {
        return this.pinEventExecutor;
    }

    private ChannelConfig setPinEventExecutorPerGroup(boolean z5) {
        this.pinEventExecutor = z5;
        return this;
    }

    private void setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator, ChannelMetadata channelMetadata) {
        if (recvByteBufAllocator instanceof MaxMessagesRecvByteBufAllocator) {
            ((MaxMessagesRecvByteBufAllocator) recvByteBufAllocator).maxMessagesPerRead(channelMetadata.defaultMaxMessagesPerRead());
        } else if (recvByteBufAllocator == null) {
            throw new NullPointerException("allocator");
        }
        setRecvByteBufAllocator(recvByteBufAllocator);
    }

    @Override // io.netty.channel.ChannelConfig
    public ByteBufAllocator getAllocator() {
        return this.allocator;
    }

    @Override // io.netty.channel.ChannelConfig
    public int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // io.netty.channel.ChannelConfig
    public MessageSizeEstimator getMessageSizeEstimator() {
        return this.msgSizeEstimator;
    }

    @Override // io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == null) {
            throw new NullPointerException("option");
        }
        if (channelOption == ChannelOption.CONNECT_TIMEOUT_MILLIS) {
            return (T) Integer.valueOf(getConnectTimeoutMillis());
        }
        if (channelOption == ChannelOption.MAX_MESSAGES_PER_READ) {
            return (T) Integer.valueOf(getMaxMessagesPerRead());
        }
        if (channelOption == ChannelOption.WRITE_SPIN_COUNT) {
            return (T) Integer.valueOf(getWriteSpinCount());
        }
        if (channelOption == ChannelOption.ALLOCATOR) {
            return (T) getAllocator();
        }
        if (channelOption == ChannelOption.RCVBUF_ALLOCATOR) {
            return (T) getRecvByteBufAllocator();
        }
        if (channelOption == ChannelOption.AUTO_READ) {
            return (T) Boolean.valueOf(isAutoRead());
        }
        if (channelOption == ChannelOption.AUTO_CLOSE) {
            return (T) Boolean.valueOf(isAutoClose());
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK) {
            return (T) Integer.valueOf(getWriteBufferHighWaterMark());
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_LOW_WATER_MARK) {
            return (T) Integer.valueOf(getWriteBufferLowWaterMark());
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_WATER_MARK) {
            return (T) getWriteBufferWaterMark();
        }
        if (channelOption == ChannelOption.MESSAGE_SIZE_ESTIMATOR) {
            return (T) getMessageSizeEstimator();
        }
        if (channelOption == ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP) {
            return (T) Boolean.valueOf(getPinEventExecutorPerGroup());
        }
        return null;
    }

    protected Map<ChannelOption<?>, Object> getOptions(Map<ChannelOption<?>, Object> map, ChannelOption<?>... channelOptionArr) {
        if (map == null) {
            map = new IdentityHashMap<>();
        }
        for (ChannelOption<?> channelOption : channelOptionArr) {
            map.put(channelOption, getOption(channelOption));
        }
        return map;
    }

    @Override // io.netty.channel.ChannelConfig
    public <T extends RecvByteBufAllocator> T getRecvByteBufAllocator() {
        return (T) this.rcvBufAllocator;
    }

    @Override // io.netty.channel.ChannelConfig
    public int getWriteBufferHighWaterMark() {
        return this.writeBufferWaterMark.high();
    }

    @Override // io.netty.channel.ChannelConfig
    public int getWriteBufferLowWaterMark() {
        return this.writeBufferWaterMark.low();
    }

    @Override // io.netty.channel.ChannelConfig
    public WriteBufferWaterMark getWriteBufferWaterMark() {
        return this.writeBufferWaterMark;
    }

    @Override // io.netty.channel.ChannelConfig
    public int getWriteSpinCount() {
        return this.writeSpinCount;
    }

    @Override // io.netty.channel.ChannelConfig
    public boolean isAutoClose() {
        return this.autoClose;
    }

    @Override // io.netty.channel.ChannelConfig
    public boolean isAutoRead() {
        return this.autoRead == 1;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        if (byteBufAllocator == null) {
            throw new NullPointerException("allocator");
        }
        this.allocator = byteBufAllocator;
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setAutoClose(boolean z5) {
        this.autoClose = z5;
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setAutoRead(boolean z5) {
        boolean z6 = AUTOREAD_UPDATER.getAndSet(this, z5 ? 1 : 0) == 1;
        if (z5 && !z6) {
            this.channel.read();
            return this;
        }
        if (!z5 && z6) {
            autoReadCleared();
        }
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setConnectTimeoutMillis(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "connectTimeoutMillis");
        this.connectTimeoutMillis = i6;
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        if (messageSizeEstimator == null) {
            throw new NullPointerException("estimator");
        }
        this.msgSizeEstimator = messageSizeEstimator;
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public boolean setOptions(Map<ChannelOption<?>, ?> map) {
        if (map == null) {
            throw new NullPointerException("options");
        }
        boolean z5 = true;
        for (Map.Entry<ChannelOption<?>, ?> entry : map.entrySet()) {
            if (!setOption(entry.getKey(), entry.getValue())) {
                z5 = false;
            }
        }
        return z5;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferHighWaterMark(int i6) {
        WriteBufferWaterMark writeBufferWaterMark;
        ObjectUtil.checkPositiveOrZero(i6, "writeBufferHighWaterMark");
        do {
            writeBufferWaterMark = this.writeBufferWaterMark;
            if (i6 < writeBufferWaterMark.low()) {
                throw new IllegalArgumentException("writeBufferHighWaterMark cannot be less than writeBufferLowWaterMark (" + writeBufferWaterMark.low() + "): " + i6);
            }
        } while (!a.a(WATERMARK_UPDATER, this, writeBufferWaterMark, new WriteBufferWaterMark(writeBufferWaterMark.low(), i6, false)));
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferLowWaterMark(int i6) {
        WriteBufferWaterMark writeBufferWaterMark;
        ObjectUtil.checkPositiveOrZero(i6, "writeBufferLowWaterMark");
        do {
            writeBufferWaterMark = this.writeBufferWaterMark;
            if (i6 > writeBufferWaterMark.high()) {
                throw new IllegalArgumentException("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark (" + writeBufferWaterMark.high() + "): " + i6);
            }
        } while (!a.a(WATERMARK_UPDATER, this, writeBufferWaterMark, new WriteBufferWaterMark(i6, writeBufferWaterMark.high(), false)));
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        this.writeBufferWaterMark = (WriteBufferWaterMark) ObjectUtil.checkNotNull(writeBufferWaterMark, "writeBufferWaterMark");
        return this;
    }

    @Override // io.netty.channel.ChannelConfig
    public ChannelConfig setWriteSpinCount(int i6) {
        ObjectUtil.checkPositive(i6, "writeSpinCount");
        if (i6 == Integer.MAX_VALUE) {
            i6--;
        }
        this.writeSpinCount = i6;
        return this;
    }

    protected <T> void validate(ChannelOption<T> channelOption, T t5) {
        if (channelOption == null) {
            throw new NullPointerException("option");
        }
        channelOption.validate(t5);
    }

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    public int getMaxMessagesPerRead() {
        try {
            return ((MaxMessagesRecvByteBufAllocator) getRecvByteBufAllocator()).maxMessagesPerRead();
        } catch (ClassCastException e6) {
            throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", e6);
        }
    }

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    public ChannelConfig setMaxMessagesPerRead(int i6) {
        try {
            ((MaxMessagesRecvByteBufAllocator) getRecvByteBufAllocator()).maxMessagesPerRead(i6);
            return this;
        } catch (ClassCastException e6) {
            throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", e6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == ChannelOption.CONNECT_TIMEOUT_MILLIS) {
            setConnectTimeoutMillis(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.MAX_MESSAGES_PER_READ) {
            setMaxMessagesPerRead(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.WRITE_SPIN_COUNT) {
            setWriteSpinCount(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.ALLOCATOR) {
            setAllocator((ByteBufAllocator) t5);
            return true;
        }
        if (channelOption == ChannelOption.RCVBUF_ALLOCATOR) {
            setRecvByteBufAllocator((RecvByteBufAllocator) t5);
            return true;
        }
        if (channelOption == ChannelOption.AUTO_READ) {
            setAutoRead(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.AUTO_CLOSE) {
            setAutoClose(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK) {
            setWriteBufferHighWaterMark(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_LOW_WATER_MARK) {
            setWriteBufferLowWaterMark(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.WRITE_BUFFER_WATER_MARK) {
            setWriteBufferWaterMark((WriteBufferWaterMark) t5);
            return true;
        }
        if (channelOption == ChannelOption.MESSAGE_SIZE_ESTIMATOR) {
            setMessageSizeEstimator((MessageSizeEstimator) t5);
            return true;
        }
        if (channelOption == ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP) {
            setPinEventExecutorPerGroup(((Boolean) t5).booleanValue());
            return true;
        }
        return false;
    }

    protected void autoReadCleared() {
    }
}
