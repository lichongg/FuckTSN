package io.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class CompactObjectOutputStream extends ObjectOutputStream {
    static final int TYPE_FAT_DESCRIPTOR = 0;
    static final int TYPE_THIN_DESCRIPTOR = 1;

    @Override // java.io.ObjectOutputStream
    protected void writeStreamHeader() throws IOException {
        writeByte(5);
    }

    CompactObjectOutputStream(OutputStream outputStream) throws IOException {
        super(outputStream);
    }

    @Override // java.io.ObjectOutputStream
    protected void writeClassDescriptor(ObjectStreamClass objectStreamClass) throws IOException {
        Class<?> forClass = objectStreamClass.forClass();
        if (!forClass.isPrimitive() && !forClass.isArray() && !forClass.isInterface() && objectStreamClass.getSerialVersionUID() != 0) {
            write(1);
            writeUTF(objectStreamClass.getName());
        } else {
            write(0);
            super.writeClassDescriptor(objectStreamClass);
        }
    }
}
