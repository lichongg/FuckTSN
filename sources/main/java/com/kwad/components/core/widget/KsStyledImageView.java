package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.t.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsStyledImageView extends ImageView implements d {
    public KsStyledImageView(Context context) {
        super(context);
    }

    public KsStyledImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledImageView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        j.b(eVar, getBackground());
    }

    @RequiresApi(api = 21)
    public KsStyledImageView(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }
}
