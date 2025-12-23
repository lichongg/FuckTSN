package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f41972e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f41973f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f41974g;

    /* renamed from: a, reason: collision with root package name */
    private String f41975a = "10.0.0.172";

    /* renamed from: b, reason: collision with root package name */
    private int f41976b = 80;

    /* renamed from: c, reason: collision with root package name */
    private Context f41977c;

    /* renamed from: d, reason: collision with root package name */
    private b f41978d;

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f41977c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f41977c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        String imprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f41977c, "oversea_domain_p", "");
        String imprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f41977c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty3);
        }
        if (!TextUtils.isEmpty(imprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f41875b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f41875b.startsWith("460") || com.umeng.commonsdk.statistics.b.f41875b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (f41974g) {
            return;
        }
        ImprintHandler.getImprintService(this.f41977c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManager.b()) {
                    FieldManager.a().a(c.this.f41977c, str2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                    UMWorkDispatch.sendEvent(c.this.f41977c, com.umeng.commonsdk.internal.a.f41769w, com.umeng.commonsdk.internal.b.a(c.this.f41977c).a(), null);
                }
            }
        });
        f41974g = true;
    }

    private void d() {
        if (f41973f) {
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        ImprintHandler.getImprintService(this.f41977c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f41977c);
                UMWorkDispatch.sendEvent(c.this.f41977c, com.umeng.commonsdk.internal.a.f41765s, com.umeng.commonsdk.internal.b.a(c.this.f41977c).a(), null);
                ImprintHandler.getImprintService(c.this.f41977c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                return true;
            }
        });
        ImprintHandler.getImprintService(this.f41977c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f41977c, str2);
                UMWorkDispatch.sendEvent(c.this.f41977c, com.umeng.commonsdk.internal.a.f41765s, com.umeng.commonsdk.internal.b.a(c.this.f41977c).a(), null);
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                    if (!UMWorkDispatch.eventHasExist()) {
                        UMWorkDispatch.sendEventEx(c.this.f41977c, o.a.E, CoreProtocol.getInstance(c.this.f41977c), null, 0L);
                    }
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                    l.a(c.this.f41977c).b(c.this.f41977c);
                }
                ImprintHandler.getImprintService(c.this.f41977c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
            }
        });
        f41973f = true;
    }

    public void a(b bVar) {
        this.f41978d = bVar;
    }

    public c(Context context) {
        this.f41977c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f41977c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f41977c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    public byte[] a(byte[] bArr, boolean z5, boolean z6, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        byte[] bArr2 = null;
        int i6 = 0;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i6 >= strArr.length) {
                return bArr2;
            }
            String str2 = strArr[i6];
            if (z6) {
                d();
            } else {
                c();
            }
            bArr2 = a(bArr, str2 + File.separator + str);
            if (bArr2 != null) {
                b bVar = this.f41978d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z5);
                }
                return bArr2;
            }
            b bVar2 = this.f41978d;
            if (bVar2 != null) {
                bVar2.onRequestFailed();
            }
            i6++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0178: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:107:0x0184, block:B:106:0x0178 */
    public byte[] a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        try {
            try {
                b bVar = this.f41978d;
                if (bVar != null) {
                    bVar.onRequestStart();
                }
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    boolean z5 = true;
                    if (!f41972e) {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance(org.apache.commons.net.imap.b.Q);
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        f41972e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", a.a(this.f41977c).b());
                    httpsURLConnection.setRequestProperty("Content-Type", a.a(this.f41977c).a());
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection.setRequestProperty("SM-IMP", "1");
                    httpsURLConnection.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                    httpsURLConnection.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                    httpsURLConnection.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                    try {
                        outputStream.write(bArr);
                        outputStream.flush();
                        httpsURLConnection.connect();
                        b bVar2 = this.f41978d;
                        if (bVar2 != null) {
                            bVar2.onRequestEnd();
                        }
                        int responseCode = httpsURLConnection.getResponseCode();
                        String headerField = httpsURLConnection.getHeaderField("Content-Type");
                        if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                            z5 = false;
                        }
                        boolean z6 = AnalyticsConstants.UM_DEBUG;
                        if (responseCode == 200 && z5) {
                            InputStream inputStream = httpsURLConnection.getInputStream();
                            try {
                                byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                                try {
                                    outputStream.close();
                                } catch (Exception e6) {
                                    UMCrashManager.reportCrash(this.f41977c, e6);
                                }
                                try {
                                    httpsURLConnection.getInputStream().close();
                                } catch (IOException unused) {
                                }
                                httpsURLConnection.disconnect();
                                return readStreamToByteArray;
                            } finally {
                                HelperUtils.safeClose(inputStream);
                            }
                        }
                        try {
                            outputStream.close();
                        } catch (Exception e7) {
                            UMCrashManager.reportCrash(this.f41977c, e7);
                        }
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused2) {
                        }
                        httpsURLConnection.disconnect();
                        return null;
                    } catch (UnknownHostException unused3) {
                        UMLog.aq("A_10200", 2, "\\|");
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e8) {
                                UMCrashManager.reportCrash(this.f41977c, e8);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused4) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    } catch (SSLHandshakeException unused5) {
                        UMLog.aq("A_10201", 2, "\\|");
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e9) {
                                UMCrashManager.reportCrash(this.f41977c, e9);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused6) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    } catch (Throwable unused7) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e10) {
                                UMCrashManager.reportCrash(this.f41977c, e10);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused8) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    }
                } catch (UnknownHostException unused9) {
                    outputStream = null;
                } catch (SSLHandshakeException unused10) {
                    outputStream = null;
                } catch (Throwable unused11) {
                    outputStream = null;
                }
            } catch (UnknownHostException unused12) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (SSLHandshakeException unused13) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (Throwable unused14) {
                httpsURLConnection = null;
                outputStream = null;
            }
        } catch (Throwable th) {
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Exception e11) {
                    UMCrashManager.reportCrash(this.f41977c, e11);
                }
            }
            if (str != 0) {
                try {
                    str.getInputStream().close();
                } catch (IOException unused15) {
                }
                str.disconnect();
                throw th;
            }
            throw th;
        }
    }
}
