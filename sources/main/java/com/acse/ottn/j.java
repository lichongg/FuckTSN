package com.acse.ottn;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    public static final int f4645b = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f4647d = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f4649f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final int f4650g = 1;

    /* renamed from: h, reason: collision with root package name */
    public static final int f4651h = 2;

    /* renamed from: i, reason: collision with root package name */
    public static final int f4652i = 3;

    /* renamed from: j, reason: collision with root package name */
    public static final int f4653j = 4;

    /* renamed from: k, reason: collision with root package name */
    public static final int f4654k = 5;

    /* renamed from: l, reason: collision with root package name */
    public static final int f4655l = 6;

    /* renamed from: m, reason: collision with root package name */
    public static final int f4656m = 7;

    /* renamed from: n, reason: collision with root package name */
    public static final int f4657n = 0;

    /* renamed from: o, reason: collision with root package name */
    public static final int f4658o = 0;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f4644a = {android.R.attr.ordering};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f4646c = {android.R.attr.propertyName};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f4648e = {android.R.attr.interpolator, android.R.attr.duration, android.R.attr.startOffset, android.R.attr.repeatCount, android.R.attr.repeatMode, android.R.attr.valueFrom, android.R.attr.valueTo, android.R.attr.valueType};

    public static i a(Context context, int i6) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = context.getResources().getAnimation(i6);
                return a(context, (XmlPullParser) xmlResourceParser);
            } catch (IOException e6) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i6));
                notFoundException.initCause(e6);
                throw notFoundException;
            } catch (XmlPullParserException e7) {
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

    public static i a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return a(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    public static i a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, m mVar, int i6) throws XmlPullParserException, IOException {
        int i7;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        i iVar = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        iVar = a(context, attributeSet);
                    } else if (name.equals("animator")) {
                        iVar = a(context, attributeSet, null);
                    } else if (name.equals(l3.f4738h)) {
                        m mVar2 = new m();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4644a);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        a(context, xmlPullParser, attributeSet, mVar2, typedValue.type == 16 ? typedValue.data : 0);
                        obtainStyledAttributes.recycle();
                        iVar = mVar2;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (mVar != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(iVar);
                    }
                }
            }
        }
        if (mVar != null && arrayList != null) {
            i[] iVarArr = new i[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                iVarArr[i7] = (i) it.next();
                i7++;
            }
            if (i6 == 0) {
                mVar.b(iVarArr);
                return iVar;
            }
            mVar.a(iVarArr);
        }
        return iVar;
    }

    public static v2 a(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        v2 v2Var = new v2();
        a(context, attributeSet, v2Var);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4646c);
        v2Var.b(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return v2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.acse.ottn.n4 a(android.content.Context r18, android.util.AttributeSet r19, com.acse.ottn.n4 r20) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.j.a(android.content.Context, android.util.AttributeSet, com.acse.ottn.n4):com.acse.ottn.n4");
    }
}
