package cn.bluemobi.dylan.base.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.jpush.android.local.JPushConstants;
import com.baidu.mobads.sdk.internal.cm;
import com.bxkj.base.v2.common.utils.g0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    static Toast f1268a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f1269a;

        a(View view) {
            this.f1269a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f1269a.setEnabled(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f1269a.setEnabled(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f1270a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f1271b;

        b(EditText editText, String str) {
            this.f1270a = editText;
            this.f1271b = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1270a.getContext().getSystemService("input_method");
            if (this.f1271b.equals("open")) {
                inputMethodManager.showSoftInput(this.f1270a, 2);
            } else {
                inputMethodManager.hideSoftInputFromWindow(this.f1270a.getWindowToken(), 0);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f1272a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1273b;

        c(EditText editText, int i6) {
            this.f1272a = editText;
            this.f1273b = i6;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = this.f1272a.getText().toString();
            if (obj.contains(".") && (obj.length() - 1) - obj.toString().indexOf(".") > this.f1273b) {
                obj = obj.substring(0, obj.indexOf(".") + this.f1273b + 1);
                this.f1272a.setText(obj);
                this.f1272a.setSelection(obj.length());
            }
            if (obj.toString().trim().substring(0).equals(".")) {
                obj = "0" + obj;
                this.f1272a.setText(obj);
                this.f1272a.setSelection(2);
            }
            if (!obj.toString().startsWith("0") || obj.toString().trim().length() <= 1 || obj.toString().substring(1, 2).equals(".")) {
                return;
            }
            this.f1272a.setText(obj.subSequence(0, 1));
            this.f1272a.setSelection(1);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }
    }

    public static String A(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        Cursor query = contentResolver.query(uri, null, null, null, null);
        query.moveToFirst();
        String string = query.getString(1);
        query.close();
        return string;
    }

    public static int P(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public static boolean X(List... listArr) {
        for (List list : listArr) {
            if (V(list)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Y(Object[]... objArr) {
        for (Object[] objArr2 : objArr) {
            if (W(objArr2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c0(List<String> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (list.get(i6) == null || b0(list.get(i6))) {
                return true;
            }
        }
        return false;
    }

    public static boolean d0(TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView == null || b0(N(textView))) {
                return true;
            }
        }
        return false;
    }

    public static boolean e0(String... strArr) {
        for (int i6 = 0; i6 < strArr.length; i6++) {
            String str = strArr[i6];
            if (str == null || str.equals("") || strArr[i6].equalsIgnoreCase("null")) {
                return true;
            }
        }
        return false;
    }

    public static String k0(long j6) {
        Object valueOf;
        Object valueOf2;
        Object obj = 0;
        boolean z5 = j6 < 0;
        long abs = Math.abs(j6) / 1000;
        int i6 = (int) (abs % 60);
        long j7 = abs / 60;
        int i7 = (int) (j7 % 60);
        long j8 = j7 / 60;
        int i8 = (int) j8;
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        decimalFormat.applyPattern("00");
        if (j8 <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(z5 ? "-" : "");
            sb.append(i7);
            sb.append(":");
            sb.append(decimalFormat.format(i6));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z5 ? "-" : "");
        if (i8 == 0) {
            valueOf = obj;
        } else if (i8 < 10) {
            valueOf = "0" + i8;
        } else {
            valueOf = Integer.valueOf(i8);
        }
        sb2.append(valueOf);
        sb2.append(":");
        if (i7 == 0) {
            valueOf2 = obj;
        } else if (i7 < 10) {
            valueOf2 = "0" + i7;
        } else {
            valueOf2 = Integer.valueOf(i7);
        }
        sb2.append(valueOf2);
        sb2.append(":");
        if (i6 != 0) {
            if (i6 < 10) {
                obj = "0" + i6;
            } else {
                obj = Integer.valueOf(i6);
            }
        }
        sb2.append(obj);
        return sb2.toString();
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0021: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:34), block:B:43:0x0021 */
    public static String l(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String b6;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (IOException e6) {
                    e = e6;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.flush();
                            byteArrayOutputStream3.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    b6 = cn.bluemobi.dylan.base.utils.b.b(byteArrayOutputStream2.toByteArray());
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                } catch (IOException e8) {
                    e = e8;
                    e.printStackTrace();
                    if (byteArrayOutputStream2 == null) {
                        return null;
                    }
                    try {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        return null;
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        return null;
                    }
                }
            } else {
                b6 = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.flush();
                    byteArrayOutputStream3.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            return b6;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }

    public static String B(long j6) {
        return DateFormat.format("MM月dd日", j6 * 1000).toString();
    }

    public static String C(long j6) {
        return DateFormat.format("kk:mm:ss", j6 * 1000).toString();
    }

    public static String D(long j6) {
        return DateFormat.format("MM-dd", j6 * 1000).toString();
    }

    public static String E(long j6) {
        return DateFormat.format("kk:mm", j6 * 1000).toString();
    }

    public static String F(long j6) {
        return DateFormat.format("yy-MM-dd HH:mm", j6 * 1000).toString();
    }

    public static String G(int i6) {
        String str = "";
        if (i6 > 99 || i6 == 0) {
            return "";
        }
        int i7 = i6 % 10;
        int i8 = (i6 - i7) / 10;
        if (i8 != 0) {
            if (i8 == 1) {
                str = "十";
            } else {
                str = H(i8) + "十";
            }
        }
        return str + H(i7);
    }

    public static int[] K(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static String M(EditText editText) {
        return editText != null ? editText.getText().toString().trim() : "";
    }

    public static String N(TextView textView) {
        return textView != null ? textView.getText().toString().trim() : "";
    }

    public static String O(Map<String, Object> map, String str) {
        return (map == null || map.size() == 0 || b0(str) || !map.containsKey(str)) ? "" : map.get(str) instanceof String ? f0((String) map.get(str)) ? "" : map.get(str).toString() : String.valueOf(map.get(str));
    }

    public static void S(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
    }

    public static boolean U(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    public static boolean V(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean W(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean Z(EditText editText) {
        return editText == null || b0(M(editText));
    }

    public static int a(float f6, Context context) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        return (int) ((f6 * r0.density) + 0.5d);
    }

    public static boolean a0(TextView textView) {
        return textView == null || b0(N(textView));
    }

    public static void b(EditText editText, String str) {
        new Timer().schedule(new b(editText, str), 300L);
    }

    public static boolean b0(String str) {
        return str == null || str.equals("") || str.equalsIgnoreCase("null");
    }

    public static String c(List list) {
        return Pattern.compile("\\b([\\w\\W])\\b").matcher(list.toString().substring(1, list.toString().length() - 1)).replaceAll("$1").replaceAll(",", " ");
    }

    public static int[] f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static boolean f0(String str) {
        return str == null || str.equals("");
    }

    public static boolean g0(String str) {
        return str != null && str.startsWith(JPushConstants.HTTP_PRE);
    }

    public static void i(Context context, int i6) {
        if (context != null) {
            j(context, context.getString(i6));
        }
    }

    public static boolean i0(String str, String str2) {
        return str != null && str.equals(str2);
    }

    public static void j(Context context, String str) {
        if (str != null) {
            Toast.makeText(context, str, 0).show();
        }
    }

    public static void j0(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    public static String k(String str) {
        if (str == null || str.length() != 4) {
            return null;
        }
        return str.substring(0, 2) + ":" + str.substring(2, 4);
    }

    public static Double l0(double d6, int i6) {
        if (i6 >= 0) {
            return Double.valueOf((0.0d == d6 ? new BigDecimal(cm.f10901d) : new BigDecimal(Double.toString(d6))).divide(new BigDecimal("1"), i6, 4).doubleValue());
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    public static Spanned n0(String str) {
        return Html.fromHtml("<font color=#000>" + str + "</font>");
    }

    public static Bitmap o(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            return width > height ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
        } catch (Exception unused) {
            return bitmap;
        }
    }

    public static String p(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(":", "");
    }

    public static void p0(Context context, CharSequence charSequence, int i6) {
        Toast toast = f1268a;
        if (toast == null) {
            f1268a = Toast.makeText(context, charSequence, i6);
        } else {
            toast.setText(charSequence);
        }
        f1268a.show();
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String r(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        try {
            return simpleDateFormat.format(simpleDateFormat.parse(str));
        } catch (ParseException e6) {
            e6.printStackTrace();
            return str;
        }
    }

    public static void r0(View view, ImageView imageView, int i6, int i7, boolean z5) {
        if (z5) {
            imageView.setBackgroundResource(i7);
        } else {
            imageView.setBackgroundResource(i6);
        }
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setStartOffset(0L);
        scaleAnimation.setDuration(50L);
        scaleAnimation2.setStartOffset(50L);
        scaleAnimation2.setDuration(50L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        animationSet.setFillAfter(true);
        imageView.startAnimation(animationSet);
        animationSet.setAnimationListener(new a(view));
    }

    public static Bitmap s0(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        Bitmap o5 = o(bitmap);
        return t0(o5, o5.getWidth() / 2);
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String t(Object obj, String str) {
        try {
            return new SimpleDateFormat(str).format(new Date(Long.parseLong(w(obj)) * 1000));
        } catch (Exception unused) {
            return "";
        }
    }

    public static Bitmap t0(Bitmap bitmap, int i6) {
        if (bitmap != null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                RectF rectF = new RectF(rect);
                float f6 = i6;
                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-12434878);
                canvas.drawRoundRect(rectF, f6, f6, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, rect, rect, paint);
                return createBitmap;
            } catch (Exception unused) {
            }
        }
        return bitmap;
    }

    public static String v(String str) {
        if (!str.contains(".")) {
            return str + ".00";
        }
        String[] split = str.split("\\.");
        if (split[1].length() == 0) {
            return split[0] + ".00";
        }
        if (split[1].length() != 1) {
            split[1].length();
            return str;
        }
        return split[0] + "." + split[1] + "0";
    }

    public static boolean v0(String str) {
        return Pattern.compile("/^([a-z0-9\\-_.+]+)@([a-z0-9\\-]+[.][a-z0-9\\-.]+)$/").matcher(str).matches();
    }

    public static String w(Object obj) {
        try {
            if (!b0(obj.toString())) {
                return obj.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static ArrayList<String[]> y(double d6, int i6, double d7, double d8) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        double d9 = (d7 - d8) / (i6 - 1);
        for (int i7 = 0; i7 < i6; i7++) {
            double d10 = ((d7 - (i7 * d9)) * 3.141592653589793d) / 180.0d;
            double cos = Math.cos(d10) * d6;
            String str = cos + "";
            arrayList.add(new String[]{str, (Math.sin(d10) * d6) + ""});
        }
        return arrayList;
    }

    public void o0(EditText editText, int i6) {
        editText.addTextChangedListener(new c(editText, i6));
    }

    public static boolean A0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("[\\u4E00-\\u9FA5]{2,4}");
    }

    public static boolean B0(String str) {
        if (T(str) || str.trim().length() < 6 || str.trim().length() > 16) {
            return false;
        }
        return true;
    }

    public static boolean C0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^1[1,2,3,4,5,6,7,8,9]+\\d{9}$");
    }

    public static int D0(String str) {
        if (C0(str)) {
            return 1;
        }
        if (y0(str)) {
            return 2;
        }
        return 0;
    }

    public static boolean E0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^(\\d{11})$|^(\\d{3,5}[-]?\\d{6,8})$");
    }

    public static boolean F0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^[a-zA-Z\\d_]+$");
    }

    public static String H(int i6) {
        return new String[]{"", "一", "二", "三", "四", "五", "六", "七", "八", "九"}[i6];
    }

    public static int I(Context context, int i6, int i7, int i8) {
        return ((K(context)[0] - a(i6, context)) - (a(i7, context) * (i8 - 1))) / i8;
    }

    public static String J(long j6) {
        return DateFormat.format(g0.f16897b, j6).toString();
    }

    public static String L(View view) {
        try {
            return view.getTag().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String Q(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    public static int R(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(3);
    }

    public static boolean T(String str) {
        if (b0(str)) {
            return false;
        }
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    public static String e(Map<String, Object> map, String str) {
        if (!map.containsKey(str) || map.get(str) == null || "".equals(map.get(str))) {
            return "";
        }
        return ((String) map.get(str)).trim();
    }

    public static float g(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int h(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean h0() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static Date m(Date date, int i6) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(6, i6);
        return calendar.getTime();
    }

    public static Bitmap m0(Bitmap bitmap, int i6, int i7) {
        Matrix matrix = new Matrix();
        matrix.postScale(i6 / bitmap.getWidth(), i7 / bitmap.getHeight());
        matrix.postRotate(0.0f);
        return Bitmap.createScaledBitmap(bitmap, i6, i7, false);
    }

    public static String n(int i6) {
        switch (i6) {
            case 1:
                return "星期一";
            case 2:
                return "星期二";
            case 3:
                return "星期三";
            case 4:
                return "星期四";
            case 5:
                return "星期五";
            case 6:
                return "星期六";
            case 7:
                return "星期日";
            default:
                return "";
        }
    }

    public static boolean q() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void q0(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
    }

    public static String s(Object obj) {
        return t(obj, "yyyy-MM-dd");
    }

    public static String u(Object obj) {
        String w5 = w(obj);
        if (w5.length() == 0) {
            return "0.00";
        }
        return w5;
    }

    public static String u0(String str) {
        if (!b0(str)) {
            return str.trim();
        }
        return "";
    }

    public static boolean w0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^\\d{13,19}$");
    }

    public static String x(Object obj) {
        return t(obj, "yyyy-MM-dd HH:mm:ss");
    }

    public static boolean x0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^\\d{6}$");
    }

    public static boolean y0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");
    }

    public static String z(ContentResolver contentResolver, Uri uri) {
        try {
            if (uri.getScheme().equals(master.flame.danmaku.danmaku.parser.b.f50156c)) {
                return uri.getPath();
            }
            return A(contentResolver, uri);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public static boolean z0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^[0-9]{17}[0-9|xX]{1}$");
    }

    public static void d(String str) {
    }
}
