package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.net.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DiskFileUpload extends AbstractDiskHttpData implements FileUpload {
    public static String baseDirectory = null;
    public static boolean deleteOnExitTemporaryFile = true;
    public static final String postfix = ".tmp";
    public static final String prefix = "FUp_";
    private String contentTransferEncoding;
    private String contentType;
    private String filename;

    @Override // java.lang.Comparable
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof FileUpload) {
            return compareTo((FileUpload) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected boolean deleteOnExit() {
        return deleteOnExitTemporaryFile;
    }

    public boolean equals(Object obj) {
        return (obj instanceof FileUpload) && FileUploadUtil.equals(this, (FileUpload) obj);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getBaseDirectory() {
        return baseDirectory;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public String getContentTransferEncoding() {
        return this.contentTransferEncoding;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public String getContentType() {
        return this.contentType;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getDiskFilename() {
        return "upload";
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public String getFilename() {
        return this.filename;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.FileUpload;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getPostfix() {
        return ".tmp";
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getPrefix() {
        return prefix;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public void setContentTransferEncoding(String str) {
        this.contentTransferEncoding = str;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public void setContentType(String str) {
        if (str == null) {
            throw new NullPointerException("contentType");
        }
        this.contentType = str;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public void setFilename(String str) {
        if (str == null) {
            throw new NullPointerException("filename");
        }
        this.filename = str;
    }

    public DiskFileUpload(String str, String str2, String str3, String str4, Charset charset, long j6) {
        super(str, charset, j6);
        setFilename(str2);
        setContentType(str3);
        setContentTransferEncoding(str4);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload copy() {
        ByteBuf content = content();
        return replace(content != null ? content.copy() : null);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload duplicate() {
        ByteBuf content = content();
        return replace(content != null ? content.duplicate() : null);
    }

    public int hashCode() {
        return FileUploadUtil.hashCode(this);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload replace(ByteBuf byteBuf) {
        DiskFileUpload diskFileUpload = new DiskFileUpload(getName(), getFilename(), getContentType(), getContentTransferEncoding(), getCharset(), this.size);
        if (byteBuf == null) {
            return diskFileUpload;
        }
        try {
            diskFileUpload.setContent(byteBuf);
            return diskFileUpload;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload retainedDuplicate() {
        ByteBuf content = content();
        if (content != null) {
            ByteBuf retainedDuplicate = content.retainedDuplicate();
            try {
                return replace(retainedDuplicate);
            } catch (Throwable th) {
                retainedDuplicate.release();
                throw th;
            }
        }
        return replace((ByteBuf) null);
    }

    public String toString() {
        File file;
        String str;
        try {
            file = getFile();
        } catch (IOException unused) {
            file = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) HttpHeaderNames.CONTENT_DISPOSITION);
        sb.append(": ");
        sb.append((Object) HttpHeaderValues.FORM_DATA);
        sb.append("; ");
        sb.append((Object) HttpHeaderValues.NAME);
        sb.append("=\"");
        sb.append(getName());
        sb.append("\"; ");
        sb.append((Object) HttpHeaderValues.FILENAME);
        sb.append("=\"");
        sb.append(this.filename);
        sb.append("\"\r\n");
        sb.append((Object) HttpHeaderNames.CONTENT_TYPE);
        sb.append(": ");
        sb.append(this.contentType);
        Charset charset = getCharset();
        String str2 = g.f50795q;
        if (charset != null) {
            str2 = "; " + ((Object) HttpHeaderValues.CHARSET) + '=' + getCharset().name() + g.f50795q;
        }
        sb.append(str2);
        sb.append((Object) HttpHeaderNames.CONTENT_LENGTH);
        sb.append(": ");
        sb.append(length());
        sb.append("\r\nCompleted: ");
        sb.append(isCompleted());
        sb.append("\r\nIsInMemory: ");
        sb.append(isInMemory());
        sb.append("\r\nRealFile: ");
        if (file != null) {
            str = file.getAbsolutePath();
        } else {
            str = "null";
        }
        sb.append(str);
        sb.append(" DefaultDeleteAfter: ");
        sb.append(deleteOnExitTemporaryFile);
        return sb.toString();
    }

    public int compareTo(FileUpload fileUpload) {
        return FileUploadUtil.compareTo(this, fileUpload);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileUpload retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileUpload touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileUpload retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public FileUpload touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
