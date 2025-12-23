package org.apache.commons.net.ntp;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TimeStamp implements Serializable, Comparable<TimeStamp> {
    public static final String NTP_DATE_FORMAT = "EEE, MMM dd yyyy HH:mm:ss.SSS";
    protected static final long msb0baseTime = 2085978496000L;
    protected static final long msb1baseTime = -2208988800000L;
    private static final long serialVersionUID = 8139806907588338737L;
    private final long ntpTime;
    private DateFormat simpleFormatter;
    private DateFormat utcFormatter;

    public TimeStamp(long j6) {
        this.ntpTime = j6;
    }

    public long getTime() {
        return getTime(this.ntpTime);
    }

    public String toString() {
        return toString(this.ntpTime);
    }

    protected static long decodeNtpHexString(String str) throws NumberFormatException {
        if (str == null) {
            throw new NumberFormatException("null");
        }
        int indexOf = str.indexOf(46);
        if (indexOf != -1) {
            return (Long.parseLong(str.substring(0, indexOf), 16) << 32) | Long.parseLong(str.substring(indexOf + 1), 16);
        }
        if (str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str, 16) << 32;
    }

    public static TimeStamp getNtpTime(long j6) {
        return new TimeStamp(toNtpTime(j6));
    }

    public static long getTime(long j6) {
        long j7 = j6 >>> 32;
        return ((j7 & 4294967295L) * 1000) + ((j7 & IjkMediaMeta.AV_CH_WIDE_LEFT) == 0 ? msb0baseTime : msb1baseTime) + Math.round(((j6 & 4294967295L) * 1000.0d) / 4.294967296E9d);
    }

    public static TimeStamp parseNtpString(String str) throws NumberFormatException {
        return new TimeStamp(decodeNtpHexString(str));
    }

    public static String toString(long j6) {
        StringBuilder sb = new StringBuilder();
        appendHexString(sb, (j6 >>> 32) & 4294967295L);
        sb.append('.');
        appendHexString(sb, j6 & 4294967295L);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(TimeStamp timeStamp) {
        long j6 = this.ntpTime;
        long j7 = timeStamp.ntpTime;
        if (j6 < j7) {
            return -1;
        }
        return j6 == j7 ? 0 : 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof TimeStamp) && this.ntpTime == ((TimeStamp) obj).ntpValue();
    }

    public Date getDate() {
        return new Date(getTime(this.ntpTime));
    }

    public long getFraction() {
        return this.ntpTime & 4294967295L;
    }

    public long getSeconds() {
        return (this.ntpTime >>> 32) & 4294967295L;
    }

    public int hashCode() {
        long j6 = this.ntpTime;
        return (int) (j6 ^ (j6 >>> 32));
    }

    public long ntpValue() {
        return this.ntpTime;
    }

    public String toDateString() {
        if (this.simpleFormatter == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(NTP_DATE_FORMAT, Locale.US);
            this.simpleFormatter = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
        }
        return this.simpleFormatter.format(getDate());
    }

    public String toUTCString() {
        if (this.utcFormatter == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss.SSS 'UTC'", Locale.US);
            this.utcFormatter = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        return this.utcFormatter.format(getDate());
    }

    public TimeStamp(String str) throws NumberFormatException {
        this.ntpTime = decodeNtpHexString(str);
    }

    private static void appendHexString(StringBuilder sb, long j6) {
        String hexString = Long.toHexString(j6);
        for (int length = hexString.length(); length < 8; length++) {
            sb.append('0');
        }
        sb.append(hexString);
    }

    public static TimeStamp getCurrentTime() {
        return getNtpTime(System.currentTimeMillis());
    }

    public TimeStamp(Date date) {
        this.ntpTime = date == null ? 0L : toNtpTime(date.getTime());
    }

    protected static long toNtpTime(long j6) {
        boolean z5;
        long j7 = msb0baseTime;
        if (j6 < msb0baseTime) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            j7 = msb1baseTime;
        }
        long j8 = j6 - j7;
        long j9 = j8 / 1000;
        long j10 = ((j8 % 1000) * IjkMediaMeta.AV_CH_WIDE_RIGHT) / 1000;
        if (z5) {
            j9 |= IjkMediaMeta.AV_CH_WIDE_LEFT;
        }
        return j10 | (j9 << 32);
    }
}
