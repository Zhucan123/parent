package com.zc.loginserver.dbTest;

import com.zc.loginserver.domain.entity.Role;
import com.zc.loginserver.domain.entity.RoleExample;
import com.zc.loginserver.domain.repository.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhuCan on 2018/12/21.
 * Project parent.
 * Date 2018/12/21   Time 16:36.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    @Resource
    private RoleMapper roleMapper;

    @Test
    public void test(){
        RoleExample roleExample=new RoleExample();
        RoleExample.Criteria criteria=roleExample.createCriteria();
        //criteria.andIdGreaterThan(0L);
        List<Role> roleExampleList=roleMapper.selectByExample(roleExample);
        for (Role role:roleExampleList){
            System.err.println(role.getCategory());
        }

    }
}
