package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavDeepLink {
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private final String mAction;
    private final ArrayList<String> mArguments;
    private boolean mExactDeepLink;
    private boolean mIsParameterizedQuery;
    private final String mMimeType;
    private Pattern mMimeTypePattern;
    private final Map<String, ParamQuery> mParamArgMap;
    private Pattern mPattern;
    private final String mUri;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        private String mAction;
        private String mMimeType;
        private String mUriPattern;

        @NonNull
        public static Builder fromMimeType(@NonNull String str) {
            Builder builder = new Builder();
            builder.setMimeType(str);
            return builder;
        }

        @NonNull
        public static Builder fromUriPattern(@NonNull String str) {
            Builder builder = new Builder();
            builder.setUriPattern(str);
            return builder;
        }

        @NonNull
        public NavDeepLink build() {
            return new NavDeepLink(this.mUriPattern, this.mAction, this.mMimeType);
        }

        @NonNull
        public Builder setMimeType(@NonNull String str) {
            this.mMimeType = str;
            return this;
        }

        @NonNull
        public Builder setUriPattern(@NonNull String str) {
            this.mUriPattern = str;
            return this;
        }

        Builder() {
        }

        @NonNull
        public static Builder fromAction(@NonNull String str) {
            if (!str.isEmpty()) {
                Builder builder = new Builder();
                builder.setAction(str);
                return builder;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        @NonNull
        public Builder setAction(@NonNull String str) {
            if (!str.isEmpty()) {
                this.mAction = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class MimeType implements Comparable<MimeType> {
        String mSubType;
        String mType;

        @Override // java.lang.Comparable
        public int compareTo(@NonNull MimeType mimeType) {
            int i6 = this.mType.equals(mimeType.mType) ? 2 : 0;
            return this.mSubType.equals(mimeType.mSubType) ? i6 + 1 : i6;
        }

        MimeType(@NonNull String str) {
            String[] split = str.split("/", -1);
            this.mType = split[0];
            this.mSubType = split[1];
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ParamQuery {
        private ArrayList<String> mArguments = new ArrayList<>();
        private String mParamRegex;

        void addArgumentName(String str) {
            this.mArguments.add(str);
        }

        String getArgumentName(int i6) {
            return this.mArguments.get(i6);
        }

        String getParamRegex() {
            return this.mParamRegex;
        }

        void setParamRegex(String str) {
            this.mParamRegex = str;
        }

        public int size() {
            return this.mArguments.size();
        }

        ParamQuery() {
        }
    }

    NavDeepLink(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.mArguments = new ArrayList<>();
        this.mParamArgMap = new HashMap();
        this.mPattern = null;
        this.mExactDeepLink = false;
        this.mIsParameterizedQuery = false;
        this.mMimeTypePattern = null;
        this.mUri = str;
        this.mAction = str2;
        this.mMimeType = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.mIsParameterizedQuery = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!SCHEME_PATTERN.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.mIsParameterizedQuery) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    buildPathRegex(str.substring(0, matcher.start()), sb, compile);
                }
                this.mExactDeepLink = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    ParamQuery paramQuery = new ParamQuery();
                    int i6 = 0;
                    while (matcher2.find()) {
                        paramQuery.addArgumentName(matcher2.group(1));
                        sb2.append(Pattern.quote(queryParameter.substring(i6, matcher2.start())));
                        sb2.append("(.+?)?");
                        i6 = matcher2.end();
                    }
                    if (i6 < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(i6)));
                    }
                    paramQuery.setParamRegex(sb2.toString().replace(".*", "\\E.*\\Q"));
                    this.mParamArgMap.put(str4, paramQuery);
                }
            } else {
                this.mExactDeepLink = buildPathRegex(str, sb, compile);
            }
            this.mPattern = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"), 2);
        }
        if (str3 != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                throw new IllegalArgumentException("The given mimeType " + str3 + " does not match to required \"type/subtype\" format");
            }
            MimeType mimeType = new MimeType(str3);
            this.mMimeTypePattern = Pattern.compile(("^(" + mimeType.mType + "|[*]+)/(" + mimeType.mSubType + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
        }
    }

    private boolean matchAction(String str) {
        boolean z5 = str == null;
        String str2 = this.mAction;
        if (z5 == (str2 != null)) {
            return false;
        }
        return str == null || str2.equals(str);
    }

    private boolean matchMimeType(String str) {
        if ((str == null) == (this.mMimeType != null)) {
            return false;
        }
        return str == null || this.mMimeTypePattern.matcher(str).matches();
    }

    private boolean matchUri(Uri uri) {
        boolean z5 = uri == null;
        Pattern pattern = this.mPattern;
        if (z5 == (pattern != null)) {
            return false;
        }
        return uri == null || pattern.matcher(uri.toString()).matches();
    }

    boolean matches(@NonNull Uri uri) {
        return matches(new NavDeepLinkRequest(uri, null, null));
    }

    private boolean parseArgument(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument == null) {
            bundle.putString(str, str2);
            return false;
        }
        try {
            navArgument.getType().parseAndPut(bundle, str, str2);
            return false;
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    @Nullable
    public String getAction() {
        return this.mAction;
    }

    @Nullable
    Bundle getMatchingArguments(@NonNull Uri uri, @NonNull Map<String, NavArgument> map) {
        Matcher matcher;
        Matcher matcher2 = this.mPattern.matcher(uri.toString());
        if (!matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.mArguments.size();
        int i6 = 0;
        while (i6 < size) {
            String str = this.mArguments.get(i6);
            i6++;
            if (parseArgument(bundle, str, Uri.decode(matcher2.group(i6)), map.get(str))) {
                return null;
            }
        }
        if (this.mIsParameterizedQuery) {
            for (String str2 : this.mParamArgMap.keySet()) {
                ParamQuery paramQuery = this.mParamArgMap.get(str2);
                String queryParameter = uri.getQueryParameter(str2);
                if (queryParameter != null) {
                    matcher = Pattern.compile(paramQuery.getParamRegex()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                for (int i7 = 0; i7 < paramQuery.size(); i7++) {
                    String decode = matcher != null ? Uri.decode(matcher.group(i7 + 1)) : null;
                    String argumentName = paramQuery.getArgumentName(i7);
                    NavArgument navArgument = map.get(argumentName);
                    if (decode != null && !decode.replaceAll("[{}]", "").equals(argumentName) && parseArgument(bundle, argumentName, decode, navArgument)) {
                        return null;
                    }
                }
            }
        }
        return bundle;
    }

    @Nullable
    public String getMimeType() {
        return this.mMimeType;
    }

    int getMimeTypeMatchRating(@NonNull String str) {
        if (this.mMimeType == null || !this.mMimeTypePattern.matcher(str).matches()) {
            return -1;
        }
        return new MimeType(this.mMimeType).compareTo(new MimeType(str));
    }

    @Nullable
    public String getUriPattern() {
        return this.mUri;
    }

    boolean isExactDeepLink() {
        return this.mExactDeepLink;
    }

    boolean matches(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        if (matchUri(navDeepLinkRequest.getUri()) && matchAction(navDeepLinkRequest.getAction())) {
            return matchMimeType(navDeepLinkRequest.getMimeType());
        }
        return false;
    }

    private boolean buildPathRegex(@NonNull String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z5 = !str.contains(".*");
        int i6 = 0;
        while (matcher.find()) {
            this.mArguments.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i6, matcher.start())));
            sb.append("(.+?)");
            i6 = matcher.end();
            z5 = false;
        }
        if (i6 < str.length()) {
            sb.append(Pattern.quote(str.substring(i6)));
        }
        sb.append("($|(\\?(.)*))");
        return z5;
    }

    NavDeepLink(@NonNull String str) {
        this(str, null, null);
    }
}
