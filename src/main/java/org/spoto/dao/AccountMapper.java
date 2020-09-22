package org.spoto.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.spoto.model.Account;

import java.util.List;

public interface AccountMapper {
    Integer add(@Param("ac") Account ac);

    Integer change(@Param("id") Integer id, @Param("account") String account, @Param("passwd")String passwd);

    Integer del(@Param("ids") List<Integer> ids);

    List<Account> getList(RowBounds rb, @Param("account")String account, @Param("passwd")String passwd);

    Integer listCount(@Param("account") String account, @Param("passwd") String passwd);

}
