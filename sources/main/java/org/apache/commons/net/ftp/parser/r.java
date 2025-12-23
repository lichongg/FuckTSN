package org.apache.commons.net.ftp.parser;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class r extends q {

    /* renamed from: j, reason: collision with root package name */
    private static final String f50792j = "(.*?);([0-9]+)\\s*.*";

    /* renamed from: i, reason: collision with root package name */
    private final Pattern f50793i;

    public r() {
        this(null);
    }

    @Override // org.apache.commons.net.ftp.parser.q
    protected boolean n() {
        return true;
    }

    public r(org.apache.commons.net.ftp.d dVar) {
        c(dVar);
        try {
            this.f50793i = Pattern.compile(f50792j);
        } catch (PatternSyntaxException unused) {
            throw new IllegalArgumentException("Unparseable regex supplied:  (.*?);([0-9]+)\\s*.*");
        }
    }

    @Override // org.apache.commons.net.ftp.g, org.apache.commons.net.ftp.f
    public List<String> d(List<String> list) {
        HashMap hashMap = new HashMap();
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Matcher matcher = this.f50793i.matcher(listIterator.next().trim());
            if (matcher.matches()) {
                MatchResult matchResult = matcher.toMatchResult();
                String group = matchResult.group(1);
                Integer valueOf = Integer.valueOf(matchResult.group(2));
                Integer num = (Integer) hashMap.get(group);
                if (num == null || valueOf.intValue() >= num.intValue()) {
                    hashMap.put(group, valueOf);
                } else {
                    listIterator.remove();
                }
            }
        }
        while (listIterator.hasPrevious()) {
            Matcher matcher2 = this.f50793i.matcher(listIterator.previous().trim());
            if (matcher2.matches()) {
                MatchResult matchResult2 = matcher2.toMatchResult();
                String group2 = matchResult2.group(1);
                Integer valueOf2 = Integer.valueOf(matchResult2.group(2));
                Integer num2 = (Integer) hashMap.get(group2);
                if (num2 != null && valueOf2.intValue() < num2.intValue()) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }
}
