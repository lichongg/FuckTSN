package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int i6 = this.mCount;
            for (int i7 = 0; i7 < i6 && this.mStartIndex + i7 < Flow.this.mDisplayedWidgetsCount; i7++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i7];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i8 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i8 = 0;
                    }
                    this.mWidth += width + i8;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i9 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i9 = 0;
                    }
                    this.mHeight += widgetHeight2 + i9;
                    if (this.biggest == null || this.biggestDimension < widgetWidth) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public WidgetsList(int i6, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i7) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i6;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i7;
        }

        public void add(ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth += widgetWidth + (constraintWidget.getVisibility() != 8 ? Flow.this.mHorizontalGap : 0);
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight += widgetHeight2 + (constraintWidget.getVisibility() != 8 ? Flow.this.mVerticalGap : 0);
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void createConstraints(boolean z5, int i6, boolean z6) {
            ConstraintWidget constraintWidget;
            int i7 = this.mCount;
            for (int i8 = 0; i8 < i7 && this.mStartIndex + i8 < Flow.this.mDisplayedWidgetsCount; i8++) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i8];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i7 == 0 || this.biggest == null) {
                return;
            }
            boolean z7 = z6 && i6 == 0;
            int i9 = -1;
            int i10 = -1;
            for (int i11 = 0; i11 < i7; i11++) {
                int i12 = z5 ? (i7 - 1) - i11 : i11;
                if (this.mStartIndex + i12 >= Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                if (Flow.this.mDisplayedWidgets[this.mStartIndex + i12].getVisibility() == 0) {
                    if (i9 == -1) {
                        i9 = i11;
                    }
                    i10 = i11;
                }
            }
            ConstraintWidget constraintWidget3 = null;
            if (this.mOrientation != 0) {
                ConstraintWidget constraintWidget4 = this.biggest;
                constraintWidget4.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
                int i13 = this.mPaddingLeft;
                if (i6 > 0) {
                    i13 += Flow.this.mHorizontalGap;
                }
                if (z5) {
                    constraintWidget4.mRight.connect(this.mRight, i13);
                    if (z6) {
                        constraintWidget4.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i6 > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget4.mRight, 0);
                    }
                } else {
                    constraintWidget4.mLeft.connect(this.mLeft, i13);
                    if (z6) {
                        constraintWidget4.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i6 > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget4.mLeft, 0);
                    }
                }
                int i14 = 0;
                while (i14 < i7 && this.mStartIndex + i14 < Flow.this.mDisplayedWidgetsCount) {
                    ConstraintWidget constraintWidget5 = Flow.this.mDisplayedWidgets[this.mStartIndex + i14];
                    if (i14 == 0) {
                        constraintWidget5.connect(constraintWidget5.mTop, this.mTop, this.mPaddingTop);
                        int i15 = Flow.this.mVerticalStyle;
                        float f6 = Flow.this.mVerticalBias;
                        if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                            i15 = Flow.this.mFirstVerticalStyle;
                            f6 = Flow.this.mFirstVerticalBias;
                        } else if (z6 && Flow.this.mLastVerticalStyle != -1) {
                            i15 = Flow.this.mLastVerticalStyle;
                            f6 = Flow.this.mLastVerticalBias;
                        }
                        constraintWidget5.setVerticalChainStyle(i15);
                        constraintWidget5.setVerticalBiasPercent(f6);
                    }
                    if (i14 == i7 - 1) {
                        constraintWidget5.connect(constraintWidget5.mBottom, this.mBottom, this.mPaddingBottom);
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget5.mTop.connect(constraintWidget3.mBottom, Flow.this.mVerticalGap);
                        if (i14 == i9) {
                            constraintWidget5.mTop.setGoneMargin(this.mPaddingTop);
                        }
                        constraintWidget3.mBottom.connect(constraintWidget5.mTop, 0);
                        if (i14 == i10 + 1) {
                            constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                        }
                    }
                    if (constraintWidget5 != constraintWidget4) {
                        if (z5) {
                            int i16 = Flow.this.mHorizontalAlign;
                            if (i16 == 0) {
                                constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                            } else if (i16 == 1) {
                                constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                            } else if (i16 == 2) {
                                constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                            }
                        } else {
                            int i17 = Flow.this.mHorizontalAlign;
                            if (i17 == 0) {
                                constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                            } else if (i17 == 1) {
                                constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                            } else if (i17 == 2) {
                                if (z7) {
                                    constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                    constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                                }
                            }
                            i14++;
                            constraintWidget3 = constraintWidget5;
                        }
                    }
                    i14++;
                    constraintWidget3 = constraintWidget5;
                }
                return;
            }
            ConstraintWidget constraintWidget6 = this.biggest;
            constraintWidget6.setVerticalChainStyle(Flow.this.mVerticalStyle);
            int i18 = this.mPaddingTop;
            if (i6 > 0) {
                i18 += Flow.this.mVerticalGap;
            }
            constraintWidget6.mTop.connect(this.mTop, i18);
            if (z6) {
                constraintWidget6.mBottom.connect(this.mBottom, this.mPaddingBottom);
            }
            if (i6 > 0) {
                this.mTop.mOwner.mBottom.connect(constraintWidget6.mTop, 0);
            }
            if (Flow.this.mVerticalAlign == 3 && !constraintWidget6.hasBaseline()) {
                for (int i19 = 0; i19 < i7; i19++) {
                    int i20 = z5 ? (i7 - 1) - i19 : i19;
                    if (this.mStartIndex + i20 >= Flow.this.mDisplayedWidgetsCount) {
                        break;
                    }
                    constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i20];
                    if (constraintWidget.hasBaseline()) {
                        break;
                    }
                }
            }
            constraintWidget = constraintWidget6;
            int i21 = 0;
            while (i21 < i7) {
                int i22 = z5 ? (i7 - 1) - i21 : i21;
                if (this.mStartIndex + i22 >= Flow.this.mDisplayedWidgetsCount) {
                    return;
                }
                ConstraintWidget constraintWidget7 = Flow.this.mDisplayedWidgets[this.mStartIndex + i22];
                if (i21 == 0) {
                    constraintWidget7.connect(constraintWidget7.mLeft, this.mLeft, this.mPaddingLeft);
                }
                if (i22 == 0) {
                    int i23 = Flow.this.mHorizontalStyle;
                    float f7 = Flow.this.mHorizontalBias;
                    if (this.mStartIndex == 0 && Flow.this.mFirstHorizontalStyle != -1) {
                        i23 = Flow.this.mFirstHorizontalStyle;
                        f7 = Flow.this.mFirstHorizontalBias;
                    } else if (z6 && Flow.this.mLastHorizontalStyle != -1) {
                        i23 = Flow.this.mLastHorizontalStyle;
                        f7 = Flow.this.mLastHorizontalBias;
                    }
                    constraintWidget7.setHorizontalChainStyle(i23);
                    constraintWidget7.setHorizontalBiasPercent(f7);
                }
                if (i21 == i7 - 1) {
                    constraintWidget7.connect(constraintWidget7.mRight, this.mRight, this.mPaddingRight);
                }
                if (constraintWidget3 != null) {
                    constraintWidget7.mLeft.connect(constraintWidget3.mRight, Flow.this.mHorizontalGap);
                    if (i21 == i9) {
                        constraintWidget7.mLeft.setGoneMargin(this.mPaddingLeft);
                    }
                    constraintWidget3.mRight.connect(constraintWidget7.mLeft, 0);
                    if (i21 == i10 + 1) {
                        constraintWidget3.mRight.setGoneMargin(this.mPaddingRight);
                    }
                }
                if (constraintWidget7 != constraintWidget6) {
                    if (Flow.this.mVerticalAlign == 3 && constraintWidget.hasBaseline() && constraintWidget7 != constraintWidget && constraintWidget7.hasBaseline()) {
                        constraintWidget7.mBaseline.connect(constraintWidget.mBaseline, 0);
                    } else {
                        int i24 = Flow.this.mVerticalAlign;
                        if (i24 == 0) {
                            constraintWidget7.mTop.connect(constraintWidget6.mTop, 0);
                        } else if (i24 == 1) {
                            constraintWidget7.mBottom.connect(constraintWidget6.mBottom, 0);
                        } else if (z7) {
                            constraintWidget7.mTop.connect(this.mTop, this.mPaddingTop);
                            constraintWidget7.mBottom.connect(this.mBottom, this.mPaddingBottom);
                        } else {
                            constraintWidget7.mTop.connect(constraintWidget6.mTop, 0);
                            constraintWidget7.mBottom.connect(constraintWidget6.mBottom, 0);
                        }
                    }
                }
                i21++;
                constraintWidget3 = constraintWidget7;
            }
        }

        public int getHeight() {
            return this.mOrientation == 1 ? this.mHeight - Flow.this.mVerticalGap : this.mHeight;
        }

        public int getWidth() {
            return this.mOrientation == 0 ? this.mWidth - Flow.this.mHorizontalGap : this.mWidth;
        }

        public void measureMatchConstraints(int i6) {
            int i7 = this.mNbMatchConstraintsWidgets;
            if (i7 == 0) {
                return;
            }
            int i8 = this.mCount;
            int i9 = i6 / i7;
            for (int i10 = 0; i10 < i8 && this.mStartIndex + i10 < Flow.this.mDisplayedWidgetsCount; i10++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i10];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i9, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    int i11 = i9;
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i11);
                    i9 = i11;
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i6) {
            this.mStartIndex = i6;
        }

        public void setup(int i6, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i7, int i8, int i9, int i10, int i11) {
            this.mOrientation = i6;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i7;
            this.mPaddingTop = i8;
            this.mPaddingRight = i9;
            this.mPaddingBottom = i10;
            this.mMax = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i6) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i7 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i7 == 0) {
                return 0;
            }
            if (i7 == 2) {
                int i8 = (int) (constraintWidget.mMatchConstraintPercentHeight * i6);
                if (i8 != constraintWidget.getHeight()) {
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i8);
                }
                return i8;
            }
            constraintWidget2 = constraintWidget;
            if (i7 == 1) {
                return constraintWidget2.getHeight();
            }
            if (i7 == 3) {
                return (int) ((constraintWidget2.getWidth() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i6) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i7 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i7 == 0) {
                return 0;
            }
            if (i7 == 2) {
                int i8 = (int) (constraintWidget.mMatchConstraintPercentWidth * i6);
                if (i8 != constraintWidget.getWidth()) {
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i8, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i8;
            }
            constraintWidget2 = constraintWidget;
            if (i7 == 1) {
                return constraintWidget2.getWidth();
            }
            if (i7 == 3) {
                return (int) ((constraintWidget2.getHeight() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x010d -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x010f -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0115 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0117 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Flow.measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i6, int i7, int i8, int[] iArr) {
        int i9;
        Flow flow;
        int i10;
        ConstraintAnchor constraintAnchor;
        int i11;
        Flow flow2 = this;
        if (i6 == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i12 = i8;
        WidgetsList widgetsList = flow2.new WidgetsList(i7, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i12);
        flow2.mChainList.add(widgetsList);
        if (i7 == 0) {
            i9 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i14 < i6) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i14];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i12);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i9++;
                }
                int i15 = i9;
                boolean z5 = (i13 == i12 || (flow2.mHorizontalGap + i13) + widgetWidth > i12) && widgetsList.biggest != null;
                if (!z5 && i14 > 0 && (i11 = flow2.mMaxElementsWrap) > 0 && i14 % i11 == 0) {
                    z5 = true;
                }
                if (z5) {
                    widgetsList = flow2.new WidgetsList(i7, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i12);
                    widgetsList.setStartIndex(i14);
                    flow2.mChainList.add(widgetsList);
                } else if (i14 > 0) {
                    i13 += flow2.mHorizontalGap + widgetWidth;
                    widgetsList.add(constraintWidget);
                    i14++;
                    i9 = i15;
                }
                i13 = widgetWidth;
                widgetsList.add(constraintWidget);
                i14++;
                i9 = i15;
            }
        } else {
            i9 = 0;
            int i16 = 0;
            int i17 = 0;
            while (i17 < i6) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i17];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i12);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i9++;
                }
                int i18 = i9;
                boolean z6 = (i16 == i12 || (flow2.mVerticalGap + i16) + widgetHeight > i12) && widgetsList.biggest != null;
                if (!z6 && i17 > 0 && (i10 = flow2.mMaxElementsWrap) > 0 && i17 % i10 == 0) {
                    z6 = true;
                }
                if (z6) {
                    widgetsList = flow2.new WidgetsList(i7, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i12);
                    flow = flow2;
                    widgetsList.setStartIndex(i17);
                    flow.mChainList.add(widgetsList);
                } else {
                    flow = flow2;
                    if (i17 > 0) {
                        i16 += flow.mVerticalGap + widgetHeight;
                        widgetsList.add(constraintWidget2);
                        i17++;
                        i12 = i8;
                        i9 = i18;
                        flow2 = flow;
                    }
                }
                i16 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i17++;
                i12 = i8;
                i9 = i18;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z7 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i9 > 0 && z7) {
            for (int i19 = 0; i19 < size; i19++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i19);
                if (i7 == 0) {
                    widgetsList2.measureMatchConstraints(i8 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i8 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        int i20 = paddingBottom;
        int i21 = 0;
        int i22 = paddingRight;
        int i23 = paddingTop;
        int i24 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor3;
        int i25 = 0;
        for (int i26 = 0; i26 < size; i26++) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i26);
            if (i7 == 0) {
                if (i26 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i26 + 1).biggest.mTop;
                    i20 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    i20 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.biggest.mBottom;
                int i27 = i25;
                widgetsList3.setup(i7, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i24, i23, i22, i20, i8);
                int max = Math.max(i21, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i27;
                if (i26 > 0) {
                    height += flow3.mVerticalGap;
                }
                i25 = height;
                i21 = max;
                constraintAnchor9 = constraintAnchor10;
                i23 = 0;
            } else {
                int i28 = i21;
                int i29 = i25;
                if (i26 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i26 + 1).biggest.mLeft;
                    i22 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    i22 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i7, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i24, i23, i22, i20, i8);
                int width = widgetsList3.getWidth() + i28;
                int max2 = Math.max(i29, widgetsList3.getHeight());
                if (i26 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i30 = width;
                i25 = max2;
                i21 = i30;
                constraintAnchor6 = constraintAnchor11;
                i24 = 0;
            }
        }
        iArr[0] = i21;
        iArr[1] = i25;
    }

    private void createAlignedConstraints(boolean z5) {
        ConstraintWidget constraintWidget;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i6 = 0; i6 < this.mDisplayedWidgetsCount; i6++) {
            this.mDisplayedWidgets[i6].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i7 = iArr[0];
        int i8 = iArr[1];
        ConstraintWidget constraintWidget2 = null;
        for (int i9 = 0; i9 < i7; i9++) {
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[z5 ? (i7 - i9) - 1 : i9];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i9 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(this.mHorizontalBias);
                }
                if (i9 == i7 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i9 > 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
        }
        for (int i10 = 0; i10 < i8; i10++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i10];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i10 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i10 == i8 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i10 > 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i11 = 0; i11 < i7; i11++) {
            for (int i12 = 0; i12 < i8; i12++) {
                int i13 = (i12 * i7) + i11;
                if (this.mOrientation == 1) {
                    i13 = (i11 * i8) + i12;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i13 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i13]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i11];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i12];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i6, int i7, int i8, int[] iArr) {
        WidgetsList widgetsList;
        if (i6 == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i7, this.mLeft, this.mTop, this.mRight, this.mBottom, i8);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList2.setup(i7, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i8);
            widgetsList = widgetsList2;
        }
        for (int i9 = 0; i9 < i6; i9++) {
            widgetsList.add(constraintWidgetArr[i9]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.solver.widgets.VirtualLayout
    public void measure(int i6, int i7, int i8, int i9) {
        int i10;
        ConstraintWidget[] constraintWidgetArr;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr = new int[2];
        int i11 = (i7 - paddingLeft) - paddingRight;
        int i12 = this.mOrientation;
        if (i12 == 1) {
            i11 = (i9 - paddingTop) - paddingBottom;
        }
        int i13 = i11;
        if (i12 == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            i10 = this.mWidgetsCount;
            if (i14 >= i10) {
                break;
            }
            if (this.mWidgets[i14].getVisibility() == 8) {
                i15++;
            }
            i14++;
        }
        if (i15 > 0) {
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[i10 - i15];
            int i16 = 0;
            i10 = 0;
            while (i16 < this.mWidgetsCount) {
                ConstraintWidget constraintWidget = this.mWidgets[i16];
                ConstraintWidget[] constraintWidgetArr4 = constraintWidgetArr3;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr4[i10] = constraintWidget;
                    i10++;
                }
                i16++;
                constraintWidgetArr3 = constraintWidgetArr4;
            }
            constraintWidgetArr = constraintWidgetArr3;
        } else {
            constraintWidgetArr = constraintWidgetArr2;
        }
        int i17 = i10;
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i17;
        int i18 = this.mWrapMode;
        if (i18 == 0) {
            measureNoWrap(constraintWidgetArr, i17, this.mOrientation, i13, iArr);
        } else if (i18 == 1) {
            measureChainWrap(constraintWidgetArr, i17, this.mOrientation, i13, iArr);
        } else if (i18 == 2) {
            measureAligned(constraintWidgetArr, i17, this.mOrientation, i13, iArr);
        }
        int i19 = iArr[0] + paddingLeft + paddingRight;
        int i20 = iArr[1] + paddingTop + paddingBottom;
        if (i6 == 1073741824) {
            i19 = i7;
        } else if (i6 == Integer.MIN_VALUE) {
            i19 = Math.min(i19, i7);
        } else if (i6 != 0) {
            i19 = 0;
        }
        if (i8 == 1073741824) {
            i20 = i9;
        } else if (i8 == Integer.MIN_VALUE) {
            i20 = Math.min(i20, i9);
        } else if (i8 != 0) {
            i20 = 0;
        }
        setMeasure(i19, i20);
        setWidth(i19);
        setHeight(i20);
        needsCallbackFromSolver(this.mWidgetsCount > 0);
    }

    public void setFirstHorizontalBias(float f6) {
        this.mFirstHorizontalBias = f6;
    }

    public void setFirstHorizontalStyle(int i6) {
        this.mFirstHorizontalStyle = i6;
    }

    public void setFirstVerticalBias(float f6) {
        this.mFirstVerticalBias = f6;
    }

    public void setFirstVerticalStyle(int i6) {
        this.mFirstVerticalStyle = i6;
    }

    public void setHorizontalAlign(int i6) {
        this.mHorizontalAlign = i6;
    }

    public void setHorizontalBias(float f6) {
        this.mHorizontalBias = f6;
    }

    public void setHorizontalGap(int i6) {
        this.mHorizontalGap = i6;
    }

    public void setHorizontalStyle(int i6) {
        this.mHorizontalStyle = i6;
    }

    public void setLastHorizontalBias(float f6) {
        this.mLastHorizontalBias = f6;
    }

    public void setLastHorizontalStyle(int i6) {
        this.mLastHorizontalStyle = i6;
    }

    public void setLastVerticalBias(float f6) {
        this.mLastVerticalBias = f6;
    }

    public void setLastVerticalStyle(int i6) {
        this.mLastVerticalStyle = i6;
    }

    public void setMaxElementsWrap(int i6) {
        this.mMaxElementsWrap = i6;
    }

    public void setOrientation(int i6) {
        this.mOrientation = i6;
    }

    public void setVerticalAlign(int i6) {
        this.mVerticalAlign = i6;
    }

    public void setVerticalBias(float f6) {
        this.mVerticalBias = f6;
    }

    public void setVerticalGap(int i6) {
        this.mVerticalGap = i6;
    }

    public void setVerticalStyle(int i6) {
        this.mVerticalStyle = i6;
    }

    public void setWrapMode(int i6) {
        this.mWrapMode = i6;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        boolean z5;
        boolean z6;
        super.addToSolver(linearSystem);
        if (getParent() != null) {
            z5 = ((ConstraintWidgetContainer) getParent()).isRtl();
        } else {
            z5 = false;
        }
        int i6 = this.mWrapMode;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    createAlignedConstraints(z5);
                }
            } else {
                int size = this.mChainList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    WidgetsList widgetsList = this.mChainList.get(i7);
                    if (i7 == size - 1) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    widgetsList.createConstraints(z5, i7, z6);
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z5, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }
}
