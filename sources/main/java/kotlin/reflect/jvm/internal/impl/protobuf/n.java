package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface n extends o {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a extends Cloneable, o {
        n build();

        /* renamed from: d */
        a e(e eVar, f fVar) throws IOException;
    }

    p<? extends n> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
