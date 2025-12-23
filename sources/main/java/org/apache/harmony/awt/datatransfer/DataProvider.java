package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import xyz.adscope.common.network.cookie.db.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DataProvider {
    public static final String FORMAT_FILE_LIST = "application/x-java-file-list";
    public static final String FORMAT_HTML = "text/html";
    public static final String FORMAT_IMAGE = "image/x-java-image";
    public static final String FORMAT_TEXT = "text/plain";
    public static final String FORMAT_URL = "application/x-java-url";
    public static final String TYPE_FILELIST = "application/x-java-file-list";
    public static final String TYPE_HTML = "text/html";
    public static final String TYPE_IMAGE = "image/x-java-image";
    public static final String TYPE_PLAINTEXT = "text/plain";
    public static final String TYPE_SERIALIZED = "application/x-java-serialized-object";
    public static final String TYPE_TEXTENCODING = "application/x-java-text-encoding";
    public static final String TYPE_URL = "application/x-java-url";
    public static final DataFlavor urlFlavor = new DataFlavor("application/x-java-url;class=java.net.URL", Field.URL);
    public static final String TYPE_URILIST = "text/uri-list";
    public static final DataFlavor uriFlavor = new DataFlavor(TYPE_URILIST, "URI");

    String[] getFileList();

    String getHTML();

    String[] getNativeFormats();

    RawBitmap getRawBitmap();

    byte[] getSerializedObject(Class<?> cls);

    String getText();

    String getURL();

    boolean isNativeFormatAvailable(String str);
}
