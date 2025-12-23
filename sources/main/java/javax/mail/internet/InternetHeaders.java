package javax.mail.internet;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.mail.Header;
import javax.mail.MessagingException;
import org.apache.commons.net.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class InternetHeaders {
    protected List headers;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static final class InternetHeader extends Header {
        String line;

        public InternetHeader(String str) {
            super("", "");
            int indexOf = str.indexOf(58);
            if (indexOf < 0) {
                this.name = str.trim();
            } else {
                this.name = str.substring(0, indexOf).trim();
            }
            this.line = str;
        }

        @Override // javax.mail.Header
        public String getValue() {
            char charAt;
            int indexOf = this.line.indexOf(58);
            if (indexOf < 0) {
                return this.line;
            }
            while (true) {
                indexOf++;
                if (indexOf < this.line.length() && ((charAt = this.line.charAt(indexOf)) == ' ' || charAt == '\t' || charAt == '\r' || charAt == '\n')) {
                }
            }
            return this.line.substring(indexOf);
        }

        public InternetHeader(String str, String str2) {
            super(str, "");
            if (str2 != null) {
                this.line = String.valueOf(str) + ": " + str2;
                return;
            }
            this.line = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class matchEnum implements Enumeration {

        /* renamed from: e, reason: collision with root package name */
        private Iterator f43458e;
        private boolean match;
        private String[] names;
        private InternetHeader next_header = null;
        private boolean want_line;

        private InternetHeader nextMatch() {
            while (this.f43458e.hasNext()) {
                InternetHeader internetHeader = (InternetHeader) this.f43458e.next();
                if (internetHeader.line != null) {
                    if (this.names != null) {
                        int i6 = 0;
                        while (true) {
                            String[] strArr = this.names;
                            if (i6 >= strArr.length) {
                                if (!this.match) {
                                }
                            } else if (!strArr[i6].equalsIgnoreCase(internetHeader.getName())) {
                                i6++;
                            } else if (this.match) {
                            }
                        }
                    } else if (this.match) {
                        return null;
                    }
                    return internetHeader;
                }
            }
            return null;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            if (this.next_header == null) {
                this.next_header = nextMatch();
            }
            return this.next_header != null;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            if (this.next_header == null) {
                this.next_header = nextMatch();
            }
            InternetHeader internetHeader = this.next_header;
            if (internetHeader == null) {
                throw new NoSuchElementException("No more headers");
            }
            this.next_header = null;
            return this.want_line ? internetHeader.line : new Header(internetHeader.getName(), internetHeader.getValue());
        }

        matchEnum(List list, String[] strArr, boolean z5, boolean z6) {
            this.f43458e = list.iterator();
            this.names = strArr;
            this.match = z5;
            this.want_line = z6;
        }
    }

    public InternetHeaders() {
        ArrayList arrayList = new ArrayList(40);
        this.headers = arrayList;
        arrayList.add(new InternetHeader("Return-Path", null));
        this.headers.add(new InternetHeader("Received", null));
        this.headers.add(new InternetHeader("Resent-Date", null));
        this.headers.add(new InternetHeader("Resent-From", null));
        this.headers.add(new InternetHeader("Resent-Sender", null));
        this.headers.add(new InternetHeader("Resent-To", null));
        this.headers.add(new InternetHeader("Resent-Cc", null));
        this.headers.add(new InternetHeader("Resent-Bcc", null));
        this.headers.add(new InternetHeader("Resent-Message-Id", null));
        this.headers.add(new InternetHeader("Date", null));
        this.headers.add(new InternetHeader("From", null));
        this.headers.add(new InternetHeader("Sender", null));
        this.headers.add(new InternetHeader("Reply-To", null));
        this.headers.add(new InternetHeader("To", null));
        this.headers.add(new InternetHeader("Cc", null));
        this.headers.add(new InternetHeader("Bcc", null));
        this.headers.add(new InternetHeader("Message-Id", null));
        this.headers.add(new InternetHeader("In-Reply-To", null));
        this.headers.add(new InternetHeader("References", null));
        this.headers.add(new InternetHeader("Subject", null));
        this.headers.add(new InternetHeader("Comments", null));
        this.headers.add(new InternetHeader("Keywords", null));
        this.headers.add(new InternetHeader("Errors-To", null));
        this.headers.add(new InternetHeader("MIME-Version", null));
        this.headers.add(new InternetHeader("Content-Type", null));
        this.headers.add(new InternetHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, null));
        this.headers.add(new InternetHeader("Content-MD5", null));
        this.headers.add(new InternetHeader(":", null));
        this.headers.add(new InternetHeader("Content-Length", null));
        this.headers.add(new InternetHeader("Status", null));
    }

    public void addHeaderLine(String str) {
        try {
            char charAt = str.charAt(0);
            if (charAt != ' ' && charAt != '\t') {
                this.headers.add(new InternetHeader(str));
                return;
            }
            InternetHeader internetHeader = (InternetHeader) this.headers.get(r0.size() - 1);
            internetHeader.line = String.valueOf(internetHeader.line) + g.f50795q + str;
        } catch (StringIndexOutOfBoundsException | NoSuchElementException unused) {
        }
    }

    public Enumeration getAllHeaderLines() {
        return getNonMatchingHeaderLines(null);
    }

    public String[] getHeader(String str) {
        ArrayList arrayList = new ArrayList();
        for (InternetHeader internetHeader : this.headers) {
            if (str.equalsIgnoreCase(internetHeader.getName()) && internetHeader.line != null) {
                arrayList.add(internetHeader.getValue());
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void removeHeader(String str) {
        for (int i6 = 0; i6 < this.headers.size(); i6++) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(i6);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                internetHeader.line = null;
            }
        }
    }

    public void setHeader(String str, String str2) {
        int indexOf;
        int i6 = 0;
        boolean z5 = false;
        while (i6 < this.headers.size()) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(i6);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                if (z5) {
                    this.headers.remove(i6);
                    i6--;
                } else {
                    String str3 = internetHeader.line;
                    if (str3 == null || (indexOf = str3.indexOf(58)) < 0) {
                        internetHeader.line = str + ": " + str2;
                    } else {
                        internetHeader.line = String.valueOf(internetHeader.line.substring(0, indexOf + 1)) + " " + str2;
                    }
                    z5 = true;
                }
            }
            i6++;
        }
        if (z5) {
            return;
        }
        addHeader(str, str2);
    }

    public void addHeader(String str, String str2) {
        int size = this.headers.size();
        boolean z5 = str.equalsIgnoreCase("Received") || str.equalsIgnoreCase("Return-Path");
        if (z5) {
            size = 0;
        }
        for (int size2 = this.headers.size() - 1; size2 >= 0; size2--) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(size2);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                if (!z5) {
                    this.headers.add(size2 + 1, new InternetHeader(str, str2));
                    return;
                }
                size = size2;
            }
            if (internetHeader.getName().equals(":")) {
                size = size2;
            }
        }
        this.headers.add(size, new InternetHeader(str, str2));
    }

    public Enumeration getAllHeaders() {
        return new matchEnum(this.headers, null, false, false);
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) {
        return new matchEnum(this.headers, strArr, true, true);
    }

    public Enumeration getMatchingHeaders(String[] strArr) {
        return new matchEnum(this.headers, strArr, true, false);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) {
        return new matchEnum(this.headers, strArr, false, true);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) {
        return new matchEnum(this.headers, strArr, false, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        r6.append(r2);
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e A[Catch: IOException -> 0x0023, TRY_LEAVE, TryCatch #0 {IOException -> 0x0023, blocks: (B:3:0x000c, B:5:0x0012, B:7:0x001a, B:11:0x0027, B:12:0x002b, B:14:0x004e, B:23:0x0036, B:25:0x003a, B:27:0x0040), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void load(java.io.InputStream r6) throws javax.mail.MessagingException {
        /*
            r5 = this;
            com.sun.mail.util.LineInputStream r0 = new com.sun.mail.util.LineInputStream
            r0.<init>(r6)
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            r1 = 0
            r2 = r1
        Lc:
            java.lang.String r3 = r0.readLine()     // Catch: java.io.IOException -> L23
            if (r3 == 0) goto L34
            java.lang.String r4 = " "
            boolean r4 = r3.startsWith(r4)     // Catch: java.io.IOException -> L23
            if (r4 != 0) goto L25
            java.lang.String r4 = "\t"
            boolean r4 = r3.startsWith(r4)     // Catch: java.io.IOException -> L23
            if (r4 == 0) goto L34
            goto L25
        L23:
            r6 = move-exception
            goto L55
        L25:
            if (r2 == 0) goto L2b
            r6.append(r2)     // Catch: java.io.IOException -> L23
            r2 = r1
        L2b:
            java.lang.String r4 = "\r\n"
            r6.append(r4)     // Catch: java.io.IOException -> L23
            r6.append(r3)     // Catch: java.io.IOException -> L23
            goto L4c
        L34:
            if (r2 == 0) goto L3a
            r5.addHeaderLine(r2)     // Catch: java.io.IOException -> L23
            goto L4b
        L3a:
            int r2 = r6.length()     // Catch: java.io.IOException -> L23
            if (r2 <= 0) goto L4b
            java.lang.String r2 = r6.toString()     // Catch: java.io.IOException -> L23
            r5.addHeaderLine(r2)     // Catch: java.io.IOException -> L23
            r2 = 0
            r6.setLength(r2)     // Catch: java.io.IOException -> L23
        L4b:
            r2 = r3
        L4c:
            if (r3 == 0) goto L54
            int r3 = r3.length()     // Catch: java.io.IOException -> L23
            if (r3 > 0) goto Lc
        L54:
            return
        L55:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException
            java.lang.String r1 = "Error in input stream"
            r0.<init>(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.InternetHeaders.load(java.io.InputStream):void");
    }

    public String getHeader(String str, String str2) {
        String[] header = getHeader(str);
        if (header == null) {
            return null;
        }
        if (header.length != 1 && str2 != null) {
            StringBuffer stringBuffer = new StringBuffer(header[0]);
            for (int i6 = 1; i6 < header.length; i6++) {
                stringBuffer.append(str2);
                stringBuffer.append(header[i6]);
            }
            return stringBuffer.toString();
        }
        return header[0];
    }

    public InternetHeaders(InputStream inputStream) throws MessagingException {
        this.headers = new ArrayList(40);
        load(inputStream);
    }
}
