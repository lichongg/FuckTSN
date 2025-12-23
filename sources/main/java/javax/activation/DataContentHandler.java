package javax.activation;

import java.io.IOException;
import java.io.OutputStream;
import myjava.awt.datatransfer.DataFlavor;
import myjava.awt.datatransfer.UnsupportedFlavorException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface DataContentHandler {
    Object getContent(DataSource dataSource) throws IOException;

    Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws UnsupportedFlavorException, IOException;

    DataFlavor[] getTransferDataFlavors();

    void writeTo(Object obj, String str, OutputStream outputStream) throws IOException;
}
