package com.szy.lstm;

import java.util.ArrayList;
import java.util.List;

/**read data from sql */

import com.szy.mysql.HibernateQuery;

public class SQLRead {
    public static double[] getData() {
        HibernateQuery hibernateQuery = new HibernateQuery();
        List<Double> list = new ArrayList<>();
        for (double data : hibernateQuery.testAdd1()) {
            list.add(data);
        }
        double[] nums = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}