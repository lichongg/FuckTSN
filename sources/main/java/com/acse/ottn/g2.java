package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.admin.DevicePolicyManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g2 {

    /* renamed from: g, reason: collision with root package name */
    public static final String f4537g = "MyAccessibilityService";

    /* renamed from: a, reason: collision with root package name */
    public boolean f4538a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f4539b;

    /* renamed from: c, reason: collision with root package name */
    public AccessibilityService f4540c;

    /* renamed from: d, reason: collision with root package name */
    public AccessibilityServiceInfo f4541d;

    /* renamed from: e, reason: collision with root package name */
    public DevicePolicyManager f4542e;

    /* renamed from: f, reason: collision with root package name */
    public x3 f4543f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && Build.VERSION.SDK_INT >= 28) {
                g2.this.f4540c.performGlobalAction(8);
            }
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:2:0x0000, B:4:0x0023, B:8:0x003a, B:10:0x004c, B:11:0x0051), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            r4 = this;
            android.accessibilityservice.AccessibilityService r0 = r4.f4540c     // Catch: java.lang.Throwable -> L37
            java.lang.String r1 = "device_policy"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L37
            android.app.admin.DevicePolicyManager r0 = (android.app.admin.DevicePolicyManager) r0     // Catch: java.lang.Throwable -> L37
            r4.f4542e = r0     // Catch: java.lang.Throwable -> L37
            android.accessibilityservice.AccessibilityService r0 = r4.f4540c     // Catch: java.lang.Throwable -> L37
            android.accessibilityservice.AccessibilityServiceInfo r0 = r0.getServiceInfo()     // Catch: java.lang.Throwable -> L37
            r4.f4541d = r0     // Catch: java.lang.Throwable -> L37
            com.acse.ottn.x3 r0 = new com.acse.ottn.x3     // Catch: java.lang.Throwable -> L37
            android.accessibilityservice.AccessibilityService r1 = r4.f4540c     // Catch: java.lang.Throwable -> L37
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L37
            r4.f4543f = r0     // Catch: java.lang.Throwable -> L37
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L37
            r1 = 28
            if (r0 >= r1) goto L39
            android.app.admin.DevicePolicyManager r0 = r4.f4542e     // Catch: java.lang.Throwable -> L37
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L37
            android.accessibilityservice.AccessibilityService r2 = r4.f4540c     // Catch: java.lang.Throwable -> L37
            java.lang.Class<com.acse.ottn.m2> r3 = com.acse.ottn.m2.class
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L37
            boolean r0 = r0.isAdminActive(r1)     // Catch: java.lang.Throwable -> L37
            if (r0 == 0) goto L35
            goto L39
        L35:
            r0 = 0
            goto L3a
        L37:
            r0 = move-exception
            goto L65
        L39:
            r0 = 1
        L3a:
            r4.f4538a = r0     // Catch: java.lang.Throwable -> L37
            android.accessibilityservice.AccessibilityServiceInfo r1 = r4.f4541d     // Catch: java.lang.Throwable -> L37
            int r2 = r1.eventTypes     // Catch: java.lang.Throwable -> L37
            r2 = r2 | 32
            r1.eventTypes = r2     // Catch: java.lang.Throwable -> L37
            int r2 = r1.flags     // Catch: java.lang.Throwable -> L37
            r2 = r2 | 32
            r1.flags = r2     // Catch: java.lang.Throwable -> L37
            if (r0 == 0) goto L51
            com.acse.ottn.x3 r0 = r4.f4543f     // Catch: java.lang.Throwable -> L37
            r0.a()     // Catch: java.lang.Throwable -> L37
        L51:
            android.accessibilityservice.AccessibilityService r0 = r4.f4540c     // Catch: java.lang.Throwable -> L37
            android.accessibilityservice.AccessibilityServiceInfo r1 = r4.f4541d     // Catch: java.lang.Throwable -> L37
            r0.setServiceInfo(r1)     // Catch: java.lang.Throwable -> L37
            android.os.Handler r0 = new android.os.Handler     // Catch: java.lang.Throwable -> L37
            com.acse.ottn.g2$a r1 = new com.acse.ottn.g2$a     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L37
            r4.f4539b = r0     // Catch: java.lang.Throwable -> L37
            return
        L65:
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.g2.a():void");
    }

    public g2(AccessibilityService accessibilityService) {
        this.f4540c = accessibilityService;
    }
}
