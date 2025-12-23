package cn.bluemobi.dylan.http;

import cn.bluemobi.dylan.http.download.ProgressResponseListener;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface HttpResponse extends ProgressResponseListener {
    void netOnFailure(Throwable th);

    void netOnFinish();

    void netOnOtherStatus(int i6, String str);

    void netOnOtherStatus(int i6, String str, Map<String, Object> map);

    void netOnStart();

    void netOnSuccess(Map<String, Object> map);

    void netOnSuccess(Map<String, Object> map, String str);

    void netOnSuccessServerError(int i6, String str);
}
