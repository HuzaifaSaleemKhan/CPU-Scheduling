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

public class operation {
    int n;
 int Bu[] =new int[20];
 float Twt,Awt,w;
 float A[]=new float[20];
 float Wt[]=new float[20];
 
void getData()
 {
 int i;
 n=Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Processes:"));
 for(i=1;i<=n;i++)
 {
 Bu[i]=Integer.parseInt(JOptionPane.showInputDialog("Enter The BurstTime for Process p"+i+""));
 }
 }
 
void SjfNp()
 {
 int i,Tt=0,temp,j;
 int B[]=new int[10];
 char S[]=new char[10];
 float temp1,t;
 Twt=0;
 w=0;
 for(i=1;i<=n;i++)
 {
 B[i]=Bu[i];
 S[i]='T';
 Tt=Tt+B[i];
 A[i]=Integer.parseInt(JOptionPane.showInputDialog("Enter The Arrival Time for Process p"+i+""));
 }
 
for(i=n;i>=1;i--)
 {
 for(j=3;j<=n;j++)
 {
 if(B[j-1]>B[j])
 {
 temp=B[j-1];
 temp1=A[j-1];
 B[j-1]=B[j];
 A[j-1]=A[j];
 B[j]=temp;
 A[j]=temp1;
 }
 }
 }
//For the 1st process
 Wt[1]=0;
 w=w+B[1];
 t=w;
 S[1]='F';
 
while(w<Tt)
 {
 i=2;
 while(i<=n)
 {
 if(S[i]=='T'&&A[i]<=t)
 {
 Wt[i]=w;
 S[i]='F';
 w=w+B[i];
 t=w;
 i=2;
 }
 else
 i++;
 }
 }
 
for(i=1;i<=n;i++)
 for(i=1;i<=n;i++)
 Twt=Twt+(Wt[i]-A[i]);
 Awt=Twt/n;
 System.out.println("Total Waiting Time:"+Twt);
 System.out.println("Average Waiting Time:"+Awt);
 }
 void RoundRobin()
 {
 
int i,j,tq,k;
 int B[]=new int[10];
 int Rrobin[][]=new int[10][10];
 int count[]=new int[10];
 int max=0;
 int m;
 Twt=0;
 n=Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Processes:"));
 for(i=1;i<=n;i++)
 {
 B[i]=Integer.parseInt(JOptionPane.showInputDialog("Enter The BurstTime for Process p"+i+""));
 }
 tq=Integer.parseInt(JOptionPane.showInputDialog("Enter The Time Quantum:"));
 m=max/tq+1;
 
//initializing Rrobin array
 for(i=1;i<=n;i++)
 {
 for(j=1;j<=m;j++)
 {
 Rrobin[i][j]=0;
 }
 }
 //placing value in the Rrobin array
 i=1;
 while(i<=n)
 {
 j=1;
 while(B[i]>0)
 {
 if(B[i]>=tq)
 {
 B[i]=B[i]-tq;
 Rrobin[i][j]=tq;
 j++;
 }
 else
 {
 Rrobin[i][j]=B[i];
 B[i]=0;
 j++;
 }
 }
 count[i]=j-1;
 i++;
 }
 
//calculating weighting time
 int x=1;
 i=1;
 while(x<=n)
 {
 for(int a=1;a<x;a++)
 {
 Wt[x]=Wt[x]+Rrobin[a][i];
 }
 i=1;
 int z=x;
 j=count[z];
 k=1;
 while(k<=j-1)
 {
 if(i==n+1)
 {
 i=1;
 k++;
 }
 else
 {
 if(i!=z)
 {
 Wt[z]=Wt[z]+Rrobin[i][k];
 }
 i++;
 }
 }
 x++;
 }
 for(i=1;i<=n;i++)
 {
 System.out.println("Waiting Time for process p"+i+":"+Wt[i]);
 }
 //calculating Average Weighting Time
 for(i=1;i<=n;i++)
 {
 Twt=Twt+Wt[i];
 Awt=Twt/n;
 }
 System.out.print("Total Waiting Time :"+Twt);
 System.out.print("Average Waiting Time :"+Awt);
 
}
 
}
