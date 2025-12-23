package com.bxkj.student.run.app.record;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bxkj.student.R;
import com.bxkj.student.run.app.ready.RunType;
import java.text.DecimalFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class Card extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f19969a;

    /* renamed from: b, reason: collision with root package name */
    private Context f19970b;

    private String d(@RunType int runType) {
        return runType != 1 ? runType != 2 ? runType != 3 ? this.f19970b.getString(R.string.free_run) : this.f19970b.getString(R.string.free_run) : this.f19970b.getString(R.string.sunshine_run) : this.f19970b.getString(R.string.morning_run);
    }

    public int getRunType() {
        return this.f19969a;
    }

    public Card(Context mContext) {
        super(mContext);
        this.f19970b = mContext;
        LayoutInflater.from(mContext).inflate(R.layout.card_recorder, this);
    }

    public Card e(int bgColor) {
        ((CardView) findViewById(R.id.card1)).setCardBackgroundColor(bgColor);
        return this;
    }

    public Card f(int runType) {
        ((TextView) findViewById(2131299164)).setText(d(runType) + "记录");
        this.f19969a = runType;
        return this;
    }

    public void setCount(int count) {
        final TextView textView = (TextView) findViewById(2131298848);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, count);
        ofInt.setDuration(1000L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.student.run.app.record.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                textView.setText(valueAnimator.getAnimatedValue().toString());
            }
        });
        ofInt.start();
    }

    public void setDistance(double distance) {
        final TextView textView = (TextView) findViewById(2131298881);
        ValueAnimator ofObject = ValueAnimator.ofObject(new TypeEvaluator() { // from class: com.bxkj.student.run.app.record.f
            @Override // android.animation.TypeEvaluator
            public final Object evaluate(float f6, Object obj, Object obj2) {
                Double valueOf;
                valueOf = Double.valueOf((((Double) obj2).doubleValue() - ((Double) obj).doubleValue()) * f6);
                return valueOf;
            }
        }, Double.valueOf(0.0d), Double.valueOf(distance));
        ofObject.setDuration(1000L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.student.run.app.record.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                textView.setText(new DecimalFormat("0.000").format(((Double) valueAnimator.getAnimatedValue()).doubleValue()));
            }
        });
        ofObject.start();
    }
}
