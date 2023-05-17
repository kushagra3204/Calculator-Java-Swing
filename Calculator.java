package JavaLab;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
public class SwingClass 
{
    static int CountOperations=0;
    public static void main(String[] args) 
    {
        Font font1 = new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 20);
        
        //Frame
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(290,540);
        jf.setLayout(null);
        jf.setVisible(true);
        
//        Frame f=new Frame();     
        Image icon = Toolkit.getDefaultToolkit().getImage("C://Users//Kushagra Agarwal//Downloads//calculator_image.png");    
        jf.setIconImage(icon);
        
        //Label                                      
        JLabel label=new JLabel("Simple Calculator");
        jf.add(label);
        label.setBounds(80,5,110,30);
        Border loweredbevel; 
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        TitledBorder title;
        title = BorderFactory.createTitledBorder(loweredbevel);
        title.setTitlePosition(TitledBorder.ABOVE_TOP);
        label.setBorder(title);
        
        
        //TextField
        JTextField jt = new JTextField();
        jf.add(jt);
        jt.setBounds(20,40,230,150);
        jt.setEditable(false);
        jt.setFont(font1);
        jt.setBackground(Color.LIGHT_GRAY);
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        jt.setBorder(compound);
        
        JButton jb = new JButton("+/-");
        jf.add(jb);
        jb.setBounds(20,440,50,40);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String ReverseSign="";
                String UnreverseSign="";
                int Number;
                for(int i=(jt.getText()).length()-1;i>=0;i--)
                {
                    if(Character.isDigit(((jt.getText()).charAt(i))) || ((jt.getText()).charAt(i))=='-' || ((jt.getText()).charAt(i))=='²' || ((jt.getText()).charAt(i))=='.')
                    {
                        ReverseSign=(jt.getText()).charAt(i)+ReverseSign;
                    }
                    else
                    {
                        break;
                    }
                }
                if(((jt.getText()).charAt(ReverseSign.length()-1))=='²')
                {
                    String Number1="";
                    for(int i=0;i<ReverseSign.length()-1;i++)
                    {
                        Number1+=((jt.getText()).charAt(i));
                        
                    }
                    int Number2=Integer.parseInt(Number1);
                    Number2=Number2*Number2;
                    ReverseSign=String.valueOf(Number2);
                }
//                String SignReverse=jt.getText();
//                Number=Double.parseDouble(ReverseSign);
                Number=Integer.parseInt(ReverseSign);
                Number=Number*(-1);
                String ReverseSign1=String.valueOf(Number);
                
                for(int i=0;i<(jt.getText()).length()-ReverseSign.length();i++)
                {
//                    if()
                    UnreverseSign+=(jt.getText()).charAt(i);
                }
                System.out.println(ReverseSign);
                System.out.println(UnreverseSign);
                
                jt.setText(UnreverseSign+ReverseSign1);
            }
        });
        
        
        
        JButton jb0 = new JButton("0");
        jf.add(jb0);
        jb0.setBounds(80,440,50,40);
        jb0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"0");
            }
        });
        
        
        JButton jbdot = new JButton(".");
        jf.add(jbdot);
        jbdot.setBounds(140,440,50,40);
        jbdot.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+".");
            }
        });
        
        
        JButton jbequal = new JButton("=");
        jf.add(jbequal);
        jbequal.setBounds(200,440,50,40);
        jbequal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                int j=0;
//                System.out.println(CountOperations);
//                String NumberString=jt.getText();
                String a[]=new String[CountOperations+1];
                String b[]=new String[CountOperations];
                first:
                for(int i=0;i<CountOperations+1;i++)
                {
                    a[i]="";
                    if(i<CountOperations)
                    {
                        b[i]="";
                    }
                    second:
                    while(j!=(jt.getText()).length())//for(int j=0;j<(jt.getText()).length();j++)
                    {
                        
                        if(Character.isDigit(((jt.getText()).charAt(j))))
                        {
                            a[i]+=(jt.getText()).charAt(j);
                        }
                        else
                        {
                            b[i]+=(jt.getText()).charAt(j);
                            j++;
                            break second;
                            
//                            j=(jt.getText()).length();
                        }
                        j++;
                    }
//                    System.out.println(a[i]);
//                    if(i<CountOperations){
//                        System.out.println(b[i]);
//                    }
                }
                
                for(int i=0;i<CountOperations;i++)
                {
                    if(b[i].equals("*"))
                    {
                        int num1=Integer.parseInt(a[i]);
                        int num2=Integer.parseInt(a[i+1]);
                        int mul=num1*num2;
                        String number=String.valueOf(mul);
                        jt.setText(number);
//                        int num2;
                    }
                    else if(b[i].equals("÷"))
                    {
                        int num1=Integer.parseInt(a[i]);
                        int num2=Integer.parseInt(a[i+1]);
                        int mul=num1/num2;
                        String number=String.valueOf(mul);
                        jt.setText(number);
//                        int num2;
                    }
                    else if(b[i].equals("+"))
                    {
                        int num1=Integer.parseInt(a[i]);
                        int num2=Integer.parseInt(a[i+1]);
                        int mul=num1+num2;
                        String number=String.valueOf(mul);
                        jt.setText(number);
//                        int num2;
                    }
                    else if(b[i].equals("-"))
                    {
                        int num1=Integer.parseInt(a[i]);
                        int num2=Integer.parseInt(a[i+1]);
                        int mul=num1-num2;
                        String number=String.valueOf(mul);
                        jt.setText(number);
//                        int num2;
                    }
                    else if(((jt.getText()).charAt((jt.getText()).length()-1))=='²')
                    {
                        String Number1="";
                        for(int k=0;k<(jt.getText()).length()-1;k++)
                        {
                            Number1+=((jt.getText()).charAt(k)); 
                        }
                        int Number2=Integer.parseInt(Number1);
                        Number2=Number2*Number2;
                        String number=String.valueOf(Number2);
                        jt.setText(number);
                    }
                }
            }
        });
        
        
        JButton jb1 = new JButton("1");
        jf.add(jb1);
        jb1.setBounds(20,380,50,40);
        jb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"1");
            }
        });
        
        
        
        jf.setVisible(true);
        
        
        
        JButton jb2 = new JButton("2");
        jf.add(jb2);
        jb2.setBounds(80,380,50,40);
        jb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"2");
            }
        });
        
        
        JButton jb3 = new JButton("3");
        jf.add(jb3);
        jb3.setBounds(140,380,50,40);
        jb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"3");
            }
        });
        
        
        JButton jb4 = new JButton("+");
        jf.add(jb4);
        jb4.setBounds(200,380,50,40);
        jb4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"+");
                CountOperations++;
            }
        });
        
        
        JButton jb5 = new JButton("4");
        jf.add(jb5);
        jb5.setBounds(20,320,50,40);
        jb5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"4");
            }
        });
        
        
        JButton jb6 = new JButton("5");
        jf.add(jb6);
        jb6.setBounds(80,320,50,40);
        jb6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"5");
            }
        });
        
        
        JButton jb7 = new JButton("6");
        jf.add(jb7);
        jb7.setBounds(140,320,50,40);
        jb7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               jt.setText(jt.getText()+"6");
            }
        });
        
        
        JButton jb8 = new JButton("-");
        jf.add(jb8);
        jb8.setBounds(200,320,50,40);
        jb8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"-");
                CountOperations++;
            }
        });
        
        
        JButton jb9 = new JButton("7");
        jf.add(jb9);
        jb9.setBounds(20,260,50,40);
        jb9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"7");
            }
        });
        
        
        JButton jb10 = new JButton("8");
        jf.add(jb10);
        jb10.setBounds(80,260,50,40);
        jb10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"8");
            }
        });
        
        
        JButton jb11 = new JButton("9");
        jf.add(jb11);
        jb11.setBounds(140,260,50,40);
        jb11.addActionListener((ActionEvent e) -> {
            jt.setText(jt.getText()+"9");
        });
        
        
        
        JButton jb12 = new JButton("*");
        jf.add(jb12);
        jb12.setBounds(200,260,50,40);
        jb12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"*");
                CountOperations++;
            }
        });
        
        JButton jb13 = new JButton("C");
        jf.add(jb13);
        jb13.setBounds(20,200,50,40);
        jb13.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e)
            {
                jt.setText("");
            }
        });
        
        
        JButton jb14 = new JButton("X²");
        jf.add(jb14);
        jb14.setBounds(80,200,50,40);
        jb14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
//                System.out.println("X²");
                jt.setText(jt.getText()+"²");
                CountOperations++;
            }
        });
        
        
        JButton jb15 = new JButton("÷");
        jf.add(jb15);
        jb15.setBounds(140,200,50,40);
        jb15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                jt.setText(jt.getText()+"÷");
                CountOperations++;
            }
        });
        
        
        
        JButton jb16 = new JButton("←");
        jf.add(jb16);
        jb16.setBounds(200,200,50,40);
        jb16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String backspace="";
                for(int i=0;i<(jt.getText()).length()-1;i++)
                {
                    backspace+=(jt.getText()).charAt(i);
                }
                jt.setText(backspace);
            }
        });
        
        
          
          jb0.setFont(font1);
          jb1.setFont(font1);
          jb2.setFont(font1);
          jb3.setFont(font1);
          jb4.setFont(font1);
          jb5.setFont(font1);
          jb6.setFont(font1);
          jb7.setFont(font1);
          jb8.setFont(font1);
          jb9.setFont(font1);
          jb10.setFont(font1);
          jb11.setFont(font1);
          jb12.setFont(font1);
          jb13.setFont(font1);
          jbdot.setFont(font1);
          jbequal.setFont(font1);
          jb15.setFont(font1);
        
    }
}
