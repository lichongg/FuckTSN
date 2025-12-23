package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.1
        @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    };
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.2
        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i6) {
            return sparseArrayCompat.valueAt(i6);
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    };
    private final View mHost;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i6) {
            int i7 = i6 == 2 ? ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId : ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            if (i7 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i7);
        }

        MyNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i6) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i6));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i6, int i7, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i6, i7, bundle);
        }
    }

    private AccessibilityEvent createEvent(int i6, int i7) {
        return i6 != -1 ? createEventForChild(i6, i7) : createEventForHost(i7);
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private boolean performActionForChild(int i6, int i7, Bundle bundle) {
        return i7 != 1 ? i7 != 2 ? i7 != 64 ? i7 != 128 ? onPerformActionForVirtualView(i6, i7, bundle) : clearAccessibilityFocus(i6) : requestAccessibilityFocus(i6) : clearKeyboardFocusForVirtualView(i6) : requestKeyboardFocusForVirtualView(i6);
    }

    protected abstract int getVirtualViewAt(float f6, float f7);

    protected abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i6) {
        invalidateVirtualView(i6, 0);
    }

    @NonNull
    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i6) {
        return i6 == -1 ? createNodeForHost() : createNodeForChild(i6);
    }

    protected abstract boolean onPerformActionForVirtualView(int i6, int i7, @Nullable Bundle bundle);

    protected abstract void onPopulateNodeForVirtualView(int i6, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    boolean performAction(int i6, int i7, Bundle bundle) {
        return i6 != -1 ? performActionForChild(i6, i7, bundle) : performActionForHost(i7, bundle);
    }

    private boolean clearAccessibilityFocus(int i6) {
        if (this.mAccessibilityFocusedVirtualViewId != i6) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i6, 65536);
        return true;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i6 = this.mKeyboardFocusedVirtualViewId;
        return i6 != Integer.MIN_VALUE && onPerformActionForVirtualView(i6, 16, null);
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            obtain.addChild(this.mHost, ((Integer) arrayList.get(i6)).intValue());
        }
        return obtain;
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            sparseArrayCompat.put(arrayList.get(i6).intValue(), createNodeForChild(arrayList.get(i6).intValue()));
        }
        return sparseArrayCompat;
    }

    private static int keyToDirection(int i6) {
        if (i6 == 19) {
            return 33;
        }
        if (i6 == 21) {
            return 17;
        }
        if (i6 != 22) {
            return MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE;
        }
        return 66;
    }

    private boolean performActionForHost(int i6, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mHost, i6, bundle);
    }

    private boolean requestAccessibilityFocus(int i6) {
        int i7;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i7 = this.mAccessibilityFocusedVirtualViewId) == i6) {
            return false;
        }
        if (i7 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i7);
        }
        this.mAccessibilityFocusedVirtualViewId = i6;
        this.mHost.invalidate();
        sendEventForVirtualView(i6, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int i6) {
        int i7 = this.mHoveredVirtualViewId;
        if (i7 == i6) {
            return;
        }
        this.mHoveredVirtualViewId = i6;
        sendEventForVirtualView(i6, 128);
        sendEventForVirtualView(i7, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int i6) {
        if (this.mKeyboardFocusedVirtualViewId != i6) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i6, false);
        sendEventForVirtualView(i6, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7 && action != 9) {
                if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
                    return false;
                }
                updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
            }
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            updateHoveredVirtualView(virtualViewAt);
            if (virtualViewAt != Integer.MIN_VALUE) {
                return true;
            }
        }
        return false;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public final void invalidateVirtualView(int i6, int i7) {
        ViewParent parent;
        if (i6 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent createEvent = createEvent(i6, 2048);
        AccessibilityEventCompat.setContentChangeTypes(createEvent, i7);
        parent.requestSendAccessibilityEvent(this.mHost, createEvent);
    }

    public final void onFocusChanged(boolean z5, int i6, @Nullable Rect rect) {
        int i7 = this.mKeyboardFocusedVirtualViewId;
        if (i7 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i7);
        }
        if (z5) {
            moveFocus(i6, rect);
        }
    }

    public final boolean requestKeyboardFocusForVirtualView(int i6) {
        int i7;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i7 = this.mKeyboardFocusedVirtualViewId) == i6) {
            return false;
        }
        if (i7 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i7);
        }
        if (i6 == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i6;
        onVirtualViewKeyboardFocusChanged(i6, true);
        sendEventForVirtualView(i6, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i6, int i7) {
        ViewParent parent;
        if (i6 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i6, i7));
    }

    public ExploreByTouchHelper(@NonNull View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private AccessibilityEvent createEventForChild(int i6, int i7) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i7);
        AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i6);
        obtain.getText().add(obtainAccessibilityNodeInfo.getText());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
        obtain.setScrollable(obtainAccessibilityNodeInfo.isScrollable());
        obtain.setPassword(obtainAccessibilityNodeInfo.isPassword());
        obtain.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
        obtain.setChecked(obtainAccessibilityNodeInfo.isChecked());
        onPopulateEventForVirtualView(i6, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(obtainAccessibilityNodeInfo.getClassName());
        AccessibilityRecordCompat.setSource(obtain, this.mHost, i6);
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent createEventForHost(int i6) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i6);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int i6) {
        boolean z5;
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        obtain.setParent(this.mHost);
        onPopulateNodeForVirtualView(i6, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.mTempParentRect);
        if (!this.mTempParentRect.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) == 0) {
                if ((actions & 128) == 0) {
                    obtain.setPackageName(this.mHost.getContext().getPackageName());
                    obtain.setSource(this.mHost, i6);
                    if (this.mAccessibilityFocusedVirtualViewId == i6) {
                        obtain.setAccessibilityFocused(true);
                        obtain.addAction(128);
                    } else {
                        obtain.setAccessibilityFocused(false);
                        obtain.addAction(64);
                    }
                    if (this.mKeyboardFocusedVirtualViewId == i6) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        obtain.addAction(2);
                    } else if (obtain.isFocusable()) {
                        obtain.addAction(1);
                    }
                    obtain.setFocused(z5);
                    this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                    obtain.getBoundsInScreen(this.mTempScreenRect);
                    if (this.mTempScreenRect.equals(rect)) {
                        obtain.getBoundsInParent(this.mTempScreenRect);
                        if (obtain.mParentVirtualDescendantId != -1) {
                            AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                            for (int i7 = obtain.mParentVirtualDescendantId; i7 != -1; i7 = obtain2.mParentVirtualDescendantId) {
                                obtain2.setParent(this.mHost, -1);
                                obtain2.setBoundsInParent(INVALID_PARENT_BOUNDS);
                                onPopulateNodeForVirtualView(i7, obtain2);
                                obtain2.getBoundsInParent(this.mTempParentRect);
                                Rect rect2 = this.mTempScreenRect;
                                Rect rect3 = this.mTempParentRect;
                                rect2.offset(rect3.left, rect3.top);
                            }
                            obtain2.recycle();
                        }
                        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    }
                    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                        if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                            obtain.setBoundsInScreen(this.mTempScreenRect);
                            if (isVisibleToUser(this.mTempScreenRect)) {
                                obtain.setVisibleToUser(true);
                            }
                        }
                    }
                    return obtain;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    private void getBoundsInParent(int i6, Rect rect) {
        obtainAccessibilityNodeInfo(i6).getBoundsInParent(rect);
    }

    private static Rect guessPreviouslyFocusedRect(@NonNull View view, int i6, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i6 != 17) {
            if (i6 != 33) {
                if (i6 != 66) {
                    if (i6 == 130) {
                        rect.set(0, -1, width, -1);
                        return rect;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                rect.set(-1, 0, -1, height);
                return rect;
            }
            rect.set(0, height, width, height);
            return rect;
        }
        rect.set(width, 0, width, height);
        return rect;
    }

    private boolean moveFocus(int i6, @Nullable Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        boolean z5;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
        int i7 = this.mKeyboardFocusedVirtualViewId;
        int i8 = Integer.MIN_VALUE;
        if (i7 == Integer.MIN_VALUE) {
            accessibilityNodeInfoCompat = null;
        } else {
            accessibilityNodeInfoCompat = allNodes.get(i7);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat;
        if (i6 != 1 && i6 != 2) {
            if (i6 != 17 && i6 != 33 && i6 != 66 && i6 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i9 = this.mKeyboardFocusedVirtualViewId;
            if (i9 != Integer.MIN_VALUE) {
                getBoundsInParent(i9, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i6, rect2);
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, rect2, i6);
        } else {
            if (ViewCompat.getLayoutDirection(this.mHost) == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, i6, z5, false);
        }
        if (accessibilityNodeInfoCompat2 != null) {
            i8 = allNodes.keyAt(allNodes.indexOfValue(accessibilityNodeInfoCompat2));
        }
        return requestKeyboardFocusForVirtualView(i8);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        int i6 = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                int keyToDirection = keyToDirection(keyCode);
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z5 = false;
                                while (i6 < repeatCount && moveFocus(keyToDirection, null)) {
                                    i6++;
                                    z5 = true;
                                }
                                return z5;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    clickKeyboardFocusedVirtualView();
                    return true;
                }
            } else {
                if (keyEvent.hasNoModifiers()) {
                    return moveFocus(2, null);
                }
                if (keyEvent.hasModifiers(1)) {
                    return moveFocus(1, null);
                }
            }
        }
        return false;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    protected void onPopulateEventForHost(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected void onPopulateEventForVirtualView(int i6, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    protected void onVirtualViewKeyboardFocusChanged(int i6, boolean z5) {
    }
}
