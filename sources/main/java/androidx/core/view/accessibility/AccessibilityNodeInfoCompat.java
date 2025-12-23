package androidx.core.view.accessibility;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_DIRECTION_INT = "androidx.core.view.accessibility.action.ARGUMENT_DIRECTION_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

    @SuppressLint({"ActionValue"})
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SCROLL_AMOUNT_FLOAT = "androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    private static final int BOOLEAN_PROPERTY_ACCESSIBILITY_DATA_SENSITIVE = 64;
    private static final int BOOLEAN_PROPERTY_HAS_REQUEST_INITIAL_ACCESSIBILITY_FOCUS = 32;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    private static final int BOOLEAN_PROPERTY_SUPPORTS_GRANULAR_SCROLLING = 67108864;
    private static final int BOOLEAN_PROPERTY_TEXT_SELECTABLE = 8388608;
    private static final String BOUNDS_IN_WINDOW_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY";
    private static final String CONTAINER_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FLAG_PREFETCH_ANCESTORS = 1;
    public static final int FLAG_PREFETCH_DESCENDANTS_BREADTH_FIRST = 16;
    public static final int FLAG_PREFETCH_DESCENDANTS_DEPTH_FIRST = 8;
    public static final int FLAG_PREFETCH_DESCENDANTS_HYBRID = 4;
    public static final int FLAG_PREFETCH_SIBLINGS = 2;
    public static final int FLAG_PREFETCH_UNINTERRUPTIBLE = 32;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";

    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_NUMBER_OF_PREFETCHED_NODES = 50;
    private static final String MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static final String UNIQUE_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";
    private static int sClickableSpanId;
    private final AccessibilityNodeInfo mInfo;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mParentVirtualDescendantId = -1;
    private int mVirtualDescendantId = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_CANCEL;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_DROP;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_START;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;

        @NonNull
        public static final AccessibilityActionCompat ACTION_IME_ENTER;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_UP;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;

        @NonNull
        @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
        public static final AccessibilityActionCompat ACTION_SCROLL_IN_DIRECTION;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;

        @NonNull
        public static final AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected final AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;
        public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
        public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
        public static final AccessibilityActionCompat ACTION_CLICK = new AccessibilityActionCompat(16, null);
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
        public static final AccessibilityActionCompat ACTION_COPY = new AccessibilityActionCompat(16384, null);
        public static final AccessibilityActionCompat ACTION_PASTE = new AccessibilityActionCompat(32768, null);
        public static final AccessibilityActionCompat ACTION_CUT = new AccessibilityActionCompat(65536, null);
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetSelectionArguments.class);
        public static final AccessibilityActionCompat ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
        public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
        public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
        public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetTextArguments.class);

        public AccessibilityActionCompat(int i6, CharSequence charSequence) {
            this(null, i6, charSequence, null, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
            Object obj2 = this.mAction;
            return obj2 == null ? accessibilityActionCompat.mAction == null : obj2.equals(accessibilityActionCompat.mAction);
        }

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction22;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction23;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction24;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction25;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction26;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction27;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction28;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction29;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction30;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction31;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction32;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction33;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction34;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction35;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction36;
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 23) {
                accessibilityAction36 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
                accessibilityAction = accessibilityAction36;
            } else {
                accessibilityAction = null;
            }
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(accessibilityAction, R.id.accessibilityActionShowOnScreen, null, null, null);
            if (i6 >= 23) {
                accessibilityAction35 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
                accessibilityAction2 = accessibilityAction35;
            } else {
                accessibilityAction2 = null;
            }
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(accessibilityAction2, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            if (i6 >= 23) {
                accessibilityAction34 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
                accessibilityAction3 = accessibilityAction34;
            } else {
                accessibilityAction3 = null;
            }
            ACTION_SCROLL_UP = new AccessibilityActionCompat(accessibilityAction3, R.id.accessibilityActionScrollUp, null, null, null);
            if (i6 >= 23) {
                accessibilityAction33 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
                accessibilityAction4 = accessibilityAction33;
            } else {
                accessibilityAction4 = null;
            }
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(accessibilityAction4, R.id.accessibilityActionScrollLeft, null, null, null);
            if (i6 >= 23) {
                accessibilityAction32 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
                accessibilityAction5 = accessibilityAction32;
            } else {
                accessibilityAction5 = null;
            }
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(accessibilityAction5, R.id.accessibilityActionScrollDown, null, null, null);
            if (i6 >= 23) {
                accessibilityAction31 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
                accessibilityAction6 = accessibilityAction31;
            } else {
                accessibilityAction6 = null;
            }
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(accessibilityAction6, R.id.accessibilityActionScrollRight, null, null, null);
            ACTION_PAGE_UP = new AccessibilityActionCompat(i6 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            if (i6 >= 29) {
                accessibilityAction30 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
                accessibilityAction7 = accessibilityAction30;
            } else {
                accessibilityAction7 = null;
            }
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(accessibilityAction7, R.id.accessibilityActionPageDown, null, null, null);
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(i6 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            if (i6 >= 29) {
                accessibilityAction29 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
                accessibilityAction8 = accessibilityAction29;
            } else {
                accessibilityAction8 = null;
            }
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(accessibilityAction8, R.id.accessibilityActionPageRight, null, null, null);
            if (i6 >= 23) {
                accessibilityAction28 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
                accessibilityAction9 = accessibilityAction28;
            } else {
                accessibilityAction9 = null;
            }
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(accessibilityAction9, R.id.accessibilityActionContextClick, null, null, null);
            if (i6 >= 24) {
                accessibilityAction27 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
                accessibilityAction10 = accessibilityAction27;
            } else {
                accessibilityAction10 = null;
            }
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(accessibilityAction10, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            if (i6 >= 26) {
                accessibilityAction26 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
                accessibilityAction11 = accessibilityAction26;
            } else {
                accessibilityAction11 = null;
            }
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(accessibilityAction11, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (i6 >= 28) {
                accessibilityAction25 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
                accessibilityAction12 = accessibilityAction25;
            } else {
                accessibilityAction12 = null;
            }
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(accessibilityAction12, R.id.accessibilityActionShowTooltip, null, null, null);
            if (i6 >= 28) {
                accessibilityAction24 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
                accessibilityAction13 = accessibilityAction24;
            } else {
                accessibilityAction13 = null;
            }
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(accessibilityAction13, R.id.accessibilityActionHideTooltip, null, null, null);
            if (i6 >= 30) {
                accessibilityAction23 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
                accessibilityAction14 = accessibilityAction23;
            } else {
                accessibilityAction14 = null;
            }
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(accessibilityAction14, R.id.accessibilityActionPressAndHold, null, null, null);
            if (i6 >= 30) {
                accessibilityAction22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
                accessibilityAction15 = accessibilityAction22;
            } else {
                accessibilityAction15 = null;
            }
            ACTION_IME_ENTER = new AccessibilityActionCompat(accessibilityAction15, R.id.accessibilityActionImeEnter, null, null, null);
            ACTION_DRAG_START = new AccessibilityActionCompat(i6 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            if (i6 >= 32) {
                accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
                accessibilityAction16 = accessibilityAction21;
            } else {
                accessibilityAction16 = null;
            }
            ACTION_DRAG_DROP = new AccessibilityActionCompat(accessibilityAction16, R.id.accessibilityActionDragDrop, null, null, null);
            if (i6 >= 32) {
                accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
                accessibilityAction17 = accessibilityAction20;
            } else {
                accessibilityAction17 = null;
            }
            ACTION_DRAG_CANCEL = new AccessibilityActionCompat(accessibilityAction17, R.id.accessibilityActionDragCancel, null, null, null);
            if (i6 >= 33) {
                accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
                accessibilityAction18 = accessibilityAction19;
            } else {
                accessibilityAction18 = null;
            }
            ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(accessibilityAction18, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            ACTION_SCROLL_IN_DIRECTION = new AccessibilityActionCompat(i6 >= 34 ? Api34Impl.getActionScrollInDirection() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int i6, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this(null, i6, charSequence, accessibilityViewCommand, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat(null, this.mId, charSequence, accessibilityViewCommand, this.mViewCommandArgumentClass);
        }

        public int getId() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
        }

        public CharSequence getLabel() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getLabel();
        }

        public int hashCode() {
            Object obj = this.mAction;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean perform(View view, Bundle bundle) {
            if (this.mCommand == null) {
                return false;
            }
            Class<? extends AccessibilityViewCommand.CommandArguments> cls = this.mViewCommandArgumentClass;
            AccessibilityViewCommand.CommandArguments commandArguments = null;
            if (cls != null) {
                try {
                    AccessibilityViewCommand.CommandArguments newInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    try {
                        newInstance.setBundle(bundle);
                        commandArguments = newInstance;
                    } catch (Exception unused) {
                        commandArguments = newInstance;
                        Class<? extends AccessibilityViewCommand.CommandArguments> cls2 = this.mViewCommandArgumentClass;
                        if (cls2 != null) {
                            cls2.getName();
                        }
                        return this.mCommand.perform(view, commandArguments);
                    }
                } catch (Exception unused2) {
                }
            }
            return this.mCommand.perform(view, commandArguments);
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String actionSymbolicName = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
            if (actionSymbolicName.equals("ACTION_UNKNOWN") && getLabel() != null) {
                actionSymbolicName = getLabel().toString();
            }
            sb.append(actionSymbolicName);
            return sb.toString();
        }

        AccessibilityActionCompat(Object obj) {
            this(obj, 0, null, null, null);
        }

        private AccessibilityActionCompat(int i6, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this(null, i6, charSequence, null, cls);
        }

        AccessibilityActionCompat(Object obj, int i6, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this.mId = i6;
            this.mCommand = accessibilityViewCommand;
            if (obj == null) {
                this.mAction = new AccessibilityNodeInfo.AccessibilityAction(i6, charSequence);
            } else {
                this.mAction = obj;
            }
            this.mViewCommandArgumentClass = cls;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    private static class Api21Impl {
        @DoNotInline
        public static CollectionItemInfoCompat createCollectionItemInfo(int i6, int i7, int i8, int i9, boolean z5, boolean z6) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i6, i7, i8, i9, z5, z6));
        }

        private Api21Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(30)
    private static class Api30Impl {
        @DoNotInline
        public static Object createRangeInfo(int i6, float f6, float f7, float f8) {
            return new AccessibilityNodeInfo.RangeInfo(i6, f6, f7, f8);
        }

        private Api30Impl() {
        }

        @DoNotInline
        public static CharSequence getStateDescription(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        @DoNotInline
        public static void setStateDescription(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(33)
    private static class Api33Impl {
        @DoNotInline
        public static CollectionItemInfoCompat buildCollectionItemInfoCompat(boolean z5, int i6, int i7, int i8, int i9, boolean z6, String str, String str2) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z5).setColumnIndex(i6).setRowIndex(i7).setColumnSpan(i8).setRowSpan(i9).setSelected(z6).setRowTitle(str).setColumnTitle(str2).build());
        }

        @DoNotInline
        public static String getCollectionItemColumnTitle(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        @DoNotInline
        public static String getCollectionItemRowTitle(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        private Api33Impl() {
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat getChild(AccessibilityNodeInfo accessibilityNodeInfo, int i6, int i7) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(accessibilityNodeInfo.getChild(i6, i7));
        }

        @DoNotInline
        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat getParent(AccessibilityNodeInfo accessibilityNodeInfo, int i6) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(accessibilityNodeInfo.getParent(i6));
        }

        @DoNotInline
        public static String getUniqueId(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        @DoNotInline
        public static boolean isTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        @DoNotInline
        public static void setTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo, boolean z5) {
            accessibilityNodeInfo.setTextSelectable(z5);
        }

        @DoNotInline
        public static void setUniqueId(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(34)
    private static class Api34Impl {
        @DoNotInline
        public static AccessibilityNodeInfo.AccessibilityAction getActionScrollInDirection() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        private Api34Impl() {
        }

        @DoNotInline
        public static void getBoundsInWindow(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        @DoNotInline
        public static CharSequence getContainerTitle(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        @DoNotInline
        public static long getMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        @DoNotInline
        public static boolean hasRequestInitialAccessibilityFocus(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        @DoNotInline
        public static boolean isAccessibilityDataSensitive(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        @DoNotInline
        public static void setAccessibilityDataSensitive(AccessibilityNodeInfo accessibilityNodeInfo, boolean z5) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z5);
        }

        @DoNotInline
        public static void setBoundsInWindow(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        @DoNotInline
        public static void setContainerTitle(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        @DoNotInline
        public static void setMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo accessibilityNodeInfo, long j6) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j6));
        }

        @DoNotInline
        public static void setQueryFromAppProcessEnabled(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z5) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z5);
        }

        @DoNotInline
        public static void setRequestInitialAccessibilityFocus(AccessibilityNodeInfo accessibilityNodeInfo, boolean z5) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        public static CollectionInfoCompat obtain(int i6, int i7, boolean z5, int i8) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i6, i7, z5, i8));
        }

        public static CollectionInfoCompat obtain(int i6, int i7, boolean z5) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i6, i7, z5));
        }

        public int getColumnCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getColumnCount();
        }

        public int getRowCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getRowCount();
        }

        public int getSelectionMode() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getSelectionMode();
        }

        public boolean isHierarchical() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).isHierarchical();
        }

        CollectionInfoCompat(Object obj) {
            this.mInfo = obj;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CollectionItemInfoCompat {
        final Object mInfo;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Builder {
            private int mColumnIndex;
            private int mColumnSpan;
            private String mColumnTitle;
            private boolean mHeading;
            private int mRowIndex;
            private int mRowSpan;
            private String mRowTitle;
            private boolean mSelected;

            @NonNull
            public CollectionItemInfoCompat build() {
                return Build.VERSION.SDK_INT >= 33 ? Api33Impl.buildCollectionItemInfoCompat(this.mHeading, this.mColumnIndex, this.mRowIndex, this.mColumnSpan, this.mRowSpan, this.mSelected, this.mRowTitle, this.mColumnTitle) : Api21Impl.createCollectionItemInfo(this.mRowIndex, this.mRowSpan, this.mColumnIndex, this.mColumnSpan, this.mHeading, this.mSelected);
            }

            @NonNull
            public Builder setColumnIndex(int i6) {
                this.mColumnIndex = i6;
                return this;
            }

            @NonNull
            public Builder setColumnSpan(int i6) {
                this.mColumnSpan = i6;
                return this;
            }

            @NonNull
            public Builder setColumnTitle(@Nullable String str) {
                this.mColumnTitle = str;
                return this;
            }

            @NonNull
            public Builder setHeading(boolean z5) {
                this.mHeading = z5;
                return this;
            }

            @NonNull
            public Builder setRowIndex(int i6) {
                this.mRowIndex = i6;
                return this;
            }

            @NonNull
            public Builder setRowSpan(int i6) {
                this.mRowSpan = i6;
                return this;
            }

            @NonNull
            public Builder setRowTitle(@Nullable String str) {
                this.mRowTitle = str;
                return this;
            }

            @NonNull
            public Builder setSelected(boolean z5) {
                this.mSelected = z5;
                return this;
            }
        }

        public static CollectionItemInfoCompat obtain(int i6, int i7, int i8, int i9, boolean z5, boolean z6) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i6, i7, i8, i9, z5, z6));
        }

        public static CollectionItemInfoCompat obtain(int i6, int i7, int i8, int i9, boolean z5) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i6, i7, i8, i9, z5));
        }

        public int getColumnIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnIndex();
        }

        public int getColumnSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnSpan();
        }

        @Nullable
        public String getColumnTitle() {
            if (Build.VERSION.SDK_INT >= 33) {
                return Api33Impl.getCollectionItemColumnTitle(this.mInfo);
            }
            return null;
        }

        public int getRowIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowIndex();
        }

        public int getRowSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowSpan();
        }

        @Nullable
        public String getRowTitle() {
            if (Build.VERSION.SDK_INT >= 33) {
                return Api33Impl.getCollectionItemRowTitle(this.mInfo);
            }
            return null;
        }

        @Deprecated
        public boolean isHeading() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isHeading();
        }

        public boolean isSelected() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isSelected();
        }

        CollectionItemInfoCompat(Object obj) {
            this.mInfo = obj;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        RangeInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        public static RangeInfoCompat obtain(int i6, float f6, float f7, float f8) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i6, f6, f7, f8));
        }

        public float getCurrent() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getCurrent();
        }

        public float getMax() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMax();
        }

        public float getMin() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMin();
        }

        public int getType() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getType();
        }

        public RangeInfoCompat(int i6, float f6, float f7, float f8) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.mInfo = Api30Impl.createRangeInfo(i6, f6, f7, f8);
            } else {
                this.mInfo = AccessibilityNodeInfo.RangeInfo.obtain(i6, f6, f7, f8);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> map) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mInfo = c1.a(map);
            } else {
                this.mInfo = null;
            }
        }

        @Nullable
        public Region getRegionAt(@IntRange(from = 0) int i6) {
            Region regionAt;
            if (Build.VERSION.SDK_INT < 29) {
                return null;
            }
            regionAt = this.mInfo.getRegionAt(i6);
            return regionAt;
        }

        @IntRange(from = 0)
        public int getRegionCount() {
            int regionCount;
            if (Build.VERSION.SDK_INT < 29) {
                return 0;
            }
            regionCount = this.mInfo.getRegionCount();
            return regionCount;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
        
            r3 = r2.mInfo.getTargetForRegion(r3);
         */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getTargetForRegion(@androidx.annotation.NonNull android.graphics.Region r3) {
            /*
                r2 = this;
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 29
                if (r0 < r1) goto L13
                android.view.accessibility.AccessibilityNodeInfo$TouchDelegateInfo r0 = r2.mInfo
                android.view.accessibility.AccessibilityNodeInfo r3 = androidx.core.view.accessibility.z0.a(r0, r3)
                if (r3 == 0) goto L13
                androidx.core.view.accessibility.AccessibilityNodeInfoCompat r3 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(r3)
                return r3
            L13:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.accessibility.AccessibilityNodeInfoCompat.TouchDelegateInfoCompat.getTargetForRegion(android.graphics.Region):androidx.core.view.accessibility.AccessibilityNodeInfoCompat");
        }

        TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.mInfo = touchDelegateInfo;
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object obj) {
        this.mInfo = (AccessibilityNodeInfo) obj;
    }

    static String getActionSymbolicName(int i6) {
        if (i6 == 1) {
            return "ACTION_FOCUS";
        }
        if (i6 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i6) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i6) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i6) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i6) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return wrap(AccessibilityNodeInfo.obtain(view));
    }

    public void addAction(int i6) {
        this.mInfo.addAction(i6);
    }

    public void addChild(View view) {
        this.mInfo.addChild(view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.mInfo)) {
            return false;
        }
        return this.mVirtualDescendantId == accessibilityNodeInfoCompat.mVirtualDescendantId && this.mParentVirtualDescendantId == accessibilityNodeInfoCompat.mParentVirtualDescendantId;
    }

    public AccessibilityNodeInfoCompat getChild(int i6) {
        return wrapNonNullInstance(this.mInfo.getChild(i6));
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public boolean performAction(int i6) {
        return this.mInfo.performAction(i6);
    }

    public boolean removeChild(View view) {
        return this.mInfo.removeChild(view);
    }

    public void setLabelFor(View view) {
        this.mInfo.setLabelFor(view);
    }

    public void setLabeledBy(View view) {
        this.mInfo.setLabeledBy(view);
    }

    public void setParent(View view) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(view);
    }

    public void setSource(View view) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(view);
    }

    public void setTraversalAfter(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.mInfo.setTraversalAfter(view);
        }
    }

    public void setTraversalBefore(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.mInfo.setTraversalBefore(view);
        }
    }

    private void addSpanLocationToExtras(ClickableSpan clickableSpan, Spanned spanned, int i6) {
        extrasIntList(SPANS_START_KEY).add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        extrasIntList(SPANS_END_KEY).add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        extrasIntList(SPANS_FLAGS_KEY).add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        extrasIntList(SPANS_ID_KEY).add(Integer.valueOf(i6));
    }

    private void clearExtrasSpans() {
        this.mInfo.getExtras().remove(SPANS_START_KEY);
        this.mInfo.getExtras().remove(SPANS_END_KEY);
        this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
        this.mInfo.getExtras().remove(SPANS_ID_KEY);
    }

    private List<Integer> extrasIntList(String str) {
        ArrayList<Integer> integerArrayList = this.mInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.mInfo.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] getClickableSpans(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View view) {
        return (SparseArray) view.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
    }

    private boolean hasSpans() {
        return !extrasIntList(SPANS_START_KEY).isEmpty();
    }

    private int idForClickableSpan(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                if (clickableSpan.equals(sparseArray.valueAt(i6).get())) {
                    return sparseArray.keyAt(i6);
                }
            }
        }
        int i7 = sClickableSpanId;
        sClickableSpanId = i7 + 1;
        return i7;
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i6) {
        return wrapNonNullInstance(AccessibilityNodeInfo.obtain(view, i6));
    }

    public static AccessibilityNodeInfoCompat wrap(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    static AccessibilityNodeInfoCompat wrapNonNullInstance(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    public void addChild(View view, int i6) {
        this.mInfo.addChild(view, i6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            clearExtrasSpans();
            removeCollectedSpans(view);
            ClickableSpan[] clickableSpans = getClickableSpans(charSequence);
            if (clickableSpans == null || clickableSpans.length <= 0) {
                return;
            }
            getExtras().putInt(SPANS_ACTION_ID_KEY, androidx.core.R.id.accessibility_action_clickable_span);
            SparseArray<WeakReference<ClickableSpan>> orCreateSpansFromViewTags = getOrCreateSpansFromViewTags(view);
            for (int i6 = 0; i6 < clickableSpans.length; i6++) {
                int idForClickableSpan = idForClickableSpan(clickableSpans[i6], orCreateSpansFromViewTags);
                orCreateSpansFromViewTags.put(idForClickableSpan, new WeakReference<>(clickableSpans[i6]));
                addSpanLocationToExtras(clickableSpans[i6], (Spanned) charSequence, idForClickableSpan);
            }
        }
    }

    public boolean canOpenPopup() {
        return this.mInfo.canOpenPopup();
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList = new ArrayList();
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = this.mInfo.findAccessibilityNodeInfosByText(str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.add(wrap(findAccessibilityNodeInfosByText.get(i6)));
        }
        return arrayList;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = this.mInfo.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        Iterator<AccessibilityNodeInfo> it = findAccessibilityNodeInfosByViewId.iterator();
        while (it.hasNext()) {
            arrayList.add(wrap(it.next()));
        }
        return arrayList;
    }

    public AccessibilityNodeInfoCompat findFocus(int i6) {
        return wrapNonNullInstance(this.mInfo.findFocus(i6));
    }

    public AccessibilityNodeInfoCompat focusSearch(int i6) {
        return wrapNonNullInstance(this.mInfo.focusSearch(i6));
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.mInfo.getActionList();
        if (actionList == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i6)));
        }
        return arrayList;
    }

    @Deprecated
    public int getActions() {
        return this.mInfo.getActions();
    }

    @NonNull
    public List<String> getAvailableExtraData() {
        List<String> availableExtraData;
        if (Build.VERSION.SDK_INT < 26) {
            return Collections.EMPTY_LIST;
        }
        availableExtraData = this.mInfo.getAvailableExtraData();
        return availableExtraData;
    }

    @Deprecated
    public void getBoundsInParent(Rect rect) {
        this.mInfo.getBoundsInParent(rect);
    }

    public void getBoundsInScreen(Rect rect) {
        this.mInfo.getBoundsInScreen(rect);
    }

    public void getBoundsInWindow(@NonNull Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.getBoundsInWindow(this.mInfo, rect);
            return;
        }
        Rect rect2 = (Rect) this.mInfo.getExtras().getParcelable(BOUNDS_IN_WINDOW_KEY);
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    @Nullable
    public AccessibilityNodeInfoCompat getChild(int i6, int i7) {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.getChild(this.mInfo, i6, i7) : getChild(i6);
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo = this.mInfo.getCollectionInfo();
        if (collectionInfo != null) {
            return new CollectionInfoCompat(collectionInfo);
        }
        return null;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.mInfo.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new CollectionItemInfoCompat(collectionItemInfo);
        }
        return null;
    }

    @Nullable
    public CharSequence getContainerTitle() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.getContainerTitle(this.mInfo) : this.mInfo.getExtras().getCharSequence(CONTAINER_TITLE_KEY);
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        int drawingOrder;
        if (Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        drawingOrder = this.mInfo.getDrawingOrder();
        return drawingOrder;
    }

    public CharSequence getError() {
        return this.mInfo.getError();
    }

    @Nullable
    public AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getExtraRenderingInfo(this.mInfo);
        }
        return null;
    }

    public Bundle getExtras() {
        return this.mInfo.getExtras();
    }

    @Nullable
    public CharSequence getHintText() {
        CharSequence hintText;
        if (Build.VERSION.SDK_INT < 26) {
            return this.mInfo.getExtras().getCharSequence(HINT_TEXT_KEY);
        }
        hintText = this.mInfo.getHintText();
        return hintText;
    }

    @Deprecated
    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return this.mInfo.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    public long getMinDurationBetweenContentChangesMillis() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.getMinDurationBetweenContentChangeMillis(this.mInfo) : this.mInfo.getExtras().getLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY);
    }

    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    @Nullable
    public CharSequence getPaneTitle() {
        CharSequence paneTitle;
        if (Build.VERSION.SDK_INT < 28) {
            return this.mInfo.getExtras().getCharSequence(PANE_TITLE_KEY);
        }
        paneTitle = this.mInfo.getPaneTitle();
        return paneTitle;
    }

    @Nullable
    public AccessibilityNodeInfoCompat getParent(int i6) {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.getParent(this.mInfo, i6) : getParent();
    }

    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo rangeInfo = this.mInfo.getRangeInfo();
        if (rangeInfo != null) {
            return new RangeInfoCompat(rangeInfo);
        }
        return null;
    }

    @Nullable
    public CharSequence getRoleDescription() {
        return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    @Nullable
    public CharSequence getStateDescription() {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.getStateDescription(this.mInfo) : this.mInfo.getExtras().getCharSequence(STATE_DESCRIPTION_KEY);
    }

    public int getTextSelectionEnd() {
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    @Nullable
    public CharSequence getTooltipText() {
        CharSequence tooltipText;
        if (Build.VERSION.SDK_INT < 28) {
            return this.mInfo.getExtras().getCharSequence(TOOLTIP_TEXT_KEY);
        }
        tooltipText = this.mInfo.getTooltipText();
        return tooltipText;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r2.mInfo.getTouchDelegateInfo();
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.TouchDelegateInfoCompat getTouchDelegateInfo() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L14
            android.view.accessibility.AccessibilityNodeInfo r0 = r2.mInfo
            android.view.accessibility.AccessibilityNodeInfo$TouchDelegateInfo r0 = androidx.core.view.accessibility.a0.a(r0)
            if (r0 == 0) goto L14
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$TouchDelegateInfoCompat r1 = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat$TouchDelegateInfoCompat
            r1.<init>(r0)
            return r1
        L14:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.accessibility.AccessibilityNodeInfoCompat.getTouchDelegateInfo():androidx.core.view.accessibility.AccessibilityNodeInfoCompat$TouchDelegateInfoCompat");
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        AccessibilityNodeInfo traversalAfter;
        if (Build.VERSION.SDK_INT < 22) {
            return null;
        }
        traversalAfter = this.mInfo.getTraversalAfter();
        return wrapNonNullInstance(traversalAfter);
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        AccessibilityNodeInfo traversalBefore;
        if (Build.VERSION.SDK_INT < 22) {
            return null;
        }
        traversalBefore = this.mInfo.getTraversalBefore();
        return wrapNonNullInstance(traversalBefore);
    }

    @Nullable
    public String getUniqueId() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.getUniqueId(this.mInfo) : this.mInfo.getExtras().getString(UNIQUE_ID_KEY);
    }

    public String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean hasRequestInitialAccessibilityFocus() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.hasRequestInitialAccessibilityFocus(this.mInfo) : getBooleanProperty(32);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean isAccessibilityDataSensitive() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.isAccessibilityDataSensitive(this.mInfo) : getBooleanProperty(64);
    }

    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        boolean isContextClickable;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        isContextClickable = this.mInfo.isContextClickable();
        return isContextClickable;
    }

    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
        return this.mInfo.isEditable();
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isGranularScrollingSupported() {
        return getBooleanProperty(67108864);
    }

    public boolean isHeading() {
        boolean isHeading;
        if (Build.VERSION.SDK_INT >= 28) {
            isHeading = this.mInfo.isHeading();
            return isHeading;
        }
        if (getBooleanProperty(2)) {
            return true;
        }
        CollectionItemInfoCompat collectionItemInfo = getCollectionItemInfo();
        return collectionItemInfo != null && collectionItemInfo.isHeading();
    }

    public boolean isImportantForAccessibility() {
        boolean isImportantForAccessibility;
        if (Build.VERSION.SDK_INT < 24) {
            return true;
        }
        isImportantForAccessibility = this.mInfo.isImportantForAccessibility();
        return isImportantForAccessibility;
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        boolean isScreenReaderFocusable;
        if (Build.VERSION.SDK_INT < 28) {
            return getBooleanProperty(1);
        }
        isScreenReaderFocusable = this.mInfo.isScreenReaderFocusable();
        return isScreenReaderFocusable;
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        boolean isShowingHintText;
        if (Build.VERSION.SDK_INT < 26) {
            return getBooleanProperty(4);
        }
        isShowingHintText = this.mInfo.isShowingHintText();
        return isShowingHintText;
    }

    public boolean isTextEntryKey() {
        boolean isTextEntryKey;
        if (Build.VERSION.SDK_INT < 29) {
            return getBooleanProperty(8);
        }
        isTextEntryKey = this.mInfo.isTextEntryKey();
        return isTextEntryKey;
    }

    public boolean isTextSelectable() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.isTextSelectable(this.mInfo) : getBooleanProperty(8388608);
    }

    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int i6, Bundle bundle) {
        return this.mInfo.performAction(i6, bundle);
    }

    public boolean refresh() {
        return this.mInfo.refresh();
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    public boolean removeChild(View view, int i6) {
        return this.mInfo.removeChild(view, i6);
    }

    public void setAccessibilityDataSensitive(boolean z5) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setAccessibilityDataSensitive(this.mInfo, z5);
        } else {
            setBooleanProperty(64, z5);
        }
    }

    public void setAccessibilityFocused(boolean z5) {
        this.mInfo.setAccessibilityFocused(z5);
    }

    public void setAvailableExtraData(@NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setAvailableExtraData(list);
        }
    }

    @Deprecated
    public void setBoundsInParent(Rect rect) {
        this.mInfo.setBoundsInParent(rect);
    }

    public void setBoundsInScreen(Rect rect) {
        this.mInfo.setBoundsInScreen(rect);
    }

    public void setBoundsInWindow(@NonNull Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setBoundsInWindow(this.mInfo, rect);
        } else {
            this.mInfo.getExtras().putParcelable(BOUNDS_IN_WINDOW_KEY, rect);
        }
    }

    public void setCanOpenPopup(boolean z5) {
        this.mInfo.setCanOpenPopup(z5);
    }

    public void setCheckable(boolean z5) {
        this.mInfo.setCheckable(z5);
    }

    public void setChecked(boolean z5) {
        this.mInfo.setChecked(z5);
    }

    public void setClassName(CharSequence charSequence) {
        this.mInfo.setClassName(charSequence);
    }

    public void setClickable(boolean z5) {
        this.mInfo.setClickable(z5);
    }

    public void setCollectionInfo(Object obj) {
        this.mInfo.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).mInfo);
    }

    public void setCollectionItemInfo(Object obj) {
        this.mInfo.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).mInfo);
    }

    public void setContainerTitle(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setContainerTitle(this.mInfo, charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(CONTAINER_TITLE_KEY, charSequence);
        }
    }

    public void setContentDescription(CharSequence charSequence) {
        this.mInfo.setContentDescription(charSequence);
    }

    public void setContentInvalid(boolean z5) {
        this.mInfo.setContentInvalid(z5);
    }

    public void setContextClickable(boolean z5) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.mInfo.setContextClickable(z5);
        }
    }

    public void setDismissable(boolean z5) {
        this.mInfo.setDismissable(z5);
    }

    public void setDrawingOrder(int i6) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mInfo.setDrawingOrder(i6);
        }
    }

    public void setEditable(boolean z5) {
        this.mInfo.setEditable(z5);
    }

    public void setEnabled(boolean z5) {
        this.mInfo.setEnabled(z5);
    }

    public void setError(CharSequence charSequence) {
        this.mInfo.setError(charSequence);
    }

    public void setFocusable(boolean z5) {
        this.mInfo.setFocusable(z5);
    }

    public void setFocused(boolean z5) {
        this.mInfo.setFocused(z5);
    }

    public void setGranularScrollingSupported(boolean z5) {
        setBooleanProperty(67108864, z5);
    }

    public void setHeading(boolean z5) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setHeading(z5);
        } else {
            setBooleanProperty(2, z5);
        }
    }

    public void setHintText(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setHintText(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(HINT_TEXT_KEY, charSequence);
        }
    }

    public void setImportantForAccessibility(boolean z5) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mInfo.setImportantForAccessibility(z5);
        }
    }

    public void setInputType(int i6) {
        this.mInfo.setInputType(i6);
    }

    public void setLabelFor(View view, int i6) {
        this.mInfo.setLabelFor(view, i6);
    }

    public void setLabeledBy(View view, int i6) {
        this.mInfo.setLabeledBy(view, i6);
    }

    public void setLiveRegion(int i6) {
        this.mInfo.setLiveRegion(i6);
    }

    public void setLongClickable(boolean z5) {
        this.mInfo.setLongClickable(z5);
    }

    public void setMaxTextLength(int i6) {
        this.mInfo.setMaxTextLength(i6);
    }

    public void setMinDurationBetweenContentChangesMillis(long j6) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setMinDurationBetweenContentChangeMillis(this.mInfo, j6);
        } else {
            this.mInfo.getExtras().putLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY, j6);
        }
    }

    public void setMovementGranularities(int i6) {
        this.mInfo.setMovementGranularities(i6);
    }

    public void setMultiLine(boolean z5) {
        this.mInfo.setMultiLine(z5);
    }

    public void setPackageName(CharSequence charSequence) {
        this.mInfo.setPackageName(charSequence);
    }

    public void setPaneTitle(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setPaneTitle(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(PANE_TITLE_KEY, charSequence);
        }
    }

    public void setPassword(boolean z5) {
        this.mInfo.setPassword(z5);
    }

    public void setQueryFromAppProcessEnabled(@NonNull View view, boolean z5) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setQueryFromAppProcessEnabled(this.mInfo, view, z5);
        }
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.mInfo);
    }

    @SuppressLint({"GetterSetterNames"})
    public void setRequestInitialAccessibilityFocus(boolean z5) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setRequestInitialAccessibilityFocus(this.mInfo, z5);
        } else {
            setBooleanProperty(32, z5);
        }
    }

    public void setRoleDescription(@Nullable CharSequence charSequence) {
        this.mInfo.getExtras().putCharSequence(ROLE_DESCRIPTION_KEY, charSequence);
    }

    public void setScreenReaderFocusable(boolean z5) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setScreenReaderFocusable(z5);
        } else {
            setBooleanProperty(1, z5);
        }
    }

    public void setScrollable(boolean z5) {
        this.mInfo.setScrollable(z5);
    }

    public void setSelected(boolean z5) {
        this.mInfo.setSelected(z5);
    }

    public void setShowingHintText(boolean z5) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setShowingHintText(z5);
        } else {
            setBooleanProperty(4, z5);
        }
    }

    public void setStateDescription(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setStateDescription(this.mInfo, charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(STATE_DESCRIPTION_KEY, charSequence);
        }
    }

    public void setText(CharSequence charSequence) {
        this.mInfo.setText(charSequence);
    }

    public void setTextEntryKey(boolean z5) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTextEntryKey(z5);
        } else {
            setBooleanProperty(8, z5);
        }
    }

    public void setTextSelectable(boolean z5) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.setTextSelectable(this.mInfo, z5);
        } else {
            setBooleanProperty(8388608, z5);
        }
    }

    public void setTextSelection(int i6, int i7) {
        this.mInfo.setTextSelection(i6, i7);
    }

    public void setTooltipText(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setTooltipText(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(TOOLTIP_TEXT_KEY, charSequence);
        }
    }

    public void setTouchDelegateInfo(@NonNull TouchDelegateInfoCompat touchDelegateInfoCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTouchDelegateInfo(touchDelegateInfoCompat.mInfo);
        }
    }

    public void setUniqueId(@Nullable String str) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.setUniqueId(this.mInfo, str);
        } else {
            this.mInfo.getExtras().putString(UNIQUE_ID_KEY, str);
        }
    }

    public void setViewIdResourceName(String str) {
        this.mInfo.setViewIdResourceName(str);
    }

    public void setVisibleToUser(boolean z5) {
        this.mInfo.setVisibleToUser(z5);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        getBoundsInWindow(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(getPackageName());
        sb.append("; className: ");
        sb.append(getClassName());
        sb.append("; text: ");
        sb.append(getText());
        sb.append("; error: ");
        sb.append(getError());
        sb.append("; maxTextLength: ");
        sb.append(getMaxTextLength());
        sb.append("; stateDescription: ");
        sb.append(getStateDescription());
        sb.append("; contentDescription: ");
        sb.append(getContentDescription());
        sb.append("; tooltipText: ");
        sb.append(getTooltipText());
        sb.append("; viewIdResName: ");
        sb.append(getViewIdResourceName());
        sb.append("; uniqueId: ");
        sb.append(getUniqueId());
        sb.append("; checkable: ");
        sb.append(isCheckable());
        sb.append("; checked: ");
        sb.append(isChecked());
        sb.append("; focusable: ");
        sb.append(isFocusable());
        sb.append("; focused: ");
        sb.append(isFocused());
        sb.append("; selected: ");
        sb.append(isSelected());
        sb.append("; clickable: ");
        sb.append(isClickable());
        sb.append("; longClickable: ");
        sb.append(isLongClickable());
        sb.append("; contextClickable: ");
        sb.append(isContextClickable());
        sb.append("; enabled: ");
        sb.append(isEnabled());
        sb.append("; password: ");
        sb.append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; containerTitle: ");
        sb.append(getContainerTitle());
        sb.append("; granularScrollingSupported: ");
        sb.append(isGranularScrollingSupported());
        sb.append("; importantForAccessibility: ");
        sb.append(isImportantForAccessibility());
        sb.append("; visible: ");
        sb.append(isVisibleToUser());
        sb.append("; isTextSelectable: ");
        sb.append(isTextSelectable());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(isAccessibilityDataSensitive());
        sb.append("; [");
        List<AccessibilityActionCompat> actionList = getActionList();
        for (int i6 = 0; i6 < actionList.size(); i6++) {
            AccessibilityActionCompat accessibilityActionCompat = actionList.get(i6);
            String actionSymbolicName = getActionSymbolicName(accessibilityActionCompat.getId());
            if (actionSymbolicName.equals("ACTION_UNKNOWN") && accessibilityActionCompat.getLabel() != null) {
                actionSymbolicName = accessibilityActionCompat.getLabel().toString();
            }
            sb.append(actionSymbolicName);
            if (i6 != actionList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }

    private boolean getBooleanProperty(int i6) {
        Bundle extras = getExtras();
        if (extras == null || (extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & i6) != i6) {
            return false;
        }
        return true;
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View view) {
        SparseArray<WeakReference<ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags == null) {
            SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
            view.setTag(androidx.core.R.id.tag_accessibility_clickable_spans, sparseArray);
            return sparseArray;
        }
        return spansFromViewTags;
    }

    private void removeCollectedSpans(View view) {
        SparseArray<WeakReference<ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags != null) {
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < spansFromViewTags.size(); i6++) {
                if (spansFromViewTags.valueAt(i6).get() == null) {
                    arrayList.add(Integer.valueOf(i6));
                }
            }
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                spansFromViewTags.remove(((Integer) arrayList.get(i7)).intValue());
            }
        }
    }

    private void setBooleanProperty(int i6, boolean z5) {
        Bundle extras = getExtras();
        if (extras != null) {
            int i7 = extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~i6);
            if (!z5) {
                i6 = 0;
            }
            extras.putInt(BOOLEAN_PROPERTY_KEY, i6 | i7);
        }
    }

    public CharSequence getText() {
        if (hasSpans()) {
            List<Integer> extrasIntList = extrasIntList(SPANS_START_KEY);
            List<Integer> extrasIntList2 = extrasIntList(SPANS_END_KEY);
            List<Integer> extrasIntList3 = extrasIntList(SPANS_FLAGS_KEY);
            List<Integer> extrasIntList4 = extrasIntList(SPANS_ID_KEY);
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
            for (int i6 = 0; i6 < extrasIntList.size(); i6++) {
                spannableString.setSpan(new AccessibilityClickableSpanCompat(extrasIntList4.get(i6).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), extrasIntList.get(i6).intValue(), extrasIntList2.get(i6).intValue(), extrasIntList3.get(i6).intValue());
            }
            return spannableString;
        }
        return this.mInfo.getText();
    }

    public void setParent(View view, int i6) {
        this.mParentVirtualDescendantId = i6;
        this.mInfo.setParent(view, i6);
    }

    public void setSource(View view, int i6) {
        this.mVirtualDescendantId = i6;
        this.mInfo.setSource(view, i6);
    }

    public void setTraversalAfter(View view, int i6) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.mInfo.setTraversalAfter(view, i6);
        }
    }

    public void setTraversalBefore(View view, int i6) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.mInfo.setTraversalBefore(view, i6);
        }
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mInfo = accessibilityNodeInfo;
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrap(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.mInfo));
    }

    @Deprecated
    public void recycle() {
    }
}
