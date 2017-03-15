package com.amayadream.qiandao.core.dao;

import com.amayadream.qiandao.core.model.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2017.03.15 16:02
 */
@Service
public interface ITaskDao {

    Task selectByPrimaryKey(@Param("taskName") String taskName, @Param("taskGroup") String taskGroup);

    List<Task> list();

    int insert(Task task);

    int update(Task task);

    int delete(@Param("taskName") String taskName, @Param("taskGroup") String taskGroup);

}
