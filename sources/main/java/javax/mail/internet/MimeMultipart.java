package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineOutputStream;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.MultipartDataSource;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MimeMultipart extends Multipart {
    private static boolean bmparse = true;
    private static boolean ignoreMissingBoundaryParameter = true;
    private static boolean ignoreMissingEndBoundary = true;
    private boolean complete;
    protected DataSource ds;
    protected boolean parsed;
    private String preamble;

    public MimeMultipart() {
        this("mixed");
    }

    private static int readFully(InputStream inputStream, byte[] bArr, int i6, int i7) throws IOException {
        int i8 = 0;
        if (i7 == 0) {
            return 0;
        }
        while (i7 > 0) {
            int read = inputStream.read(bArr, i6, i7);
            if (read <= 0) {
                break;
            }
            i6 += read;
            i8 += read;
            i7 -= read;
        }
        if (i8 > 0) {
            return i8;
        }
        return -1;
    }

    @Override // javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart);
    }

    protected MimeBodyPart createMimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        return new MimeBodyPart(internetHeaders, bArr);
    }

    @Override // javax.mail.Multipart
    public synchronized BodyPart getBodyPart(int i6) throws MessagingException {
        parse();
        return super.getBodyPart(i6);
    }

    @Override // javax.mail.Multipart
    public synchronized int getCount() throws MessagingException {
        parse();
        return super.getCount();
    }

    public synchronized String getPreamble() throws MessagingException {
        parse();
        return this.preamble;
    }

    public synchronized boolean isComplete() throws MessagingException {
        parse();
        return this.complete;
    }

    @Override // javax.mail.Multipart
    public boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        return super.removeBodyPart(bodyPart);
    }

    public synchronized void setPreamble(String str) throws MessagingException {
        this.preamble = str;
    }

    public synchronized void setSubType(String str) throws MessagingException {
        ContentType contentType = new ContentType(this.contentType);
        contentType.setSubType(str);
        this.contentType = contentType.toString();
    }

    protected void updateHeaders() throws MessagingException {
        for (int i6 = 0; i6 < this.parts.size(); i6++) {
            ((MimeBodyPart) this.parts.elementAt(i6)).updateHeaders();
        }
    }

    @Override // javax.mail.Multipart
    public synchronized void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        try {
            parse();
            String str = "--" + new ContentType(this.contentType).getParameter(HttpHeaders.Values.BOUNDARY);
            LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
            String str2 = this.preamble;
            if (str2 != null) {
                byte[] bytes = ASCIIUtility.getBytes(str2);
                lineOutputStream.write(bytes);
                if (bytes.length > 0 && bytes[bytes.length - 1] != 13 && bytes[bytes.length - 1] != 10) {
                    lineOutputStream.writeln();
                }
            }
            for (int i6 = 0; i6 < this.parts.size(); i6++) {
                lineOutputStream.writeln(str);
                ((MimeBodyPart) this.parts.elementAt(i6)).writeTo(outputStream);
                lineOutputStream.writeln();
            }
            lineOutputStream.writeln(String.valueOf(str) + "--");
        } catch (Throwable th) {
            throw th;
        }
    }

    static {
        try {
            String property = System.getProperty("mail.mime.multipart.ignoremissingendboundary");
            boolean z5 = true;
            ignoreMissingEndBoundary = property == null || !property.equalsIgnoreCase("false");
            String property2 = System.getProperty("mail.mime.multipart.ignoremissingboundaryparameter");
            ignoreMissingBoundaryParameter = property2 == null || !property2.equalsIgnoreCase("false");
            String property3 = System.getProperty("mail.mime.multipart.bmparse");
            if (property3 != null && property3.equalsIgnoreCase("false")) {
                z5 = false;
            }
            bmparse = z5;
        } catch (SecurityException unused) {
        }
    }

    public MimeMultipart(String str) {
        this.ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        String uniqueBoundaryValue = UniqueValue.getUniqueBoundaryValue();
        ContentType contentType = new ContentType("multipart", str, null);
        contentType.setParameter(HttpHeaders.Values.BOUNDARY, uniqueBoundaryValue);
        this.contentType = contentType.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0189, code lost:
    
        r12 = r7;
        r30 = r8;
        r17 = (r0.getPosition() - r6) - r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a2 A[Catch: all -> 0x008e, IOException -> 0x0091, TryCatch #6 {all -> 0x008e, IOException -> 0x0091, blocks: (B:24:0x0055, B:25:0x005c, B:56:0x00a1, B:57:0x00a7, B:61:0x00b3, B:77:0x00b8, B:80:0x00c7, B:81:0x00cb, B:83:0x00d1, B:205:0x00d9, B:207:0x00dd, B:215:0x00e6, B:216:0x00ed, B:88:0x00fc, B:91:0x0104, B:92:0x0112, B:93:0x0119, B:192:0x0124, B:195:0x012a, B:196:0x012e, B:150:0x01d6, B:152:0x0204, B:153:0x01e1, B:155:0x01e5, B:156:0x01f2, B:159:0x01f8, B:160:0x01fc, B:198:0x013d, B:199:0x0144, B:104:0x015a, B:112:0x016c, B:121:0x023a, B:126:0x0251, B:127:0x0257, B:129:0x0262, B:132:0x0270, B:137:0x027d, B:138:0x0283, B:142:0x0189, B:143:0x019a, B:145:0x01a2, B:148:0x01aa, B:174:0x01c5, B:176:0x01cf, B:181:0x021f, B:97:0x014c, B:99:0x029d, B:200:0x010c, B:202:0x02b1, B:203:0x02b8, B:219:0x00f3, B:63:0x02b9, B:69:0x02dd, B:72:0x02c9, B:65:0x02ce, B:67:0x02d6, B:59:0x02f0, B:222:0x0310, B:223:0x0317, B:27:0x0069, B:33:0x0079, B:35:0x0081, B:38:0x0318, B:47:0x0320, B:42:0x032f, B:43:0x033d, B:224:0x0094, B:29:0x0071, B:237:0x0363, B:238:0x036a), top: B:23:0x0055, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0343 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v5, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void parsebm() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 897
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parsebm():void");
    }

    private void skipFully(InputStream inputStream, long j6) throws IOException {
        while (j6 > 0) {
            long skip = inputStream.skip(j6);
            if (skip <= 0) {
                throw new EOFException("can't skip");
            }
            j6 -= skip;
        }
    }

    protected InternetHeaders createInternetHeaders(InputStream inputStream) throws MessagingException {
        return new InternetHeaders(inputStream);
    }

    protected MimeBodyPart createMimeBodyPart(InputStream inputStream) throws MessagingException {
        return new MimeBodyPart(inputStream);
    }

    /* JADX WARN: Code restructure failed: missing block: B:173:0x00d0, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x012b, code lost:
    
        r15 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x018b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x020f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0065 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected synchronized void parse() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parse():void");
    }

    public synchronized BodyPart getBodyPart(String str) throws MessagingException {
        parse();
        int count = getCount();
        for (int i6 = 0; i6 < count; i6++) {
            MimeBodyPart mimeBodyPart = (MimeBodyPart) getBodyPart(i6);
            String contentID = mimeBodyPart.getContentID();
            if (contentID != null && contentID.equals(str)) {
                return mimeBodyPart;
            }
        }
        return null;
    }

    @Override // javax.mail.Multipart
    public void removeBodyPart(int i6) throws MessagingException {
        parse();
        super.removeBodyPart(i6);
    }

    @Override // javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart, int i6) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart, i6);
    }

    public MimeMultipart(DataSource dataSource) throws MessagingException {
        this.ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        if (dataSource instanceof MessageAware) {
            setParent(((MessageAware) dataSource).getMessageContext().getPart());
        }
        if (dataSource instanceof MultipartDataSource) {
            setMultipartDataSource((MultipartDataSource) dataSource);
            return;
        }
        this.parsed = false;
        this.ds = dataSource;
        this.contentType = dataSource.getContentType();
    }
}
