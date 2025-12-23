package androidx.core.internal.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ActionProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public interface SupportMenuItem extends MenuItem {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    @Nullable
    View getActionView();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    @Nullable
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    @Nullable
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    @Nullable
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Nullable
    ActionProvider getSupportActionProvider();

    @Override // android.view.MenuItem
    @Nullable
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    boolean requiresActionButton();

    boolean requiresOverflow();

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setActionView(int i6);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setActionView(@Nullable View view);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setAlphabeticShortcut(char c6, int i6);

    @Override // android.view.MenuItem
    @NonNull
    /* bridge */ /* synthetic */ MenuItem setContentDescription(@Nullable CharSequence charSequence);

    @Override // android.view.MenuItem
    @NonNull
    SupportMenuItem setContentDescription(@Nullable CharSequence charSequence);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setIconTintList(@Nullable ColorStateList colorStateList);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setIconTintMode(@Nullable PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setNumericShortcut(char c6, int i6);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setShortcut(char c6, char c7, int i6, int i7);

    @Override // android.view.MenuItem
    void setShowAsAction(int i6);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setShowAsActionFlags(int i6);

    @NonNull
    SupportMenuItem setSupportActionProvider(@Nullable ActionProvider actionProvider);

    @Override // android.view.MenuItem
    @NonNull
    /* bridge */ /* synthetic */ MenuItem setTooltipText(@Nullable CharSequence charSequence);

    @Override // android.view.MenuItem
    @NonNull
    SupportMenuItem setTooltipText(@Nullable CharSequence charSequence);
}
