package com.amap.api.col.p0003l;

import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class t2 {

    /* renamed from: a, reason: collision with root package name */
    private static String f7257a = "0123456789";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f7258a;

        /* renamed from: b, reason: collision with root package name */
        private int f7259b;

        /* renamed from: c, reason: collision with root package name */
        private int f7260c;

        public a(String str, int i6) {
            this.f7259b = 1103515245;
            this.f7260c = 12345;
            this.f7258a = d(str, i6, str.length());
        }

        private int e(int i6) {
            return (int) (((i6 * this.f7259b) + this.f7260c) & 2147483647L);
        }

        private char a(int i6) {
            this.f7258a.getClass();
            return this.f7258a.charAt(i6);
        }

        private int b(char c6) {
            this.f7258a.getClass();
            return this.f7258a.indexOf(c6);
        }

        private String d(String str, int i6, int i7) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            for (int i8 = 0; i8 < i7; i8++) {
                int e6 = e(i6);
                int i9 = e6 % length;
                i6 = e(e6);
                int i10 = i6 % length;
                char charAt = stringBuffer.charAt(i9);
                stringBuffer.setCharAt(i9, stringBuffer.charAt(i10));
                stringBuffer.setCharAt(i10, charAt);
            }
            return stringBuffer.toString();
        }

        private String f(int i6, String str) {
            StringBuilder sb = new StringBuilder();
            int length = this.f7258a.length();
            int length2 = str.length();
            for (int i7 = 0; i7 < length2; i7++) {
                int b6 = b(str.charAt(i7));
                if (b6 < 0) {
                    break;
                }
                sb.append(a(((b6 + i6) + i7) % length));
            }
            if (sb.length() == length2) {
                return sb.toString();
            }
            return null;
        }

        public final String c(int i6, String str) {
            return f(i6, str);
        }

        public a() {
            this((byte) 0);
        }

        private a(byte b6) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }
    }

    public static String a() {
        Random random = new Random();
        int nextInt = random.nextInt(10);
        Locale locale = Locale.US;
        String format = String.format(locale, "%05d", Integer.valueOf(nextInt));
        int nextInt2 = random.nextInt(10);
        int nextInt3 = random.nextInt(100);
        return new a(f7257a, nextInt3).c(nextInt2, format) + String.format(locale, "%01d", Integer.valueOf(nextInt2)) + String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(nextInt3));
    }
}
