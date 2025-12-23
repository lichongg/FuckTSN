package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
interface j {
    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<cw> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int j(int i6, int i7, int i8);

    int j(View view);

    int j(View view, int i6, int i7);

    View j(int i6);

    void j(View view, int i6, int i7, cw cwVar);

    void j(cw cwVar);

    boolean j();

    void setFlexLines(List<cw> list);

    int xt(int i6, int i7, int i8);

    View xt(int i6);
}
