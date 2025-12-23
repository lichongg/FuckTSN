package cn.jpush.android.api;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.ad.f;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.webview.bridge.HostJsScope;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.io.InputStream;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes2.dex */
public class SystemAlertHelper {

    /* renamed from: a, reason: collision with root package name */
    private static int f3510a = 400;

    /* renamed from: b, reason: collision with root package name */
    private static int f3511b = 600;

    /* renamed from: c, reason: collision with root package name */
    private static ImageButton f3512c;

    /* renamed from: d, reason: collision with root package name */
    private static WindowManager f3513d;

    /* renamed from: e, reason: collision with root package name */
    private static WebView f3514e;

    private static DisplayMetrics a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            return null;
        }
        Logger.d("SystemAlertHelper", "width : " + displayMetrics.widthPixels);
        Logger.d("SystemAlertHelper", "height : " + displayMetrics.heightPixels);
        Logger.d("SystemAlertHelper", "density : " + displayMetrics.density);
        Logger.d("SystemAlertHelper", "densityDpi : " + displayMetrics.densityDpi);
        Logger.d("SystemAlertHelper", "xdpi : " + displayMetrics.xdpi);
        Logger.d("SystemAlertHelper", "ydpi : " + displayMetrics.ydpi);
        return displayMetrics;
    }

    public static void systemAlert() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, WindowManager windowManager, WebView webView, ImageButton imageButton) {
        int i6;
        int i7;
        DisplayMetrics a6 = a(context);
        if (a6 != null) {
            int i8 = (a6.widthPixels * 3) / 4;
            f3510a = i8;
            int i9 = a6.heightPixels / 2;
            f3511b = i9;
            i6 = i8 / 2;
            i7 = -(i9 / 2);
        } else {
            i6 = 200;
            i7 = -300;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.gravity = 17;
        layoutParams.type = 2003;
        layoutParams.flags |= 552;
        layoutParams.width = f3510a;
        layoutParams.height = f3511b;
        layoutParams.x = -1;
        layoutParams.y = -1;
        windowManager.addView(webView, layoutParams);
        imageButton.setBackgroundColor(context.getResources().getColor(R.color.transparent));
        imageButton.setImageDrawable(context.getResources().getDrawable(context.getResources().getIdentifier("jpush_close", ResIdentify.RES_TYPE_DRAWABLE, context.getPackageName())));
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.y = i7;
        layoutParams.x = i6;
        windowManager.addView(imageButton, layoutParams);
    }

    public static void close() {
        WindowManager windowManager = f3513d;
        if (windowManager == null) {
            return;
        }
        try {
            WebView webView = f3514e;
            if (webView != null) {
                windowManager.removeView(webView);
            }
            ImageButton imageButton = f3512c;
            if (imageButton != null) {
                f3513d.removeView(imageButton);
            }
        } catch (Throwable unused) {
        }
        f3513d = null;
        f3514e = null;
        f3512c = null;
    }

    public static int getWindowHeight() {
        return f3511b;
    }

    public static int getWindowWidth() {
        return f3510a;
    }

    public static void startActivityByName(WebView webView, String str, String str2) {
        Context appContext;
        Logger.d("SystemAlertHelper", "action --- startActivityByName--------activityName : " + str + "----- params : " + str2);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("SystemAlertHelper", "The activity name is null or empty, Give up..");
        }
        if (webView == null || (appContext = JPushConstants.getAppContext(webView.getContext())) == null) {
            return;
        }
        try {
            Intent intent = new Intent(webView.getContext(), Class.forName(str));
            intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
            intent.setFlags(268435456);
            appContext.startActivity(intent);
            close();
        } catch (Exception unused) {
            Logger.ee("SystemAlertHelper", "The activity name is invalid, Give up..");
        }
    }

    public static void systemAlert(final Context context, final d dVar) {
        new Handler(Looper.getMainLooper()).post(new f("SystemAlertHelper#systemAlert") { // from class: cn.jpush.android.api.SystemAlertHelper.1
            @Override // cn.jpush.android.ad.f
            @SuppressLint({"NewApi"})
            public void a() {
                String str = dVar.Z;
                if (TextUtils.isEmpty(str)) {
                    Logger.e("SystemAlertHelper", " not Rich Notification");
                    return;
                }
                WindowManager unused = SystemAlertHelper.f3513d = (WindowManager) context.getSystemService("window");
                WebView unused2 = SystemAlertHelper.f3514e = new WebView(context);
                ImageButton unused3 = SystemAlertHelper.f3512c = new ImageButton(context);
                SystemAlertHelper.b(context, SystemAlertHelper.f3513d, SystemAlertHelper.f3514e, SystemAlertHelper.f3512c);
                SystemAlertHelper.f3514e.setHorizontalScrollBarEnabled(false);
                SystemAlertHelper.f3514e.setVerticalScrollBarEnabled(false);
                SystemAlertHelper.f3514e.setScrollbarFadingEnabled(true);
                SystemAlertHelper.f3514e.setScrollBarStyle(CommonNetImpl.FLAG_SHARE_JUMP);
                cn.jpush.android.ad.a.c(SystemAlertHelper.f3514e.getSettings());
                cn.jpush.android.ad.a.a(SystemAlertHelper.f3514e);
                SystemAlertHelper.f3514e.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
                SystemAlertHelper.f3514e.setWebViewClient(new cn.jpush.android.ui.a(dVar, context));
                if (!TextUtils.isEmpty(str) && str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                    SystemAlertHelper.f3514e.loadUrl(str);
                }
                SystemAlertHelper.f3512c.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.api.SystemAlertHelper.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SystemAlertHelper.close();
                    }
                });
            }
        });
    }

    public static Bitmap getImageFromAssetsFile(Context context, String str) {
        Bitmap bitmap = null;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException unused) {
            return bitmap;
        }
    }
}
