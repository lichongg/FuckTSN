package cn.bluemobi.dylan.http;

import android.content.Context;
import cn.bluemobi.dylan.http.MessageManager;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Http {
    private static CustomResponse customResponse;
    private static volatile Http http;
    private static ResponseInterceptor responseInterceptor;
    private boolean debugMode;
    private final String TAG = "HTTP";
    private Integer loadingDialogLayoutId = null;

    public static Http getHttp() {
        if (http == null) {
            synchronized (Http.class) {
                try {
                    if (http == null) {
                        http = new Http();
                    }
                } finally {
                }
            }
        }
        return http;
    }

    public static HttpRequest with(Context context) {
        HttpRequest httpRequest = new HttpRequest(context);
        ResponseInterceptor responseInterceptor2 = responseInterceptor;
        if (responseInterceptor2 != null) {
            httpRequest.setResponseInterceptor(responseInterceptor2);
        }
        CustomResponse customResponse2 = customResponse;
        if (customResponse2 != null) {
            httpRequest.setCustomResponse(customResponse2);
        }
        return httpRequest;
    }

    public Integer getLoadingDialogLayoutId() {
        return this.loadingDialogLayoutId;
    }

    public boolean isDebugMode() {
        return this.debugMode;
    }

    public void setCustomResponse(CustomResponse customResponse2) {
        customResponse = customResponse2;
    }

    public Http setDebugMode(boolean z5) {
        this.debugMode = z5;
        RetrofitManager.getRetrofitManager().setDebugMode(z5);
        return http;
    }

    public void setResponseInterceptor(ResponseInterceptor responseInterceptor2) {
        responseInterceptor = responseInterceptor2;
    }

    private Http() {
    }

    public static void changeBaseUrl(String str) {
        RetrofitManager.getRetrofitManager().changeBaseUrl(str);
    }

    public static <T> T getApiService(Class<T> cls) {
        return (T) RetrofitManager.getRetrofitManager().getApiService(cls);
    }

    public Http addInterceptor(Interceptor interceptor) {
        RetrofitManager.getRetrofitManager().addInterceptor(interceptor);
        return this;
    }

    public <T> Http init(Class<T> cls, String str, String str2, String str3, String str4, int i6) {
        RetrofitManager.getRetrofitManager().initRetrofit(cls, str);
        JsonParse.getJsonParse().initJson(str2, str3, str4, i6);
        return http;
    }

    public Http setDefaultTimeout(long j6, TimeUnit timeUnit) {
        RetrofitManager.getRetrofitManager().setDefaultTimeout(j6, timeUnit);
        return this;
    }

    public Http setErrorMessage(String str) {
        MessageManager.getMessageManager().setErrorMessage(str);
        return http;
    }

    public void setLoadingDialog(int i6) {
        this.loadingDialogLayoutId = Integer.valueOf(i6);
    }

    public Http setSecret(String str) {
        RetrofitManager.getRetrofitManager().setSecret(str);
        return this;
    }

    public Http setShowMessageModel(MessageManager.MessageModel messageModel) {
        MessageManager.getMessageManager().setShowMessageModel(messageModel);
        return http;
    }

    public Http setUseEnglishLanguage(boolean z5) {
        MessageManager.getMessageManager().setUseEnglishLanguage(z5);
        return http;
    }
}
