package org.spoto.utils;


import org.apache.ibatis.session.RowBounds;

public class PageUtils {

  public static Integer getLastPage(Integer dataCount,Integer pageSize){

      if (dataCount%pageSize==0){
          return dataCount/pageSize;
      }else {
          return (dataCount/pageSize)+1;
      }
  }

   public static RowBounds getRowBounds(Integer pageIndex,Integer pageSize){
      int offset= (pageIndex-1)*pageSize;
      int limit=pageSize;
       RowBounds rb = new RowBounds(offset,limit);
          return rb;
   }
}