package com.umeng.commonsdk.stateless;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f41852a = 273;

    /* renamed from: b, reason: collision with root package name */
    private static Context f41853b = null;

    /* renamed from: c, reason: collision with root package name */
    private static HandlerThread f41854c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Handler f41855d = null;

    /* renamed from: f, reason: collision with root package name */
    private static final int f41857f = 274;

    /* renamed from: g, reason: collision with root package name */
    private static final int f41858g = 275;

    /* renamed from: h, reason: collision with root package name */
    private static final int f41859h = 512;

    /* renamed from: i, reason: collision with root package name */
    private static a f41860i;

    /* renamed from: j, reason: collision with root package name */
    private static IntentFilter f41861j;

    /* renamed from: k, reason: collision with root package name */
    private static volatile boolean f41862k;

    /* renamed from: e, reason: collision with root package name */
    private static Object f41856e = new Object();

    /* renamed from: l, reason: collision with root package name */
    private static LinkedList<String> f41863l = new LinkedList<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends FileObserver {
        @Override // android.os.FileObserver
        public void onEvent(int i6, String str) {
            if ((i6 & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(274);
        }

        public a(String str) {
            super(str);
        }
    }

    public static void a(boolean z5) {
        f41862k = z5;
        if (!z5) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(274);
        }
    }

    public static void b(int i6) {
        Handler handler;
        try {
            if (!f41862k || (handler = f41855d) == null || handler.hasMessages(i6)) {
                return;
            }
            Message obtainMessage = f41855d.obtainMessage();
            obtainMessage.what = i6;
            f41855d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f41853b, th);
        }
    }

    private static String j() {
        try {
            String peek = f41863l.peek();
            if (peek == null) {
                return peek;
            }
            try {
                f41863l.removeFirst();
                return peek;
            } catch (Throwable unused) {
                return peek;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void c() {
        b(275);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] c6 = d.c(f41853b);
        if (c6 != null) {
            if (f41863l.size() > 0) {
                f41863l.clear();
            }
            for (File file : c6) {
                f41863l.add(file.getAbsolutePath());
            }
        }
    }

    @TargetApi(9)
    private static void k() {
        String pollFirst;
        byte[] bArr;
        if (f41863l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = f41863l.pollFirst();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (file.exists()) {
                    c cVar = new c(f41853b);
                    try {
                        bArr = d.a(pollFirst);
                    } catch (Exception unused) {
                        bArr = null;
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String c6 = d.c(d.d(name));
                    if (cVar.a(bArr, c6, com.umeng.commonsdk.vchannel.a.f42140c.equalsIgnoreCase(c6) ? com.umeng.commonsdk.vchannel.a.f42138a : "", substring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (pollFirst != null);
        f41863l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        File a6;
        byte[] bArr;
        if (!f41862k || f41853b == null) {
            return;
        }
        do {
            try {
                a6 = d.a(f41853b);
                if (a6 != null && a6.getParentFile() != null && !TextUtils.isEmpty(a6.getParentFile().getName())) {
                    c cVar = new c(f41853b);
                    String str = new String(Base64.decode(a6.getParentFile().getName(), 0));
                    if (!com.umeng.commonsdk.internal.a.f41747a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.f41748b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.H.equalsIgnoreCase(str)) {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        try {
                            bArr = d.a(a6.getAbsolutePath());
                        } catch (Exception unused) {
                            bArr = null;
                        }
                        String str2 = com.umeng.commonsdk.vchannel.a.f42140c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.f42138a : "";
                        String str3 = UMServerURL.PATH_SHARE.equalsIgnoreCase(str) ? "s" : "u";
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str3 = "p";
                        }
                        if (!cVar.a(bArr, str, str2, str3)) {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                        File file = new File(a6.getAbsolutePath());
                        if (!file.delete()) {
                            ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                            file.delete();
                        }
                    }
                    new File(a6.getAbsolutePath()).delete();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f41853b, th);
            }
        } while (a6 != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(f41853b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f41845e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!f41862k || f41853b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(f41853b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f41845e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable unused) {
        }
    }

    public b(Context context) {
        synchronized (f41856e) {
            try {
                if (context != null) {
                    try {
                        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                        f41853b = origApplicationContext;
                        if (origApplicationContext != null && f41854c == null) {
                            HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                            f41854c = handlerThread;
                            handlerThread.start();
                            if (f41860i == null) {
                                String str = f41853b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f41846f;
                                File file = new File(str);
                                if (!file.exists()) {
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                    file.mkdir();
                                }
                                a aVar = new a(str);
                                f41860i = aVar;
                                aVar.startWatching();
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                            }
                            if (f41855d == null) {
                                f41855d = new Handler(f41854c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                    @Override // android.os.Handler
                                    public void handleMessage(Message message) {
                                        int i6 = message.what;
                                        if (i6 != 512) {
                                            switch (i6) {
                                                case 273:
                                                    b.l();
                                                    return;
                                                case 274:
                                                    b.n();
                                                    return;
                                                case 275:
                                                    b.p();
                                                    break;
                                                default:
                                                    return;
                                            }
                                        }
                                        b.q();
                                    }
                                };
                            }
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    public static boolean a() {
        synchronized (f41856e) {
            try {
                return f41860i != null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(274);
    }

    public static void a(int i6) {
        Handler handler;
        if (!f41862k || (handler = f41855d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i6;
        f41855d.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }
}
