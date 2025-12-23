package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.i.cw.xt.m;
import com.bytedance.sdk.openadsdk.widget.FlowLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends BaseAdapter {
    private j cw;

    /* renamed from: j, reason: collision with root package name */
    private final List<m> f28897j;
    private final Context xt;

    public interface j {
        void j(int i6, m mVar);
    }

    private class xt {

        /* renamed from: j, reason: collision with root package name */
        TextView f28899j;
        FlowLayout xt;

        private xt() {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i6) {
        return i6;
    }

    private StateListDrawable j() {
        Drawable j6 = j(Color.parseColor("#FDE6E6E6"));
        Drawable j7 = j(Color.parseColor("#FDFFFFFF"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, j6);
        stateListDrawable.addState(new int[0], j7);
        return stateListDrawable;
    }

    private TextView xt() {
        TextView textView = new TextView(this.xt);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        com.bytedance.sdk.openadsdk.core.dislike.j.r xt2 = com.bytedance.sdk.openadsdk.core.dislike.j.j.xt();
        marginLayoutParams.setMargins(0, 0, xt2.j(this.xt, 8.0f), xt2.j(this.xt, 8.0f));
        textView.setLayoutParams(marginLayoutParams);
        int j6 = xt2.j(this.xt, 21.0f);
        int j7 = xt2.j(this.xt, 6.0f);
        textView.setPadding(j6, j7, j6, j7);
        Drawable j8 = j(Color.parseColor("#0A161823"));
        ((GradientDrawable) j8).setCornerRadius(xt2.j(this.xt, 4.0f));
        textView.setBackground(j8);
        textView.setTextColor(Color.parseColor("#BF161823"));
        textView.setTextSize(14.0f);
        textView.setAlpha(0.75f);
        return textView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<m> list = this.f28897j;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i6) {
        return this.f28897j.get(i6);
    }

    @Override // android.widget.Adapter
    public View getView(final int i6, View view, ViewGroup viewGroup) {
        View view2;
        xt xtVar;
        if (view == null) {
            xtVar = new xt();
            view2 = com.bytedance.sdk.openadsdk.res.r.xt(this.xt);
            xtVar.f28899j = (TextView) view2.findViewById(2047279094);
            xtVar.xt = (FlowLayout) view2.findViewById(2047279093);
            view2.setTag(xtVar);
        } else {
            view2 = view;
            xtVar = (xt) view.getTag();
        }
        m mVar = this.f28897j.get(i6);
        xtVar.f28899j.setText(mVar.xt());
        if (!mVar.m()) {
            xtVar.f28899j.setBackground(j());
            xtVar.xt.setVisibility(8);
            return view2;
        }
        xtVar.xt.removeAllViews();
        List<m> r5 = mVar.r();
        for (int i7 = 0; i7 < r5.size(); i7++) {
            final m mVar2 = r5.get(i7);
            TextView xt2 = xt();
            xt2.setText(mVar2.xt());
            xt2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.r.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (r.this.cw != null) {
                        r.this.cw.j(i6, mVar2);
                    }
                }
            });
            xtVar.xt.addView(xt2);
        }
        xtVar.xt.setVisibility(0);
        return view2;
    }

    public r(Context context, List<m> list) {
        ArrayList arrayList;
        if (list == null) {
            arrayList = new ArrayList(0);
        } else {
            arrayList = new ArrayList(list);
        }
        this.f28897j = arrayList;
        this.xt = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : context;
    }

    private Drawable j(int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i6);
        return gradientDrawable;
    }

    public void j(j jVar) {
        this.cw = jVar;
    }

    public void j(List<m> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f28897j.clear();
        this.f28897j.addAll(list);
        notifyDataSetChanged();
    }
}
