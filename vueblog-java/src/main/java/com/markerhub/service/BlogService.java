package com.markerhub.service;

import com.markerhub.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface BlogService extends IService<Blog> {


    boolean removeById(Long id);
}
