package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.generated.callback.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PubTitleBindingImpl extends PubTitleBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds = null;

    @Nullable
    private final View.OnClickListener mCallback45;

    @Nullable
    private final View.OnClickListener mCallback46;
    private long mDirtyFlags;

    public PubTitleBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        AppCompatActivity appCompatActivity;
        if (sourceId != 1) {
            if (sourceId == 2 && (appCompatActivity = this.mActivity) != null) {
                appCompatActivity.finish();
                return;
            }
            return;
        }
        AppCompatActivity appCompatActivity2 = this.mActivity;
        if (appCompatActivity2 != null) {
            appCompatActivity2.finish();
        }
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
            this.ibBack.setOnClickListener(this.mCallback45);
            this.ibRight.setOnClickListener(this.mCallback46);
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
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    private PubTitleBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatImageButton) bindings[2], (AppCompatImageButton) bindings[3], (ConstraintLayout) bindings[0], (MarqueeTextView) bindings[1]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        this.ibRight.setTag(null);
        this.llTitle.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        this.mCallback45 = new a(this, 1);
        this.mCallback46 = new a(this, 2);
        invalidateAll();
    }

    @Override // com.bxkj.student.databinding.PubTitleBinding
    public void setActivity(@Nullable AppCompatActivity Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.PubTitleBinding
    public void setIsHideBack(@Nullable Boolean IsHideBack) {
        this.mIsHideBack = IsHideBack;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.PubTitleBinding
    public void setTitle(@Nullable String Title) {
        this.mTitle = Title;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(29);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (29 == variableId) {
            setTitle((String) variable);
            return true;
        }
        if (12 == variableId) {
            setIsHideBack((Boolean) variable);
            return true;
        }
        if (1 != variableId) {
            return false;
        }
        setActivity((AppCompatActivity) variable);
        return true;
    }
}
