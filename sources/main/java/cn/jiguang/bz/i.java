package cn.jiguang.bz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.kwad.library.solder.lib.ext.PluginError;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f2741a = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f2742b = {"fstab.andy", "ueventd.andy.rc"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f2743c = {"fstab.nox", "init.nox.rc", "ueventd.nox.rc"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f2744d = {"/dev/socket/qemud", "/dev/qemu_pipe"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f2745e = {"goldfish"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f2746f = {"ueventd.android_x86.rc", "x86.prop", "ueventd.ttVM_x86.rc", "init.ttVM_x86.rc", "fstab.ttVM_x86", "fstab.vbox86", "init.vbox86.rc", "ueventd.vbox86.rc"};

    /* renamed from: g, reason: collision with root package name */
    private static final r[] f2747g = {new r("init.svc.qemud", null), new r("init.svc.qemu-props", null), new r("qemu.hw.mainkeys", null), new r("qemu.sf.fake_camera", null), new r("qemu.sf.lcd_density", null), new r("ro.bootloader", "unknown"), new r("ro.bootmode", "unknown"), new r("ro.hardware", "goldfish"), new r("ro.kernel.android.qemud", null), new r("ro.kernel.qemu.gles", null), new r("ro.kernel.qemu", "1"), new r("ro.product.device", "generic"), new r("ro.product.model", "sdk"), new r("ro.product.name", "sdk")};

    /* renamed from: n, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static i f2748n;

    /* renamed from: h, reason: collision with root package name */
    private final Context f2749h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2750i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2751j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2752k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2753l = false;

    /* renamed from: m, reason: collision with root package name */
    private final List<String> f2754m;

    public static i a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context 不能为空.");
        }
        if (f2748n == null) {
            f2748n = new i(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        return f2748n;
    }

    private boolean g() {
        return false;
    }

    public i b(boolean z5) {
        this.f2752k = z5;
        return this;
    }

    public i c(boolean z5) {
        this.f2753l = z5;
        return this;
    }

    public static Boolean b(Context context) {
        return ((SensorManager) context.getSystemService(bi.ac)).getDefaultSensor(5) == null ? Boolean.TRUE : Boolean.FALSE;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c() {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bz.i.c():boolean");
    }

    private boolean d() {
        Intent launchIntentForPackage;
        if (this.f2751j && !this.f2754m.isEmpty()) {
            PackageManager packageManager = this.f2749h.getPackageManager();
            Iterator<String> it = this.f2754m.iterator();
            while (it.hasNext()) {
                try {
                    launchIntentForPackage = packageManager.getLaunchIntentForPackage(it.next());
                } catch (Throwable unused) {
                }
                if (launchIntentForPackage != null) {
                    return packageManager.resolveActivity(launchIntentForPackage, 65536) != null;
                }
                continue;
            }
        }
        return false;
    }

    private boolean e() {
        if (!q.a(this.f2749h, com.kuaishou.weapon.p0.g.f36043c) || !i() || !x.b(this.f2749h, false).equalsIgnoreCase(FaceEnvironment.OS)) {
            return false;
        }
        cn.jiguang.bb.f.c("EmulatorDetector", "Check operator name android is detected");
        return true;
    }

    private boolean f() {
        int i6 = 0;
        for (r rVar : f2747g) {
            if ((!"ro.product.name".equals(rVar.f2782a) || cn.jiguang.g.a.a().e(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW)) && (!"ro.product.model".equals(rVar.f2782a) || cn.jiguang.g.a.a().e(PluginError.ERROR_UPD_FILE_NOT_FOUND))) {
                String a6 = w.a(rVar.f2782a, "");
                String str = rVar.f2783b;
                if (str == null && a6 != null) {
                    i6++;
                }
                if (str != null && a6 != null && a6.contains(str)) {
                    i6++;
                }
            }
        }
        if (i6 < 5) {
            return false;
        }
        cn.jiguang.bb.f.c("EmulatorDetector", "Check QEmuProps is detected");
        return true;
    }

    private boolean h() {
        w.a(CommonNetImpl.NAME, "");
        if (!q.a(this.f2749h, com.kuaishou.weapon.p0.g.f36041a)) {
            return false;
        }
        String[] strArr = {"/system/bin/netcfg"};
        StringBuilder sb = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(strArr);
            processBuilder.directory(new File("/system/bin/"));
            processBuilder.redirectErrorStream(true);
            InputStream inputStream = processBuilder.start().getInputStream();
            byte[] bArr = new byte[1024];
            while (inputStream.read(bArr) != -1) {
                sb.append(new String(bArr));
            }
            inputStream.close();
        } catch (Throwable th) {
            cn.jiguang.bb.f.c("EmulatorDetector", th.getMessage());
        }
        String sb2 = sb.toString();
        cn.jiguang.bb.f.c("EmulatorDetector", "netcfg data -> " + sb2);
        if (TextUtils.isEmpty(sb2)) {
            return false;
        }
        for (String str : sb2.split(com.snail.antifake.deviceid.e.f37542d)) {
            if ((str.contains("wlan0") || str.contains("tunl0") || str.contains("eth0")) && str.contains("10.0.2.15")) {
                cn.jiguang.bb.f.c("EmulatorDetector", "Check IP is detected");
                return true;
            }
        }
        return false;
    }

    private boolean i() {
        boolean hasSystemFeature = this.f2749h.getPackageManager().hasSystemFeature("android.hardware.telephony");
        cn.jiguang.bb.f.c("EmulatorDetector", "Supported TelePhony: " + hasSystemFeature);
        return hasSystemFeature;
    }

    public i a(boolean z5) {
        this.f2751j = z5;
        return this;
    }

    private i(Context context) {
        ArrayList arrayList = new ArrayList();
        this.f2754m = arrayList;
        this.f2749h = context;
        arrayList.add("com.google.android.launcher.layouts.genymotion");
        arrayList.add("com.bluestacks");
        arrayList.add("com.bignox.app");
    }

    private boolean b() {
        boolean z5 = c() || e() || a(f2741a, "Geny") || a(f2742b, "Andy") || a(f2743c, "Nox") || a(f2744d, "Pipes") || g() || h();
        if (z5) {
            return z5;
        }
        if (this.f2752k) {
            z5 = f() && a(f2746f, "X86");
        }
        if (this.f2751j) {
            z5 = d();
        }
        return this.f2753l ? b(this.f2749h).booleanValue() : z5;
    }

    public boolean a() {
        boolean z5;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            z5 = b();
        } catch (Throwable th) {
            th = th;
            z5 = false;
        }
        try {
            cn.jiguang.bb.f.c("EmulatorDetector", "sync detect cost time: " + (System.currentTimeMillis() - currentTimeMillis) + ", isSimulator: " + z5);
            return z5;
        } catch (Throwable th2) {
            th = th2;
            cn.jiguang.bb.f.i("EmulatorDetector", "detect si failed, error: " + th.getMessage());
            return z5;
        }
    }

    private boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (new File(str2).exists()) {
                cn.jiguang.bb.f.c("EmulatorDetector", "Check " + str + " is detected");
                return true;
            }
        }
        return false;
    }
}
