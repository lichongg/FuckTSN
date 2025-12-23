package xyz.adscope.ad;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import xyz.adscope.common.v2.dev.info.ScreenUtil;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class q6 {
    public static void a(Context context, View view, String str, int i6, String str2, int i7) {
        view.setBackground(a(context, str, i6, str2, i7));
    }

    private static Drawable a(Context context, String str, int i6, String str2, int i7) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (StringUtil.isValidColor(str)) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(0);
        }
        if (i7 > 0) {
            gradientDrawable.setCornerRadius(ScreenUtil.Calculate.dip2px(context, i7));
        }
        if (i6 > 0 && StringUtil.isValidColor(str2)) {
            gradientDrawable.setStroke(ScreenUtil.Calculate.dip2px(context, i6), Color.parseColor(str2));
        }
        return gradientDrawable;
    }

    public static int a(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (StringUtil.modelSizeByPercent(str)) {
            return (int) (i6 * StringUtil.parseSizePercent(str));
        }
        return StringUtil.parseInt(str);
    }
}
