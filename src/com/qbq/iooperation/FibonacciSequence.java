package com.qbq.iooperation;
/**
 * 
 * @author QianBingqiao
 *
 */
public class FibonacciSequence {
	//斐波那契数列 :这个数列从第3项开始，每一项都等于前两项之和。
		public int fibonacciSque(int n){
			if(n <= 0)
			{
				return 0;
			}else if(n == 1){
				return 1;
			}
			return fibonacciSque(n -1) + fibonacciSque(n +1);
		}
		public static void main(String[] args) {
			FibonacciSequence f = new FibonacciSequence();
			f.fibonacciSque(15);
		}
}
