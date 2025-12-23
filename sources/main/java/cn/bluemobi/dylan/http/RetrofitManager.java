package cn.bluemobi.dylan.http;

import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.huawei.hms.feature.dynamic.f.e;
import com.huawei.hms.framework.common.ContainerUtils;
import com.orhanobut.logger.j;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.apache.commons.net.imap.b;
import retrofit2.adapter.rxjava.h;
import retrofit2.d0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RetrofitManager {
    private static volatile RetrofitManager singleton;
    private Object apiService;
    private long currentTimeout;
    private TimeUnit currentTimeoutUnit;
    private TimeUnit defaultTimeoutUnit;
    private SSLSocketFactory factory;
    private OkHttpClient mOkHttpClient;
    private OkHttpClient.Builder okhttpBuilder;
    private boolean overlockCard;
    private d0 retrofit;
    private d0.b retrofitBuilder;
    private String secret;
    String TAG = "Http";
    private final int TIMEOUT = 15;
    private boolean debugMode = true;
    private List<Interceptor> interceptorList = new ArrayList();
    private long defaultTimeout = 30;

    public static String convertFileSize(long j6) {
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

    private SSLSocketFactory setCertificates(InputStream... inputStreamArr) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(e.f33254b);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int length = inputStreamArr.length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                InputStream inputStream = inputStreamArr[i6];
                int i8 = i7 + 1;
                keyStore.setCertificateEntry(Integer.toString(i7), certificateFactory.generateCertificate(inputStream));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                i6++;
                i7 = i8;
            }
            SSLContext sSLContext = SSLContext.getInstance(b.Q);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public <T> T getApiService(Class<T> cls) {
        long j6 = this.defaultTimeout;
        long j7 = this.currentTimeout;
        if (j6 == j7 && this.currentTimeoutUnit == this.defaultTimeoutUnit) {
            return (T) this.retrofit.g(cls);
        }
        this.okhttpBuilder.readTimeout(j7, this.currentTimeoutUnit).connectTimeout(this.currentTimeout, this.currentTimeoutUnit).writeTimeout(this.currentTimeout, this.currentTimeoutUnit);
        d0 f6 = this.retrofitBuilder.j(this.okhttpBuilder.build()).f();
        this.retrofit = f6;
        T t5 = (T) f6.g(cls);
        this.okhttpBuilder.readTimeout(this.defaultTimeout, this.defaultTimeoutUnit).connectTimeout(this.defaultTimeout, this.defaultTimeoutUnit).writeTimeout(this.defaultTimeout, this.defaultTimeoutUnit);
        this.retrofit = this.retrofitBuilder.j(this.okhttpBuilder.build()).f();
        this.currentTimeout = this.defaultTimeout;
        this.currentTimeoutUnit = this.defaultTimeoutUnit;
        return t5;
    }

    public static String formatDuring(long j6) {
        if (j6 < 1000) {
            return j6 + "ms";
        }
        if (j6 < 60000) {
            return ((j6 % 60000) / 1000) + "s";
        }
        return ((j6 % 3600000) / 60000) + "min";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPartHeaders(MultipartBody.Part part) {
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

    public static RetrofitManager getRetrofitManager() {
        if (singleton == null) {
            synchronized (RetrofitManager.class) {
                try {
                    if (singleton == null) {
                        singleton = new RetrofitManager();
                    }
                } finally {
                }
            }
        }
        return singleton;
    }

    private SSLContext overlockCard() {
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: cn.bluemobi.dylan.http.RetrofitManager.5
            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }
        }};
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            return sSLContext;
        } catch (Exception unused) {
            return null;
        }
    }

    public void addInterceptor(Interceptor interceptor) {
        this.interceptorList.add(interceptor);
    }

    public void changeBaseUrl(String str) {
        this.retrofit = this.retrofitBuilder.c(str).f();
    }

    public <T> void initRetrofit(Class<T> cls, String str) {
        this.mOkHttpClient = new OkHttpClient();
        Interceptor interceptor = new Interceptor() { // from class: cn.bluemobi.dylan.http.RetrofitManager.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder newBuilder = request.newBuilder();
                if (request.body() instanceof FormBody) {
                    FormBody.Builder builder = new FormBody.Builder();
                    FormBody formBody = (FormBody) request.body();
                    String str2 = "";
                    String str3 = "";
                    for (int i6 = 0; i6 < formBody.size(); i6++) {
                        String encodedName = formBody.encodedName(i6);
                        String encodedValue = formBody.encodedValue(i6);
                        if (Constants.JumpUrlConstants.SRC_TYPE_APP.equals(encodedName)) {
                            str2 = encodedValue;
                        } else if ("class".equals(encodedName)) {
                            str3 = encodedValue;
                        }
                        builder.addEncoded(encodedName, encodedValue);
                    }
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(RetrofitManager.this.secret)) {
                        builder.add("sign", MD5Utils.md5(str2 + str3 + RetrofitManager.this.secret));
                        newBuilder.method(request.method(), builder.build());
                    }
                }
                return chain.proceed(newBuilder.build());
            }
        };
        Interceptor interceptor2 = new Interceptor() { // from class: cn.bluemobi.dylan.http.RetrofitManager.2
            private StringBuilder mMessage = new StringBuilder();

            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                this.mMessage.setLength(0);
                Request request = chain.request();
                this.mMessage.append("请求地址：");
                this.mMessage.append(request.url());
                this.mMessage.append(com.snail.antifake.deviceid.e.f37542d);
                Response proceed = chain.proceed(request.newBuilder().build());
                if ("POST".equals(request.method())) {
                    this.mMessage.append("请求参数：");
                    addRequestParement(request);
                    this.mMessage.append(com.snail.antifake.deviceid.e.f37542d);
                    this.mMessage.append("请求大小：");
                    if (request.body() != null) {
                        this.mMessage.append(RetrofitManager.convertFileSize(request.body().contentLength()));
                    }
                    j.c(this.mMessage.toString());
                    this.mMessage.setLength(0);
                    this.mMessage.append("响应地址：");
                    this.mMessage.append(proceed.request().url());
                    this.mMessage.append(com.snail.antifake.deviceid.e.f37542d);
                    this.mMessage.append("响应参数：");
                    addRequestParement(proceed.request());
                    this.mMessage.append(com.snail.antifake.deviceid.e.f37542d);
                }
                this.mMessage.append("响应耗时：");
                this.mMessage.append(RetrofitManager.formatDuring(proceed.receivedResponseAtMillis() - proceed.sentRequestAtMillis()));
                this.mMessage.append(com.snail.antifake.deviceid.e.f37542d);
                String string = proceed.body().string();
                Response build = proceed.newBuilder().body(ResponseBody.create(proceed.body().contentType(), string)).build();
                this.mMessage.append("响应大小：");
                if (request.body() != null) {
                    this.mMessage.append(RetrofitManager.convertFileSize(build.body().contentLength()));
                }
                this.mMessage.append(com.snail.antifake.deviceid.e.f37542d);
                this.mMessage.append("响应数据：");
                this.mMessage.append(com.snail.antifake.deviceid.e.f37542d);
                this.mMessage.append(JsonParse.formatJson(EncodeUtils.ascii2native(string)));
                j.c(this.mMessage.toString());
                return build;
            }

            private void addRequestParement(Request request) {
                String str2;
                if (request.body() instanceof FormBody) {
                    FormBody formBody = (FormBody) request.body();
                    for (int i6 = 0; i6 < formBody.size(); i6++) {
                        String encodedName = formBody.encodedName(i6);
                        String value = formBody.value(i6);
                        if (this.mMessage.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) != -1) {
                            this.mMessage.append(com.snail.antifake.deviceid.e.f37542d);
                            this.mMessage.append("\u3000\u3000\u3000\u3000\u3000");
                        }
                        this.mMessage.append(encodedName);
                        this.mMessage.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        this.mMessage.append(value);
                    }
                    return;
                }
                if (request.body() instanceof MultipartBody) {
                    for (MultipartBody.Part part : ((MultipartBody) request.body()).parts()) {
                        String partHeaders = RetrofitManager.this.getPartHeaders(part);
                        try {
                            str2 = URLDecoder.decode(RetrofitManager.this.getRequestBody(part).replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
                        } catch (UnsupportedEncodingException e6) {
                            e6.printStackTrace();
                            str2 = null;
                        }
                        if (this.mMessage.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) != -1) {
                            this.mMessage.append(com.snail.antifake.deviceid.e.f37542d);
                            this.mMessage.append("\u3000\u3000\u3000\u3000\u3000");
                        }
                        this.mMessage.append(partHeaders);
                        this.mMessage.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        this.mMessage.append(str2);
                    }
                }
            }
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.okhttpBuilder = builder;
        builder.readTimeout(this.defaultTimeout, this.defaultTimeoutUnit).connectTimeout(this.defaultTimeout, this.defaultTimeoutUnit).writeTimeout(this.defaultTimeout, this.defaultTimeoutUnit);
        Iterator<Interceptor> it = this.interceptorList.iterator();
        while (it.hasNext()) {
            this.okhttpBuilder.addInterceptor(it.next());
        }
        this.okhttpBuilder.addInterceptor(interceptor);
        if (this.debugMode) {
            this.okhttpBuilder.addInterceptor(interceptor2);
        }
        try {
            if (Build.VERSION.SDK_INT > 21) {
                X509TrustManager x509TrustManager = new X509TrustManager() { // from class: cn.bluemobi.dylan.http.RetrofitManager.3
                    @Override // javax.net.ssl.X509TrustManager
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str2) throws CertificateException {
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str2) throws CertificateException {
                    }
                };
                SSLContext sSLContext = SSLContext.getInstance("SSL");
                sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
                SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                if (this.overlockCard) {
                    this.okhttpBuilder.sslSocketFactory(socketFactory, x509TrustManager).hostnameVerifier(new HostnameVerifier() { // from class: cn.bluemobi.dylan.http.RetrofitManager.4
                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str2, SSLSession sSLSession) {
                            return true;
                        }
                    });
                } else {
                    SSLSocketFactory sSLSocketFactory = this.factory;
                    if (sSLSocketFactory != null) {
                        this.okhttpBuilder.sslSocketFactory(sSLSocketFactory, x509TrustManager);
                    }
                }
            }
        } catch (KeyManagementException e6) {
            e6.printStackTrace();
        } catch (NoSuchAlgorithmException e7) {
            e7.printStackTrace();
        }
        this.mOkHttpClient = this.okhttpBuilder.build();
        d0.b bVar = new d0.b();
        this.retrofitBuilder = bVar;
        d0 f6 = bVar.c(str).a(h.d()).j(this.mOkHttpClient).f();
        this.retrofit = f6;
        this.apiService = f6.g(cls);
    }

    public void setDebugMode(boolean z5) {
        this.debugMode = z5;
    }

    public void setDefaultTimeout(long j6, TimeUnit timeUnit) {
        this.defaultTimeout = j6;
        this.defaultTimeoutUnit = timeUnit;
        if (this.retrofitBuilder != null) {
            this.okhttpBuilder.readTimeout(j6, timeUnit).connectTimeout(this.defaultTimeout, this.defaultTimeoutUnit).writeTimeout(this.defaultTimeout, this.defaultTimeoutUnit);
            this.retrofit = this.retrofitBuilder.j(this.okhttpBuilder.build()).f();
        }
    }

    public void setOverlockCard(boolean z5) {
        this.overlockCard = z5;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public void setTimeout(long j6, TimeUnit timeUnit) {
        this.currentTimeout = j6;
        this.currentTimeoutUnit = timeUnit;
    }

    private RetrofitManager() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.defaultTimeoutUnit = timeUnit;
        this.currentTimeout = 30L;
        this.currentTimeoutUnit = timeUnit;
        this.overlockCard = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getRequestBody(MultipartBody.Part part) {
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

    public void setSSLSocketFactory(InputStream... inputStreamArr) {
        this.factory = setCertificates(inputStreamArr);
    }

    public <T> T getApiService() {
        return (T) this.apiService;
    }
}
