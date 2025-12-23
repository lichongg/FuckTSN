package javax.activation;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import myjava.awt.datatransfer.DataFlavor;
import myjava.awt.datatransfer.UnsupportedFlavorException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class ObjectDataContentHandler implements DataContentHandler {
    private DataContentHandler dch;
    private String mimeType;
    private Object obj;
    private DataFlavor[] transferFlavors = null;

    @Override // javax.activation.DataContentHandler
    public synchronized DataFlavor[] getTransferDataFlavors() {
        try {
            if (this.transferFlavors == null) {
                DataContentHandler dataContentHandler = this.dch;
                if (dataContentHandler != null) {
                    this.transferFlavors = dataContentHandler.getTransferDataFlavors();
                } else {
                    this.transferFlavors = new DataFlavor[]{new ActivationDataFlavor(r2, r3, r3)};
                    Class<?> cls = this.obj.getClass();
                    String str = this.mimeType;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.transferFlavors;
    }

    @Override // javax.activation.DataContentHandler
    public Object getContent(DataSource dataSource) {
        return this.obj;
    }

    public DataContentHandler getDCH() {
        return this.dch;
    }

    @Override // javax.activation.DataContentHandler
    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws UnsupportedFlavorException, IOException {
        DataContentHandler dataContentHandler = this.dch;
        if (dataContentHandler != null) {
            return dataContentHandler.getTransferData(dataFlavor, dataSource);
        }
        if (dataFlavor.equals(getTransferDataFlavors()[0])) {
            return this.obj;
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    @Override // javax.activation.DataContentHandler
    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        DataContentHandler dataContentHandler = this.dch;
        if (dataContentHandler != null) {
            dataContentHandler.writeTo(obj, str, outputStream);
            return;
        }
        if (obj instanceof byte[]) {
            outputStream.write((byte[]) obj);
            return;
        }
        if (!(obj instanceof String)) {
            throw new UnsupportedDataTypeException("no object DCH for MIME type " + this.mimeType);
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write((String) obj);
        outputStreamWriter.flush();
    }

    public ObjectDataContentHandler(DataContentHandler dataContentHandler, Object obj, String str) {
        this.obj = obj;
        this.mimeType = str;
        this.dch = dataContentHandler;
    }
}
