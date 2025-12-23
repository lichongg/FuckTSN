package j0;

import java.io.IOException;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.junit.Test;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {
    public static void a() {
        try {
            CtClass ctClass = ClassPool.getDefault().get("com.google.android.gms.internal.mlkit_vision_pose_common.zzvm");
            ctClass.getDeclaredMethod("zza").insertBefore("{ System.out.println(\"Intercepted zzvm->zza method call\"); return false; }");
            ctClass.writeFile();
            System.out.getClass();
            ctClass.writeFile("C:\\Android\\Code\\BoXinCampus\\student\\src\\main\\java\\com\\bxkj\\student\\v2\\ai\\fitness");
        } catch (NotFoundException | CannotCompileException | IOException unused) {
            System.out.getClass();
        }
    }

    @Test
    public void b() {
        a();
    }
}
