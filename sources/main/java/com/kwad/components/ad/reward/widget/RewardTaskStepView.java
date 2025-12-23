package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.ad.reward.l.c;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RewardTaskStepView extends LinearLayout {
    private List<c> Eo;
    private String sV;

    public RewardTaskStepView(Context context) {
        super(context);
        this.Eo = new ArrayList();
        lo();
    }

    private void lo() {
        setOrientation(1);
    }

    public final void a(List<c> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.sV = str;
        this.Eo.clear();
        this.Eo.addAll(list);
        lp();
    }

    private void lp() {
        int size = this.Eo.size();
        int i6 = 0;
        while (i6 < size) {
            c cVar = this.Eo.get(i6);
            int i7 = i6 + 1;
            a(i7, cVar.kE(), cVar.kF(), cVar.isCompleted());
            if (i6 < size - 1) {
                ae(this.Eo.get(i7).isCompleted());
            }
            i6 = i7;
        }
    }

    private void ae(boolean z5) {
        int i6;
        DividerView dividerView = (DividerView) m.a(getContext(), R.layout.ksad_reward_task_dialog_dash, this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_divider_height);
        if (z5) {
            i6 = R.color.ksad_reward_main_color;
        } else {
            i6 = R.color.ksad_reward_undone_color;
        }
        dividerView.setDividerColor(getResources().getColor(i6));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Eo = new ArrayList();
        lo();
    }

    private void a(int i6, String str, String str2, boolean z5) {
        int i7;
        if (z5) {
            i7 = R.layout.ksad_reward_task_step_item_checked;
        } else {
            i7 = R.layout.ksad_reward_task_step_item_unchecked;
        }
        ViewGroup viewGroup = (ViewGroup) m.a(getContext(), i7, this, false);
        if (z5) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i6, str2);
        }
        addView(viewGroup);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.Eo = new ArrayList();
        lo();
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.Eo = new ArrayList();
        lo();
    }

    private static void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(str);
    }

    private void a(ViewGroup viewGroup, int i6, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(String.format(str, this.sV));
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_icon_text)).setText(String.valueOf(i6));
    }
}
