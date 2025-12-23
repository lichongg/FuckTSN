package javax.activation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class FileDataSource implements DataSource {
    private File _file;
    private FileTypeMap typeMap;

    public FileDataSource(File file) {
        this.typeMap = null;
        this._file = file;
    }

    @Override // javax.activation.DataSource
    public String getContentType() {
        FileTypeMap fileTypeMap = this.typeMap;
        return fileTypeMap == null ? FileTypeMap.getDefaultFileTypeMap().getContentType(this._file) : fileTypeMap.getContentType(this._file);
    }

    public File getFile() {
        return this._file;
    }

    @Override // javax.activation.DataSource
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this._file);
    }

    @Override // javax.activation.DataSource
    public String getName() {
        return this._file.getName();
    }

    @Override // javax.activation.DataSource
    public OutputStream getOutputStream() throws IOException {
        return new FileOutputStream(this._file);
    }

    public void setFileTypeMap(FileTypeMap fileTypeMap) {
        this.typeMap = fileTypeMap;
    }

    public FileDataSource(String str) {
        this(new File(str));
    }
}
