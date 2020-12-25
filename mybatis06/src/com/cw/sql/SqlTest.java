package com.cw.sql;


import org.apache.ibatis.jdbc.SQL;

/**
 * @author 陈小哥cw
 * @date 2020/12/25 13:57
 */
public class SqlTest {
    public static void main(String[] args) {
        System.out.println(getSql());
    }

    public static String getSql() {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("student");
            }
        }.toString();
        return sql;
    }
}
