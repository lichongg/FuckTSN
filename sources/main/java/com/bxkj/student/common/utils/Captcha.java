package com.bxkj.student.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class Captcha {

    /* renamed from: n, reason: collision with root package name */
    private static final char[] f17750n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: o, reason: collision with root package name */
    private static final char[] f17751o = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: p, reason: collision with root package name */
    private static final char[] f17752p = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: q, reason: collision with root package name */
    private static Captcha f17753q;

    /* renamed from: m, reason: collision with root package name */
    private String f17766m;

    /* renamed from: k, reason: collision with root package name */
    private TYPE f17764k = TYPE.CHARS;

    /* renamed from: a, reason: collision with root package name */
    private int f17754a = 200;

    /* renamed from: b, reason: collision with root package name */
    private int f17755b = 80;

    /* renamed from: c, reason: collision with root package name */
    private int f17756c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f17757d = 4;

    /* renamed from: e, reason: collision with root package name */
    private int f17758e = 2;

    /* renamed from: f, reason: collision with root package name */
    private int f17759f = 50;

    /* renamed from: g, reason: collision with root package name */
    private int f17760g = 20;

    /* renamed from: h, reason: collision with root package name */
    private int f17761h = 20;

    /* renamed from: i, reason: collision with root package name */
    private int f17762i = 45;

    /* renamed from: j, reason: collision with root package name */
    private int f17763j = 15;

    /* renamed from: l, reason: collision with root package name */
    private Random f17765l = new Random();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum TYPE {
        NUMBER,
        LETTER,
        CHARS
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17767a;

        static {
            int[] iArr = new int[TYPE.values().length];
            f17767a = iArr;
            try {
                iArr[TYPE.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17767a[TYPE.LETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17767a[TYPE.CHARS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        int i6 = a.f17767a[this.f17764k.ordinal()];
        int i7 = 0;
        if (i6 == 1) {
            while (i7 < this.f17757d) {
                char[] cArr = f17750n;
                sb.append(cArr[this.f17765l.nextInt(cArr.length)]);
                i7++;
            }
        } else if (i6 == 2) {
            while (i7 < this.f17757d) {
                char[] cArr2 = f17751o;
                sb.append(cArr2[this.f17765l.nextInt(cArr2.length)]);
                i7++;
            }
        } else if (i6 != 3) {
            while (i7 < this.f17757d) {
                char[] cArr3 = f17752p;
                sb.append(cArr3[this.f17765l.nextInt(cArr3.length)]);
                i7++;
            }
        } else {
            while (i7 < this.f17757d) {
                char[] cArr4 = f17752p;
                sb.append(cArr4[this.f17765l.nextInt(cArr4.length)]);
                i7++;
            }
        }
        return sb.toString();
    }

    public static Captcha e() {
        if (f17753q == null) {
            synchronized (Captcha.class) {
                f17753q = new Captcha();
            }
        }
        return f17753q;
    }

    private int f() {
        return Color.rgb(this.f17765l.nextInt(256), this.f17765l.nextInt(256), this.f17765l.nextInt(256));
    }

    private int g() {
        return this.f17760g + this.f17765l.nextInt(this.f17761h);
    }

    private int h() {
        return this.f17762i + this.f17765l.nextInt(this.f17763j);
    }

    public String d() {
        return this.f17766m;
    }

    public Captcha j(int color) {
        this.f17756c = color;
        return f17753q;
    }

    public Captcha k(int paddingLeft, int paddingTop) {
        this.f17760g = paddingLeft;
        this.f17762i = paddingTop;
        return f17753q;
    }

    public Captcha l(int paddingLeft, int paddingLeftRang, int paddingTop, int paddingTopRang) {
        this.f17760g = paddingLeft;
        this.f17761h = paddingLeftRang;
        this.f17762i = paddingTop;
        this.f17763j = paddingTopRang;
        return f17753q;
    }

    public Captcha m(int size) {
        this.f17759f = size;
        return f17753q;
    }

    public Captcha n(int length) {
        this.f17757d = length;
        return f17753q;
    }

    public Captcha o(int number) {
        this.f17758e = number;
        return f17753q;
    }

    public Captcha p(int width, int height) {
        this.f17754a = width;
        this.f17755b = height;
        return f17753q;
    }

    public Captcha q(TYPE type) {
        this.f17764k = type;
        return f17753q;
    }

    private Captcha() {
    }

    private void c(Canvas canvas, Paint paint) {
        int f6 = f();
        int nextInt = this.f17765l.nextInt(this.f17754a);
        int nextInt2 = this.f17765l.nextInt(this.f17755b);
        int nextInt3 = this.f17765l.nextInt(this.f17754a);
        int nextInt4 = this.f17765l.nextInt(this.f17755b);
        paint.setStrokeWidth(1.0f);
        paint.setColor(f6);
        canvas.drawLine(nextInt, nextInt2, nextInt3, nextInt4, paint);
    }

    private void i(Paint paint) {
        paint.setColor(f());
        paint.setFakeBoldText(this.f17765l.nextBoolean());
        int nextInt = this.f17765l.nextInt(11) / 10;
        if (!this.f17765l.nextBoolean()) {
            nextInt = -nextInt;
        }
        paint.setTextSkewX(nextInt);
    }

    public Bitmap a() {
        this.f17766m = b();
        Bitmap createBitmap = Bitmap.createBitmap(this.f17754a, this.f17755b, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(this.f17756c);
        Paint paint = new Paint();
        paint.setTextSize(this.f17759f);
        int i6 = 0;
        for (int i7 = 0; i7 < this.f17766m.length(); i7++) {
            i(paint);
            i6 += g();
            canvas.drawText(String.valueOf(this.f17766m.charAt(i7)), i6, h(), paint);
        }
        for (int i8 = 0; i8 < this.f17758e; i8++) {
            c(canvas, paint);
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }
}
