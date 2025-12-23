package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.MessageSizeEstimator;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultMessageSizeEstimator implements MessageSizeEstimator {
    public static final MessageSizeEstimator DEFAULT = new DefaultMessageSizeEstimator(8);
    private final MessageSizeEstimator.Handle handle;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.DefaultMessageSizeEstimator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class HandleImpl implements MessageSizeEstimator.Handle {
        private final int unknownSize;

        /* synthetic */ HandleImpl(int i6, AnonymousClass1 anonymousClass1) {
            this(i6);
        }

        private HandleImpl(int i6) {
            this.unknownSize = i6;
        }

        @Override // io.netty.channel.MessageSizeEstimator.Handle
        public int size(Object obj) {
            if (obj instanceof ByteBuf) {
                return ((ByteBuf) obj).readableBytes();
            }
            if (obj instanceof ByteBufHolder) {
                return ((ByteBufHolder) obj).content().readableBytes();
            }
            if (obj instanceof FileRegion) {
                return 0;
            }
            return this.unknownSize;
        }
    }

    @Override // io.netty.channel.MessageSizeEstimator
    public MessageSizeEstimator.Handle newHandle() {
        return this.handle;
    }

    public DefaultMessageSizeEstimator(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "unknownSize");
        this.handle = new HandleImpl(i6, null);
    }
}
