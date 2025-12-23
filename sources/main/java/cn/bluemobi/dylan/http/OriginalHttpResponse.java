package cn.bluemobi.dylan.http;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface OriginalHttpResponse {
    void netOnFailure(Throwable th);

    void netOnFinish();

    void netOnStart();

    void netOnSuccess(String str);
}
