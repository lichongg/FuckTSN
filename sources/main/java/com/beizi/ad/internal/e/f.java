package com.beizi.ad.internal.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.ad.i;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.lance.ApkBean;
import com.beizi.fusion.R;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f {
    public static void a(final i iVar, final View view, final b bVar) {
        if (!a(iVar) || view == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.ad.internal.e.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.a(view, bVar)) {
                    view.setTag(R.string.beizi_native_tag, new WeakReference(i.this));
                }
            }
        });
    }

    @Deprecated
    public static void a(final i iVar, final View view, final List<View> list, final b bVar) {
        if (!a(iVar) || view == null || list == null || list.isEmpty()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.ad.internal.e.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.a(view, list, bVar)) {
                    view.setTag(R.string.beizi_native_tag, new WeakReference(i.this));
                }
            }
        });
    }

    public static void a(i iVar, View view, String str, String str2, String str3, String str4, int i6) {
        try {
            Context context = view.getContext();
            View rootView = view.getRootView();
            if (rootView != null) {
                context = rootView.getContext();
            }
            iVar.a(context, view, str, str2, str3, str4, i6);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    static boolean a(i iVar) {
        return (iVar == null || iVar.g()) ? false : true;
    }

    public static FrameLayout a(View view, i iVar) {
        try {
            int i6 = R.drawable.button_close_background;
            if (view.getTag(i6) != null && (view.getTag(i6) instanceof FrameLayout)) {
                u.a((FrameLayout) view.getTag(i6));
                return (FrameLayout) view.getTag(i6);
            }
            view.getContext();
            u.a(view);
            FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1, 17));
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout a6 = u.a(view.getContext(), iVar.l());
            a6.setVisibility(0);
            linearLayout.addView(a6, new FrameLayout.LayoutParams(-2, -2, 17));
            View b6 = u.b(view.getContext(), iVar.k());
            b6.setVisibility(0);
            linearLayout.addView(b6, new FrameLayout.LayoutParams(-2, -2, 17));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b6.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            b6.setLayoutParams(layoutParams);
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int a7 = u.a(view.getContext(), 20.0f);
            layoutParams2.setMargins(0, 0, a7, a7);
            linearLayout.setLayoutParams(layoutParams2);
            view.setTag(i6, frameLayout);
            return frameLayout;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static FrameLayout a(Context context, Bitmap bitmap, i iVar) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(0);
        imageView.setImageBitmap(bitmap);
        return a(imageView, iVar);
    }

    public static View a(final Context context, i iVar) {
        if (context != null && iVar != null) {
            try {
                ApkBean n6 = iVar.n();
                if (n6 == null) {
                    return null;
                }
                final String apkName = n6.getApkName();
                String appDeveloper = n6.getAppDeveloper();
                String appVersion = n6.getAppVersion();
                String appPermissionsUrl = n6.getAppPermissionsUrl();
                final String appPermissionsDesc = !TextUtils.isEmpty(appPermissionsUrl) ? appPermissionsUrl : n6.getAppPermissionsDesc();
                final String appPrivacyUrl = n6.getAppPrivacyUrl();
                final String appintro = n6.getAppintro();
                String str = "应用名称：" + apkName + " | 开发者：" + appDeveloper + " | 应用版本：" + appVersion + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>";
                TextView textView = new TextView(context);
                textView.setText(Html.fromHtml(str));
                textView.setTextSize(2, 6.0f);
                textView.setTextColor(Color.parseColor("#999999"));
                textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
                textView.setPadding(10, 10, 10, 10);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.e.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(context, (Class<?>) DownloadAppInfoActivity.class);
                            intent.putExtra("title_content_key", apkName);
                            intent.putExtra("privacy_content_key", appPrivacyUrl);
                            intent.putExtra("permission_content_key", appPermissionsDesc);
                            intent.putExtra("intro_content_key", appintro);
                            intent.setFlags(268435456);
                            context.startActivity(intent);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
                return textView;
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }
}
