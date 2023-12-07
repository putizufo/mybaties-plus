package com.ithzouli.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("tb_user")
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;
    private String name;
    private Integer age;
    private char gender;
    @TableField(value = "p", select = false)
    private String phone;
    @TableField(exist = false)
    private String password;
    //逻辑删除
//    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
    //
    @Version
    private Integer version;

}
