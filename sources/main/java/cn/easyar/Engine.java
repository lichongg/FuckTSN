package cn.easyar;

import android.app.Activity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C8E75EBBD")
/* loaded from: D:\Downloads\app\classes2.dex */
public class Engine {
    @MethodId("C1D7F81F3")
    public static native String errorMessage();

    @MethodId("C37873CEF")
    public static native boolean initializeKey(String licenseKey);

    @MethodId("C059E7BAC")
    public static native boolean isLicenseKeyMatched(String licenseKey, String packageName, String variant, int operatingSystem);

    @MethodId("C82A3537F")
    public static native String name();

    @MethodId("CDBC6476A")
    public static native void onPause();

    @MethodId("CA37CC4E3")
    public static native void onResume();

    @MethodId("CB01257F6")
    public static native int schemaHash();

    @MethodId("C3556B4DE")
    public static native boolean setupActivity(Activity activity);

    @MethodId("CCB7BF562")
    public static native String variant();

    @MethodId("CB781B70F")
    public static native String versionString();

    public static void d() {
        System.loadLibrary("EasyAR");
        q.a();
    }

    public static void e(String soLibraryDir) {
        System.load(soLibraryDir + "/libEasyAR.so");
        q.a();
    }

    public static boolean a(Activity activity, String licenseKey) {
        d();
        if (setupActivity(activity) && initializeKey(licenseKey)) {
            return true;
        }
        return false;
    }

    public static boolean b(Activity activity, String licenseKey, String soLibraryDir) {
        e(soLibraryDir);
        if (setupActivity(activity) && initializeKey(licenseKey)) {
            return true;
        }
        return false;
    }

    public static boolean c(Activity activity, String licenseKey) {
        if (setupActivity(activity) && initializeKey(licenseKey)) {
            return true;
        }
        return false;
    }
}
