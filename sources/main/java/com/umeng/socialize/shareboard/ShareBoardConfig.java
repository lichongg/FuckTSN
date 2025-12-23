package com.umeng.socialize.shareboard;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.umeng.socialize.utils.ShareBoardlistener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ShareBoardConfig {
    public static int BG_SHAPE_CIRCULAR = 1;
    public static int BG_SHAPE_NONE = 0;
    public static int BG_SHAPE_ROUNDED_SQUARE = 2;
    static final int CANCEL_BTN_HEIGHT = 50;
    static final int CANCEL_BTN_TEXT_SIZE_IN_SP = 15;
    static final int CENTER_MENU_LEFT_PADDING = 36;
    static final int INDICATOR_BOTTOM_MARGIN = 20;
    static final int INDICATOR_SIZE = 3;
    static final int INDICATOR_SPACE = 5;
    private static final int MENU_COLUMN_NUM = 4;
    private static final int MENU_COLUMN_NUM_CENTER = 3;
    private static final int MENU_COLUMN_NUM_HORIZONTAL = 6;
    private static final int MENU_COLUMN_NUM_HORIZONTAL_CENTER = 5;
    static final int MENU_ROW_MARGIN = 20;
    static final int MENU_ROW_NUM = 2;
    static final int MENU_TOP_MARGIN = 20;
    public static int SHAREBOARD_POSITION_BOTTOM = 3;
    public static int SHAREBOARD_POSITION_CENTER = 2;
    static int SHAREBOARD_POSITION_TOP = 1;
    static final int TITLE_TEXT_SIZE_IN_SP = 16;
    static final int TITLE_TOP_MARGIN = 20;
    static final int VIEW_PAGER_LEFT_MARGIN = 10;
    int mCancelBtnBgColor;
    int mCancelBtnBgPressedColor;
    int mCancelBtnColor;
    String mCancelBtnText;
    boolean mCancelBtnVisibility;
    int mIndicatorNormalColor;
    int mIndicatorSelectedColor;
    boolean mIndicatorVisibility;
    int mMenuBgColor;
    int mMenuBgPressedColor;
    int mMenuBgShape;
    int mMenuBgShapeAngle;
    int mMenuColumnNum;
    int mMenuIconPressedColor;
    int mMenuTextColor;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private ShareBoardlistener mShareBoardlistener;
    int mShareboardBgColor;
    int mShareboardPosition;
    String mTitleText;
    int mTitleTextColor;
    boolean mTitleVisibility;
    int mTopMargin;

    public ShareBoardConfig setCancelButtonBackground(int i6) {
        setCancelButtonBackground(i6, 0);
        return this;
    }

    public ShareBoardConfig setIndicatorColor(int i6) {
        setIndicatorColor(i6, 0);
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundColor(int i6) {
        setMenuItemBackgroundColor(i6, 0);
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundShape(int i6) {
        setMenuItemBackgroundShape(i6, 0);
        return this;
    }

    private void setDefaultValue() {
        int parseColor = Color.parseColor("#575A5C");
        setShareboardBackgroundColor(Color.parseColor("#E9EFF2"));
        setShareboardPostion(SHAREBOARD_POSITION_BOTTOM);
        setTitleText("选择要分享到的平台");
        setTitleTextColor(parseColor);
        setMenuItemBackgroundShape(BG_SHAPE_ROUNDED_SQUARE, 5);
        setMenuItemBackgroundColor(Color.parseColor("#ffffff"), Color.parseColor("#22000000"));
        setMenuItemIconPressedColor(Color.parseColor("#22000000"));
        setMenuItemTextColor(parseColor);
        setCancelButtonText("取消分享");
        setCancelButtonTextColor(parseColor);
        setCancelButtonBackground(Color.parseColor("#ffffff"), Color.parseColor("#22000000"));
        setIndicatorColor(Color.parseColor("#C2C9CC"), Color.parseColor("#0086DC"));
    }

    int calculateMenuHeightInDp(int i6) {
        int i7 = i6 <= this.mMenuColumnNum ? 1 : 2;
        return (i7 * 75) + ((i7 - 1) * 20) + 20;
    }

    PopupWindow.OnDismissListener getOnDismissListener() {
        return this.mOnDismissListener;
    }

    ShareBoardlistener getShareBoardlistener() {
        return this.mShareBoardlistener;
    }

    public ShareBoardConfig setCancelButtonBackground(int i6, int i7) {
        this.mCancelBtnBgColor = i6;
        this.mCancelBtnBgPressedColor = i7;
        return this;
    }

    public ShareBoardConfig setCancelButtonTextColor(int i6) {
        this.mCancelBtnColor = i6;
        return this;
    }

    public ShareBoardConfig setCancelButtonVisibility(boolean z5) {
        this.mCancelBtnVisibility = z5;
        return this;
    }

    public ShareBoardConfig setIndicatorColor(int i6, int i7) {
        if (i6 != 0) {
            this.mIndicatorNormalColor = i6;
        }
        if (i7 != 0) {
            this.mIndicatorSelectedColor = i7;
        }
        setIndicatorVisibility(true);
        return this;
    }

    public ShareBoardConfig setIndicatorVisibility(boolean z5) {
        this.mIndicatorVisibility = z5;
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundColor(int i6, int i7) {
        this.mMenuBgColor = i6;
        this.mMenuBgPressedColor = i7;
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundShape(int i6, int i7) {
        if (i6 != BG_SHAPE_CIRCULAR && i6 != BG_SHAPE_ROUNDED_SQUARE) {
            i6 = BG_SHAPE_NONE;
        }
        this.mMenuBgShape = i6;
        this.mMenuBgShapeAngle = i7;
        return this;
    }

    public ShareBoardConfig setMenuItemIconPressedColor(int i6) {
        this.mMenuIconPressedColor = i6;
        return this;
    }

    public ShareBoardConfig setMenuItemTextColor(int i6) {
        this.mMenuTextColor = i6;
        return this;
    }

    public ShareBoardConfig setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    void setOrientation(boolean z5) {
        if (z5) {
            int i6 = this.mShareboardPosition;
            if (i6 == SHAREBOARD_POSITION_BOTTOM) {
                this.mMenuColumnNum = 6;
                return;
            } else {
                if (i6 == SHAREBOARD_POSITION_CENTER) {
                    this.mMenuColumnNum = 5;
                    return;
                }
                return;
            }
        }
        int i7 = this.mShareboardPosition;
        if (i7 == SHAREBOARD_POSITION_BOTTOM) {
            this.mMenuColumnNum = 4;
        } else if (i7 == SHAREBOARD_POSITION_CENTER) {
            this.mMenuColumnNum = 3;
        }
    }

    void setShareBoardlistener(ShareBoardlistener shareBoardlistener) {
        this.mShareBoardlistener = shareBoardlistener;
    }

    public ShareBoardConfig setShareboardBackgroundColor(int i6) {
        this.mShareboardBgColor = i6;
        return this;
    }

    public ShareBoardConfig setShareboardPostion(int i6) {
        int i7 = SHAREBOARD_POSITION_BOTTOM;
        if (i6 != i7 && i6 != SHAREBOARD_POSITION_CENTER && i6 != SHAREBOARD_POSITION_TOP) {
            i6 = i7;
        }
        this.mShareboardPosition = i6;
        return this;
    }

    public ShareBoardConfig setStatusBarHeight(int i6) {
        this.mTopMargin = i6;
        return this;
    }

    public ShareBoardConfig setTitleTextColor(int i6) {
        this.mTitleTextColor = i6;
        return this;
    }

    public ShareBoardConfig setTitleVisibility(boolean z5) {
        this.mTitleVisibility = z5;
        return this;
    }

    public ShareBoardConfig() {
        setDefaultValue();
    }

    public ShareBoardConfig setCancelButtonText(String str) {
        if (TextUtils.isEmpty(str)) {
            setCancelButtonVisibility(false);
            return this;
        }
        setCancelButtonVisibility(true);
        this.mCancelBtnText = str;
        return this;
    }

    public ShareBoardConfig setTitleText(String str) {
        if (TextUtils.isEmpty(str)) {
            setTitleVisibility(false);
            return this;
        }
        setTitleVisibility(true);
        this.mTitleText = str;
        return this;
    }
}
