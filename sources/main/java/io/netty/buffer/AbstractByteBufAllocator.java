package io.netty.buffer;

import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractByteBufAllocator implements ByteBufAllocator {
    static final int CALCULATE_THRESHOLD = 4194304;
    static final int DEFAULT_INITIAL_CAPACITY = 256;
    static final int DEFAULT_MAX_CAPACITY = Integer.MAX_VALUE;
    static final int DEFAULT_MAX_COMPONENTS = 16;
    private final boolean directByDefault;
    private final ByteBuf emptyBuf;

    protected AbstractByteBufAllocator() {
        this(false);
    }

    protected static ByteBuf toLeakAwareBuffer(ByteBuf byteBuf) {
        ResourceLeakTracker<ByteBuf> track;
        int i6 = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i6 == 1) {
            ResourceLeakTracker<ByteBuf> track2 = AbstractByteBuf.leakDetector.track(byteBuf);
            if (track2 != null) {
                return new SimpleLeakAwareByteBuf(byteBuf, track2);
            }
        } else if ((i6 == 2 || i6 == 3) && (track = AbstractByteBuf.leakDetector.track(byteBuf)) != null) {
            return new AdvancedLeakAwareByteBuf(byteBuf, track);
        }
        return byteBuf;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer() {
        return this.directByDefault ? directBuffer() : heapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer() {
        return this.directByDefault ? compositeDirectBuffer() : compositeHeapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer() {
        return compositeDirectBuffer(16);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer() {
        return compositeHeapBuffer(16);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer() {
        return directBuffer(256, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer() {
        return heapBuffer(256, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer() {
        return (PlatformDependent.hasUnsafe() || isDirectBufferPooled()) ? directBuffer(256) : heapBuffer(256);
    }

    protected abstract ByteBuf newDirectBuffer(int i6, int i7);

    protected abstract ByteBuf newHeapBuffer(int i6, int i7);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.buffer.AbstractByteBufAllocator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$util$ResourceLeakDetector$Level;

        static {
            int[] iArr = new int[ResourceLeakDetector.Level.values().length];
            $SwitchMap$io$netty$util$ResourceLeakDetector$Level = iArr;
            try {
                iArr[ResourceLeakDetector.Level.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.ADVANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.PARANOID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        ResourceLeakDetector.addExclusions(AbstractByteBufAllocator.class, "toLeakAwareBuffer");
    }

    protected AbstractByteBufAllocator(boolean z5) {
        this.directByDefault = z5 && PlatformDependent.hasUnsafe();
        this.emptyBuf = new EmptyByteBuf(this);
    }

    private static void validate(int i6, int i7) {
        ObjectUtil.checkPositiveOrZero(i6, "initialCapacity");
        if (i6 > i7) {
            throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i6), Integer.valueOf(i7)));
        }
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int i6, int i7) {
        ObjectUtil.checkPositiveOrZero(i6, "minNewCapacity");
        if (i6 > i7) {
            throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i6), Integer.valueOf(i7)));
        }
        if (i6 == 4194304) {
            return 4194304;
        }
        if (i6 > 4194304) {
            int i8 = (i6 / 4194304) * 4194304;
            return i8 > i7 - 4194304 ? i7 : i8 + 4194304;
        }
        int i9 = 64;
        while (i9 < i6) {
            i9 <<= 1;
        }
        return Math.min(i9, i7);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i6) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, true, i6));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i6) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, false, i6));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i6) {
        return directBuffer(i6, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i6) {
        return heapBuffer(i6, Integer.MAX_VALUE);
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(directByDefault: " + this.directByDefault + ')';
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i6, int i7) {
        if (i6 == 0 && i7 == 0) {
            return this.emptyBuf;
        }
        validate(i6, i7);
        return newDirectBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i6, int i7) {
        if (i6 == 0 && i7 == 0) {
            return this.emptyBuf;
        }
        validate(i6, i7);
        return newHeapBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i6) {
        if (this.directByDefault) {
            return directBuffer(i6);
        }
        return heapBuffer(i6);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int i6) {
        if (this.directByDefault) {
            return compositeDirectBuffer(i6);
        }
        return compositeHeapBuffer(i6);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i6) {
        if (!PlatformDependent.hasUnsafe() && !isDirectBufferPooled()) {
            return heapBuffer(i6);
        }
        return directBuffer(i6);
    }

    protected static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf compositeByteBuf) {
        ResourceLeakTracker<ByteBuf> track;
        int i6 = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i6 == 1) {
            ResourceLeakTracker<ByteBuf> track2 = AbstractByteBuf.leakDetector.track(compositeByteBuf);
            if (track2 != null) {
                return new SimpleLeakAwareCompositeByteBuf(compositeByteBuf, track2);
            }
        } else if ((i6 == 2 || i6 == 3) && (track = AbstractByteBuf.leakDetector.track(compositeByteBuf)) != null) {
            return new AdvancedLeakAwareCompositeByteBuf(compositeByteBuf, track);
        }
        return compositeByteBuf;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i6, int i7) {
        if (this.directByDefault) {
            return directBuffer(i6, i7);
        }
        return heapBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i6, int i7) {
        if (!PlatformDependent.hasUnsafe() && !isDirectBufferPooled()) {
            return heapBuffer(i6, i7);
        }
        return directBuffer(i6, i7);
    }
}
