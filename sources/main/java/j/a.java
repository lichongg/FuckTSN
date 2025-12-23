package j;

import java.util.Date;
import java.util.Properties;
import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends Authenticator {

    /* renamed from: a, reason: collision with root package name */
    private String f43434a;

    /* renamed from: b, reason: collision with root package name */
    private String f43435b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f43436c;

    /* renamed from: d, reason: collision with root package name */
    private String f43437d;

    /* renamed from: e, reason: collision with root package name */
    private String f43438e;

    /* renamed from: f, reason: collision with root package name */
    private String f43439f;

    /* renamed from: g, reason: collision with root package name */
    private String f43440g;

    /* renamed from: h, reason: collision with root package name */
    private String f43441h;

    /* renamed from: i, reason: collision with root package name */
    private String f43442i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f43443j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f43444k;

    /* renamed from: l, reason: collision with root package name */
    private Multipart f43445l;

    public a() {
        this.f43440g = "smtp.qq.com";
        this.f43438e = "587";
        this.f43439f = "587";
        this.f43434a = "";
        this.f43435b = "";
        this.f43437d = "";
        this.f43441h = "";
        this.f43442i = "";
        this.f43444k = false;
        this.f43443j = true;
        this.f43445l = new MimeMultipart();
        MailcapCommandMap mailcapCommandMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mailcapCommandMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
        mailcapCommandMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mailcapCommandMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mailcapCommandMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mailcapCommandMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mailcapCommandMap);
    }

    private Properties a() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", this.f43440g);
        if (this.f43444k) {
            properties.put("mail.debug", "true");
        }
        if (this.f43443j) {
            properties.put("mail.smtp.auth", "true");
        }
        properties.put("mail.smtp.port", this.f43438e);
        properties.put("mail.password", "dylanandroid2dev");
        properties.put("mail.smtp.socketFactory.port", this.f43439f);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        return properties;
    }

    public void A(String str) {
        this.f43441h = str;
    }

    public void B(String[] strArr) {
        this.f43436c = strArr;
    }

    public void C(String str) {
        this.f43434a = str;
    }

    public void b(String str) throws Exception {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDataHandler(new DataHandler(new FileDataSource(str)));
        mimeBodyPart.setFileName(str.split("/")[r4.length - 1]);
        this.f43445l.addBodyPart(mimeBodyPart);
    }

    public String c() {
        return this.f43442i;
    }

    public String d() {
        return this.f43442i;
    }

    public String e() {
        return this.f43437d;
    }

    public String f() {
        return this.f43440g;
    }

    public Multipart g() {
        return this.f43445l;
    }

    @Override // javax.mail.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.f43434a, this.f43435b);
    }

    public String h() {
        return this.f43435b;
    }

    public String i() {
        return this.f43438e;
    }

    public String j() {
        return this.f43439f;
    }

    public String k() {
        return this.f43441h;
    }

    public String[] l() {
        return this.f43436c;
    }

    public String m() {
        return this.f43434a;
    }

    public boolean n() {
        return this.f43443j;
    }

    public boolean o() {
        return this.f43444k;
    }

    public void q(String str) {
        this.f43442i = str;
    }

    public void r(boolean z5) {
        this.f43443j = z5;
    }

    public void s(String str) {
        this.f43442i = str;
    }

    public void t(boolean z5) {
        this.f43444k = z5;
    }

    public void u(String str) {
        this.f43437d = str;
    }

    public void v(String str) {
        this.f43440g = str;
    }

    public void w(Multipart multipart) {
        this.f43445l = multipart;
    }

    public void x(String str) {
        this.f43435b = str;
    }

    public void y(String str) {
        this.f43438e = str;
    }

    public void z(String str) {
        this.f43439f = str;
    }

    public boolean p() throws Exception {
        Properties a6 = a();
        if (this.f43434a.equals("") || this.f43435b.equals("") || this.f43436c.length <= 0 || this.f43437d.equals("") || this.f43441h.equals("") || this.f43442i.equals("")) {
            return false;
        }
        MimeMessage mimeMessage = new MimeMessage(Session.getInstance(a6, this));
        mimeMessage.setFrom(new InternetAddress(this.f43437d));
        InternetAddress[] internetAddressArr = new InternetAddress[this.f43436c.length];
        for (int i6 = 0; i6 < this.f43436c.length; i6++) {
            internetAddressArr[i6] = new InternetAddress(this.f43436c[i6]);
        }
        mimeMessage.setRecipients(Message.RecipientType.TO, internetAddressArr);
        mimeMessage.setSubject(this.f43441h);
        mimeMessage.setSentDate(new Date());
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(this.f43442i);
        this.f43445l.addBodyPart(mimeBodyPart);
        mimeMessage.setContent(this.f43445l);
        Transport.send(mimeMessage);
        return true;
    }

    public a(String str, String str2) {
        this();
        this.f43434a = str;
        this.f43435b = str2;
    }
}
