package com.sun.mail.pop3;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.SharedInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends MimeMessage {

    /* renamed from: e, reason: collision with root package name */
    static final String f39521e = "UNKNOWN";

    /* renamed from: a, reason: collision with root package name */
    private b f39522a;

    /* renamed from: b, reason: collision with root package name */
    private int f39523b;

    /* renamed from: c, reason: collision with root package name */
    private int f39524c;

    /* renamed from: d, reason: collision with root package name */
    String f39525d;

    private void b() throws MessagingException {
        InputStream n6;
        try {
            synchronized (this) {
                try {
                    if (this.headers != null) {
                        return;
                    }
                    if (!((e) this.f39522a.getStore()).f39536k && (n6 = this.f39522a.g().n(this.msgnum, 0)) != null) {
                        this.f39523b = n6.available();
                        this.headers = new InternetHeaders(n6);
                    }
                    getContentStream().close();
                } finally {
                }
            }
        } catch (EOFException e6) {
            this.f39522a.close(false);
            throw new FolderClosedException(this.f39522a, e6.toString());
        } catch (IOException e7) {
            throw new MessagingException("error loading POP3 headers", e7);
        }
    }

    public synchronized void a(boolean z5) {
        this.content = null;
        this.contentStream = null;
        this.f39524c = -1;
        if (z5) {
            this.headers = null;
            this.f39523b = -1;
        }
    }

    public InputStream c(int i6) throws MessagingException {
        InputStream n6;
        try {
            synchronized (this) {
                n6 = this.f39522a.g().n(this.msgnum, i6);
            }
            return n6;
        } catch (EOFException e6) {
            this.f39522a.close(false);
            throw new FolderClosedException(this.f39522a, e6.toString());
        } catch (IOException e7) {
            throw new MessagingException("error getting size", e7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // javax.mail.internet.MimeMessage
    protected InputStream getContentStream() throws MessagingException {
        int i6;
        try {
            synchronized (this) {
                try {
                    if (this.contentStream == null) {
                        f g6 = this.f39522a.g();
                        int i7 = this.msgnum;
                        int i8 = this.f39524c;
                        InputStream i9 = g6.i(i7, i8 > 0 ? i8 + this.f39523b : 0);
                        if (i9 == 0) {
                            this.expunged = true;
                            throw new MessageRemovedException();
                        }
                        if (this.headers != null && !((e) this.f39522a.getStore()).f39537l) {
                            do {
                                i6 = 0;
                                while (true) {
                                    int read = i9.read();
                                    if (read >= 0 && read != 10) {
                                        if (read != 13) {
                                            i6++;
                                        } else if (i9.available() > 0) {
                                            i9.mark(1);
                                            if (i9.read() != 10) {
                                                i9.reset();
                                            }
                                        }
                                    }
                                }
                                if (i9.available() == 0) {
                                    break;
                                }
                            } while (i6 != 0);
                            this.f39523b = (int) ((SharedInputStream) i9).getPosition();
                            this.contentStream = ((SharedInputStream) i9).newStream(this.f39523b, -1L);
                        }
                        this.headers = new InternetHeaders(i9);
                        this.f39523b = (int) ((SharedInputStream) i9).getPosition();
                        this.contentStream = ((SharedInputStream) i9).newStream(this.f39523b, -1L);
                    }
                } finally {
                }
            }
            return super.getContentStream();
        } catch (EOFException e6) {
            this.f39522a.close(false);
            throw new FolderClosedException(this.f39522a, e6.toString());
        } catch (IOException e7) {
            throw new MessagingException("error fetching POP3 content", e7);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        try {
            synchronized (this) {
                try {
                    int i6 = this.f39524c;
                    if (i6 >= 0) {
                        return i6;
                    }
                    if (i6 < 0) {
                        if (this.headers == null) {
                            b();
                        }
                        InputStream inputStream = this.contentStream;
                        if (inputStream != null) {
                            this.f39524c = inputStream.available();
                        } else {
                            this.f39524c = this.f39522a.g().c(this.msgnum) - this.f39523b;
                        }
                    }
                    return this.f39524c;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (EOFException e6) {
            this.f39522a.close(false);
            throw new FolderClosedException(this.f39522a, e6.toString());
        } catch (IOException e7) {
            throw new MessagingException("error getting size", e7);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getAllHeaderLines() throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void saveChanges() throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setFlags(Flags flags, boolean z5) throws MessagingException {
        Flags flags2 = (Flags) this.flags.clone();
        super.setFlags(flags, z5);
        if (this.flags.equals(flags2)) {
            return;
        }
        this.f39522a.notifyMessageChangedListeners(1, this);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    public c(Folder folder, int i6) throws MessagingException {
        super(folder, i6);
        this.f39523b = -1;
        this.f39524c = -1;
        this.f39525d = "UNKNOWN";
        this.f39522a = (b) folder;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getHeader(str, str2);
    }
}
