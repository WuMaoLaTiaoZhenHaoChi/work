package com.sjkcxx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.entity.StudentSubject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/1 16:28
 * @Description:学生-学科表
 */
public interface StudentSubjectMapper extends BaseMapper<StudentSubject> {

    /**
     * 有条件查询
     * @param studentSubject
     * @return
     */
    List<StudentSubject> selectStudentSubjectBySS(@Param("studentSubject") StudentSubject studentSubject,@Param("pageDto") PageDto pageDto);

    /**
     * 统计总数
     * @param studentSubject
     * @return
     */
    int countStudentSubjectBySS(@Param("studentSubject") StudentSubject studentSubject);

}
