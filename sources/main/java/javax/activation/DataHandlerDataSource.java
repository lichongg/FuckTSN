package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class DataHandlerDataSource implements DataSource {
    DataHandler dataHandler;

    @Override // javax.activation.DataSource
    public String getContentType() {
        return this.dataHandler.getContentType();
    }

    @Override // javax.activation.DataSource
    public InputStream getInputStream() throws IOException {
        return this.dataHandler.getInputStream();
    }

    @Override // javax.activation.DataSource
    public String getName() {
        return this.dataHandler.getName();
    }

    @Override // javax.activation.DataSource
    public OutputStream getOutputStream() throws IOException {
        return this.dataHandler.getOutputStream();
    }

    public DataHandlerDataSource(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }
}
