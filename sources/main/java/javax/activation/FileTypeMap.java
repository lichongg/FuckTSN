package javax.activation;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class FileTypeMap {
    private static FileTypeMap defaultMap;

    public abstract String getContentType(File file);

    public abstract String getContentType(String str);

    public static FileTypeMap getDefaultFileTypeMap() {
        if (defaultMap == null) {
            defaultMap = new MimetypesFileTypeMap();
        }
        return defaultMap;
    }

    public static void setDefaultFileTypeMap(FileTypeMap fileTypeMap) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            try {
                securityManager.checkSetFactory();
            } catch (SecurityException e6) {
                if (FileTypeMap.class.getClassLoader() != fileTypeMap.getClass().getClassLoader()) {
                    throw e6;
                }
            }
        }
        defaultMap = fileTypeMap;
    }
}
