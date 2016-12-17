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
    public static ThreadLocal<Integer> getPageSize() {
        return pageSize;
    }

    public static void setPageSize(ThreadLocal<Integer> pageSize) {
        SystemContext.pageSize = pageSize;
    }

    public static ThreadLocal<Integer> getPageIndex() {
        return pageIndex;
    }

    public static void setPageIndex(ThreadLocal<Integer> pageIndex) {
        SystemContext.pageIndex = pageIndex;
    }
}
