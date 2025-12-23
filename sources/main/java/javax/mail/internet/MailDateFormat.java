package javax.mail.internet;

import java.io.PrintStream;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MailDateFormat extends SimpleDateFormat {
    static boolean debug = false;
    private static final long serialVersionUID = -8148227605210628779L;
    private static TimeZone tz = TimeZone.getTimeZone("GMT");
    private static Calendar cal = new GregorianCalendar(tz);

    public MailDateFormat() {
        super("EEE, d MMM yyyy HH:mm:ss 'XXXXX' (z)", Locale.US);
    }

    private static synchronized Date ourUTC(int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z5) {
        Date time;
        synchronized (MailDateFormat.class) {
            cal.clear();
            cal.setLenient(z5);
            cal.set(1, i6);
            cal.set(2, i7);
            cal.set(5, i8);
            cal.set(11, i9);
            cal.set(12, i10 + i12);
            cal.set(13, i11);
            time = cal.getTime();
        }
        return time;
    }

    private static Date parseDate(char[] cArr, ParsePosition parsePosition, boolean z5) {
        try {
            MailDateParser mailDateParser = new MailDateParser(cArr);
            mailDateParser.skipUntilNumber();
            int parseNumber = mailDateParser.parseNumber();
            if (!mailDateParser.skipIfChar('-')) {
                mailDateParser.skipWhiteSpace();
            }
            int parseMonth = mailDateParser.parseMonth();
            if (!mailDateParser.skipIfChar('-')) {
                mailDateParser.skipWhiteSpace();
            }
            int parseNumber2 = mailDateParser.parseNumber();
            if (parseNumber2 < 50) {
                parseNumber2 += 2000;
            } else if (parseNumber2 < 100) {
                parseNumber2 += 1900;
            }
            mailDateParser.skipWhiteSpace();
            int parseNumber3 = mailDateParser.parseNumber();
            mailDateParser.skipChar(':');
            int parseNumber4 = mailDateParser.parseNumber();
            int i6 = 0;
            int parseNumber5 = mailDateParser.skipIfChar(':') ? mailDateParser.parseNumber() : 0;
            try {
                mailDateParser.skipWhiteSpace();
                i6 = mailDateParser.parseTimeZone();
            } catch (java.text.ParseException unused) {
                if (debug) {
                    PrintStream printStream = System.out;
                    new String(cArr);
                    printStream.getClass();
                }
            }
            parsePosition.setIndex(mailDateParser.getIndex());
            return ourUTC(parseNumber2, parseMonth, parseNumber, parseNumber3, parseNumber4, parseNumber5, i6, z5);
        } catch (Exception e6) {
            if (debug) {
                PrintStream printStream2 = System.out;
                new String(cArr);
                printStream2.getClass();
                e6.printStackTrace();
            }
            parsePosition.setIndex(1);
            return null;
        }
    }

    @Override // java.text.DateFormat
    public void setCalendar(Calendar calendar) {
        throw new RuntimeException("Method setCalendar() shouldn't be called");
    }

    @Override // java.text.DateFormat
    public void setNumberFormat(NumberFormat numberFormat) {
        throw new RuntimeException("Method setNumberFormat() shouldn't be called");
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int i6;
        int length = stringBuffer.length();
        super.format(date, stringBuffer, fieldPosition);
        int i7 = length + 25;
        while (stringBuffer.charAt(i7) != 'X') {
            i7++;
        }
        ((SimpleDateFormat) this).calendar.clear();
        ((SimpleDateFormat) this).calendar.setTime(date);
        int i8 = ((SimpleDateFormat) this).calendar.get(15) + ((SimpleDateFormat) this).calendar.get(16);
        if (i8 < 0) {
            i6 = i7 + 1;
            stringBuffer.setCharAt(i7, '-');
            i8 = -i8;
        } else {
            i6 = i7 + 1;
            stringBuffer.setCharAt(i7, '+');
        }
        int i9 = (i8 / 60) / 1000;
        int i10 = i9 / 60;
        int i11 = i9 % 60;
        stringBuffer.setCharAt(i6, Character.forDigit(i10 / 10, 10));
        stringBuffer.setCharAt(i6 + 1, Character.forDigit(i10 % 10, 10));
        stringBuffer.setCharAt(i6 + 2, Character.forDigit(i11 / 10, 10));
        stringBuffer.setCharAt(i6 + 3, Character.forDigit(i11 % 10, 10));
        return stringBuffer;
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return parseDate(str.toCharArray(), parsePosition, isLenient());
    }
}
