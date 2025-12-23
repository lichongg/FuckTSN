package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class HctSolver {
    static final double[][] SCALED_DISCOUNT_FROM_LINRGB = {new double[]{0.001200833568784504d, 0.002389694492170889d, 2.795742885861124E-4d}, new double[]{5.891086651375999E-4d, 0.0029785502573438758d, 3.270666104008398E-4d}, new double[]{1.0146692491640572E-4d, 5.364214359186694E-4d, 0.0032979401770712076d}};
    static final double[][] LINRGB_FROM_SCALED_DISCOUNT = {new double[]{1373.2198709594231d, -1100.4251190754821d, -7.278681089101213d}, new double[]{-271.815969077903d, 559.6580465940733d, -32.46047482791194d}, new double[]{1.9622899599665666d, -57.173814538844006d, 308.7233197812385d}};
    static final double[] Y_FROM_LINRGB = {0.2126d, 0.7152d, 0.0722d};
    static final double[] CRITICAL_PLANES = {0.015176349177441876d, 0.045529047532325624d, 0.07588174588720938d, 0.10623444424209313d, 0.13658714259697685d, 0.16693984095186062d, 0.19729253930674434d, 0.2276452376616281d, 0.2579979360165119d, 0.28835063437139563d, 0.3188300904430532d, 0.350925934958123d, 0.3848314933096426d, 0.42057480301049466d, 0.458183274052838d, 0.4976837250274023d, 0.5391024159806381d, 0.5824650784040898d, 0.6277969426914107d, 0.6751227633498623d, 0.7244668422128921d, 0.775853049866786d, 0.829304845476233d, 0.8848452951698498d, 0.942497089126609d, 1.0022825574869039d, 1.0642236851973577d, 1.1283421258858297d, 1.1946592148522128d, 1.2631959812511864d, 1.3339731595349034d, 1.407011200216447d, 1.4823302800086415d, 1.5599503113873272d, 1.6398909516233677d, 1.7221716113234105d, 1.8068114625156377d, 1.8938294463134073d, 1.9832442801866852d, 2.075074464868551d, 2.1693382909216234d, 2.2660538449872063d, 2.36523901573795d, 2.4669114995532007d, 2.5710888059345764d, 2.6777882626779785d, 2.7870270208169257d, 2.898822059350997d, 3.0131901897720907d, 3.1301480604002863d, 3.2497121605402226d, 3.3718988244681087d, 3.4967242352587946d, 3.624204428461639d, 3.754355295633311d, 3.887192587735158d, 4.022731918402185d, 4.160988767090289d, 4.301978482107941d, 4.445716283538092d, 4.592217266055746d, 4.741496401646282d, 4.893568542229298d, 5.048448422192488d, 5.20615066083972d, 5.3666897647573375d, 5.5300801301023865d, 5.696336044816294d, 5.865471690767354d, 6.037501145825082d, 6.212438385869475d, 6.390297286737924d, 6.571091626112461d, 6.7548350853498045d, 6.941541251256611d, 7.131223617812143d, 7.323895587840543d, 7.5195704746346665d, 7.7182615035334345d, 7.919981813454504d, 8.124744458384042d, 8.332562408825165d, 8.543448553206703d, 8.757415699253682d, 8.974476575321063d, 9.194643831691977d, 9.417930041841839d, 9.644347703669503d, 9.873909240696694d, 10.106627003236781d, 10.342513269534024d, 10.58158024687427d, 10.8238400726681d, 11.069304815507364d, 11.317986476196008d, 11.569896988756009d, 11.825048221409341d, 12.083451977536606d, 12.345119996613247d, 12.610063955123938d, 12.878295467455942d, 13.149826086772048d, 13.42466730586372d, 13.702830557985108d, 13.984327217668513d, 14.269168601521828d, 14.55736596900856d, 14.848930523210871d, 15.143873411576273d, 15.44220572664832d, 15.743938506781891d, 16.04908273684337d, 16.35764934889634d, 16.66964922287304d, 16.985093187232053d, 17.30399201960269d, 17.62635644741625d, 17.95219714852476d, 18.281524751807332d, 18.614349837764564d, 18.95068293910138d, 19.290534541298456d, 19.633915083172692d, 19.98083495742689d, 20.331304511189067d, 20.685334046541502d, 21.042933821039977d, 21.404114048223256d, 21.76888489811322d, 22.137256497705877d, 22.50923893145328d, 22.884842241736916d, 23.264076429332462d, 23.6469514538663d, 24.033477234264016d, 24.42366364919083d, 24.817520537484558d, 25.21505769858089d, 25.61628489293138d, 26.021211842414342d, 26.429848230738664d, 26.842203703840827d, 27.258287870275353d, 27.678110301598522d, 28.10168053274597d, 28.529008062403893d, 28.96010235337422d, 29.39497283293396d, 29.83362889318845d, 30.276079891419332d, 30.722335150426627d, 31.172403958865512d, 31.62629557157785d, 32.08401920991837d, 32.54558406207592d, 33.010999283389665d, 33.4802739966603d, 33.953417292456834d, 34.430438229418264d, 34.911345834551085d, 35.39614910352207d, 35.88485700094671d, 36.37747846067349d, 36.87402238606382d, 37.37449765026789d, 37.87891309649659d, 38.38727753828926d, 38.89959975977785d, 39.41588851594697d, 39.93615253289054d, 40.460400508064545d, 40.98864111053629d, 41.520882981230194d, 42.05713473317016d, 42.597404951718396d, 43.141702194811224d, 43.6900349931913d, 44.24241185063697d, 44.798841244188324d, 45.35933162437017d, 45.92389141541209d, 46.49252901546552d, 47.065252796817916d, 47.64207110610409d, 48.22299226451468d, 48.808024568002054d, 49.3971762874833d, 49.9904556690408d, 50.587870934119984d, 51.189430279724725d, 51.79514187861014d, 52.40501387947288d, 53.0190544071392d, 53.637271562750364d, 54.259673423945976d, 54.88626804504493d, 55.517063457223934d, 56.15206766869424d, 56.79128866487574d, 57.43473440856916d, 58.08241284012621d, 58.734331877617365d, 59.39049941699807d, 60.05092333227251d, 60.715611475655585d, 61.38457167773311d, 62.057811747619894d, 62.7353394731159d, 63.417162620860914d, 64.10328893648692d, 64.79372614476921d, 65.48848194977529d, 66.18756403501224d, 66.89098006357258d, 67.59873767827808d, 68.31084450182222d, 69.02730813691093d, 69.74813616640164d, 70.47333615344107d, 71.20291564160104d, 71.93688215501312d, 72.67524319850172d, 73.41800625771542d, 74.16517879925733d, 74.9167682708136d, 75.67278210128072d, 76.43322770089146d, 77.1981124613393d, 77.96744375590167d, 78.74122893956174d, 79.51947534912904d, 80.30219030335869d, 81.08938110306934d, 81.88105503125999d, 82.67721935322541d, 83.4778813166706d, 84.28304815182372d, 85.09272707154808d, 85.90692527145302d, 86.72564993000343d, 87.54890820862819d, 88.3767072518277d, 89.2090541872801d, 90.04595612594655d, 90.88742016217518d, 91.73345337380438d, 92.58406282226491d, 93.43925555268066d, 94.29903859396902d, 95.16341895893969d, 96.03240364439274d, 96.9059996312159d, 97.78421388448044d, 98.6670533535366d, 99.55452497210776d};

    static boolean areInCyclicOrder(double d6, double d7, double d8) {
        return sanitizeRadians(d7 - d6) < sanitizeRadians(d8 - d6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (areInCyclicOrder(r10, r12, r14) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static double[][] bisectToSegment(double r20, double r22) {
        /*
            r0 = 3
            double[] r0 = new double[r0]
            r1 = 0
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r0[r1] = r2
            r4 = 1
            r0[r4] = r2
            r5 = 2
            r0[r5] = r2
            r2 = 0
            r6 = r0
            r10 = r2
            r14 = r10
            r7 = 0
            r8 = 0
            r9 = 1
        L16:
            r12 = 12
            if (r7 >= r12) goto L5f
            r12 = r20
            double[] r16 = nthVertex(r12, r7)
            r17 = r16[r1]
            int r19 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r19 >= 0) goto L29
            r18 = r14
            goto L44
        L29:
            double r12 = hueOf(r16)
            if (r8 != 0) goto L36
            r10 = r12
            r14 = r10
            r0 = r16
            r6 = r0
            r8 = 1
            goto L5c
        L36:
            if (r9 != 0) goto L47
            boolean r17 = areInCyclicOrder(r10, r12, r14)
            r18 = r14
            if (r17 == 0) goto L44
        L40:
            r14 = r12
            r12 = r22
            goto L4a
        L44:
            r14 = r18
            goto L5c
        L47:
            r18 = r14
            goto L40
        L4a:
            boolean r9 = areInCyclicOrder(r10, r12, r14)
            r12 = r14
            if (r9 == 0) goto L56
            r14 = r12
            r6 = r16
        L54:
            r9 = 0
            goto L5c
        L56:
            r10 = r12
            r0 = r16
            r14 = r18
            goto L54
        L5c:
            int r7 = r7 + 1
            goto L16
        L5f:
            double[][] r2 = new double[r5][]
            r2[r1] = r0
            r2[r4] = r6
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.HctSolver.bisectToSegment(double, double):double[][]");
    }

    static double intercept(double d6, double d7, double d8) {
        return (d7 - d6) / (d8 - d6);
    }

    static double[] lerpPoint(double[] dArr, double d6, double[] dArr2) {
        double d7 = dArr[0];
        double d8 = d7 + ((dArr2[0] - d7) * d6);
        double d9 = dArr[1];
        double d10 = d9 + ((dArr2[1] - d9) * d6);
        double d11 = dArr[2];
        return new double[]{d8, d10, d11 + ((dArr2[2] - d11) * d6)};
    }

    static double[] midpoint(double[] dArr, double[] dArr2) {
        return new double[]{(dArr[0] + dArr2[0]) / 2.0d, (dArr[1] + dArr2[1]) / 2.0d, (dArr[2] + dArr2[2]) / 2.0d};
    }

    static int criticalPlaneAbove(double d6) {
        return (int) Math.ceil(d6 - 0.5d);
    }

    static int criticalPlaneBelow(double d6) {
        return (int) Math.floor(d6 - 0.5d);
    }

    static double hueOf(double[] dArr) {
        double[] matrixMultiply = MathUtils.matrixMultiply(dArr, SCALED_DISCOUNT_FROM_LINRGB);
        double chromaticAdaptation = chromaticAdaptation(matrixMultiply[0]);
        double chromaticAdaptation2 = chromaticAdaptation(matrixMultiply[1]);
        double chromaticAdaptation3 = chromaticAdaptation(matrixMultiply[2]);
        return Math.atan2(((chromaticAdaptation + chromaticAdaptation2) - (chromaticAdaptation3 * 2.0d)) / 9.0d, (((chromaticAdaptation * 11.0d) + ((-12.0d) * chromaticAdaptation2)) + chromaticAdaptation3) / 11.0d);
    }

    static boolean isBounded(double d6) {
        return 0.0d <= d6 && d6 <= 100.0d;
    }

    static double[] nthVertex(double d6, int i6) {
        double[] dArr = Y_FROM_LINRGB;
        double d7 = dArr[0];
        double d8 = dArr[1];
        double d9 = dArr[2];
        double d10 = i6 % 4 <= 1 ? 0.0d : 100.0d;
        double d11 = i6 % 2 == 0 ? 0.0d : 100.0d;
        if (i6 < 4) {
            double d12 = ((d6 - (d8 * d10)) - (d9 * d11)) / d7;
            return isBounded(d12) ? new double[]{d12, d10, d11} : new double[]{-1.0d, -1.0d, -1.0d};
        }
        if (i6 < 8) {
            double d13 = ((d6 - (d7 * d11)) - (d9 * d10)) / d8;
            return isBounded(d13) ? new double[]{d11, d13, d10} : new double[]{-1.0d, -1.0d, -1.0d};
        }
        double d14 = ((d6 - (d7 * d10)) - (d8 * d11)) / d9;
        return isBounded(d14) ? new double[]{d10, d11, d14} : new double[]{-1.0d, -1.0d, -1.0d};
    }

    static double[] setCoordinate(double[] dArr, double d6, double[] dArr2, int i6) {
        return lerpPoint(dArr, intercept(dArr[i6], d6, dArr2[i6]), dArr2);
    }

    static double trueDelinearized(double d6) {
        double d7 = d6 / 100.0d;
        return (d7 <= 0.0031308d ? d7 * 12.92d : (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d;
    }

    private HctSolver() {
    }

    static double[] bisectToLimit(double d6, double d7) {
        int criticalPlaneAbove;
        int criticalPlaneBelow;
        double[][] bisectToSegment = bisectToSegment(d6, d7);
        double[] dArr = bisectToSegment[0];
        double hueOf = hueOf(dArr);
        double[] dArr2 = bisectToSegment[1];
        for (int i6 = 0; i6 < 3; i6++) {
            double d8 = dArr[i6];
            double d9 = dArr2[i6];
            if (d8 != d9) {
                if (d8 < d9) {
                    criticalPlaneAbove = criticalPlaneBelow(trueDelinearized(d8));
                    criticalPlaneBelow = criticalPlaneAbove(trueDelinearized(dArr2[i6]));
                } else {
                    criticalPlaneAbove = criticalPlaneAbove(trueDelinearized(d8));
                    criticalPlaneBelow = criticalPlaneBelow(trueDelinearized(dArr2[i6]));
                }
                double d10 = hueOf;
                int i7 = criticalPlaneAbove;
                int i8 = criticalPlaneBelow;
                double d11 = d10;
                for (int i9 = 0; i9 < 8 && Math.abs(i8 - i7) > 1; i9++) {
                    int floor = (int) Math.floor((i7 + i8) / 2.0d);
                    double[] coordinate = setCoordinate(dArr, CRITICAL_PLANES[floor], dArr2, i6);
                    double hueOf2 = hueOf(coordinate);
                    if (areInCyclicOrder(d11, d7, hueOf2)) {
                        i8 = floor;
                        dArr2 = coordinate;
                    } else {
                        d11 = hueOf2;
                        i7 = floor;
                        dArr = coordinate;
                    }
                }
                hueOf = d11;
            }
        }
        return midpoint(dArr, dArr2);
    }

    static double chromaticAdaptation(double d6) {
        double pow = Math.pow(Math.abs(d6), 0.42d);
        return ((MathUtils.signum(d6) * 400.0d) * pow) / (pow + 27.13d);
    }

    static int findResultByJ(double d6, double d7, double d8) {
        double d9;
        double sqrt = Math.sqrt(d8) * 11.0d;
        ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
        double d10 = 1.0d;
        double pow = 1.0d / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d);
        double d11 = 2.0d;
        double cos = (Math.cos(d6 + 2.0d) + 3.8d) * 0.25d * 3846.153846153846d * viewingConditions.getNc() * viewingConditions.getNcb();
        double sin = Math.sin(d6);
        double cos2 = Math.cos(d6);
        int i6 = 0;
        while (i6 < 5) {
            double d12 = d10;
            double d13 = sqrt / 100.0d;
            if (d7 != 0.0d && sqrt != 0.0d) {
                d9 = d7 / Math.sqrt(d13);
            } else {
                d9 = 0.0d;
            }
            double d14 = d11;
            double d15 = sqrt;
            double pow2 = Math.pow(d9 * pow, 1.1111111111111112d);
            double aw = (viewingConditions.getAw() * Math.pow(d13, (d12 / viewingConditions.getC()) / viewingConditions.getZ())) / viewingConditions.getNbb();
            double d16 = (((0.305d + aw) * 23.0d) * pow2) / (((23.0d * cos) + ((pow2 * 11.0d) * cos2)) + ((108.0d * pow2) * sin));
            double d17 = d16 * cos2;
            double d18 = d16 * sin;
            double d19 = aw * 460.0d;
            double[] matrixMultiply = MathUtils.matrixMultiply(new double[]{inverseChromaticAdaptation(((d19 + (451.0d * d17)) + (288.0d * d18)) / 1403.0d), inverseChromaticAdaptation(((d19 - (891.0d * d17)) - (261.0d * d18)) / 1403.0d), inverseChromaticAdaptation(((d19 - (d17 * 220.0d)) - (d18 * 6300.0d)) / 1403.0d)}, LINRGB_FROM_SCALED_DISCOUNT);
            double d20 = matrixMultiply[0];
            if (d20 < 0.0d) {
                break;
            }
            double d21 = matrixMultiply[1];
            if (d21 < 0.0d) {
                break;
            }
            double d22 = matrixMultiply[2];
            if (d22 < 0.0d) {
                break;
            }
            double[] dArr = Y_FROM_LINRGB;
            double d23 = (dArr[0] * d20) + (dArr[1] * d21) + (dArr[2] * d22);
            if (d23 <= 0.0d) {
                return 0;
            }
            if (i6 != 4) {
                double d24 = d23 - d8;
                if (Math.abs(d24) >= 0.002d) {
                    sqrt = d15 - ((d24 * d15) / (d23 * d14));
                    i6++;
                    d10 = d12;
                    d11 = d14;
                }
            }
            if (matrixMultiply[0] <= 100.01d && matrixMultiply[1] <= 100.01d && matrixMultiply[2] <= 100.01d) {
                return ColorUtils.argbFromLinrgb(matrixMultiply);
            }
        }
        return 0;
    }

    static double inverseChromaticAdaptation(double d6) {
        double abs = Math.abs(d6);
        return MathUtils.signum(d6) * Math.pow(Math.max(0.0d, (27.13d * abs) / (400.0d - abs)), 2.380952380952381d);
    }

    public static Cam16 solveToCam(double d6, double d7, double d8) {
        return Cam16.fromInt(solveToInt(d6, d7, d8));
    }

    static double sanitizeRadians(double d6) {
        return (d6 + 25.132741228718345d) % 6.283185307179586d;
    }

    public static int solveToInt(double d6, double d7, double d8) {
        if (d7 >= 1.0E-4d && d8 >= 1.0E-4d && d8 <= 99.9999d) {
            double sanitizeDegreesDouble = (MathUtils.sanitizeDegreesDouble(d6) / 180.0d) * 3.141592653589793d;
            double yFromLstar = ColorUtils.yFromLstar(d8);
            int findResultByJ = findResultByJ(sanitizeDegreesDouble, d7, yFromLstar);
            if (findResultByJ != 0) {
                return findResultByJ;
            }
            return ColorUtils.argbFromLinrgb(bisectToLimit(yFromLstar, sanitizeDegreesDouble));
        }
        return ColorUtils.argbFromLstar(d8);
    }
}
