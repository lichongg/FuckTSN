package xyz.adscope.common.tool.utils;

import android.text.TextUtils;
import com.bxkj.base.v2.common.utils.g0;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import xyz.adscope.common.tool.security.Base64Util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UniqIdUtil {

    /* renamed from: f, reason: collision with root package name */
    private static UniqIdUtil f56758f = new UniqIdUtil();

    /* renamed from: a, reason: collision with root package name */
    private String f56759a;

    /* renamed from: b, reason: collision with root package name */
    private final Random f56760b = new SecureRandom();

    /* renamed from: c, reason: collision with root package name */
    private final UniqTimer f56761c = new UniqTimer(this, null);

    /* renamed from: d, reason: collision with root package name */
    private boolean f56762d = false;

    /* renamed from: e, reason: collision with root package name */
    private final String f56763e = "MTI3LjAuMC4x";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.tool.utils.UniqIdUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class UniqTimer {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicLong f56764a;

        private UniqTimer() {
            this.f56764a = new AtomicLong(System.currentTimeMillis());
        }

        public String getCurrentTime() {
            if (!UniqIdUtil.timestamp2Date(this.f56764a.incrementAndGet()).equals(UniqIdUtil.timestamp2Date(System.currentTimeMillis()))) {
                this.f56764a.set(System.currentTimeMillis() + UniqIdUtil.this.f56760b.nextInt(10000));
            }
            return UniqIdUtil.b(this.f56764a.incrementAndGet());
        }

        /* synthetic */ UniqTimer(UniqIdUtil uniqIdUtil, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static String leftPad(String str, int i6, String str2) {
        if (str == null) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        int length = str2.length();
        int length2 = i6 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i6, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i7 = 0; i7 < length2; i7++) {
            cArr[i7] = charArray[i7 % length];
        }
        return new String(cArr).concat(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(long j6) {
        return new SimpleDateFormat(g0.f16897b).format(new Date(j6));
    }

    public static UniqIdUtil getInstance() {
        UniqIdUtil uniqIdUtil = f56758f;
        uniqIdUtil.f56762d = false;
        return uniqIdUtil;
    }

    public static UniqIdUtil getInstanceWithLog() {
        UniqIdUtil uniqIdUtil = f56758f;
        uniqIdUtil.f56762d = true;
        return uniqIdUtil;
    }

    public static String left(String str, int i6) {
        if (str == null) {
            return null;
        }
        return i6 < 0 ? "" : str.length() <= i6 ? str : str.substring(0, i6);
    }

    public static String repeat(char c6, int i6) {
        if (i6 <= 0) {
            return "";
        }
        char[] cArr = new char[i6];
        Arrays.fill(cArr, c6);
        return new String(cArr);
    }

    public static String timestamp2Date(long j6) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j6 * 1000));
    }

    public String getUniqID() {
        StringBuffer stringBuffer = new StringBuffer();
        String uniqTime = getUniqTime();
        int nextInt = this.f56760b.nextInt(8999999) + 1000000;
        stringBuffer.append(uniqTime);
        stringBuffer.append(this.f56759a);
        stringBuffer.append(getUniqThreadCode());
        stringBuffer.append(nextInt);
        if (this.f56762d) {
            PrintStream printStream = System.out;
            String.valueOf(nextInt).length();
            printStream.getClass();
            System.out.getClass();
        }
        return stringBuffer.toString();
    }

    public String getUniqTime() {
        String currentTime = this.f56761c.getCurrentTime();
        if (this.f56762d) {
            PrintStream printStream = System.out;
            currentTime.length();
            printStream.getClass();
        }
        return currentTime;
    }

    private UniqIdUtil() {
        String decode = Base64Util.decode("MTI3LjAuMC4x");
        String str = this.f56759a;
        if (str == null || str.trim().length() == 0 || decode.equals(this.f56759a)) {
            this.f56759a = String.valueOf(System.currentTimeMillis());
        }
        this.f56759a = this.f56759a.substring(r0.length() - 2).replace(".", "0");
        if (this.f56762d) {
            PrintStream printStream = System.out;
            this.f56759a.length();
            printStream.getClass();
        }
    }

    public String getUniqThreadCode() {
        String left = left(String.valueOf(Thread.currentThread().hashCode()), 9);
        if (this.f56762d) {
            PrintStream printStream = System.out;
            left.length();
            printStream.getClass();
        }
        return leftPad(left, 9, "0");
    }

    public static String leftPad(String str, int i6, char c6) {
        if (str == null) {
            return null;
        }
        int length = i6 - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i6, String.valueOf(c6));
        }
        return repeat(c6, length).concat(str);
    }
}
