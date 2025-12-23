package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.annotation.AnimatorRes;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import com.acse.ottn.l3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public class AnimatorInflaterCompat {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] mNodeArray;

        PathDataEvaluator() {
        }

        PathDataEvaluator(PathParser.PathDataNode[] pathDataNodeArr) {
            this.mNodeArray = pathDataNodeArr;
        }

        @Override // android.animation.TypeEvaluator
        public PathParser.PathDataNode[] evaluate(float f6, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (!PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!PathParser.canMorph(this.mNodeArray, pathDataNodeArr)) {
                this.mNodeArray = PathParser.deepCopyNodes(pathDataNodeArr);
            }
            for (int i6 = 0; i6 < pathDataNodeArr.length; i6++) {
                this.mNodeArray[i6].interpolatePathDataNode(pathDataNodeArr[i6], pathDataNodeArr2[i6], f6);
            }
            return this.mNodeArray;
        }
    }

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f6) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f6);
    }

    public static Animator loadAnimator(Context context, @AnimatorRes int i6) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i6) : loadAnimator(context, context.getResources(), context.getTheme(), i6);
    }

    private static PropertyValuesHolder loadPvh(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i6) throws XmlPullParserException, IOException {
        int size;
        Context context2;
        Resources.Theme theme2;
        XmlPullParser xmlPullParser2;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (i6 == 4) {
                    i6 = inferValueTypeOfKeyframe(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                int i7 = i6;
                context2 = context;
                theme2 = theme;
                xmlPullParser2 = xmlPullParser;
                Keyframe loadKeyframe = loadKeyframe(context2, resources, theme2, Xml.asAttributeSet(xmlPullParser), i7, xmlPullParser2);
                if (loadKeyframe != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(loadKeyframe);
                }
                xmlPullParser2.next();
                i6 = i7;
            } else {
                context2 = context;
                theme2 = theme;
                xmlPullParser2 = xmlPullParser;
            }
            context = context2;
            theme = theme2;
            xmlPullParser = xmlPullParser2;
        }
        if (arrayList == null || (size = arrayList.size()) <= 0) {
            return null;
        }
        Keyframe keyframe = (Keyframe) arrayList.get(0);
        Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
        float fraction = keyframe2.getFraction();
        if (fraction < 1.0f) {
            if (fraction < 0.0f) {
                keyframe2.setFraction(1.0f);
            } else {
                arrayList.add(arrayList.size(), createNewKeyframe(keyframe2, 1.0f));
                size++;
            }
        }
        float fraction2 = keyframe.getFraction();
        if (fraction2 != 0.0f) {
            if (fraction2 < 0.0f) {
                keyframe.setFraction(0.0f);
            } else {
                arrayList.add(0, createNewKeyframe(keyframe, 0.0f));
                size++;
            }
        }
        Keyframe[] keyframeArr = new Keyframe[size];
        arrayList.toArray(keyframeArr);
        for (int i8 = 0; i8 < size; i8++) {
            Keyframe keyframe3 = keyframeArr[i8];
            if (keyframe3.getFraction() < 0.0f) {
                if (i8 == 0) {
                    keyframe3.setFraction(0.0f);
                } else {
                    int i9 = size - 1;
                    if (i8 == i9) {
                        keyframe3.setFraction(1.0f);
                    } else {
                        int i10 = i8;
                        for (int i11 = i8 + 1; i11 < i9 && keyframeArr[i11].getFraction() < 0.0f; i11++) {
                            i10 = i11;
                        }
                        distributeKeyframes(keyframeArr, keyframeArr[i10 + 1].getFraction() - keyframeArr[i8 - 1].getFraction(), i8, i10);
                    }
                }
            }
        }
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
        if (i6 == 3) {
            ofKeyframe.setEvaluator(ArgbEvaluator.getInstance());
        }
        return ofKeyframe;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i6, float f6) throws XmlPullParserException, IOException {
        int i7;
        int depth = xmlPullParser.getDepth();
        ValueAnimator valueAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i7 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        valueAnimator = loadObjectAnimator(context, resources, theme, attributeSet, f6, xmlPullParser);
                    } else if (name.equals("animator")) {
                        valueAnimator = loadAnimator(context, resources, theme, attributeSet, null, f6, xmlPullParser);
                    } else if (name.equals(l3.f4738h)) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
                        createAnimatorFromXml(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "ordering", 0, 0), f6);
                        obtainAttributes.recycle();
                        valueAnimator = animatorSet2;
                    } else {
                        if (!name.equals("propertyValuesHolder")) {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        PropertyValuesHolder[] loadValues = loadValues(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (loadValues != null && (valueAnimator instanceof ValueAnimator)) {
                            valueAnimator.setValues(loadValues);
                        }
                        i7 = 1;
                    }
                    if (animatorSet != null && i7 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAnimator);
                    }
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i7] = (Animator) it.next();
                i7++;
            }
            if (i6 == 0) {
                animatorSet.playTogether(animatorArr);
                return valueAnimator;
            }
            animatorSet.playSequentially(animatorArr);
        }
        return valueAnimator;
    }

    private static void distributeKeyframes(Keyframe[] keyframeArr, float f6, int i6, int i7) {
        float f7 = f6 / ((i7 - i6) + 2);
        while (i6 <= i7) {
            keyframeArr[i6].setFraction(keyframeArr[i6 - 1].getFraction() + f7);
            i6++;
        }
    }

    private static void dumpKeyframes(Object[] objArr, String str) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        for (Object obj : objArr) {
            Keyframe keyframe = (Keyframe) obj;
            Object obj2 = "null";
            (keyframe.getFraction() < 0.0f ? "null" : Float.valueOf(keyframe.getFraction())).toString();
            if (keyframe.hasValue()) {
                obj2 = keyframe.getValue();
            }
            Objects.toString(obj2);
        }
    }

    private static int inferValueTypeOfKeyframe(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
        int i6 = 0;
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        if (peekNamedValue != null && isColorType(peekNamedValue.type)) {
            i6 = 3;
        }
        obtainAttributes.recycle();
        return i6;
    }

    private static boolean isColorType(int i6) {
        return i6 >= 28 && i6 <= 31;
    }

    private static Keyframe loadKeyframe(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i6, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
        float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        boolean z5 = peekNamedValue != null;
        if (i6 == 4) {
            i6 = (z5 && isColorType(peekNamedValue.type)) ? 3 : 0;
        }
        Keyframe ofInt = z5 ? i6 != 0 ? (i6 == 1 || i6 == 3) ? Keyframe.ofInt(namedFloat, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "value", 0, 0)) : null : Keyframe.ofFloat(namedFloat, TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "value", 0, 0.0f)) : i6 == 0 ? Keyframe.ofFloat(namedFloat) : Keyframe.ofInt(namedFloat);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 1, 0);
        if (namedResourceId > 0) {
            ofInt.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        return ofInt;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f6, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, resources, theme, attributeSet, objectAnimator, f6, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder[] loadValues(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i6;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser2.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser2.next();
            } else {
                if (xmlPullParser2.getName().equals("propertyValuesHolder")) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                    String namedString = TypedArrayUtils.getNamedString(obtainAttributes, xmlPullParser2, "propertyName", 3);
                    int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser2, "valueType", 2, 4);
                    PropertyValuesHolder loadPvh = loadPvh(context, resources, theme, xmlPullParser2, namedString, namedInt);
                    if (loadPvh == null) {
                        loadPvh = getPVH(obtainAttributes, namedInt, 0, 1, namedString);
                    }
                    if (loadPvh != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(loadPvh);
                    }
                    obtainAttributes.recycle();
                }
                xmlPullParser.next();
                xmlPullParser2 = xmlPullParser;
            }
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size];
        for (i6 = 0; i6 < size; i6++) {
            propertyValuesHolderArr[i6] = (PropertyValuesHolder) arrayList.get(i6);
        }
        return propertyValuesHolderArr;
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f6, XmlPullParser xmlPullParser) {
        long namedInt = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "duration", 1, 300);
        long namedInt2 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        int namedInt3 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
            if (namedInt3 == 4) {
                namedInt3 = inferValueTypeFromValues(typedArray, 5, 6);
            }
            PropertyValuesHolder pvh = getPVH(typedArray, namedInt3, 5, 6, "");
            if (pvh != null) {
                valueAnimator.setValues(pvh);
            }
        }
        valueAnimator.setDuration(namedInt);
        valueAnimator.setStartDelay(namedInt2);
        valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            setupObjectAnimator(valueAnimator, typedArray2, namedInt3, f6, xmlPullParser);
        }
    }

    private static void setupObjectAnimator(ValueAnimator valueAnimator, TypedArray typedArray, int i6, float f6, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1);
        if (namedString == null) {
            objectAnimator.setPropertyName(TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        String namedString2 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyXName", 2);
        String namedString3 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyYName", 3);
        if (i6 != 2) {
        }
        if (namedString2 != null || namedString3 != null) {
            setupPathMotion(PathParser.createPathFromPathData(namedString), objectAnimator, f6 * 0.5f, namedString2, namedString3);
            return;
        }
        throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    private static void setupPathMotion(Path path, ObjectAnimator objectAnimator, float f6, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f7 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f8 = 0.0f;
        do {
            f8 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f8));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f8 / f6)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f9 = f8 / (min - 1);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f7 - ((Float) arrayList.get(i7)).floatValue(), fArr3, null);
            fArr[i6] = fArr3[0];
            fArr2[i6] = fArr3[1];
            f7 += f9;
            int i8 = i7 + 1;
            if (i8 < arrayList.size() && f7 > ((Float) arrayList.get(i8)).floatValue()) {
                pathMeasure2.nextContour();
                i7 = i8;
            }
            i6++;
        }
        PropertyValuesHolder ofFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder ofFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (ofFloat == null) {
            objectAnimator.setValues(ofFloat2);
        } else if (ofFloat2 == null) {
            objectAnimator.setValues(ofFloat);
        } else {
            objectAnimator.setValues(ofFloat, ofFloat2);
        }
    }

    private AnimatorInflaterCompat() {
    }

    private static Keyframe createNewKeyframe(Keyframe keyframe, float f6) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f6);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f6);
        }
        return Keyframe.ofObject(f6);
    }

    private static PropertyValuesHolder getPVH(TypedArray typedArray, int i6, int i7, int i8, String str) {
        boolean z5;
        int i9;
        boolean z6;
        int i10;
        boolean z7;
        ArgbEvaluator argbEvaluator;
        int i11;
        int i12;
        int i13;
        float f6;
        PropertyValuesHolder ofFloat;
        float f7;
        float f8;
        TypedValue peekValue = typedArray.peekValue(i7);
        if (peekValue != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            i9 = peekValue.type;
        } else {
            i9 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i8);
        if (peekValue2 != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            i10 = peekValue2.type;
        } else {
            i10 = 0;
        }
        if (i6 == 4) {
            if ((z5 && isColorType(i9)) || (z6 && isColorType(i10))) {
                i6 = 3;
            } else {
                i6 = 0;
            }
        }
        if (i6 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        if (i6 == 2) {
            String string = typedArray.getString(i7);
            String string2 = typedArray.getString(i8);
            PathParser.PathDataNode[] createNodesFromPathData = PathParser.createNodesFromPathData(string);
            PathParser.PathDataNode[] createNodesFromPathData2 = PathParser.createNodesFromPathData(string2);
            if (createNodesFromPathData != null || createNodesFromPathData2 != null) {
                if (createNodesFromPathData != null) {
                    PathDataEvaluator pathDataEvaluator = new PathDataEvaluator();
                    if (createNodesFromPathData2 != null) {
                        if (PathParser.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                            return PropertyValuesHolder.ofObject(str, pathDataEvaluator, createNodesFromPathData, createNodesFromPathData2);
                        }
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                    return PropertyValuesHolder.ofObject(str, pathDataEvaluator, createNodesFromPathData);
                }
                if (createNodesFromPathData2 != null) {
                    return PropertyValuesHolder.ofObject(str, new PathDataEvaluator(), createNodesFromPathData2);
                }
            }
            return null;
        }
        if (i6 == 3) {
            argbEvaluator = ArgbEvaluator.getInstance();
        } else {
            argbEvaluator = null;
        }
        if (z7) {
            if (z5) {
                if (i9 == 5) {
                    f7 = typedArray.getDimension(i7, 0.0f);
                } else {
                    f7 = typedArray.getFloat(i7, 0.0f);
                }
                if (z6) {
                    if (i10 == 5) {
                        f8 = typedArray.getDimension(i8, 0.0f);
                    } else {
                        f8 = typedArray.getFloat(i8, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f7, f8);
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, f7);
                }
            } else {
                if (i10 == 5) {
                    f6 = typedArray.getDimension(i8, 0.0f);
                } else {
                    f6 = typedArray.getFloat(i8, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, f6);
            }
            propertyValuesHolder = ofFloat;
        } else if (z5) {
            if (i9 == 5) {
                i12 = (int) typedArray.getDimension(i7, 0.0f);
            } else if (isColorType(i9)) {
                i12 = typedArray.getColor(i7, 0);
            } else {
                i12 = typedArray.getInt(i7, 0);
            }
            if (z6) {
                if (i10 == 5) {
                    i13 = (int) typedArray.getDimension(i8, 0.0f);
                } else if (isColorType(i10)) {
                    i13 = typedArray.getColor(i8, 0);
                } else {
                    i13 = typedArray.getInt(i8, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i12, i13);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i12);
            }
        } else if (z6) {
            if (i10 == 5) {
                i11 = (int) typedArray.getDimension(i8, 0.0f);
            } else if (isColorType(i10)) {
                i11 = typedArray.getColor(i8, 0);
            } else {
                i11 = typedArray.getInt(i8, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i11);
        }
        if (propertyValuesHolder != null && argbEvaluator != null) {
            propertyValuesHolder.setEvaluator(argbEvaluator);
        }
        return propertyValuesHolder;
    }

    private static int inferValueTypeFromValues(TypedArray typedArray, int i6, int i7) {
        boolean z5;
        int i8;
        int i9;
        TypedValue peekValue = typedArray.peekValue(i6);
        boolean z6 = true;
        if (peekValue != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            i8 = peekValue.type;
        } else {
            i8 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i7);
        if (peekValue2 == null) {
            z6 = false;
        }
        if (z6) {
            i9 = peekValue2.type;
        } else {
            i9 = 0;
        }
        if (!z5 || !isColorType(i8)) {
            if (!z6 || !isColorType(i9)) {
                return 0;
            }
            return 3;
        }
        return 3;
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, @AnimatorRes int i6) throws Resources.NotFoundException {
        return loadAnimator(context, resources, theme, i6, 1.0f);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, @AnimatorRes int i6, float f6) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i6);
                    return createAnimatorFromXml(context, resources, theme, xmlResourceParser, f6);
                } catch (XmlPullParserException e6) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i6));
                    notFoundException.initCause(e6);
                    throw notFoundException;
                }
            } catch (IOException e7) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i6));
                notFoundException2.initCause(e7);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f6, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR);
        TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        parseAnimatorFromTypeArray(valueAnimator, obtainAttributes, obtainAttributes2, f6, xmlPullParser);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            valueAnimator.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator;
    }
}
