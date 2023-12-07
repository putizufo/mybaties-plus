package com.ithzouli.mybatiesplus;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ithzouli.mapper.UserMapper;
import com.ithzouli.pojo.User;

import com.ithzouli.pojo.query.QueryUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest
class MybatiesPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void Id(){

        System.out.println(IdType.ASSIGN_ID);
        System.out.println(IdType.ASSIGN_ID);
    }

    @Test
    void getPage() {
        IPage page = new Page(3, 3);
        userMapper.selectPage(page, null);
        System.out.println("页码：" + page.getCurrent());
        System.out.println("每页条数：" + page.getSize());
        System.out.println("一共多少页：" + page.getPages());
        System.out.println("一共多少条：" + page.getTotal());
        System.out.println("查询的数据：" + page.getRecords());

    }

    @Test
    void insert() {
        User tbUser = new User();
        tbUser.setName("张丰lhlp");
        tbUser.setAge(18);
        tbUser.setGender('1');
        tbUser.setPhone("12345678");
//        tbUser.setId(7);
        userMapper.insert(tbUser);

    }

    @Test
    void update() {
       /* User user = new User();

        user.setAge(30);
//        user.setGender(1);
        user.setPhone("12345678");
        user.setId(7);
        userMapper.updateById(user);
        System.out.println("update...");*/

//        User u = new User();
//        u.setId(1);
//        u.setName("黄渤666");
//        u.setVersion(1);
//        userMapper.updateById(u);

//        User user = userMapper.selectById(1);
//        user.setName("黄渤777");
//        userMapper.updateById(user);

        User user1 = userMapper.selectById(1);
        User user2 = userMapper.selectById(1);

        user1.setName("大黄66");

        user2.setName("范冰冰");

        userMapper.updateById(user1);
        userMapper.updateById(user2);


    }

    @Test
    void delete() {
//        User tbUser = new User();
//        tbUser.setName("黄渤666");
//        tbUser.setAge(50);
//
//        tbUser.setId(7);

//        userMapper.deleteById(1211301890);
        System.out.println(userMapper.selectList(null));
        //批量删除  根据id
//        List<Integer> list = new ArrayList<>();
//        list.add(-474804222);
//        list.add(-369975295);
//        list.add(1311944705);
//        userMapper.deleteBatchIds(list);

        //批量查找 根据id
/*        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(userMapper.selectBatchIds(list));*/

    }

    @Test
    void contextLoads() {
        //条件查询

        //方式一：
        /*QueryWrapper qw = new QueryWrapper<>();
        qw.lt("age", 40);
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);*/

        //方式二：lambda表达式
        /*QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lambda().lt(User::getAge, 40);
        qw.lambda().gt(User::getAge, 30);
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);*/

        //方式三：lambda表达式
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //年龄小于50大于40
//        lqw.lt(User::getAge, 50).gt(User::getAge, 40);
        //大于50或小于40
        lqw.gt(User::getAge, 50).or().lt(User::getAge, 40);
        List<User> users = userMapper.selectList(lqw);
        System.out.println(users);
    }

    @Test
    void query() {

        //条件空值判断
//        QueryUser qu = new QueryUser();
//        qu.setAge(30);
//        qu.setAge2(50);

//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//        lqw.gt(null != qu.getAge(), User::getAge, qu.getAge());
//        lqw.lt(null != qu.getAge2(), User::getAge, qu.getAge2());
/*        lqw.gt(null != qu.getAge(), User::getAge, qu.getAge())
           .lt(null != qu.getAge2(), User::getAge, qu.getAge2());
        List<User> users = userMapper.selectList(lqw);
        System.out.println(users);*/

        //查询投影
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//        lqw.select(User::getId, User::getName, User::getAge);
        /*QueryWrapper lqw = new QueryWrapper();
        lqw.select("id", "age", "phone");
        List<User> users = userMapper.selectList(lqw);
        System.out.println(users);*/

//        QueryWrapper<User> lqw = new QueryWrapper();
////        查询总数
//        lqw.select("count(*) as count, gender");
////        分组查询
//        lqw.groupBy("gender");
//        List<Map<String, Object>> maps = userMapper.selectMaps(lqw);
//        System.out.println(maps);

    }

    @Test
    void conditionalQuery(){
        //条件查询
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//        //eq相当于=
//        lqw.eq(User::getName, "白眉鹰王").eq(User::getAge, 55);
//        User user = userMapper.selectOne(lqw);
//        System.out.println(user);


        //范围查询 lt(不包含) le(包含) gt(不包含) ge(包含) eq between
        /*LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.between(User::getAge, 30, 40);
        List<User> users = userMapper.selectList(lqw);
        System.out.println(users);*/

        //模糊匹配
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//        lqw.like(User::getName, "王"); // % val %
//        lqw.likeLeft(User::getName, "使"); // % val
        lqw.likeRight(User::getName, "光"); // val %
        List<User> users = userMapper.selectList(lqw);
        System.out.println(users);

    }

    @Test
    void reflectionName(){

        List<User> users = userMapper.selectList(null);
        System.out.println(users);

    }

}
