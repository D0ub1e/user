package com.hkwy.model;

/**
 * Created by double2 on 2016/12/17.
 */
public class SystemContext {
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();

    /**
     * 我没有写一个remove的方法
     * @return
     */
    public static  int getPageSize(){
        return pageSize.get();
    }
    public static  void setPageSize(int _pageSize){
        pageSize.set(_pageSize);
    }
    public static  void removePageSize(){
        pageSize.remove();
    }
    //三种方法对象是PageIndex
    public static  int getPageIndex(){
        return pageIndex.get();
    }
    public static  void setPageIndex(int _pageIndex){
        pageIndex.set(_pageIndex);
    }
    public static  void removePageIndex(){
        pageIndex.remove();
    }
}
