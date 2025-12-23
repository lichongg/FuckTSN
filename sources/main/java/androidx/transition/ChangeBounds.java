package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY;
    private static final Property<View, PointF> POSITION_PROPERTY;
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY;
    private boolean mReparent;
    private boolean mResizeClip;
    private int[] mTempLocation;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private static RectEvaluator sRectEvaluator = new RectEvaluator();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private View mView;

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            int i6 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i6;
            if (this.mTopLeftCalls == i6) {
                setLeftTopRightBottom();
            }
        }

        void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            int i6 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i6;
            if (i6 == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }

        ViewBounds(View view) {
            this.mView = view;
        }
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    static {
        Class<PointF> cls = PointF.class;
        DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(cls, "boundsOrigin") { // from class: androidx.transition.ChangeBounds.1
            private Rect mBounds = new Rect();

            @Override // android.util.Property
            public PointF get(Drawable drawable) {
                drawable.copyBounds(this.mBounds);
                Rect rect = this.mBounds;
                return new PointF(rect.left, rect.top);
            }

            @Override // android.util.Property
            public void set(Drawable drawable, PointF pointF) {
                drawable.copyBounds(this.mBounds);
                this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                drawable.setBounds(this.mBounds);
            }
        };
        String str = "topLeft";
        TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(cls, str) { // from class: androidx.transition.ChangeBounds.2
            @Override // android.util.Property
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            @Override // android.util.Property
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.setTopLeft(pointF);
            }
        };
        String str2 = "bottomRight";
        BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(cls, str2) { // from class: androidx.transition.ChangeBounds.3
            @Override // android.util.Property
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            @Override // android.util.Property
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.setBottomRight(pointF);
            }
        };
        BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(cls, str2) { // from class: androidx.transition.ChangeBounds.4
            @Override // android.util.Property
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public void set(View view, PointF pointF) {
                ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(cls, str) { // from class: androidx.transition.ChangeBounds.5
            @Override // android.util.Property
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public void set(View view, PointF pointF) {
                ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
        POSITION_PROPERTY = new Property<View, PointF>(cls, "position") { // from class: androidx.transition.ChangeBounds.6
            @Override // android.util.Property
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public void set(View view, PointF pointF) {
                int round = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                ViewUtils.setLeftTopRightBottom(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
            }
        };
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (!ViewCompat.isLaidOut(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        if (this.mReparent) {
            transitionValues.view.getLocationInWindow(this.mTempLocation);
            transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
            transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
        }
        if (this.mResizeClip) {
            transitionValues.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(view));
        }
    }

    private boolean parentMatches(View view, View view2) {
        if (!this.mReparent) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        return matchedTransitionValues == null ? view == view2 : view2 == matchedTransitionValues.view;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull final ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        Animator animator;
        int i6;
        int i7;
        Rect rect;
        View view;
        ObjectAnimator objectAnimator;
        Animator mergeAnimators;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view2 = transitionValues2.view;
        if (parentMatches(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
            Rect rect3 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
            int i8 = rect2.left;
            final int i9 = rect3.left;
            int i10 = rect2.top;
            final int i11 = rect3.top;
            int i12 = rect2.right;
            final int i13 = rect3.right;
            int i14 = rect2.bottom;
            final int i15 = rect3.bottom;
            int i16 = i12 - i8;
            animator = null;
            int i17 = i14 - i10;
            int i18 = i13 - i9;
            int i19 = i15 - i11;
            Rect rect4 = (Rect) transitionValues.values.get(PROPNAME_CLIP);
            final Rect rect5 = (Rect) transitionValues2.values.get(PROPNAME_CLIP);
            if ((i16 == 0 || i17 == 0) && (i18 == 0 || i19 == 0)) {
                i6 = 0;
            } else {
                i6 = (i8 == i9 && i10 == i11) ? 0 : 1;
                if (i12 != i13 || i14 != i15) {
                    i6++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i6++;
            }
            if (i6 > 0) {
                if (this.mResizeClip) {
                    ViewUtils.setLeftTopRightBottom(view2, i8, i10, Math.max(i16, i18) + i8, Math.max(i17, i19) + i10);
                    ObjectAnimator ofPointF = (i8 == i9 && i10 == i11) ? null : ObjectAnimatorUtils.ofPointF(view2, POSITION_PROPERTY, getPathMotion().getPath(i8, i10, i9, i11));
                    if (rect4 == null) {
                        i7 = 0;
                        rect = new Rect(0, 0, i16, i17);
                    } else {
                        i7 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i7, i7, i18, i19) : rect5;
                    if (rect.equals(rect6)) {
                        view = view2;
                        objectAnimator = null;
                    } else {
                        ViewCompat.setClipBounds(view2, rect);
                        RectEvaluator rectEvaluator = sRectEvaluator;
                        Object[] objArr = new Object[2];
                        objArr[i7] = rect;
                        objArr[1] = rect6;
                        ObjectAnimator ofObject = ObjectAnimator.ofObject(view2, "clipBounds", rectEvaluator, objArr);
                        view = view2;
                        ofObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.8
                            private boolean mIsCanceled;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                                this.mIsCanceled = true;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                if (this.mIsCanceled) {
                                    return;
                                }
                                ViewCompat.setClipBounds(view2, rect5);
                                ViewUtils.setLeftTopRightBottom(view2, i9, i11, i13, i15);
                            }
                        });
                        objectAnimator = ofObject;
                    }
                    mergeAnimators = TransitionUtils.mergeAnimators(ofPointF, objectAnimator);
                } else {
                    ViewUtils.setLeftTopRightBottom(view2, i8, i10, i12, i14);
                    if (i6 != 2) {
                        mergeAnimators = (i8 == i9 && i10 == i11) ? ObjectAnimatorUtils.ofPointF(view2, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(i12, i14, i13, i15)) : ObjectAnimatorUtils.ofPointF(view2, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(i8, i10, i9, i11));
                    } else if (i16 == i18 && i17 == i19) {
                        mergeAnimators = ObjectAnimatorUtils.ofPointF(view2, POSITION_PROPERTY, getPathMotion().getPath(i8, i10, i9, i11));
                    } else {
                        ViewBounds viewBounds = new ViewBounds(view2);
                        ObjectAnimator ofPointF2 = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath(i8, i10, i9, i11));
                        ObjectAnimator ofPointF3 = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(i12, i14, i13, i15));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ofPointF2, ofPointF3);
                        animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.7
                            private ViewBounds mViewBounds;
                            final /* synthetic */ ViewBounds val$viewBounds;

                            {
                                this.val$viewBounds = viewBounds;
                                this.mViewBounds = viewBounds;
                            }
                        });
                        mergeAnimators = animatorSet;
                    }
                    view = view2;
                }
                if (view.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    ViewGroupUtils.suppressLayout(viewGroup4, true);
                    addListener(new TransitionListenerAdapter() { // from class: androidx.transition.ChangeBounds.9
                        boolean mCanceled = false;

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionCancel(@NonNull Transition transition) {
                            ViewGroupUtils.suppressLayout(viewGroup4, false);
                            this.mCanceled = true;
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionEnd(@NonNull Transition transition) {
                            if (!this.mCanceled) {
                                ViewGroupUtils.suppressLayout(viewGroup4, false);
                            }
                            transition.removeListener(this);
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionPause(@NonNull Transition transition) {
                            ViewGroupUtils.suppressLayout(viewGroup4, false);
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionResume(@NonNull Transition transition) {
                            ViewGroupUtils.suppressLayout(viewGroup4, true);
                        }
                    });
                }
                return mergeAnimators;
            }
        } else {
            animator = null;
            int intValue = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_X)).intValue();
            int intValue2 = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_Y)).intValue();
            int intValue3 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_X)).intValue();
            int intValue4 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_Y)).intValue();
            if (intValue != intValue3 || intValue2 != intValue4) {
                viewGroup.getLocationInWindow(this.mTempLocation);
                Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                view2.draw(new Canvas(createBitmap));
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                final float transitionAlpha = ViewUtils.getTransitionAlpha(view2);
                ViewUtils.setTransitionAlpha(view2, 0.0f);
                ViewUtils.getOverlay(viewGroup).add(bitmapDrawable);
                PathMotion pathMotion = getPathMotion();
                int[] iArr = this.mTempLocation;
                int i20 = iArr[0];
                int i21 = iArr[1];
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, pathMotion.getPath(intValue - i20, intValue2 - i21, intValue3 - i20, intValue4 - i21)));
                ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.10
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        ViewUtils.getOverlay(viewGroup).remove(bitmapDrawable);
                        ViewUtils.setTransitionAlpha(view2, transitionAlpha);
                    }
                });
                return ofPropertyValuesHolder;
            }
        }
        return animator;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean z5) {
        this.mResizeClip = z5;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }
}
