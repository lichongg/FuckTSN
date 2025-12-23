package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r {
    public static com.kwad.sdk.l.a.d aYY;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends com.kwad.sdk.l.a.a {
        private void PR() {
            ArrayList arrayList = new ArrayList();
            this.aWE = arrayList;
            arrayList.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.a.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean cm(Context context) {
                    String str = Build.PRODUCT;
                    int i6 = (str.contains("sdk") || str.contains("Andy") || str.contains("ttVM_Hdragon") || str.contains("google_sdk") || str.contains("Droid4X") || str.contains("nox") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("vbox86p") || str.contains("aries")) ? 1 : 0;
                    String str2 = Build.MANUFACTURER;
                    if (str2.equals("unknown") || str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("MIT") || str2.contains("nox") || str2.contains("TiantianVM")) {
                        i6++;
                    }
                    String str3 = Build.BRAND;
                    if (str3.equals("generic") || str3.equals("generic_x86") || str3.equals("TTVM") || str3.contains("Andy")) {
                        i6++;
                    }
                    String str4 = Build.DEVICE;
                    if (str4.contains("generic") || str4.contains("generic_x86") || str4.contains("Andy") || str4.contains("ttVM_Hdragon") || str4.contains("Droid4X") || str4.contains("nox") || str4.contains("generic_x86_64") || str4.contains("vbox86p") || str4.contains("aries")) {
                        i6++;
                    }
                    String str5 = Build.MODEL;
                    if (str5.equals("sdk") || str5.contains("Emulator") || str5.equals("google_sdk") || str5.contains("Droid4X") || str5.contains("TiantianVM") || str5.contains("Andy") || str5.equals("Android SDK built for x86_64") || str5.equals("Android SDK built for x86")) {
                        i6++;
                    }
                    String str6 = Build.HARDWARE;
                    if (str6.equals("goldfish") || str6.equals("vbox86") || str6.contains("nox") || str6.contains("ttVM_x86")) {
                        i6++;
                    }
                    String str7 = Build.FINGERPRINT;
                    if (str7.contains("generic/sdk/generic") || str7.contains("generic_x86/sdk_x86/generic_x86") || str7.contains("Andy") || str7.contains("ttVM_Hdragon") || str7.contains("generic_x86_64") || str7.contains("generic/google_sdk/generic") || str7.contains("vbox86p") || str7.contains("generic/vbox86p/vbox86p")) {
                        i6++;
                    }
                    try {
                        if (!bc.useStoragePermissionDisable()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(Environment.getExternalStorageDirectory().toString());
                            char c6 = File.separatorChar;
                            sb.append(c6);
                            sb.append("windows");
                            sb.append(c6);
                            sb.append("BstSharedFolder");
                            if (new File(sb.toString()).exists()) {
                                i6 += 10;
                            }
                        }
                    } catch (Exception unused) {
                    }
                    return i6 > 3;
                }
            });
            this.aWE.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.a.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean cm(Context context) {
                    return "1".equals(bq.get("ro.kernel.qemu"));
                }
            });
        }

        public a() {
            PR();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends com.kwad.sdk.l.a.a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends com.kwad.sdk.l.a.a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d extends com.kwad.sdk.l.a.a {
        private void PR() {
            ArrayList arrayList = new ArrayList();
            this.aWE = arrayList;
            arrayList.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean cm(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.aWE.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean cm(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i6 = 0; i6 < 5; i6++) {
                        if (new File(strArr[i6] + "su").exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.aWE.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.3
                @Override // com.kwad.sdk.l.a.a
                public final boolean cm(Context context) {
                    return !TextUtils.isEmpty(r.g(new String[]{"/system/xbin/which", "su"}));
                }
            });
            this.aWE.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.4
                @Override // com.kwad.sdk.l.a.a
                public final boolean cm(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        w.a(file, "ok", forName, false);
                        return w.a(file, forName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }

        public d() {
            PR();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e extends com.kwad.sdk.l.a.a {
        private void PR() {
            ArrayList arrayList = new ArrayList();
            this.aWE = arrayList;
            arrayList.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.e.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean cm(Context context) {
                    return as.ap(context, "de.robv.android.xposed.installer") || as.ap(context, "com.saurik.substrate");
                }
            });
            this.aWE.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.e.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean cm(Context context) {
                    try {
                        throw new Exception("empty");
                    } catch (Exception e6) {
                        boolean z5 = false;
                        int i6 = 0;
                        for (StackTraceElement stackTraceElement : e6.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i6 = i6 + 1) == 2) {
                                z5 = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z5 = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.f35735b) && methodName.equals("main")) {
                                z5 = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.f35735b) && methodName.equals("handleHookedMethod")) {
                                z5 = true;
                            }
                        }
                        return z5;
                    }
                }
            });
            this.aWE.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.e.3
                @Override // com.kwad.sdk.l.a.a
                public final boolean cm(Context context) {
                    FileReader fileReader;
                    boolean z5 = false;
                    BufferedReader bufferedReader = null;
                    try {
                        HashSet<String> hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    if (!readLine.endsWith(".so") && !readLine.endsWith(".jar")) {
                                    }
                                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                } catch (Exception unused) {
                                    bufferedReader = bufferedReader2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    return z5;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    throw th;
                                }
                            }
                            for (String str : hashSet) {
                                if (str.contains("com.saurik.substrate")) {
                                    Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                    z5 = true;
                                }
                                if (str.contains("XposedBridge.jar")) {
                                    Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                    z5 = true;
                                }
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        } catch (Exception unused2) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception unused3) {
                        fileReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileReader = null;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z5;
                }
            });
        }

        public e() {
            PR();
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.l.a.d PQ() {
        synchronized (r.class) {
            if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).By()) {
                return null;
            }
            com.kwad.sdk.l.a.d dVar = aYY;
            if (dVar != null) {
                return dVar;
            }
            Context origApplicationContext = StubApp.getOrigApplicationContext(ServiceProvider.getContext().getApplicationContext());
            com.kwad.sdk.l.a.d dVar2 = new com.kwad.sdk.l.a.d(origApplicationContext);
            boolean cl = new d().cl(origApplicationContext);
            boolean cl2 = new e().cl(origApplicationContext);
            boolean cl3 = new b().cl(origApplicationContext);
            boolean cl4 = new a().cl(origApplicationContext);
            boolean cl5 = new c().cl(origApplicationContext);
            dVar2.bT(cl);
            dVar2.bU(cl2);
            dVar2.bV(cl3);
            dVar2.bX(cl4);
            dVar2.bY(cl5);
            aYY = dVar2;
            return dVar2;
        }
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }
}
