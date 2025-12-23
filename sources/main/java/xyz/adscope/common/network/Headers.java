package xyz.adscope.common.network;

import android.os.Build;
import android.text.TextUtils;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.internal.StringUtil;
import java.net.HttpCookie;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.network.util.ListMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Headers extends ListMap<String, String> {
    public static final String KEY_ACCEPT = "Accept";
    public static final String KEY_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String KEY_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String KEY_ACCEPT_RANGE = "Accept-Range";
    public static final String KEY_CACHE_CONTROL = "Cache-Control";
    public static final String KEY_CONNECTION = "Connection";
    public static final String KEY_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String KEY_CONTENT_ENCODING = "Content-Encoding";
    public static final String KEY_CONTENT_LENGTH = "Content-Length";
    public static final String KEY_CONTENT_RANGE = "Content-Range";
    public static final String KEY_CONTENT_TYPE = "Content-Type";
    public static final String KEY_COOKIE = "Cookie";
    public static final String KEY_DATE = "Date";
    public static final String KEY_EXPIRES = "Expires";
    public static final String KEY_E_TAG = "ETag";
    public static final String KEY_HOST = "Host";
    public static final String KEY_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String KEY_IF_NONE_MATCH = "If-None-Match";
    public static final String KEY_LAST_MODIFIED = "Last-Modified";
    public static final String KEY_LOCATION = "Location";
    public static final String KEY_RANGE = "Range";
    public static final String KEY_SET_COOKIE = "Set-Cookie";
    public static final String KEY_USER_AGENT = "User-Agent";
    public static final String TIME_FORMAT_HTTP = "EEE, dd MMM y HH:mm:ss 'GMT'";
    public static final String VALUE_ACCEPT_ALL = "*/*";
    public static final String VALUE_ACCEPT_ENCODING = "gzip, deflate";
    public static final String VALUE_APPLICATION_FORM = "multipart/form-data";
    public static final String VALUE_APPLICATION_JSON = "application/json";
    public static final String VALUE_APPLICATION_STREAM = "application/octet-stream";
    public static final String VALUE_APPLICATION_URLENCODED = "application/x-www-form-urlencoded";
    public static final String VALUE_APPLICATION_XML = "application/xml";
    public static final String VALUE_CLOSE = "close";
    public static final String VALUE_KEEP_ALIVE = "keep-alive";
    public static final TimeZone TIME_ZONE_GMT = TimeZone.getTimeZone("GMT");
    public static final String VALUE_ACCEPT_LANGUAGE = getLanguage();
    public static final String VALUE_USER_AGENT = getUserAgent();

    public Headers() {
        super(new TreeMap(new Comparator<String>() { // from class: xyz.adscope.common.network.Headers.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        }));
    }

    public static long formatGMTToMillis(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT_HTTP, Locale.US);
        simpleDateFormat.setTimeZone(TIME_ZONE_GMT);
        return simpleDateFormat.parse(str).getTime();
    }

    public static String formatMillisToGMT(long j6) {
        Date date = new Date(j6);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT_HTTP, Locale.US);
        simpleDateFormat.setTimeZone(TIME_ZONE_GMT);
        return simpleDateFormat.format(date);
    }

    public static Headers fromJSONString(String str) {
        Headers headers = new Headers();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray jSONArray = new JSONArray(jSONObject.optString(next));
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                headers.add(next, jSONArray.optString(i6));
            }
        }
        return headers;
    }

    public static List<HttpCookie> getHttpCookieList(Headers headers) {
        ArrayList arrayList = new ArrayList();
        for (String str : headers.keySet()) {
            if (str.equalsIgnoreCase("Set-Cookie")) {
                Iterator<String> it = headers.get(str).iterator();
                while (it.hasNext()) {
                    arrayList.addAll(HttpCookie.parse(it.next()));
                }
            }
        }
        return arrayList;
    }

    public static Map<String, String> getRequestHeaders(Headers headers) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            linkedHashMap.put(entry.getKey(), TextUtils.join("; ", entry.getValue()));
        }
        return linkedHashMap;
    }

    public static String getUserAgent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Build.VERSION.RELEASE);
        stringBuffer.append("; ");
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            stringBuffer.append(language.toLowerCase(locale));
            String country = locale.getCountry();
            if (!TextUtils.isEmpty(country)) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase(locale));
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str = Build.MODEL;
            if (str.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str);
            }
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            stringBuffer.append(" Api/");
            stringBuffer.append(str2);
        }
        return String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/534.30 (KHTML, like Gecko) Version/5.0 %sSafari/534.30", stringBuffer, "Mobile ");
    }

    public static String toJSONString(Headers headers) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), new JSONArray((Collection) entry.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject.toString();
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public boolean containsKey(String str) {
        return super.containsKey((Headers) formatKey(str));
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public List<String> get(String str) {
        return super.get((Headers) formatKey(str));
    }

    public String getCacheControl() {
        List<String> list = get("Cache-Control");
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        return TextUtils.join(",", list);
    }

    public String getContentDisposition() {
        return getFirst("Content-Disposition");
    }

    public String getContentEncoding() {
        return getFirst("Content-Encoding");
    }

    public long getContentLength() {
        String first = getFirst("Content-Length");
        if (TextUtils.isEmpty(first)) {
            first = "0";
        }
        return Long.parseLong(first);
    }

    public String getContentRange() {
        return getFirst("Content-Range");
    }

    public String getContentType() {
        return getFirst("Content-Type");
    }

    public long getDate() {
        return a("Date");
    }

    public String getETag() {
        return getFirst("ETag");
    }

    public long getExpires() {
        return a("Expires");
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public String getFirst(String str) {
        return (String) super.getFirst((Headers) formatKey(str));
    }

    public long getLastModified() {
        return a("Last-Modified");
    }

    public String getLocation() {
        return getFirst("Location");
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public List<String> remove(String str) {
        return super.remove((Headers) formatKey(str));
    }

    private long a(String str) {
        String first = getFirst(str);
        if (!TextUtils.isEmpty(first)) {
            try {
                return formatGMTToMillis(first);
            } catch (ParseException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    public static long analysisCacheExpires(Headers headers) {
        long j6;
        long j7;
        long currentTimeMillis = System.currentTimeMillis();
        String cacheControl = headers.getCacheControl();
        if (!TextUtils.isEmpty(cacheControl)) {
            StringTokenizer stringTokenizer = new StringTokenizer(cacheControl, ",");
            j6 = 0;
            j7 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String lowerCase = stringTokenizer.nextToken().trim().toLowerCase(Locale.getDefault());
                if (lowerCase.equals("no-cache") || lowerCase.equals(HttpHeaders.Values.NO_STORE)) {
                    return 0L;
                }
                if (lowerCase.startsWith("max-age=")) {
                    j6 = Long.parseLong(lowerCase.substring(8)) * 1000;
                } else {
                    if (lowerCase.startsWith("must-revalidate")) {
                        return 0L;
                    }
                    if (lowerCase.startsWith("stale-while-revalidate=")) {
                        j7 = Long.parseLong(lowerCase.substring(23)) * 1000;
                    }
                }
            }
        } else {
            j6 = 0;
            j7 = 0;
        }
        if (!TextUtils.isEmpty(cacheControl)) {
            long j8 = currentTimeMillis + j6;
            if (j7 > 0) {
                return j8 + j7;
            }
            return j8;
        }
        long expires = headers.getExpires();
        long date = headers.getDate();
        if (expires <= date) {
            return 0L;
        }
        return (currentTimeMillis + expires) - date;
    }

    public static String formatKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.toLowerCase(Locale.ENGLISH).split("-");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            String substring = str2.substring(0, 1);
            String substring2 = str2.substring(1);
            sb.append(substring.toUpperCase(Locale.ENGLISH));
            sb.append(substring2);
            sb.append("-");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.lastIndexOf("-"));
        }
        return sb.toString();
    }

    public static String getLanguage() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        if (!TextUtils.isEmpty(country)) {
            sb.append('-');
            sb.append(country);
            sb.append(StringUtil.COMMA);
            sb.append(language);
        }
        return sb.toString();
    }

    public static String parseSubValue(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
            while (stringTokenizer.hasMoreElements()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf > 0 && str2.equalsIgnoreCase(nextToken.substring(0, indexOf).trim())) {
                    return nextToken.substring(indexOf + 1).trim();
                }
            }
        }
        return str3;
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public void add(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        super.add((Headers) formatKey(str), str2);
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public void set(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        super.set((Headers) formatKey(str), str2);
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public void add(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list.isEmpty()) {
            return;
        }
        super.add((Headers) formatKey(str), (List) list);
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public void set(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list.isEmpty()) {
            return;
        }
        super.set((Headers) formatKey(str), (List) list);
    }

    public void add(Headers headers) {
        try {
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    add(key, it.next());
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void set(Headers headers) {
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            set(entry.getKey(), entry.getValue());
        }
    }
}
