package cn.bluemobi.dylan.http;

import android.content.Context;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface ResponseInterceptor {
    void onError(Context context, Throwable th);

    boolean onResponse(Context context, int i6, String str, Map<String, Object> map, String str2);

    boolean onResponseStart(Context context, String str, Map<String, Object> map, String str2, int i6);
}
