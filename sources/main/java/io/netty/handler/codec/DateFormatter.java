package io.netty.handler.codec;

import com.umeng.socialize.common.SocializeConstants;
import io.netty.util.AsciiString;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import java.util.BitSet;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DateFormatter {
    private static final String[] CALENDAR_MONTH_TO_SHORT_NAME;
    private static final String[] DAY_OF_WEEK_TO_SHORT_NAME;
    private static final BitSet DELIMITERS;
    private static final FastThreadLocal<DateFormatter> INSTANCES;
    private final GregorianCalendar cal;
    private int dayOfMonth;
    private boolean dayOfMonthFound;
    private int hours;
    private int minutes;
    private int month;
    private boolean monthFound;
    private final StringBuilder sb;
    private int seconds;
    private boolean timeFound;
    private int year;
    private boolean yearFound;

    private boolean parse1(CharSequence charSequence, int i6, int i7) {
        int i8 = -1;
        while (i6 < i7) {
            if (isDelim(charSequence.charAt(i6))) {
                if (i8 == -1) {
                    continue;
                } else {
                    if (parseToken(charSequence, i8, i6)) {
                        return true;
                    }
                    i8 = -1;
                }
            } else if (i8 == -1) {
                i8 = i6;
            }
            i6++;
        }
        return i8 != -1 && parseToken(charSequence, i8, charSequence.length());
    }

    public static Date parseHttpDate(CharSequence charSequence) {
        return parseHttpDate(charSequence, 0, charSequence.length());
    }

    private boolean tryParseDayOfMonth(CharSequence charSequence, int i6, int i7) {
        int i8 = i7 - i6;
        if (i8 == 1) {
            char charAt = charSequence.charAt(i6);
            if (!isDigit(charAt)) {
                return false;
            }
            this.dayOfMonth = getNumericalValue(charAt);
            return true;
        }
        if (i8 != 2) {
            return false;
        }
        char charAt2 = charSequence.charAt(i6);
        char charAt3 = charSequence.charAt(i6 + 1);
        if (!isDigit(charAt2) || !isDigit(charAt3)) {
            return false;
        }
        this.dayOfMonth = (getNumericalValue(charAt2) * 10) + getNumericalValue(charAt3);
        return true;
    }

    private boolean tryParseMonth(CharSequence charSequence, int i6, int i7) {
        if (i7 - i6 != 3) {
            return false;
        }
        char lowerCase = AsciiString.toLowerCase(charSequence.charAt(i6));
        char lowerCase2 = AsciiString.toLowerCase(charSequence.charAt(i6 + 1));
        char lowerCase3 = AsciiString.toLowerCase(charSequence.charAt(i6 + 2));
        if (lowerCase == 'j' && lowerCase2 == 'a' && lowerCase3 == 'n') {
            this.month = 0;
        } else if (lowerCase == 'f' && lowerCase2 == 'e' && lowerCase3 == 'b') {
            this.month = 1;
        } else if (lowerCase == 'm' && lowerCase2 == 'a' && lowerCase3 == 'r') {
            this.month = 2;
        } else if (lowerCase == 'a' && lowerCase2 == 'p' && lowerCase3 == 'r') {
            this.month = 3;
        } else if (lowerCase == 'm' && lowerCase2 == 'a' && lowerCase3 == 'y') {
            this.month = 4;
        } else if (lowerCase == 'j' && lowerCase2 == 'u' && lowerCase3 == 'n') {
            this.month = 5;
        } else if (lowerCase == 'j' && lowerCase2 == 'u' && lowerCase3 == 'l') {
            this.month = 6;
        } else if (lowerCase == 'a' && lowerCase2 == 'u' && lowerCase3 == 'g') {
            this.month = 7;
        } else if (lowerCase == 's' && lowerCase2 == 'e' && lowerCase3 == 'p') {
            this.month = 8;
        } else if (lowerCase == 'o' && lowerCase2 == 'c' && lowerCase3 == 't') {
            this.month = 9;
        } else if (lowerCase == 'n' && lowerCase2 == 'o' && lowerCase3 == 'v') {
            this.month = 10;
        } else {
            if (lowerCase != 'd' || lowerCase2 != 'e' || lowerCase3 != 'c') {
                return false;
            }
            this.month = 11;
        }
        return true;
    }

    private boolean tryParseYear(CharSequence charSequence, int i6, int i7) {
        int i8 = i7 - i6;
        if (i8 == 2) {
            char charAt = charSequence.charAt(i6);
            char charAt2 = charSequence.charAt(i6 + 1);
            if (!isDigit(charAt) || !isDigit(charAt2)) {
                return false;
            }
            this.year = (getNumericalValue(charAt) * 10) + getNumericalValue(charAt2);
            return true;
        }
        if (i8 != 4) {
            return false;
        }
        char charAt3 = charSequence.charAt(i6);
        char charAt4 = charSequence.charAt(i6 + 1);
        char charAt5 = charSequence.charAt(i6 + 2);
        char charAt6 = charSequence.charAt(i6 + 3);
        if (!isDigit(charAt3) || !isDigit(charAt4) || !isDigit(charAt5) || !isDigit(charAt6)) {
            return false;
        }
        this.year = (getNumericalValue(charAt3) * 1000) + (getNumericalValue(charAt4) * 100) + (getNumericalValue(charAt5) * 10) + getNumericalValue(charAt6);
        return true;
    }

    public void reset() {
        this.timeFound = false;
        this.hours = -1;
        this.minutes = -1;
        this.seconds = -1;
        this.dayOfMonthFound = false;
        this.dayOfMonth = -1;
        this.monthFound = false;
        this.month = -1;
        this.yearFound = false;
        this.year = -1;
        this.cal.clear();
        this.sb.setLength(0);
    }

    static {
        BitSet bitSet = new BitSet();
        DELIMITERS = bitSet;
        bitSet.set(9);
        for (char c6 = ' '; c6 <= '/'; c6 = (char) (c6 + 1)) {
            DELIMITERS.set(c6);
        }
        for (char c7 = ';'; c7 <= '@'; c7 = (char) (c7 + 1)) {
            DELIMITERS.set(c7);
        }
        for (char c8 = '['; c8 <= '`'; c8 = (char) (c8 + 1)) {
            DELIMITERS.set(c8);
        }
        for (char c9 = '{'; c9 <= '~'; c9 = (char) (c9 + 1)) {
            DELIMITERS.set(c9);
        }
        DAY_OF_WEEK_TO_SHORT_NAME = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        CALENDAR_MONTH_TO_SHORT_NAME = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        INSTANCES = new FastThreadLocal<DateFormatter>() { // from class: io.netty.handler.codec.DateFormatter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public DateFormatter initialValue() {
                return new DateFormatter();
            }
        };
    }

    private DateFormatter() {
        this.cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        this.sb = new StringBuilder(29);
        reset();
    }

    private StringBuilder append0(Date date, StringBuilder sb) {
        this.cal.setTime(date);
        sb.append(DAY_OF_WEEK_TO_SHORT_NAME[this.cal.get(7) - 1]);
        sb.append(", ");
        sb.append(this.cal.get(5));
        sb.append(' ');
        sb.append(CALENDAR_MONTH_TO_SHORT_NAME[this.cal.get(2)]);
        sb.append(' ');
        sb.append(this.cal.get(1));
        sb.append(' ');
        appendZeroLeftPadded(this.cal.get(11), sb).append(':');
        appendZeroLeftPadded(this.cal.get(12), sb).append(':');
        StringBuilder appendZeroLeftPadded = appendZeroLeftPadded(this.cal.get(13), sb);
        appendZeroLeftPadded.append(" GMT");
        return appendZeroLeftPadded;
    }

    private static StringBuilder appendZeroLeftPadded(int i6, StringBuilder sb) {
        if (i6 < 10) {
            sb.append('0');
        }
        sb.append(i6);
        return sb;
    }

    private Date computeDate() {
        this.cal.set(5, this.dayOfMonth);
        this.cal.set(2, this.month);
        this.cal.set(1, this.year);
        this.cal.set(11, this.hours);
        this.cal.set(12, this.minutes);
        this.cal.set(13, this.seconds);
        return this.cal.getTime();
    }

    private String format0(Date date) {
        append0(date, this.sb);
        return this.sb.toString();
    }

    private static DateFormatter formatter() {
        DateFormatter dateFormatter = INSTANCES.get();
        dateFormatter.reset();
        return dateFormatter;
    }

    private static int getNumericalValue(char c6) {
        return c6 - '0';
    }

    private static boolean isDelim(char c6) {
        return DELIMITERS.get(c6);
    }

    private static boolean isDigit(char c6) {
        return c6 >= '0' && c6 <= '9';
    }

    private boolean normalizeAndValidate() {
        int i6 = this.dayOfMonth;
        if (i6 < 1 || i6 > 31 || this.hours > 23 || this.minutes > 59 || this.seconds > 59) {
            return false;
        }
        int i7 = this.year;
        if (i7 >= 70 && i7 <= 99) {
            this.year = i7 + 1900;
        } else if (i7 >= 0 && i7 < 70) {
            this.year = i7 + 2000;
        } else if (i7 < 1601) {
            return false;
        }
        return true;
    }

    public static Date parseHttpDate(CharSequence charSequence, int i6, int i7) {
        int i8 = i7 - i6;
        if (i8 == 0) {
            return null;
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("Can't have end < start");
        }
        if (i8 <= 64) {
            return formatter().parse0((CharSequence) ObjectUtil.checkNotNull(charSequence, SocializeConstants.KEY_TEXT), i6, i7);
        }
        throw new IllegalArgumentException("Can't parse more than 64 chars,looks like a user error or a malformed header");
    }

    private boolean parseToken(CharSequence charSequence, int i6, int i7) {
        if (!this.timeFound) {
            boolean tryParseTime = tryParseTime(charSequence, i6, i7);
            this.timeFound = tryParseTime;
            if (tryParseTime) {
                return this.dayOfMonthFound && this.monthFound && this.yearFound;
            }
        }
        if (!this.dayOfMonthFound) {
            boolean tryParseDayOfMonth = tryParseDayOfMonth(charSequence, i6, i7);
            this.dayOfMonthFound = tryParseDayOfMonth;
            if (tryParseDayOfMonth) {
                return this.timeFound && this.monthFound && this.yearFound;
            }
        }
        if (!this.monthFound) {
            boolean tryParseMonth = tryParseMonth(charSequence, i6, i7);
            this.monthFound = tryParseMonth;
            if (tryParseMonth) {
                return this.timeFound && this.dayOfMonthFound && this.yearFound;
            }
        }
        if (!this.yearFound) {
            this.yearFound = tryParseYear(charSequence, i6, i7);
        }
        return this.timeFound && this.dayOfMonthFound && this.monthFound && this.yearFound;
    }

    private boolean tryParseTime(CharSequence charSequence, int i6, int i7) {
        int i8 = i7 - i6;
        if (i8 >= 5 && i8 <= 8) {
            int i9 = 0;
            int i10 = 0;
            int i11 = -1;
            int i12 = -1;
            int i13 = 0;
            while (i6 < i7) {
                char charAt = charSequence.charAt(i6);
                if (isDigit(charAt)) {
                    i10 = (i10 * 10) + getNumericalValue(charAt);
                    i9++;
                    if (i9 > 2) {
                        return false;
                    }
                } else {
                    if (charAt != ':' || i9 == 0) {
                        return false;
                    }
                    if (i13 != 0) {
                        if (i13 != 1) {
                            return false;
                        }
                        i12 = i10;
                        i10 = i11;
                    }
                    i13++;
                    i11 = i10;
                    i9 = 0;
                    i10 = 0;
                }
                i6++;
            }
            int i14 = i9 > 0 ? i10 : -1;
            if (i11 >= 0 && i12 >= 0 && i14 >= 0) {
                this.hours = i11;
                this.minutes = i12;
                this.seconds = i14;
                return true;
            }
        }
        return false;
    }

    public static StringBuilder append(Date date, StringBuilder sb) {
        return formatter().append0((Date) ObjectUtil.checkNotNull(date, "date"), (StringBuilder) ObjectUtil.checkNotNull(sb, "sb"));
    }

    public static String format(Date date) {
        return formatter().format0((Date) ObjectUtil.checkNotNull(date, "date"));
    }

    private Date parse0(CharSequence charSequence, int i6, int i7) {
        if (parse1(charSequence, i6, i7) && normalizeAndValidate()) {
            return computeDate();
        }
        return null;
    }
}
