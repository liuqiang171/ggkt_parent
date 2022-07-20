package com.at.ggkt.vod.controller;


import com.at.ggkt.result.Result;
import com.at.ggkt.vo.vod.TeacherQueryVo;
import com.at.ggkt.vod.service.TeacherService;
import com.at.ggkt.model.vod.Teacher;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2022-07-16
 */
@Api(tags = "讲师管理接口")
@RestController
@CrossOrigin
@RequestMapping("/admin/vod/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("查询所有讲师")
    @GetMapping("/findAll")
    public Result findAllTeacher(){

        List<Teacher> list = teacherService.list();
        return Result.ok(list);
    }

    //逻辑删除讲师
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("remove/{id}")
    public Result removeTeacher(@PathVariable Long id){
        boolean b = teacherService.removeById(id);
        if(b){
            return Result.ok(null);
        }else {

            return Result.fail();
        }
    }

    @ApiOperation("条件查询分页")
    @PostMapping("/findQueryPage/{current}/{limit}")
    public Result findPage(@PathVariable Integer current,
                           @PathVariable Integer limit,
                           @RequestBody(required = false) TeacherQueryVo teacherQueryVo){
        //分页
        IPage<Teacher> page = new Page<>(current,limit);
        if(teacherQueryVo == null){
            IPage<Teacher> teacherIPage = teacherService.page(page,null);
            return Result.ok(teacherIPage);
        }else {
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();

            QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
            wrapper.like(!StringUtils.isEmpty(name),"name",name)
                    .like(!StringUtils.isEmpty(level),"level",level)
                    .ge(!StringUtils.isEmpty(joinDateBegin),"join_date",joinDateBegin)
                    .le(!StringUtils.isEmpty(joinDateEnd),"join_date",joinDateEnd);

            IPage<Teacher> teacherIPage = teacherService.page(page, wrapper);

            return Result.ok(teacherIPage);
        }
    }

    @ApiOperation("添加讲师")
    @PostMapping("/saveTeacher")
    public Result saveTeacher(@RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        if(save){
            return Result.ok(null);
        }else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "根据id查询")
    @GetMapping("getTeacher/{id}")
    public Result getTeacher(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    @ApiOperation(value = "修改讲师")
    @PutMapping("updateTeacher")
    public Result updateTeacherById(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.updateById(teacher);
        if(isSuccess){
            return Result.ok(null);
        }else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "批量删除讲师")
    @DeleteMapping("removeBatch")
    public Result  removeBatch(@RequestBody List<Long> idList){
        boolean isSuccess = teacherService.removeByIds(idList);
        if(isSuccess){
            return Result.ok(null);
        }else {
            return Result.fail();
        }
    }
}

