package com.szy.lstm;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class DrawChart {
    public static void drawChart(double[] y_pre, double[] res_recur) {
        JFrame frame = new JFrame("LSTM预测图");
        frame.setLayout(new GridLayout(1, 2, 10, 10));
        frame.add(new TimeSeriesChart(y_pre, res_recur).getChartPanel()); // 添加折线图
        frame.setBounds(50, 50, 1080, 720);
        frame.setVisible(true);
    }
}
