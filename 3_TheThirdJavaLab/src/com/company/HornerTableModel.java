package com.company;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class HornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public HornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.setCoefficients(coefficients);
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() { // В данной модели два столбца
        return 3;
    }

    public int getRowCount() { // Вычислить количество точек между началом и концом отрезка исходя из шага табулирования
        return new Double(Math.ceil((to - from) / step)).intValue() + 1;
    }



    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        switch (col) {
            case 0 : return x;
            case 1 : return calculateHorner(x);
            case 2 : return isPrecise(calculateHorner(x));
            default : return 0;
        }
    }

    private Object isPrecise(double x) {
        return (double)x % 1 == 0;
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0 : return "Значение X";
            case 1 : return "Значение многочлена";
            case 2 : return "Точное значение?";
            default : return "";
        }
    }

    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 2 : return Boolean.class;
            case 0 : return Double.class;
            case 1 : return Double.class;
            default : return Double.class;
        }
    }

    private double calculateHorner(double x) {
        Double b = coefficients[coefficients.length - 1];
        for (int i = coefficients.length - 2; i >= 0; i--) {
            b = b * x + coefficients[i];
        }
        return b;
    }

    public Double[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(Double[] coefficients) {
        this.coefficients = coefficients;
    }
}

