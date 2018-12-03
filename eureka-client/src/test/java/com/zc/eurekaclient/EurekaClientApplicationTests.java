package com.zc.eurekaclient;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaClientApplicationTests {
    @Autowired
    @Qualifier("oracleJdbcTemplate")
    private JdbcTemplate oracleTemplate;

    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate mysqlTemplate;

    @Test
    public void contextLoads() {
        String sql="select count(*) from c_user";
        String res1=oracleTemplate.queryForObject(sql,String.class);
        String RES2=mysqlTemplate.queryForObject(sql,String.class);
    }

}
