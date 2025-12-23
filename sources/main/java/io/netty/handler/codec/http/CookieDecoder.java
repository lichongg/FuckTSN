package io.netty.handler.codec.http;

import io.netty.handler.codec.DateFormatter;
import io.netty.handler.codec.http.cookie.CookieHeaderNames;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class CookieDecoder {
    private static final String COMMENT = "Comment";
    private static final String COMMENTURL = "CommentURL";
    private static final String DISCARD = "Discard";
    private static final String PORT = "Port";
    private static final String VERSION = "Version";
    private final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CookieDecoder.class);
    private final boolean strict;
    private static final CookieDecoder STRICT = new CookieDecoder(true);
    private static final CookieDecoder LAX = new CookieDecoder(false);

    public static Set<Cookie> decode(String str) {
        return decode(str, true);
    }

    private DefaultCookie initCookie(String str, String str2) {
        int firstInvalidCookieValueOctet;
        int firstInvalidCookieNameOctet;
        if (str == null || str.length() == 0) {
            this.logger.debug("Skipping cookie with null name");
            return null;
        }
        if (str2 == null) {
            this.logger.debug("Skipping cookie with null value");
            return null;
        }
        CharSequence unwrapValue = CookieUtil.unwrapValue(str2);
        if (unwrapValue == null) {
            this.logger.debug("Skipping cookie because starting quotes are not properly balanced in '{}'", unwrapValue);
            return null;
        }
        if (this.strict && (firstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str)) >= 0) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Skipping cookie because name '{}' contains invalid char '{}'", str, Character.valueOf(str.charAt(firstInvalidCookieNameOctet)));
            }
            return null;
        }
        boolean z5 = unwrapValue.length() != str2.length();
        if (!this.strict || (firstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(unwrapValue)) < 0) {
            DefaultCookie defaultCookie = new DefaultCookie(str, unwrapValue.toString());
            defaultCookie.setWrap(z5);
            return defaultCookie;
        }
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Skipping cookie because value '{}' contains invalid char '{}'", unwrapValue, Character.valueOf(unwrapValue.charAt(firstInvalidCookieValueOctet)));
        }
        return null;
    }

    public static Set<Cookie> decode(String str, boolean z5) {
        return (z5 ? STRICT : LAX).doDecode(str);
    }

    private Set<Cookie> doDecode(String str) {
        int i6;
        int i7;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList(8);
        ArrayList arrayList4 = new ArrayList(8);
        extractKeyValuePairs(str, arrayList3, arrayList4);
        if (arrayList3.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        if (((String) arrayList3.get(0)).equalsIgnoreCase(VERSION)) {
            try {
                i6 = Integer.parseInt((String) arrayList4.get(0));
            } catch (NumberFormatException unused) {
                i6 = 0;
            }
            i7 = 1;
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (arrayList3.size() <= i7) {
            return Collections.EMPTY_SET;
        }
        TreeSet treeSet = new TreeSet();
        while (i7 < arrayList3.size()) {
            String str2 = (String) arrayList3.get(i7);
            String str3 = (String) arrayList4.get(i7);
            if (str3 == null) {
                str3 = "";
            }
            DefaultCookie initCookie = initCookie(str2, str3);
            if (initCookie == null) {
                break;
            }
            ArrayList arrayList5 = new ArrayList(2);
            int i8 = i7 + 1;
            String str4 = null;
            int i9 = i7;
            TreeSet treeSet2 = treeSet;
            String str5 = null;
            long j6 = Long.MIN_VALUE;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            String str6 = null;
            String str7 = null;
            while (true) {
                if (i8 >= arrayList3.size()) {
                    arrayList = arrayList3;
                    arrayList2 = arrayList4;
                    break;
                }
                String str8 = (String) arrayList3.get(i8);
                arrayList = arrayList3;
                String str9 = (String) arrayList4.get(i8);
                arrayList2 = arrayList4;
                if (!DISCARD.equalsIgnoreCase(str8)) {
                    if (!CookieHeaderNames.SECURE.equalsIgnoreCase(str8)) {
                        if (!CookieHeaderNames.HTTPONLY.equalsIgnoreCase(str8)) {
                            if (!COMMENT.equalsIgnoreCase(str8)) {
                                if (!COMMENTURL.equalsIgnoreCase(str8)) {
                                    if (!CookieHeaderNames.DOMAIN.equalsIgnoreCase(str8)) {
                                        if (!CookieHeaderNames.PATH.equalsIgnoreCase(str8)) {
                                            if (!"Expires".equalsIgnoreCase(str8)) {
                                                if (!CookieHeaderNames.MAX_AGE.equalsIgnoreCase(str8)) {
                                                    if (!VERSION.equalsIgnoreCase(str8)) {
                                                        if (!PORT.equalsIgnoreCase(str8)) {
                                                            break;
                                                        }
                                                        String[] split = str9.split(",");
                                                        int length = split.length;
                                                        int i10 = 0;
                                                        while (i10 < length) {
                                                            String[] strArr = split;
                                                            try {
                                                                arrayList5.add(Integer.valueOf(split[i10]));
                                                            } catch (NumberFormatException unused2) {
                                                            }
                                                            i10++;
                                                            split = strArr;
                                                        }
                                                    } else {
                                                        i6 = Integer.parseInt(str9);
                                                    }
                                                } else {
                                                    j6 = Integer.parseInt(str9);
                                                }
                                            } else {
                                                Date parseHttpDate = DateFormatter.parseHttpDate(str9);
                                                if (parseHttpDate != null) {
                                                    long time = parseHttpDate.getTime() - System.currentTimeMillis();
                                                    j6 = (time / 1000) + (time % 1000 != 0 ? 1 : 0);
                                                }
                                            }
                                        } else {
                                            str5 = str9;
                                        }
                                    } else {
                                        str7 = str9;
                                    }
                                } else {
                                    str6 = str9;
                                }
                            } else {
                                str4 = str9;
                            }
                        } else {
                            z5 = true;
                        }
                    } else {
                        z6 = true;
                    }
                } else {
                    z7 = true;
                }
                i8++;
                i9++;
                arrayList4 = arrayList2;
                arrayList3 = arrayList;
            }
            initCookie.setVersion(i6);
            initCookie.setMaxAge(j6);
            initCookie.setPath(str5);
            initCookie.setDomain(str7);
            initCookie.setSecure(z6);
            initCookie.setHttpOnly(z5);
            if (i6 > 0) {
                initCookie.setComment(str4);
            }
            if (i6 > 1) {
                initCookie.setCommentUrl(str6);
                initCookie.setPorts(arrayList5);
                initCookie.setDiscard(z7);
            }
            treeSet2.add(initCookie);
            i7 = i9 + 1;
            treeSet = treeSet2;
            arrayList4 = arrayList2;
            arrayList3 = arrayList;
        }
        return treeSet;
    }

    private CookieDecoder(boolean z5) {
        this.strict = z5;
    }

    private static void extractKeyValuePairs(String str, List<String> list, List<String> list2) {
        String substring;
        String str2;
        String substring2;
        int length = str.length();
        int i6 = 0;
        while (i6 != length) {
            char charAt = str.charAt(i6);
            if (charAt != ' ' && charAt != ',' && charAt != ';') {
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        while (i6 != length) {
                            if (str.charAt(i6) == '$') {
                                i6++;
                            } else {
                                String str3 = null;
                                if (i6 == length) {
                                    str2 = null;
                                } else {
                                    int i7 = i6;
                                    while (true) {
                                        char charAt2 = str.charAt(i7);
                                        if (charAt2 != ';') {
                                            if (charAt2 != '=') {
                                                i7++;
                                                if (i7 == length) {
                                                    substring = str.substring(i6);
                                                }
                                            } else {
                                                String substring3 = str.substring(i6, i7);
                                                i6 = i7 + 1;
                                                if (i6 == length) {
                                                    str2 = "";
                                                } else {
                                                    char charAt3 = str.charAt(i6);
                                                    if (charAt3 != '\"' && charAt3 != '\'') {
                                                        int indexOf = str.indexOf(59, i6);
                                                        if (indexOf > 0) {
                                                            substring2 = str.substring(i6, indexOf);
                                                        } else {
                                                            substring2 = str.substring(i6);
                                                            indexOf = length;
                                                        }
                                                        str2 = substring2;
                                                        i6 = indexOf;
                                                    } else {
                                                        StringBuilder sb = new StringBuilder(str.length() - i6);
                                                        int i8 = i7 + 2;
                                                        while (true) {
                                                            boolean z5 = false;
                                                            while (i8 != length) {
                                                                if (z5) {
                                                                    int i9 = i8 + 1;
                                                                    char charAt4 = str.charAt(i8);
                                                                    if (charAt4 != '\"' && charAt4 != '\'' && charAt4 != '\\') {
                                                                        sb.append(charAt4);
                                                                    } else {
                                                                        sb.setCharAt(sb.length() - 1, charAt4);
                                                                    }
                                                                    i8 = i9;
                                                                } else {
                                                                    int i10 = i8 + 1;
                                                                    char charAt5 = str.charAt(i8);
                                                                    if (charAt5 == charAt3) {
                                                                        str2 = sb.toString();
                                                                        str3 = substring3;
                                                                        i6 = i10;
                                                                    } else {
                                                                        sb.append(charAt5);
                                                                        if (charAt5 == '\\') {
                                                                            i8 = i10;
                                                                            z5 = true;
                                                                        } else {
                                                                            i8 = i10;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            str2 = sb.toString();
                                                            i6 = i8;
                                                        }
                                                    }
                                                }
                                                str3 = substring3;
                                            }
                                        } else {
                                            substring = str.substring(i6, i7);
                                        }
                                    }
                                    str2 = null;
                                    str3 = substring;
                                    i6 = i7;
                                }
                                list.add(str3);
                                list2.add(str2);
                                continue;
                            }
                        }
                        return;
                }
            }
            i6++;
        }
    }
}
