package xyz.adscope.common.v2.conn;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IBaseHttpRequest {
    void requestWithGetMethod(String str, IBaseHttpResponseCallback iBaseHttpResponseCallback);

    void requestWithPostMethod(String str, String str2, IBaseHttpResponseCallback iBaseHttpResponseCallback);

    void requestWithStreamMethod(String str, byte[] bArr, IBaseHttpResponseCallback iBaseHttpResponseCallback);
}
