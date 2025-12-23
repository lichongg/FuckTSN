package io.netty.channel;

import io.netty.util.ReferenceCounted;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface FileRegion extends ReferenceCounted {
    long count();

    long position();

    @Override // io.netty.util.ReferenceCounted
    FileRegion retain();

    @Override // io.netty.util.ReferenceCounted
    FileRegion retain(int i6);

    @Override // io.netty.util.ReferenceCounted
    FileRegion touch();

    @Override // io.netty.util.ReferenceCounted
    FileRegion touch(Object obj);

    long transferTo(WritableByteChannel writableByteChannel, long j6) throws IOException;

    @Deprecated
    long transfered();

    long transferred();
}
