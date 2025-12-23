package com.bxkj.student.v2.common.utils;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d {
    public static void a(BottomNavigationView view, String[] imgUrl) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) view.getChildAt(0);
        if (bottomNavigationMenuView == null) {
            com.orhanobut.logger.j.c("BottomNavigationViewHelper.replaceItemImage menuView==null为空");
            return;
        }
        com.bumptech.glide.request.h V0 = com.bumptech.glide.request.h.V0();
        for (int i6 = 0; i6 < bottomNavigationMenuView.getChildCount(); i6++) {
            try {
                ImageView imageView = (ImageView) ((BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i6)).findViewById(2131298231);
                if (imageView == null) {
                    com.orhanobut.logger.j.e("BottomNavigationItemView-icon为空", new Object[0]);
                    return;
                }
                if (imgUrl[i6].startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                    com.bumptech.glide.b.D(view.getContext()).a(imgUrl[i6]).b(V0).m1(imageView);
                } else if (imgUrl[i6].startsWith("/")) {
                    com.bumptech.glide.b.D(view.getContext()).e(new File(imgUrl[i6])).b(V0).m1(imageView);
                } else {
                    com.bumptech.glide.b.D(view.getContext()).p(Integer.valueOf(Integer.parseInt(imgUrl[i6]))).b(V0).m1(imageView);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
    }

    public static void b(BottomNavigationView view, int index, @DrawableRes int defaultImg, String gifUrl) {
        try {
            com.bumptech.glide.b.D(view.getContext()).a(gifUrl).y0(defaultImg).z(defaultImg).m1((ImageView) ((BottomNavigationItemView) ((BottomNavigationMenuView) view.getChildAt(0)).getChildAt(index)).findViewById(2131297052));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void c(BottomNavigationView view, int marginTop) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) view.getChildAt(0);
        for (int i6 = 0; i6 < bottomNavigationMenuView.getChildCount(); i6++) {
            try {
                ImageView imageView = (ImageView) ((BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i6)).findViewById(2131297052);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = marginTop;
                imageView.setLayoutParams(marginLayoutParams);
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
    }

    public static void d(BottomNavigationView view, int width, int height) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) view.getChildAt(0);
        for (int i6 = 0; i6 < bottomNavigationMenuView.getChildCount(); i6++) {
            try {
                ImageView imageView = (ImageView) ((BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i6)).findViewById(2131297052);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = width;
                layoutParams.width = height;
                imageView.setLayoutParams(layoutParams);
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
    }
}
