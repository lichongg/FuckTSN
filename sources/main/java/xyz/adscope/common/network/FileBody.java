package xyz.adscope.common.network;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class FileBody extends BaseContent<FileBody> implements RequestBody {

    /* renamed from: b, reason: collision with root package name */
    private final File f56468b;

    @Override // xyz.adscope.common.network.BaseContent
    protected void a(OutputStream outputStream) {
        FileInputStream fileInputStream = new FileInputStream(this.f56468b);
        IOUtils.write(fileInputStream, outputStream);
        IOUtils.closeQuietly(fileInputStream);
    }

    @Override // xyz.adscope.common.network.Content
    public long contentLength() {
        return this.f56468b.length();
    }

    @Override // xyz.adscope.common.network.Content
    public String contentType() {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f56468b.getName()));
        return TextUtils.isEmpty(mimeTypeFromExtension) ? "application/octet-stream" : mimeTypeFromExtension;
    }

    public FileBody(File file) {
        this.f56468b = file;
    }
}
