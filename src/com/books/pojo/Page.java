package com.books.pojo;

import java.io.Serializable;

public class Page implements Serializable {

    private int currentPage = 1; // 当前页数
    private int pageRow = 15; // 每页显示记录的条数
    private int totalRow; // 总的记录条数
    private int totalPage; // 总的页数

    private int startPos; // 开始位置，从0开始
    private boolean hasFirst;// 是否有首页
    private boolean hasPre;// 是否有前一页
    private boolean hasNext;// 是否有下一
    private boolean hasLast;// 是否有最后一页

    public Page(int totalRow, int currentPage) {
        this.totalRow = totalRow;
        this.currentPage = currentPage;
    }

    public int gettotalPage() {
        totalPage = gettotalRow() / getpageRow();
        return (totalRow % pageRow == 0) ? totalPage
                : totalPage + 1;
    }

    public void settotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getcurrentPage() {
        return currentPage;
    }

    public void setcurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getpageRow() {
        return pageRow;
    }

    public void setpageRow(int pageRow) {
        this.pageRow = pageRow;
    }

    public int gettotalRow() {
        return totalRow;
    }

    public void settotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getStartPos() {
        return (currentPage - 1) * pageRow;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    /**
     * 是否是第一页
     *
     * @return
     */
    public boolean isHasFirst() {
        return (currentPage == 1) ? false : true;
    }

    public void setHasFirst(boolean hasFirst) {
        this.hasFirst = hasFirst;
    }

    public boolean isHasPre() {
        // 如果有首页就有前一页，因为有首页就不是第一页
        return isHasFirst() ? true : false;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    public boolean isHasNext() {
        // 如果有尾页就有下一页，因为有尾页表明不是最后一页
        return isHasLast() ? true : false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasLast() {
        // 如果不是最后一页就有尾页
        return (currentPage == gettotalRow()) ? false : true;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }

}
