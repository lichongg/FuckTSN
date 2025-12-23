package com.bytedance.adsdk.ugeno.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class xt {

    /* renamed from: j, reason: collision with root package name */
    private final DataSetObservable f23804j = new DataSetObservable();
    private DataSetObserver xt;

    public void cw() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.xt;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f23804j.notifyChanged();
    }

    public float j(int i6) {
        return 1.0f;
    }

    public abstract int j();

    public abstract boolean j(View view, Object obj);

    public Parcelable xt() {
        return null;
    }

    public int j(Object obj) {
        return -1;
    }

    public Object j(ViewGroup viewGroup, int i6) {
        return j((View) viewGroup, i6);
    }

    public void j(ViewGroup viewGroup, int i6, Object obj) {
        j((View) viewGroup, i6, obj);
    }

    @Deprecated
    public Object j(View view, int i6) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void j(View view, int i6, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    void j(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.xt = dataSetObserver;
        }
    }
}
