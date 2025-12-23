package pl.droidsonroids.gif;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import pl.droidsonroids.gif.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class GifImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f51777a;

    public GifImageView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        if (k.e(this, false, i6)) {
            return;
        }
        super.setBackgroundResource(i6);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i6) {
        if (k.e(this, true, i6)) {
            return;
        }
        super.setImageResource(i6);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(k.c(this, attributeSet, 0, 0));
    }

    private void a(k.a aVar) {
        this.f51777a = aVar.f51840a;
        int i6 = aVar.f51838c;
        if (i6 > 0) {
            super.setImageResource(i6);
        }
        int i7 = aVar.f51839d;
        if (i7 > 0) {
            super.setBackgroundResource(i7);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.a(getDrawable(), 0);
        gifViewSavedState.a(getBackground(), 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new GifViewSavedState(super.onSaveInstanceState(), this.f51777a ? getDrawable() : null, this.f51777a ? getBackground() : null);
    }

    public void setFreezesAnimation(boolean z5) {
        this.f51777a = z5;
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (!k.d(this, uri)) {
            super.setImageURI(uri);
        }
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        a(k.c(this, attributeSet, i6, 0));
    }

    @RequiresApi(21)
    public GifImageView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        a(k.c(this, attributeSet, i6, i7));
    }
}
