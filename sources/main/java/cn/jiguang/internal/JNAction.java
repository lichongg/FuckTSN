package cn.jiguang.internal;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JNAction {
    public static boolean isNativeLibraryLoaded;

    public static native boolean a(String str, String str2);

    public static native boolean d(String str);

    public static native void i(String str, long j6, int i6);

    public static native byte[] r(String str);

    public static native void s(String str, long j6, int i6, String str2);

    public static native String v();

    public static native boolean w(String str, String str2);

    public static void load() {
        try {
            System.loadLibrary("jutils");
            isNativeLibraryLoaded = true;
        } catch (Throwable unused) {
            isNativeLibraryLoaded = false;
        }
    }

    public static void loadPath(String str) {
        try {
            System.load(str);
            isNativeLibraryLoaded = true;
        } catch (Throwable unused) {
            isNativeLibraryLoaded = false;
        }
    }
}
