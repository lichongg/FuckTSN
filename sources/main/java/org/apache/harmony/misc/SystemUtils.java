package org.apache.harmony.misc;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SystemUtils {
    public static final int ARC_IA32 = 1;
    public static final int ARC_IA64 = 2;
    public static final int ARC_UNKNOWN = -1;
    public static final int OS_LINUX = 2;
    public static final int OS_UNKNOWN = -1;
    public static final int OS_WINDOWS = 1;
    private static int arc;
    private static int os;

    public static int getOS() {
        if (os == 0) {
            String substring = System.getProperty("os.name").substring(0, 3);
            if (substring.compareToIgnoreCase("win") == 0) {
                os = 1;
            } else if (substring.compareToIgnoreCase("lin") == 0) {
                os = 2;
            } else {
                os = -1;
            }
        }
        return os;
    }
}
