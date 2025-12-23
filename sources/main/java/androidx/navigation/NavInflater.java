package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavOptions;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavInflater {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";
    private static final String TAG_ACTION = "action";
    private static final String TAG_ARGUMENT = "argument";
    private static final String TAG_DEEP_LINK = "deepLink";
    private static final String TAG_INCLUDE = "include";
    private static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal<>();
    private Context mContext;
    private NavigatorProvider mNavigatorProvider;

    @NonNull
    @SuppressLint({"ResourceType"})
    public NavGraph inflate(@NavigationRes int i6) {
        int next;
        Resources resources = this.mContext.getResources();
        XmlResourceParser xml = resources.getXml(i6);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e6) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i6) + " line " + xml.getLineNumber(), e6);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        NavDestination inflate = inflate(resources, xml, asAttributeSet, i6);
        if (inflate instanceof NavGraph) {
            return (NavGraph) inflate;
        }
        throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
    }

    private static NavType checkNavType(TypedValue typedValue, NavType navType, NavType navType2, String str, String str2) throws XmlPullParserException {
        if (navType == null || navType == navType2) {
            return navType != null ? navType : navType2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    private void inflateAction(@NonNull Resources resources, @NonNull NavDestination navDestination, @NonNull AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i6) throws IOException, XmlPullParserException {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavAction);
        int resourceId = obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_android_id, 0);
        NavAction navAction = new NavAction(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_destination, 0));
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.setLaunchSingleTop(obtainAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_launchSingleTop, false));
        builder.setPopUpTo(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popUpTo, -1), obtainAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToInclusive, false));
        builder.setEnterAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_enterAnim, -1));
        builder.setExitAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_exitAnim, -1));
        builder.setPopEnterAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popEnterAnim, -1));
        builder.setPopExitAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popExitAnim, -1));
        navAction.setNavOptions(builder.build());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && TAG_ARGUMENT.equals(xmlResourceParser.getName())) {
                inflateArgumentForBundle(resources, bundle, attributeSet, i6);
            }
        }
        if (!bundle.isEmpty()) {
            navAction.setDefaultArguments(bundle);
        }
        navDestination.putAction(resourceId, navAction);
        obtainAttributes.recycle();
    }

    @NonNull
    private NavArgument inflateArgument(@NonNull TypedArray typedArray, @NonNull Resources resources, int i6) throws XmlPullParserException {
        NavArgument.Builder builder = new NavArgument.Builder();
        builder.setIsNullable(typedArray.getBoolean(androidx.navigation.common.R.styleable.NavArgument_nullable, false));
        ThreadLocal<TypedValue> threadLocal = sTmpValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(androidx.navigation.common.R.styleable.NavArgument_argType);
        Object obj = null;
        NavType<?> fromArgType = string != null ? NavType.fromArgType(string, resources.getResourcePackageName(i6)) : null;
        int i7 = androidx.navigation.common.R.styleable.NavArgument_android_defaultValue;
        if (typedArray.getValue(i7, typedValue)) {
            NavType<Integer> navType = NavType.ReferenceType;
            if (fromArgType == navType) {
                int i8 = typedValue.resourceId;
                if (i8 != 0) {
                    obj = Integer.valueOf(i8);
                } else {
                    if (typedValue.type != 16 || typedValue.data != 0) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + fromArgType.getName() + ". Must be a reference to a resource.");
                    }
                    obj = 0;
                }
            } else {
                int i9 = typedValue.resourceId;
                if (i9 != 0) {
                    if (fromArgType != null) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + fromArgType.getName() + ". You must use a \"" + navType.getName() + "\" type to reference other resources.");
                    }
                    fromArgType = navType;
                    obj = Integer.valueOf(i9);
                } else if (fromArgType == NavType.StringType) {
                    obj = typedArray.getString(i7);
                } else {
                    int i10 = typedValue.type;
                    if (i10 == 3) {
                        String charSequence = typedValue.string.toString();
                        if (fromArgType == null) {
                            fromArgType = NavType.inferFromValue(charSequence);
                        }
                        obj = fromArgType.parseValue(charSequence);
                    } else if (i10 == 4) {
                        fromArgType = checkNavType(typedValue, fromArgType, NavType.FloatType, string, "float");
                        obj = Float.valueOf(typedValue.getFloat());
                    } else if (i10 == 5) {
                        fromArgType = checkNavType(typedValue, fromArgType, NavType.IntType, string, "dimension");
                        obj = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                    } else if (i10 == 18) {
                        fromArgType = checkNavType(typedValue, fromArgType, NavType.BoolType, string, "boolean");
                        obj = Boolean.valueOf(typedValue.data != 0);
                    } else {
                        if (i10 < 16 || i10 > 31) {
                            throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                        }
                        NavType<Float> navType2 = NavType.FloatType;
                        if (fromArgType == navType2) {
                            fromArgType = checkNavType(typedValue, fromArgType, navType2, string, "float");
                            obj = Float.valueOf(typedValue.data);
                        } else {
                            fromArgType = checkNavType(typedValue, fromArgType, NavType.IntType, string, "integer");
                            obj = Integer.valueOf(typedValue.data);
                        }
                    }
                }
            }
        }
        if (obj != null) {
            builder.setDefaultValue(obj);
        }
        if (fromArgType != null) {
            builder.setType(fromArgType);
        }
        return builder.build();
    }

    private void inflateArgumentForBundle(@NonNull Resources resources, @NonNull Bundle bundle, @NonNull AttributeSet attributeSet, int i6) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        NavArgument inflateArgument = inflateArgument(obtainAttributes, resources, i6);
        if (inflateArgument.isDefaultValuePresent()) {
            inflateArgument.putDefaultValue(string, bundle);
        }
        obtainAttributes.recycle();
    }

    private void inflateArgumentForDestination(@NonNull Resources resources, @NonNull NavDestination navDestination, @NonNull AttributeSet attributeSet, int i6) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        navDestination.addArgument(string, inflateArgument(obtainAttributes, resources, i6));
        obtainAttributes.recycle();
    }

    private void inflateDeepLink(@NonNull Resources resources, @NonNull NavDestination navDestination, @NonNull AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavDeepLink);
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_action);
        String string3 = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_mimeType);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        NavDeepLink.Builder builder = new NavDeepLink.Builder();
        if (string != null) {
            builder.setUriPattern(string.replace(APPLICATION_ID_PLACEHOLDER, this.mContext.getPackageName()));
        }
        if (!TextUtils.isEmpty(string2)) {
            builder.setAction(string2.replace(APPLICATION_ID_PLACEHOLDER, this.mContext.getPackageName()));
        }
        if (string3 != null) {
            builder.setMimeType(string3.replace(APPLICATION_ID_PLACEHOLDER, this.mContext.getPackageName()));
        }
        navDestination.addDeepLink(builder.build());
        obtainAttributes.recycle();
    }

    public NavInflater(@NonNull Context context, @NonNull NavigatorProvider navigatorProvider) {
        this.mContext = context;
        this.mNavigatorProvider = navigatorProvider;
    }

    @NonNull
    private NavDestination inflate(@NonNull Resources resources, @NonNull XmlResourceParser xmlResourceParser, @NonNull AttributeSet attributeSet, int i6) throws XmlPullParserException, IOException {
        int depth;
        Resources resources2;
        XmlResourceParser xmlResourceParser2;
        AttributeSet attributeSet2;
        int i7;
        NavDestination createDestination = this.mNavigatorProvider.getNavigator(xmlResourceParser.getName()).createDestination();
        createDestination.onInflate(this.mContext, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if (TAG_ARGUMENT.equals(name)) {
                    inflateArgumentForDestination(resources, createDestination, attributeSet, i6);
                } else if (TAG_DEEP_LINK.equals(name)) {
                    inflateDeepLink(resources, createDestination, attributeSet);
                } else {
                    if ("action".equals(name)) {
                        resources2 = resources;
                        xmlResourceParser2 = xmlResourceParser;
                        attributeSet2 = attributeSet;
                        i7 = i6;
                        inflateAction(resources2, createDestination, attributeSet2, xmlResourceParser2, i7);
                    } else {
                        resources2 = resources;
                        xmlResourceParser2 = xmlResourceParser;
                        attributeSet2 = attributeSet;
                        i7 = i6;
                        if (TAG_INCLUDE.equals(name) && (createDestination instanceof NavGraph)) {
                            TypedArray obtainAttributes = resources2.obtainAttributes(attributeSet2, R.styleable.NavInclude);
                            ((NavGraph) createDestination).addDestination(inflate(obtainAttributes.getResourceId(R.styleable.NavInclude_graph, 0)));
                            obtainAttributes.recycle();
                        } else if (createDestination instanceof NavGraph) {
                            ((NavGraph) createDestination).addDestination(inflate(resources2, xmlResourceParser2, attributeSet2, i7));
                        }
                    }
                    resources = resources2;
                    attributeSet = attributeSet2;
                    xmlResourceParser = xmlResourceParser2;
                    i6 = i7;
                }
                resources2 = resources;
                xmlResourceParser2 = xmlResourceParser;
                attributeSet2 = attributeSet;
                i7 = i6;
                resources = resources2;
                attributeSet = attributeSet2;
                xmlResourceParser = xmlResourceParser2;
                i6 = i7;
            }
        }
        return createDestination;
    }
}
