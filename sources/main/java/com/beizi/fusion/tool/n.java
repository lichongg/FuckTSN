package com.beizi.fusion.tool;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.bn;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.ResponseInfo;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.stub.StubApp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private static n f13729a = new n();

    /* renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f13730b;

    /* renamed from: c, reason: collision with root package name */
    private Context f13731c;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String obj = stringWriter.toString();
        a(obj);
        b(obj);
    }

    public static n a() {
        return f13729a;
    }

    private n() {
    }

    public void a(Context context) {
        this.f13730b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f13731c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            a(th);
        } catch (Exception e6) {
            e6.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f13730b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    private void a(String str) {
        String a6;
        String a7;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("appId", com.beizi.fusion.c.b.a().b());
            jSONObject.put(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, this.f13731c.getPackageName());
            jSONObject.put("versionName", ap.d(this.f13731c));
            jSONObject.put("versionCode", String.valueOf(ap.e(this.f13731c)));
            jSONObject.put("sdkVersion", "5.2.1.20");
            jSONObject2.put("osVersion", Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT);
            jSONObject2.put("vendor", Build.MANUFACTURER);
            jSONObject2.put(bn.f10753i, Build.MODEL);
            jSONObject.put(ConstantHelper.LOG_DE, jSONObject2);
            jSONObject.put("crashMessage", str);
            if (!TextUtils.isEmpty(ResponseInfo.getInstance(this.f13731c).getCrashUrl()) && ResponseInfo.getInstance(this.f13731c).getCrashUrl().startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                a6 = ResponseInfo.getInstance(this.f13731c).getCrashUrl();
            } else {
                a6 = d.a(BeiZis.getTransferProtocol() ? "aHR0cHM6Ly9hcGktaHRwLmJlaXppLmJpei9tYi9zZGsvY3Jhc2gvdjE=" : "aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAwL21iL3Nkay9jcmFzaC92MQ==");
                if (TextUtils.isEmpty(a6)) {
                    return;
                }
            }
            if (TextUtils.isEmpty(a6) || (a7 = v.a(a6, jSONObject.toString().getBytes())) == null) {
                return;
            }
            aa.a("lance", "post:" + a7);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void b(String str) {
        Context context;
        try {
            context = this.f13731c;
        } catch (Exception unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            return;
        }
        File a6 = g.a(context);
        aa.a("BeiZis", "CrashHandler storagePath == " + a6);
        if (a6 != null) {
            String str2 = a6.getPath() + "/Beizi/log/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            String format = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date(System.currentTimeMillis()));
            File file2 = new File(str2 + "crash_" + format + ".trace");
            file2.createNewFile();
            FileWriter fileWriter = new FileWriter(file2, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(format);
            bufferedWriter.write(org.apache.commons.net.g.f50795q);
            bufferedWriter.write("------------------crash----------------------");
            bufferedWriter.write(org.apache.commons.net.g.f50795q);
            bufferedWriter.write(str);
            bufferedWriter.write(org.apache.commons.net.g.f50795q);
            bufferedWriter.write("-------------------end-----------------------");
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }
        aa.a("lance", "writeLog ok");
    }

    private boolean a(final Throwable th) {
        if (th == null) {
            return false;
        }
        new Thread(new Runnable() { // from class: com.beizi.fusion.tool.n.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                n.this.b(th);
                Looper.loop();
            }
        }).start();
        try {
            Thread.sleep(1000L);
            return true;
        } catch (InterruptedException e6) {
            e6.printStackTrace();
            return true;
        }
    }
}
