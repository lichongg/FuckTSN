package com.danikula.videocache;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface d {
    void a(byte[] bArr, int i6) throws ProxyCacheException;

    long available() throws ProxyCacheException;

    int b(byte[] bArr, long j6, int i6) throws ProxyCacheException;

    void close() throws ProxyCacheException;

    void complete() throws ProxyCacheException;

    boolean isCompleted();
}
