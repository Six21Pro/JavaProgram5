
import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 
import java.util.*; 
import java.util.Stack;

public class PostFixCalculator
{
    /**
     * Constructor for objects of class PostFixCalculator
     */
    public PostFixCalculator()//default constructor
    {

    }

    public double eval(String y)//method accepts a string//in this case the postfixed expression
    {
        InfixToPostfix a=new InfixToPostfix();
        String k="";

        Stack<Double> st = new Stack<Double>();//stack of doubles
        Scanner scan= new Scanner(y);//new scanner scanning y
        while (scan.hasNext()){
            k=scan.next();//k eqauls next value within scan
            //System.out.println("k"+k);//FOR TESTING

            if(!k.contains("*")&&!k.contains("+")&&!k.contains("-")&&!k.contains("/")&&!k.contains("=")&&!k.contains("%")){
                //if k is not +,_,/,*,=,%
                double u=Double.parseDouble(k);//value of k converted to a double
                st.push(u);//u pushed on stack st
            }
            else if(k.contains("*")){//if k is * //Following else ifs are essentially the same as this one

                double nn=st.pop();//nn chosen for no particular reason //nn=st.pop()
                //System.out.println("nn"+nn);//FOR TESTING
                double v = st.pop();//v chosen for no particular reason //v= st.pop()
                //System.out.println("v"+v);//FOR TESTING

                v=v*nn;//v multiplied by nn
               // System.out.println("v2: "+v);//For TESTING
                st.push(v);//v pushed on the stack

            }
            else if(k.contains("+")){

                double nn=st.pop();
                //System.out.println("nn"+nn);
                double v = st.pop();
               /// System.out.println("v"+v);

                v=v+nn;//v= v plus nn
                //System.out.println("v2: "+v);
                st.push(v);

            }
            else if(k.contains("-")){

                double nn=st.pop();
                //System.out.println("nn"+nn);
                double v = st.pop();
                //System.out.println("v"+v);

                v=v-nn;//v= v minus nn
               //System.out.println("v2: "+v);
                st.push(v);

            }
            else if(k.contains("/")){

                double nn=st.pop();
               // System.out.println("nn"+nn);
                double v = st.pop();
                //System.out.println("v"+v);

                v=v/nn;// v= v divided by nn
              //  System.out.println("v2: "+v);
                st.push(v);

                //System.out.println("{v2"+st.pop());
            }
            else if(k.contains("%")){

                double nn=st.pop();
                nn=nn/100;//nn is convert to a percent of 100// technically a decimal
               // System.out.println("nn"+nn);
                
                st.push(nn);

                //System.out.println("{v2"+st.pop());
            }
        }
        double w=st.pop();//double w equals the last element popped of the stack aka the final result

        return w;//w returned
    }
}
