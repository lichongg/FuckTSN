package io.netty.handler.codec.http.multipart;

import io.netty.util.ReferenceCounted;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface InterfaceHttpData extends Comparable<InterfaceHttpData>, ReferenceCounted {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum HttpDataType {
        Attribute,
        FileUpload,
        InternalAttribute
    }

    HttpDataType getHttpDataType();

    String getName();

    InterfaceHttpData retain();

    InterfaceHttpData retain(int i6);

    InterfaceHttpData touch();

    InterfaceHttpData touch(Object obj);
}
