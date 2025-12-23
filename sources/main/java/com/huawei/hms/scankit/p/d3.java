package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class d3 {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f34120a = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})T(\\d{2})(\\d{2})(\\d{2})Z");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f34121b = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})T(\\d{2})(\\d{2})(\\d{2})");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f34122c = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f34123d = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})\\d{6}Z");

    static void a(String str, HmsScan.EventTime eventTime) {
        Matcher matcher = f34120a.matcher(str);
        Matcher matcher2 = f34121b.matcher(str);
        Matcher matcher3 = f34122c.matcher(str);
        Matcher matcher4 = f34123d.matcher(str);
        try {
            if (matcher.matches()) {
                a(eventTime, Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
                b(eventTime, Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                eventTime.isUTCTime = true;
                eventTime.originalValue = str;
                return;
            }
            if (matcher2.matches()) {
                a(eventTime, Integer.parseInt(matcher2.group(1)), Integer.parseInt(matcher2.group(2)), Integer.parseInt(matcher2.group(3)));
                b(eventTime, Integer.parseInt(matcher2.group(4)), Integer.parseInt(matcher2.group(5)), Integer.parseInt(matcher2.group(6)));
                eventTime.originalValue = str;
            } else if (matcher3.matches()) {
                a(eventTime, Integer.parseInt(matcher3.group(1)), Integer.parseInt(matcher3.group(2)), Integer.parseInt(matcher3.group(3)));
                eventTime.originalValue = str;
            } else if (matcher4.matches()) {
                a(eventTime, Integer.parseInt(matcher4.group(1)), Integer.parseInt(matcher4.group(2)), Integer.parseInt(matcher4.group(3)));
            }
        } catch (NullPointerException unused) {
            o4.b("exception", "NullPointerException");
        }
    }

    private static void b(HmsScan.EventTime eventTime, int i6, int i7, int i8) {
        eventTime.hours = i6;
        eventTime.minutes = i7;
        eventTime.seconds = i8;
    }

    private static void a(HmsScan.EventTime eventTime, int i6, int i7, int i8) {
        eventTime.year = i6;
        eventTime.month = i7;
        eventTime.day = i8;
    }
}
