package com.baidu.liantian.push;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Pair;
import com.baidu.liantian.ac.Callback;
import com.baidu.liantian.b;
import com.baidu.liantian.b.e;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.d;
import com.baidu.liantian.core.g;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LiantianPushConnService extends Service {
    private static final int ERROR_CODE_KILL = 2;
    public static final String PUSH_SERVICE_ACTION = "com.baidu.liantian.push.service.action";
    private static int sPushPluginId = -1;
    private d mFha;
    private String mPushPluginVersion = "";
    private Callback dataServerCallback = new Callback() { // from class: com.baidu.liantian.push.LiantianPushConnService.2
        @Override // com.baidu.liantian.ac.Callback
        public final Object onError(Object... objArr) {
            try {
                int intValue = ((Integer) objArr[0]).intValue();
                b.a();
                if (intValue != 2) {
                    return null;
                }
                LiantianPushConnService.this.reportKillSelf(4);
                LiantianPushConnService.this.stopSelf();
                return null;
            } catch (Throwable unused) {
                e.a();
                return null;
            }
        }

        @Override // com.baidu.liantian.ac.Callback
        public final Object onProgress1(Object... objArr) {
            return null;
        }
    };
    private IBinder mBinder = new Binder() { // from class: com.baidu.liantian.push.LiantianPushConnService.3
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Integer, Object> startDataServer(int i6) {
        try {
            Pair<Integer, Object> a6 = this.mFha.a(i6, "startDataServer", new Class[]{Callback.class}, this.dataServerCallback);
            Objects.toString(a6.first);
            Objects.toString(a6.second);
            b.a();
            if (((Integer) a6.first).intValue() != 0) {
                reportMethodFail("startDataServer", (Integer) a6.first);
            }
            return a6;
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            getPackageName();
            b.a();
            if (PUSH_SERVICE_ACTION.equals(intent.getAction())) {
                b.a();
                return this.mBinder;
            }
            return null;
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            super.onCreate();
            this.mFha = d.a(StubApp.getOrigApplicationContext(getApplicationContext()));
            getPackageName();
            b.a();
            new Thread(new Runnable() { // from class: com.baidu.liantian.push.LiantianPushConnService.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        boolean c6 = LiantianPushConnService.this.mFha.c();
                        b.a();
                        boolean z5 = false;
                        if (c6) {
                            LiantianPushConnService.this.reportInitPushModuleResult(true);
                        } else {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException e6) {
                                e6.printStackTrace();
                            }
                            if (!LiantianPushConnService.this.mFha.c()) {
                                LiantianPushConnService.this.reportInitPushModuleResult(false);
                                LiantianPushConnService.this.reportKillSelf(1);
                                LiantianPushConnService.this.stopSelf();
                                return;
                            }
                            LiantianPushConnService.this.reportInitPushModuleResult(true);
                        }
                        ApkInfo d6 = g.a(LiantianPushConnService.this).d("com.baidu.liantian.x18");
                        Objects.toString(LiantianPushConnService.this.mFha);
                        Objects.toString(d6);
                        b.a();
                        if (d6 == null) {
                            LiantianPushConnService.this.reportKillSelf(2);
                            LiantianPushConnService.this.stopSelf();
                            return;
                        }
                        LiantianPushConnService.this.mPushPluginVersion = d6.versionName;
                        int unused = LiantianPushConnService.sPushPluginId = d6.key;
                        Pair startDataServer = LiantianPushConnService.this.startDataServer(LiantianPushConnService.sPushPluginId);
                        boolean z6 = startDataServer != null && ((Boolean) startDataServer.second).booleanValue();
                        if (((Integer) startDataServer.first).intValue() != 0 || !z6) {
                            startDataServer = LiantianPushConnService.this.startDataServer(LiantianPushConnService.sPushPluginId);
                            if (startDataServer != null && ((Boolean) startDataServer.second).booleanValue()) {
                                z5 = true;
                            }
                            z6 = z5;
                        }
                        if (((Integer) startDataServer.first).intValue() == 0 && z6) {
                            return;
                        }
                        LiantianPushConnService.this.reportKillSelf(3);
                        LiantianPushConnService.this.stopSelf();
                    } catch (Throwable unused2) {
                        e.a();
                    }
                }
            }).start();
        } catch (Throwable unused) {
            e.a();
        }
    }

    protected void reportInitPushModuleResult(boolean z5) {
        int i6;
        b.a();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.1.6.7");
            hashMap.put("2", com.baidu.liantian.b.g.c(StubApp.getOrigApplicationContext(getApplicationContext())));
            if (z5) {
                i6 = 1;
            } else {
                i6 = 2;
            }
            hashMap.put("3", Integer.valueOf(i6));
            e.a(StubApp.getOrigApplicationContext(getApplicationContext()), "1003130", hashMap);
        } catch (Throwable unused) {
            e.a();
        }
    }

    protected void reportKillSelf(int i6) {
        b.a();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.1.6.7");
            hashMap.put("2", com.baidu.liantian.b.g.c(StubApp.getOrigApplicationContext(getApplicationContext())));
            hashMap.put("3", this.mPushPluginVersion);
            hashMap.put("4", Integer.valueOf(i6));
            e.a(StubApp.getOrigApplicationContext(getApplicationContext()), "1003133", hashMap);
        } catch (Throwable unused) {
            e.a();
        }
    }

    protected void reportMethodFail(String str, Integer num) {
        b.a();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.1.6.7");
            hashMap.put("2", com.baidu.liantian.b.g.c(StubApp.getOrigApplicationContext(getApplicationContext())));
            hashMap.put("3", this.mPushPluginVersion);
            hashMap.put("4", str);
            hashMap.put("5", num);
            e.a(StubApp.getOrigApplicationContext(getApplicationContext()), "1003131", hashMap);
        } catch (Throwable unused) {
            e.a();
        }
    }
}
