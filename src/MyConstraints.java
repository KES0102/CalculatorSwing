/*
* Экземпляр данного класса создается сразу
* в конструкторе основного класса ( CalculatorSwing ),
* его методы вызываются только в основном классе,
*
* возвращает наборы параметров ( gbc ) для каждого
* компонента ( JButton и JLabel )
 */
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MyConstraints {

  //-------------------------------------------------------------------Строка 1
  GridBagConstraints getGbcJLabel1() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.ipady = 5;
    gbc.weightx = 0.0;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 4;
    gbc.insets = new Insets(0, 10, 0, 10);

    return gbc;
  }

  //-------------------------------------------------------------------Строка 2
  GridBagConstraints getGbcJLabel2() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.ipady = 5;
    gbc.weightx = 0.0;
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 4;
    gbc.insets = new Insets(0, 10, 0, 10);

    return gbc;
  }

  //-------------------------------------------------------------Строка 3(C, ←, +)
  //--------------------------------------------- C
  GridBagConstraints getGbcC() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //--------------------------------------------- ←
  GridBagConstraints getGbcBackSp() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //--------------------------------------------- +
  GridBagConstraints getGbcPlus() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 1;
    gbc.gridx = 2;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //---------------------------------------------------------------Строка 4(7,8,9,-)
  //---------------------------------------------------------- 7
  GridBagConstraints getGbc7() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //---------------------------------------------------------- 8
  GridBagConstraints getGbc8() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //---------------------------------------------------------- 9
  GridBagConstraints getGbc9() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 2;
    gbc.gridy = 3;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //--------------------------------------------------------- (-)
  GridBagConstraints getGbcMinus() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 3;
    gbc.gridy = 3;
    gbc.insets = new Insets(2, 10, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //-------------------------------------------------------------------Строка 5 (4,5,6,*)
  //-------------------------------------------------------- 4
  GridBagConstraints getGbc4() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //------------------------------------------------------- 5
  GridBagConstraints getGbc5() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //------------------------------------------------------- 6
  GridBagConstraints getGbc6() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 2;
    gbc.gridy = 4;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //------------------------------------------------------- *
  GridBagConstraints getGbcMultiply() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 3;
    gbc.gridy = 4;
    gbc.insets = new Insets(2, 10, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //-------------------------------------------------------------------Строка 6(1,2,3,/)
  //------------------------------------------------------- 1
  GridBagConstraints getGbc1() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //------------------------------------------------------- 2
  GridBagConstraints getGbc2() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 1;
    gbc.gridy = 5;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //------------------------------------------------------- 3
  GridBagConstraints getGbc3() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 2;
    gbc.gridy = 5;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //------------------------------------------------------- /
  GridBagConstraints getGbcDivide() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 3;
    gbc.gridy = 5;
    gbc.insets = new Insets(2, 10, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //---------------------------------------------------------------Строка 7(Последняя)
  //------------------------------------------------------- 0
  GridBagConstraints getGbc0() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //------------------------------------------------------- .
  GridBagConstraints getGbcPoint() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 1;
    gbc.gridy = 6;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weighty = 0.5;

    return gbc;
  }

  //------------------------------------------------------- =
  GridBagConstraints getGbcInput() {
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.5;
    gbc.gridx = 2;
    gbc.gridy = 6;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.gridwidth = 2;
    gbc.weighty = 0.5;

    return gbc;
  }

}
