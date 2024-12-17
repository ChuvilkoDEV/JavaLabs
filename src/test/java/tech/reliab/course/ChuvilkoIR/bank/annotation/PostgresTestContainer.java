package tech.reliab.course.ChuvilkoIR.bank.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tech.reliab.course.ChuvilkoIR.bank.extension.PostgresTestContainerExtension;

@Target(ElementType.TYPE)
@SpringBootTest
@ExtendWith(PostgresTestContainerExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public @interface PostgresTestContainer {
}
