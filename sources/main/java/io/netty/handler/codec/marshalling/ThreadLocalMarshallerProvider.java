package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.FastThreadLocal;
import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ThreadLocalMarshallerProvider implements MarshallerProvider {
    private final MarshallingConfiguration config;
    private final MarshallerFactory factory;
    private final FastThreadLocal<Marshaller> marshallers = new FastThreadLocal<>();

    @Override // io.netty.handler.codec.marshalling.MarshallerProvider
    public Marshaller getMarshaller(ChannelHandlerContext channelHandlerContext) throws Exception {
        Marshaller marshaller = this.marshallers.get();
        if (marshaller != null) {
            return marshaller;
        }
        Marshaller createMarshaller = this.factory.createMarshaller(this.config);
        this.marshallers.set(createMarshaller);
        return createMarshaller;
    }

    public ThreadLocalMarshallerProvider(MarshallerFactory marshallerFactory, MarshallingConfiguration marshallingConfiguration) {
        this.factory = marshallerFactory;
        this.config = marshallingConfiguration;
    }
}
