package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import javax.activation.DataHandler;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParameterList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends MimeBodyPart {

    /* renamed from: a, reason: collision with root package name */
    private g f39225a;

    /* renamed from: b, reason: collision with root package name */
    private com.sun.mail.imap.protocol.d f39226b;

    /* renamed from: c, reason: collision with root package name */
    private String f39227c;

    /* renamed from: d, reason: collision with root package name */
    private String f39228d;

    /* renamed from: e, reason: collision with root package name */
    private String f39229e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f39230f = false;

    private synchronized void a() throws MessagingException {
        try {
            if (this.f39230f) {
                return;
            }
            if (this.headers == null) {
                this.headers = new InternetHeaders();
            }
            synchronized (this.f39225a.t()) {
                try {
                    com.sun.mail.imap.protocol.h v5 = this.f39225a.v();
                    this.f39225a.n();
                    if (v5.i0()) {
                        com.sun.mail.imap.protocol.c u02 = v5.u0(this.f39225a.w(), String.valueOf(this.f39227c) + ".MIME");
                        if (u02 == null) {
                            throw new MessagingException("Failed to fetch headers");
                        }
                        ByteArrayInputStream b6 = u02.b();
                        if (b6 == null) {
                            throw new MessagingException("Failed to fetch headers");
                        }
                        this.headers.load(b6);
                    } else {
                        this.headers.addHeader("Content-Type", this.f39228d);
                        this.headers.addHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, this.f39226b.f39409d);
                        String str = this.f39226b.f39414i;
                        if (str != null) {
                            this.headers.addHeader("Content-Description", str);
                        }
                        String str2 = this.f39226b.f39413h;
                        if (str2 != null) {
                            this.headers.addHeader("Content-ID", str2);
                        }
                        String str3 = this.f39226b.f39415j;
                        if (str3 != null) {
                            this.headers.addHeader("Content-MD5", str3);
                        }
                    }
                } catch (ConnectionException e6) {
                    throw new FolderClosedException(this.f39225a.getFolder(), e6.getMessage());
                } catch (ProtocolException e7) {
                    throw new MessagingException(e7.getMessage(), e7);
                }
            }
            this.f39230f = true;
        } catch (Throwable th) {
            throw th;
        } finally {
        }
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        try {
            if (this.dh == null) {
                if (this.f39226b.a()) {
                    this.dh = new DataHandler(new h(this, this.f39226b.f39420o, this.f39227c, this.f39225a));
                } else if (this.f39226b.b() && this.f39225a.A()) {
                    g gVar = this.f39225a;
                    com.sun.mail.imap.protocol.d dVar = this.f39226b;
                    this.dh = new DataHandler(new i(gVar, dVar.f39420o[0], dVar.f39421p, this.f39227c), this.f39228d);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setContent(Object obj, String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        return this.f39226b.f39413h;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        return this.f39226b.f39415j;
    }

    @Override // javax.mail.internet.MimeBodyPart
    protected InputStream getContentStream() throws MessagingException {
        boolean u5 = this.f39225a.u();
        synchronized (this.f39225a.t()) {
            try {
                com.sun.mail.imap.protocol.h v5 = this.f39225a.v();
                this.f39225a.n();
                if (v5.i0() && this.f39225a.r() != -1) {
                    return new f(this.f39225a, this.f39227c, this.f39226b.f39411f, u5);
                }
                int w5 = this.f39225a.w();
                com.sun.mail.imap.protocol.c u02 = u5 ? v5.u0(w5, this.f39227c) : v5.M(w5, this.f39227c);
                ByteArrayInputStream b6 = u02 != null ? u02.b() : null;
                if (b6 != null) {
                    return b6;
                }
                throw new MessagingException("No content");
            } catch (ConnectionException e6) {
                throw new FolderClosedException(this.f39225a.getFolder(), e6.getMessage());
            } catch (ProtocolException e7) {
                throw new MessagingException(e7.getMessage(), e7);
            }
        }
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getContentType() throws MessagingException {
        return this.f39228d;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getDescription() throws MessagingException {
        String str = this.f39229e;
        if (str != null) {
            return str;
        }
        String str2 = this.f39226b.f39414i;
        if (str2 == null) {
            return null;
        }
        try {
            this.f39229e = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f39229e = this.f39226b.f39414i;
        }
        return this.f39229e;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getDisposition() throws MessagingException {
        return this.f39226b.f39412g;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        return this.f39226b.f39409d;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getFileName() throws MessagingException {
        ParameterList parameterList;
        ParameterList parameterList2 = this.f39226b.f39418m;
        String str = parameterList2 != null ? parameterList2.get("filename") : null;
        return (str != null || (parameterList = this.f39226b.f39417l) == null) ? str : parameterList.get(CommonNetImpl.NAME);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public int getLineCount() throws MessagingException {
        return this.f39226b.f39410e;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public int getSize() throws MessagingException {
        return this.f39226b.f39411f;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setContent(Multipart multipart) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart
    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    protected d(com.sun.mail.imap.protocol.d dVar, String str, g gVar) {
        this.f39226b = dVar;
        this.f39227c = str;
        this.f39225a = gVar;
        this.f39228d = new ContentType(dVar.f39407b, dVar.f39408c, dVar.f39417l).toString();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration getAllHeaderLines() throws MessagingException {
        a();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        a();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        a();
        return super.getHeader(str);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        a();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        a();
        return super.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        a();
        return super.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        a();
        return super.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart
    protected void updateHeaders() {
    }
}
