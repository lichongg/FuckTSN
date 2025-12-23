package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsPriceView extends TextView implements d {
    private static String MI = "¥%s 到手约 ¥%s";
    private static String MJ = "¥%s  ¥%s";
    private static String MK = "¥%s";
    private a MH;
    private String ML;
    private String MM;
    private boolean MN;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private int MO;
        private int MP;
        private int MQ;
        private int MR;
        private int MS;
        private int MT;

        public final a as(int i6) {
            this.MP = i6;
            return this;
        }

        public final a at(int i6) {
            this.MS = i6;
            return this;
        }

        public final a au(int i6) {
            this.MT = i6;
            return this;
        }

        public final int nQ() {
            return this.MQ;
        }

        public final int nR() {
            return this.MS;
        }

        public final int nS() {
            return this.MR;
        }

        public final int nT() {
            return this.MT;
        }

        public final int nU() {
            return this.MO;
        }

        public final int nV() {
            return this.MP;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.MH = new a();
        A(context);
    }

    private void A(Context context) {
        setMaxLines(1);
        a aVar = this.MH;
        Resources resources = context.getResources();
        int i6 = R.color.ksad_reward_main_color;
        aVar.MQ = resources.getColor(i6);
        a aVar2 = this.MH;
        Resources resources2 = context.getResources();
        int i7 = R.dimen.ksad_reward_order_price_size;
        aVar2.MR = resources2.getDimensionPixelSize(i7);
        this.MH.MS = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.MH.MT = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
        this.MH.MO = context.getResources().getColor(i6);
        this.MH.MP = context.getResources().getDimensionPixelSize(i7);
    }

    @Nullable
    private static SpannableString a(String str, @Nullable String str2, boolean z5, a aVar) {
        String format;
        if (str2 == null) {
            format = String.format(MK, str);
        } else {
            format = String.format(z5 ? MJ : MI, str, str2);
        }
        SpannableString spannableString = new SpannableString(format);
        if (format.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.nU()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.nV()), 0, 1, 17);
        }
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            return null;
        }
        int length = str.length() + indexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.nQ()), indexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.nS()), indexOf, length, 18);
        if (str2 != null) {
            int lastIndexOf = format.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + lastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.nR()), lastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.nT()), lastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
        }
        return spannableString;
    }

    public final void h(String str, String str2) {
        d(str, str2, false);
    }

    @NonNull
    public a getConfig() {
        return this.MH;
    }

    public final void d(String str, String str2, boolean z5) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            this.ML = str;
            this.MM = str2;
            this.MN = z5;
            SpannableString spannableString = null;
            if (TextUtils.isEmpty(str2)) {
                this.MM = null;
            }
            if (str != null && str.startsWith("¥")) {
                str = str.replaceFirst("¥", "");
            }
            setTextColor(this.MH.nQ());
            try {
                spannableString = a(str, this.MM, z5, this.MH);
            } catch (Exception e6) {
                c.printStackTraceOnly(e6);
            }
            if (spannableString != null) {
                setText(spannableString);
            }
        }
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MH = new a();
        A(context);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.MH = new a();
        A(context);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.MH = new a();
        A(context);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.MH.MQ = eVar.wf();
        d(this.ML, this.MM, this.MN);
    }
}
