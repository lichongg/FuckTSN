package com.bxkj.competition.signup;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.competition.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class StickyDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: e, reason: collision with root package name */
    private TextPaint f17451e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f17452f;

    /* renamed from: g, reason: collision with root package name */
    private int f17453g;

    /* renamed from: h, reason: collision with root package name */
    private List<Map<String, Object>> f17454h;

    /* renamed from: i, reason: collision with root package name */
    private Context f17455i;

    /* renamed from: j, reason: collision with root package name */
    private final Resources f17456j;

    private boolean a(int position) {
        return position == 0 || position <= 0 || position >= this.f17454h.size() || !JsonParse.getString(this.f17454h.get(position), "groupName").equals(JsonParse.getString(this.f17454h.get(position - 1), "groupName"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c6, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c6, parent, state);
        List<Map<String, Object>> list = this.f17454h;
        if (list == null || list.size() == 0) {
            return;
        }
        int paddingLeft = parent.getPaddingLeft();
        int width = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = parent.getChildAt(i6);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            if (a(childAdapterPosition)) {
                String string = (childAdapterPosition <= 0 || childAdapterPosition >= this.f17454h.size()) ? "" : JsonParse.getString(this.f17454h.get(childAdapterPosition), "groupName");
                int top2 = childAt.getTop() - this.f17453g;
                int top3 = childAt.getTop();
                this.f17452f.setColor(this.f17455i.getResources().getColor(R.color.colorAccent));
                c6.drawRect(paddingLeft, top2, width, top3, this.f17452f);
                this.f17452f.setColor(this.f17456j.getColor(R.color.group_bg));
                c6.drawRect(new Rect(u.a(5.0f, this.f17455i) + paddingLeft, top2, width, top3), this.f17452f);
                Paint.FontMetricsInt fontMetricsInt = this.f17451e.getFontMetricsInt();
                c6.drawText(string, paddingLeft + 30, (((r1.bottom + r1.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.f17451e);
            }
        }
    }

    public StickyDecoration(Context context, List<Map<String, Object>> dataList) {
        this.f17454h = dataList;
        this.f17455i = context;
        Resources resources = context.getResources();
        this.f17456j = resources;
        Paint paint = new Paint();
        this.f17452f = paint;
        paint.setColor(resources.getColor(R.color.group_bg));
        TextPaint textPaint = new TextPaint();
        this.f17451e = textPaint;
        textPaint.setAntiAlias(true);
        this.f17451e.setTextSize(context.getResources().getDisplayMetrics().scaledDensity * 16.0f);
        this.f17451e.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f17453g = u.a(50.0f, context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        List<Map<String, Object>> list = this.f17454h;
        if (list != null && list.size() != 0) {
            if (a(parent.getChildAdapterPosition(view))) {
                outRect.top = this.f17453g;
            } else {
                outRect.top = 0;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c6, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c6, parent, state);
        List<Map<String, Object>> list = this.f17454h;
        if (list != null && list.size() != 0) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) parent.getLayoutManager()).findFirstVisibleItemPosition();
            int paddingLeft = parent.getPaddingLeft();
            int width = parent.getWidth() - parent.getPaddingRight();
            String string = JsonParse.getString(this.f17454h.get(findFirstVisibleItemPosition), "groupName");
            this.f17452f.setColor(this.f17455i.getResources().getColor(R.color.colorAccent));
            c6.drawRect(paddingLeft, 0.0f, width, this.f17453g, this.f17452f);
            this.f17452f.setColor(this.f17456j.getColor(R.color.group_bg));
            c6.drawRect(new Rect(paddingLeft + u.a(5.0f, this.f17455i), 0, width, this.f17453g), this.f17452f);
            Paint.FontMetricsInt fontMetricsInt = this.f17451e.getFontMetricsInt();
            c6.drawText(string, 30.0f, (((r10.bottom + r10.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.f17451e);
        }
    }
}
