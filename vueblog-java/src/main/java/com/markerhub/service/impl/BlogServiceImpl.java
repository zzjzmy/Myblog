package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.markerhub.entity.Blog;
import com.markerhub.mapper.BlogMapper;
import com.markerhub.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Override
    public boolean removeById(Long id) {
        int rows = baseMapper.deleteById(id);
        return rows > 0;
    }

    @Override
    public boolean remove(Wrapper<Blog> wrapper) {
        int rows = baseMapper.delete(wrapper);
        return rows > 0;
    }
}
