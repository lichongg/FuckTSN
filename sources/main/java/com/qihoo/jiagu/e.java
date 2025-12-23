package com.qihoo.jiagu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.Base64;
import com.kuaishou.weapon.p0.g;
import com.qihoo.bugreport.CrashReport;
import com.qihoo.bugreport.javacrash.ExceptionHandleReporter;
import com.qihoo.bugreport.javacrash.ReportField;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class e extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ boolean f36538a;

    /* renamed from: b, reason: collision with root package name */
    private /* synthetic */ JSONObject f36539b;

    /* renamed from: c, reason: collision with root package name */
    private /* synthetic */ ExceptionHandleReporter f36540c;

    public e(ExceptionHandleReporter exceptionHandleReporter, boolean z5, JSONObject jSONObject) {
        this.f36540c = exceptionHandleReporter;
        this.f36538a = z5;
        this.f36539b = jSONObject;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Context context;
        boolean z5;
        boolean z6;
        String str;
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Context context2;
        try {
            context = this.f36540c.f36521c;
            if (c.a(context, g.f36042b)) {
                z5 = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
            } else {
                z5 = false;
            }
            if (this.f36538a) {
                z6 = false;
            } else {
                context2 = this.f36540c.f36521c;
                z6 = c.c(context2, "opentestCrashCollect");
            }
            if (z5 || z6) {
                new d();
                JSONObject jSONObject = this.f36539b;
                if (jSONObject == null) {
                    return;
                }
                String jSONObject2 = jSONObject.toString();
                if (jSONObject2.length() == 0 || Build.VERSION.SDK_INT < 8) {
                    return;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(jSONObject2.getBytes());
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byte[] bArr = new byte[16];
                new Random().nextBytes(bArr);
                Cipher cipher = Cipher.getInstance("RC4");
                cipher.init(1, new SecretKeySpec(bArr, "RC4"));
                byte[] update = cipher.update(byteArray);
                byte[] bArr2 = new byte[update.length + 16 + 4];
                System.arraycopy(new byte[]{(byte) 16, (byte) 0, (byte) 0, (byte) 0}, 0, bArr2, 0, 4);
                System.arraycopy(bArr, 0, bArr2, 4, 16);
                System.arraycopy(update, 0, bArr2, 20, update.length);
                String encodeToString = Base64.encodeToString(bArr2, 0);
                String encode = URLEncoder.encode(encodeToString, "UTF-8");
                String a6 = c.a(encode.getBytes());
                if (a6 == null) {
                    str = null;
                } else {
                    byte[] bytes = a6.getBytes();
                    byte[] bArr3 = new byte[16];
                    byte[] bArr4 = new byte[48];
                    new Random().nextBytes(bArr3);
                    byte[] bytes2 = c.a(bArr3).getBytes();
                    System.arraycopy(bytes, 16, bArr4, 0, 16);
                    System.arraycopy(bytes2, 0, bArr4, 16, 16);
                    System.arraycopy(bytes, 0, bArr4, 32, 16);
                    str = new String(bArr4);
                }
                if (z5) {
                    new c();
                    HttpPost httpPost = new HttpPost(b.a());
                    httpPost.addHeader("User-Agent", "Android");
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("cpv", "3");
                    BasicHttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, b.b());
                    HttpConnectionParams.setSoTimeout(basicHttpParams, b.c());
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                    ArrayList arrayList = new ArrayList(2);
                    arrayList.add(new BasicNameValuePair("c", encodeToString));
                    arrayList.add(new BasicNameValuePair("x", str));
                    boolean c6 = c.c(CrashReport.a(), "jg_qihoo_test_file");
                    if (c6) {
                        f.a("CRASH_REPORT", "crash_data:" + encodeToString);
                    }
                    try {
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
                    } catch (UnsupportedEncodingException e6) {
                    }
                    try {
                        HttpResponse execute = defaultHttpClient.execute(httpPost);
                        execute.getStatusLine().getStatusCode();
                        if (c6) {
                            f.a("CRASH_REPORT", "response_code:" + execute.getStatusLine().getStatusCode());
                        }
                    } catch (IOException e7) {
                    }
                }
                if (!z6 || jSONObject == null || encode == null || str == null) {
                    return;
                }
                try {
                    if (!jSONObject.has(ReportField.ct.name())) {
                        return;
                    }
                    File file = new File(CrashReport.a().getFilesDir().getAbsolutePath() + "/crashCollect");
                    if (!file.exists() && !file.isDirectory()) {
                        file.mkdirs();
                        d.a("chmod 777 " + file.getAbsolutePath());
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("cpv=3").append("&c=").append(encode).append("&x=").append(str);
                    synchronized (d.class) {
                        try {
                            File file2 = new File(file + "/" + String.valueOf(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).parse(jSONObject.getString(ReportField.ct.name())).getTime()));
                            try {
                                fileOutputStream2 = new FileOutputStream(file2);
                            } catch (Exception e8) {
                                fileOutputStream2 = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                            try {
                                fileOutputStream2.write(stringBuffer.toString().getBytes());
                                fileOutputStream2.flush();
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e9) {
                                }
                                d.a("chmod 777 " + file2.getAbsolutePath());
                            } catch (Exception e10) {
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e11) {
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (IOException e12) {
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e13) {
                        }
                    }
                } catch (Throwable th4) {
                }
            }
        } catch (Throwable th5) {
        }
    }
}
