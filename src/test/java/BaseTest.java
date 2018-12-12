import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

  private static Jdbi jdbi;
  protected Handle handle;

  @BeforeAll
  public static void setUpJdbi() {
    jdbi = Jdbi.create("jdbc:oracle:thin:@localhost:49161:xe", "system", "oracle");
  }

  @BeforeEach
  public void setUpHandle() {
    handle = jdbi.open();
  }

  @AfterEach
  public void tearDownHandle() {
    handle.close();
  }

  protected enum JOBS {
    SA_REP, SA_MAN, ST_CLERK;
  }
}
