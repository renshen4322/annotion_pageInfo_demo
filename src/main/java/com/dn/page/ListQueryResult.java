package com.dn.page;

import java.util.List;

/**
 * Created by MoonBlade on 2022/5/11 18:03.
 */

public class ListQueryResult<T> {
    // ===========================================================
    // Constants
    // ===========================================================


    // ===========================================================
    // Fields
    // ===========================================================
    public int total;
    public List<T> rows;

    // ===========================================================
    // Constructors
    // ===========================================================
    public ListQueryResult() {

    }

    public ListQueryResult(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    // ===========================================================
    // Getter &amp; Setter
    // ===========================================================

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }


    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================


    // ===========================================================
    // Methods
    // ===========================================================


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
