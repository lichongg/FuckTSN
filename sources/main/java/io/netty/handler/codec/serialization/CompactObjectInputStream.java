package io.netty.handler.codec.serialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class CompactObjectInputStream extends ObjectInputStream {
    private final ClassResolver classResolver;

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        try {
            return this.classResolver.resolve(objectStreamClass.getName());
        } catch (ClassNotFoundException unused) {
            return super.resolveClass(objectStreamClass);
        }
    }

    CompactObjectInputStream(InputStream inputStream, ClassResolver classResolver) throws IOException {
        super(inputStream);
        this.classResolver = classResolver;
    }

    @Override // java.io.ObjectInputStream
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        int read = read();
        if (read >= 0) {
            if (read != 0) {
                if (read == 1) {
                    return ObjectStreamClass.lookupAny(this.classResolver.resolve(readUTF()));
                }
                throw new StreamCorruptedException("Unexpected class descriptor type: " + read);
            }
            return super.readClassDescriptor();
        }
        throw new EOFException();
    }

    @Override // java.io.ObjectInputStream
    protected void readStreamHeader() throws IOException {
        int readByte = readByte() & 255;
        if (readByte == 5) {
            return;
        }
        throw new StreamCorruptedException("Unsupported version: " + readByte);
    }
}
