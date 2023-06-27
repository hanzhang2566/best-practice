package boot.util;

import org.junit.jupiter.api.Test;

/**
 * Usage: {@link BcryptUtils} 测试 <br/>
 * Date: 2023/6/27 10:34 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public class BcryptUtilsTest {
    @Test
    public void encryptTest() {
        String content = "123456";
        for (int i = 0; i < 3; i++) {
            String encrypt = BcryptUtils.encrypt(content);
            System.out.println("encrypt = " + encrypt);
            boolean matches = BcryptUtils.matches(content, encrypt);
            System.out.println("matches = " + matches);
        }
    }

    @Test
    public void matchesTest() {
        String content = "123456";
        for (int i = 0; i < 3; i++) {
            boolean matches = BcryptUtils.matches(content, "$2a$10$lcByir.6IYt7P.JnNyYfm.NbUsXdov1Cym83fUmx5MffTaC8ENY9K1");
            System.out.println("matches = " + matches);
        }
    }
}
