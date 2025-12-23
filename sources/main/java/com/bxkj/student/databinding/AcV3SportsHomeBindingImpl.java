package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.amap.api.maps.MapView;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.common.utils.h;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcV3SportsHomeBindingImpl extends AcV3SportsHomeBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback47;

    @Nullable
    private final View.OnClickListener mCallback48;

    @Nullable
    private final View.OnClickListener mCallback49;

    @Nullable
    private final View.OnClickListener mCallback50;

    @Nullable
    private final View.OnClickListener mCallback51;

    @Nullable
    private final View.OnClickListener mCallback52;

    @Nullable
    private final View.OnClickListener mCallback53;

    @Nullable
    private final View.OnClickListener mCallback54;

    @Nullable
    private final View.OnClickListener mCallback55;

    @Nullable
    private final View.OnClickListener mCallback56;

    @Nullable
    private final View.OnClickListener mCallback57;

    @Nullable
    private final View.OnClickListener mCallback58;

    @Nullable
    private final View.OnClickListener mCallback59;

    @Nullable
    private final View.OnClickListener mCallback60;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    @NonNull
    private final TextView mboundView6;

    public AcV3SportsHomeBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
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
            this.mDirtyFlags = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.map, 17);
        sparseIntArray.put(2131298081, 18);
        sparseIntArray.put(R.id.tab, 19);
        sparseIntArray.put(R.id.cl_data, 20);
        sparseIntArray.put(R.id.card_user, 21);
        sparseIntArray.put(2131298083, 22);
        sparseIntArray.put(2131297148, 23);
        sparseIntArray.put(R.id.tv_weather, 24);
        sparseIntArray.put(R.id.cl_gps, 25);
        sparseIntArray.put(R.id.tv_gps, 26);
        sparseIntArray.put(R.id.iv_gps, 27);
        sparseIntArray.put(2131296574, 28);
        sparseIntArray.put(2131298879, 29);
    }

    private AcV3SportsHomeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialCardView) bindings[28], (MaterialCardView) bindings[21], (ConstraintLayout) bindings[20], (ConstraintLayout) bindings[25], (AppCompatImageButton) bindings[1], (ConstraintLayout) bindings[2], (ImageView) bindings[12], (AppCompatImageView) bindings[27], (ShapeableImageView) bindings[23], (ImageView) bindings[15], (ImageView) bindings[14], (ImageView) bindings[9], (ConstraintLayout) bindings[18], (LinearLayout) bindings[22], (MapView) bindings[17], (TabLayout) bindings[19], (TextView) bindings[11], (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[29], (TextView) bindings[13], (TextView) bindings[5], (TextView) bindings[26], (TextView) bindings[10], (TextView) bindings[16], (TextView) bindings[7], (TextView) bindings[8], (TextView) bindings[24]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        this.ibSet.setTag(null);
        this.ivDescription.setTag(null);
        this.ivPermission.setTag(null);
        this.ivStart.setTag(null);
        this.ivTimeArrow.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[6];
        this.mboundView6 = textView;
        textView.setTag(null);
        this.tvAccount.setTag(null);
        this.tvCount.setTag(null);
        this.tvCountHint.setTag(null);
        this.tvDescriptionV3.setTag(null);
        this.tvDistance.setTag(null);
        this.tvName.setTag(null);
        this.tvPermissionV3.setTag(null);
        this.tvTime.setTag(null);
        this.tvTimeUnit.setTag(null);
        setRootTag(root);
        this.mCallback47 = new a(this, 1);
        this.mCallback59 = new a(this, 13);
        this.mCallback55 = new a(this, 9);
        this.mCallback50 = new a(this, 4);
        this.mCallback48 = new a(this, 2);
        this.mCallback56 = new a(this, 10);
        this.mCallback51 = new a(this, 5);
        this.mCallback49 = new a(this, 3);
        this.mCallback57 = new a(this, 11);
        this.mCallback52 = new a(this, 6);
        this.mCallback60 = new a(this, 14);
        this.mCallback58 = new a(this, 12);
        this.mCallback54 = new a(this, 8);
        this.mCallback53 = new a(this, 7);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        long j7;
        long j8;
        String str;
        String str2;
        String str3;
        int i6;
        String str4;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mRecordMap;
        b bVar = this.mLoggedInUser;
        long j9 = j6 & 17;
        String str5 = null;
        if (j9 != 0) {
            c0 c0Var = c0.f16887a;
            int k6 = c0Var.k(map, "sportType");
            double f6 = c0Var.f(map, "runSportRange");
            j7 = 0;
            str2 = c0Var.u(map, "succeed", "0");
            j8 = 17;
            str = c0Var.u(map, "sumTime", "0");
            boolean z5 = k6 == 5;
            str3 = h.f16899a.a(f6);
            if (j9 != 0) {
                j6 |= z5 ? 320L : 160L;
            }
            int i7 = z5 ? 0 : 8;
            i6 = z5 ? 8 : 0;
            r12 = i7;
        } else {
            j7 = 0;
            j8 = 17;
            str = null;
            str2 = null;
            str3 = null;
            i6 = 0;
        }
        long j10 = 20 & j6;
        if (j10 == j7 || bVar == null) {
            str4 = null;
        } else {
            str5 = bVar.S();
            str4 = bVar.U();
        }
        if ((16 & j6) != j7) {
            this.ibBack.setOnClickListener(this.mCallback47);
            this.ibSet.setOnClickListener(this.mCallback48);
            this.ivDescription.setOnClickListener(this.mCallback56);
            this.ivPermission.setOnClickListener(this.mCallback59);
            this.ivStart.setOnClickListener(this.mCallback58);
            this.ivTimeArrow.setOnClickListener(this.mCallback55);
            this.mboundView6.setOnClickListener(this.mCallback52);
            this.tvCount.setOnClickListener(this.mCallback49);
            this.tvCountHint.setOnClickListener(this.mCallback50);
            this.tvDescriptionV3.setOnClickListener(this.mCallback57);
            this.tvDistance.setOnClickListener(this.mCallback51);
            this.tvPermissionV3.setOnClickListener(this.mCallback60);
            this.tvTime.setOnClickListener(this.mCallback53);
            this.tvTimeUnit.setOnClickListener(this.mCallback54);
        }
        if ((j6 & j8) != j7) {
            this.ivTimeArrow.setVisibility(r12);
            this.mboundView6.setVisibility(i6);
            TextViewBindingAdapter.setText(this.tvCount, str2);
            this.tvDistance.setVisibility(i6);
            TextViewBindingAdapter.setText(this.tvDistance, str3);
            TextViewBindingAdapter.setText(this.tvTime, str);
        }
        if (j10 != j7) {
            TextViewBindingAdapter.setText(this.tvAccount, str5);
            TextViewBindingAdapter.setText(this.tvName, str4);
        }
    }

    @Override // com.bxkj.student.databinding.AcV3SportsHomeBinding
    public void setBackEvent(@Nullable V3SportsHomeActivity BackEvent) {
        this.mBackEvent = BackEvent;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsHomeBinding
    public void setLoggedInUser(@Nullable b LoggedInUser) {
        this.mLoggedInUser = LoggedInUser;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsHomeBinding
    public void setRecordMap(@Nullable Map<String, Object> RecordMap) {
        this.mRecordMap = RecordMap;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsHomeBinding
    public void setTitle(@Nullable String Title) {
        this.mTitle = Title;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (23 == variableId) {
            setRecordMap((Map) variable);
            return true;
        }
        if (4 == variableId) {
            setBackEvent((V3SportsHomeActivity) variable);
            return true;
        }
        if (14 == variableId) {
            setLoggedInUser((b) variable);
            return true;
        }
        if (29 != variableId) {
            return false;
        }
        setTitle((String) variable);
        return true;
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                V3SportsHomeActivity v3SportsHomeActivity = this.mBackEvent;
                if (v3SportsHomeActivity != null) {
                    v3SportsHomeActivity.r1();
                    break;
                }
                break;
            case 2:
                V3SportsHomeActivity v3SportsHomeActivity2 = this.mBackEvent;
                if (v3SportsHomeActivity2 != null) {
                    v3SportsHomeActivity2.d2();
                    break;
                }
                break;
            case 3:
                V3SportsHomeActivity v3SportsHomeActivity3 = this.mBackEvent;
                if (v3SportsHomeActivity3 != null) {
                    v3SportsHomeActivity3.c2();
                    break;
                }
                break;
            case 4:
                V3SportsHomeActivity v3SportsHomeActivity4 = this.mBackEvent;
                if (v3SportsHomeActivity4 != null) {
                    v3SportsHomeActivity4.c2();
                    break;
                }
                break;
            case 5:
                V3SportsHomeActivity v3SportsHomeActivity5 = this.mBackEvent;
                if (v3SportsHomeActivity5 != null) {
                    v3SportsHomeActivity5.b2();
                    break;
                }
                break;
            case 6:
                V3SportsHomeActivity v3SportsHomeActivity6 = this.mBackEvent;
                if (v3SportsHomeActivity6 != null) {
                    v3SportsHomeActivity6.b2();
                    break;
                }
                break;
            case 7:
                V3SportsHomeActivity v3SportsHomeActivity7 = this.mBackEvent;
                if (v3SportsHomeActivity7 != null) {
                    v3SportsHomeActivity7.c2();
                    break;
                }
                break;
            case 8:
                V3SportsHomeActivity v3SportsHomeActivity8 = this.mBackEvent;
                if (v3SportsHomeActivity8 != null) {
                    v3SportsHomeActivity8.c2();
                    break;
                }
                break;
            case 9:
                V3SportsHomeActivity v3SportsHomeActivity9 = this.mBackEvent;
                if (v3SportsHomeActivity9 != null) {
                    v3SportsHomeActivity9.b2();
                    break;
                }
                break;
            case 10:
                V3SportsHomeActivity v3SportsHomeActivity10 = this.mBackEvent;
                if (v3SportsHomeActivity10 != null) {
                    v3SportsHomeActivity10.Z1();
                    break;
                }
                break;
            case 11:
                V3SportsHomeActivity v3SportsHomeActivity11 = this.mBackEvent;
                if (v3SportsHomeActivity11 != null) {
                    v3SportsHomeActivity11.Z1();
                    break;
                }
                break;
            case 12:
                V3SportsHomeActivity v3SportsHomeActivity12 = this.mBackEvent;
                if (v3SportsHomeActivity12 != null) {
                    v3SportsHomeActivity12.Y1();
                    break;
                }
                break;
            case 13:
                V3SportsHomeActivity v3SportsHomeActivity13 = this.mBackEvent;
                if (v3SportsHomeActivity13 != null) {
                    v3SportsHomeActivity13.a2();
                    break;
                }
                break;
            case 14:
                V3SportsHomeActivity v3SportsHomeActivity14 = this.mBackEvent;
                if (v3SportsHomeActivity14 != null) {
                    v3SportsHomeActivity14.a2();
                    break;
                }
                break;
        }
    }
}
