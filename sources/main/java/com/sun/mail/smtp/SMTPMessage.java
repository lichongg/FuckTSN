package com.sun.mail.smtp;

import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SMTPMessage extends MimeMessage {
    public static final int NOTIFY_DELAY = 4;
    public static final int NOTIFY_FAILURE = 2;
    public static final int NOTIFY_NEVER = -1;
    public static final int NOTIFY_SUCCESS = 1;
    public static final int RETURN_FULL = 1;
    public static final int RETURN_HDRS = 2;
    private static final String[] returnOptionString;
    private boolean allow8bitMIME;
    private String envelopeFrom;
    private String extension;
    private int notifyOptions;
    private int returnOption;
    private boolean sendPartial;
    private String submitter;

    static {
        String[] strArr = new String[3];
        strArr[1] = "FULL";
        strArr[2] = "HDRS";
        returnOptionString = strArr;
    }

    public SMTPMessage(Session session) {
        super(session);
        this.notifyOptions = 0;
        this.returnOption = 0;
        this.sendPartial = false;
        this.allow8bitMIME = false;
        this.submitter = null;
        this.extension = null;
    }

    public void setNotifyOptions(int i6) {
        if (i6 < -1 || i6 >= 8) {
            throw new IllegalArgumentException("Bad return option");
        }
        this.notifyOptions = i6;
    }

    public boolean getAllow8bitMIME() {
        return this.allow8bitMIME;
    }

    String getDSNNotify() {
        int i6 = this.notifyOptions;
        if (i6 == 0) {
            return null;
        }
        if (i6 == -1) {
            return "NEVER";
        }
        StringBuffer stringBuffer = new StringBuffer();
        if ((this.notifyOptions & 1) != 0) {
            stringBuffer.append(MonitorResult.SUCCESS);
        }
        if ((this.notifyOptions & 2) != 0) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(StringUtil.COMMA);
            }
            stringBuffer.append("FAILURE");
        }
        if ((this.notifyOptions & 4) != 0) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(StringUtil.COMMA);
            }
            stringBuffer.append("DELAY");
        }
        return stringBuffer.toString();
    }

    String getDSNRet() {
        return returnOptionString[this.returnOption];
    }

    public String getEnvelopeFrom() {
        return this.envelopeFrom;
    }

    public String getMailExtension() {
        return this.extension;
    }

    public int getNotifyOptions() {
        return this.notifyOptions;
    }

    public int getReturnOption() {
        return this.returnOption;
    }

    public boolean getSendPartial() {
        return this.sendPartial;
    }

    public String getSubmitter() {
        return this.submitter;
    }

    public void setAllow8bitMIME(boolean z5) {
        this.allow8bitMIME = z5;
    }

    public void setEnvelopeFrom(String str) {
        this.envelopeFrom = str;
    }

    public void setMailExtension(String str) {
        this.extension = str;
    }

    public void setReturnOption(int i6) {
        if (i6 < 0 || i6 > 2) {
            throw new IllegalArgumentException("Bad return option");
        }
        this.returnOption = i6;
    }

    public void setSendPartial(boolean z5) {
        this.sendPartial = z5;
    }

    public void setSubmitter(String str) {
        this.submitter = str;
    }

    public SMTPMessage(Session session, InputStream inputStream) throws MessagingException {
        super(session, inputStream);
        this.notifyOptions = 0;
        this.returnOption = 0;
        this.sendPartial = false;
        this.allow8bitMIME = false;
        this.submitter = null;
        this.extension = null;
    }

    public SMTPMessage(MimeMessage mimeMessage) throws MessagingException {
        super(mimeMessage);
        this.notifyOptions = 0;
        this.returnOption = 0;
        this.sendPartial = false;
        this.allow8bitMIME = false;
        this.submitter = null;
        this.extension = null;
    }
}
