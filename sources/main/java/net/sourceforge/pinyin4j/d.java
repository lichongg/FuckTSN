package net.sourceforge.pinyin4j;

import kotlin.text.v0;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class d {
    static String b(String str, net.sourceforge.pinyin4j.format.b bVar) throws BadHanyuPinyinOutputFormatCombination {
        net.sourceforge.pinyin4j.format.c cVar = net.sourceforge.pinyin4j.format.c.f50432d;
        if (cVar == bVar.b() && (net.sourceforge.pinyin4j.format.d.f50435c == bVar.c() || net.sourceforge.pinyin4j.format.d.f50434b == bVar.c())) {
            throw new BadHanyuPinyinOutputFormatCombination("tone marks cannot be added to v or u:");
        }
        if (net.sourceforge.pinyin4j.format.c.f50431c == bVar.b()) {
            str = str.replaceAll("[1-5]", "");
        } else if (cVar == bVar.b()) {
            str = a(str.replaceAll("u:", "v"));
        }
        if (net.sourceforge.pinyin4j.format.d.f50435c == bVar.c()) {
            str = str.replaceAll("u:", "v");
        } else if (net.sourceforge.pinyin4j.format.d.f50436d == bVar.c()) {
            str = str.replaceAll("u:", "ü");
        }
        return net.sourceforge.pinyin4j.format.a.f50424b == bVar.a() ? str.toUpperCase() : str;
    }

    d() {
    }

    private static String a(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.matches("[a-z]*[1-5]?")) {
            if (lowerCase.matches("[a-z]*[1-5]")) {
                int numericValue = Character.getNumericValue(lowerCase.charAt(lowerCase.length() - 1));
                char c6 = 'a';
                int indexOf = lowerCase.indexOf(97);
                int indexOf2 = lowerCase.indexOf(101);
                int indexOf3 = lowerCase.indexOf("ou");
                if (-1 == indexOf) {
                    if (-1 != indexOf2) {
                        indexOf = indexOf2;
                        c6 = 'e';
                    } else if (-1 != indexOf3) {
                        c6 = "ou".charAt(0);
                        indexOf = indexOf3;
                    } else {
                        indexOf = lowerCase.length() - 1;
                        while (true) {
                            if (indexOf >= 0) {
                                if (String.valueOf(lowerCase.charAt(indexOf)).matches("[aeiouv]")) {
                                    c6 = lowerCase.charAt(indexOf);
                                    break;
                                }
                                indexOf--;
                            } else {
                                c6 = v0.f47959c;
                                indexOf = -1;
                                break;
                            }
                        }
                    }
                }
                if ('$' != c6 && -1 != indexOf) {
                    return lowerCase.substring(0, indexOf).replaceAll("v", "ü") + "āáăàaēéĕèeīíĭìiōóŏòoūúŭùuǖǘǚǜü".charAt(("aeiouv".indexOf(c6) * 5) + (numericValue - 1)) + lowerCase.substring(indexOf + 1, lowerCase.length() - 1).replaceAll("v", "ü");
                }
                return lowerCase;
            }
            return lowerCase.replaceAll("v", "ü");
        }
        return lowerCase;
    }
}
