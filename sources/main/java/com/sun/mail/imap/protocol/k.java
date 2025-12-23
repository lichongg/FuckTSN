package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.mail.internet.MailDateFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class k implements l {

    /* renamed from: c, reason: collision with root package name */
    static final char[] f39464c = {'I', 'N', 'T', 'E', 'R', 'N', 'A', 'L', 'D', 'A', 'T', 'E'};

    /* renamed from: d, reason: collision with root package name */
    private static MailDateFormat f39465d = new MailDateFormat();

    /* renamed from: e, reason: collision with root package name */
    private static SimpleDateFormat f39466e = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss ", Locale.US);

    /* renamed from: a, reason: collision with root package name */
    public int f39467a;

    /* renamed from: b, reason: collision with root package name */
    protected Date f39468b;

    public static String a(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (f39466e) {
            f39466e.format(date, stringBuffer, new FieldPosition(0));
        }
        int i6 = -date.getTimezoneOffset();
        if (i6 < 0) {
            stringBuffer.append('-');
            i6 = -i6;
        } else {
            stringBuffer.append('+');
        }
        int i7 = i6 / 60;
        int i8 = i6 % 60;
        stringBuffer.append(Character.forDigit(i7 / 10, 10));
        stringBuffer.append(Character.forDigit(i7 % 10, 10));
        stringBuffer.append(Character.forDigit(i8 / 10, 10));
        stringBuffer.append(Character.forDigit(i8 % 10, 10));
        return stringBuffer.toString();
    }

    public Date b() {
        return this.f39468b;
    }

    public k(f fVar) throws ParsingException {
        this.f39467a = fVar.E();
        fVar.B();
        String w5 = fVar.w();
        if (w5 != null) {
            try {
                this.f39468b = f39465d.parse(w5);
                return;
            } catch (ParseException unused) {
                throw new ParsingException("INTERNALDATE parse error");
            }
        }
        throw new ParsingException("INTERNALDATE is NIL");
    }
}
