package com.acse.ottn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.acse.ottn.adapter.AutoScrollViewPager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static g0 f4534a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f4535b = "ButtonColorUtil";

    public static g0 a() {
        if (f4534a == null) {
            synchronized (g0.class) {
                try {
                    if (f4534a == null) {
                        f4534a = new g0();
                    }
                } finally {
                }
            }
        }
        return f4534a;
    }

    public void b(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(k0.f4682r)) {
            textView.setBackgroundResource(R.drawable.accessibilty_ydsj_green_button);
        } else if (activity.getPackageName().equals(k0.f4683s)) {
            textView.setBackgroundResource(R.drawable.accessibilty_sdxu_button);
        } else {
            textView.setBackgroundResource(R.drawable.accessibilty_green_button);
        }
    }

    public String c(Activity activity) {
        return activity.getPackageName().equals(k0.f4682r) ? "https://h5.gxapp.iydsj.com/gxapp/privacy_policy/userService.html" : activity.getPackageName().equals(k0.f4684t) ? "https://www.boxkj.com/resources/user_agreement_info.html" : activity.getPackageName().equals(k0.f4685u) ? "https://api2.lptiyu.com/v3/api.php/Login/user_notice" : activity.getPackageName().equals(k0.f4683s) ? "https://mh5.huachenjie.com/h5/contract/document.html?code=501" : "";
    }

    public void d(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(k0.f4682r)) {
            textView.setTextColor(Color.parseColor("#5FCA8B"));
        } else if (activity.getPackageName().equals(k0.f4683s)) {
            textView.setTextColor(Color.parseColor("#650AEC"));
        } else {
            textView.setTextColor(Color.parseColor("#3ECDA1"));
        }
    }

    public String e(Activity activity) {
        if (activity.getPackageName().equals(k0.f4682r)) {
            return "#5FCA8B";
        }
        if (activity.getPackageName().equals(k0.f4683s)) {
            return "#650AEC";
        }
        return "#3ECDA1";
    }

    public void b(Activity activity, ImageView imageView) {
        if (activity.getPackageName().equals(k0.f4682r)) {
            imageView.setImageResource(R.mipmap.sjxy_warning);
            return;
        }
        if (activity.getPackageName().equals(k0.f4685u)) {
            imageView.setImageResource(R.mipmap.bdlp_warning);
        } else if (activity.getPackageName().equals(k0.f4683s)) {
            imageView.setImageResource(R.mipmap.sdxy_warning);
        } else {
            imageView.setImageResource(R.mipmap.warning);
        }
    }

    public String d(Activity activity) {
        if (!activity.getPackageName().equals(k0.f4682r) && !activity.getPackageName().equals(k0.f4684t) && !activity.getPackageName().equals(k0.f4685u) && !activity.getPackageName().equals(k0.f4683s)) {
            return "https://www.idazhe.net/course/snt-serviceagreement?name=省钱助手";
        }
        return "https://www.idazhe.net/course/snt-serviceagreement?name=DETN";
    }

    public void a(Activity activity, TextView textView) {
        textView.setBackgroundColor(Color.parseColor("#DEE2EC"));
    }

    public void a(Activity activity, ImageView imageView, ImageView imageView2) {
        imageView2.setVisibility(8);
        imageView.setVisibility(0);
        if (activity.getPackageName().equals(k0.f4682r)) {
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.mipmap.run_dialog_icon);
            return;
        }
        if (activity.getPackageName().equals(k0.f4685u)) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.mipmap.bdlp_running_icon);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.setMargins(0, 60, 0, 0);
            imageView.setLayoutParams(layoutParams);
            return;
        }
        if (activity.getPackageName().equals(k0.f4683s)) {
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.mipmap.sdxy_run_icon);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.mipmap.running_icon);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            layoutParams2.setMargins(0, 60, 0, 0);
            imageView.setLayoutParams(layoutParams2);
        }
    }

    public void c(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(k0.f4682r)) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(0);
        }
    }

    public String b(Activity activity) {
        if (!activity.getPackageName().equals(k0.f4682r) && !activity.getPackageName().equals(k0.f4684t) && !activity.getPackageName().equals(k0.f4685u) && !activity.getPackageName().equals(k0.f4683s)) {
            return "https://www.idazhe.net/course/snt-privacyagreement?name=省钱助手";
        }
        return "https://www.idazhe.net/course/snt-privacyagreement?name=DETN";
    }

    public void b(Activity activity, RelativeLayout relativeLayout) {
        relativeLayout.setBackgroundColor(Color.parseColor("#F3F3F3"));
    }

    public void a(Activity activity, ImageView imageView) {
        if (activity.getPackageName().equals(k0.f4682r)) {
            imageView.setImageResource(R.mipmap.ydsj_up);
        } else if (activity.getPackageName().equals(k0.f4683s)) {
            imageView.setImageResource(R.mipmap.sdxy_up);
        } else {
            imageView.setImageResource(R.mipmap.up_green);
        }
    }

    public void a(Activity activity, View view) {
        if (!activity.getPackageName().equals(k0.f4682r) && !activity.getPackageName().equals(k0.f4683s) && !activity.getPackageName().equals(k0.f4684t) && !activity.getPackageName().equals(k0.f4685u)) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    public boolean a(Activity activity, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, AutoScrollViewPager autoScrollViewPager, ImageView imageView5) {
        if (activity.getPackageName().equals(k0.f4682r)) {
            autoScrollViewPager.setVisibility(8);
            imageView5.setImageResource(R.mipmap.yundong);
            imageView.setImageResource(R.mipmap.ydsj_accessiblity_green);
            imageView3.setImageResource(R.mipmap.ydsj_flow_window_green);
            imageView2.setImageResource(R.mipmap.ydsj_location_green_position);
            imageView4.setImageResource(R.mipmap.ydsj_battery_green);
            return true;
        }
        if (activity.getPackageName().equals(k0.f4685u)) {
            autoScrollViewPager.setVisibility(8);
            imageView.setImageResource(R.mipmap.accessiblity_green_logo);
            imageView2.setImageResource(R.mipmap.location_green_position);
            imageView3.setImageResource(R.mipmap.flow_window_green);
            imageView5.setImageResource(R.mipmap.bdlp_banner);
            imageView4.setImageResource(R.mipmap.battery_green_icon);
            return true;
        }
        if (activity.getPackageName().equals(k0.f4683s)) {
            autoScrollViewPager.setVisibility(8);
            imageView.setImageResource(R.mipmap.shandong_fuzhu_s);
            imageView2.setImageResource(R.mipmap.shandong_dingwei_s);
            imageView3.setImageResource(R.mipmap.shandong_xuanfu_s);
            imageView5.setImageResource(R.mipmap.shandong_banner);
            imageView4.setImageResource(R.mipmap.shandong_houtai_s);
            return true;
        }
        autoScrollViewPager.setVisibility(8);
        imageView.setImageResource(R.mipmap.accessiblity_green_logo);
        imageView2.setImageResource(R.mipmap.location_green_position);
        imageView3.setImageResource(R.mipmap.flow_window_green);
        imageView5.setImageResource(R.mipmap.banner_6);
        imageView4.setImageResource(R.mipmap.battery_green_icon);
        return true;
    }

    public void a(Activity activity, TextPaint textPaint) {
        if (activity.getPackageName().equals(k0.f4682r)) {
            textPaint.setColor(Color.parseColor("#5FCA8B"));
        } else if (activity.getPackageName().equals(k0.f4683s)) {
            textPaint.setColor(Color.parseColor("#650AEC"));
        } else {
            textPaint.setColor(Color.parseColor("#3ECDA1"));
        }
    }

    public String a(Context context) {
        if (context.getPackageName().equals(k0.f4682r)) {
            return "wxd67633bd92006e63";
        }
        if (context.getPackageName().equals(k0.f4683s)) {
            return "wx15d677743c454371";
        }
        if (context.getPackageName().equals(k0.f4685u)) {
            return "wx5a2e1ff396785475";
        }
        if (context.getPackageName().equals(k0.f4684t)) {
            return com.bxkj.student.v2.common.utils.w.f20953b;
        }
        return "wx0b99368ff4dd7868";
    }

    public void a(Activity activity, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView) {
        int i6 = R.mipmap.premission_unreadly;
        imageView.setImageResource(i6);
        imageView3.setImageResource(i6);
        imageView2.setImageResource(i6);
        imageView4.setImageResource(i6);
        int i7 = R.drawable.permission_background;
        relativeLayout.setBackgroundResource(i7);
        relativeLayout3.setBackgroundResource(i7);
        relativeLayout4.setBackgroundResource(i7);
        relativeLayout2.setBackgroundResource(i7);
        textView.setText("允许后台使用精准定位，以便持续记录跑步轨迹。");
        textView.setTextColor(Color.parseColor("#AAAAAA"));
        if (activity.getPackageName().equals(k0.f4682r)) {
            if (b.c().e()) {
                imageView.setImageResource(R.mipmap.permission_readly);
                relativeLayout.setBackgroundResource(R.drawable.permission_green_background);
            }
            if (b.c().a()) {
                imageView3.setImageResource(R.mipmap.permission_readly);
                relativeLayout3.setBackgroundResource(R.drawable.permission_green_background);
            }
            if (b2.a().a((Context) activity) && b2.a().b((Context) activity)) {
                imageView2.setImageResource(R.mipmap.permission_readly);
                relativeLayout2.setBackgroundResource(R.drawable.permission_green_background);
            } else if (j3.a().c("location_permission_size") > 2) {
                imageView2.setImageResource(R.mipmap.premission_location_exceptional);
                textView.setText("开启异常请在设置中手动开启");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (x4.a().b(activity.getPackageName())) {
                imageView4.setImageResource(R.mipmap.permission_readly);
                relativeLayout4.setBackgroundResource(R.drawable.permission_green_background);
                return;
            }
            return;
        }
        if (activity.getPackageName().equals(k0.f4683s)) {
            if (b.c().e()) {
                imageView.setImageResource(R.mipmap.shandong_select);
                relativeLayout.setBackgroundResource(R.drawable.permission_sd_background);
            }
            if (b.c().a()) {
                imageView3.setImageResource(R.mipmap.shandong_select);
                relativeLayout3.setBackgroundResource(R.drawable.permission_sd_background);
            }
            if (b2.a().a((Context) activity) && b2.a().b((Context) activity)) {
                imageView2.setImageResource(R.mipmap.shandong_select);
                relativeLayout2.setBackgroundResource(R.drawable.permission_sd_background);
            } else if (j3.a().c("location_permission_size") > 2) {
                imageView2.setImageResource(R.mipmap.premission_location_exceptional);
                textView.setText("开启异常请在设置中手动开启");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (x4.a().b(activity.getPackageName())) {
                imageView4.setImageResource(R.mipmap.shandong_select);
                relativeLayout4.setBackgroundResource(R.drawable.permission_sd_background);
                return;
            }
            return;
        }
        if (b.c().e()) {
            imageView.setImageResource(R.mipmap.permission_readly_tsn);
            relativeLayout.setBackgroundResource(R.drawable.permission_tsn_green_background);
        }
        if (b2.a().a((Context) activity) && b2.a().b((Context) activity)) {
            imageView2.setImageResource(R.mipmap.permission_readly_tsn);
            relativeLayout2.setBackgroundResource(R.drawable.permission_tsn_green_background);
        } else if (j3.a().c("location_permission_size") > 2) {
            imageView2.setImageResource(R.mipmap.premission_location_exceptional);
            textView.setText("开启异常请在设置中手动开启");
            textView.setTextColor(Color.parseColor("#FD5439"));
        }
        if (b.c().a()) {
            imageView3.setImageResource(R.mipmap.permission_readly_tsn);
            relativeLayout3.setBackgroundResource(R.drawable.permission_tsn_green_background);
        }
        if (x4.a().b(activity.getPackageName())) {
            imageView4.setImageResource(R.mipmap.permission_readly_tsn);
            relativeLayout4.setBackgroundResource(R.drawable.permission_tsn_green_background);
        }
    }

    public void a(Activity activity, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        if (activity.getPackageName().equals(k0.f4682r) || activity.getPackageName().equals(k0.f4684t) || activity.getPackageName().equals(k0.f4685u) || activity.getPackageName().equals(k0.f4683s)) {
            textView.setText("警告");
            textView2.setText("当前必要权限不完整，将无法记录准确的跑步轨迹，可能会影响您的跑步成绩! \n \n您仍然可以开始跑步，但建议您保持程序一直在前台运行，并保持屏幕常亮，以便记录成绩。\n");
            textView3.setText("继续使用");
            textView4.setText("尝试开权限");
        }
    }

    public String a(Activity activity) {
        if (activity.getPackageName().equals(k0.f4682r)) {
            return "https://h5.gxapp.iydsj.com/gxapp/privacy_policy/index.html";
        }
        if (activity.getPackageName().equals(k0.f4684t)) {
            return "https://www.boxkj.com/resources/user_agreement.html";
        }
        if (activity.getPackageName().equals(k0.f4685u)) {
            return "https://api2.lptiyu.com/v3/api.php/Login/user_privacy";
        }
        if (activity.getPackageName().equals(k0.f4683s)) {
            return "https://mh5.huachenjie.com/h5/contract/document.html?code=502";
        }
        return "";
    }

    public void a(Activity activity, TextView textView, TextView textView2) {
        if (textView != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor("#AAAAAA"));
        }
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        relativeLayout.setBackgroundResource(R.drawable.circle_rect_in);
    }
}
