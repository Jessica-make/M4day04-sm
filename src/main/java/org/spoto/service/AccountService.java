package org.spoto.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.spoto.model.Account;
import org.spoto.utils.TableData;

import java.util.List;

public interface AccountService {
    TableData<Account> list (int index, String account , String passwd);

    //新增、修改
    void  save(Account ac);

    //删除
    void del(List<Integer> ids);

}
