package com.google.android.material.bottomnavigation;

import android.content.Context;
import androidx.annotation.DimenRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class BottomNavigationItemView extends NavigationBarItemView {
    @Override // com.google.android.material.navigation.NavigationBarItemView
    @DimenRes
    protected int getItemDefaultMarginResId() {
        return R.dimen.design_bottom_navigation_margin;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @LayoutRes
    protected int getItemLayoutResId() {
        return R.layout.design_bottom_navigation_item;
    }

    public BottomNavigationItemView(@NonNull Context context) {
        super(context);
    }
}
