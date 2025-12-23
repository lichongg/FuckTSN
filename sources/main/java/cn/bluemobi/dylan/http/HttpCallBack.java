package cn.bluemobi.dylan.http;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class HttpCallBack implements HttpResponse {
    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnOtherStatus(int i6, String str) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnOtherStatus(int i6, String str, Map<String, Object> map) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnFinish() {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnStart() {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnFailure(Throwable th) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnSuccess(Map<String, Object> map, String str) {
    }

    @Override // cn.bluemobi.dylan.http.HttpResponse
    public void netOnSuccessServerError(int i6, String str) {
    }

    @Override // cn.bluemobi.dylan.http.download.ProgressResponseListener
    public void onResponseProgress(long j6, long j7, boolean z5) {
    }
}
