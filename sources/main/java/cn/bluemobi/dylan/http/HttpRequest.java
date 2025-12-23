package cn.bluemobi.dylan.http;

import android.app.Activity;
import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.Toast;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.http.MessageManager;
import cn.bluemobi.dylan.http.dialog.DialogOnDismissListener;
import cn.bluemobi.dylan.http.dialog.DialogOnKeyListener;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.bjtsn.dylan.lifecycleobserver.LifecycleObserver;
import com.bjtsn.dylan.lifecycleobserver.b;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.c0;
import rx.android.schedulers.a;
import rx.e;
import rx.l;
import rx.m;
import rx.schedulers.c;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class HttpRequest {
    private WeakReference<Context> context;
    private CustomResponse customResponse;
    private String loadingMessage;
    private e<? extends c0<ResponseBody>> observable;
    private ResponseInterceptor responseInterceptor;
    private boolean isShowLoadingDialog = true;
    private LoadingDialog loadingDialog = null;
    private boolean isShowSuccessMessage = true;
    private boolean isShowOtherStatusMessage = true;
    private boolean isShowFailMessage = true;
    private boolean canCancel = true;
    private HttpJsonKey httpJsonKey = JsonParse.getJsonParse();

    private String convertFileSize(long j6) {
        if (j6 >= IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return String.format("%.1f GB", Float.valueOf(j6 / IjkMediaMeta.AV_CH_STEREO_RIGHT));
        }
        if (j6 >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            float f6 = j6 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            return String.format(f6 > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f6));
        }
        if (j6 < 1024) {
            return String.format("%d B", Long.valueOf(j6));
        }
        float f7 = j6 / 1024;
        return String.format(f7 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f7));
    }

    public HttpRequest hideFailMessage() {
        this.isShowFailMessage = false;
        return this;
    }

    public HttpRequest hideLoadingDialog() {
        this.isShowLoadingDialog = false;
        return this;
    }

    public HttpRequest hideOtherStatusMessage() {
        this.isShowOtherStatusMessage = false;
        return this;
    }

    public HttpRequest hideSuccessMessage() {
        this.isShowSuccessMessage = false;
        return this;
    }

    public m setDataListener(final HttpCallBack httpCallBack) {
        final Context context = this.context.get();
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            httpCallBack.netOnFinish();
            return null;
        }
        String str = MessageManager.getMessageManager().isUseEnglishLanguage() ? "Network  unusual" : "网络不可用";
        if (this.customResponse == null && !NetworkUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, str, 0).show();
            if (httpCallBack != null) {
                httpCallBack.netOnFailure(new Exception(str));
                httpCallBack.netOnFinish();
            }
            return null;
        }
        if (!this.isShowLoadingDialog) {
            this.loadingDialog = null;
        } else if (this.loadingDialog == null) {
            this.loadingDialog = new LoadingDialog(context);
        }
        m r5 = this.observable.w5(c.e()).I3(a.b()).r5(new l<c0<ResponseBody>>() { // from class: cn.bluemobi.dylan.http.HttpRequest.1
            private void showErrorMessage(String str2, Exception exc) {
                if (HttpRequest.this.responseInterceptor != null) {
                    HttpRequest.this.responseInterceptor.onError(context, exc);
                }
                if (MessageManager.getMessageManager().getShowMessageModel() != MessageManager.MessageModel.NO && HttpRequest.this.isShowFailMessage) {
                    Toast.makeText(context, str2, 0).show();
                }
                HttpCallBack httpCallBack2 = httpCallBack;
                if (httpCallBack2 != null) {
                    httpCallBack2.netOnFailure(exc);
                }
                if (Http.getHttp().isDebugMode()) {
                    exc.printStackTrace();
                }
            }

            @Override // rx.f
            public void onCompleted() {
                if (HttpRequest.this.loadingDialog != null) {
                    HttpRequest.this.loadingDialog.dismiss();
                }
                HttpCallBack httpCallBack2 = httpCallBack;
                if (httpCallBack2 != null) {
                    httpCallBack2.netOnFinish();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x019d  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // rx.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onNext(retrofit2.c0<okhttp3.ResponseBody> r14) {
                /*
                    Method dump skipped, instructions count: 480
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.http.HttpRequest.AnonymousClass1.onNext(retrofit2.c0):void");
            }

            @Override // rx.l
            public void onStart() {
                if (HttpRequest.this.loadingDialog != null) {
                    HttpRequest.this.loadingDialog.show(HttpRequest.this.loadingMessage);
                }
                HttpCallBack httpCallBack2 = httpCallBack;
                if (httpCallBack2 != null) {
                    httpCallBack2.netOnStart();
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                if (Http.getHttp().isDebugMode()) {
                    th.printStackTrace();
                }
                onCompleted();
                if (HttpRequest.this.customResponse != null) {
                    HttpRequest.this.customResponse.onError(context, HttpRequest.this, httpCallBack, th);
                    return;
                }
                if (HttpRequest.this.responseInterceptor != null) {
                    HttpRequest.this.responseInterceptor.onError(context, th);
                }
                if (HttpRequest.this.isShowFailMessage) {
                    if (th instanceof SocketTimeoutException) {
                        Toast.makeText(context, "网络连接超时,请重新再试", 0).show();
                    } else {
                        Toast.makeText(context, "网络连接错误,错误码：-2", 0).show();
                    }
                }
                HttpCallBack httpCallBack2 = httpCallBack;
                if (httpCallBack2 != null) {
                    httpCallBack2.netOnFailure(th);
                }
            }
        });
        if (r5 != null) {
            LoadingDialog loadingDialog = this.loadingDialog;
            if (loadingDialog != null) {
                loadingDialog.setOnKeyListener(new DialogOnKeyListener(loadingDialog, this.canCancel));
                this.loadingDialog.setOnDismissListener(new DialogOnDismissListener(r5));
                return r5;
            }
            addLifeCycle(context, r5);
        }
        return r5;
    }

    private void addLifeCycle(Context context, final m mVar) {
        if (context instanceof FragmentActivity) {
            new LifecycleObserver((FragmentActivity) context).c(new b() { // from class: cn.bluemobi.dylan.http.HttpRequest.3
                @Override // com.bjtsn.dylan.lifecycleobserver.b
                public void onDestroy() {
                    m mVar2 = mVar;
                    if (mVar2 != null && !mVar2.isUnsubscribed()) {
                        mVar.unsubscribe();
                    }
                    super.onDestroy();
                }
            });
        }
    }

    private String getPartHeaders(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField("headers");
        } catch (NoSuchFieldException e6) {
            e6.printStackTrace();
            field = null;
        }
        field.setAccessible(true);
        try {
            return ((Headers) field.get(part)).get("content-disposition").split(";")[1].split(ContainerUtils.KEY_VALUE_DELIMITER)[1].replace("\"", "");
        } catch (IllegalAccessException e7) {
            e7.printStackTrace();
            return "";
        } catch (Exception e8) {
            e8.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> getRequestParement(Request request) {
        String str;
        ArrayMap arrayMap = new ArrayMap();
        if (request.body() instanceof FormBody) {
            FormBody formBody = (FormBody) request.body();
            for (int i6 = 0; i6 < formBody.size(); i6++) {
                arrayMap.put(formBody.name(i6), formBody.value(i6));
            }
        } else if (request.body() instanceof MultipartBody) {
            for (MultipartBody.Part part : ((MultipartBody) request.body()).parts()) {
                String partHeaders = getPartHeaders(part);
                try {
                    str = URLDecoder.decode(getRequestBody(part).replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
                } catch (UnsupportedEncodingException e6) {
                    e6.printStackTrace();
                    str = null;
                }
                arrayMap.put(partHeaders, str);
            }
        }
        return arrayMap;
    }

    public LoadingDialog getLoadingDialog() {
        return this.loadingDialog;
    }

    public boolean isShowFailMessage() {
        return this.isShowFailMessage;
    }

    public boolean isShowOtherStatusMessage() {
        return this.isShowOtherStatusMessage;
    }

    public boolean isShowSuccessMessage() {
        return this.isShowSuccessMessage;
    }

    public HttpRequest setCanCancel(boolean z5) {
        this.canCancel = z5;
        return this;
    }

    public void setCustomResponse(CustomResponse customResponse) {
        this.customResponse = customResponse;
    }

    public HttpRequest setHttpJsonKey(HttpJsonKey httpJsonKey) {
        this.httpJsonKey = httpJsonKey;
        return this;
    }

    public HttpRequest setLoadingMessage(String str) {
        this.loadingMessage = str;
        return this;
    }

    public HttpRequest setObservable(e<? extends c0<ResponseBody>> eVar) {
        this.observable = eVar;
        return this;
    }

    public HttpRequest setResponseInterceptor(ResponseInterceptor responseInterceptor) {
        this.responseInterceptor = responseInterceptor;
        return this;
    }

    public HttpRequest setShowFailMessage(boolean z5) {
        this.isShowFailMessage = z5;
        return this;
    }

    public HttpRequest setShowLoadingDialog(boolean z5) {
        this.isShowLoadingDialog = z5;
        return this;
    }

    public HttpRequest setShowOtherStatusMessage(boolean z5) {
        this.isShowOtherStatusMessage = z5;
        return this;
    }

    public HttpRequest setShowSuccessMessage(boolean z5) {
        this.isShowSuccessMessage = z5;
        return this;
    }

    public HttpRequest(Context context) {
        this.context = new WeakReference<>(context);
    }

    private String getRequestBody(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField("body");
        } catch (NoSuchFieldException e6) {
            e6.printStackTrace();
            field = null;
        }
        field.setAccessible(true);
        try {
            RequestBody requestBody = (RequestBody) field.get(part);
            MediaType contentType = requestBody.contentType();
            if (contentType.type().equals("multipart")) {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                return buffer.readString(contentType.charset(Charset.forName("UTF-8")));
            }
            if (contentType.type().equals(SocializeProtocolConstants.IMAGE)) {
                return convertFileSize(requestBody.contentLength());
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public HttpRequest setTimeout(long j6, TimeUnit timeUnit) {
        RetrofitManager.getRetrofitManager().setTimeout(j6, timeUnit);
        return this;
    }

    public m setDataListener(final OriginalHttpResponse originalHttpResponse) {
        String str = MessageManager.getMessageManager().isUseEnglishLanguage() ? "Network  unusual" : "网络不可用";
        final String errorMessage = MessageManager.getMessageManager().isUseEnglishLanguage() ? "Network  error" : MessageManager.getMessageManager().getErrorMessage();
        if (!NetworkUtil.isNetworkAvailable(this.context.get())) {
            Toast.makeText(this.context.get(), str, 0).show();
            if (originalHttpResponse != null) {
                originalHttpResponse.netOnFailure(new Exception(str));
                originalHttpResponse.netOnFinish();
            }
            return null;
        }
        if (this.isShowLoadingDialog) {
            if (this.loadingDialog == null) {
                this.loadingDialog = new LoadingDialog(this.context.get());
            }
        } else {
            this.loadingDialog = null;
        }
        m r5 = this.observable.w5(c.e()).I3(a.b()).r5(new l<c0<ResponseBody>>() { // from class: cn.bluemobi.dylan.http.HttpRequest.2
            @Override // rx.f
            public void onCompleted() {
                if (HttpRequest.this.loadingDialog != null) {
                    HttpRequest.this.loadingDialog.dismiss();
                }
                OriginalHttpResponse originalHttpResponse2 = originalHttpResponse;
                if (originalHttpResponse2 != null) {
                    originalHttpResponse2.netOnFinish();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x0088 A[Catch: Exception -> 0x008c, TRY_LEAVE, TryCatch #0 {Exception -> 0x008c, blocks: (B:19:0x0084, B:21:0x0088), top: B:18:0x0084 }] */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            @Override // rx.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onNext(retrofit2.c0<okhttp3.ResponseBody> r8) {
                /*
                    r7 = this;
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this
                    cn.bluemobi.dylan.http.dialog.LoadingDialog r0 = cn.bluemobi.dylan.http.HttpRequest.access$000(r0)
                    if (r0 == 0) goto L11
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this
                    cn.bluemobi.dylan.http.dialog.LoadingDialog r0 = cn.bluemobi.dylan.http.HttpRequest.access$000(r0)
                    r0.dismiss()
                L11:
                    boolean r0 = r8.g()
                    java.lang.String r1 = ""
                    if (r0 != 0) goto L26
                    okhttp3.ResponseBody r0 = r8.e()     // Catch: java.io.IOException -> L23
                    java.lang.String r0 = r0.string()     // Catch: java.io.IOException -> L23
                L21:
                    r5 = r0
                    goto L31
                L23:
                    r0 = move-exception
                    r8 = r0
                    goto L80
                L26:
                    java.lang.Object r0 = r8.a()     // Catch: java.io.IOException -> L23
                    okhttp3.ResponseBody r0 = (okhttp3.ResponseBody) r0     // Catch: java.io.IOException -> L23
                    java.lang.String r0 = r0.string()     // Catch: java.io.IOException -> L23
                    goto L21
                L31:
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this     // Catch: java.io.IOException -> L7d
                    cn.bluemobi.dylan.http.ResponseInterceptor r0 = cn.bluemobi.dylan.http.HttpRequest.access$300(r0)     // Catch: java.io.IOException -> L7d
                    if (r0 == 0) goto L84
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this     // Catch: java.io.IOException -> L7d
                    okhttp3.Response r1 = r8.i()     // Catch: java.io.IOException -> L7d
                    okhttp3.Request r1 = r1.request()     // Catch: java.io.IOException -> L7d
                    java.util.Map r4 = cn.bluemobi.dylan.http.HttpRequest.access$500(r0, r1)     // Catch: java.io.IOException -> L7d
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this     // Catch: java.io.IOException -> L7d
                    cn.bluemobi.dylan.http.ResponseInterceptor r1 = cn.bluemobi.dylan.http.HttpRequest.access$300(r0)     // Catch: java.io.IOException -> L7d
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this     // Catch: java.io.IOException -> L7d
                    java.lang.ref.WeakReference r0 = cn.bluemobi.dylan.http.HttpRequest.access$900(r0)     // Catch: java.io.IOException -> L7d
                    java.lang.Object r0 = r0.get()     // Catch: java.io.IOException -> L7d
                    r2 = r0
                    android.content.Context r2 = (android.content.Context) r2     // Catch: java.io.IOException -> L7d
                    okhttp3.Response r0 = r8.i()     // Catch: java.io.IOException -> L7d
                    okhttp3.Request r0 = r0.request()     // Catch: java.io.IOException -> L7d
                    okhttp3.HttpUrl r0 = r0.url()     // Catch: java.io.IOException -> L7d
                    java.net.URL r0 = r0.url()     // Catch: java.io.IOException -> L7d
                    java.lang.String r3 = r0.toString()     // Catch: java.io.IOException -> L7d
                    okhttp3.Response r8 = r8.i()     // Catch: java.io.IOException -> L7d
                    int r6 = r8.code()     // Catch: java.io.IOException -> L7d
                    boolean r8 = r1.onResponseStart(r2, r3, r4, r5, r6)     // Catch: java.io.IOException -> L7d
                    if (r8 == 0) goto L84
                    goto Lcc
                L7d:
                    r0 = move-exception
                    r8 = r0
                    r1 = r5
                L80:
                    r8.printStackTrace()
                    r5 = r1
                L84:
                    cn.bluemobi.dylan.http.OriginalHttpResponse r8 = r2     // Catch: java.lang.Exception -> L8c
                    if (r8 == 0) goto Lcc
                    r8.netOnSuccess(r5)     // Catch: java.lang.Exception -> L8c
                    goto Lcc
                L8c:
                    r0 = move-exception
                    r8 = r0
                    cn.bluemobi.dylan.http.MessageManager r0 = cn.bluemobi.dylan.http.MessageManager.getMessageManager()
                    cn.bluemobi.dylan.http.MessageManager$MessageModel r0 = r0.getShowMessageModel()
                    cn.bluemobi.dylan.http.MessageManager$MessageModel r1 = cn.bluemobi.dylan.http.MessageManager.MessageModel.NO
                    if (r0 == r1) goto Lb8
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this
                    boolean r0 = cn.bluemobi.dylan.http.HttpRequest.access$400(r0)
                    if (r0 == 0) goto Lb8
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this
                    java.lang.ref.WeakReference r0 = cn.bluemobi.dylan.http.HttpRequest.access$900(r0)
                    java.lang.Object r0 = r0.get()
                    android.content.Context r0 = (android.content.Context) r0
                    java.lang.String r1 = r3
                    r2 = 0
                    android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
                    r0.show()
                Lb8:
                    cn.bluemobi.dylan.http.OriginalHttpResponse r0 = r2
                    if (r0 == 0) goto Lbf
                    r0.netOnFailure(r8)
                Lbf:
                    cn.bluemobi.dylan.http.Http r0 = cn.bluemobi.dylan.http.Http.getHttp()
                    boolean r0 = r0.isDebugMode()
                    if (r0 == 0) goto Lcc
                    r8.printStackTrace()
                Lcc:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.http.HttpRequest.AnonymousClass2.onNext(retrofit2.c0):void");
            }

            @Override // rx.l
            public void onStart() {
                if (HttpRequest.this.loadingDialog != null) {
                    HttpRequest.this.loadingDialog.show(HttpRequest.this.loadingMessage);
                }
                OriginalHttpResponse originalHttpResponse2 = originalHttpResponse;
                if (originalHttpResponse2 != null) {
                    originalHttpResponse2.netOnStart();
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                if (Http.getHttp().isDebugMode()) {
                    th.printStackTrace();
                }
                if (HttpRequest.this.isShowFailMessage) {
                    Toast.makeText((Context) HttpRequest.this.context.get(), errorMessage, 0).show();
                }
                OriginalHttpResponse originalHttpResponse2 = originalHttpResponse;
                if (originalHttpResponse2 != null) {
                    originalHttpResponse2.netOnFailure(th);
                }
                onCompleted();
            }
        });
        if (r5 != null) {
            LoadingDialog loadingDialog = this.loadingDialog;
            if (loadingDialog != null) {
                loadingDialog.setOnKeyListener(new DialogOnKeyListener(loadingDialog, this.canCancel));
                this.loadingDialog.setOnDismissListener(new DialogOnDismissListener(r5));
                return r5;
            }
            addLifeCycle(this.context.get(), r5);
        }
        return r5;
    }
}
