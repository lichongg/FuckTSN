package org.apache.harmony.awt.datatransfer;

import com.baidu.mobads.sdk.internal.a;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.dnd.peer.DropTargetContextPeer;
import java.nio.charset.Charset;
import org.apache.commons.net.ftp.b;
import org.apache.harmony.awt.ContextStorage;
import org.apache.harmony.awt.internal.nls.Messages;
import org.apache.harmony.misc.SystemUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class DTK {
    protected final DataTransferThread dataTransferThread;
    private NativeClipboard nativeClipboard = null;
    private NativeClipboard nativeSelection = null;
    protected SystemFlavorMap systemFlavorMap;

    protected void appendSystemFlavorMap(SystemFlavorMap systemFlavorMap, DataFlavor dataFlavor, String str) {
        systemFlavorMap.addFlavorForUnencodedNative(str, dataFlavor);
        systemFlavorMap.addUnencodedNativeForFlavor(dataFlavor, str);
    }

    public abstract DragSourceContextPeer createDragSourceContextPeer(DragGestureEvent dragGestureEvent);

    public abstract DropTargetContextPeer createDropTargetContextPeer(DropTargetContext dropTargetContext);

    public synchronized SystemFlavorMap getSystemFlavorMap() {
        return this.systemFlavorMap;
    }

    public abstract void initDragAndDrop();

    protected abstract NativeClipboard newNativeClipboard();

    protected abstract NativeClipboard newNativeSelection();

    public abstract void runEventLoop();

    public synchronized void setSystemFlavorMap(SystemFlavorMap systemFlavorMap) {
        this.systemFlavorMap = systemFlavorMap;
    }

    protected String[] getCharsets() {
        return new String[]{"UTF-16", "UTF-8", "unicode", b.T, "US-ASCII"};
    }

    public String getDefaultCharset() {
        return "unicode";
    }

    public NativeClipboard getNativeClipboard() {
        if (this.nativeClipboard == null) {
            this.nativeClipboard = newNativeClipboard();
        }
        return this.nativeClipboard;
    }

    public NativeClipboard getNativeSelection() {
        if (this.nativeSelection == null) {
            this.nativeSelection = newNativeSelection();
        }
        return this.nativeSelection;
    }

    protected DTK() {
        DataTransferThread dataTransferThread = new DataTransferThread(this);
        this.dataTransferThread = dataTransferThread;
        dataTransferThread.start();
    }

    private static DTK createDTK() {
        String str;
        int os = SystemUtils.getOS();
        if (os != 1) {
            if (os == 2) {
                str = "org.apache.harmony.awt.datatransfer.linux.LinuxDTK";
            } else {
                throw new RuntimeException(Messages.getString("awt.4E"));
            }
        } else {
            str = "org.apache.harmony.awt.datatransfer.windows.WinDTK";
        }
        try {
            return (DTK) Class.forName(str).newInstance();
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static DTK getDTK() {
        synchronized (ContextStorage.getContextLock()) {
            try {
                if (ContextStorage.shutdownPending()) {
                    return null;
                }
                DTK dtk = ContextStorage.getDTK();
                if (dtk == null) {
                    dtk = createDTK();
                    ContextStorage.setDTK(dtk);
                }
                return dtk;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void appendSystemFlavorMap(SystemFlavorMap systemFlavorMap, String[] strArr, String str, String str2) {
        TextFlavor.addUnicodeClasses(systemFlavorMap, str2, str);
        for (int i6 = 0; i6 < strArr.length; i6++) {
            String str3 = strArr[i6];
            if (str3 != null && Charset.isSupported(str3)) {
                TextFlavor.addCharsetClasses(systemFlavorMap, str2, str, strArr[i6]);
            }
        }
    }

    public void initSystemFlavorMap(SystemFlavorMap systemFlavorMap) {
        String[] charsets = getCharsets();
        appendSystemFlavorMap(systemFlavorMap, DataFlavor.stringFlavor, "text/plain");
        appendSystemFlavorMap(systemFlavorMap, charsets, "plain", "text/plain");
        appendSystemFlavorMap(systemFlavorMap, charsets, a.f10505f, "text/html");
        appendSystemFlavorMap(systemFlavorMap, DataProvider.urlFlavor, "application/x-java-url");
        appendSystemFlavorMap(systemFlavorMap, charsets, "uri-list", "application/x-java-url");
        appendSystemFlavorMap(systemFlavorMap, DataFlavor.javaFileListFlavor, "application/x-java-file-list");
        appendSystemFlavorMap(systemFlavorMap, DataFlavor.imageFlavor, "image/x-java-image");
    }
}
