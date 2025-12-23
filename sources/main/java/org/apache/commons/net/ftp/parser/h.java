package org.apache.commons.net.ftp.parser;

import com.bxkj.base.v2.common.utils.g0;
import com.huawei.hms.framework.common.ContainerUtils;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.net.ftp.FTPFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends org.apache.commons.net.ftp.g {

    /* renamed from: c, reason: collision with root package name */
    private static final h f50745c = new h();

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, Integer> f50746d;

    /* renamed from: e, reason: collision with root package name */
    private static int[] f50747e;

    /* renamed from: f, reason: collision with root package name */
    private static int[][] f50748f;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f50746d = hashMap;
        hashMap.put(master.flame.danmaku.danmaku.parser.b.f50156c, 0);
        hashMap.put("cdir", 1);
        hashMap.put("pdir", 1);
        hashMap.put("dir", 1);
        f50747e = new int[]{0, 1, 2};
        f50748f = new int[][]{new int[0], new int[]{2}, new int[]{1}, new int[]{2, 1}, new int[]{0}, new int[]{0, 2}, new int[]{0, 1}, new int[]{0, 1, 2}};
    }

    public static h f() {
        return f50745c;
    }

    public static FTPFile g(String str) {
        return f50745c.a(str);
    }

    public static Calendar h(String str) {
        SimpleDateFormat simpleDateFormat;
        boolean z5;
        if (str.contains(".")) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            z5 = true;
        } else {
            simpleDateFormat = new SimpleDateFormat(g0.f16897b);
            z5 = false;
        }
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        simpleDateFormat.setTimeZone(timeZone);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
        ParsePosition parsePosition = new ParsePosition(0);
        simpleDateFormat.setLenient(false);
        Date parse = simpleDateFormat.parse(str, parsePosition);
        if (parsePosition.getIndex() != str.length()) {
            return null;
        }
        gregorianCalendar.setTime(parse);
        if (!z5) {
            gregorianCalendar.clear(14);
        }
        return gregorianCalendar;
    }

    @Override // org.apache.commons.net.ftp.f
    public FTPFile a(String str) {
        FTPFile fTPFile;
        FTPFile fTPFile2 = null;
        if (str.startsWith(" ")) {
            if (str.length() <= 1) {
                return null;
            }
            FTPFile fTPFile3 = new FTPFile();
            fTPFile3.setRawListing(str);
            fTPFile3.setName(str.substring(1));
            return fTPFile3;
        }
        int i6 = 2;
        String[] split = str.split(" ", 2);
        if (split.length != 2 || split[1].length() == 0) {
            return null;
        }
        String str2 = split[0];
        if (!str2.endsWith(";")) {
            return null;
        }
        FTPFile fTPFile4 = new FTPFile();
        fTPFile4.setRawListing(str);
        fTPFile4.setName(split[1]);
        String[] split2 = str2.split(";");
        boolean contains = split[0].toLowerCase(Locale.ENGLISH).contains("unix.mode=");
        int length = split2.length;
        int i7 = 0;
        while (i7 < length) {
            String[] split3 = split2[i7].split(ContainerUtils.KEY_VALUE_DELIMITER, -1);
            if (split3.length != i6) {
                return fTPFile2;
            }
            String str3 = split3[0];
            Locale locale = Locale.ENGLISH;
            String lowerCase = str3.toLowerCase(locale);
            String str4 = split3[1];
            if (str4.length() != 0) {
                String lowerCase2 = str4.toLowerCase(locale);
                if ("size".equals(lowerCase)) {
                    fTPFile4.setSize(Long.parseLong(str4));
                } else if ("sizd".equals(lowerCase)) {
                    fTPFile4.setSize(Long.parseLong(str4));
                } else if ("modify".equals(lowerCase)) {
                    Calendar h6 = h(str4);
                    if (h6 == null) {
                        return fTPFile2;
                    }
                    fTPFile4.setTimestamp(h6);
                } else if ("type".equals(lowerCase)) {
                    Integer num = f50746d.get(lowerCase2);
                    if (num == null) {
                        fTPFile4.setType(3);
                    } else {
                        fTPFile4.setType(num.intValue());
                    }
                } else {
                    if (lowerCase.startsWith("unix.")) {
                        String lowerCase3 = lowerCase.substring(5).toLowerCase(locale);
                        if ("group".equals(lowerCase3)) {
                            fTPFile4.setGroup(str4);
                        } else if ("owner".equals(lowerCase3)) {
                            fTPFile4.setUser(str4);
                        } else if (RtspHeaders.Values.MODE.equals(lowerCase3)) {
                            int length2 = str4.length() - 3;
                            int i8 = 0;
                            while (i8 < 3) {
                                int charAt = str4.charAt(length2 + i8) - '0';
                                if (charAt >= 0 && charAt <= 7) {
                                    int[] iArr = f50748f[charAt];
                                    int length3 = iArr.length;
                                    int i9 = 0;
                                    while (i9 < length3) {
                                        fTPFile4.setPermission(f50747e[i8], iArr[i9], true);
                                        i9++;
                                        fTPFile2 = fTPFile2;
                                    }
                                }
                                i8++;
                                fTPFile2 = fTPFile2;
                            }
                        }
                        fTPFile = fTPFile2;
                    } else {
                        fTPFile = fTPFile2;
                        if (!contains && "perm".equals(lowerCase)) {
                            e(fTPFile4, lowerCase2);
                            i7++;
                            fTPFile2 = fTPFile;
                            i6 = 2;
                        }
                    }
                    i7++;
                    fTPFile2 = fTPFile;
                    i6 = 2;
                }
            }
            fTPFile = fTPFile2;
            i7++;
            fTPFile2 = fTPFile;
            i6 = 2;
        }
        return fTPFile4;
    }

    private void e(FTPFile fTPFile, String str) {
        for (char c6 : str.toCharArray()) {
            if (c6 != 'a') {
                if (c6 != 'p') {
                    if (c6 != 'r') {
                        if (c6 != 'w') {
                            if (c6 != 'l') {
                                if (c6 != 'm') {
                                    switch (c6) {
                                        case 'c':
                                            fTPFile.setPermission(0, 1, true);
                                            break;
                                        case 'd':
                                            fTPFile.setPermission(0, 1, true);
                                            break;
                                        case 'e':
                                            fTPFile.setPermission(0, 0, true);
                                            break;
                                    }
                                } else {
                                    fTPFile.setPermission(0, 1, true);
                                }
                            } else {
                                fTPFile.setPermission(0, 2, true);
                            }
                        } else {
                            fTPFile.setPermission(0, 1, true);
                        }
                    } else {
                        fTPFile.setPermission(0, 0, true);
                    }
                } else {
                    fTPFile.setPermission(0, 1, true);
                }
            } else {
                fTPFile.setPermission(0, 1, true);
            }
        }
    }
}
