package com.zc.loginserver.dbTest;

import com.zc.loginserver.domain.entity.SysPermission;
import com.zc.loginserver.domain.repository.SysPermissionMapper;
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
    private SysPermissionMapper permissionMapper;

    @Test
    public void test() {
        List<SysPermission> permissionList = permissionMapper.findPermissionByUserId(1L);
        for (SysPermission s : permissionList) {
            System.err.println(s.getName());
        }
    }
}
