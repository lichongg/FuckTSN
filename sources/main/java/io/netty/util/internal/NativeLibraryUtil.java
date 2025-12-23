package io.netty.util.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class NativeLibraryUtil {
    public static void loadLibrary(String str, boolean z5) {
        if (z5) {
            System.load(str);
        } else {
            System.loadLibrary(str);
        }
    }

    private NativeLibraryUtil() {
    }
}
