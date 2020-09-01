package site.part.ms.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import site.part.ms.entity.Goods;
import site.part.ms.mapper.GoodsMapper;

public class GoodsServiceImpl {
    @Autowired
    Goods goods;
    @Autowired
    private GoodsMapper goodsMapper;
    public void t(){
        goodsMapper.selectPage(new Page<Goods>(1,3), new QueryWrapper<Goods>().
                between("age",1,6));
    }
}
