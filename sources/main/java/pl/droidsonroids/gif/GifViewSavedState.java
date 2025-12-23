package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final long[][] f51795a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Parcelable.Creator<GifViewSavedState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GifViewSavedState[] newArray(int i6) {
            return new GifViewSavedState[i6];
        }

        a() {
        }
    }

    /* synthetic */ GifViewSavedState(Parcel parcel, a aVar) {
        this(parcel);
    }

    GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f51795a = new long[drawableArr.length][];
        for (int i6 = 0; i6 < drawableArr.length; i6++) {
            Drawable drawable = drawableArr[i6];
            if (drawable instanceof e) {
                this.f51795a[i6] = ((e) drawable).f51809g.o();
            } else {
                this.f51795a[i6] = null;
            }
        }
    }

    void a(Drawable drawable, int i6) {
        if (this.f51795a[i6] == null || !(drawable instanceof e)) {
            return;
        }
        ((e) drawable).J(r3.f51809g.E(r4, r3.f51808f));
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeInt(this.f51795a.length);
        for (long[] jArr : this.f51795a) {
            parcel.writeLongArray(jArr);
        }
    }

    private GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f51795a = new long[parcel.readInt()][];
        int i6 = 0;
        while (true) {
            long[][] jArr = this.f51795a;
            if (i6 >= jArr.length) {
                return;
            }
            jArr[i6] = parcel.createLongArray();
            i6++;
        }
    }

    GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.f51795a = new long[][]{jArr};
    }
}
