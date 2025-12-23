package com.bxkj.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.base.R;
import com.bxkj.base.generated.callback.a;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.base.view.MarqueeTextView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class NewPubTitleBindingImpl extends NewPubTitleBinding implements a.InterfaceC0186a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback1;
    private long mDirtyFlags;

    public NewPubTitleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = this.mTitle;
        Boolean bool = this.mIsHideBack;
        long j7 = j6 & 10;
        int i6 = 0;
        if (j7 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j7 != 0) {
                j6 |= safeUnbox ? 32L : 16L;
            }
            if (safeUnbox) {
                i6 = 4;
            }
        }
        if ((8 & j6) != 0) {
            this.ibBack.setOnClickListener(this.mCallback1);
        }
        if ((10 & j6) != 0) {
            this.ibBack.setVisibility(i6);
        }
        if ((j6 & 9) != 0) {
            TextViewBindingAdapter.setText(this.tvTitle, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.mDirtyFlags != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i6, Object obj, int i7) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
    }

    private NewPubTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatImageButton) objArr[1], (ConstraintLayout) objArr[0], (Toolbar) objArr[3], (MarqueeTextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        this.llTitle.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(view);
        this.mCallback1 = new a(this, 1);
        invalidateAll();
    }

    @Override // com.bxkj.base.generated.callback.a.InterfaceC0186a
    public final void _internalCallbackOnClick(int i6, View view) {
        b bVar = this.mActivity;
        if (bVar != null) {
            bVar.onBackPressed();
        }
    }

    @Override // com.bxkj.base.databinding.NewPubTitleBinding
    public void setActivity(@Nullable b bVar) {
        this.mActivity = bVar;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(com.bxkj.base.a.f16369b);
        super.requestRebind();
    }

    @Override // com.bxkj.base.databinding.NewPubTitleBinding
    public void setIsHideBack(@Nullable Boolean bool) {
        this.mIsHideBack = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(com.bxkj.base.a.f16380m);
        super.requestRebind();
    }

    @Override // com.bxkj.base.databinding.NewPubTitleBinding
    public void setTitle(@Nullable String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(com.bxkj.base.a.D);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i6, @Nullable Object obj) {
        if (com.bxkj.base.a.D == i6) {
            setTitle((String) obj);
            return true;
        }
        if (com.bxkj.base.a.f16380m == i6) {
            setIsHideBack((Boolean) obj);
            return true;
        }
        if (com.bxkj.base.a.f16369b != i6) {
            return false;
        }
        setActivity((b) obj);
        return true;
    }
}
