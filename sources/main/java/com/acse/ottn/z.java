package com.acse.ottn;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class z extends AppCompatActivity {

    /* renamed from: d, reason: collision with root package name */
    public static final String f5531d = "BaseActivity";

    /* renamed from: a, reason: collision with root package name */
    public Toast f5532a;

    /* renamed from: b, reason: collision with root package name */
    public long f5533b = 0;

    /* renamed from: c, reason: collision with root package name */
    public AppCompatActivity f5534c;

    public void a(AppCompatActivity appCompatActivity) {
        this.f5534c = appCompatActivity;
    }

    public void b() {
        finish();
        overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.slide_out_from_top);
        p.c(this);
    }

    public void a() {
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_right);
        p.c(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f5534c == null) {
            a();
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(67108864);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Toast toast = this.f5532a;
        if (toast != null) {
            toast.cancel();
            this.f5532a = null;
        }
        super.onDestroy();
    }

    public void c(Intent intent) {
        p.c(this);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (b(this)) {
            a((Activity) this);
        }
        super.onCreate(bundle);
        setRequestedOrientation(1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Toast toast = this.f5532a;
        if (toast != null) {
            toast.cancel();
            this.f5532a = null;
        }
        o.f4968l = Boolean.FALSE;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        o.f4968l = Boolean.TRUE;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        c2.b("Memory", "max:" + ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + " total:" + ((Runtime.getRuntime().totalMemory() / 1024) / 1024) + " free:" + ((Runtime.getRuntime().freeMemory() / 1024) / 1024) + " ");
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i6) {
        if (b(this)) {
            return;
        }
        super.setRequestedOrientation(i6);
    }

    public void b(Intent intent) {
        p.c(this);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.slide_out_from_top);
    }

    public void a(Intent intent) {
        finish();
        p.c(this);
        c(intent);
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_right);
    }

    public static boolean b(Activity activity) {
        Exception e6;
        boolean z5;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z5 = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                return z5;
            } catch (Exception e7) {
                e6 = e7;
                e6.printStackTrace();
                return z5;
            }
        } catch (Exception e8) {
            e6 = e8;
            z5 = false;
        }
    }

    public void a(Intent intent, int i6) {
        p.c(this);
        startActivityForResult(intent, i6);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
    }

    public void a(int i6) {
        Window window = getWindow();
        a(this, i6, 0);
        window.addFlags(2048);
        window.clearFlags(1024);
        window.getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f35648o);
    }

    public void a(Activity activity, @ColorInt int i6, @IntRange(from = 0, to = 255) int i7) {
        i4.b(activity, i6, i7);
    }

    public void a(boolean z5) {
        if (z5) {
            getWindow().getDecorView().setSystemUiVisibility(1024);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(AVMDLDataLoader.KeyIsLoaderCacheSize);
        }
    }

    public static boolean a(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }
}
