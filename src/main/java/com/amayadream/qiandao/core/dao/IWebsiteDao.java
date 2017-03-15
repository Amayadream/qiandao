package com.amayadream.qiandao.core.dao;

import com.amayadream.qiandao.core.model.Website;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2017.03.15 16:02
 */
@Service
public interface IWebsiteDao {

    Website selectByPrimaryKey(String webId);

    List<Website> list();

    int insert(Website website);

    int update(Website website);

    int delete(List<String> webIds);

}
