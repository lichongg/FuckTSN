package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class b<MessageType extends n> implements p<MessageType> {

    /* renamed from: a, reason: collision with root package name */
    private static final f f46463a = f.c();

    private MessageType e(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw f(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    private UninitializedMessageException f(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).newUninitializedMessageException() : new UninitializedMessageException(messagetype);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public MessageType a(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        return e(j(inputStream, fVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public MessageType b(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        return e(k(inputStream, fVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public MessageType c(d dVar, f fVar) throws InvalidProtocolBufferException {
        return e(l(dVar, fVar));
    }

    public MessageType j(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return k(new a.AbstractC0905a.C0906a(inputStream, e.B(read, inputStream)), fVar);
        } catch (IOException e6) {
            throw new InvalidProtocolBufferException(e6.getMessage());
        }
    }

    public MessageType k(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        e g6 = e.g(inputStream);
        MessageType messagetype = (MessageType) d(g6, fVar);
        try {
            g6.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e6) {
            throw e6.setUnfinishedMessage(messagetype);
        }
    }

    public MessageType l(d dVar, f fVar) throws InvalidProtocolBufferException {
        e s5 = dVar.s();
        MessageType messagetype = (MessageType) d(s5, fVar);
        try {
            s5.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e6) {
            throw e6.setUnfinishedMessage(messagetype);
        }
    }
}
