package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.MessageRemovedIOException;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.internal.StringUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.FolderClosedException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.HeaderTokenizer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MimeBodyPart extends BodyPart implements MimePart {
    static boolean cacheMultipart = true;
    private static boolean decodeFileName = false;
    private static boolean encodeFileName = false;
    private static boolean setContentTypeFileName = true;
    private static boolean setDefaultTextCharset = true;
    private Object cachedContent;
    protected byte[] content;
    protected InputStream contentStream;
    protected DataHandler dh;
    protected InternetHeaders headers;

    public MimeBodyPart() {
        this.headers = new InternetHeaders();
    }

    public void attachFile(File file) throws IOException, MessagingException {
        FileDataSource fileDataSource = new FileDataSource(file);
        setDataHandler(new DataHandler(fileDataSource));
        setFileName(fileDataSource.getName());
    }

    @Override // javax.mail.internet.MimePart
    public String[] getContentLanguage() throws MessagingException {
        return getContentLanguage(this);
    }

    @Override // javax.mail.Part
    public String getDescription() throws MessagingException {
        return getDescription(this);
    }

    @Override // javax.mail.Part
    public String getDisposition() throws MessagingException {
        return getDisposition(this);
    }

    public String getEncoding() throws MessagingException {
        return getEncoding(this);
    }

    @Override // javax.mail.Part
    public String getFileName() throws MessagingException {
        return getFileName(this);
    }

    @Override // javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.Part
    public int getLineCount() throws MessagingException {
        return -1;
    }

    @Override // javax.mail.Part
    public boolean isMimeType(String str) throws MessagingException {
        return isMimeType(this, str);
    }

    public void saveFile(File file) throws IOException, MessagingException {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        try {
            inputStream = getInputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                } else {
                    bufferedOutputStream.write(bArr, 0, read);
                }
            }
            inputStream.close();
            try {
                bufferedOutputStream.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            if (bufferedOutputStream == null) {
                throw th;
            }
            try {
                bufferedOutputStream.close();
                throw th;
            } catch (IOException unused4) {
                throw th;
            }
        }
    }

    @Override // javax.mail.Part
    public void setContent(Object obj, String str) throws MessagingException {
        if (obj instanceof Multipart) {
            setContent((Multipart) obj);
        } else {
            setDataHandler(new DataHandler(obj, str));
        }
    }

    @Override // javax.mail.internet.MimePart
    public void setContentLanguage(String[] strArr) throws MessagingException {
        setContentLanguage(this, strArr);
    }

    @Override // javax.mail.Part
    public void setDescription(String str) throws MessagingException {
        setDescription(str, null);
    }

    @Override // javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        setDisposition(this, str);
    }

    @Override // javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        setFileName(this, str);
    }

    @Override // javax.mail.Part, javax.mail.internet.MimePart
    public void setText(String str) throws MessagingException {
        setText(str, null);
    }

    protected void updateHeaders() throws MessagingException {
        updateHeaders(this);
        if (this.cachedContent != null) {
            this.dh = new DataHandler(this.cachedContent, getContentType());
            this.cachedContent = null;
            this.content = null;
            InputStream inputStream = this.contentStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            this.contentStream = null;
        }
    }

    @Override // javax.mail.Part
    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        writeTo(this, outputStream, null);
    }

    static {
        try {
            String property = System.getProperty("mail.mime.setdefaulttextcharset");
            boolean z5 = true;
            setDefaultTextCharset = property == null || !property.equalsIgnoreCase("false");
            String property2 = System.getProperty("mail.mime.setcontenttypefilename");
            setContentTypeFileName = property2 == null || !property2.equalsIgnoreCase("false");
            String property3 = System.getProperty("mail.mime.encodefilename");
            encodeFileName = (property3 == null || property3.equalsIgnoreCase("false")) ? false : true;
            String property4 = System.getProperty("mail.mime.decodefilename");
            decodeFileName = (property4 == null || property4.equalsIgnoreCase("false")) ? false : true;
            String property5 = System.getProperty("mail.mime.cachemultipart");
            if (property5 != null && property5.equalsIgnoreCase("false")) {
                z5 = false;
            }
            cacheMultipart = z5;
        } catch (SecurityException unused) {
        }
    }

    static String[] getContentLanguage(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Language", null);
        if (header == null) {
            return null;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(header, HeaderTokenizer.MIME);
        Vector vector = new Vector();
        while (true) {
            HeaderTokenizer.Token next = headerTokenizer.next();
            int type = next.getType();
            if (type == -4) {
                break;
            }
            if (type == -1) {
                vector.addElement(next.getValue());
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    static String getDescription(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Description", null);
        if (header == null) {
            return null;
        }
        try {
            return MimeUtility.decodeText(MimeUtility.unfold(header));
        } catch (UnsupportedEncodingException unused) {
            return header;
        }
    }

    static String getDisposition(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Disposition", null);
        if (header == null) {
            return null;
        }
        return new ContentDisposition(header).getDisposition();
    }

    static String getEncoding(MimePart mimePart) throws MessagingException {
        HeaderTokenizer.Token next;
        int type;
        String header = mimePart.getHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, null);
        if (header == null) {
            return null;
        }
        String trim = header.trim();
        if (trim.equalsIgnoreCase("7bit") || trim.equalsIgnoreCase("8bit") || trim.equalsIgnoreCase(HttpHeaders.Values.QUOTED_PRINTABLE) || trim.equalsIgnoreCase(HttpHeaders.Values.BINARY) || trim.equalsIgnoreCase(HttpHeaders.Values.BASE64)) {
            return trim;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(trim, HeaderTokenizer.MIME);
        do {
            next = headerTokenizer.next();
            type = next.getType();
            if (type == -4) {
                return trim;
            }
        } while (type != -1);
        return next.getValue();
    }

    static String getFileName(MimePart mimePart) throws MessagingException {
        String header;
        String header2 = mimePart.getHeader("Content-Disposition", null);
        String parameter = header2 != null ? new ContentDisposition(header2).getParameter("filename") : null;
        if (parameter == null && (header = mimePart.getHeader("Content-Type", null)) != null) {
            try {
                parameter = new ContentType(header).getParameter(CommonNetImpl.NAME);
            } catch (ParseException unused) {
            }
        }
        if (!decodeFileName || parameter == null) {
            return parameter;
        }
        try {
            return MimeUtility.decodeText(parameter);
        } catch (UnsupportedEncodingException e6) {
            throw new MessagingException("Can't decode filename", e6);
        }
    }

    static void invalidateContentHeaders(MimePart mimePart) throws MessagingException {
        mimePart.removeHeader("Content-Type");
        mimePart.removeHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING);
    }

    static boolean isMimeType(MimePart mimePart, String str) throws MessagingException {
        try {
            return new ContentType(mimePart.getContentType()).match(str);
        } catch (ParseException unused) {
            return mimePart.getContentType().equalsIgnoreCase(str);
        }
    }

    static void setContentLanguage(MimePart mimePart, String[] strArr) throws MessagingException {
        StringBuffer stringBuffer = new StringBuffer(strArr[0]);
        for (int i6 = 1; i6 < strArr.length; i6++) {
            stringBuffer.append(StringUtil.COMMA);
            stringBuffer.append(strArr[i6]);
        }
        mimePart.setHeader("Content-Language", stringBuffer.toString());
    }

    static void setDisposition(MimePart mimePart, String str) throws MessagingException {
        if (str == null) {
            mimePart.removeHeader("Content-Disposition");
            return;
        }
        String header = mimePart.getHeader("Content-Disposition", null);
        if (header != null) {
            ContentDisposition contentDisposition = new ContentDisposition(header);
            contentDisposition.setDisposition(str);
            str = contentDisposition.toString();
        }
        mimePart.setHeader("Content-Disposition", str);
    }

    static void setEncoding(MimePart mimePart, String str) throws MessagingException {
        mimePart.setHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, str);
    }

    static void setFileName(MimePart mimePart, String str) throws MessagingException {
        String header;
        if (encodeFileName && str != null) {
            try {
                str = MimeUtility.encodeText(str);
            } catch (UnsupportedEncodingException e6) {
                throw new MessagingException("Can't encode filename", e6);
            }
        }
        String header2 = mimePart.getHeader("Content-Disposition", null);
        if (header2 == null) {
            header2 = Part.ATTACHMENT;
        }
        ContentDisposition contentDisposition = new ContentDisposition(header2);
        contentDisposition.setParameter("filename", str);
        mimePart.setHeader("Content-Disposition", contentDisposition.toString());
        if (!setContentTypeFileName || (header = mimePart.getHeader("Content-Type", null)) == null) {
            return;
        }
        try {
            ContentType contentType = new ContentType(header);
            contentType.setParameter(CommonNetImpl.NAME, str);
            mimePart.setHeader("Content-Type", contentType.toString());
        } catch (ParseException unused) {
        }
    }

    static void writeTo(MimePart mimePart, OutputStream outputStream, String[] strArr) throws IOException, MessagingException {
        LineOutputStream lineOutputStream = outputStream instanceof LineOutputStream ? (LineOutputStream) outputStream : new LineOutputStream(outputStream);
        Enumeration nonMatchingHeaderLines = mimePart.getNonMatchingHeaderLines(strArr);
        while (nonMatchingHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln((String) nonMatchingHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        OutputStream encode = MimeUtility.encode(outputStream, mimePart.getEncoding());
        mimePart.getDataHandler().writeTo(encode);
        encode.flush();
    }

    @Override // javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        this.headers.addHeader(str, str2);
    }

    public void addHeaderLine(String str) throws MessagingException {
        this.headers.addHeaderLine(str);
    }

    public Enumeration getAllHeaderLines() throws MessagingException {
        return this.headers.getAllHeaderLines();
    }

    @Override // javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        return this.headers.getAllHeaders();
    }

    @Override // javax.mail.Part
    public Object getContent() throws IOException, MessagingException {
        Object obj = this.cachedContent;
        if (obj != null) {
            return obj;
        }
        try {
            Object content = getDataHandler().getContent();
            if (cacheMultipart && (((content instanceof Multipart) || (content instanceof Message)) && (this.content != null || this.contentStream != null))) {
                this.cachedContent = content;
            }
            return content;
        } catch (FolderClosedIOException e6) {
            throw new FolderClosedException(e6.getFolder(), e6.getMessage());
        } catch (MessageRemovedIOException e7) {
            throw new MessageRemovedException(e7.getMessage());
        }
    }

    public String getContentID() throws MessagingException {
        return getHeader("Content-Id", null);
    }

    public String getContentMD5() throws MessagingException {
        return getHeader("Content-MD5", null);
    }

    protected InputStream getContentStream() throws MessagingException {
        Closeable closeable = this.contentStream;
        if (closeable != null) {
            return ((SharedInputStream) closeable).newStream(0L, -1L);
        }
        if (this.content != null) {
            return new ByteArrayInputStream(this.content);
        }
        throw new MessagingException("No content");
    }

    @Override // javax.mail.Part
    public String getContentType() throws MessagingException {
        String header = getHeader("Content-Type", null);
        return header == null ? "text/plain" : header;
    }

    @Override // javax.mail.Part
    public DataHandler getDataHandler() throws MessagingException {
        if (this.dh == null) {
            this.dh = new DataHandler(new MimePartDataSource(this));
        }
        return this.dh;
    }

    @Override // javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        return this.headers.getHeader(str, str2);
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getMatchingHeaders(strArr);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.Part
    public int getSize() throws MessagingException {
        byte[] bArr = this.content;
        if (bArr != null) {
            return bArr.length;
        }
        InputStream inputStream = this.contentStream;
        if (inputStream == null) {
            return -1;
        }
        try {
            int available = inputStream.available();
            if (available > 0) {
                return available;
            }
            return -1;
        } catch (IOException unused) {
            return -1;
        }
    }

    @Override // javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        this.headers.removeHeader(str);
    }

    public void setContentID(String str) throws MessagingException {
        if (str == null) {
            removeHeader("Content-ID");
        } else {
            setHeader("Content-ID", str);
        }
    }

    public void setContentMD5(String str) throws MessagingException {
        setHeader("Content-MD5", str);
    }

    @Override // javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        this.dh = dataHandler;
        this.cachedContent = null;
        invalidateContentHeaders(this);
    }

    public void setDescription(String str, String str2) throws MessagingException {
        setDescription(this, str, str2);
    }

    @Override // javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        this.headers.setHeader(str, str2);
    }

    @Override // javax.mail.internet.MimePart
    public void setText(String str, String str2) throws MessagingException {
        setText(this, str, str2, "plain");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MimeBodyPart(InputStream inputStream) throws MessagingException {
        boolean z5 = inputStream instanceof ByteArrayInputStream;
        InputStream inputStream2 = inputStream;
        if (!z5) {
            boolean z6 = inputStream instanceof BufferedInputStream;
            inputStream2 = inputStream;
            if (!z6) {
                boolean z7 = inputStream instanceof SharedInputStream;
                inputStream2 = inputStream;
                if (!z7) {
                    inputStream2 = new BufferedInputStream(inputStream);
                }
            }
        }
        this.headers = new InternetHeaders(inputStream2);
        if (inputStream2 instanceof SharedInputStream) {
            SharedInputStream sharedInputStream = (SharedInputStream) inputStream2;
            this.contentStream = sharedInputStream.newStream(sharedInputStream.getPosition(), -1L);
        } else {
            try {
                this.content = ASCIIUtility.getBytes(inputStream2);
            } catch (IOException e6) {
                throw new MessagingException("Error reading input stream", e6);
            }
        }
    }

    static void setDescription(MimePart mimePart, String str, String str2) throws MessagingException {
        if (str != null) {
            try {
                mimePart.setHeader("Content-Description", MimeUtility.fold(21, MimeUtility.encodeText(str, str2, null)));
                return;
            } catch (UnsupportedEncodingException e6) {
                throw new MessagingException("Encoding error", e6);
            }
        }
        mimePart.removeHeader("Content-Description");
    }

    @Override // javax.mail.Part
    public InputStream getInputStream() throws IOException, MessagingException {
        return getDataHandler().getInputStream();
    }

    public InputStream getRawInputStream() throws MessagingException {
        return getContentStream();
    }

    @Override // javax.mail.internet.MimePart
    public void setText(String str, String str2, String str3) throws MessagingException {
        setText(this, str, str2, str3);
    }

    static void setText(MimePart mimePart, String str, String str2, String str3) throws MessagingException {
        if (str2 == null) {
            if (MimeUtility.checkAscii(str) != 1) {
                str2 = MimeUtility.getDefaultMIMECharset();
            } else {
                str2 = "us-ascii";
            }
        }
        mimePart.setContent(str, "text/" + str3 + "; charset=" + MimeUtility.quote(str2, HeaderTokenizer.MIME));
    }

    public void attachFile(String str) throws IOException, MessagingException {
        attachFile(new File(str));
    }

    @Override // javax.mail.Part
    public void setContent(Multipart multipart) throws MessagingException {
        setDataHandler(new DataHandler(multipart, multipart.getContentType()));
        multipart.setParent(this);
    }

    static void updateHeaders(MimePart mimePart) throws MessagingException {
        String defaultMIMECharset;
        String parameter;
        Object content;
        DataHandler dataHandler = mimePart.getDataHandler();
        if (dataHandler == null) {
            return;
        }
        try {
            String contentType = dataHandler.getContentType();
            boolean z5 = mimePart.getHeader("Content-Type") == null;
            ContentType contentType2 = new ContentType(contentType);
            if (contentType2.match("multipart/*")) {
                if (mimePart instanceof MimeBodyPart) {
                    content = ((MimeBodyPart) mimePart).cachedContent;
                    if (content == null) {
                        content = dataHandler.getContent();
                    }
                } else if (mimePart instanceof MimeMessage) {
                    content = ((MimeMessage) mimePart).cachedContent;
                    if (content == null) {
                        content = dataHandler.getContent();
                    }
                } else {
                    content = dataHandler.getContent();
                }
                if (content instanceof MimeMultipart) {
                    ((MimeMultipart) content).updateHeaders();
                } else {
                    throw new MessagingException("MIME part of type \"" + contentType + "\" contains object of type " + content.getClass().getName() + " instead of MimeMultipart");
                }
            } else if (!contentType2.match("message/rfc822")) {
                if (mimePart.getHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING) == null) {
                    setEncoding(mimePart, MimeUtility.getEncoding(dataHandler));
                }
                if (z5 && setDefaultTextCharset && contentType2.match("text/*") && contentType2.getParameter("charset") == null) {
                    String encoding = mimePart.getEncoding();
                    if (encoding != null && encoding.equalsIgnoreCase("7bit")) {
                        defaultMIMECharset = "us-ascii";
                    } else {
                        defaultMIMECharset = MimeUtility.getDefaultMIMECharset();
                    }
                    contentType2.setParameter("charset", defaultMIMECharset);
                    contentType = contentType2.toString();
                }
            }
            if (z5) {
                String header = mimePart.getHeader("Content-Disposition", null);
                if (header != null && (parameter = new ContentDisposition(header).getParameter("filename")) != null) {
                    contentType2.setParameter(CommonNetImpl.NAME, parameter);
                    contentType = contentType2.toString();
                }
                mimePart.setHeader("Content-Type", contentType);
            }
        } catch (IOException e6) {
            throw new MessagingException("IOException updating headers", e6);
        }
    }

    public void saveFile(String str) throws IOException, MessagingException {
        saveFile(new File(str));
    }

    public MimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        this.headers = internetHeaders;
        this.content = bArr;
    }
}
