package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class MailTo {
    private static final String BCC = "bcc";
    private static final String BODY = "body";
    private static final String CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap<String, String> mHeaders = new HashMap<>();

    public static boolean isMailTo(@Nullable String str) {
        return str != null && str.startsWith(MAILTO_SCHEME);
    }

    @NonNull
    public static MailTo parse(@NonNull String str) throws ParseException {
        String decode;
        String substring;
        Preconditions.checkNotNull(str);
        if (!isMailTo(str)) {
            throw new ParseException("Not a mailto scheme");
        }
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1) {
            decode = Uri.decode(str.substring(7));
            substring = null;
        } else {
            decode = Uri.decode(str.substring(7, indexOf2));
            substring = str.substring(indexOf2 + 1);
        }
        MailTo mailTo = new MailTo();
        if (substring != null) {
            for (String str2 : substring.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
                if (split.length != 0) {
                    mailTo.mHeaders.put(Uri.decode(split[0]).toLowerCase(Locale.ROOT), split.length > 1 ? Uri.decode(split[1]) : null);
                }
            }
        }
        String to = mailTo.getTo();
        if (to != null) {
            decode = decode + ", " + to;
        }
        mailTo.mHeaders.put("to", decode);
        return mailTo;
    }

    public static boolean isMailTo(@Nullable Uri uri) {
        return uri != null && MAILTO.equals(uri.getScheme());
    }

    @Nullable
    public String getBcc() {
        return this.mHeaders.get(BCC);
    }

    @Nullable
    public String getBody() {
        return this.mHeaders.get(BODY);
    }

    @Nullable
    public String getCc() {
        return this.mHeaders.get("cc");
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Nullable
    public String getSubject() {
        return this.mHeaders.get(SUBJECT);
    }

    @Nullable
    public String getTo() {
        return this.mHeaders.get("to");
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(MAILTO_SCHEME);
        sb.append('?');
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            sb.append(Uri.encode(entry.getKey()));
            sb.append('=');
            sb.append(Uri.encode(entry.getValue()));
            sb.append(v0.f47960d);
        }
        return sb.toString();
    }

    private MailTo() {
    }

    @NonNull
    public static MailTo parse(@NonNull Uri uri) throws ParseException {
        return parse(uri.toString());
    }
}
