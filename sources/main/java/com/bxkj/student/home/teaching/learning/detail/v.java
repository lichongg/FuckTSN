package com.bxkj.student.home.teaching.learning.detail;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.bxkj.student.R;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private final char[] f18681a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: b, reason: collision with root package name */
    private int[] f18682b;

    /* renamed from: c, reason: collision with root package name */
    private SpannableString f18683c;

    /* renamed from: d, reason: collision with root package name */
    private Context f18684d;

    public SpannableString a() {
        this.f18682b = new int[]{ContextCompat.getColor(this.f18684d, 2131099714), ContextCompat.getColor(this.f18684d, 2131099717), ContextCompat.getColor(this.f18684d, 2131099719), ContextCompat.getColor(this.f18684d, 2131100565), ContextCompat.getColor(this.f18684d, 2131099730), ContextCompat.getColor(this.f18684d, R.color.purple), ContextCompat.getColor(this.f18684d, R.color.speed1), ContextCompat.getColor(this.f18684d, 2131099731), ContextCompat.getColor(this.f18684d, R.color.color_red_light), ContextCompat.getColor(this.f18684d, 2131099718)};
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < 4; i6++) {
            sb.append(this.f18681a[new Random().nextInt(this.f18681a.length)]);
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        this.f18683c = spannableString;
        spannableString.setSpan(new ForegroundColorSpan(this.f18682b[new Random().nextInt(this.f18682b.length)]), 0, 1, 33);
        this.f18683c.setSpan(new ForegroundColorSpan(this.f18682b[new Random().nextInt(this.f18682b.length)]), 1, 2, 33);
        this.f18683c.setSpan(new ForegroundColorSpan(this.f18682b[new Random().nextInt(this.f18682b.length)]), 2, 3, 33);
        this.f18683c.setSpan(new ForegroundColorSpan(this.f18682b[new Random().nextInt(this.f18682b.length)]), 3, 4, 33);
        return this.f18683c;
    }

    public SpannableString b() {
        return this.f18683c;
    }

    public v(Context mContext) {
        this.f18684d = mContext;
    }
}
