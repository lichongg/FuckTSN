package org.apache.commons.net.ftp.parser;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class g implements f, org.apache.commons.net.ftp.a {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f50739h = {14, 13, 12, 11, 5, 2, 1};

    /* renamed from: c, reason: collision with root package name */
    private SimpleDateFormat f50740c;

    /* renamed from: d, reason: collision with root package name */
    private int f50741d;

    /* renamed from: e, reason: collision with root package name */
    private SimpleDateFormat f50742e;

    /* renamed from: f, reason: collision with root package name */
    private int f50743f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f50744g = false;

    private static int e(SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat == null) {
            return 0;
        }
        String pattern = simpleDateFormat.toPattern();
        for (char c6 : "SsmHdM".toCharArray()) {
            if (pattern.indexOf(c6) != -1) {
                if (c6 == 'H') {
                    return j(11);
                }
                if (c6 == 'M') {
                    return j(2);
                }
                if (c6 == 'S') {
                    return j(14);
                }
                if (c6 == 'd') {
                    return j(5);
                }
                if (c6 == 'm') {
                    return j(12);
                }
                if (c6 == 's') {
                    return j(13);
                }
            }
        }
        return 0;
    }

    private static int j(int i6) {
        int i7 = 0;
        while (true) {
            int[] iArr = f50739h;
            if (i7 >= iArr.length) {
                return 0;
            }
            if (i6 == iArr[i7]) {
                return i7;
            }
            i7++;
        }
    }

    private void m(String str, DateFormatSymbols dateFormatSymbols) {
        if (str != null) {
            if (dateFormatSymbols != null) {
                this.f50740c = new SimpleDateFormat(str, dateFormatSymbols);
            } else {
                this.f50740c = new SimpleDateFormat(str);
            }
            this.f50740c.setLenient(false);
        } else {
            this.f50740c = null;
        }
        this.f50741d = e(this.f50740c);
    }

    private static void o(int i6, Calendar calendar) {
        if (i6 <= 0) {
            return;
        }
        int i7 = f50739h[i6 - 1];
        if (calendar.get(i7) != 0) {
            return;
        }
        calendar.clear(i7);
    }

    private void p(String str, DateFormatSymbols dateFormatSymbols) {
        if (str != null) {
            if (dateFormatSymbols != null) {
                this.f50742e = new SimpleDateFormat(str, dateFormatSymbols);
            } else {
                this.f50742e = new SimpleDateFormat(str);
            }
            this.f50742e.setLenient(false);
        } else {
            this.f50742e = null;
        }
        this.f50743f = e(this.f50742e);
    }

    public SimpleDateFormat b() {
        return this.f50740c;
    }

    public String d() {
        return this.f50740c.toPattern();
    }

    public SimpleDateFormat f() {
        return this.f50742e;
    }

    public String g() {
        return this.f50742e.toPattern();
    }

    public TimeZone h() {
        return this.f50740c.getTimeZone();
    }

    public String[] i() {
        return this.f50740c.getDateFormatSymbols().getShortMonths();
    }

    boolean k() {
        return this.f50744g;
    }

    void n(boolean z5) {
        this.f50744g = z5;
    }

    public g() {
        m(f.f50737a, null);
        p(f.f50738b, null);
    }

    private void q(String str) {
        TimeZone timeZone = TimeZone.getDefault();
        if (str != null) {
            timeZone = TimeZone.getTimeZone(str);
        }
        this.f50740c.setTimeZone(timeZone);
        SimpleDateFormat simpleDateFormat = this.f50742e;
        if (simpleDateFormat != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
    }

    @Override // org.apache.commons.net.ftp.parser.f
    public Calendar a(String str) throws ParseException {
        return l(str, Calendar.getInstance());
    }

    @Override // org.apache.commons.net.ftp.a
    public void c(org.apache.commons.net.ftp.d dVar) {
        DateFormatSymbols k6;
        String d6 = dVar.d();
        String g6 = dVar.g();
        if (g6 != null) {
            k6 = org.apache.commons.net.ftp.d.a(g6);
        } else if (d6 != null) {
            k6 = org.apache.commons.net.ftp.d.k(d6);
        } else {
            k6 = org.apache.commons.net.ftp.d.k("en");
        }
        p(dVar.c(), k6);
        String b6 = dVar.b();
        if (b6 != null) {
            m(b6, k6);
            q(dVar.f());
            this.f50744g = dVar.j();
            return;
        }
        throw new IllegalArgumentException("defaultFormatString cannot be null");
    }

    public Calendar l(String str, Calendar calendar) throws ParseException {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.setTimeZone(h());
        if (this.f50742e != null) {
            Calendar calendar3 = (Calendar) calendar.clone();
            calendar3.setTimeZone(h());
            if (this.f50744g) {
                calendar3.add(5, 1);
            }
            String str2 = str + " " + Integer.toString(calendar3.get(1));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f50742e.toPattern() + " yyyy", this.f50742e.getDateFormatSymbols());
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(this.f50742e.getTimeZone());
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = simpleDateFormat.parse(str2, parsePosition);
            if (parse != null && parsePosition.getIndex() == str2.length()) {
                calendar2.setTime(parse);
                if (calendar2.after(calendar3)) {
                    calendar2.add(1, -1);
                }
                o(this.f50743f, calendar2);
                return calendar2;
            }
        }
        ParsePosition parsePosition2 = new ParsePosition(0);
        Date parse2 = this.f50740c.parse(str, parsePosition2);
        if (parse2 != null && parsePosition2.getIndex() == str.length()) {
            calendar2.setTime(parse2);
            o(this.f50741d, calendar2);
            return calendar2;
        }
        throw new ParseException("Timestamp '" + str + "' could not be parsed using a server time of " + calendar.getTime().toString(), parsePosition2.getErrorIndex());
    }
}
