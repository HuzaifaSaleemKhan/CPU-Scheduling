/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpuscheduling;
import javax.swing.JOptionPane;
/**
 *
 * @author HSKSwati
 */
public class Cpuscheduling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        operation op=new operation();
 int select;
 do
 {
 select=Integer.parseInt(JOptionPane.showInputDialog("Select An Option:\n1.SJF NonPreemptive\n2.Round Robin"));
 
switch(select)
 {
 case 1:
 
System.out.println("SJF NonPreemptive\n");
 System.out.println ("-------------------");
 
op.getData();
 op.SjfNp();
 break;
 
case 2:
 System.out.println("Round Robin\n");
 System.out.println ("-------------------");
 op.RoundRobin();
 break;
 case 3:
 break;
 }
 }
 while(select<=3);
 }
}
   

