package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.lang.Math;

import static java.lang.Math.PI;

public class MainFrame extends JFrame {
    // Размеры окна приложения в виде констант
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;
//текстовые поля для считывания значений переменных X Y
    //как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;
    //текстовое поле для отображения результата
    //как компанент, совместно используемый
    //в различных методах
    private JTextField textFieldResult;
//группа радио-ккнопок для обеспечения
    //уникальности выделения в группе
    private JTextField textFieldMemory;
    private ButtonGroup radioButtons = new ButtonGroup();
   //контейнер для отобр радио-кн.
    private Box hboxFormulaType = Box.createHorizontalBox();
//идентификатор выбранной формулы
    private int formulaId = 1;

    //формула 1
    public Double calculate1(Double x,Double y,Double z)
    {
        return (Math.pow(Math.log(z)+Math.sin(PI+z),0.25))/(Math.pow(Math.pow(y,2)+Math.pow(Math.exp(x),Math.cos(x))+Math.sin(y),Math.sin(x)));
    }

    //формула 2
    public Double calculate2(Double x,Double y,Double z)
    {
        return ((1+Math.sqrt(z*x))/(Math.pow(1+Math.pow(x,3),y)));
    }

    //Вспомогательный метод для добавления кнопок на панель
    private void addRadioButton(String buttonName, final int formulaId){
        JRadioButton button=new JRadioButton(buttonName);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                MainFrame.this.formulaId=formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }

    //Конструктор класса

    public MainFrame(){

        super("Вычисление формулы");//вызывает рподительский конструктор без аргументов

        final Formula a=new Formula();

        setSize(WIDTH,HEIGHT);
        Toolkit kit=Toolkit.getDefaultToolkit();
        //отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width-WIDTH)/2,
                (kit.getScreenSize().height-HEIGHT)/2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(),true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        //Создать область с полями ввода для X Y Z
        JLabel labelForX=new JLabel("X:");
        textFieldX=new JTextField("0",10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());

        JLabel labelForY=new JLabel("Y:");
        textFieldY=new JTextField("0",10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());

        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        Box hboxVariables=Box.createHorizontalBox();
        hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));

        //hboxVariables.add(Box.createHorizontalGlue());
       // hboxVariables.add((Box.createGlue()));
        //TODO
        /*
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10)); //сохраняет расстояние между х и полем
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(100)); //минимальная ширина сжатия

       // hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);

        hboxVariables.add(Box.createHorizontalStrut(100));
       // hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());
*/



        /*hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);*/
        //hboxVariables.add(Box.createHorizontalGlue());
        //hboxVariables.add(Box.createHorizontalStrut(30));
        hboxVariables.add(labelForX);
        //hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(Box.createHorizontalGlue());


     //   hboxVariables.add(Box.createHorizontalStrut(30));
        hboxVariables.add(labelForY);
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(Box.createHorizontalGlue());

        //hboxVariables.add(Box.createHorizontalGlue());
       // hboxVariables.add(Box.createHorizontalStrut(30));
        hboxVariables.add(labelForZ);
        //hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);


//Создать область для вывода результата
        JLabel labelForResult=new JLabel("Результат:");

        textFieldResult = new JTextField("0", 15);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());


        JLabel labelForMemory = new JLabel("Память:");
//labelMemory = new JLabel("0");
        textFieldMemory = new JTextField("0", 15);
        textFieldMemory.setMaximumSize(textFieldResult.getPreferredSize());
        Box hboxMemory = Box.createHorizontalBox();
        hboxMemory.add(Box.createHorizontalGlue());
        hboxMemory.add(labelForMemory);
        hboxMemory.add(Box.createHorizontalStrut(10));
        hboxMemory.add(textFieldMemory);
        hboxMemory.add(Box.createHorizontalGlue());
        hboxMemory.setBorder(BorderFactory.createLineBorder(Color.BLUE));

// Создать область для кнопок
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    if (formulaId==1)
                        result = calculate1(x, y, z);
                    else
                        result = calculate2(x, y, z);
                    textFieldResult.setText(result.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });

        JButton buttonSum = new JButton("M+");
        buttonSum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                Double result = Double.parseDouble(textFieldResult.getText());
                double k=a.getSum();
                k+=result;
                a.setSum(k);
                Double s = a.getSum();
                String str = Double.toString(s);
                textFieldMemory.setText(str);
            }});



        JButton buttonDel = new JButton("MC");
        buttonDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                a.setSum(0);
                Double s = a.getSum();
                String str = Double.toString(s);
                textFieldMemory.setText(str);
            }});

        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);

        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalStrut(30));


        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        Box hboxButtonsM = Box.createHorizontalBox();
        hboxButtonsM.add(buttonDel);
        hboxButtonsM.add(Box.createHorizontalGlue());
        hboxButtonsM.add(Box.createHorizontalStrut(30));
        hboxButtonsM.add(buttonSum);




// Связать области воедино в компоновке BoxLayout
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());

        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxMemory);
        contentBox.add(hboxButtons);
        contentBox.add(hboxButtonsM);

        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }



}


