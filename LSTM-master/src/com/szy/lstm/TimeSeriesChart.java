package com.szy.lstm;

import java.awt.Font;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class TimeSeriesChart {
    ChartPanel frame1;

    public TimeSeriesChart(double[] y_pre, double[] res_recur) {
        XYDataset xydataset = createDataset(y_pre, res_recur);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("LSTM实际值预测", "日期", "负荷", xydataset, true, true,
                true);
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("dd"));
        frame1 = new ChartPanel(jfreechart, true);
        dateaxis.setLabelFont(new Font("黑体", Font.BOLD, 14)); // 水平底部标题
        dateaxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
        ValueAxis rangeAxis = xyplot.getRangeAxis();// 获取柱状
        rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        jfreechart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体
    }

    private static XYDataset createDataset(double[] y_pre, double[] res_recur) { // 这个数据集有点多，但都不难理解
        TimeSeries timeseries = new TimeSeries("LSTM预测值", Day.class);
        int day = 1;
        int month = 1;
        int year = 2019;
        for (int i = 0; i < res_recur.length; i++) {
            timeseries.add(new Day(day++, month, year), res_recur[i]);
        }
        day = 1;
        month = 1;
        year = 2019;
        TimeSeries timeseries1 = new TimeSeries("实际值", Day.class);
        for (int i = 0; i < y_pre.length; i++) {
            timeseries1.add(new Day(day++, month, year), y_pre[i]);
        }
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries);
        timeseriescollection.addSeries(timeseries1);
        return timeseriescollection;
    }

    public ChartPanel getChartPanel() {
        return frame1;
    }
}
