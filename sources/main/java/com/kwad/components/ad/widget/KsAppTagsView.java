package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsAppTagsView extends LinearLayout {
    private int MG;

    public KsAppTagsView(Context context) {
        super(context);
        this.MG = 3;
    }

    public final void a(List<String> list, @LayoutRes int i6) {
        if (list == null) {
            return;
        }
        int i7 = 0;
        for (String str : list) {
            i7++;
            if (i7 > this.MG) {
                return;
            } else {
                a(this, str, i6);
            }
        }
    }

    public void setAppTags(List<String> list) {
        a(list, R.layout.ksad_reward_apk_info_card_tag_item);
    }

    public void setMaxCount(int i6) {
        this.MG = i6;
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MG = 3;
    }

    private static void a(LinearLayout linearLayout, String str, @LayoutRes int i6) {
        TextView textView = (TextView) m.a(linearLayout.getContext(), i6, linearLayout, false);
        textView.setText(str);
        linearLayout.addView(textView);
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.MG = 3;
    }

    @RequiresApi(api = 21)
    public KsAppTagsView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.MG = 3;
    }
}
