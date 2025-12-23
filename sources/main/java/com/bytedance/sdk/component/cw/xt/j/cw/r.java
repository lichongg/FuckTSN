package com.bytedance.sdk.component.cw.xt.j.cw;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class r {

    /* renamed from: j, reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f26176j = new ThreadLocal<DateFormat>() { // from class: com.bytedance.sdk.component.cw.xt.j.cw.r.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(com.bytedance.sdk.component.cw.xt.j.cw.ae);
            return simpleDateFormat;
        }
    };
    private static final String[] xt = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    private static final DateFormat[] cw = new DateFormat[15];

    public static Date j(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f26176j.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        String[] strArr = xt;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i6 = 0; i6 < length; i6++) {
                    DateFormat[] dateFormatArr = cw;
                    DateFormat dateFormat = dateFormatArr[i6];
                    if (dateFormat == null) {
                        dateFormat = new SimpleDateFormat(xt[i6], Locale.US);
                        dateFormat.setTimeZone(com.bytedance.sdk.component.cw.xt.j.cw.ae);
                        dateFormatArr[i6] = dateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date parse2 = dateFormat.parse(str, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return parse2;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String j(Date date) {
        return f26176j.get().format(date);
    }
}
