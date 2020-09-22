package org.spoto.service.Impl;

import org.apache.ibatis.session.RowBounds;
import org.spoto.dao.AccountMapper;
import org.spoto.model.Account;
import org.spoto.service.AccountService;
import org.spoto.utils.PageUtils;
import org.spoto.utils.TableData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    //一页三条数据;
    @Value("${pageSize}")
    private  int pageSize;

    //提取到全局变量;
    @Resource
    private AccountMapper mapper ;

    @Override
    public TableData <Account> list (int index, String account ,String passwd){
        //构造一个结果数据;
        TableData<Account> td = new TableData<>();
        //把前端接过来的参数，丢到集合里面去,第几页index
        td.setPageIndex(index);
        //每页几条数据pageSize
        td.setPageSize(pageSize);

        //count数据条数;
        Integer count = mapper.listCount(account,passwd);
        td.setDataCount(count);
         //td的三个条件两个都要用;所以全局变量,  private List<T> dataList数据为空;
        if (count <=0){
          return td;
        }
        //index被塞到td.setPageIndex(index);里面
        RowBounds rb = PageUtils.getRowBounds(index, pageSize);
        //调用dao接口;
        List<Account> list = mapper.getList(rb,account,passwd);
        td.setDataList(list);
        return td;
    }

    @Override
    //有异常回滚
    @Transactional(rollbackFor = Exception.class)
    public void save(Account ac) {
        if (ac.getId()>0){
            //更新
            mapper.change(ac.getId(), ac.getAccount(), ac.getPasswd());
        }else {
            //新增；
            mapper.add(ac);
        }
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void del( List<Integer> ids) {
        //把ids丢给dao去处理
        mapper.del(ids);
    }
}
