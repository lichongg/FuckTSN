package io.netty.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ReferenceCounted {
    int refCnt();

    boolean release();

    boolean release(int i6);

    ReferenceCounted retain();

    ReferenceCounted retain(int i6);

    ReferenceCounted touch();

    ReferenceCounted touch(Object obj);
}
