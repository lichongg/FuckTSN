package com.umeng.commonsdk.framework;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kuaishou.weapon.p0.g;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a implements UMImprintChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    private static HandlerThread f41721a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f41722b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f41723c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final int f41724d = 200;

    /* renamed from: e, reason: collision with root package name */
    private static final int f41725e = 273;

    /* renamed from: f, reason: collision with root package name */
    private static final int f41726f = 274;

    /* renamed from: g, reason: collision with root package name */
    private static final int f41727g = 512;

    /* renamed from: h, reason: collision with root package name */
    private static final int f41728h = 769;

    /* renamed from: i, reason: collision with root package name */
    private static FileObserverC0826a f41729i = null;

    /* renamed from: j, reason: collision with root package name */
    private static ConnectivityManager f41730j = null;

    /* renamed from: k, reason: collision with root package name */
    private static IntentFilter f41731k = null;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f41732l = false;

    /* renamed from: m, reason: collision with root package name */
    private static ArrayList<UMSenderStateNotify> f41733m = null;

    /* renamed from: p, reason: collision with root package name */
    private static final String f41736p = "report_policy";

    /* renamed from: q, reason: collision with root package name */
    private static final String f41737q = "report_interval";

    /* renamed from: s, reason: collision with root package name */
    private static final int f41739s = 15;

    /* renamed from: t, reason: collision with root package name */
    private static final int f41740t = 3;

    /* renamed from: u, reason: collision with root package name */
    private static final int f41741u = 90;

    /* renamed from: x, reason: collision with root package name */
    private static BroadcastReceiver f41744x;

    /* renamed from: n, reason: collision with root package name */
    private static Object f41734n = new Object();

    /* renamed from: o, reason: collision with root package name */
    private static ReentrantLock f41735o = new ReentrantLock();

    /* renamed from: r, reason: collision with root package name */
    private static boolean f41738r = false;

    /* renamed from: v, reason: collision with root package name */
    private static int f41742v = 15;

    /* renamed from: w, reason: collision with root package name */
    private static Object f41743w = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.framework.a$a, reason: collision with other inner class name */
    static class FileObserverC0826a extends FileObserver {
        @Override // android.os.FileObserver
        public void onEvent(int i6, String str) {
            if ((i6 & 8) != 8) {
                return;
            }
            ULog.d("--->>> envelope file created >>> " + str);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            a.c(273);
        }

        public FileObserverC0826a(String str) {
            super(str);
        }
    }

    public static int b() {
        int i6;
        synchronized (f41743w) {
            i6 = f41742v;
        }
        return i6;
    }

    public static void c() {
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f41730j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        f41744x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
                }
            }
        };
    }

    public static void a(Context context) {
        if (f41730j != null || context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        f41730j = connectivityManager;
        if (connectivityManager != null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i6) {
        Handler handler;
        if (!f41732l || (handler = f41722b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i6;
        f41722b.sendMessage(obtainMessage);
    }

    public static void d() {
        if (f41735o.tryLock()) {
            try {
                b(273);
            } finally {
                f41735o.unlock();
            }
        }
    }

    public static void e() {
        a(274, 3000);
    }

    private void j() {
        synchronized (f41743w) {
            try {
                if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f41736p, ""))) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    f41738r = true;
                    f41742v = 15;
                    int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f41737q, Constants.VIA_REPORT_TYPE_WPA_STATE)).intValue();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                    if (intValue >= 3 && intValue <= 90) {
                        f41742v = intValue * 1000;
                    }
                    f41742v = 15;
                } else {
                    f41738r = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void k() {
        if (f41721a != null) {
            f41721a = null;
        }
        if (f41722b != null) {
            f41722b = null;
        }
        if (f41723c != null) {
            f41723c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        int size;
        synchronized (f41734n) {
            try {
                ArrayList<UMSenderStateNotify> arrayList = f41733m;
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    for (int i6 = 0; i6 < size; i6++) {
                        f41733m.get(i6).onSenderIdle();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (f41732l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (!new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.d("--->>> Send envelope file success, delete it.");
                        if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                            ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                            UMFrUtils.removeEnvelopeFile(envelopeFile);
                        }
                        c(273);
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (f41743w) {
            try {
                if (f41736p.equals(str)) {
                    if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                        f41738r = true;
                    } else {
                        f41738r = false;
                    }
                }
                if (f41737q.equals(str)) {
                    int intValue = Integer.valueOf(str2).intValue();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                    if (intValue >= 3 && intValue <= 90) {
                        f41742v = intValue * 1000;
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f41742v);
                    }
                    f41742v = 15000;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f41742v);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public a(Context context, Handler handler) {
        if (f41730j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f41730j != null) {
                f41730j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f41723c = handler;
        try {
            if (f41721a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                f41721a = handlerThread;
                handlerThread.start();
                if (f41729i == null) {
                    FileObserverC0826a fileObserverC0826a = new FileObserverC0826a(UMFrUtils.getEnvelopeDirPath(context));
                    f41729i = fileObserverC0826a;
                    fileObserverC0826a.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (f41722b == null) {
                    f41722b = new Handler(f41721a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.3
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i6 = message.what;
                            if (i6 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.f41735o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.n();
                                    } catch (Throwable unused) {
                                    }
                                    a.f41735o.unlock();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (i6 == 274) {
                                a.l();
                            } else {
                                if (i6 != 512) {
                                    return;
                                }
                                a.m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(f41736p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(f41737q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void b(Context context) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> registerNetReceiver: context is null, registerNetReceiver failed.");
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (DeviceConfig.checkPermission(context, g.f36042b)) {
                NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
                if (f41730j != null) {
                    final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerNetworkCallback");
                    f41730j.registerNetworkCallback(build, new ConnectivityManager.NetworkCallback() { // from class: com.umeng.commonsdk.framework.a.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            Context context2 = origApplicationContext;
                            UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.E, b.a(context2).a(), null);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onLost");
                            Context context2 = origApplicationContext;
                            UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.E, b.a(context2).a(), null, 2000L);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                            super.onCapabilitiesChanged(network, networkCapabilities);
                        }
                    });
                    return;
                }
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
            return;
        }
        if (DeviceConfig.checkPermission(context, g.f36042b)) {
            if (f41730j == null || f41731k != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            f41731k = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (f41744x != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerReceiver");
                context.registerReceiver(f41744x, f41731k);
                return;
            }
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (f41734n) {
            try {
                if (f41733m == null) {
                    f41733m = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i6 = 0; i6 < f41733m.size(); i6++) {
                        if (uMSenderStateNotify == f41733m.get(i6)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    f41733m.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    public static boolean a() {
        boolean z5;
        synchronized (f41743w) {
            z5 = f41738r;
        }
        return z5;
    }

    public static void a(boolean z5) {
        int size;
        f41732l = z5;
        if (z5) {
            synchronized (f41734n) {
                try {
                    ArrayList<UMSenderStateNotify> arrayList = f41733m;
                    if (arrayList != null && (size = arrayList.size()) > 0) {
                        for (int i6 = 0; i6 < size; i6++) {
                            f41733m.get(i6).onConnectionAvailable();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        f41732l = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
    }

    private static void b(int i6) {
        Handler handler;
        if (!f41732l || (handler = f41722b) == null || handler.hasMessages(i6)) {
            return;
        }
        Message obtainMessage = f41722b.obtainMessage();
        obtainMessage.what = i6;
        f41722b.sendMessage(obtainMessage);
    }

    private static void a(int i6, long j6) {
        Handler handler;
        if (!f41732l || (handler = f41722b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i6;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j6);
        f41722b.sendMessageDelayed(obtainMessage, j6);
    }

    private static void a(int i6, int i7) {
        Handler handler;
        if (!f41732l || (handler = f41722b) == null) {
            return;
        }
        handler.removeMessages(i6);
        Message obtainMessage = f41722b.obtainMessage();
        obtainMessage.what = i6;
        f41722b.sendMessageDelayed(obtainMessage, i7);
    }
}
