package eu.sii;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

  private static Jdbi jdbi;
  protected Handle handle;

  //Creating connection to DB
  @BeforeAll
  public static void setUpJdbi() {
    jdbi = Jdbi.create("jdbc:oracle:thin:@localhost:49161:xe", "system", "oracle");
    jdbi.installPlugin(new SqlObjectPlugin());
  }

  //Creating handler to send queries(statement) to db
  @BeforeEach
  public void setUpHandle() {
    handle = jdbi.open();
  }

  //Closing handler connection to db
  @AfterEach
  public void tearDownHandle() {
    handle.close();
  }

  protected enum JOBS {
    SA_REP, SA_MAN, ST_CLERK;
  }
}
