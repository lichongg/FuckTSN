package com.bytedance.adsdk.ugeno.m;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import com.bytedance.sdk.component.utils.vl;
import java.lang.reflect.Field;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static Field f23712j;
    private static boolean xt;

    public static Drawable j(CompoundButton compoundButton) {
        Drawable buttonDrawable;
        if (Build.VERSION.SDK_INT >= 23) {
            buttonDrawable = compoundButton.getButtonDrawable();
            return buttonDrawable;
        }
        if (!xt) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f23712j = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e6) {
                vl.j("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e6);
            }
            xt = true;
        }
        Field field = f23712j;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e7) {
                vl.j("CompoundButtonCompat", "Failed to get button drawable via reflection", e7);
                f23712j = null;
            }
        }
        return null;
    }
}
