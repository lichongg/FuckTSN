package com.bxkj.base.v2.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.bxkj.base.R;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SportCardView extends FrameLayout {
    public SportCardView(Context context) {
        this(context, null);
    }

    public SportCardView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SportCardView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        LayoutInflater.from(context).inflate(R.layout.sport_recorder_card, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SportCardView);
        String string = obtainStyledAttributes.getString(R.styleable.SportCardView_cardTitle);
        String string2 = obtainStyledAttributes.getString(R.styleable.SportCardView_count);
        String string3 = obtainStyledAttributes.getString(R.styleable.SportCardView_distance);
        int color = obtainStyledAttributes.getColor(R.styleable.SportCardView_bgColor, -16776961);
        obtainStyledAttributes.recycle();
        CardView cardView = (CardView) findViewById(R.id.card);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        TextView textView2 = (TextView) findViewById(R.id.tv_count);
        TextView textView3 = (TextView) findViewById(R.id.tv_distance);
        cardView.setCardBackgroundColor(color);
        textView.setText(string);
        textView2.setText(string2);
        textView3.setText(string3);
    }
}
