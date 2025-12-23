package com.sun.mail.smtp;

import com.snail.antifake.deviceid.e;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.ParseException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SMTPTransport extends Transport {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String UNKNOWN = "UNKNOWN";
    private Address[] addresses;
    private SMTPOutputStream dataStream;
    private int defaultPort;
    private MessagingException exception;
    private Hashtable extMap;
    private Address[] invalidAddr;
    private boolean isSSL;
    private int lastReturnCode;
    private String lastServerResponse;
    private LineInputStream lineInputStream;
    private String localHostName;
    private DigestMD5 md5support;
    private MimeMessage message;
    private String name;
    private PrintStream out;
    private boolean quitWait;
    private boolean reportSuccess;
    private String saslRealm;
    private boolean sendPartiallyFailed;
    private BufferedInputStream serverInput;
    private OutputStream serverOutput;
    private Socket serverSocket;
    private boolean useRset;
    private boolean useStartTLS;
    private Address[] validSentAddr;
    private Address[] validUnsentAddr;
    private static final String[] ignoreList = {"Bcc", "Content-Length"};
    private static final byte[] CRLF = {13, 10};
    private static char[] hexchar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public SMTPTransport(Session session, URLName uRLName) {
        this(session, uRLName, "smtp", 25, false);
    }

    private void closeConnection() throws MessagingException {
        try {
            try {
                Socket socket = this.serverSocket;
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e6) {
                throw new MessagingException("Server Close Failed", e6);
            }
        } finally {
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (super.isConnected()) {
                super.close();
            }
        }
    }

    private boolean convertTo8Bit(MimePart mimePart) {
        try {
            if (mimePart.isMimeType("text/*")) {
                String encoding = mimePart.getEncoding();
                if (encoding == null) {
                    return false;
                }
                if ((!encoding.equalsIgnoreCase(HttpHeaders.Values.QUOTED_PRINTABLE) && !encoding.equalsIgnoreCase(HttpHeaders.Values.BASE64)) || !is8Bit(mimePart.getInputStream())) {
                    return false;
                }
                mimePart.setContent(mimePart.getContent(), mimePart.getContentType());
                mimePart.setHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, "8bit");
                return true;
            }
            if (!mimePart.isMimeType("multipart/*")) {
                return false;
            }
            MimeMultipart mimeMultipart = (MimeMultipart) mimePart.getContent();
            int count = mimeMultipart.getCount();
            boolean z5 = false;
            for (int i6 = 0; i6 < count; i6++) {
                try {
                    if (convertTo8Bit((MimePart) mimeMultipart.getBodyPart(i6))) {
                        z5 = true;
                    }
                } catch (IOException | MessagingException unused) {
                    return z5;
                }
            }
            return z5;
        } catch (IOException | MessagingException unused2) {
            return false;
        }
    }

    private void expandGroups() {
        Vector vector = null;
        int i6 = 0;
        while (true) {
            Address[] addressArr = this.addresses;
            if (i6 >= addressArr.length) {
                break;
            }
            InternetAddress internetAddress = (InternetAddress) addressArr[i6];
            if (internetAddress.isGroup()) {
                if (vector == null) {
                    Vector vector2 = new Vector();
                    for (int i7 = 0; i7 < i6; i7++) {
                        vector2.addElement(this.addresses[i7]);
                    }
                    vector = vector2;
                }
                try {
                    InternetAddress[] group = internetAddress.getGroup(true);
                    if (group != null) {
                        for (InternetAddress internetAddress2 : group) {
                            vector.addElement(internetAddress2);
                        }
                    } else {
                        vector.addElement(internetAddress);
                    }
                } catch (ParseException unused) {
                    vector.addElement(internetAddress);
                }
            } else if (vector != null) {
                vector.addElement(internetAddress);
            }
            i6++;
        }
        if (vector != null) {
            InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
            vector.copyInto(internetAddressArr);
            this.addresses = internetAddressArr;
        }
    }

    private synchronized DigestMD5 getMD5() {
        try {
            if (this.md5support == null) {
                this.md5support = new DigestMD5(this.debug ? this.out : null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.md5support;
    }

    private boolean is8Bit(InputStream inputStream) {
        boolean z5 = false;
        int i6 = 0;
        while (true) {
            try {
                int read = inputStream.read();
                if (read < 0) {
                    if (this.debug && z5) {
                        this.out.getClass();
                    }
                    return z5;
                }
                int i7 = read & 255;
                if (i7 == 13 || i7 == 10) {
                    i6 = 0;
                } else if (i7 == 0 || (i6 = i6 + 1) > 998) {
                    return false;
                }
                if (i7 > 127) {
                    z5 = true;
                }
            } catch (IOException unused) {
                return false;
            }
        }
    }

    private void openServer(String str, int i6) throws MessagingException {
        if (this.debug) {
            this.out.getClass();
        }
        try {
            Socket socket = SocketFetcher.getSocket(str, i6, this.session.getProperties(), "mail." + this.name, this.isSSL);
            this.serverSocket = socket;
            int port = socket.getPort();
            initStreams();
            int readServerResponse = readServerResponse();
            if (readServerResponse == 220) {
                if (this.debug) {
                    this.out.getClass();
                    return;
                }
                return;
            }
            this.serverSocket.close();
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (this.debug) {
                this.out.getClass();
            }
            throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + port + ", response: " + readServerResponse);
        } catch (UnknownHostException e6) {
            throw new MessagingException("Unknown SMTP host: " + str, e6);
        } catch (IOException e7) {
            throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + i6, e7);
        }
    }

    protected static String xtext(String str) {
        StringBuffer stringBuffer = null;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt >= 128) {
                throw new IllegalArgumentException("Non-ASCII character in SMTP submitter: " + str);
            }
            if (charAt < '!' || charAt > '~' || charAt == '+' || charAt == '=') {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.length() + 4);
                    stringBuffer.append(str.substring(0, i6));
                }
                stringBuffer.append('+');
                stringBuffer.append(hexchar[(charAt & 240) >> 4]);
                stringBuffer.append(hexchar[charAt & 15]);
            } else if (stringBuffer != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer != null ? stringBuffer.toString() : str;
    }

    @Override // javax.mail.Service
    public synchronized void close() throws MessagingException {
        int readServerResponse;
        if (super.isConnected()) {
            try {
                if (this.serverSocket != null) {
                    sendCommand("QUIT");
                    if (this.quitWait && (readServerResponse = readServerResponse()) != 221 && readServerResponse != -1) {
                        this.out.getClass();
                    }
                }
            } finally {
                closeConnection();
            }
        }
    }

    public synchronized void connect(Socket socket) throws MessagingException {
        this.serverSocket = socket;
        super.connect();
    }

    public synchronized int getLastReturnCode() {
        return this.lastReturnCode;
    }

    public synchronized String getLastServerResponse() {
        return this.lastServerResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[Catch: all -> 0x000c, UnknownHostException -> 0x0081, TRY_LEAVE, TryCatch #0 {UnknownHostException -> 0x0081, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x002b, B:10:0x002f, B:12:0x0052, B:14:0x0056, B:21:0x005c, B:23:0x0068, B:25:0x0035, B:26:0x000e), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String getLocalHost() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.localHostName     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            if (r0 == 0) goto Le
            int r0 = r0.length()     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            if (r0 > 0) goto L2b
            goto Le
        Lc:
            r0 = move-exception
            goto L85
        Le:
            javax.mail.Session r0 = r3.session     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r2 = "mail."
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r2 = r3.name     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r2 = ".localhost"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r0 = r0.getProperty(r1)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            r3.localHostName = r0     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
        L2b:
            java.lang.String r0 = r3.localHostName     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            if (r0 == 0) goto L35
            int r0 = r0.length()     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            if (r0 > 0) goto L52
        L35:
            javax.mail.Session r0 = r3.session     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r2 = "mail."
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r2 = r3.name     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r2 = ".localaddress"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r0 = r0.getProperty(r1)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            r3.localHostName = r0     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
        L52:
            java.lang.String r0 = r3.localHostName     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            if (r0 == 0) goto L5c
            int r0 = r0.length()     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            if (r0 > 0) goto L81
        L5c:
            java.net.InetAddress r0 = java.net.InetAddress.getLocalHost()     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r1 = r0.getHostName()     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            r3.localHostName = r1     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            if (r1 != 0) goto L81
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r2 = "["
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r0 = r0.getHostAddress()     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            r1.append(r0)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r0 = "]"
            r1.append(r0)     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
            r3.localHostName = r0     // Catch: java.lang.Throwable -> Lc java.net.UnknownHostException -> L81
        L81:
            java.lang.String r0 = r3.localHostName     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r3)
            return r0
        L85:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lc
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.getLocalHost():java.lang.String");
    }

    public synchronized boolean getReportSuccess() {
        return this.reportSuccess;
    }

    public synchronized String getSASLRealm() {
        try {
            if (this.saslRealm == "UNKNOWN") {
                String property = this.session.getProperty("mail." + this.name + ".sasl.realm");
                this.saslRealm = property;
                if (property == null) {
                    this.saslRealm = this.session.getProperty("mail." + this.name + ".saslrealm");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.saslRealm;
    }

    public synchronized boolean getStartTLS() {
        return this.useStartTLS;
    }

    public synchronized boolean getUseRset() {
        return this.useRset;
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        try {
            if (!super.isConnected()) {
                return false;
            }
            try {
                try {
                    if (this.useRset) {
                        sendCommand("RSET");
                    } else {
                        sendCommand("NOOP");
                    }
                    int readServerResponse = readServerResponse();
                    if (readServerResponse >= 0 && readServerResponse != 421) {
                        return true;
                    }
                    try {
                        closeConnection();
                    } catch (MessagingException unused) {
                    }
                    return false;
                } catch (MessagingException unused2) {
                    return false;
                }
            } catch (Exception unused3) {
                closeConnection();
                return false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void issueCommand(String str, int i6) throws MessagingException {
        sendCommand(str);
        if (readServerResponse() != i6) {
            throw new MessagingException(this.lastServerResponse);
        }
    }

    protected void sendCommand(String str) throws MessagingException {
        sendCommand(ASCIIUtility.getBytes(str));
    }

    public synchronized void setLocalHost(String str) {
        this.localHostName = str;
    }

    public synchronized void setReportSuccess(boolean z5) {
        this.reportSuccess = z5;
    }

    public synchronized void setSASLRealm(String str) {
        this.saslRealm = str;
    }

    public synchronized void setStartTLS(boolean z5) {
        this.useStartTLS = z5;
    }

    public synchronized void setUseRset(boolean z5) {
        this.useRset = z5;
    }

    public synchronized int simpleCommand(String str) throws MessagingException {
        sendCommand(str);
        return readServerResponse();
    }

    protected SMTPTransport(Session session, URLName uRLName, String str, int i6, boolean z5) {
        super(session, uRLName);
        this.name = "smtp";
        this.defaultPort = 25;
        boolean z6 = false;
        this.isSSL = false;
        this.sendPartiallyFailed = false;
        this.quitWait = false;
        this.saslRealm = "UNKNOWN";
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.name = str;
        this.defaultPort = i6;
        this.isSSL = z5;
        this.out = session.getDebugOut();
        String property = session.getProperty("mail." + str + ".quitwait");
        this.quitWait = property == null || property.equalsIgnoreCase("true");
        String property2 = session.getProperty("mail." + str + ".reportsuccess");
        this.reportSuccess = property2 != null && property2.equalsIgnoreCase("true");
        String property3 = session.getProperty("mail." + str + ".starttls.enable");
        this.useStartTLS = property3 != null && property3.equalsIgnoreCase("true");
        String property4 = session.getProperty("mail." + str + ".userset");
        if (property4 != null && property4.equalsIgnoreCase("true")) {
            z6 = true;
        }
        this.useRset = z6;
    }

    private void initStreams() throws IOException {
        Properties properties = this.session.getProperties();
        PrintStream debugOut = this.session.getDebugOut();
        boolean debug = this.session.getDebug();
        String property = properties.getProperty("mail.debug.quote");
        boolean z5 = property != null && property.equalsIgnoreCase("true");
        TraceInputStream traceInputStream = new TraceInputStream(this.serverSocket.getInputStream(), debugOut);
        traceInputStream.setTrace(debug);
        traceInputStream.setQuote(z5);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.serverSocket.getOutputStream(), debugOut);
        traceOutputStream.setTrace(debug);
        traceOutputStream.setQuote(z5);
        this.serverOutput = new BufferedOutputStream(traceOutputStream);
        this.serverInput = new BufferedInputStream(traceInputStream);
        this.lineInputStream = new LineInputStream(this.serverInput);
    }

    private boolean isNotLastLine(String str) {
        return str != null && str.length() >= 4 && str.charAt(3) == '-';
    }

    private String normalizeAddress(String str) {
        if (str.startsWith("<") || str.endsWith(">")) {
            return str;
        }
        return "<" + str + ">";
    }

    private void sendCommand(byte[] bArr) throws MessagingException {
        try {
            this.serverOutput.write(bArr);
            this.serverOutput.write(CRLF);
            this.serverOutput.flush();
        } catch (IOException e6) {
            throw new MessagingException("Can't send command to SMTP host", e6);
        }
    }

    protected OutputStream data() throws MessagingException {
        issueSendCommand("DATA", 354);
        SMTPOutputStream sMTPOutputStream = new SMTPOutputStream(this.serverOutput);
        this.dataStream = sMTPOutputStream;
        return sMTPOutputStream;
    }

    protected boolean ehlo(String str) throws MessagingException {
        String str2;
        if (str != null) {
            str2 = "EHLO " + str;
        } else {
            str2 = "EHLO";
        }
        sendCommand(str2);
        int readServerResponse = readServerResponse();
        if (readServerResponse == 250) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(this.lastServerResponse));
            this.extMap = new Hashtable();
            boolean z5 = true;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (z5) {
                        z5 = false;
                    } else if (readLine.length() >= 5) {
                        String substring = readLine.substring(4);
                        int indexOf = substring.indexOf(32);
                        String str3 = "";
                        if (indexOf > 0) {
                            str3 = substring.substring(indexOf + 1);
                            substring = substring.substring(0, indexOf);
                        }
                        if (this.debug) {
                            this.out.getClass();
                        }
                        this.extMap.put(substring.toUpperCase(Locale.ENGLISH), str3);
                    }
                } catch (IOException unused) {
                }
            }
        }
        return readServerResponse == 250;
    }

    protected void finishData() throws IOException, MessagingException {
        this.dataStream.ensureAtBOL();
        issueSendCommand(".", 250);
    }

    public String getExtensionParameter(String str) {
        Hashtable hashtable = this.extMap;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str.toUpperCase(Locale.ENGLISH));
    }

    protected void helo(String str) throws MessagingException {
        if (str == null) {
            issueCommand("HELO", 250);
            return;
        }
        issueCommand("HELO " + str, 250);
    }

    protected void mailFrom() throws MessagingException {
        Address[] from;
        MimeMessage mimeMessage = this.message;
        String envelopeFrom = mimeMessage instanceof SMTPMessage ? ((SMTPMessage) mimeMessage).getEnvelopeFrom() : null;
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            envelopeFrom = this.session.getProperty("mail." + this.name + ".from");
        }
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            MimeMessage mimeMessage2 = this.message;
            Address localAddress = (mimeMessage2 == null || (from = mimeMessage2.getFrom()) == null || from.length <= 0) ? InternetAddress.getLocalAddress(this.session) : from[0];
            if (localAddress == null) {
                throw new MessagingException("can't determine local email address");
            }
            envelopeFrom = ((InternetAddress) localAddress).getAddress();
        }
        String str = "MAIL FROM:" + normalizeAddress(envelopeFrom);
        if (supportsExtension("DSN")) {
            MimeMessage mimeMessage3 = this.message;
            String dSNRet = mimeMessage3 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage3).getDSNRet() : null;
            if (dSNRet == null) {
                dSNRet = this.session.getProperty("mail." + this.name + ".dsn.ret");
            }
            if (dSNRet != null) {
                str = String.valueOf(str) + " RET=" + dSNRet;
            }
        }
        if (supportsExtension("AUTH")) {
            MimeMessage mimeMessage4 = this.message;
            String submitter = mimeMessage4 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage4).getSubmitter() : null;
            if (submitter == null) {
                submitter = this.session.getProperty("mail." + this.name + ".submitter");
            }
            if (submitter != null) {
                try {
                    str = String.valueOf(str) + " AUTH=" + xtext(submitter);
                } catch (IllegalArgumentException e6) {
                    if (this.debug) {
                        PrintStream printStream = this.out;
                        e6.toString();
                        printStream.getClass();
                    }
                }
            }
        }
        MimeMessage mimeMessage5 = this.message;
        String mailExtension = mimeMessage5 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage5).getMailExtension() : null;
        if (mailExtension == null) {
            mailExtension = this.session.getProperty("mail." + this.name + ".mailextension");
        }
        if (mailExtension != null && mailExtension.length() > 0) {
            str = String.valueOf(str) + " " + mailExtension;
        }
        issueSendCommand(str, 250);
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x01be  */
    @Override // javax.mail.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean protocolConnect(java.lang.String r14, int r15, java.lang.String r16, java.lang.String r17) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 549
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.protocolConnect(java.lang.String, int, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void rcptTo() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 724
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.rcptTo():void");
    }

    protected int readServerResponse() throws MessagingException {
        String readLine;
        int i6;
        StringBuffer stringBuffer = new StringBuffer(100);
        do {
            try {
                readLine = this.lineInputStream.readLine();
                if (readLine == null) {
                    String stringBuffer2 = stringBuffer.toString();
                    if (stringBuffer2.length() == 0) {
                        stringBuffer2 = "[EOF]";
                    }
                    this.lastServerResponse = stringBuffer2;
                    this.lastReturnCode = -1;
                    if (this.debug) {
                        this.out.getClass();
                    }
                    return -1;
                }
                stringBuffer.append(readLine);
                stringBuffer.append(e.f37542d);
            } catch (IOException e6) {
                if (this.debug) {
                    PrintStream printStream = this.out;
                    e6.toString();
                    printStream.getClass();
                }
                this.lastServerResponse = "";
                this.lastReturnCode = 0;
                throw new MessagingException("Exception reading response", e6);
            }
        } while (isNotLastLine(readLine));
        String stringBuffer3 = stringBuffer.toString();
        if (stringBuffer3 != null && stringBuffer3.length() >= 3) {
            try {
                try {
                    try {
                        i6 = Integer.parseInt(stringBuffer3.substring(0, 3));
                    } catch (NumberFormatException unused) {
                        close();
                    } catch (StringIndexOutOfBoundsException unused2) {
                        close();
                    }
                } catch (MessagingException e7) {
                    if (this.debug) {
                        e7.printStackTrace(this.out);
                    }
                }
            } catch (MessagingException e8) {
                if (this.debug) {
                    e8.printStackTrace(this.out);
                }
            }
            if (i6 == -1 && this.debug) {
                this.out.getClass();
            }
            this.lastServerResponse = stringBuffer3;
            this.lastReturnCode = i6;
            return i6;
        }
        i6 = -1;
        if (i6 == -1) {
            this.out.getClass();
        }
        this.lastServerResponse = stringBuffer3;
        this.lastReturnCode = i6;
        return i6;
    }

    @Override // javax.mail.Transport
    public synchronized void sendMessage(Message message, Address[] addressArr) throws MessagingException, SendFailedException {
        try {
            checkConnected();
            if (!(message instanceof MimeMessage)) {
                if (this.debug) {
                    this.out.getClass();
                }
                throw new MessagingException("SMTP can only send RFC822 messages");
            }
            for (int i6 = 0; i6 < addressArr.length; i6++) {
                if (!(addressArr[i6] instanceof InternetAddress)) {
                    throw new MessagingException(addressArr[i6] + " is not an InternetAddress");
                }
            }
            this.message = (MimeMessage) message;
            this.addresses = addressArr;
            this.validUnsentAddr = addressArr;
            expandGroups();
            boolean allow8bitMIME = message instanceof SMTPMessage ? ((SMTPMessage) message).getAllow8bitMIME() : false;
            if (!allow8bitMIME) {
                String property = this.session.getProperty("mail." + this.name + ".allow8bitmime");
                allow8bitMIME = property != null && property.equalsIgnoreCase("true");
            }
            if (this.debug) {
                this.out.getClass();
            }
            if (allow8bitMIME && supportsExtension("8BITMIME") && convertTo8Bit(this.message)) {
                try {
                    this.message.saveChanges();
                } catch (MessagingException unused) {
                }
            }
            try {
                try {
                    mailFrom();
                    rcptTo();
                    this.message.writeTo(data(), ignoreList);
                    finishData();
                    if (this.sendPartiallyFailed) {
                        if (this.debug) {
                            this.out.getClass();
                        }
                        notifyTransportListeners(3, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                        throw new SMTPSendFailedException(".", this.lastReturnCode, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
                    }
                    notifyTransportListeners(1, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                    this.invalidAddr = null;
                    this.validUnsentAddr = null;
                    this.validSentAddr = null;
                    this.addresses = null;
                    this.message = null;
                    this.exception = null;
                    this.sendPartiallyFailed = false;
                } catch (IOException e6) {
                    if (this.debug) {
                        e6.printStackTrace(this.out);
                    }
                    try {
                        closeConnection();
                    } catch (MessagingException unused2) {
                    }
                    notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                    throw new MessagingException("IOException while sending message", e6);
                } catch (MessagingException e7) {
                    if (this.debug) {
                        e7.printStackTrace(this.out);
                    }
                    notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                    throw e7;
                }
            } finally {
                this.invalidAddr = null;
                this.validUnsentAddr = null;
                this.validSentAddr = null;
                this.addresses = null;
                this.message = null;
                this.exception = null;
                this.sendPartiallyFailed = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected void startTLS() throws MessagingException {
        issueCommand("STARTTLS", 220);
        try {
            this.serverSocket = SocketFetcher.startTLS(this.serverSocket, this.session.getProperties(), "mail." + this.name);
            initStreams();
        } catch (IOException e6) {
            closeConnection();
            throw new MessagingException("Could not convert socket to TLS", e6);
        }
    }

    protected boolean supportsAuthentication(String str) {
        String str2;
        Hashtable hashtable = this.extMap;
        if (hashtable == null || (str2 = (String) hashtable.get("AUTH")) == null) {
            return false;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        while (stringTokenizer.hasMoreTokens()) {
            if (stringTokenizer.nextToken().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean supportsExtension(String str) {
        Hashtable hashtable = this.extMap;
        return (hashtable == null || hashtable.get(str.toUpperCase(Locale.ENGLISH)) == null) ? false : true;
    }

    private void issueSendCommand(String str, int i6) throws MessagingException {
        int length;
        int length2;
        sendCommand(str);
        int readServerResponse = readServerResponse();
        if (readServerResponse != i6) {
            Address[] addressArr = this.validSentAddr;
            if (addressArr == null) {
                length = 0;
            } else {
                length = addressArr.length;
            }
            Address[] addressArr2 = this.validUnsentAddr;
            if (addressArr2 == null) {
                length2 = 0;
            } else {
                length2 = addressArr2.length;
            }
            Address[] addressArr3 = new Address[length + length2];
            if (length > 0) {
                System.arraycopy(addressArr, 0, addressArr3, 0, length);
            }
            if (length2 > 0) {
                System.arraycopy(this.validUnsentAddr, 0, addressArr3, length, length2);
            }
            this.validSentAddr = null;
            this.validUnsentAddr = addressArr3;
            if (this.debug) {
                this.out.getClass();
            }
            String str2 = this.lastServerResponse;
            int i7 = this.lastReturnCode;
            if (this.serverSocket != null) {
                issueCommand("RSET", 250);
            }
            this.lastServerResponse = str2;
            this.lastReturnCode = i7;
            throw new SMTPSendFailedException(str, readServerResponse, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
        }
    }

    protected void checkConnected() {
        if (super.isConnected()) {
        } else {
            throw new IllegalStateException("Not connected");
        }
    }

    @Override // javax.mail.Service
    protected void finalize() throws Throwable {
        super.finalize();
        try {
            closeConnection();
        } catch (MessagingException unused) {
        }
    }

    protected int simpleCommand(byte[] bArr) throws MessagingException {
        sendCommand(bArr);
        return readServerResponse();
    }

    private void openServer() throws MessagingException {
        try {
            int port = this.serverSocket.getPort();
            String hostName = this.serverSocket.getInetAddress().getHostName();
            if (this.debug) {
                this.out.getClass();
            }
            initStreams();
            int readServerResponse = readServerResponse();
            if (readServerResponse != 220) {
                this.serverSocket.close();
                this.serverSocket = null;
                this.serverOutput = null;
                this.serverInput = null;
                this.lineInputStream = null;
                if (this.debug) {
                    this.out.getClass();
                }
                throw new MessagingException("Got bad greeting from SMTP host: " + hostName + ", port: " + port + ", response: " + readServerResponse);
            }
            if (this.debug) {
                this.out.getClass();
            }
        } catch (IOException e6) {
            throw new MessagingException("Could not start protocol to SMTP host: UNKNOWN, port: -1", e6);
        }
    }
}
