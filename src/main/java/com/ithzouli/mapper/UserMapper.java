package com.ithzouli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ithzouli.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
