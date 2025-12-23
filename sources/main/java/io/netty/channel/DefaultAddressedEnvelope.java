package io.netty.channel;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultAddressedEnvelope<M, A extends SocketAddress> implements AddressedEnvelope<M, A> {
    private final M message;
    private final A recipient;
    private final A sender;

    public DefaultAddressedEnvelope(M m6, A a6, A a7) {
        if (m6 == null) {
            throw new NullPointerException(CrashHianalyticsData.MESSAGE);
        }
        if (a6 == null && a7 == null) {
            throw new NullPointerException("recipient and sender");
        }
        this.message = m6;
        this.sender = a7;
        this.recipient = a6;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return ReferenceCountUtil.release(this.message);
    }

    @Override // io.netty.channel.AddressedEnvelope
    public M content() {
        return this.message;
    }

    @Override // io.netty.channel.AddressedEnvelope
    public A recipient() {
        return this.recipient;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        M m6 = this.message;
        if (m6 instanceof ReferenceCounted) {
            return ((ReferenceCounted) m6).refCnt();
        }
        return 1;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return ReferenceCountUtil.release(this.message, i6);
    }

    @Override // io.netty.channel.AddressedEnvelope
    public A sender() {
        return this.sender;
    }

    public String toString() {
        if (this.sender == null) {
            return StringUtil.simpleClassName(this) + "(=> " + this.recipient + ", " + this.message + ')';
        }
        return StringUtil.simpleClassName(this) + '(' + this.sender + " => " + this.recipient + ", " + this.message + ')';
    }

    @Override // io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> retain() {
        ReferenceCountUtil.retain(this.message);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> touch() {
        ReferenceCountUtil.touch(this.message);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> retain(int i6) {
        ReferenceCountUtil.retain(this.message, i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> touch(Object obj) {
        ReferenceCountUtil.touch(this.message, obj);
        return this;
    }

    public DefaultAddressedEnvelope(M m6, A a6) {
        this(m6, a6, null);
    }
}
