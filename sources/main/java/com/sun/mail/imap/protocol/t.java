package com.sun.mail.imap.protocol;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.search.AddressTerm;
import javax.mail.search.AndTerm;
import javax.mail.search.BodyTerm;
import javax.mail.search.DateTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.HeaderTerm;
import javax.mail.search.MessageIDTerm;
import javax.mail.search.NotTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.RecipientStringTerm;
import javax.mail.search.RecipientTerm;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;
import javax.mail.search.SentDateTerm;
import javax.mail.search.SizeTerm;
import javax.mail.search.StringTerm;
import javax.mail.search.SubjectTerm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class t {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f39499a = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /* renamed from: b, reason: collision with root package name */
    private static Calendar f39500b = new GregorianCalendar();

    private static com.sun.mail.iap.b b(BodyTerm bodyTerm, String str) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("BODY");
        bVar.p(bodyTerm.getPattern(), str);
        return bVar;
    }

    private static com.sun.mail.iap.b d(String str, String str2) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("FROM");
        bVar.p(str, str2);
        return bVar;
    }

    static com.sun.mail.iap.b e(SearchTerm searchTerm, String str) throws SearchException, IOException {
        if (searchTerm instanceof AndTerm) {
            return a((AndTerm) searchTerm, str);
        }
        if (searchTerm instanceof OrTerm) {
            return k((OrTerm) searchTerm, str);
        }
        if (searchTerm instanceof NotTerm) {
            return j((NotTerm) searchTerm, str);
        }
        if (searchTerm instanceof HeaderTerm) {
            return f((HeaderTerm) searchTerm, str);
        }
        if (searchTerm instanceof FlagTerm) {
            return c((FlagTerm) searchTerm);
        }
        if (searchTerm instanceof FromTerm) {
            return d(((FromTerm) searchTerm).getAddress().toString(), str);
        }
        if (searchTerm instanceof FromStringTerm) {
            return d(((FromStringTerm) searchTerm).getPattern(), str);
        }
        if (searchTerm instanceof RecipientTerm) {
            RecipientTerm recipientTerm = (RecipientTerm) searchTerm;
            return m(recipientTerm.getRecipientType(), recipientTerm.getAddress().toString(), str);
        }
        if (searchTerm instanceof RecipientStringTerm) {
            RecipientStringTerm recipientStringTerm = (RecipientStringTerm) searchTerm;
            return m(recipientStringTerm.getRecipientType(), recipientStringTerm.getPattern(), str);
        }
        if (searchTerm instanceof SubjectTerm) {
            return p((SubjectTerm) searchTerm, str);
        }
        if (searchTerm instanceof BodyTerm) {
            return b((BodyTerm) searchTerm, str);
        }
        if (searchTerm instanceof SizeTerm) {
            return o((SizeTerm) searchTerm);
        }
        if (searchTerm instanceof SentDateTerm) {
            return n((SentDateTerm) searchTerm);
        }
        if (searchTerm instanceof ReceivedDateTerm) {
            return l((ReceivedDateTerm) searchTerm);
        }
        if (searchTerm instanceof MessageIDTerm) {
            return i((MessageIDTerm) searchTerm, str);
        }
        throw new SearchException("Search too complex");
    }

    private static com.sun.mail.iap.b f(HeaderTerm headerTerm, String str) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("HEADER");
        bVar.o(headerTerm.getHeaderName());
        bVar.p(headerTerm.getPattern(), str);
        return bVar;
    }

    static boolean h(SearchTerm searchTerm) {
        boolean z5 = searchTerm instanceof AndTerm;
        if (z5 || (searchTerm instanceof OrTerm)) {
            for (SearchTerm searchTerm2 : z5 ? ((AndTerm) searchTerm).getTerms() : ((OrTerm) searchTerm).getTerms()) {
                if (!h(searchTerm2)) {
                    return false;
                }
            }
            return true;
        }
        if (searchTerm instanceof NotTerm) {
            return h(((NotTerm) searchTerm).getTerm());
        }
        if (searchTerm instanceof StringTerm) {
            return g(((StringTerm) searchTerm).getPattern());
        }
        if (searchTerm instanceof AddressTerm) {
            return g(((AddressTerm) searchTerm).getAddress().toString());
        }
        return true;
    }

    private static com.sun.mail.iap.b i(MessageIDTerm messageIDTerm, String str) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("HEADER");
        bVar.o("Message-ID");
        bVar.p(messageIDTerm.getPattern(), str);
        return bVar;
    }

    private static com.sun.mail.iap.b j(NotTerm notTerm, String str) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("NOT");
        SearchTerm term = notTerm.getTerm();
        if ((term instanceof AndTerm) || (term instanceof FlagTerm)) {
            bVar.h(e(term, str));
            return bVar;
        }
        bVar.a(e(term, str));
        return bVar;
    }

    private static com.sun.mail.iap.b l(DateTerm dateTerm) throws SearchException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        String q5 = q(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                bVar.i("OR BEFORE " + q5 + " ON " + q5);
                return bVar;
            case 2:
                bVar.i("BEFORE " + q5);
                return bVar;
            case 3:
                bVar.i("ON " + q5);
                return bVar;
            case 4:
                bVar.i("NOT ON " + q5);
                return bVar;
            case 5:
                bVar.i("SINCE " + q5);
                return bVar;
            case 6:
                bVar.i("OR SINCE " + q5 + " ON " + q5);
                return bVar;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
    }

    private static com.sun.mail.iap.b m(Message.RecipientType recipientType, String str, String str2) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        if (recipientType == Message.RecipientType.TO) {
            bVar.i("TO");
        } else if (recipientType == Message.RecipientType.CC) {
            bVar.i("CC");
        } else {
            if (recipientType != Message.RecipientType.BCC) {
                throw new SearchException("Illegal Recipient type");
            }
            bVar.i("BCC");
        }
        bVar.p(str, str2);
        return bVar;
    }

    private static com.sun.mail.iap.b n(DateTerm dateTerm) throws SearchException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        String q5 = q(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                bVar.i("OR SENTBEFORE " + q5 + " SENTON " + q5);
                return bVar;
            case 2:
                bVar.i("SENTBEFORE " + q5);
                return bVar;
            case 3:
                bVar.i("SENTON " + q5);
                return bVar;
            case 4:
                bVar.i("NOT SENTON " + q5);
                return bVar;
            case 5:
                bVar.i("SENTSINCE " + q5);
                return bVar;
            case 6:
                bVar.i("OR SENTSINCE " + q5 + " SENTON " + q5);
                return bVar;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
    }

    private static com.sun.mail.iap.b o(SizeTerm sizeTerm) throws SearchException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        int comparison = sizeTerm.getComparison();
        if (comparison == 2) {
            bVar.i("SMALLER");
        } else {
            if (comparison != 5) {
                throw new SearchException("Cannot handle Comparison");
            }
            bVar.i("LARGER");
        }
        bVar.m(sizeTerm.getNumber());
        return bVar;
    }

    private static com.sun.mail.iap.b p(SubjectTerm subjectTerm, String str) throws SearchException, IOException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i("SUBJECT");
        bVar.p(subjectTerm.getPattern(), str);
        return bVar;
    }

    private static String q(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        f39500b.setTime(date);
        stringBuffer.append(f39500b.get(5));
        stringBuffer.append("-");
        stringBuffer.append(f39499a[f39500b.get(2)]);
        stringBuffer.append('-');
        stringBuffer.append(f39500b.get(1));
        return stringBuffer.toString();
    }

    t() {
    }

    private static com.sun.mail.iap.b a(AndTerm andTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = andTerm.getTerms();
        com.sun.mail.iap.b e6 = e(terms[0], str);
        for (int i6 = 1; i6 < terms.length; i6++) {
            e6.a(e(terms[i6], str));
        }
        return e6;
    }

    private static com.sun.mail.iap.b c(FlagTerm flagTerm) throws SearchException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean testSet = flagTerm.getTestSet();
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        Flags flags = flagTerm.getFlags();
        Flags.Flag[] systemFlags = flags.getSystemFlags();
        String[] userFlags = flags.getUserFlags();
        if (systemFlags.length == 0 && userFlags.length == 0) {
            throw new SearchException("Invalid FlagTerm");
        }
        for (Flags.Flag flag : systemFlags) {
            if (flag == Flags.Flag.DELETED) {
                if (testSet) {
                    str7 = "DELETED";
                } else {
                    str7 = "UNDELETED";
                }
                bVar.i(str7);
            } else if (flag == Flags.Flag.ANSWERED) {
                if (testSet) {
                    str6 = "ANSWERED";
                } else {
                    str6 = "UNANSWERED";
                }
                bVar.i(str6);
            } else if (flag == Flags.Flag.DRAFT) {
                if (testSet) {
                    str5 = "DRAFT";
                } else {
                    str5 = "UNDRAFT";
                }
                bVar.i(str5);
            } else if (flag == Flags.Flag.FLAGGED) {
                if (testSet) {
                    str4 = "FLAGGED";
                } else {
                    str4 = "UNFLAGGED";
                }
                bVar.i(str4);
            } else if (flag == Flags.Flag.RECENT) {
                if (testSet) {
                    str3 = "RECENT";
                } else {
                    str3 = "OLD";
                }
                bVar.i(str3);
            } else if (flag == Flags.Flag.SEEN) {
                if (testSet) {
                    str2 = "SEEN";
                } else {
                    str2 = "UNSEEN";
                }
                bVar.i(str2);
            }
        }
        for (String str8 : userFlags) {
            if (testSet) {
                str = "KEYWORD";
            } else {
                str = "UNKEYWORD";
            }
            bVar.i(str);
            bVar.i(str8);
        }
        return bVar;
    }

    private static boolean g(String str) {
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (str.charAt(i6) > 127) {
                return false;
            }
        }
        return true;
    }

    private static com.sun.mail.iap.b k(OrTerm orTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = orTerm.getTerms();
        if (terms.length > 2) {
            SearchTerm searchTerm = terms[0];
            int i6 = 1;
            while (i6 < terms.length) {
                OrTerm orTerm2 = new OrTerm(searchTerm, terms[i6]);
                i6++;
                searchTerm = orTerm2;
            }
            terms = ((OrTerm) searchTerm).getTerms();
        }
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        if (terms.length > 1) {
            bVar.i("OR");
        }
        SearchTerm searchTerm2 = terms[0];
        if (!(searchTerm2 instanceof AndTerm) && !(searchTerm2 instanceof FlagTerm)) {
            bVar.a(e(searchTerm2, str));
        } else {
            bVar.h(e(searchTerm2, str));
        }
        if (terms.length > 1) {
            SearchTerm searchTerm3 = terms[1];
            if (!(searchTerm3 instanceof AndTerm) && !(searchTerm3 instanceof FlagTerm)) {
                bVar.a(e(searchTerm3, str));
                return bVar;
            }
            bVar.h(e(searchTerm3, str));
        }
        return bVar;
    }
}
