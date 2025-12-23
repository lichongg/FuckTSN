package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.FastThreadLocal;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ThreadLocalUnmarshallerProvider implements UnmarshallerProvider {
    private final MarshallingConfiguration config;
    private final MarshallerFactory factory;
    private final FastThreadLocal<Unmarshaller> unmarshallers = new FastThreadLocal<>();

    @Override // io.netty.handler.codec.marshalling.UnmarshallerProvider
    public Unmarshaller getUnmarshaller(ChannelHandlerContext channelHandlerContext) throws Exception {
        Unmarshaller unmarshaller = this.unmarshallers.get();
        if (unmarshaller != null) {
            return unmarshaller;
        }
        Unmarshaller createUnmarshaller = this.factory.createUnmarshaller(this.config);
        this.unmarshallers.set(createUnmarshaller);
        return createUnmarshaller;
    }

    public ThreadLocalUnmarshallerProvider(MarshallerFactory marshallerFactory, MarshallingConfiguration marshallingConfiguration) {
        this.factory = marshallerFactory;
        this.config = marshallingConfiguration;
    }
}
