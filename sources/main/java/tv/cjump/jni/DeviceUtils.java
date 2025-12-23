package tv.cjump.jni;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DeviceUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54642a = "x86";

    /* renamed from: b, reason: collision with root package name */
    public static final String f54643b = "mips";

    /* renamed from: c, reason: collision with root package name */
    private static ARCH f54644c = ARCH.Unknown;

    /* renamed from: d, reason: collision with root package name */
    private static final int f54645d = 40;

    /* renamed from: e, reason: collision with root package name */
    private static final int f54646e = 3;

    /* renamed from: f, reason: collision with root package name */
    private static final int f54647f = 8;

    /* renamed from: g, reason: collision with root package name */
    private static final int f54648g = 183;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ARCH {
        Unknown,
        ARM,
        X86,
        MIPS,
        ARM64
    }

    public static String c() {
        try {
            Field declaredField = Build.class.getDeclaredField("CPU_ABI2");
            if (declaredField == null) {
                return null;
            }
            Object obj = declaredField.get(null);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
    
        if (r3 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0072, code lost:
    
        r3.close();
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0070, code lost:
    
        if (r3 == null) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0063 -> B:22:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized tv.cjump.jni.DeviceUtils.ARCH a() {
        /*
            java.lang.Class<tv.cjump.jni.DeviceUtils> r0 = tv.cjump.jni.DeviceUtils.class
            monitor-enter(r0)
            r1 = 20
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L60
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L60
            java.io.File r3 = android.os.Environment.getRootDirectory()     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = "lib/libc.so"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L60
            boolean r3 = r2.canRead()     // Catch: java.lang.Throwable -> L60
            if (r3 == 0) goto L87
            r3 = 0
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69 java.io.FileNotFoundException -> L6b
            java.lang.String r5 = "r"
            r4.<init>(r2, r5)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69 java.io.FileNotFoundException -> L6b
            r4.readFully(r1)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            r2 = 19
            r2 = r1[r2]     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            r3 = 8
            int r2 = r2 << r3
            r5 = 18
            r1 = r1[r5]     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            r1 = r1 | r2
            r2 = 3
            if (r1 == r2) goto L58
            if (r1 == r3) goto L53
            r2 = 40
            if (r1 == r2) goto L4e
            r2 = 183(0xb7, float:2.56E-43)
            if (r1 == r2) goto L49
            java.lang.Integer.toHexString(r1)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            goto L5c
        L40:
            r1 = move-exception
            r3 = r4
            goto L7c
        L43:
            r1 = move-exception
            r3 = r4
            goto L6d
        L46:
            r1 = move-exception
            r3 = r4
            goto L76
        L49:
            tv.cjump.jni.DeviceUtils$ARCH r1 = tv.cjump.jni.DeviceUtils.ARCH.ARM64     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            tv.cjump.jni.DeviceUtils.f54644c = r1     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            goto L5c
        L4e:
            tv.cjump.jni.DeviceUtils$ARCH r1 = tv.cjump.jni.DeviceUtils.ARCH.ARM     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            tv.cjump.jni.DeviceUtils.f54644c = r1     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            goto L5c
        L53:
            tv.cjump.jni.DeviceUtils$ARCH r1 = tv.cjump.jni.DeviceUtils.ARCH.MIPS     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            tv.cjump.jni.DeviceUtils.f54644c = r1     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            goto L5c
        L58:
            tv.cjump.jni.DeviceUtils$ARCH r1 = tv.cjump.jni.DeviceUtils.ARCH.X86     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
            tv.cjump.jni.DeviceUtils.f54644c = r1     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L46
        L5c:
            r4.close()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            goto L87
        L60:
            r1 = move-exception
            goto L8b
        L62:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L60
            goto L87
        L67:
            r1 = move-exception
            goto L7c
        L69:
            r1 = move-exception
            goto L6d
        L6b:
            r1 = move-exception
            goto L76
        L6d:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L67
            if (r3 == 0) goto L87
        L72:
            r3.close()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            goto L87
        L76:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L67
            if (r3 == 0) goto L87
            goto L72
        L7c:
            if (r3 == 0) goto L86
            r3.close()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L82
            goto L86
        L82:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L60
        L86:
            throw r1     // Catch: java.lang.Throwable -> L60
        L87:
            tv.cjump.jni.DeviceUtils$ARCH r1 = tv.cjump.jni.DeviceUtils.f54644c     // Catch: java.lang.Throwable -> L60
            monitor-exit(r0)
            return r1
        L8b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.cjump.jni.DeviceUtils.a():tv.cjump.jni.DeviceUtils$ARCH");
    }

    public static String b() {
        return Build.CPU_ABI;
    }

    public static boolean e() {
        return Build.MANUFACTURER.equalsIgnoreCase("MagicBox") && Build.PRODUCT.equalsIgnoreCase("MagicBox");
    }

    public static boolean f() {
        return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && Build.PRODUCT.equalsIgnoreCase("dredd");
    }

    public static boolean k() {
        return j(f54643b);
    }

    public static boolean l() {
        return j(f54642a);
    }

    public static boolean d() {
        ARCH a6 = a();
        if (!l() && ARCH.X86.equals(a6)) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        if (!f() && !e()) {
            return false;
        }
        return true;
    }

    public static boolean h() {
        ARCH a6 = a();
        if ((j("armeabi-v7a") || j("armeabi")) && ARCH.ARM.equals(a6)) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        ARCH a6 = a();
        if (!j(f54642a) && !ARCH.X86.equals(a6)) {
            return false;
        }
        return true;
    }

    public static boolean j(String str) {
        String b6 = b();
        if (!TextUtils.isEmpty(b6) && b6.equalsIgnoreCase(str)) {
            return true;
        }
        if (!TextUtils.isEmpty(c()) && b6.equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }
}
